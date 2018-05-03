package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.bo.BceQrAttrBean;
import com.ai.bce.ivalues.IBceQrAttrValue;

public interface IConfQrAttrSV {


	/**
	 * 
	 * @Function: IConfQrAttrSV::queryBceQrTemplateValues
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
	public IBceQrAttrValue[] queryBceQrTemplateAttrValues(String templateId,int startNum,int endNum) throws Exception;

	
	/**
	 * 
	 * @Function: IConfQrAttrSV::queryBceQrTemplateCounts
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
	public int queryBceQrTemplateAttrCounts(String templateId)throws Exception;
	
	/**
	 * 
	 * @Function: IConfQrAttrSV::saveBceTempalteAttr
	 * @Description: 保存模板属性信息
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 下午02:04:34 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     Administrator          v1.1.0               修改原因
	 */
	public boolean saveBceTempalteAttr(BceQrAttrBean bean)throws Exception;
	
	/**
	 * 
	 * @Function: IConfQrAttrSV::delBceTemplateAttr
	 * @Description: 删除模板属性信息
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 下午02:20:02 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     Administrator          v1.1.0               修改原因
	 */
	public boolean delBceTemplateAttr(String attrId)throws Exception;
	

}
