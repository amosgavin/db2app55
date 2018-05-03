package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleResourceAllotValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleResourceUsedValue;

public interface ISaleResourceSV {

	public IBOSaleResourceAllotValue[] getResourceAllot(String cityId)
			throws Exception;

	public void save(IBOSaleResourceAllotValue vl) throws Exception;
	
	public IBOSaleResourceUsedValue[] selectResourceUsed(String cityId) throws Exception;
	
	public IBOSaleResourceUsedValue[] selectResourceUsed() throws Exception;
	
	public IBOSaleResourceUsedValue[] selectResourceUsed2(String cityId) throws Exception;
}
