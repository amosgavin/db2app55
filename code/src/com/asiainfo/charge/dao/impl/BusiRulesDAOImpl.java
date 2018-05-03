package com.asiainfo.charge.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.asiainfo.charge.bo.BOBusiRulesBean;
import com.asiainfo.charge.bo.BOBusiRulesEngine;
import com.asiainfo.charge.dao.interfaces.IBusiRulesDAO;
import com.asiainfo.charge.ivalues.IBOBusiRulesValue;

public class BusiRulesDAOImpl implements IBusiRulesDAO {

	public void delBusiRules(String id)	throws Exception, RuntimeException{
		String condition =  IBOBusiRulesValue.S_Id + "= :ruleid ";
		Map parameter = new HashMap();
		parameter.put("ruleid", id);
		IBOBusiRulesValue[] rules = BOBusiRulesEngine.getBeans(condition, parameter);
		if(rules.length>0){
			for(int i=0;i<rules.length;i++){
				rules[i].delete();
			BOBusiRulesEngine.save(rules[i]);
			}
		}
	}
	/**
	 * 保存档次信息-业务规则信息
	 * 
	 * @param busiRulesValue
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveBusiRules(IBOBusiRulesValue busiRulesValue)
			throws Exception, RuntimeException {

		if (busiRulesValue != null) {

			// 新增，需要取ID
			if (busiRulesValue.isNew()) {
				//busiRulesValue.setId(BOBusiRulesEngine.getNewId().toString());
				//busiRulesValue.setStsToNew();
				//System.out.println(busiRulesValue.getId());
			}
			BOBusiRulesEngine.save(busiRulesValue);
			return busiRulesValue.getId();
		}
		return null;
	}

	/**
	 * 根据ID查询档次信息-业务规则信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IBOBusiRulesValue queryBusiRules(String id) throws Exception {
		String condition =  IBOBusiRulesValue.S_Id + "= :ruleid ";
		Map parameter = new HashMap();
		parameter.put("ruleid", id);
		IBOBusiRulesValue[] rules = BOBusiRulesEngine.getBeans(condition, parameter);
		if (rules.length == 1){
			return rules[0];
		}
		return new BOBusiRulesBean();
	}
}
