package com.ai.bce.configtool.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.bce.configtool.dao.interfaces.IConfTreeChartDAO;
import com.ai.bce.configtool.service.interfaces.IConfTreeChartSV;
import com.ai.bce.util.BServiceFactory;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.valuebean.chartnode.ChartNode;

/**
 * ��ȡÿ���������νṹ��HTML����
 * @author akuei
 *
 */
public class ConfTreeChartSVImpl implements IConfTreeChartSV {

	/**
	 * ��ȡ��������� ���νṹ
	 * @param bceFrameId
	 * @return
	 * @throws Exception
	 */
	public String getBceFrameTreeHtml(long bceFrameId) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		
		Map nodeMap = dao.getBceFrameNodeMap(bceFrameId);
		
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,  LocaleResourceFactory.getResource("BES0000538") ,
				LocaleResourceFactory.getResource("BES0000585",new String[]{bceFrameId+""}) );
	}

	/**
	 * ��ȡҳ�������νṹ
	 * @param pageFrameID
	 * @return
	 * @throws Exception
	 */
	public String getBcePageFrameTreeHtml(long pageFrameID) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("PAGE_FRAME_ID", ""+pageFrameID);
		Map nodeMap = dao.getBcePageFrameNodeMap("PAGE_FRAME_ID= :PAGE_FRAME_ID ", parameter ,true);
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000539")  ,
				LocaleResourceFactory.getResource("BES0000586",new String[]{""+pageFrameID}) );
	}
	
	/**
	 * ��ȡҳ������ҳ���ϵ���ñ����νṹ
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
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000540") ,
				LocaleResourceFactory.getResource("BES0000587",new String[]{PAGE_FRAME_PAGE_ID+""}) );
	}
	 

	/**
	 * ��ȡҳ�� 
	 * @param pageID
	 * @return
	 * @throws Exception
	 */
	public String getBcePageTreeHtml(long pageID) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("PAGE_ID", ""+pageID);
		Map nodeMap = dao.getBcePageNodeMap("PAGE_ID= :PAGE_ID ", parameter);
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000541") ,
				LocaleResourceFactory.getResource("BES0000588",new String[]{""+pageID}) );
	}
	 

	/**
	 * ��ȡ����
	 * @param rulesetId
	 * @return
	 * @throws Exception
	 */
	public String getBceRulesetTreeHtml(long rulesetId) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("RULESET_ID", ""+rulesetId);
		Map nodeMap = dao.getBceRuleSet("RULESET_ID= :RULESET_ID ", parameter);
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000542") ,
				LocaleResourceFactory.getResource("BES0000589",new String[]{""+rulesetId}) );
	}

	/**
	 * ��ȡ����������ϵ��
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public String getBceRulesetAndRuleTreeHtml(long rulesetId ,long ruleId,long relateId) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("RELATE_ID", ""+relateId);
		Map nodeMap = dao.getBceRuleSetAndRule("RELATE_ID= :RELATE_ID ", parameter);
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000543"),
				LocaleResourceFactory.getResource("BES0000591",new String[]{""+ruleId ,""+rulesetId}));
	}

	/**
	 * ��ȡ����
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public String getBceRuleTreeHtml(long ruleId) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		
		HashMap parameter = new HashMap();
		parameter.put("RULE_ID", ""+ruleId);
		Map nodeMap = dao.getBceRule("RULE_ID= :RULE_ID ", parameter);
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000544") ,
				LocaleResourceFactory.getResource("BES0000592",new String[]{""+ruleId}));
	}
	
	/**
	 * ��ȡJAVA�����������ܹ�ϵ
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
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000545"),
				LocaleResourceFactory.getResource("BES0000593",new String[]{""+relateId}) );
	}
	

	/**
	 * ��ȡҳ������ҳ���ϵ��������������
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
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000546") 
				,LocaleResourceFactory.getResource("BES0000594",new String[]{""+BCE_FRAME_ID,""+PAGE_FRAME_PAGE_ID}));
	
	}

	/**
	 * ��ȡҳ������ҳ���ϵ�������ɫ  
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
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000547") ,
				LocaleResourceFactory.getResource("BES0000595",new String[]{""+BCE_FRAME_ID ,
						""+PAGE_FRAME_PAGE_ID,""+ROLE_ID}));
	
	}
	

	/**
	 * ��ȡҳ������ҳ���ϵ�������ݼ���ϵ��
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
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000548")  ,
				LocaleResourceFactory.getResource("BES0000596",new String[]{""+PAGE_FRAME_PAGE_ID
						,""+ROWSET_ID}) );
	
	}
	

	/**
	 * ��ȡ���ݼ� 
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
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000549")  ,
				LocaleResourceFactory.getResource("BES0000597",new String[]{""+ROWSET_ID}) );
	
	}
	

	/**
	 * ��ȡ����ģ��
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getAllModule( ) throws Exception{
		IConfTreeChartDAO dao = (IConfTreeChartDAO)BServiceFactory.getService(IConfTreeChartDAO.class);
		 
		Map nodeMap = dao.getAllModule();
		
		//���ݽڵ㷵��XML
		return getStringByNodeMap(nodeMap ,LocaleResourceFactory.getResource("BES0000550")  ,
				LocaleResourceFactory.getResource("BES0000550") );
	}
	 
	
	
	/**
	 * ���ݽڵ�map������html ���
	 * @param nodeMap
	 * @param multiNodeHit ���ж���ڵ��ʱ�򣬹���һ���ܽڵ������
	 * @param whenErrHit ��û�нڵ��ʱ�򱨴���Ϣ
	 * @return
	 */
	private String getStringByNodeMap(Map nodeMap ,String multiNodeHit ,String whenErrHit){
		ChartNode rootNode = null; 
		
		//��û�з��ؽڵ��ʱ��
		if(nodeMap == null || nodeMap.size() ==0){
			rootNode = new ChartNode();
			rootNode.setId("empty");
			rootNode.setName(whenErrHit);
		}
		//��ֻ��һ���ڵ��ʱ��
		else if(nodeMap.size() == 1){
			ChartNode chartNodes[] =(ChartNode[]) nodeMap.values().toArray(new ChartNode[1]);
			rootNode = chartNodes[0]; 
		}
		//����ж���ڵ�
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
