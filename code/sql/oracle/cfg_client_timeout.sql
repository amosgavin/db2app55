create table cfg_client_timeout
(
  server_name  				varchar2(100) not null,
  interface_classname	varchar2(300) not null,
  method_name  				varchar2(100) not null,
  parameter_count  		number(6) not null,
  timeout_second  		number(6) not null,
  state        				char(1) not null,
  remarks      				varchar2(255),
  CONSTRAINT pk_cfg_client_timeout PRIMARY KEY (interface_classname, method_name, parameter_count)
);

