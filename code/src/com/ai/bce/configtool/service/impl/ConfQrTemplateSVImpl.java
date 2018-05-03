package com.ai.bce.configtool.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.util.StringUtils;
import com.ai.bce.bo.BceFrameBean;
import com.ai.bce.bo.BceFrameEngine;
import com.ai.bce.bo.BceQrAttrBean;
import com.ai.bce.bo.BceQrAttrEngine;
import com.ai.bce.bo.BceQrTemplateBean;
import com.ai.bce.bo.BceQrTemplateEngine;
import com.ai.bce.configtool.dao.interfaces.IConfQrTemplateDAO;
import com.ai.bce.configtool.service.interfaces.IConfQrTemplateSV;
import com.ai.bce.ivalues.IBceQrTemplateValue;
import com.ai.bce.util.BServiceFactory;

public class ConfQrTemplateSVImpl implements IConfQrTemplateSV {

	private final static Log log = LogFactory.getLog(ConfQrTemplateSVImpl.class);
	
	
	
	/**
	 * 
	 * @Function: ConfQrTemplateSVImpl::queryBceQrTemplateCounts
	 * @Description: 查询确认页模板信息数量
	 * @param contentClass
	 * @param templateName
	 * @param filePath
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 下午04:38:00 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentao          v1.1.0               修改原因
	 */
	public int queryBceQrTemplateCounts(String contentClass,String templateName,String filePath)
			throws Exception {
		
		if(log.isInfoEnabled()){
			log.info("ConfQrTemplateSVImpl queryBceQrTemplateCounts start");
		}
		
		HashMap infomap = new HashMap();
		//拼接查询条件，内容类（contentClass）支持模糊查询
		StringBuffer condition = new StringBuffer("1=1");
		
		if (!StringUtils.isEmptyString(contentClass)) {
			condition.append(" AND " + IBceQrTemplateValue.S_ContentClass+" like :contentClass");
			infomap.put("contentClass", '%'+contentClass+'%');
		}
		
		if (!StringUtils.isEmptyString(templateName)) {
			condition.append(" AND " + IBceQrTemplateValue.S_TemplateName+" like :templateName");
			infomap.put("templateName", '%'+templateName+'%');
		}
		
		if (!StringUtils.isEmptyString(filePath)) {
			condition.append(" AND " + IBceQrTemplateValue.S_FilePath+" like :filePath");
			infomap.put("filePath", '%'+filePath+'%');
		}
		
		//存在状态为1
		condition.append(" AND " + IBceQrTemplateValue.S_State+" = :state");
		infomap.put("state", String.valueOf(1));
		
		IConfQrTemplateDAO bceQrTemplateDao = getBceQrTemplateDAO();
		
		int count = bceQrTemplateDao.queryBceQrTemplateCounts(condition.toString(), infomap);
		return count;
	}

	/**
	 * 
	 * @Function: ConfQrTemplateSVImpl::queryBceQrTemplateValues
	 * @Description: 查询确认页模板信息
	 * @param contentClass
	 * @param templateName
	 * @param filePath
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 下午04:38:05 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentao          v1.1.0               修改原因
	 */
	public IBceQrTemplateValue[] queryBceQrTemplateValues(String contentClass,String templateName,String filePath,int startNum,int endNum) throws Exception {
		if(log.isInfoEnabled()){
			log.info("ConfQrTemplateSVImpl queryBceQrTemplateValues start");
		}
		
		HashMap infomap = new HashMap();
		//拼接查询条件，内容类（contentClass）支持模糊查询
		StringBuffer condition = new StringBuffer("1=1");
		
		if (!StringUtils.isEmptyString(contentClass)) {
			condition.append(" AND " + IBceQrTemplateValue.S_ContentClass+" like :contentClass");
			infomap.put("contentClass", '%'+contentClass+'%');
		}
		
		if (!StringUtils.isEmptyString(templateName)) {
			condition.append(" AND " + IBceQrTemplateValue.S_TemplateName+" like :templateName");
			infomap.put("templateName", '%'+templateName+'%');
		}
		
		if (!StringUtils.isEmptyString(filePath)) {
			condition.append(" AND " + IBceQrTemplateValue.S_FilePath+" like :filePath");
			infomap.put("filePath", '%'+filePath+'%');
		}
		
		//存在状态为1
		condition.append(" AND " + IBceQrTemplateValue.S_State+" = :state");
		infomap.put("state", String.valueOf(1));
		condition.append(" order by "+IBceQrTemplateValue.S_TemplateId+" asc");		
		IConfQrTemplateDAO bceQrTemplateDao = getBceQrTemplateDAO();
		
		IBceQrTemplateValue[] templateArr = bceQrTemplateDao.queryBceQrTemplateValues(condition.toString(), infomap, startNum, endNum);
		return templateArr;
	}
	
	
	private IConfQrTemplateDAO getBceQrTemplateDAO() throws Exception{
		return (IConfQrTemplateDAO) BServiceFactory.getService(IConfQrTemplateDAO.class);
	}

	/**
	 * 
	 * @Function: ConfQrTemplateSVImpl::delBceQrTempalteValue
	 * @Description: 删除bce 模板信息
	 *               1、模板关联的属性信息，然后再删除模板信息
	 *               2、把 处理框架 中相关联的模板信息 置为空
	 *               3、逻辑删除模板信息
	 * @param templateId
	 * @return
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 下午05:15:10 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentato          v1.1.0               修改原因
	 */
	public boolean delBceQrTempalteValue(String templateId)throws Exception {
		long id = Long.valueOf(templateId).longValue();
		IBceQrTemplateValue tempalteBean = BceQrTemplateEngine.getBean(id);
		
		String condition = "1=1 and "+BceQrAttrBean.S_TemplateId+" = :"+BceQrAttrBean.S_TemplateId+" and "+BceQrAttrBean.S_State+" = :"+BceQrAttrBean.S_State;
		Map parameter = new HashMap();
		parameter.put(BceQrAttrBean.S_TemplateId, templateId);
		parameter.put(BceQrAttrBean.S_State,1);
		BceQrAttrBean[] bceQrAttrBeans = BceQrAttrEngine.getBeans(condition, parameter);             //1、查询模板对应的属性信息
		
		if(bceQrAttrBeans != null){                                                                  //如果有属性信息，把属性信息状态置为0
			for(int i=0;i<bceQrAttrBeans.length;i++){
				BceQrAttrBean attrBean = bceQrAttrBeans[i];
				attrBean.setState(0);
			}
			BceQrAttrEngine.saveBatch(bceQrAttrBeans);
		}
		
		String cond = "1=1 and "+BceFrameBean.S_PrintTemplateId+" = :"+BceFrameBean.S_PrintTemplateId;
		Map para = new HashMap();
		para.put(BceFrameBean.S_PrintTemplateId, templateId);
		
		BceFrameBean[] bceFrameBeans = BceFrameEngine.getBeans(cond, para);                            //2、查询模板对应的处理框架信息
		if(bceFrameBeans != null){                                                                     //如果有处理框架信息，把打印模板ID置为空
			for(int i=0;i<bceFrameBeans.length;i++){
				BceFrameBean frameBean = bceFrameBeans[i];
				frameBean.setPrintTemplateId(0);
		     }
			BceFrameEngine.saveBatch(bceFrameBeans);
		}
		
		if(tempalteBean != null){                                                          				//3、逻辑删除模板信息
			tempalteBean.setState(0); 
			BceQrTemplateEngine.save(tempalteBean);
			return true;
		}
		
		return false;
	}

	/**
	 * 
	 * @Function: ConfQrTemplateSVImpl::saveBceQrTemplateValue
	 * @Description: 保存修改、新增的bce 模板信息
	 * @param bean
	 * @return
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 下午05:15:14 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentato          v1.1.0               修改原因
	 */
	public boolean saveBceQrTemplateValue(BceQrTemplateBean bean) throws Exception{

		if(bean != null){
			if(bean.getTemplateId() == 0){
				bean.setTemplateId(BceQrTemplateEngine.getNewId().longValue());
			}
			bean.setState(1);
			BceQrTemplateEngine.save(bean);
			return true;
		}
		
		return false;
	
	}

}
