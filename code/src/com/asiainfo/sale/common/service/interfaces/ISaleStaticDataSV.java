package com.asiainfo.sale.common.service.interfaces;

import com.asiainfo.sale.common.ivalues.IBOSaleStaticDataValue;

public interface ISaleStaticDataSV {

	/**
	 * 初始化缓存
	 * 
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void initCache() throws Exception, RuntimeException;

	/**
	 * 获取静态数据
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getSaleStaticData(String codeType)
			throws Exception, RuntimeException;

	/**
	 * 根据静态数据类型和编号获取数据
	 * 
	 * @param codeType
	 *            long
	 * @param codeId
	 *            long
	 * @throws Exception
	 * @throws RemoteException
	 * @return ISysStaticDataValue[]
	 */
	public IBOSaleStaticDataValue getSaleStaticData(String codeType,
			String codeId) throws Exception, RuntimeException;

	/**
	 * 获取品牌
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getBrand() throws Exception,
			RuntimeException;

	/**
	 * 获取细分市场
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getMarket() throws Exception,
			RuntimeException;

	
	public IBOSaleStaticDataValue[] getGroupType() throws Exception,
			RuntimeException;
	
	public IBOSaleStaticDataValue[] getActivity() throws Exception,
	RuntimeException;
	
	/**
	 * 获取渠道
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getChannel() throws Exception,
			RuntimeException;

	// 获取业务变更类型
	public IBOSaleStaticDataValue[] getBusiChangeType() throws Exception,
			RuntimeException;

	// 获取业务变更渠道类型
	public IBOSaleStaticDataValue[] getChannelType() throws Exception,
			RuntimeException;
	
	// 获取业务变更开放品牌类型
	public IBOSaleStaticDataValue[] getOpenBrand() throws Exception,
			RuntimeException;
	
	// 获取地理位置类型
	public IBOSaleStaticDataValue[] getGeoPosType() throws Exception,
			RuntimeException;
	
	// 获取渠道星级类型
	public IBOSaleStaticDataValue[] getStarLevel() throws Exception,
	RuntimeException;
	/**
	 * 获取地市
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] area_type() throws Exception,
			RuntimeException;

	/**
	 * 主动营销点
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getZDYXD() throws Exception,
			RuntimeException;

	public IBOSaleStaticDataValue[] getSaleStaticDatas(String codeType,
			String name) throws Exception;

	public int queryStaticDateCount(String codeType, String name)
			throws Exception;
	
	// 获取boss资费批次编码
	public IBOSaleStaticDataValue[] getBatchCode() throws Exception,
	RuntimeException;
	
	// 获取boss资费批次名称
	public IBOSaleStaticDataValue[] getBatchName() throws Exception,
	RuntimeException;
}
