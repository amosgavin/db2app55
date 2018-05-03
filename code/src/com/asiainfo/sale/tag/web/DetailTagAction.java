package com.asiainfo.sale.tag.web;

import java.net.URLDecoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.comframe.client.ComframeClient;
import com.asiainfo.sale.activity.bo.BOSaleDetailBean;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.service.interfaces.IRelateSaleWithGoodsSV;
import com.asiainfo.sale.tag.bo.BOHPApplyBean;
import com.asiainfo.sale.tag.bo.BOHPPromationTagBean;
import com.asiainfo.sale.tag.bo.BOPromationTagBean;
import com.asiainfo.sale.tag.ivalues.IBOHPApplyValue;
import com.asiainfo.sale.tag.ivalues.IBOHPPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.sale.tag.service.interfaces.ITagDetailSV;
import com.asiainfo.workflow.workflowstat.bo.BOWorkflowStatBean;

public class DetailTagAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(DetailTagAction.class);

	public void saveDetailTag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		int pid = Integer.parseInt(request.getParameter("pid"));
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOPromationTagBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		IBOPromationTagValue[] tagDetailValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOPromationTagBean[]) {
				tagDetailValues = (BOPromationTagBean[]) obj;
			}
		}

		ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);

		try {
			if (null == tagDetailValues || 0 == tagDetailValues.length) {

				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {

				String tagCodeStr = "'" + tagDetailValues[0].getTagCode() + "'";

				for (int i = 1; i < tagDetailValues.length; ++i) {
					tagCodeStr += ",'" + tagDetailValues[i].getTagCode() + "'";
				}

				/*if (tagDetailSV.getCountByTagCode(tagCodeStr) > 0) {
					cp.set("FLAG", "N");
					cp.set("MESSAGE", "输入的BOSSID与已有标签重复！");
				} else {
				*/
				int addid = tagDetailSV.saveTagDetail(tagDetailValues, pid);
				cp.set("ADDID", String.valueOf(addid));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
				//}
				// for(int i=0;i<=tagDetailValues.length;i++){
				// if(tagDetailValues[i].getTagType().equals("6")){
				//					 
				// }
				// }
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void saveDetailTagOnWeaponAdd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		int pid = Integer.parseInt(request.getParameter("pid"));
		String busi3 = request.getParameter("busi3"); // PRESENT_BUSI3_AMOUNT
		String adopt = request.getParameter("adopt");// GOOD_ADOPT_DIRECTORY
		String rprice = request.getParameter("rprice");// REFERENCE_PRICE
		String saleFlag = request.getParameter("saleFlag");// REFERENCE_PRICE
		IBOPromationTagValue tagDetailValues = new BOPromationTagBean();
		tagDetailValues.setPid(pid);
		// if(saleFlag.equals("16")){
		// tagDetailValues.setTagType("8");
		// tagDetailValues.setState("99");
		// }else{
		tagDetailValues.setTagType("7");
		tagDetailValues.setState("1");
		// }
		tagDetailValues.setCycle(1);
		tagDetailValues.setCharge(Double.valueOf(busi3).doubleValue());
		tagDetailValues.setName(adopt);
		tagDetailValues.setSumcharge(Double.valueOf(rprice).doubleValue());
		tagDetailValues.setArea("10");
		IBOPromationTagValue[] tagDetailArray = new IBOPromationTagValue[1];
		tagDetailArray[0] = tagDetailValues;
		ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);

		try {
			if (null == tagDetailValues || 0 == tagDetailArray.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				tagDetailSV.saveTagDetail(tagDetailArray, pid);
				String wid = String.valueOf(tagDetailArray[0].getId());
				cp.set("wid", wid);
			}
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void isHaveTag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		String tagtype = request.getParameter("tagtype");
		String charge = request.getParameter("charge");
		String cycle = request.getParameter("cycle");
		String suncharge = request.getParameter("suncharge");
		String area = request.getParameter("area");
		String issp = request.getParameter("issp");
		String tagname =request.getParameter("tagname");
		String accounttype = request.getParameter("accounttype");
		ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);
		try {
			// if (tagtype.equals("5") || tagtype.equals("7")) {
			if (tagDetailSV.isHaveTag(tagtype, charge, cycle, suncharge, area,
					issp, tagname, accounttype)) {
				cp.set("ISHAVETAG", "Y");
			} else {
				cp.set("ISHAVETAG", "N");
			}
			/*
			 * } else if (tagtype.equals("3")) { if
			 * (tagDetailSV.isHaveTag(tagtype, charge, cycle, suncharge, area,
			 * issp, "", accounttype)) { cp.set("ISHAVETAG", "Y"); } else {
			 * cp.set("ISHAVETAG", "N"); } cp.set("ISHAVETAG", "N"); } else { if
			 * (tagDetailSV.isHaveTag(tagtype, charge, cycle, suncharge, area,
			 * issp, "", "")) { cp.set("ISHAVETAG", "Y"); } else {
			 * cp.set("ISHAVETAG", "N"); } }
			 */
		} catch (Exception e) {
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void saveDetailZFQTagOnWeaponAdd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		int pid = Integer.parseInt(request.getParameter("pid"));
		String busi2 = request.getParameter("busi2"); // PRESENT_BUSI3_AMOUNT
		IBOPromationTagValue tagDetailValues = new BOPromationTagBean();
		tagDetailValues.setPid(pid);
		tagDetailValues.setTagType("6");
		tagDetailValues.setCycle(1);
		tagDetailValues.setCharge(Double.valueOf(busi2).doubleValue());
		tagDetailValues.setName("支付劵_" + busi2 + "元");
		tagDetailValues.setState("99");
		tagDetailValues.setArea("10");
		IBOPromationTagValue[] tagDetailArray = new IBOPromationTagValue[1];
		tagDetailArray[0] = tagDetailValues;
		ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);

		try {
			if (null == tagDetailValues || 0 == tagDetailArray.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				tagDetailSV.saveTagDetail(tagDetailArray, pid);
				String wid = String.valueOf(tagDetailArray[0].getId());
				cp.set("wid", wid);
			}
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

	public void updateStateToReady(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);

		int pid = Integer.parseInt(request.getParameter("pid"));
		String[] idListStr = (request.getParameter("idListStr")).split(",");
		int length = idListStr.length - 1;
		IBOPromationTagValue[] promationTags = new IBOPromationTagValue[length];

		for (int i = 0; i < length; ++i) {
			int id = Integer.parseInt(idListStr[i + 1]);
			promationTags[i] = tagDetailSV.getTagDetailById(id);
			// promationTags[i].setState("2");
			promationTags[i].setPid(pid);

		}
		tagDetailSV.saveTagDetail(promationTags, 0);
	}

	public void updateStateToUsed(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);
		int weaponId = Integer.parseInt(request.getParameter("weaponId"));
		IBOPromationTagValue[] promationTags = tagDetailSV
				.getSpareTagDetailByWeaponId(weaponId);

		for (int i = 0; i < promationTags.length; ++i) {
			if (promationTags[i] != null) {
				promationTags[i].setState("1");
			}
		}
		tagDetailSV.saveTagDetail(promationTags, 0);
	}

	public void deleteDetailTag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOPromationTagBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		IBOPromationTagValue[] tagDetailValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOPromationTagBean[]) {
				tagDetailValues = (BOPromationTagBean[]) obj;
			}
		}

		ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);

		try {
			if (null == tagDetailValues || 0 == tagDetailValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				tagDetailSV.delTagDetail(tagDetailValues);
			}
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

	public void saveGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String staffId = String.valueOf(SessionManager.getUser().getID());
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOHPPromationTagBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		IBOHPPromationTagValue[] hpPromationTagValue = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOHPPromationTagBean[]) {
				hpPromationTagValue = (IBOHPPromationTagValue[]) obj;
			}
		}
		ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);
		try {
			if (hpPromationTagValue.length == 0 || hpPromationTagValue == null) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				if (hpPromationTagValue.length == 1) {
					tagDetailSV.saveGoods(hpPromationTagValue[0]);
					// cp.set("MESSAGE", "操作成功！");

				} else {
					for (int i = 0; i < hpPromationTagValue.length; i++) {
						tagDetailSV.saveGoods(hpPromationTagValue[i]);
					}
				}
				cp.set("FLAG", "Y");
			}

			// 判断是否生成货品工单
			// 使用武器申请id作为货品BOSSID申请id
			// 如果不存在工单类型为"productCase",且存在有未配置的货品，则发起货品配置流程
			StringBuffer condition = new StringBuffer();
			condition.append(" " + BOWorkflowStatBean.S_WorkflowObjectType
					+ " =:type");
			HashMap<String, String> parameter = new HashMap<String, String>();
			parameter.put("type", "productCase");
			HashMap<String, String> aVars = new HashMap<String, String>();
			aVars.put("staff", "20004927");
			int cnt = ComframeClient.getWorkflowCount("HB", condition
					.toString(), parameter);
			if (cnt <= 0 && tagDetailSV.haveTagCode()) {
				IBOHPApplyValue aValue = new BOHPApplyBean();
				String vorgId = "10";
				String newId = tagDetailSV.saveProductApply(aValue);
				CenterFactory.setDirectCenterInfo(new CenterInfo("0", vorgId));
				ComframeClient.createWorkflow("template.ProductBossId",
						staffId, "productCase", newId, aVars, null, null);
				CenterFactory.setCenterInfoEmpty();
			}
		} catch (Exception e) {
			log.error("资费保存出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

}
