package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.bce.bo.BceButtonBean;
import com.ai.bce.bo.BceButtonEngine;
import com.ai.bce.bo.BceFrameButtonBean;
import com.ai.bce.bo.BceFrameButtonEngine;
import com.ai.bce.configtool.service.interfaces.IConfButtonSV;
import com.ai.bce.ivalues.IBceButtonValue;
import com.ai.bce.ivalues.IBceFrameButtonValue;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.LocaleResourceFactory;
/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: ConfButtonSVImpl.java
 * @Description: 按钮服务实现类
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 20, 2010 10:28:36 AM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 20, 2010     ZhangWenqi           v1.0.0               修改原因
 */
public class ConfButtonSVImpl implements IConfButtonSV {

	/**
	 * 根据条件查询按钮信息
	 */
	public IBceButtonValue[] getBceButtonValues(String cond) throws Exception,
			RemoteException {
		return BceButtonEngine.getBeans(cond, null);
	}
	/**
	 * 根据条件查询按钮信息
	 */
	public IBceButtonValue[] getBceButtonValues(String cond, int startNum, int endNum)
			throws Exception, RemoteException {
		return BceButtonEngine.getBeans(null, cond, null, startNum, endNum, false);
	}
	/**
	 * 根据条件查询按钮信息的数量
	 */
	public int getBceButtonCount(String cond) throws Exception, RemoteException {
		IBceButtonValue[] values = this.getBceButtonValues(cond);
		if(values != null && values.length > 0)
		{
			return values.length;
		}
		return 0;
	}
	
	/**
	 * 根据条件查询业务操作与按钮关系
	 */
	public IBceFrameButtonValue[] getBceFrameButton(String cond) throws Exception, RemoteException
	{
		return BceFrameButtonEngine.getBeans(cond, null);
	}
	/**
	 *  根据条件分页查询业务操作与按钮关系
	 */
	public IBceFrameButtonValue[] getBceFrameButton(String cond, int startNum, int endNum) throws Exception, RemoteException
	{
		return BceFrameButtonEngine.getBeans(null, cond, null, startNum, endNum, false);
	}
	/**
	 * 根据条件查询业务操作与按钮关系的数量
	 */
	public int getBceFrameButtonCount(String cond) throws Exception, RemoteException
	{
		IBceFrameButtonValue[] values = this.getBceFrameButton(cond);
		if(values != null && values.length > 0)
		{
			return values.length;
		}
		return 0;
	}
	
	public IBceButtonValue[] getBceButtons() throws Exception {
		return BceButtonEngine.getBeans(IBceButtonValue.S_State +" = 1 ",null); 
	}
}
