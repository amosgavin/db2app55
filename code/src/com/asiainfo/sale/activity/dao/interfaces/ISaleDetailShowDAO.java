package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleDetailShowValue;

public interface ISaleDetailShowDAO {

	/**
	 * ����Ӫ����ID��ȡ������ϸ��Ϣ������������ص�������
	 * 
	 * @param id Ӫ����ID
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailShowValue[] getSaleDetailShowValues(String id)
			throws Exception;
}
