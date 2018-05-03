package com.asiainfo.sale.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.test.bo.BoSlHolidayBean;
import com.asiainfo.sale.test.ivalues.IBoSlHolidayValue;
import com.asiainfo.sale.test.service.interfaces.ISlHolidaySV;
import com.asiainfo.sale.test.TestFactory;
import com.asiainfo.sale.util.ActionUtil;

/**   
 * Copyright: Copyright (c) 2012 Asiainfo-Linkage
 * 
 * @Description: SL_HOLIDAY Action
 *
 * @version: v1.0.0
 * @author: yanghesi
 * @date: 2012-02-21 15:33:38 
 *
 * Modification History:</br>
 * Date         Author          Version            Description</br>
 *---------------------------------------------------------</br>
 * 2012-02-21     yanghesi           v1.0.0              Auto Generated</br>
 */
public class SlHolidayAction extends BaseAction {
	
	private final static Log log = LogFactory.getLog(SlHolidayAction.class);

	/**
	 * 增加SL_HOLIDAY信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addSlHoliday(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		try {
			ISlHolidaySV sv = TestFactory.getSlHolidaySV();
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request.getInputStream(), new Class[] { BoSlHolidayBean.class });
			IBoSlHolidayValue[] beanValues = (IBoSlHolidayValue[]) (dcLists[0].getColDataContainerInterface(0));
			if (null != beanValues && beanValues.length > 0) {
				Object retValue = sv.createSlHoliday(beanValues[0] );
				cp.set("MESSAGE", "[新增成功能]新增SL_HOLIDAY主键为:" + retValue.toString());
				cp.set("NEWID", retValue.toString());
				cp.set("IsOk", "TRUE");
			} else {
				cp.set("IsOk", "FALSE");
				cp.set("MESSAGE", "没有需要增加的信息");
			}
		} catch (Exception e) {
			log.error("新增SL_HOLIDAY错误:", e);
			cp.set("IsOk", "FALSE");
			cp.set("MESSAGE", e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	/**
	 * 修改SL_HOLIDAY信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void modifySlHoliday(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		try {
			ISlHolidaySV sv = TestFactory.getSlHolidaySV();
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request.getInputStream(), new Class[] { BoSlHolidayBean.class });
			IBoSlHolidayValue[] beanValues = (IBoSlHolidayValue[]) (dcLists[0].getColDataContainerInterface(0));
			if (null != beanValues && beanValues.length > 0) {
				boolean retValue = sv.modifySlHoliday(beanValues[0]);
				if (retValue) {
					cp.set("MESSAGE", "修改成功");
					cp.set("IsOk", "TRUE");
				} else {
					cp.set("MESSAGE", "修改失败");
					cp.set("IsOk", "FALSE");
				}
			} else {
				cp.set("IsOk", "FALSE");
				cp.set("MESSAGE", "没有需要修改的信息");
			}
		} catch (Exception e) {
			log.error("修改SL_HOLIDAY错误:", e);
			cp.set("IsOk", "FALSE");
			cp.set("MESSAGE", e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	
	public void del(HttpServletRequest request, HttpServletResponse response) throws Exception{
		CustomProperty cp = CustomProperty.getInstance();
		try {
			ISlHolidaySV sv = TestFactory.getSlHolidaySV();
			String ids = HttpUtil.getParameter(request,"ids");
			String sql = "delete from sl_holiday where holiday_id in ("+ids+")";
			sv.exeSql(sql,null);
		} catch (Exception e) {
			log.error("删除SL_HOLIDAY错误:", e);
			cp.set("IsOk", "FALSE");
			cp.set("MESSAGE", e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	
}
