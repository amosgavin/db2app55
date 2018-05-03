package com.ai.bce.util.define;

import java.rmi.RemoteException;
import java.util.Map;

import com.ai.bce.ivalues.IBceData;
import com.ai.bce.util.bean.PreDealBusiPrintBean;

/**
 * bce ����Ĵ�ӡ�ӿ�
 * @author qiangao
 *
 */
public interface DealBusiPrint {
	/**
	 * �Ѵ�ӡ״̬��ƽ̨��ִ��
	 */
	public static final String PRINTED_PLAT="5";
	/**
	 * Ԥ��ӡ״̬
	 */
	public static final String PRE_PRINTED="4";
	/**
	 * �Ѵ�ӡ
	 */
	public static final String PRINTED="1";
	/**
	 * ����Ҫ��ӡ
	 */
	public static final String NO_NEED_PRINT="2";
	/**
	 * δ��ӡ
	 */
	public static final String NOT_YET_PRINT="3";
	
	/**
	 * ͨ��CRM���ӡ
	 */
	public static final String CRM_PRINT="2";
	
	/**
	 * ͨ����ֽ��ƽ̨��ӡ
	 */
	public static final String PLAT_PRINT="1";
	
	public void saveBusiPrintInfo(long bceFrameId) throws Exception,RemoteException;
	
	public void setSoBusiPrintInfo(IBceData bceData,PreDealBusiPrintBean preDealBusiPrintBean) throws Exception,RemoteException;
	
	public Map getSetBusiPrintInfo() throws Exception,RemoteException;
	
	
}
