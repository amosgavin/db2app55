package com.asiainfo.common.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.sun.org.apache.xml.internal.serializer.utils.Utils;

public class ConnCRMClientAction extends BaseAction {

	private transient static Log log = LogFactory
			.getLog(ConnCRMClientAction.class);

	private static final int TIMEOUT = 60;

	public void requestCrm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String param = request.getParameter("param");
		try {

			String interfaceID = request.getParameter("interfaceID");
			// 正式环境
			//String url = "http://10.25.5.163:7211/ebus/httpService/ProductManager/MRTMGR" + interfaceID;
			// 测试环境
			String url = "http://10.30.43.108:7211/ebus/httpService/ProductManager/MRTMGR"
					+ interfaceID;
			String jsonStr = post(url, param);
			cp.set("jsonStr", jsonStr);
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

	public String post(String url, String param) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		String response = null;
		System.out.println(url);
		System.out.println(param);
		try {
			// param =
			// "{'head':{ 'accessType':'bsacMktmgr', 'interfaceID':'MRTMGRQueryPrivStatus', 'reqTime':'20140331173759', 'reqSeq':'1000000001', 'operatorID':'', 'region':'999' }, 'body':{ 'privID':'test' } }";
			StringEntity s = new StringEntity(param);
			//s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			post.setEntity(s);
			post.setHeader("Content-Type", "application/json");
			HttpResponse res = client.execute(post);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = res.getEntity();
				//String charset = EntityUtils.getContentCharSet(entity);
				response = EntityUtils.toString(entity, "GB2312");
				System.out.println(response);
			}
		} catch (Exception e) {
			System.err.print(e);
			throw new RuntimeException(e);
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

	public static final HttpParams createHttpParams() {
		final HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setStaleCheckingEnabled(params, false);
		HttpConnectionParams.setConnectionTimeout(params, TIMEOUT * 1000);
		HttpConnectionParams.setSoTimeout(params, TIMEOUT * 1000);
		HttpConnectionParams.setSocketBufferSize(params, 8192 * 5);
		return params;
	}
}
