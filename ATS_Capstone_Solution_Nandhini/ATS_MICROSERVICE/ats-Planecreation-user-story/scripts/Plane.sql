-- Active: 1719376346140@@127.0.0.1@3306@atsc
USE ATSC;
CREATE TABLE Plane (
    registration_number VARCHAR(6) PRIMARY KEY,
    maker VARCHAR(50),
    model VARCHAR(50) NOT NULL,
    image_path VARCHAR(255),
    seating_capacity INT NOT NULL
);
INSERT INTO plane (registration_number, maker, model, image_path, seating_capacity)
VALUES ('PL0001', 'Boeing', '747', '/images/boeing_747.png', 150);
SELECT * FROM Plane;
drop Table Plane;