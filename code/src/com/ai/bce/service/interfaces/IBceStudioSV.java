package com.ai.bce.service.interfaces;

import java.rmi.RemoteException;
import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.bce.ivalues.IBceAttrValue;
import com.ai.bce.ivalues.IBceButtonValue;
import com.ai.bce.ivalues.IBceFormGroupValue;
import com.ai.bce.ivalues.IBceFrameAreaFormValue;
import com.ai.bce.ivalues.IBceFrameAreaPagetabValue;
import com.ai.bce.ivalues.IBceFrameAttrValue;
import com.ai.bce.ivalues.IBceFrameButtonValue;
import com.ai.bce.ivalues.IBceFrameJavaRulesetRelValue;
import com.ai.bce.ivalues.IBceFramePageRoleValue;
import com.ai.bce.ivalues.IBceFrameSpecialPageValue;
import com.ai.bce.ivalues.IBceFrameTabitemValue;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.ivalues.IBcePageFramePageValue;
import com.ai.bce.ivalues.IBcePageFrameValue;
import com.ai.bce.ivalues.IBcePageRowsetRelValue;
import com.ai.bce.ivalues.IBcePageValue;
import com.ai.bce.ivalues.IBceRowsetValue;
import com.ai.bce.ivalues.IBceRuleValue;
import com.ai.bce.ivalues.IBceRulesetRuleValue;
import com.ai.bce.ivalues.IBceRulesetValue;
import com.ai.bce.ivalues.IBceSimpleFuncFieldMappingValue;
import com.ai.bce.ivalues.IBceSimpleFuncValue;
import com.ai.bce.ivalues.IQPageFramePageValue;

public interface IBceStudioSV {

	public IBceFrameValue[] getBceFrameValues(String cond)throws Exception;
	
	public IBcePageFrameValue[] getPageFrameValues(String cond)throws Exception;
	
	public IBcePageFramePageValue[] getBcePageFramePageValues(String cond)throws Exception;
	
	public IBcePageValue[] getBcePageValues(String cond)throws Exception;
	
	public IQPageFramePageValue[] getQPageFramePageValues(String cond)throws Exception;
	
	public IBcePageRowsetRelValue[] getPageRowsetRelValues(String cond)throws Exception;
	
	public IBceRowsetValue[] getRowsetValues(String cond)throws Exception;
	
	public IBceFramePageRoleValue[] getPageRoleValues(String cond)throws Exception;
	
	public IBceFrameSpecialPageValue[] getSpecialPageValues(String cond)throws Exception;
	
	public IBceRuleValue[] getBceRuleValues(String cond)throws Exception;
	
	public IBceRulesetValue[] getBceRulesetValues(String cond)throws Exception;
	
	public IBceRulesetRuleValue[] getBceRulesetRuleValues(String cond)throws Exception;
	
	public IBceFrameJavaRulesetRelValue[] getFrameJavaRulesetRelValues(String cond)throws Exception;
	
	public IBceSimpleFuncValue[] getSFuncValues(String cond)throws Exception;
	
	public IBceSimpleFuncFieldMappingValue[] getSFuncFMappingValues(String cond)throws Exception;
	
	public IBceButtonValue[] getBceButton()throws Exception;
	
	public IBceFrameButtonValue[] getBceFrameButton(String cond)throws Exception;
	
	public IBceFrameAreaFormValue[] getFrameAreaForm(String cond)throws Exception;
	
	public IBceFrameAttrValue[] getBceFrameAttr(String cond)throws Exception;

	public IBceFormGroupValue[] getBceFormGroup(String cond)throws Exception;
	
	public IBceAttrValue[] getBceAttr(String cond)throws Exception;
	
	public IBceFrameAreaPagetabValue[] getBceFrameAreaPagetab(String cond)throws Exception;
	
	public IBceFrameTabitemValue[] getBceFrameTabitem(String cond)throws Exception;
	
	public void commonSaveRowset(DataContainerInterface[] dcs) throws Exception;
	
	public Map getCacheMap(String key, String key2) throws Exception,RemoteException;
}
