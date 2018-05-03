package com.asiainfo.sale.activity.dao.interfaces;

import java.util.List;

import com.asiainfo.sale.activity.ivalues.IBOSaleInfoValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainShowValue;

public interface ISaleMainShowDAO {

	/**
	 * 根据订单编号查询营销案整体（包括主信息和档次信息）信息
	 * 
	 * @param id
	 *            编号
	 * 
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleInfoValue getSaleInfoValue(String id) throws Exception;

	/**
	 * 根据订单编号查询营销案信息
	 * 
	 * @param id
	 *            编号
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainShowValue getSaleMainShowById(String id) throws Exception;

	/**
	 * 根据订单编号查询预览营销案信息
	 * 
	 * @param id
	 *            编号
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainShowValue[] getSaleMainOverviewById(String id)
			throws Exception;

	/**
	 * 根据营销案名称、申请人名称、组织机构查询营销案信息
	 * 
	 * @param name
	 *            营销案名称
	 * @param applicant
	 *            申请人名称
	 * @param org
	 *            组织机构
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainShowValue[] getSaleMainShow(String name,
			String applicant, String org, int startNum, int endNum)
			throws Exception;

	/**
	 * 根据营销案名称、申请人名称、组织机构查询营销案条数
	 * 
	 * @param name
	 *            营销案名称
	 * @param applicant
	 *            申请人名称
	 * @param org
	 *            组织机构
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
	 * 获取营销案信息
	 * 
	 * @param mainCode
	 *            营销案业务编码
	 * @param name
	 *            营销案名称
	 * @param applicant
	 *            提交人
	 * @param org
	 *            提交组织
	 * @param submitTimeBegin
	 *            提交开始时间
	 * @param submitTimeEnd
	 *            提交结束时间
	 * @param isFinish
	 *            是否完结
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainShowValue[] getSaleMainAndFWInfo(String selectType,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd, String isFinish,
			int startNum, int endNum) throws Exception;

	/**
	 * 获取营销案信息条数
	 * 
	 * @param mainCode
	 *            营销案业务编码
	 * @param name
	 *            营销案名称
	 * @param applicant
	 *            提交人
	 * @param org
	 *            提交组织
	 * @param submitTimeBegin
	 *            提交开始时间
	 * @param submitTimeEnd
	 *            提交结束时间
	 * @param isFinish
	 *            是否完结
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String selectType, String mainCode, String name,
			String applicant, String org, String submitTimeBegin,
			String submitTimeEnd, String isFinish) throws Exception;

	/**
	 * 获取营销案信息
	 * 
	 * @param mainCode
	 *            营销案业务编码
	 * @param name
	 *            营销案名称
	 * @param applicant
	 *            提交人
	 * @param org
	 *            提交组织
	 * @param submitTimeBegin
	 *            提交开始时间
	 * @param submitTimeEnd
	 *            提交结束时间
	 * @param isFinish
	 *            是否完结
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainShowValue[] getSaleMainAndFWInfo(List<String> wfList,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd, int startNum,
			int endNum) throws Exception;

	/**
	 * 获取营销案信息条数
	 * 
	 * @param mainCode
	 *            营销案业务编码
	 * @param name
	 *            营销案名称
	 * @param applicant
	 *            提交人
	 * @param org
	 *            提交组织
	 * @param submitTimeBegin
	 *            提交开始时间
	 * @param submitTimeEnd
	 *            提交结束时间
	 * @param isFinish
	 *            是否完结
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(List<String> wfList, String mainCode, String name,
			String applicant, String org, String submitTimeBegin,
			String submitTimeEnd) throws Exception;
	
	/**
	 * 获取营销案信息
	 * 
	 * @param mainCode
	 *            营销案业务编码
	 * @param name
	 *            营销案名称
	 * @param applicant
	 *            提交人
	 * @param org
	 *            提交组织
	 * @param submitTimeBegin
	 *            提交开始时间
	 * @param submitTimeEnd
	 *            提交结束时间
	 * @param isFinish
	 *            是否完结
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainShowValue[] getSaleMainInfo(String selectType,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd,
			int startNum, int endNum) throws Exception;

	/**
	 * 获取营销案信息条数
	 * 
	 * @param mainCode
	 *            营销案业务编码
	 * @param name
	 *            营销案名称
	 * @param applicant
	 *            提交人
	 * @param org
	 *            提交组织
	 * @param submitTimeBegin
	 *            提交开始时间
	 * @param submitTimeEnd
	 *            提交结束时间
	 * @param isFinish
	 *            是否完结
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getSaleMainInfoCount(String selectType,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd) throws Exception;
}
