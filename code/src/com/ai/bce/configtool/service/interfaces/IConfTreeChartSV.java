package com.ai.bce.configtool.service.interfaces;


public interface IConfTreeChartSV {
	
	/**
	 * ����BCD_FRAME_ID����ȡ����html
	 * @param bceFrameId
	 * @return
	 * @throws Exception
	 */
	public String getBceFrameTreeHtml(long bceFrameId) throws Exception;
	 
	/**
	 * ����ҳ�������νṹ
	 * @param pageFrameID
	 * @return
	 * @throws Exception
	 */
	public String getBcePageFrameTreeHtml(long pageFrameID) throws Exception;
	
	/**
	 * ��ȡҳ������ҳ���ϵ���ñ����νṹ
	 * @param pageFrameID
	 * @return
	 * @throws Exception
	 */
	public String getBcePageFrameAndPageTreeHtml(long PAGE_FRAME_PAGE_ID) throws Exception;
	
	/**
	 * ��ȡҳ�� 
	 * @param pageID
	 * @return
	 * @throws Exception
	 */
	public String getBcePageTreeHtml(long pageID) throws Exception;
	

	/**
	 * ��ȡ����
	 * @param rulesetId
	 * @return
	 * @throws Exception
	 */
	public String getBceRulesetTreeHtml(long rulesetId) throws Exception;
	
	/**
	 * ��ȡ����������ϵ��
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public String getBceRulesetAndRuleTreeHtml(long rulesetId ,long ruleId,long relateId) throws Exception;
	

	/**
	 * ��ȡ����
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public String getBceRuleTreeHtml(long ruleId) throws Exception;
	
	
	/**
	 * ��ȡJAVA�����������ܹ�ϵ
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getJavaRuleNodeMap(long relateId) throws Exception;
	

	/**
	 * ��ȡҳ������ҳ���ϵ��������������
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBceSpecialPageNodeMap(long BCE_FRAME_ID ,long  PAGE_FRAME_PAGE_ID) throws Exception;
	

	/**
	 * ��ȡҳ������ҳ���ϵ�������ɫ  
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBcePageRoleNodeMap(long BCE_FRAME_ID ,long PAGE_FRAME_PAGE_ID ,
			long ROLE_ID) throws Exception;
	

	/**
	 * ��ȡҳ������ҳ���ϵ�������ݼ���ϵ��
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBcePageRowsetRelateNodeMap(long PAGE_FRAME_PAGE_ID ,long ROWSET_ID) throws Exception;
	

	/**
	 * ��ȡ���ݼ� 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getBceDataset(long ROWSET_ID ) throws Exception;
	

	/**
	 * ��ȡ����ģ��
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public String getAllModule( ) throws Exception;
}
