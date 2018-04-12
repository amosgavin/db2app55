一、活动(营销案管理)
select * from SALE_ORDER_T;--------------------------------------------------工单表
select * from SALE_MAIN_T;---------------------------------------------------批次表
一个工单下有多个批次  SALE_ORDER_T，SALE_MAIN_T通过ORDER_ID关联 
select * from SALE_DETAIL_T;-------------------------------------------------档次表   
一个批次对应多个档次  SALE_MAIN_T的ID对应SALE_DETAIL_T的SALE_ID.
select * from SALE_WEAPON_T;-------------------------------------------------武器表
一个档次对应一个武器  SALE_WEAPON_T的ID关联SALE_DETAIL_T的WEAPON_ID
select * from SALE_TAG_DETAIL_T;---------------------------------------------武器标识
一个武器由多个武器标识组成
select * from WEAPON_TAG_RELA_T;---------------------------------------------武器标识表和武器表的关联表
SALE_TAG_DETAIL_T和SALE_WEAPON_T的关联表。
select * from SALE_CHANNEL_INFO  批次、档次关联渠道表------------------------批次、档次关联渠道表
REL_TYPE字段lev档次关联 act批次关联  和REL_ID对应
select * from SALE_RELAT_CGROUP  批次、档次关联目标客户群--------------------批次、档次关联目标客户群
RELAT_TYPE字段lev档次关联 act批次关联  和RELAT_ID对应
SELECT * FROM SALE_EIT_APPRISE_T; 电子券申告单( remark2)---------------------电子券申告单( remark2)
一个批次关联多种申告单 SALE_EIT_APPRISE_T的MID和SALE_MAIN_T的ID;
remark2字段：
dzj_sgd:电子卷申告单
sjpj_sgd:手机配件申告单
sjzf_sgd:手机支付申告单

SELECT * FROM STOP_SELLING_MAIN_T;--------------------------------------------活动、资费停售主表
SELECT * FROM STOP_SELLING_DETAIL_T;------------------------------------------活动、资费停售明细表 
STOP_SELLING_MAIN_T和STOP_SELLING_DETAIL_T通过MAINID关联  一对多的关系
STOP_SELLING_MAIN_T中的ITEM_TYPE字段：
charge：活动
sale：资费
javascript:parent.doUpload();


二、资费
SELECT * FROM CHARGE_MAIN_T;---------------------------------------------------资费工单表
SELECT * FROM CHARGE_APPLY_MAIN_T;---------------------------------------------资费主表
一对一关系 CHARGE_MAIN_T和CHARGE_APPLY_MAIN_T通过MAIN_ID关联

SELECT * FROM CHARGE_INFO_T;---------------------------------------------------资费明细表
一对多关系 CHARGE_APPLY_MAIN_T和CHARGE_INFO_T通过APPLY_ID关联
SELECT * FROM CHARGE_APPLY_PROD_ATTR_T;----------------------------------------资费项目    
CHARGE_INFO_T和CHARGE_APPLY_PROD_ATTR_T通过CHARGE_ID关联     一对多
SELECT * FROM CHARGE_APPLY_PROD_ATTR_EXT_T;------------------------------------资费信息 
CHARGE_INFO_T和CHARGE_APPLY_PROD_ATTR_EXT_T通过CHARGE_ID关联 一对一
SELECT * FROM CHARGE_FINALLOCATION_SHARE;--------------------------------------财务分摊
CHARGE_INFO_T和CHARGE_FINALLOCATION_SHARE的CHARGE_ID关联     一对多
--SELECT * FROM CHARGE_FINALLOCATION_RULES;------------------------------------产品资费规则
--CHARGE_INFO_T和CHARGE_FINALLOCATION_RULES的CHARGE_ID关联     一对多
SELECT * FROM CHARGE_CHECK;----------------------------------------------------资费对比
SELECT * FROM CHANNEL_RULE_T;--------------------------------------------------产品发布渠道规则
SELECT * FROM CHARGE_DYNAMIC_SUM_T;--------------------------------------------动态损益测算
SELECT * FROM CHARGE_STATIC_SUM_T;---------------------------------------------静态损益测算
SELECT * FROM CHARGE_CONCESS_INFO_T;-------------------------------------------优惠包表（数据，语音,可能隐藏掉）
SELECT * FROM CHARGE_BUSINESS_RULES;-------------------------------------------业务规则
SELECT * FROM CHARGE_CONF_T; --------------------------------------------------配置信息表
SELECT * FROM CHARGE_TEST; ----------------------------------------------------测试信息表

三、权限
SELECT * FROM SECHB.SEC_STAFF; ------------------------------------------------员工表  
SELECT * FROM SECHB.SEC_ORGANIZE;----------------------------------------------机构表
SECHB.SEC_STAFF和SECHB.SEC_ORGANIZE通过ORGANIZE_ID关联  多对一
SELECT * FROM SECHB.SEC_OPERATOR;----------------------------------------------操作员（查流程vm_task operator_id）
SECHB.SEC_OPERATOR和SECHB.SEC_STAFF通过STAFF_ID关联     一对一
SELECT * FROM SECHB.SEC_STATION;-----------------------------------------------岗位表
SELECT * FROM SECHB.SEC_OP_STATION;关联操作员和岗位表 
SELECT * FROM SECHB.SEC_ROLE; -------------------------------------------------角色表
SELECT * FROM SECHB.SEC_AUTHOR;------------------------------------------------授权表
通过OP_STATION和ROLE_ID将关联操作员和岗位表和角色表关联
SELECT * FROM SECHB.SEC_FUNCTION;----------------------------------------------菜单表
SELECT * FROM SECHB.SEC_ROLE_GRANT;--------------------------------------------角色关联菜单表
ROLE_ID角色ROLE_ID、ENT_ID菜单表的FUNC_ID

四、工作流
select * from HBSALE.VM_TEMPLATE;----------------------------------------------工作流模版配置表
select * from HBSALE.VM_SCHEDULE;----------------------------------------------工作流调度表(调度表，流程创建时插入，state=’W’，schedule_server为空；开始调度，state=’W’， schedule_server为调度它的队列编号；停止调度，state=’F’（例如遇到人工节点）；流程执行完成后删除数据。)
select * from HBSALE.VM_WF where workflow_id='HB^11^0000000000000007001';------工作流流程表()
REGION_ID是地市ID
select * from	HBSALE.H_VM_WF;------------------------------------------------工作流流程归档表     
与工作流流程表相似  就是流程结束后才有
select * from HBSALE.VM_TASK where workflow_id='HB^11^0000000000000007001';----工作流任务表
select * from HBSALE.H_VM_TASK;------------------------------------------------工作流任务归档表
select * from HBSALE.VM_TASK_TS;-----------------------------------------------工作流会签任务表


五、其它表
select * from MENU_PRIVE_T;----------------------------------------------------点击工单跳转页面
select * from HBSALE.SALE_STATIC_DATA;-----------------------------------------多选项的表
select * from HBSALE.SALE_STATIC_DATA where CODE_NAME ='template.ProvinceSaleCaseApprove';
select * from HBSALE.SALE_ORDER_T;  
STATE（工单状态1：保存；2：审核中；3：审核通过；4：审核不通过；）
hbsale.%attach%  附件



修改流程：
select * from vm_wf where workflow_object_id='22410';
select * from vm_task where workflow_id='HB^11^0000000000000006762' order by create_date;
delete from vm_task_ts where parent_task_id='HB^11^0000000000000039810'
delete from vm_task where task_id in('HB^11^0000000000000039809','HB^11^0000000000000039810');
update vm_task set state=5 where task_id='HB^11^0000000000000036733'


select * from syscat.tables where tabschema in ('HBSALE','SECHB','BASEHB');---营销平台的表
runstats on table HBSALE.SALE_HPTAG_DETAIL_T;---runstats表
SELECT nextval for  HBSALE_WORK_ID$SEQ  as id FROM SYSIBM.SYSDUMMY1;---查找当前sequence
alter sequence HBSALE_WORK_ID$SEQ restart with 28772  ---重置序号
CREATE SEQUENCE RESOURCE_CHANGE_DETAIL_T$SEQ AS INTEGER;  ---创建sequence
select * from BASEHB.CFG_ID_GENERATOR;   --配置各表sequence的表
find ./ -type f -ctime -2 -exec tar -rvf 20160731.tar {} \;  --查找两天内修改文件、并打成tar