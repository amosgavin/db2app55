create table cfg_client_timeout
(
  server_name  				VARCHAR(100) not null,
  interface_classname	VARCHAR(300) not null,
  method_name  				VARCHAR(100) not null,
  parameter_count  		BIGINT(6) not null,
  timeout_second  		BIGINT(6) not null,
  state        				char(1) not null,
  remarks      				VARCHAR(255),
  CONSTRAINT pk_cfg_client_timeout PRIMARY KEY (interface_classname, method_name, parameter_count)
);

