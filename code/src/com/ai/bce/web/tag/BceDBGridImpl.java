/***********************************************************************
 * Module:       BceDBGridImpl.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Dec 3, 2010
 ***********************************************************************/

package com.ai.bce.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.util.locale.AppframeLocaleFactory;
import com.ai.appframe2.web.tag.DBGridImpl;
import com.ai.bce.ivalues.IBceFrameAreaFormValue;
import com.ai.bce.ivalues.IQBceBusinessAttrValue;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;

public class BceDBGridImpl extends DBGridImpl{
	private static transient Log log = LogFactory.getLog(BceDBGridImpl.class);
  private long bceFrameId;

	public int doEndTag(PageContext aPageContext) throws JspException {
		try{
			SessionManager.getRequest().setAttribute(BceUtil.BCE_FRAME_ID_KEY, new Long(bceFrameId));
			SessionManager.getRequest().setAttribute(BceUtil.AREA_ID,this.getTableid());
			IBceFrameAreaFormValue[] ba = BceServiceFactory.getBceFrameSV().getBceFrameAreas(bceFrameId, this.getTableid());
    	if(ba != null && ba.length > 0){
    		if(StringUtils.isNotBlank(ba[0].getDataModel()))
    			this.setTablemodel(ba[0].getDataModel());
    		if(StringUtils.isNotBlank(ba[0].getServiceName()))
    			this.setImplservice_name(ba[0].getServiceName());
    		if(StringUtils.isNotBlank(ba[0].getQueryMethod()))
    			this.setImplservice_querymethod(ba[0].getQueryMethod());
    		if(StringUtils.isNotBlank(ba[0].getCountMethod()))
    			this.setImplservice_countmethod(ba[0].getCountMethod());
    		if(StringUtils.isNotBlank(ba[0].getConditionName()))
    			this.setConditionname(ba[0].getConditionName());
    		if(StringUtils.isNotBlank(ba[0].getParameterName()))
    			this.setParametersname(ba[0].getParameterName());
    		if(StringUtils.isNotBlank(ba[0].getWidth())){
    			this.setWidth(ba[0].getWidth());
    		}
    		if(StringUtils.isNotBlank(ba[0].getHeight())){
    			this.setHeight(ba[0].getHeight());
    		}
    		if(StringUtils.isNotBlank(ba[0].getRowHeight())){
    			this.setRowHeight(ba[0].getRowHeight());
    		}
    		if(StringUtils.isNotBlank(ba[0].getMo())){
    			this.setMo(ba[0].getMo());
    		}
    		if(StringUtils.isNotBlank(ba[0].getOperator())){
    			this.setOperator(ba[0].getOperator());
    		}
    		if(ba[0].getPageSize() != 0){
    			this.setPagesize(String.valueOf(ba[0].getPageSize()));
    		}
    		this.setMultiselect(ba[0].getMultSelect()==1?"true":"false");
    		this.setNeedrefresh(ba[0].getNeedRefresh()==1?"true":"false");
    		this.setFootdisplay(ba[0].getFootDisplay()==1?"block":"none");
    		this.setEditable(ba[0].getIsEditable()==1?"true":"false");
    		this.setInitial(ba[0].getIsInitial()==1?"true":"false");
    		

    		if(StringUtils.isNotBlank(ba[0].getOnDbclick())){
    			this.setOndbclick(ba[0].getOnDbclick());
    		}
    		if(StringUtils.isNotBlank(ba[0].getOnValuechange())){
    			this.setOnvalchange(ba[0].getOnValuechange());
    		}
    		if(StringUtils.isNotBlank(ba[0].getOnRowchange())){
    			this.setOnrowchange(ba[0].getOnRowchange());
    		}
    	}
			IQBceBusinessAttrValue[] attrs = BceServiceFactory.getBceFrameSV().getQBceBusinessAttrs(bceFrameId,this.getTableid());
			for(int i=0;i<attrs.length;i++){
				if(StringUtils.isNotBlank(attrs[i].getFieldWidth()))
				  setColWidths(attrs[i].getAttrCode(), attrs[i].getFieldWidth());
				if(attrs[i].getIsVisible() == 1)
					AddCol(attrs[i].getAttrCode(), true);
				else 
					AddCol(attrs[i].getAttrCode(), false);
			}
			super.doEndTag(aPageContext);
		}
		catch(Exception ex){
			log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.web.tag.DBGridImpl.construct_erro"),ex);
      throw new JspException("construct_erro error.ex:"+ex);
		}
		
		return Tag.EVAL_PAGE;
	}
	
	public void setBceframeid(String bceFrameId){
  	this.bceFrameId = Long.parseLong(bceFrameId);
  }
}
