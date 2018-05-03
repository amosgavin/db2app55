-- Create table
create table CFG_ID_GENERATOR
(
  TABLE_NAME             VARCHAR(100)  primary key,
  DOMAIN_ID              BIGINT(6) not null,
  GENERATOR_TYPE         CHAR(1) not null,
  SEQUENCE_NAME          VARCHAR(60),
  MAX_ID                 BIGINT(12),
  START_VALUE            BIGINT(12),
  MIN_VALUE              BIGINT(12),
  MAX_VALUE              BIGINT(12),
  INCREMENT_VALUE        BIGINT(6),
  CYCLE_FLAG             CHAR(1),
  CACHE_SIZE             BIGINT(6),
  SEQUENCE_CREATE_SCRIPT VARCHAR(1000),
  HIS_TABLE_NAME         VARCHAR(100),
  HIS_SEQUENCE_NAME      VARCHAR(60),
  HIS_DATA_FLAG          CHAR(1),
  HIS_MAX_ID             BIGINT(12),
  HIS_DONECODE_FLAG      CHAR(1),
  STEP_BY                BIGINT(6),
  HIS_STEP_BY            BIGINT(6)
) ;
