package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IChargeNewMainDAO;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainValue;
import com.asiainfo.charge.ivalues.IBOChargeMainValue;
import com.asiainfo.charge.service.interfaces.IChargeNewMainSV;

public class ChargeNewMainSVImpl implements IChargeNewMainSV {

	@Override
	public IBOChargeMainValue IChargeMainshow(String id) throws Exception {
		IChargeNewMainDAO chargeNewMain = (IChargeNewMainDAO) ServiceFactory
				.getService(IChargeNewMainDAO.class);
		return chargeNewMain.IChargeMainshow(id);
	}

	@Override
	public void chargeStateToNoUse(String id) throws Exception,
			RuntimeException {
		IChargeNewMainDAO chargeNewMain = (IChargeNewMainDAO) ServiceFactory
				.getService(IChargeNewMainDAO.class);
		chargeNewMain.chargeStateToNoUse(id);

	}

	@Override
	public void chargeStateToUse(String id) throws Exception, RuntimeException {
		IChargeNewMainDAO chargeNewMain = (IChargeNewMainDAO) ServiceFactory
				.getService(IChargeNewMainDAO.class);
		chargeNewMain.chargeStateToUse(id);
	}

	@Override
	public IBOChargeApplyMainValue[] getApplyMainsByMainId(String mainid)
			throws Exception, RuntimeException {
		IChargeNewMainDAO chargeNewMain = (IChargeNewMainDAO) ServiceFactory
				.getService(IChargeNewMainDAO.class);
		return chargeNewMain.getApplyMainsByMainId(mainid);

	}

	@Override
	public String saveChargeNewMain(IBOChargeMainValue chargeNewMainValue)
			throws Exception, RuntimeException {
		IChargeNewMainDAO chargeNewMain = (IChargeNewMainDAO) ServiceFactory
				.getService(IChargeNewMainDAO.class);
		return chargeNewMain.saveChargeNewMain(chargeNewMainValue);
	}

	@Override
	public IBOChargeMainValue[] IChargeNewMainByMessage(String id,
			String applyTime, String applyEndTime, String principle,
			String isSubmit, String townname, String appname,
			int $startrowindex, int $endrowindex) throws Exception {
		IChargeNewMainDAO chargeNewMain = (IChargeNewMainDAO) ServiceFactory
				.getService(IChargeNewMainDAO.class);
		return chargeNewMain.IChargeNewMainByMessage(id, applyTime,
				applyEndTime, principle, isSubmit, townname, appname,
				$startrowindex, $endrowindex);
	}

	@Override
	public int IChargeNewMainByMessageCount(String id, String applyTime,
			String applyEndTime, String principle, String isSubmit,
			String townname, String appname) throws Exception {

		IChargeNewMainDAO chargeNewMain = (IChargeNewMainDAO) ServiceFactory
				.getService(IChargeNewMainDAO.class);
		return chargeNewMain.IChargeNewMainByMessageCount(id, applyTime,
				applyEndTime, principle, isSubmit, townname, appname);
	}

	@Override
	public void changeChargeMainState(String mid, String state)
			throws Exception, RuntimeException {
		IBOChargeMainValue chargeMainValue = this.IChargeMainshow(mid);
		chargeMainValue.setState(state);
		this.saveChargeNewMain(chargeMainValue);

	}

	@Override
	public void delChargeMain(String id) throws Exception, RuntimeException {
		IChargeNewMainDAO chargeNewMain = (IChargeNewMainDAO) ServiceFactory
				.getService(IChargeNewMainDAO.class);
		chargeNewMain.delChargeMain(id);

	}

	@Override
	public void chargeStateToNoUse(String id, String result) throws Exception,
			RuntimeException {

		if (result.equals("no")) {
			((IChargeNewMainDAO) ServiceFactory
					.getService(IChargeNewMainDAO.class))
					.chargeStateToNoUse(id);
		}
	}

	@Override
	public void chargeStateToUse(String id, String result) throws Exception,
			RuntimeException {

		if (result.equals("default")) {
			((IChargeNewMainDAO) ServiceFactory
					.getService(IChargeNewMainDAO.class)).chargeStateToUse(id);
		}
	}

}
