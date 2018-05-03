package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeApplyMainValue;
import com.asiainfo.charge.ivalues.IBOChargeMainValue;

public interface IChargeNewMainSV {
	public void chargeStateToUse(String id) throws Exception, RuntimeException;

	public void chargeStateToNoUse(String id) throws Exception,
			RuntimeException;

	public void chargeStateToUse(String id, String result) throws Exception,
			RuntimeException;

	public void chargeStateToNoUse(String id, String result) throws Exception,
			RuntimeException;

	public void changeChargeMainState(String mid, String state)
			throws Exception, RuntimeException;

	public IBOChargeMainValue IChargeMainshow(String id) throws Exception;

	public IBOChargeMainValue[] IChargeNewMainByMessage(String id,
			String applyTime, String applyEndTime, String principle,
			String isSubmit, String townname, String appname,
			int $STARTROWINDEX, int $ENDROWINDEX) throws Exception;

	public int IChargeNewMainByMessageCount(String id, String applyTime,
			String applyEndTime, String principle, String isSubmit,
			String townname, String appname) throws Exception;

	public String saveChargeNewMain(IBOChargeMainValue chargeNewMainValue)
			throws Exception, RuntimeException;

	public IBOChargeApplyMainValue[] getApplyMainsByMainId(String mainid)
			throws Exception, RuntimeException;

	public void delChargeMain(String id) throws Exception, RuntimeException;
}
