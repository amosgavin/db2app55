/***********************************************************************
 * Module:       BceDBAutoFormImpl.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Nov 18, 2010
 ***********************************************************************/

package com.ai.bce.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.util.charset.CharsetFactory;
import com.ai.appframe2.util.locale.AppframeLocaleFactory;
import com.ai.appframe2.web.tag.DBAutoFormImpl;
import com.ai.bce.ivalues.IBceFrameAreaFormValue;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;

public class BceDBAutoFormImpl extends DBAutoFormImpl{
	private static transient Log log = LogFactory.getLog(BceDBAutoFormImpl.class);
  public static final int COL_NUM = 4;
  private static Template defaultTemplate = null;
  private long bceFrameId;
  private String templateName;
  
  /**
   * Process the start tag for this instance.
   *
   * @throws JspException
   * @return int
   * @todo Implement this javax.servlet.jsp.tagext.Tag method
   */
  public int doStartTag(PageContext aPageContext) throws JspException {
    try {
    	SessionManager.getRequest().setAttribute(BceUtil.BCE_FRAME_ID_KEY, new Long(bceFrameId));
    	SessionManager.getRequest().setAttribute(BceUtil.AREA_ID, formId);
    	IBceFrameAreaFormValue[] ba = BceServiceFactory.getBceFrameSV().getBceFrameAreas(bceFrameId, formId);
    	if(ba != null && ba.length > 0){
    		if(ba[0].getCols() > 0)
    			setColNum(String.valueOf(ba[0].getCols()));
    		if(StringUtils.isNotBlank(ba[0].getTemplateId()))
    			setTemplatename(ba[0].getTemplateId());
    		else if(StringUtils.isBlank(this.templateName))
    			setTemplatename("com/ai/bce/template/BceAttrTemplate.vm");
    		if(StringUtils.isNotBlank(ba[0].getDataModel()))
    			this.setDatamodel(ba[0].getDataModel());
    		if(StringUtils.isNotBlank(ba[0].getServiceName()))
    			this.setImplservice_name(ba[0].getServiceName());
    		if(StringUtils.isNotBlank(ba[0].getQueryMethod()))
    			this.setImplservice_querymethod(ba[0].getQueryMethod());
    		if(StringUtils.isNotBlank(ba[0].getConditionName()))
    			this.setConditionname(ba[0].getConditionName());
    		if(StringUtils.isNotBlank(ba[0].getParameterName()))
    			this.setParametersname(ba[0].getParameterName());
    		if(StringUtils.isNotBlank(ba[0].getMo())){
    			this.setMo(ba[0].getMo());
    		}
    		if(StringUtils.isNotBlank(ba[0].getOperator())){
    			this.setOperator(ba[0].getOperator());
    		}
    		this.setEditable(ba[0].getIsEditable()==1?"true":"false");
    		this.setInitial(ba[0].getIsInitial()==1?"true":"false");
    		
    		if(StringUtils.isNotBlank(ba[0].getOnValuechange())){
    			this.setOnvalchange(ba[0].getOnValuechange());
    		}
    	}
    	 
    	super.doStartTag(aPageContext);
    	setSetname(this.builder.getFieldTypeSetDB().getFullName());
    }
    catch (Exception ex) {
      log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.web.tag.DBAutoFormImpl.dostart_error"),ex);
      throw new JspException("doStartTag error.ex:"+ex);
    }

    return Tag.EVAL_BODY_INCLUDE;
  }

  public static Template getDefaultTemplate() throws Exception {
    if (defaultTemplate == null) {
      defaultTemplate = Velocity.getTemplate("com/ai/bce/template/BceAttrTemplate.vm", CharsetFactory.getDefaultCharset());
    }
    return defaultTemplate;
  }  
  
  public void setBceframeid(String bceFrameId){
  	this.bceFrameId = Long.parseLong(bceFrameId);
  }
  
  public void setTemplatename(String pTemplatename) throws JspException{
  	super.setTemplatename(pTemplatename);
    this.templateName = pTemplatename;
   }
}

