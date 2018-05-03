package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOUserScaleValue;

public interface ISaleUserScaleDAO {

	public void save(IBOUserScaleValue[] values) throws Exception;

	public IBOUserScaleValue[] getUserScaleByRelaId(String relaId,String infoType,
			 int startNum, int endNum) throws Exception;

	public int getCnUserScaleListByRelaId(String relaId,String infoType)
			throws Exception;
	
	public void cloneUserScaleByRelaId( String oldId,String infoType,
			String newId) throws Exception;


}
