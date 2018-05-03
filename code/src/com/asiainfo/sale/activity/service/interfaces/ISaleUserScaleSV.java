package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOUserScaleValue;



public interface ISaleUserScaleSV {

	public void save(IBOUserScaleValue[] values) throws Exception;

	public IBOUserScaleValue[] getUserScaleByRelaId(String relaId,String InfoType,
			int startNum, int endNum) throws Exception;

	public int getCnUserScaleListByRelaId(String relaId,String infoType)
			throws Exception;
}
