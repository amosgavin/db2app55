/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:19                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_DESC                                     */
/*==============================================================*/
create table VM_EXCEPTION_DESC
(
   EXCEPTION_DESC_CODE  varchar(255) not null comment '�쳣���α���',
   EXCEPTION_DESC_NAME  varchar(255) comment '�쳣��������',
   EXCEPTION_DESC_TYPE  char(1) comment '�쳣��������(A:����ȫ���쳣ԭ�����,B:ֻ������һ���쳣ԭ��)',
   CREATE_DATE          datetime comment '����ʱ��',
   STATE                char(1) comment '״̬ U ��ǰ���� E ��������'
);

alter table VM_EXCEPTION_DESC
   add primary key (EXCEPTION_DESC_CODE);

