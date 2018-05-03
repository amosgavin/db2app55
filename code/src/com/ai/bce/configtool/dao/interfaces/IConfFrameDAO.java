package com.ai.bce.configtool.dao.interfaces;

import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.bce.ivalues.IBceAttrFieldMapValue;
import com.ai.bce.ivalues.IBceBatInputFieldFormatValue;
import com.ai.bce.ivalues.IBceBatInputFormatValue;
import com.ai.bce.ivalues.IBceExtTableConfigValue;
import com.ai.bce.ivalues.IBceFrameConfigTemplateValue;
import com.ai.bce.ivalues.IBceFramePageRoleValue;
import com.ai.bce.ivalues.IBceFrameValue;
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

public interface IConfFrameDAO {
	
	
	public IBceFrameValue getBceFrameValueByBceFrameId(long bceFrameId) throws Exception;
	public IBceFrameValue[] getBceFrameValues(String cond,int startIndex,int endIndex)throws Exception;
	public int getBceFrameValuesCount(String cond) throws Exception ;
	public IBcePageValue getBcePage(long pageId)throws Exception;
	public int getBceFramesCountByModuleId(long moduleId);
	public IBceRuleValue getBceRule(long ruleId)throws Exception;
	
	
	public IBceFrameConfigTemplateValue[] getBceFrameConfigTemplateValues(String cond,int startIndex,int endIndex)throws Exception;
	public int getBceFrameConfigTemplateValuesCount(String cond) throws Exception ;
	
    /**
     * ���������ܱ�š�ҳ����,��ȡ������ҳ������Ľ�ɫ����
     * @param pBeFrameId
     * @param pPageId
     * @return
     * @throws Exception
     */
    public IBceFramePageRoleValue[] getBceFramePageRoles(
            long pBeFrameId, long pPageId) throws Exception;
    
    
	
    /**
     * ���������ܱ�Ż�ȡ�����ܰ��������еĽ�ɫ
     * @param pBeFrameId
     * @param pPageId
     * @return
     * @throws Exception
     */
	public IBceFramePageRoleValue[] getBceFramePageRolesByBceFrameId(long BeFrameId) throws Exception ;
    
    /**
     * ����������ѯ������
     */
	public IBceFrameValue getBceFrameValue(long businessId,Map paramMap) throws Exception;
    
    /**���������ܱ�Ż�ȡ����������
     * @param pPageFrameId
     * @return
     * @throws Exception
     */
    public IBceFrameValue getBceFrameValue(long pFrameId) throws Exception;    
    
    /**���ݹ��򼯱�Ų�ѯ�ù��򼯰��������й���
     * @param pPageRulesetId
     * @return
     * @throws Exception
     */
    public IQBceRulesetRuleValue[] getRulesByRulesetId(long pPageRulesetId) throws Exception;
    
   
    
    /**���������ܱ�š�ҳ���ܱ�Ų�ѯҳ���ܰ�����ҳ��
     * @param pBeFrameId
     * @param pPageFrameId
     * @return
     * @throws Exception
     */
    public IQPageFramePageValue[] getPageFramePages(long pBeFrameId,long pPageFrameId)throws Exception;
    
    /**����ҳ���Ż�ȡҳ����������ݼ�
     * @param pPageId
     * @return
     * @throws Exception
     */
    public IBceRowsetValue[] getPageRowsets(long pPageId)throws Exception;
    
  
    public IBceSimpleFuncValue[] qrySFunc(String cond,Map param)throws Exception;
    
    public IBceSimpleFuncFieldMappingValue[] qrySFuncFieldMapping(String cond,Map param)throws Exception;
    
    public DataContainerInterface[] getDatasByBO(String datasourceName,String cond,Map param,ObjectType ot)throws Exception;

    public IQBceBusinessAttrValue[] getQBceBusinessAttrs(String cond,Map param)throws Exception;
    
     
    public IQBceBusinessButtonValue[] getQBceBusinessButton(String cond,Map param)throws Exception;
    
    public IBceWorkflowValue[] getBceWorkflow(long busiOperId, long prodSpecId,long offerId) throws Exception;
    
    public IBceBatInputFormatValue getImportFileConfig(
        long aProductSpecId, long aProductRoleId,long aBusinessId) throws Exception;
    
    public IBceBatInputFieldFormatValue[] getImportFieldValues(long aConfigId) throws Exception;
    
    public IBceAttrFieldMapValue[] getBceAttrFieldMaps(long aBusinessId)throws Exception;
    
    public IBceExtTableConfigValue[] getBceExtTableConfigs( String relType ) throws Exception;
    
}
