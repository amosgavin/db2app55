/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:07:28                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_RECORD                                   */
/*==============================================================*/
create table VM_EXCEPTION_RECORD  (
   EXCEPTION_RECORD_ID  NUMBER(15,0)                    not null,
   WORKFLOW_ID          VARCHAR2(25),
   QUEUE_ID             VARCHAR2(5),
   TASK_ID              VARCHAR2(25),
   EXCEPTION_CODE       VARCHAR2(255)                   not null,
   EXCEPTION_REMARKS    VARCHAR2(255),
   NEXT_TEMPLATE_TAG    VARCHAR2(255),
   RULE_OWNER           VARCHAR2(2),
   CREATE_DATE          DATE,
   STATE                CHAR(1),
   REGION_ID            VARCHAR2(6)
);

comment on column VM_EXCEPTION_RECORD.EXCEPTION_RECORD_ID is
'�쳣��¼��ʶ(����)';

comment on column VM_EXCEPTION_RECORD.WORKFLOW_ID is
'������ʵ�����';

comment on column VM_EXCEPTION_RECORD.QUEUE_ID is
'���̶���';

comment on column VM_EXCEPTION_RECORD.TASK_ID is
'����������ʵ��ID';

comment on column VM_EXCEPTION_RECORD.EXCEPTION_CODE is
'�쳣ԭ��';

comment on column VM_EXCEPTION_RECORD.EXCEPTION_REMARKS is
'�쳣������Ϣ';

comment on column VM_EXCEPTION_RECORD.NEXT_TEMPLATE_TAG is
'�쳣���̱���(֧����ҵ��ϵͳʵ��ѡ���쳣���̵Ĺ���)';

comment on column VM_EXCEPTION_RECORD.RULE_OWNER is
'�쳣����������(01:COMFRAME 02:ҵ��ϵͳ)';

comment on column VM_EXCEPTION_RECORD.CREATE_DATE is
'����ʱ��';

comment on column VM_EXCEPTION_RECORD.STATE is
'״̬ U ��ǰ���� E ��������';

comment on column VM_EXCEPTION_RECORD.REGION_ID is
'������Ϣ';

alter table VM_EXCEPTION_RECORD
   add constraint PK_VM_EX_R primary key (EXCEPTION_RECORD_ID);

