/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:09:07                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM                                        */
/*==============================================================*/
create table VM_OBJECT_ITEM  (
   OBJECT_ITEM_ID       BIGINT                      not null,
   CODE                 VARCHAR(255),
   NAME                 VARCHAR(255),
   DESCRIPTION          VARCHAR(4000),
   ITEM_TYPE            VARCHAR(255),
   SORT_BY              INTEGER,
   BUSINESS_DOMAIN_ID   BIGINT,
   BUSINESS_TYPE_ID     BIGINT,
   CREATER              BIGINT,
   CHECKER              BIGINT,
   ISLOCK               CHAR(1),
   STATE                CHAR(1),
   REMARKS              VARCHAR(255),
   CREATE_DATE          TIMESTAMP,
   MODIFY_DATE          TIMESTAMP,
   URL                  VARCHAR(255),
   DATA_COMMIT_SV       VARCHAR(255),
   DATA_COMMIT_SV_FUNCTION VARCHAR(255),
   FINISHCODE_SV        VARCHAR(255),
   FINISHCODE_SV_FUNCTION VARCHAR(255),
   FINISHCODE_DS        VARCHAR(255),
   FINISHCODE_DS_PARAM  VARCHAR(255)
);

comment on column VM_OBJECT_ITEM.OBJECT_ITEM_ID is
'对象单元编号';

comment on column VM_OBJECT_ITEM.CODE is
'编码';

comment on column VM_OBJECT_ITEM.NAME is
'名称';

comment on column VM_OBJECT_ITEM.DESCRIPTION is
'描述';

comment on column VM_OBJECT_ITEM.ITEM_TYPE is
'单元类型';

comment on column VM_OBJECT_ITEM.SORT_BY is
'排序方式';

comment on column VM_OBJECT_ITEM.BUSINESS_DOMAIN_ID is
'所属业务区域';

comment on column VM_OBJECT_ITEM.BUSINESS_TYPE_ID is
'业务类型';

comment on column VM_OBJECT_ITEM.CREATER is
'创建用户';

comment on column VM_OBJECT_ITEM.CHECKER is
'锁定用户';

comment on column VM_OBJECT_ITEM.ISLOCK is
'锁定状态';

comment on column VM_OBJECT_ITEM.STATE is
'状态';

comment on column VM_OBJECT_ITEM.REMARKS is
'备注';

comment on column VM_OBJECT_ITEM.CREATE_DATE is
'创建时间';

comment on column VM_OBJECT_ITEM.MODIFY_DATE is
'修改时间';

comment on column VM_OBJECT_ITEM.URL is
'页面块指向业务页面的URL';

comment on column VM_OBJECT_ITEM.DATA_COMMIT_SV is
'回单数据提交服务';

comment on column VM_OBJECT_ITEM.DATA_COMMIT_SV_FUNCTION is
'回单数据提交服务之方法';

comment on column VM_OBJECT_ITEM.FINISHCODE_SV is
'回单结果服务';

comment on column VM_OBJECT_ITEM.FINISHCODE_SV_FUNCTION is
'回单结果服务之方法';

comment on column VM_OBJECT_ITEM.FINISHCODE_DS is
'回单结果DS';

comment on column VM_OBJECT_ITEM.FINISHCODE_DS_PARAM is
'回单结果DS参数';

alter table VM_OBJECT_ITEM
   add constraint PK_OBJECT_ITEM primary key (OBJECT_ITEM_ID);

