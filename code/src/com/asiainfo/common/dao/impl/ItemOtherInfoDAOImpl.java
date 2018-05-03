package com.asiainfo.common.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.bi.dao.interfaces.ITaskNodeDealTimeDAO;
import com.asiainfo.charge.dao.interfaces.IChargeMainDAO;
import com.asiainfo.common.bo.BOItemOtherInfoBean;
import com.asiainfo.common.bo.BOItemOtherInfoEngine;
import com.asiainfo.common.dao.interfaces.IItemOtherInfoDAO;
import com.asiainfo.common.ivalues.IBOItemOtherInfoValue;
import com.asiainfo.sale.activity.dao.interfaces.ISaleOrderDAO;
import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponDAO;

public class ItemOtherInfoDAOImpl implements IItemOtherInfoDAO {

	@Override
	public IBOItemOtherInfoValue getItemOtherInfoByIdAndTag(String itemId,
			String taskTag) throws Exception {

		String condition = " 1=1 ";
		if (StringUtil.isNotBlank(itemId)) {
			condition += " and " + IBOItemOtherInfoValue.S_ItemId + " = "
					+ itemId;
		} else {
			return null;
		}
		if (StringUtil.isNotBlank(taskTag)) {
			condition += " and " + IBOItemOtherInfoValue.S_TaskTag + " = '"
					+ taskTag + "' ";
		} else {
			return null;
		}
		IBOItemOtherInfoValue[] info = BOItemOtherInfoEngine.getBeans(
				condition, null);
		if (info == null || info.length < 1)
			return null;
		return info[0];
	}

	@Override
	public void saveAdviseFinishDate(String itemId, String taskTag,
			String adviseDate, String delayReason, String approveFlag)
			throws Exception {

		IBOItemOtherInfoValue itemInfo = getItemOtherInfoByIdAndTag(itemId,
				taskTag);
		if (itemInfo == null || itemInfo.getItemId() == 0) {
			itemInfo = new BOItemOtherInfoBean();
			itemInfo.setId(BOItemOtherInfoEngine.getNewId().intValue());
			itemInfo.setItemId(Integer.parseInt(itemId));
			// itemInfo.setApproveFlag("0");
		}
		// System.out.println(adviseDate);
		// itemInfo.setDate1(Timestamp.valueOf(adviseDate + " 00:00:00"));
		if (StringUtil.isNotBlank(taskTag)) {
			itemInfo.setTaskTag(taskTag);
		}
		if (StringUtil.isNotBlank(adviseDate)) {
			itemInfo.setAdviseDealTime(Timestamp.valueOf(adviseDate
					+ " 23:59:59"));
		}
		if (StringUtil.isNotBlank(delayReason)) {
			itemInfo.setDelayReason(delayReason);
		}
		if (StringUtil.isNotBlank(approveFlag)) {
			itemInfo.setApproveFlag(approveFlag);
		}
		BOItemOtherInfoEngine.save(itemInfo);
	}

	private String getAfterDate(String fromTime, int diffDays) throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date olddate = null;
		df.setLenient(false);
		olddate = new java.sql.Date(df.parse(fromTime).getTime());
		Calendar cal = new GregorianCalendar();
		cal.setTime(olddate);
		// Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, diffDays);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		return cal.get(Calendar.YEAR) + "-"
				+ (month < 10 ? "0" + month : month) + "-"
				+ (day < 10 ? "0" + day : day) + " " + fromTime.substring(11);
	}

	private int getDiffDayExceptHol(String itemType, String fromTime,
			String endTime, int demandDays) throws Exception {

		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		int days = 0;
		try {
			connection = ServiceManager.getSession().getConnection();
			String sql = "VALUES ( timestampdiff ( 16, timestamp ('"
					+ endTime
					+ "') - timestamp ('"
					+ fromTime
					+ "')) - (SELECT count (*) FROM hbsale.holiday_t WHERE holiday BETWEEN timestamp ('"
					+ fromTime + "') AND timestamp ('" + endTime + "')))";
			if (itemType.equals("saleCase") || itemType.equals("saleCaseT")
					|| itemType.equals("saleCaseI")
					|| itemType.equals("saleCaseZQ")
					|| StringUtil.isBlank(itemType)) {
				sql = "VALUES ( timestampdiff ( 16, timestamp ('"
						+ endTime
						+ "') - timestamp ('"
						+ fromTime
						+ "')) - (SELECT count (*) FROM hbsale.holiday_t WHERE flag <> 'c' and holiday BETWEEN timestamp ('"
						+ fromTime + "') AND timestamp ('" + endTime + "')))";
			}
			// System.out.println(sql);
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				days = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return demandDays - days;
	}

	@Override
	public String getAdviseDate(String itemType, String fromTime, int diffDays)
			throws Exception {

		if (StringUtil.isBlank(fromTime)) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			fromTime = dateFormat.format(date);
		}
		String midVal = getAfterDate(fromTime, diffDays);
		int lessDays = 7;
		int count = 1;
		do {
			lessDays = getDiffDayExceptHol(itemType, fromTime, midVal, diffDays);
			midVal = getAfterDate(midVal, lessDays);
			++count;
		} while (lessDays != 0 && count < 20);
		return midVal;
	}

	@Override
	public String getLastTaskEndTime(String taskReceiverOpid) throws Exception {

		Timestamp tms = ((ITaskNodeDealTimeDAO) ServiceFactory
				.getService(ITaskNodeDealTimeDAO.class))
				.getLastTaskEndTime(taskReceiverOpid);
		return tms == null ? null : tms.toString();
	}

	@Override
	public int getNeedDays(String itemId, String itemType) throws Exception {

		int levelNum = 0;
		if (itemType.equals("saleCase") || itemType.equals("saleCaseT")
				|| itemType.equals("saleCaseI")
				|| itemType.equals("saleCaseZQ")) {
			levelNum = ((ISaleOrderDAO) ServiceFactory
					.getService(ISaleOrderDAO.class))
					.getSaleDetailCountByOrderId(itemId);
			return Math.max(((int) Math.ceil(levelNum * 0.2)), 2);
		} else if (itemType.equals("chargeCase")
				|| itemType.equals("chargeCaseT")
				|| itemType.equals("newChargeCaseT")
				|| itemType.equals("newChargeCaseP")
				|| itemType.equals("chargeCaseZQ")) {
			levelNum = ((IChargeMainDAO) ServiceFactory
					.getService(IChargeMainDAO.class))
					.getChargeDetailByNewMainidCount(itemId);
			return Math.max(((int) Math.ceil(levelNum * 0.5)), 5);
		} else if (itemType.equals("weaponCase")) {
			levelNum = ((ISaleWeaponDAO) ServiceFactory
					.getService(ISaleWeaponDAO.class)).getCountByMainId(itemId);
			return Math.max(((int) Math.ceil(levelNum * 0.3)), 3);
		}
		return 3;
	}

	@Override
	public boolean moreThanMaxTaskPerMan(String taskReceiverOpid,
			String itemType) throws Exception {

		int currentTaskNums = ((ITaskNodeDealTimeDAO) ServiceFactory
				.getService(ITaskNodeDealTimeDAO.class)).getCurrentTaskNum(
				taskReceiverOpid, itemType);

		if (itemType.equals("saleCase") || itemType.equals("saleCaseT")
				|| itemType.equals("saleCaseI")
				|| itemType.equals("saleCaseZQ")) {
			return currentTaskNums > 3 ? true : false;
		}
		if (itemType.equals("chargeCase") || itemType.equals("chargeCaseT")
				|| itemType.equals("newChargeCaseT")
				|| itemType.equals("newChargeCaseP")
				|| itemType.equals("chargeCaseZQ")) {
			return currentTaskNums > 5 ? true : false;
		}
		return false;
	}
}
