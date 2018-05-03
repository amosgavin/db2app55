package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.auto.plugin.version.hand.bo.BceVerHandBean;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOrdBean;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerHandValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOrdValue;

public interface IConfVersionSV {
public IBceVerHandValue getVerHands(String cond) throws Exception;
public long saveVerHand(BceVerHandBean verHand) throws Exception;
public IBceVerOrdValue[] getVerOrds(String cond,int startIndex,int endIndex) throws Exception;
public int getVerOrdsCount(String cond) throws Exception;
public void saveVerOrd(BceVerOrdBean verOrd) throws Exception;
}
