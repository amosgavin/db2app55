-- Create table
create table CFG_TABLE_SPLIT
(
  TABLE_NAME      VARCHAR2(255) primary key,
  TABLE_NAME_EXPR VARCHAR2(255) not null,
  STATE           CHAR(1) not null,
  REMARKS         VARCHAR2(255)
);
