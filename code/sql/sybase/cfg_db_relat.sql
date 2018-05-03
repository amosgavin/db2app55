-- create table
create table cfg_db_relat
(
  db_acct_code varchar(255) not null,
  url_name     varchar(255)	not null,
  server_name  varchar(255) not null,
  state        char(1)			not null,
  remarks      varchar(255) null,
  primary   key(db_acct_code,server_name)
)
 
 
-- create/recreate indexes 
create index idx_cfg_db_relat_1 on cfg_db_relat (server_name)

