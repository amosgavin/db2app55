һ���(Ӫ��������)
select * from SALE_ORDER_T;--------------------------------------------------������
select * from SALE_MAIN_T;---------------------------------------------------���α�
һ���������ж������  SALE_ORDER_T��SALE_MAIN_Tͨ��ORDER_ID���� 
select * from SALE_DETAIL_T;-------------------------------------------------���α�   
һ�����ζ�Ӧ�������  SALE_MAIN_T��ID��ӦSALE_DETAIL_T��SALE_ID.
select * from SALE_WEAPON_T;-------------------------------------------------������
һ�����ζ�Ӧһ������  SALE_WEAPON_T��ID����SALE_DETAIL_T��WEAPON_ID
select * from SALE_TAG_DETAIL_T;---------------------------------------------������ʶ
һ�������ɶ��������ʶ���
select * from WEAPON_TAG_RELA_T;---------------------------------------------������ʶ���������Ĺ�����
SALE_TAG_DETAIL_T��SALE_WEAPON_T�Ĺ�����
select * from SALE_CHANNEL_INFO  ���Ρ����ι���������------------------------���Ρ����ι���������
REL_TYPE�ֶ�lev���ι��� act���ι���  ��REL_ID��Ӧ
select * from SALE_RELAT_CGROUP  ���Ρ����ι���Ŀ��ͻ�Ⱥ--------------------���Ρ����ι���Ŀ��ͻ�Ⱥ
RELAT_TYPE�ֶ�lev���ι��� act���ι���  ��RELAT_ID��Ӧ
SELECT * FROM SALE_EIT_APPRISE_T; ����ȯ��浥( remark2)---------------------����ȯ��浥( remark2)
һ�����ι���������浥 SALE_EIT_APPRISE_T��MID��SALE_MAIN_T��ID;
remark2�ֶΣ�
dzj_sgd:���Ӿ���浥
sjpj_sgd:�ֻ������浥
sjzf_sgd:�ֻ�֧����浥

SELECT * FROM STOP_SELLING_MAIN_T;--------------------------------------------����ʷ�ͣ������
SELECT * FROM STOP_SELLING_DETAIL_T;------------------------------------------����ʷ�ͣ����ϸ�� 
STOP_SELLING_MAIN_T��STOP_SELLING_DETAIL_Tͨ��MAINID����  һ�Զ�Ĺ�ϵ
STOP_SELLING_MAIN_T�е�ITEM_TYPE�ֶΣ�
charge���
sale���ʷ�
javascript:parent.doUpload();


�����ʷ�
SELECT * FROM CHARGE_MAIN_T;---------------------------------------------------�ʷѹ�����
SELECT * FROM CHARGE_APPLY_MAIN_T;---------------------------------------------�ʷ�����
һ��һ��ϵ CHARGE_MAIN_T��CHARGE_APPLY_MAIN_Tͨ��MAIN_ID����

SELECT * FROM CHARGE_INFO_T;---------------------------------------------------�ʷ���ϸ��
һ�Զ��ϵ CHARGE_APPLY_MAIN_T��CHARGE_INFO_Tͨ��APPLY_ID����
SELECT * FROM CHARGE_APPLY_PROD_ATTR_T;----------------------------------------�ʷ���Ŀ    
CHARGE_INFO_T��CHARGE_APPLY_PROD_ATTR_Tͨ��CHARGE_ID����     һ�Զ�
SELECT * FROM CHARGE_APPLY_PROD_ATTR_EXT_T;------------------------------------�ʷ���Ϣ 
CHARGE_INFO_T��CHARGE_APPLY_PROD_ATTR_EXT_Tͨ��CHARGE_ID���� һ��һ
SELECT * FROM CHARGE_FINALLOCATION_SHARE;--------------------------------------�����̯
CHARGE_INFO_T��CHARGE_FINALLOCATION_SHARE��CHARGE_ID����     һ�Զ�
--SELECT * FROM CHARGE_FINALLOCATION_RULES;------------------------------------��Ʒ�ʷѹ���
--CHARGE_INFO_T��CHARGE_FINALLOCATION_RULES��CHARGE_ID����     һ�Զ�
SELECT * FROM CHARGE_CHECK;----------------------------------------------------�ʷѶԱ�
SELECT * FROM CHANNEL_RULE_T;--------------------------------------------------��Ʒ������������
SELECT * FROM CHARGE_DYNAMIC_SUM_T;--------------------------------------------��̬�������
SELECT * FROM CHARGE_STATIC_SUM_T;---------------------------------------------��̬�������
SELECT * FROM CHARGE_CONCESS_INFO_T;-------------------------------------------�Żݰ������ݣ�����,�������ص���
SELECT * FROM CHARGE_BUSINESS_RULES;-------------------------------------------ҵ�����
SELECT * FROM CHARGE_CONF_T; --------------------------------------------------������Ϣ��
SELECT * FROM CHARGE_TEST; ----------------------------------------------------������Ϣ��

����Ȩ��
SELECT * FROM SECHB.SEC_STAFF; ------------------------------------------------Ա����  
SELECT * FROM SECHB.SEC_ORGANIZE;----------------------------------------------������
SECHB.SEC_STAFF��SECHB.SEC_ORGANIZEͨ��ORGANIZE_ID����  ���һ
SELECT * FROM SECHB.SEC_OPERATOR;----------------------------------------------����Ա��������vm_task operator_id��
SECHB.SEC_OPERATOR��SECHB.SEC_STAFFͨ��STAFF_ID����     һ��һ
SELECT * FROM SECHB.SEC_STATION;-----------------------------------------------��λ��
SELECT * FROM SECHB.SEC_OP_STATION;��������Ա�͸�λ�� 
SELECT * FROM SECHB.SEC_ROLE; -------------------------------------------------��ɫ��
SELECT * FROM SECHB.SEC_AUTHOR;------------------------------------------------��Ȩ��
ͨ��OP_STATION��ROLE_ID����������Ա�͸�λ��ͽ�ɫ�����
SELECT * FROM SECHB.SEC_FUNCTION;----------------------------------------------�˵���
SELECT * FROM SECHB.SEC_ROLE_GRANT;--------------------------------------------��ɫ�����˵���
ROLE_ID��ɫROLE_ID��ENT_ID�˵����FUNC_ID

�ġ�������
select * from HBSALE.VM_TEMPLATE;----------------------------------------------������ģ�����ñ�
select * from HBSALE.VM_SCHEDULE;----------------------------------------------���������ȱ�(���ȱ����̴���ʱ���룬state=��W����schedule_serverΪ�գ���ʼ���ȣ�state=��W���� schedule_serverΪ�������Ķ��б�ţ�ֹͣ���ȣ�state=��F�������������˹��ڵ㣩������ִ����ɺ�ɾ�����ݡ�)
select * from HBSALE.VM_WF where workflow_id='HB^11^0000000000000007001';------���������̱�()
REGION_ID�ǵ���ID
select * from	HBSALE.H_VM_WF;------------------------------------------------���������̹鵵��     
�빤�������̱�����  �������̽��������
select * from HBSALE.VM_TASK where workflow_id='HB^11^0000000000000007001';----�����������
select * from HBSALE.H_VM_TASK;------------------------------------------------����������鵵��
select * from HBSALE.VM_TASK_TS;-----------------------------------------------��������ǩ�����


�塢������
select * from MENU_PRIVE_T;----------------------------------------------------���������תҳ��
select * from HBSALE.SALE_STATIC_DATA;-----------------------------------------��ѡ��ı�
select * from HBSALE.SALE_STATIC_DATA where CODE_NAME ='template.ProvinceSaleCaseApprove';
select * from HBSALE.SALE_ORDER_T;  
STATE������״̬1�����棻2������У�3�����ͨ����4����˲�ͨ������
hbsale.%attach%  ����



�޸����̣�
select * from vm_wf where workflow_object_id='22410';
select * from vm_task where workflow_id='HB^11^0000000000000006762' order by create_date;
delete from vm_task_ts where parent_task_id='HB^11^0000000000000039810'
delete from vm_task where task_id in('HB^11^0000000000000039809','HB^11^0000000000000039810');
update vm_task set state=5 where task_id='HB^11^0000000000000036733'


select * from syscat.tables where tabschema in ('HBSALE','SECHB','BASEHB');---Ӫ��ƽ̨�ı�
runstats on table HBSALE.SALE_HPTAG_DETAIL_T;---runstats��
SELECT nextval for  HBSALE_WORK_ID$SEQ  as id FROM SYSIBM.SYSDUMMY1;---���ҵ�ǰsequence
alter sequence HBSALE_WORK_ID$SEQ restart with 28772  ---�������
CREATE SEQUENCE RESOURCE_CHANGE_DETAIL_T$SEQ AS INTEGER;  ---����sequence
select * from BASEHB.CFG_ID_GENERATOR;   --���ø���sequence�ı�
find ./ -type f -ctime -2 -exec tar -rvf 20160731.tar {} \;  --�����������޸��ļ��������tar