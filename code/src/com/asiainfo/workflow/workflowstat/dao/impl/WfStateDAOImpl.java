package com.asiainfo.workflow.workflowstat.dao.impl;

import java.util.HashMap;

import com.asiainfo.workflow.workflowstat.bo.BOWorkflowStatEngine;
import com.asiainfo.workflow.workflowstat.dao.interfaces.IWfStateDAO;
import com.asiainfo.workflow.workflowstat.ivalues.IBOWorkflowStatValue;

/**
 * @author Administrator
 * 
 */
public class WfStateDAOImpl implements IWfStateDAO {

	/**
	 * 根据申请地区、工单类型查询工单状态信息
	 * 
	 * @param regionId
	 *            申请地区
	 * @param workflowObjectType
	 *            工单类型
	 * @param createDateStart
	 *            创建时间起
	 * @param createDateEnd
	 *            创建时间止
	 * @param startNum
	 *            记录开始索引
	 * @param endNum
	 *            记录结束索引
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOWorkflowStatValue[] getWfState(String regionId,
			String workflowObjectType, String createDateStart,
			String createDateEnd, int startNum, int endNum) throws Exception,
			RuntimeException {
		IBOWorkflowStatValue[] workflowStateList;
		// StringBuffer sqlStr = new StringBuffer();
		HashMap<String, String> parameter = new HashMap<String, String>();

		// sqlStr
		// .append(" select
		// workflow_id,region_id,staff_id,workflow_object_type");
		// sqlStr
		// .append(",workflow_object_id,create_date,nvl(label,'流程已结束') as
		// label,task_id,staff_name ");
		// sqlStr.append(" from (select tmp.*, s.staff_name ");
		// sqlStr
		// .append(" from (select wf.workflow_id,wf.region_id,wf.create_staff_id
		// as staff_id,");
		// sqlStr.append("wf.workflow_object_type,wf.workflow_object_id,");
		// sqlStr.append("wf.create_date,t.label,t.task_id from hbsale.vm_wf
		// wf");
		// sqlStr
		// .append(" left join (select distinct hbsale.vm_task.workflow_id,");
		// sqlStr
		// .append(" hbsale.vm_task.label,task_tmp.task_id from
		// hbsale.vm_task,");
		// sqlStr
		// .append("(select max(task_id) as task_id,workflow_id from
		// hbsale.vm_task");
		// sqlStr
		// .append(" group by workflow_id) task_tmp where hbsale.vm_task.task_id
		// = task_tmp.task_id");
		// sqlStr
		// .append(" and hbsale.vm_task.workflow_id = task_tmp.workflow_id) t on
		// wf.workflow_id = t.workflow_id) tmp");
		// sqlStr
		// .append(" left join sechb.sec_staff s on tmp.staff_id = s.staff_id");
		// sqlStr.append(" union ");
		// sqlStr
		// .append("select tmp.*, s.staff_name from (select
		// wf.workflow_id,wf.region_id,wf.create_staff_id as staff_id,");
		// sqlStr
		// .append("wf.workflow_object_type,wf.workflow_object_id,wf.create_date,t.label,t.task_id");
		// sqlStr
		// .append(" from hbsale.h_vm_wf wf left join (select distinct
		// hbsale.vm_task.workflow_id,");
		// sqlStr
		// .append("hbsale.vm_task.label,task_tmp.task_id from
		// hbsale.vm_task,(select max(task_id) as task_id,");
		// sqlStr
		// .append("workflow_id from hbsale.vm_task group by workflow_id)
		// task_tmp");
		// sqlStr
		// .append(" where hbsale.vm_task.task_id = task_tmp.task_id and
		// hbsale.vm_task.workflow_id =");
		// sqlStr
		// .append("task_tmp.workflow_id) t on wf.workflow_id =t.workflow_id)
		// tmp");
		// sqlStr
		// .append(" left join sechb.sec_staff s on tmp.staff_id =
		// to_char(s.staff_id)) data01");
		// sqlStr.append(" where 1=1");

		// if (!regionId.equals("") && !regionId.equals("SY")) {
		// sqlStr.append(" and data01.region_id = :regionId");
		// parameter.put("regionId", regionId);
		// }
		//
		// if (!workflowObjectType.equals("") &&
		// !workflowObjectType.equals("SY")) {
		// sqlStr
		// .append(" and data01.workflow_object_type = :workflowObjectType");
		// parameter.put("workflowObjectType", workflowObjectType);
		// }

		StringBuffer sqlCondition = new StringBuffer();
		sqlCondition.append("1=1");

		if (!regionId.equals("") && !regionId.equals("SY")) {
			sqlCondition.append(" and " + IBOWorkflowStatValue.S_RegionId
					+ " =:regionId");
			parameter.put("regionId", regionId);
		}

		if (!workflowObjectType.equals("") && !workflowObjectType.equals("SY")) {
			sqlCondition.append(" and "
					+ IBOWorkflowStatValue.S_WorkflowObjectType
					+ " =:workflowObjectType");
			parameter.put("workflowObjectType", workflowObjectType);
		}

		if (!createDateStart.equals("")) {
			sqlCondition.append(" and " + IBOWorkflowStatValue.S_CreateDate
					+ " >=:createDateStart");
			parameter.put("createDateStart", createDateStart);
		}

		if (!createDateStart.equals("")) {
			sqlCondition.append(" and " + IBOWorkflowStatValue.S_CreateDate
					+ " <=:createDateEnd");
			parameter.put("createDateEnd", createDateEnd);
		}

		// workflowStateList = BOWorkflowStatEngine.getBeansFromSql(sqlStr
		// .toString(), parameter);
		workflowStateList = BOWorkflowStatEngine.getBeans(null, sqlCondition
				.toString(), parameter, startNum, endNum, false);
		return workflowStateList;
	}

	/**
	 * 根据申请地区、工单类型查询工单状态信息总记录数
	 * 
	 * @param regionId
	 *            申请地区
	 * @param workflowObjectType
	 *            工单类型
	 * @param createDateStart
	 *            创建时间起
	 * @param createDateEnd
	 *            创建时间止
	 * 
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getWfCount(String regionId, String workflowObjectType,
			String createDateStart, String createDateEnd) throws Exception,
			RuntimeException {
		StringBuffer sqlCondition = new StringBuffer("1=1");
		HashMap<String, String> parameter = new HashMap<String, String>();

		if (!regionId.equals("") && !regionId.equals("SY")) {
			sqlCondition.append(" and " + IBOWorkflowStatValue.S_RegionId
					+ " =:regionId");
			parameter.put("regionId", regionId);
		}

		if (!workflowObjectType.equals("") && !workflowObjectType.equals("SY")) {
			sqlCondition.append(" and "
					+ IBOWorkflowStatValue.S_WorkflowObjectType
					+ " =:workflowObjectType");
			parameter.put("workflowObjectType", workflowObjectType);
		}

		if (!createDateStart.equals("")) {
			sqlCondition.append(" and " + IBOWorkflowStatValue.S_CreateDate
					+ " >=:createDateStart");
			parameter.put("createDateStart", createDateStart);
		}

		if (!createDateStart.equals("")) {
			sqlCondition.append(" and " + IBOWorkflowStatValue.S_CreateDate
					+ " <=:createDateEnd");
			parameter.put("createDateEnd", createDateEnd);
		}

		return BOWorkflowStatEngine.getBeansCount(sqlCondition.toString(),
				parameter);
	}

	/**
	 * 根据申请地区ID，申请类型统计工单信息
	 * 
	 * @param regionId
	 *            申请地区ID
	 * @param workflowObjectType
	 *            申请类型
	 * @param createDateStart
	 *            创建时间起
	 * @param createDateEnd
	 *            创建时间止
	 * @return
	 * @throws Exception
	 */
	public IBOWorkflowStatValue[] getWfState(String regionId,
			String workflowObjectType, String createDateStart,
			String createDateEnd) throws Exception {
		IBOWorkflowStatValue[] workflowStateList;
		HashMap<String, String> parameter = new HashMap<String, String>();

		StringBuffer sqlCondition = new StringBuffer();
		sqlCondition.append("1=1");

		if (!regionId.equals("") && !regionId.equals("SY")) {
			sqlCondition.append(" and " + IBOWorkflowStatValue.S_RegionId
					+ " =:regionId");
			parameter.put("regionId", regionId);
		}

		if (!workflowObjectType.equals("") && !workflowObjectType.equals("SY")) {
			sqlCondition.append(" and "
					+ IBOWorkflowStatValue.S_WorkflowObjectType
					+ " =:workflowObjectType");
			parameter.put("workflowObjectType", workflowObjectType);
		}

		if (!createDateStart.equals("")) {
			sqlCondition.append(" and " + IBOWorkflowStatValue.S_CreateDate
					+ " >=:createDateStart");
			parameter.put("createDateStart", createDateStart);
		}

		if (!createDateStart.equals("")) {
			sqlCondition.append(" and " + IBOWorkflowStatValue.S_CreateDate
					+ " <=:createDateEnd");
			parameter.put("createDateEnd", createDateEnd);
		}

		workflowStateList = BOWorkflowStatEngine.getBeans(sqlCondition
				.toString(), parameter);
		return workflowStateList;
	}

}
