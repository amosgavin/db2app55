package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceAttrValue;
import com.ai.bce.ivalues.IBceFormGroupValue;
import com.ai.bce.ivalues.IBceFrameAreaFormValue;

public interface IConfFrameAreaFormSV {
public IBceFrameAreaFormValue getFrameAreaFormValueById(String bceFrameId,String formId) throws RemoteException,Exception;

public IBceAttrValue[] getBceAttr(String cond,int startIndex,int endIndex)throws Exception;

public int getBceAttrCount(String cond)throws Exception;
	/**
	 * 
	 * @Function: getBceAttr
	 * @Description: ����������ѯ������Ϣ
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 21, 2010 9:34:19 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 21, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IBceAttrValue[] getBceAttr(String cond)throws Exception, RemoteException;
	
	public IBceFormGroupValue[] getGroups(String cond) throws Exception;
}
