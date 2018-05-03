package com.ai.bce.util.define;

import java.rmi.RemoteException;
import java.util.Map;

import com.ai.bce.ivalues.IBceData;
import com.ai.bce.util.bean.PreDealBusiPrintBean;

/**
 * bce 里面的打印接口
 * @author qiangao
 *
 */
public interface DealBusiPrint {
	/**
	 * 已打印状态（平台回执）
	 */
	public static final String PRINTED_PLAT="5";
	/**
	 * 预打印状态
	 */
	public static final String PRE_PRINTED="4";
	/**
	 * 已打印
	 */
	public static final String PRINTED="1";
	/**
	 * 不需要打印
	 */
	public static final String NO_NEED_PRINT="2";
	/**
	 * 未打印
	 */
	public static final String NOT_YET_PRINT="3";
	
	/**
	 * 通过CRM侧打印
	 */
	public static final String CRM_PRINT="2";
	
	/**
	 * 通过无纸化平台打印
	 */
	public static final String PLAT_PRINT="1";
	
	public void saveBusiPrintInfo(long bceFrameId) throws Exception,RemoteException;
	
	public void setSoBusiPrintInfo(IBceData bceData,PreDealBusiPrintBean preDealBusiPrintBean) throws Exception,RemoteException;
	
	public Map getSetBusiPrintInfo() throws Exception,RemoteException;
	
	
}
