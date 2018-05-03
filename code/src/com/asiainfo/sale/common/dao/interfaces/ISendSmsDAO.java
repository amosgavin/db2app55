package com.asiainfo.sale.common.dao.interfaces;

import com.asiainfo.sale.common.ivalues.IBOApplyInfoValue;
import com.asiainfo.task.dao.interfaces.IProxyPriveDAO;

public interface ISendSmsDAO {
	
	/*
	 * ˵������ȡ����������
	 * ������
	 * wid:����ID
	 * */
    public IBOApplyInfoValue getApplyName(String wid)throws RuntimeException,Exception;

	/*
	 * ˵������ȡ��������
	 * ������
	 * task_id:����ID
	 * */
    public String getObjectType(String task_id)throws RuntimeException,	Exception;

	/*
	 * ˵������ȡ����id
	 * ������
	 * task_id:����ID
	 * */
    public String getObjectId(String task_id)throws RuntimeException,	Exception;

	/*
	 * ˵������ȡ�ֻ�����
	 * ������
	 * operator_id:����ԱID
	 * */
    public String getTelphone(String operator_id)throws RuntimeException,	Exception;
}
