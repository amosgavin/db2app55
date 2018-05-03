package com.ai.bce.auto.plugin.version.hand.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerDtlParamsValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerHandValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOpDtlValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOpValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOrdValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerTabinfoValue;

/**
 * 
 * 版本服务数据库层接口实现类
 * <p>
 * Copyright (c) 2010 Asiainfo-Linkage
 * </p>
 * 
 * @ClassName: IHandLogDAO.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Feb 1, 2011 7:38:38 PM
 */
public interface IHandLogDAO {
	/**
	 * 保存需求单操作
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param opValue
	 * @throws Exception
	 * @throws RemoteException
	 *             设定文件
	 * @return 返回类型
	 */
	public IBceVerOpValue saveVerOp(IBceVerOpValue opValue) throws Exception,
			RemoteException;

	/**
	 * 保存操作单明细
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param opDtlValue
	 * @param dtlParamsValues
	 * @throws Exception
	 * @throws RemoteException
	 *             设定文件
	 * @return 返回类型
	 */
	public void saveVerOpDtl(IBceVerOpDtlValue opDtlValue,
			IBceVerDtlParamsValue[] dtlParamsValues) throws Exception,
			RemoteException;
	
	public IBceVerOrdValue createOrder(IBceVerOrdValue verOrdValue)
	throws Exception, RemoteException;

	public void createVerHand(IBceVerHandValue verHandValue) throws Exception, RemoteException;

	public IBceVerOpDtlValue[] getOpDtlValuesByOpId(long opId, boolean isHf) throws Exception;

	public IBceVerOpValue[] getOpValuesByOrdId(long ordId, boolean isHf) throws Exception;

	public IBceVerDtlParamsValue[] getOpParamsByDtlId(long dtlId) throws Exception;

	public IBceVerOrdValue getOrdValueByOrdId(long ordId) throws Exception;

	public IBceVerTabinfoValue[] getBceVerTabInfoValuesByTabName(
			String tableName) throws Exception;
}
