package com.asiainfo.sale.weapon.web;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.common.util.CenterUtil;

import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.crm.example.so.service.interfaces.ISoSV;
import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.sale.tag.service.interfaces.ITagDetailSV;
import com.asiainfo.sale.util.ActionUtil;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponBean;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponEngine;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponMainBean;
import com.asiainfo.sale.weapon.bo.BOWeaponTagRelaBean;
import com.asiainfo.sale.weapon.bo.BOWeaponTagRelaEngine;
import com.asiainfo.sale.weapon.dao.impl.SaleWeaponDAOImpl;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponMainValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponSignOrAduitValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;
import com.asiainfo.sale.weapon.ivalues.IBOWeaponTagRelaValue;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV;
import com.asiainfo.util.agent.ClientAgent;
import com.asiainfo.sale.common.service.impl.SendSmsSVImpl;

public class SaleWeaponAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(BaseAction.class);

	IBOSaleWeaponValue[] saleWeaponValues = null;

	// 保存主信息
	public void saveSaleWeaponMainA(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		String delid = request.getParameter("delid");
		IBOSaleWeaponMainValue[] saleWeaponMainValues = null;
		if (delid.equals("0")) {
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(
					request.getInputStream(),
					new Class[] { BOSaleWeaponMainBean.class });

			if (dcLists.length == 0) {
				return;
			}

			// 前台提交的数据

			for (int i = 0; i < dcLists.length; i++) {
				Object[] obj = dcLists[i].getColDataContainerInterface(0);
				if (obj instanceof BOSaleWeaponMainBean[]) {
					saleWeaponMainValues = (BOSaleWeaponMainBean[]) obj;
				}
			}
		}
		ISaleWeaponMainSV SaleWeaponMainSV = (ISaleWeaponMainSV) ServiceFactory
				.getService(ISaleWeaponMainSV.class);

		try {
			if (!delid.equals("0")) {
				SaleWeaponMainSV.delSaleWeaponMain(delid);
			} else {
				SaleWeaponMainSV.saveSaleWeaponMain(saleWeaponMainValues);
				cp.set("FLAG", "Y");
				System.out.print(saleWeaponMainValues[0].getId());
				cp.set("MID", saleWeaponMainValues[0].getId());
			}
		} catch (Exception e) {
			// 操作失败
			log.error("操作员工信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 删除该工单的所有武器模板和武器标签关联信息记录
	public void delWeaponSTageRelaS(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleWeaponBean.class });

		// 前台提交的数据
		IBOSaleWeaponValue[] saleWeaponValues2 = null;
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOSaleWeaponBean[]) {
				saleWeaponValues2 = (BOSaleWeaponBean[]) obj;
			}
		}
		String mid = saleWeaponValues2[0].getMid();
		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);
		saleWeaponValues = saleWeaponSV.getSaleWeaponOnlyByMID(mid);
		ITagDetailSV tagdetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);
		String wid = "";
		try {
			if (dcLists.length > 0) {
				String typeCode = request.getParameter("typeCode");
				if (!"aduit".equals(typeCode)) {
					for (int t = 0; t < saleWeaponValues.length; t++) {
						saleWeaponValues[t].setState("A");
					}
				}
				// 多条武器删除
				saleWeaponSV.delWeapons(saleWeaponValues);
				for (int j = 0; j < saleWeaponValues.length; j++) {
					wid = wid + saleWeaponValues[j].getId() + ";";
				}
			} else if (dcLists.length == 0) {
				wid = request.getParameter("WID");
			}

			BOWeaponTagRelaBean weaponTagRelaBean = null;
			// 获得和该武器相关的所有标签详细信息（供修改使用）
			/*String[] wids = wid.substring(0, wid.length() - 1).split(";");
			for (int k = 0; k < wids.length; k++) {
				IBOPromationTagValue[] promationTagValue = tagdetailSV
						.getAllTagByWeaponId(Integer.parseInt(wids[k]), -1, -1);
				for (int i = 0; i < promationTagValue.length; i++) {
					saleWeaponSV.delWeaponTagRela(wids[k], String
							.valueOf(promationTagValue[i].getId()));
				}
			} */
			cp.set("WID", wid);
			cp.set("FLAG", "Y");
		} catch (Exception e) {
			// 操作失败
			log.error("操作员工信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 删除武器的单条模板武器标签关联信息记录
	public void delWeaponTageRela(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleWeaponBean.class });

		// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOSaleWeaponBean[]) {
				saleWeaponValues = (BOSaleWeaponBean[]) obj;
			}
		}

		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);

		ITagDetailSV tagdetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);
		String wid = "";
		try {
			if (dcLists.length > 0) {
				String typeCode = request.getParameter("typeCode");
				for (int j = 0; j < saleWeaponValues.length; j++) {
					if (!"aduit".equals(typeCode)) {
						saleWeaponValues[j].setState("A");
					}
					/*wid = saleWeaponValues[j].getId();
					BOWeaponTagRelaBean weaponTagRelaBean = null;
					// 获得和该武器相关的所有标签详细信息（供修改使用）
					IBOPromationTagValue[] promationTagValue = tagdetailSV
							.getAllTagByWeaponId(Integer.parseInt(wid), -1, -1);
					for (int i = 0; i < promationTagValue.length; i++) {
						saleWeaponSV.delWeaponTagRela(wid, String
								.valueOf(promationTagValue[i].getId()));
					} */
				}
				// 将信息存入武器详细信息表中
				saleWeaponSV.saveSaleWeapon(saleWeaponValues);
			} else if (dcLists.length == 0) {
				wid = request.getParameter("WID");
			}
			// cp.set("WID", wid);
			cp.set("FLAG", "Y");
		} catch (Exception e) {
			// 操作失败
			log.error("操作员工信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 保存
	public void saveSaleWeaponMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleWeaponBean.class });

		// if (dcLists.length == 0) {
		// return;
		//			
		// }

		// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOSaleWeaponBean[]) {
				saleWeaponValues = (BOSaleWeaponBean[]) obj;
			}
		}

		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);

		ITagDetailSV tagdetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);
		String wid = "";
		String weapid = "";
		String type = "";
		try {
			if (dcLists.length > 0) {

				// String saleFlag = request.getParameter("saleFlag");
				String typeCode = request.getParameter("typeCode");
				// if("12".equals(saleFlag)){
				// saleWeaponValues[0].setWeaponName(saleWeaponValues[0].getWeaponName()+"("+SessionManager.getUser().getName()+")");
				// }
				if (!"aduit".equals(typeCode)) {
					saleWeaponValues[0].setState("A");
				}
				// 将信息存入武器详细信息表中
				weapid = saleWeaponValues[0].getId();
				saleWeaponSV.saveSaleWeapon(saleWeaponValues);
				wid = saleWeaponValues[0].getId();
				if (weapid != null && weapid != "") {
					if (weapid.equals(wid)) {
						type = "update";
					}
				}
				// System.out.print("+++++++++++++++++"+wid);
			} else if (dcLists.length == 0) {
				wid = request.getParameter("WID");
			}

			BOWeaponTagRelaBean weaponTagRelaBean = null;
			// 获得和该武器相关的所有标签详细信息（供修改使用）
			IBOPromationTagValue[] promationTagValue = tagdetailSV
					.getAllTagByWeaponId(Integer.parseInt(wid), -1, -1);

			String wtid = request.getParameter("wtid");
			String[] ss = null;
			if (StringUtils.isNotBlank(wtid)) {
				ss = wtid.split(",");
			}
			// String type = request.getParameter("type");
			if (StringUtils.isNotBlank(wtid) || StringUtils.isNotBlank(type)) {

				if (type.equals("update")) {
					for (int i = 0; i < promationTagValue.length; i++) {
						String oldTagType = promationTagValue[i].getTagType();
						for (int k = 0; k < ss.length; k++) {

							if (StringUtils.isNotBlank(ss[k])) {
								IBOPromationTagValue newTag = tagdetailSV
										.getTagDetailById(Integer
												.parseInt(ss[k]));
								if (newTag.getTagType().equals(oldTagType)) {
									saleWeaponSV.delWeaponTagRela(wid, String
											.valueOf(promationTagValue[i]
													.getId()));
								}
							}
						}
					}
				}

				// 将武器详细信息中的标签，存入标签与武器的关系表中
				// String[] tt = ss[i].split(",");
				for (int j = 0; j < ss.length; j++) {
					String tagId = ss[j];
					if (!tagId.trim().equals("") && !tagId.equals("0")) {
						weaponTagRelaBean = new BOWeaponTagRelaBean();
						weaponTagRelaBean.setWeaponId(wid);
						weaponTagRelaBean.setTagId(tagId);
						IBOPromationTagValue tag = tagdetailSV
							.getTagDetailById(Integer.parseInt(tagId));
						if (tag != null && tag.getState().equals("99")) {
							weaponTagRelaBean.setSaleFlag("99");
						} else {
							weaponTagRelaBean.setSaleFlag("1");
						}
						saleWeaponSV.saveWeaponTagRela(weaponTagRelaBean);
					}
				}
			}
			// }
			cp.set("WID", wid);
			cp.set("FLAG", "Y");
		} catch (Exception e) {
			// 操作失败
			log.error("操作员工信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 提交页面起工作流
	public void commitSaleWeapon(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		// saveSaleWeaponMain(request, response);
		try {
			// 获得下一环节审批人
			String approver = request.getParameter("approver");
			String wid = request.getParameter("wid");
			String wids = wid.substring(0, wid.length() - 1);
			String[] weaponids = wids.split(";");
			String mid = request.getParameter("mid");
			String weaponName = request.getParameter("weaponName");
			// String weaponName=new
			// String(request.getParameter("weaponName").getBytes("ISO8859_1"));
			// 通过武器名称（自动生成的）判断是否有重复
			ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
					.getService(ISaleWeaponSV.class);
			if (saleWeaponSV.selectName(weaponName) == 1) {
				cp.set("FLAG", "C");
			} else if (saleWeaponSV.selectName(weaponName) == 2) {
				cp.set("FLAG", "W");
			} else if (saleWeaponSV.selectName(weaponName) == 3) {
				cp.set("FLAG", "U");
			} else {
				String staffId = String.valueOf(SessionManager.getUser()
						.getID());
				String orgId = String.valueOf(SessionManager.getUser()
						.getOrgId());
				boolean inSign = false;
				for (int j = 0; j < weaponids.length; j++) {
					IBOSaleWeaponValue[] beans = saleWeaponSV
							.getSaleWeaponByID(weaponids[j], -1, -1);
					IBOPromationTagValue[] promationTagValue = saleWeaponSV
							.getTagBeanByWeaponWid(weaponids[j]);
					for (int i = 0; i < promationTagValue.length; i++) {
						if (promationTagValue[i].getState().equals("99")) {
							inSign = true;
							continue;
						}
					}

					if (inSign == true) {
						beans[0].setState("C");
					} else {
						beans[0].setState("U");
					}
					saleWeaponSV.saveSaleWeapon(beans);
				}
				if (inSign == true) {
					ClientAgent.createWorkflow("template.WeaponNewApprove",
							staffId, approver, "weaponCase", mid, null, null,
							orgId);
				}
				// SendSmsSVImpl send=new SendSmsSVImpl();
				// send.sendSms("weaponCase", mid, staffId, "20005232");
				cp.set("FLAG", "Y");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("操作员工信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 指定会签人
	public void AssignSaleWeapon(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		try {
			// SessionManager.getUser().get
			String staffId = String.valueOf(SessionManager.getUser().getID());
			String wid = request.getParameter("wid");
			String staffid = request.getParameter("staffid");
			String reason = request.getParameter("remark");
			System.out.print(reason);
			ClientAgent.assignReason("5000", staffId, "weaponCase", wid, "",
					reason, staffid);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败");
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 会签
	public void SignSaleWeapon(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		try {
			String staffId = String.valueOf(SessionManager.getUser().getID());
			String wid = request.getParameter("wid");
			String reason = request.getParameter("reason");
			// String reason = new
			// String(reasonTmp.getBytes("ISO-8859-1"),"GBK");
			ClientAgent.signTask("50000", staffId, "weaponCase", wid, "",
					reason, "");
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

	public void saveSuggestdate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);
		String wid = request.getParameter("wid");
		// String mid= request.getParameter("mid");
		String time = request.getParameter("suggestDate");
		IBOSaleWeaponValue[] bean = saleWeaponSV.getSaleWeaponByID(wid, -1, -1);
		String mid = bean[0].getMid();
		IBOSaleWeaponValue[] beans = saleWeaponSV
				.getSaleWeaponByID(mid, -1, -1);
		try {
			if (!"".equals(time) && time != null) {
				Timestamp timestamp = Timestamp.valueOf(time);
				for (int i = 0; i < beans.length; i++) {
					beans[i].setSuggestDate(timestamp);
				}
				saleWeaponSV.saveSaleWeapon(beans);
			}
		} catch (Exception e) {
			cp.set("MESSAGE", "操作时间出错");
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 审核
	public void AduitSaleWeapon(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		try {
			String staffId = String.valueOf(SessionManager.getUser().getID());
			String mid = request.getParameter("mid");
			String reason = request.getParameter("reason");
			String result = request.getParameter("result");
			String showTime = request.getParameter("showTime");
			// String wid= request.getParameter("wid");
			String wid = "";
			ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
					.getService(ISaleWeaponSV.class);
			if (mid != null && mid != "") {
				IBOSaleWeaponValue[] SaleWeapons = saleWeaponSV
						.getSaleWeaponOnlyByMID(mid);
				for (int t = 0; t < SaleWeapons.length; t++) {
					wid = wid + SaleWeapons[t].getId() + ";";
				}
			}
			String wwid = wid.substring(0, wid.length() - 1);
			String[] wids = wwid.split(";");

			boolean flag = true;
			String staffid = "";
			for (int j = 0; j < wids.length; j++) {
				IBOPromationTagValue[] promationTagValue = saleWeaponSV
						.getTagBeanByWeaponWid(wids[j]);
				IBOPromationTagValue[] waitTagsID = saleWeaponSV
						.getWaitTagsID();
				ArrayList list = new ArrayList();
				for (int i = 0; i < waitTagsID.length; i++) {
					list.add(waitTagsID[i].getId());
				}
				if (flag) {
					for (int i = 0; i < promationTagValue.length; i++) {
						if ("99".equals(promationTagValue[i].getState().trim()
								.toString())) {
							// flag=list.contains(promationTagValue[i].getId());
							flag = false;
						}
					}
				}

				IBOSaleWeaponValue[] beans = saleWeaponSV.getSaleWeaponByID(
						wids[j], -1, -1);

				if ("add".equals(showTime)) {

					if (flag == false) {
						if ("approve".equals(result)) {
							result = "pz";
							String time = request.getParameter("suggestDate");
							if (!"".equals(time) && time != null) {
								Timestamp timestamp = Timestamp.valueOf(time);
								beans[0].setSuggestDate(timestamp);
							}
							beans[0].setState("W");
							saleWeaponSV.saveSaleWeapon(beans);
							cp.set("MESSAGE", "操作成功！");
							staffid = "20004927";
							// ClientAgent.assignTask("50000",staffId,"weaponCase",mid,"20004927","",reason,result);
						} else {
							beans[0].setState("N");
							saleWeaponSV.saveSaleWeapon(beans);
							cp.set("MESSAGE", "操作成功！");
							// ClientAgent.assignTask("50000",staffId,"weaponCase",mid,"","",reason,result);
						}
					} else {
						if ("approve".equals(result)) {
							beans[0].setState("U");
							saleWeaponSV.saveSaleWeapon(beans);
							cp.set("MESSAGE", "操作成功！");
							// ClientAgent.assignTask("50000",staffId,"weaponCase",mid,"","",reason,result);
						} else {
							beans[0].setState("N");
							saleWeaponSV.saveSaleWeapon(beans);
							cp.set("MESSAGE", "操作成功！");
							// ClientAgent.assignTask("50000",staffId,"weaponCase",mid,"","",reason,result);
						}
					}

					cp.set("FLAG", "Y");
				} else {
					if (flag == false) {
						cp.set("MESSAGE", "WAIT");
					} else {
						cp.set("MESSAGE", "OK");
					}

				}
			}
			if ("add".equals(showTime)) {
				ClientAgent.assignTask("50000", staffId, "weaponCase", mid,
						staffid, "", reason, result);
			}
		} catch (Exception e) {
			// 操作失败
			log.error("操作员工信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 查询页面
	public DataContainer[] getSaleWeapon(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DataContainer[] rtn = null;
		String wid = HttpUtil.getAsString(request, "wid");
		// String wwid = HttpUtil.getAsInt(request, "wwid");
		String name = HttpUtil.getAsString(request, "weaponName");
		String marketType = HttpUtil.getAsString(request, "marketType");
		String bLimit = HttpUtil.getAsString(request, "bLimit");
		String backMonth = HttpUtil.getAsString(request, "backMonth");
		String lLimit = HttpUtil.getAsString(request, "lLimit");
		String baseMonth = HttpUtil.getAsString(request, "baseMonth");
		String busiType = HttpUtil.getAsString(request, "busiType");
		String netAge = HttpUtil.getAsString(request, "netAge");
		String minNetAge = HttpUtil.getAsString(request, "minNetAge");
		String maxNetAge = HttpUtil.getAsString(request, "maxNetAge");
		String selfBusi = HttpUtil.getAsString(request, "selfBusi");
		String couponsValue = HttpUtil.getAsString(request, "couponsValue");
		String goodAdoptDirectory = HttpUtil.getAsString(request,
				"goodAdoptDirectory");
		String saleFlag = HttpUtil.getAsString(request, "saleFlag");
		String presentBusiMonth = HttpUtil.getAsString(request,
				"presentBusiMonth");
		String state = HttpUtil.getAsString(request, "state");
		String presentBusiAmount = HttpUtil.getAsString(request,
				"presentBusiAmount");
		String presentReachAmount = HttpUtil.getAsString(request,
				"presentReachAmount");
		String presentValuePermon = HttpUtil.getAsString(request,
				"presentValuePermon");
		String presentBusi2Amount = HttpUtil.getAsString(request,
				"presentBusi2Amount");
		String presentBusi4Amount = HttpUtil.getAsString(request,
				"presentBusi4Amount");
		String openMonth = HttpUtil.getAsString(request, "openMonth");
		String mid = HttpUtil.getAsString(request, "mid");
		String zfqType = HttpUtil.getAsString(request, "zfqType");

		// ISoSV serv = (ISoSV) ServiceFactory.getService(ISoSV.class);
		try {

			ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
					.getService(ISaleWeaponSV.class);

			// IBOSaleWeaponValue[] saleWeaponValues =
			// saleWeaponSV.getSaleWeapon(weaponName, marketType, "", baseMonth,
			// lLimit, "", "", "", "", netAge, "", "", "", -1, -1);
			IBOSaleWeaponValue[] saleWeaponValues = saleWeaponSV.getSaleWeapon(
					mid, "", wid, name, marketType, backMonth, baseMonth,
					lLimit, bLimit, saleFlag, presentBusiMonth, busiType,
					netAge, couponsValue, selfBusi, goodAdoptDirectory, state,
					presentBusiAmount, presentReachAmount, presentValuePermon,
					presentBusi2Amount, zfqType, presentBusi4Amount, openMonth,
					minNetAge, maxNetAge, 1, 5);

		} catch (Exception ex) {
			throw ex;
		}
		return rtn;
	}

	public void selectAreaAndSp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String wid = request.getParameter("wtid");
		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);
		try {
			IBOPromationTagValue[] promationTags = saleWeaponSV
					.getTagBeanByWeaponWid(wid);
			if (promationTags.length > 0) {
				for (int i = 0; i < promationTags.length; i++) {
					if (!promationTags[i].getArea().equals("10")) {
						cp.set("AREA" + promationTags[i].getTagType(), "true");
					}
				}
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 会签页面加载

	public DataContainer[] getSaleWeaponAssign(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DataContainer[] rtn = null;
		ISoSV serv = (ISoSV) ServiceFactory.getService(ISoSV.class);
		try {
			ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
					.getService(ISaleWeaponSV.class);
			String taskTag = request.getParameter("taskTag");
			String curStat = "5";
			String wid = "";
			List lista = ClientAgent.getAllCurTaskByTag(taskTag, "weaponCase",
					curStat);
			if (lista != null) {
				for (int i = 0; i < lista.size(); i++) {
					if (i != 0) {
						wid = wid + " , " + lista.get(i);
					} else {
						wid = lista.get(i).toString();
					}
				}
			}
		} catch (Exception ex) {
			throw ex;
		}
		return rtn;

	}

	public void finishTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String taskId = request.getParameter("mid");
		String reason = request.getParameter("reason");
		String tagType = request.getParameter("tagType");
		// System.out.print(tagType);
		// String staffId = request.getParameter("staffId");
		String staffId = String.valueOf(SessionManager.getUser().getID());
		boolean isEnd = request.getParameter("taskState").equals("taskIsEnd");
		if (isEnd) {
			String weaponId = request.getParameter("weaponId");

			ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
					.getService(ISaleWeaponSV.class);
			IBOSaleWeaponValue[] SaleWeapons = saleWeaponSV
					.getSaleWeaponOnlyByMID(taskId);
			for (int j = 0; j < SaleWeapons.length; j++) {
				IBOPromationTagValue[] promationTags = saleWeaponSV
						.getSpareTagDetailByWeaponId(SaleWeapons[j].getId());
				SaleWeapons[j].setState("U");
				for (int i = 0; i < promationTags.length; ++i) {
					if (promationTags[i] != null) {
						promationTags[i].setState("1");
					}
				}
				saleWeaponSV.saveTagDetail(promationTags, 0);
			}
			saleWeaponSV.saveSaleWeapon(SaleWeapons);

		}
		ClientAgent.assignTask("5000", staffId, "weaponCase", taskId, "",
				reason, "");
	}

	public void reAuthorize(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		try {
			String taskid = request.getParameter("taskid");
			String staffid = request.getParameter("staffid");
			String authorizeStaffId = request.getParameter("authorizeStaffId");
			ClientAgent.reAuthorizeTask(taskid, authorizeStaffId, staffid);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败");
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

}
