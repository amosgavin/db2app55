package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.ivalues.IBceSimpleFuncFieldMappingValue;
import com.ai.bce.ivalues.IBceSimpleFuncValue;

/**
 * 单点功能的服务接口
 * 
 * @author linzhaoming
 *
 */
public interface IConfSimpleFuncSV {
	
	/**
	 * 获取单点功能配置表格数据
	 * @param cond
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IBceSimpleFuncValue[] getSimpleFuncValues(String cond, int startIndex,
			int endIndex) throws Exception;

	/**
	 * 获取单点功能配置表格数据
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public int getSimpleFuncValuesCount(String cond) throws Exception;

	/**
	 * 获取单点功能字段映射配置表格数据
	 * @param cond
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IBceSimpleFuncFieldMappingValue[] getSimpleFuncFieldMappingValues(
			String cond, int startIndex, int endIndex) throws Exception;

	/**
	 * 获取单点功能字段映射配置表格数据
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public int getSimpleFuncFieldMappingCount(String cond) throws Exception;
}
