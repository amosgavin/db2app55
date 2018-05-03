-- create table
create table cfg_db_acct
(
  db_acct_code     varchar(255)  primary key,
  username         varchar(255) null,
  password         varchar(255) null,
  host             varchar(255) null,
  port             numeric(5)   null,
  sid              varchar(255) null,
  default_conn_min numeric(3)   null,
  default_conn_max numeric(3)   null,
  state            char(1)      null,
  remarks          varchar(1000) null
)

create index idx_cfg_db_acct_1 on cfg_db_acct (username)
