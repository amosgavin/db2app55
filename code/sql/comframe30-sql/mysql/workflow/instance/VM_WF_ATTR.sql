/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_WF_ATTR                                            */
/*==============================================================*/
create table VM_WF_ATTR
(
   ATTR_ID              numeric(15,0) not null comment '流程实例属性标识',
   WORKFLOW_ID          varchar(25) comment '流程标识',
   QUEUE_ID             varchar(5) comment '流程队列',
   ATTR_CODE            varchar(255) comment '属性编码',
   ATTR_NAME            varchar(255) comment '属性名称',
   ATTR_VALUE           varchar(255) comment '属性值',
   REGION_ID            varchar(6) comment '地域信息',
   CREATE_DATE          datetime comment '创建时间'
);

alter table VM_WF_ATTR
   add primary key (ATTR_ID);

/*==============================================================*/
/* Index: IDX_A_C_V                                             */
/*==============================================================*/
create index IDX_A_C_V on VM_WF_ATTR
(
   ATTR_CODE,
   ATTR_VALUE
);

/*==============================================================*/
/* Index: IDX_W_A_WID                                           */
/*==============================================================*/
create index IDX_W_A_WID on VM_WF_ATTR
(
   WORKFLOW_ID
);

