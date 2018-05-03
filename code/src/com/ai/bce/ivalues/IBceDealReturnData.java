package com.ai.bce.ivalues;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

public interface IBceDealReturnData extends Serializable {

	String[][] getCustomProperty();

	//���ڹ��췵�ص�ǰ̨����Ϣ
	void setCustomProperty(String[][] msgs);

	//�Ƿ�ɹ�
	String getIsSuccess();

	void setIsSuccess(String newIsSuccess);

	//������Ϣ
	String getErrorMsg();

	void setErrorMsg(String newErrorMsg);

	//�ɹ���Ϣ
	String getSuccessMsg();

	void setSuccessMsg(String newSuccessMsg);

	/**
	 * �������ڴ������̣�������������Ҫ����
	 */

	//�������������ģ�壬һ�㲻��Ҫ�裬����������˴����ȼ�����bce_frame.workflow_code
	void setWorkflowCode(String code);

	String getWorkflowCode();

	void setWorkflowObjectId(String objId);

	String getWorkflowObjectId();

	void setWorkflowObjectTypeId(String typeId);

	String getWorkflowObjectTypeId();

	void setWorkflowParamMap(Map paramMap);

	Map getWorkflowParamMap();

	void setWorkflowStartTime(Timestamp t);

	Timestamp getWorkflowStartTime();

	void setWorkflowNotes(String notes);

	String getWorkflowNotes();

	void setProcessReturnMap(Map map);

	Map getProcessReturnMap();

	/**
	 * ͨ�����ʻ����������ʾ����
	 * 
	 * @param msg
	 * @param params
	 */
	public void setErrorMsgByKey(String key, Object[] params);

	public Object[] getErrorMsgParams();

	/**
	 * ͨ�����ʻ����������ʾ����
	 * 
	 * @param key
	 */
	public void setErrorMsgByKey(String key);

	/**
	 * ��������Key ������Message
	 * 
	 * @param key
	 */
	public void setErrorMsgKey(String key);

	public String getErrorMsgKey();

}
