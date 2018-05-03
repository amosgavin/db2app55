package com.asiainfo.task.dao.impl;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.task.ivalues.IBOCurTaskValue;
import com.asiainfo.task.ivalues.IBORoleOpValue;
import com.asiainfo.task.ivalues.IBOHistoryTaskValue;
import com.asiainfo.task.ivalues.IBOCurCountTaskValue;
import com.asiainfo.task.ivalues.IBOAllTaskCountValue;
import com.asiainfo.task.dao.interfaces.ICurTaskDAO;
import com.asiainfo.task.bo.BOCurTaskBean;
import com.asiainfo.task.bo.BOCurTaskEngine;
import com.asiainfo.task.bo.BOHistoryTaskEngine;
import com.asiainfo.task.bo.BORoleOpEngine;
import com.asiainfo.task.bo.BOCurCountTaskEngine;
import com.asiainfo.task.bo.BOAllTaskCountEngine;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.privilege.UserInfoInterface;
import com.asiainfo.task.ivalues.IBOFinishTaskValue;
import com.asiainfo.task.bo.BOFinishTaskEngine;
import com.asiainfo.task.dao.impl.ProxyPriveDAOImpl;
import com.asiainfo.task.ivalues.IBOProxyPriveValue;
import com.asiainfo.task.bo.BOProxyPriveEngine;

public class CurTaskDAOImpl implements ICurTaskDAO{

	/**
	 * 说明:根据staffId查询角色ID
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public List<String> getRole(String staffId) throws Exception,RuntimeException{
		ArrayList<String> role= new ArrayList<String>();
		IBORoleOpValue[] roleOp;

		String condition = IBORoleOpValue.S_OperatorId+"=:staffId";
		HashMap<String,String> parameter = new HashMap<String,String>();
		parameter.put("staffId", staffId);

		String roleId;
		roleOp = BORoleOpEngine.getBeans(condition, parameter);   
		for(int i=0;i<roleOp.length;i++){
			roleId = String.valueOf(roleOp[i].getRoleId());  
			role.add(roleId);
		}
		return role;
	}
	
	/**
	 * 说明:获取员工代理人
	 * staffId：员工号
	 * **/
	public String getProxyStaff(String staffId)throws Exception,RuntimeException{
		StringBuffer sqlstr = new StringBuffer();
		sqlstr.append(" SELECT * ");
		sqlstr.append("  FROM proxy_prive_t ");
		sqlstr.append("  WHERE author_staff_id = :staffid ");
		sqlstr.append("  AND state = 1 ");
		sqlstr.append("  AND proxy_date IN (SELECT max (proxy_date) ");
		sqlstr.append("  FROM proxy_prive_t ");
		sqlstr.append("  WHERE author_staff_id = :staffid ");
		sqlstr.append("  AND state = 1) ");
		HashMap parameter = new HashMap();
		parameter.put("staffid", staffId);
		IBOProxyPriveValue[] proxy=BOProxyPriveEngine.getBeansFromSql(sqlstr.toString(), parameter);
		if(proxy.length==1){
          return proxy[0].getProxyStaffId();
		}else{
		  return "-1";
		}
	}
	

	/**
	 * 说明:员工号查询待处理工单数量
	 * staffId：员工号
	 * **/
	public int getCurCount(String staffId) throws Exception,RuntimeException{
		//获取代理人列表
		List authorStaff;
		ProxyPriveDAOImpl proxyPrive = new ProxyPriveDAOImpl();
		authorStaff = proxyPrive.getAuthorStaff(staffId);
		StringBuffer staffstr = new StringBuffer();
		if(authorStaff.size()!=0){
			Iterator ite = authorStaff.iterator();
			while(ite.hasNext()){
				staffstr.append("'");
				staffstr.append(ite.next());
				staffstr.append("'");
				staffstr.append(",");
			}
			staffstr.deleteCharAt(staffstr.lastIndexOf(","));
		}
		if(staffstr.length()>0){
			staffstr.append(",");
			staffstr.append("'");
			staffstr.append(staffId);
			staffstr.append("'");
		}else{
			staffstr.append("'");
			staffstr.append(staffId);
			staffstr.append("'");
		}
		StringBuffer sqlStr=new StringBuffer();	
		sqlStr.append("SELECT distinct workflow_id, ");
		sqlStr.append("       TASK_TAG, ");
		sqlStr.append("       TASK_ID, ");
		sqlStr.append("       LABEL AS TLABEL, ");
		sqlStr.append("       CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("       STATE, ");
		sqlStr.append("       STATION_ID, ");
		sqlStr.append("       TASK_STAFF_ID, ");
		sqlStr.append("       task_type, ");
		sqlStr.append("       description ERROR_MESSAGE, ");
		sqlStr.append("       task_template_id, ");
		sqlStr.append("       FINISH_STAFF_ID, ");
		sqlStr.append("       FINISH_DATE, ");
		sqlStr.append("       description ");
		sqlStr.append("  FROM VM_TASK ");
		sqlStr.append(" WHERE state = '5' ");
		sqlStr.append(" and TASK_STAFF_ID in ( "+staffstr.toString()+")");
		sqlStr.append(" UNION ALL ");
		sqlStr.append(" SELECT workflow_id, ");
		sqlStr.append("       TASK_TAG, ");
		sqlStr.append("       TASK_ID, ");
		sqlStr.append("       LABEL AS TLABEL, ");
		sqlStr.append("       CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("       STATE, ");
		sqlStr.append("       STATION_ID, ");
		sqlStr.append("       TASK_STAFF_ID, ");
		sqlStr.append("       task_type, ");
		sqlStr.append("       description ERROR_MESSAGE, ");
		sqlStr.append("       task_template_id, ");
		sqlStr.append("       FINISH_STAFF_ID, ");
		sqlStr.append("       FINISH_DATE, ");
		sqlStr.append("       description ");
		sqlStr.append("  FROM VM_TASK_TS ");
		sqlStr.append(" WHERE state = '5' ");
		sqlStr.append(" and TASK_STAFF_ID in ( "+staffstr.toString()+")");
		
		HashMap parameter = new HashMap();
		parameter.put("staffstr", staffstr.toString());
		IBOCurCountTaskValue[] curCnt = BOCurCountTaskEngine.getBeansFromSql(sqlStr.toString(), parameter);
		return curCnt.length;
	}

	/**
	 * 说明:员工号和工单类型查询待处理工单数量
	 * staffId：员工号
	 * **/
	public int getCurCountByType(String staffId,String caseType) throws Exception,RuntimeException{
		//获取代理人列表
		List authorStaff;
		ProxyPriveDAOImpl proxyPrive = new ProxyPriveDAOImpl();
		authorStaff = proxyPrive.getAuthorStaff(staffId);
		StringBuffer staffstr = new StringBuffer();
		if(authorStaff.size()!=0){
			Iterator ite = authorStaff.iterator();
			while(ite.hasNext()){
				staffstr.append("'");
				staffstr.append(ite.next());
				staffstr.append("'");
				staffstr.append(",");
			}
			staffstr.deleteCharAt(staffstr.lastIndexOf(","));
		}
		if(staffstr.length()>0){
			staffstr.append(",");
			staffstr.append("'");
			staffstr.append(staffId);
			staffstr.append("'");
		}else{
			staffstr.append("'");
			staffstr.append(staffId);
			staffstr.append("'");
		}
		StringBuffer sqlStr=new StringBuffer();	
		sqlStr.append("SELECT a.workflow_id, ");
		sqlStr.append("       a.TASK_TAG, ");
		sqlStr.append("       a.TASK_ID, ");
		sqlStr.append("       a.LABEL AS TLABEL, ");
		sqlStr.append("       a.CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("       a.STATE, ");
		sqlStr.append("       a.STATION_ID, ");
		sqlStr.append("       a.TASK_STAFF_ID, ");
		sqlStr.append("       a.task_type, ");
		sqlStr.append("       a.description ERROR_MESSAGE, ");
		sqlStr.append("       a.task_template_id, ");
		sqlStr.append("       a.FINISH_STAFF_ID, ");
		sqlStr.append("       a.FINISH_DATE, ");
		sqlStr.append("       a.description ");
		sqlStr.append("  FROM VM_TASK a,vm_wf b ");
		sqlStr.append(" WHERE a.state = '5' ");
		sqlStr.append(" and b.workflow_object_type = '"+caseType+"' ");
		sqlStr.append(" and a.workflow_id = b.workflow_id ");
		sqlStr.append(" and TASK_STAFF_ID in ( "+staffstr.toString()+")");
		sqlStr.append(" UNION ALL ");
		sqlStr.append(" SELECT a.workflow_id, ");
		sqlStr.append("       a.TASK_TAG, ");
		sqlStr.append("       a.TASK_ID, ");
		sqlStr.append("       a.LABEL AS TLABEL, ");
		sqlStr.append("       a.CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("       a.STATE, ");
		sqlStr.append("       a.STATION_ID, ");
		sqlStr.append("       a.TASK_STAFF_ID, ");
		sqlStr.append("       a.task_type, ");
		sqlStr.append("       a.description ERROR_MESSAGE, ");
		sqlStr.append("       a.task_template_id, ");
		sqlStr.append("       a.FINISH_STAFF_ID, ");
		sqlStr.append("       a.FINISH_DATE, ");
		sqlStr.append("       a.description ");
		sqlStr.append("  FROM VM_TASK_TS a,vm_wf b  ");
		sqlStr.append(" WHERE a.state = '5' ");
		sqlStr.append(" and b.workflow_object_type = '"+caseType+"' ");
		sqlStr.append(" and a.workflow_id = b.workflow_id ");
		sqlStr.append(" and TASK_STAFF_ID in ( "+staffstr.toString()+")");
		
		HashMap parameter = new HashMap();
		parameter.put("staffstr", staffstr.toString());
		IBOCurCountTaskValue[] curCnt = BOCurCountTaskEngine.getBeansFromSql(sqlStr.toString(), parameter);
		return curCnt.length;
	}
	
	/**
	 * 说明:员工已办未结工单数
	 * staffId：员工号
	 * **/
	public int getFinishTaskCount(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception,RuntimeException{
		IBOFinishTaskValue[] curCnt = getFinishTask(staffId, beginTime, endTime, applyname,corporation, objectid,staffname, 2, 0);
		return curCnt.length;
	}

	/**
	 * 说明:员工已办归档工单数
	 * staffId：员工号
	 * **/
	public int getHistoryTaskCount(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception,RuntimeException{
		IBOFinishTaskValue[] curCnt = this.getHistoryRecord(staffId, beginTime, endTime, applyname, objectid,corporation,staffname, 2, 0);
		return curCnt.length;
	}
	
	/**
	 * 说明:根据岗位ID和员工号查询所有待处理工单
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public IBOCurTaskValue[] getCurTask(String staffId,int startNum, int endNum) throws Exception,RuntimeException{
		//获取员工orgId
		/*UserInfoInterface user = SessionManager.getUser();
		String orgId = String.valueOf(user.getOrgId()).substring(0, 2);*/

		//获取代理人列表
		List authorStaff;
		ProxyPriveDAOImpl proxyPrive = new ProxyPriveDAOImpl();
		authorStaff = proxyPrive.getAuthorStaff(staffId);
		StringBuffer staffstr = new StringBuffer();
		if(authorStaff.size()!=0){
			Iterator ite = authorStaff.iterator();
			while(ite.hasNext()){
				staffstr.append("'");
				staffstr.append(ite.next());
				staffstr.append("'");
				staffstr.append(",");
			}
			staffstr.deleteCharAt(staffstr.lastIndexOf(","));
		}
		if(staffstr.length()>0){
			staffstr.append(",");
			staffstr.append("'");
			staffstr.append(staffId);
			staffstr.append("'");
		}else{
			staffstr.append("'");
			staffstr.append(staffId);
			staffstr.append("'");
		}
		
		//String vstate="5";
		StringBuffer sqlStr=new StringBuffer();
		sqlStr.append(" select distinct data03.row_index,data03.WORKFLOW_ID,data03.TEMPLATE_TAG,data03.TASK_TAG,data03.WORKFLOW_OBJECT_TYPE,data03.OBJECT_TYPE_NAME,data03.WORKFLOW_OBJECT_ID,data03.CREATE_DATE, ");
		sqlStr.append(" data03.LABEL,data03.TASK_ID,data03.TLABEL,data03.TASK_DATE,data03.STATE_NAME,data03.STATE,data03.STATION_ID,data03.TASK_STAFF_ID,data03.TASK_STAFF_NAME,data03.ERROR_MESSAGE, ");
		sqlStr.append(" data03.task_template_id,data03.STAFF_NAME,data03.FINISH_STAFF_ID,data03.FINISH_DATE,data03.description,data03.REGION_ID,data03.ORG_NAME, ");
		sqlStr.append(" data03.create_staff_name,data03.create_time,data03.apply_name,data03.create_staff_id,data03.corporation,data03.create_corporation,' ' next_task,sec_st1.staff_name pz_staff,sec_st2.staff_name test_staff from ( ");
		sqlStr.append(" SELECT rownumber () OVER ( ORDER BY TASK_DATE desc ) AS row_index, WORKFLOW_ID, ");
		sqlStr.append("  TEMPLATE_TAG, ");
		sqlStr.append("  TASK_TAG, ");
		sqlStr.append("  WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("  OBJECT_TYPE_NAME, ");
		sqlStr.append("  WORKFLOW_OBJECT_ID, ");
		sqlStr.append("  CREATE_DATE, ");
		sqlStr.append("  LABEL, ");
		sqlStr.append("  TASK_ID, ");
		sqlStr.append("  TLABEL, ");
		sqlStr.append("  TASK_DATE, ");
		sqlStr.append("  STATE_NAME, ");
		sqlStr.append("  STATE, ");
		sqlStr.append("  STATION_ID, ");
		sqlStr.append("  TASK_STAFF_ID, ");
		sqlStr.append("  TASK_STAFF_NAME, ");
		sqlStr.append("  ERROR_MESSAGE, ");
		sqlStr.append("  task_template_id, ");
		sqlStr.append("  STAFF_NAME, ");
		sqlStr.append("  FINISH_STAFF_ID, ");
		sqlStr.append(" FINISH_DATE, ");
		sqlStr.append("  description, ");
		sqlStr.append("  REGION_ID,        ");
		sqlStr.append("  ORG_NAME, ");
		sqlStr.append("  create_staff_name,  ");
		sqlStr.append("  create_time, ");
		sqlStr.append("  apply_name, ");
		sqlStr.append("  create_staff_id, ");
		sqlStr.append("  corporation, ");
		sqlStr.append("  create_corporation ");
		sqlStr.append("  FROM ( SELECT WORKFLOW_ID, ");
		sqlStr.append("  TEMPLATE_TAG, ");
		sqlStr.append("  TASK_TAG, ");
		sqlStr.append("  WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("  OBJECT_TYPE_NAME, ");
		sqlStr.append("  WORKFLOW_OBJECT_ID, ");
		sqlStr.append("  CREATE_DATE, ");
		sqlStr.append("  LABEL, ");
		sqlStr.append("  TASK_ID, ");
		sqlStr.append("  (CASE WHEN TLABEL LIKE '%~%' ");
		sqlStr.append("  THEN substr (TLABEL, 1, locate ('~', TLABEL, 1) - 1) ");
		sqlStr.append("  ELSE TLABEL END) ");
		sqlStr.append("  TLABEL, ");
		sqlStr.append("  TASK_DATE, ");
		sqlStr.append("  STATE_NAME, ");
		sqlStr.append("  STATE,  ");
		sqlStr.append("  STATION_ID, ");
		sqlStr.append("  TASK_STAFF_ID, ");
		sqlStr.append("  TASK_STAFF_NAME,     ");
		sqlStr.append("  ERROR_MESSAGE, ");
		sqlStr.append("  task_template_id, ");
		sqlStr.append("  STAFF_NAME,         ");
		sqlStr.append("  FINISH_STAFF_ID, ");
		sqlStr.append("  FINISH_DATE, ");
		sqlStr.append("  description,       ");
		sqlStr.append("  REGION_ID, ");
		sqlStr.append("  ORG_NAME, ");
		sqlStr.append("  create_staff_id, ");
		sqlStr.append("  create_staff_name, ");
		sqlStr.append("  (CASE WHEN corporation1 IS NULL THEN create_corporation ");
		sqlStr.append("  ELSE corporation1 END) ");
		sqlStr.append("  corporation, ");
		sqlStr.append("  create_corporation ");
		sqlStr.append("  FROM (SELECT a.WORKFLOW_ID, ");
		sqlStr.append("  a.TEMPLATE_TAG, ");
		sqlStr.append("  b.TASK_TAG, ");
		sqlStr.append("  a.WORKFLOW_OBJECT_TYPE WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("  a.WORKFLOW_OBJECT_TYPE OBJECT_TYPE_NAME, ");
		sqlStr.append("  a.WORKFLOW_OBJECT_ID, ");
		sqlStr.append("  a.CREATE_DATE, ");
		sqlStr.append("  a.LABEL, ");
		sqlStr.append("  b.TASK_ID, ");
		sqlStr.append("  b.TLABEL, ");
		sqlStr.append("  b.TASK_DATE, ");
		sqlStr.append("  '待办' STATE_NAME,  ");
		sqlStr.append("  b.STATE, ");
		sqlStr.append("  b.STATION_ID, ");
		sqlStr.append("  b.TASK_STAFF_ID, ");
		sqlStr.append("  '' TASK_STAFF_NAME, ");
		sqlStr.append("  b.description ERROR_MESSAGE, ");
		sqlStr.append("  b.task_template_id, ");
		sqlStr.append("  b.FINISH_STAFF_ID, ");
		sqlStr.append("  '' STAFF_NAME, ");
		sqlStr.append("  b.FINISH_DATE, ");
		sqlStr.append("  b.description, ");
		sqlStr.append("  a.REGION_ID, ");
		sqlStr.append("  '' ORG_NAME, ");
		sqlStr.append("  a.create_staff_id, ");
		sqlStr.append("  (SELECT sta.staff_name ");
		sqlStr.append("     FROM SECHB.SEC_STAFF sta, SECHB.SEC_OPERATOR ope ");
		sqlStr.append("    WHERE a.create_staff_id = to_char (ope.OPERATOR_ID) ");
		sqlStr.append("     AND to_char (sta.STAFF_ID) = to_char (ope.STAFF_ID)) ");
		sqlStr.append("  create_staff_name, ");
		sqlStr.append("       '--' corporation1, ");
		sqlStr.append("       (SELECT nvl (organize_name, '--') ");
		sqlStr.append("          FROM sechb.sec_organize c ");
		sqlStr.append("         WHERE c.organize_id = a.region_id) ");
		sqlStr.append("          create_corporation     ");
		sqlStr.append("  FROM vm_wf a, ");
		sqlStr.append("  (SELECT workflow_id,   ");
		sqlStr.append("  TASK_TAG, ");
		sqlStr.append("  TASK_ID, ");
		sqlStr.append("  LABEL AS TLABEL, ");
		sqlStr.append("  CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("  STATE, ");
		sqlStr.append("  STATION_ID, ");
		sqlStr.append("  TASK_STAFF_ID, ");
		sqlStr.append("  task_type, ");
		sqlStr.append("  description ERROR_MESSAGE, ");
		sqlStr.append("  task_template_id, ");
		sqlStr.append("  FINISH_STAFF_ID, ");
		sqlStr.append("  FINISH_DATE, ");
		sqlStr.append("  description ");
		sqlStr.append("    FROM VM_TASK ");
		sqlStr.append("   WHERE state = '5' ");
		sqlStr.append("   AND TASK_STAFF_ID IN (  "+ staffstr.toString() +" )");
		sqlStr.append("  UNION ALL                 ");
		sqlStr.append("  SELECT workflow_id, ");
		sqlStr.append("  TASK_TAG,         ");
		sqlStr.append("  TASK_ID, ");
		sqlStr.append("  LABEL AS TLABEL, ");
		sqlStr.append("  CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("  STATE, ");
		sqlStr.append("  STATION_ID, ");
		sqlStr.append("  TASK_STAFF_ID, ");
		sqlStr.append("  task_type, ");
		sqlStr.append("  description ERROR_MESSAGE, ");
		sqlStr.append("  task_template_id, ");
		sqlStr.append("  FINISH_STAFF_ID, ");
		sqlStr.append("  FINISH_DATE, ");
		sqlStr.append("  description ");
		sqlStr.append("   FROM VM_TASK_TS ");
		sqlStr.append("  WHERE state = '5'  ");
		sqlStr.append("  AND TASK_STAFF_ID IN ( "+ staffstr.toString() +" )"+" ) b ");
		sqlStr.append("           WHERE a.WORKFLOW_ID = b.WORKFLOW_ID) ) data01, ");
		sqlStr.append(" ( SELECT ID recordId, ");
		sqlStr.append("         apply_name, ");
		sqlStr.append("         principal, ");
		sqlStr.append("         create_time ");
		sqlStr.append("    FROM SALE_WEAPON_MAIN_T sw ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT order_id recordId, ");
		sqlStr.append("         order_name apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_date create_time ");
		sqlStr.append("    FROM sale_order_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT MAIN_ID recordId,      ");
		sqlStr.append("         REAMRK_1 apply_name, ");
		sqlStr.append("         PRINCIPLE principal, ");
		sqlStr.append("         CREATE_TIME create_time          ");
		sqlStr.append("    FROM CHARGE_MAIN_T sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select ACCESS_ID recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           CREATE_TIME create_time "); 
		sqlStr.append("      from ACCESS_CHANGE_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select busi_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from BUSI_CHANGE_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select recordId, ");
		sqlStr.append("           apply_name, "); 
		sqlStr.append("    	    principal ,  "); 
		sqlStr.append("           apply_time create_time "); 
		sqlStr.append("      from PRODUCT_BOSSID_APPLY_T sm "); 		
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT ID recordId, ");
		sqlStr.append("         apply_name, ");
		sqlStr.append("         principal, ");
		sqlStr.append("         create_time ");
		sqlStr.append("    FROM sale_batch_prestore_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT ID recordId, ");
		sqlStr.append("         '协助配置工单'||rela_order_id apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_time ");
		sqlStr.append("    FROM product_attach_cfg_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT mainid recordId, ");
		sqlStr.append("         apply_name, ");
		sqlStr.append("         principal, ");
		sqlStr.append("         prop_time create_time ");
		sqlStr.append("    FROM stop_selling_main_t sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select complains_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from ORDER_COMPLAINS_T oct "); 
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT RESOURCE_ID recordId, ");
		sqlStr.append("         apply_name, ");
		sqlStr.append("        PRINCIPLE principal, ");
		sqlStr.append("        prop_time create_time ");
		sqlStr.append("    FROM RESOURCE_CHANGE_T rc ");
		sqlStr.append(") data02 ");
		sqlStr.append("  WHERE data01.WORKFLOW_OBJECT_ID = TO_CHAR(data02.recordId) ");
		sqlStr.append("  ) data03")
			  .append(" LEFT JOIN hbsale.vm_task vt1 ON data03.workflow_id=vt1.workflow_id AND vt1.task_tag IN ('w05','t15','p06','I018','C041','PC041','st4-ch2-conf','busi013') and vt1.state='3' ")
			  .append(" LEFT JOIN sechb.sec_operator sec_op1 ON vt1.finish_staff_id=sec_op1.operator_id ")
			  .append(" LEFT JOIN sechb.sec_staff sec_st1 ON sec_op1.staff_id=sec_st1.staff_id ")
			  .append(" LEFT JOIN hbsale.vm_task vt2 ON data03.workflow_id=vt2.workflow_id AND vt2.task_tag IN ('t0004','p17','C27','PC008','st5-ch2-test') ")
			  .append(" LEFT JOIN sechb.sec_operator sec_op2 ON vt2.finish_staff_id=sec_op2.operator_id ")
			  .append(" LEFT JOIN sechb.sec_staff sec_st2 ON sec_op2.staff_id=sec_st2.staff_id ");
		
		if(startNum < endNum){
			String citer01 = " where row_index >=:startNum and row_index<=:endNum ";
			sqlStr.append(citer01);
		}
		sqlStr.append(" order by data03.ROW_INDEX");
		HashMap<String,String> parameter = new HashMap<String,String>();
		parameter.put("staffstr", staffstr.toString());
		parameter.put("startNum", String.valueOf(startNum));
		parameter.put("endNum",  String.valueOf(endNum));
        
		IBOCurTaskValue[] curTask = BOCurTaskEngine.getBeansFromSql(sqlStr.toString(), parameter);
		
		System.out.println("取出 "+curTask.length+" 条任务记录！");
		return curTask;
	}

	/**
	 * 说明:根据workflowId查询出所的已完成任务
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public IBOCurTaskValue[] getAllTaskByWorkFlowId(String workflowId,int startNum, int endNum) throws Exception,RuntimeException{
		IBOCurTaskValue[] curTask;
		StringBuffer sqlStr=new StringBuffer();
		sqlStr.append("");
		sqlStr.append(" SELECT WORKFLOW_ID, ");
		sqlStr.append("        TEMPLATE_TAG, ");
		sqlStr.append("        TASK_TAG, ");
		sqlStr.append("        WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("        OBJECT_TYPE_NAME, ");
		sqlStr.append("        WORKFLOW_OBJECT_ID, ");
		sqlStr.append("        CREATE_DATE, ");
		sqlStr.append("        LABEL, ");
		sqlStr.append("        TASK_ID, ");
		sqlStr.append("        TLABEL, ");
		sqlStr.append("        TASK_DATE, ");
		sqlStr.append("        DECISION_RESULT, ");
		sqlStr.append("        STATE_NAME, ");
		sqlStr.append("        STATE, ");
		sqlStr.append("        STATION_ID, ");
		sqlStr.append("        TASK_STAFF_ID, ");
		sqlStr.append("        TASK_STAFF_NAME, ");
		sqlStr.append("        ERROR_MESSAGE, ");
		sqlStr.append("        task_template_id, ");
		sqlStr.append("        STAFF_NAME, ");
		sqlStr.append("        FINISH_STAFF_ID, ");
		sqlStr.append("        FINISH_DATE, ");
		sqlStr.append("        description, ");
		sqlStr.append("        REGION_ID, ");
		sqlStr.append("        ORG_NAME, ");
		sqlStr.append("        create_staff_name, ");
		sqlStr.append("        create_time, ");
		sqlStr.append("        apply_name, ");
		sqlStr.append("        create_staff_id, ");
		sqlStr.append("        corporation, ");
		sqlStr.append("        create_corporation, ' ' next_task ");
		sqlStr.append("   FROM (SELECT WORKFLOW_ID, ");
		sqlStr.append("                TEMPLATE_TAG, ");
		sqlStr.append("                TASK_TAG, ");
		sqlStr.append("                WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("                OBJECT_TYPE_NAME, ");
		sqlStr.append("                WORKFLOW_OBJECT_ID, ");
		sqlStr.append("                CREATE_DATE, ");
		sqlStr.append("                LABEL, ");
		sqlStr.append("                TASK_ID, ");
		sqlStr.append("                (CASE WHEN TLABEL LIKE '%~%' ");
		sqlStr.append("                    THEN substr (TLABEL, 1, locate ('~', TLABEL, 1) - 1) ");
		sqlStr.append("                    ELSE TLABEL END) TLABEL, ");
		sqlStr.append("                TASK_DATE, ");
		sqlStr.append("                DECISION_RESULT, ");
		sqlStr.append("                STATE_NAME, ");
		sqlStr.append("                STATE, ");
		sqlStr.append("                STATION_ID, ");
		sqlStr.append("                TASK_STAFF_ID, ");
		sqlStr.append("                TASK_STAFF_NAME, ");
		sqlStr.append("                ERROR_MESSAGE, ");
		sqlStr.append("                task_template_id, ");
		sqlStr.append("                STAFF_NAME, ");
		sqlStr.append("                FINISH_STAFF_ID, ");
		sqlStr.append("                FINISH_DATE, ");
		sqlStr.append("                description, ");
		sqlStr.append("                REGION_ID, ");
		sqlStr.append("                ORG_NAME, ");
		sqlStr.append("                create_staff_id, ");
		sqlStr.append("                create_staff_name, ");
		sqlStr.append("                (CASE ");
		sqlStr.append("                    WHEN corporation1 IS NULL THEN create_corporation ");
		sqlStr.append("                    ELSE corporation1 END) corporation, ");
		sqlStr.append("                create_corporation ");
		sqlStr.append("           FROM (SELECT a.WORKFLOW_ID, ");
		sqlStr.append("                        a.TEMPLATE_TAG, ");
		sqlStr.append("                        b.TASK_TAG, ");
		sqlStr.append("  					   a.WORKFLOW_OBJECT_TYPE WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("                        a.WORKFLOW_OBJECT_TYPE OBJECT_TYPE_NAME, ");
		sqlStr.append("                        a.WORKFLOW_OBJECT_ID, ");
		sqlStr.append("                        a.CREATE_DATE, ");
		sqlStr.append("                        a.LABEL, ");
		sqlStr.append("                        b.TASK_ID, ");
		sqlStr.append("                        b.TLABEL, ");
		sqlStr.append("                        b.TASK_DATE, ");
		sqlStr.append("                        b.DECISION_RESULT, ");
		sqlStr.append("                        (CASE WHEN b.STATE = '5' THEN '等待办理' ");
		sqlStr.append("                            WHEN b.STATE = '3' THEN '已经完成' ");
		sqlStr.append("                            WHEN b.STATE = '2' THEN '可调度' ");
		sqlStr.append("                            WHEN b.STATE = '1' THEN '不能调度' ");
		sqlStr.append("                            WHEN b.STATE = '4' THEN '终止' ");
		sqlStr.append("                            WHEN b.STATE = '6' THEN '任务回退' ");
		sqlStr.append("                            WHEN b.STATE = '10' THEN '任务转派' ");
		sqlStr.append("                            WHEN b.STATE = '11' THEN '异常结束' ");
		sqlStr.append("                            ELSE '其他状态' END) STATE_NAME, ");
		sqlStr.append("                        b.STATE, ");
		sqlStr.append("                        b.STATION_ID, ");
		sqlStr.append("                        b.TASK_STAFF_ID, ");
		sqlStr.append("                        (CASE  WHEN task_type in ('user','sign') ");
		sqlStr.append("                            THEN ");
		sqlStr.append("                               (SELECT value (sta.STAFF_NAME, '') ");
		sqlStr.append("                                  FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                                       SECHB.SEC_OPERATOR ope ");
		sqlStr.append("                                 WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                       AND char (ope.OPERATOR_ID) = value (b.TASK_STAFF_ID, '0')) ");
		sqlStr.append("                            WHEN task_type = 'start' ");
		sqlStr.append("                            THEN ");
		sqlStr.append("                               (SELECT value (sta.STAFF_NAME, '') ");
		sqlStr.append("                                  FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                                       SECHB.SEC_OPERATOR ope ");
		sqlStr.append("                                 WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                       AND char (ope.OPERATOR_ID) = value (a.create_staff_id, '0')) ");
		sqlStr.append("                            ELSE ' ' END) TASK_STAFF_NAME, ");
		sqlStr.append("                        b.description ERROR_MESSAGE, ");
		sqlStr.append("                        b.task_template_id, ");
		sqlStr.append("                        b.FINISH_STAFF_ID, ");
		sqlStr.append("                        (SELECT value (sta.STAFF_NAME, '') ");
		sqlStr.append("                           FROM SECHB.SEC_STAFF sta, SECHB.SEC_OPERATOR ope ");
		sqlStr.append("                          WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                AND char (ope.OPERATOR_ID) = value (b.FINISH_STAFF_ID, '0')) STAFF_NAME, ");
		sqlStr.append("                        b.FINISH_DATE, ");
		sqlStr.append("                        b.description, ");
		sqlStr.append("                        a.REGION_ID, ");
		sqlStr.append("                        (CASE WHEN task_type in ('user','sign') THEN ");
		sqlStr.append("                               (SELECT value (org.organize_name, '') ");
		sqlStr.append("                                  FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                                       SECHB.SEC_OPERATOR ope, ");
		sqlStr.append("                                       SECHB.SEC_ORGANIZE org ");
		sqlStr.append("                                 WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                       AND char (ope.OPERATOR_ID) = ");
		sqlStr.append("                                              value (b.TASK_STAFF_ID, '0') ");
		sqlStr.append("                                       AND sta.organize_id = org.organize_id) ");
		sqlStr.append("                            WHEN task_type = 'start' ");
		sqlStr.append("                            THEN (SELECT value (org.organize_name, '') ");
		sqlStr.append("                                  FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                                       SECHB.SEC_OPERATOR ope, ");
		sqlStr.append("                                       SECHB.SEC_ORGANIZE org ");
		sqlStr.append("                                 WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                       AND char (ope.OPERATOR_ID) = value (a.create_staff_id, '0') ");
		sqlStr.append("                                       AND sta.organize_id = org.organize_id) ");
		sqlStr.append("                            ELSE ' ' END) ORG_NAME, ");
		sqlStr.append("                        a.create_staff_id, ");
		sqlStr.append("                       (SELECT sta.staff_name ");
		sqlStr.append("                           FROM SECHB.SEC_STAFF sta, SECHB.SEC_OPERATOR ope ");
		sqlStr.append("                          WHERE a.create_staff_id = to_char (ope.OPERATOR_ID) ");
		sqlStr.append("                                AND to_char (sta.STAFF_ID) = to_char (ope.STAFF_ID)) ");
		sqlStr.append("                           create_staff_name,    ");                    
		sqlStr.append("                        (SELECT value (org.organize_name, '') ");
		sqlStr.append("                           FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                                SECHB.SEC_OPERATOR ope, ");
		sqlStr.append("                                SECHB.SEC_ORGANIZE org ");
		sqlStr.append("                          WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                AND char (ope.OPERATOR_ID) = value (b.TASK_STAFF_ID, '0') ");
		sqlStr.append("                                AND substr (sta.organize_id, 1, 2) = org.organize_id) corporation1, ");
		sqlStr.append("                        (SELECT nvl (organize_name, '--') ");
		sqlStr.append("                           FROM sechb.sec_organize c ");
		sqlStr.append("                          WHERE c.organize_id = a.region_id) create_corporation ");
		sqlStr.append("                   FROM vm_wf a, ");
		sqlStr.append("                        (SELECT workflow_id, ");
		sqlStr.append("                                TASK_TAG, ");
		sqlStr.append("                                TASK_ID, ");
		sqlStr.append("                                LABEL AS TLABEL, ");
		sqlStr.append("                                CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("                                DECISION_RESULT, ");
		sqlStr.append("                                STATE, ");
		sqlStr.append("                                STATION_ID, ");
		sqlStr.append("                                TASK_STAFF_ID, ");
		sqlStr.append("                                task_type, ");
		sqlStr.append("                                ERROR_MESSAGE, ");
		sqlStr.append("                                task_template_id, ");
		sqlStr.append("                                FINISH_STAFF_ID, ");
		sqlStr.append("                                FINISH_DATE, ");
		sqlStr.append("                                description ");
		sqlStr.append("                           FROM VM_TASK ");
		sqlStr.append(" WHERE workflow_id = '"+workflowId+"'");
		sqlStr.append("                                AND task_type IN ('user', 'start') ");
		sqlStr.append("                                AND state IN (3,5) ");
		sqlStr.append("                         UNION ALL ");
		sqlStr.append("                         SELECT workflow_id, ");
		sqlStr.append("                                TASK_TAG, ");
		sqlStr.append("                                TASK_ID, ");
		sqlStr.append("                                LABEL AS TLABEL, ");
		sqlStr.append("                                CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("                                DECISION_RESULT, ");
		sqlStr.append("                                STATE, ");
		sqlStr.append("                                STATION_ID, ");
		sqlStr.append("                                TASK_STAFF_ID, ");
		sqlStr.append("                                task_type, ");
		sqlStr.append("                                ERROR_MESSAGE , ");
		sqlStr.append("                                task_template_id, ");
		sqlStr.append("                                FINISH_STAFF_ID, ");
		sqlStr.append("                                FINISH_DATE, ");
		sqlStr.append("                                ERROR_MESSAGE description ");
		sqlStr.append("                           FROM VM_TASK_TS ");
		sqlStr.append(" WHERE workflow_id = '"+workflowId+"'" );
		sqlStr.append("                                AND task_type IN ('user', 'sign') ");
		sqlStr.append("                                AND state IN (3,5) ");
		sqlStr.append("                                ) b ");
		sqlStr.append("                  WHERE a.WORKFLOW_ID = b.WORKFLOW_ID ");
		sqlStr.append("  and a.WORKFLOW_ID ='"+workflowId+"'");
		sqlStr.append("                        AND task_type IN ('user', 'start','sign'))) data01, ");
		sqlStr.append("        (SELECT id recordId, ");
		sqlStr.append("                apply_name, ");
		sqlStr.append("                principal, ");
		sqlStr.append("                create_time ");
		sqlStr.append("           FROM SALE_WEAPON_MAIN_T sw ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("  SELECT order_id recordId, ");
		sqlStr.append("         order_name apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_date create_time ");
		sqlStr.append("    FROM sale_order_t sm ");
		sqlStr.append("    UNION ALL ");
		sqlStr.append("      SELECT MAIN_ID recordId, ");
		sqlStr.append("                REAMRK_1 apply_name, ");
		sqlStr.append("                PRINCIPLE principal, ");
		sqlStr.append("                CREATE_TIME create_time ");
		sqlStr.append("           FROM CHARGE_MAIN_T ");
		sqlStr.append("  		UNION ALL ");
		sqlStr.append("  		SELECT ID recordId, ");
		sqlStr.append("         '协助配置工单'||rela_order_id apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_time ");
		sqlStr.append("    	FROM product_attach_cfg_t sm ");
		sqlStr.append("   UNION ALL ");
		sqlStr.append("     select ACCESS_ID recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           CREATE_TIME create_time "); 
		sqlStr.append("      from ACCESS_CHANGE_T sm "); 		
		sqlStr.append("    UNION ALL ");
		sqlStr.append("    	select busi_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from BUSI_CHANGE_T sm "); 		
		sqlStr.append("    UNION ALL ");
		sqlStr.append("    	select recordId, ");
		sqlStr.append("           apply_name, "); 
		sqlStr.append("    	    principal ,  "); 
		sqlStr.append("           apply_time create_time "); 
		sqlStr.append("      from PRODUCT_BOSSID_APPLY_T sm "); 		
		sqlStr.append("    UNION ALL ");
		sqlStr.append("      SELECT id recordId, ");
		sqlStr.append("                apply_name, ");
		sqlStr.append("                principal, ");
		sqlStr.append("                create_time ");
		sqlStr.append("           FROM sale_batch_prestore_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT mainid recordId, ");
		sqlStr.append("         apply_name, ");
		sqlStr.append("         principal, ");
		sqlStr.append("         prop_time create_time ");
		sqlStr.append("    FROM stop_selling_main_t sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select complains_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from ORDER_COMPLAINS_T oct "); 
		sqlStr.append("    UNION ALL ");
		sqlStr.append("    	select RESOURCE_ID recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from RESOURCE_CHANGE_T rc ");
		sqlStr.append(") data02 ");
		sqlStr.append("  WHERE data01.WORKFLOW_OBJECT_ID = TO_CHAR(data02.recordId) ");
		sqlStr.append(" ORDER BY TASK_DATE asc");		

		
		HashMap<String,String> parameter = new HashMap<String,String>();
		parameter.put("workflowId", workflowId);
		curTask = BOCurTaskEngine.getBeansFromSql(sqlStr.toString(), parameter);
		int taskcnt = curTask.length;
		for(int i=0;i < taskcnt-1; i++){
			curTask[i].setErrorMessage("");
			
			if(curTask[i].getDescription()==null){
			    curTask[i].setNextTask(curTask[i+1].getTlabel());
			}else if(curTask[i].getDescription().isEmpty()){
			    curTask[i].setNextTask(curTask[i+1].getTlabel());
			}
			else{
				int end = curTask[i].getDescription().indexOf("|");
				if(end==-1){
				    curTask[i].setNextTask(curTask[i+1].getTlabel());
				}else{
					curTask[i].setNextTask(curTask[i].getDescription().substring(0, end));
					curTask[i].setDescription(curTask[i].getDescription().substring(end+1, curTask[i].getDescription().length()));
				}
			}
		}
		return curTask;
	}

	/**
	 * 说明:根据workflowId查询出所的已完成任务
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public IBOCurTaskValue[] getAllTaskByWorkFlowId(String workflowId) throws Exception,RuntimeException{
		return getAllTaskByWorkFlowId(workflowId,0, 0);
	}
	
	/**
	 * 说明:根据workflowId查询出所的已完成任务任务数
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public int getAllCurTaskCount(String workflowId) throws Exception,RuntimeException{
		HashMap<String,String> parameter = new HashMap<String,String>();
		parameter.put("workflowId", workflowId);
		
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("SELECT workflow_id, ");
		sqlStr.append("       TASK_TAG, ");
		sqlStr.append("       TASK_ID, ");
		sqlStr.append("       LABEL AS TLABEL, ");
		sqlStr.append("       CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("       STATE, ");
		sqlStr.append("       STATION_ID, ");
		sqlStr.append("       TASK_STAFF_ID, ");
		sqlStr.append("       task_type, ");
		sqlStr.append("       description ERROR_MESSAGE, ");
		sqlStr.append("       task_template_id, ");
		sqlStr.append("       FINISH_STAFF_ID, ");
		sqlStr.append("       FINISH_DATE, ");
		sqlStr.append("       description ");
		sqlStr.append("  FROM VM_TASK ");
		sqlStr.append(" WHERE     workflow_id = '"+workflowId+"'");
		sqlStr.append("       AND task_type IN ('user', 'start') ");
		sqlStr.append("       AND state IN (3, 5) ");
		sqlStr.append(" UNION ALL ");
		sqlStr.append(" SELECT workflow_id, ");
		sqlStr.append("       TASK_TAG, ");
		sqlStr.append("       TASK_ID, ");
		sqlStr.append("       LABEL AS TLABEL, ");
		sqlStr.append("       CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("       STATE, ");
		sqlStr.append("       STATION_ID, ");
		sqlStr.append("       TASK_STAFF_ID, ");
		sqlStr.append("       task_type, ");
		sqlStr.append("       description ERROR_MESSAGE, ");
		sqlStr.append("       task_template_id, ");
		sqlStr.append("       FINISH_STAFF_ID, ");
		sqlStr.append("       FINISH_DATE, ");
		sqlStr.append("       description ");
		sqlStr.append("  FROM VM_TASK_TS ");
		sqlStr.append("  WHERE     workflow_id = '"+workflowId+"'");
		sqlStr.append("       AND task_type IN ('user', 'sign') ");
		sqlStr.append("       AND state IN (3, 5) ");
		sqlStr.append("       AND ( (FINISH_STAFF_ID = TASK_STAFF_ID) OR FINISH_STAFF_ID IS NULL) ");
		
		IBOAllTaskCountValue[] cntvalue = BOAllTaskCountEngine.getBeansFromSql(sqlStr.toString(), parameter);
		return cntvalue.length;
	}
	
	/**
	 * 说明:根据岗位ID、员工号和工单类型查询所有待处理工单
	 * roleId:岗位ID
	 * staffId：员工号
	 * 
	 * **/
	public IBOCurTaskValue[] getAllCurTaskByCaseType(String staffId,String caseType,int startNum, int endNum) throws Exception,RuntimeException{
		//获取员工orgId
		UserInfoInterface user = SessionManager.getUser();
		String orgId = String.valueOf(user.getOrgId()).substring(0, 2);

		//获取代理人列表
		List authorStaff;
		ProxyPriveDAOImpl proxyPrive = new ProxyPriveDAOImpl();
		authorStaff = proxyPrive.getAuthorStaff(staffId);
		StringBuffer staffstr = new StringBuffer();
		if(authorStaff.size()!=0){
			Iterator ite = authorStaff.iterator();
			while(ite.hasNext()){
				staffstr.append("'");
				staffstr.append(ite.next());
				staffstr.append("'");
				staffstr.append(",");
			}
			staffstr.deleteCharAt(staffstr.lastIndexOf(","));
		}
		if(staffstr.length()>0){
			staffstr.append(",");
			staffstr.append("'");
			staffstr.append(staffId);
			staffstr.append("'");
		}else{
			staffstr.append("'");
			staffstr.append(staffId);
			staffstr.append("'");
		}
		
		//String vstate="5";
		StringBuffer sqlStr=new StringBuffer();
		sqlStr.append(" select row_index,WORKFLOW_ID,TEMPLATE_TAG,TASK_TAG,WORKFLOW_OBJECT_TYPE,OBJECT_TYPE_NAME,WORKFLOW_OBJECT_ID,CREATE_DATE, ");
		sqlStr.append(" LABEL,TASK_ID,TLABEL,TASK_DATE,DECISION_RESULT,STATE_NAME,STATE,STATION_ID,TASK_STAFF_ID,TASK_STAFF_NAME,ERROR_MESSAGE, ");
		sqlStr.append(" task_template_id,STAFF_NAME,FINISH_STAFF_ID,FINISH_DATE,description,REGION_ID,ORG_NAME, ");
		sqlStr.append(" create_staff_name,create_time,apply_name,create_staff_id,corporation,create_corporation from ( ");
		sqlStr.append(" SELECT rownumber () OVER ( ORDER BY TASK_DATE desc ) AS row_index, WORKFLOW_ID, ");
		sqlStr.append("  TEMPLATE_TAG, ");
		sqlStr.append("  TASK_TAG, ");
		sqlStr.append("  WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("  OBJECT_TYPE_NAME, ");
		sqlStr.append("  WORKFLOW_OBJECT_ID, ");
		sqlStr.append("  CREATE_DATE, ");
		sqlStr.append("  LABEL, ");
		sqlStr.append("  TASK_ID, ");
		sqlStr.append("  TLABEL, ");
		sqlStr.append("  TASK_DATE, ");
		sqlStr.append("  DECISION_RESULT, ");
		sqlStr.append("  STATE_NAME, ");
		sqlStr.append("  STATE, ");
		sqlStr.append("  STATION_ID, ");
		sqlStr.append("  TASK_STAFF_ID, ");
		sqlStr.append("  TASK_STAFF_NAME, ");
		sqlStr.append("  ERROR_MESSAGE, ");
		sqlStr.append("  task_template_id, ");
		sqlStr.append("  STAFF_NAME, ");
		sqlStr.append("  FINISH_STAFF_ID, ");
		sqlStr.append(" FINISH_DATE, ");
		sqlStr.append("  description, ");
		sqlStr.append("  REGION_ID,        ");
		sqlStr.append("  ORG_NAME, ");
		sqlStr.append("  create_staff_name,  ");
		sqlStr.append("  create_time, ");
		sqlStr.append("  apply_name, ");
		sqlStr.append("  create_staff_id, ");
		sqlStr.append("  corporation, ");
		sqlStr.append("  create_corporation ");
		sqlStr.append("  FROM ( SELECT WORKFLOW_ID, ");
		sqlStr.append("  TEMPLATE_TAG, ");
		sqlStr.append("  TASK_TAG, ");
		sqlStr.append("  WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("  OBJECT_TYPE_NAME, ");
		sqlStr.append("  WORKFLOW_OBJECT_ID, ");
		sqlStr.append("  CREATE_DATE, ");
		sqlStr.append("  LABEL, ");
		sqlStr.append("  TASK_ID, ");
		sqlStr.append("  (CASE WHEN TLABEL LIKE '%~%' ");
		sqlStr.append("  THEN substr (TLABEL, 1, locate ('~', TLABEL, 1) - 1) ");
		sqlStr.append("  ELSE TLABEL END) ");
		sqlStr.append("  TLABEL, ");
		sqlStr.append("  TASK_DATE, ");
		sqlStr.append("  STATE_NAME, ");
		sqlStr.append("  STATE,  ");
		sqlStr.append("  STATION_ID, ");
		sqlStr.append("  TASK_STAFF_ID, ");
		sqlStr.append("  TASK_STAFF_NAME,     ");
		sqlStr.append("  ERROR_MESSAGE, ");
		sqlStr.append("  task_template_id, ");
		sqlStr.append("  STAFF_NAME,         ");
		sqlStr.append("  FINISH_STAFF_ID, ");
		sqlStr.append("  FINISH_DATE, ");
		sqlStr.append("  description,       ");
		sqlStr.append("  REGION_ID, ");
		sqlStr.append("  ORG_NAME, ");
		sqlStr.append("  create_staff_id, ");
		sqlStr.append("  create_staff_name, ");
		sqlStr.append("  (CASE WHEN corporation1 IS NULL THEN create_corporation ");
		sqlStr.append("  ELSE corporation1 END) ");
		sqlStr.append("  corporation, ");
		sqlStr.append("  create_corporation ");
		sqlStr.append("  FROM (SELECT a.WORKFLOW_ID, ");
		sqlStr.append("  a.TEMPLATE_TAG, ");
		sqlStr.append("  b.TASK_TAG, ");
		sqlStr.append("  a.WORKFLOW_OBJECT_TYPE WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("  a.WORKFLOW_OBJECT_TYPE OBJECT_TYPE_NAME, ");
		sqlStr.append("  a.WORKFLOW_OBJECT_ID, ");
		sqlStr.append("  a.CREATE_DATE, ");
		sqlStr.append("  a.LABEL, ");
		sqlStr.append("  b.TASK_ID, ");
		sqlStr.append("  b.TLABEL, ");
		sqlStr.append("  b.TASK_DATE, ");
		sqlStr.append("  b.DECISION_RESULT, ");
		sqlStr.append("  '待办' STATE_NAME,  ");
		sqlStr.append("  b.STATE, ");
		sqlStr.append("  b.STATION_ID, ");
		sqlStr.append("  b.TASK_STAFF_ID, ");
		sqlStr.append("  '' TASK_STAFF_NAME, ");
		sqlStr.append("  b.description ERROR_MESSAGE, ");
		sqlStr.append("  b.task_template_id, ");
		sqlStr.append("  b.FINISH_STAFF_ID, ");
		sqlStr.append("  '' STAFF_NAME, ");
		sqlStr.append("  b.FINISH_DATE, ");
		sqlStr.append("  b.description, ");
		sqlStr.append("  a.REGION_ID, ");
		sqlStr.append("  '' ORG_NAME, ");
		sqlStr.append("  a.create_staff_id, ");
		sqlStr.append("  (SELECT sta.staff_name ");
		sqlStr.append("     FROM SECHB.SEC_STAFF sta, SECHB.SEC_OPERATOR ope ");
		sqlStr.append("    WHERE a.create_staff_id = to_char (ope.OPERATOR_ID) ");
		sqlStr.append("     AND to_char (sta.STAFF_ID) = to_char (ope.STAFF_ID)) ");
		sqlStr.append("  create_staff_name, ");
		sqlStr.append("       '--' corporation1, ");
		sqlStr.append("       (SELECT nvl (organize_name, '--') ");
		sqlStr.append("          FROM sechb.sec_organize c ");
		sqlStr.append("         WHERE c.organize_id = a.region_id) ");
		sqlStr.append("          create_corporation     ");
		sqlStr.append("  FROM vm_wf a, ");
		sqlStr.append("  (SELECT workflow_id,   ");
		sqlStr.append("  TASK_TAG, ");
		sqlStr.append("  TASK_ID, ");
		sqlStr.append("  LABEL AS TLABEL, ");
		sqlStr.append("  CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("  DECISION_RESULT, ");
		sqlStr.append("  STATE, ");
		sqlStr.append("  STATION_ID, ");
		sqlStr.append("  TASK_STAFF_ID, ");
		sqlStr.append("  task_type, ");
		sqlStr.append("  description ERROR_MESSAGE, ");
		sqlStr.append("  task_template_id, ");
		sqlStr.append("  FINISH_STAFF_ID, ");
		sqlStr.append("  FINISH_DATE, ");
		sqlStr.append("  description ");
		sqlStr.append("    FROM VM_TASK ");
		sqlStr.append("   WHERE state = '5' ");
		sqlStr.append("   AND TASK_STAFF_ID IN (  "+ staffstr.toString() +" )");
		sqlStr.append("  UNION ALL                 ");
		sqlStr.append("  SELECT workflow_id, ");
		sqlStr.append("  TASK_TAG,         ");
		sqlStr.append("  TASK_ID, ");
		sqlStr.append("  LABEL AS TLABEL, ");
		sqlStr.append("  CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("  DECISION_RESULT, ");
		sqlStr.append("  STATE, ");
		sqlStr.append("  STATION_ID, ");
		sqlStr.append("  TASK_STAFF_ID, ");
		sqlStr.append("  task_type, ");
		sqlStr.append("  description ERROR_MESSAGE, ");
		sqlStr.append("  task_template_id, ");
		sqlStr.append("  FINISH_STAFF_ID, ");
		sqlStr.append("  FINISH_DATE, ");
		sqlStr.append("  description ");
		sqlStr.append("   FROM VM_TASK_TS ");
		sqlStr.append("  WHERE state = '5'  ");
		sqlStr.append("  AND TASK_STAFF_ID IN ( "+ staffstr.toString() +" )"+" ) b ");
		sqlStr.append("           WHERE a.WORKFLOW_ID = b.WORKFLOW_ID ");
		sqlStr.append("  and a.WORKFLOW_OBJECT_TYPE like '%"+ caseType +"%' ) ) data01, ");
		sqlStr.append(" ( SELECT ID recordId, ");
		sqlStr.append("         apply_name, ");
		sqlStr.append("         principal, ");
		sqlStr.append("         create_time ");
		sqlStr.append("    FROM SALE_WEAPON_MAIN_T sw ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT order_id recordId, ");
		sqlStr.append("         order_name apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_date create_time ");
		sqlStr.append("    FROM sale_order_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT MAIN_ID recordId,      ");
		sqlStr.append("         REAMRK_1 apply_name, ");
		sqlStr.append("         PRINCIPLE principal, ");
		sqlStr.append("         CREATE_TIME create_time          ");
		sqlStr.append("    FROM CHARGE_MAIN_T sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select ACCESS_ID recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           CREATE_TIME create_time "); 
		sqlStr.append("      from ACCESS_CHANGE_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select busi_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from BUSI_CHANGE_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select recordId, ");
		sqlStr.append("           apply_name, "); 
		sqlStr.append("    	    principal ,  "); 
		sqlStr.append("           apply_time create_time "); 
		sqlStr.append("      from PRODUCT_BOSSID_APPLY_T sm "); 		
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT ID recordId, ");
		sqlStr.append("         apply_name, ");
		sqlStr.append("         principal, ");
		sqlStr.append("         create_time ");
		sqlStr.append("    FROM sale_batch_prestore_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT ID recordId, ");
		sqlStr.append("         '协助配置工单'||rela_order_id apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_time ");
		sqlStr.append("    FROM product_attach_cfg_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT mainid recordId, ");
		sqlStr.append("         apply_name, ");
		sqlStr.append("         principal, ");
		sqlStr.append("         prop_time create_time ");
		sqlStr.append("    FROM stop_selling_main_t sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select complains_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from ORDER_COMPLAINS_T oct "); 
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select RESOURCE_ID recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from RESOURCE_CHANGE_T rc "); 
		sqlStr.append(") data02 ");
		sqlStr.append("  WHERE data01.WORKFLOW_OBJECT_ID = TO_CHAR(data02.recordId) ");
		sqlStr.append("  ) data03");	
		if(startNum < endNum){
			String citer01 = " where row_index >=:startNum and row_index<=:endNum ";
			sqlStr.append(citer01);
		}
		HashMap<String,String> parameter = new HashMap<String,String>();
		parameter.put("staffstr", staffstr.toString());
		parameter.put("startNum", String.valueOf(startNum));
		parameter.put("endNum",  String.valueOf(endNum));
        
		IBOCurTaskValue[] curTask = BOCurTaskEngine.getBeansFromSql(sqlStr.toString(), parameter);
		System.out.println("取出 "+curTask.length+" 条任务记录！");
		return curTask;
	}

	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间查询所有已处理工单
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOFinishTaskValue[] getFinishTask(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname,int startNum, int endNum) throws Exception,RuntimeException{
		IBOFinishTaskValue[] finishTask;
		StringBuffer sqlStr = new StringBuffer();
		HashMap<String,String> parameter = new HashMap<String,String>();
		sqlStr.append(" SELECT row_index, WORKFLOW_ID,TEMPLATE_TAG,WORKFLOW_OBJECT_TYPE,OBJECT_TYPE_NAME,WORKFLOW_OBJECT_ID,CREATE_DATE,LABEL,REGION_ID,create_staff_id,STAFF_NAME,department,org_name,apply_name from ( ");
		sqlStr.append(" SELECT rownumber () OVER ( order by CREATE_DATE desc ) AS row_index, WORKFLOW_ID,TEMPLATE_TAG,WORKFLOW_OBJECT_TYPE,OBJECT_TYPE_NAME,WORKFLOW_OBJECT_ID,CREATE_DATE,LABEL,REGION_ID,create_staff_id,STAFF_NAME,department,org_name,apply_name from ( ");
		sqlStr.append(" SELECT  ");
		sqlStr.append("        WORKFLOW_ID, ");
		sqlStr.append("        TEMPLATE_TAG, ");
		sqlStr.append("        WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("        OBJECT_TYPE_NAME, ");
		sqlStr.append("        WORKFLOW_OBJECT_ID, ");
		sqlStr.append("        CREATE_DATE, ");
		sqlStr.append("        LABEL, ");
		sqlStr.append("        REGION_ID, ");
		sqlStr.append("        create_staff_id, ");
		sqlStr.append("        STAFF_NAME, ");
		sqlStr.append("        department, ");
		sqlStr.append("        org_name, ");
		sqlStr.append("        apply_name ");
		sqlStr.append("   FROM (SELECT DISTINCT ");
		sqlStr.append("                a.WORKFLOW_ID, ");
		sqlStr.append("                a.TEMPLATE_TAG, ");
		sqlStr.append("  			   a.WORKFLOW_OBJECT_TYPE WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("                a.WORKFLOW_OBJECT_TYPE OBJECT_TYPE_NAME, ");
		sqlStr.append("                a.WORKFLOW_OBJECT_ID, ");
		sqlStr.append("                a.CREATE_DATE, ");
		sqlStr.append("                a.LABEL, ");
		sqlStr.append("                a.REGION_ID, ");
		sqlStr.append("                a.create_staff_id, ");
		sqlStr.append("                (SELECT value (sta.STAFF_NAME, '') ");
		sqlStr.append("                   FROM SECHB.SEC_STAFF sta, SECHB.SEC_OPERATOR ope ");
		sqlStr.append("                  WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                    AND char (ope.OPERATOR_ID) = a.create_staff_id) STAFF_NAME, ");
		sqlStr.append("                (SELECT value (org.organize_name, '') ");
		sqlStr.append("                   FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                        SECHB.SEC_OPERATOR ope, ");
		sqlStr.append("                        SECHB.SEC_ORGANIZE org ");
		sqlStr.append("                  WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                    AND char (ope.OPERATOR_ID) = value (a.create_staff_id, '0') ");
		sqlStr.append("                    AND sta.organize_id = org.organize_id) department, ");
		sqlStr.append("                (SELECT value (org.organize_name, '') ");
		sqlStr.append("                   FROM SECHB.SEC_ORGANIZE org ");
		sqlStr.append("                  WHERE org.organize_id = a.REGION_ID) org_name ");
		sqlStr.append("           FROM vm_wf a ");
		sqlStr.append("          WHERE (create_staff_id = :staffId ");
		sqlStr.append("                OR a.WORKFLOW_ID IN ");
		sqlStr.append("                      (SELECT workflow_id ");
		sqlStr.append("                         FROM VM_TASK ");
		sqlStr.append("                        WHERE state <> '5' AND (TASK_STAFF_ID = :staffId or FINISH_STAFF_ID = :staffId ) ");
		sqlStr.append("                       UNION ALL ");
		sqlStr.append("                       SELECT workflow_id ");
		sqlStr.append("                         FROM VM_TASK_TS ");
		sqlStr.append("                        WHERE state <> '5' AND (TASK_STAFF_ID = :staffId or FINISH_STAFF_ID = :staffId ) ))");
        if(StringUtil.isNotBlank(beginTime)){
			sqlStr.append(" AND CREATE_DATE>=:beginTime ");
			parameter.put("beginTime", beginTime);
		}

		if(StringUtil.isNotBlank(endTime)){
			sqlStr.append(" and CREATE_DATE<=:endTime ");	
			parameter.put("endTime", endTime);
		}
		sqlStr.append(") data01, ");
		sqlStr.append("        (SELECT ID recordId, ");
		sqlStr.append("                apply_name, ");
		sqlStr.append("                principal, ");
		sqlStr.append("                create_time ");
		sqlStr.append("           FROM SALE_WEAPON_MAIN_T sw ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("  SELECT order_id recordId, ");
		sqlStr.append("         order_name apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_date create_time ");
		sqlStr.append("    FROM sale_order_t sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("         SELECT MAIN_ID recordId, ");
		sqlStr.append("                REAMRK_1 apply_name, ");
		sqlStr.append("                PRINCIPLE principal, ");
		sqlStr.append("                CREATE_TIME create_time ");
		sqlStr.append("           FROM CHARGE_MAIN_T sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select ACCESS_ID recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           CREATE_TIME create_time "); 
		sqlStr.append("      from ACCESS_CHANGE_T sm "); 	
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select busi_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from BUSI_CHANGE_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select recordId, ");
		sqlStr.append("           apply_name, "); 
		sqlStr.append("    	    principal ,  "); 
		sqlStr.append("           apply_time create_time "); 
		sqlStr.append("      from PRODUCT_BOSSID_APPLY_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("         SELECT ID recordId, ");
		sqlStr.append("                apply_name, ");
		sqlStr.append("                principal, ");
		sqlStr.append("                create_time ");
		sqlStr.append("           FROM sale_batch_prestore_t sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("  SELECT ID recordId, ");
		sqlStr.append("         '协助配置工单'||rela_order_id apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_time ");
		sqlStr.append("    FROM product_attach_cfg_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT mainid recordId, ");
		sqlStr.append("         apply_name, ");
		sqlStr.append("         principal, ");
		sqlStr.append("         prop_time create_time ");
		sqlStr.append("    FROM stop_selling_main_t sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select complains_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from ORDER_COMPLAINS_T oct "); 
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select RESOURCE_ID recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from RESOURCE_CHANGE_T rc "); 	
		sqlStr.append(" ) data02 ");
		sqlStr.append("  WHERE data01.WORKFLOW_OBJECT_ID = data02.recordId ");
		if(StringUtil.isNotBlank(applyname)){
			sqlStr.append(" and data02.apply_name like '%"+applyname.trim()+"%' ");
		}
		if(StringUtil.isNotBlank(objectid)){
			sqlStr.append(" and data02.recordId like '%"+objectid.trim()+"%' ");
		}
		if(StringUtil.isNotBlank(corporation)){
			sqlStr.append(" and data01.org_name like '%"+corporation.trim()+"%' ");
		}
		if(StringUtil.isNotBlank(staffname)){
			sqlStr.append(" and data01.STAFF_NAME like '%"+staffname.trim()+"%' ");
		}
		sqlStr.append("  )data03  ");
		sqlStr.append("  )data04  ");
        sqlStr.append(" where 1=1 ");

         if(startNum < endNum){
			String citer01 = " and row_index >=:startNum and row_index<=:endNum ";
			sqlStr.append(citer01);
		}

		parameter.put("staffId", staffId);
		parameter.put("startNum", String.valueOf(startNum));
		parameter.put("endNum", String.valueOf(endNum));
		
		finishTask = BOFinishTaskEngine.getBeansFromSql(sqlStr.toString(), parameter);
		System.out.println("共取出已办未结事项："+finishTask.length+" 条！");
		return finishTask;
	}

	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间查询所有已归档工单
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOHistoryTaskValue[] getHistoryTask(String staffId,String beginTime,String endTime) throws Exception,RuntimeException{
		//获取员工orgId
		UserInfoInterface user = SessionManager.getUser();
		String orgId = String.valueOf(user.getOrgId()).substring(0, 2);

		//查询roleid
		List roles = getRole(staffId);
		StringBuffer roleStr = new StringBuffer("");
		if(roles.size()!=0){
			Iterator ite = roles.iterator();
			while(ite.hasNext()){
				String role=ite.next().toString();
				roleStr.append(role);
				roleStr.append(",");
			}
			roleStr.deleteCharAt(roleStr.lastIndexOf(","));
		}
		StringBuffer condition = new StringBuffer(); 
		
		//如果是省公司的人，则任何地市的单子都可以看（只要有角色）
		if(orgId.equals("10")){
			String str01  = "state in('3') and ";
			condition.append(str01);
		}else{
			String str02 = "state in('3') and (REGION_ID=:orgId or REGION_ID='10') and ";
			condition.append(str02);
		}
		
		IBOHistoryTaskValue[] historyTask;
		String vstate="3";
		HashMap<String,String> parameter = new HashMap<String,String>();

		if(roles.size()!=0){
			String str03 = " ( "+IBOHistoryTaskValue.S_StationId+" in("+roleStr.toString() +") OR"+" "+IBOHistoryTaskValue.S_FinishStaffId+"=:staffId "+" ) ";
			condition.append(str03);
		}else{
			String str04 = IBOCurTaskValue.S_FinishStaffId+"=:staffId";
			condition.append(str04);
		}

		if(beginTime != null){
			String begin = " and "+IBOCurTaskValue.S_FinishDate+">=to_date(:beginTime ,'yyyymmdd hh24:mi:ss')";
			condition = condition.append(begin);
		}
		parameter.put("beginTime", beginTime);
		
		if(endTime != null){
			String end = " and "+IBOCurTaskValue.S_FinishDate+"<=to_date(:endTime ,'yyyymmdd hh24:mi:ss')";
			condition = condition.append(end);
		}
		parameter.put("endTime", endTime);
		parameter.put("staffId", staffId);
		parameter.put("vstate", vstate);
		parameter.put("orgId", orgId);

		historyTask = BOHistoryTaskEngine.getBeans(condition.toString(), parameter);
		
		return historyTask;
	}

	/**
	 * 说明:根据工单ID、工单类型查询工单审批意见
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOCurTaskValue[] getReasons(String recordId,String recordType) throws Exception,RuntimeException{
		IBOCurTaskValue[] curTask;
		String vstate="3";
		String basecond = "state=:vstate and "+IBOCurTaskValue.S_WorkflowObjectId+" =:recordId and"+" "+IBOCurTaskValue.S_ObjectTypeName+"=:recordType";
		HashMap<String,String> parameter = new HashMap<String,String>();
		
		parameter.put("recordId", recordId);
		parameter.put("recordType", recordType);
		parameter.put("vstate", vstate);
		
		curTask = BOCurTaskEngine.getBeans(basecond, parameter);
		return curTask;
	}
	
	/**
	 * 说明:根据workflowId查询出所有已归档的的已完成任务
	 * workflowId:流程ID
	 * **/
	public IBOCurTaskValue[] getAllHistoryTaskByWorkFlowId(String workflowId,int startNum, int endNum) throws Exception,RuntimeException{
		IBOCurTaskValue[] historyTask;
		StringBuffer sqlStr=new StringBuffer();
		sqlStr.append("");
		sqlStr.append(" SELECT WORKFLOW_ID, ");
		sqlStr.append("        TEMPLATE_TAG, ");
		sqlStr.append("        TASK_TAG, ");
		sqlStr.append("        WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("        OBJECT_TYPE_NAME, ");
		sqlStr.append("        WORKFLOW_OBJECT_ID, ");
		sqlStr.append("        CREATE_DATE, ");
		sqlStr.append("        LABEL, ");
		sqlStr.append("        TASK_ID, ");
		sqlStr.append("        TLABEL, ");
		sqlStr.append("        TASK_DATE, ");
		sqlStr.append("        DECISION_RESULT, ");
		sqlStr.append("        STATE_NAME, ");
		sqlStr.append("        STATE, ");
		sqlStr.append("        STATION_ID, ");
		sqlStr.append("        TASK_STAFF_ID, ");
		sqlStr.append("        TASK_STAFF_NAME, ");
		sqlStr.append("        ERROR_MESSAGE, ");
		sqlStr.append("        task_template_id, ");
		sqlStr.append("        STAFF_NAME, ");
		sqlStr.append("        FINISH_STAFF_ID, ");
		sqlStr.append("        FINISH_DATE, ");
		sqlStr.append("        description, ");
		sqlStr.append("        REGION_ID, ");
		sqlStr.append("        ORG_NAME, ");
		sqlStr.append("        create_staff_name, ");
		sqlStr.append("        create_time, ");
		sqlStr.append("        apply_name, ");
		sqlStr.append("        create_staff_id, ");
		sqlStr.append("        corporation, ");
		sqlStr.append("        create_corporation, ' ' next_task  ");
		sqlStr.append("   FROM (SELECT WORKFLOW_ID, ");
		sqlStr.append("                TEMPLATE_TAG, ");
		sqlStr.append("                TASK_TAG, ");
		sqlStr.append("                WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("                OBJECT_TYPE_NAME, ");
		sqlStr.append("                WORKFLOW_OBJECT_ID, ");
		sqlStr.append("                CREATE_DATE, ");
		sqlStr.append("                LABEL, ");
		sqlStr.append("                TASK_ID, ");
		sqlStr.append("                (CASE WHEN TLABEL LIKE '%~%' ");
		sqlStr.append("                    THEN substr (TLABEL, 1, locate ('~', TLABEL, 1) - 1) ");
		sqlStr.append("                    ELSE TLABEL END) TLABEL, ");
		sqlStr.append("                TASK_DATE, ");
		sqlStr.append("                DECISION_RESULT, ");
		sqlStr.append("                STATE_NAME, ");
		sqlStr.append("                STATE, ");
		sqlStr.append("                STATION_ID, ");
		sqlStr.append("                TASK_STAFF_ID, ");
		sqlStr.append("                TASK_STAFF_NAME, ");
		sqlStr.append("                ERROR_MESSAGE, ");
		sqlStr.append("                task_template_id, ");
		sqlStr.append("                STAFF_NAME, ");
		sqlStr.append("                FINISH_STAFF_ID, ");
		sqlStr.append("                FINISH_DATE, ");
		sqlStr.append("                description, ");
		sqlStr.append("                REGION_ID, ");
		sqlStr.append("                ORG_NAME, ");
		sqlStr.append("                create_staff_id, ");
		sqlStr.append("                create_staff_name, ");
		sqlStr.append("                (CASE ");
		sqlStr.append("                    WHEN corporation1 IS NULL THEN create_corporation ");
		sqlStr.append("                    ELSE corporation1 END) corporation, ");
		sqlStr.append("                create_corporation ");
		sqlStr.append("           FROM (SELECT a.WORKFLOW_ID, ");
		sqlStr.append("                        a.TEMPLATE_TAG, ");
		sqlStr.append("                        b.TASK_TAG, ");
		sqlStr.append("  					   a.WORKFLOW_OBJECT_TYPE WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("                        a.WORKFLOW_OBJECT_TYPE OBJECT_TYPE_NAME, ");
		sqlStr.append("                        a.WORKFLOW_OBJECT_ID, ");
		sqlStr.append("                        a.CREATE_DATE, ");
		sqlStr.append("                        a.LABEL, ");
		sqlStr.append("                        b.TASK_ID, ");
		sqlStr.append("                        b.TLABEL, ");
		sqlStr.append("                        b.TASK_DATE, ");
		sqlStr.append("                        b.DECISION_RESULT, ");
		sqlStr.append("                        (CASE WHEN b.STATE = '5' THEN '等待办理' ");
		sqlStr.append("                            WHEN b.STATE = '3' THEN '已经完成' ");
		sqlStr.append("                            WHEN b.STATE = '2' THEN '可调度' ");
		sqlStr.append("                            WHEN b.STATE = '1' THEN '不能调度' ");
		sqlStr.append("                            WHEN b.STATE = '4' THEN '终止' ");
		sqlStr.append("                            WHEN b.STATE = '6' THEN '任务回退' ");
		sqlStr.append("                            WHEN b.STATE = '10' THEN '任务转派' ");
		sqlStr.append("                            WHEN b.STATE = '11' THEN '异常结束' ");
		sqlStr.append("                            ELSE '其他状态' END) STATE_NAME, ");
		sqlStr.append("                        b.STATE, ");
		sqlStr.append("                        b.STATION_ID, ");
		sqlStr.append("                        b.TASK_STAFF_ID, ");
		sqlStr.append("                        (CASE  WHEN task_type in ('user','sign') ");
		sqlStr.append("                            THEN ");
		sqlStr.append("                               (SELECT value (sta.STAFF_NAME, '') ");
		sqlStr.append("                                  FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                                       SECHB.SEC_OPERATOR ope ");
		sqlStr.append("                                 WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                       AND char (ope.OPERATOR_ID) = value (b.TASK_STAFF_ID, '0')) ");
		sqlStr.append("                            WHEN task_type = 'start' ");
		sqlStr.append("                            THEN ");
		sqlStr.append("                               (SELECT value (sta.STAFF_NAME, '') ");
		sqlStr.append("                                  FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                                       SECHB.SEC_OPERATOR ope ");
		sqlStr.append("                                 WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                       AND char (ope.OPERATOR_ID) = value (a.create_staff_id, '0')) ");
		sqlStr.append("                            ELSE ' ' END) TASK_STAFF_NAME, ");
		sqlStr.append("                        b.description ERROR_MESSAGE, ");
		sqlStr.append("                        b.task_template_id, ");
		sqlStr.append("                        b.FINISH_STAFF_ID, ");
		sqlStr.append("                        (SELECT value (sta.STAFF_NAME, '') ");
		sqlStr.append("                           FROM SECHB.SEC_STAFF sta, SECHB.SEC_OPERATOR ope ");
		sqlStr.append("                          WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                AND char (ope.OPERATOR_ID) = value (b.FINISH_STAFF_ID, '0')) STAFF_NAME, ");
		sqlStr.append("                        b.FINISH_DATE, ");
		sqlStr.append("                        b.description, ");
		sqlStr.append("                        a.REGION_ID, ");
		sqlStr.append("                        (CASE WHEN task_type in ('user','sign') THEN ");
		sqlStr.append("                               (SELECT value (org.organize_name, '') ");
		sqlStr.append("                                  FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                                       SECHB.SEC_OPERATOR ope, ");
		sqlStr.append("                                       SECHB.SEC_ORGANIZE org ");
		sqlStr.append("                                 WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                       AND char (ope.OPERATOR_ID) = ");
		sqlStr.append("                                              value (b.TASK_STAFF_ID, '0') ");
		sqlStr.append("                                       AND sta.organize_id = org.organize_id) ");
		sqlStr.append("                            WHEN task_type = 'start' ");
		sqlStr.append("                            THEN (SELECT value (org.organize_name, '') ");
		sqlStr.append("                                  FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                                       SECHB.SEC_OPERATOR ope, ");
		sqlStr.append("                                       SECHB.SEC_ORGANIZE org ");
		sqlStr.append("                                 WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                       AND char (ope.OPERATOR_ID) = value (a.create_staff_id, '0') ");
		sqlStr.append("                                       AND sta.organize_id = org.organize_id) ");
		sqlStr.append("                            ELSE ' ' END) ORG_NAME, ");
		sqlStr.append("                        a.create_staff_id, ");
		sqlStr.append("                       (SELECT sta.staff_name ");
		sqlStr.append("                           FROM SECHB.SEC_STAFF sta, SECHB.SEC_OPERATOR ope ");
		sqlStr.append("                          WHERE a.create_staff_id = to_char (ope.OPERATOR_ID) ");
		sqlStr.append("                                AND to_char (sta.STAFF_ID) = to_char (ope.STAFF_ID)) ");
		sqlStr.append("                           create_staff_name,    ");                    
		sqlStr.append("                        (SELECT value (org.organize_name, '') ");
		sqlStr.append("                           FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                                SECHB.SEC_OPERATOR ope, ");
		sqlStr.append("                                SECHB.SEC_ORGANIZE org ");
		sqlStr.append("                          WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                                AND char (ope.OPERATOR_ID) = value (b.TASK_STAFF_ID, '0') ");
		sqlStr.append("                                AND substr (sta.organize_id, 1, 2) = org.organize_id) corporation1, ");
		sqlStr.append("                        (SELECT nvl (organize_name, '--') ");
		sqlStr.append("                           FROM sechb.sec_organize c ");
		sqlStr.append("                          WHERE c.organize_id = a.region_id) create_corporation ");
		sqlStr.append("                   FROM h_vm_wf a, ");
		sqlStr.append("                        (SELECT workflow_id, ");
		sqlStr.append("                                TASK_TAG, ");
		sqlStr.append("                                TASK_ID, ");
		sqlStr.append("                                LABEL AS TLABEL, ");
		sqlStr.append("                                CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("                                DECISION_RESULT, ");
		sqlStr.append("                                STATE, ");
		sqlStr.append("                                STATION_ID, ");
		sqlStr.append("                                TASK_STAFF_ID, ");
		sqlStr.append("                                task_type, ");
		sqlStr.append("                                ERROR_MESSAGE, ");
		sqlStr.append("                                task_template_id, ");
		sqlStr.append("                                FINISH_STAFF_ID, ");
		sqlStr.append("                                FINISH_DATE, ");
		sqlStr.append("                                description ");
		sqlStr.append("                           FROM h_VM_TASK ");
		sqlStr.append(" WHERE workflow_id = '"+workflowId+"'");
		sqlStr.append("                                AND task_type IN ('user', 'start','finish') ");
		sqlStr.append("                                AND state IN (3,5) ");
		sqlStr.append("                         UNION ALL ");
		sqlStr.append("                         SELECT workflow_id, ");
		sqlStr.append("                                TASK_TAG, ");
		sqlStr.append("                                TASK_ID, ");
		sqlStr.append("                                LABEL AS TLABEL, ");
		sqlStr.append("                                CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("                                DECISION_RESULT, ");
		sqlStr.append("                                STATE, ");
		sqlStr.append("                                STATION_ID, ");
		sqlStr.append("                                TASK_STAFF_ID, ");
		sqlStr.append("                                task_type, ");
		sqlStr.append("                                ERROR_MESSAGE, ");
		sqlStr.append("                                task_template_id, ");
		sqlStr.append("                                FINISH_STAFF_ID, ");
		sqlStr.append("                                FINISH_DATE, ");
		sqlStr.append("                                ERROR_MESSAGE description ");
		sqlStr.append("                           FROM h_VM_TASK_TS ");
		sqlStr.append(" WHERE workflow_id = '"+workflowId+"'" );
		sqlStr.append("                                AND task_type IN ('user', 'sign') ");
		sqlStr.append("                                AND state IN (3,5) ");
		sqlStr.append("                                AND ( (FINISH_STAFF_ID = TASK_STAFF_ID) ");
		sqlStr.append("                                     OR FINISH_STAFF_ID IS NULL)) b ");
		sqlStr.append("                  WHERE a.WORKFLOW_ID = b.WORKFLOW_ID ");
		sqlStr.append("  and a.WORKFLOW_ID ='"+workflowId+"'");
		sqlStr.append("                        AND task_type IN ('user', 'start','sign','finish'))) data01, ");
		sqlStr.append("        (SELECT id recordId, ");
		sqlStr.append("                apply_name, ");
		sqlStr.append("                principal, ");
		sqlStr.append("                create_time ");
		sqlStr.append("           FROM SALE_WEAPON_MAIN_T sw ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("  SELECT order_id recordId, ");
		sqlStr.append("         order_name apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_date create_time ");
		sqlStr.append("    FROM sale_order_t sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("         SELECT MAIN_ID recordId, ");
		sqlStr.append("                REAMRK_1 apply_name, ");
		sqlStr.append("                PRINCIPLE principal, ");
		sqlStr.append("                CREATE_TIME create_time ");
		sqlStr.append("           FROM CHARGE_MAIN_T ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select ACCESS_ID recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           CREATE_TIME create_time "); 
		sqlStr.append("      from ACCESS_CHANGE_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select busi_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from BUSI_CHANGE_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select recordId, ");
		sqlStr.append("           apply_name, "); 
		sqlStr.append("    	    principal ,  "); 
		sqlStr.append("           apply_time create_time "); 
		sqlStr.append("      from PRODUCT_BOSSID_APPLY_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("         SELECT id recordId, ");
		sqlStr.append("                apply_name, ");
		sqlStr.append("                principal, ");
		sqlStr.append("                create_time ");
		sqlStr.append("           FROM sale_batch_prestore_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT mainid recordId, ");
		sqlStr.append("         apply_name, ");
		sqlStr.append("         principal, ");
		sqlStr.append("         prop_time create_time ");
		sqlStr.append("    FROM stop_selling_main_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT ID recordId, ");
		sqlStr.append("         '协助配置工单'||rela_order_id apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_time ");
		sqlStr.append("    FROM product_attach_cfg_t sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select complains_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from ORDER_COMPLAINS_T oct "); 
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select RESOURCE_ID recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from RESOURCE_CHANGE_T rc "); 
		sqlStr.append("      ) data02 ");
		sqlStr.append("  WHERE data01.WORKFLOW_OBJECT_ID = TO_CHAR(data02.recordId) ");
		sqlStr.append(" ORDER BY TASK_ID asc");		

		HashMap<String,String> parameter = new HashMap<String,String>();
		parameter.put("workflowId", workflowId);
		historyTask = BOCurTaskEngine.getBeansFromSql(sqlStr.toString(), parameter);
		int taskcnt = historyTask.length;
		for(int i=0;i < taskcnt-1; i++){
			historyTask[i].setErrorMessage("");
			int end = historyTask[i].getDescription().indexOf("|");
			if(end>=0){
				historyTask[i].setNextTask(historyTask[i].getDescription().substring(0, end));
				historyTask[i].setDescription(historyTask[i].getDescription().substring(end+1, historyTask[i].getDescription().length()));
				
			}else{
				historyTask[i].setNextTask(historyTask[i+1].getTlabel());
			}
		}
		
		return historyTask;
	}

	/**
	 * 说明:根据workflowId查询出所有已归档的的已完成任务数
	 * workflowId:流程ID
	 * **/
	public int getAllHistoryTaskCount(String workflowId) throws Exception,RuntimeException{
		HashMap<String,String> parameter = new HashMap<String,String>();
		parameter.put("workflowId", workflowId);
		
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("SELECT workflow_id, ");
		sqlStr.append("       TASK_TAG, ");
		sqlStr.append("       TASK_ID, ");
		sqlStr.append("       LABEL AS TLABEL, ");
		sqlStr.append("       CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("       STATE, ");
		sqlStr.append("       STATION_ID, ");
		sqlStr.append("       TASK_STAFF_ID, ");
		sqlStr.append("       task_type, ");
		sqlStr.append("       description ERROR_MESSAGE, ");
		sqlStr.append("       task_template_id, ");
		sqlStr.append("       FINISH_STAFF_ID, ");
		sqlStr.append("       FINISH_DATE, ");
		sqlStr.append("       description ");
		sqlStr.append("  FROM h_VM_TASK ");
		sqlStr.append(" WHERE     workflow_id = '"+workflowId+"'");
		sqlStr.append("       AND task_type IN ('user', 'start') ");
		sqlStr.append("       AND state IN (3, 5) ");
		sqlStr.append(" UNION ALL ");
		sqlStr.append(" SELECT workflow_id, ");
		sqlStr.append("       TASK_TAG, ");
		sqlStr.append("       TASK_ID, ");
		sqlStr.append("       LABEL AS TLABEL, ");
		sqlStr.append("       CREATE_DATE AS TASK_DATE, ");
		sqlStr.append("       STATE, ");
		sqlStr.append("       STATION_ID, ");
		sqlStr.append("       TASK_STAFF_ID, ");
		sqlStr.append("       task_type, ");
		sqlStr.append("       description ERROR_MESSAGE, ");
		sqlStr.append("       task_template_id, ");
		sqlStr.append("       FINISH_STAFF_ID, ");
		sqlStr.append("       FINISH_DATE, ");
		sqlStr.append("       description ");
		sqlStr.append("  FROM h_VM_TASK_TS ");
		sqlStr.append("  WHERE     workflow_id = '"+workflowId+"'");
		sqlStr.append("       AND task_type IN ('user', 'sign') ");
		sqlStr.append("       AND state IN (3, 5) ");
		sqlStr.append("       AND ( (FINISH_STAFF_ID = TASK_STAFF_ID) OR FINISH_STAFF_ID IS NULL) ");
		
		IBOAllTaskCountValue[] cntvalue = BOAllTaskCountEngine.getBeansFromSql(sqlStr.toString(), parameter);
		return cntvalue.length;
	}
	
	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间工单(如果处理多个任务，则只显示一条)
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOFinishTaskValue[] getHistoryRecord(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname,int startNum, int endNum) throws Exception,RuntimeException{
		IBOFinishTaskValue[] finishTask;
		StringBuffer sqlStr = new StringBuffer();
		HashMap<String,String> parameter = new HashMap<String,String>();

		sqlStr.append(" SELECT row_index, WORKFLOW_ID,TEMPLATE_TAG,WORKFLOW_OBJECT_TYPE,OBJECT_TYPE_NAME,WORKFLOW_OBJECT_ID,CREATE_DATE,LABEL,REGION_ID,create_staff_id,STAFF_NAME,department,org_name,apply_name from ( ");
		sqlStr.append(" SELECT rownumber () OVER ( order by CREATE_DATE desc ) AS row_index, WORKFLOW_ID,TEMPLATE_TAG,WORKFLOW_OBJECT_TYPE,OBJECT_TYPE_NAME,WORKFLOW_OBJECT_ID,CREATE_DATE,LABEL,REGION_ID,create_staff_id,STAFF_NAME,department,org_name,apply_name from ( ");
		sqlStr.append(" SELECT  ");
		sqlStr.append("        WORKFLOW_ID, ");
		sqlStr.append("        TEMPLATE_TAG, ");
		sqlStr.append("        WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("        OBJECT_TYPE_NAME, ");
		sqlStr.append("        WORKFLOW_OBJECT_ID, ");
		sqlStr.append("        CREATE_DATE, ");
		sqlStr.append("        LABEL, ");
		sqlStr.append("        REGION_ID, ");
		sqlStr.append("        create_staff_id, ");
		sqlStr.append("        STAFF_NAME, ");
		sqlStr.append("        department, ");
		sqlStr.append("        org_name, ");
		sqlStr.append("        apply_name ");
		sqlStr.append("   FROM (SELECT DISTINCT ");
		sqlStr.append("                a.WORKFLOW_ID, ");
		sqlStr.append("                a.TEMPLATE_TAG, ");
		sqlStr.append("  			   a.WORKFLOW_OBJECT_TYPE WORKFLOW_OBJECT_TYPE, ");
		sqlStr.append("                a.WORKFLOW_OBJECT_TYPE OBJECT_TYPE_NAME, ");
		sqlStr.append("                a.WORKFLOW_OBJECT_ID, ");
		sqlStr.append("                a.CREATE_DATE, ");
		sqlStr.append("                a.LABEL, ");
		sqlStr.append("                a.REGION_ID, ");
		sqlStr.append("                a.create_staff_id, ");
		sqlStr.append("                (SELECT value (sta.STAFF_NAME, '') ");
		sqlStr.append("                   FROM SECHB.SEC_STAFF sta, SECHB.SEC_OPERATOR ope ");
		sqlStr.append("                  WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                    AND char (ope.OPERATOR_ID) = a.create_staff_id) STAFF_NAME, ");
		sqlStr.append("                (SELECT value (org.organize_name, '') ");
		sqlStr.append("                   FROM SECHB.SEC_STAFF sta, ");
		sqlStr.append("                        SECHB.SEC_OPERATOR ope, ");
		sqlStr.append("                        SECHB.SEC_ORGANIZE org ");
		sqlStr.append("                  WHERE sta.STAFF_ID = ope.STAFF_ID ");
		sqlStr.append("                    AND char (ope.OPERATOR_ID) = value (a.create_staff_id, '0') ");
		sqlStr.append("                    AND sta.organize_id = org.organize_id) department, ");
		sqlStr.append("                (SELECT value (org.organize_name, '') ");
		sqlStr.append("                   FROM SECHB.SEC_ORGANIZE org ");
		sqlStr.append("                  WHERE org.organize_id = a.REGION_ID) org_name ");
		sqlStr.append("           FROM h_vm_wf a ");
		sqlStr.append("          WHERE (create_staff_id = :staffId ");
		sqlStr.append("                OR a.WORKFLOW_ID IN ");
		sqlStr.append("                      (SELECT workflow_id ");
		sqlStr.append("                         FROM h_VM_TASK ");
		sqlStr.append("                        WHERE state <> '5' AND (TASK_STAFF_ID = :staffId or FINISH_STAFF_ID = :staffId ) ");
		sqlStr.append("                       UNION ALL ");
		sqlStr.append("                       SELECT workflow_id ");
		sqlStr.append("                         FROM h_VM_TASK_TS ");
		sqlStr.append("                        WHERE state <> '5' AND (TASK_STAFF_ID = :staffId or FINISH_STAFF_ID = :staffId ) ))");
        if(StringUtil.isNotBlank(beginTime)){
			sqlStr.append(" AND CREATE_DATE>=:beginTime ");
			parameter.put("beginTime", beginTime);
		}

		if(StringUtil.isNotBlank(endTime)){
			sqlStr.append(" and CREATE_DATE<=:endTime ");	
			parameter.put("endTime", endTime);
		}
		sqlStr.append(") data01, ");
		sqlStr.append("        (SELECT ID recordId, ");
		sqlStr.append("                apply_name, ");
		sqlStr.append("                principal, ");
		sqlStr.append("                create_time ");
		sqlStr.append("           FROM SALE_WEAPON_MAIN_T sw ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("  SELECT order_id recordId, ");
		sqlStr.append("         order_name apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_date create_time ");
		sqlStr.append("    FROM sale_order_t sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("         SELECT MAIN_ID recordId, ");
		sqlStr.append("                REAMRK_1 apply_name, ");
		sqlStr.append("                PRINCIPLE principal, ");
		sqlStr.append("                CREATE_TIME create_time ");
		sqlStr.append("           FROM CHARGE_MAIN_T sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select ACCESS_ID recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           CREATE_TIME create_time "); 
		sqlStr.append("      from ACCESS_CHANGE_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select busi_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from BUSI_CHANGE_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select recordId, ");
		sqlStr.append("           apply_name, "); 
		sqlStr.append("    	    principal ,  "); 
		sqlStr.append("           apply_time create_time "); 
		sqlStr.append("      from PRODUCT_BOSSID_APPLY_T sm "); 		
		sqlStr.append("         UNION ALL ");
		sqlStr.append("         SELECT ID recordId, ");
		sqlStr.append("                apply_name, ");
		sqlStr.append("                principal, ");
		sqlStr.append("                create_time ");
		sqlStr.append("           FROM sale_batch_prestore_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT ID recordId, ");
		sqlStr.append("         '协助配置工单'||rela_order_id apply_name, ");
		sqlStr.append("         principle principal, ");
		sqlStr.append("         create_time ");
		sqlStr.append("    FROM product_attach_cfg_t sm ");
		sqlStr.append("  UNION ALL ");
		sqlStr.append("  SELECT mainid recordId, ");
		sqlStr.append("         apply_name, ");
		sqlStr.append("         principal, ");
		sqlStr.append("         prop_time create_time ");
		sqlStr.append("    FROM stop_selling_main_t sm ");
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select complains_id recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from ORDER_COMPLAINS_T oct "); 
		sqlStr.append("         UNION ALL ");
		sqlStr.append("    select RESOURCE_ID recordId, ");
		sqlStr.append("           APPLY_NAME apply_name, "); 
		sqlStr.append("    	   PRINCIPLE principal ,  "); 
		sqlStr.append("           prop_time create_time "); 
		sqlStr.append("      from RESOURCE_CHANGE_T rc "); 	
		sqlStr.append(" ) data02 ");
		sqlStr.append("  WHERE data01.WORKFLOW_OBJECT_ID = data02.recordId ");
		if(StringUtil.isNotBlank(applyname)){
			sqlStr.append(" and data02.apply_name like '%"+applyname.trim()+"%' ");
		}
		if(StringUtil.isNotBlank(objectid)){
			sqlStr.append(" and data02.recordId like '%"+objectid.trim()+"%' ");
		}
		if(StringUtil.isNotBlank(corporation)){
			sqlStr.append(" and data01.org_name like '%"+corporation.trim()+"%' ");
		}
		if(StringUtil.isNotBlank(staffname)){
			sqlStr.append(" and data01.STAFF_NAME like '%"+staffname.trim()+"%' ");
		}
		sqlStr.append("  )data03  ");
		sqlStr.append("  )data04  ");
        sqlStr.append(" where 1=1 ");

		if(startNum < endNum){
			String citer01 = " and row_index >=:startNum and row_index<=:endNum ";
			sqlStr.append(citer01);
		}
		
		parameter.put("staffId", staffId);
		parameter.put("startNum", String.valueOf(startNum));
		parameter.put("endNum", String.valueOf(endNum));
		finishTask = BOFinishTaskEngine.getBeansFromSql(sqlStr.toString(), parameter);
		return finishTask;
	}
	
	
	/**
	 * 说明:根据工单ID、工单状态查询工单审批意见
	 * recordId
	 * **/
	public String getWorkflowIdByrecordId(String recordId,String state) throws Exception,RuntimeException{
		String sql="";
		BOCurTaskBean[] vmWf;
		if (state.equals("2")) {
			sql ="select * from vm_wf  where workflow_object_id='"+recordId+"'";
		} else {
			sql ="select * from h_vm_wf  where workflow_object_id='"+recordId+"'";
		}
		vmWf = BOCurTaskEngine.getBeansFromSql(sql,null);
		return  vmWf.length > 0 ? vmWf[0].getWorkflowId() : "";
	}
	
	
	
}
