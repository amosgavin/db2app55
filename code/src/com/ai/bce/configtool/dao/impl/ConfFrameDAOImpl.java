package com.ai.bce.configtool.dao.impl;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.bce.bo.BceAttrFieldMapEngine;
import com.ai.bce.bo.BceBatInputFieldFormatEngine;
import com.ai.bce.bo.BceBatInputFormatEngine;
import com.ai.bce.bo.BceExtTableConfigEngine;
import com.ai.bce.bo.BceFrameBean;
import com.ai.bce.bo.BceFrameConfigTemplateEngine;
import com.ai.bce.bo.BceFrameEngine;
import com.ai.bce.bo.BceFramePageRoleEngine;
import com.ai.bce.bo.BceFrameSpecialPageEngine;
import com.ai.bce.bo.BcePageEngine;
import com.ai.bce.bo.BceRowsetEngine;
import com.ai.bce.bo.BceRuleEngine;
import com.ai.bce.bo.BceSimpleFuncEngine;
import com.ai.bce.bo.BceSimpleFuncFieldMappingEngine;
import com.ai.bce.bo.BceWorkflowEngine;
import com.ai.bce.bo.QBceBusinessAttrEngine;
import com.ai.bce.bo.QBceBusinessButtonEngine;
import com.ai.bce.bo.QBceRowsetBean;
import com.ai.bce.bo.QBceRulesetRuleEngine;
import com.ai.bce.bo.QPageFramePageEngine;
import com.ai.bce.configtool.dao.interfaces.IConfFrameDAO;
import com.ai.bce.ivalues.IBceAttrFieldMapValue;
import com.ai.bce.ivalues.IBceBatInputFieldFormatValue;
import com.ai.bce.ivalues.IBceBatInputFormatValue;
import com.ai.bce.ivalues.IBceExtTableConfigValue;
import com.ai.bce.ivalues.IBceFrameConfigTemplateValue;
import com.ai.bce.ivalues.IBceFramePageRoleValue;
import com.ai.bce.ivalues.IBceFrameSpecialPageValue;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.ivalues.IBcePageRowsetRelValue;
import com.ai.bce.ivalues.IBcePageValue;
import com.ai.bce.ivalues.IBceRowsetValue;
import com.ai.bce.ivalues.IBceRuleValue;
import com.ai.bce.ivalues.IBceSimpleFuncFieldMappingValue;
import com.ai.bce.ivalues.IBceSimpleFuncValue;
import com.ai.bce.ivalues.IBceWorkflowValue;
import com.ai.bce.ivalues.IQBceBusinessAttrValue;
import com.ai.bce.ivalues.IQBceBusinessButtonValue;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;
import com.ai.bce.ivalues.IQPageFramePageValue;
import com.ai.bce.util.BceException;

public class ConfFrameDAOImpl implements IConfFrameDAO {
	
	
	public IBceFrameValue getBceFrameValueByBceFrameId(long bceFrameId) throws Exception {
		return BceFrameEngine.getBean(bceFrameId);
	}
	
	
	
	public IBcePageValue getBcePage(long pageId)throws Exception{
		return BcePageEngine.getBean(pageId);
	}
	
	public IBceRuleValue getBceRule(long ruleId)throws Exception{
		return BceRuleEngine.getBean(ruleId);
	}
	
    /**
     * ���������ܱ�š�ҳ����,��ȡ������ҳ������Ľ�ɫ����
     * @param pBceFrameId
     * @param pPageId
     * @return
     * @throws Exception
     */
    public IBceFramePageRoleValue[] getBceFramePageRoles(
            long pBceFrameId, long pPageFramePageId) throws Exception {
        String sql = IBceFramePageRoleValue.S_BceFrameId+" = :pBceFrameId ";
        sql += " and "+IBceFramePageRoleValue.S_PageFramePageId +" = :pPageFramePageId ";
        sql += " and "+IBceFramePageRoleValue.S_State+" = 1 ";
        sql += " order by "+IBceFramePageRoleValue.S_SeqNo+" ";
        HashMap parameter=new HashMap();
        parameter.put("pBceFrameId", new Long(pBceFrameId));
        parameter.put("pPageFramePageId", new Long(pPageFramePageId));
        IBceFramePageRoleValue[] beans =BceFramePageRoleEngine.getBeans(sql, parameter);
        return beans;
    }

	
    /**
     * ���������ܱ�Ż�ȡ�����ܰ��������еĽ�ɫ
     * @param pBceFrameId
     * @param pPageId
     * @return
     * @throws Exception
     * @add by Yuye
     */
	public IBceFramePageRoleValue[] getBceFramePageRolesByBceFrameId(long BceFrameId) throws Exception {
		String sql = IBceFramePageRoleValue.S_BceFrameId+" = :pBceFrameId and "
		           + IBceFramePageRoleValue.S_State + " = 1 order by " + IBceFramePageRoleValue.S_SeqNo;
		HashMap parameter=new HashMap();
	    parameter.put("pBceFrameId", new Long(BceFrameId));
	   IBceFramePageRoleValue[] beans =BceFramePageRoleEngine.getBeans(sql, parameter);   
		return beans;
	}
    
    /**
     * ����������ѯ������
     */
    public IBceFrameValue getBceFrameValue(long businessId,Map paramMap)
            throws Exception {
        String cond = IBceFrameValue.S_BusinessId + " = :businessId and "
                    + IBceFrameValue.S_State + " = 1 ";
        HashMap parameter=new HashMap();
      	parameter.put("businessId", new Long(businessId));
      	IBceFrameValue[] values = BceFrameEngine.getBeans(cond, parameter);
      	if(values == null || values.length == 0)
      		return null;
      	if(paramMap == null || paramMap.size() ==0){
      		return values[0];
      	}
        //���ݲ����б�ƥ��
    		int index = -1;
    		int maxMatch = 0;
    		for(int i=0;i<values.length;i++){
    			String paramData = values[i].getParamData();
    			if(StringUtils.isBlank(paramData)){
    				if(index == -1)
    				  index = i;
    				continue;
    			}
    			int match = 0;
    			String[] params = null;
    			if(paramData.indexOf("@~")>0){
    				params = StringUtils.split(paramData, "@~");
    			}
    			else{
    				params = StringUtils.split(paramData, "\r\n");
    			}

    			for(int j=0;j<params.length;j++){
    				String[] tmp = StringUtils.split(params[j],"=");
    				if(tmp.length != 2){
    					throw new BceException("BES0000018");
    				}
    				
    				if(paramMap.containsKey(tmp[0])){
    					if(paramMap.get(tmp[0]).toString().equals(tmp[1])){
    						match++;
    					}
    					else{
    						//��һ��˵����ƥ��
    						match = 0;
    						break;
    					}
    				}
    			}
          //���������ƥ�� match == maxMatch���������������⣬��Ĭ��ȡ��һ��
    			if(match > maxMatch){
    				maxMatch = match;
    				index = i;
    			}
    		}
    		if(index == -1){
    			return null;
    		}
    		return values[index];
    }    
    
    /**���ݹ��򼯱�Ų�ѯ�ù��򼯰��������й���
     * @param pPageRulesetId
     * @return
     * @throws Exception
     */
    public IQBceRulesetRuleValue[] getRulesByRulesetId(long pPageRulesetId) throws Exception {
    	String condition=IQBceRulesetRuleValue.S_RulesetId+" = :pPageRulesetId and "
    	   + IQBceRulesetRuleValue.S_State + " = 1 order by " + IQBceRulesetRuleValue.S_SeqNo;
    	HashMap parameter=new HashMap();
    	parameter.put("pPageRulesetId", new Long(pPageRulesetId));
    	return QBceRulesetRuleEngine.getBeans(condition, parameter);
    }
    
    
    
    /**���������ܱ�Ż�ȡ����������
     * @param pPageFrameId
     * @return
     * @throws Exception
     */
    public IBceFrameValue getBceFrameValue(long pFrameId) throws Exception{
    	IBceFrameValue retValue=null;
    	retValue=BceFrameEngine.getBean(pFrameId);
    	if(retValue!=null&&!retValue.isNew()){
    		return retValue;
    	}else{
    		return null;
    	}
    }    
    
    /**���������ܱ�š�ҳ���ܱ�Ų�ѯҳ���ܰ�����ҳ��
     * @param pBceFrameId
     * @param pPageFrameId
     * @return
     * @throws Exception
     */
    public IQPageFramePageValue[] getPageFramePages(long pBceFrameId,long pPageFrameId)throws Exception{
    	//���Ȳ�ѯ�����ܵ�����ҳ�档
    	String condition=IBceFrameSpecialPageValue.S_BceFrameId+" = :pBceFrameId and "+IBceFrameSpecialPageValue.S_State+" =1 ";
    	HashMap parameter=new HashMap();
    	parameter.put("pBceFrameId", new Long(pBceFrameId));
    	IBceFrameSpecialPageValue[] BceFrameSpecPages=BceFrameSpecialPageEngine.getBeans(condition, parameter);
    	HashMap pageMap=new HashMap();
    	if(BceFrameSpecPages!=null&&BceFrameSpecPages.length>0){
    		for (int i = 0; i < BceFrameSpecPages.length; i++) {
    			pageMap.put(new Long(BceFrameSpecPages[i].getPageFramePageId()), BceFrameSpecPages[i]);
			  }
    	}
    	//��ѯ�����ܵ�ҳ�棬���ҳ����Ϣ�������ܵ�����ҳ���Ѵ��ڣ���������ҳ���������Ϣ����֮��
    	condition=IQPageFramePageValue.S_PageFrameId+" = :pPageFrameId and "+IQPageFramePageValue.S_State+" =1 order by "+IQPageFramePageValue.S_SeqNo;
    	parameter=new HashMap();
    	parameter.put("pPageFrameId", new Long(pPageFrameId));
    	IQPageFramePageValue[] pageFamePages = QPageFramePageEngine.getBeans(condition, parameter);
    	if(pageFamePages!=null&&pageFamePages.length>0){
    		for (int i = 0; i < pageFamePages.length; i++) {
				long pageFramePageId=pageFamePages[i].getPageFramePageId();
				IBceFrameSpecialPageValue specPage=(IBceFrameSpecialPageValue)pageMap.get(new Long(pageFramePageId));
				if(specPage!=null){
					if (StringUtils.isNotBlank(specPage.getPageParam())) {
	                    String tmp = pageFamePages[i].getPageUrl();
	                    if (tmp.indexOf("?") > 0) {
	                        tmp += "&" + specPage.getPageParam();
	                    } else {
	                        tmp += "?" + specPage.getPageParam();
	                    }
	                    pageFamePages[i].setPageUrl(tmp);
	                }
	                if (specPage.getIsDataMust() != -1)
	                	pageFamePages[i].setIsDataMust(specPage.getIsDataMust());
	                if (specPage.getIsGetPageData() != -1)
	                	pageFamePages[i].setIsGetPageData(specPage.getIsGetPageData());
	                if (specPage.getPageRulesetId() != -1)
	                	pageFamePages[i].setPageRulesetId(specPage.getPageRulesetId());
	                if (StringUtils.isNotBlank(specPage.getPageTitle()))
	                	pageFamePages[i].setPageTitle(specPage.getPageTitle());
				}
			}
    	}
    	return pageFamePages;
    }
    
    /**����ҳ���Ż�ȡҳ����������ݼ�
     * @param pPageId
     * @return
     * @throws Exception
     */
    public IBceRowsetValue[] getPageRowsets(long pPageFramePageId)throws Exception{
        String sql = QBceRowsetBean.getObjectTypeStatic().getMapingEnty();
        sql+=" and "+IBcePageRowsetRelValue.S_PageFramePageId+" = :pPageFramePageId ";
    	HashMap parameter=new HashMap();
    	parameter.put("pPageFramePageId", new Long(pPageFramePageId));
    	return BceRowsetEngine.getBeansFromSql(sql, parameter);
    }
     
    
    public IBceSimpleFuncValue[] qrySFunc(String cond,Map param)throws Exception{
  		return BceSimpleFuncEngine.getBeans(cond, param);
  	}
    
    public IBceSimpleFuncFieldMappingValue[] qrySFuncFieldMapping(String cond,Map param)throws Exception{
  		return BceSimpleFuncFieldMappingEngine.getBeans(cond, param);
  	}
    
    public DataContainerInterface[] getDatasByBO(String datasourceName,String cond,Map param,ObjectType ot)throws Exception{
    	Connection conn = ServiceManager.getSession().getConnection(datasourceName);
  		try{
    	  return ServiceManager.getDataStore().retrieve(conn,null, ot, null, cond, param, -1, -1, false, false, null);
  		}
  		finally{
  			if(conn != null)
  				conn.close();
  		}
    }
    
    public IQBceBusinessAttrValue[] getQBceBusinessAttrs(String cond,Map param)throws Exception{
    	return QBceBusinessAttrEngine.getBeans(cond, param);
    }
    
 
    public IQBceBusinessButtonValue[] getQBceBusinessButton(String cond,Map param)throws Exception{
    	return QBceBusinessButtonEngine.getBeans(cond, param);
    }
    
    public IBceWorkflowValue[] getBceWorkflow(long busiOperId, long prodSpecId,
  			long offerId) throws Exception, RemoteException {
  		StringBuffer buf = new StringBuffer();
  		Map param = new HashMap();
  		buf.append(IBceWorkflowValue.S_BusinessId).append(" = :busiOperId and ").
  			append(IBceWorkflowValue.S_ProdSpecId).append(" = :prodSpecId and ").
  			append(IBceWorkflowValue.S_State).append(" = 1 ");
  		param.put("busiOperId", new Long(busiOperId));
  		param.put("prodSpecId", new Long(prodSpecId));
  		if(offerId>0){
  			buf.append(" and ").append(IBceWorkflowValue.S_OfferId).append(" = :offerId ");
  			param.put("offerId", new Long(offerId));
  		}
  		return BceWorkflowEngine.getBeans(buf.toString(), param);
  	}
  	
  	/**
     * ���ݲ�Ʒ����źͽ�ɫ��Ų�ѯ�ý�ɫ��Ա������ļ���ʽ������Ϣ
     *
     * @param aProductSpecId
     * @param aProductRoleId
     * @param aBusinessId
     * @return
     * @throws Exception
     */
    public IBceBatInputFormatValue getImportFileConfig(
            long aProductSpecId, long aProductRoleId,long aBusinessId) throws Exception {
    	IBceBatInputFormatValue ret = null;
        String condition = "("+IBceBatInputFormatValue.S_ProdSpecId
                + " = :aProductSpecId or "+IBceBatInputFormatValue.S_ProdSpecId+" = -10000 )";
        condition += " and (" + IBceBatInputFormatValue.S_RoleId
                + " = :aProductRoleId  or "+IBceBatInputFormatValue.S_RoleId+" = -10000)";
        condition += " and (" + IBceBatInputFormatValue.S_BusinessId
        + " = :aBusinessId or "+ IBceBatInputFormatValue.S_BusinessId+" = -1 )";        
        HashMap parameter = new HashMap();
        parameter.put("aProductSpecId", String.valueOf(aProductSpecId));
        parameter.put("aProductRoleId", String.valueOf(aProductRoleId));
        parameter.put("aBusinessId", String.valueOf(aBusinessId));
        IBceBatInputFormatValue[] values = BceBatInputFormatEngine.getBeans(condition, parameter);
        if (values != null && values.length > 0) {
            //�жϾ��崫��Ĳ���������о�������ģ��򷵻ط��Ͼ�����������������ݡ�
            int maxFitNo=-1;
            int maxFitRowNo=0;
            for (int i = 0; i < values.length; i++) {
    			int tmpFitNo=0;
    			if (values[i].getBusinessId()==aBusinessId){
    				tmpFitNo++;
    			}
    			if (values[i].getRoleId()==aProductRoleId){
    				tmpFitNo++;
    			}
      			
    			if (tmpFitNo>maxFitNo){
    				maxFitNo=tmpFitNo;
    				maxFitRowNo=i;
    			}
    		}        	
            ret = values[maxFitRowNo];
        }else{
        	//"δ�ҵ���Ʒ���["+aProductSpecId+"]����ɫ["+aProductRoleId+"]��ҵ�����Ϊ["+aBusinessId+"]�ĳ�Ա������������ݡ�"
        	Object[] pParams = new String[]{Long.toString(aProductSpecId), Long.toString(aProductRoleId), Long.toString(aBusinessId)};
        	throw new BceException("BES0000008", pParams);
        }
        return ret;
    }
    
    /**�������ñ�Ż�ȡ���õ��ֶε���ϸ��Ϣ
     * @param aConfigId
     * @return
     * @throws Exception
     */
    public IBceBatInputFieldFormatValue[] getImportFieldValues(long aConfigId) throws Exception{
    	String condition=IBceBatInputFieldFormatValue.S_ConfigId+" = :aConfigId order by "+IBceBatInputFieldFormatValue.S_SeqNo;
    	HashMap parameter=new HashMap();
    	parameter.put("aConfigId", new Long(aConfigId));
    	return BceBatInputFieldFormatEngine.getBeans(condition, parameter);
    } 
    
    /**����ҵ�������Ų�ѯ��ҵ��������õ������붩���е�ӳ���ϵ
     * @param aBusinessId
     * @return
     * @throws Exception
     */
    public IBceAttrFieldMapValue[] getBceAttrFieldMaps(long aBusinessId)throws Exception{
    	String condition=IBceAttrFieldMapValue.S_BusinessId+" = :aBusinessId ";
    	HashMap parameter=new HashMap();
    	parameter.put("aBusinessId", new Long(aBusinessId));
    	return BceAttrFieldMapEngine.getBeans(condition, parameter);
    }
    
    /**
     * ���ݹ����ֶ����Ͳ�ѯ������չ������
     * @param relType
     * @return
     * @throws Exception
     */
    public IBceExtTableConfigValue[] getBceExtTableConfigs( String relType ) throws Exception{
      String condition = IBceExtTableConfigValue.S_State + " = 1 ";
      HashMap parameter=new HashMap();
      condition += " and " + IBceExtTableConfigValue.S_RelType + " = :relType";
      parameter.put( "relType", relType );
      return BceExtTableConfigEngine.getBeans(condition, parameter);
    }



	public IBceFrameValue[] getBceFrameValues(String cond, int startIndex,
			int endIndex) throws Exception {
		return BceFrameEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}



	public int getBceFrameValuesCount(String cond) throws Exception {
		return BceFrameEngine.getBeansCount(cond, null);
	}



	public int getBceFramesCountByModuleId(long moduleId) {
		String cond = BceFrameBean.S_ModuleId +" = :moduleId";
		Map parameter = new HashMap();
		parameter.put("moduleId", new Long(moduleId));
		try {
			return BceFrameEngine.getBeansCount(cond, parameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 
	 * @Function: ConfFrameDAOImpl::getBceFrameConfigTemplateValues
	 * @Description: �ú����Ĺ�������
	 * @param cond
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-14 ����02:18:39 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-14     Administrator          v1.1.0               �޸�ԭ��
	 */
	public IBceFrameConfigTemplateValue[] getBceFrameConfigTemplateValues(String cond,
			int startIndex, int endIndex) throws Exception {
		return  BceFrameConfigTemplateEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}

	/**
	 * 
	 * @Function: ConfFrameDAOImpl::getBceFrameConfigTemplateValuesCount
	 * @Description: �ú����Ĺ�������
	 * @param cond
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-14 ����02:18:43 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-14     Administrator          v1.1.0               �޸�ԭ��
	 */
	public int getBceFrameConfigTemplateValuesCount(String cond)
			throws Exception {
		return BceFrameConfigTemplateEngine.getBeansCount(cond, null);
	}
}
