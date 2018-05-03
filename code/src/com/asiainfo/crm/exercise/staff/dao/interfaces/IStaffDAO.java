package com.asiainfo.crm.exercise.staff.dao.interfaces;

import com.asiainfo.crm.exercise.staff.ivalues.IBOStaffValue;

public interface IStaffDAO {

	/**
	 * ������֯Id��ȡԱ������
	 * 
	 * @param organizeId
	 *            ��֯����Id
	 * @return int Ա������
	 */
	public int getStaffCountByOrgId(String organizeId) throws Exception;

	/**
	 * ����Ա�����Ż�ȡԱ������
	 * 
	 * @param staffId
	 *            Ա��Id
	 * @return int Ա������
	 */
	public int getStaffCountByStaffId(String staffId) throws Exception;
	
	/**
	 * ����Ա��������ȡԱ������
	 * 
	 * @param name
	 *            Ա������
	 * @return int Ա������
	 */
	public int getStaffCountByName(String name) throws Exception;

	/**
	 * ������֯ID��ѯԱ����Ϣ
	 * 
	 * @param organizeId
	 *            ��֯Id
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return IBOStaffValue[]
	 * @throws Exception
	 */
	public IBOStaffValue[] getStaffByOrgID(String organizeId, int startNum,
			int endNum) throws Exception;
	
	/**
	 * ����Ա��ID��ѯԱ����Ϣ
	 * 
	 * @param staffId
	 *            Ա��Id
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return IBOStaffValue[]
	 * @throws Exception
	 */
	public IBOStaffValue[] getStaffByStaffID(String staffId, int startNum,
			int endNum) throws Exception;

	/**
	 * ���ݿͻ�������ȡ�ͻ���Ϣ
	 * 
	 * @param name
	 *            Ա������
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return IBOStaffValue[]
	 * @throws Exception
	 */
	public IBOStaffValue[] getStaffByName(String name, int startNum, int endNum)
			throws Exception;

	/**
	 * ����ͻ���Ϣ
	 * 
	 * @param objIBOStaffVlue
	 *            Ա������
	 * @return string ִ�н��
	 * @throws Exception
	 */
	public void saveStaff(IBOStaffValue[] objIBOStaffValues) throws Exception;

	/**
	 * Idɾ��Ա��
	 * 
	 * @param objIBOStaffValues
	 *            Ա��
	 */
	public void delStaff(IBOStaffValue[] objIBOStaffValues) throws Exception;
}
