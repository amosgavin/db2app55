package com.asiainfo.bi.dao.impl;

import java.net.URLDecoder;

import com.asiainfo.bi.bo.BOBusiSupportEngine;
import com.asiainfo.bi.dao.interfaces.IBusiSupportDAO;
import com.asiainfo.bi.ivalues.IBOBusiSupportValue;
import com.asiainfo.sale.util.StringUtil;

public class BusiSupportDAOImpl implements IBusiSupportDAO {

	@Override
	public IBOBusiSupportValue[] getItemInfoINBusiSu(String itemId,
			String itemType, String state, String dispatchTimeF,
			String dispatchTimeTo, String dealPerson, int startNum, int endNum)
			throws Exception {

		String condition = " 1 = 1 and dispatch_date is not null ";
		if (!StringUtil.isBlank(itemId)) {
			condition += " and " + IBOBusiSupportValue.S_Wid + " = " + itemId;
		}
		if (!StringUtil.isBlank(itemType) && !itemType.equals("all")) {
			condition += " and " + IBOBusiSupportValue.S_Itemtype + " = '"
					+ itemType + "'";
		}
		if (!StringUtil.isBlank(state) && !state.equals("-1")) {
			condition += " and " + IBOBusiSupportValue.S_State + " = " + state;
		}
		if (!StringUtil.isBlank(dispatchTimeF)) {
			condition += " and " + IBOBusiSupportValue.S_DispatchDate + " >= '"
					+ dispatchTimeF + "'";
		}
		if (!StringUtil.isBlank(dispatchTimeTo)) {
			condition += " and " + IBOBusiSupportValue.S_DispatchDate + " < '"
					+ dispatchTimeTo + "'";
		}
		if (!StringUtil.isBlank(dealPerson)) {
			condition += " and " + IBOBusiSupportValue.S_StaffName + " like '%"
					+ URLDecoder.decode(dealPerson, "utf-8") + "%'";
		}
		condition += " order by dispatch_date desc ";
		return BOBusiSupportEngine.getBeans(null, condition, null, startNum,
				endNum, false);
	}

	@Override
	public int getItemInfoINBusiSuCount(String itemId, String itemType,
			String state, String dispatchTimeF, String dispatchTimeTo,
			String dealPerson) throws Exception {
		String condition = " 1 = 1 and dispatch_date is not null ";
		if (!StringUtil.isBlank(itemId)) {
			condition += " and " + IBOBusiSupportValue.S_Wid + " = " + itemId;
		}
		if (!StringUtil.isBlank(itemType) && !itemType.equals("all")) {
			condition += " and " + IBOBusiSupportValue.S_Itemtype + " = '"
					+ itemType + "'";
		}
		if (!StringUtil.isBlank(state) && !state.equals("-1")) {
			condition += " and " + IBOBusiSupportValue.S_State + " = " + state;
		}
		if (!StringUtil.isBlank(dispatchTimeF)) {
			condition += " and " + IBOBusiSupportValue.S_DispatchDate + " >= '"
					+ dispatchTimeF + "'";
		}
		if (!StringUtil.isBlank(dispatchTimeTo)) {
			condition += " and " + IBOBusiSupportValue.S_DispatchDate + " < '"
					+ dispatchTimeTo + "'";
		}
		if (!StringUtil.isBlank(dealPerson)) {
			condition += " and " + IBOBusiSupportValue.S_StaffName + " like '%"
					+ URLDecoder.decode(dealPerson, "utf-8") + "%'";
		}
		return BOBusiSupportEngine.getBeansCount(condition, null);
	}

}
