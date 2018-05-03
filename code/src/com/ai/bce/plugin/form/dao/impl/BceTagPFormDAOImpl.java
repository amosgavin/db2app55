package com.ai.bce.plugin.form.dao.impl;
import java.util.Map;
import com.ai.bce.plugin.form.ivalues.IBceTagPFormFieldValue;
import com.ai.bce.plugin.form.ivalues.IBceTagPFormValue;

import com.ai.bce.plugin.form.bo.BceTagPFormEngine;
import com.ai.bce.plugin.form.bo.BceTagPFormFieldEngine;
import com.ai.bce.plugin.form.dao.interfaces.IBceTagPFormDAO;
public class BceTagPFormDAOImpl implements IBceTagPFormDAO { 
	
public IBceTagPFormValue getBceTagPForm(long objectId) throws Exception{
	return BceTagPFormEngine.getBean(objectId);
}

public IBceTagPFormValue[] getBceTagPForm(String cond,Map param) throws Exception{
	return BceTagPFormEngine.getBeans(cond,param);
}

public IBceTagPFormFieldValue[] getBceTagPFormField(String cond,Map param) throws Exception{
	return BceTagPFormFieldEngine.getBeans(cond, param);
}

} 
