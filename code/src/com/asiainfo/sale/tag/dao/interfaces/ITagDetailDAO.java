package com.asiainfo.sale.tag.dao.interfaces;

import com.asiainfo.sale.tag.ivalues.IBOHPApplyValue;
import com.asiainfo.sale.tag.ivalues.IBOHPPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IBOTagItemValue;

public interface ITagDetailDAO {

	public int saveTagDetail(IBOPromationTagValue[] tagDetailValues, int pid)
			throws Exception;

	/**
	 * 根据编号查询促销标签信息
	 * 
	 * @param id
	 *            编号
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOPromationTagValue getTagDetailById(int id) throws Exception;

	/**
	 * 根据促销标签编号查询营销活动信息
	 * 
	 * @param id
	 *            促销标签编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOPromationTagValue[] getTagDetailByMainId(String pid,
			int startNum, int endNum) throws Exception;

	public int countTagDetailByMainId(String pid) throws Exception;

	/**
	 * 根据促销标签编号查询营销活动信息
	 * 
	 * @param id
	 *            促销标签编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String mainId) throws Exception;

	/*
	 * 查询状态为使用的所有标签
	 */
	public IBOPromationTagValue[] getTagDetailByState(String state,
			String tagType, String charge, int startNum, int endNum)
			throws Exception;

	/**
	 * 删除促销标签信息
	 * 
	 * @param TagDetailValues
	 * @throws Exception
	 * @throws RuntimeException
	 */

	public IBOPromationTagValue[] queryTagDetail(String charge, String tagType,
			String month, String orgid, String chargename, String state,
			int startNum, int endNum) throws Exception;

	public IBOHPPromationTagValue[] queryZFQTagDetail(String charge,
			String tagType, String month, String orgid, int startNum, int endNum)
			throws Exception;

	public int getTagDetailCount(String charge, String tagType, String month,
			String orgid) throws Exception;

	public int getTagDetailCount(String charge, String tagType, String month,
			String orgid, String chargename, String state) throws Exception;

	public int getTagCount(String charge, String tagType, String state)
			throws Exception;

	public IBOPromationTagValue[] getTagDetail(String charge, String tagType,
			String state, int startNum, int endNum) throws Exception;

	public IBOPromationTagValue[] getTagDetailInSpare(String charge,
			String tagType, int startNum, int endNum) throws Exception;

	public int getTagInSpareCount(String charge, String tagType)
			throws Exception;

	public void delTagDetail(IBOPromationTagValue[] tagDetailValues)
			throws Exception;

	/*
	 * 根据武器id获取标签id，取出备用标签信息
	 */
	public IBOPromationTagValue[] getSpareTagDetailByWeaponId(int weaponId);

	public IBOPromationTagValue[] getAllTagByWeaponId(int weaponId,
			int startNum, int endNum) throws Exception;

	public int getAllTagByWeaponIdCount(int weaponId) throws Exception;

	public int getCountByTagCode(String tagCodeStr) throws Exception;

	// 保存时是否有重复
	public boolean isHaveTag(String tagtype, String charge, String cycle,
			String suncharge, String area, String issp, String name,
			String attype) throws Exception;

	public IBOHPPromationTagValue getGoodsById(String id) throws Exception;

	public void saveGoods(IBOHPPromationTagValue hpPromation) throws Exception;

	public boolean haveTagCode() throws Exception;

	public String getNewid() throws Exception;

	public String saveProductApply(IBOHPApplyValue aValue) throws Exception;

	public IBOTagItemValue[] getTagItemByType(String itemType) throws Exception;

	public int getTagItemByTypeCount(String itemType) throws Exception;

	// 通过weaponid，标签类型查询出相关标签信息
	public IBOPromationTagValue[] getTagDetailByWeaponIdAndType(int weaponId,
			String tagType) throws Exception;

	// 通过工单ID,取出备用标签信息(武器一对多需求)
	public IBOPromationTagValue[] getSpareTagDetailByMid(String mids)
			throws Exception;

}
