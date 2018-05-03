package com.asiainfo.charge.service.interfaces;

import com.ai.appframe2.bo.DataContainer;
import com.asiainfo.charge.ivalues.IBOProductExtDescValue;
import com.asiainfo.charge.ivalues.IBOProductExtValue;
import com.asiainfo.common.service.interfaces.IAbstractProductExtSV;

/**
 * 
 * @author jiangxl 资费套餐管理服务类
 * 
 */
public interface IProdInfoQrySV extends IAbstractProductExtSV{

	/**
	 * 获取短彩信，语音，wlan，gprs 资费套餐信息
	 * 
	 * @param cols
	 *            要查询的字段名字
	 * @param prodName
	 *            优惠名称
	 * @param type
	 *            资费类型
	 * @param attrId
	 *            累计量
	 * @param privId
	 *            优惠id
	 * @param $STARTROWINDEX
	 *            开始记录
	 * @param $ENDROWINDEX
	 *            结束记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public DataContainer[] getBasicProdInfo(String cols, String prodName,
			String type, String attrId, String privId,String condStr, int $STARTROWINDEX,
			int $ENDROWINDEX) throws Exception;

	/**
	 * 统计总量
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
	 * 置历史数据状态为0 （无效）
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
	 * 保存新增数据
	 * 
	 * @param saveValues
	 * @throws Exception
	 */
	public void saveProductExtValue(IBOProductExtValue[] saveValues)
			throws Exception;

	/**
	 * 查询资费历史数据
	 * 
	 * @param displayCols
	 *            展示列
	 * @param basicCols
	 *            基础表中的基础列
	 * @param tableName
	 *            表名
	 * @param privId
	 *            优惠ID
	 * @param attrId
	 *            累计量
	 * @param state
	 *            状态
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
	 * 统计总数
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
	 * 根据类型获取属性下来框的数据源
	 * @param privType
	 * @return
	 * @throws Exception
	 */
//	public IBOProductExtDescValue[] getExtAttrs(String privType)
//			throws Exception;
}
