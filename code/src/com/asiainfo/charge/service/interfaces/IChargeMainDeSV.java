package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeInfoValue;

public interface IChargeMainDeSV {
	//�����ʷ�����Ϣ
	public String saveChargeMainDe(IBOChargeInfoValue chargeMainValue)
	throws Exception, RuntimeException;
	//����ID���ʷ�����Ϣ
	public IBOChargeInfoValue IChargeMainDeshow(String id)
	throws Exception, RuntimeException;
	
	
}
