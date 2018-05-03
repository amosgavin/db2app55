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
 * 资费套餐管理  数据访问接口
 *
 */
public interface IProdInfoQryDAO extends  ICommonProductExtDAO {
	/**
	 * 获取基本资费信息 包括短彩信，语音，wlan，gprs等
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
	 * 统计总数
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
     * 初始化product_ext表中属于gprs的值
     * @param extType
     * @throws Exception
     */
	public void initialGprsValue(String extType)throws Exception;
	
	/**
	 * 初始化product_ext表中属于短彩信，语音，wlan的值
	 * @param extType
	 * @throws Exception
	 */
	public void initialBasicValue(String extType)throws Exception;

	/**
	 * 根据条件查询属性数据
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
	 * 在product_ext 保存数据
	 * @param dataValues
	 * @throws Exception
	 */
	public void saveProductExtValue(IBOProductExtValue[] dataValues)throws Exception;

	
	/**
	 * 查询修改历史
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
	 * 统计总数
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
