package com.asiainfo.sale.weapon.service.interfaces;

import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.sale.weapon.bo.BOWeaponTagRelaBean;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponSValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponSignOrAduitValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;

public interface ISaleWeaponSV {
	public int selectName(String name) throws Exception, RuntimeException;

	public void delWeaponTagRela(String wid, String saletype) throws Exception;

	/**
	 * ���ݻ��Ų�ѯ������Ϣ
	 * 
	 * @param activityId
	 *            ����
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponValue[] getSaleWeaponByActivityId(String activityId)
			throws Exception, RuntimeException;

	public int getSaleWeaponCountByActivityId(String activityId)
			throws Exception;

	public IBOPromationTagValue[] getSpareTagByActivityId(String activityId)
			throws Exception;

	public int getSpareTagCountByActivityId(String activityId) throws Exception;

	/**
	 * ���ݱ�Ų�ѯ������Ϣ
	 * 
	 * @param id
	 *            ���
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponValue[] getSaleWeaponByID(String id, int startNum,
			int endNum) throws Exception, RuntimeException;

	public IBOSaleWeaponSValue getSaleWeaponSByID(String id, int startNum,
			int endNum) throws Exception, RuntimeException;

	/**
	 * ���ݱ�Ų�ѯ��������
	 * 
	 * @param id
	 *            ���
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCountByID(String id) throws Exception, RuntimeException;

	/**
	 * ���ݶ�����Ų�ѯ������Ϣ
	 * 
	 * @param id
	 *            �������
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponValue[] getSaleWeaponByMainId(String mainId,
			int startNum, int endNum) throws Exception, RuntimeException;

	/**
	 * ���ݶ�����Ų�ѯ��������
	 * 
	 * @param id
	 *            �������
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCountByMainId(String mainId) throws Exception,
			RuntimeException;

	/**
	 * ����Ӫ�����������ơ��г����͡������������������������׶�ȡ�������ȡ� ÿ�����͡��������������Ͷ�ȡ����䡢֧��ȯ������ҵ�񡢻�Ʒ�ɹ�Ŀ¼
	 * ��ѯ������Ϣ
	 * 
	 * @param weaponName
	 *            ����������
	 * @param marketType
	 *            �г�����
	 * @param backMonth
	 *            ��������
	 * @param baseMonth
	 *            ��������
	 * @param lLimit
	 *            ���׶��
	 * @param bLimit
	 *            �������
	 * @param presentPermon
	 *            ÿ������
	 * @param presentMonth
	 *            ��������
	 * @param pLimit
	 *            ���Ͷ��
	 * @param netAge
	 *            ����
	 * @param couponsValue
	 *            ֧��ȯ���
	 * @param selfBusi
	 *            ����ҵ��
	 * @param directory
	 *            ��Ʒ�ɹ�Ŀ¼
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponValue[] getSaleWeapon(String mid, String wwid,
			String wid, String name, String marketType, String backMonth,
			String baseMonth, String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age, int startNum, int endNum)
			throws Exception, RuntimeException;

	/**
	 * ����Ӫ�����������ơ��г����͡������������������������׶�ȡ�������ȡ� ÿ�����͡��������������Ͷ�ȡ����䡢֧��ȯ������ҵ�񡢻�Ʒ�ɹ�Ŀ¼
	 * ��ѯ������Ϣ
	 * 
	 * @param weaponName
	 *            ����������
	 * @param marketType
	 *            �г�����
	 * @param backMonth
	 *            ��������
	 * @param baseMonth
	 *            ��������
	 * @param lLimit
	 *            ���׶��
	 * @param bLimit
	 *            �������
	 * @param presentPermon
	 *            ÿ������
	 * @param presentMonth
	 *            ��������
	 * @param pLimit
	 *            ���Ͷ��
	 * @param netAge
	 *            ����
	 * @param couponsValue
	 *            ֧��ȯ���
	 * @param selfBusi
	 *            ����ҵ��
	 * @param directory
	 *            ��Ʒ�ɹ�Ŀ¼
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String mid, String wwid, String wid, String name,
			String marketType, String backMonth, String baseMonth,
			String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age) throws Exception,
			RuntimeException;

	/**
	 * ɾ������������Ϣ
	 * 
	 * @param saleWeaponMainValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void saveSaleWeapon(IBOSaleWeaponValue[] saleWeaponValues)
			throws Exception, RuntimeException;

	/**
	 * ������ǩ
	 * 
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponSignOrAduitValue[] getSaleWeaponSignOrAduit(String wid,
			String taskTag, int startNum, int endNum) throws Exception,
			RuntimeException;

	public int getCountSignOrAduit(String wid, String taskTag)
			throws Exception, RuntimeException;

	public void saveWeaponTagRela(BOWeaponTagRelaBean weaponTagRelaBean)
			throws Exception;

	public IBOPromationTagValue[] getTagBeanByWeaponWid(String wid)
			throws Exception;

	public IBOPromationTagValue[] getSpareTagDetailByWeaponId(String weaponId)
			throws Exception;

	public void saveTagDetail(IBOPromationTagValue[] tagDetailValues, int pid)
			throws Exception;

	public IBOSaleWeaponSValue[] getSaleWeaponS(String wwid, String wid,
			String name, String marketType, String backMonth, String baseMonth,
			String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age, int startNum, int endNum)
			throws Exception;

	public IBOPromationTagValue[] getWaitTagsID() throws Exception;

	public BOWeaponTagRelaBean getWeaponTagRelaByWS(String wid, String saletype)
			throws Exception;

	public void changeWeaponState(String mainId, String state) throws Exception;

	// ����weapon_id��ѯ������ϸ��Ϣ(����һ�Զ�����)
	public IBOSaleWeaponValue[] getSaleWeaponOnlyByID(String id)
			throws Exception, RuntimeException;

	// ����mid��ѯ������ϸ��Ϣ������һ�Զ�����
	public IBOSaleWeaponValue[] getSaleWeaponOnlyByMID(String mid)
			throws Exception, RuntimeException;

	// ɾ����������������������ģ����Ϣ������һ�Զ�����
	public void delWeapons(IBOSaleWeaponValue[] saleWeaponValues)
			throws Exception, RuntimeException;

	// �ж��Ƿ���Ҫʡҵ֧�����������
	public boolean needWeaponTestAudit(String workflowId) throws Exception;
}
