package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;

public interface IVoiceChargeConcessSV {

	/**
	 * �����ʷ�ID��ȡ�����Ż�����Ϣ
	 * 
	 * @param chargeId �ʷ�ID
	 * @return
	 * @throws Exception
	 */
	public IBOChargeConcessInfoValue getVoiceChargeMain(String chargeId)throws Exception,RuntimeException;
	
	/**
	 * �����ʷ�ID��ȡ�����Ż���ϸ��Ϣ
	 * 
	 * @param chargeId �ʷ�ID
	 * @return
	 * @throws Exception
	 */
	public IBOChargeConcessDetailInfoValue[] getVoiceChargeDetail(String concessid)throws Exception,RuntimeException;

	/**
	 * ���������Ż���Ϣ
	 * 
	 * @param IBOChargeConcessInfoValue �ʷ�ID
     *
	 * @return
	 * @throws Exception
	 */
	public String saveChargeInfo(IBOChargeConcessInfoValue chargeConcessInfoValue)throws Exception,RuntimeException;
	
	/**
	 * ���������Ż���Ϣ
	 * 
	 * @param IBOChargeConcessInfoValue
     *
	 * @return
	 * @throws Exception
	 */
	public void saveChargeInfo(IBOChargeConcessInfoValue[] beans)throws Exception,RuntimeException;
	
	
	/**
	 * ���������Ż���ϸ��Ϣ
	 * 
	 * @param IBOChargeConcessInfoValue �ʷ�ID
     *
	 * @return
	 * @throws Exception
	 */
	public void saveChargeDetailInfo(IBOChargeConcessDetailInfoValue[] chargeConcessDetailInfoValue)throws Exception,RuntimeException;

}
