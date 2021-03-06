﻿DROP TABLE EMPLOYEE_AUTH;
DROP TABLE EMPLOYEE;
DROP TABLE BK_FUNCTION;

CREATE TABLE EMPLOYEE (
EMP_NO VARCHAR2(10) NOT NULL,
EMP_ID VARCHAR2(40) NOT NULL,
EMP_PSW VARCHAR2(40) NOT NULL,
EMP_NAME VARCHAR2(40) NOT NULL,
EMP_LSTLOG TIMESTAMP,
EMP_BADLOG TIMESTAMP,
EMP_BADLOGTRY NUMBER(10) DEFAULT 0,
EMP_PHOTO BLOB,
EMP_STATE VARCHAR2(10) DEFAULT 'Active' NOT NULL,
EMP_NEWDATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
CONSTRAINT EMP_NO_PK PRIMARY KEY(EMP_NO));

DROP SEQUENCE EMP_SEQ;

CREATE SEQUENCE EMP_SEQ
INCREMENT BY 1 
START WITH 1 
NOCACHE;

------insert先寫在這裡--------
INSERT INTO EMPLOYEE(EMP_NO, EMP_ID, EMP_PSW, EMP_NAME, EMP_STATE) VALUES('EM'||(LPAD(to_char
(EMP_SEQ.NEXTVAL),8,'0')), 'peter@forhouse.com', '123456' ,'吳神', 'Active');
INSERT INTO EMPLOYEE(EMP_NO, EMP_ID, EMP_PSW, EMP_NAME, EMP_STATE) VALUES('EM'||(LPAD(to_char
(EMP_SEQ.NEXTVAL),8,'0')), 'yyy@forhouse.com', '123456' ,'楊宇茵', 'Active');
INSERT INTO EMPLOYEE(EMP_NO, EMP_ID, EMP_PSW, EMP_NAME, EMP_STATE) VALUES('EM'||(LPAD(to_char
(EMP_SEQ.NEXTVAL),8,'0')), 'dragon@forhouse.com', '123456' ,'趙子龍', 'Active');
------------------------------
CREATE TABLE BK_FUNCTION(
BKF_NO NUMBER(10),
BKF_NAME VARCHAR2(40) NOT NULL, 
BKF_DSB VARCHAR2(100) NOT NULL, 
BKF_STATE VARCHAR2(10) NOT NULL,
BKF_UPDATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
CONSTRAINT BKF_NO_PK PRIMARY KEY(BKF_NO));

DROP SEQUENCE BKF_NO_SEQ;

CREATE SEQUENCE BKF_NO_SEQ
INCREMENT BY 1 
START WITH 100 
NOMAXVALUE
NOCYCLE
NOCACHE;

------insert先寫在這裡--------
INSERT INTO BK_FUNCTION(BKF_NO, BKF_NAME, BKF_DSB, BKF_STATE) 
VALUES(BKF_NO_SEQ.NEXTVAL, '管理員工', '管理後台帳號、管理後台帳號權限' ,'On');
INSERT INTO BK_FUNCTION(BKF_NO, BKF_NAME, BKF_DSB, BKF_STATE) 
VALUES(BKF_NO_SEQ.NEXTVAL, '審核權限', '審核房仲註冊、審核廠商註冊' ,'On');
INSERT INTO BK_FUNCTION(BKF_NO, BKF_NAME, BKF_DSB, BKF_STATE) 
VALUES(BKF_NO_SEQ.NEXTVAL, '維護房屋資料', '房屋資料更新檢視、房屋資料爬蟲開關' ,'Test');
INSERT INTO BK_FUNCTION(BKF_NO, BKF_NAME, BKF_DSB, BKF_STATE) 
VALUES(BKF_NO_SEQ.NEXTVAL, '管理檢舉', '審核檢舉房仲、審核檢舉廠商' ,'On');
INSERT INTO BK_FUNCTION(BKF_NO, BKF_NAME, BKF_DSB, BKF_STATE) 
VALUES(BKF_NO_SEQ.NEXTVAL, '管理News', '管理房市最新消息、管理系統公告、管理促銷資訊' ,'On');
INSERT INTO BK_FUNCTION(BKF_NO, BKF_NAME, BKF_DSB, BKF_STATE)
VALUES(BKF_NO_SEQ.NEXTVAL, '管理廣告', '審核廠商廣告申請刊登廣告撤銷廣告' ,'On');
INSERT INTO BK_FUNCTION(BKF_NO, BKF_NAME, BKF_DSB, BKF_STATE)
VALUES(BKF_NO_SEQ.NEXTVAL, '管理常見問題', '更新問題' ,'On');

------------------------------
CREATE TABLE EMPLOYEE_AUTH(
EMP_NO VARCHAR2(10) NOT NULL,
BKF_NO NUMBER(10) NOT NULL,
EMAU_DATE  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
EMAU_EDITOR VARCHAR2(10),
CONSTRAINT EMP_NO_FK FOREIGN KEY (EMP_NO) REFERENCES EMPLOYEE(EMP_NO),
CONSTRAINT BKF_NO_FK FOREIGN KEY (BKF_NO) REFERENCES BK_FUNCTION
(BKF_NO),
CONSTRAINT EMPLOYEE_AUTH_PK PRIMARY KEY(EMP_NO,BKF_NO));
------insert先寫在這裡--------
INSERT INTO EMPLOYEE_AUTH(EMP_NO, BKF_NO,EMAU_EDITOR) 
VALUES('EM00000003', 100, 'EM00000001');
INSERT INTO EMPLOYEE_AUTH(EMP_NO, BKF_NO,EMAU_EDITOR) 
VALUES('EM00000003', 101, 'EM00000001');
INSERT INTO EMPLOYEE_AUTH(EMP_NO, BKF_NO,EMAU_EDITOR) 
VALUES('EM00000003', 102, 'EM00000001');

-----員工的世界-複製到這邊-請按下commit-------
commit;
-----員工的世界-複製到這邊-請按下commit-------
-----員工的世界-複製到這邊-請按下commit-------

-----商品的世界-要先拿大哥的表格--
DROP TABLE ORDER_DETAIL;
DROP TABLE PRODUCT_ORDER;

CREATE TABLE PRODUCT_ORDER(
PDO_NO VARCHAR2(15) NOT NULL,
MEM_NO VARCHAR2(10) NOT NULL,
SLR_NO VARCHAR2(10) NOT NULL,
PDO_STAT VARCHAR2(20) DEFAULT 'order' NOT NULL,
PDO_RESR_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
SLR_RATE NUMBER(2),
MEM_RATE NUMBER(2),
MEM_REVIEW VARCHAR2(100),
PDO_PARAMS CLOB,
CP_NO VARCHAR2(10),
CONSTRAINT PDO_NO_PK PRIMARY KEY(PDO_NO),
CONSTRAINT MEM_NO_FK FOREIGN KEY (MEM_NO) REFERENCES MEMBER(MEM_NO),
CONSTRAINT SLR_NO_FK FOREIGN KEY (SLR_NO) REFERENCES SELLER(SLR_NO));

DROP SEQUENCE PDO_NO_SEQ;

CREATE SEQUENCE PDO_NO_SEQ
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

------insert先寫在這裡--------
INSERT INTO PRODUCT_ORDER(PDO_NO, MEM_NO, SLR_NO, PDO_STAT)
VALUES('OD'||TO_CHAR(SYSDATE,'RRMMDD')||'-'||(LPAD(to_char(PDO_NO_SEQ.NEXTVAL),6,'0')), 'MB00000001', 'SL00000001' ,'order');
INSERT INTO PRODUCT_ORDER(PDO_NO, MEM_NO, SLR_NO, PDO_STAT)
VALUES('OD'||TO_CHAR(SYSDATE,'RRMMDD')||'-'||(LPAD(to_char(PDO_NO_SEQ.NEXTVAL),6,'0')), 'MB00000001', 'SL00000001' ,'order');
INSERT INTO PRODUCT_ORDER(PDO_NO, MEM_NO, SLR_NO, PDO_STAT)
VALUES('OD'||TO_CHAR(SYSDATE,'RRMMDD')||'-'||(LPAD(to_char(PDO_NO_SEQ.NEXTVAL),6,'0')), 'MB00000002', 'SL00000001' ,'order');
INSERT INTO PRODUCT_ORDER(PDO_NO, MEM_NO, SLR_NO, PDO_STAT)
VALUES('OD'||TO_CHAR(SYSDATE,'RRMMDD')||'-'||(LPAD(to_char(PDO_NO_SEQ.NEXTVAL),6,'0')), 'MB00000002', 'SL00000002' ,'order');
INSERT INTO PRODUCT_ORDER(PDO_NO, MEM_NO, SLR_NO, PDO_STAT)
VALUES('OD'||TO_CHAR(SYSDATE,'RRMMDD')||'-'||(LPAD(to_char(PDO_NO_SEQ.NEXTVAL),6,'0')), 'MB00000003', 'SL00000003' ,'order');
INSERT INTO PRODUCT_ORDER(PDO_NO, MEM_NO, SLR_NO, PDO_STAT)
VALUES('OD'||TO_CHAR(SYSDATE,'RRMMDD')||'-'||(LPAD(to_char(PDO_NO_SEQ.NEXTVAL),6,'0')), 'MB00000002', 'SL00000003' ,'deliver');
INSERT INTO PRODUCT_ORDER(PDO_NO, MEM_NO, SLR_NO, PDO_STAT)
VALUES('OD'||TO_CHAR(SYSDATE,'RRMMDD')||'-'||(LPAD(to_char(PDO_NO_SEQ.NEXTVAL),6,'0')), 'MB00000002', 'SL00000004' ,'cancel');
-------------------------------------------------------------


CREATE TABLE ORDER_DETAIL(
PDO_NO VARCHAR2(15) NOT NULL,
PRD_NO VARCHAR2(10) NOT NULL,
ODER_UNI_PRICE NUMBER(10),
ODER_QUANTITY NUMBER(10),
CONSTRAINT PDO_NO_FK FOREIGN KEY (PDO_NO) REFERENCES PRODUCT_ORDER(PDO_NO),
CONSTRAINT PRD_NO_FK FOREIGN KEY (PRD_NO) REFERENCES PRODUCT(PRD_NO),
CONSTRAINT ORDER_DETAIL_PK PRIMARY KEY(PDO_NO,PRD_NO)
);
------insert先寫在這裡--------
INSERT INTO ORDER_DETAIL(PDO_NO, PRD_NO, ODER_UNI_PRICE, ODER_QUANTITY) 
VALUES('OD171109-000001', 'PD00000020', 500000000 ,10);
INSERT INTO ORDER_DETAIL(PDO_NO, PRD_NO, ODER_UNI_PRICE, ODER_QUANTITY) 
VALUES('OD171109-000001', 'PD00000011', 500000000 ,10);


----------?--------
INSERT INTO ORDER_DETAIL(PDO_NO, PRD_NO, ODER_UNI_PRICE, ODER_QUANTITY) 
VALUES('OD'||TO_CHAR(SYSDATE,'RRMMDD')||'-000002', 'PD00000011', 500000000 ,10);


----------------------------------

