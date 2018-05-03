package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleDetailGroupBySaleTypeValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;

public interface ISaleDetailDAO {

	/**
	 * ����Ӫ�����Ϣ
	 * 
	 * @param saveSaleDetail
	 * @throws Exception
	 */
	public String saveSaleDetail(IBOSaleDetailValue[] saleDetailValues)
			throws Exception;

	/*
	 * 
	 */
	public String getNewSaleDetailId() throws Exception;

	/**
	 * ���ݱ�Ų�ѯӪ�����Ϣ
	 * 
	 * @param id
	 *            ���
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailValue getSaleDetailById(String id) throws Exception;

	/**
	 * ����Ӫ������Ų�ѯӪ�����Ϣ
	 * 
	 * @param id
	 *            Ӫ�������
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailValue[] getSaleDetailByMainId(String mainId,
			int startNum, int endNum) throws Exception;

	/**
	 * ����Ӫ������Ų�ѯӪ�����Ϣ
	 * 
	 * @param id
	 *            Ӫ�������
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public int getCount(String mainId) throws Exception;

	/**
	 * ɾ��Ӫ�����Ϣ
	 * 
	 * @param SaleDetailValues
	 * @throws Exception
	 */
	public void delSaleDetail(IBOSaleDetailValue[] saleDetailValues)
			throws Exception;

	/**
	 * ��ѯӪ���������ͷ�����Ϣ
	 * 
	 * @param mainId
	 *            ����
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailGroupBySaleTypeValue[] getSaleDetailGroupBySaleTypeValues(
			String mainId, int startNum, int endNum) throws Exception;

	/**
	 * ��ѯӪ���������ͷ�����Ϣ����
	 * 
	 * @param mainId
	 *            ����
	 * @return
	 * @throws Exception
	 */
	public int getCountGroupBySaleType(String mainId) throws Exception;

	/**
	 * ���ݻ���Ͳ�ѯӪ�����Ϣ
	 * 
	 * @param mainId
	 *            Ӫ�������
	 * @param saleFlag
	 *            �����
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailValue[] getSaleDetailBySaleFlag(String mainId,
			String saleFlag, int startNum, int endNum) throws Exception;

	/**
	 * ��ѯӪ������Ų�ѯӪ�����Ϣ����
	 * 
	 * @param mainId
	 *            Ӫ�������
	 * @param saleFlag
	 *            �����
	 * @return
	 * @throws Exception
	 */
	public int getCountBySaleFlag(String mainId, String saleFlag)
			throws Exception;

	/**
	 * ����Ӫ�����α���
	 * 
	 * @param saleDetailValue
	 * @return
	 * @throws Exception
	 */
	public String getSaleDetailCode(IBOSaleDetailValue saleDetailValue)
			throws Exception;

	/**
	 * ͨ��Ӫ��������mainIdɾ������
	 */
	public void deleteSaleDetailByMainId(String mainId) throws Exception;

	/**
	 * �ж���д����bossid�Ƿ������ͬ��
	 */
	public boolean IsHasSameBossId(String levBossid, String orderId)
			throws Exception;
}
