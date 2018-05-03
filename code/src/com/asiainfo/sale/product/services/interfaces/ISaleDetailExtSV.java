package com.asiainfo.sale.product.services.interfaces;

import com.asiainfo.common.service.interfaces.IAbstractProductExtSV;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtQValue;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtValue;

/**
 * Ӫ�������ι��������
 * 
 * @author jiangxl
 * 
 */
public interface ISaleDetailExtSV extends IAbstractProductExtSV {

	/**
	 * ��ѯӪ��������Ϣ
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
	 * ���ؼ�¼����
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
	 * ��������e_id�޸����ݵ�״̬
	 * @param e_id
	 * @param status
	 * @param staffId
	 * @throws Exception
	 */
	public void changeSts(String e_id, String status, String staffId)throws Exception;

	/**
	 * ������չ�ֶε�ֵ������
	 * @param saveValues
	 * @throws Exception
	 */
	public void saveSaleDetailExtValue(IBOSaleDetailExtValue[] saveValues)throws Exception;

	/**
	 * ��ȡsale_detail_ext���������
	 * @return
	 * @throws Exception
	 */
	public long getNewId()throws Exception;
	
	/**
	 * ����������ѯ��չ�ֶε�ֵ
	 * @param detail_id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailExtValue[] getSaleDetailExt(String detail_id,String status)throws Exception;
	
	
	
	
	
	

}
