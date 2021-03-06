package com.asiainfo.sale.weapon.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleInfoValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponInfoValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponMainDeValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponMainValue;

public interface ISaleWeaponMainDAO {
	//更具武器主信息ID删除武器主信息
	public void delSaleWeaponMain(String mid)
	throws Exception, RuntimeException ;
	/**
	 * 保存武器订单信息
	 * 
	 * @param saleWeaponMainValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void saveSaleWeaponMain(IBOSaleWeaponMainValue[] saleWeaponMainValues)
			throws Exception;

	/**
	 * 根据订单编号查询武器订单信息
	 * 
	 * @param id
	 *            编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponMainValue[] getSaleWeaponMainById(String id,
			int startNum, int endNum) throws Exception;

	
	public IBOSaleWeaponMainValue[] getSaleWeaponMainById(String id) throws Exception;
	/**
	 * 根据订单编号查询武器订单条数
	 * 
	 * @param id
	 *            编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCountById(String id) throws Exception;

	/**
	 * 根据订单名称、申请人名称、组织机构查询武器订单信息
	 * 
	 * @param name
	 *            订单名称
	 * @param applicant
	 *            申请人名称
	 * @param org
	 *            组织机构查询武器订单信息
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponMainValue[] getSaleWeaponMain(String name,
			String applicant, String org, int startNum, int endNum)
			throws Exception;

	/**
	 * 根据订单名称、申请人名称、组织机构查询武器订单条数
	 * 
	 * @param name
	 *            订单名称
	 * @param applicant
	 *            申请人名称
	 * @param org
	 *            组织机构查询武器订单信息
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String name, String applicant, String org)
			throws Exception;

	/**
	 * 删除武器订单信息
	 * 
	 * @param saleWeaponMainValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void delSaleWeaponMain(IBOSaleWeaponMainValue[] saleWeaponMainValues)
			throws Exception;
	
	
	public IBOSaleWeaponInfoValue getSaleWeaponInfoValue(String id) throws Exception;
	
	/**
	 * 根据主ID查询主表详细信息
	 * */
	public IBOSaleWeaponMainDeValue[] getSaleWeaponMainDeById(String id) throws Exception;
}
