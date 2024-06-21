CREATE DATABASE test_db;
USE test_db;

CREATE TABLE person (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL
);

-- CREATE INDEX name_index ON user(name(100));
