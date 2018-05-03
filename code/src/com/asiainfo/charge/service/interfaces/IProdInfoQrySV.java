package com.asiainfo.charge.service.interfaces;

import com.ai.appframe2.bo.DataContainer;
import com.asiainfo.charge.ivalues.IBOProductExtDescValue;
import com.asiainfo.charge.ivalues.IBOProductExtValue;
import com.asiainfo.common.service.interfaces.IAbstractProductExtSV;

/**
 * 
 * @author jiangxl �ʷ��ײ͹��������
 * 
 */
public interface IProdInfoQrySV extends IAbstractProductExtSV{

	/**
	 * ��ȡ�̲��ţ�������wlan��gprs �ʷ��ײ���Ϣ
	 * 
	 * @param cols
	 *            Ҫ��ѯ���ֶ�����
	 * @param prodName
	 *            �Ż�����
	 * @param type
	 *            �ʷ�����
	 * @param attrId
	 *            �ۼ���
	 * @param privId
	 *            �Ż�id
	 * @param $STARTROWINDEX
	 *            ��ʼ��¼
	 * @param $ENDROWINDEX
	 *            ������¼
	 * 
	 * @return
	 * @throws Exception
	 */
	public DataContainer[] getBasicProdInfo(String cols, String prodName,
			String type, String attrId, String privId,String condStr, int $STARTROWINDEX,
			int $ENDROWINDEX) throws Exception;

	/**
	 * ͳ������
	 * 
	 * @param cols
	 * @param prodName
	 * @param type
	 * @param attrId
	 * @param privId
	 * @return
	 * @throws Exception
	 */
	public int getBasicProdInfoCount(String cols, String prodName, String type,
			String attrId, String privId,String condStr) throws Exception;

	
	/**
	 * ����ʷ����״̬Ϊ0 ����Ч��
	 * 
	 * @param privId
	 * @param attrId
	 * @param state
	 * @param extType
	 * @param staffId
	 * @throws Exception
	 */
	public void changeSts(String privId, String attrId, String state,
			String extType, String staffId) throws Exception;

	/**
	 * ������������
	 * 
	 * @param saveValues
	 * @throws Exception
	 */
	public void saveProductExtValue(IBOProductExtValue[] saveValues)
			throws Exception;

	/**
	 * ��ѯ�ʷ���ʷ����
	 * 
	 * @param displayCols
	 *            չʾ��
	 * @param basicCols
	 *            �������еĻ�����
	 * @param tableName
	 *            ����
	 * @param privId
	 *            �Ż�ID
	 * @param attrId
	 *            �ۼ���
	 * @param state
	 *            ״̬
	 * @param extType
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public DataContainer[] qryProductInfoHis(String displayCols,
			String basicCols, String tableName, String privId, String attrId,
			String state, String extType, int startIndex, int endIndex)
			throws Exception;

	/**
	 * ͳ������
	 * 
	 * @param displayCols
	 * @param basicCols
	 * @param tableName
	 * @param privId
	 * @param attrId
	 * @param state
	 * @param extType
	 * @return
	 * @throws Exception
	 */
	public int qryProductInfoHisCount(String displayCols, String basicCols,
			String tableName, String privId, String attrId, String state,
			String extType) throws Exception;
	
	/**
	 * �������ͻ�ȡ���������������Դ
	 * @param privType
	 * @return
	 * @throws Exception
	 */
//	public IBOProductExtDescValue[] getExtAttrs(String privType)
//			throws Exception;
}
