﻿DROP TABLE EMPLOYEE_AUTH;
DROP TABLE EMPLOYEE;
DROP TABLE BK_FUNCTION;

CREATE TABLE EMPLOYEE (
EMP_NO VARCHAR2(10) NOT NULL,
ID VARCHAR2(40) NOT NULL,
PASSWORD VARCHAR2(40) NOT NULL,
NAME VARCHAR2(40) NOT NULL,
LASTLOGIN TIMESTAMP,
LASTBADLOGIN TIMESTAMP,
BADLOGINTRY NUMBER(10),
PHOTO BLOB,
STATE VARCHAR2(10) NOT NULL,
CREATEDATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
CONSTRAINT EMP_NO_PK PRIMARY KEY(EMP_NO));

CREATE SEQUENCE EMP_SEQ
INCREMENT BY 1 
START WITH 1 
NOCACHE;
-----------------------------------------------------------------------------
CREATE TABLE BK_FUNCTION(
FUNCTION_NO NUMBER(10),
NAME VARCHAR2(40) NOT NULL, 
DESCRIBE VARCHAR2(100) NOT NULL, 
STATE VARCHAR2(10) NOT NULL,
UPDATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT FUNCTION_NO_PK PRIMARY KEY(FUNCTION_NO));
--xxxxxxxxxx---------------------------------------------------------------------------
CREATE TABLE EMPLOYEE_AUTH(
EMP_NO VARCHAR2(10) NOT NULL,
FUNCTION_NO NUMBER(10) NOT NULL,
TIMESTAMP  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
EDITOR VARCHAR2(10),
CONSTRAINT EMP_NO_FK FOREIGN KEY (EMP_NO) REFERENCES EMPLOYEE(EMP_NO),
CONSTRAINT FUNCTION_NO_FK FOREIGN KEY (FUNCTION_NO) REFERENCES BK_FUNCTION(FUNCTION_NO),
CONSTRAINT EMPLOYEE_AUTH_PK PRIMARY KEY(EMP_NO,FUNCTION_NO));

--xxxxxxxxxx---------------------------------------------------------------------------



DROP TABLE Product_Orde;
CREATE TABLE Product_Order(
Order_No NUMBER(10) NOT NULL, 
Member_No NUMBER(10) NOT NULL,
Seller_No NUMBER(10) NOT NULL,
Order_Status VARCHAR2(20),
ResR_Date TIMESTAMP, 
Seller_Rate NUMBER(2),
Member_Rate NUMBER(2),
Member_Review VARCHAR2(30),
params CLOB,
CP_No NUMBER(10)
);


-----------------------------------------------------------------------------

DROP TABLE Product_Orde;
CREATE TABLE Product_Order(
Order_No NUMBER(10) NOT NULL,
Product_No NUMBER(10) NOT NULL,
Unit_price NUMBER(10),
quantity NUMBER(10)
);