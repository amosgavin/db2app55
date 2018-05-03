package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceButtonValue;
import com.ai.bce.ivalues.IBceFrameButtonValue;

/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: IConfButtonSV.java
 * @Description: ��ť����ӿ�
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 20, 2010 10:21:57 AM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 20, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
 */
public interface IConfButtonSV {

	/**
	 * 
	 * @Function: getBceButton
	 * @Description: ����������ѯ��ť��Ϣ
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 10:23:48 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IBceButtonValue[] getBceButtonValues(String cond)throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBceButton
	 * @Description: ����������ѯ��ť��Ϣ
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 10:22:48 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IBceButtonValue[] getBceButtonValues(String cond, int startNum, int endNum)throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBceButtonCount
	 * @Description: ����������ѯ��ť��Ϣ������
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 10:25:02 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public int getBceButtonCount(String cond) throws Exception, RemoteException;
	
	/**
	 * 
	 * @Function: getBceFrameButton
	 * @Description: ����������ѯҵ������밴ť��ϵ
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 4:28:35 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IBceFrameButtonValue[] getBceFrameButton(String cond) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBceFrameButton
	 * @Description: ����������ѯҵ������밴ť��ϵ
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 4:29:40 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IBceFrameButtonValue[] getBceFrameButton(String cond, int startNum, int endNum) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBceFrameButtonCount
	 * @Description: ����������ѯҵ������밴ť��ϵ������
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 4:30:20 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public int getBceFrameButtonCount(String cond) throws Exception, RemoteException;

	public IBceButtonValue[] getBceButtons() throws Exception;
}
