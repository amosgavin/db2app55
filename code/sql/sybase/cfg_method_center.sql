-- create table
create table cfg_method_center
(
  service_impl_classname           varchar(255) not null,
  method_name           					 varchar(255) not null,
  parameter_count          				 numeric(6) not null,
  parameter_index 								 numeric(6) not null,
  parameter_function 							 varchar(255) not null,
  center_type 							 			 varchar(255) not null,  
  state                						 char(1) not null,
  remarks              						 varchar(255) null,
  primary   key(service_impl_classname,method_name,parameter_count)
);
