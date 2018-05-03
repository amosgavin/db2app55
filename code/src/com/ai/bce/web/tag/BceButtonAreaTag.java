/***********************************************************************
 * Module:       BceButtonAreaTag.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Nov 20, 2010
 ***********************************************************************/

package com.ai.bce.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.web.tag.AIButtonTag;
import com.ai.appframe2.web.tag.JSHelper;
import com.ai.bce.ivalues.IQBceBusinessButtonValue;
import com.ai.bce.util.BceServiceFactory;

public class BceButtonAreaTag extends BodyTagSupport{

	private static transient Log log = LogFactory.getLog(BceButtonAreaTag.class);
	private String bceFrameId;
	private String areaId;

	public int doStartTag() throws JspException {
		JSHelper.processJS(pageContext, (HttpServletRequest) pageContext
				.getRequest(), "AIButton_Tag_Js");
		return Tag.EVAL_PAGE;
	}
	
	public int doEndTag() throws JspException {
		try {
			IQBceBusinessButtonValue[] bbs = BceServiceFactory.getBceFrameSV()
					.getQBceBusinessButton(Long.parseLong(bceFrameId), areaId);
			for (int i = 0; i < bbs.length; i++) {
				//删除了生成的文件方式增加了模拟JSP生成代码方式
				AIButtonTag aiButtonTag = new AIButtonTag();
				aiButtonTag.setPageContext(this.pageContext);
				aiButtonTag.setId(bbs[i].getButtonCode());
				aiButtonTag.setText(bbs[i].getText());
				aiButtonTag.setI18nRes(bbs[i].getI18nRes());
				aiButtonTag.setOnclick(bbs[i].getEventClick());
				aiButtonTag.setEnable("1".equals(bbs[i].getEnable())?"true":"false");
				aiButtonTag.doStartTag();
				aiButtonTag.doEndTag();
				pageContext.getOut().append("&nbsp;&nbsp;");
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new JspException(ex);
		}
		return Tag.EVAL_PAGE;
	}

	public String getAreaid() {
		return areaId;
	}

	public void setAreaid(String areaId) {
		this.areaId = areaId;
	}

	public String getBceframeid() {
		return bceFrameId;
	}

	public void setBceframeid(String bceFrameId) {
		this.bceFrameId = bceFrameId;
	}
}
