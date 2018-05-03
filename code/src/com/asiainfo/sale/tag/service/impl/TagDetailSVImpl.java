package com.asiainfo.sale.tag.service.impl;

import java.net.URLDecoder;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.tag.dao.interfaces.ITagDetailDAO;
import com.asiainfo.sale.tag.ivalues.IBOHPApplyValue;
import com.asiainfo.sale.tag.ivalues.IBOHPPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IBOTagItemValue;
import com.asiainfo.sale.tag.service.interfaces.ITagDetailSV;

import org.apache.commons.net.ntp.TimeStamp;

public class TagDetailSVImpl implements ITagDetailSV {

	public void delTagDetail(IBOPromationTagValue[] tagDetailValues)
			throws Exception, RuntimeException {
		((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.delTagDetail(tagDetailValues);
	}

	public int getCount(String mainId) throws Exception, RuntimeException {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getCount(mainId);
	}

	public IBOPromationTagValue getTagDetailById(int id) throws Exception,
			RuntimeException {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagDetailById(id);

	}

	public IBOPromationTagValue[] getTagDetailByMainId(String pid,
			int startNum, int endNum) throws Exception, RuntimeException {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagDetailByMainId(pid, startNum, endNum);
	}

	public int saveTagDetail(IBOPromationTagValue[] tagDetailValues, int pid)
			throws Exception, RuntimeException {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.saveTagDetail(tagDetailValues, pid);
	}

	public IBOPromationTagValue[] getTagDetailByState(String state,
			String tagType, String charge, int startNum, int endNum)
			throws Exception {

		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagDetailByState(state, tagType, charge, startNum, endNum);
	}

	public int countTagDetailByMainId(String pid) throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.countTagDetailByMainId(pid);
	}

	public int getTagDetailCount(String charge, String tagType, String month,
			String orgid) throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagDetailCount(charge, tagType, month, orgid);

	}

	public IBOPromationTagValue[] queryTagDetail(String charge, String tagType,
			String month, String orgid, String chargename, String state,
			int startNum, int endNum) throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.queryTagDetail(charge, tagType, month, orgid, URLDecoder
						.decode(chargename, "utf-8"), state, startNum, endNum);
	}

	public IBOPromationTagValue[] getTagDetailInSpare(String charge,
			String tagType, int startNum, int endNum) throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagDetailInSpare(charge, tagType, startNum, endNum);
	}

	public int getTagInSpareCount(String charge, String tagType)
			throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagInSpareCount(charge, tagType);
	}

	public int getTagCount(String charge, String tagType, String state)
			throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagCount(charge, tagType, state);
	}

	public IBOPromationTagValue[] getTagDetail(String charge, String tagType,
			String state, int startNum, int endNum) throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagDetail(charge, tagType, state, startNum, endNum);
	}

	public IBOPromationTagValue[] getSpareTagDetailByWeaponId(int weaponId) {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getSpareTagDetailByWeaponId(weaponId);
	}

	public IBOHPPromationTagValue[] queryZFQTagDetail(String charge,
			String tagType, String month, String orgid, int startNum, int endNum)
			throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.queryZFQTagDetail(charge, tagType, month, orgid, startNum,
						endNum);
	}

	@Override
	public int getTagDetailCount(String charge, String tagType, String month,
			String orgid, String chargename, String state) throws Exception {

		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagDetailCount(charge, tagType, month, orgid, URLDecoder
						.decode(chargename, "utf-8"), state);
	}

	@Override
	public IBOPromationTagValue[] getAllTagByWeaponId(int weaponId,
			int startNum, int endNum) throws Exception {

		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getAllTagByWeaponId(weaponId, startNum, endNum);
	}

	@Override
	public int getAllTagByWeaponIdCount(int weaponId) throws Exception {

		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getAllTagByWeaponIdCount(weaponId);
	}

	@Override
	public int getCountByTagCode(String tagCodeStr) throws Exception {

		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getCountByTagCode(tagCodeStr);
	}

	public boolean isHaveTag(String tagtype, String charge, String cycle,
			String suncharge, String area, String issp, String name,
			String attype) throws Exception {

		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.isHaveTag(tagtype, charge, cycle, suncharge, area, issp, name,
						attype);
	}

	public IBOHPPromationTagValue getGoodsById(String id) throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getGoodsById(id);
	}

	public void saveGoods(IBOHPPromationTagValue hpPromation) throws Exception {
		((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.saveGoods(hpPromation);
	}

	public boolean haveTagCode() throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.haveTagCode();
	}

	public String getNewid() throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getNewid();
	}

	// 新增货品申请信息
	public String saveProductApply(IBOHPApplyValue aValue) throws Exception {
		Date date = new Date(System.currentTimeMillis());
		Time time = new Time(System.currentTimeMillis());

		aValue.setApplyTime(Timestamp.valueOf(date.toString() + " "
				+ time.toString()));
		String applyName = "货品BOSSID配置申请-"
				+ TimeStamp.getCurrentTime().toDateString();
		aValue.setApplyName(applyName);
		aValue.setPrincipal("00");
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.saveProductApply(aValue);
	}

	public IBOTagItemValue[] getTagItemByType(String itemType) throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagItemByType(itemType);
	}

	public int getTagItemByTypeCount(String itemType) throws Exception {
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagItemByTypeCount(itemType);
	}

	@Override
	// 通过weaponid，标签类型查询出相关标签信息
	public IBOPromationTagValue[] getTagDetailByWeaponIdAndType(int weaponId,
			String tagType) throws Exception {
		// TODO Auto-generated method stub
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getTagDetailByWeaponIdAndType(weaponId, tagType);
	}

	@Override
	public IBOPromationTagValue[] getSpareTagDetailByMid(String mids)
			throws Exception {
		// TODO Auto-generated method stub
		return ((ITagDetailDAO) ServiceFactory.getService(ITagDetailDAO.class))
				.getSpareTagDetailByMid(mids);
	}
}
