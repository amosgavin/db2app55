/***********************************************************************
 * Module:       IBceTagPGridDAO.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Nov 17, 2010
 ***********************************************************************/

package com.ai.bce.plugin.grid.dao.interfaces;

import java.util.Map;

import com.ai.bce.plugin.grid.ivalues.IBceTagPGridFieldValue;
import com.ai.bce.plugin.grid.ivalues.IBceTagPGridValue;

public interface IBceTagPGridDAO {
	
	public IBceTagPGridValue getBceTagPGrid(long objectId)throws Exception;

	public IBceTagPGridValue[] getBceTagPGrid(String cond,Map param)throws Exception;
	
	public IBceTagPGridFieldValue[] getBceTagPGridField(String cond,Map param)throws Exception;
}
