package com.asiainfo.sale.access.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.sale.access.dao.interfaces.IBusiChangeAssistDAO;

public class BusiChangeAssistDAOImpl implements IBusiChangeAssistDAO {

	@Override
	public String checkChannelId(String channelIdStr) throws Exception {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		channelIdStr = "'" + channelIdStr.replace(",", "','") + "'";
		String errorChannelIdStr = "";

		try {
			conn = ServiceManager.getSession().getConnection();
			String sql = "SELECT channel_id FROM (VALUES "
					+ channelIdStr
					+ ") AS tmp (channel_id) WHERE channel_id not IN (SELECT channel_id FROM NMK.CHL_INFO "
					// + " WHERE ETL_CYCLE_ID = '" + getLastDay() + "')";
					+ " WHERE ETL_CYCLE_ID = '20140112')";
			System.out.println(sql);
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				if (errorChannelIdStr.equals("")) {
					errorChannelIdStr += rs.getString("channel_id").trim();
				} else {
					errorChannelIdStr += ","
							+ rs.getString("channel_id").trim();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return errorChannelIdStr;
	}

	@Override
	public String getSaleHandles(String feeId) throws Exception {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		String sumAndMonCn = "";

		try {
			conn = ServiceManager.getSession().getConnection();
			String sql = "SELECT t1.cn_all, t2.CN_MON FROM (SELECT sum (partake_cn_mon) cn_all FROM hbsale.sale_act_partake WHERE fee_id = '"
					+ feeId
					+ "') t1 join (SELECT partake_cn_mon cn_mon FROM hbsale.sale_act_partake  WHERE fee_id = '"
					+ feeId
					+ "' AND etl_cycle_id = '"
					+ getLastMonth()
					+ "') t2 ON 1 = 1";
			System.out.println(sql);
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				sumAndMonCn = rs.getString("cn_all").trim() + ";"
						+ rs.getString("cn_mon").trim();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sumAndMonCn;
	}

	private static String getLastDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String lastDay = new SimpleDateFormat("yyyyMMdd").format(calendar
				.getTime());
		return lastDay;
	}

	private static String getLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		/*
		 * int year = calendar.get(Calendar.YEAR); int month =
		 * calendar.get(Calendar.MONTH) + 1; return "" + year + (month < 10 ?
		 * "0" + month : month);
		 */
		String lastMonth = new SimpleDateFormat("yyyyMM").format(calendar
				.getTime());
		return lastMonth;
	}
}
