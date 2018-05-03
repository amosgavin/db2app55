package com.asiainfo.bi.dao.impl;

import java.net.URLDecoder;
import java.sql.Timestamp;

import com.asiainfo.bi.bo.BOTaskNodeDTEngine;
import com.asiainfo.bi.dao.interfaces.ITaskNodeDealTimeDAO;
import com.asiainfo.bi.ivalues.IBOTaskNodeDTValue;
import com.asiainfo.sale.util.StringUtil;

public class TaskNodeDealTimeDAOImpl implements ITaskNodeDealTimeDAO {

	@Override
	public IBOTaskNodeDTValue[] query(String itemId, String itemType,
			String taskReceiverOpid, String taskReceiver, String node,
			String finishDateFrom, String finishDateTo, String dayLe,
			String dayGe, String isDelay, int startNum, int endNum)
			throws Exception {

		String condition = getCondition(itemId, itemType, taskReceiverOpid,
				taskReceiver, node, finishDateFrom, finishDateTo, dayLe, dayGe,
				isDelay);
		condition += " order by task_rec_time desc ";
		return BOTaskNodeDTEngine.getBeans(null, condition, null, startNum,
				endNum, false);
	}

	@Override
	public int queryCn(String itemId, String itemType, String taskReceiverOpid,
			String taskReceiver, String node, String finishDateFrom,
			String finishDateTo, String dayLe, String dayGe, String isDelay)
			throws Exception {

		String condition = getCondition(itemId, itemType, taskReceiverOpid,
				taskReceiver, node, finishDateFrom, finishDateTo, dayLe, dayGe,
				isDelay);
		return BOTaskNodeDTEngine.getBeansCount(condition, null);
	}

	private String getCondition(String itemId, String itemType,
			String taskReceiverOpid, String taskReceiver, String node,
			String finishDateFrom, String finishDateTo, String dayLe,
			String dayGe, String isDelay) throws Exception {

		String condition = " 1=1 ";
		if (StringUtil.isNotBlank(itemId)) {
			condition += " and " + IBOTaskNodeDTValue.S_WorkflowObjectId
					+ " = " + itemId;
		}
		if (StringUtil.isNotBlank(itemType) && !itemType.equals("sy")) {
			condition += " and lower(workflow_object_type) like '%"
					+ itemType.toLowerCase() + "%'";
		}
		if (StringUtil.isNotBlank(taskReceiverOpid)) {
			condition += " and " + IBOTaskNodeDTValue.S_TaskStaffId + " = '"
					+ taskReceiverOpid + "' ";
		}
		if (StringUtil.isNotBlank(taskReceiver)) {
			condition += " and STAFF_NAME like '%"
					+ URLDecoder.decode(taskReceiver, "utf-8") + "%'";
		}
		/*
		 * if (StringUtil.isNotBlank(finishDateFrom)) { condition += " and " +
		 * IBOTaskNodeDTValue.S_FinishDate + " >= '" + finishDateFrom + "'"; }
		 * if (StringUtil.isNotBlank(finishDateTo)) { condition += " and " +
		 * IBOTaskNodeDTValue.S_FinishDate + " < '" + finishDateTo + "'"; } if
		 */
		if (StringUtil.isNotBlank(dayLe)) {
			condition += " and is_delay=0 and " + IBOTaskNodeDTValue.S_DiffDay
					+ " <= " + dayLe;
		}
		if (StringUtil.isNotBlank(dayGe)) {
			condition += " and is_delay=0 and " + IBOTaskNodeDTValue.S_DiffDay
					+ " >= " + dayGe;
		}

		if (StringUtil.isNotBlank(isDelay) && !isDelay.equals("sy")) {
			condition += " and " + IBOTaskNodeDTValue.S_IsDelay + " = '"
					+ isDelay + "'";
		}
		if (StringUtil.isBlank(node) || node.equals("pz")) {
			condition += " and task_tag in ('w05', 't15', 't0003', 't0023', 'p52', 'p06', 'p14', 'PC041', 'PC015', 'C041', 'C031', 'busi013') ";
		} else if (node.equals("test")) {
			condition += " and task_tag in ('t0004', 't0005', 'p17', 'p54', 'I019', 'C27', 'PC008') ";
		} else {
			condition += " and task_tag in ('w05', 't15', 't0003', 't0023', 'p52', 'p06', 'p14', 'PC041', 'PC015', 'C041', 'C031', 'busi013', 't0004', 't0005', 'p17', 'p54', 'I019', 'C27', 'PC008') ";
		}
		return condition;
	}

	@Override
	public int getCurrentTaskNum(String taskReceiverOpid, String itemType)
			throws Exception {

		String condition = getCondition("", itemType, taskReceiverOpid, "", "",
				"", "", "", "", "")
				+ " and task_end_time is null and advise_deal_time is not null ";
		return BOTaskNodeDTEngine.getBeansCount(condition, null);
	}

	@Override
	public Timestamp getLastTaskEndTime(String taskReceiverOpid)
			throws Exception {

		String condition = getCondition("", "", taskReceiverOpid, "", "", "",
				"", "", "", "")
				+ " and is_delay = '1' and task_end_time is null order by advise_deal_time desc fetch first row only ";
		IBOTaskNodeDTValue[] taskNodes = BOTaskNodeDTEngine.getBeans(condition,
				null);
		if (taskNodes != null && taskNodes.length > 0)
			return taskNodes[0].getAdviseDealTime();
		return null;
	}
}
