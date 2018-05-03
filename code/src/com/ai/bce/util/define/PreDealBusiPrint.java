package com.ai.bce.util.define;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceData;
import com.ai.bce.util.bean.PreDealBusiPrintBean;

/**
 * bce 里面预处理打印接口
 * @author qiangao
 *
 */
public interface PreDealBusiPrint {
	public PreDealBusiPrintBean doPreDealBusiPrint(IBceData bceData) throws Exception,RemoteException;
	//public boolean isMainTamlate() throws Exception;
}
