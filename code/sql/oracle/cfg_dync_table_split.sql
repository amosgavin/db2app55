create table CFG_DYNC_TABLE_SPLIT
(
  GROUP_NAME      VARCHAR2(255) not null,
  TABLE_NAME      VARCHAR2(255) not null,
  TABLE_NAME_EXPR VARCHAR2(255) not null,
  CONVERT_CLASS   VARCHAR2(255) not null,
  STATE           CHAR(1) not null,
  REMARKS         VARCHAR2(255),
  primary key(GROUP_NAME,TABLE_NAME)
);