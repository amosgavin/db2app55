/***********************************************************************
 * Module:       IBceTagPFormSV.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Nov 17, 2010
 ***********************************************************************/

package com.ai.bce.plugin.form.service.interfaces;

import com.ai.bce.plugin.form.ivalues.IBceTagPFormFieldValue;
import com.ai.bce.plugin.form.ivalues.IBceTagPFormValue;

public interface IBceTagPFormSV {

	public IBceTagPFormValue getBceTagPForm(long objectId)throws Exception;
	
	public IBceTagPFormFieldValue[] getBceTagPFormField(long objectId)throws Exception;
}
