/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:12                           */
/*==============================================================*/


alter table VM_OBJECT_ITEM
   drop primary key;

drop table if exists VM_OBJECT_ITEM;

alter table VM_OBJECT_ITEM_KIND
   drop primary key;

drop table if exists VM_OBJECT_ITEM_KIND;

alter table VM_OBJECT_ITEM_KIND_ELEMENT
   drop primary key;

drop table if exists VM_OBJECT_ITEM_KIND_ELEMENT;

alter table VM_OBJECT_ITEM_RELAT
   drop primary key;

drop table if exists VM_OBJECT_ITEM_RELAT;

alter table VM_OBJECT_ITEM_URL
   drop primary key;

drop table if exists VM_OBJECT_ITEM_URL;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

