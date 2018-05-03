-- CREATE TABLE
CREATE TABLE CFG_BO_MASK(
BO_NAME 							VARCHAR(255) NOT NULL,
ATTR_NAME							VARCHAR(255) NOT NULL,
MASK_FUNCTION_CLASS		VARCHAR(255) NOT NULL,
STATE									CHARACTER(1)	NOT NULL,
REMARKS								VARCHAR(255),
CONSTRAINT PK_CFG_BO_MASK PRIMARY KEY (BO_NAME,ATTR_NAME)
);
create table cfg_client_timeout
(
  SERVER_NAME  				VARCHAR(100) NOT NULL,
  INTERFACE_CLASSNAME	VARCHAR(300) NOT NULL,
  METHOD_NAME  				VARCHAR(100) NOT NULL,
  PARAMETER_COUNT  		BIGINT NOT NULL,
  TIMEOUT_SECOND  		BIGINT NOT NULL,
  STATE        				CHARACTER(1) NOT NULL,
  REMARKS      				VARCHAR(255),
  CONSTRAINT PK_CFG_CLIENT_TIMEOUT PRIMARY KEY (INTERFACE_CLASSNAME, METHOD_NAME, PARAMETER_COUNT)
);

-- Create table
create table CFG_DB_ACCT
(
  DB_ACCT_CODE     VARCHAR(255) not null primary key,
  USERNAME         VARCHAR(255),
  PASSWORD         VARCHAR(255),
  HOST             VARCHAR(255),
  PORT             BIGINT,
  SID              VARCHAR(255),
  DEFAULT_CONN_MIN BIGINT,
  DEFAULT_CONN_MAX BIGINT,
  STATE            CHARACTER(1),
  REMARKS          VARCHAR(1000)
);

create index IDX_CFG_DB_ACCT_1 on CFG_DB_ACCT (USERNAME);

-- Create table
create table CFG_DB_JDBC_PARAMETER
(
  PARAMETER_ID BIGINT not null primary key,
  DB_ACCT_CODE VARCHAR(255) not null,
  SERVER_NAME  VARCHAR(255) not null,
  NAME         VARCHAR(255) not null,
  VALUE        VARCHAR(255) not null,
  STATE        CHARACTER(1) not null,
  REMARKS      VARCHAR(255)
);
  
 
-- Create/Recreate indexes 
create index IDX_CFG_DB_JDBC_PARAMETER_1 on CFG_DB_JDBC_PARAMETER (SERVER_NAME);
create index IDX_CFG_DB_JDBC_PARAMETER_2 on CFG_DB_JDBC_PARAMETER (DB_ACCT_CODE);

-- Create table
create table CFG_DB_RELAT
(
  DB_ACCT_CODE VARCHAR(255) not null,
  URL_NAME     VARCHAR(255),
  SERVER_NAME  VARCHAR(255) not null,
  STATE        CHARACTER(1),
  REMARKS      VARCHAR(255),
  primary   key(DB_ACCT_CODE,SERVER_NAME)
);
 
 
-- Create/Recreate indexes 
create index IDX_CFG_DB_RELAT_1 on CFG_DB_RELAT (SERVER_NAME);

-- Create table
create table CFG_DB_URL
(
  NAME    VARCHAR(255) not null primary key,
  URL     VARCHAR(1000),
  STATE   CHARACTER(1),
  REMARKS VARCHAR(255)
);

create table CFG_DYNC_TABLE_SPLIT
(
  GROUP_NAME      VARCHAR(255) not null,
  TABLE_NAME      VARCHAR(255) not null,
  TABLE_NAME_EXPR VARCHAR(255) not null,
  CONVERT_CLASS   VARCHAR(255) not null,
  STATE           CHARACTER(1) not null,
  REMARKS         VARCHAR(255),
  primary key(GROUP_NAME,TABLE_NAME)
);

create table CFG_I18N_RESOURCE
(
  RES_KEY VARCHAR(15) not null primary key,
  ZH_CN   VARCHAR(1000) not null,
  EN_US   VARCHAR(1000),
  STATE   CHARACTER(1) not null,
  REMARK  VARCHAR(255)
);

-- Create table
create table CFG_ID_GENERATOR
(
  TABLE_NAME             VARCHAR(100)  not null primary key,
  DOMAIN_ID              BIGINT not null,
  GENERATOR_TYPE         CHARACTER(1) not null,
  SEQUENCE_NAME          VARCHAR(60),
  MAX_ID                 BIGINT,
  START_VALUE            BIGINT,
  MIN_VALUE              BIGINT,
  MAX_VALUE              BIGINT,
  INCREMENT_VALUE        BIGINT,
  CYCLE_FLAG             CHARACTER(1),
  CACHE_SIZE             BIGINT,
  SEQUENCE_CREATE_SCRIPT VARCHAR(1000),
  HIS_TABLE_NAME         VARCHAR(100),
  HIS_SEQUENCE_NAME      VARCHAR(60),
  HIS_DATA_FLAG          CHARACTER(1),
  HIS_MAX_ID             BIGINT,
  HIS_DONECODE_FLAG      CHARACTER(1),
  STEP_BY                BIGINT,
  HIS_STEP_BY            BIGINT
) ;

-- Create table
create table CFG_ID_GENERATOR_WRAPPER
(
  TABLE_NAME             									VARCHAR(100) not null primary key,
  TABLE_SEQ_WRAPPER_IMPL        					VARCHAR(1000),
  HIS_TABLE_SEQ_WRAPPER_IMPL      				VARCHAR(1000)
) ;

-- Create table
create table CFG_METHOD_CENTER
(
  SERVICE_IMPL_CLASSNAME           VARCHAR(255) not null,
  METHOD_NAME           					 VARCHAR(255) not null,
  PARAMETER_COUNT          				 BIGINT not null,
  PARAMETER_INDEX 								 BIGINT not null,
  PARAMETER_FUNCTION 							 VARCHAR(255) not null,
  CENTER_TYPE 							 			 VARCHAR(255) not null,  
  STATE                						 CHARACTER(1) not null,
  REMARKS              						 VARCHAR(255),
  primary   key(SERVICE_IMPL_CLASSNAME,METHOD_NAME,PARAMETER_COUNT)
);

-- Create table
create table CFG_SERVICE_CONTROL(
SERVER_NAME   VARCHAR(1000) NOT NULL,
SERVICE_NAME  VARCHAR(1000) NOT NULL,
METHOD_NAME   VARCHAR(1000),
LIMIT_COUNT 	BIGINT NOT NULL,
STATE					CHARACTER(1)   NOT NULL,
REMARKS				VARCHAR(255)
);

-- Create table
create table CFG_TABLE_SPLIT
(
  TABLE_NAME      VARCHAR(255) not null primary key,
  TABLE_NAME_EXPR VARCHAR(255) not null,
  STATE           CHARACTER(1) not null,
  REMARKS         VARCHAR(255)
);

-- Create table
create table CFG_TABLE_SPLIT_MAPPING
(
  MAPPING_ID           BIGINT not null primary key,
  TABLE_NAME           VARCHAR(255) not null,
  COLUMN_NAME          VARCHAR(255) not null,
  COLUMN_CONVERT_CLASS VARCHAR(255) not null,
  STATE                CHARACTER(1) not null,
  REMARKS              VARCHAR(255)
);

create index IDX_CFG_TABLE_SPLIT_MAPPING_1 on CFG_TABLE_SPLIT_MAPPING (TABLE_NAME,COLUMN_NAME);






