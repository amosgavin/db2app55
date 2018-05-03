package com.asiainfo.task.service.interfaces;

import com.asiainfo.task.ivalues.IBOCurTaskValue;
import com.asiainfo.task.ivalues.IBOHistoryTaskValue;
import com.asiainfo.task.ivalues.IBOFinishTaskValue;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public interface ICurTaskSV {
	
	/**
	 * ˵��:���ݸ�λID��Ա���Ų�ѯ���д�������
	 * roleId:��λID
	 * staffId��Ա����
	 * **/
	public IBOCurTaskValue[] getCurTask(String staffId,int startNum, int endNum) throws Exception,RuntimeException;
	
	/**
	 * ˵��:Ա���Ų�ѯ������������
	 * staffId��Ա����
	 * **/
	public int getCurCount(String staffId) throws Exception,RuntimeException;

	/**
	 * ˵��:���ݸ�λID��Ա���ź͹������Ͳ�ѯ���д������� roleId:��λID staffId��Ա����
	 * **/
	public int getCurCountByType(String staffId, String caseType) throws Exception, RuntimeException;
	

	/**
	 * ˵��:����workflowId��ѯ����������
	 * roleId:��λID
	 * staffId��Ա����
	 * **/
	public IBOCurTaskValue[] getAllTaskByWorkFlowId(String workflowId,int startNum, int endNum) throws Exception,RuntimeException;
	
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
	 * ˵��:���ݸ�λID��Ա���š���ʼʱ�䡢����ʱ���ѯ�����Ѵ���������
	 * roleId:��λID staffId��Ա���� endTime:����ʱ��
	 * beginTime:����ʱ��
	 * **/
	public int getFinishTaskCount(String staffId, String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception, RuntimeException;	

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
	 * ˵��:���ݸ�λID��Ա���š���ʼʱ�䡢����ʱ�乤����¼��
	 * roleId:��λID
	 * staffId��Ա����
	 * endTime:����ʱ��
	 * beginTime:����ʱ��
	 * **/
	public int getHistoryCount(String staffId,String beginTime, String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception,RuntimeException;
	

	/**
	 * ˵��:����·�����ļ����͹���ID,����������Ϣ
	 * dir������·��
	 * fileName:�ļ���
	 * mId:����ID
	 * **/
	public Workbook toExcel(String mId,String type) throws Exception,RuntimeException;

	/*˵��������·�����ļ����͹���ID,����Ӫ�����Ϣ
	 * dir������·��
	 * fileName:�ļ���
	 * mId:����ID
	 * */
	public Workbook exportSaleCase(String mId) throws Exception,RuntimeException;
	
	/*˵��������·�����ļ����͹���ID,����Ӫ�����Ϣ
	 * dir������·��
	 * fileName:�ļ���
	 * mId:����ID
	 * */
	public boolean exportWeapon(String dir,String fileName,String mId) throws Exception,RuntimeException;
	
	/**
	 * ˵��:���ݸ�λID��Ա���š���ʼʱ�䡢����ʱ�乤��(���������������ֻ��ʾһ��)
	 * roleId:��λID
	 * staffId��Ա����
	 * endTime:����ʱ��
	 * beginTime:����ʱ��
	 * **/
	public IBOFinishTaskValue[] getHistoryRecord(String staffId,String beginTime, String endTime,String applyname,String objectid,String corporation,String staffname,int startNum, int endNum) throws Exception,RuntimeException;
	
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
	
	/*
	 * ˵�����ṩ��֪�Ṧ�ܣ�Ҫ�����workflow_id ��ѯ����ǰ���ѹ鵵�Ĺ���������Ϣ
	 */
	public IBOCurTaskValue[] getTaskByWorkFlowIdForQ(String recordId,String state,int startNum, int endNum);
	
	/*
	 * ˵�����ṩ��֪�Ṧ�ܣ�Ҫ�����workflow_id ��ѯ����ǰ���ѹ鵵�Ĺ���������
	 */
	public int getTaskByWorkFlowIdForQCnt(String recordId,String state);
	
	public String getWorkflowIdByrecordId(String recordId,String state) throws Exception,RuntimeException;
}
