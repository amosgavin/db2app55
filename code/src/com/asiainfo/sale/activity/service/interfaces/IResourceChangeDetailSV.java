package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOResourceChangeDetailValue;

public interface IResourceChangeDetailSV {
	// 通过ID获取明细记录
	public IBOResourceChangeDetailValue getResourceChangeDetailByID(int resourceId)
			throws Exception;

	public int saveResourceChangeDetail(IBOResourceChangeDetailValue resourceChangeDetailValue) throws Exception;

}
