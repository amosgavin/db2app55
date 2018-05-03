package com.asiainfo.sale.complain.dao.impl;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.sale.complain.bo.BOOrderComplainsEngine;
import com.asiainfo.sale.complain.dao.interfaces.IOrderComplainDAO;
import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsValue;

public class OrderComplainDAOImpl implements IOrderComplainDAO {

	@Override
	public IBOOrderComplainsValue getOrderComplainsById(String complain_id)
			throws Exception {
		// TODO Auto-generated method stub
		if(complain_id != null && !complain_id.equals("")){
			return BOOrderComplainsEngine.getBean(Integer.parseInt(complain_id));
		}
		return null;
	}

	@Override
	public int saveOrderComplain(IBOOrderComplainsValue OrderComplainsValue)
			throws Exception {
		// TODO Auto-generated method stub
		int complainId = OrderComplainsValue.getComplainsId();
		if(OrderComplainsValue!=null){
			System.out.println(OrderComplainsValue.isDeleted());
			if(OrderComplainsValue.isDeleted()){
				OrderComplainsValue.undelete();
				OrderComplainsValue.setIsDelete("1");
			}
			if(OrderComplainsValue.isNew()){
				complainId = BOOrderComplainsEngine.getNewId().intValue();
				OrderComplainsValue.setComplainsId(complainId);
				OrderComplainsValue.setState("1");
				OrderComplainsValue.setStsToNew();
			}
			BOOrderComplainsEngine.save(OrderComplainsValue);
		}
		return complainId;
	}

	@Override
	public void changeStateTo(String complainId, String state) throws Exception {
		// TODO Auto-generated method stub
		IBOOrderComplainsValue ivalue = getOrderComplainsById(complainId);
		ivalue.setState(state);
		BOOrderComplainsEngine.save(ivalue);
	}

	@Override
	public int queryOrderComplainCount(String complainId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> paras = new HashMap<String, String>();
		if (complainId != null && !complainId.equals("")) {
			paras.put("like", IBOOrderComplainsValue.S_ComplainsId + ";"
					+ StringUtils.trimToEmpty(complainId));
		}
		if (applyName != null && !applyName.equals("")) {
			paras.put("like", IBOOrderComplainsValue.S_ApplyName
					+ ";"
					+ StringUtils.trimToEmpty(URLDecoder.decode(applyName,
							"utf-8")));
		}
		if (state != null && !state.equals("") && !state.equals("0")) {
			paras.put(IBOOrderComplainsValue.S_State, StringUtils
					.trimToEmpty(state));
		}
		if (cityId != null && !cityId.equals("") && !cityId.equals("0")) {
			paras.put("substr(ORG,1,2)", StringUtils.trimToEmpty(cityId));
		}
		paras.put(IBOOrderComplainsValue.S_Principle, StringUtils
				.trimToEmpty(principle));
		paras.put("between", StringUtils.trimToEmpty(beginTime) + ";prop_time;"
				+ StringUtils.trimToEmpty(endTime));
		return BOOrderComplainsEngine.getBeansCount(getCondition(paras), null);
	}

	@Override
	public IBOOrderComplainsValue[] queryOrderComplainValue(String complainId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> paras = new HashMap<String, String>();
		if (complainId != null && !complainId.equals("")) {
			paras.put("like", IBOOrderComplainsValue.S_ComplainsId+ ";"
					+ StringUtils.trimToEmpty(complainId));
		}
		if (applyName != null && !applyName.equals("")) {
			paras.put("like", IBOOrderComplainsValue.S_ApplyName
					+ ";"
					+ StringUtils.trimToEmpty(URLDecoder.decode(applyName,
							"utf-8")));
		}
		if (state != null && !state.equals("") && !state.equals("0")) {
			paras.put(IBOOrderComplainsValue.S_State, StringUtils
					.trimToEmpty(state));
		}
		if (cityId != null && !cityId.equals("") && !cityId.equals("0")) {
			paras.put("substr(ORG,1,2)", StringUtils.trimToEmpty(cityId));
		}
		paras.put(IBOOrderComplainsValue.S_Principle, StringUtils
				.trimToEmpty(principle));
		paras.put("between", StringUtils.trimToEmpty(beginTime) + ";prop_time;"
				+ StringUtils.trimToEmpty(endTime));
		return BOOrderComplainsEngine.getBeans(null, getCondition(paras)
				+ " order by prop_time desc", null, startNum, endNum, false);
	}
	
	String getCondition(Map<String, String> paras) {

		String condition = " 1=1 ";
		//添加一个删除状态条件
		condition+="and is_delete is null";
		if (paras != null) {

			for (Entry<String, String> para : paras.entrySet()) {
				if (para.getKey().trim().equals("like")) {
					condition += " and " + para.getValue().split(";")[0].trim()
							+ " like '%" + para.getValue().split(";")[1].trim()
							+ "%'";
				} else if (para.getKey().trim().equals("between")) {
					String[] cond = para.getValue().split(";");
					if (cond.length >= 2 && !cond[0].trim().equals("")) {
						condition += " and " + cond[1] + " >= '" + cond[0]
								+ "'";
					}
					if (cond.length >= 3 && !cond[2].trim().equals("")) {
						condition += " and " + cond[1] + " <= '" + cond[2]
								+ "'";
					}
				} else if (!para.getKey().trim().equals("")
						&& !para.getValue().trim().equals("")) {
					if (para.getKey().trim().equals("substr(ORG,1,2)")
							&& para.getValue().trim().equals("18")) {
						condition += " and substr(ORG,1,2) in (18,27,28)";
					} else {
						condition += " and " + para.getKey().trim() + " = "
								+ para.getValue().trim();
					}
				}
			}
		}
		return condition;
	}


	@Override
	public void saveOrderComplainBatch(IBOOrderComplainsValue[] busiChangeValues)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
