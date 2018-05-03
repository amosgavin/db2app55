-- create table
create table cfg_table_split
(
  table_name      varchar(255) primary key,
  table_name_expr varchar(255) not null,
  state           char(1) not null,
  remarks         varchar(255) null
)

