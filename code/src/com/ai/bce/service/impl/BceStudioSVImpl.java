package com.ai.bce.service.impl;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.complex.cache.CacheFactory;
import com.ai.bce.auto.plugin.cache.BceServiceCache;
import com.ai.bce.bo.BceAttrEngine;
import com.ai.bce.bo.BceButtonEngine;
import com.ai.bce.bo.BceFormGroupEngine;
import com.ai.bce.bo.BceFrameAreaFormEngine;
import com.ai.bce.bo.BceFrameAreaPagetabEngine;
import com.ai.bce.bo.BceFrameAttrEngine;
import com.ai.bce.bo.BceFrameButtonEngine;
import com.ai.bce.bo.BceFrameEngine;
import com.ai.bce.bo.BceFrameJavaRulesetRelEngine;
import com.ai.bce.bo.BceFramePageRoleEngine;
import com.ai.bce.bo.BceFrameSpecialPageEngine;
import com.ai.bce.bo.BceFrameTabitemEngine;
import com.ai.bce.bo.BcePageEngine;
import com.ai.bce.bo.BcePageFrameEngine;
import com.ai.bce.bo.BcePageFramePageEngine;
import com.ai.bce.bo.BcePageRowsetRelEngine;
import com.ai.bce.bo.BceRowsetEngine;
import com.ai.bce.bo.BceRuleEngine;
import com.ai.bce.bo.BceRulesetEngine;
import com.ai.bce.bo.BceRulesetRuleEngine;
import com.ai.bce.bo.BceSimpleFuncEngine;
import com.ai.bce.bo.BceSimpleFuncFieldMappingEngine;
import com.ai.bce.bo.QPageFramePageEngine;
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
import com.ai.bce.service.interfaces.IBceStudioSV;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.util.ReflectUtils;

public class BceStudioSVImpl implements IBceStudioSV{
	public static transient final Log log = LogFactory
			.getLog(BceStudioSVImpl.class);
	public IBceFrameValue[] getBceFrameValues(String cond)throws Exception{
		return BceFrameEngine.getBeans(cond,null);
	}
	
	public IBcePageFrameValue[] getPageFrameValues(String cond)throws Exception{
		return BcePageFrameEngine.getBeans(cond,null);
	}
	
	public IBcePageFramePageValue[] getBcePageFramePageValues(String cond)throws Exception{
		return BcePageFramePageEngine.getBeans(cond,null);
	}
	
	public IBcePageValue[] getBcePageValues(String cond)throws Exception{
		return BcePageEngine.getBeans(cond,null);
	}
	
	public IQPageFramePageValue[] getQPageFramePageValues(String cond)throws Exception{
		return QPageFramePageEngine.getBeans(cond,null);
	}
	
	public IBcePageRowsetRelValue[] getPageRowsetRelValues(String cond)throws Exception{
		return BcePageRowsetRelEngine.getBeans(cond,null);
	}
	
	public IBceRowsetValue[] getRowsetValues(String cond)throws Exception{
		return BceRowsetEngine.getBeans(cond,null);
	}
	
	public IBceFramePageRoleValue[] getPageRoleValues(String cond)throws Exception{
		return BceFramePageRoleEngine.getBeans(cond,null);
	}
	
	public IBceFrameSpecialPageValue[] getSpecialPageValues(String cond)throws Exception{
		return BceFrameSpecialPageEngine.getBeans(cond,null);
	}
	
	public IBceRuleValue[] getBceRuleValues(String cond)throws Exception{
		return BceRuleEngine.getBeans(cond,null);
	}
	
	public IBceRulesetValue[] getBceRulesetValues(String cond)throws Exception{
		return BceRulesetEngine.getBeans(cond,null);
	}
	
	public IBceRulesetRuleValue[] getBceRulesetRuleValues(String cond)throws Exception{
		return BceRulesetRuleEngine.getBeans(cond,null);
	}
	
	public IBceFrameJavaRulesetRelValue[] getFrameJavaRulesetRelValues(String cond)throws Exception{
		return BceFrameJavaRulesetRelEngine.getBeans(cond,null);
	}
	
	public IBceSimpleFuncValue[] getSFuncValues(String cond)throws Exception{
		return BceSimpleFuncEngine.getBeans(cond,null);
	}
	
	public IBceSimpleFuncFieldMappingValue[] getSFuncFMappingValues(String cond)throws Exception{
		return BceSimpleFuncFieldMappingEngine.getBeans(cond,null);
	}
	
  public IBceButtonValue[] getBceButton()throws Exception{
  	return BceButtonEngine.getBeans(IBceButtonValue.S_State + " = 1 ",null);
  }
	
	public IBceFrameButtonValue[] getBceFrameButton(String cond)throws Exception{
		return BceFrameButtonEngine.getBeans(cond,null);
	}
	
	public IBceFrameAreaFormValue[] getFrameAreaForm(String cond)throws Exception{
		return BceFrameAreaFormEngine.getBeans(cond,null);
	}
	
	public IBceFrameAttrValue[] getBceFrameAttr(String cond)throws Exception{
		IBceFrameAttrValue[] values = BceFrameAttrEngine.getBeans(cond,null);
		for(int i=0;i<values.length;i++){
			if(StringUtils.isBlank(values[i].getAttrName())){
				IBceAttrValue attr = BceAttrEngine.getBean(values[i].getAttrId());
				if(attr != null)
				  values[i].setAttrName(attr.getAttrName());
			}
		}
		return values;
	}
	
	public IBceFormGroupValue[] getBceFormGroup(String cond)throws Exception{
		return BceFormGroupEngine.getBeans(cond,null);
	}
	
	public IBceAttrValue[] getBceAttr(String cond)throws Exception{
		return BceAttrEngine.getBeans(cond,null);
	}
	
  public IBceFrameAreaPagetabValue[] getBceFrameAreaPagetab(String cond)throws Exception{
  	return BceFrameAreaPagetabEngine.getBeans(cond,null);
  }
	
	public IBceFrameTabitemValue[] getBceFrameTabitem(String cond)throws Exception{
		return BceFrameTabitemEngine.getBeans(cond,null);
	}
	
	public void commonSaveRowset(DataContainerInterface[] dcs) throws Exception{
		for(int i=0;i<dcs.length;i++){
			if(dcs[i].isNew()){
//			设置主键
				Map keyPropertys = dcs[i].getKeyProperties();
				Set keys = keyPropertys.keySet();
				for(Iterator it = keys.iterator();it.hasNext();){
					String key = (String)it.next();
					//key为空，则取newId
					if(dcs[i].get(key) == null){
						
						Connection conn = null;
						try{
							conn = ServiceManager.getSession().getConnection();
							dcs[i].set(key, ServiceManager.getIdGenerator().getNewId(conn,dcs[i].getObjectType()));
						}
						finally{
							if(conn != null)
								conn.close();
						}
					}
				}
				if(dcs[i].getProperties().containsKey("STATE")){
				//设置状态
				if(dcs[i].get("STATE") == null)
				  dcs[i].set("STATE", new Integer(1));
				}
			}
			else if(dcs[i].isDeleted()){
				dcs[i].setStsToOld();
				dcs[i].set("STATE", new Integer(0));
			}
		}
		BceServiceFactory.getBceFrameDAOForConf().saveDatasForConf(dcs,null);
	}
	
	public static void main(String[] args) throws Exception {
		Map map = new HashMap();
		map.put("aa", "1");
//		map.put("bb", "2");
		IBceFrameValue frame = BceServiceFactory.getBceFrameSV().getBceFrameValue(23456,map);
		if(frame == null){
			System.out.println("wrong");
		}
		else{
			System.out.println(frame.getParamData());
		}
	}

	/* (非 Javadoc) 
	* <p>Title: getCacheMap</p> 
	* <p>Description: </p> 
	* @param type
	* @param key
	* @return
	* @throws Exception
	* @throws RemoteException 
	* @see com.ai.bce.service.interfaces.IBceStudioSV#getCacheMap(int, java.lang.String) 
	*/
	public Map getCacheMap(String key,String key2) throws Exception,
			RemoteException {
		if (log.isDebugEnabled()) {
			log.debug(LocaleResourceFactory.getResource("BES0000838"));
		}
			return (Map) CacheFactory.get(ReflectUtils.forName(key2),
			key);
	}
}
