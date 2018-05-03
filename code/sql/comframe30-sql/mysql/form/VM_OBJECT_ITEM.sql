/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:12                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM                                        */
/*==============================================================*/
create table VM_OBJECT_ITEM
(
   OBJECT_ITEM_ID       numeric(15,0) not null comment '对象单元编号',
   CODE                 varchar(255) comment '编码',
   NAME                 varchar(255) comment '名称',
   DESCRIPTION          varchar(4000) comment '描述',
   ITEM_TYPE            varchar(255) comment '单元类型',
   SORT_BY              numeric(3,0) comment '排序方式',
   BUSINESS_DOMAIN_ID   numeric(15,0) comment '所属业务区域',
   BUSINESS_TYPE_ID     numeric(15,0) comment '业务类型',
   CREATER              numeric(15,0) comment '创建用户',
   CHECKER              numeric(15,0) comment '锁定用户',
   ISLOCK               char(1) comment '锁定状态',
   STATE                char(1) comment '状态',
   REMARKS              varchar(255) comment '备注',
   CREATE_DATE          datetime comment '创建时间',
   MODIFY_DATE          datetime comment '修改时间',
   URL                  varchar(255) comment '页面块指向业务页面的URL',
   DATA_COMMIT_SV       varchar(255) comment '回单数据提交服务',
   DATA_COMMIT_SV_FUNCTION varchar(255) comment '回单数据提交服务之方法',
   FINISHCODE_SV        varchar(255) comment '回单结果服务',
   FINISHCODE_SV_FUNCTION varchar(255) comment '回单结果服务之方法',
   FINISHCODE_DS        varchar(255) comment '回单结果DS',
   FINISHCODE_DS_PARAM  varchar(255) comment '回单结果DS参数'
);

alter table VM_OBJECT_ITEM
   add primary key (OBJECT_ITEM_ID);

