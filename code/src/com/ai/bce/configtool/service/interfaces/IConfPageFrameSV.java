package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBcePageFrameValue;
import com.ai.bce.ivalues.IBcePageValue;

public interface IConfPageFrameSV {
public IBcePageFrameValue getBcePageFrameValueByBcePageFrameId(String bcePageFrameId) throws RemoteException, Exception;

public IBcePageFrameValue[] getPageFrameValues(String cond,int startIndex,int endIndex)throws Exception;

public int getPageFrameValuesCount(String cond) throws Exception;

public IBcePageValue[] getBcePageValuesByBcePageFrameId(String bcePageFrameId) throws RemoteException, Exception;
}
