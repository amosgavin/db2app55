package com.asiainfo.bi.service.interfaces;

import com.asiainfo.bi.ivalues.IBOBusiSupportValue;

public interface IBusiSupportSV {

	/**
	 * ����������ѯ������ϸ
	 * 
	 * @param itemId
	 *            ����id
	 * @param state
	 *            ����״̬
	 * @param dispatchTimeF
	 *            ����ʱ��from
	 * @param dispatchTimeTo
	 *            ����ʱ��to
	 * @param dealPerson
	 *            ������
	 * @return
	 * @throws Exception
	 */
	public IBOBusiSupportValue[] getItemInfoINBusiSu(String itemId,
			String itemType, String state, String dispatchTimeF,
			String dispatchTimeTo, String dealPerson, int startNum, int endNum)
			throws Exception;

	public int getItemInfoINBusiSuCount(String itemId, String itemType,
			String state, String dispatchTimeF, String dispatchTimeTo,
			String dealPerson) throws Exception;
}
