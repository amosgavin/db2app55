package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeInfoValue;

public interface IChargeMainDeSV {
	//保存资费子信息
	public String saveChargeMainDe(IBOChargeInfoValue chargeMainValue)
	throws Exception, RuntimeException;
	//根据ID查资费子信息
	public IBOChargeInfoValue IChargeMainDeshow(String id)
	throws Exception, RuntimeException;
	
	
}
