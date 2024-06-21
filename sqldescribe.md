## 核心语句查询
### 基础操作
* **基础操作都较为简单，为基本的增删改查**
* **使用mybatis框架中的工具可以轻松解决，这里不赘述sql语句的书写**

### 进阶查询
* 本次实验，我们更注重在sql语句使用的灵活性，所以选择了mybatis框架
* 对于进阶查询，如果使用框架工具需要引用多个service、多个mapper，造成耦合度较高，所以我们采取了在mapper中嵌入sql来查询
* 同时使用sql查询，可以更加简单的优化查询速度，特别是在大型连表过程中

**在sql设计过程中，我们体会到了sql语句对查询效率的重要性并且做出了分析与优化**
**为了简化文档，只展示三个较难的sql，下面的sql都接近**
**所有sql语句都可以在“src/main/resources/mapper/AdvancedMapper.xml” 中查看**
#### a
`菜品数据分析：某个商户所有菜品的评分、销量以及购买该菜品次数最多的人。`
本次项目最难的查询
* 首先为了避免大量的联表操作，我们先做三个较为简单的子查询，分别取出商家的菜品评分、销量、购买该菜品次数最多的人
* 将上述三个表联合，即可得到最后结果，同时避免了大规模的联表，优化了查询速度
```sql
        WITH food_sales AS (
            SELECT
            f.id AS id,
            f.name AS foodName,
            COUNT(ofd.food_id) AS saleCount,
            u.name AS personBuyMost,
            ROW_NUMBER() OVER (PARTITION BY f.id ORDER BY COUNT(ofd.food_id) DESC) AS rn
            FROM food f
            LEFT JOIN order_food ofd ON f.id = ofd.food_id
            LEFT JOIN orders o ON ofd.order_id = o.id
            LEFT JOIN user u ON o.user_id = u.id
            WHERE f.caterer_id = #{id}
            GROUP BY f.id, foodName, personBuyMost  
            ),
        foodSaleCount AS (
            SELECT
            f.id AS id,
            f.name AS foodName,
            COUNT(ofd.food_id) AS saleCount
            FROM food f
            LEFT JOIN order_food ofd ON f.id = ofd.food_id
            WHERE f.caterer_id = #{id}
            GROUP BY f.id, f.name  
            ),
        FoodGrade AS (
            SELECT
            f.id AS id,
            f.name AS foodName,
            AVG(fc.grade) AS avgGrade
            FROM food f
            LEFT JOIN food_comment fc ON f.id = fc.food_id
            WHERE f.caterer_id = #{id}
            GROUP BY f.id, f.name  
            )
        SELECT
            food_sales.id AS id,
            food_sales.foodName AS foodName,
            FoodGrade.avgGrade AS avgGrade,
            foodSaleCount.saleCount AS saleCount,
            food_sales.personBuyMost AS personBuyMost
        FROM food_sales
            JOIN foodSaleCount ON food_sales.id = foodSaleCount.id
            JOIN FoodGrade ON food_sales.id = FoodGrade.id
        WHERE food_sales.rn = 1
        ORDER BY foodSaleCount.saleCount DESC;
 ```
#### b
`某用户收藏的各个菜品在一段时间（近一周，近一月，近一年）内的销量`
* 此处查询直接使用为了方便书写直接使用四次联表来进行，后三次联表都是同一张表，只为了便捷书写
* 这种写法极大降低了速度，有极大的修改空间
* 下方其余查询将给出修改方法
```sql
        SELECT f.id AS foodId,
            f.name AS foodName,
            o1.is_queue_order  AS is_queue_order,
            COALESCE(SUM(CASE WHEN o1.time >= DATE_SUB(NOW(), INTERVAL 1 WEEK) THEN 1 ELSE 0 END), 0) AS salesLastWeek,
            COALESCE(SUM(CASE WHEN o2.time >= DATE_SUB(NOW(), INTERVAL 1 MONTH) THEN 1 ELSE 0 END), 0) AS salesLastMonth,
            COALESCE(SUM(CASE WHEN o3.time >= DATE_SUB(NOW(), INTERVAL 1 YEAR) THEN 1 ELSE 0 END), 0) AS salesLastYear
        FROM food f
            JOIN food_collect fc ON f.id = fc.food_id
            LEFT JOIN order_food ofd ON f.id = ofd.food_id
            LEFT JOIN orders o1 ON ofd.order_id = o1.id
            LEFT JOIN orders o2 ON ofd.order_id = o2.id
            LEFT JOIN orders o3 ON ofd.order_id = o3.id
        WHERE fc.user_id = #{id}
        GROUP BY f.id, f.name,o1.is_queue_order;
```
#### c
` 一段时间内某个商户的忠实粉丝在该商户的消费分布。（忠实粉丝：在该商户
消费次数超过某个阈值的用户；消费分布：各个菜品购买次数）`
* 以下查询仍然通过多次联表，加上条件判断来进行分析
* 同时嵌套一个exit子查询 来判断是否为忠实用户
```
    SELECT u.id AS userId,
        f.id AS foodId,
        f.name AS foodName,
        COUNT(ofd.food_id) AS purchaseCount
        FROM orders o
        JOIN user u ON o.user_id = u.id
        JOIN order_food ofd ON o.id = ofd.order_id
        JOIN food f ON ofd.food_id = f.id
   WHERE o.caterer_id =  #{id}-- 替换为商户的 ID
        AND u.id IN (
            SELECT user_id
            FROM (
            SELECT user_id, COUNT(*) AS orderCount
            FROM orders
            WHERE caterer_id =  #{id}
            AND time >= DATE_SUB(NOW(), INTERVAL 1 YEAR)  -- 按照一年的时间段进行选择
            GROUP BY user_id
            HAVING orderCount > 5 -- 定义忠实粉丝的阈值，例如超过多少次订单
            )   AS loyalFans
            )
        GROUP BY u.id, u.name, f.id, f.name
        ORDER BY u.id, f.id;
```
#### d
`用户活跃度分析：分析用户的活跃度模式，包括每周、每月点餐频率的变化 趋势，以及用户在不同时间段的活跃程度`
* 本次为了优化B查询中的多级联表，我们将每种频率都分开查询，降低了联表次数
* 分为week ，monthly ，hourly 

#### e
`用户群体特征分析：根据用户的角色、年龄和性别等信息，对用户群体进行 特征分析。比如根据年龄段/角色/性别对用户进行区分得出点餐习惯（在各个商户
的用餐次数/某一菜品的购买数量/...）和评价习惯（评价的数量/评分给出的分数）。`
* 同样为了简化查询，我们以特性将查询切分，得到三个子查询
* 在子查询中使用联表，聚合，group等常用手段 即可得到结果
* 分为Type,Role，Gendre
