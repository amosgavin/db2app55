-- Create table
create table cfg_service_control(
server_name   varchar(1000) not null,
service_name  varchar(1000) not null,
method_name   varchar(1000) null,
limit_count 	numeric(6) not null,
state					char(1)   not null,
remarks				varchar(255) null
);
