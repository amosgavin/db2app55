package com.asiainfo.charge.dao.impl;

import java.util.HashMap;

import com.asiainfo.charge.dao.interfaces.IVoiceChargeConcessDAO;
import com.asiainfo.charge.bo.BOChargeConcessDetailInfoEngine;
import com.asiainfo.charge.bo.BOChargeConcessInfoEngine;
import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;

public class VoiceChargeConcessDAOImpl implements IVoiceChargeConcessDAO {
	
	public void delVoiceChargeMain(String chargeId)throws Exception,RuntimeException{
		IBOChargeConcessInfoValue  chargeConcessInfoValue=this.getVoiceChargeMain(chargeId);
		if(chargeConcessInfoValue!=null){
			int vid=chargeConcessInfoValue.getConcessid();
			chargeConcessInfoValue.delete();
			BOChargeConcessInfoEngine.save(chargeConcessInfoValue);
			IBOChargeConcessDetailInfoValue[] concessDetailInfoValues =this.getVoiceChargeDetail(String.valueOf(vid));
			if(concessDetailInfoValues!=null){
			for(IBOChargeConcessDetailInfoValue concessDetailInfoValue:concessDetailInfoValues){
				concessDetailInfoValue.delete();
				BOChargeConcessDetailInfoEngine.save(concessDetailInfoValue);
			}
			}
		}
	}
	/**
	 * �����ʷ�ID��ȡ�����Ż�����Ϣ
	 * 
	 * @param chargeId �ʷ�ID
	 * @return
	 * @throws Exception
	 */
	public IBOChargeConcessInfoValue getVoiceChargeMain(String chargeId)throws Exception,RuntimeException{
		String condition = IBOChargeConcessInfoValue.S_Mid+" = :chargeId ";
		HashMap<String,String> parameter = new HashMap<String,String>();
		parameter.put("chargeId", chargeId);
		
		IBOChargeConcessInfoValue[] concessArray = BOChargeConcessInfoEngine.getBeans(condition, parameter);
		if(concessArray.length >0){
			return concessArray[0];
		}else{
			//�޶�Ӧ�ʷ��򷵻�null
			return null; 
		}
	}
	/**
	 * �����ʷ�ID��ȡ�����Ż���ϸ��Ϣ
	 * 
	 * @param chargeId �ʷ�ID
     *
	 * @return
	 * @throws Exception
	 */
	public IBOChargeConcessDetailInfoValue[] getVoiceChargeDetail(String concessid)throws Exception,RuntimeException{
		HashMap<String,String> parameter = new HashMap<String,String>();
		String condition = IBOChargeConcessDetailInfoValue.S_Conssid+" = :conssid ";
		parameter.put("conssid", concessid);
		IBOChargeConcessDetailInfoValue[] concessDetailArray = BOChargeConcessDetailInfoEngine.getBeans(condition, parameter);
		if(concessDetailArray.length >0){
			return concessDetailArray;
		}else{
			//�޶�Ӧ�ʷ��򷵻�null
			return null; 
		}
	}

	/**
	 * ���������Ż���Ϣ
	 * 
	 * @param IBOChargeConcessInfoValue �ʷ�ID
     *
	 * @return
	 * @throws Exception
	 */
	public String saveChargeInfo(IBOChargeConcessInfoValue chargeConcessInfoValue)throws Exception,RuntimeException{
		if(chargeConcessInfoValue.isNew()){
			chargeConcessInfoValue.setConcessid(BOChargeConcessInfoEngine.getNewId().intValue());
		}
		BOChargeConcessInfoEngine.save(chargeConcessInfoValue);
		String conssid = String.valueOf(chargeConcessInfoValue.getConcessid());
		return conssid;
	}

	/**
	 * ���������Ż���Ϣ
	 * 
	 * @param IBOChargeConcessInfoValue �ʷ�ID
     *
	 * @return
	 * @throws Exception
	 */
	public void saveChargeInfo(IBOChargeConcessInfoValue[] beans)throws Exception,RuntimeException{
		for(int i=0;i<beans.length;i++){
			if(beans[i].isNew()){
				beans[i].setConcessid(BOChargeConcessInfoEngine.getNewId().intValue());
			}
			
		}

		BOChargeConcessInfoEngine.saveBatch(beans);
	}
	
	/**
	 * ���������Ż���ϸ��Ϣ
	 * @param IBOChargeConcessInfoValue �ʷ�ID
     *
	 * @return
	 * @throws Exception
	 */
	public void saveChargeDetailInfo(IBOChargeConcessDetailInfoValue[] chargeConcessDetailInfoValue)throws Exception,RuntimeException{
		for(int i=0;i<chargeConcessDetailInfoValue.length;i++){
			if(chargeConcessDetailInfoValue[i].isNew()){
				chargeConcessDetailInfoValue[i].setId(BOChargeConcessDetailInfoEngine.getNewId().intValue());
			}
		}
		BOChargeConcessDetailInfoEngine.save(chargeConcessDetailInfoValue);	
	}

}
