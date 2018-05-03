package com.ai.bce.plugin;

import com.ai.bce.bo.BceViewObjectBean;


/**
 * �ӿڳ���ʵ���� Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: AbstractPlgin.java
 * @Description: ����Ĺ�������
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Nov 1, 2010 2:48:46 PM
 */
public abstract class AbstractTagPlugin {
	protected StringBuffer displayBuffer = new StringBuffer();

	/**
	 * �������ʵ�ִ˷���
	 * 
	 * @Function: AbstractTagPlugin.java
	 * @Description: �ú����Ĺ�������
	 * 
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 1, 2010 8:15:14 PM
	 * 
	 */
	public abstract String display(BceViewObjectBean viewObjectBean,
			int pageframeId, String template_id) throws Exception;
	
	
	
}
