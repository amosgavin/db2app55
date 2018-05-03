package com.asiainfo.crm.exercise.staff.service.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.crm.exercise.staff.ivalues.IBOOrganizeValue;

public interface IOrganizeSV {

	/**
	 * 删除组织
	 * 
	 * @param organizeId
	 *            组织机构Id
	 * @return int 组织机构数量
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void delOrganize(IBOOrganizeValue[] objIOrganizeVlue)
			throws RemoteException, Exception;

	/**
	 * 根据组织ID查询组织信息
	 * 
	 * @param organizeID
	 *            组织机构ID
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return IBOOrganizeValue[]
	 * @throws Exception
	 */
	public IBOOrganizeValue[] getOrganizeByOrgID(String organizeId,
			int startNum, int endNum) throws RemoteException, Exception;
	
	/**
	 * 根据归属组织ID查询组织信息
	 * 
	 * @param parentID
	 *            归属组织机构ID
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return IBOOrganizeValue[]
	 * @throws Exception
	 */
	public IBOOrganizeValue[] getOrganizeByPareintID(String parentID,
			int startNum, int endNum) throws RemoteException, Exception;

	/**
	 * 获取所有组织信息
	 * 
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return IBOOrganizeValue[]
	 * @throws Exception
	 */
	public IBOOrganizeValue[] getAllOrganize(int startNum, int endNum)
			throws RemoteException, Exception;

	/**
	 * 获取所有组织信息个数
	 * 
	 * @return int
	 * @throws Exception
	 */
	public int getAllOrganizeCount() throws RemoteException, Exception;

	/**
	 * 根据组织名称获取组织信息
	 * 
	 * @param name
	 *            组织机构名称
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return IBOOrganizeValue[]
	 * @throws Exception
	 */
	public IBOOrganizeValue[] getOrganizeByName(String name, int startNum,
			int endNum) throws RemoteException, Exception;

	/**
	 * 保存组织信息
	 * 
	 * @param objIBOStaffVlue
	 *            组织机构对象数组
	 * @return String 执行结果
	 * @throws Exception
	 */
	public void saveOrganize(IBOOrganizeValue[] objIBOOrganizeVlues)
			throws RemoteException, Exception;

}
