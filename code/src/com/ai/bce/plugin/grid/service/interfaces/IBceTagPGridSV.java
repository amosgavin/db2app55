/***********************************************************************
 * Module:       IBceTagPGridSV.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Nov 17, 2010
 ***********************************************************************/

package com.ai.bce.plugin.grid.service.interfaces;

import com.ai.bce.plugin.grid.ivalues.IBceTagPGridFieldValue;
import com.ai.bce.plugin.grid.ivalues.IBceTagPGridValue;

public interface IBceTagPGridSV {

	public IBceTagPGridValue getBceTagPGrid(long objectId)throws Exception;
	
	public IBceTagPGridFieldValue[] getBceTagPGridField(long objectId)throws Exception;
}
