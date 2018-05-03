package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleRelatCgroupValue;

public interface ICustGroupSV {

	public void save(IBOSaleRelatCgroupValue[] values) throws Exception;

	public IBOSaleRelatCgroupValue[] getSaleRelatCgroupByRelaId(String relaId,
			String relaType, int startNum, int endNum) throws Exception;

	public int getCnSaleRelatCgroupByRelaId(String relaId, String relaType)
			throws Exception;

	public void cloneSaleRelatCgroupByRelaId(String relaType, String oldId,
			String newId) throws Exception;
}
