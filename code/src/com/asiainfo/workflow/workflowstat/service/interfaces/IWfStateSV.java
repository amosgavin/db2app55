package com.asiainfo.workflow.workflowstat.service.interfaces;

import org.apache.poi.ss.usermodel.Workbook;

import com.asiainfo.workflow.workflowstat.ivalues.IBOWorkflowStatValue;

public interface IWfStateSV {

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
	 * 
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOWorkflowStatValue[] getWfState(String regionId,
			String workflowObjectType, String createDateStart,
			String createDateEnd, int startNum, int endNum) throws Exception,
			RuntimeException;

	/**
	 * 根据申请地区、工单类型查询工单状态信息的总记录数
	 * 
	 * @param regionId
	 *            申请地区
	 * @param workflowObjectType
	 *            工单类型
	 * @param createDateStart
	 *            创建时间起
	 * @param createDateEnd
	 *            创建时间止
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getWfCount(String regionId, String workflowObjectType,
			String createDateStart, String createDateEnd) throws Exception,
			RuntimeException;

	/**
	 * 根据申请地区，申请类型导出工单信息
	 * 
	 * @param regionId
	 *            申请地区ID
	 * @param workflowObjectType
	 *            工单类型
	 * @param createDateStart
	 *            创建时间起
	 * @param createDateEnd
	 *            创建时间止
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public Workbook toExcel(String regionId, String workflowObjectType,
			String createDateStart, String createDateEnd) throws Exception,
			RuntimeException;

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
			String createDateEnd) throws Exception;

}
