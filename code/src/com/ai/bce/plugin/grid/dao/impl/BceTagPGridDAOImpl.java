package com.ai.bce.plugin.grid.dao.impl;
import java.util.Map;
import com.ai.bce.plugin.grid.ivalues.IBceTagPGridFieldValue;
import com.ai.bce.plugin.grid.ivalues.IBceTagPGridValue;

import com.ai.bce.plugin.grid.bo.BceTagPGridEngine;
import com.ai.bce.plugin.grid.bo.BceTagPGridFieldEngine;
import com.ai.bce.plugin.grid.dao.interfaces.IBceTagPGridDAO;
public class BceTagPGridDAOImpl implements IBceTagPGridDAO { 
	
public IBceTagPGridValue getBceTagPGrid(long objectId) throws Exception{
	return BceTagPGridEngine.getBean(objectId);
}

public IBceTagPGridValue[] getBceTagPGrid(String cond,Map param) throws Exception{
	return BceTagPGridEngine.getBeans(cond,param);
}

public IBceTagPGridFieldValue[] getBceTagPGridField(String cond,Map param) throws Exception{
	return BceTagPGridFieldEngine.getBeans(cond, param);
}

} 
