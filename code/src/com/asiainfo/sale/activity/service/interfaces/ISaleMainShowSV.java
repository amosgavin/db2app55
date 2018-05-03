package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleInfoValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainShowValue;

public interface ISaleMainShowSV {

	
	/**
	 * ���ݶ�����Ų�ѯӪ�������壨��������Ϣ�͵�����Ϣ����Ϣ
	 * 
	 * @param id
	 *            ���
	 * 
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleInfoValue getSaleInfoValue(String id) throws Exception,
			RuntimeException;

	/**
	 * ���ݶ�����Ų�ѯӪ������Ϣ
	 * 
	 * @param id
	 *            ���
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainShowValue getSaleMainShowById(String id)
			throws Exception, RuntimeException;

	/**
	 * ���ݶ�����Ų�ѯԤ��Ӫ������Ϣ
	 * 
	 * @param id
	 *            ���
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainShowValue getSaleMainOverviewById(String id)
			throws Exception, RuntimeException;

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
	public IBOSaleMainShowValue[] getSaleMainShow(String name,
			String applicant, String org, int startNum, int endNum)
			throws Exception, RuntimeException;

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
	 * ��ȡӪ������Ϣ
	 * 
	 * @param mainCode
	 *            Ӫ����ҵ�����
	 * @param name
	 *            Ӫ��������
	 * @param applicant
	 *            �ύ��
	 * @param org
	 *            �ύ��֯
	 * @param submitTimeBegin
	 *            �ύ��ʼʱ��
	 * @param submitTimeEnd
	 *            �ύ����ʱ��
	 * @param isFinish
	 *            �Ƿ����
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainShowValue[] getSaleMainAndFWInfo(String taskTag,
			String curStat, String mainCode, String name, String applicant,
			String org, String submitTimeBegin, String submitTimeEnd,
			int startNum, int endNum) throws Exception, RuntimeException;

	/**
	 * ��ȡӪ������Ϣ����
	 * 
	 * @param mainCode
	 *            Ӫ����ҵ�����
	 * @param name
	 *            Ӫ��������
	 * @param applicant
	 *            �ύ��
	 * @param org
	 *            �ύ��֯
	 * @param submitTimeBegin
	 *            �ύ��ʼʱ��
	 * @param submitTimeEnd
	 *            �ύ����ʱ��
	 * @param isFinish
	 *            �Ƿ����
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String taskTag, String curStat, String mainCode,
			String name, String applicant, String org, String submitTimeBegin,
			String submitTimeEnd) throws Exception, RuntimeException;

	public IBOSaleMainShowValue[] getSaleMainAndFWInfo2(String selectType,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd, String isFinish,
			int startNum, int endNum) throws Exception, RuntimeException;

	public int getCount2(String selectType, String mainCode, String name,
			String applicant, String org, String submitTimeBegin,
			String submitTimeEnd, String isFinish) throws Exception,
			RuntimeException;
	
	/**
	 * ��ȡӪ������Ϣ
	 * 
	 * @param mainCode
	 *            Ӫ����ҵ�����
	 * @param name
	 *            Ӫ��������
	 * @param applicant
	 *            �ύ��
	 * @param org
	 *            �ύ��֯
	 * @param submitTimeBegin
	 *            �ύ��ʼʱ��
	 * @param submitTimeEnd
	 *            �ύ����ʱ��
	 * @param isFinish
	 *            �Ƿ����
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainShowValue[] getSaleMainInfo(String selectType,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd,
			int startNum, int endNum) throws Exception,
			RuntimeException;

	/**
	 * ��ȡӪ������Ϣ����
	 * 
	 * @param mainCode
	 *            Ӫ����ҵ�����
	 * @param name
	 *            Ӫ��������
	 * @param applicant
	 *            �ύ��
	 * @param org
	 *            �ύ��֯
	 * @param submitTimeBegin
	 *            �ύ��ʼʱ��
	 * @param submitTimeEnd
	 *            �ύ����ʱ��
	 * @param isFinish
	 *            �Ƿ����
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getSaleMainInfoCount(String selectType,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd) throws Exception,
			RuntimeException;
}
