package com.ai.bce.configtool.service.interfaces;

import java.util.Map;

import com.ai.bce.bo.BceQrTemplateBean;
import com.ai.bce.ivalues.IBceQrTemplateValue;

public interface IConfQrTemplateSV {


	/**
	 * 
	 * @Function: IConfQrTemplateSV::queryBceQrTemplateValues
	 * @Description: 该函数的功能描述
	 * @param contentClass
	 * @param templateName
	 * @param filePath
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-10 下午04:38:24 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-10     Administrator          v1.1.0               修改原因
	 */
	public IBceQrTemplateValue[] queryBceQrTemplateValues(String contentClass,String templateName,String filePath,int startNum,int endNum) throws Exception;

	
	/**
	 * 
	 * @Function: IConfQrTemplateSV::queryBceQrTemplateCounts
	 * @Description: 该函数的功能描述
	 * @param contentClass
	 * @param templateName
	 * @param filePath
	 * @param parameter
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-10 下午04:38:28 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-10     Administrator          v1.1.0               修改原因
	 */
	public int queryBceQrTemplateCounts(String contentClass,String templateName,String filePath)throws Exception;
	
	/**
	 * 
	 * @Function: IConfQrTemplateSV::saveBceQtTemplateValue
	 * @Description: 保存 新增、修改后的模板信息
	 * @param bean
	 * @return
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 下午05:06:57 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     Administrator          v1.1.0               修改原因
	 */
	public boolean saveBceQrTemplateValue(BceQrTemplateBean bean)throws Exception;
	
	/**
	 * 
	 * @Function: IConfQrTemplateSV::delBceQrTempalteValue
	 * @Description: 该函数的功能描述
	 * @param templateId
	 * @return
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 下午05:08:56 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     Administrator          v1.1.0               修改原因
	 */
	public boolean delBceQrTempalteValue(String templateId)throws Exception;
	

}
