/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: H_VM_WF_ATTR                                          */
/*==============================================================*/
create table H_VM_WF_ATTR
(
   ATTR_ID              numeric(15,0) not null comment '����ʵ�����Ա�ʶ��ʷ��',
   WORKFLOW_ID          varchar(25) comment '���̱�ʶ',
   QUEUE_ID             varchar(5) comment '���̶���',
   ATTR_CODE            varchar(255) comment '���Ա���',
   ATTR_NAME            varchar(255) comment '��������',
   ATTR_VALUE           varchar(255) comment '����ֵ',
   REGION_ID            varchar(6) comment '������Ϣ',
   CREATE_DATE          datetime comment '����ʱ��',
   TRANSFER_DATE        datetime comment '����ʷ�¼�'
);

alter table H_VM_WF_ATTR
   add primary key (ATTR_ID);

/*==============================================================*/
/* Index: IDX_H_W_A_CV                                          */
/*==============================================================*/
create index IDX_H_W_A_CV on H_VM_WF_ATTR
(
   ATTR_CODE,
   ATTR_VALUE
);

/*==============================================================*/
/* Index: IDX_H_A_WFID                                          */
/*==============================================================*/
create index IDX_H_A_WFID on H_VM_WF_ATTR
(
   WORKFLOW_ID
);

