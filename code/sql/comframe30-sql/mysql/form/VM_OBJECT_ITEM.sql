/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:12                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM                                        */
/*==============================================================*/
create table VM_OBJECT_ITEM
(
   OBJECT_ITEM_ID       numeric(15,0) not null comment '����Ԫ���',
   CODE                 varchar(255) comment '����',
   NAME                 varchar(255) comment '����',
   DESCRIPTION          varchar(4000) comment '����',
   ITEM_TYPE            varchar(255) comment '��Ԫ����',
   SORT_BY              numeric(3,0) comment '����ʽ',
   BUSINESS_DOMAIN_ID   numeric(15,0) comment '����ҵ������',
   BUSINESS_TYPE_ID     numeric(15,0) comment 'ҵ������',
   CREATER              numeric(15,0) comment '�����û�',
   CHECKER              numeric(15,0) comment '�����û�',
   ISLOCK               char(1) comment '����״̬',
   STATE                char(1) comment '״̬',
   REMARKS              varchar(255) comment '��ע',
   CREATE_DATE          datetime comment '����ʱ��',
   MODIFY_DATE          datetime comment '�޸�ʱ��',
   URL                  varchar(255) comment 'ҳ���ָ��ҵ��ҳ���URL',
   DATA_COMMIT_SV       varchar(255) comment '�ص������ύ����',
   DATA_COMMIT_SV_FUNCTION varchar(255) comment '�ص������ύ����֮����',
   FINISHCODE_SV        varchar(255) comment '�ص��������',
   FINISHCODE_SV_FUNCTION varchar(255) comment '�ص��������֮����',
   FINISHCODE_DS        varchar(255) comment '�ص����DS',
   FINISHCODE_DS_PARAM  varchar(255) comment '�ص����DS����'
);

alter table VM_OBJECT_ITEM
   add primary key (OBJECT_ITEM_ID);

