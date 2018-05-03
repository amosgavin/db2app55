package com.asiainfo.sale.weapon.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleInfoValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponInfoValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponMainDeValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponMainValue;

public interface ISaleWeaponMainDAO {
	//������������ϢIDɾ����������Ϣ
	public void delSaleWeaponMain(String mid)
	throws Exception, RuntimeException ;
	/**
	 * ��������������Ϣ
	 * 
	 * @param saleWeaponMainValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void saveSaleWeaponMain(IBOSaleWeaponMainValue[] saleWeaponMainValues)
			throws Exception;

	/**
	 * ���ݶ�����Ų�ѯ����������Ϣ
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
	public IBOSaleWeaponMainValue[] getSaleWeaponMainById(String id,
			int startNum, int endNum) throws Exception;

	
	public IBOSaleWeaponMainValue[] getSaleWeaponMainById(String id) throws Exception;
	/**
	 * ���ݶ�����Ų�ѯ������������
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
	public int getCountById(String id) throws Exception;

	/**
	 * ���ݶ������ơ����������ơ���֯������ѯ����������Ϣ
	 * 
	 * @param name
	 *            ��������
	 * @param applicant
	 *            ����������
	 * @param org
	 *            ��֯������ѯ����������Ϣ
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponMainValue[] getSaleWeaponMain(String name,
			String applicant, String org, int startNum, int endNum)
			throws Exception;

	/**
	 * ���ݶ������ơ����������ơ���֯������ѯ������������
	 * 
	 * @param name
	 *            ��������
	 * @param applicant
	 *            ����������
	 * @param org
	 *            ��֯������ѯ����������Ϣ
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String name, String applicant, String org)
			throws Exception;

	/**
	 * ɾ������������Ϣ
	 * 
	 * @param saleWeaponMainValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void delSaleWeaponMain(IBOSaleWeaponMainValue[] saleWeaponMainValues)
			throws Exception;
	
	
	public IBOSaleWeaponInfoValue getSaleWeaponInfoValue(String id) throws Exception;
	
	/**
	 * ������ID��ѯ������ϸ��Ϣ
	 * */
	public IBOSaleWeaponMainDeValue[] getSaleWeaponMainDeById(String id) throws Exception;
}