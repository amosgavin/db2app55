package com.asiainfo.charge.service.impl;

import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;
import com.asiainfo.charge.service.interfaces.IVoiceChargeConcessSV;
import com.asiainfo.charge.dao.interfaces.IVoiceChargeConcessDAO;
import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.common.ivalues.IBOBsStaticDataValue;
import com.ai.common.util.StaticDataUtil;

public class VoiceChargeConcessSVImpl implements IVoiceChargeConcessSV {
	/**
	 * �����ʷ�ID��ȡ�����Ż�����Ϣ
	 * 
	 * @param chargeId �ʷ�ID
	 * @return
	 * @throws Exception
	 */
	public IBOChargeConcessInfoValue getVoiceChargeMain(String chargeId)throws Exception,RuntimeException{
		IBOChargeConcessInfoValue concessMain = ((IVoiceChargeConcessDAO)ServiceFactory.getService(IVoiceChargeConcessDAO.class)).getVoiceChargeMain(chargeId);
		return concessMain;
	}
	
	/**
	 * �����ʷ�ID��ȡ�����Ż���ϸ��Ϣ
	 * 
	 * @param chargeId �ʷ�ID
	 * @return
	 * @throws Exception
	 */
	public IBOChargeConcessDetailInfoValue[] getVoiceChargeDetail(String concessid)throws Exception,RuntimeException{
		IBOChargeConcessDetailInfoValue[] concessDetail = ((IVoiceChargeConcessDAO)ServiceFactory.getService(IVoiceChargeConcessDAO.class)).getVoiceChargeDetail(concessid);
		
		IBOBsStaticDataValue[] staticDataValues = StaticDataUtil.getStaticData("YHB_BUSI_TYPE_VOICE");
		for (int i = 0; i < concessDetail.length; i++) {
			for (int j = 0; j < staticDataValues.length; j++) {
				if(staticDataValues[j].getCodeValue().equals(concessDetail[i].getDetailType())){
					concessDetail[i].setDetailType(staticDataValues[j].getCodeName());
				}
			}
		}
		
		return concessDetail;
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
		String concessId = ((IVoiceChargeConcessDAO)ServiceFactory.getService(IVoiceChargeConcessDAO.class)).saveChargeInfo(chargeConcessInfoValue);
		return concessId;
		
	}

	/**
	 * ���������Ż���Ϣ
	 * 
	 * @param IBOChargeConcessInfoValue
     *
	 * @return
	 * @throws Exception
	 */
	public void saveChargeInfo(IBOChargeConcessInfoValue[] beans)throws Exception,RuntimeException{
		((IVoiceChargeConcessDAO)ServiceFactory.getService(IVoiceChargeConcessDAO.class)).saveChargeInfo(beans);
	}
	
	/**
	 * ���������Ż���ϸ��Ϣ
	 * 
	 * @param IBOChargeConcessInfoValue �ʷ�ID
     *
	 * @return
	 * @throws Exception
	 */
	public void saveChargeDetailInfo(IBOChargeConcessDetailInfoValue[] chargeConcessDetailInfoValue)throws Exception,RuntimeException{
		((IVoiceChargeConcessDAO)ServiceFactory.getService(IVoiceChargeConcessDAO.class)).saveChargeDetailInfo(chargeConcessDetailInfoValue);
	}
	

}
