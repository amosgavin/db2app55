package com.ai.bce.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.bce.ivalues.ISubmitData;
import com.ai.bce.valuebean.NodeDataBean;
import com.ai.bce.valuebean.NodeXmlDataBean;
import com.ai.bce.valuebean.SubmitDataBean;

public class SubmitDataXmlParseUtil {

	private static transient Log log = LogFactory
			.getLog(SubmitDataXmlParseUtil.class);
	private static int bufferLen = 10240;

	/**
	 * 解析前台传过来的非一页一页的数据
	 * 
	 * @param reader
	 * @return
	 * @throws Exception
	 * @author shaosm
	 */
	public static ISubmitData[] parseSubmitData(HttpServletRequest reader)
			throws Exception {
		String contentSplitStr = "|@|@|";
		ArrayList rtnList = new ArrayList();
		/*StringBuffer strBuffer = new StringBuffer();
		char[] bufChar = new char[bufferLen];
		int readLen = 0;
		for (; (readLen = reader.read(bufChar)) != -1;) {
			strBuffer.append(bufChar, 0, readLen);
		}*/
		String xmlStr = HttpUtil.getStringFromBufferedReader(reader);
		// if(xmlStr==null) break;
		if (log.isDebugEnabled()) {
			log
					.debug("===================================.start======================================");
			log.debug("Xml Info:" + xmlStr);
			log
					.debug("=====================================.end======================================");
		}
		String[] splitXMLStr = StringUtils.splitByWholeSeparator(xmlStr,
				contentSplitStr);
		for (int j = 0; j < splitXMLStr.length; j++) {
			if (StringUtils.isBlank(splitXMLStr[j]))
				continue;
			// StringReader strReader = new StringReader(splitXMLStr[j]);
			// ByteArrayInputStream strIn = new
			// ByteArrayInputStream(splitXMLStr[j].getBytes("UTF-8"));
			/*StringBufferInputStream strIn = new StringBufferInputStream(
					splitXMLStr[j]);
*/			
			
				ISubmitData objSubmitData = SubmitDataXmlParseUtil
						.parseSubmitData(splitXMLStr[j]);
				rtnList.add(objSubmitData);
			
		}

		return (ISubmitData[]) rtnList.toArray(new ISubmitData[0]);
	}

	public static ISubmitData parseSubmitData(String in) throws Exception {
		SubmitDataBean submitData = SubmitDataXmlParseUtil
				.getNewSubmitDataInstance();

		// 解析xml inputstream
		Document doc = 		 DocumentHelper.parseText(in);
		
		Element root = doc.getRootElement();
		submitData.setName(root.attributeValue("name"));
		submitData.setCurPageId(root.attributeValue("curpageid"));
		submitData.setNextPageId(root.attributeValue("nextpageid"));
		submitData.setType(root.attributeValue("type"));

		for (Iterator i = root.elementIterator(); i.hasNext();) {
			Element element = (Element) i.next();
			// nodeinfo节点
			if (element.getName().equals("nodeinfo")) {
				NodeDataBean nodeInfo = new NodeDataBean();
				nodeInfo.setName(element.attributeValue("name"));
				nodeInfo.setInfotype(element.attributeValue("infotype"));
				for (Iterator j = element.elementIterator(); j.hasNext();) {
					Element nodeElement = (Element) j.next();

					// userdata
					if (nodeElement.getName().equals("UD")) {
						CustomProperty cp = CustomProperty.getInstance();
						cp.initial(nodeElement.asXML());
						nodeInfo.setUserData(cp);
					}

					// nodexml
					if (nodeElement.getName().equals("nodexml")) {
						NodeXmlDataBean nodexml = new NodeXmlDataBean();
						nodexml.setName(nodeElement.attributeValue("name"));
						nodexml.setXmltype(nodeElement
								.attributeValue("xmltype"));
						for (Iterator m = nodeElement.elementIterator(); m
								.hasNext();) {
							Element rootInfoXmlElement = (Element) m.next();
							if (rootInfoXmlElement.getName().equals("RootInfo")) {
								nodexml
										.setXmlstring(rootInfoXmlElement
												.asXML());
							}
							// child submitUserData
							if (rootInfoXmlElement.getName().equals(
									"submitdata")) {
								/*InputStream inputStream = new ByteArrayInputStream(
										rootInfoXmlElement.asXML().getBytes(
												"UTF-8"));*/
								ISubmitData childsubmitData = SubmitDataXmlParseUtil
										.parseSubmitData(rootInfoXmlElement.asXML());
								nodeInfo.addChildSubmitData(childsubmitData);
							}
						}
						nodeInfo.AddNodexml(nodexml);
					}
				}

				submitData.addNodeInfo(nodeInfo);
			}

		}

		return (ISubmitData) submitData;
	}

	public static SubmitDataBean getNewSubmitDataInstance() {
		return new SubmitDataBean();
	}
}
