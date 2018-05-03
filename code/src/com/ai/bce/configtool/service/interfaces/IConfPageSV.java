package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBcePageValue;
import com.ai.bce.ivalues.IQBOBcePagePageFrameValue;
import com.ai.bce.ivalues.IQBOBcePageRelRowsetValue;
import com.ai.bce.ivalues.IQBOBcePageRulesetRuleValue;
import com.ai.bce.ivalues.IQBOBceRowsetPageValue;
/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: IBcePageSV.java
 * @Description: ҳ�����ӿ�
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 10, 2010 10:43:20 AM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 10, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
 */
public interface IConfPageSV {

	/**
	 * 
	 * @Function: getBcePageValues
	 * @Description: ����������ȡҳ����Ϣ
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 10, 2010 10:51:46 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 10, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IBcePageValue[] getBcePageValues(String cond, int startNum, int endNum)throws Exception, RemoteException;
	
	public IBcePageValue[] getBcePageValues(String cond)throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBcePageCount
	 * @Description: ����������ȡҳ����Ϣ
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 3:06:30 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public int getBcePageCount(String cond) throws Exception, RemoteException;
	
	/**
	 * 
	 * @Function: getRelatePagesByRowsetId
	 * @Description: �������ݼ���Ż�ȡ���ø����ݼ�������ҳ����Ϣ
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 14, 2010 8:13:38 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 14, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IQBOBceRowsetPageValue[] getRelatePagesByRowsetId(long rowsetId, int startNum, int endNum) throws Exception, RemoteException;
	public IQBOBceRowsetPageValue[] getRelatePagesByRowsetId(long rowsetId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelatePageCountByRowsetId
	 * @Description: �������ݼ���Ż�ȡ���ø����ݼ���ҳ������
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 11:34:48 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public int getRelatePageCountByRowsetId(long rowsetId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelatePageFramesByPageId
	 * @Description: ����ҳ���Ż�ȡ���ø�ҳ���ҳ����
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 15, 2010 9:49:06 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 15, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IQBOBcePagePageFrameValue[] getRelatePageFramesByPageId(long pageId, int startNum, int endNum) throws Exception, RemoteException;
	public IQBOBcePagePageFrameValue[] getRelatePageFramesByPageId(long pageId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelatePageFrameCount
	 * @Description: ����ҳ���Ż�ȡ���ø�ҳ���ҳ��������
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 3:12:03 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public int getRelatePageFrameCount(long pageId)throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelateRulesByPageId
	 * @Description: ����ҳ���Ż�ȡҳ������Ĺ���
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 15, 2010 11:16:30 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 15, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IQBOBcePageRulesetRuleValue[] getRelateRulesByPageId(long pageId, int start, int end) throws Exception, RemoteException;
	public IQBOBcePageRulesetRuleValue[] getRelateRulesByPageId(long pageId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelateRuleCountByPageId
	 * @Description: ����ҳ���Ż�ȡҳ������Ĺ�������
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 15, 2010 11:17:47 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 15, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public int getRelateRuleCountByPageId(long pageId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelateRowsetsByPageId
	 * @Description: ����ҳ���Ż�ȡҳ����������ݼ�
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 15, 2010 2:23:25 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 15, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IQBOBcePageRelRowsetValue[] getRelateRowsetsByPageId(long pageId, int start, int end) throws Exception, RemoteException;
	public IQBOBcePageRelRowsetValue[] getRelateRowsetsByPageId(long pageId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelateRowsetCountByPageId
	 * @Description: ����ҳ���Ż�ȡҳ����������ݼ�����
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 15, 2010 2:22:45 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 15, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public int getRelateRowsetCountByPageId(long pageId) throws Exception, RemoteException;
}
