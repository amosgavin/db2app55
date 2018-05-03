-- create table
create table cfg_db_url
(
  name    varchar(255) primary key,
  url     varchar(4000) not null,
  state   char(1) null,
  remarks varchar(255) null
)

