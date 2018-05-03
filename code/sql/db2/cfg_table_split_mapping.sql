-- Create table
create table CFG_TABLE_SPLIT_MAPPING
(
  MAPPING_ID           BIGINT not null primary key,
  TABLE_NAME           VARCHAR(255) not null,
  COLUMN_NAME          VARCHAR(255) not null,
  COLUMN_CONVERT_CLASS VARCHAR(255) not null,
  STATE                CHARACTER(1) not null,
  REMARKS              VARCHAR(255)
);

create index IDX_CFG_TABLE_SPLIT_MAPPING_1 on CFG_TABLE_SPLIT_MAPPING (TABLE_NAME,COLUMN_NAME);