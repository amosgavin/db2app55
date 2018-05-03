-- Create table
create table CFG_DB_URL
(
  NAME    VARCHAR(255) primary key,
  URL     VARCHAR(4000),
  STATE   CHAR(1),
  REMARKS VARCHAR(255)
);
