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
id VARCHAR(32) PRIMARY KEY NOT NULL,
name VARCHAR(255) NOT NULL,
is_student BOOLEAN NOT NULL,
password VARCHAR(32) NOT NULL,
s_id VARCHAR(32) NOT NULL,
age INT,
gender CHAR(1)
);

CREATE TABLE caterer (
id VARCHAR(32) PRIMARY KEY NOT NULL,
name VARCHAR(255) NOT NULL,
password VARCHAR(32) NOT NULL,
address VARCHAR(255)
);

CREATE TABLE food (
id VARCHAR(32) PRIMARY KEY NOT NULL,
caterer_id VARCHAR(32) references caterer(id),
name VARCHAR(255) NOT NULL,
price DECIMAL(10, 2) NOT NULL,
description TEXT
);

CREATE TABLE book (
id VARCHAR(32) PRIMARY KEY NOT NULL,
user_id VARCHAR(32) NOT NULL,
caterer_id VARCHAR(32) NOT NULL,
time DATETIME NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (caterer_id) REFERENCES caterer(id)
);

CREATE TABLE collect (
user_id VARCHAR(32) NOT NULL,
food_id VARCHAR(32) NOT NULL,
PRIMARY KEY (user_id, food_id),
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (food_id) REFERENCES food(id)
);

CREATE TABLE food_type (
food_id VARCHAR(32) NOT NULL,
type VARCHAR(255),
PRIMARY KEY ( food_id, type),
FOREIGN KEY (food_id) REFERENCES food(id)
);

CREATE TABLE order(
id VARCHAR(32) PRIMARY KEY NOT NULL,
time DATETIME NOT NULL,
user_id VARCHAR(32) NOT NULL,
caterer_id VARCHAR(32) NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (caterer_id) REFERENCES caterer(id)
);

CREATE TABLE order_food (
order_id VARCHAR(32) NOT NULL,
food_id VARCHAR(32) NOT NULL,
PRIMARY KEY (order_id, food_id),
FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (food_id) REFERENCES food(id)
);

CREATE TABLE price (
food_id VARCHAR(32) NOT NULL,
time DATETIME NOT NULL,
price DECIMAL(10, 2) NOT NULL,
PRIMARY KEY (food_id, time),
FOREIGN KEY (food_id) REFERENCES food(id)
);

CREATE TABLE root (
id VARCHAR(32) PRIMARY KEY NOT NULL,
password VARCHAR(255) NOT NULL
);
