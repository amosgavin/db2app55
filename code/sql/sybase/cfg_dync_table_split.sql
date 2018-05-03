create table cfg_dync_table_split
(
  group_name      varchar(255) not null,
  table_name      varchar(255) not null,
  table_name_expr varchar(255) not null,
  convert_class   varchar(255) not null,
  state           char(1) not null,
  remarks         varchar(255) null,
  primary key(group_name,table_name)
)

