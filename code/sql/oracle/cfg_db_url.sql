-- Create table
create table CFG_DB_URL
(
  NAME    VARCHAR2(255) primary key,
  URL     VARCHAR2(4000),
  STATE   CHAR(1),
  REMARKS VARCHAR2(255)
);
