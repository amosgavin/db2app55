package com.asiainfo.sale.weapon.service.interfaces;

import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.sale.weapon.bo.BOWeaponTagRelaBean;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponSValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponSignOrAduitValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;

public interface ISaleWeaponSV {
	public int selectName(String name) throws Exception, RuntimeException;

	public void delWeaponTagRela(String wid, String saletype) throws Exception;

	/**
	 * 根据活动编号查询武器信息
	 * 
	 * @param activityId
	 *            活动编号
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponValue[] getSaleWeaponByActivityId(String activityId)
			throws Exception, RuntimeException;

	public int getSaleWeaponCountByActivityId(String activityId)
			throws Exception;

	public IBOPromationTagValue[] getSpareTagByActivityId(String activityId)
			throws Exception;

	public int getSpareTagCountByActivityId(String activityId) throws Exception;

	/**
	 * 根据编号查询武器信息
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
	public IBOSaleWeaponValue[] getSaleWeaponByID(String id, int startNum,
			int endNum) throws Exception, RuntimeException;

	public IBOSaleWeaponSValue getSaleWeaponSByID(String id, int startNum,
			int endNum) throws Exception, RuntimeException;

	/**
	 * 根据编号查询武器条数
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
	public int getCountByID(String id) throws Exception, RuntimeException;

	/**
	 * 根据订单编号查询武器信息
	 * 
	 * @param id
	 *            订单编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponValue[] getSaleWeaponByMainId(String mainId,
			int startNum, int endNum) throws Exception, RuntimeException;

	/**
	 * 根据订单编号查询武器条数
	 * 
	 * @param id
	 *            订单编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCountByMainId(String mainId) throws Exception,
			RuntimeException;

	/**
	 * 根据营销武器库名称、市场类型、返还月数、保底月数、保底额度、返还额度、 每月赠送、赠送月数、赠送额度、网龄、支付券面额、自有业务、货品采购目录
	 * 查询武器信息
	 * 
	 * @param weaponName
	 *            武器库名称
	 * @param marketType
	 *            市场类型
	 * @param backMonth
	 *            返还月数
	 * @param baseMonth
	 *            保底月数
	 * @param lLimit
	 *            保底额度
	 * @param bLimit
	 *            返还额度
	 * @param presentPermon
	 *            每月赠送
	 * @param presentMonth
	 *            赠送月数
	 * @param pLimit
	 *            赠送额度
	 * @param netAge
	 *            网龄
	 * @param couponsValue
	 *            支付券面额
	 * @param selfBusi
	 *            自有业务
	 * @param directory
	 *            货品采购目录
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponValue[] getSaleWeapon(String mid, String wwid,
			String wid, String name, String marketType, String backMonth,
			String baseMonth, String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age, int startNum, int endNum)
			throws Exception, RuntimeException;

	/**
	 * 根据营销武器库名称、市场类型、返还月数、保底月数、保底额度、返还额度、 每月赠送、赠送月数、赠送额度、网龄、支付券面额、自有业务、货品采购目录
	 * 查询武器信息
	 * 
	 * @param weaponName
	 *            武器库名称
	 * @param marketType
	 *            市场类型
	 * @param backMonth
	 *            返还月数
	 * @param baseMonth
	 *            保底月数
	 * @param lLimit
	 *            保底额度
	 * @param bLimit
	 *            返还额度
	 * @param presentPermon
	 *            每月赠送
	 * @param presentMonth
	 *            赠送月数
	 * @param pLimit
	 *            赠送额度
	 * @param netAge
	 *            网龄
	 * @param couponsValue
	 *            支付券面额
	 * @param selfBusi
	 *            自有业务
	 * @param directory
	 *            货品采购目录
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String mid, String wwid, String wid, String name,
			String marketType, String backMonth, String baseMonth,
			String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age) throws Exception,
			RuntimeException;

	/**
	 * 删除武器订单信息
	 * 
	 * @param saleWeaponMainValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void saveSaleWeapon(IBOSaleWeaponValue[] saleWeaponValues)
			throws Exception, RuntimeException;

	/**
	 * 审批会签
	 * 
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleWeaponSignOrAduitValue[] getSaleWeaponSignOrAduit(String wid,
			String taskTag, int startNum, int endNum) throws Exception,
			RuntimeException;

	public int getCountSignOrAduit(String wid, String taskTag)
			throws Exception, RuntimeException;

	public void saveWeaponTagRela(BOWeaponTagRelaBean weaponTagRelaBean)
			throws Exception;

	public IBOPromationTagValue[] getTagBeanByWeaponWid(String wid)
			throws Exception;

	public IBOPromationTagValue[] getSpareTagDetailByWeaponId(String weaponId)
			throws Exception;

	public void saveTagDetail(IBOPromationTagValue[] tagDetailValues, int pid)
			throws Exception;

	public IBOSaleWeaponSValue[] getSaleWeaponS(String wwid, String wid,
			String name, String marketType, String backMonth, String baseMonth,
			String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age, int startNum, int endNum)
			throws Exception;

	public IBOPromationTagValue[] getWaitTagsID() throws Exception;

	public BOWeaponTagRelaBean getWeaponTagRelaByWS(String wid, String saletype)
			throws Exception;

	public void changeWeaponState(String mainId, String state) throws Exception;

	// 根据weapon_id查询武器详细信息(武器一对多需求)
	public IBOSaleWeaponValue[] getSaleWeaponOnlyByID(String id)
			throws Exception, RuntimeException;

	// 根据mid查询武器详细信息（武器一对多需求）
	public IBOSaleWeaponValue[] getSaleWeaponOnlyByMID(String mid)
			throws Exception, RuntimeException;

	// 删除该武器工单的所有武器模板信息（武器一对多需求）
	public void delWeapons(IBOSaleWeaponValue[] saleWeaponValues)
			throws Exception, RuntimeException;

	// 判断是否需要省业支审核武器测试
	public boolean needWeaponTestAudit(String workflowId) throws Exception;
}
