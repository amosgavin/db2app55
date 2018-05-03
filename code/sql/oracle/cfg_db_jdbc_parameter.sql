-- Create table
create table CFG_DB_JDBC_PARAMETER
(
  PARAMETER_ID NUMBER(12) primary key,
  DB_ACCT_CODE VARCHAR2(255) not null,
  SERVER_NAME  VARCHAR2(255) not null,
  NAME         VARCHAR2(255) not null,
  VALUE        VARCHAR2(255) not null,
  STATE        CHAR(1) not null,
  REMARKS      VARCHAR2(255)
);
  
 
-- Create/Recreate indexes 
create index IDX_CFG_DB_JDBC_PARAMETER_1 on CFG_DB_JDBC_PARAMETER (SERVER_NAME);
create index IDX_CFG_DB_JDBC_PARAMETER_2 on CFG_DB_JDBC_PARAMETER (DB_ACCT_CODE);

