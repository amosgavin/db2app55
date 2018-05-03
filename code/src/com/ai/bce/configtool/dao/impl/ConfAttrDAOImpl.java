package com.ai.bce.configtool.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.bce.bo.BceAttrBean;
import com.ai.bce.bo.BceAttrEngine;
import com.ai.bce.configtool.dao.interfaces.IConfAttrDAO;
import com.ai.bce.ivalues.IBceAttrValue;

public class ConfAttrDAOImpl implements IConfAttrDAO {

	public IBceAttrValue[] getBceAttrs(String attrId) throws Exception {
		IBceAttrValue[] attrs = BceAttrEngine.getBeans(IBceAttrValue.S_State +" = 1 and "+IBceAttrValue.S_AttrId+" = "+attrId,null);
		 return attrs;
	}

	public BceAttrBean[] getBeansFromSql(String sql, Map parameter,
			String dataSource) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection(dataSource.toLowerCase());
			resultset = ServiceManager.getDataStore().retrieve(conn, sql,
					parameter);
			return (BceAttrBean[]) ServiceManager.getDataStore()
					.crateDtaContainerFromResultSet(BceAttrBean.class,
							BceAttrBean.getObjectTypeStatic(), resultset, null,
							true);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public DataContainerInterface[] getTableNames(String dataSource, String cond)
			throws Exception {
		StringBuffer sql = new StringBuffer("select * from all_tables where owner=:dataSource");
		if(null != cond && !"".equals(cond)){
			sql.append(" and "+cond);
		}
		Map parameter = new HashMap();
		parameter.put("dataSource", dataSource.toUpperCase());
		Connection conn = ServiceManager.getSession().getConnection();
		ResultSet results = ServiceManager.getDataStore().retrieve(conn, sql.toString(),parameter);
		return ServiceManager.getDataStore().crateDtaContainerFromResultSet(DataContainer.class,ServiceManager.getObjectTypeFactory().getObjectTypeByClass(DataContainer.class) , results, null, true);
	}

}
