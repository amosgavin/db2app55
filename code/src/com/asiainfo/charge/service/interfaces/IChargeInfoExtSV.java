package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeInfoExtValue;

public interface IChargeInfoExtSV {

	/**
	 * ��ѯ�ʷѵ�����չ��Ϣ
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
