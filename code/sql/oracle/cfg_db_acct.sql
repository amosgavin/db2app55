-- Create table
create table CFG_DB_ACCT
(
  DB_ACCT_CODE     VARCHAR2(255)  primary key,
  USERNAME         VARCHAR2(255),
  PASSWORD         VARCHAR2(255),
  HOST             VARCHAR2(255),
  PORT             NUMBER(5),
  SID              VARCHAR2(255),
  DEFAULT_CONN_MIN NUMBER(3),
  DEFAULT_CONN_MAX NUMBER(3),
  STATE            CHAR(1),
  REMARKS          VARCHAR2(1000)
);

create index IDX_CFG_DB_ACCT_1 on CFG_DB_ACCT (USERNAME);