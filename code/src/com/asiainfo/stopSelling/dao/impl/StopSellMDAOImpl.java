package com.asiainfo.stopSelling.dao.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.stopSelling.bo.BOStopSellMEngine;
import com.asiainfo.stopSelling.dao.interfaces.IStopSellMDAO;
import com.asiainfo.stopSelling.ivalues.IBOStopSellMValue;

public class StopSellMDAOImpl implements IStopSellMDAO {

	@Override
	public int save(IBOStopSellMValue[] stopSellCharge) throws Exception {

		int mainId = 0;
		if (stopSellCharge != null && stopSellCharge.length > 0) {
			for (int i = 0; i < stopSellCharge.length; ++i) {
				if (stopSellCharge[i].isNew()) {
					mainId = BOStopSellMEngine.getNewId().intValue();
					stopSellCharge[i].setMainid(mainId);
					stopSellCharge[i].setState("1");
					stopSellCharge[i].setStsToNew();
				}
			}
			BOStopSellMEngine.save(stopSellCharge);
		}
		return mainId;
	}

	@Override
	public IBOStopSellMValue getStopSellMInfoById(String mainId)
			throws Exception {

		return BOStopSellMEngine.getBean(Integer.parseInt(mainId));
	}

	@Override
	public IBOStopSellMValue[] query(String mainId, String applyName,
			String itemType, String principal, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception {

		return BOStopSellMEngine.getBeans(null, getConditon(mainId, applyName,
				itemType, principal, cityId, state, beginTime, endTime)
				+ " order by prop_time desc", null, startNum, endNum, false);
	}

	@Override
	public int queryCn(String mainId, String applyName, String itemType,
			String principal, String cityId, String state, String beginTime,
			String endTime) throws Exception {
		return BOStopSellMEngine.getBeansCount(getConditon(mainId, applyName,
				itemType, principal, cityId, state, beginTime, endTime), null);
	}

	private String getConditon(String mainId, String applyName,
			String itemType, String principal, String cityId, String state,
			String beginTime, String endTime)
			throws UnsupportedEncodingException {

		String condition = " 1=1 ";
		if (StringUtil.isNotBlank(mainId)) {
			condition += " and " + IBOStopSellMValue.S_Mainid + " = " + mainId;
		}
		if (StringUtil.isNotBlank(applyName)) {
			condition += " and " + IBOStopSellMValue.S_ApplyName + " like '%"
					+ URLDecoder.decode(applyName, "utf-8") + "%'";
		}
		if (StringUtil.isNotBlank(itemType)) {
			condition += " and " + IBOStopSellMValue.S_ItemType + " = '"
					+ itemType + "'";
		}
		if (StringUtil.isNotBlank(principal)) {
			condition += " and " + IBOStopSellMValue.S_Principal + " = "
					+ principal;
		}
		if (StringUtil.isNotBlank(cityId) && !cityId.equals("0")) {
			if (cityId.equals("18")) {
				condition += " and substr(ORG_ID,1,2) in (18,27,28)";
			} else {
				condition += " and substr(ORG_ID,1,2) = " + cityId;
			}
		}
		if (StringUtil.isNotBlank(state) && !state.equals("0")) {
			condition += " and " + IBOStopSellMValue.S_State + " = " + state;
		}
		if (StringUtil.isNotBlank(beginTime)) {
			condition += " and " + IBOStopSellMValue.S_PropTime + " >= '"
					+ beginTime + "'";
		}
		if (StringUtil.isNotBlank(endTime)) {
			condition += " and " + IBOStopSellMValue.S_PropTime + " <= '"
					+ endTime + "'";
		}
		condition += " and (" + IBOStopSellMValue.S_IsDelete + " !=1 or "+ IBOStopSellMValue.S_IsDelete + " is null)";
		return condition;
	}

	@Override
	public void changeStsTo(String mainId, String state) throws Exception,
			RuntimeException {

		IBOStopSellMValue bean = getStopSellMInfoById(mainId);
		bean.setState(state);
		BOStopSellMEngine.save(bean);
	}

	@Override
	public void changeStsToAgreen(String mainId) throws Exception,
			RuntimeException {

		changeStsTo(mainId, "3");
	}

	@Override
	public void changeStsToNo(String mainId, String choice) throws Exception,
			RuntimeException {

		if (choice.equals("end")) {
			changeStsTo(mainId, "4");
		}
	}

	@Override
	public void changeStsTo2(String mainId) throws Exception, RuntimeException {

		changeStsTo(mainId, "2");
	}
}
