package com.ai.bce.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.tag.AITabItemTag;
import com.ai.appframe2.web.tag.AITabTag;
import com.ai.appframe2.web.tag.JSHelper;
import com.ai.bce.ivalues.IBceFrameAreaPagetabValue;
import com.ai.bce.ivalues.IBceFrameTabitemValue;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.valuebean.BceTabBean;

/**
 * Bce提供TabAreaTag 标签源码
 * <p>
 * Copyright (c) 2010 Asiainfo-Linkage
 * </p>
 * 
 * @ClassName: BceTabAreaTag.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Feb 26, 2011 1:32:26 PM
 */
public class BceTabAreaTag extends BodyTagSupport {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	private static transient Log log = LogFactory.getLog(BceTabAreaTag.class);

	String bceframeid;
	String areaid;

	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JSHelper.processJS(pageContext, (HttpServletRequest) pageContext
				.getRequest(), "AITab_Tag_Js");
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		try {
			/*
			 * IQBceBusinessButtonValue[] bbs =
			 * BceServiceFactory.getBceFrameSV()
			 * .getQBceBusinessButton(Long.parseLong(bceFrameId), areaId);
			 */// for (int i = 0; i < bbs.length; i++) {
			// 删除了生成的文件方式增加了模拟JSP生成代码方式
			BceTabBean tabBean = BceServiceFactory.getBceFrameSV()
					.getQBusiTabArea(Long.parseLong(bceframeid), areaid);
			AITabTag aiTabTag = new AITabTag();
			aiTabTag.setPageContext(pageContext);
			IBceFrameAreaPagetabValue areaPageTab = tabBean
					.getAreaPagetabValue();
			aiTabTag.setId("bce_tab_" + areaPageTab.getTabId());
			aiTabTag.setAfterSetTab(areaPageTab.getAftersettab());
			aiTabTag.setBeforeSetTab(areaPageTab.getBeforesettab());
			aiTabTag.setGetParameter(areaPageTab.getGetparameter());
			aiTabTag.setHeight(areaPageTab.getHeight());
			aiTabTag.setParent(this.getParent());
			if (StringUtils.isNotBlank(areaPageTab.getTabType()))
				aiTabTag.setType(areaPageTab.getTabType());
			aiTabTag.setVmFile(areaPageTab.getVmfile());
			aiTabTag.setWidth(areaPageTab.getWidth());
			aiTabTag.setParent(this.getParent());
			aiTabTag.doStartTag();
			StringBuffer buffer  =new StringBuffer();
			buffer.append("<script>");
			IBceFrameTabitemValue[] tabitemes = tabBean.getTabitemValues();
			for (int i = 0; i < tabitemes.length; i++) {
				IBceFrameTabitemValue tabValue = tabitemes[i];
				AITabItemTag tabItem = new AITabItemTag();
				tabItem.setId(tabValue.getTabId() + "_"
						+ tabValue.getTabItemId());
				tabItem.setI18nRes(tabValue.getI18nres());
				tabItem.setInitial(tabValue.getIsinitial() == 1 ? "true"
						: "false");
				tabItem.setIsDeletable(tabValue.getIsdeletable());
				tabItem.setMo(tabValue.getMo());
				tabItem.setSrc(getUrl(tabValue));
				tabItem.setTitle(tabValue.getTitle());
				tabItem.setWidth(tabValue.getWidth());
				tabItem.setParent(aiTabTag);
				tabItem.doStartTag();
				tabItem.doEndTag();
				if(StringUtils.isNotBlank(tabValue.getOnclose())){
					buffer.append("tabCloseFunction('"+tabValue.getTabId() + "_"
							+ tabValue.getTabItemId()+"','"+tabValue.getOnclose()+"','"+areaPageTab.getTabId()+"');");
				}
			}

			aiTabTag.doEndTag();
			buffer.append("</script>");
			// }
			pageContext.getOut().print(buffer.toString());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new JspException(ex);
		}
		return Tag.EVAL_PAGE;
	}

	private String getUrl(IBceFrameTabitemValue tabValue) throws Exception {
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		String url = "";
		if (!(tabValue.getSrc().startsWith("http://") || tabValue.getSrc()
				.startsWith("https://")))
			url = request.getContextPath();
		url += tabValue.getSrc();
		String paramsQuery= request.getQueryString();
		String srcParams = tabValue.getSrcParams();
		if (StringUtils.isNotBlank(srcParams)) {
			String[] params = srcParams.split(",");
			for (int i = 0; i < params.length; i++) {
				if("$USE_PPARAMS".equals(params[i]))
				{
					if(StringUtils.isBlank(paramsQuery))continue;
					if(url.indexOf("?")<0){	url+="?";}
					else{url+="&";}
					url+=paramsQuery;
					continue;
				}
				String[] se = StringUtils.split(params[i], "=");
				if (se.length != 2)
					throw new BceException("BES0000790");
				String key = se[0];
				String value = se[1];
				if (value.startsWith("$REQUEST.")) {
					value = HttpUtil.getAsString(request, value
							.substring("$REQUEST.".length()));
				}else if (value.startsWith("$PAGE.")) {
					value = (String) pageContext.getAttribute(value
							.substring("$PAGE.".length()));
				}
				if(url.indexOf("?")<0){url+="?";}
				else{url+="&";}
				url+=key+"="+value;
			}
		}
		return url;
	}

	public String getBceframeid() {
		return bceframeid;
	}

	public void setBceframeid(String bceframeid) {
		this.bceframeid = bceframeid;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

}
