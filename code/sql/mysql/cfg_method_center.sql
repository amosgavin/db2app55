-- Create table
create table CFG_METHOD_CENTER
(
  SERVICE_IMPL_CLASSNAME           VARCHAR(255) not null,
  METHOD_NAME           					 VARCHAR(255) not null,
  PARAMETER_COUNT          				 BIGINT(6) not null,
  PARAMETER_INDEX 								 BIGINT(6) not null,
  PARAMETER_FUNCTION 							 VARCHAR(255) not null,
  CENTER_TYPE 							 			 VARCHAR(255) not null,  
  STATE                						 CHAR(1) not null,
  REMARKS              						 VARCHAR(255),
  primary   key(SERVICE_IMPL_CLASSNAME,METHOD_NAME,PARAMETER_COUNT)
);
