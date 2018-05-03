-- create table
create table cfg_id_generator
(
  table_name             varchar(100)  primary key,
  domain_id              numeric(6) not null,
  generator_type         char(1) not null,
  sequence_name          varchar(60) null,
  max_id                 numeric(12) null,
  start_value            numeric(12) null,
  min_value              numeric(12) null,
  max_value              numeric(12) null,
  increment_value        numeric(6)	 null,
  cycle_flag             char(1)     null,
  cache_size             numeric(6)  null,
  sequence_create_script varchar(1000) null,
  his_table_name         varchar(100) null,
  his_sequence_name      varchar(60) null,
  his_data_flag          char(1) null,
  his_max_id             numeric(12) null,
  his_donecode_flag      char(1) null,
  step_by                numeric(6) null,
  his_step_by            numeric(6) null
) 

