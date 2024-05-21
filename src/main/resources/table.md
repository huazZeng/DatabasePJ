# Tabel
## book
* id
* user_id
* caterer_id
* time

## caterer
* id
* name
* password
* address

## collect
* user_id
* caterer_id 
* food_id

## food 
* id
* name
* price
* description

## food_type
* caterer_id
* food_id
* type

## order
* id
* time
* status
* order_food_id
* total_price

## order_food
* order_id
* caterer_id
* food_id
* real_price

## price
* caterer_id
* food_id
* time
* price

## root
* id
* password

## user
* id
* name
* is_student
* password
* s_id
* age
* gender


# Create语句
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
