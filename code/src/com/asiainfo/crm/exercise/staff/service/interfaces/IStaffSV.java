package com.asiainfo.crm.exercise.staff.service.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.crm.exercise.staff.ivalues.IBOOrganizeValue;
import com.asiainfo.crm.exercise.staff.ivalues.IBOStaffValue;

/**
 * @author zhin
 * 
 */
public interface IStaffSV {

	/**
	 * ������֯Id��ȡԱ������
	 * 
	 * @param organizeId
	 *            ��֯����Id
	 * @return int Ա������
	 */
	public int getStaffCountByOrgId(String organizeId) throws RemoteException,
			Exception;

	/**
	 * ����Ա�����Ż�ȡԱ������
	 * 
	 * @param staffId
	 *            Ա��Id
	 * @return int Ա������
	 */
	public int getStaffCountByStaffId(String staffId) throws RemoteException,
			Exception;
	

	/**
	 * ����Ա��������ȡԱ������
	 * 
	 * @param staffId
	 *            Ա��Id
	 * @return int Ա������
	 */
	public int getStaffCountByName(String name) throws RemoteException,
			Exception;

	/**
	 * ������֯ID��ѯԱ����Ϣ
	 * 
	 * @param organizeID
	 *            ��֯ID
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return IBOStaffValue[]
	 * @throws Exception
	 */
	public IBOStaffValue[] getStaffByStaffID(String staffID, int startNum,
			int endNum) throws RemoteException, Exception;

	/**
	 * ����Ա��ID��ѯԱ����Ϣ
	 * 
	 * @param staffID
	 *            Ա��ID
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return IBOStaffValue[]
	 * @throws Exception
	 */
	public IBOStaffValue[] getStaffByOrgID(String organizeID, int startNum,
			int endNum) throws RemoteException, Exception;
	

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
			throws RemoteException, Exception;

	/**
	 * ����ͻ���Ϣ
	 * 
	 * @param objIBOStaffVlue
	 *            Ա������
	 * @return string ִ�н��
	 * @throws Exception
	 */
	public void saveStaff(IBOStaffValue[] objIBOStaffVlue)
			throws RemoteException, Exception;

	/**
	 * ����Ա��Idɾ��Ա��
	 * 
	 * @param sraffId
	 *            Ա��Id
	 */
	public void delStaff(IBOStaffValue[] objIBOStaffValues)
			throws RemoteException, Exception;
}
