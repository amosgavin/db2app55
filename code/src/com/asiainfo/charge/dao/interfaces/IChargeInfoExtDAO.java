package com.asiainfo.charge.dao.interfaces;


import com.asiainfo.charge.ivalues.IBOChargeInfoExtValue;

public interface IChargeInfoExtDAO {

	public IBOChargeInfoExtValue[] getChargeInfoExt(String applyId,
			String type)throws Exception;

	public void saveChargeInfoExt(IBOChargeInfoExtValue[] infoExtValues)throws Exception;

}
