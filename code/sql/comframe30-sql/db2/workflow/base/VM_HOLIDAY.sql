/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_HOLIDAY                                            */
/*==============================================================*/
create table VM_HOLIDAY  (
   HOLIDAY              DATE                            not null
);

comment on table VM_HOLIDAY is
'�ڼ��ձ�';

comment on column VM_HOLIDAY.HOLIDAY is
'�ڼ��� yyyy-mm-dd';

