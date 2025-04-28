-- Create Database
CREATE DATABASE IF NOT EXISTS employeeDB;

-- Use Database
USE employeeDB;

-- Create Table
CREATE TABLE IF NOT EXISTS employeeData (
    empId INT PRIMARY KEY,
    name VARCHAR(100),
    phoneNumber VARCHAR(20),
    emailAddress VARCHAR(100),
    ssn VARCHAR(20),
    salary DOUBLE,
    jobTitle VARCHAR(100),
    division VARCHAR(100)
);