package com.asiainfo.sale.activity.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.sale.activity.bo.BOSaleDetailEngine;
import com.asiainfo.sale.activity.bo.BOSaleDetailGroupBySaleTypeEngine;
import com.asiainfo.sale.activity.bo.BOSaleMainEngine;
import com.asiainfo.sale.activity.bo.BOSaleOrderEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleDetailDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleMainDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailGroupBySaleTypeValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleOrderValue;
import com.asiainfo.sale.common.dao.interfaces.ISaleStaticDataDAO;
import com.asiainfo.sale.common.ivalues.IBOSaleStaticDataValue;
import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponDAO;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;

public class SaleDetailDAOImpl implements ISaleDetailDAO {

	public void delSaleDetail(IBOSaleDetailValue[] saleDetailValues)
			throws Exception {
		for (int i = 0; i < saleDetailValues.length; i++) {
			saleDetailValues[i].delete();
		}
		BOSaleDetailEngine.save(saleDetailValues);
	}

	public IBOSaleDetailValue getSaleDetailById(String id) throws Exception {
		return BOSaleDetailEngine.getBean(id);
	}

	public int getCount(String mainId) throws Exception {
		Object[] objects = getConditionMainId(mainId);
		return BOSaleDetailEngine.getBeansCount((String) objects[0],
				(Map) objects[1]);
	}

	public IBOSaleDetailValue[] getSaleDetailByMainId(String mainId,
			int startNum, int endNum) throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		Object[] objects = getConditionMainId(mainId);
		return BOSaleDetailEngine.getBeans(cols, (String) objects[0]
				+ " order by create_time", (Map) objects[1], startNum, endNum,
				isShowFK);
	}

	public String saveSaleDetail(IBOSaleDetailValue[] saleDetailValues)
			throws Exception {
		String saleDetailId = "";
		for (int i = 0; i < saleDetailValues.length; i++) {
			// 新增，需要取ID
			if (saleDetailValues[i].isNew()) {
				saleDetailId = BOSaleDetailEngine.getNewId().toString();
				if (saleDetailValues[i].getId() == null
						|| saleDetailValues[i].getId().equals("")) {

					saleDetailValues[i].setId(saleDetailId);
				} else {
					saleDetailId = saleDetailValues[i].getId();
				}
				saleDetailValues[i].setStsToNew();
				saleDetailValues[i].setCreateTime(BOSaleDetailEngine
						.getSysDate());
			} else {
				saleDetailValues[i].setModifyTime(BOSaleDetailEngine
						.getSysDate());
			}
			IBOSaleMainValue saleMainValue = BOSaleMainEngine
					.getBean(saleDetailValues[i].getSaleId());
			IBOSaleOrderValue orderValue = BOSaleOrderEngine.getBean(Integer
					.parseInt(saleMainValue.getOrderId()));
			if (!saleDetailValues[i].isDeleted()
					&& StringUtil.isNotBlank(saleDetailValues[i].getMarket())
					&& (StringUtil.isBlank(saleDetailValues[i]
							.getSaleActiveCode()) || orderValue.getState()
							.equals("1"))) {

				saleDetailValues[i]
						.setSaleActiveCode(getSaleDetailCode(saleDetailValues[i]));
				BOSaleDetailEngine.save(saleDetailValues[i]);
				updateActCode(saleDetailValues[i].getSaleId());
			} else {
				BOSaleDetailEngine.save(saleDetailValues[i]);
			}
		}
		return saleDetailId;
	}

	public String getNewSaleDetailId() throws Exception {
		return BOSaleDetailEngine.getNewId().toString();
	}

	public String getSaleDetailCode(IBOSaleDetailValue saleDetailValue) {

		String marketCode = "00";
		String actType = "00";
		String saleMainCode = "";
		String seriNo = "0001";

		try {
			IBOSaleMainValue saleMainValue = ((ISaleMainDAO) ServiceFactory
					.getService(ISaleMainDAO.class))
					.getSaleMainById(saleDetailValue.getSaleId());

			actType = saleDetailValue.getSaleFlag().trim();
			marketCode = saleDetailValue.getMarket().trim();
			String saleDetailCode = saleDetailValue.getSaleActiveCode();
			saleMainCode = saleMainValue.getSaleMainCode();

			if (saleMainCode.equals("0000")) {
				return getOldSaleDetailCode(saleDetailValue);
			}

			Connection conn = ServiceManager.getSession().getConnection();
			/*
			 * String sql = " SELECT MAX (SERIALNO) serialno" +
			 * " FROM (SELECT INT(SUBSTR(SALE_ACTIVE_CODE,21,4)) SERIALNO FROM SALE_DETAIL_T WHERE SUBSTR(SALE_ACTIVE_CODE,1,3)='LEV' "
			 * + " AND SUBSTR(SALE_ACTIVE_CODE,11,10)='" +
			 * saleMainCode.substring(10) +
			 * "' UNION (SELECT INT(SUBSTR(LEVEL_CODE,21,4)) SERIALNO FROM SALE_DETAIL_T WHERE SUBSTR(LEVEL_CODE,1,3)='LEV' AND "
			 * + " SUBSTR(LEVEL_CODE,11,10)='" + saleMainCode.substring(10) +
			 * "'))";
			 */
			String sql = "select max(int(substr(sale_active_code,21,4))) serialno from sale_detail_t where substr(sale_active_code,1,3)='LEV' "
					+ " AND SUBSTR(SALE_ACTIVE_CODE,11,10)='"
					+ saleMainCode.substring(10) + "'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				int serialNoTmp = rs.getInt("serialno");
				if (0 != serialNoTmp) {
					if (saleDetailCode != null && !saleDetailCode.equals("")) {
						seriNo = saleDetailCode.substring(20);
					} else {
						seriNo = ((serialNoTmp + 10001) + "").substring(1);
					}
				}
			} else {
				rs.close();
				st.close();
				conn.close();
				return saleDetailValue.getSaleActiveCode();
			}
			rs.close();
			st.close();
			conn.close();

			// 目标市场
			if ("sy".equals(marketCode)) {
				marketCode = "00";
			} else if ("1".equals(marketCode)) {
				marketCode = "01";
			} else if ("2".equals(marketCode)) {
				marketCode = "02";
			} else if ("5".equals(marketCode)) {
				marketCode = "03";
			} else if ("4".equals(marketCode)) {
				marketCode = "04";
			} else if ("7".equals(marketCode)) {
				marketCode = "05";
			} else if ("3".equals(marketCode)) {
				marketCode = "06";
			} else if ("6".equals(marketCode)) {
				marketCode = "07";
			} else if ("8".equals(marketCode)) {
				marketCode = "99";
			} else {
				marketCode = "99";
			}
			/*
			 * 活动类型 预存类（01）— 积分类（02）— 终端类（03）— 自有产品类（04）— 赠送话费类（05）— 新入网类（06）—
			 * 专题类（07）— 新业务/集团信息化业务营销类（08）— 刺激业务使用量类（09）— 网龄回馈类（10）—
			 * 电子渠道体验类（11）— 特殊客户关系维护类（12）— 抽奖类（13）— 其他（14）
			 */
			switch (Integer.parseInt(actType.substring(0, 2))) {

			case 11:
				actType = "05";
				break;
			case 12:
				actType = "01";
				break;
			case 13:
				actType = "01";
				break;
			case 14:
				actType = "01";
				break;
			case 15:
				actType = "01";
				break;
			case 17:
				actType = "01";
				break;
			case 21:
				actType = "03";
				break;
			case 22:
				actType = "03";
				break;
			case 23:
				actType = "03";
				break;
			case 31:
				actType = "04";
				break;
			default:
				actType = "14";
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (marketCode.length() != 2) {
			marketCode = "99";
		}
		if (actType.length() != 2) {
			actType = "14";
		}
		return "LEV" + saleMainCode.substring(3, 6) + marketCode + actType
				+ saleMainCode.substring(10) + seriNo;
	}

	public String getOldSaleDetailCode(IBOSaleDetailValue saleDetailValue) {
		String codeString = "0000";
		String cityCode = "00";
		String marketCode = "0";
		String saleFlagCode = "00";
		String minMonth = "00";
		String maxMonth = "00";
		String baseMonth = "00";
		String beginTime = "000000";
		String endTime = "000000";
		String serialNo = "000";
		try {
			IBOSaleMainValue saleMainValue = ((ISaleMainDAO) ServiceFactory
					.getService(ISaleMainDAO.class))
					.getSaleMainById(saleDetailValue.getSaleId());
			IBOSaleWeaponValue weaponValue = ((ISaleWeaponDAO) ServiceFactory
					.getService(ISaleWeaponDAO.class)).getSaleWeaponByID(
					saleDetailValue.getWeaponId(), -1, -1)[0];

			String orgIdString = saleMainValue.getPromoteDepart();

			IBOSaleStaticDataValue cityCodeObj = ((ISaleStaticDataDAO) ServiceFactory
					.getService(ISaleStaticDataDAO.class)).getSaleStaticData(
					"dsbm", orgIdString.substring(0, 2));
			cityCode = cityCodeObj.getCodeName();
			marketCode = saleDetailValue.getMarket();
			saleFlagCode = saleDetailValue.getSaleFlag();
			minMonth = String.valueOf(weaponValue.getMinnetAge());
			if (minMonth.length() < 1) {
				minMonth = "00";
			} else if (minMonth.length() == 1) {
				minMonth = "0" + minMonth;
			} else if (minMonth.length() > 2) {
				minMonth = "99";
			}
			maxMonth = String.valueOf(weaponValue.getMaxnetAge());
			if (maxMonth.length() < 1) {
				maxMonth = "00";
			} else if (maxMonth.length() == 1) {
				maxMonth = "0" + maxMonth;
			} else if (maxMonth.length() > 2) {
				maxMonth = "99";
			}
			baseMonth = String.valueOf(weaponValue.getBaseMonth());
			if (baseMonth.length() < 1) {
				baseMonth = "00";
			} else if (baseMonth.length() == 1) {
				baseMonth = "0" + baseMonth;
			} else if (baseMonth.length() > 2) {
				baseMonth = "99";
			}
			Timestamp beginTimeTmp = saleMainValue.getBeginTime();
			Timestamp endTimeTmp = saleMainValue.getEndTime();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yymmdd");
			beginTime = dateFormat.format(beginTimeTmp);
			endTime = dateFormat.format(endTimeTmp);
			serialNo = BOSaleDetailEngine.getNewId().toString();
			codeString = cityCode + marketCode + saleFlagCode + minMonth
					+ maxMonth + baseMonth + beginTime + endTime + serialNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codeString;
	}

	private void updateActCode(String mainId) throws Exception {

		IBOSaleMainValue saleMain = BOSaleMainEngine.getBean(mainId);
		if (saleMain.getSaleMainCode().equals("0000")) {
			return;
		} else {

			String actType = "";
			String oldActCode = saleMain.getSaleMainCode();
			try {
				Connection conn = ServiceManager.getSession().getConnection();
				String sql = "select min(substr(sale_active_code,9,2)) actType from SALE_DETAIL_T where substr(sale_active_code,1,3)='LEV' AND sale_id = "
						+ "'" + mainId + "'";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if (rs.next()) {
					actType = rs.getString("actType");
					if (null == actType || "".equals(actType)) {
						actType = "99";
					}
				}
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			saleMain.setSaleMainCode(oldActCode.substring(0, 8) + actType
					+ oldActCode.substring(10));
			BOSaleMainEngine.save(saleMain);
		}
	}

	private Object[] getConditionMainId(String mainId) {
		String condition = " " + IBOSaleDetailValue.S_SaleId + " = :mainId";
		Map parameter = new HashedMap();
		parameter.put("mainId", mainId);
		return new Object[] { condition.toString(), parameter };
	}

	public int getCountGroupBySaleType(String mainId) throws Exception {
		Object[] objects = getConditionMainId(mainId);
		return BOSaleDetailGroupBySaleTypeEngine.getBeansCount(
				(String) objects[0], (Map) objects[1]);
	}

	public IBOSaleDetailGroupBySaleTypeValue[] getSaleDetailGroupBySaleTypeValues(
			String mainId, int startNum, int endNum) throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		Object[] objects = getConditionMainId(mainId);
		return BOSaleDetailGroupBySaleTypeEngine.getBeans(cols,
				(String) objects[0], (Map) objects[1], startNum, endNum,
				isShowFK);
	}

	private Object[] getConditionSaleFlag(String mainId, String saleFlag) {
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		Map parameter = new HashedMap();
		if (StringUtils.isNotBlank(mainId)) {
			condition.append(" AND " + IBOSaleDetailValue.S_SaleId
					+ " = :mainId");
			parameter.put("mainId", mainId);
		}
		if (StringUtils.isNotBlank(saleFlag)) {
			condition.append(" AND " + IBOSaleDetailValue.S_SaleFlag
					+ " = :applicant");
			parameter.put("saleFlag", saleFlag);
		}
		return new Object[] { condition.toString(), parameter };
	}

	public int getCountBySaleFlag(String mainId, String saleFlag)
			throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		Object[] objects = getConditionSaleFlag(mainId, saleFlag);
		return BOSaleDetailEngine.getBeansCount((String) objects[0],
				(Map) objects[1]);
	}

	public IBOSaleDetailValue[] getSaleDetailBySaleFlag(String mainId,
			String saleFlag, int startNum, int endNum) throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		Object[] objects = getConditionSaleFlag(mainId, saleFlag);
		return BOSaleDetailEngine.getBeans(cols, (String) objects[0]
				+ " order by create_time ", (Map) objects[1], startNum, endNum,
				isShowFK);
	}

	@Override
	public void deleteSaleDetailByMainId(String mainId) throws Exception {

		IBOSaleDetailValue[] saleDetails = getSaleDetailByMainId(mainId, 1, 100);
		if (null != saleDetails) {

			delSaleDetail(saleDetails);
		}
	}

	@Override
	public boolean IsHasSameBossId(String levBossid, String orderId)
			throws Exception {

		String condition = " " + IBOSaleDetailValue.S_LevelCode + " in ("
				+ levBossid + ") and " + IBOSaleDetailValue.S_SaleId
				+ " not in (select sm.id from sale_main_t sm where order_id ="
				+ orderId + ")";
		return BOSaleDetailEngine.getBeansCount(condition, null) > 0;
	}

}
