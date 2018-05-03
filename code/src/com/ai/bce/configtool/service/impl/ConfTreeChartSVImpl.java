package com.ai.bce.configtool.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.bce.configtool.dao.interfaces.IConfTreeChartDAO;
import com.ai.bce.configtool.service.interfaces.IConfTreeChartSV;
import com.ai.bce.util.BServiceFactory;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.valuebean.chartnode.ChartNode;

/**
 * 获取每个类型树形结构的HTML代码
 * @author akuei
 *
 */
public class ConfTreeChartSVImpl implements IConfTreeChartSV {

	/**
	 * 获取受理主框架 树形结构
	 * @param bceFrameId
	 * @return
	 * @throws Exception
	 */
	public String getBceFrameTreeHtml(long bceFrameId) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		
		Map nodeMap = dao.getBceFrameNodeMap(bceFrameId);
		
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,  LocaleResourceFactory.getResource("BES0000538") ,
				LocaleResourceFactory.getResource("BES0000585",new String[]{bceFrameId+""}) );
	}

	/**
	 * 获取页面框架树形结构
	 * @param pageFrameID
	 * @return
	 * @throws Exception
	 */
	public String getBcePageFrameTreeHtml(long pageFrameID) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("PAGE_FRAME_ID", ""+pageFrameID);
		Map nodeMap = dao.getBcePageFrameNodeMap("PAGE_FRAME_ID= :PAGE_FRAME_ID ", parameter ,true);
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000539")  ,
				LocaleResourceFactory.getResource("BES0000586",new String[]{""+pageFrameID}) );
	}
	
	/**
	 * 获取页面框架与页面关系配置表树形结构
	 * @param pageFrameID
	 * @return
	 * @throws Exception
	 */
	public String getBcePageFrameAndPageTreeHtml(long PAGE_FRAME_PAGE_ID) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("PAGE_FRAME_PAGE_ID", ""+PAGE_FRAME_PAGE_ID);
		Map nodeMap = dao.getBcePageFrameAndPageNodeMap("PAGE_FRAME_PAGE_ID= :PAGE_FRAME_PAGE_ID ", 
				parameter);
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000540") ,
				LocaleResourceFactory.getResource("BES0000587",new String[]{PAGE_FRAME_PAGE_ID+""}) );
	}
	 

	/**
	 * 获取页面 
	 * @param pageID
	 * @return
	 * @throws Exception
	 */
	public String getBcePageTreeHtml(long pageID) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("PAGE_ID", ""+pageID);
		Map nodeMap = dao.getBcePageNodeMap("PAGE_ID= :PAGE_ID ", parameter);
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000541") ,
				LocaleResourceFactory.getResource("BES0000588",new String[]{""+pageID}) );
	}
	 

	/**
	 * 获取规则集
	 * @param rulesetId
	 * @return
	 * @throws Exception
	 */
	public String getBceRulesetTreeHtml(long rulesetId) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("RULESET_ID", ""+rulesetId);
		Map nodeMap = dao.getBceRuleSet("RULESET_ID= :RULESET_ID ", parameter);
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000542") ,
				LocaleResourceFactory.getResource("BES0000589",new String[]{""+rulesetId}) );
	}

	/**
	 * 获取规则集与规则关系表
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public String getBceRulesetAndRuleTreeHtml(long rulesetId ,long ruleId,long relateId) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("RELATE_ID", ""+relateId);
		Map nodeMap = dao.getBceRuleSetAndRule("RELATE_ID= :RELATE_ID ", parameter);
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000543"),
				LocaleResourceFactory.getResource("BES0000591",new String[]{""+ruleId ,""+rulesetId}));
	}

	/**
	 * 获取规则
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public String getBceRuleTreeHtml(long ruleId) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("RULE_ID", ""+ruleId);
		Map nodeMap = dao.getBceRule("RULE_ID= :RULE_ID ", parameter);
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000544") ,
				LocaleResourceFactory.getResource("BES0000592",new String[]{""+ruleId}));
	}
	
	/**
	 * 获取JAVA规则集与受理框架关系
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getJavaRuleNodeMap(long relateId) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("RELATE_ID", ""+relateId);
		Map nodeMap = dao.getJavaRuleNodeMap("RELATE_ID= :RELATE_ID ", parameter);
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000545"),
				LocaleResourceFactory.getResource("BES0000593",new String[]{""+relateId}) );
	}
	

	/**
	 * 获取页面框架与页面关系表——与特殊配置
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBceSpecialPageNodeMap(long BCE_FRAME_ID ,long  PAGE_FRAME_PAGE_ID) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("BCE_FRAME_ID", ""+BCE_FRAME_ID);
		parameter.put("PAGE_FRAME_PAGE_ID", ""+PAGE_FRAME_PAGE_ID);
		Map nodeMap = dao.getBceSpecialPageNodeMap(
				"BCE_FRAME_ID= :BCE_FRAME_ID and PAGE_FRAME_PAGE_ID= :PAGE_FRAME_PAGE_ID ", parameter);
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000546") 
				,LocaleResourceFactory.getResource("BES0000594",new String[]{""+BCE_FRAME_ID,""+PAGE_FRAME_PAGE_ID}));
	
	}

	/**
	 * 获取页面框架与页面关系表——与角色  
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBcePageRoleNodeMap(long BCE_FRAME_ID ,long PAGE_FRAME_PAGE_ID ,
			long ROLE_ID) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("BCE_FRAME_ID", ""+BCE_FRAME_ID);
		parameter.put("PAGE_FRAME_PAGE_ID", ""+PAGE_FRAME_PAGE_ID);
		parameter.put("ROLE_ID", ""+ROLE_ID);
		Map nodeMap = dao.getBcePageRoleNodeMap(
				"BCE_FRAME_ID= :BCE_FRAME_ID and PAGE_FRAME_PAGE_ID= :PAGE_FRAME_PAGE_ID and ROLE_ID= :ROLE_ID ", parameter);
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000547") ,
				LocaleResourceFactory.getResource("BES0000595",new String[]{""+BCE_FRAME_ID ,
						""+PAGE_FRAME_PAGE_ID,""+ROLE_ID}));
	
	}
	

	/**
	 * 获取页面框架与页面关系表——数据集关系表
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBcePageRowsetRelateNodeMap(long PAGE_FRAME_PAGE_ID ,long ROWSET_ID) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("PAGE_FRAME_PAGE_ID", ""+PAGE_FRAME_PAGE_ID);
		parameter.put("ROWSET_ID", ""+ROWSET_ID);
		Map nodeMap = dao.getBcePageRowsetRelateNodeMap(
				"PAGE_FRAME_PAGE_ID= :PAGE_FRAME_PAGE_ID and ROWSET_ID= :ROWSET_ID ", parameter);
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000548")  ,
				LocaleResourceFactory.getResource("BES0000596",new String[]{""+PAGE_FRAME_PAGE_ID
						,""+ROWSET_ID}) );
	
	}
	

	/**
	 * 获取数据集 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBceDataset(long ROWSET_ID ) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("ROWSET_ID", ""+ROWSET_ID);
		Map nodeMap = dao.getBceDataset("ROWSET_ID= :ROWSET_ID ", parameter);
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000549")  ,
				LocaleResourceFactory.getResource("BES0000597",new String[]{""+ROWSET_ID}) );
	
	}
	

	/**
	 * 获取所有模块
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getAllModule( ) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		 
		Map nodeMap = dao.getAllModule();
		
		//根据节点返回XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000550")  ,
				LocaleResourceFactory.getResource("BES0000550") );
	}
	 
	
	
	/**
	 * 根据节点map，返回html 语句
	 * @param nodeMap
	 * @param multiNodeHit 当有多个节点的时候，构造一个总节点的名称
	 * @param whenErrHit 当没有节点的时候报错信息
	 * @return
	 */
	private String getStringByNodeMap(Map nodeMap ,String multiNodeHit ,String whenErrHit){
		ChartNode rootNode = null; 
		
		//当没有返回节点的时候
		if(nodeMap == null || nodeMap.size() ==0){
			rootNode = new ChartNode();
			rootNode.setId("empty");
			rootNode.setName(whenErrHit);
		}
		//当只有一个节点的时候
		else if(nodeMap.size() == 1){
			ChartNode chartNodes[] =(ChartNode[]) nodeMap.values().toArray(new ChartNode[1]);
			rootNode = chartNodes[0]; 
		}
		//如果有多个节点
		else{
			rootNode = new ChartNode();
			rootNode.setId("rootlist");
			rootNode.setName(multiNodeHit);
			
			ChartNode chartNodes[] =(ChartNode[]) nodeMap.values().toArray(new ChartNode[1]);
			for(int i=0;i<chartNodes.length;i++){
				rootNode.addChidNode((ChartNode)chartNodes[i]);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		rootNode.toString(sb ,"" ,0);
		
		String rootNodeKey = "_0_" + rootNode.getId() ;
		if(rootNode.getSecondId() != null && rootNode.getSecondId().equals("") ==false){
			rootNodeKey = rootNodeKey + "_" + rootNode.getSecondId();
		}
		sb.append("\n var OrgShows=new OrgShow(" + rootNodeKey + ");");
		return sb.toString();
	}
}
