package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.ivalues.IBceRulesetValue;

/**
 * 规则集服务接口
 * @author linzhaoming
 *
 */
public interface IConfRulesetSV {

	/**
	 * 分页获取表格数据
	 * @param cond
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IBceRulesetValue[] getBceRulesetValues(String cond,int startIndex,int endIndex)throws Exception;
	
	/**
	 * 分页获取表格数据
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public int getBceRulesetValuesCount(String cond) throws Exception;
}
