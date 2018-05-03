package com.asiainfo.sale.tag.dao.interfaces;

import com.asiainfo.sale.tag.ivalues.IBOHPApplyValue;
import com.asiainfo.sale.tag.ivalues.IBOHPPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IBOTagItemValue;

public interface ITagDetailDAO {

	public int saveTagDetail(IBOPromationTagValue[] tagDetailValues, int pid)
			throws Exception;

	/**
	 * ���ݱ�Ų�ѯ������ǩ��Ϣ
	 * 
	 * @param id
	 *            ���
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOPromationTagValue getTagDetailById(int id) throws Exception;

	/**
	 * ���ݴ�����ǩ��Ų�ѯӪ�����Ϣ
	 * 
	 * @param id
	 *            ������ǩ���
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOPromationTagValue[] getTagDetailByMainId(String pid,
			int startNum, int endNum) throws Exception;

	public int countTagDetailByMainId(String pid) throws Exception;

	/**
	 * ���ݴ�����ǩ��Ų�ѯӪ�����Ϣ
	 * 
	 * @param id
	 *            ������ǩ���
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String mainId) throws Exception;

	/*
	 * ��ѯ״̬Ϊʹ�õ����б�ǩ
	 */
	public IBOPromationTagValue[] getTagDetailByState(String state,
			String tagType, String charge, int startNum, int endNum)
			throws Exception;

	/**
	 * ɾ��������ǩ��Ϣ
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
	 * ��������id��ȡ��ǩid��ȡ�����ñ�ǩ��Ϣ
	 */
	public IBOPromationTagValue[] getSpareTagDetailByWeaponId(int weaponId);

	public IBOPromationTagValue[] getAllTagByWeaponId(int weaponId,
			int startNum, int endNum) throws Exception;

	public int getAllTagByWeaponIdCount(int weaponId) throws Exception;

	public int getCountByTagCode(String tagCodeStr) throws Exception;

	// ����ʱ�Ƿ����ظ�
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

	// ͨ��weaponid����ǩ���Ͳ�ѯ����ر�ǩ��Ϣ
	public IBOPromationTagValue[] getTagDetailByWeaponIdAndType(int weaponId,
			String tagType) throws Exception;

	// ͨ������ID,ȡ�����ñ�ǩ��Ϣ(����һ�Զ�����)
	public IBOPromationTagValue[] getSpareTagDetailByMid(String mids)
			throws Exception;

}
