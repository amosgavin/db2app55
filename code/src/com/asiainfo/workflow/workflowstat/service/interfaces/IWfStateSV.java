package com.asiainfo.workflow.workflowstat.service.interfaces;

import org.apache.poi.ss.usermodel.Workbook;

import com.asiainfo.workflow.workflowstat.ivalues.IBOWorkflowStatValue;

public interface IWfStateSV {

	/**
	 * ��������������������Ͳ�ѯ����״̬��Ϣ
	 * 
	 * @param regionId
	 *            �������
	 * @param workflowObjectType
	 *            ��������
	 * @param createDateStart
	 *            ����ʱ����
	 * @param createDateEnd
	 *            ����ʱ��ֹ
	 * @param startNum
	 *            ��¼��ʼ����
	 * @param endNum
	 *            ��¼��������
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
	 * ��������������������Ͳ�ѯ����״̬��Ϣ���ܼ�¼��
	 * 
	 * @param regionId
	 *            �������
	 * @param workflowObjectType
	 *            ��������
	 * @param createDateStart
	 *            ����ʱ����
	 * @param createDateEnd
	 *            ����ʱ��ֹ
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getWfCount(String regionId, String workflowObjectType,
			String createDateStart, String createDateEnd) throws Exception,
			RuntimeException;

	/**
	 * ��������������������͵���������Ϣ
	 * 
	 * @param regionId
	 *            �������ID
	 * @param workflowObjectType
	 *            ��������
	 * @param createDateStart
	 *            ����ʱ����
	 * @param createDateEnd
	 *            ����ʱ��ֹ
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public Workbook toExcel(String regionId, String workflowObjectType,
			String createDateStart, String createDateEnd) throws Exception,
			RuntimeException;

	/**
	 * �����������ID����������ͳ�ƹ�����Ϣ
	 * 
	 * @param regionId
	 *            �������ID
	 * @param workflowObjectType
	 *            ��������
	 * @param createDateStart
	 *            ����ʱ����
	 * @param createDateEnd
	 *            ����ʱ��ֹ
	 * @return
	 * @throws Exception
	 */
	public IBOWorkflowStatValue[] getWfState(String regionId,
			String workflowObjectType, String createDateStart,
			String createDateEnd) throws Exception;

}
