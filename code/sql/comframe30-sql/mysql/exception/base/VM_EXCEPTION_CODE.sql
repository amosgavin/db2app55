/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:19                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_CODE                                     */
/*==============================================================*/
create table VM_EXCEPTION_CODE
(
   EXCEPTION_CODE       varchar(255) not null comment '�쳣ԭ�����',
   EXCEPTION_NAME       varchar(255) comment '�쳣ԭ������',
   WORKFLOW_OBJECT_TYPE varchar(255) comment '�����������������',
   TASK_TAG             varchar(255),
   EXCEPTION_TYPE       varchar(255),
   CREATE_DATE          datetime comment '����ʱ��',
   STATE                char(1) comment '״̬ U ��ǰ���� E ��������'
);

alter table VM_EXCEPTION_CODE
   add primary key (EXCEPTION_CODE);

