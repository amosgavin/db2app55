package com.asiainfo.sale.common.service.interfaces;

import com.asiainfo.sale.common.bo.BOOperatorInfoBean;
import com.asiainfo.sale.common.bo.BOWFOperatorBean;
import com.asiainfo.sale.common.ivalues.IBOWFOperatorValue;

public interface IOperatorInfoSV {

	/**
	 * 根据组织机构编码获取其下操作员信息
	 * 
	 * @param orgId
	 *            组织机构编码
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public BOOperatorInfoBean[] getOperatorInfo(String staffName, String orgId, int startNum,
			int endNum) throws Exception, RuntimeException;

	/**
	 * 根据组织机构编码获取其下操作员信息
	 * 
	 * @param orgId
	 *            组织机构编码
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public int getCountByOrgId(String staffName, String orgId)
			throws Exception, RuntimeException;
	
	/**
	 * 根据角色、部门操作员信息
	 * 
	 * @param roleId
	 *            角色编码
	 * @param orgId
	 *            组织机构编码
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public BOWFOperatorBean[] getWFOperatorInfo(String staffName, String roleId, String orgId,
			int startNum, int endNum) throws Exception, RuntimeException;

	/**
	 * 根据角色、部门操作员数量信息
	 * 
	 * @param roleId
	 *            角色编码
	 * @param orgId
	 *            组织机构编码
	 * @return int
	 * @throws Exception
	 * @throws RemoteException
	 */
	public int getWFOperatorCountByOrgId(String staffName, String roleId, String orgId)
			throws Exception, RuntimeException;
	
	/**
	 * 根据操作员ID获取操作员信息
	 * 
	 * @param operatorId
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOWFOperatorValue getNameById(String id)
			throws Exception, RuntimeException;
}
