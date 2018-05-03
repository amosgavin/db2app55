/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_WF_ATTR                                            */
/*==============================================================*/
create table VM_WF_ATTR  (
   ATTR_ID              NUMBER(15,0)                    not null,
   WORKFLOW_ID          VARCHAR2(25),
   QUEUE_ID             VARCHAR2(5),
   ATTR_CODE            VARCHAR2(255),
   ATTR_NAME            VARCHAR2(255),
   ATTR_VALUE           VARCHAR2(255),
   REGION_ID            VARCHAR2(6),
   CREATE_DATE          DATE
);

comment on column VM_WF_ATTR.ATTR_ID is
'����ʵ�����Ա�ʶ';

comment on column VM_WF_ATTR.WORKFLOW_ID is
'���̱�ʶ';

comment on column VM_WF_ATTR.QUEUE_ID is
'���̶���';

comment on column VM_WF_ATTR.ATTR_CODE is
'���Ա���';

comment on column VM_WF_ATTR.ATTR_NAME is
'��������';

comment on column VM_WF_ATTR.ATTR_VALUE is
'����ֵ';

comment on column VM_WF_ATTR.REGION_ID is
'������Ϣ';

comment on column VM_WF_ATTR.CREATE_DATE is
'����ʱ��';

alter table VM_WF_ATTR
   add constraint PK_VM_WF_A primary key (ATTR_ID);

/*==============================================================*/
/* Index: IDX_A_C_V                                             */
/*==============================================================*/
create index IDX_A_C_V on VM_WF_ATTR (
   ATTR_CODE ASC,
   ATTR_VALUE ASC
);

/*==============================================================*/
/* Index: IDX_W_A_WID                                           */
/*==============================================================*/
create index IDX_W_A_WID on VM_WF_ATTR (
   WORKFLOW_ID ASC
);

