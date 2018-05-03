package com.asiainfo.sale.access.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.access.bo.BOBusiChangeDetailBean;
import com.asiainfo.sale.access.ivalues.IBOBusiChangeDetailValue;
import com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV;

public class BusiChangeDetailAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(BusiChangeDetailAction.class);

	public void saveBusiChangeDetailInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOBusiChangeDetailValue[] busiChangeDetailValues = null;// 前台提交的数据

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil
				.getDataContainerLists(request.getInputStream(),
						new Class[] { BOBusiChangeDetailBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOBusiChangeDetailBean[]) {
				busiChangeDetailValues = (BOBusiChangeDetailBean[]) obj;
			}
		}
		IBusiChangeDetailSV busiChangeDetailSV = (IBusiChangeDetailSV) ServiceFactory
				.getService(IBusiChangeDetailSV.class);

		try {
			if (null == busiChangeDetailValues
					|| 0 == busiChangeDetailValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else if (1 == busiChangeDetailValues.length) {
				String relId = busiChangeDetailSV
						.saveBusiChangeDetail(busiChangeDetailValues[0]);
				cp.set("FLAG", "Y");
				cp.set("RELID", relId);
				cp.set("MESSAGE", "操作成功！");
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作失败！");
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

	public void isExistBatchId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String batchId = request.getParameter("batchId");
		String batchType = request.getParameter("batchType");
		IBusiChangeDetailSV busiChangeDetailSV = (IBusiChangeDetailSV) ServiceFactory
				.getService(IBusiChangeDetailSV.class);

		try {
			if (busiChangeDetailSV.isExistBatchId(batchId, batchType)) {
				cp.set("FLAG", "Y");
			} else {
				cp.set("FLAG", "N");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("执行出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}

	public void deleteBusiChangeDetailBatch(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOBusiChangeDetailValue[] busiChangeDetailValues = null;// 前台提交的数据

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil
				.getDataContainerLists(request.getInputStream(),
						new Class[] { BOBusiChangeDetailBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOBusiChangeDetailBean[]) {
				busiChangeDetailValues = (BOBusiChangeDetailBean[]) obj;
			}
		}
		IBusiChangeDetailSV busiChangeDetailSV = (IBusiChangeDetailSV) ServiceFactory
				.getService(IBusiChangeDetailSV.class);

		try {
			if (null == busiChangeDetailValues
					|| 0 == busiChangeDetailValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有记录需要删除！");
			} else {
				busiChangeDetailSV
						.deleteBusiChangeDetailBatch(busiChangeDetailValues);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("删除操作出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}
}
