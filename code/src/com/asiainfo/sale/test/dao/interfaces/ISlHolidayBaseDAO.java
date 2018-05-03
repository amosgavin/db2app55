package com.asiainfo.sale.test.dao.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import com.asiainfo.sale.test.ivalues.IBoSlHolidayValue;

/**   
 * Copyright: Copyright (c) 2012 Asiainfo-Linkage
 * 
 * @Description: SL_HOLIDAYDAO接口
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
	 * 获取一个空的BoBean对象
	 *
	 * @return 返回一个空的BoBean对象
	 * @throws Exception
	 */
	public IBoSlHolidayValue getEmptySlHoliday() throws Exception;

	/**
	 * 按主建获取SL_HOLIDAY
	 * 
	 * @param id
	 * @return IBoSlHolidayValue
	 * @throws Exception
	 */
	public IBoSlHolidayValue getSlHoliday(Object id) throws Exception;

	/**
	 * 根据条件获取SL_HOLIDAY
	 * 
	 * @param aCond
	 * @param AddInCond
	 * @return IBoSlHolidayValue[]
	 * @throws Exception
	 */
	public IBoSlHolidayValue[] getSlHoliday(IBoSlHolidayValue aCond, String AddInCond, HashMap map) throws Exception;

	/**
	 * 按条件查询记录条数
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getSlHolidayCountFromWhereSql(String sql, HashMap map) throws Exception;

	/**
	 * 按条件分段查询
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
	 * 按SQL查询
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public IBoSlHolidayValue[] getSlHolidayFromSql(String sql, HashMap map) throws Exception;

	/**
	 * 按SQL查询
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getCountSlHolidayFromSql(String sql, HashMap map) throws Exception;

	/**
	 * 按BO文件中的SQL查询
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public IBoSlHolidayValue[] getSlHolidayFromBO(String sql, HashMap map) throws Exception;

	/**
	 * 执行一条SQL语句
	 * 
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void exeSql(String sql, HashMap map) throws Exception;

	/**
	 * 新增SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return Object
	 * @throws Exception
	 */
	public String createSlHoliday(IBoSlHolidayValue aObj) throws Exception;

	/**
	 * 新增SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return Object
	 * @throws Exception
	 */
	public ArrayList createSlHoliday(IBoSlHolidayValue[] aObj) throws Exception;

	/**
	 * 批量新增SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return
	 * @throws Exception
	 */
	public void batchCreateSlHoliday(IBoSlHolidayValue[] aObj) throws Exception;

	/**
	 * 修改一条SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return boolean
	 * @throws Exception
	 */
	public void modifySlHoliday(IBoSlHolidayValue aObj) throws Exception;

	/**
	 * 批量修改接口报文日志[]信息
	 * 
	 * @param aObj
	 * @return
	 * @throws Exception
	 */
	public void batchModifySlHoliday(IBoSlHolidayValue[] aObj) throws Exception;

	/**
	 * 根据条件修改数据
	 * 
	 * @param cond
	 *            查询条件
	 * @param acond
	 *            查询条件
	 * @param map
	 *            邦定变量
	 * @param value
	 *            修改后的值
	 * @throws Exception
	 */
	public void modifySlHoliday(IBoSlHolidayValue cond, String acond, HashMap map, IBoSlHolidayValue value) throws Exception;

	/**
	 * 删除一条SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return boolean
	 * @throws Exception
	 */
	public void deleteSlHoliday(IBoSlHolidayValue aObj) throws Exception;

	/**
	 * 批量删除SL_HOLIDAY
	 * 
	 * @param aObj
	 * @return boolean
	 * @throws Exception
	 */
	public void batchDeleteSlHoliday(IBoSlHolidayValue[] aObj) throws Exception;


	/**   
	 * 返回系统时间
	 *
	 * @return
	 * @throws Exception
	 * @return：返回系统时间
	 *
	 */
	public java.sql.Timestamp getSysDate() throws Exception;

	/**   
	 * 返回操作流水
	 *
	 * @return
	 * @throws Exception
	 * @return：返回操作流水
	 *
	 */
	public long getDoneCode() throws Exception;

	/**   
	 * 返回新的主键编号
	 *
	 * @return 返回新的主键编号
	 */
	public BigDecimal getNewId() throws Exception;
}
