# Table - 数据库表结构说明
本文件详细描述了项目中各数据库表的结构，包括每个表的字段、数据类型、约束条件以及相互之间的关系。
参照ER图进行设计。本表为当前设计思路，随着进一步实现会作进一步的完善。


本说明分为以下几个部分
* 表结构设计
* 具体表创建语句（具体变量选择可在此得出）

# 表结构设计

## book
* id
* user_id
* caterer_id
* time

预定 表，id代表预定id，其中包含着发起这个预定的发起人（用户的id），预定的餐厅的id，和发起这个预定动作的时间。


## caterer
* id
* name
* password
* address

食堂供应商 表，包含供应商id，供应商的名字，供应商的账户密码，其地址。

## collect
* user_id
* food_id

（用户）收藏 表 包含用户id  食物id，由于食物可以唯一的标识供应商，因此仅需这两个对象

## food 
* id
* name
* caterer_id
* price
* description

食物id ，name对应的名字，caterer_id提供这个食物的供应商的id，price为当前的价格，description我这个食物的描述

## food_type
* food_id
* type

food_id食物的id，type对应的食物的种类




## order
* id
* time
* total_price

订单 表，id，time下订单的时间，total_price订单的总金额。订单由于包含多个食物，所以其中所定食物设置为order_food表。

## order_food
* order_id
* food_id

订单食物 表，order_id，food_id所定的食物。

## price
* food_id
* time
* price

食物的价格历史记录 表，food_id食物id，time设定价格的时间，price设定的价格

## root
* id
* password

管理员用户对应的id和密码

## user
* id
* name
* is_student
* password
* s_id
* age
* gender

用户 表，id用户id，name用户名称，is_student是否是学生（是学生or是教职工），password账号密码，s_id账号id，age用户年龄，gender用户性别


# 具体表创建语句
主键与外键引用关系可见下
## Create语句
CREATE TABLE user (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(32) NOT NULL,
type VARCHAR(16) NOT NULL,
password VARCHAR(32) NOT NULL,
s_id VARCHAR(32) NOT NULL,
age INT,
gender CHAR(1)
);
CREATE TABLE food (
id INT PRIMARY KEY NOT NULL,
caterer_id INT references caterer(id),
name VARCHAR(255) NOT NULL,
price DECIMAL(10, 2) NOT NULL,
description TEXT,
image_path VARCHAR(255) NOT NULL,
ingredient VARCHAR(255) NOT NULL,
nutrition VARCHAR(255) NOT NULL,
allergen VARCHAR(255),
type VARCHAR(32)
);
CREATE TABLE caterer (
id INT PRIMARY KEY NOT NULL,
name VARCHAR(32) NOT NULL,
password VARCHAR(32) NOT NULL,
address VARCHAR(255),
main_food_id INT NOT NULL,
FOREIGN KEY (main_food_id) REFERENCES food(id)
);



CREATE TABLE book (
id INT PRIMARY KEY NOT NULL,
user_id INT NOT NULL,
caterer_id INT NOT NULL,
time DATETIME NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (caterer_id) REFERENCES caterer(id)
);

CREATE TABLE food_collect (
user_id INT NOT NULL,
food_id INT NOT NULL,
PRIMARY KEY (user_id, food_id),
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (food_id) REFERENCES food(id)
);

CREATE TABLE caterer_collect (
user_id INT NOT NULL,
caterer_id INT NOT NULL,
PRIMARY KEY (user_id, caterer_id),
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (caterer_id) REFERENCES caterer(id)
);


CREATE TABLE orders(
id INT PRIMARY KEY NOT NULL,
time DATETIME NOT NULL,
user_id INT NOT NULL,
caterer_id INT NOT NULL,
is_queue_order BOOLEAN NOT NULL,
is_finished BOOLEAN NOT NULL DEFAULT FALSE,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (caterer_id) REFERENCES caterer(id)
);

CREATE TABLE order_food (
order_id INT NOT NULL,
food_id INT NOT NULL,
PRIMARY KEY (order_id, food_id),
FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (food_id) REFERENCES food(id)
);

CREATE TABLE price (
food_id INT NOT NULL,
time DATETIME NOT NULL,
price DECIMAL(10, 2) NOT NULL,
PRIMARY KEY (food_id, time),
FOREIGN KEY (food_id) REFERENCES food(id)
);


CREATE TABLE caterer_comment(
caterer_id INT NOT NULL,
user_id INT NOT NULL,
comment TEXT,
grade INT,
FOREIGN KEY (caterer_id) REFERENCES caterer(id),
FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE food_comment(
food_id INT NOT NULL,
user_id INT NOT NULL,
comment TEXT,
grade INT,
FOREIGN KEY (food_id) REFERENCES food(id),
FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE messages (
message_id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
caterer_id INT NOT NULL,
message_content TEXT NOT NULL,
sent_time DATETIME NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (caterer_id) REFERENCES caterer(id)
);


DELIMITER $$
CREATE TRIGGER insert_order_message AFTER INSERT ON orders
FOR EACH ROW
BEGIN
DECLARE user_name VARCHAR(255);
DECLARE caterer_name VARCHAR(255);

    -- 获取用户名称
    SELECT name INTO user_name FROM user WHERE id = NEW.user_id;

    -- 获取餐厅名称
    SELECT name INTO caterer_name FROM caterer WHERE id = NEW.caterer_id;

    -- 构造消息内容
    SET @message_content = CONCAT('User ', user_name, ' placed an order with caterer ', caterer_name);

    -- 插入消息记录
    INSERT INTO messages (user_id, caterer_id, message_content, sent_time)
    VALUES (NEW.user_id, NEW.caterer_id, @message_content, NOW());
END;
$$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER order_finished_message AFTER UPDATE ON orders
FOR EACH ROW
BEGIN
IF OLD.is_finished = 0 AND NEW.is_finished = 1 THEN
DECLARE user_name VARCHAR(255);
DECLARE caterer_name VARCHAR(255);

        -- 获取用户名称
        SELECT name INTO user_name FROM user WHERE id = NEW.user_id;

        -- 获取餐厅名称
        SELECT name INTO caterer_name FROM caterer WHERE id = NEW.caterer_id;

        -- 构造消息内容
        SET @message_content = CONCAT('Order for user ', user_name, ' with caterer ', caterer_name, ' is now finished.');

        -- 插入消息记录
        INSERT INTO messages (user_id, caterer_id, message_content, sent_time)
        VALUES (NEW.user_id, NEW.caterer_id, @message_content, NOW());
    END IF;
END;
$$
DELIMITER ;
