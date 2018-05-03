package com.asiainfo.sale.tag.dao.interfaces;

import com.asiainfo.sale.tag.ivalues.IBOApplyTagValue;

public interface ITagMainDAO {

	public int saveTagMain(IBOApplyTagValue TagMainValues) throws Exception;

	/**
	 * ���ݱ�Ų�ѯ������ǩ��Ϣ
	 * 
	 * @param id
	 *            ���
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOApplyTagValue getTagMainShowById(String id) throws Exception,
			RuntimeException;

	/**
	 * ���ݴ�����ǩ��Ų�ѯӪ�����Ϣ
	 * 
	 * @param id
	 *            ������ǩ���
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	// public IBOPromationTagValue[] getTagDetailByMainId(String mainId,
	// int startNum, int endNum) throws Exception;

	/**
	 * ���ݴ�����ǩ��Ų�ѯӪ�����Ϣ
	 * 
	 * @param id
	 *            ������ǩ���
	 * @param startNum
	 *            ��ҳ��ʼҳ��
	 * @param endNum
	 *            ��ҳ����ҳ��
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	// public int getCount(String mainId) throws Exception;
	/*
	 * ��ѯ״̬Ϊʹ�õ����б�ǩ
	 */
	// public IBOPromationTagValue[] getTagDetailByState(String state, String
	// charge, int startNum, int endNum) throws Exception;
	/**
	 * ɾ��������ǩ��Ϣ
	 * 
	 * @param TagDetailValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOApplyTagValue[] getMainTagShowByTaskTag(String taskTag) throws Exception;
	// public IBOPromationTagValue[] queryTagDetail(String charge, int startNum,
	// int endNum)throws Exception;

	// public int getTagDetailCount(String charge)throws Exception;

	// public IBOPromationTagValue[] getTagDetailInSpare(String charge, int
	// startNum, int endNum) throws Exception;

	// public int getTagInSpareCount(String charge) throws Exception;

	// public void delTagDetail(IBOPromationTagValue[] TagDetailValues)
	// throws Exception;
}
