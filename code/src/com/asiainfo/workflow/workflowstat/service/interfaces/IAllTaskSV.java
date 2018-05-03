package com.asiainfo.workflow.workflowstat.service.interfaces;

import com.asiainfo.workflow.workflowstat.ivalues.IBOAllTaskStatValue;

public interface IAllTaskSV {
	/**
	 * ����workflowId��ѯ�����й������ѹ鵵������δ�鵵���칤����
	 * 
	 * @param workflowId
	 *            ������ID
	 * @param startNum
	 *            ��ҳ��¼��ʼ����
	 * @param endNum
	 *            ��ҳ��¼��������
	 * 
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOAllTaskStatValue[] getAllTaskByWorkFlowId(String workflowId,
			int startNum, int endNum) throws Exception, RuntimeException;

	/**
	 * ����workflowId��ѯ�����������ܼ�¼��
	 * 
	 * @param workflowId
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getAllTaskCount(String workflowId) throws Exception,
			RuntimeException;
}
