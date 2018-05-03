package com.asiainfo.task.dao.interfaces;

import com.asiainfo.task.ivalues.IBOCurTaskValue;
import com.asiainfo.task.ivalues.IBOHistoryTaskValue;
import com.asiainfo.task.ivalues.IBOFinishTaskValue;

public interface ICurTaskDAO {
	/**
	 * ˵��:���ݸ�λID��Ա���Ų�ѯ���д�������
	 * roleId:��λID
	 * staffId��Ա����
	 * **/
	public IBOCurTaskValue[] getCurTask(String staffId,int startNum, int endNum) throws Exception,RuntimeException;

	/**
	 * ˵��:��ȡԱ��������
	 * staffId��Ա����
	 * **/
	public String getProxyStaff(String staffId)throws Exception,RuntimeException;
	
	/**
	 * ˵��:Ա���Ų�ѯ������������
	 * staffId��Ա����
	 * **/
	public int getCurCount(String staffId) throws Exception,RuntimeException;

	/**
	 * ˵��:Ա���ź͹������Ͳ�ѯ������������
	 * staffId��Ա����
	 * **/
	public int getCurCountByType(String staffId,String caseType) throws Exception,RuntimeException;

	/**
	 * ˵��:Ա���Ѱ�δ�Ṥ����
	 * staffId��Ա����
	 * **/
	public int getFinishTaskCount(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception,RuntimeException;

	/**
	 * ˵��:Ա���Ѱ�鵵������
	 * staffId��Ա����
	 * **/
	public int getHistoryTaskCount(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception,RuntimeException;
	
	/**
	 * ˵��:����workflowId��ѯ����������
	 * roleId:��λID
	 * staffId��Ա����
	 * **/
	public IBOCurTaskValue[] getAllTaskByWorkFlowId(String workflowId,int startNum, int endNum) throws Exception,RuntimeException;

	/**
	 * ˵��:����workflowId��ѯ����������
	 * roleId:��λID
	 * staffId��Ա����
	 * **/
	public IBOCurTaskValue[] getAllTaskByWorkFlowId(String workflowId) throws Exception,RuntimeException;
	
	/**
	 * ˵��:���ݸ�λID��Ա���ź͹������Ͳ�ѯ���д�������
	 * roleId:��λID
	 * staffId��Ա����
	 * 
	 * **/
	public IBOCurTaskValue[] getAllCurTaskByCaseType(String staffId,String caseType,int startNum, int endNum) throws Exception,RuntimeException;

	/**
	 * ˵��:���ݸ�λID��Ա���š���ʼʱ�䡢����ʱ���ѯ�����Ѵ�����
	 * roleId:��λID
	 * staffId��Ա����
	 * endTime:����ʱ��
	 * beginTime:����ʱ��
	 * **/
	public IBOFinishTaskValue[] getFinishTask(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname,int startNum, int endNum) throws Exception,RuntimeException;

	/**
	 * ˵��:���ݸ�λID��Ա���š���ʼʱ�䡢����ʱ���ѯ�����ѹ鵵����
	 * roleId:��λID
	 * staffId��Ա����
	 * endTime:����ʱ��
	 * beginTime:����ʱ��
	 * **/
	public IBOHistoryTaskValue[] getHistoryTask(String staffId,String beginTime,String endTime) throws Exception,RuntimeException;

	/**
	 * ˵��:���ݹ���ID���������Ͳ�ѯ�����������
	 * roleId:��λID
	 * staffId��Ա����
	 * endTime:����ʱ��
	 * beginTime:����ʱ��
	 * **/
	public IBOCurTaskValue[] getReasons(String recordId,String recordType) throws Exception,RuntimeException;

	/**
	 * ˵��:����workflowId��ѯ�������ѹ鵵�ĵ����������
	 * workflowId:����ID
	 * **/
	public IBOCurTaskValue[] getAllHistoryTaskByWorkFlowId(String workflowId,int startNum, int endNum) throws Exception,RuntimeException;

	/**
	 * ˵��:���ݸ�λID��Ա���š���ʼʱ�䡢����ʱ�乤��(���������������ֻ��ʾһ��)
	 * roleId:��λID
	 * staffId��Ա����
	 * endTime:����ʱ��
	 * beginTime:����ʱ��
	 * **/
	public IBOFinishTaskValue[] getHistoryRecord(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname,int startNum, int endNum) throws Exception,RuntimeException;
	
	/**
	 * ˵��:����workflowId��ѯ�������ѹ鵵�ĵ������������
	 * workflowId:����ID
	 * **/
	public int getAllHistoryTaskCount(String workflowId) throws Exception,RuntimeException;
	
	/**
	 * ˵��:����workflowId��ѯ���������������������
	 * roleId:��λID
	 * staffId��Ա����
	 * **/
	public int getAllCurTaskCount(String workflowId) throws Exception,RuntimeException;
	/**
	 * ˵��:���ݹ���ID������״̬��ѯ�����������
	 * recordId
	 * **/
	public String getWorkflowIdByrecordId(String recordId,String state) throws Exception,RuntimeException;
}
