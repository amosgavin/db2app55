-- Create table
create table CFG_ID_GENERATOR
(
  TABLE_NAME             VARCHAR2(100)  primary key,
  DOMAIN_ID              NUMBER(6) not null,
  GENERATOR_TYPE         CHAR(1) not null,
  SEQUENCE_NAME          VARCHAR2(60),
  MAX_ID                 NUMBER(12),
  START_VALUE            NUMBER(12),
  MIN_VALUE              NUMBER(12),
  MAX_VALUE              NUMBER(12),
  INCREMENT_VALUE        NUMBER(6),
  CYCLE_FLAG             CHAR(1),
  CACHE_SIZE             NUMBER(6),
  SEQUENCE_CREATE_SCRIPT VARCHAR2(1000),
  HIS_TABLE_NAME         VARCHAR2(100),
  HIS_SEQUENCE_NAME      VARCHAR2(60),
  HIS_DATA_FLAG          CHAR(1),
  HIS_MAX_ID             NUMBER(12),
  HIS_DONECODE_FLAG      CHAR(1),
  STEP_BY                NUMBER(6),
  HIS_STEP_BY            NUMBER(6)
) ;