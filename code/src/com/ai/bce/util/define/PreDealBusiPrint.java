package com.ai.bce.util.define;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceData;
import com.ai.bce.util.bean.PreDealBusiPrintBean;

/**
 * bce ����Ԥ�����ӡ�ӿ�
 * @author qiangao
 *
 */
public interface PreDealBusiPrint {
	public PreDealBusiPrintBean doPreDealBusiPrint(IBceData bceData) throws Exception,RemoteException;
	//public boolean isMainTamlate() throws Exception;
}
