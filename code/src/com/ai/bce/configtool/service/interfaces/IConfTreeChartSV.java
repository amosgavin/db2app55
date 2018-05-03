package com.ai.bce.configtool.service.interfaces;


public interface IConfTreeChartSV {
	
	/**
	 * 根据BCD_FRAME_ID，获取树形html
	 * @param bceFrameId
	 * @return
	 * @throws Exception
	 */
	public String getBceFrameTreeHtml(long bceFrameId) throws Exception;
	 
	/**
	 * 根据页面框架树形结构
	 * @param pageFrameID
	 * @return
	 * @throws Exception
	 */
	public String getBcePageFrameTreeHtml(long pageFrameID) throws Exception;
	
	/**
	 * 获取页面框架与页面关系配置表树形结构
	 * @param pageFrameID
	 * @return
	 * @throws Exception
	 */
	public String getBcePageFrameAndPageTreeHtml(long PAGE_FRAME_PAGE_ID) throws Exception;
	
	/**
	 * 获取页面 
	 * @param pageID
	 * @return
	 * @throws Exception
	 */
	public String getBcePageTreeHtml(long pageID) throws Exception;
	

	/**
	 * 获取规则集
	 * @param rulesetId
	 * @return
	 * @throws Exception
	 */
	public String getBceRulesetTreeHtml(long rulesetId) throws Exception;
	
	/**
	 * 获取规则集与规则关系表
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public String getBceRulesetAndRuleTreeHtml(long rulesetId ,long ruleId,long relateId) throws Exception;
	

	/**
	 * 获取规则
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public String getBceRuleTreeHtml(long ruleId) throws Exception;
	
	
	/**
	 * 获取JAVA规则集与受理框架关系
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getJavaRuleNodeMap(long relateId) throws Exception;
	

	/**
	 * 获取页面框架与页面关系表——与特殊配置
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBceSpecialPageNodeMap(long BCE_FRAME_ID ,long  PAGE_FRAME_PAGE_ID) throws Exception;
	

	/**
	 * 获取页面框架与页面关系表——与角色  
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBcePageRoleNodeMap(long BCE_FRAME_ID ,long PAGE_FRAME_PAGE_ID ,
			long ROLE_ID) throws Exception;
	

	/**
	 * 获取页面框架与页面关系表——数据集关系表
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBcePageRowsetRelateNodeMap(long PAGE_FRAME_PAGE_ID ,long ROWSET_ID) throws Exception;
	

	/**
	 * 获取数据集 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBceDataset(long ROWSET_ID ) throws Exception;
	

	/**
	 * 获取所有模块
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getAllModule( ) throws Exception;
}
