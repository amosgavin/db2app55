-- create table
create table cfg_bo_mask(
bo_name 							varchar(255) not null,
attr_name							varchar(255) not null,
mask_function_class		varchar(255) not null,
state									char(1)	not null,
remarks								varchar(255),
constraint pk_cfg_bo_mask primary key (bo_name,attr_name)
)
