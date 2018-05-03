package com.ai.bce.plugin.grid.service.impl;
import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.plugin.grid.dao.interfaces.IBceTagPGridDAO;
import com.ai.bce.plugin.grid.ivalues.IBceTagPGridFieldValue;
import com.ai.bce.plugin.grid.ivalues.IBceTagPGridValue;

import com.ai.bce.plugin.grid.service.interfaces.IBceTagPGridSV;
public class BceTagPGridSVImpl implements IBceTagPGridSV { 
	
	public IBceTagPGridDAO getDao(){
		return (IBceTagPGridDAO)ServiceFactory.getService(IBceTagPGridDAO.class);
	}
public IBceTagPGridValue getBceTagPGrid(long objectId) throws Exception{
	return getDao().getBceTagPGrid(objectId);
}

public IBceTagPGridFieldValue[] getBceTagPGridField(long objectId) throws Exception{
	String cond = IBceTagPGridFieldValue.S_ObjectId + " = :objId and "
	            + IBceTagPGridFieldValue.S_State + " = 1 "
	            + " order by " + IBceTagPGridFieldValue.S_SeqNo;
	Map param = new HashMap();
	param.put("objId",new Long(objectId));
	return getDao().getBceTagPGridField(cond, param);
}

} 
