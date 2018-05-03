package com.asiainfo.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import net.sf.json.JSONObject;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IChargeMainDAO;
import com.asiainfo.charge.dao.interfaces.IChargeNewMainDAO;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;
import com.asiainfo.httpserver.pojo.AuditInfo;
import com.asiainfo.httpserver.pojo.BusiChangeInfo;
import com.asiainfo.httpserver.pojo.BusiChangeLev;
import com.asiainfo.httpserver.pojo.ChargeInfo;
import com.asiainfo.httpserver.pojo.ChargeLev;
import com.asiainfo.httpserver.pojo.SaleBatch;
import com.asiainfo.httpserver.pojo.SaleInfo;
import com.asiainfo.httpserver.pojo.SaleLev;
import com.asiainfo.httpserver.pojo.StaffInfo;
import com.asiainfo.httpserver.pojo.WfInfo;
import com.asiainfo.httpserver.pojo.TaskInfo;
import com.asiainfo.sale.access.dao.interfaces.IBusiChangeDAO;
import com.asiainfo.sale.access.dao.interfaces.IBusiChangeDetailDAO;
import com.asiainfo.sale.access.ivalues.IBOBusiChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOBusiChangeValue;
import com.asiainfo.sale.activity.dao.interfaces.ISaleDetailDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleOrderDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleOrderValue;
import com.asiainfo.sale.common.service.interfaces.ISaleStaticDataSV;
import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponDAO;
import com.asiainfo.task.dao.interfaces.ICurTaskDAO;
import com.asiainfo.task.ivalues.IBOCurTaskValue;
import com.asiainfo.task.ivalues.IBOFinishTaskValue;
import com.asiainfo.workflow.util.TaskUtil;
import com.asiainfo.workflow.util.bo.BOTaskRouteBean;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SaleHttpServer extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaleHttpServer() {
		super();
	}

	public static void main(String[] args) throws ServletException {
		new SaleHttpServer().init();
	}

	public void init() throws ServletException {
		try {

			// 允许最大连接数
			// int backLog = 10;
			// http://10.31.81.211:8077/sale/httpService/service/MRTMGRQueryPrivStatus
			// 实现HTTP SERVER
			HttpServer hs = HttpServer.create(new InetSocketAddress(8077), 0); // 设置HttpServer的端口为8077
			// 查询当前待办工单
			hs.createContext("/sale/httpService/service/QueryAwaitOrders",
					new QueryAwaitOrders());
			// 查询工单流转明细
			hs.createContext("/sale/httpService/service/QueryWFTaskInfo",
					new QueryWFTaskInfo());
			// 查询历史处理工单
			hs.createContext("/sale/httpService/service/QueryHsWFTaskInfo",
					new QueryHsWFTaskInfo());
			// 查询营销活动信息
			hs.createContext("/sale/httpService/service/QuerySaleInfo",
					new QuerySaleInfo());
			// 查询资费案信息
			hs.createContext("/sale/httpService/service/QueryChargeInfo",
					new QueryChargeInfo());
			// 查询业务变更
			hs.createContext("/sale/httpService/service/QueryBusiChangeInfo",
					new QueryBusiChangeInfo());
			// 查询停售
			hs.createContext("/sale/httpService/service/QuerySellStopInfo",
					new QuerySellStopInfo());

			// 查询下一环节可选项（角色、单位）
			hs.createContext("/sale/httpService/service/QueryNextStageInWF",
					new QueryNextStageInWF());
			// 工单审核
			hs.createContext("/sale/httpService/service/Audit", new Audit());

			hs.createContext("/sale/httpService/service/QueryStaffByRoleId",
					new QueryStaffByRoleId());

			hs.createContext("/sale/httpService/service/QueryByStaffName",
					new QueryByStaffName());
			// default executor
			// hs.setExecutor(null);
			hs.setExecutor(Executors.newCachedThreadPool());
			hs.start();

			/*
			 * 实现HTTPS SERVER HttpsServer hss = HttpsServer.create(new
			 * InetSocketAddress(443), 0); // 设置HTTPS端口这443 KeyStore ks =
			 * KeyStore.getInstance("JKS"); // 建立证书库 ks.load(new
			 * FileInputStream("证书名"), "密码".toCharArray()); // 载入证书
			 * KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			 * // 建立一个密钥管理工厂 kmf.init(ks, "密码".toCharArray()); // 初始工厂
			 * SSLContext sslContext = SSLContext.getInstance("SSLv3"); //
			 * 建立证书实体 sslContext.init(kmf.getKeyManagers(), null, null); //
			 * 初始化证书 HttpsConfigurator conf = new HttpsConfigurator(sslContext);
			 * // 在https配置 hss.setHttpsConfigurator(conf); // 在https server载入配置
			 * hss.setExecutor(null); // creates a default executor
			 * hss.createContext("/", new MyHandler1()); // 用MyHandler类内处理到/的请求
			 * hss.start();
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		super.destroy();
	}
}

class QueryAwaitOrders implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {

		InputStream is = t.getRequestBody();
		JSONObject reqParaJson = HttpServerUtil.isToJson(is);
		OutputStream os = t.getResponseBody();
		// String userId = "maojingjing";
		ISaleStaticDataSV sv = (ISaleStaticDataSV) ServiceFactory
				.getService(ISaleStaticDataSV.class);
		ICurTaskDAO taskDao = (ICurTaskDAO) ServiceFactory
				.getService(ICurTaskDAO.class);
		RetJsonObject retJsonObj = new RetJsonObject();
		Head head = new Head();
		retJsonObj.setHead(head);
		head.setRetType("query");

		try {
			String userId = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"userId");
			IBOCurTaskValue[] tasks = taskDao.getCurTask(HttpServerUtil
					.codeTranOpId(userId), -1, -1);
			ArrayList<WfInfo> body = new ArrayList<WfInfo>();

			for (IBOCurTaskValue task : tasks) {
				String wfType = task.getWorkflowObjectType();
				if (wfType != null
						&& (wfType.contains("saleCase")
								|| wfType.contains("busiChangeCase") || "UniteChargeFlow"
								.equals(wfType))) {

					WfInfo wfi = new WfInfo();
					wfi.setOrgName(task.getCreateCorporation());
					wfi.setProposer(task.getCreateStaffName());
					wfi.setOrderId(task.getWorkflowObjectId());
					wfi.setOrderName(task.getApplyName());
					if (wfType.contains("saleCase")) {
						wfi.setOrderType("营销案");
					} else if ("UniteChargeFlow".equals(wfType)) {
						wfi.setOrderType("资费");
					} else if (wfType.contains("busiChangeCase")) {
						wfi.setOrderType("业务变更");
					} else {
						wfi.setOrderType("不支持类型");
					}
					// wfi.setOrderType(sv.getSaleStaticData("flowType",
					// task.getWorkflowObjectType()).getCodeNameNls());
					wfi.setTemplateCode(task.getTemplateTag());
					wfi.setTaskTemplateId(String.valueOf(task
							.getTaskTemplateId()));
					wfi.setCurrentStage(task.getTlabel());
					wfi.setWorkflowId(task.getWorkflowId());
					wfi.setTaskId(task.getTaskId());
					wfi.setCfStaff(task.getPzStaff());
					wfi.setTestStaff(task.getTestStaff());
					wfi.setCreateTime(task.getCreateDate().toString()
							.substring(0, 10));
					wfi.setReceiveTime(task.getTaskDate().toString().substring(
							0, 10));
					body.add(wfi);
				}
			}
			retJsonObj.setBody(body);
			head.setRetCode("1");
			head.setRetMsg("success");
		} catch (Exception e) {
			head.setRetCode("0");
			head.setRetMsg("请求出错！");
			e.printStackTrace();
		} finally {
			JSONObject js = JSONObject.fromBean(retJsonObj);
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/json; charset=GBK");
			h.add("Access-Control-Allow-Origin", "*");
			h.add("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept");
			h.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			t.sendResponseHeaders(200, js.toString().getBytes("GBK").length);
			os.write(js.toString().getBytes("GBK"));
			os.flush();
			os.close();
			t.close();
		}
	}
}

class QueryWFTaskInfo implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		InputStream is = t.getRequestBody();
		JSONObject reqParaJson = HttpServerUtil.isToJson(is);
		OutputStream os = t.getResponseBody();
		ICurTaskDAO taskDao = (ICurTaskDAO) ServiceFactory
				.getService(ICurTaskDAO.class);
		ISaleStaticDataSV sv = (ISaleStaticDataSV) ServiceFactory
				.getService(ISaleStaticDataSV.class);
		RetJsonObject retJsonObj = new RetJsonObject();
		Head head = new Head();
		retJsonObj.setHead(head);
		head.setRetType("query");

		try {
			String workflowId = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"workflowId");
			IBOCurTaskValue[] tasks = taskDao
					.getAllTaskByWorkFlowId(workflowId);
			ArrayList<TaskInfo> body = new ArrayList<TaskInfo>();

			for (IBOCurTaskValue task : tasks) {
				TaskInfo taskInfo = new TaskInfo();
				taskInfo.setOrgName(task.getCreateCorporation());
				taskInfo.setCorporation(task.getCorporation());
				taskInfo.setCurrentStage(task.getTlabel());
				taskInfo.setReceiveStaff(task.getTaskStaffName());
				taskInfo.setDealStaff(task.getStaffName());
				String decision = task.getDecisionResult();
				if (StringUtil.isNotBlank(decision)) {
					taskInfo.setDecision(sv.getSaleStaticData("decitionResult",
							decision).getCodeName());
				}
				taskInfo.setNextStap(task.getNextTask());
				taskInfo.setState(task.getStateName());
				taskInfo.setTaskReceiveDate(task.getTaskDate().toString()
						.substring(0, 10));
				Timestamp finishDate = task.getFinishDate();
				if (finishDate != null
						&& StringUtil.isNotBlank(finishDate.toString())) {
					taskInfo.setTaskFinishDate(task.getFinishDate().toString()
							.substring(0, 10));
				}
				body.add(taskInfo);
			}
			retJsonObj.setBody(body);
			head.setRetCode("1");
			head.setRetMsg("success");
		} catch (Exception e) {
			head.setRetCode("0");
			head.setRetMsg("请求出错！");
			e.printStackTrace();
		} finally {
			JSONObject js = JSONObject.fromBean(retJsonObj);
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/json; charset=GBK");
			h.add("Access-Control-Allow-Origin", "*");
			h.add("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept");
			h.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			t.sendResponseHeaders(200, js.toString().getBytes("GBK").length);
			os.write(js.toString().getBytes("GBK"));
			os.flush();
			os.close();
			t.close();
		}
	}
}

class QueryHsWFTaskInfo implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		OutputStream os = t.getResponseBody();
		InputStream is = t.getRequestBody();
		JSONObject reqParaJson = HttpServerUtil.isToJson(is);
		ISaleStaticDataSV sv = (ISaleStaticDataSV) ServiceFactory
				.getService(ISaleStaticDataSV.class);
		ICurTaskDAO taskDao = (ICurTaskDAO) ServiceFactory
				.getService(ICurTaskDAO.class);
		RetJsonObject retJsonObj = new RetJsonObject();
		Head head = new Head();
		retJsonObj.setHead(head);
		head.setRetType("query");

		try {
			String staffId = HttpServerUtil.codeTranOpId(HttpServerUtil
					.getStrFromJsByKey(reqParaJson, "userId"));
			String beginTime = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"beginTime");
			if (StringUtil.isNotBlank(beginTime))
				beginTime += " 01:01:01.0000";
			String endTime = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"endTime");
			if (StringUtil.isNotBlank(endTime))
				endTime += " 23:59:59.0000";
			String orderName = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"orderName");
			String OrderId = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"OrderId");
			String corporation = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"corporation");
			String staffName = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"staffName");
			IBOFinishTaskValue[] hTasks = taskDao.getHistoryRecord(staffId,
					beginTime, endTime, orderName, OrderId, corporation,
					staffName, -1, -1);
			IBOFinishTaskValue[] fTasks = taskDao.getFinishTask(staffId,
					beginTime, endTime, orderName, OrderId, corporation,
					staffName, -1, -1);
			ArrayList<WfInfo> body = new ArrayList<WfInfo>();

			for (IBOFinishTaskValue task : fTasks) {
				String wfType = task.getWorkflowObjectType();
				if (wfType != null
						&& (wfType.contains("saleCase")
								|| wfType.contains("busiChangeCase") || "UniteChargeFlow"
								.equals(wfType))) {
					WfInfo wfi = new WfInfo();
					wfi.setOrderName(task.getApplyName());
					wfi.setOrderId(task.getWorkflowObjectId());
					if (wfType.contains("saleCase")) {
						wfi.setOrderType("营销案");
					} else if ("UniteChargeFlow".equals(wfType)) {
						wfi.setOrderType("资费");
					} else if (wfType.contains("busiChangeCase")) {
						wfi.setOrderType("业务变更");
					} else {
						wfi.setOrderType("不支持类型");
					}
					// wfi.setOrderType(sv.getSaleStaticData("orderType",
					// task.getWorkflowObjectType()).getCodeName());
					wfi.setProposer(task.getStaffName());
					wfi.setOrgName(task.getOrgName());
					wfi.setCreateTime(task.getCreateDate().toString()
							.substring(0, 10));
					body.add(wfi);
				}
			}
			for (IBOFinishTaskValue task : hTasks) {
				String wfType = task.getWorkflowObjectType();
				if (wfType != null
						&& (wfType.contains("saleCase")
								|| wfType.contains("busiChangeCase") || "UniteChargeFlow"
								.equals(wfType))) {

					WfInfo wfi = new WfInfo();
					wfi.setOrderName(task.getApplyName());
					wfi.setOrderId(task.getWorkflowObjectId());
					if (wfType.contains("saleCase")) {
						wfi.setOrderType("营销案");
					} else if ("UniteChargeFlow".equals(wfType)) {
						wfi.setOrderType("资费");
					} else if (wfType.contains("busiChangeCase")) {
						wfi.setOrderType("业务变更");
					} else {
						wfi.setOrderType("不支持类型");
					}
					// wfi.setOrderType(sv.getSaleStaticData("orderType",
					// task.getWorkflowObjectType()).getCodeName());
					wfi.setProposer(task.getStaffName());
					wfi.setOrgName(task.getOrgName());
					wfi.setCreateTime(task.getCreateDate().toString()
							.substring(0, 10));
					body.add(wfi);
				}
			}
			retJsonObj.setBody(body);
			head.setRetCode("1");
			head.setRetMsg("success");
		} catch (Exception e) {
			head.setRetCode("0");
			head.setRetMsg("请求出错！");
			e.printStackTrace();
		} finally {
			JSONObject js = JSONObject.fromBean(retJsonObj);
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/json; charset=GBK");
			h.add("Access-Control-Allow-Origin", "*");
			h.add("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept");
			h.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			t.sendResponseHeaders(200, js.toString().getBytes("GBK").length);
			os.write(js.toString().getBytes("GBK"));
			os.flush();
			os.close();
			t.close();
		}
	}
}

class QuerySaleInfo implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		OutputStream os = t.getResponseBody();
		InputStream is = t.getRequestBody();
		JSONObject reqParaJson = HttpServerUtil.isToJson(is);
		ISaleStaticDataSV sv = (ISaleStaticDataSV) ServiceFactory
				.getService(ISaleStaticDataSV.class);
		ISaleOrderDAO saleOrderDao = (ISaleOrderDAO) ServiceFactory
				.getService(ISaleOrderDAO.class);
		ISaleDetailDAO saleDtDao = (ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class);
		ISaleWeaponDAO saleWpDao = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		RetJsonObject retJsonObj = new RetJsonObject();
		Head head = new Head();
		retJsonObj.setHead(head);
		head.setRetType("query");

		try {
			String orderId = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"orderId");
			IBOSaleOrderValue orderInfo = saleOrderDao
					.getSaleOrderInfo(orderId);
			ArrayList<SaleInfo> body = new ArrayList<SaleInfo>();
			SaleInfo si = new SaleInfo();
			si.setProposer(orderInfo.getPrinciple());
			si.setOrgName(orderInfo.getOrgName());
			si.setOrderName(orderInfo.getPropName());
			ArrayList<SaleBatch> sbs = new ArrayList<SaleBatch>();
			for (IBOSaleMainValue bi : saleOrderDao.getSaleMainByOrderId(
					orderId, -1, -1)) {
				SaleBatch sb = new SaleBatch();
				sb.setBatchName(bi.getSaleMainName());
				sb.setBatchCode(bi.getSaleMainCode());
				sb.setBeginTime(bi.getBeginTime().toString().substring(0, 10));
				sb.setEndTime(bi.getEndTime().toString().substring(0, 10));
				sb.setExecArea(sv.getSaleStaticData("aclarea", bi.getExearea())
						.getCodeName());
				sb.setTarget(bi.getAim());
				IBOSaleDetailValue[] levInfo = saleDtDao.getSaleDetailByMainId(
						bi.getId(), -1, -1);
				ArrayList<SaleLev> sls = new ArrayList<SaleLev>();
				for (IBOSaleDetailValue li : levInfo) {
					SaleLev sl = new SaleLev();
					sl.setLevName(li.getSaleActiveName());
					sl.setLevCode(li.getSaleActiveCode());
					sl.setLevType(sv
							.getSaleStaticData("hdlx", li.getSaleFlag())
							.getCodeName());
					sl.setLevDes(li.getLevelDesc());
					sl.setWeaponDes(saleWpDao.getSaleWeaponByID(li
							.getWeaponId(), 0, 1)[0].getWeaponName());
					sls.add(sl);
				}
				sb.setSaleLevs(sls);
				sbs.add(sb);
			}
			si.setSaleBatch(sbs);
			body.add(si);
			retJsonObj.setBody(body);
			head.setRetCode("1");
			head.setRetMsg("success");
		} catch (Exception e) {
			head.setRetCode("0");
			head.setRetMsg("请求出错！");
			e.printStackTrace();
		} finally {
			JSONObject js = JSONObject.fromBean(retJsonObj);
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/json; charset=GBK");
			h.add("Access-Control-Allow-Origin", "*");
			h.add("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept");
			h.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			t.sendResponseHeaders(200, js.toString().getBytes("GBK").length);
			os.write(js.toString().getBytes("GBK"));
			os.flush();
			os.close();
			t.close();
		}
	}
}

class QueryChargeInfo implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		OutputStream os = t.getResponseBody();
		InputStream is = t.getRequestBody();
		JSONObject reqParaJson = HttpServerUtil.isToJson(is);
		ISaleStaticDataSV sv = (ISaleStaticDataSV) ServiceFactory
				.getService(ISaleStaticDataSV.class);
		IChargeNewMainDAO chargeOrDao = (IChargeNewMainDAO) ServiceFactory
				.getService(IChargeNewMainDAO.class);
		IChargeMainDAO chargeMDao = (IChargeMainDAO) ServiceFactory
				.getService(IChargeMainDAO.class);
		RetJsonObject retJsonObj = new RetJsonObject();
		Head head = new Head();
		retJsonObj.setHead(head);
		head.setRetType("query");

		try {
			String orderId = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"orderId");
			ArrayList<ChargeInfo> body = new ArrayList<ChargeInfo>();
			IBOChargeApplyMainValue cmv = chargeMDao
					.IChargeMainshow(chargeOrDao.getApplyMainsByMainId(orderId)[0]
							.getApplyId());
			ChargeInfo ci = new ChargeInfo();
			ci.setChargeName(cmv.getApplyName());
			ci.setChargeType(sv.getSaleStaticData("feetype", cmv.getFeeType())
					.getCodeName());
			ci.setBrand(sv.getSaleStaticData("typecards", cmv.getSaleFashion())
					.getCodeName());
			ci.setMarket(sv.getSaleStaticData("zfmarket", cmv.getMarketType())
					.getCodeName());
			ci.setBeginTime(cmv.getApplyTime().toString().substring(0, 10));
			ci.setEndTime(cmv.getApplyEndTime().toString().substring(0, 10));
			ci.setFlack(cmv.getFlack());
			ci.setBackGroup(cmv.getBackGround());
			ci.setExtendChennel(cmv.getExtendChannel());
			ci.setTarget(cmv.getUserCircs());
			ArrayList<ChargeLev> cls = new ArrayList<ChargeLev>();
			for (IBOChargeInfoValue cdv : chargeMDao
					.getChargeDetailByNewMainid(orderId, 0, 0)) {
				ChargeLev cl = new ChargeLev();
				cl.setChargeLevName(cdv.getFeeName());
				cl.setChargeLevCode(cdv.getCase());
				cl.setChargeLevBossCode(cdv.getInaddUserCount());
				cl.setFeePerMon(String.valueOf(cdv.getDoorDamnify()));
				cl.setChargeLevDesc(cdv.getExt5());
				cls.add(cl);
			}
			ci.setChargeLev(cls);
			body.add(ci);
			retJsonObj.setBody(body);
			head.setRetCode("1");
			head.setRetMsg("success");
		} catch (Exception e) {
			head.setRetCode("0");
			head.setRetMsg("请求出错！");
			e.printStackTrace();
		} finally {
			JSONObject js = JSONObject.fromBean(retJsonObj);
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/json; charset=GBK");
			h.add("Access-Control-Allow-Origin", "*");
			h.add("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept");
			h.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			t.sendResponseHeaders(200, js.toString().getBytes("GBK").length);
			os.write(js.toString().getBytes("GBK"));
			os.flush();
			os.close();
			t.close();
		}
	}
}

class QueryBusiChangeInfo implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		OutputStream os = t.getResponseBody();
		InputStream is = t.getRequestBody();
		JSONObject reqParaJson = HttpServerUtil.isToJson(is);
		ISaleStaticDataSV sv = (ISaleStaticDataSV) ServiceFactory
				.getService(ISaleStaticDataSV.class);
		IBusiChangeDAO busiMDao = (IBusiChangeDAO) ServiceFactory
				.getService(IBusiChangeDAO.class);
		IBusiChangeDetailDAO busiDtDao = (IBusiChangeDetailDAO) ServiceFactory
				.getService(IBusiChangeDetailDAO.class);
		RetJsonObject retJsonObj = new RetJsonObject();
		Head head = new Head();
		retJsonObj.setHead(head);
		head.setRetType("query");

		try {
			String orderId = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"orderId");
			ArrayList<BusiChangeInfo> body = new ArrayList<BusiChangeInfo>();
			IBOBusiChangeValue bcVal = busiMDao.getBusiChargeById(orderId);
			BusiChangeInfo bci = new BusiChangeInfo();
			bci.setProposer(bcVal.getPropStaff());
			bci.setOrgName(bcVal.getOrgName());
			bci.setOrderName(bcVal.getApplyName());
			bci.setDescription(bcVal.getDescription());
			ArrayList<BusiChangeLev> bcls = new ArrayList<BusiChangeLev>();
			for (IBOBusiChangeDetailValue bcdVal : busiDtDao
					.getBusiChargeDetailByPID(orderId, null, -1, -1)) {
				BusiChangeLev bcl = new BusiChangeLev();
				bcl.setBatchName(bcdVal.getActName());
				bcl.setBatchCode(bcdVal.getActCode());
				bcl.setLevName(bcdVal.getLevName());
				bcl.setLevCode(bcdVal.getLevCode());
				bcl.setChangeContent(bcdVal.getChangeType());
				bcls.add(bcl);
			}
			bci.setItems(bcls);
			body.add(bci);
			retJsonObj.setBody(body);
			head.setRetCode("1");
			head.setRetMsg("success");
		} catch (Exception e) {
			head.setRetCode("0");
			head.setRetMsg("请求出错！");
			e.printStackTrace();
		} finally {
			JSONObject js = JSONObject.fromBean(retJsonObj);
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/json; charset=GBK");
			h.add("Access-Control-Allow-Origin", "*");
			h.add("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept");
			h.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			t.sendResponseHeaders(200, js.toString().getBytes("GBK").length);
			os.write(js.toString().getBytes("GBK"));
			os.flush();
			os.close();
			t.close();
		}
	}
}

class QuerySellStopInfo implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		OutputStream os;
		JSONObject js = JSONObject
				.fromString("{'head':{'retType':'1','retCode':'0','retMsg':'成功'},"
						+ "'body':{'array':[{'custGroupName':'目标客户群1','region':'region1','createDate':'创建时间','startDate':'开始时间','endDate':'结束时间'},{'custGroupName':'目标客户群2','region':'region1','createDate':'创建时间','startDate':'开始时间','endDate':'结束时间'},{'custGroupName':'目标客户群3','region':'region1','createDate':'创建时间','startDate':'开始时间','endDate':'结束时间'},{'custGroupName':'目标客户群4','region':'region1','createDate':'创建时间','startDate':'开始时间','endDate':'结束时间'}]}}");
		Headers h = t.getResponseHeaders();
		h.add("Content-Type", "application/jsonp; charset=GBK");
		h.add("Access-Control-Allow-Origin", "*");
		h.add("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
		h.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		t.sendResponseHeaders(200, js.toString().getBytes("GBK").length);
		os = t.getResponseBody();
		os.write(js.toString().getBytes("GBK"));
		os.flush();
		os.close();
		t.close();
	}
}

class QueryNextStageInWF implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		OutputStream os = t.getResponseBody();
		InputStream is = t.getRequestBody();
		JSONObject reqParaJson = HttpServerUtil.isToJson(is);
		RetJsonObject retJsonObj = new RetJsonObject();
		Head head = new Head();
		retJsonObj.setHead(head);
		head.setRetType("query");

		try {
			String templateCode = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"templateCode");
			String taskTemplateId = HttpServerUtil.getStrFromJsByKey(
					reqParaJson, "taskTemplateId");
			ArrayList<AuditInfo> body = new ArrayList<AuditInfo>();

			for (BOTaskRouteBean rv : TaskUtil.getRoute4TaskTemplate(
					templateCode, Long.parseLong(taskTemplateId))) {
				String[] cd = rv.getCondition().split("~");
				if (!cd[1].contains("hq") || !cd[3].equals("-1")) {
					AuditInfo ai = new AuditInfo();
					ai.setNextStepDes(rv.getLable());
					ai.setNextStepOps(cd[1]);
					ai.setRoleId(cd[3]);
					body.add(ai);
				}
			}
			retJsonObj.setBody(body);
			head.setRetCode("1");
			head.setRetMsg("success");
		} catch (Exception e) {
			head.setRetCode("0");
			head.setRetMsg("请求出错！");
			e.printStackTrace();
		} finally {
			JSONObject js = JSONObject.fromBean(retJsonObj);
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/json; charset=GBK");
			h.add("Access-Control-Allow-Origin", "*");
			h.add("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept");
			h.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			t.sendResponseHeaders(200, js.toString().getBytes("GBK").length);
			os.write(js.toString().getBytes("GBK"));
			os.flush();
			os.close();
			t.close();
		}
	}
}

class Audit implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		OutputStream os = t.getResponseBody();
		InputStream is = t.getRequestBody();
		JSONObject reqParaJson = HttpServerUtil.isToJson(is);
		RetJsonObject retJsonObj = new RetJsonObject();
		Head head = new Head();
		retJsonObj.setHead(head);
		head.setRetType("audit");

		try {
			String userId = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"userId");
			String taskId = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"taskId");
			String nextStepOps = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"nextStepOps");
			String nsStaffId = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"nsStaffId");
			String comment = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"comment");
			String auditFlag = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"auditFlag");

			String[] retCode = TaskUtil.finishUserTask(taskId, nextStepOps,
					HttpServerUtil.codeTranOpId(userId), nsStaffId, null,
					comment, auditFlag);
			if ("0000".equals(retCode[0])) {
				head.setRetCode("1");
				head.setRetMsg("提交审核成功！");
			} else {
				head.setRetCode("0");
				head.setRetMsg("提交审核出错！");
			}
		} catch (Exception e) {
			head.setRetCode("0");
			head.setRetMsg("提交审核出错！");
			e.printStackTrace();
		} finally {
			JSONObject js = JSONObject.fromBean(retJsonObj);
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/json; charset=GBK");
			h.add("Access-Control-Allow-Origin", "*");
			h.add("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept");
			h.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			t.sendResponseHeaders(200, js.toString().getBytes("GBK").length);
			os.write(js.toString().getBytes("GBK"));
			os.flush();
			os.close();
			t.close();
		}
	}
}

class QueryStaffByRoleId implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		OutputStream os = t.getResponseBody();
		InputStream is = t.getRequestBody();
		JSONObject reqParaJson = HttpServerUtil.isToJson(is);
		RetJsonObject retJsonObj = new RetJsonObject();
		Head head = new Head();
		retJsonObj.setHead(head);
		head.setRetType("query");

		try {
			String code = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"userId");
			String roleId = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"roleId");
			ArrayList<StaffInfo> sl = HttpServerUtil.getStaffInfoByRoleId(
					roleId, code);
			retJsonObj.setBody(sl);
			head.setRetCode("1");
			head.setRetMsg("查询成功！");
		} catch (Exception e) {
			head.setRetCode("0");
			head.setRetMsg("查询出错！");
			e.printStackTrace();
		} finally {
			JSONObject js = JSONObject.fromBean(retJsonObj);
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/json; charset=GBK");
			h.add("Access-Control-Allow-Origin", "*");
			h.add("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept");
			h.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			t.sendResponseHeaders(200, js.toString().getBytes("GBK").length);
			os.write(js.toString().getBytes("GBK"));
			os.flush();
			os.close();
			t.close();
		}
	}
}

class QueryByStaffName implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		OutputStream os = t.getResponseBody();
		InputStream is = t.getRequestBody();
		JSONObject reqParaJson = HttpServerUtil.isToJson(is);
		RetJsonObject retJsonObj = new RetJsonObject();
		Head head = new Head();
		retJsonObj.setHead(head);
		head.setRetType("query");

		try {
			String staffNames = HttpServerUtil.getStrFromJsByKey(reqParaJson,
					"staffNames");
			ArrayList<StaffInfo> sl = HttpServerUtil
					.getStaffInfoByStaffName(staffNames);
			retJsonObj.setBody(sl);
			head.setRetCode("1");
			head.setRetMsg("查询成功！");
		} catch (Exception e) {
			head.setRetCode("0");
			head.setRetMsg("查询出错！");
			e.printStackTrace();
		} finally {
			JSONObject js = JSONObject.fromBean(retJsonObj);
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/json; charset=GBK");
			h.add("Access-Control-Allow-Origin", "*");
			h.add("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept");
			h.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			t.sendResponseHeaders(200, js.toString().getBytes("GBK").length);
			os.write(js.toString().getBytes("GBK"));
			os.flush();
			os.close();
			t.close();
		}
	}
}
