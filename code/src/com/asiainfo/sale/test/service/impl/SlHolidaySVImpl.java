package com.asiainfo.sale.test.service.impl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.sale.test.TestFactory;
import com.asiainfo.sale.test.dao.interfaces.ISlHolidayDAO;
import com.asiainfo.sale.test.ivalues.IBoSlHolidayValue;
import com.asiainfo.sale.test.service.interfaces.ISlHolidaySV;

/**   
 * Copyright: Copyright (c) 2012 Asiainfo-Linkage
 * 
 * @Description: SL_HOLIDAY Service µœ÷
 *
 * @version: v1.0.0
 * @author: yanghesi
 * @date: 2012-02-21 15:33:38 
 *
 * Modification History:</br>
 * Date         Author          Version            Description</br>
 *---------------------------------------------------------</br>
 * 2012-02-21     yanghesi           v1.0.0               Auto Generated</br>
 */
public class SlHolidaySVImpl implements ISlHolidaySV {

	private final static Log log = LogFactory.getLog(SlHolidaySVImpl.class);

	public IBoSlHolidayValue getEmptySlHoliday() throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		return idao.getEmptySlHoliday();
	}

	public IBoSlHolidayValue getSlHolidayByID(BigDecimal id) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		return idao.getSlHoliday(id);
	}

	public IBoSlHolidayValue[] getSlHoliday(IBoSlHolidayValue aCond, String AddInCond, HashMap map) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		return idao.getSlHoliday(aCond, AddInCond, map);
	}

	public int getSlHolidayCountFromWhereSql(String sql, HashMap map) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		return idao.getSlHolidayCountFromWhereSql(sql, map);
	}

	public IBoSlHolidayValue[] getSlHolidayFromWhereSql(String sql, HashMap map, int start, int end) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		return idao.getSlHolidayFromWhereSql(sql, map, start, end);
	}

	public int getCount(String id,String name) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		if(StringUtils.isEmpty(id)){
			
		}
		String sql = "";
		HashMap map = new HashMap();
		return idao.getSlHolidayCountFromWhereSql(sql, map);
	}

	public IBoSlHolidayValue[] getSelect(String id, String name, int start, int end) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		String sql = "";
		HashMap map = new HashMap();
		return idao.getSlHolidayFromWhereSql(sql, map, start, end);
	}
	
	
	public void exeSql(String sql, HashMap map) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		idao.exeSql(sql, map);
	}

	public String createSlHoliday(IBoSlHolidayValue aObj) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		String ret = idao.createSlHoliday(aObj);
		return ret;
	}

	public ArrayList createSlHolidays(IBoSlHolidayValue[] aObj) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		ArrayList li = new ArrayList();
		for (int i = 0; i < aObj.length; i++) {
			Object ret = idao.createSlHoliday(aObj[i]);
			li.add(ret);
		}
		return li;
	}

	public void batchCreateSlHoliday(IBoSlHolidayValue[] aObj) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		idao.batchCreateSlHoliday(aObj);
	}

	public boolean modifySlHoliday(IBoSlHolidayValue aObj) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		idao.modifySlHoliday(aObj);
		return true;
	}

	public boolean modifySlHolidays(IBoSlHolidayValue[] aObj) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		for (int i = 0; i < aObj.length; i++) {
			idao.modifySlHoliday(aObj[i]);
		}
		return true;
	}

	public void batchModifySlHoliday(IBoSlHolidayValue[] aObj) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		idao.batchModifySlHoliday(aObj);
	}

	public boolean deleteSlHoliday(IBoSlHolidayValue aObj) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		idao.deleteSlHoliday(aObj);
		return true;
	}

	public boolean deleteSlHolidays(IBoSlHolidayValue[] aObj) throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		for (int i = 0; i < aObj.length; i++) {
			idao.deleteSlHoliday(aObj[i]);
		}
		return true;
	}

	public java.sql.Timestamp getSysDate() throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		return idao.getSysDate();
	}

	public BigDecimal getNewId() throws Exception, RemoteException {
		ISlHolidayDAO idao = TestFactory.getSlHolidayDAO();
		return idao.getNewId();
	}
}
