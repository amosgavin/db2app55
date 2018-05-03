package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBcePageRowsetRelValue;
import com.ai.bce.ivalues.IBceRowsetValue;
import com.ai.bce.ivalues.IQBOBcePageRowsetValue;

/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: IBceRowsetSV.java
 * @Description: ���ݼ�����ӿ�
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 10, 2010 11:17:11 AM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 10, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
 */
public interface IConfRowsetSV {

	/**
	 * 
	 * @Function: getPageRowsetValues
	 * @Description: ���ݲ�ѯ������ȡ���ݼ���������Ϣ
	 *
	 * @param: cond ��ѯ����
	 * @return��IQBOBcePageRowsetValue[] ���ݼ���������Ϣ
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 8, 2010 9:14:17 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 8, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IQBOBcePageRowsetValue[] getPageRowsetValues(String cond, int startNum, int endNum) throws Exception, RemoteException;
	public IQBOBcePageRowsetValue[] getPageRowsetValues(String cond ) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getPageRowsetCount
	 * @Description: ���ݲ�ѯ������ȡ���ݼ���������Ϣ����
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 3:36:04 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public int getPageRowsetCount(String cond) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRowsetValues
	 * @Description: ����������ȡ���ݼ���Ϣ
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 10, 2010 3:01:01 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 10, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IBceRowsetValue[] getRowsetValues(String cond, int startNum, int endNum) throws Exception, RemoteException;
	public IBceRowsetValue[] getRowsetValues(String cond ) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRowsetCount
	 * @Description: ����������ȡ���ݼ�����
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 2:33:09 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public int getRowsetCount(String cond) throws Exception, RemoteException;

	public IBcePageRowsetRelValue getPageRowsetRelValueById(String pageFramePageId,String rowsetId) throws Exception;
}
