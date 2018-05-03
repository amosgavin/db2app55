/***********************************************************************
 * Module:       BceDBAutoGridTag.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Dec 3, 2010
 ***********************************************************************/

package com.ai.bce.web.tag;

import javax.servlet.jsp.PageContext;

import com.ai.appframe2.web.tag.AIDBGridTag;

public class BceDBAutoGridTag extends AIDBGridTag{

	public void setPageContext(PageContext pageContext) {
	  if(m_grid == null){
		  m_grid = new BceDBGridImpl();
	  }
	  m_grid .setSetname("${class=com.ai.bce.web.BceAutoSetAction;method=getBceAttrGrid}");
	  super.setPageContext(pageContext);
  }
	
	public void setBceframeid(String bceFrameId) {
		((BceDBGridImpl)m_grid).setBceframeid(bceFrameId);
	}	
}
