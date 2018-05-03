package com.asiainfo.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.common.ivalues.IBOItemOtherInfoValue;
import com.asiainfo.common.service.interfaces.IItemOtherInfoSV;
import com.asiainfo.sale.util.StringUtil;

public class ItemOtherInfoAction extends BaseAction {

	private transient static Log log = LogFactory
			.getLog(ItemOtherInfoAction.class);

	public void getAdDateInConf(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String advDate = "";
		String itemId = request.getParameter("itemId");
		String itemType = request.getParameter("itemType");
		String taskTag = request.getParameter("taskTag");
		String taskReceiverOpid = request.getParameter("taskReceiverOpid");
		IItemOtherInfoSV itemSV = (IItemOtherInfoSV) ServiceFactory
				.getService(IItemOtherInfoSV.class);
		try {
			IBOItemOtherInfoValue itemOtherInfo = itemSV
					.getItemOtherInfoByIdAndTag(itemId, taskTag);
			if (itemOtherInfo != null) {
				advDate = itemOtherInfo.getAdviseDealTime().toString();
				cp.set("advDate", advDate);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			} else {
				if (itemSV.moreThanMaxTaskPerMan(taskReceiverOpid, itemType)) {
					advDate = itemSV.getAdviseDate(itemType, "", itemSV
							.getNeedDays(itemId, itemType));
					cp.set("advDate", advDate);
					cp.set("FLAG", "N");
					cp.set("MESSAGE", "任务接受人手上任务偏多，请发其他人处理！");
				} else {
					// advDate = itemSV.getAdviseDate("2013-12-25 17:10:05", 7);
					// advDate = itemSV.getAdviseDate(itemType, itemSV
					// .getLastTaskEndTime(taskReceiverOpid), itemSV
					// .getNeedDays(itemId, itemType));
					advDate = itemSV.getAdviseDate(itemType, "", itemSV
							.getNeedDays(itemId, itemType));
					cp.set("advDate", advDate);
					cp.set("FLAG", "Y");
					cp.set("MESSAGE", "操作成功！");
				}

			}
		} catch (Exception e) {
			// 操作失败
			log.error("操作出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void getAdDateInGeneral(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String advDate = "";
		String itemId = request.getParameter("itemId");
		String taskTag = request.getParameter("taskTag");
		String needDays = request.getParameter("needDays");
		IItemOtherInfoSV itemSV = (IItemOtherInfoSV) ServiceFactory
				.getService(IItemOtherInfoSV.class);
		try {
			IBOItemOtherInfoValue itemOtherInfo = itemSV
					.getItemOtherInfoByIdAndTag(itemId, taskTag);
			if (itemOtherInfo != null
					&& itemOtherInfo.getAdviseDealTime() != null) {

				advDate = itemOtherInfo.getAdviseDealTime().toString();
				cp.set("advDate", advDate);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			} else {
				if (StringUtil.isBlank(needDays)) {
					cp.set("advDate", "");
					cp.set("FLAG", "N");
					cp.set("MESSAGE", "");
				} else {
					advDate = itemSV.getAdviseDate("", "", Integer
							.parseInt(needDays));
					cp.set("advDate", advDate);
					cp.set("FLAG", "Y");
					cp.set("MESSAGE", "操作成功！");
				}
			}
		} catch (Exception e) {
			// 操作失败
			log.error("操作出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void saveItemOtherInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String advDate = request.getParameter("advDate");
		String itemId = request.getParameter("itemId");
		String taskTag = request.getParameter("taskTag");
		String delayReason = request.getParameter("delayReason");
		String approveFlag = request.getParameter("approveFlag");
		IItemOtherInfoSV itemSV = (IItemOtherInfoSV) ServiceFactory
				.getService(IItemOtherInfoSV.class);
		try {
			itemSV.saveAdviseFinishDate(itemId, taskTag, advDate, delayReason,
					approveFlag);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("操作出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void reComputeAdviseDate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String advDate = "";
		String itemId = request.getParameter("itemId");
		String itemType = request.getParameter("itemType");
		String taskTag = request.getParameter("taskTag");
		String reAuthorOpid = request.getParameter("reAuthorOpid");
		String node = request.getParameter("node");
		IItemOtherInfoSV itemSV = (IItemOtherInfoSV) ServiceFactory
				.getService(IItemOtherInfoSV.class);
		try {
			if (node.equals("pz")) {

				// advDate = itemSV.getAdviseDate("2013-12-25 17:10:05", 7);
				advDate = itemSV.getAdviseDate(itemType, "", itemSV
						.getNeedDays(itemId, itemType));
				itemSV.saveAdviseFinishDate(itemId, taskTag, advDate.substring(
						0, 10), "", null);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			} else if (node.equals("test")) {
				advDate = itemSV.getAdviseDate("", "", 3);
				itemSV.saveAdviseFinishDate(itemId, taskTag, advDate.substring(
						0, 10), "", null);
				cp.set("advDate", advDate);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("操作出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
