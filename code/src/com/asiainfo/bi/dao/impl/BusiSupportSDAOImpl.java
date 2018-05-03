package com.asiainfo.bi.dao.impl;

import com.asiainfo.bi.bo.BOBusiSupportSEngine;
import com.asiainfo.bi.dao.interfaces.IBusiSupportSDAO;
import com.asiainfo.bi.ivalues.IBOBusiSupportSValue;
import com.asiainfo.sale.util.StringUtil;

public class BusiSupportSDAOImpl implements IBusiSupportSDAO {

	@Override
	public IBOBusiSupportSValue[] getStatisticsINBusiSu(String dispatchTimeF,
			String dispatchTimeTo) throws Exception {

		String sql = " SELECT staff_name, "
				+ " count (staff_name) total, "
				+ " sum (CASE WHEN STATE = '1' THEN 1 ELSE 0 END) AS totalY, "
				+ " sum (CASE WHEN state = '1' AND itemtype = 'sale' THEN 1 ELSE 0 END) "
				+ " AS saleY, "
				+ " sum (CASE WHEN STATE = '1' AND itemtype = 'charge' THEN 1 ELSE 0 END) "
				+ " AS chargeY, "
				+ " sum (CASE WHEN STATE = '1' AND itemtype = 'busi' THEN 1 ELSE 0 END) "
				+ " AS busiY, "
				+ " sum (CASE WHEN STATE = '1' AND itemtype = 'weapon' THEN 1 ELSE 0 END) "
				+ " AS weaponY, "
				+ " sum (CASE WHEN STATE = '0' THEN 1 ELSE 0 END) AS totalN, "
				+ " sum (CASE WHEN STATE = '0' AND itemtype = 'sale' THEN 1 ELSE 0 END) "
				+ " AS saleN, "
				+ " sum (CASE WHEN STATE = '0' AND itemtype = 'charge' THEN 1 ELSE 0 END) "
				+ " AS chargeN, "
				+ " sum (CASE WHEN STATE = '0' AND itemtype = 'busi' THEN 1 ELSE 0 END) "
				+ " AS busiN, "
				+ " sum (CASE WHEN STATE = '0' AND itemtype = 'weapon' THEN 1 ELSE 0 END) "
				+ " AS weaponN, "
				+ " sum (CASE WHEN diffday >= 1 and diffday < 15 THEN 1 ELSE 0 END) "
				+ " AS diffls15, "
				+ " sum (CASE WHEN diffday >= 15 AND diffday < 30 THEN 1 ELSE 0 END) "
				+ " AS diff15to30, "
				+ " sum (CASE WHEN diffday >= 30 THEN 1 ELSE 0 END) AS diffgt30 "
				+ " FROM hbsale.view_item_busisuppor "
				+ " WHERE dispatch_date IS NOT NULL ";
		if (!StringUtil.isBlank(dispatchTimeF)) {
			sql += " AND dispatch_date >= '" + dispatchTimeF + "'";
		}
		if (!StringUtil.isBlank(dispatchTimeTo)) {
			sql += " AND dispatch_date < '" + dispatchTimeTo + "'";
		}
		sql += " GROUP BY staff_name ";
		return BOBusiSupportSEngine.getBeansFromSql(sql, null);
	}
}
