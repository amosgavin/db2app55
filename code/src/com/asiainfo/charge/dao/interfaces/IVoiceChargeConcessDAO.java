package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;

public interface IVoiceChargeConcessDAO {
	
	/**
	 * 根据资费ID获取语音优惠主信息
	 * 
	 * @param chargeId 资费ID
	 * @return
	 * @throws Exception
	 */
	public IBOChargeConcessInfoValue getVoiceChargeMain(String chargeId)throws Exception,RuntimeException;
	
	/**
	 * 根据资费ID获取语音优惠明细信息
	 * 
	 * @param chargeId 资费ID
	 * @return
	 * @throws Exception
	 */
	public IBOChargeConcessDetailInfoValue[] getVoiceChargeDetail(String concessid)throws Exception,RuntimeException;
	
	/**
	 * 保存语音优惠信息
	 * 
	 * @param IBOChargeConcessInfoValue 资费ID
     *
	 * @return
	 * @throws Exception
	 */
	public String saveChargeInfo(IBOChargeConcessInfoValue chargeConcessInfoValue)throws Exception,RuntimeException;
	
	/**
	 * 保存语音优惠信息
	 * 
	 * @param IBOChargeConcessInfoValue 资费ID
     *
	 * @return
	 * @throws Exception
	 */
	public void saveChargeInfo(IBOChargeConcessInfoValue[] beans)throws Exception,RuntimeException;
	
	
	/**
	 * 保存语音优惠详细信息
	 * 
	 * @param IBOChargeConcessInfoValue 资费ID
     *
	 * @return
	 * @throws Exception
	 */
	public void saveChargeDetailInfo(IBOChargeConcessDetailInfoValue[] chargeConcessDetailInfoValue)throws Exception,RuntimeException;
	
}
