package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOResourceChangeDetailValue;

public interface IResourceChangeDetailSV {
	// ͨ��ID��ȡ��ϸ��¼
	public IBOResourceChangeDetailValue getResourceChangeDetailByID(int resourceId)
			throws Exception;

	public int saveResourceChangeDetail(IBOResourceChangeDetailValue resourceChangeDetailValue) throws Exception;

}
