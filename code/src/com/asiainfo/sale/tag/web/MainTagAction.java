package com.asiainfo.sale.tag.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.tag.bo.BOApplyTagBean;
import com.asiainfo.sale.tag.ivalues.IBOApplyTagValue;
import com.asiainfo.sale.tag.service.interfaces.ITagMainSV;


public class MainTagAction extends BaseAction{

	private transient static Log log = LogFactory.getLog(MainTagAction.class);

	public void saveMainTag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOApplyTagBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		IBOApplyTagValue[] tagMainValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOApplyTagBean[]) {
				tagMainValues = (BOApplyTagBean[]) obj;
			}
		}

		ITagMainSV tagMainSV = (ITagMainSV) ServiceFactory.getService(ITagMainSV.class);

		try {
			if(null == tagMainValues || 0 == tagMainValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				tagMainSV.saveTagMain(tagMainValues[0]);
			}
			cp.set("ADDID", "");
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存营销案主信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
