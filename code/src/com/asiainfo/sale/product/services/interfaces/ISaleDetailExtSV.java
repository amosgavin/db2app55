package com.asiainfo.sale.product.services.interfaces;

import com.asiainfo.common.service.interfaces.IAbstractProductExtSV;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtQValue;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtValue;

/**
 * 营销案档次管理服务类
 * 
 * @author jiangxl
 * 
 */
public interface ISaleDetailExtSV extends IAbstractProductExtSV {

	/**
	 * 查询营销档次信息
	 * @param mainId
	 * @param saleFlag
	 * @param active_name
	 * @param market
	 * @param start_date
	 * @param end_date
	 * @param status
	 * @param condStr
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailExtQValue[] qrySaleDetailExt(String mainId,String detail_id,
			String saleFlag, String active_name, String market,
			String start_date, String end_date,String status,String condStr, int startIndex, int endIndex)
			throws Exception;

	/**
	 * 返回记录条数
	 * @param mainId
	 * @param saleFlag
	 * @param active_name
	 * @param market
	 * @param start_date
	 * @param end_date
	 * @param status
	 * @param condStr
	 * @return
	 * @throws Exception
	 */
	public int qrySaleDetailExtCount(String mainId,String detail_id,
			String saleFlag, String active_name, String market,
			String start_date, String end_date,String status,String condStr) throws Exception;

	/**
	 * 根据主键e_id修改数据的状态
	 * @param e_id
	 * @param status
	 * @param staffId
	 * @throws Exception
	 */
	public void changeSts(String e_id, String status, String staffId)throws Exception;

	/**
	 * 保存扩展字段的值到表中
	 * @param saveValues
	 * @throws Exception
	 */
	public void saveSaleDetailExtValue(IBOSaleDetailExtValue[] saveValues)throws Exception;

	/**
	 * 获取sale_detail_ext中主键编号
	 * @return
	 * @throws Exception
	 */
	public long getNewId()throws Exception;
	
	/**
	 * 根据条件查询扩展字段的值
	 * @param detail_id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailExtValue[] getSaleDetailExt(String detail_id,String status)throws Exception;
	
	
	
	
	
	

}
