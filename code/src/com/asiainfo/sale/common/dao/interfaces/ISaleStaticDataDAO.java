package com.asiainfo.sale.common.dao.interfaces;

import com.asiainfo.sale.common.ivalues.IBOSaleStaticDataValue;

public interface ISaleStaticDataDAO {

	/**
	 * 获取静态数据
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getSaleStaticData(String codeType)
			throws Exception;

	/**
	 * 更加静态数据类型和编号获取数据
	 * 
	 * @param codeType
	 *            long
	 * @param codeId
	 *            long
	 * @throws Exception
	 * @throws RemoteException
	 * @return ISysStaticDataValue[]
	 */
	public IBOSaleStaticDataValue getSaleStaticData(String codeType, String codeId)
			throws Exception;
	
	/**
	 * 初始化缓存
	 * 
	 * @throws Exception
	 */
	public void initCache() throws Exception;
	 //查询专款
	 public IBOSaleStaticDataValue[] getSaleStaticDatas( String codeType ,String name) throws Exception;
	 
	 public int queryStaticDateCount(String codeType ,String name)throws Exception;
}
