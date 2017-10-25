﻿DROP TABLE EMPLOYEE_AUTH;
DROP TABLE EMPLOYEE;
DROP TABLE BK_FUNCTION;

CREATE TABLE EMPLOYEE (
EMP_NO VARCHAR2(10),
ID VARCHAR2(40) NOT NULL,
PASSWORD VARCHAR2(40) NOT NULL,
NAME VARCHAR2(40) NOT NULL,
LASTLOGIN TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
LASTBADLOGIN TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
BADLOGINTRY NUMBER(10),
PHOTO BLOB,
STATE VARCHAR2(10) NOT NULL,
CREATEDATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
CONSTRAINT EMP_NO_PK PRIMARY KEY(EMP_NO));

-----------------------------------------------------------------------------
CREATE TABLE BK_FUNCTION(
FUNCTION_NO NUMBER(10),
NAME VARCHAR2(40) NOT NULL, 
DESCRIBE VARCHAR2(100) NOT NULL, 
STATE VARCHAR2(10) NOT NULL,
UPDATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT FUNCTION_NO_PK PRIMARY KEY(FUNCTION_NO));
-----------------------------------------------------------------------------
CREATE TABLE EMPLOYEE_AUTH(
EMP_NO VARCHAR2(10) NOT NULL,
FUNCTION_NO NUMBER(10) NOT NULL,
TIMESTAMP  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
EDITOR VARCHAR2(10),
CONSTRAINT EMP_NO_FK FOREIGN KEY (EMP_NO) REFERENCES EMPLOYEE(EMP_NO),
CONSTRAINT FUNCTION_NO_FK FOREIGN KEY (FUNCTION_NO) REFERENCES BK_FUNCTION(FUNCTION_NO),
CONSTRAINT EMPLOYEE_AUTH_PK PRIMARY KEY(EMP_NO,FUNCTION_NO));