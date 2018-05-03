/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_QUEUE_CONFIG                                       */
/*==============================================================*/
create table VM_QUEUE_CONFIG
(
   QUEUE_ID             varchar(5) not null comment '队列标识',
   QUEUE_TYPE           varchar(255) not null comment '队列类型',
   DATASOURE            varchar(30) comment '数据源名称,可以配置so{center}等',
   SPLIT_QUEUE          char(1) comment '是否按队列标识分表(Y:分,N或不填不:不分)',
   SPLIT_REGION         char(1) comment '是否按队地域分表(Y:分,N或不填不:不分)',
   TIME_INTERVAL        numeric(15,0) comment '时间间隔(单位:毫秒)',
   FETCH_NUM            numeric(4,0) comment '每次获取条数',
   STATE                char(1) comment 'U:有效,E:无效',
   REMARK               varchar(255) comment '备注'
);

alter table VM_QUEUE_CONFIG
   add primary key (QUEUE_ID, QUEUE_TYPE);

