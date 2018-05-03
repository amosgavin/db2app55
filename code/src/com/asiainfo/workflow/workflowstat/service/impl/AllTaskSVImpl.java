package com.asiainfo.workflow.workflowstat.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.workflow.workflowstat.dao.interfaces.IAllTaskDAO;
import com.asiainfo.workflow.workflowstat.ivalues.IBOAllTaskStatValue;
import com.asiainfo.workflow.workflowstat.service.interfaces.IAllTaskSV;

public class AllTaskSVImpl implements IAllTaskSV {

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
			int startNum, int endNum) throws Exception, RuntimeException {
		IBOAllTaskStatValue[] taskList = null;
		taskList = ((IAllTaskDAO) ServiceFactory.getService(IAllTaskDAO.class))
				.getAllTaskByWorkFlowId(workflowId, startNum, endNum);

		return taskList;
	}

	/**
	 * ����workflowId��ѯ�����������ܼ�¼��
	 * 
	 * @param workflowId
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getAllTaskCount(String workflowId) throws Exception,
			RuntimeException {

		int cnt = ((IAllTaskDAO) ServiceFactory.getService(IAllTaskDAO.class))
				.getAllTaskCount(workflowId);

		return cnt;
	}

}
