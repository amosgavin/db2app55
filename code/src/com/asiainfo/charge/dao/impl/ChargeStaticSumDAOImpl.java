package com.asiainfo.charge.dao.impl;

import com.asiainfo.charge.bo.BOChargeInfoEngine;
import com.asiainfo.charge.bo.BOChargeStaticSumBean;
import com.asiainfo.charge.bo.BOChargeStaticSumEngine;
import com.asiainfo.charge.bo.BOChargeStaticSumShowEngine;
import com.asiainfo.charge.dao.interfaces.IChargeStaticSumDAO;
import com.asiainfo.charge.ivalues.IBOChargeStaticSumShowValue;

public class ChargeStaticSumDAOImpl implements IChargeStaticSumDAO {

	@Override
	public void save(String sums) throws Exception {

		String[] records = sums.split(";");
		String grandId = records[0].split(",")[0];
		String items[] = new String[] { "固定费(元)", "户均本地时长(分钟)", "户均本地收入(元)",
				"户均长途时长(分钟)", "户均长途收入(元)", "户均漫游时长(分钟)", "户均漫游收入(元)",
				"户均流量(M)", "户均流量收入(元)", "户均短信条数(条)", "户均短信收入(元)", "其他户均收入(元)" };

		BOChargeStaticSumBean chargeSum[] = new BOChargeStaticSumBean[12];
		BOChargeStaticSumBean isNull[] = BOChargeStaticSumEngine.getBeans(
				" 1=1 and grand_id = " + grandId + " order by order_id ", null);
		if (null != isNull && isNull.length > 1) {

			chargeSum = isNull;
		}

		for (int i = 0; i < 12; ++i) {

			double col1 = Double.parseDouble(records[i + 1].split(",")[0]);
			double col2 = Double.parseDouble(records[i + 1].split(",")[1]);

			if (chargeSum[i] == null)
				chargeSum[i] = new BOChargeStaticSumBean();

			chargeSum[i].setSwitchUser(Integer
					.parseInt(records[0].split(",")[1]));
			chargeSum[i].setItem(items[i]);
			chargeSum[i].setGrandId(grandId);
			chargeSum[i].setBeforeChange(col1);
			chargeSum[i].setAfterChange(col2);

			if (null == isNull || isNull.length < 1) {

				chargeSum[i].setOrderId(BOChargeStaticSumEngine.getNewId()
						.intValue());
				chargeSum[i].setStsToNew();
			}

		}
		BOChargeStaticSumEngine.saveBatch(chargeSum);
	}
	//根据档次ID删除
	public void delStaticSumByGrandId(String grandId) throws Exception {
		BOChargeStaticSumBean[] chargeStaticSumShowValue=this.getStaticSumValueByGrandId(grandId);
		if(chargeStaticSumShowValue.length>0){
			for (int i = 0; i < chargeStaticSumShowValue.length; i++) {
				chargeStaticSumShowValue[i].delete();
			}
			BOChargeStaticSumEngine.save(chargeStaticSumShowValue);
		}
	}
	
	@Override
	public IBOChargeStaticSumShowValue[] getStaticSumByGrandId(String grandId)
			throws Exception {

		if (BOChargeStaticSumEngine.getBeansCount(" 1=1 and grand_id="
				+ grandId, null) == 0) {
			return null;
		}
		String condition = "SELECT ITEM, BEFORE_CHANGE, "
				+ " AFTER_CHANGE, SWITCH_USER, FLUCTUATE*100 FLUCTUATE, USER_CHANGE, "
				+ " SUM_CHANGE FROM (SELECT ORDER_ID, ITEM, "
				+ " BEFORE_CHANGE, AFTER_CHANGE, SWITCH_USER, "
				+ " CASE WHEN BEFORE_CHANGE=0 THEN 0 ELSE AFTER_CHANGE / BEFORE_CHANGE - 1 END FLUCTUATE, "
				+ " AFTER_CHANGE - BEFORE_CHANGE USER_CHANGE, "
				+ " (AFTER_CHANGE - BEFORE_CHANGE) * SWITCH_USER SUM_CHANGE "
				+ " FROM HBSALE.CHARGE_STATIC_SUM_T T WHERE GRAND_ID = "
				+ grandId
				+ " UNION ALL SELECT SUM (ORDER_ID) ORDER_ID, "
				+ " 'ARPU' ITEM, SUM (BEFORE_CHANGE) BEFORE_CHANGE, "
				+ " SUM (AFTER_CHANGE) AFTER_CHANGE, "
				+ " SUM (SWITCH_USER) SWITCH_USER,"
				+ " SUM (FLUCTUATE) FLUCTUATE, "
				+ " SUM (USER_CHANGE) USER_CHANGE, "
				+ " SUM (SUM_CHANGE) SUM_CHANGE FROM (SELECT ORDER_ID, "
				+ " ITEM, BEFORE_CHANGE, AFTER_CHANGE, SWITCH_USER, "
				+ " CASE WHEN BEFORE_CHANGE=0 THEN 0 ELSE AFTER_CHANGE / BEFORE_CHANGE - 1 END FLUCTUATE, "
				+ " AFTER_CHANGE - BEFORE_CHANGE USER_CHANGE, "
				+ " (AFTER_CHANGE - BEFORE_CHANGE) * SWITCH_USER "
				+ " SUM_CHANGE FROM HBSALE.CHARGE_STATIC_SUM_T S "
				+ " WHERE GRAND_ID = "
				+ grandId
				+ " AND ITEM IN ('固定费(元)','户均本地收入(元)','户均长途收入(元)','户均漫游收入(元)','户均流量收入(元)','户均短信收入(元)','其他户均收入(元)') )) ORDER BY ORDER_ID";

		return BOChargeStaticSumShowEngine.getBeansFromSql(condition, null);
	}

	@Override
	public int getStaticSumCount(String grandId) throws Exception {

		String condition = " 1=1 and grand_id=" + grandId;
		return BOChargeStaticSumEngine.getBeansCount(condition, null) != 0 ? 13
				: 0;
	}

	@Override
	public String getSaveRecords(String grandId) throws Exception {

		BOChargeStaticSumBean chargeSum[] = BOChargeStaticSumEngine.getBeans(
				" 1=1 and grand_id = " + grandId + " order by order_id ", null);

		if (chargeSum == null || chargeSum.length < 1)
			return "";

		String retStr = "" + chargeSum[1].getSwitchUser();

		for (int i = 0; i < 12; ++i) {
			retStr += ";" + chargeSum[i].getBeforeChange() + ","
					+ chargeSum[i].getAfterChange();
		}
		return retStr;
	}

	@Override
	public BOChargeStaticSumBean[] getStaticSumValueByGrandId(String grandId)
			throws Exception {

		return BOChargeStaticSumEngine.getBeans(" 1=1 and grand_id = "
				+ grandId + " order by order_id ", null);
	}
}
