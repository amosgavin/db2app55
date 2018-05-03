package com.asiainfo.sale.common.service.interfaces;

import com.asiainfo.sale.common.bo.BOOperatorInfoBean;
import com.asiainfo.sale.common.bo.BOWFOperatorBean;
import com.asiainfo.sale.common.ivalues.IBOWFOperatorValue;

public interface IOperatorInfoSV {

	/**
	 * ������֯���������ȡ���²���Ա��Ϣ
	 * 
	 * @param orgId
	 *            ��֯��������
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public BOOperatorInfoBean[] getOperatorInfo(String staffName, String orgId, int startNum,
			int endNum) throws Exception, RuntimeException;

	/**
	 * ������֯���������ȡ���²���Ա��Ϣ
	 * 
	 * @param orgId
	 *            ��֯��������
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public int getCountByOrgId(String staffName, String orgId)
			throws Exception, RuntimeException;
	
	/**
	 * ���ݽ�ɫ�����Ų���Ա��Ϣ
	 * 
	 * @param roleId
	 *            ��ɫ����
	 * @param orgId
	 *            ��֯��������
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public BOWFOperatorBean[] getWFOperatorInfo(String staffName, String roleId, String orgId,
			int startNum, int endNum) throws Exception, RuntimeException;

	/**
	 * ���ݽ�ɫ�����Ų���Ա������Ϣ
	 * 
	 * @param roleId
	 *            ��ɫ����
	 * @param orgId
	 *            ��֯��������
	 * @return int
	 * @throws Exception
	 * @throws RemoteException
	 */
	public int getWFOperatorCountByOrgId(String staffName, String roleId, String orgId)
			throws Exception, RuntimeException;
	
	/**
	 * ���ݲ���ԱID��ȡ����Ա��Ϣ
	 * 
	 * @param operatorId
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOWFOperatorValue getNameById(String id)
			throws Exception, RuntimeException;
}
