-- Create table
create table CFG_METHOD_CENTER
(
  SERVICE_IMPL_CLASSNAME           VARCHAR2(255) not null,
  METHOD_NAME           					 VARCHAR2(255) not null,
  PARAMETER_COUNT          				 NUMBER(6) not null,
  PARAMETER_INDEX 								 NUMBER(6) not null,
  PARAMETER_FUNCTION 							 VARCHAR2(255) not null,
  CENTER_TYPE 							 			 VARCHAR2(255) not null,  
  STATE                						 CHAR(1) not null,
  REMARKS              						 VARCHAR2(255),
  primary   key(SERVICE_IMPL_CLASSNAME,METHOD_NAME,PARAMETER_COUNT)
);
