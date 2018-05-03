create table CFG_I18N_RESOURCE
(
  RES_KEY VARCHAR(15) primary key,
  ZH_CN   VARCHAR(1000) not null,
  EN_US   VARCHAR(1000),
  STATE   CHAR(1) not null,
  REMARK  VARCHAR(255)
)