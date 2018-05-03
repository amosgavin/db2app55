package com.asiainfo.common.dao.impl;

import com.ai.comframe.vm.workflow.bo.BOHVmWFBean;
import com.ai.comframe.vm.workflow.bo.BOHVmWFEngine;
import com.ai.comframe.vm.workflow.bo.BOVmWFBean;
import com.ai.comframe.vm.workflow.bo.BOVmWFEngine;
import com.asiainfo.common.bo.BOAuditInfoShowEngine;
import com.asiainfo.common.dao.interfaces.IAuditInfoShowDAO;
import com.asiainfo.common.ivalues.IBOAuditInfoShowValue;
import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.task.bo.BOVmTaskBean;
import com.asiainfo.task.bo.BOVmTaskEngine;

public class AuditInfoShowDAOImpl implements IAuditInfoShowDAO {

	@Override
	public IBOAuditInfoShowValue[] getApproveInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException {

		if (workflowId.equals("")) {
			workflowId = getWfIdByOrderId(orderId);
		}
		if (workflowId.equals(""))
			return null;
		String condition = "SELECT task.label,                               "
				+ "       org1.organize_name org,                            "
				+ "	      org2.organize_name depart,                         "
				+ "       sf.staff_name,                                     "
				+ "       task.decision_result,                              "
				+ "       task.description                                   "
				+ "  FROM (SELECT finish_staff_id,                           "
				+ "               label,                                     "
				+ "               decision_result,                           "
				+ "               description,                               "
				+ "               create_date                                "
				+ "          FROM hbsale.vm_task                             "
				+ "         WHERE     workflow_id = '"
				+ workflowId
				+ "'              AND task_type = 'user'                     "
				+ "               AND task_tag like '%-audit'                "
				+ "               AND finish_staff_id IS NOT NULL            "
				+ "        UNION ALL                                         "
				+ "        SELECT finish_staff_id,                           "
				+ "               label,                                     "
				+ "               decision_result,                           "
				+ "               description,                               "
				+ "               create_date                                "
				+ "          FROM hbsale.h_vm_task                           "
				+ "         WHERE     workflow_id = '"
				+ workflowId
				+ "'              AND task_type = 'user'                     "
				+ "               AND task_tag like '%-audit'                "
				+ "               AND finish_staff_id IS NOT NULL) task      "
				+ "       LEFT JOIN sechb.sec_operator so                    "
				+ "          ON task.finish_staff_id = so.operator_id        "
				+ "       LEFT JOIN sechb.sec_staff sf                       "
				+ "          ON so.staff_id = sf.staff_id                    "
				+ "	   left join sechb.sec_organize org1                     "
				+ "	      on substr(sf.organize_id,1,2)=org1.organize_id     "
				+ "	   left join sechb.sec_organize org2                     "
				+ "	      on sf.organize_id=org2.organize_id                 "
				+ "ORDER BY task.create_date                                 ";
		return descriptionTransfer(BOAuditInfoShowEngine.getBeansFromSql(
				condition, null));
	}

	@Override
	public IBOAuditInfoShowValue[] getSignInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException {

		if (workflowId.equals("")) {
			workflowId = getWfIdByOrderId(orderId);
		}
		if (workflowId.equals(""))
			return null;
		String condition = "SELECT task.label,                             "
				+ "		  org1.organize_name org,                          "
				+ "	      org2.organize_name depart,                       "
				+ "       sf.staff_name,                                   "
				+ "       task.decision_result,                            "
				+ "       task.description                                 "
				+ "  FROM (SELECT workflow_id,                             "
				+ "               label,                                   "
				+ "               task_tag,                                "
				+ "               task_type,                               "
				+ "               finish_staff_id,                         "
				+ "               decision_result,                         "
				+ "               error_message description,               "
				+ "               create_date                              "
				+ "          FROM hbsale.vm_task_ts                        "
				+ "        UNION                                           "
				+ "        SELECT workflow_id,                             "
				+ "               label,                                   "
				+ "               task_tag,                                "
				+ "               task_type,                               "
				+ "               finish_staff_id,                         "
				+ "               decision_result,                         "
				+ "               error_message description,               "
				+ "               create_date                              "
				+ "          FROM hbsale.h_vm_task_ts) task                "
				+ "       LEFT JOIN sechb.sec_operator so                  "
				+ "          ON task.finish_staff_id = so.operator_id      "
				+ "       LEFT JOIN sechb.sec_staff sf                     "
				+ "          ON so.staff_id = sf.staff_id                  "
				+ "       left join sechb.sec_organize org1                "
				+ "	        on substr(sf.organize_id,1,2)=org1.organize_id "
				+ "	     left join sechb.sec_organize org2                 "
				+ "	        on sf.organize_id=org2.organize_id             "
				+ " WHERE     workflow_id = '" + workflowId
				+ "'      AND task_type = 'sign'                           "
				+ "      AND task_tag like '%-sign'                        "
				+ "       AND finish_staff_id IS NOT NULL                  "
				+ "ORDER BY task.create_date                               ";
		return descriptionTransfer(BOAuditInfoShowEngine.getBeansFromSql(
				condition, null));
	}

	@Override
	public IBOAuditInfoShowValue getEstInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException {

		IBOAuditInfoShowValue[] ests = getFlowInfoByWFId(orderId, workflowId, "'st3-ch1-est'");
		if (ests.length >= 1) {
			return ests[ests.length-1];
		} else {
			return null;
		}
		//return getFlowInfoByWFId(orderId, workflowId, "'st3-ch1-est'");
	}

	@Override
	public IBOAuditInfoShowValue[] getTestInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException {

		return getFlowInfoByWFId(orderId, workflowId,
				"'st4-ch2-test','st4-ch5-test'");
	}

	@Override
	public IBOAuditInfoShowValue[] getconfInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException {

		return getFlowInfoByWFId(orderId, workflowId,
				"'st5-ch2-conf','st5-ch4-conf'");
	}

	private IBOAuditInfoShowValue[] getFlowInfoByWFId(String orderId,
			String workflowId, String taskTag) throws Exception,
			RuntimeException {

		if (workflowId.equals("")) {
			workflowId = getWfIdByOrderId(orderId);
		}
		if (workflowId.equals(""))
			return null;
		String condition = "SELECT task.label,                             "
				+ "		  org1.organize_name org,                          "
				+ "	      org2.organize_name depart,                       "
				+ "       sf.staff_name,                                   "
				+ "       task.decision_result,                            "
				+ "       task.description                                 "
				+ "  FROM (SELECT finish_staff_id,                         "
				+ "               label,                                   "
				+ "               decision_result,                         "
				+ "               description,                             "
				+ "               create_date                              "
				+ "          FROM hbsale.vm_task                           "
				+ "         WHERE     workflow_id = '"
				+ workflowId
				+ "'              AND task_type = 'user'                   "
				+ "               AND finish_staff_id IS NOT NULL          "
				+ "               AND task_tag in (                        "
				+ taskTag
				+ ")        UNION                                          "
				+ "        SELECT finish_staff_id,                         "
				+ "               label,                                   "
				+ "               decision_result,                         "
				+ "               description,                             "
				+ "               create_date                              "
				+ "          FROM hbsale.h_vm_task                         "
				+ "         WHERE     workflow_id = '"
				+ workflowId
				+ "'              AND task_type = 'user'                   "
				+ "               AND finish_staff_id IS NOT NULL          "
				+ "               AND task_tag in (                        "
				+ taskTag
				+ ")) task                                                 "
				+ "       LEFT JOIN sechb.sec_operator so                  "
				+ "          ON task.finish_staff_id = so.operator_id      "
				+ "       LEFT JOIN sechb.sec_staff sf                     "
				+ "          ON so.staff_id = sf.staff_id                  "
				+ "       left join sechb.sec_organize org1                "
				+ "	        on substr(sf.organize_id,1,2)=org1.organize_id "
				+ "	     left join sechb.sec_organize org2                 "
				+ "	        on sf.organize_id=org2.organize_id             "
				+ "ORDER BY task.create_date                               ";
		return descriptionTransfer(BOAuditInfoShowEngine.getBeansFromSql(
				condition, null));
	}

	private IBOAuditInfoShowValue[] descriptionTransfer(
			IBOAuditInfoShowValue[] iValues) throws Exception {

		if (iValues == null)
			return null;
		for (int i = 0; i < iValues.length; ++i) {
			String desc = iValues[i].getDescription();
			if (StringUtil.isNotBlank(desc) && !desc.endsWith("|")) {
				iValues[i].setDescription(iValues[i].getDescription().split(
						"\\|")[1]);
			} else if (desc.endsWith("|")) {
				iValues[i].setDescription("");
			}
		}
		return iValues;
	}

	private String getWfIdByOrderId(String orderId) throws Exception {

		BOVmWFBean[] wfs = BOVmWFEngine.getBeansFromSql(
				"select * from hbsale.vm_wf where workflow_object_id = '"
						+ orderId + "'", null);
		if (wfs != null && wfs.length > 0) {
			return wfs[0].getWorkflowId();
		} else {
			BOHVmWFBean[] hwfs = BOHVmWFEngine.getBeansFromSql(
					"select * from hbsale.h_vm_wf where workflow_object_id = '"
							+ orderId + "'", null);
			if (hwfs != null && hwfs.length > 0) {
				return hwfs[0].getWorkflowId();
			}
		}
		return "";

	}

	public BOVmTaskBean getCurVMTaskByOrderId(String orderId) throws Exception {

		String wfId = getWfIdByOrderId(orderId);
		BOVmTaskBean[] task = BOVmTaskEngine.getBeans(" workflow_id='" + wfId
				+ "' and state = '5'", null);
		return (task == null || task.length < 1) ? null : task[0];
	}
}
