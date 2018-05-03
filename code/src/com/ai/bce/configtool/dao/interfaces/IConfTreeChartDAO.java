package com.ai.bce.configtool.dao.interfaces;

import java.util.Map;

public interface IConfTreeChartDAO {

	/**
	 * 获取受理主框架
	 * @param bceFrameId  
	 * @return
	 * @throws Exception
	 */
	public Map getBceFrameNodeMap(long bceFrameId ) throws Exception;
	/**
	 * 获取JAVA规则集与受理框架关系
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getJavaRuleNodeMap(String condition ,Map parameter) throws Exception;
	

	/**
	 * 获取页面框架与页面关系表——与特殊配置
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceSpecialPageNodeMap(String condition ,Map parameter) throws Exception;

	/**
	 * 获取页面框架与页面关系表——与角色  
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageRoleNodeMap(String condition ,Map parameter) throws Exception;
	

	/**
	 * 获取页面框架与页面关系表——数据集关系表
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageRowsetRelateNodeMap(String condition ,Map parameter) throws Exception;
	

	/**
	 * 获取数据集 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceDataset(String condition ,Map parameter) throws Exception;
	/**
	 * 获取页面框架
	 * @param condition
	 * @param parameter
	 * @param isIncludePageFrameAndPageNode 是否页面框架与页面关系子节点
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageFrameNodeMap(String condition ,Map parameter,
			boolean isIncludePageFrameAndPageNode) throws Exception;
	

	/**
	 * 获取页面框架与页面关系配置表
	 * @param condition
	 * @param parameter
	 * @param isIncludePageFrameNode 是否包含 页面框架节点
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageFrameAndPageNodeMap(String condition ,Map parameter ) throws Exception;
	

	/**
	 * 获取页面
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageNodeMap(String condition ,Map parameter) throws Exception;
	

	/**
	 * 获取规则集
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceRuleSet(String condition ,Map parameter) throws Exception;
	

	/**
	 * 获取规则集与规则关系表
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceRuleSetAndRule(String condition ,Map parameter) throws Exception;
	
	
	/**
	 * 获取规则 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceRule(String condition ,Map parameter) throws Exception;
	

	/**
	 * 获取所有模块
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getAllModule( ) throws Exception;
}
