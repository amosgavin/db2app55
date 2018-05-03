-- Create table
create table CFG_DB_ACCT
(
  DB_ACCT_CODE     VARCHAR(255) not null primary key,
  USERNAME         VARCHAR(255),
  PASSWORD         VARCHAR(255),
  HOST             VARCHAR(255),
  PORT             BIGINT,
  SID              VARCHAR(255),
  DEFAULT_CONN_MIN BIGINT,
  DEFAULT_CONN_MAX BIGINT,
  STATE            CHARACTER(1),
  REMARKS          VARCHAR(1000)
);

create index IDX_CFG_DB_ACCT_1 on CFG_DB_ACCT (USERNAME);