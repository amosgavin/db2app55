package com.asiainfo.sale.tag.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.asiainfo.sale.tag.bo.BOApplyTagEngine;
import com.asiainfo.sale.tag.dao.interfaces.ITagMainDAO;
import com.asiainfo.sale.tag.ivalues.IBOApplyTagValue;
import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.util.agent.ClientAgent;

public class TagMainDAOImpl implements ITagMainDAO {

	
	public int saveTagMain(IBOApplyTagValue tagMainValues)
			throws Exception {
		int ret = 0;
		if (tagMainValues.isNew()) {
			ret = BOApplyTagEngine.getNewId().intValue();
			tagMainValues.setId(ret);
			tagMainValues.setStsToNew();
		}
		BOApplyTagEngine.save(tagMainValues);
		return ret;
	}

	
	public IBOApplyTagValue getTagMainShowById(String id) throws Exception,
			RuntimeException {
		String condition = " " + IBOPromationTagValue.S_Id + " = :id";
		Map<String, String> parameter = new HashedMap();
		parameter.put("ID", id);
		System.out.println(id + " : " + condition);
		return BOApplyTagEngine.getBean(Integer.parseInt(id));
	}

	
	public IBOApplyTagValue[] getMainTagShowByTaskTag(String taskTag) throws Exception {
		
		List idList = ClientAgent.getAllCurTaskByTag(taskTag, "tagCase", "5");
		int length = idList.size();
		IBOApplyTagValue[] applyTagValues = new IBOApplyTagValue[length];
		for (int i = 0; i < idList.size(); ++i){
			applyTagValues[i] = BOApplyTagEngine.getBean(Integer.parseInt((idList.get(i)).toString()));
		}
		return applyTagValues;
	}
}
