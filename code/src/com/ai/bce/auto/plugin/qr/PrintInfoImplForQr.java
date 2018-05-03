package com.ai.bce.auto.plugin.qr;

import java.rmi.RemoteException;
import java.util.HashMap;

import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceWarnValue;
import com.ai.bce.util.BceServiceFactory;

/**
 * 
 * ȷ��ҳ��Ϣ�ӿڲ���
 * 
 * @ClassName: PrintInfoImplForQr.java
 * @Description:
 * @author :���ؽ�
 * @date 2011-7-21
 * @email:pengqj@asiainfo-linkage.com
 */
public class PrintInfoImplForQr {
	/**
	 * ��ȡ������Ϣ�ڴ�ҳ�ϵĽӿڷ���
	 * 
	 * @param bceData
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public String getPrintContentByQr(HashMap map) throws RemoteException,
			Exception {
		IBceData bceData  = (IBceData) map.get("BCEDATA");
		IBceWarnValue bceWarnValue = BceServiceFactory.getBceFrameSV()
				.getWarnContent(bceData.getBceFrameId(), "", "", "", 3);
		if (bceWarnValue != null) {
			return bceWarnValue.getWarnContent();
		}
		return null;
	}
}
