-- create table
create table cfg_db_jdbc_parameter
(
  parameter_id numeric(12) primary key,
  db_acct_code varchar(255) not null,
  server_name  varchar(255) not null,
  name         varchar(255) not null,
  value        varchar(255) not null,
  state        char(1) not null,
  remarks      varchar(255) null,
)
  
 
-- create/recreate indexes 
create index idx_cfg_db_jdbc_parameter_1 on cfg_db_jdbc_parameter (server_name)

create index idx_cfg_db_jdbc_parameter_2 on cfg_db_jdbc_parameter (db_acct_code)

