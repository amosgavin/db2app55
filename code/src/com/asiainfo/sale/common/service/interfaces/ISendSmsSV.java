package com.asiainfo.sale.common.service.interfaces;

import com.ai.comframe.client.ComframeClient;
import com.asiainfo.sale.common.ivalues.IBOApplyInfoValue;
import com.asiainfo.task.dao.interfaces.IProxyPriveDAO;

public interface ISendSmsSV {
	
	/**
	 * ˵�������Ͷ���
	 * ������
	 * task_id������ID
	 * send_staff_id:������ID
	 * next_staff_id:������ID
	 **/
    public void sendSms(String task_id, String send_staff_id, String next_staff_id);

	/**
	 * ˵������������ʱ���Ͷ���
	 * ������
	 * objectType����������
	 * wid:����ID
	 * send_staff_id:������ID
	 * next_staff_id:������ID
	 **/
    public void sendSms(String objectType,String wid, String send_staff_id, String next_staff_id)throws Exception;
    
	/**
	 * ˵������������ʱ���Ͷ���
	 * ������
	 * objectType����������
	 * wid:����ID
	 * send_staff_id:������ID
	 * next_staff_id:������ID
	 **/
    public void sendSmsZH(String objectType,String wid, String send_staff_id, String next_staff_id)throws 	Exception;
    
	/**
	 * ˵�������͹���������������
	 * ������
	 * objectType����������
	 * wid:����ID
	 * send_staff_id:������ID
	 * next_staff_id:������ID
	 **/
    public void sendSmsOver(String objectType,String wid, String send_staff_id, String next_staff_id)throws Exception;
    
	/**
	 * ˵������϶���
	 * ������
	 * record_type����������
	 * wid:����ID
	 **/
    public String makeSms(String record_type,String wid)throws Exception;

	/**
	 * ˵����Ϊ֪��Э����϶���
	 * ������
	 * record_type����������
	 * wid:����ID
	 **/
    public String makeSmsZH(String record_type,String wid)throws Exception;
    
	/**
	 * ˵�������̽�������
	 * ������
	 * record_type����������
	 * wid:����ID
	 **/
    public String makeSmsOver(String record_type,String wid)throws Exception;

	/**
	 * ˵������ȡ����������
	 * ������
	 * wid:����ID
	 **/
    public IBOApplyInfoValue getApplyName(String wid)throws Exception;
    
	/**
	 * ˵������ȡ��������
	 * ������
	 * task_id:����ID
	 **/
    public String getObjectType(String task_id)throws Exception;
    
    /**
	 * ˵�����ֻ���
	 * ������
	 * operator_id:����ԱID
	 **/
    public String getTelphone(String operator_id)throws Exception;
    
    /**
	 * ˵�����жϵ�ǰ��Ա�Ƿ��д����ˣ����û���򷢶��ţ�����У���ȡ�����˷�����
	 * ������
	 * staffId:������ID
	 * send_staff_id��������ID
	 * sms:��������
	 * task_id�� ����ID
	 **/
    public void sendToProxy(String send_staff_id,String staffId,IProxyPriveDAO proxyPrive,String sms,String task_id)throws Exception;
    
	/**
	 * ˵������ȡ����ID
	 * ������
	 * task_id:����ID
	 **/
    public String getObjectId(String task_id)throws Exception;
}
