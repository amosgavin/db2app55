/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:06:00                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_CODE                                     */
/*==============================================================*/
create table VM_EXCEPTION_CODE  (
   EXCEPTION_CODE       VARCHAR2(255)                   not null,
   EXCEPTION_NAME       VARCHAR2(255),
   WORKFLOW_OBJECT_TYPE VARCHAR2(255),
   TASK_TAG             VARCHAR2(255),
   EXCEPTION_TYPE       VARCHAR2(255),
   CREATE_DATE          DATE,
   STATE                CHAR(1)
);

comment on column VM_EXCEPTION_CODE.EXCEPTION_CODE is
'�쳣ԭ�����';

comment on column VM_EXCEPTION_CODE.EXCEPTION_NAME is
'�쳣ԭ������';

comment on column VM_EXCEPTION_CODE.WORKFLOW_OBJECT_TYPE is
'�����������������';

comment on column VM_EXCEPTION_CODE.CREATE_DATE is
'����ʱ��';

comment on column VM_EXCEPTION_CODE.STATE is
'״̬ U ��ǰ���� E ��������';

alter table VM_EXCEPTION_CODE
   add constraint PK_VM_EXCEPTION_CODE primary key (EXCEPTION_CODE);

