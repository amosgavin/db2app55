package com.asiainfo.sale.product.dao.interfaces;

import com.asiainfo.common.dao.interfaces.ICommonProductExtDAO;
import com.asiainfo.sale.product.bo.BOSaleDetailExtBean;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtQValue;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtValue;

/**
 * Ӫ����������Ϣ�������ݷ��ʽӿ�
 * @author jiangxl
 *
 */
public interface ISaleDetailExtDAO extends ICommonProductExtDAO {

	/**
	 * ��ѯӪ����������Ϣ
	 * @param mainId
	 * @param saleFlag
	 * @param active_name
	 * @param market
	 * @param start_date
	 * @param end_date
	 * @param condStr
	 * @param startIndex
	 * @param endIndex
	 * @throws Exception
	 */
	public IBOSaleDetailExtQValue[] qrySaleDetailExt(String mainId,String detail_id, String saleFlag, String active_name,
			String market, String start_date, String end_date, String status,String condStr,
			int startIndex, int endIndex)throws Exception;

	/**
	 * Ӫ����������Ϣ��ѯͳ���ܼ�¼��
	 * @param mainId
	 * @param saleFlag
	 * @param active_name
	 * @param market
	 * @param start_date
	 * @param end_date
	 * @param condStr
	 * @return
	 * @throws Exception
	 */
	public int qrySaleDetailExtCount(String mainId,String detail_id, String saleFlag,
			String active_name, String market, String start_date,
			String end_date,String status, String condStr)throws Exception;

	/**
	 * ��ʼ����չ��
	 * @param extType
	 * @param staffId
	 * @throws Exception
	 */
	public void saveInitialValues(String extType, String staffId)throws Exception;

	/**
	 * ����������ȡ��¼
	 * @param e_id
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailExtValue getDataValue(String e_id)throws Exception;

	/**
	 * ������չ��¼
	 * @param saleDetailExtBeans
	 * @throws Exception
	 */
	public void saveSaleDetailExtValue(IBOSaleDetailExtValue[] saleDetailExtBeans)throws Exception;

	public long getNewId()throws Exception;

	public IBOSaleDetailExtValue[] getSaleDetailExt(String detail_id, String status)throws Exception;
	
	

}
