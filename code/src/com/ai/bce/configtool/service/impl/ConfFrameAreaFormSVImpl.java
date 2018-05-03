package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.configtool.dao.interfaces.IConfFrameAreaFormDAO;
import com.ai.bce.configtool.service.interfaces.IConfFrameAreaFormSV;
import com.ai.bce.ivalues.IBceAttrValue;
import com.ai.bce.ivalues.IBceFormGroupValue;
import com.ai.bce.ivalues.IBceFrameAreaFormValue;
import com.ai.bce.util.BServiceFactory;

public class ConfFrameAreaFormSVImpl implements IConfFrameAreaFormSV {

	public IBceFrameAreaFormValue getFrameAreaFormValueById(String bceFrameId,String formId)
			throws RemoteException, Exception {
		long _bceFrameId=-1;
		if(null != bceFrameId && !"".equals(bceFrameId)){
			_bceFrameId = Long.parseLong(bceFrameId);
		}
		return getDao().getFrameAreaFormValueById(_bceFrameId, formId);
	}
	
	public IConfFrameAreaFormDAO getDao() throws RemoteException,Exception{
		return (IConfFrameAreaFormDAO) BServiceFactory.getService(IConfFrameAreaFormDAO.class);
	}
	
	public IBceAttrValue[] getBceAttr(String cond,int startIndex,int endIndex)throws RemoteException,Exception{
		return getDao().getBceAttr(cond, startIndex, endIndex);
	}
	
	public int getBceAttrCount(String cond) throws RemoteException,Exception {
		return getDao().getBceAttrCount(cond);
	}
	/**
	 * 根据条件查询属性信息
	 */
	public IBceAttrValue[] getBceAttr(String cond)throws Exception, RemoteException
	{
		return getDao().getBceAttr(cond);
	}

	/**
	 * 
	 * @Function: getAttributesByIds
	 * @Description: 批量查询属性
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 23, 2010 12:01:10 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 23, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IBceAttrValue[] getAttributesByIds(long[] attrIds) throws Exception, RemoteException
	{
		return getDao().getAttributesByIds(attrIds);
	}
	public IBceFormGroupValue[] getGroups(String cond) throws RemoteException,Exception{
		return getDao().getGroups(cond);
	}
}
