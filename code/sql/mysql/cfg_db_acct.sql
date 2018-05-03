-- Create table
create table CFG_DB_ACCT
(
  DB_ACCT_CODE     VARCHAR(255)  primary key,
  USERNAME         VARCHAR(255),
  PASSWORD         VARCHAR(255),
  HOST             VARCHAR(255),
  PORT             BIGINT(5),
  SID              VARCHAR(255),
  DEFAULT_CONN_MIN BIGINT(3),
  DEFAULT_CONN_MAX BIGINT(3),
  STATE            CHAR(1),
  REMARKS          VARCHAR(1000)
);

create index IDX_CFG_DB_ACCT_1 on CFG_DB_ACCT (USERNAME);
