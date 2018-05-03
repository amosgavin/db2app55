package com.ai.bce.dao.interfaces;

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
 * @ClassName: IBuSoDAO.java
 * @Description: ����ҳ���ѯ��DAO
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Oct 21, 2010 10:04:16 AM
 * 
 * Modification History: Date Author Version Description
 * ---------------------------------------------------------* Oct 21, 2010
 * Qinjin Peng v1.0.0 �޸�ԭ��
 */
public interface IBceAutoPageDAO {
	/**
	 * 
	 * @Function: IBuSoDAO.java
	 * @Description: ҳ����չ��Ŀǰ���е�ViewObject
	 * 
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Oct 21, 2010 10:04:36 AM
	 * 
	 * Modification History: Date Author Version Description
	 * ---------------------------------------------------------* Oct 21, 2010
	 * Qinjin Peng v1.0.0 �޸�ԭ��
	 */

	public BceViewObjectBean getBuViewObjectBeanById(long id) throws Exception;

	public BcePageRelConfigBean[] getPageRelByPageFrameId(long pa, long prantId,
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
}
