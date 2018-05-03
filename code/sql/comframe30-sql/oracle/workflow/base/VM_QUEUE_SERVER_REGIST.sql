/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/9/8 21:20:58                            */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_QUEUE_SERVER_REGIST                                */
/*==============================================================*/
create table VM_QUEUE_SERVER_REGIST  (
   REGIST_ID            NUMBER(15,0)                    not null,
   PROCESS_ID           VARCHAR2(255),
   HOST_IP              VARCHAR2(255),
   HOST_NAME            VARCHAR2(255),
   QUEUE_ID             VARCHAR2(5),
   QUEUE_TYPE           VARCHAR2(255),
   MOD_PARAM            NUMBER(3,0),
   MOD_VALUE            VARCHAR2(255),
   REGION_ID            VARCHAR2(6),
   STATE                CHAR(1),
   REGIST_DATE          DATE,
   REMARKS              VARCHAR2(255)
);

comment on table VM_QUEUE_SERVER_REGIST is
'队列服务器注册表';

comment on column VM_QUEUE_SERVER_REGIST.PROCESS_ID is
'进程标识';

comment on column VM_QUEUE_SERVER_REGIST.HOST_IP is
'主机IP';

comment on column VM_QUEUE_SERVER_REGIST.HOST_NAME is
'主机名称';

comment on column VM_QUEUE_SERVER_REGIST.QUEUE_ID is
'队列标识';

comment on column VM_QUEUE_SERVER_REGIST.QUEUE_TYPE is
'队列类型，-t参数值';

comment on column VM_QUEUE_SERVER_REGIST.MOD_PARAM is
'模参，-m参数值';

comment on column VM_QUEUE_SERVER_REGIST.MOD_VALUE is
'模值，-v参数值';

comment on column VM_QUEUE_SERVER_REGIST.REGION_ID is
'地市标识，-r参数值';

comment on column VM_QUEUE_SERVER_REGIST.STATE is
'状态';

comment on column VM_QUEUE_SERVER_REGIST.REGIST_DATE is
'注册时间';

comment on column VM_QUEUE_SERVER_REGIST.REMARKS is
'备注';

alter table VM_QUEUE_SERVER_REGIST
   add constraint PK_VM_QUEUE_SERVER_REGIST primary key (REGIST_ID);

