/**   
 * @Title: IPrintContent.java 
 * @Package com.ai.bce.auto.plugin.qr 
 * @Description: TODO(��һ�仰�������ļ���ʲô) 
 * @author Qinjin Peng (Pengqj@asiainfo-linkage.com)   
 * @date 2011-4-3 ����10:52:36 
 * @version V1.0   
 */
package com.ai.bce.auto.plugin.qr;

import java.rmi.RemoteException;
import java.util.Map;

import com.ai.bce.ivalues.IBceData;

/**
 * ȷ��ҳ�ӿ���
 * 
 * @ClassName: IPrintContent
 * @Description: TODO(������һ�仰��������������)
 * @author Qinjin Peng
 * @date 2011-4-3 ����10:52:36
 * 
 */
public interface IPrintContent {

	/**
	 * @param bceFrameid 
	 * ��ȡ������������
	 * 
	 * @Title: getContent
	 * @Description: TODO
	 * @param @param bceData
	 * @param @param customOrderId
	 * @param @return
	 * @param @throws RemoteException
	 * @param @throws Exception
	 * @return Map
	 * @throws
	 */
	public Map getContent(IBceData bceData, long customOrderId, long bceFrameid)
			throws RemoteException, Exception;
}
