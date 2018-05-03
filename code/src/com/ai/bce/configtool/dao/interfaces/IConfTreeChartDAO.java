package com.ai.bce.configtool.dao.interfaces;

import java.util.Map;

public interface IConfTreeChartDAO {

	/**
	 * ��ȡ���������
	 * @param bceFrameId  
	 * @return
	 * @throws Exception
	 */
	public Map getBceFrameNodeMap(long bceFrameId ) throws Exception;
	/**
	 * ��ȡJAVA�����������ܹ�ϵ
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getJavaRuleNodeMap(String condition ,Map parameter) throws Exception;
	

	/**
	 * ��ȡҳ������ҳ���ϵ��������������
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceSpecialPageNodeMap(String condition ,Map parameter) throws Exception;

	/**
	 * ��ȡҳ������ҳ���ϵ�������ɫ  
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageRoleNodeMap(String condition ,Map parameter) throws Exception;
	

	/**
	 * ��ȡҳ������ҳ���ϵ�������ݼ���ϵ��
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageRowsetRelateNodeMap(String condition ,Map parameter) throws Exception;
	

	/**
	 * ��ȡ���ݼ� 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceDataset(String condition ,Map parameter) throws Exception;
	/**
	 * ��ȡҳ����
	 * @param condition
	 * @param parameter
	 * @param isIncludePageFrameAndPageNode �Ƿ�ҳ������ҳ���ϵ�ӽڵ�
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageFrameNodeMap(String condition ,Map parameter,
			boolean isIncludePageFrameAndPageNode) throws Exception;
	

	/**
	 * ��ȡҳ������ҳ���ϵ���ñ�
	 * @param condition
	 * @param parameter
	 * @param isIncludePageFrameNode �Ƿ���� ҳ���ܽڵ�
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageFrameAndPageNodeMap(String condition ,Map parameter ) throws Exception;
	

	/**
	 * ��ȡҳ��
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBcePageNodeMap(String condition ,Map parameter) throws Exception;
	

	/**
	 * ��ȡ����
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceRuleSet(String condition ,Map parameter) throws Exception;
	

	/**
	 * ��ȡ����������ϵ��
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceRuleSetAndRule(String condition ,Map parameter) throws Exception;
	
	
	/**
	 * ��ȡ���� 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getBceRule(String condition ,Map parameter) throws Exception;
	

	/**
	 * ��ȡ����ģ��
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public Map getAllModule( ) throws Exception;
}
