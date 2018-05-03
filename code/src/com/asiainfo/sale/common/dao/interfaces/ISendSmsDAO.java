package com.asiainfo.sale.common.dao.interfaces;

import com.asiainfo.sale.common.ivalues.IBOApplyInfoValue;
import com.asiainfo.task.dao.interfaces.IProxyPriveDAO;

public interface ISendSmsDAO {
	
	/*
	 * 说明：获取工单申请名
	 * 参数：
	 * wid:工单ID
	 * */
    public IBOApplyInfoValue getApplyName(String wid)throws RuntimeException,Exception;

	/*
	 * 说明：获取工单类型
	 * 参数：
	 * task_id:任务ID
	 * */
    public String getObjectType(String task_id)throws RuntimeException,	Exception;

	/*
	 * 说明：获取工单id
	 * 参数：
	 * task_id:任务ID
	 * */
    public String getObjectId(String task_id)throws RuntimeException,	Exception;

	/*
	 * 说明：获取手机号码
	 * 参数：
	 * operator_id:操作员ID
	 * */
    public String getTelphone(String operator_id)throws RuntimeException,	Exception;
}
