package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleDetailShowValue;

public interface ISaleDetailShowDAO {

	/**
	 * 根据营销案ID获取档次详细信息（包括档次相关的武器）
	 * 
	 * @param id 营销按ID
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailShowValue[] getSaleDetailShowValues(String id)
			throws Exception;
}
