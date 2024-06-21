### 数据库表结构说明

这份文档详细描述了一个餐饮订餐系统的数据库结构，包括每个表的字段、数据类型、约束条件以及它们之间的关系。

---

#### 表：`user`

- **字段：**
    - `id` INT（主键）
    - `name` VARCHAR(32) NOT NULL（姓名）
    - `type` VARCHAR(16) NOT NULL（用户类型）
    - `password` VARCHAR(32) NOT NULL（密码）
    - `s_id` VARCHAR(32) NOT NULL（学号/工号）
    - `age` INT（年龄）
    - `gender` CHAR(1)（性别）

- **约束条件：**
    - `id` 是主键。
    - `name`、`type`、`password`、`s_id` 不可为空 (`NOT NULL`)。

---

#### 表：`caterer`

- **字段：**
    - `id` INT（主键）
    - `name` VARCHAR(32) NOT NULL（名称）
    - `password` VARCHAR(32) NOT NULL（密码）
    - `address` VARCHAR(255)（地址）
    - `main_food_name` VARCHAR(255)（主打菜名）

- **约束条件：**
    - `id` 是主键。
    - `name`、`password` 不可为空 (`NOT NULL`)。

---

#### 表：`food`

- **字段：**
    - `id` INT（主键）
    - `caterer_id` INT（外键，引用 `caterer(id)`）
    - `name` VARCHAR(255) NOT NULL（菜品名称）
    - `price` DECIMAL(10, 2) NOT NULL（价格）
    - `description` TEXT（描述）
    - `image_path` VARCHAR(255) NOT NULL（图片路径）
    - `ingredient` VARCHAR(255) NOT NULL（成分）
    - `nutrition` VARCHAR(255) NOT NULL（营养成分）
    - `allergen` VARCHAR(255)（过敏原）
    - `type` VARCHAR(32)（菜品类型）

- **约束条件：**
    - `id` 是主键。
    - `caterer_id` 是外键，引用 `caterer(id)`，并且设定了 `ON DELETE CASCADE`。
    - `name`、`price`、`image_path`、`ingredient`、`nutrition` 不可为空 (`NOT NULL`)。

---

#### 表：`book`

- **字段：**
    - `id` INT（主键）
    - `user_id` INT（外键，引用 `user(id)`）
    - `caterer_id` INT（外键，引用 `caterer(id)`）
    - `time` DATETIME NOT NULL（预订时间）

- **约束条件：**
    - `id` 是主键。
    - `user_id` 是外键，引用 `user(id)`，并且设定了 `ON DELETE CASCADE`。
    - `caterer_id` 是外键，引用 `caterer(id)`，并且设定了 `ON DELETE CASCADE`。
    - `time` 不可为空 (`NOT NULL`)。

---

#### 表：`food_collect`

- **字段：**
    - `user_id` INT（外键，引用 `user(id)`）
    - `food_id` INT（外键，引用 `food(id)`）

- **约束条件：**
    - `(user_id, food_id)` 是主键。
    - `user_id` 是外键，引用 `user(id)`，并且设定了 `ON DELETE CASCADE`。
    - `food_id` 是外键，引用 `food(id)`，并且设定了 `ON DELETE CASCADE`。

---

#### 表：`caterer_collect`

- **字段：**
    - `user_id` INT（外键，引用 `user(id)`）
    - `caterer_id` INT（外键，引用 `caterer(id)`）

- **约束条件：**
    - `(user_id, caterer_id)` 是主键。
    - `user_id` 是外键，引用 `user(id)`，并且设定了 `ON DELETE CASCADE`。
    - `caterer_id` 是外键，引用 `caterer(id)`，并且设定了 `ON DELETE CASCADE`。

---

#### 表：`orders`

- **字段：**
    - `id` INT（主键）
    - `time` DATETIME NOT NULL（订单时间）
    - `user_id` INT（外键，引用 `user(id)`）
    - `caterer_id` INT（外键，引用 `caterer(id)`）
    - `is_queue_order` BOOLEAN NOT NULL（是否排队订单）
    - `is_finished` BOOLEAN NOT NULL DEFAULT FALSE（订单是否完成，默认为未完成）

- **约束条件：**
    - `id` 是主键。
    - `user_id` 是外键，引用 `user(id)`，并且设定了 `ON DELETE CASCADE`。
    - `caterer_id` 是外键，引用 `caterer(id)`，并且设定了 `ON DELETE CASCADE`。
    - `time`、`is_queue_order` 不可为空 (`NOT NULL`)。

---

#### 表：`order_food`

- **字段：**
    - `order_id` INT（外键，引用 `orders(id)`）
    - `food_id` INT（外键，引用 `food(id)`）
    - `quantity` INT NOT NULL（数量）

- **约束条件：**
    - `(order_id, food_id)` 是主键。
    - `order_id` 是外键，引用 `orders(id)`，并且设定了 `ON DELETE CASCADE`。
    - `food_id` 是外键，引用 `food(id)`，并且设定了 `ON DELETE CASCADE`。
    - `quantity` 不可为空 (`NOT NULL`)。

---

#### 表：`price`

- **字段：**
    - `food_id` INT（外键，引用 `food(id)`）
    - `time` DATETIME NOT NULL（价格时间）
    - `price` DECIMAL(10, 2) NOT NULL（价格）

- **约束条件：**
    - `(food_id, time)` 是主键。
    - `food_id` 是外键，引用 `food(id)`，并且设定了 `ON DELETE CASCADE`。
    - `price`、`time` 不可为空 (`NOT NULL`)。

---

#### 表：`caterer_comment`

- **字段：**
    - `caterer_id` INT（外键，引用 `caterer(id)`）
    - `user_id` INT（外键，引用 `user(id)`）
    - `comment` TEXT（评论内容）
    - `grade` INT（评分）

- **约束条件：**
    - `caterer_id` 是外键，引用 `caterer(id)`，并且设定了 `ON DELETE CASCADE`。
    - `user_id` 是外键，引用 `user(id)`，并且设定了 `ON DELETE CASCADE`。

---

#### 表：`food_comment`

- **字段：**
    - `food_id` INT（外键，引用 `food(id)`）
    - `user_id` INT（外键，引用 `user(id)`）
    - `comment` TEXT（评论内容）
    - `grade` INT（评分）

- **约束条件：**
    - `food_id` 是外键，引用 `food(id)`，并且设定了 `ON DELETE CASCADE`。
    - `user_id` 是外键，引用 `user(id)`，并且设定了 `ON DELETE CASCADE`。

---

这份数据库结构描述了一个餐饮订餐系统的设计，用于管理用户、餐饮服务提供商、菜品、订单及其评论等信息。