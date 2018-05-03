/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_QUEUE_CONFIG                                       */
/*==============================================================*/
create table VM_QUEUE_CONFIG
(
   QUEUE_ID             varchar(5) not null comment '���б�ʶ',
   QUEUE_TYPE           varchar(255) not null comment '��������',
   DATASOURE            varchar(30) comment '����Դ����,��������so{center}��',
   SPLIT_QUEUE          char(1) comment '�Ƿ񰴶��б�ʶ�ֱ�(Y:��,N���:����)',
   SPLIT_REGION         char(1) comment '�Ƿ񰴶ӵ���ֱ�(Y:��,N���:����)',
   TIME_INTERVAL        numeric(15,0) comment 'ʱ����(��λ:����)',
   FETCH_NUM            numeric(4,0) comment 'ÿ�λ�ȡ����',
   STATE                char(1) comment 'U:��Ч,E:��Ч',
   REMARK               varchar(255) comment '��ע'
);

alter table VM_QUEUE_CONFIG
   add primary key (QUEUE_ID, QUEUE_TYPE);

