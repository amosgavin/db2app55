/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:19                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_RULE                                     */
/*==============================================================*/
create table VM_EXCEPTION_RULE
(
   EXCEPTION_RULE_ID    numeric(15,0) not null comment '�쳣���������ʶ(����)',
   EXCEPTION_DESC_CODE  varchar(255) comment '�쳣���α���',
   CURRENT_TEMPLATE_TAG varchar(255) comment '��ǰ������ʵ����ģ�����',
   NEXT_TEMPLATE_TAG    varchar(255) comment '�쳣��������ģ�����',
   EXCEPTION_RULE_REMARKS varchar(255) comment '�쳣����������Ϣ',
   CREATE_DATE          datetime comment '����ʱ��',
   STATE                char(1) comment '״̬ U ��ǰ���� E ��������'
);

alter table VM_EXCEPTION_RULE
   add primary key (EXCEPTION_RULE_ID);

