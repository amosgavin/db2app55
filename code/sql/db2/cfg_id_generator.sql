-- Create table
create table CFG_ID_GENERATOR
(
  TABLE_NAME             VARCHAR(100)  not null primary key,
  DOMAIN_ID              BIGINT not null,
  GENERATOR_TYPE         CHARACTER(1) not null,
  SEQUENCE_NAME          VARCHAR(60),
  MAX_ID                 BIGINT,
  START_VALUE            BIGINT,
  MIN_VALUE              BIGINT,
  MAX_VALUE              BIGINT,
  INCREMENT_VALUE        BIGINT,
  CYCLE_FLAG             CHARACTER(1),
  CACHE_SIZE             BIGINT,
  SEQUENCE_CREATE_SCRIPT VARCHAR(1000),
  HIS_TABLE_NAME         VARCHAR(100),
  HIS_SEQUENCE_NAME      VARCHAR(60),
  HIS_DATA_FLAG          CHARACTER(1),
  HIS_MAX_ID             BIGINT,
  HIS_DONECODE_FLAG      CHARACTER(1),
  STEP_BY                BIGINT,
  HIS_STEP_BY            BIGINT
) ;