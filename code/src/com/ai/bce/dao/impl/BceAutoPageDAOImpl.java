package com.ai.bce.dao.impl;

import com.ai.appframe2.util.criteria.Criteria;
import com.ai.bce.bo.BcePageBean;
import com.ai.bce.bo.BcePageEngine;
import com.ai.bce.bo.BcePageRelConfigBean;
import com.ai.bce.bo.BcePageRelConfigEngine;
import com.ai.bce.bo.BceRuleBean;
import com.ai.bce.bo.BceRuleEngine;
import com.ai.bce.bo.BceRulesetRuleBean;
import com.ai.bce.bo.BceRulesetRuleEngine;
import com.ai.bce.bo.BceVObjectConfBean;
import com.ai.bce.bo.BceVObjectConfEngine;
import com.ai.bce.bo.BceViewObjectAttrBean;
import com.ai.bce.bo.BceViewObjectAttrEngine;
import com.ai.bce.bo.BceViewObjectBean;
import com.ai.bce.bo.BceViewObjectEngine;
import com.ai.bce.dao.interfaces.IBceAutoPageDAO;
import com.ai.bce.util.BceException;

public class BceAutoPageDAOImpl implements IBceAutoPageDAO {

	public BceViewObjectBean getBuViewObjectBeanById(long id) throws Exception {
		// TODO Auto-generated method stub
		return BceViewObjectEngine.getBean(id);
	}

	public BcePageRelConfigBean[] getPageRelByPageFrameId(long pa, long prantId,
			String tempalte_id) throws Exception {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		criteria.addEqual(BcePageRelConfigBean.S_PageId, pa);
		criteria.addEqual(BcePageRelConfigBean.S_PreRelateId, prantId);
		criteria.addEqual(BcePageRelConfigBean.S_TemplateId, tempalte_id);
		criteria.addAscendingOrderByColumn(BcePageRelConfigBean.S_SeqNo);
		return BcePageRelConfigEngine.getBeans(criteria);
	}

	public BceVObjectConfBean getBuVObjectConfBeanByTypeName(String objType)
			throws Exception {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		criteria.addEqual(BceVObjectConfBean.S_ObjTypeId, objType);
		BceVObjectConfBean[] beans = BceVObjectConfEngine.getBeans(criteria);
		if (beans == null || beans.length < 1) {
			throw new BceException("BES0000412");
		}
		return beans[0];
	}

	public BceViewObjectAttrBean[] getBuViewObjectAttrBeanByobjID(long id)
			throws Exception {
		// TODO Auto-generated method stub

		Criteria criteria = new Criteria();
		criteria.addEqual(BceViewObjectAttrBean.S_ObjectId, id);
		return BceViewObjectAttrEngine.getBeans(criteria);
	}

	public BceViewObjectBean getBuViewObjectBeanByRelId(long prant_id)
			throws Exception {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		
		criteria.addEqual(BcePageRelConfigBean.S_PageRelId, prant_id);
		BcePageRelConfigBean buPageRelConfigBean = BcePageRelConfigEngine
				.getBean(prant_id);
		if (buPageRelConfigBean == null) {
			return null;
		}
		return BceViewObjectEngine
				.getBean(buPageRelConfigBean.getRelateObjId());
	}

	public BceVObjectConfBean[] getTagPlgins() throws Exception {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		criteria.addEqual(BceVObjectConfBean.S_IsSelfDefine, "1");
		return BceVObjectConfEngine.getBeans(criteria);
	}

	public BcePageRelConfigBean getBuPageRelConfigBeanById(long relateAttrId)
			throws Exception {
		// TODO Auto-generated method stub
		return BcePageRelConfigEngine.getBean(relateAttrId);
	}

	public BcePageBean getBePageBean(long pageId) throws Exception {

		return BcePageEngine.getBean(pageId);

	}

	public BceRulesetRuleBean[] getPageRuleSetRule(long pageRulesetId)
			throws Exception {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		criteria.addEqual(BceRulesetRuleBean.S_RulesetId, pageRulesetId);
		criteria.addAscendingOrderByColumn(BceRulesetRuleBean.S_SeqNo);
		return BceRulesetRuleEngine.getBeans(criteria);
	}

	public BceRuleBean getBeRuleBy(long ruleId) throws Exception {
		// TODO Auto-generated method stub
		return BceRuleEngine.getBean(ruleId);
	}

	public BcePageBean getBePageById(long pageFrameId) throws Exception {
		// TODO Auto-generated method stub
		return BcePageEngine.getBean(pageFrameId);
	};

}
