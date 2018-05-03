package com.ai.bce.configtool.dao.interfaces;

import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.bce.bo.BceAttrBean;
import com.ai.bce.ivalues.IBceAttrValue;

public interface IConfAttrDAO {
	public IBceAttrValue[] getBceAttrs(String attrId) throws Exception;
	public BceAttrBean[] getBeansFromSql(String sql, Map parameter,String dataSource) throws Exception;
	public DataContainerInterface[] getTableNames(String dataSource, String cond) throws Exception ;
}
