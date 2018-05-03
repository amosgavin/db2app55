-- Create table
create table CFG_DB_RELAT
(
  DB_ACCT_CODE VARCHAR(255) not null,
  URL_NAME     VARCHAR(255),
  SERVER_NAME  VARCHAR(255) not null,
  STATE        CHARACTER(1),
  REMARKS      VARCHAR(255),
  primary   key(DB_ACCT_CODE,SERVER_NAME)
);
 
 
-- Create/Recreate indexes 
create index IDX_CFG_DB_RELAT_1 on CFG_DB_RELAT (SERVER_NAME);
