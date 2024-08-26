-- Active: 1719376346140@@127.0.0.1@3306@atsc
CREATE DATABASE ATSC;
USE ATSC;
CREATE TABLE Users(
    id BIGINT  PRIMARY KEY,
    email_id VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    failed_attempts INT DEFAULT 0,
    is_locked BOOLEAN DEFAULT FALSE,
    lock_time DATETIME

);
SELECT * FROM Users;
INSERT INTO Users
VALUES (1,'nandhu@1', 'Password123!','9876543210', 0, 0, '2024-08-21 10:30:00');
DROP TABLE Users;