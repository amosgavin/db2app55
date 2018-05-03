/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:36                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_RECORD                                   */
/*==============================================================*/
create table VM_EXCEPTION_RECORD
(
   EXCEPTION_RECORD_ID  numeric(15,0) not null comment '�쳣��¼��ʶ(����)',
   WORKFLOW_ID          varchar(25) comment '������ʵ�����',
   QUEUE_ID             varchar(5) comment '���̶���',
   TASK_ID              varchar(25) comment '����������ʵ��ID',
   EXCEPTION_CODE       varchar(255) not null comment '�쳣ԭ��',
   EXCEPTION_REMARKS    varchar(255) comment '�쳣������Ϣ',
   NEXT_TEMPLATE_TAG    varchar(255) comment '�쳣���̱���(֧����ҵ��ϵͳʵ��ѡ���쳣���̵Ĺ���)',
   RULE_OWNER           varchar(2) comment '�쳣����������(01:COMFRAME 02:ҵ��ϵͳ)',
   CREATE_DATE          datetime comment '����ʱ��',
   STATE                char(1) comment '״̬ U ��ǰ���� E ��������',
   REGION_ID            varchar(6) comment '������Ϣ'
);

alter table VM_EXCEPTION_RECORD
   add primary key (EXCEPTION_RECORD_ID);

