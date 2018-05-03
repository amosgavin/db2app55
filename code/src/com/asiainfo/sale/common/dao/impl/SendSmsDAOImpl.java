package com.asiainfo.sale.common.dao.impl;

import com.asiainfo.sale.common.dao.interfaces.ISendSmsDAO;
import com.asiainfo.sale.common.bo.BOApplyInfoBean;
import com.asiainfo.sale.common.bo.BOApplyInfoEngine;
import com.asiainfo.sale.common.bo.BOStaffSmsInfoEngine;
import com.asiainfo.sale.common.ivalues.IBOApplyInfoValue;
import com.asiainfo.sale.common.ivalues.IBOStaffSmsInfoValue;
import com.asiainfo.sale.common.bo.BOWorkflowInfoEngine;
import com.asiainfo.sale.common.ivalues.IBOWorkflowInfoValue;

import java.util.HashMap;

public class SendSmsDAOImpl implements ISendSmsDAO{
	
	/*
	 * 说明：获取工单申请名
	 * 参数：
	 * wid:工单ID
	 * */
    public IBOApplyInfoValue getApplyName(String wid)throws RuntimeException,Exception{
    	HashMap<String,String> parameter = new HashMap<String,String>();
    	StringBuffer sqlstr = new StringBuffer();
    	sqlstr.append(" SELECT recordId, ");
    	sqlstr.append("        apply_name, ");
    	sqlstr.append("        principal, ");
    	sqlstr.append("        create_time, ");
    	sqlstr.append("        create_staff_name, ");
    	sqlstr.append("        orgName ");
    	sqlstr.append("   FROM (SELECT id recordId, ");
    	sqlstr.append("                apply_name, ");
    	sqlstr.append("                principal, ");
    	sqlstr.append("                create_time, ");
    	sqlstr.append("                sta.staff_name create_staff_name, ");
    	sqlstr.append("                (SELECT org.organize_name ");
    	sqlstr.append("                   FROM SECHB.sec_organize org ");
    	sqlstr.append("                  WHERE org.organize_id = ");
    	sqlstr.append("                           substr (to_char (sta.organize_id), 1, 2)) ");
    	sqlstr.append("                   orgName ");
    	sqlstr.append("           FROM SALE_WEAPON_MAIN_T sw, ");
    	sqlstr.append("                SECHB.SEC_STAFF sta, ");
    	sqlstr.append("                SECHB.SEC_OPERATOR ope ");
    	sqlstr.append("          WHERE sw.PRINCIPAL = to_char (ope.OPERATOR_ID) ");
    	sqlstr.append("                AND to_char (ope.STAFF_ID) = to_char (sta.STAFF_ID) ");
    	sqlstr.append(" and id="+wid+" ");
    	sqlstr.append("         UNION ALL ");
    	sqlstr.append("         SELECT order_id recordId, ");
    	sqlstr.append("                order_name apply_name, ");
    	sqlstr.append("                principle, ");
    	sqlstr.append("                so.create_date create_time, ");
    	sqlstr.append("                so.prop_name create_staff_name, ");
    	sqlstr.append("                (SELECT org.organize_name ");
    	sqlstr.append("                   FROM SECHB.sec_organize org ");
    	sqlstr.append("                  WHERE org.organize_id = ");
    	sqlstr.append("                           substr (so.org_id, 1, 2)) ");
    	sqlstr.append("                   orgName ");
    	sqlstr.append("           FROM sale_order_t so ");
    	sqlstr.append(" where order_id="+wid+" ");
    	sqlstr.append("         UNION ALL ");
    	sqlstr.append("         SELECT MAIN_ID recordId, ");
    	sqlstr.append("                REAMRK_1 apply_name, ");
    	sqlstr.append("                PRINCIPLE principal, ");
    	sqlstr.append("                CREATE_TIME, ");
    	sqlstr.append("                sta.staff_name create_staff_name, ");
    	sqlstr.append("                (SELECT org.organize_name ");
    	sqlstr.append("                   FROM SECHB.sec_organize org ");
    	sqlstr.append("                  WHERE org.organize_id = ");
    	sqlstr.append("                           substr (to_char (sta.organize_id), 1, 2)) ");
    	sqlstr.append("                   orgName ");
    	sqlstr.append("           FROM CHARGE_MAIN_T sm, ");
    	sqlstr.append("                SECHB.SEC_STAFF sta, ");
    	sqlstr.append("                SECHB.SEC_OPERATOR ope ");
    	sqlstr.append("          WHERE sm.principle = to_char (ope.OPERATOR_ID) ");
    	sqlstr.append(" and MAIN_ID="+wid+" ");
    	sqlstr.append("                AND to_char (sta.STAFF_ID) = to_char (ope.STAFF_ID)");
    	sqlstr.append("         UNION ALL ");
        sqlstr.append(" SELECT to_char(sm.ACCESS_ID) recordId,sm.APPLY_NAME apply_name, to_char(sm.principle) principal,sm.create_time APPLY_TIME, sta.staff_name create_staff_name, ");
        sqlstr.append(" (SELECT org.organize_name FROM SECHB.sec_organize org WHERE org.organize_id =substr (to_char (sta.organize_id), 1, 2)) orgName ");
        sqlstr.append(" from HBSALE.ACCESS_CHANGE_T sm,SECHB.SEC_STAFF sta,SECHB.SEC_OPERATOR ope ");
        sqlstr.append(" WHERE sm.principle = to_char (ope.OPERATOR_ID) and ACCESS_ID= " +wid+" ");
        sqlstr.append(" AND to_char (sta.STAFF_ID) = to_char (ope.STAFF_ID)");
    	sqlstr.append("         UNION ALL ");
    	sqlstr.append("         SELECT id recordId, ");
    	sqlstr.append("                apply_name, ");
    	sqlstr.append("                principal, ");
    	sqlstr.append("                create_time, ");
    	sqlstr.append("                sta.staff_name create_staff_name, ");
    	sqlstr.append("                (SELECT org.organize_name ");
    	sqlstr.append("                   FROM SECHB.sec_organize org ");
    	sqlstr.append("                  WHERE org.organize_id = ");
    	sqlstr.append("                           substr (to_char (sta.organize_id), 1, 2)) ");
    	sqlstr.append("                   orgName ");
    	sqlstr.append("           FROM SALE_BATCH_PRESTORE_T sm, SECHB.SEC_STAFF sta, SECHB.SEC_OPERATOR ope ");
    	sqlstr.append("          WHERE sm.PRINCIPAL = to_char (ope.OPERATOR_ID) ");
    	sqlstr.append("                AND to_char (sta.STAFF_ID) = to_char (ope.STAFF_ID) ");
    	sqlstr.append(" and id="+wid+" ");
    	sqlstr.append(" UNION ALL " )
    		  .append("SELECT busi_id recordId, ")
    		  .append(" APPLY_NAME apply_name, ")
    		  .append(" principle principal, ")
    		  .append(" PROP_TIME create_time, ")
    		  .append(" prop_staff create_staff_name, ")
    		  .append(" (SELECT org.organize_name ")
    		  .append(" FROM SECHB.sec_organize org ")
    		  .append(" WHERE org.organize_id = substr (bc.org, 1, 2)) ")
    		  .append(" orgName ")
    		  .append(" FROM busi_change_t bc ")
    		  .append(" where busi_id = " + wid + " ")
    	      .append(" UNION ALL " )
    		  .append("SELECT mainid recordId, ")
    		  .append(" APPLY_NAME apply_name, ")
    		  .append(" principal principal, ")
    		  .append(" PROP_TIME create_time, ")
    		  .append(" prop_staff create_staff_name, ")
    		  .append(" (SELECT org.organize_name ")
    		  .append(" FROM SECHB.sec_organize org ")
    		  .append(" WHERE org.organize_id = substr (ssc.org_id, 1, 2)) ")
    		  .append(" orgName ")
    		  .append(" FROM stop_selling_main_t ssc ")
    		  .append(" where mainid = " + wid + " ")
    		  .append(" UNION ALL " )
    		  .append(" SELECT RESOURCE_ID recordId, ")
    		  .append(" APPLY_NAME apply_name, ")
    		  .append(" principle principal, ")
    		  .append(" PROP_TIME create_time, ")
    		  .append(" prop_staff create_staff_name, ")
    		  .append(" (SELECT org.organize_name ")
    		  .append(" FROM SECHB.sec_organize org ")
    		  .append(" WHERE org.organize_id = substr (rc.org, 1, 2)) ")
    		  .append(" orgName ")
    		  .append(" FROM RESOURCE_CHANGE_T rc ")
    		  .append(" WHERE RESOURCE_ID =" + wid + " " )
    		  .append(" UNION ALL ")
    		  .append("SELECT id recordId, ")
    		  .append(" '协助配置工单'||rela_order_id apply_name, ")
    		  .append(" principle principal, ")
    		  .append(" create_time, ")
    		  .append(" '系统自动' create_staff_name, ")
    		  .append(" '' orgName ")
    		  .append(" FROM PRODUCT_ATTACH_CFG_T oct ")
    		  .append(" where id = " + wid + " ")
    		  .append(" UNION ALL " )
    		  .append("SELECT complains_id recordId, ")
    		  .append(" APPLY_NAME apply_name, ")
    		  .append(" principle principal, ")
    		  .append(" PROP_TIME create_time, ")
    		  .append(" prop_staff create_staff_name, ")
    		  .append(" (SELECT org.organize_name ")
    		  .append(" FROM SECHB.sec_organize org ")
    		  .append(" WHERE org.organize_id = substr (oct.org, 1, 2)) ")
    		  .append(" orgName ")
    		  .append(" FROM order_complains_t oct ")
    		  .append(" where complains_id = " + wid + ")");
    	parameter.put("wid", wid);
    	//System.out.print("sql===:"+sqlstr.toString());
    	IBOApplyInfoValue[] applyInfo = BOApplyInfoEngine.getBeansFromSql(sqlstr.toString(), parameter);

    	
    	if(applyInfo.length > 1){
    		throw new Exception("获取多个工单,工单重复 !");
    	}
    	if (applyInfo == null){
    		return new BOApplyInfoBean();
    	}
    	return applyInfo[0];
    }
    
	/*
	 * 说明：获取工单类型
	 * 参数：
	 * task_id:工单ID
	 * */
    public String getObjectType(String task_id)throws RuntimeException,	Exception{
    	String condition = IBOWorkflowInfoValue.S_TaskId+"=:task_id";
    	HashMap<String,String> parameter = new HashMap<String,String>();
    	parameter.put("task_id", task_id);
    	
    	IBOWorkflowInfoValue[] workinfo = BOWorkflowInfoEngine.getBeans(condition, parameter);

    	if(workinfo.length > 1){
    		throw new Exception("一个任务获取多个任务,请联系管理员 !");
    	}
        
    	String object_type= workinfo[0].getWorkflowObjectType();
    	return object_type;
    }
    
	/*
	 * 说明：获取工单id
	 * 参数：
	 * task_id:任务ID
	 * */
    public String getObjectId(String task_id)throws RuntimeException,	Exception{
    	String condition = IBOWorkflowInfoValue.S_TaskId+"=:task_id";
    	HashMap<String,String> parameter = new HashMap<String,String>();
    	parameter.put("task_id", task_id);
    	
    	IBOWorkflowInfoValue[] workinfo = BOWorkflowInfoEngine.getBeans(condition, parameter);

    	if(workinfo.length > 1){
    		throw new Exception("一个任务获取多个任务,请联系管理员 !");
    	}
        
    	String objectId= workinfo[0].getWorkflowObjectId();
    	return objectId;
    	
    }
    
	/*
	 * 说明：获取手机号码
	 * 参数：
	 * operator_id:操作员ID
	 * */
    public String getTelphone(String operator_id)throws RuntimeException,Exception{
    	String condition = IBOStaffSmsInfoValue.S_OperatorId+"=:operator_id";
    	HashMap<String,String> parameter = new HashMap<String,String>();
    	parameter.put("operator_id", operator_id);
    	
    	IBOStaffSmsInfoValue[] staffSmsInfo = BOStaffSmsInfoEngine.getBeans(condition, parameter);

    	if (staffSmsInfo != null && staffSmsInfo.length > 0) {
    		return staffSmsInfo[0].getBillId();
    	} else {
    		return "10086";
    	}
    }
    
}
