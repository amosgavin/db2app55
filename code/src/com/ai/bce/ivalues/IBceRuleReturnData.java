package com.ai.bce.ivalues;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;

public interface IBceRuleReturnData extends Serializable {
	// ��ȡУ�鷵����Ϣ
	public String getMsg();

	/**
	 * // ����У�鷵����Ϣ
	 * 
	 * @deprecated use setMsgByKey ���������
	 */
	public void setMsg(String msg);

	// ��ȡУ����
	public int getResultCode();

	/**
	 * ����У��������ֵȡ�ԣ� BceUtil.JAVA_RULE_RETURN_CODE_YES 1 ����
	 * BceUtil.JAVA_RULE_RETURN_CODE_WARNNING 2 ���������о���
	 * BceUtil.JAVA_RULE_RETURN_CODE_NO 3 ������
	 */
	public void setResultCode(int resultCode);

	public void setCustomResultCode(String customResultCode);

	public String getCustomResultCode();

	public void addFailDc(DataContainerInterface failDc);

	public void addSuccessDc(DataContainerInterface successDc);

	public void addWarnningDc(DataContainerInterface warnningDc);

	// ��ȡʧ���б�������У������
	public DataContainerInterface[] getFailDcList();

	// ��ȡ�ɹ��б�������У������
	public DataContainerInterface[] getSuccessDcList();

	// ��ȡ�澯�б�������У������
	public DataContainerInterface[] getWarnningDcList();

	/**
	 * ͨ�����ʻ����������ʾ����
	 * 
	 * @param msg
	 * @param params
	 */
	public void setMsgByKey(String msg, Object[] params);

	public Object[] getMsgParams();

	/**
	 * ͨ�����ʻ����������ʾ����
	 * 
	 * @param key
	 */
	public void setMsgByKey(String key);

	public String getKey();

	/**
	 * ��������Key ������Message
	 * 
	 * @param key
	 */
	public void setKey(String key);

	/**
	 * ������Ϣ����ȥRequest
	 * 
	 * @return
	 */
	public Map getRequestParameMap();

	/**
	 * ���÷�����Ϣ����ȥRequest
	 * 
	 * @param requestParameMap
	 */
	public void setRequestParameMap(Map requestParameMap);

	void setBceRuleData(IBceRuleData bceRuleData);

	List<IBceRuleData> getBceRuleData();

}
