package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleDetailGroupBySaleTypeValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;

public interface ISaleDetailSV {

	/**
	 * ����Ӫ�����Ϣ
	 * 
	 * @param saveSaleDetail
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveSaleDetail(IBOSaleDetailValue[] saleDetailValues)
			throws Exception, RuntimeException;

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
	 * @throws RuntimeException
	 */
	public IBOSaleDetailValue getSaleDetailById(String id) throws Exception,
			RuntimeException;

	/**
	 * ����Ӫ������Ų�ѯӪ�����Ϣ
	 * 
	 * @param mainId
	 *            ����
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleDetailValue[] getSaleDetailByMainId(String mainId,
			int startNum, int endNum) throws Exception, RuntimeException;

	/**
	 * ��ѯӪ������Ų�ѯӪ�����Ϣ����
	 * 
	 * @param mainId
	 *            ����
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String mainId) throws Exception, RuntimeException;

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
	 * @throws RuntimeException
	 */
	public IBOSaleDetailValue[] getSaleDetailBySaleFlag(String mainId,
			String saleFlag, int startNum, int endNum) throws Exception,
			RuntimeException;

	/**
	 * ��ѯӪ������Ų�ѯӪ�����Ϣ����
	 * 
	 * @param mainId
	 *            Ӫ�������
	 * @param saleFlag
	 *            �����
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCountBySaleFlag(String mainId, String saleFlag)
			throws Exception, RuntimeException;

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
	 * @throws RuntimeException
	 */
	public IBOSaleDetailGroupBySaleTypeValue[] getSaleDetailGroupBySaleTypeValues(
			String mainId, int startNum, int endNum) throws Exception,
			RuntimeException;

	/**
	 * ��ѯӪ���������ͷ�����Ϣ����
	 * 
	 * @param mainId
	 *            ����
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCountGroupBySaleType(String mainId) throws Exception,
			RuntimeException;

	/**
	 * ɾ��Ӫ�����Ϣ
	 * 
	 * @param SaleDetailValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void delSaleDetail(IBOSaleDetailValue[] saleDetailValues)
			throws Exception, RuntimeException;

	/**
	 * �ж���д����bossid�Ƿ������ͬ��
	 */
	public boolean IsHasSameBossId(String levBossid, String orderId)
			throws Exception;
}
