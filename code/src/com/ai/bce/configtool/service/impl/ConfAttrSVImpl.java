package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.bce.bo.BceAttrBean;
import com.ai.bce.configtool.dao.interfaces.IConfAttrDAO;
import com.ai.bce.configtool.service.interfaces.IConfAttrSV;
import com.ai.bce.ivalues.IBceAttrValue;
import com.ai.bce.util.BServiceFactory;

public class ConfAttrSVImpl implements IConfAttrSV {

	public IBceAttrValue[] getBceAttrBeans(String dataSource, String tableName)
			throws Exception {

		StringBuffer sql = new StringBuffer("select a.TABLE_NAME as obj_name,"
				+ " a.COLUMN_NAME as attr_code," + " b.comments as attr_name,"
				+ " decode(a.DATA_TYPE,'DATE',a.DATA_TYPE,'NUMBER',a.DATA_TYPE||'('||a.DATA_PRECISION||decode(a.DATA_SCALE,0,'',','||a.DATA_SCALE)||')',a.DATA_TYPE||'('||a.DATA_LENGTH||')') as field_type,"
				+ " decode(a.DATA_TYPE,'DATE',null,'NUMBER',a.DATA_PRECISION,a.DATA_LENGTH) as MAX_LENGTH,"
				+ " 1 as state"
				+ " FROM USER_TAB_COLUMNS A, USER_COL_COMMENTS B"
				+ " WHERE A.TABLE_NAME = B.TABLE_NAME"
				+ " AND A.COLUMN_NAME = B.COLUMN_NAME"
				+ " AND A.table_name = :table_name"
				);
		Map parameter = new HashMap();
		parameter.put("table_name", tableName);
		//parameter.put("conn", dataSource);
		return getBeansFromSql(sql.toString(), parameter,dataSource);
	}
	
	public DataContainerInterface[] getTableNames(String dataSource, String cond) throws RemoteException,Exception {
		return getDao().getTableNames(dataSource, cond);
}

	public BceAttrBean[] getBeansFromSql(String sql, Map parameter,String dataSource) throws RemoteException,Exception {
		return getDao().getBeansFromSql(sql, parameter, dataSource);
	}

	public int getBceAttrBeansCount(String dataSource, String tableName) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public IBceAttrValue[] getBceAttrs(String attrId) throws RemoteException,Exception{
		return getDao().getBceAttrs(attrId);
	}
	public IConfAttrDAO getDao() throws Exception{
		return (IConfAttrDAO) BServiceFactory.getService(IConfAttrDAO.class);
	}
}
