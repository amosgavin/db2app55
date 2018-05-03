package com.ai.bce.service.impl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.complex.tab.store.HisRecordHelper;
import com.ai.appframe2.complex.util.DSNameUtil;
import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceDealReturnData;
import com.ai.bce.ivalues.IBceSimpleFuncFieldMappingValue;
import com.ai.bce.ivalues.IBceSimpleFuncValue;
import com.ai.bce.service.interfaces.IBceDealService;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.valuebean.BceDealReturnDataBean;

public class BceDealServiceImpl implements IBceDealService{
	public static transient Log log = LogFactory.getLog(BceDealServiceImpl.class);
	//private static final String[] VIRTUAL_FIELDS = {"DONE_CODE","DONE_DATE","OP_ID","ORG_ID","CREATE_DATE","VALID_DATE","EFFECTIVE_DATE","EXPIRE_DATE"};

	public IBceDealReturnData deal(IBceData bceData, long bceFrameId) throws Exception, RemoteException {
		//获取单点功能框架配置数据
		IBceSimpleFuncValue[] bfvs = BceServiceFactory.getBceFrameSV().getSFunc(bceFrameId);
		if(bfvs != null && bfvs.length > 0){
			if(log.isDebugEnabled()){
				log.debug("Save datas by simple func");
			}
			for(int i=0;i<bfvs.length;i++){
				String boName = bfvs[i].getInsBo();
				String datasource = bfvs[i].getInsDatasource();
				String rowsetName = bfvs[i].getRowsetName();
				if(log.isDebugEnabled()){
					log.debug("bo: "+boName);
					log.debug("datasource: "+datasource);
					log.debug("rowset: "+rowsetName);
				}

				//转换数据源
				int k = datasource.indexOf("{");
				if(k > 0){
					datasource = DSNameUtil.getDataSourceNameByPrefixNameInImplicit(datasource.substring(0,k));
				}
				
				//普通数据集直接保存dcs 非单点功能的rowset没有rowsetname
				if(StringUtils.isBlank(rowsetName) 
						&& StringUtils.isBlank(boName)
						&& bceData.getNormalRowsets() != null){
					if(log.isDebugEnabled()){
						log.debug("Save NormalRowsets to DataSource: " + datasource);
					}
					saveDatas(bceData.getNormalRowsets(),datasource);
					continue;
				}
				//没有配数据集时，直接根据单点功能的bo删除
				if(StringUtils.isBlank(rowsetName)
						|| bceData.getNormalRowsetInfo(rowsetName) == null
						|| bceData.getNormalRowsetInfo(rowsetName).length == 0){
					//根据主键删除数据
					if(StringUtils.isBlank(boName)){
						//没有配bo，没法处理，数据配置有误
						continue;
					}
					if(bceData.getUserDatas() == null){
						continue;
					}
					if(log.isDebugEnabled()){
						log.debug("Delete " + boName + " by keys:");
					}
					ObjectType bo = ServiceManager.getObjectTypeFactory().getInstance(boName);
					DataContainerInterface dc = new DataContainer();
					dc.setObjectType(bo);
					Set keys = bo.getKeyProperties().keySet();
					Map mapping = getFieldMappingOpp(bfvs[i].getFuncId());
					int index = 0;
					//设置主键值
					for(Iterator it = keys.iterator();it.hasNext();){
						String key = (String)it.next();
						String name = key;
						if(mapping != null && mapping.containsKey(key)){
							name = (String)mapping.get(key);
						}
						String value = bceData.getUserData(name);
						dc.set(key,value);
						if(log.isDebugEnabled()){
							log.debug("key " + (index++) + ": " +key + ", user data: " + name + ", value: " + value);
						}
					}
					dc.setStsToOld();
					//置为删除状态
					dc.delete();
					//保存
					BceServiceFactory.getBceFrameDAO().saveDatas(new DataContainerInterface[]{dc}, datasource);
					continue;
				}//end 根据主键删除数据
				
				if(log.isDebugEnabled()){
					log.debug("Save " + rowsetName + " to DataSource: " + datasource);
				}
				//保存DataContainer
				DataContainerInterface[] dcs = null;
				//单数据集
				if(rowsetName.indexOf(",")<0){
					dcs = bceData.getNormalRowsetInfo(rowsetName);
				}
				//合并数据集
				else{
					String[] rowsets = StringUtils.split(rowsetName,",");
					Object[] objs = new Object[rowsets.length];
					int index = 0;
					int max = 1;
					for(int n=0;n<rowsets.length;n++){
						DataContainerInterface[] dc = bceData.getNormalRowsetInfo(rowsets[n]);
						if(dc.length > max){
							if(max > 1){
								//合并数据集时，最多只能有一个tableRowset
								throw new BceException("BES0000417");
							}
							max = dc.length;
							index = n;
						}
						objs[n] = dc;
					}
					dcs = (DataContainerInterface[])objs[index];
					for(int n=0;n<objs.length;n++){
						if(n == index)
							continue;
						DataContainerInterface[] dc = (DataContainerInterface[])objs[n];
						for(int m=0;m<dcs.length;m++){
							dcs[m].copy(dc[0]);
						}
					}
				}
				if(StringUtils.isBlank(boName)){
					saveDatas(dcs,datasource);
				}
				else{
					//需要字段映射
					Map mapping = getFieldMapping(bfvs[i].getFuncId());
					saveDatas(dcs,mapping,
							ServiceManager.getObjectTypeFactory().getInstance(boName),datasource);
				}
			}
		}//end 配置了单点
		//直接保存各数据集数据
		else if(bceData.getNormalRowsets() != null){
			if(log.isDebugEnabled()){
				log.debug("No simple func,save NormalRowsets by default.");
			}
			saveDatas(bceData.getNormalRowsets(),null);
		}
		
		IBceDealReturnData returnData = new BceDealReturnDataBean();
		returnData.setIsSuccess("INFO");
		returnData.setSuccessMsg(LocaleResourceFactory.getResource("BES0000411"));
		//设置流程参数
		Map paramMap = new HashMap();
		paramMap.put("BCE_FRAME_ID", new Long(bceFrameId));
		paramMap.put("BCE_DATA", bceData);
		returnData.setWorkflowParamMap(paramMap);
		// 设置流程参数--结束
		return returnData;
	}
	
	private void saveDatas(Map rowsetMap,String datasourceName)throws Exception{
		Collection c = rowsetMap.values();
		for(Iterator it = c.iterator();it.hasNext();){
			DataContainerInterface[] dcs = (DataContainerInterface[])it.next();
			saveDatas(dcs,datasourceName);
		}
	}
	
	private void saveDatas(DataContainerInterface[] dcs,String datasourceName)throws Exception{
		for(int i=0;i<dcs.length;i++){
			Map keyPropertys = dcs[i].getKeyProperties();
			Set keys = keyPropertys.keySet();
			for(Iterator it = keys.iterator();it.hasNext();){
				String key = (String)it.next();
				//key为空，则取newId
				if(dcs[i].get(key) == null){
					Connection conn = null;
					if(datasourceName == null)
						conn = ServiceManager.getSession().getConnection();
					else
						conn = ServiceManager.getSession().getConnection(datasourceName);
					try{
						BigDecimal newId = ServiceManager.getIdGenerator().getNewId(conn,dcs[i].getObjectType());
						if(log.isDebugEnabled()){
							log.debug("Set key: " + key + ", value: " + newId.longValue());
						}
						dcs[i].set(key, newId);
					}
					finally{
						if(conn != null)
							conn.close();
					}
				}
			}
		}
		BceServiceFactory.getBceFrameDAO().saveDatas(dcs, datasourceName);
	}
	
	private void saveDatas(DataContainerInterface[] dcs,Map mapping,ObjectType bo,String datasourceName)throws Exception{
		DataContainerInterface[] values = new DataContainerInterface[dcs.length];
		for(int i=0;i<dcs.length;i++){
			values[i] = new DataContainer();
			values[i].setObjectType(bo);
			//获取字段
			String[] props = dcs[i].getPropertyNames();
			boolean hasKey = false;
			for(int j=0;j<props.length;j++){
				if(dcs[i].get(props[j]) == null)
					continue;
				String name = props[j];
				if(mapping != null && mapping.containsKey(props[j])){
					name = (String)mapping.get(props[j]);
				}
				//如果是主键，设置状态为old
				if(bo.isKeyProperty(name)){
					if(dcs[i].getOldObj(props[j]) != null){
						if(log.isDebugEnabled()){
							log.debug("init key: " + name + " value: " + dcs[i].getOldObj(props[j]));
						}
				    values[i].initProperty(name, dcs[i].getOldObj(props[j]));
					}
					values[i].set(name, dcs[i].get(props[j]));
					hasKey = true;
				}
				else{
					//非删除状态，bo中有此属性才设置,并且不是虚字段
					if(dcs[i].isDeleted() == false && bo.hasProperty(name) && isVirtual(name) == false){
						if(dcs[i].getOldObj(props[j]) != null){
							if(log.isDebugEnabled()){
								log.debug("init property: " + name + " value: " + dcs[i].getOldObj(props[j]));
							}
					    values[i].initProperty(name, dcs[i].getOldObj(props[j]));
						}
						if(log.isDebugEnabled()){
							log.debug("set property: " + name + " value: " + dcs[i].get(props[j]));
						}
					  values[i].set(name, dcs[i].get(props[j]));
					}
				}
			}
			//设置主键
			if(hasKey == false){
				Map keyPropertys = bo.getKeyProperties();
				Set keys = keyPropertys.keySet();
				for(Iterator it = keys.iterator();it.hasNext();){
					String key = (String)it.next();
					if(values[i].get(key) == null){
						Connection conn = null;
						if(datasourceName == null)
							conn = ServiceManager.getSession().getConnection();
						else
							conn = ServiceManager.getSession().getConnection(datasourceName);
						try{
							BigDecimal newId = ServiceManager.getIdGenerator().getNewId(conn,bo);
							if(log.isDebugEnabled()){
								log.debug("set key: " + key + ", value: " + newId.longValue());
							}
							values[i].set(key, newId);
						}
						finally{
							if(conn != null)
								conn.close();
						}
					}
				}
			}
			//判断是否是删除
			if(dcs[i].isDeleted()){
				if(log.isDebugEnabled()){
					log.debug("Set state to delete");
				}
				values[i].delete();
			}
		}
		//保存数据
		BceServiceFactory.getBceFrameDAO().saveDatas(values, datasourceName);
	}
	
	//字段映射，key为报文字段，value为实例字段
	private Map getFieldMapping(long funcId)throws Exception{
		IBceSimpleFuncFieldMappingValue[] mappingValues = BceServiceFactory.getBceFrameSV().getSFuncFieldMapping(funcId);
		Map mapping = null;
		if(mappingValues != null && mappingValues.length > 0){
			mapping = new HashMap();
			for(int k=0;k<mappingValues.length;k++){
				//{报文，实例字段}
			  mapping.put(mappingValues[k].getFieldCode(),mappingValues[k].getInsField());
			}
		}
		return mapping;
	}
	
	//字段映射，key为实例字段，value为报文字段
	private Map getFieldMappingOpp(long funcId)throws Exception{
		IBceSimpleFuncFieldMappingValue[] mappingValues = BceServiceFactory.getBceFrameSV().getSFuncFieldMapping(funcId);
		Map mapping = null;
		if(mappingValues != null && mappingValues.length > 0){
			mapping = new HashMap();
			for(int k=0;k<mappingValues.length;k++){
				//{实例字段，报文}
			  mapping.put(mappingValues[k].getInsField(),mappingValues[k].getFieldCode());
			}
		}
		return mapping;
	}
	
	private boolean isVirtual(String field){
		if(HisRecordHelper.getHisColumns().containsKey(field))
			return true;
		return false;
	}

	public IBceDealReturnData createCustomProperty(IBceData beData,
			IBceDealReturnData data) throws Exception, RemoteException {
		String[][] msg = null;
		if (data.getProcessReturnMap() != null) {
			int length= data.getProcessReturnMap().entrySet().size();
			msg  = new String[length+2][2];
			int i = 2;
			for (Iterator iterator = data.getProcessReturnMap().entrySet()
					.iterator(); iterator.hasNext();) {
				Entry entry = (Entry) iterator.next();
				if(entry.getValue() instanceof String){
					msg[i][0]=(String) entry.getKey(); 
					msg[i][1]=(String) entry.getValue();
					i++;
				}
			}
		}
		if(msg==null)msg = new String[2][2];
		msg[0][0] = "FLAG";
		msg[0][1] = data.getIsSuccess();
		msg[1][0] = "MESSAGE";
		msg[1][1] = data.getSuccessMsg();
		data.setCustomProperty(msg);
		return data;
	}

}
