package com.ai.bce.create;

import javax.servlet.http.HttpServletRequest;

import com.ai.bce.create.template.impl.TemplateStringForJs;

/**
 * 模版语言实现 Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: AbstractTemplateString.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Nov 8, 2010 8:37:22 PM
 */
public abstract class AbstractTemplateString {
	protected StringBuffer tempBuffer = new StringBuffer();
	public static final String PARAM_REQUEST = "$REQUEST";
	public static final String PARAM_DBGRID = "$DBGRID";
	public static final String PARAM_DBFORM = "$DBFORM";
	public static final String PARAM_NORMAL = "$NORMAL";
	public static final String PARAM_N = "$";
	protected HttpServletRequest request ;
	
	private boolean isDy ;

	
	public boolean isDy() {
		return isDy;
	}

	public void setDy(boolean isDy) {
		this.isDy = isDy;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public abstract String dispalayString(long pageId) throws Exception;
	
	public String dispalayByRusetId(long ruleSetID) throws Exception {
		return "";
	}
	
	public static void main(String[] args) throws Exception {
		AbstractTemplateString abstractTemplateString = new TemplateStringForJs();
		abstractTemplateString.setDy(false);
		System.out.println(abstractTemplateString.dispalayByRusetId(300110));
	}
}
