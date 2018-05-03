package com.asiainfo.sale.tag.dao.interfaces;

import com.asiainfo.sale.tag.ivalues.IBOApplyTagValue;

public interface ITagMainDAO {

	public int saveTagMain(IBOApplyTagValue TagMainValues) throws Exception;

	/**
	 * 根据编号查询促销标签信息
	 * 
	 * @param id
	 *            编号
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOApplyTagValue getTagMainShowById(String id) throws Exception,
			RuntimeException;

	/**
	 * 根据促销标签编号查询营销活动信息
	 * 
	 * @param id
	 *            促销标签编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	// public IBOPromationTagValue[] getTagDetailByMainId(String mainId,
	// int startNum, int endNum) throws Exception;

	/**
	 * 根据促销标签编号查询营销活动信息
	 * 
	 * @param id
	 *            促销标签编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	// public int getCount(String mainId) throws Exception;
	/*
	 * 查询状态为使用的所有标签
	 */
	// public IBOPromationTagValue[] getTagDetailByState(String state, String
	// charge, int startNum, int endNum) throws Exception;
	/**
	 * 删除促销标签信息
	 * 
	 * @param TagDetailValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOApplyTagValue[] getMainTagShowByTaskTag(String taskTag) throws Exception;
	// public IBOPromationTagValue[] queryTagDetail(String charge, int startNum,
	// int endNum)throws Exception;

	// public int getTagDetailCount(String charge)throws Exception;

	// public IBOPromationTagValue[] getTagDetailInSpare(String charge, int
	// startNum, int endNum) throws Exception;

	// public int getTagInSpareCount(String charge) throws Exception;

	// public void delTagDetail(IBOPromationTagValue[] TagDetailValues)
	// throws Exception;
}
