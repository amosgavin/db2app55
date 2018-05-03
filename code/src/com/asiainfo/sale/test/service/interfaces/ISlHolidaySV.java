package com.asiainfo.sale.test.service.interfaces;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import com.asiainfo.sale.test.ivalues.IBoSlHolidayValue;


/**   
 * Copyright: Copyright (c) 2012 Asiainfo-Linkage
 * 
 * @Description: SL_HOLIDAY Service�ӿ�
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
public interface ISlHolidaySV {
	
	public IBoSlHolidayValue getEmptySlHoliday() throws Exception, RemoteException;

	/**
	 * ��������ȡSL_HOLIDAY��Ϣ
	 * 
	 * @param id
	 * @return IBoSlHolidayValue
	 * @throws Exception
	 */
	public IBoSlHolidayValue getSlHolidayByID(BigDecimal id) throws Exception, RemoteException;

	/**
	 * ����������ȡSL_HOLIDAY��Ϣ
	 * 
	 * @param aCond
	 * @param AddInCond
	 * @return IBoSlHolidayValue[]
	 * @throws Exception
	 */
	public IBoSlHolidayValue[] getSlHoliday(IBoSlHolidayValue aCond, String AddInCond, HashMap map) throws Exception, RemoteException;

	/**
	 * ��������ѯ��¼����
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getSlHolidayCountFromWhereSql(String sql, HashMap map) throws Exception, RemoteException;

	/**
	 * �������ֶβ�ѯ
	 * 
	 * @param sql
	 * @param map
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 */
	public IBoSlHolidayValue[] getSlHolidayFromWhereSql(String sql, HashMap map, int start, int end) throws Exception, RemoteException;
	
	/**
	 * ��������ѯ��¼����
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getCount(String id,String name) throws Exception, RemoteException;

	/**
	 * �������ֶβ�ѯ
	 * 
	 * @param sql
	 * @param map
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 */
	public IBoSlHolidayValue[] getSelect(String id, String name, int start, int end) throws Exception, RemoteException;
	
	

	/**
	 * ִ��һ��SQL���
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void exeSql(String sql, HashMap map) throws Exception, RemoteException;

	/**
	 * ����SL_HOLIDAY��Ϣ
	 * 
	 * @param aObj
	 * @return Object
	 * @throws Exception
	 */
	public String createSlHoliday(IBoSlHolidayValue aObj) throws Exception, RemoteException;

	/**
	 * ����һ��SL_HOLIDAY��Ϣ
	 * 
	 * @param aObj
	 * @return Object
	 * @throws Exception
	 */
	public ArrayList createSlHolidays(IBoSlHolidayValue[] aObj) throws Exception, RemoteException;

	/**
	 * ��������SL_HOLIDAY[]��Ϣ
	 * 
	 * @param aObj
	 * @return
	 * @throws Exception
	 */
	public void batchCreateSlHoliday(IBoSlHolidayValue[] aObj) throws Exception, RemoteException;

	/**
	 * �޸�һ��SL_HOLIDAY��Ϣ
	 * 
	 * @param aObj
	 * @return boolean
	 * @throws Exception
	 */
	public boolean modifySlHoliday(IBoSlHolidayValue aObj) throws Exception, RemoteException;

	/**
	 * �޸�һ��SL_HOLIDAY��Ϣ
	 * 
	 * @param aObj
	 * @return boolean
	 * @throws Exception
	 */
	public boolean modifySlHolidays(IBoSlHolidayValue[] aObj) throws Exception, RemoteException;

	/**
	 * �����޸�SL_HOLIDAY[]��Ϣ
	 * 
	 * @param aObj
	 * @return
	 * @throws Exception
	 */
	public void batchModifySlHoliday(IBoSlHolidayValue[] aObj) throws Exception, RemoteException;

	/**
	 * ɾ��һ��SL_HOLIDAY��Ϣ
	 * 
	 * @param aObj
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteSlHoliday(IBoSlHolidayValue aObj) throws Exception, RemoteException;

	/**
	 * ɾ��һ��SL_HOLIDAY��Ϣ
	 * 
	 * @param aObj
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteSlHolidays(IBoSlHolidayValue[] aObj) throws Exception, RemoteException;

	public BigDecimal getNewId() throws Exception, RemoteException;

	public java.sql.Timestamp getSysDate() throws Exception, RemoteException;

}
