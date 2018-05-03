package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleResourceAllotValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleResourceUsedValue;

public interface ISaleResourceDAO {

	public IBOSaleResourceAllotValue[] getResourceAllot(String cityId)
			throws Exception;

	public void save(IBOSaleResourceAllotValue vl) throws Exception;

	public IBOSaleResourceUsedValue[] selectResourceUsed(String cityId) throws Exception;
	
	public IBOSaleResourceUsedValue[] selectResourceUsed() throws Exception;
	
	public IBOSaleResourceUsedValue[] selectResourceUsed2(String cityId) throws Exception;
}
