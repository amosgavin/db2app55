package com.ai.bce.configtool.service.interfaces;

import java.util.Map;

import com.ai.bce.bo.BceQrTemplateBean;
import com.ai.bce.ivalues.IBceQrTemplateValue;

public interface IConfQrTemplateSV {


	/**
	 * 
	 * @Function: IConfQrTemplateSV::queryBceQrTemplateValues
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
	public IBceQrTemplateValue[] queryBceQrTemplateValues(String contentClass,String templateName,String filePath,int startNum,int endNum) throws Exception;

	
	/**
	 * 
	 * @Function: IConfQrTemplateSV::queryBceQrTemplateCounts
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
	public int queryBceQrTemplateCounts(String contentClass,String templateName,String filePath)throws Exception;
	
	/**
	 * 
	 * @Function: IConfQrTemplateSV::saveBceQtTemplateValue
	 * @Description: ���� �������޸ĺ��ģ����Ϣ
	 * @param bean
	 * @return
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 ����05:06:57 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     Administrator          v1.1.0               �޸�ԭ��
	 */
	public boolean saveBceQrTemplateValue(BceQrTemplateBean bean)throws Exception;
	
	/**
	 * 
	 * @Function: IConfQrTemplateSV::delBceQrTempalteValue
	 * @Description: �ú����Ĺ�������
	 * @param templateId
	 * @return
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 ����05:08:56 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     Administrator          v1.1.0               �޸�ԭ��
	 */
	public boolean delBceQrTempalteValue(String templateId)throws Exception;
	

}
