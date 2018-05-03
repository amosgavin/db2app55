/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_WF_ATTR                                            */
/*==============================================================*/
create table VM_WF_ATTR
(
   ATTR_ID              numeric(15,0) not null comment '����ʵ�����Ա�ʶ',
   WORKFLOW_ID          varchar(25) comment '���̱�ʶ',
   QUEUE_ID             varchar(5) comment '���̶���',
   ATTR_CODE            varchar(255) comment '���Ա���',
   ATTR_NAME            varchar(255) comment '��������',
   ATTR_VALUE           varchar(255) comment '����ֵ',
   REGION_ID            varchar(6) comment '������Ϣ',
   CREATE_DATE          datetime comment '����ʱ��'
);

alter table VM_WF_ATTR
   add primary key (ATTR_ID);

/*==============================================================*/
/* Index: IDX_A_C_V                                             */
/*==============================================================*/
create index IDX_A_C_V on VM_WF_ATTR
(
   ATTR_CODE,
   ATTR_VALUE
);

/*==============================================================*/
/* Index: IDX_W_A_WID                                           */
/*==============================================================*/
create index IDX_W_A_WID on VM_WF_ATTR
(
   WORKFLOW_ID
);

