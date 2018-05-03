/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 12:44:45                           */
/*==============================================================*/


drop sequence H_VM_TEMPLATE$SEQ;

drop sequence VM_ALARM_CONFIG$SEQ;

drop sequence VM_ENGINE_TEMPLATE_VERSION$SEQ;

drop sequence VM_EXCEPTION_CODE$SEQ;

drop sequence VM_EXCEPTION_RULE$SEQ;

drop sequence VM_OBJ_ITEM$SEQ;

drop sequence VM_OBJ_ITEM_KIND$SEQ;

drop sequence VM_OBJ_ITEM_KIND_ELEMENT$SEQ;

drop sequence VM_OBJ_ITEM_RELAT$SEQ;

drop sequence VM_TEMPLATE_VERSION$SEQ;

drop sequence VM_QUEUE_SERVER_REGIST$SEQ;

create sequence VM_QUEUE_SERVER_REGIST$SEQ
increment by 1
start with 1
 maxvalue 100000000000000
 minvalue 1;

create sequence H_VM_TEMPLATE$SEQ
increment by 1
start with 1
 maxvalue 100000000000000
 minvalue 1;

create sequence VM_ALARM_CONFIG$SEQ
increment by 1
start with 1
 maxvalue 100000000000000
 minvalue 1;

create sequence VM_ENGINE_TEMPLATE_VERSION$SEQ
increment by 1
start with 1
 maxvalue 100000000000000
 minvalue 1;

create sequence VM_EXCEPTION_CODE$SEQ
increment by 1
start with 1000
 maxvalue 100000000000000
 minvalue 1;

create sequence VM_EXCEPTION_RULE$SEQ
increment by 1
start with 1
 maxvalue 100000000000000
 minvalue 1;

create sequence VM_OBJ_ITEM$SEQ
increment by 1
start with 1000
 maxvalue 100000000000
 minvalue 1;

create sequence VM_OBJ_ITEM_KIND$SEQ
increment by 1
start with 1000
 maxvalue 100000000000
 minvalue 1;

create sequence VM_OBJ_ITEM_KIND_ELEMENT$SEQ
increment by 1
start with 1000
 maxvalue 100000000000
 minvalue 1;

create sequence VM_OBJ_ITEM_RELAT$SEQ
increment by 1
start with 1000
 maxvalue 100000000000
 minvalue 1;

create sequence VM_TEMPLATE_VERSION$SEQ
increment by 1
start with 1
 maxvalue 100000000000000
 minvalue 1;

