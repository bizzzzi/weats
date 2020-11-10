-- member Table
 CREATE TABLE MEMBER (
 USER_ID VARCHAR2(255) PRIMARY KEY,
 USER_NAME VARCHAR2(255) NOT NULL,
 USER_EMAIL VARCHAR2(255) NOT NULL,
 USER_PW VARCHAR2(255) NOT NULL,
 SALT VARCHAR2(255) NOT NULL,
 USER_VERIFY NUMBER(1,0) DEFAULT 0 NOT NULL,
 PARTNER_VERIFY NUMBER(1,0) DEFAULT 0 NOT NULL 
 );
 
CREATE TABLE PARTNER (
PARTNER_ID VARCHAR2(255) PRIMARY KEY,
USER_ID VARCHAR2(255) NOT NULL,
C_NAME VARCHAR2(255) NOT NULL,
C_POSTNUM VARCHAR2(255) NOT NULL,
C_ADDRESS VARCHAR2(255) NOT NULL,
C_DETAIL_ADDRESS VARCHAR2(255) NOT NULL,
C_PHONE VARCHAR2(255) NOT NULL,
PARTNER_LICENSE_NUM VARCHAR2(255) NOT NULL,
PARTNER_LICENSE_DOCS VARCHAR2(255) NOT NULL,
constraint FK_PARTNER_USER_ID FOREIGN KEY(USER_ID)
REFERENCES MEMBER(USER_ID)
);

CREATE TABLE LEPORTS (
LEPORTS_ID VARCHAR2(255) PRIMARY KEY,
PARTNER_ID VARCHAR2(255) NOT NULL,
LEPORTS_TITLE VARCHAR2(255) NOT NULL,
LEPORTS_TYPE VARCHAR2(255) NOT NULL,
LEPORTS_LOC VARCHAR2(255) NOT NULL,
LEPORTS_REGIDATE DATE DEFAULT sysdate NOT NULL,
LEPORTS_MAIN_IMG VARCHAR2(255) NOT NULL,
LEPORTS_SUB_IMG1 VARCHAR2(255) ,
LEPORTS_SUB_IMG2 VARCHAR2(255),
LEPORTS_SUB_IMG3 VARCHAR2(255),
LEPORTS_SUB_IMG4 VARCHAR2(255),
LEPORTS_CONTENT VARCHAR2(255) NOT NULL,
CONSTRAINT FK_LEPORTS_PARTNER_ID FOREIGN KEY(PARTNER_ID)
REFERENCES PARTNER(PARTNER_ID)
);

CREATE TABLE LEPORTS_ITEM (
LEPORTS_ID VARCHAR2(255) NOT NULL,
LEPORTS_ITEM_TITLE VARCHAR2(255) NOT NULL,
LEPORTS_SUMMARY VARCHAR2(255) NOT NULL,
LEPORTS_PRICE NUMBER(8,0) NOT NULL,
LEPORTS_MAX_CAPACITY NUMBER(3,0) NOT NULL,
CONSTRAINT FK_LEPORTS_ITEM_LEPORTS_ID FOREIGN KEY(LEPORTS_ID)
REFERENCES LEPORTS(LEPORTS_ID)
);

CREATE TABLE RESERVATION (
RESERVATION_ID VARCHAR2(255) PRIMARY KEY,
USER_ID VARCHAR2(255) NOT NULL,
LEPORTS_ID VARCHAR2(255) NOT NULL,
RS_NAME VARCHAR2(255) NOT NULL,
RS_PHONE VARCHAR2(255) NOT NULL,
RS_PERSONS VARCHAR2(255) NOT NULL,
RS_PAYMETHOD VARCHAR2(255) NOT NULL,
RS_DATE VARCHAR2(255) NOT NULL,
RS_PAYMENT_DATE DATE DEFAULT sysdate NOT NULL,
RS_PRICE NUMBER(8,0) NOT NULL,
CONSTRAINT FK_RS_LEPORTS_ID FOREIGN KEY(LEPORTS_ID)
REFERENCES LEPORTS(LEPORTS_ID)
);

CREATE TABLE RESERVATION_REVIEW (
REVIEW_ID VARCHAR2(255) PRIMARY KEY,
LEPORTS_ID VARCHAR2(255) NOT NULL,
RESERVATION_ID VARCHAR2(255) NOT NULL,
USER_ID VARCHAR2(255) NOT NULL,
REVIEW_COMMENTS VARCHAR2(255) NOT NULL,
REVIEW_REGIDATE DATE DEFAULT sysdate NOT NULL,
CONSTRAINT FK_REVIEW_LEPORTS_ID FOREIGN KEY(LEPORTS_ID)
REFERENCES LEPORTS(LEPORTS_ID),
CONSTRAINT FK_REVIEW_RESERVATION_ID FOREIGN KEY(RESERVATION_ID)
REFERENCES RESERVATION(RESERVATION_ID)
);

CREATE TABLE TRADE (
TRADE_ID VARCHAR2(255) PRIMARY KEY,
USER_ID VARCHAR2(255) NOT NULL,
TRADE_MAIN_IMG VARCHAR2(255) NOT NULL,
TRADE_SUB_IMG1 VARCHAR2(255),
TRADE_SUB_IMG2 VARCHAR2(255),
TRADE_SUB_IMG3 VARCHAR2(255),
TRADE_SUB_IMG4 VARCHAR2(255),
TRADE_TITLE VARCHAR2(255) NOT NULL,
TRADE_CONTENTS VARCHAR2(255) NOT NULL,
TRADE_TYPE VARCHAR2(255) NOT NULL,
TRADE_LOC VARCHAR2(255) NOT NULL,
TRADE_PHONE VARCHAR2(255) NOT NULL,
TRADE_USER_NAME VARCHAR2(255) NOT NULL,
TRADE_PRICE NUMBER(8,0) NOT NULL,
TRADE_REGIDATE DATE DEFAULT sysdate NOT NULL,
TRADE_HIT NUMBER(11,0)  NOT NULL
);

CREATE TABLE TRADE_COMMENTS (
TRADE_COMMENT_ID VARCHAR2(255) PRIMARY KEY,
TRADE_ID VARCHAR2(255) NOT NULL,
USER_ID VARCHAR2(255) NOT NULL,
TRADE_COMMENT VARCHAR2(255) NOT NULL,
COMMENT_REGIDATE DATE DEFAULT sysdate NOT NULL,
CONSTRAINT FK_TRADE_COMMENTS_TRADE_ID FOREIGN KEY(TRADE_ID)
REFERENCES TRADE(TRADE_ID)
);

CREATE TABLE CUSTOMER_QUESTION (
QUESTION_ID VARCHAR2(255) PRIMARY KEY,
USER_ID VARCHAR2(255) NOT NULL,
Q_TITLE VARCHAR2(255) NOT NULL,
Q_TYPE VARCHAR2(255) NOT NULL,
Q_CONTENT VARCHAR2(255) NOT NULL,
Q_RESERVATION_ID VARCHAR2(255) NOT NULL,
Q_PHONE VARCHAR2(255) NOT NULL,
Q_REGIDATE DATE DEFAULT sysdate  NOT NULL
);

CREATE TABLE CUSTOMER_ANSWER (
ANSWER_ID VARCHAR2(255) PRIMARY KEY,
QUESTION_ID VARCHAR2(255) NOT NULL,
ANSWER_CONTENT VARCHAR2(255) NOT NULL,
ANSWER_REGIDATE DATE DEFAULT sysdate NOT NULL,
CONSTRAINT FK_CUSTOMER_QUESTION_Q_ID FOREIGN KEY(QUESTION_ID)
REFERENCES CUSTOMER_QUESTION (QUESTION_ID)
);

CREATE TABLE TRADE_RECOMMENTS (
TRADE_RECOMMENT_ID VARCHAR2(255) PRIMARY KEY,
TRADE_COMMENT_ID VARCHAR2(255),
USER_ID VARCHAR2(255) NOT NULL,
TRADE_COMMENT VARCHAR2(255) NOT NULL,
DEPTH NUMBER DEFAULT 0,
COMMENT_REGIDATE DATE DEFAULT sysdate NOT NULL,
CONSTRAINT FK_RECOMMENTS_TRADE_COM_ID FOREIGN KEY(TRADE_COMMENT_ID)
REFERENCES TRADE_COMMENTS(TRADE_COMMENT_ID)
);

COMMIT;







 