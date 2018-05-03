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

