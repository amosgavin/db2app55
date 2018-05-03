package com.asiainfo.sale.tag.dao.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.sale.tag.bo.BOHPPromationTagEngine;
import com.asiainfo.sale.tag.bo.BOTagItemEngine;
import com.asiainfo.sale.tag.bo.BOPromationTagEngine;
import com.asiainfo.sale.tag.bo.BOHPApplyEngine;
import com.asiainfo.sale.tag.dao.interfaces.ITagDetailDAO;
import com.asiainfo.sale.tag.ivalues.IBOHPPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IBOHPApplyValue;
import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IBOTagItemValue;
import com.asiainfo.sale.weapon.bo.BOWeaponTagRelaEngine;
import com.asiainfo.sale.weapon.ivalues.IBOWeaponTagRelaValue;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponMainEngine;

public class TagDetailDAOImpl implements ITagDetailDAO {

	public void delTagDetail(IBOPromationTagValue[] tagDetailValues)
			throws Exception {
		for (int i = 0; i < tagDetailValues.length; i++) {
			tagDetailValues[i].delete();
		}
		BOPromationTagEngine.save(tagDetailValues);
	}

	public int getCount(String mainId) throws Exception {
		Object[] objects = getCondition(mainId);
		return BOPromationTagEngine.getBeansCount((String) objects[0],
				(Map) objects[1]);
	}

	public IBOPromationTagValue getTagDetailById(int id) throws Exception {
		return BOPromationTagEngine.getBean(id);
	}

	public IBOPromationTagValue[] getTagDetailByMainId(String pid,
			int startNum, int endNum) throws Exception {

		String condition = "";
		condition = " " + IBOPromationTagValue.S_Id + " in ( " + pid + " ) ";
		return BOPromationTagEngine.getBeans(null, condition, null, startNum,
				endNum, false);
	}

	public int countTagDetailByMainId(String pid) throws Exception {

		String condition = "";
		condition = " " + IBOPromationTagValue.S_Id + " in ( " + pid + " ) ";
		return BOPromationTagEngine.getBeansCount(condition, null);
	}

	public int saveTagDetail(IBOPromationTagValue[] tagDetailValues, int pid)
			throws Exception {
		for (int i = 0; i < tagDetailValues.length; i++) {
			// 新增，需要取ID
			if (tagDetailValues[i].isNew()) {
				tagDetailValues[i].setId(BOPromationTagEngine.getNewId()
						.intValue());
				tagDetailValues[i].setStsToNew();
				tagDetailValues[i].set("PID", pid);
				// tagDetailValues[i].set("STATE", "99");
				System.out.print(tagDetailValues[i]);
			}
			BOPromationTagEngine.save(tagDetailValues);
			return (int) tagDetailValues[0].getId();
		}
		return 0;

	}

	private Object[] getCondition(String charge) {
		String condition = " " + IBOPromationTagValue.S_Charge + " = :charge";
		Map parameter = new HashedMap();
		parameter.put("CHARGE", charge);
		return new Object[] { condition.toString(), parameter };
	}

	public IBOPromationTagValue[] getTagDetailByState(String state,
			String tagType, String charge, int startNum, int endNum)
			throws Exception {

		String condition = " 1=1 ";
		if (null != state && !state.equals("-1")) {
			condition += " and " + IBOPromationTagValue.S_State + " = " + state;
		}
		if (null != charge && !charge.equals("-1")) {
			condition += " and " + IBOPromationTagValue.S_Charge + " = "
					+ charge;
		}
		if (null != tagType && !tagType.equals("-1")) {
			condition += " and " + IBOPromationTagValue.S_TagType + " = "
					+ tagType;
		}
		return BOPromationTagEngine.getBeans(null, condition, null, startNum,
				endNum, false);
	}

	public IBOPromationTagValue[] getTagDetailInSpare(String charge,
			String tagType, int startNum, int endNum) throws Exception {

		return getTagDetailByState("99", tagType, charge, startNum, endNum);
	}

	public int getTagInSpareCount(String charge, String tagType)
			throws Exception {
		String condition = " " + IBOPromationTagValue.S_State + " = \'99\'";
		if (null != charge && !charge.equals("-1")) {
			condition += " and " + IBOPromationTagValue.S_Charge + " = "
					+ charge;
		}
		if (null != tagType && !tagType.equals("-1")) {
			condition += " and " + IBOPromationTagValue.S_TagType + " = "
					+ tagType;
		}
		return BOPromationTagEngine.getBeansCount(condition, null);
	}

	// <<<<<<< .mine

	public IBOPromationTagValue[] queryTagDetail(String charge, String tagType,
			String month, String orgid, String chargename, String state,
			int startNum, int endNum) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");

		if (StringUtils.isNotBlank(state)) {
			condition.append(" AND " + IBOPromationTagValue.S_State
					+ " = :state");
			parameter.put("state", state);
		}
		if (StringUtils.isNotBlank(charge)) {
			condition.append(" AND " + IBOPromationTagValue.S_Charge
					+ " = :charge");
			parameter.put("charge", charge);
		} else {
			condition = condition;
		}
		if (StringUtils.isNotBlank(tagType)) {
			condition.append(" AND " + IBOPromationTagValue.S_TagType
					+ " = :tagType");
			parameter.put("tagType", tagType);
		}
		if (StringUtils.isNotBlank(month)) {
			condition.append(" AND " + IBOPromationTagValue.S_Cycle
					+ " = :cycle");
			parameter.put("cycle", month);
		}
		if (StringUtils.isNotBlank(chargename)) {
			condition.append(" AND " + IBOPromationTagValue.S_Name
					+ " like :chargename");
			parameter.put("chargename", "%" + chargename + "%");
		}
		if ("10" != orgid) {
			condition.append(" AND " + IBOPromationTagValue.S_Area
					+ " in (10,:orgid) ORDER BY "
					+ IBOPromationTagValue.S_Charge);
			parameter.put("orgid", orgid);
		} else {
			condition.append(" AND " + IBOPromationTagValue.S_Area
					+ " = :orgid  ORDER BY " + IBOPromationTagValue.S_Charge);
			parameter.put("orgid", orgid);
		}
		Object[] object = new Object[] { condition.toString(), parameter };
		IBOPromationTagValue[] iob = BOPromationTagEngine.getBeans(null,
				(String) object[0], (Map) object[1], startNum, endNum, false);
		return iob;

	}

	public int getTagCount(String charge, String tagType, String state)
			throws Exception {
		String condition = "1=1";
		if (null != state && !state.equals("-1")) {
			condition += " and " + IBOPromationTagValue.S_State + " = " + state;
		}
		if (null != charge && !charge.equals("-1")) {
			condition += " and " + IBOPromationTagValue.S_Charge + " = "
					+ charge;
		}
		if (null != tagType && !tagType.equals("-1")) {
			condition += " and " + IBOPromationTagValue.S_TagType + " = "
					+ tagType;
		}
		return BOPromationTagEngine.getBeansCount(condition, null);
	}

	public IBOPromationTagValue[] getTagDetail(String charge, String tagType,
			String state, int startNum, int endNum) throws Exception {
		String condition = "1=1";
		if (null != state && !state.equals("-1")) {
			condition += " and " + IBOPromationTagValue.S_State + " = " + state;
		}
		if (null != charge && !charge.equals("-1")) {
			condition += " and " + IBOPromationTagValue.S_Charge + " = "
					+ charge;
		}
		if (null != tagType && !tagType.equals("-1")) {
			condition += " and " + IBOPromationTagValue.S_TagType + " = "
					+ tagType;
		}
		return BOPromationTagEngine.getBeans(null, condition + " order by id ",
				null, startNum, endNum, false);
	}

	// >>>>>>> .r127
	/*
	 * 根据武器id获取标签id，取出备用标签信息
	 */

	public IBOPromationTagValue[] getSpareTagDetailByWeaponId(int weaponId) {

		String condition = IBOWeaponTagRelaValue.S_WeaponId + " = " + weaponId;
		ArrayList<IBOPromationTagValue> spareTags = new ArrayList<IBOPromationTagValue>();

		try {
			IBOWeaponTagRelaValue weaponTagRelas[] = BOWeaponTagRelaEngine
					.getBeans(condition, null);
			for (int i = 0; i < weaponTagRelas.length; ++i) {
				if (weaponTagRelas[i] != null) {
					IBOPromationTagValue temp = BOPromationTagEngine
							.getBean(Integer.parseInt(weaponTagRelas[i]
									.getTagId()));
					if (null != temp) {
						if (temp.getState().equals("99")
								|| temp.getPid() == weaponId) {

							spareTags.add(temp);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IBOPromationTagValue[]) spareTags
				.toArray(new IBOPromationTagValue[spareTags.size()]);
	}

	public IBOHPPromationTagValue[] queryZFQTagDetail(String charge,
			String tagType, String month, String orgid, int startNum, int endNum)
			throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1  ");

		// <<<<<<< .mine
		if (StringUtils.isNotBlank(charge)) {
			condition.append(" AND " + IBOHPPromationTagValue.S_Charge
					+ " = :charge");
			parameter.put("charge", charge);
		} else {
			condition = condition;
		}
		if (StringUtils.isNotBlank(tagType)) {
			condition.append(" AND " + IBOHPPromationTagValue.S_TagCode
					+ " is  null ");
		}
		// month为名称查询
		if (StringUtils.isNotBlank(month)) {
			String mon = URLDecoder.decode(month, "utf-8");
			condition.append(" AND " + IBOHPPromationTagValue.S_Name
					+ " like :cycle");
			parameter.put("cycle", "%" + mon + "%");
		}
		String org = URLDecoder.decode(orgid, "utf-8");
		System.out.print(org);
		if (!"全省".equals(org)) {
			condition.append(" AND  (" + IBOHPPromationTagValue.S_Area
					+ "  like  '%" + org + "%' or "
					+ IBOHPPromationTagValue.S_Area + " = '全省') AND "
					+ IBOHPPromationTagValue.S_State + " != '0' ");
		}
		condition.append("  order by tag_code desc,id desc ");
		Object[] object = new Object[] { condition.toString(), parameter };
		IBOHPPromationTagValue[] iob = BOHPPromationTagEngine.getBeans(null,
				(String) object[0], (Map) object[1], startNum, endNum, false);
		return iob;

	}

	public int getTagDetailCount(String charge, String tagType, String month,
			String orgid) throws Exception {
		return queryZFQTagDetail(charge, tagType, month, orgid, -1, -1).length;

	}

	@Override
	public int getTagDetailCount(String charge, String tagType, String month,
			String orgid, String chargename, String state) throws Exception {

		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (StringUtils.isNotBlank(state)) {
			condition.append(" AND " + IBOPromationTagValue.S_State
					+ " = :state");
			parameter.put("state", state);
		}
		if (StringUtils.isNotBlank(charge)) {
			condition.append(" AND " + IBOPromationTagValue.S_Charge
					+ " = :charge");
			parameter.put("charge", charge);
		} else {
			condition = condition;
		}
		if (StringUtils.isNotBlank(tagType)) {
			condition.append(" AND " + IBOPromationTagValue.S_TagType
					+ " = :tagType");
			parameter.put("tagType", tagType);
		}
		if (StringUtils.isNotBlank(month)) {
			condition.append(" AND " + IBOPromationTagValue.S_Cycle
					+ " = :cycle");
			parameter.put("cycle", month);
		}
		if (StringUtils.isNotBlank(chargename)) {
			condition.append(" AND " + IBOPromationTagValue.S_Name
					+ " like :chargename");
			parameter.put("chargename", "%" + chargename + "%");
		}
		if ("10" != orgid) {
			condition.append(" AND " + IBOPromationTagValue.S_Area
					+ " in (10,:orgid)");
			parameter.put("orgid", orgid);
		} else {
			condition.append(" AND " + IBOPromationTagValue.S_Area
					+ " = :orgid");
			parameter.put("orgid", orgid);
		}
		if (!"7".equalsIgnoreCase(tagType)) {
			return BOPromationTagEngine.getBeansCount(condition.toString(),
					parameter);
		} else {
			return BOHPPromationTagEngine.getBeansCount(condition.toString(),
					parameter);
		}

	}

	public IBOPromationTagValue[] getAllTagByWeaponId(int weaponId,
			int startNum, int endNum) throws Exception {

		String condition = IBOWeaponTagRelaValue.S_WeaponId + " = " + weaponId;
		String tagIdStr = "";

		try {
			IBOWeaponTagRelaValue weaponTagRelas[] = BOWeaponTagRelaEngine
					.getBeans(condition, null);
			for (int i = 0; i < weaponTagRelas.length; ++i) {
				if (weaponTagRelas[i] != null) {
					if (0 == i) {
						tagIdStr += weaponTagRelas[i].getTagId();
					} else {
						tagIdStr += "," + weaponTagRelas[i].getTagId();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (tagIdStr.equals("")) {
			tagIdStr = "-1";
		}
		return BOPromationTagEngine.getBeans(null, " 1=1 and "
				+ IBOPromationTagValue.S_Id + " in (" + tagIdStr + ")", null,
				startNum, endNum, false);

	}

	public int getAllTagByWeaponIdCount(int weaponId) throws Exception {

		String condition = IBOWeaponTagRelaValue.S_WeaponId + " = " + weaponId;
		String tagIdStr = "";

		try {
			IBOWeaponTagRelaValue weaponTagRelas[] = BOWeaponTagRelaEngine
					.getBeans(condition, null);
			for (int i = 0; i < weaponTagRelas.length; ++i) {
				if (weaponTagRelas[i] != null) {
					if (0 == i) {
						tagIdStr += weaponTagRelas[i].getTagId();
					} else {
						tagIdStr += "," + weaponTagRelas[i].getTagId();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (tagIdStr.equals("")) {
			return 0;
		}
		return BOPromationTagEngine.getBeansCount(" 1=1 and "
				+ IBOPromationTagValue.S_Id + " in (" + tagIdStr + ")", null);

	}

	@Override
	public int getCountByTagCode(String tagCodeStr) throws Exception {
		if (tagCodeStr != null && !tagCodeStr.equals("")) {
			return BOPromationTagEngine.getBeansCount(" 1=1 and "
					+ IBOPromationTagValue.S_TagCode + " in (" + tagCodeStr
					+ ")", null);
		} else {
			return 0;
		}
	}

	public boolean isHaveTag(String tagtype, String charge, String cycle,
			String suncharge, String area, String issp, String name,
			String attype) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (StringUtils.isNotBlank(charge)) {
			condition.append(" AND " + IBOPromationTagValue.S_Charge
					+ " = :charge");
			parameter.put("charge", charge);
		} else {
			condition = condition;
		}
		if (StringUtils.isNotBlank(tagtype)) {
			condition.append(" AND " + IBOPromationTagValue.S_TagType
					+ " = :tagtype");
			parameter.put("tagtype", tagtype);
		}
		if (StringUtils.isNotBlank(cycle)) {
			condition.append(" AND " + IBOPromationTagValue.S_Cycle
					+ " = :cycle");
			parameter.put("cycle", cycle);
		}
		if (StringUtils.isNotBlank(suncharge)) {
			condition.append(" AND " + IBOPromationTagValue.S_Sumcharge
					+ " = :suncharge");
			parameter.put("suncharge", suncharge);
		}

		if (StringUtils.isNotBlank(area)) {
			condition
					.append(" AND " + IBOPromationTagValue.S_Area + " = :area");
			parameter.put("area", area);
		}
		if (StringUtils.isNotBlank(issp)) {
			condition
					.append(" AND " + IBOPromationTagValue.S_IsSp + " = :issp");
			parameter.put("issp", issp);
		}
		if (StringUtils.isNotBlank(name)) {
			condition
					.append(" AND " + IBOPromationTagValue.S_Name + " = :name");
			parameter.put("name", name);
		}
		if (StringUtils.isNotBlank(attype)) {
			condition.append(" AND " + IBOPromationTagValue.S_AccountType
					+ " = :attype");
			parameter.put("attype", attype);
		}
		if (BOPromationTagEngine.getBeansCount(condition.toString(), parameter) > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 根据ID查询货品
	public IBOHPPromationTagValue getGoodsById(String id) throws Exception {
		return BOHPPromationTagEngine.getBean(Integer.parseInt(id));
	}

	// 保存货品
	public void saveGoods(IBOHPPromationTagValue hpPromation) throws Exception {
		if (hpPromation.isNew()) {
			hpPromation.setCreateTime(BOHPPromationTagEngine.getSysDate());
			hpPromation.setId(BOHPPromationTagEngine.getNewId().intValue());
			hpPromation.setState("1");
		} else {
			hpPromation.setModifyTime(BOHPPromationTagEngine.getSysDate());
		}
		if (hpPromation.isDeleted()) {
			hpPromation.setState("0");
			BOHPPromationTagEngine.save(hpPromation);
		} else {
			BOHPPromationTagEngine.save(hpPromation);
		}

	}

	public boolean haveTagCode() throws Exception {
		String condition = "select * from   HBSALE.SALE_HPTAG_DETAIL_T where tag_code is null and state !=0";
		IBOHPPromationTagValue[] hpPromationTagValue = BOHPPromationTagEngine
				.getBeansFromSql(condition, null);
		if (hpPromationTagValue.length > 0) {
			return true;
		} else {
			return false;
		}
	}

	public String getNewid() throws Exception {
		return BOSaleWeaponMainEngine.getNewId().toString();

	}

	// 新增货品申请信息
	public String saveProductApply(IBOHPApplyValue aValue) throws Exception {
		String newId = String.valueOf(BOHPApplyEngine.getNewId());
		aValue.setRecordid(newId);
		BOHPApplyEngine.save(aValue);
		return newId;
	}

	// 专款范围账目项
	public IBOTagItemValue[] getTagItemByType(String itemType) throws Exception {
		if (StringUtils.isNotBlank(itemType)) {
			String condition = "select * from   HBSALE.TAG_ITEM_T where ITEM_TYPE ="
					+ itemType;
			return BOTagItemEngine.getBeansFromSql(condition, null);
		}
		return null;

	}

	public int getTagItemByTypeCount(String itemType) throws Exception {
		return this.getTagItemByType(itemType).length;
	}

	@Override
	public IBOPromationTagValue[] getTagDetailByWeaponIdAndType(int weaponId,
			String tagType) throws Exception {
		// TODO Auto-generated method stub
		String condition = IBOWeaponTagRelaValue.S_WeaponId + " = " + weaponId;
		ArrayList<IBOPromationTagValue> spareTags = new ArrayList<IBOPromationTagValue>();
		String tagid = "";
		try {
			IBOWeaponTagRelaValue weaponTagRelas[] = BOWeaponTagRelaEngine
					.getBeans(condition, null);
			for (int i = 0; i < weaponTagRelas.length; ++i) {
				if (weaponTagRelas[i] != null) {
					IBOPromationTagValue temp = BOPromationTagEngine
							.getBean(Integer.parseInt(weaponTagRelas[i]
									.getTagId()));
					if (null != temp) {
						// String a = temp.getTagType().trim();
						// String b = tagType.trim();
						// int c = temp.getPid();
						// boolean f =
						// (temp.getTagType().trim().equals(tagType.trim()));
						// boolean fd =
						// (temp.getTagType().trim().equals(tagType.trim())||
						// temp.getPid() == weaponId);
						if (temp.getTagType().trim().equals(tagType.trim())
								|| temp.getPid() == weaponId) {
							if (!tagid.contains(Integer.toString(temp.getId()))) {
								tagid = tagid + Integer.toString(temp.getId())
										+ "@";
								spareTags.add(temp);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IBOPromationTagValue[]) spareTags
				.toArray(new IBOPromationTagValue[spareTags.size()]);
	}

	@Override
	public IBOPromationTagValue[] getSpareTagDetailByMid(String mids)
			throws Exception {
		mids = mids.substring(0, mids.length() - 1);
		String condition = IBOWeaponTagRelaValue.S_WeaponId + " in( " + mids
				+ " ) ";
		ArrayList<IBOPromationTagValue> spareTags = new ArrayList<IBOPromationTagValue>();
		String tagid = "";
		try {
			IBOWeaponTagRelaValue weaponTagRelas[] = BOWeaponTagRelaEngine
					.getBeans(condition, null);
			for (int i = 0; i < weaponTagRelas.length; ++i) {
				if (weaponTagRelas[i] != null) {
					IBOPromationTagValue temp = BOPromationTagEngine
							.getBean(Integer.parseInt(weaponTagRelas[i]
									.getTagId()));
					if (null != temp) {
						if (temp.getState().equals("99")
								|| temp.getPid() == Integer
										.parseInt(weaponTagRelas[i]
												.getWeaponId())) {
							if (!tagid.contains(Integer.toString(temp.getId()))) {
								tagid = tagid + Integer.toString(temp.getId())
										+ "@";
								spareTags.add(temp);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IBOPromationTagValue[]) spareTags
				.toArray(new IBOPromationTagValue[spareTags.size()]);
	}
}
