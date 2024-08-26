-- Active: 1719376346140@@127.0.0.1@3306@atsc
USE ATSC;
CREATE TABLE Airport (
    airport_id VARCHAR(5) PRIMARY KEY,
    airport_name VARCHAR(255) NOT NULL,
    country_code VARCHAR(5) NOT NULL
);
INSERT INTO Airport VALUES ('A0001', 'TN International Airport', 'TN');

INSERT INTO Airport VALUES ('A0002', 'US International Airport', 'WHITEHOUSE', 'US');
SELECT * FROM Airport;
drop table Airport;