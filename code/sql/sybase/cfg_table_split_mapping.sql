-- create table
create table cfg_table_split_mapping
(
  mapping_id           numeric(12) primary key,
  table_name           varchar(255) not null,
  column_name          varchar(255) not null,
  column_convert_class varchar(255) not null,
  state                char(1) not null,
  remarks              varchar(255) null
)

create index idx_cfg_table_split_mapping_1 on cfg_table_split_mapping (table_name,column_name)

