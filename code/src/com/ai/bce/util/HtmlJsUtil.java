package com.ai.bce.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.ScriptTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;
import org.htmlparser.visitors.HtmlPage;

public class HtmlJsUtil {
	public static transient Log log = LogFactory.getLog(HtmlJsUtil.class);
	public static final int SRC_FILE_TYPE_HTTP = 0;

	public static void main(String[] args) throws ParserException, BceException {
		getFunction("http://10.70.181.8:9090/zjcrm/crm/common/CacheRefresh.jsp?id=,com.ai.bce.auto.plugin.cache.BceServiceCache");
	}

	/**
	 * �������������
	 * 
	 * @param filePath
	 * @return
	 * @throws BceException
	 * @throws ParserException
	 */
	public static Map getFunction(String filePath) throws BceException,
			ParserException {
		byte[] responseBody = getFilContent(filePath,
				HtmlJsUtil.SRC_FILE_TYPE_HTTP);
		String fileContent = new String(responseBody);
		
		Parser myParser;
		myParser = Parser.createParser(fileContent, "utf8");
		HtmlPage visitor = new HtmlPage(myParser);
		NodeFilter filterJS = new NodeClassFilter(ScriptTag.class);
		NodeList nodelist;
		nodelist = myParser.parse(filterJS);
		StringBuffer buffer  =  new StringBuffer();
		for (SimpleNodeIterator iterator = nodelist.elements(); iterator
				.hasMoreNodes();) {
			ScriptTag type = (ScriptTag) iterator.nextNode();
			String src  = type.getAttribute("src");
			if(StringUtils.isBlank(src)){
				buffer.append(type.getScriptCode());
			}
		}
		System.out.println(buffer.toString());
		return null;
	}

	public static byte[] getFilContent(String filePath, int fileType)
			throws BceException {
		// ��ȡ����
		byte[] responseBody = null;
		try {
			// ����HttpClient��ʵ��
			HttpClient httpClient = new HttpClient();
			HttpClientParams params = new HttpClientParams();
			params.setParameter("JSESSIONID", "");
			httpClient.setParams(params);
			// ����GET������ʵ��
			GetMethod getMethod = new GetMethod(filePath);
			// ʹ��ϵͳ�ṩ��Ĭ�ϵĻָ�����
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler());
			// ִ��getMethod
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ getMethod.getStatusLine());
			}
			responseBody = getMethod.getResponseBody();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Get Resource Error~", e);
			}
			throw new BceException(e);
		}
		// ��������
		return responseBody;
	}

	class HtmlModel {

	}
}

class JsFunctionModel {
	/**
	 * ��������
	 */
	String funcName;
	/**
	 * �ļ��б�
	 */
	List countList;

}
