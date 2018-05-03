-- Create table
create table CFG_TABLE_SPLIT
(
  TABLE_NAME      VARCHAR(255) primary key,
  TABLE_NAME_EXPR VARCHAR(255) not null,
  STATE           CHAR(1) not null,
  REMARKS         VARCHAR(255)
);

