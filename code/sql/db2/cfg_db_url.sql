-- Create table
create table CFG_DB_URL
(
  NAME    VARCHAR(255) not null primary key,
  URL     VARCHAR(1000),
  STATE   CHARACTER(1),
  REMARKS VARCHAR(255)
);
