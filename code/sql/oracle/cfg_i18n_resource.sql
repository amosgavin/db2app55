create table CFG_I18N_RESOURCE
(
  RES_KEY VARCHAR2(15) primary key,
  ZH_CN   VARCHAR2(1000) not null,
  EN_US   VARCHAR2(1000),
  STATE   CHAR(1) not null,
  REMARK  VARCHAR2(255)
)