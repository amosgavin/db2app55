package com.asiainfo.sale.access.service.interfaces;

public interface IBusiChangeAssistSV {

	/**
	 * �����д������id�Ƿ���ȷ
	 * 
	 * @param channelIdStr
	 * @return ������д���������id��û�з��ؿա�
	 * @throws Exception
	 */
	public String checkChannelId(String channelIdStr) throws Exception;

	/**
	 * ��ȡӪ�����İ�����
	 * 
	 * @param feeId
	 * @return �����ۼư��������������������� 
	 * @throws Exception
	 */
	public String getSaleHandles(String feeId) throws Exception;
}
