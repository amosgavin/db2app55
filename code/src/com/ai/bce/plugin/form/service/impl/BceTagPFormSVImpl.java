package com.ai.bce.plugin.form.service.impl;
import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.plugin.form.dao.interfaces.IBceTagPFormDAO;
import com.ai.bce.plugin.form.ivalues.IBceTagPFormFieldValue;
import com.ai.bce.plugin.form.ivalues.IBceTagPFormValue;

import com.ai.bce.plugin.form.service.interfaces.IBceTagPFormSV;
public class BceTagPFormSVImpl implements IBceTagPFormSV { 
	
	public IBceTagPFormDAO getDao(){
		return (IBceTagPFormDAO)ServiceFactory.getService(IBceTagPFormDAO.class);
	}
public IBceTagPFormValue getBceTagPForm(long objectId) throws Exception{
	return getDao().getBceTagPForm(objectId);
}

public IBceTagPFormFieldValue[] getBceTagPFormField(long objectId) throws Exception{
	String cond = IBceTagPFormFieldValue.S_ObjectId + " = :objId and "
	            + IBceTagPFormFieldValue.S_State + " = 1 "
	            + " order by " + IBceTagPFormFieldValue.S_SeqNo;
	Map param = new HashMap();
	param.put("objId",new Long(objectId));
	return getDao().getBceTagPFormField(cond, param);
}

} 
