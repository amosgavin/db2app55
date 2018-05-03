/**   
 * @Title: PrintFileConfig.java 
 * @Package com.ai.bce.auto.plugin.qr 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Qinjin Peng (Pengqj@asiainfo-linkage.com)   
 * @date 2011-4-9 下午03:50:16 
 * @version V1.0   
 */
package com.ai.bce.auto.plugin.qr;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.ai.appframe2.util.XmlUtil;
import com.ai.bce.util.define.AbstraParse;

/**
 * 解析配置文件实现类
 * 
 * @ClassName: PrintFileConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Qinjin Peng
 * @date 2011-4-9 下午03:50:16
 * 
 */

public class PrintFileConfig extends AbstraParse {

	/*
	 * (非 Javadoc) <p>Title: parseXml</p> <p>Description: </p>
	 * 
	 * @param fileName
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see com.ai.bce.util.ParseInterface#parseXml(java.lang.String)
	 */
	public Object parseXml(String fileName) throws Exception {
		// TODO Auto-generated method stub
		Element root = XmlUtil.parseXml(fileName);
		Map map = new HashMap();
		Map orderIdGenMap = getOrderIdMap(root);
		map.put("orderIdGenMap", orderIdGenMap);
		return map;
	}

	/**
	 * @Title: getOrderIdMap
	 * @Description: TODO
	 * @param @param root
	 * @param @return
	 * @return Map
	 * @throws
	 */
	private Map getOrderIdMap(Element root) {
		// TODO Auto-generated method stub
		Element orderId = root.element("getServiceOrderId");
		Map map  = new HashMap();
		List elments =orderId.elements();
		for (Iterator iterator = elments.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			String key  = element.attributeValue("key");
			String value = element.attributeValue("value");
			map.put(key, value);
		}
		return map;
	}
}
