/***********************************************************************
 * Module:       IBceTagPFormDAO.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Nov 17, 2010
 ***********************************************************************/

package com.ai.bce.plugin.form.dao.interfaces;

import java.util.Map;

import com.ai.bce.plugin.form.ivalues.IBceTagPFormFieldValue;
import com.ai.bce.plugin.form.ivalues.IBceTagPFormValue;

public interface IBceTagPFormDAO {
	
	public IBceTagPFormValue getBceTagPForm(long objectId)throws Exception;

	public IBceTagPFormValue[] getBceTagPForm(String cond,Map param)throws Exception;
	
	public IBceTagPFormFieldValue[] getBceTagPFormField(String cond,Map param)throws Exception;
}
