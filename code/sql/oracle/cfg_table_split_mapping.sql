-- Create table
create table CFG_TABLE_SPLIT_MAPPING
(
  MAPPING_ID           NUMBER(12) primary key,
  TABLE_NAME           VARCHAR2(255) not null,
  COLUMN_NAME          VARCHAR2(255) not null,
  COLUMN_CONVERT_CLASS VARCHAR2(255) not null,
  STATE                CHAR(1) not null,
  REMARKS              VARCHAR2(255)
);

create index IDX_CFG_TABLE_SPLIT_MAPPING_1 on CFG_TABLE_SPLIT_MAPPING (TABLE_NAME,COLUMN_NAME);