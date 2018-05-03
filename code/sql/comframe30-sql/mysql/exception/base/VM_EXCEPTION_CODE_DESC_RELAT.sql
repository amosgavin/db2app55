/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:19                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_CODE_DESC_RELAT                          */
/*==============================================================*/
create table VM_EXCEPTION_CODE_DESC_RELAT
(
   EXCEPTION_CODE       varchar(255) not null comment '�쳣ԭ�����',
   EXCEPTION_DESC_CODE  varchar(255) not null comment '�쳣���α���',
   CREATE_DATE          datetime comment '����ʱ��',
   STATE                char(1) comment '״̬ U ��ǰ���� E ��������'
);

alter table VM_EXCEPTION_CODE_DESC_RELAT
   add primary key (EXCEPTION_CODE, EXCEPTION_DESC_CODE);

