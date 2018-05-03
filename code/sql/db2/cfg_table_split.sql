-- Create table
create table CFG_TABLE_SPLIT
(
  TABLE_NAME      VARCHAR(255) not null primary key,
  TABLE_NAME_EXPR VARCHAR(255) not null,
  STATE           CHARACTER(1) not null,
  REMARKS         VARCHAR(255)
);
