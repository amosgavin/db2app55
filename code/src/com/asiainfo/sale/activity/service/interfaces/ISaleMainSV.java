package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;

public interface ISaleMainSV {

	/**
	 * ����һ��Ӫ������Ϣ
	 * 
	 * @param saleMainValue
	 * @return ����Ա��� 0 ʧ��
	 * @throws Exception
	 */
	public String saveSaleMain(IBOSaleMainValue saleMainValue)
			throws Exception, RuntimeException;

	/**
	 * ����Ӫ������Ϣ
	 * 
	 * @param SaleMainValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void saveSaleMain(IBOSaleMainValue[] saleMainValues)
			throws Exception, RuntimeException;

	/**
	 * ���ݶ�����Ų�ѯӪ������Ϣ
	 * 
	 * @param id
	 *            ���
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainValue getSaleMainById(String id) throws Exception,
			RuntimeException;

	/**
	 * ����Ӫ�������ơ����������ơ���֯������ѯӪ������Ϣ
	 * 
	 * @param name
	 *            Ӫ��������
	 * @param applicant
	 *            ����������
	 * @param org
	 *            ��֯����
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainValue[] getSaleMain(String name, String applicant,
			String org, int startNum, int endNum) throws Exception,
			RuntimeException;

	/**
	 * ����Ӫ�������ơ����������ơ���֯������ѯӪ��������
	 * 
	 * @param name
	 *            Ӫ��������
	 * @param applicant
	 *            ����������
	 * @param org
	 *            ��֯����
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String name, String applicant, String org)
			throws Exception, RuntimeException;

	/**
	 * ɾ��Ӫ������Ϣ
	 * 
	 * @param SaleMainValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void delSaleMain(IBOSaleMainValue[] saleMainValues)
			throws Exception, RuntimeException;

	/**
	 * ��������״̬������ȯ����ֻ��ʹ��һ�Σ���Ҫ���ύ���̺���ô˷�������״̬��
	 * 
	 * @param mainId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void setWeaponState(String mainId) throws Exception,
			RuntimeException;

	/**
	 * ����Ӫ����
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void cloneSaleMain(String mainId, String orderId) throws Exception,
			RuntimeException;

	/**
	 * ͬ��-�޸�Ӫ����״̬
	 * 
	 * @param mainId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsToAgreen(String mainId) throws Exception,
			RuntimeException;

	/**
	 * ��ͬ��-�޸�Ӫ����״̬
	 * 
	 * @param mainId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsToNo(String mainId) throws Exception, RuntimeException;

	/**
	 * ɾ��Ӫ����������Ϣ
	 * 
	 * @param mainId
	 * @throws Exception
	 */
	public void deleteSaleMainByMainId(String mainId) throws Exception;

	public void changeStsTo(String mainId, String state) throws Exception,
			RuntimeException;

	public String getNewACTCode(IBOSaleMainValue saleMain) throws Exception,
			RuntimeException;

	/**
	 * �ж���д����bossid�Ƿ������ͬ��
	 * 
	 * @param actBossid
	 * @return
	 * @throws Exception
	 */
	public boolean IsHasSameBossId(String actBossid, String orderId)
			throws Exception;

	/**
	 * ������������ַ���д�˲����ҵ����˷���
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public boolean hasEmptyExplantStatistic(String orderId) throws Exception;

	/**
	 * ������а�������ȯ�����ζ���д�˵�����浥
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public boolean hasEitAppriseToWrite(String orderId) throws Exception;
	
	/**
	 * �ж�Ӫ����Ƿ��������ȯ
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public boolean hasEitInSale(String orderId) throws Exception;

	public String checksalemaintype(String orderId) throws Exception;
	/**
	 * �ж�Ӫ�����Ļ����
	 * 
	 */
}
