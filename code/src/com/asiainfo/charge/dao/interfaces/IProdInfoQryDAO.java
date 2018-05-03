package com.asiainfo.charge.dao.interfaces;

import com.ai.appframe2.bo.DataContainer;
import com.asiainfo.charge.ivalues.IBOGprsFluxParamValue;
import com.asiainfo.charge.ivalues.IBOGprsProductInfoValue;
import com.asiainfo.charge.ivalues.IBOProductExtDescValue;
import com.asiainfo.charge.ivalues.IBOProductExtValue;
import com.asiainfo.charge.ivalues.IBOProductInfoValue;
import com.asiainfo.common.dao.interfaces.ICommonProductExtDAO;

/**
 * 
 * @author jiangxl
 * �ʷ��ײ͹���  ���ݷ��ʽӿ�
 *
 */
public interface IProdInfoQryDAO extends  ICommonProductExtDAO {
	/**
	 * ��ȡ�����ʷ���Ϣ �����̲��ţ�������wlan��gprs��
	 * @param cols
	 * @param prodName
	 * @param type
	 * @param attrId
	 * @param privId
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public DataContainer[] getBasicProdInfo(String cols,String prodName,
			String type, String attrId,String privId,String condStr,int startIndex, int endIndex) throws Exception;

	
	/**
	 * ͳ������
	 * @param cols
	 * @param prodName
	 * @param type
	 * @param attrId
	 * @param privId
	 * @return
	 * @throws Exception
	 */
	public int getBasicProdInfoCount(String cols,String prodName,
			String type,String attrId,String privId,String condStr)throws Exception;
	


	
    /**
     * ��ʼ��product_ext��������gprs��ֵ
     * @param extType
     * @throws Exception
     */
	public void initialGprsValue(String extType)throws Exception;
	
	/**
	 * ��ʼ��product_ext�������ڶ̲��ţ�������wlan��ֵ
	 * @param extType
	 * @throws Exception
	 */
	public void initialBasicValue(String extType)throws Exception;

	/**
	 * ����������ѯ��������
	 * @param privId
	 * @param attrId
	 * @param extType
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public IBOProductExtValue getDataValue(String privId,String attrId, String extType,
			String state)throws Exception;

	
	/**
	 * ��product_ext ��������
	 * @param dataValues
	 * @throws Exception
	 */
	public void saveProductExtValue(IBOProductExtValue[] dataValues)throws Exception;

	
	/**
	 * ��ѯ�޸���ʷ
	 * @param displayCols
	 * @param basicCols
	 * @param tableName
	 * @param privId
	 * @param attrId
	 * @param state
	 * @param extType
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public DataContainer[] qryProductInfoHis(String displayCols,String basicCols,String tableName, String privId,String attrId,
			String state, String extType, int startIndex, int endIndex)throws Exception;


	/**
	 * ͳ������
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
	public int qryProductInfoHisCount(String displayCols,String basicCols, String tableName ,String privId,String attrId, String state,
			String extType)throws Exception;

}
