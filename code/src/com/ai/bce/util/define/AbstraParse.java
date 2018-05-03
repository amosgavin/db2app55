package com.ai.bce.util.define;

import org.dom4j.Element;

import com.ai.appframe2.util.XmlUtil;

public abstract class AbstraParse {
	public abstract Object parseXml(String fileName) throws Exception;

	public Element getRootElement(String fileName) throws Exception {
		Element element = XmlUtil.parseXml(fileName);
		return element;
	}
}
