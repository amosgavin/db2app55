package com.ai.bce.configtool.dao.impl;

import com.ai.bce.auto.plugin.version.hand.bo.BceVerHandBean;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerHandEngine;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOrdBean;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOrdEngine;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerHandValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOrdValue;
import com.ai.bce.configtool.dao.interfaces.IConfVersionDAO;

public class ConfVersionDAOImpl implements IConfVersionDAO {

	public IBceVerHandValue getVerHands(String cond) throws Exception {
		IBceVerHandValue verHand = new BceVerHandBean();
		IBceVerHandValue[] verHands = BceVerHandEngine.getBeans(cond, null);
		if(null != verHands && 0< verHands.length){
			verHand = verHands[0];
		}
		return verHand;
	}

	public IBceVerOrdValue[] getVerOrds(String cond, int startIndex,
			int endIndex) throws Exception {
		return BceVerOrdEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}

	public int getVerOrdsCount(String cond) throws Exception {
		return BceVerOrdEngine.getBeansCount(cond, null);
	}

	public long saveVerHand(BceVerHandBean verHand) throws Exception {
		if(0 == verHand.getVersionId()){
			verHand.setVersionId(BceVerHandEngine.getNewId().longValue());
		}
		BceVerHandEngine.save(verHand);
		return verHand.getVersionId();
	}

	public void saveVerOrd(BceVerOrdBean verOrd) throws Exception {
		BceVerOrdEngine.save(verOrd);
	}

}
