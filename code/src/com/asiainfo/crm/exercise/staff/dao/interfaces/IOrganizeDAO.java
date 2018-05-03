package com.asiainfo.crm.exercise.staff.dao.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.crm.exercise.staff.ivalues.IBOOrganizeValue;

public interface IOrganizeDAO {

	/**
	 * ɾ����֯
	 * 
	 * @param objIBOOrganizeValues
	 *            ��֯����
	 * @return int ��֯��������
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void delOrganize(IBOOrganizeValue[] objIBOOrganizeValues)
			throws Exception;

	/**
	 * ��ȡ������֯��Ϣ
	 *
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return IBOOrganizeValue[]
	 * @throws Exception
	 */
	public IBOOrganizeValue[] getAllOrganize(int startNum, int endNum)
			throws Exception;
	
	/**
	 * ��ȡ������֯��Ϣ����
	 * 
	 * @return int
	 * @throws Exception
	 */
	public int getAllOrganizeCount() throws Exception;
	
	/**
	 * ������֯ID��ѯ��֯��Ϣ
	 * 
	 * @param organizeID
	 *            ��֯����ID
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return IBOOrganizeValue[]
	 * @throws Exception
	 */
	public IBOOrganizeValue[] getOrganizeByOrgID(String organizeId,
			int startNum, int endNum) throws Exception;

	/**
	 * ���ݹ�����֯ID��ѯ��֯��Ϣ
	 * 
	 * @param parentID
	 *            ������֯����ID
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return IBOOrganizeValue[]
	 * @throws Exception
	 */
	public IBOOrganizeValue[] getOrganizeByPareintID(String parentID,
			int startNum, int endNum) throws Exception;
	
	/**
	 * ������֯���ƻ�ȡ��֯��Ϣ
	 * 
	 * @param name
	 *            ��֯��������
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return IBOOrganizeValue[]
	 * @throws Exception
	 */
	public IBOOrganizeValue[] getOrganizeByName(String name, int startNum,
			int endNum) throws Exception;

	/**
	 * ������֯��Ϣ
	 * 
	 * @param objIBOStaffVlue
	 *            ��֯������������
	 * @return String ִ�н��
	 * @throws Exception
	 */
	public void saveOrganize(IBOOrganizeValue[] objIBOOrganizeVlues)
			throws Exception;
}
