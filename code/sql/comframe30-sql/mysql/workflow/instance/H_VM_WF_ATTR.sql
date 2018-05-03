/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: H_VM_WF_ATTR                                          */
/*==============================================================*/
create table H_VM_WF_ATTR
(
   ATTR_ID              numeric(15,0) not null comment '流程实例属性标识历史表',
   WORKFLOW_ID          varchar(25) comment '流程标识',
   QUEUE_ID             varchar(5) comment '流程队列',
   ATTR_CODE            varchar(255) comment '属性编码',
   ATTR_NAME            varchar(255) comment '属性名称',
   ATTR_VALUE           varchar(255) comment '属性值',
   REGION_ID            varchar(6) comment '地域信息',
   CREATE_DATE          datetime comment '创建时间',
   TRANSFER_DATE        datetime comment '移历史事件'
);

alter table H_VM_WF_ATTR
   add primary key (ATTR_ID);

/*==============================================================*/
/* Index: IDX_H_W_A_CV                                          */
/*==============================================================*/
create index IDX_H_W_A_CV on H_VM_WF_ATTR
(
   ATTR_CODE,
   ATTR_VALUE
);

/*==============================================================*/
/* Index: IDX_H_A_WFID                                          */
/*==============================================================*/
create index IDX_H_A_WFID on H_VM_WF_ATTR
(
   WORKFLOW_ID
);

