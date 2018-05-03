package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.ivalues.IBceSimpleFuncFieldMappingValue;
import com.ai.bce.ivalues.IBceSimpleFuncValue;

/**
 * ���㹦�ܵķ���ӿ�
 * 
 * @author linzhaoming
 *
 */
public interface IConfSimpleFuncSV {
	
	/**
	 * ��ȡ���㹦�����ñ������
	 * @param cond
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IBceSimpleFuncValue[] getSimpleFuncValues(String cond, int startIndex,
			int endIndex) throws Exception;

	/**
	 * ��ȡ���㹦�����ñ������
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public int getSimpleFuncValuesCount(String cond) throws Exception;

	/**
	 * ��ȡ���㹦���ֶ�ӳ�����ñ������
	 * @param cond
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IBceSimpleFuncFieldMappingValue[] getSimpleFuncFieldMappingValues(
			String cond, int startIndex, int endIndex) throws Exception;

	/**
	 * ��ȡ���㹦���ֶ�ӳ�����ñ������
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public int getSimpleFuncFieldMappingCount(String cond) throws Exception;
}
