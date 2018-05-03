/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/9/8 21:20:58                            */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_QUEUE_SERVER_REGIST                                */
/*==============================================================*/
create table VM_QUEUE_SERVER_REGIST  (
   REGIST_ID            BIGINT                    not null,
   PROCESS_ID           VARCHAR(255),
   HOST_IP              VARCHAR(255),
   HOST_NAME            VARCHAR(255),
   QUEUE_ID             VARCHAR(5),
   QUEUE_TYPE           VARCHAR(255),
   MOD_PARAM            INTEGER,
   MOD_VALUE            VARCHAR(255),
   REGION_ID            VARCHAR(6),
   STATE                CHAR(1),
   REGIST_DATE          TIMESTAMP,
   REMARKS              VARCHAR(255)
);

comment on table VM_QUEUE_SERVER_REGIST is
'���з�����ע���';

comment on column VM_QUEUE_SERVER_REGIST.PROCESS_ID is
'���̱�ʶ';

comment on column VM_QUEUE_SERVER_REGIST.HOST_IP is
'����IP';

comment on column VM_QUEUE_SERVER_REGIST.HOST_NAME is
'��������';

comment on column VM_QUEUE_SERVER_REGIST.QUEUE_ID is
'���б�ʶ';

comment on column VM_QUEUE_SERVER_REGIST.QUEUE_TYPE is
'�������ͣ�-t����ֵ';

comment on column VM_QUEUE_SERVER_REGIST.MOD_PARAM is
'ģ�Σ�-m����ֵ';

comment on column VM_QUEUE_SERVER_REGIST.MOD_VALUE is
'ģֵ��-v����ֵ';

comment on column VM_QUEUE_SERVER_REGIST.REGION_ID is
'���б�ʶ��-r����ֵ';

comment on column VM_QUEUE_SERVER_REGIST.STATE is
'״̬';

comment on column VM_QUEUE_SERVER_REGIST.REGIST_DATE is
'ע��ʱ��';

comment on column VM_QUEUE_SERVER_REGIST.REMARKS is
'��ע';

alter table VM_QUEUE_SERVER_REGIST
   add constraint PK_VM_QUEUE_SERVER_REGIST primary key (REGIST_ID);

