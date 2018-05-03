create table cfg_db_acct
(
  res_key VARCHAR(15) primary key,
  zh_cn   VARCHAR(1000) not null,
  en_us   VARCHAR(1000),
  state   CHAR(1) not null,
  remark  VARCHAR(255)
)