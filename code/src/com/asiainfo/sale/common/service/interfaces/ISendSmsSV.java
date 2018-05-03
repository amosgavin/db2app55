package com.asiainfo.sale.common.service.interfaces;

import com.ai.comframe.client.ComframeClient;
import com.asiainfo.sale.common.ivalues.IBOApplyInfoValue;
import com.asiainfo.task.dao.interfaces.IProxyPriveDAO;

public interface ISendSmsSV {
	
	/**
	 * 说明：发送短信
	 * 参数：
	 * task_id：任务ID
	 * send_staff_id:发送人ID
	 * next_staff_id:接收人ID
	 **/
    public void sendSms(String task_id, String send_staff_id, String next_staff_id);

	/**
	 * 说明：创建流程时发送短信
	 * 参数：
	 * objectType：工单类型
	 * wid:工单ID
	 * send_staff_id:发送人ID
	 * next_staff_id:接收人ID
	 **/
    public void sendSms(String objectType,String wid, String send_staff_id, String next_staff_id)throws Exception;
    
	/**
	 * 说明：创建流程时发送短信
	 * 参数：
	 * objectType：工单类型
	 * wid:工单ID
	 * send_staff_id:发送人ID
	 * next_staff_id:接收人ID
	 **/
    public void sendSmsZH(String objectType,String wid, String send_staff_id, String next_staff_id)throws 	Exception;
    
	/**
	 * 说明：发送工单审批结束短信
	 * 参数：
	 * objectType：工单类型
	 * wid:工单ID
	 * send_staff_id:发送人ID
	 * next_staff_id:接收人ID
	 **/
    public void sendSmsOver(String objectType,String wid, String send_staff_id, String next_staff_id)throws Exception;
    
	/**
	 * 说明：组合短信
	 * 参数：
	 * record_type：工单类型
	 * wid:工单ID
	 **/
    public String makeSms(String record_type,String wid)throws Exception;

	/**
	 * 说明：为知会协办组合短信
	 * 参数：
	 * record_type：工单类型
	 * wid:工单ID
	 **/
    public String makeSmsZH(String record_type,String wid)throws Exception;
    
	/**
	 * 说明：流程结束短信
	 * 参数：
	 * record_type：工单类型
	 * wid:工单ID
	 **/
    public String makeSmsOver(String record_type,String wid)throws Exception;

	/**
	 * 说明：获取工单申请名
	 * 参数：
	 * wid:工单ID
	 **/
    public IBOApplyInfoValue getApplyName(String wid)throws Exception;
    
	/**
	 * 说明：获取工单类型
	 * 参数：
	 * task_id:工单ID
	 **/
    public String getObjectType(String task_id)throws Exception;
    
    /**
	 * 说明：手机号
	 * 参数：
	 * operator_id:操作员ID
	 **/
    public String getTelphone(String operator_id)throws Exception;
    
    /**
	 * 说明：判断当前人员是否有代理人，如果没有则发短信，如果有，则取代理人发短信
	 * 参数：
	 * staffId:接收人ID
	 * send_staff_id：发送人ID
	 * sms:短信内容
	 * task_id： 任务ID
	 **/
    public void sendToProxy(String send_staff_id,String staffId,IProxyPriveDAO proxyPrive,String sms,String task_id)throws Exception;
    
	/**
	 * 说明：获取工单ID
	 * 参数：
	 * task_id:任务ID
	 **/
    public String getObjectId(String task_id)throws Exception;
}
