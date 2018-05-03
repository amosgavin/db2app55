package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.auto.plugin.version.hand.bo.BceVerHandBean;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOrdBean;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerHandValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOrdValue;

public interface IConfVersionDAO {
	public long saveVerHand(BceVerHandBean verHand) throws Exception;
	public void saveVerOrd(BceVerOrdBean verOrd) throws Exception;
	public IBceVerOrdValue[] getVerOrds(String cond,int startIndex,int endIndex) throws Exception;
	public int getVerOrdsCount(String cond) throws Exception;
	public IBceVerHandValue getVerHands(String cond) throws Exception;
}
