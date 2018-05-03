package com.ai.bce.service.interfaces;

import com.ai.bce.bo.BcePageBean;
import com.ai.bce.bo.BcePageRelConfigBean;
import com.ai.bce.bo.BceRuleBean;
import com.ai.bce.bo.BceRulesetRuleBean;
import com.ai.bce.bo.BceVObjectConfBean;
import com.ai.bce.bo.BceViewObjectAttrBean;
import com.ai.bce.bo.BceViewObjectBean;

/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: IBuSoSV.java
 * @Description: 业务曾接口实现
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Oct 21, 2010 3:06:36 PM
 * 
 * Modification History: Date Author Version Description
 * ---------------------------------------------------------* Oct 21, 2010
 * Qinjin Peng v1.0.0 修改原因
 */
public interface IBceAutoPageSV {

	public BceViewObjectBean getBuViewObjectBeanById(long id) throws Exception;

	public String getJsString(long pageFrameId) throws Exception;

	public BcePageRelConfigBean[] getPageRelByPageFrameId(int pa, long prantId,
			String tempalte_id) throws Exception;

	public BceVObjectConfBean getBuVObjectConfBeanByTypeName(String objType)
			throws Exception;

	public BceViewObjectAttrBean[] getBuViewObjectAttrBeanByobjID(long id)
			throws Exception;

	public BceViewObjectBean getBuViewObjectBeanByRelId(long prant_id)
			throws Exception;

	public BceVObjectConfBean[] getTagPlgins() throws Exception;

	public BcePageRelConfigBean getBuPageRelConfigBeanById(long relateAttrId)
			throws Exception;

	public BcePageBean getBePageBean(long pageId) throws Exception;

	public BceRulesetRuleBean[] getPageRuleSetRule(long pageRulesetId)
			throws Exception;

	public BceRuleBean getBeRuleBy(long ruleId) throws Exception;

	public BcePageBean getBePageById(long pageFrameId) throws Exception;

	public BceViewObjectAttrBean[] getBuViewObjectAttrBeanByRelConfigID(
			long relConfigId) throws Exception;

}
