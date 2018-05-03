package com.asiainfo.sale.test.dao.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import com.asiainfo.sale.test.ivalues.IBoSlHolidayValue;

/**   
 * Copyright: Copyright (c) 2012 Asiainfo-Linkage
 * 
 * @Description: SL_HOLIDAYDAO�ӿ�
 * <p>Auto Generated. Please don't Modify!!</p>
 *
 * @version: v1.0.0
 * @author: yanghesi
 * @date: 2012-02-21 15:33:37 
 *
 * Modification History:</br>
 * Date         Author          Version            Description</br>
 *---------------------------------------------------------</br>
 * 2012-02-21     yanghesi           v1.0.0               Auto Generated</br>
 */
public interface ISlHolidayBaseDAO {

	/**   
	 * ��ȡһ���յ�BoBean����
	 *
	 * @return ����һ���յ�BoBean����
	 * @throws Exception
	 */
	public IBoSlHolidayValue getEmptySlHoliday() throws Exception;

	/**
	 * ��������ȡSL_HOLIDAY
	 * 
	 * @param id
	 * @return IBoSlHolidayValue
	 * @throws Exception
	 */
	public IBoSlHolidayValue getSlHoliday(Object id) throws Exception;

	/**
	 * ����������ȡSL_HOLIDAY
	 * 
	 * @param aCond
	 * @param AddInCond
	 * @return IBoSlHolidayValue[]
	 * @throws Exception
	 */
	public IBoSlHolidayValue[] getSlHoliday(IBoSlHolidayValue aCond, String AddInCond, HashMap map) throws Exception;

	/**
	 * ��������ѯ��¼����
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getSlHolidayCountFromWhereSql(String sql, HashMap map) throws Exception;

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
	public IBoSlHolidayValue[] getSlHolidayFromWhereSql(String sql, HashMap map, int start, int end) throws Exception;

	/**
	 * ��SQL��ѯ
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public IBoSlHolidayValue[] getSlHolidayFromSql(String sql, HashMap map) throws Exception;

	/**
	 * ��SQL��ѯ
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getCountSlHolidayFromSql(String sql, HashMap map) throws Exception;

	/**
	 * ��BO�ļ��е�SQL��ѯ
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public IBoSlHolidayValue[] getSlHolidayFromBO(String sql, HashMap map) throws Exception;

	/**
	 * ִ��һ��SQL���
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void exeSql(String sql, HashMap map) throws Exception;

	/**
	 * ����SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return Object
	 * @throws Exception
	 */
	public String createSlHoliday(IBoSlHolidayValue aObj) throws Exception;

	/**
	 * ����SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return Object
	 * @throws Exception
	 */
	public ArrayList createSlHoliday(IBoSlHolidayValue[] aObj) throws Exception;

	/**
	 * ��������SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return
	 * @throws Exception
	 */
	public void batchCreateSlHoliday(IBoSlHolidayValue[] aObj) throws Exception;

	/**
	 * �޸�һ��SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return boolean
	 * @throws Exception
	 */
	public void modifySlHoliday(IBoSlHolidayValue aObj) throws Exception;

	/**
	 * �����޸Ľӿڱ�����־[]��Ϣ
	 * 
	 * @param aObj
	 * @return
	 * @throws Exception
	 */
	public void batchModifySlHoliday(IBoSlHolidayValue[] aObj) throws Exception;

	/**
	 * ���������޸�����
	 * 
	 * @param cond
	 *            ��ѯ����
	 * @param acond
	 *            ��ѯ����
	 * @param map
	 *            �����
	 * @param value
	 *            �޸ĺ��ֵ
	 * @throws Exception
	 */
	public void modifySlHoliday(IBoSlHolidayValue cond, String acond, HashMap map, IBoSlHolidayValue value) throws Exception;

	/**
	 * ɾ��һ��SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return boolean
	 * @throws Exception
	 */
	public void deleteSlHoliday(IBoSlHolidayValue aObj) throws Exception;

	/**
	 * ����ɾ��SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return boolean
	 * @throws Exception
	 */
	public void batchDeleteSlHoliday(IBoSlHolidayValue[] aObj) throws Exception;


	/**   
	 * ����ϵͳʱ��
	 *
	 * @return
	 * @throws Exception
	 * @return������ϵͳʱ��
	 *
	 */
	public java.sql.Timestamp getSysDate() throws Exception;

	/**   
	 * ���ز�����ˮ
	 *
	 * @return
	 * @throws Exception
	 * @return�����ز�����ˮ
	 *
	 */
	public long getDoneCode() throws Exception;

	/**   
	 * �����µ��������
	 *
	 * @return �����µ��������
	 */
	public BigDecimal getNewId() throws Exception;
}
