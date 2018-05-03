package com.ai.bce.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.bo.BcePageBean;
import com.ai.bce.bo.BcePageRelConfigBean;
import com.ai.bce.bo.BceRuleBean;
import com.ai.bce.bo.BceRulesetRuleBean;
import com.ai.bce.bo.BceVObjectConfBean;
import com.ai.bce.bo.BceViewObjectAttrBean;
import com.ai.bce.bo.BceViewObjectBean;
import com.ai.bce.dao.interfaces.IBceAutoPageDAO;
import com.ai.bce.service.interfaces.IBceAutoPageSV;

/**
 * 业务框架接口实现类
 * 
 * @author rudys.eva
 * 
 */
public class BceAutoPageSVImpl implements IBceAutoPageSV {
	
	public IBceAutoPageDAO getBceAutoPageDao(){
		return (IBceAutoPageDAO) ServiceFactory.getService(IBceAutoPageDAO.class);
	}

	/**
	 * 获取ActionBean
	 */
	/*
	 * public BuJsActionBean[] getBuJsActionBeanByFrameId(int frameid) throws
	 * Exception { // TODO Auto-generated method stub return
	 * getBceAutoPageDao().getBuJsActionBeanByFrameId(frameid); }
	 */

	/**
	 * 
	 */
	public BceViewObjectBean getBuViewObjectBeanById(long id) throws Exception {
		// TODO Auto-generated method stub
		return getBceAutoPageDao().getBuViewObjectBeanById(id);
	}

	/**
	 * 
	 */
	/*
	 * public BuObjectButtonBean[] getBuObjectButtonBeanByEntityId(int id)
	 * throws Exception { // TODO Auto-generated method stub return
	 * getBceAutoPageDao().getBuObjectButtonBeanByEntityId(id); }
	 * 
	 *//**
		 * 
		 */
	/*
	 * public BuObjectParamsBean[] getBuObjectParamsBeanByActionId(int actionId)
	 * throws Exception { // TODO Auto-generated method stub return
	 * getBceAutoPageDao().getBuObjectParamsBeanByActionId(actionId); }
	 * 
	 *//**
		 * 
		 */
	/*
	 * public BuActionBean getBuActionBeanById(int id) throws Exception { //
	 * TODO Auto-generated method stub return
	 * getBceAutoPageDao().getBuActionBeanById(id); }
	 * 
	 * 
	 * 
	 * public BuPageTemplatesBean getBuPageTemplatesBeanByJspCode(int jsp_code)
	 * throws Exception { // TODO Auto-generated method stub BuPageFrameBean
	 * buPageFrameBean = getBceAutoPageDao() .getBuPageFrameBeanByJspCode(jsp_code);
	 * BuPageTemplatesBean buPageTemplatesBean = getBceAutoPageDao()
	 * .getBuPageTemplatesBeanById(buPageFrameBean .getPageTemplatesId());
	 * return buPageTemplatesBean; }
	 */
	public BcePageRelConfigBean[] getPageRelByPageFrameId(int pa, long prantId,
			String tempalte_id) throws Exception {
		// TODO Auto-generated method stub
		return getBceAutoPageDao().getPageRelByPageFrameId(pa, prantId, tempalte_id);
	}

	public BceVObjectConfBean getBuVObjectConfBeanByTypeName(String objType)
			throws Exception {
		// TODO Auto-generated method stub
		return getBceAutoPageDao().getBuVObjectConfBeanByTypeName(objType);
	}

	public BceViewObjectAttrBean[] getBuViewObjectAttrBeanByobjID(long id)
			throws Exception {
		// TODO Auto-generated method stub
		return getBceAutoPageDao().getBuViewObjectAttrBeanByobjID(id);
	}

	public BceViewObjectBean getBuViewObjectBeanByRelId(long prant_id)
			throws Exception {
		// TODO Auto-generated method stub
		return getBceAutoPageDao().getBuViewObjectBeanByRelId(prant_id);
	}

	public BceVObjectConfBean[] getTagPlgins() throws Exception {
		// TODO Auto-generated method stub
		return getBceAutoPageDao().getTagPlgins();
	}

	public BcePageRelConfigBean getBuPageRelConfigBeanById(long relateAttrId)
			throws Exception {
		// TODO Auto-generated method stub
		return getBceAutoPageDao().getBuPageRelConfigBeanById(relateAttrId);
	}

	public String getJsString(long pageFrameId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public BcePageBean getBePageBean(long pageId) throws Exception {
		// TODO Auto-generated method stub
		return getBceAutoPageDao().getBePageBean(pageId);
	}

	public BceRulesetRuleBean[] getPageRuleSetRule(long pageRulesetId)
			throws Exception {
		// TODO Auto-generated method stub
		return getBceAutoPageDao().getPageRuleSetRule(pageRulesetId);
	}

	public BceRuleBean getBeRuleBy(long ruleId) throws Exception {
		// TODO Auto-generated method stub
		return getBceAutoPageDao().getBeRuleBy(ruleId);
	}

	public BcePageBean getBePageById(long pageFrameId) throws Exception {
		// TODO Auto-generated method stub
		return getBceAutoPageDao().getBePageById(pageFrameId);
	}

	public BceViewObjectAttrBean[] getBuViewObjectAttrBeanByRelConfigID(
			long relConfigId) throws Exception {
		// TODO Auto-generated method stub
		return this.getBuViewObjectAttrBeanByobjID(this
				.getBuPageRelConfigBeanById(relConfigId).getRelateObjId());
	}
}