package com.asiainfo.task.service.interfaces;

import com.asiainfo.task.ivalues.IBOCurTaskValue;
import com.asiainfo.task.ivalues.IBOHistoryTaskValue;
import com.asiainfo.task.ivalues.IBOFinishTaskValue;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public interface ICurTaskSV {
	
	/**
	 * 说明:根据岗位ID和员工号查询所有待处理工单
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public IBOCurTaskValue[] getCurTask(String staffId,int startNum, int endNum) throws Exception,RuntimeException;
	
	/**
	 * 说明:员工号查询待处理工单数量
	 * staffId：员工号
	 * **/
	public int getCurCount(String staffId) throws Exception,RuntimeException;

	/**
	 * 说明:根据岗位ID、员工号和工单类型查询所有待处理工单 roleId:岗位ID staffId：员工号
	 * **/
	public int getCurCountByType(String staffId, String caseType) throws Exception, RuntimeException;
	

	/**
	 * 说明:根据workflowId查询出所的任务
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public IBOCurTaskValue[] getAllTaskByWorkFlowId(String workflowId,int startNum, int endNum) throws Exception,RuntimeException;
	
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
	 * 说明:根据岗位ID、员工号、开始时间、结束时间查询所有已处理工单数量
	 * roleId:岗位ID staffId：员工号 endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public int getFinishTaskCount(String staffId, String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception, RuntimeException;	

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
	 * 说明:根据岗位ID、员工号、开始时间、结束时间工单记录数
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public int getHistoryCount(String staffId,String beginTime, String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception,RuntimeException;
	

	/**
	 * 说明:根据路径、文件名和工单ID,导出工单信息
	 * dir：绝对路径
	 * fileName:文件名
	 * mId:工单ID
	 * **/
	public Workbook toExcel(String mId,String type) throws Exception,RuntimeException;

	/*说明：根据路径、文件名和工单ID,导出营销活动信息
	 * dir：绝对路径
	 * fileName:文件名
	 * mId:工单ID
	 * */
	public Workbook exportSaleCase(String mId) throws Exception,RuntimeException;
	
	/*说明：根据路径、文件名和工单ID,导出营销活动信息
	 * dir：绝对路径
	 * fileName:文件名
	 * mId:工单ID
	 * */
	public boolean exportWeapon(String dir,String fileName,String mId) throws Exception,RuntimeException;
	
	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间工单(如果处理多个任务，则只显示一条)
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOFinishTaskValue[] getHistoryRecord(String staffId,String beginTime, String endTime,String applyname,String objectid,String corporation,String staffname,int startNum, int endNum) throws Exception,RuntimeException;
	
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
	
	/*
	 * 说明：提供给知会功能，要求根据workflow_id 查询出当前和已归档的工单流程信息
	 */
	public IBOCurTaskValue[] getTaskByWorkFlowIdForQ(String recordId,String state,int startNum, int endNum);
	
	/*
	 * 说明：提供给知会功能，要求根据workflow_id 查询出当前和已归档的工单流程数
	 */
	public int getTaskByWorkFlowIdForQCnt(String recordId,String state);
	
	public String getWorkflowIdByrecordId(String recordId,String state) throws Exception,RuntimeException;
}
