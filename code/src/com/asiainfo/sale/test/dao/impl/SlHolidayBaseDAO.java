package com.asiainfo.sale.test.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.sale.test.bo.BoSlHolidayBean;
import com.asiainfo.sale.test.bo.BoSlHolidayEngine;
import com.asiainfo.sale.test.dao.interfaces.ISlHolidayDAO;
import com.asiainfo.sale.test.ivalues.IBoSlHolidayValue;

/**   
 * Copyright: Copyright (c) 2012 Asiainfo-Linkage
 * 
 * @Description: SL_HOLIDAY BaseDAO实现
 * <p>Auto Generated. Please don't Modify!!</p>
 *
 * @version: v1.0.0
 * @author: yanghesi
 * @date: 2012-02-21 15:33:37 
 *
 * Modification History:</br>
 * Date         Author          Version            Description</br>
 *---------------------------------------------------------</br>
 * 2012-02-21     yanghesi           v1.0.0              Auto Generated</br>
 */
public class SlHolidayBaseDAO implements ISlHolidayDAO {

	public IBoSlHolidayValue getEmptySlHoliday() throws Exception {
		return new BoSlHolidayBean();
	}

	public IBoSlHolidayValue getSlHoliday(Object id) throws Exception {
		IBoSlHolidayValue ret = BoSlHolidayEngine.getBean(((BigDecimal)id).intValue());
		return ret;
	}

	public IBoSlHolidayValue[] getSlHoliday(IBoSlHolidayValue aCond, String AddInCond, HashMap pList) throws Exception {
		StringBuffer VarCondition = new StringBuffer();
		if (null == pList)
			pList = new HashMap();
		buildCriteria((DataContainer) aCond, AddInCond, VarCondition, pList);
		return BoSlHolidayEngine.getBeans(VarCondition.toString(), pList);
	}

	public int getSlHolidayCountFromWhereSql(String sql, HashMap map) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return ServiceManager.getDataStore().retrieveCount(conn, BoSlHolidayBean.getObjectTypeStatic(), sql, map, null);
		} finally {
			if (null != conn)
				conn.close();
		}
	}

	public IBoSlHolidayValue[] getSlHolidayFromWhereSql(String sql, HashMap map, int start, int end) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			return (IBoSlHolidayValue[])ServiceManager.getDataStore().retrieve(conn,BoSlHolidayBean.class,BoSlHolidayBean.getObjectTypeStatic(),null,sql,map,start,end,false,false,null);
		} finally {
			if (null != conn)
				conn.close();
		}
	}

	public IBoSlHolidayValue[] getSlHolidayFromSql(String sql, HashMap map) throws Exception {
		return BoSlHolidayEngine.getBeansFromSql(sql, map);
	}

	public int getCountSlHolidayFromSql(String sql, HashMap map) throws Exception {
		Connection conn = null;
		ResultSet resultset = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			resultset = ServiceManager.getDataStore().retrieve(conn, sql, map);
			while (resultset.next()) {
				return resultset.getInt(1);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (resultset != null)
				resultset.close();
			if (conn != null)
				conn.close();
		}
		return 0;
	}

	public IBoSlHolidayValue[] getSlHolidayFromBO(String bofilepath, HashMap map) throws Exception {
		return BoSlHolidayEngine.getBeansFromQueryBO(bofilepath, map);
	}

	public void exeSql(String sql, HashMap map) throws Exception {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			ServiceManager.getDataStore().execute(conn, sql, map);
		} finally {
			if (null != conn) {
				conn.close();
			}
		}
	}

	public String createSlHoliday(IBoSlHolidayValue aObj) throws Exception {
		if (!(aObj instanceof DataContainer))
			throw new AIException("业务对象Bean实例不为DataContainer");
		DataContainer dataContainer = (DataContainer) aObj;
		if (dataContainer.isNew() == false)
			throw new AIException("业务对象Bean实例不为新建模式实例");
		String[] keys = (String[]) dataContainer.getKeyProperties().keySet().toArray(new String[] {});
		if (null != keys && keys.length > 0) {
			String id = ((DataContainer) aObj).getAsString(keys[0]);
			if (null == id || "".equals(id)) {
				BigDecimal manid = BoSlHolidayEngine.getNewId();
				dataContainer.set(keys[0], manid);
			}
		}
		aObj.setState(1);
		BoSlHolidayEngine.save(aObj);
		return ((DataContainer) aObj).getAsString(keys[0]);
	}

	public ArrayList createSlHoliday(IBoSlHolidayValue[] aObj) throws Exception {
		ArrayList li = new ArrayList();
		for (int i = 0; i < aObj.length; i++) {
			String ret = createSlHoliday(aObj[i]);
			li.add(ret);
		}
		return li;
	}

	public void batchCreateSlHoliday(IBoSlHolidayValue[] aObj) throws Exception {
		if (null != aObj && aObj.length > 0) {
			DataContainer dataContainer = (DataContainer) aObj[0];
			String[] keys = (String[]) dataContainer.getKeyProperties().keySet().toArray(new String[] {});
			String id = null;
			if (null != keys && keys.length > 0) {
				id = dataContainer.getAsString(keys[0]);
			}
			for (int i = 0; i < aObj.length; i++) {
				if (null == id || "".equals(id)) {
					BigDecimal manid = BoSlHolidayEngine.getNewId();
					aObj[i].set(keys[0], manid);
				}
			}
			BoSlHolidayEngine.saveBatch(aObj);
		}
	}

	public void modifySlHoliday(IBoSlHolidayValue aObj) throws Exception {
		if (!(aObj instanceof DataContainer))
			throw new AIException("业务对象Bean实例不为DataContainer");
		DataContainer dataContainer = (DataContainer) aObj;
		if (dataContainer.isModified() == false)
			throw new AIException("业务对象Bean实例不为修改模式实例");
		//ActionUtil.fillLogInfoData((DataContainer)aObj);
		BoSlHolidayEngine.save(aObj);
	}

	public void batchModifySlHoliday(IBoSlHolidayValue[] aObj) throws Exception {
		BoSlHolidayEngine.saveBatch(aObj);
	}

	public void modifySlHoliday(IBoSlHolidayValue cond, String acond, HashMap map, IBoSlHolidayValue value) throws Exception {
		StringBuffer sb = new StringBuffer();
		if (null == map)
			map = new HashMap();
		buildUpdateHead((DataContainer) value, sb, map);
		buildCriteria((DataContainer) cond, acond, sb, map);
		exeSql(sb.toString(), map);
	}

	public void deleteSlHoliday(IBoSlHolidayValue aObj) throws Exception {
		((DataContainer) aObj).setStsToOld();
		((DataContainer) aObj).delete();
		BoSlHolidayEngine.save(aObj);
	}

	public void batchDeleteSlHoliday(IBoSlHolidayValue[] aObj) throws Exception {
		if (null != aObj) {
			for (int i = 0; i < aObj.length; i++) {
				((DataContainer) aObj[i]).setStsToOld();
				((DataContainer) aObj[i]).delete();
			}
			batchModifySlHoliday(aObj);
		}
	}


	public java.sql.Timestamp getSysDate() throws Exception {
		return BoSlHolidayEngine.getSysDate();
	}

	public long getDoneCode() throws Exception {
		return ServiceManager.getDoneCode();
	}
	
    public BigDecimal getNewId() throws Exception{
		return BoSlHolidayEngine.getNewId();
	}
	
	/**   
	 * 转换查询条件
	 *
	 * @param dataContainer
	 * @param addOnCondition
	 * @param criteria
	 * @param retCriteriaList
	 * @throws Exception
	 * @return：返回结果描述
	 */
	protected void buildCriteria(DataContainer dataContainer, String addOnCondition, StringBuffer criteria, Map retCriteriaList) throws Exception {
		if (dataContainer != null) {
			Map ps = dataContainer.getProperties();
			for (java.util.Iterator cc = ps.entrySet().iterator(); cc.hasNext();) {
				Map.Entry e = (Map.Entry) cc.next();
				if (e.getValue() != null) {
					if (criteria.length() > 0)
						criteria.append(" and ");
					criteria.append(e.getKey().toString() + " = :p_" + e.getKey().toString());
					retCriteriaList.put("p_" + e.getKey().toString(), e.getValue());
				}
			}
		}
		if (criteria.length() > 0 && StringUtils.isBlank(addOnCondition) == false)
			criteria.append(" and ");
		if (StringUtils.isBlank(addOnCondition) == false)
			criteria.append(addOnCondition);
	}

	/**   
	 * 构建数据更新头信息
	 *
	 * @param dataContainer
	 * @param sb
	 * @param map
	 * @throws Exception
	 * @return：返回结果描述
	 * @throws：异常描述
	 */
	protected void buildUpdateHead(DataContainer dataContainer, StringBuffer sb, HashMap map) throws Exception {
		if (null == sb)
			sb = new StringBuffer();
		if (null == map)
			map = new HashMap();
		if (dataContainer != null) {
			Map ps = dataContainer.getProperties();
			for (java.util.Iterator cc = ps.entrySet().iterator(); cc.hasNext();) {
				Map.Entry e = (Map.Entry) cc.next();
				if (e.getValue() != null) {
					if (sb.length() > 0)
						sb.append(" , ");
					sb.append(e.getKey().toString() + "=:V_" + e.getKey().toString());
					map.put("V_" + e.getKey().toString(), e.getValue());
				}
			}
			if (sb.length() > 0) {
				sb.append(" WHERE 1=1 ");
				sb.insert(0, "UPDATE " + dataContainer.fetchTableName() + " SET ");
			} else {
				throw new Exception("没有设置修改的数据值!");
			}
		} else {
			throw new Exception("没有设置修改的数据值!");
		}
	}
}
