/***********************************************************************
 * Module:       BceDBAutoFormTag.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Nov 18, 2010
 ***********************************************************************/

package com.ai.bce.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.web.tag.AIDBAutoFormTag;
import com.ai.appframe2.web.tag.DBAutoFormImpl;
import com.ai.appframe2.web.tag.FieldItemInterface;
import com.ai.appframe2.web.tag.JSHelper;

public class BceDBAutoFormTag extends AIDBAutoFormTag{
	private DBAutoFormImpl m_form;
	public static transient Log log = LogFactory
			.getLog(BceDBAutoFormTag.class);

  public void setPageContext(PageContext pageContext) {
    m_form = new BceDBAutoFormImpl();
    m_form.setSetname("${class=com.ai.bce.web.BceAutoSetAction;method=getBceAttrAutoForm}");
    m_form.setTemplateEchoClassName("com.ai.bce.web.BceAutoSetEchoClass");
    super.setPageContext(pageContext);
  }
  
  public int doStartTag() throws JspException {
    JSHelper.processJS(pageContext, (HttpServletRequest) pageContext.getRequest(),
		       "DBAutoForm_Tag_Js");
    
    return m_form.doStartTag(pageContext);
  }
  
  public int doEndTag() throws JspException {
    int reVal = m_form.doEndTag(pageContext);
    m_form = null;

    //add by YangHua,increment chunks;
    try {
      pageContext.getOut().flush();
    }
    catch (IOException ex) {
      throw new JspException(ex);
    }

    return reVal;
  }
  
  public void setBceframeid(String bceFrameId){
  	((BceDBAutoFormImpl)m_form).setBceframeid(bceFrameId);
  }

  public void setSetname(String setName) {

    m_form.setSetname(setName);
  }

  public void setDatamodel(String dataModel) {

    m_form.setDatamodel(dataModel);
  }

  public void setFormid(String formId) {

    m_form.setFormid(formId);
  }

  public void setOnvalchange(String onvalchange) {

    m_form.setOnvalchange(onvalchange);
  }

  public void setOndblink(String ondblink){
	if("true".equalsIgnoreCase(ondblink)){
		ondblink = "g_AiBceAutoForm.onDbLink";
		try {
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			pageContext.getOut().write("<script language=\"JavaScript\" src=\""+request.getContextPath()
					+"/bce/frame/js/bceAutoForm.js\"></script>");
		} catch (IOException e) {
			if (log.isErrorEnabled()) {
				log.error("加载bceAutoForm.js出现异常", e);
			}
		}
	}
    m_form.setOndblink(ondblink);
  }

  public void setConditionname(String conditionname) {

    m_form.setConditionname(conditionname);
  }

  public void setParametersname(String parametersname) {

    m_form.setParametersname(parametersname);
  }

  public void setEditable(String editable) {

    m_form.setEditable(editable);
  }

  public void setInitial(String initial) {

    m_form.setInitial(initial);
  }


  public void setOnfocusin(String onfocusin) {
    m_form.setOnfocusin(onfocusin);
  }

  public void setOnfocusout(String onfocusout) {
    m_form.setOnfoucsout(onfocusout);
  }

  public void setTemplatename(String templatename) throws JspException{
    ((BceDBAutoFormImpl)m_form).setTemplatename(templatename);
  }

  public void setColnum(String colNum){
    ((BceDBAutoFormImpl)m_form).setColNum(colNum);
  }

  public void addFieldItem(FieldItemInterface fieldItem){
    ((BceDBAutoFormImpl)m_form).addFieldItem(fieldItem);
  }

  public void setTemplateclass(String className) throws JspException{
	  ((BceDBAutoFormImpl)m_form).setTemplateEchoClassName(className);
  }


  public void setOnkeypress(String onkeypress){

  }
  
  public void setImplservice_name(String implservice_name) {
		this.m_form.setImplservice_name(implservice_name);
	}

	public void setImplservice_querymethod(String implservice_querymethod) {
		this.m_form.setImplservice_querymethod(implservice_querymethod);
	}
}
