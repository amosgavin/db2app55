package com.asiainfo.costWarn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.costWarn.bo.BOConfigureBean;
import com.asiainfo.costWarn.ivalues.IBOConfigureValue;
import com.asiainfo.costWarn.service.interfaces.IConfigureSV;


public class ConfigureAction extends BaseAction{
	private transient static Log log = LogFactory.getLog(ConfigureAction.class);
	
	IBOConfigureValue[] Values = null;

	public void save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOConfigureBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "没有修改需要保存！");
			return;
		}

		IBOConfigureValue[] vls = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof IBOConfigureValue[]) {
				vls = (IBOConfigureValue[]) obj;
			}
		}

		IConfigureSV iconfigureSV = (IConfigureSV) ServiceFactory
				.getService(IConfigureSV.class);

		try {
			if (null == vls || 0 == vls.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else if (1 == vls.length) {
				iconfigureSV.save(vls[0]);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	public void deleteconfigure(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOConfigureBean.class });

		// 前台提交的数据
		IBOConfigureValue[] vls = null;// 前台提交的数据
		//IBOSaleWeaponValue[] saleWeaponValues2 = null;
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof IBOConfigureValue[]) {
				vls = (IBOConfigureValue[]) obj;
			}
		}
		
		String staffid = vls[0].getStaffid();
		IConfigureSV iconfigureSV = (IConfigureSV) ServiceFactory
		.getService(IConfigureSV.class);
		Values = iconfigureSV.getStaffid(staffid);
		try {
			if (dcLists.length > 0) {
				iconfigureSV.deleteconfigure(Values);
				}
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("操作员工信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	}
	