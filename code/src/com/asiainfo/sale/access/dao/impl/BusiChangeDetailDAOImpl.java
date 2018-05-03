package com.asiainfo.sale.access.dao.impl;

import java.net.URLDecoder;

import com.asiainfo.charge.bo.BOChargeApplyMainEngine;
import com.asiainfo.sale.access.bo.BOBusiChangeDetailEngine;
import com.asiainfo.sale.access.bo.BOSelectSaleOrChargeEngine;
import com.asiainfo.sale.access.dao.interfaces.IBusiChangeDetailDAO;
import com.asiainfo.sale.access.ivalues.IBOBusiChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOSelectSaleOrChargeValue;
import com.asiainfo.sale.activity.bo.BOSaleMainEngine;

public class BusiChangeDetailDAOImpl implements IBusiChangeDetailDAO {

	@Override
	public IBOBusiChangeDetailValue getBusiChargeDetailByID(String busiDId)
			throws Exception {

		return BOBusiChangeDetailEngine.getBean(Integer.parseInt(busiDId));
	}

	@Override
	public IBOBusiChangeDetailValue[] getBusiChargeDetailByPID(String busiId,
			String busiType, int startNum, int endNum) throws Exception {

		if (busiId != null && !busiId.equals("")) {
			String condition = IBOBusiChangeDetailValue.S_BusiId + " = "
					+ busiId;
			if (busiType != null && !busiType.equals("")) {
				condition += " and " + IBOBusiChangeDetailValue.S_ChangeObject
						+ " = '" + busiType + "'";
			}
			return BOBusiChangeDetailEngine.getBeans(null, condition, null,
					startNum, endNum, false);
		}
		return null;
	}

	@Override
	public int getBusiChargeDetailCountByPID(String busiId, String busiType)
			throws Exception {

		if (busiId != null && !busiId.equals("")) {
			String condition = IBOBusiChangeDetailValue.S_BusiId + " = "
					+ busiId;
			if (busiType != null && !busiType.equals("")) {
				condition += " and " + IBOBusiChangeDetailValue.S_ChangeObject
						+ " = '" + busiType + "'";
			}
			return BOBusiChangeDetailEngine.getBeansCount(condition, null);
		}
		return 0;
	}

	@Override
	public String saveBusiChangeDetail(
			IBOBusiChangeDetailValue busiChangeDetailValue) throws Exception {
		String relId="";
		if (busiChangeDetailValue != null) {
			
			if (busiChangeDetailValue.isNew()) {
				busiChangeDetailValue.setBusidId(BOBusiChangeDetailEngine
						.getNewId().intValue());
				busiChangeDetailValue.setStsToNew();
			}
			BOBusiChangeDetailEngine.save(busiChangeDetailValue);
			relId=String.valueOf(busiChangeDetailValue.getBusidId());
		}
		return relId;
	}

	@Override
	public void saveBusiChangeDetailBatch(
			IBOBusiChangeDetailValue[] busiChangeDetailValues) throws Exception {

		if (busiChangeDetailValues != null && busiChangeDetailValues.length > 0) {
			for (int i = 0; i < busiChangeDetailValues.length; ++i) {
				if (busiChangeDetailValues[i].isNew()) {
					busiChangeDetailValues[i]
							.setBusidId(BOBusiChangeDetailEngine.getNewId()
									.intValue());
					busiChangeDetailValues[i].setStsToNew();
				}
			}
			BOBusiChangeDetailEngine.saveBatch(busiChangeDetailValues);
		}
	}

	@Override
	public IBOSelectSaleOrChargeValue[] getExistInfo(String batchType,
			String orgId, String operName, String batchName, String levelName,
			int startNum, int endNum) throws Exception {

		String condition = " 1=1 ";
		if (batchType != null && !batchType.equals("")) {
			condition += " and " + IBOSelectSaleOrChargeValue.S_BatchType
					+ " = '" + batchType + "'";
		}
		if (orgId != null && !orgId.equals("") && !orgId.equals("0")) {
			condition += " and " + IBOSelectSaleOrChargeValue.S_OrgId + " = "
					+ orgId;
		}
		if (operName != null && !operName.equals("")) {
			condition += " and " + IBOSelectSaleOrChargeValue.S_StaffName
					+ " like '%" + URLDecoder.decode(operName, "utf-8") + "%'";
		}
		if (batchName != null && !batchName.equals("")) {
			condition += " and " + IBOSelectSaleOrChargeValue.S_BatchName
					+ " like '%" + URLDecoder.decode(batchName, "utf-8") + "%'";
		}
		if (levelName != null && !levelName.equals("")) {
			condition += " and " + IBOSelectSaleOrChargeValue.S_LevelName
					+ " like '%" + URLDecoder.decode(levelName, "utf-8") + "%'";
		}
		condition += " order by begin_time desc ";
		return BOSelectSaleOrChargeEngine.getBeans(null, condition, null,
				startNum, endNum, false);
	}

	@Override
	public int getExistInfoCount(String batchType, String orgId,
			String operName, String batchName, String levelName)
			throws Exception {

		String condition = " 1=1 ";
		if (batchType != null && !batchType.equals("")) {
			condition += " and " + IBOSelectSaleOrChargeValue.S_BatchType
					+ " = '" + batchType + "'";
		}
		if (orgId != null && !orgId.equals("") && !orgId.equals("0")) {
			condition += " and " + IBOSelectSaleOrChargeValue.S_OrgId + " = "
					+ orgId;
		}
		if (operName != null && !operName.equals("")) {
			condition += " and " + IBOSelectSaleOrChargeValue.S_StaffName
					+ " like '%" + URLDecoder.decode(operName, "utf-8") + "%'";
		}
		if (batchName != null && !batchName.equals("")) {
			condition += " and " + IBOSelectSaleOrChargeValue.S_BatchName
					+ " like '%" + URLDecoder.decode(batchName, "utf-8") + "%'";
		}
		if (levelName != null && !levelName.equals("")) {
			condition += " and " + IBOSelectSaleOrChargeValue.S_LevelName
					+ " like '%" + URLDecoder.decode(levelName, "utf-8") + "%'";
		}
		return BOSelectSaleOrChargeEngine.getBeansCount(condition, null);
	}

	@Override
	public boolean isExistBatchId(String batchId, String batchType)
			throws Exception {

		if (batchType.equals("sale")) {
			return (BOSaleMainEngine.getBeansCount(" id = " + batchId, null) > 0);
		} else if (batchType.equals("charge")) {
			return (BOChargeApplyMainEngine.getBeansCount(" apply_id = "
					+ batchId, null) > 0);
		}
		return false;
	}

}
