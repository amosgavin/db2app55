-- Create table
create table CFG_SERVICE_CONTROL(
SERVER_NAME   VARCHAR2(1000) NOT NULL,
SERVICE_NAME  VARCHAR2(1000) NOT NULL,
METHOD_NAME   VARCHAR2(1000),
LIMIT_COUNT 	NUMBER(6) NOT NULL,
STATE					CHAR(1)   NOT NULL,
REMARKS				VARCHAR2(255)
);