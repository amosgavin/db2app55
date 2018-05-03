package com.asiainfo.sale.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.asiainfo.sale.activity.dao.interfaces.ICustGroupDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleChannelInfoDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleDetailDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleMainDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleOrderDAO;
import com.asiainfo.sale.activity.ivalues.IBOChannelInfoValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleOrderValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleRelatCgroupValue;
import com.asiainfo.sale.activity.jsobject.Act;
import com.asiainfo.sale.activity.jsobject.ActReq;
import com.asiainfo.sale.activity.jsobject.Channel;
import com.asiainfo.sale.activity.jsobject.CustGroup;
import com.asiainfo.sale.activity.jsobject.LevReq;
import com.asiainfo.sale.activity.jsobject.Level;
import com.asiainfo.sale.activity.jsobject.Org;

public class SaleToCRMClient {

	//String url = "http://10.30.43.203:7211/ebus/httpService/BusinessAcceptanceService_http/";
	String url ="http://10.25.5.163:7211/ebus/httpService/BusinessAcceptanceService_http/";
	String head = "{\"head\":{},\"body\":{\"request\":";
	String end = "}}";

	public String createAct(String actId, String interf) throws Exception {

		// String url =
		// "http://10.30.43.203:7211/ebus/httpService/UnifyMarketService/PTPCEICreateAct";
		ISaleOrderDAO saleOrderDao = (ISaleOrderDAO) ServiceFactory
				.getService(ISaleOrderDAO.class);
		ISaleMainDAO saleMainDao = (ISaleMainDAO) ServiceFactory
				.getService(ISaleMainDAO.class);
		ISaleChannelInfoDAO channelDAO = (ISaleChannelInfoDAO) ServiceFactory
				.getService(ISaleChannelInfoDAO.class);
		ICustGroupDAO custGroupDAO = (ICustGroupDAO) ServiceFactory
				.getService(ICustGroupDAO.class);
		ActReq request = new ActReq();

		Act act = new Act();
		IBOSaleMainValue sm = saleMainDao.getSaleMainById(actId);
		IBOSaleOrderValue so = saleOrderDao.getSaleOrderInfo(sm.getOrderId());
		act.setRegion(orgIdToRegion(so.getOrgId().substring(0, 2)));
		act.setPRODID(sm.getSaleMainCode());
		act.setPRODNAME(sm.getSaleMainName());
		act.setREWARDTYPE(sm.getSaleMainType());
		act.setREWARDCLASS(sm.getExerciseType());
		act.setAVAILABLEDATE(sm.getBeginTime().toString().substring(0, 19));
		act.setENDDATE(sm.getEndTime().toString().substring(0, 19));
		act.setPRIVRELATETYPE(sm.getGradeDefaultRelation());
		act.setUNITEORDERNO(sm.getOrderId());
		act.setCREATEORGID(orgIdToCode(so.getOrgId().substring(0, 2)));

		ArrayList<Channel> channellist = new ArrayList<Channel>();
		for (IBOChannelInfoValue chV : channelDAO.getChannelInfoByRelaId(actId,
				"act", 0, -1)) {
			Channel ch = new Channel();
			ch.setCHANNELID(chV.getChannelCode());
			ch.setOPERATION(chV.getOperation());
			ch.setREGION(chV.getRegion());
			channellist.add(ch);
		}

		ArrayList<CustGroup> custgroupallow = new ArrayList<CustGroup>();
		ArrayList<CustGroup> custgroupforbid = new ArrayList<CustGroup>();
		for (IBOSaleRelatCgroupValue cgV : custGroupDAO
				.getSaleRelatCgroupByRelaId(actId, "act", 0, -1)) {
			CustGroup cg = new CustGroup();
			cg.setCUSTGROUPID(cgV.getCgroupId());
			cg.setREGION(cgV.getCgroupRegion());
			cg.setBEGINDATE(cgV.getCgroupBeginTime().toString()
					.substring(0, 19));
			cg.setENDDATE(cgV.getCgroupEndTime().toString().substring(0, 19));
			if ("0".equals(cgV.getCgroupFlag())) {
				custgroupforbid.add(cg);
			} else {
				custgroupallow.add(cg);
			}
		}

		ArrayList<Org> orglist = new ArrayList<Org>();
		Org org = new Org();
		org.setORGID(region2Code(sm.getExearea()));
		orglist.add(org);

		request.setAct(act);
		request.setChannellist(channellist);
		request.setOrglist(orglist);
		request.setCustgroupallow(custgroupallow);
		request.setCustgroupforbid(custgroupforbid);

		try {
			String response = post(url + interf, head
					+ JSONObject.fromBean(request).toString() + end);
			if (response != null && !("").equals(response.trim())) {
				JSONObject js = JSONObject.fromString(response);
				return js.getJSONObject("body").getJSONObject("response")
						.getString("retcode");
			} else {
				return "555";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "555";
	}

	public String createLevel(String actId, String levId, String interf)
			throws Exception {

		ISaleOrderDAO saleOrderDao = (ISaleOrderDAO) ServiceFactory
				.getService(ISaleOrderDAO.class);
		ISaleMainDAO saleMainDao = (ISaleMainDAO) ServiceFactory
				.getService(ISaleMainDAO.class);
		ISaleChannelInfoDAO channelDAO = (ISaleChannelInfoDAO) ServiceFactory
				.getService(ISaleChannelInfoDAO.class);
		ISaleDetailDAO saleDtDao = (ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class);
		ICustGroupDAO custGroupDAO = (ICustGroupDAO) ServiceFactory
				.getService(ICustGroupDAO.class);
		LevReq request = new LevReq();

		Level level = new Level();
		IBOSaleMainValue sm = saleMainDao.getSaleMainById(actId);
		IBOSaleOrderValue so = saleOrderDao.getSaleOrderInfo(sm.getOrderId());
		IBOSaleDetailValue sd = saleDtDao.getSaleDetailById(levId);

		level.setRegion(orgIdToRegion(so.getOrgId().substring(0, 2)));
		level.setPRODID(sm.getSaleMainCode());
		level.setPRIVID(sd.getSaleActiveCode());
		level.setPRIVNAME(sd.getSaleActiveName());
		level.setSTARTDATE(sm.getBeginTime().toString().substring(0, 19));
		level.setSTOPDATE(sm.getEndTime().toString().substring(0, 19));
		level.setCREATEORG(orgIdToCode(so.getOrgId().substring(0, 2)));
		ArrayList<Channel> channellist = new ArrayList<Channel>();
		for (IBOChannelInfoValue chV : channelDAO.getChannelInfoByRelaId(levId,
				"lev", 0, -1)) {
			Channel ch = new Channel();
			ch.setCHANNELID(chV.getChannelCode());
			ch.setOPERATION(chV.getOperation());
			ch.setREGION(chV.getRegion());
			channellist.add(ch);
		}

		ArrayList<Org> orglist = new ArrayList<Org>();
		Org org = new Org();
		org.setORGID(region2Code(sm.getExearea()));
		orglist.add(org);

		ArrayList<CustGroup> custgroupallow = new ArrayList<CustGroup>();
		ArrayList<CustGroup> custgroupforbid = new ArrayList<CustGroup>();
		for (IBOSaleRelatCgroupValue cgV : custGroupDAO
				.getSaleRelatCgroupByRelaId(levId, "lev", 0, -1)) {
			CustGroup cg = new CustGroup();
			cg.setCUSTGROUPID(cgV.getCgroupId());
			cg.setREGION(cgV.getCgroupRegion());
			cg.setBEGINDATE(cgV.getCgroupBeginTime().toString()
					.substring(0, 19));
			cg.setENDDATE(cgV.getCgroupEndTime().toString().substring(0, 19));
			if ("0".equals(cgV.getCgroupFlag())) {
				custgroupforbid.add(cg);
			} else {
				custgroupallow.add(cg);
			}
		}

		request.setLevel(level);
		request.setChannellist(channellist);
		request.setOrglist(orglist);
		request.setCustgroupallow(custgroupallow);
		request.setCustgroupforbid(custgroupforbid);

		try {
			String response = post(url + interf, head
					+ JSONObject.fromBean(request).toString() + end);
			if (response != null && !("").equals(response.trim())) {
				JSONObject js = JSONObject.fromString(response);
				return js.getJSONObject("body").getJSONObject("response")
						.getString("retcode");
			} else {
				return "555";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "555";
	}

	// operate 1：新增，2：删除
	public String dealCustomer(String groupId, String groupName,
			String userCount, String region, String operate) {

		if (StringUtil.isBlank(groupId) || StringUtil.isBlank(groupName)
				|| StringUtil.isBlank(region)) {
			return "555";
		}
		String param = "{\"groupid\":\"" + groupId + "\",\"groupname\":\""
				+ groupName + "\",\"usercount\":\"" + userCount
				+ "\",\"region\":\"" + region + "\",\"Operate\":\"" + operate
				+ "\"}";

		try {
			String response = post(url + "PTPCEIDealCustomer", head + param
					+ end);
			if (response != null && !("").equals(response.trim())) {
				JSONObject js = JSONObject.fromString(response);
				return js.getJSONObject("body").getJSONObject("response")
						.getString("retcode");
			} else {
				return "555";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "555";
	}

	public String createGroupCustomer(String taskFile, String parameter)
			throws Exception {

		if (taskFile == null || taskFile.trim().equals("")) {
			return "555";
		}
		String taskType = "custGroup";
		// String parameter = "add"; //del删除 add新增
		String operId = "";
		String region = "210";

		String param = "{'TASKTYPE':'" + taskType + "','PARAMETER':'"
				+ parameter + "','TASKFILE':'" + taskFile + "','OPERID':'"
				+ operId + "','region':'" + region + "'}";

		try {
			String response = post(url + "PTPCEICreateGroupCustomer", head
					+ param + end);
			if (response != null && !("").equals(response.trim())) {
				JSONObject js = JSONObject.fromString(response);
				return js.getJSONObject("body").getJSONObject("response")
						.getString("retcode");
			} else {
				return "555";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "555";
	}

	public void qryCustGroupDef(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String param = request.getParameter("param");
		try {

			String url = "http://10.30.43.203:7211/ebus/httpService/UnifyMarketService/PTPCEIQryCustGroupDef";
			String jsonStr = post(url, param);
			cp.set("jsonStr", jsonStr);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");

		} catch (Exception e) {
		} finally {
		}
	}

	public String post(String url, String param) {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 设置请求和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(
				5000).setConnectTimeout(5000).build();
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		String response = null;
		System.out.println(url);
		System.out.println(param);
		try {
			StringEntity s = new StringEntity(param, "GB2312");
			// s.setContentType("application/json");
			post.setEntity(s);
			post.setHeader("Content-Type", "application/json;charset=GB2312");
			HttpResponse res = httpClient.execute(post);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = res.getEntity();
				response = EntityUtils.toString(entity);
				System.out.println(response);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (post != null)
				post.releaseConnection();
		}
		return response;

	}

	public String inputStream2String(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i = -1;
		while ((i = is.read()) != -1) {
			baos.write(i);
		}
		return baos.toString();
	}

	private String orgIdToRegion(String orgId) {
		switch (Integer.parseInt(orgId)) {
		case 10:
			orgId = "999";
			break;
		case 28:
			orgId = "728";
			break;
		case 27:
			orgId = "728";
			break;
		case 11:
			orgId = "270";
			break;
		case 12:
			orgId = "714";
			break;
		case 19:
			orgId = "715";
			break;
		case 13:
			orgId = "711";
			break;
		case 24:
			orgId = "722";
			break;
		case 14:
			orgId = "717";
			break;
		case 16:
			orgId = "719";
			break;
		case 18:
			orgId = "728";
			break;
		case 20:
			orgId = "716";
			break;
		case 15:
			orgId = "718";
			break;
		case 23:
			orgId = "724";
			break;
		case 25:
			orgId = "713";
			break;
		case 17:
			orgId = "710";
			break;
		case 26:
			orgId = "712";
			break;
		default:
		}
		return orgId;
	}

	private String region2Code(String orgId) {
		switch (Integer.parseInt(orgId)) {
		case 999:
			orgId = "HB";
			break;
		case 728:
			orgId = "HB.JH";
			break;
		case 270:
			orgId = "HB.WH";
			break;
		case 714:
			orgId = "HB.HS";
			break;
		case 715:
			orgId = "HB.XN";
			break;
		case 711:
			orgId = "HB.EZ";
			break;
		case 722:
			orgId = "HB.SZ";
			break;
		case 717:
			orgId = "HB.YC";
			break;
		case 719:
			orgId = "HB.SY";
			break;
		case 716:
			orgId = "HB.JZ";
			break;
		case 718:
			orgId = "HB.ES";
			break;
		case 724:
			orgId = "HB.JM";
			break;
		case 713:
			orgId = "HB.HG";
			break;
		case 710:
			orgId = "HB.XF";
			break;
		case 712:
			orgId = "HB.XG";
			break;
		default:
		}
		return orgId;
	}

	private String orgIdToCode(String orgId) {
		switch (Integer.parseInt(orgId)) {
		case 10:
			orgId = "HB";
			break;
		case 28:
			orgId = "HB.TM";
			break;
		case 27:
			orgId = "HB.QJ";
			break;
		case 11:
			orgId = "HB.WH";
			break;
		case 12:
			orgId = "HB.HS";
			break;
		case 19:
			orgId = "HB.XN";
			break;
		case 13:
			orgId = "HB.EZ";
			break;
		case 24:
			orgId = "HB.SZ";
			break;
		case 14:
			orgId = "HB.YC";
			break;
		case 16:
			orgId = "HB.SY";
			break;
		case 18:
			orgId = "HB.JH";
			break;
		case 20:
			orgId = "HB.JZ";
			break;
		case 15:
			orgId = "HB.ES";
			break;
		case 23:
			orgId = "HB.JM";
			break;
		case 25:
			orgId = "HB.HG";
			break;
		case 17:
			orgId = "HB.XF";
			break;
		case 26:
			orgId = "HB.XG";
			break;
		default:
		}
		return orgId;
	}
}
