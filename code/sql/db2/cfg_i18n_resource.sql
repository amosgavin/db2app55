create table CFG_I18N_RESOURCE
(
  RES_KEY VARCHAR(15) not null primary key,
  ZH_CN   VARCHAR(1000) not null,
  EN_US   VARCHAR(1000),
  STATE   CHARACTER(1) not null,
  REMARK  VARCHAR(255)
)