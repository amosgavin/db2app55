-- Create table
create table CFG_ID_GENERATOR_WRAPPER
(
  TABLE_NAME             									VARCHAR(100)  primary key,
  TABLE_SEQ_WRAPPER_IMPL        					VARCHAR(1000),
  HIS_TABLE_SEQ_WRAPPER_IMPL      				VARCHAR(1000)
) ;