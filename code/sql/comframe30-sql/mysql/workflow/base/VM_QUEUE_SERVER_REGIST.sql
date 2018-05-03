/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/9/8 21:25:49                            */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_QUEUE_SERVER_REGIST                                */
/*==============================================================*/
create table VM_QUEUE_SERVER_REGIST
(
   REGIST_ID            numeric(15,0) not null,
   PROCESS_ID           varchar(255) comment '���̱�ʶ',
   HOST_IP              varchar(255) comment '����IP',
   HOST_NAME            varchar(255) comment '��������',
   QUEUE_ID             varchar(5) comment '���б�ʶ',
   QUEUE_TYPE           varchar(255) comment '�������ͣ�-t����ֵ',
   MOD_PARAM		numeric(3,0) comment 'ģ��-m����ֵ',
   MOD_VALUE            varchar(255) comment 'ģֵ��-v����ֵ',
   REGION_ID            varchar(6) comment '���б�ʶ��-r����ֵ',
   STATE                char(1) comment '״̬',
   REGIST_DATE          datetime comment 'ע��ʱ��',
   REMARKS              varchar(255) comment '��ע'
);

alter table VM_QUEUE_SERVER_REGIST comment '���з�����ע���';

alter table VM_QUEUE_SERVER_REGIST
   add primary key (REGIST_ID);

