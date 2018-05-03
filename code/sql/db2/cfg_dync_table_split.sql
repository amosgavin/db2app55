create table CFG_DYNC_TABLE_SPLIT
(
  GROUP_NAME      VARCHAR(255) not null,
  TABLE_NAME      VARCHAR(255) not null,
  TABLE_NAME_EXPR VARCHAR(255) not null,
  CONVERT_CLASS   VARCHAR(255) not null,
  STATE           CHARACTER(1) not null,
  REMARKS         VARCHAR(255),
  primary key(GROUP_NAME,TABLE_NAME)
);