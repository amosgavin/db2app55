/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_WF_ATTR                                            */
/*==============================================================*/
create table VM_WF_ATTR  (
   ATTR_ID              BIGINT                    not null,
   WORKFLOW_ID          VARCHAR(25),
   QUEUE_ID             VARCHAR(5),
   ATTR_CODE            VARCHAR(255),
   ATTR_NAME            VARCHAR(255),
   ATTR_VALUE           VARCHAR(255),
   REGION_ID            VARCHAR(6),
   CREATE_DATE          TIMESTAMP
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

