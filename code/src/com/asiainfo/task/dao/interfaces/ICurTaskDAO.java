package com.asiainfo.task.dao.interfaces;

import com.asiainfo.task.ivalues.IBOCurTaskValue;
import com.asiainfo.task.ivalues.IBOHistoryTaskValue;
import com.asiainfo.task.ivalues.IBOFinishTaskValue;

public interface ICurTaskDAO {
	/**
	 * 说明:根据岗位ID和员工号查询所有待处理工单
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public IBOCurTaskValue[] getCurTask(String staffId,int startNum, int endNum) throws Exception,RuntimeException;

	/**
	 * 说明:获取员工代理人
	 * staffId：员工号
	 * **/
	public String getProxyStaff(String staffId)throws Exception,RuntimeException;
	
	/**
	 * 说明:员工号查询待处理工单数量
	 * staffId：员工号
	 * **/
	public int getCurCount(String staffId) throws Exception,RuntimeException;

	/**
	 * 说明:员工号和工单类型查询待处理工单数量
	 * staffId：员工号
	 * **/
	public int getCurCountByType(String staffId,String caseType) throws Exception,RuntimeException;

	/**
	 * 说明:员工已办未结工单数
	 * staffId：员工号
	 * **/
	public int getFinishTaskCount(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception,RuntimeException;

	/**
	 * 说明:员工已办归档工单数
	 * staffId：员工号
	 * **/
	public int getHistoryTaskCount(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception,RuntimeException;
	
	/**
	 * 说明:根据workflowId查询出所的任务
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public IBOCurTaskValue[] getAllTaskByWorkFlowId(String workflowId,int startNum, int endNum) throws Exception,RuntimeException;

	/**
	 * 说明:根据workflowId查询出所的任务
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public IBOCurTaskValue[] getAllTaskByWorkFlowId(String workflowId) throws Exception,RuntimeException;
	
	/**
	 * 说明:根据岗位ID、员工号和工单类型查询所有待处理工单
	 * roleId:岗位ID
	 * staffId：员工号
	 * 
	 * **/
	public IBOCurTaskValue[] getAllCurTaskByCaseType(String staffId,String caseType,int startNum, int endNum) throws Exception,RuntimeException;

	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间查询所有已处理工单
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOFinishTaskValue[] getFinishTask(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname,int startNum, int endNum) throws Exception,RuntimeException;

	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间查询所有已归档工单
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOHistoryTaskValue[] getHistoryTask(String staffId,String beginTime,String endTime) throws Exception,RuntimeException;

	/**
	 * 说明:根据工单ID、工单类型查询工单审批意见
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOCurTaskValue[] getReasons(String recordId,String recordType) throws Exception,RuntimeException;

	/**
	 * 说明:根据workflowId查询出所有已归档的的已完成任务
	 * workflowId:流程ID
	 * **/
	public IBOCurTaskValue[] getAllHistoryTaskByWorkFlowId(String workflowId,int startNum, int endNum) throws Exception,RuntimeException;

	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间工单(如果处理多个任务，则只显示一条)
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOFinishTaskValue[] getHistoryRecord(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname,int startNum, int endNum) throws Exception,RuntimeException;
	
	/**
	 * 说明:根据workflowId查询出所有已归档的的已完成任务数
	 * workflowId:流程ID
	 * **/
	public int getAllHistoryTaskCount(String workflowId) throws Exception,RuntimeException;
	
	/**
	 * 说明:根据workflowId查询出所的已完成任务任务数
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public int getAllCurTaskCount(String workflowId) throws Exception,RuntimeException;
	/**
	 * 说明:根据工单ID、工单状态查询工单审批意见
	 * recordId
	 * **/
	public String getWorkflowIdByrecordId(String recordId,String state) throws Exception,RuntimeException;
}
