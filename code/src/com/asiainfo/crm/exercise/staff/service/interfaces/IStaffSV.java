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
	 * 根据组织Id获取员工数量
	 * 
	 * @param organizeId
	 *            组织机构Id
	 * @return int 员工数量
	 */
	public int getStaffCountByOrgId(String organizeId) throws RemoteException,
			Exception;

	/**
	 * 根据员工工号获取员工数量
	 * 
	 * @param staffId
	 *            员工Id
	 * @return int 员工数量
	 */
	public int getStaffCountByStaffId(String staffId) throws RemoteException,
			Exception;
	

	/**
	 * 根据员工姓名获取员工数量
	 * 
	 * @param staffId
	 *            员工Id
	 * @return int 员工数量
	 */
	public int getStaffCountByName(String name) throws RemoteException,
			Exception;

	/**
	 * 根据组织ID查询员工信息
	 * 
	 * @param organizeID
	 *            组织ID
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return IBOStaffValue[]
	 * @throws Exception
	 */
	public IBOStaffValue[] getStaffByStaffID(String staffID, int startNum,
			int endNum) throws RemoteException, Exception;

	/**
	 * 根据员工ID查询员工信息
	 * 
	 * @param staffID
	 *            员工ID
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return IBOStaffValue[]
	 * @throws Exception
	 */
	public IBOStaffValue[] getStaffByOrgID(String organizeID, int startNum,
			int endNum) throws RemoteException, Exception;
	

	/**
	 * 根据客户姓名获取客户信息
	 * 
	 * @param name
	 *            员工姓名
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return IBOStaffValue[]
	 * @throws Exception
	 */
	public IBOStaffValue[] getStaffByName(String name, int startNum, int endNum)
			throws RemoteException, Exception;

	/**
	 * 保存客户信息
	 * 
	 * @param objIBOStaffVlue
	 *            员工数组
	 * @return string 执行结果
	 * @throws Exception
	 */
	public void saveStaff(IBOStaffValue[] objIBOStaffVlue)
			throws RemoteException, Exception;

	/**
	 * 根据员工Id删除员工
	 * 
	 * @param sraffId
	 *            员工Id
	 */
	public void delStaff(IBOStaffValue[] objIBOStaffValues)
			throws RemoteException, Exception;
}
