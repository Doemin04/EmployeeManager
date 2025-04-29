CREATE DATABASE IF NOT EXISTS employeeDB;
USE employeeDB;

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

CREATE TABLE IF NOT EXISTS pay_statement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    empId INT,
    date DATE,
    amount DOUBLE,
    FOREIGN KEY (empId) REFERENCES employeeData(empId) ON DELETE CASCADE
);