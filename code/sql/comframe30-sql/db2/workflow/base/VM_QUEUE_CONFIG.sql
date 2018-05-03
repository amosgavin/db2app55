/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_QUEUE_CONFIG                                       */
/*==============================================================*/
create table VM_QUEUE_CONFIG  (
   QUEUE_ID             VARCHAR(5)                     not null,
   QUEUE_TYPE           VARCHAR(255)                   not null,
   DATASOURE            VARCHAR(30),
   SPLIT_QUEUE          CHAR(1),
   SPLIT_REGION         CHAR(1),
   TIME_INTERVAL        BIGINT,
   FETCH_NUM            INTEGER,
   STATE                CHAR(1),
   REMARK               VARCHAR(255)
);

comment on column VM_QUEUE_CONFIG.QUEUE_ID is
'���б�ʶ';

comment on column VM_QUEUE_CONFIG.QUEUE_TYPE is
'��������';

comment on column VM_QUEUE_CONFIG.DATASOURE is
'����Դ����,��������so{center}��';

comment on column VM_QUEUE_CONFIG.SPLIT_QUEUE is
'�Ƿ񰴶��б�ʶ�ֱ�(Y:��,N���:����)';

comment on column VM_QUEUE_CONFIG.SPLIT_REGION is
'�Ƿ񰴶ӵ���ֱ�(Y:��,N���:����)';

comment on column VM_QUEUE_CONFIG.TIME_INTERVAL is
'ʱ����(��λ:����)';

comment on column VM_QUEUE_CONFIG.FETCH_NUM is
'ÿ�λ�ȡ����';

comment on column VM_QUEUE_CONFIG.STATE is
'U:��Ч,E:��Ч';

comment on column VM_QUEUE_CONFIG.REMARK is
'��ע';

alter table VM_QUEUE_CONFIG
   add constraint PK_VM_QUEUE_CONFIG primary key (QUEUE_ID, QUEUE_TYPE);

