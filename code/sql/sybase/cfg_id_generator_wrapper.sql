-- create table
create table cfg_id_generator_wrapper
(
  table_name             									varchar(100)  primary key,
  table_seq_wrapper_impl        					varchar(1000),
  his_table_seq_wrapper_impl      				varchar(1000)
) ;