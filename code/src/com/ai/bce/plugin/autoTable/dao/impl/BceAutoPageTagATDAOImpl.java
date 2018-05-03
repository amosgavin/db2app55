package com.ai.bce.plugin.autoTable.dao.impl;

import com.ai.appframe2.util.criteria.Criteria;
import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableAttrBean;
import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableAttrEngine;
import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableBean;
import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableEngine;
import com.ai.bce.plugin.autoTable.dao.interfaces.IBceAutoPageTagATDAO;
import com.ai.bce.util.BceException;

public class BceAutoPageTagATDAOImpl implements IBceAutoPageTagATDAO {

	public BceTagPAutotableBean getATableByObjId(long objId) throws Exception {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		criteria.addEqual(BceTagPAutotableBean.S_ObjectId, objId);
		BceTagPAutotableBean[] tagPAutotableBeans = BceTagPAutotableEngine
				.getBeans(criteria);
		if (tagPAutotableBeans.length != 1) {
			throw new BceException("BES0000423");
		}
		return tagPAutotableBeans[0];
	}

	public BceTagPAutotableAttrBean[] getATableAttrByTbId(long id)
			throws Exception {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		criteria.addEqual(BceTagPAutotableAttrBean.S_AutotableId, id);
		criteria.addAscendingOrderByColumn(BceTagPAutotableAttrBean.S_Rowes);
		criteria.addAscendingOrderByColumn(BceTagPAutotableAttrBean.S_Col);

		return BceTagPAutotableAttrEngine.getBeans(criteria);
	}

}
