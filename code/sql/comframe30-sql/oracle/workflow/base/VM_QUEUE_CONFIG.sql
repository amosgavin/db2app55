/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_QUEUE_CONFIG                                       */
/*==============================================================*/
create table VM_QUEUE_CONFIG  (
   QUEUE_ID             VARCHAR2(5)                     not null,
   QUEUE_TYPE           VARCHAR2(255)                   not null,
   DATASOURE            VARCHAR2(30),
   SPLIT_QUEUE          CHAR(1),
   SPLIT_REGION         CHAR(1),
   TIME_INTERVAL        NUMBER(15,0),
   FETCH_NUM            NUMBER(4,0),
   STATE                CHAR(1),
   REMARK               VARCHAR2(255)
);

comment on column VM_QUEUE_CONFIG.QUEUE_ID is
'队列标识';

comment on column VM_QUEUE_CONFIG.QUEUE_TYPE is
'队列类型';

comment on column VM_QUEUE_CONFIG.DATASOURE is
'数据源名称,可以配置so{center}等';

comment on column VM_QUEUE_CONFIG.SPLIT_QUEUE is
'是否按队列标识分表(Y:分,N或不填不:不分)';

comment on column VM_QUEUE_CONFIG.SPLIT_REGION is
'是否按队地域分表(Y:分,N或不填不:不分)';

comment on column VM_QUEUE_CONFIG.TIME_INTERVAL is
'时间间隔(单位:毫秒)';

comment on column VM_QUEUE_CONFIG.FETCH_NUM is
'每次获取条数';

comment on column VM_QUEUE_CONFIG.STATE is
'U:有效,E:无效';

comment on column VM_QUEUE_CONFIG.REMARK is
'备注';

alter table VM_QUEUE_CONFIG
   add constraint PK_VM_QUEUE_CONFIG primary key (QUEUE_ID, QUEUE_TYPE);

