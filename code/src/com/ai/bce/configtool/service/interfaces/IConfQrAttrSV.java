package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.bo.BceQrAttrBean;
import com.ai.bce.ivalues.IBceQrAttrValue;

public interface IConfQrAttrSV {


	/**
	 * 
	 * @Function: IConfQrAttrSV::queryBceQrTemplateValues
	 * @Description: �ú����Ĺ�������
	 * @param contentClass
	 * @param templateName
	 * @param filePath
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-10 ����04:38:24 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-10     Administrator          v1.1.0               �޸�ԭ��
	 */
	public IBceQrAttrValue[] queryBceQrTemplateAttrValues(String templateId,int startNum,int endNum) throws Exception;

	
	/**
	 * 
	 * @Function: IConfQrAttrSV::queryBceQrTemplateCounts
	 * @Description: �ú����Ĺ�������
	 * @param contentClass
	 * @param templateName
	 * @param filePath
	 * @param parameter
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-10 ����04:38:28 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-10     Administrator          v1.1.0               �޸�ԭ��
	 */
	public int queryBceQrTemplateAttrCounts(String templateId)throws Exception;
	
	/**
	 * 
	 * @Function: IConfQrAttrSV::saveBceTempalteAttr
	 * @Description: ����ģ��������Ϣ
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 ����02:04:34 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     Administrator          v1.1.0               �޸�ԭ��
	 */
	public boolean saveBceTempalteAttr(BceQrAttrBean bean)throws Exception;
	
	/**
	 * 
	 * @Function: IConfQrAttrSV::delBceTemplateAttr
	 * @Description: ɾ��ģ��������Ϣ
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 ����02:20:02 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     Administrator          v1.1.0               �޸�ԭ��
	 */
	public boolean delBceTemplateAttr(String attrId)throws Exception;
	

}
