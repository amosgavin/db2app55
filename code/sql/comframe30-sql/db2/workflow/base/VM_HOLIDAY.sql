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
'节假日表';

comment on column VM_HOLIDAY.HOLIDAY is
'节假日 yyyy-mm-dd';

