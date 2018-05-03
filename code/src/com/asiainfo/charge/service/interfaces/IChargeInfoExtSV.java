package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeInfoExtValue;

public interface IChargeInfoExtSV {

	/**
	 * 查询资费档次扩展信息
	 * 
	 * @param applyId
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public IBOChargeInfoExtValue[] getChargeInfoExt(String applyId, String type)
			throws Exception;

	public void saveChargeInfoExt(IBOChargeInfoExtValue[] infoExtValues) throws Exception;
	
	

}
