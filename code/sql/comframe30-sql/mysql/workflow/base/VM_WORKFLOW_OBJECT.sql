/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_WORKFLOW_OBJECT                                    */
/*==============================================================*/
create table VM_WORKFLOW_OBJECT
(
   CODE                 varchar(255) not null comment '����������������',
   NAME                 varchar(255) not null comment '�����������������',
   STATE                char(1) not null comment '״̬',
   CREATE_DATE          datetime comment '����ʱ��',
   REMARK               varchar(255) comment '��ע'
);

alter table VM_WORKFLOW_OBJECT comment '�������������';

alter table VM_WORKFLOW_OBJECT
   add primary key (CODE);

