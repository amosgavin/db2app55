package com.ai.bce.configtool.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.bo.DataContainer;
import com.ai.bce.bo.BceFrameBean;
import com.ai.bce.bo.BceFrameEngine;
import com.ai.bce.bo.BceFrameJavaRulesetRelBean;
import com.ai.bce.bo.BceFrameJavaRulesetRelEngine;
import com.ai.bce.bo.BceFramePageRoleBean;
import com.ai.bce.bo.BceFramePageRoleEngine;
import com.ai.bce.bo.BceFrameSpecialPageBean;
import com.ai.bce.bo.BceModuleBean;
import com.ai.bce.bo.BceModuleEngine;
import com.ai.bce.bo.BcePageBean;
import com.ai.bce.bo.BcePageEngine;
import com.ai.bce.bo.BcePageFrameBean;
import com.ai.bce.bo.BcePageFrameEngine;
import com.ai.bce.bo.BceFrameSpecialPageEngine;
import com.ai.bce.bo.BcePageFramePageBean;
import com.ai.bce.bo.BcePageFramePageEngine;
import com.ai.bce.bo.BcePageRowsetRelBean;
import com.ai.bce.bo.BcePageRowsetRelEngine;
import com.ai.bce.bo.BceRowsetBean;
import com.ai.bce.bo.BceRowsetEngine;
import com.ai.bce.bo.BceRuleBean;
import com.ai.bce.bo.BceRuleEngine;
import com.ai.bce.bo.BceRulesetBean;
import com.ai.bce.bo.BceRulesetEngine;
import com.ai.bce.bo.BceRulesetRuleBean;
import com.ai.bce.bo.BceRulesetRuleEngine;
import com.ai.bce.configtool.dao.interfaces.IConfTreeChartDAO;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.valuebean.chartnode.ChartNode;


public class ConfTreeChartDAOImpl implements IConfTreeChartDAO {
	
	private static ThreadLocal BCE_FRAME_ID = new ThreadLocal();
	
	/**
	 * 获取受理主框架
	 * @param bceFrameId  
	 * @return
	 * @throws Exception
	 */
	public Map getBceFrameNodeMap(long bceFrameId ) throws Exception{
		//根据查询条件，获取BCEFRAME为主节点的数据		
		BceFrameBean bean = BceFrameEngine.getBean(bceFrameId);
		if(bean == null ||bean.isNew()){
			return null;
		}
		
		HashMap bceFrameMap = new HashMap();

		//构造受理主框架节点
		ChartNode parentNode = new ChartNode();
		parentNode.setId(bean.getBceFrameId() +"");
		parentNode.setName(LocaleResourceFactory.getResource("BES0000584") + "<br>" +bean.getRemarks());
		parentNode.setNodeType("BCE_FRAME");
		parentNode.setState(bean.getState()+"");
		parentNode.setLink("BCE_FRAME_ID="+bean.getBceFrameId()+ 
					"&bcePageFrameId=" + bean.getPageFrameId() + 
					"&workflowCode=" + bean.getWorkflowCode());


		parentNode.setShowTip(getTipsFromBean(bean));
		
		HashMap parameter = new HashMap();
		parameter.put("BCE_FRAME_ID", ""+bceFrameId);
		parameter.put("PAGE_FRAME_ID", ""+bean.getPageFrameId());
		
		//加载受理框架子节点 
		try {
			//在线程变量中存放bce_frame_id，主要是供后续查看 页面框架特殊配置和产品角色时使用
			BCE_FRAME_ID.set(bceFrameId+"");
			
			//获取受理框架下挂的页面框架数据 
			String searchPageFrameCond = "PAGE_FRAME_ID = :PAGE_FRAME_ID ";
			Map  pageFrameMap = getBcePageFrameNodeMap(searchPageFrameCond ,parameter  ,true);
			if(pageFrameMap != null){
				ChartNode childNode = (ChartNode) pageFrameMap.get(bean.getPageFrameId()+"");
					
				if(childNode != null){
					parentNode.addChidNode(childNode);
				}
			}
		} finally {
			//清空bce_frame_id
			BCE_FRAME_ID.set(null);
		}
		 
		 
		//获取受理框架下挂的java规则集数据 
		String searchJavaRuleCond = "BCE_FRAME_ID = :BCE_FRAME_ID ";
		Map pageJavaRuleMap = getJavaRuleNodeMap( searchJavaRuleCond ,parameter);
		if(pageJavaRuleMap != null){
			//如果有多个JAVA规则集，则建一个虚拟的节点，纯粹为了美观
			ChartNode virtualNode = parentNode;
			if(pageJavaRuleMap.size()>1){
				virtualNode = new ChartNode();
				virtualNode.setId("javaruleset_vir");
				virtualNode.setName(LocaleResourceFactory.getResource("BES0000571") );
				parentNode.addChidNode(virtualNode);
			}
			
			ChartNode childNodes[] = (ChartNode[]) pageJavaRuleMap.values().toArray(new ChartNode[0]);
			for(int i=0; i<childNodes.length ;i++){ 				
				virtualNode.addChidNode(childNodes[i]);
			}
		}
		 

		bceFrameMap.put(parentNode.getId(), parentNode);
		return bceFrameMap;
	}
	

	/**
	 * 获取JAVA规则集与受理框架关系
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getJavaRuleNodeMap(String condition ,Map parameter) throws Exception{
		BceFrameJavaRulesetRelBean  beans[]= BceFrameJavaRulesetRelEngine.getBeans(condition, parameter);
		if(beans == null || beans.length ==0){
			return null;
		}
		
		HashMap pageNodeMap = new HashMap();

		//获取功能点包含的规则集
		String searchRulesetCond = "RULESET_ID in (";
		
		//构造所有的功能点与JAVA规则集关系节点
		for(int i=0;i<beans.length;i++){
			ChartNode node = new ChartNode();
			node.setId(beans[i].getRelateId() +""); 
			node.setParentId(beans[i].getBceFrameId()+"");
			node.setName(LocaleResourceFactory.getResource("BES0000572") + "<br>"
					+beans[i].getBceFrameId() + "," + beans[i].getRulesetId() );
			node.setNodeType("BCE_FRAME_JAVA_RULESET_REL");
			node.setState(beans[i].getState()+"");
			node.setShowTip(getTipsFromBean(beans[i]));
			node.setLink("RELATE_ID="+beans[i].getRelateId()+"&BCE_FRAME_ID="+beans[i].getBceFrameId()+"&RULESET_ID="+beans[i].getRulesetId());
			
			pageNodeMap.put(node.getId(), node);

			if(i == 0){
				searchRulesetCond = searchRulesetCond +"'" + beans[i].getRulesetId() + "'";
			}else{
				searchRulesetCond = searchRulesetCond +",'" + beans[i].getRulesetId() + "'";
			}
		}
		
		searchRulesetCond = searchRulesetCond + ")";
		
		Map rulesetMap = getBceRuleSet(searchRulesetCond ,null);


		// 功能点与JAVA规则集——规则集
		if(rulesetMap != null){
			for(int i=0;i<beans.length;i++){
				ChartNode parentNode = (ChartNode) pageNodeMap.get(beans[i].getRelateId()+"");
				ChartNode childNode = (ChartNode) rulesetMap.get(beans[i].getRulesetId()+"");
				
				if(parentNode != null && childNode != null){
					parentNode.addChidNode(childNode);
				}
			}
		}
		
		return pageNodeMap;
	}
	
	/**
	 * 获取页面框架
	 * @param condition
	 * @param parameter 
	 * @param isIncludePageFrameAndPageNode 是否页面框架与页面关系子节点
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageFrameNodeMap(String condition ,Map parameter,
			boolean isIncludePageFrameAndPageNode) throws Exception{
		//根据查询条件，获取BCEFRAMEPAGE为主节点的数据
		BcePageFrameBean beans[]= BcePageFrameEngine.getBeans(condition, parameter);
		if(beans == null || beans.length ==0){
			return null;
		}
		
		HashMap pageFrameMap = new HashMap();

		//获取页面框架也页面关系数据
		String searchPageFrameAndPageCond = "PAGE_FRAME_ID in (";
		
		//构造所有的页面框架节点
		for(int i=0;i<beans.length;i++){
			ChartNode node = new ChartNode();
			node.setId(beans[i].getPageFrameId() +"");
			node.setName(LocaleResourceFactory.getResource("BES0000573") + "<br>" +beans[i].getPageFrameName());
			node.setNodeType("BCE_PAGE_FRAME");
			node.setState(beans[i].getState()+"");
			node.setShowTip(getTipsFromBean(beans[i]));
			node.setLink("bcePageFrameId=" + beans[i].getPageFrameId());
			
			pageFrameMap.put(node.getId(), node);
			
			if(i ==0){
				searchPageFrameAndPageCond = searchPageFrameAndPageCond +"'" + beans[i].getPageFrameId() + "'";
			}else{
				searchPageFrameAndPageCond = searchPageFrameAndPageCond +",'" + beans[i].getPageFrameId() + "'";
			}
		}
		searchPageFrameAndPageCond = searchPageFrameAndPageCond + ")";
		
		//获取页面框架下的 页面框架与页面关系表
		if(isIncludePageFrameAndPageNode == true){
			Map pageFrameAndPageMap = getBcePageFrameAndPageNodeMap( searchPageFrameAndPageCond ,null);
			if(pageFrameAndPageMap != null){
				ChartNode childNodes[] = (ChartNode[]) pageFrameAndPageMap.values().toArray(new ChartNode[0]);
				for(int i=0; i<childNodes.length ;i++){
					ChartNode parentNode = (ChartNode) pageFrameMap.get(childNodes[i].getParentId());
					
					if(parentNode != null ){
						parentNode.addChidNode(childNodes[i]);
					}
				}
			}
		}
		
		return pageFrameMap;
	}
	
	

	/**
	 * 获取页面框架与页面关系配置表
	 * @param condition
	 * @param parameter 
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageFrameAndPageNodeMap(String condition ,Map parameter ) throws Exception{
		BcePageFramePageBean beans[]= BcePageFramePageEngine.getBeans(condition, parameter);
		if(beans == null || beans.length ==0){
			return null;
		}

		//获取当前父亲节点是否有bceFrameId
		String bceFrameId = (String)BCE_FRAME_ID.get();
		
		HashMap pageFrameAndPageMap = new HashMap();

		//获取包含的页面
		String searchPageCond = "PAGE_ID in (";
		//获取包含的页面框架也数据集集关系 
		String searchRowsetRelatCond = "PAGE_FRAME_PAGE_ID in (";
		
		//获取关联的页面框架
		String searchPageFrameCond = "PAGE_FRAME_ID in (";
		
		//构造所有的页面框架和页面节点
		for(int i=0;i<beans.length;i++){
			ChartNode node = new ChartNode();
			node.setId(beans[i].getPageFramePageId() +"");
			node.setParentId(beans[i].getPageFrameId() + "");
			node.setName(LocaleResourceFactory.getResource("BES0000574") + "<br>"+beans[i].getPageTitle());
			node.setNodeType("BCE_PAGE_FRAME_PAGE");
			node.setState(beans[i].getState()+"");
			node.setShowTip(getTipsFromBean(beans[i]));
			if(bceFrameId != null)
			  node.setLink("pFramePageId=" +beans[i].getPageFramePageId() +
					"&BCE_FRAME_ID=" + bceFrameId);
			else
				node.setLink("pFramePageId=" +beans[i].getPageFramePageId());
			
			pageFrameAndPageMap.put(node.getId(), node);
			
			if(i ==0){
				searchPageCond = searchPageCond +"'" + beans[i].getPageId() + "'";
				searchPageFrameCond = searchPageFrameCond +"'" + beans[i].getPageFrameId() + "'";
				searchRowsetRelatCond = searchRowsetRelatCond +"'" + beans[i].getPageFramePageId() + "'";
			}else{
				searchPageCond = searchPageCond +",'" + beans[i].getPageId() + "'";
				searchPageFrameCond = searchPageFrameCond +",'" + beans[i].getPageFrameId() + "'";
				searchRowsetRelatCond = searchRowsetRelatCond +",'" + beans[i].getPageFramePageId() + "'";
			}
		}
		searchPageCond = searchPageCond + ")";
		searchRowsetRelatCond = searchRowsetRelatCond + ")";
		searchPageFrameCond = searchPageFrameCond + ")";
		
		
		// 框架与页面关系--关联的页面
		Map pageNodeMap = getBcePageNodeMap(searchPageCond ,null);
		if(pageNodeMap != null){
			for(int i=0;i<beans.length;i++){
				ChartNode parentNode = (ChartNode) pageFrameAndPageMap.get(beans[i].getPageFramePageId() +"");
				ChartNode childNode = (ChartNode) pageNodeMap.get(beans[i].getPageId()+"");
				
				if(parentNode != null && childNode != null){
					parentNode.addChidNode(childNode);
				}
			}
		}

		//框架与页面关系--页面和数据集关系
		Map pageRowsetRelatMap = getBcePageRowsetRelateNodeMap(searchRowsetRelatCond ,null);
		if(pageRowsetRelatMap != null){
			ChartNode childNodes[] = (ChartNode[]) pageRowsetRelatMap.values().toArray(new ChartNode[0]);
			for(int i=0;i<childNodes.length;i++){
				ChartNode parentNode = (ChartNode) pageFrameAndPageMap.get(childNodes[i].getParentId()+""); 
				
				if(parentNode != null  ){
					parentNode.addChidNode(childNodes[i]);
				}
			}
		}
		
		HashMap para = new HashMap();

		
		if(bceFrameId == null || "".equals(bceFrameId) == true ){
			return pageFrameAndPageMap;
		}
		
		//框架与页面关系--关联的角色
		condition = "BCE_FRAME_ID = :BCE_FRAME_ID and " +searchRowsetRelatCond;
		
		para.put("BCE_FRAME_ID", bceFrameId);
		
		Map roleNodeMap = getBcePageRoleNodeMap(condition ,para) ;
		if(roleNodeMap != null){
			ChartNode childNodes[] = (ChartNode[]) roleNodeMap.values().toArray(new ChartNode[0]);
			for(int i=0;i<childNodes.length;i++){
				ChartNode parentNode = (ChartNode) pageFrameAndPageMap.get(childNodes[i].getParentId()+""); 
				
				if(parentNode != null  ){
					parentNode.addChidNode(childNodes[i]);
				}
			}
		}
		//获取受理框架下挂的 页面特殊配置
		Map specialPageNodeMap = getBceSpecialPageNodeMap(condition ,para) ;
		
		if(specialPageNodeMap != null){
			ChartNode childNodes[] = (ChartNode[]) specialPageNodeMap.values().toArray(new ChartNode[0]);
			for(int i=0;i<childNodes.length;i++){
				ChartNode parentNode = (ChartNode) pageFrameAndPageMap.get(childNodes[i].getId()+""); 
				
				if(parentNode != null  ){
					parentNode.addChidNode(childNodes[i]);
				}
			}
		}
		return pageFrameAndPageMap;
	}
	

	/**
	 * 获取页面框架与页面关系表——与特殊配置
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceSpecialPageNodeMap(String condition ,Map parameter) throws Exception{
		//BceFramePageRoleBean beans[]= BceFramePageRoleEngine.getBeans(condition, parameter);
		BceFrameSpecialPageBean beans[] = BceFrameSpecialPageEngine.getBeans(condition,parameter);
		if(beans == null || beans.length ==0){
			return null;
		}
		
		HashMap specialPageNodeMap = new HashMap();

		//获取页面包含的数据集
		//String searchDatasetCond = "ROWSET_ID in ("; 
		
		//构造所有的页面框架与角色关系节点
		for(int i=0;i<beans.length;i++){
			ChartNode node = new ChartNode();
			node.setId(beans[i].getPageFramePageId() +"");  
			node.setState(beans[i].getState()+"");
			
			node.setName(LocaleResourceFactory.getResource("BES0000575")  );
			
			node.setNodeType("BCE_FRAME_SPECIAL_PAGE");
			node.setShowTip(getTipsFromBean(beans[i]));
			node.setLink("bceFrameId="+beans[i].getBceFrameId()+ 
					"&pageFramePageId="+beans[i].getPageFramePageId());
			
			specialPageNodeMap.put(node.getId() , node);
		
//			if(i == 0){
//				searchDatasetCond = searchDatasetCond +"'" + beans[i].getRowsetId() + "'";
//			}else{
//				searchDatasetCond = searchDatasetCond +",'" + beans[i].getRowsetId() + "'";
//			}
		}
 
//		searchDatasetCond = searchDatasetCond + ")";
		
//		//获取数据集
//		Map rowsetMap = getBceDataset(searchDatasetCond ,null);
//
//		// 与数据集关系
//		if(rowsetMap != null){
//			for(int i=0;i<beans.length;i++){
//				ChartNode parentNode = (ChartNode) pageNodeMap.get(
//						beans[i].getPageFramePageId()+"_" +beans[i].getRowsetId());
//				ChartNode childNode = (ChartNode) rowsetMap.get(beans[i].getRowsetId()+"");
//				
//				if(parentNode != null && childNode != null){
//					parentNode.addChidNode(childNode);
//				}
//			}
//		}
		
		return specialPageNodeMap;
	}
	

	/**
	 * 获取页面框架与页面关系表——与角色  
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageRoleNodeMap(String condition ,Map parameter) throws Exception{
		BceFramePageRoleBean beans[]= BceFramePageRoleEngine.getBeans(condition, parameter);
		if(beans == null || beans.length ==0){
			return null;
		}
		
		HashMap roleNodeMap = new HashMap();

		//获取页面包含的数据集
		//String searchDatasetCond = "ROWSET_ID in ("; 
		
		//构造所有的页面框架与角色关系节点
		for(int i=0;i<beans.length;i++){
			ChartNode node = new ChartNode();
			node.setId(beans[i].getPageFramePageId() +""); 
			node.setSecondId(beans[i].getRoleId() +""); 
			node.setParentId(beans[i].getPageFramePageId() +""); 
			node.setState(beans[i].getState()+"");
			
			if(beans[i].getRemarks() !=null && "".equals(beans[i].getRemarks()) == false){
				node.setName(LocaleResourceFactory.getResource("BES0000576") + "<br>" +beans[i].getRemarks());
			}else{
				node.setName(LocaleResourceFactory.getResource("BES0000576") + "<br>" +beans[i].getRoleId());
			}
			node.setNodeType("BCE_FRAME_PAGE_ROLE");
			node.setShowTip(getTipsFromBean(beans[i]));
			node.setLink("roleId="+beans[i].getRoleId()+
					"&frameId="+beans[i].getBceFrameId() +
					"&pFrameId="+beans[i].getPageFramePageId() );
			
			
			roleNodeMap.put(node.getId()+"_" + node.getSecondId(), node);
		
//			if(i == 0){
//				searchDatasetCond = searchDatasetCond +"'" + beans[i].getRowsetId() + "'";
//			}else{
//				searchDatasetCond = searchDatasetCond +",'" + beans[i].getRowsetId() + "'";
//			}
		}
 
//		searchDatasetCond = searchDatasetCond + ")";
		
//		//获取数据集
//		Map rowsetMap = getBceDataset(searchDatasetCond ,null);
//
//		// 与数据集关系
//		if(rowsetMap != null){
//			for(int i=0;i<beans.length;i++){
//				ChartNode parentNode = (ChartNode) pageNodeMap.get(
//						beans[i].getPageFramePageId()+"_" +beans[i].getRowsetId());
//				ChartNode childNode = (ChartNode) rowsetMap.get(beans[i].getRowsetId()+"");
//				
//				if(parentNode != null && childNode != null){
//					parentNode.addChidNode(childNode);
//				}
//			}
//		}
		
		return roleNodeMap;
	}
	
	
	/**
	 * 获取页面框架与页面关系表——数据集关系表
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageRowsetRelateNodeMap(String condition ,Map parameter) throws Exception{
		BcePageRowsetRelBean beans[]= BcePageRowsetRelEngine.getBeans(condition, parameter);
		if(beans == null || beans.length ==0){
			return null;
		}
		
		HashMap pageNodeMap = new HashMap();

		//获取页面包含的数据集
		String searchDatasetCond = "ROWSET_ID in ("; 
		
		//构造所有的页面框架与数据集关系节点
		for(int i=0;i<beans.length;i++){
			ChartNode node = new ChartNode();
			node.setId(beans[i].getPageFramePageId() +""); 
			node.setSecondId(beans[i].getRowsetId() +""); 
			node.setParentId(beans[i].getPageFramePageId() +""); 
			node.setState(beans[i].getState()+"");
			
			node.setName(LocaleResourceFactory.getResource("BES0000577") + "<br>"+
					beans[i].getPageFramePageId() +"," +beans[i].getRowsetId());
			node.setNodeType("BCE_PAGE_ROWSET_REL");
			node.setShowTip(getTipsFromBean(beans[i]));
			node.setLink("PAGE_FRAME_PAGE_ID=" +beans[i].getPageFramePageId() +
					"&ROWSET_ID=" +beans[i].getRowsetId() );
			
			pageNodeMap.put(node.getId()+"_" + node.getSecondId(), node);
		
			if(i == 0){
				searchDatasetCond = searchDatasetCond +"'" + beans[i].getRowsetId() + "'";
			}else{
				searchDatasetCond = searchDatasetCond +",'" + beans[i].getRowsetId() + "'";
			}
		}
 
		searchDatasetCond = searchDatasetCond + ")";
		
		//获取数据集
		Map rowsetMap = getBceDataset(searchDatasetCond ,null);

		// 与数据集关系
		if(rowsetMap != null){
			for(int i=0;i<beans.length;i++){
				ChartNode parentNode = (ChartNode) pageNodeMap.get(
						beans[i].getPageFramePageId()+"_" +beans[i].getRowsetId());
				ChartNode childNode = (ChartNode) rowsetMap.get(beans[i].getRowsetId()+"");
				
				if(parentNode != null && childNode != null){
					parentNode.addChidNode(childNode);
				}
			}
		}
		
		return pageNodeMap;
	}
	

	/**
	 * 获取数据集 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceDataset(String condition ,Map parameter) throws Exception{
		BceRowsetBean beans[]= BceRowsetEngine.getBeans(condition, parameter);
		if(beans == null || beans.length ==0){
			return null;
		}
		
		HashMap ruleNodeMap = new HashMap();
 
		
		//构造所有的数据集
		for(int i=0;i<beans.length;i++){
			ChartNode node = new ChartNode();
			node.setId(beans[i].getRowsetId()+""); 
			node.setState(beans[i].getState()+"");
			node.setShowTip(getTipsFromBean(beans[i]));
			node.setLink("ROWSET_ID=" + beans[i].getRowsetId());
			
			
			if(beans[i].getRemarks() !=null && "".equals(beans[i].getRemarks()) == false){
				node.setName(LocaleResourceFactory.getResource("BES0000578") + "<br>" + beans[i].getRemarks());
			}else{
				node.setName(LocaleResourceFactory.getResource("BES0000578") + "<br>" + beans[i].getRowsetId());
			}
			node.setNodeType("BCE_ROWSET");
			
			ruleNodeMap.put(node.getId(), node);
		}

		return ruleNodeMap;
	}
	
	/**
	 * 获取页面
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageNodeMap(String condition ,Map parameter) throws Exception{
		BcePageBean beans[]= BcePageEngine.getBeans(condition, parameter);
		if(beans == null || beans.length ==0){
			return null;
		}
		
		HashMap pageNodeMap = new HashMap();

		//获取页面包含的规则集
		String searchRulesetCond = "RULESET_ID in (";
		
		//页面包含规则集数量
		int includeRulesetCount = 0;
		
		//构造所有的页面节点
		for(int i=0;i<beans.length;i++){
			ChartNode node = new ChartNode();
			node.setId(beans[i].getPageId() +""); 
			//node.setName(LocaleResourceFactory.getResource("BES0000579") + "<br>"+beans[i].getPageId());
			String pageName = beans[i].getRemarks()==null?"":beans[i].getRemarks();
			node.setName(LocaleResourceFactory.getResource("BES0000579")+" "+beans[i].getPageId()+"<br>("+pageName+")");
			node.setNodeType("BCE_PAGE");
			node.setState(beans[i].getState()+"");
			node.setShowTip(getTipsFromBean(beans[i]));
			node.setLink("PAGE_ID=" + beans[i].getPageId());
			
			pageNodeMap.put(node.getId(), node);
			
			if(beans[i].getPageRulesetId() <=0){
				continue;
			}
			
			includeRulesetCount ++;
			
			if(includeRulesetCount == 1){
				searchRulesetCond = searchRulesetCond +"'" + beans[i].getPageRulesetId() + "'";
			}else{
				searchRulesetCond = searchRulesetCond +",'" + beans[i].getPageRulesetId() + "'";
			}
		}
		
		//如果页面不包含规则集，则返回
		if(includeRulesetCount==0){
			return pageNodeMap;
		}
		
		searchRulesetCond = searchRulesetCond + ")";
		
		Map rulesetMap = getBceRuleSet(searchRulesetCond ,null);


		// 页面与规则集关系
		if(rulesetMap != null){
			for(int i=0;i<beans.length;i++){
				ChartNode parentNode = (ChartNode) pageNodeMap.get(beans[i].getPageId()+"");
				ChartNode childNode = (ChartNode) rulesetMap.get(beans[i].getPageRulesetId()+"");
				
				if(parentNode != null && childNode != null){
					parentNode.addChidNode(childNode);
				}
			}
		}
		
		return pageNodeMap;
	}
	

	/**
	 * 获取规则集
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceRuleSet(String condition ,Map parameter) throws Exception{
		BceRulesetBean beans[]= BceRulesetEngine.getBeans(condition, parameter);
		if(beans == null || beans.length ==0){
			return null;
		}
		
		HashMap rulesetNodeMap = new HashMap();

		//获取页面框架也页面关系数据
		String searchRulesetAndRuleCond = "RULESET_ID in (";
		
		//构造所有的规则集节点
		for(int i=0;i<beans.length;i++){
			ChartNode node = new ChartNode();
			node.setId(beans[i].getRulesetId()+""); 
			//node.setName(LocaleResourceFactory.getResource("BES0000580") + "<br>" + beans[i].getRulesetId()); 
			String rulesetName = beans[i].getRemarks()==null?"":beans[i].getRemarks();
			node.setName(LocaleResourceFactory.getResource("BES0000580")+" "+beans[i].getRulesetId()+"<br>("+rulesetName+")");
			node.setNodeType("BCE_RULESET");
			node.setState(beans[i].getState()+"");
			node.setShowTip(getTipsFromBean(beans[i]));
			node.setLink("RULESET_ID=" + beans[i].getRulesetId()+"&RULESET_TYPE="+beans[i].getRulesetType());
			
			rulesetNodeMap.put(node.getId(), node);
			
			if(i ==0){
				searchRulesetAndRuleCond = searchRulesetAndRuleCond +"'" + beans[i].getRulesetId() + "'";
			}else{
				searchRulesetAndRuleCond = searchRulesetAndRuleCond +",'" + beans[i].getRulesetId() + "'";
			}
		}
		searchRulesetAndRuleCond = searchRulesetAndRuleCond + ")";
		
		//获取规则集与规则关系表
		Map rulesetAndRuleNodeMap = getBceRuleSetAndRule(searchRulesetAndRuleCond ,null);

		//规则集和规则的关系
		if(rulesetAndRuleNodeMap != null){
			ChartNode childNodes[] = (ChartNode[]) rulesetAndRuleNodeMap.values().toArray(new ChartNode[0]);
			for(int i=0;i<childNodes.length;i++){
				ChartNode parentNode = (ChartNode) rulesetNodeMap.get(childNodes[i].getParentId()+""); 
				
				if(parentNode != null  ){
					parentNode.addChidNode(childNodes[i]);
				}
			}
		}
		return rulesetNodeMap;
	}
	

	/**
	 * 获取规则集与规则关系表
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceRuleSetAndRule(String condition ,Map parameter) throws Exception{
		BceRulesetRuleBean beans[]= BceRulesetRuleEngine.getBeans(condition, parameter);
		if(beans == null || beans.length ==0){
			return null;
		}
		
		HashMap rulesetAndRuleNodeMap = new HashMap();

		//获取规则条件 
		String searchRuleCond = "RULE_ID in (";
		
		//构造所有的规则集与规则关系节点
		for(int i=0;i<beans.length;i++){
			BceRulesetBean rulesetBean = BceRulesetEngine.getBean(beans[i].getRulesetId());
			
			ChartNode node = new ChartNode();
			node.setId(beans[i].getRulesetId()+"");
			node.setSecondId(beans[i].getRuleId()+"");
			node.setState(beans[i].getState()+"");
			node.setShowTip(getTipsFromBean(beans[i]));
			node.setLink("RULESET_ID=" + beans[i].getRulesetId() +
						"&RULE_ID=" + beans[i].getRuleId() + "&RELATE_ID=" +beans[i].getRelateId() + "&RULESET_TYPE=" + rulesetBean.getRulesetType());
			
			node.setParentId(beans[i].getRulesetId()+"");
			//node.setName(LocaleResourceFactory.getResource("BES0000581") + "<br>" + beans[i].getRulesetId()+"," + beans[i].getRuleId()); 
			node.setName(LocaleResourceFactory.getResource("BES0000581") + "<br>" + beans[i].getRulesetId()+"," + beans[i].getRuleId());
			node.setNodeType("BCE_RULESET_RULE");
			
			rulesetAndRuleNodeMap.put(node.getId() +"_" + node.getSecondId(), node);
			
			if(i ==0){
				searchRuleCond = searchRuleCond +"'" + beans[i].getRuleId() + "'";
			}else{
				searchRuleCond = searchRuleCond +",'" + beans[i].getRuleId() + "'";
			}
		}
		searchRuleCond = searchRuleCond + ")";
		

		//获取规则
		Map ruleNodeMap = getBceRule(searchRuleCond ,null);

		//规则集和规则的关系
		if(ruleNodeMap != null){ 
			for(int i=0;i<beans.length;i++){
				ChartNode parentNode = (ChartNode) rulesetAndRuleNodeMap.get(beans[i].getRulesetId()+
						"_"+beans[i].getRuleId()); 
				ChartNode chilidNode = (ChartNode) ruleNodeMap.get(beans[i].getRuleId()+""); 
				
				if(parentNode != null && chilidNode !=null  ){
					parentNode.addChidNode(chilidNode);
				}
			}
		}
		return rulesetAndRuleNodeMap;
	}
	
	
	/**
	 * 获取规则 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceRule(String condition ,Map parameter) throws Exception{
		BceRuleBean beans[]= BceRuleEngine.getBeans(condition, parameter);
		if(beans == null || beans.length ==0){
			return null;
		}
		
		HashMap ruleNodeMap = new HashMap();
 
		
		//构造所有的规则集与规则关系节点
		for(int i=0;i<beans.length;i++){
			ChartNode node = new ChartNode();
			node.setId(beans[i].getRuleId()+""); 
			node.setState(beans[i].getState()+"");
			node.setShowTip(getTipsFromBean(beans[i]));
			node.setLink("RULE_ID=" + beans[i].getRuleId()); 
			String ruleName = beans[i].getRemarks()==null?"":beans[i].getRemarks();
			node.setName(LocaleResourceFactory.getResource("BES0000582")+" " + beans[i].getRuleId()+"<br>(" +ruleName +")"); 
			node.setNodeType("BCE_RULE");
			
			ruleNodeMap.put(node.getId(), node);
		}

		return ruleNodeMap;
	}
	
	/**
	 * 获取所有模块
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getAllModule( ) throws Exception{
		ChartNode parentNode = new ChartNode();
		parentNode.setId("all_module_node");
		parentNode.setName(LocaleResourceFactory.getResource("BES0000550")); 
		parentNode.setState("1");
		 

		BceModuleBean[] beans= BceModuleEngine.getBeans("" ,null);
		for(int i=0;i<beans.length;i++){
			ChartNode node = new ChartNode();
			node.setId("" + beans[i].getModuleId() );
			node.setName(beans[i].getModuleName() );
			node.setState(beans[i].getState() +"");
			node.setLink("module_id=" + beans[i].getModuleId());
			parentNode.addChidNode(node);
		}
		
		HashMap map = new HashMap();
		map.put(parentNode.getId(), parentNode);
		return map;
	}
	/**
	 * 将bean转换成字符串
	 * @param dc
	 * @return
	 * @throws Exception
	 */
	private String getTipsFromBean(DataContainer  dc) throws Exception{
		if(dc == null){
			return "";
		} 
		String str = dc.toString();
		int index = str.indexOf('\n');
		if(index >-1){
			str = str.substring(index +1);
		}
		
		str = str.replaceAll("\n", " ");
		str = str.replaceAll("   ", "\\\\n");
		str = str.replaceAll(":", " = ");
		
		//获取表名
		String tableName= getTableNameFromDc(dc);
		str = LocaleResourceFactory.getResource("BES0000583") + ":" + tableName + "\\n" + str;
		
		return str;
	}
	
	/**
	 * 获取bean对应的方法 
	 * @param dc
	 * @return
	 * @throws Exception
	 */
	private String getTableNameFromDc(DataContainer  dc)throws Exception{
		//尝试从缓存中获取表名
		Class c = dc.getClass();
		String tableName = (String)tableMap.get(c);
		if(tableName != null ){
			return tableName;
		}
		
		/*//反射获取ObjectType对象
		Method getObjectTypeStatic = c.getMethod("getObjectTypeStatic", null);
		
		//获取表名
		ObjectType type = dc.getObjectType();*/
		tableName = dc.fetchTableName();
		
		tableMap.put(c, tableName);
		return tableName;
	}
	private static HashMap tableMap = new HashMap();
}
