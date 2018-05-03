package com.asiainfo.sale.access.dao.impl;

import com.asiainfo.charge.bo.BOChargeApplyMainEngine;
import com.asiainfo.charge.bo.BOChargeInfoEngine;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;
import com.asiainfo.sale.access.dao.interfaces.IAccessChangeDAO;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeValue;
import com.asiainfo.sale.access.bo.BOAccessChangeDetailEngine;
import com.asiainfo.sale.access.bo.BOAccessChangeEngine;
import com.asiainfo.sale.access.bo.BOAccessChangeBean;
import com.asiainfo.sale.access.bo.BOAccessChangeDetailBean;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccessChangeDAOImpl implements IAccessChangeDAO{
	
	//保存渠道修改申请主信息
	public int saveAccessChange(IBOAccessChangeValue accessChangeValue)throws Exception{
		if (accessChangeValue.isNew() || 0>=accessChangeValue.getAccessId()) {
			accessChangeValue.setAccessId(BOAccessChangeEngine.getNewId().intValue());
			Timestamp tamp = new Timestamp(System.currentTimeMillis());
			accessChangeValue.setCreateTime(tamp);
		}
		BOAccessChangeEngine.save(accessChangeValue);
		return accessChangeValue.getAccessId();
	}

	//保存渠道修改申请明细信息
	public void saveAccessChangeDetail(IBOAccessChangeDetailValue accessChangeDetailValue,int accessId)throws Exception{
		BOAccessChangeDetailBean accessChangeDetailBean = BOAccessChangeDetailEngine.transfer(accessChangeDetailValue);
		if (accessChangeDetailBean.isNew() || 0>=accessChangeDetailBean.getId()) {
			accessChangeDetailBean.setId(BOAccessChangeDetailEngine.getNewId().intValue());
			accessChangeDetailBean.setAccessId(accessId);
		}			
		BOAccessChangeDetailEngine.save(accessChangeDetailBean);
		
	}

	//保存渠道修改申请明细信息
	public void saveAccessChangeDetailBatch(IBOAccessChangeDetailValue[] accessChangeDetailValues)throws Exception{
		BOAccessChangeDetailBean[] accessChangeDetailBeans = BOAccessChangeDetailEngine.transfer(accessChangeDetailValues);
		for(int i=0 ;i<accessChangeDetailBeans.length;i++){
			if(accessChangeDetailBeans[i].isNew()){
				accessChangeDetailBeans[i].setId(BOAccessChangeDetailEngine.getNewId().intValue());
			}
		}
		BOAccessChangeDetailEngine.saveBatch(accessChangeDetailBeans);
	}
	

	//保存渠道修改申请明细信息
	public void saveAccessChangeDetail(IBOAccessChangeDetailValue[] accessChangeDetailValues,int accessId)throws Exception{
		for (int i = 0; i < accessChangeDetailValues.length; i++) {
			// 新增，需要取ID
			if (accessChangeDetailValues[i].isNew()) {
				accessChangeDetailValues[i].setId(BOAccessChangeDetailEngine.getNewId().intValue());
				accessChangeDetailValues[i].setAccessId(accessId);
			} 
			BOAccessChangeDetailEngine.save(accessChangeDetailValues[i]);
		}
		
	}
	
	//获取修改申请主信息
	public IBOAccessChangeValue getAccessChargeById(int accessid)throws Exception{
		return BOAccessChangeEngine.getBean(accessid);
	}		
	
	//获取修改申请明细信息
	public IBOAccessChangeDetailValue[] getAccessChargeDetailById(int accessid,int startNum, int endNum)throws Exception{
		String condition = IBOAccessChangeDetailValue.S_AccessId+"=:accessid";
		HashMap<String,Integer> parameter = new HashMap<String,Integer>();
		parameter.put("accessid", Integer.valueOf(accessid));
		
		return BOAccessChangeDetailEngine.getBeans(null, condition, parameter, startNum, endNum, false); 
		//BOAccessChangeDetailEngine.getBeans(condition, parameter);
	}

	//获取修改申请明细信息记录数
	public int getAccessChargeDetailCount(int accessid)throws Exception{
		String condition = IBOAccessChangeDetailValue.S_AccessId+"=:accessid";
		HashMap<String,Integer> parameter = new HashMap<String,Integer>();
		parameter.put("accessid", Integer.valueOf(accessid));
		
		return BOAccessChangeDetailEngine.getBeansCount(condition, parameter); 
	}
	
	//查询渠道修改信息
	public IBOAccessChangeValue[] queryAccessChangeValue(String beginTime,String endTime,String applyname,String objectid, String principle,String town,int startNum, int endNum)throws Exception{
		StringBuffer condition = new StringBuffer();
		HashMap<String,String> parameter = new HashMap<String,String>();
		condition.append(" 1=1 ");
		if(!beginTime.isEmpty()){
			condition.append(" AND create_time>=:beginTime ");
			parameter.put("beginTime", beginTime);
		}

		if(!endTime.isEmpty()){
			condition.append(" and create_time<=:endTime ");	
			parameter.put("endTime", endTime);
		}

		if(!applyname.isEmpty()){
			condition.append(" and APPLY_NAME like '%"+applyname.trim()+"%' ");
		}
		
		if(!objectid.isEmpty()){
			condition.append(" and ACCESS_ID ="+objectid.trim());
		}	
		if(!principle.isEmpty()){
			condition.append(" and principle ="+principle.trim());
		}			

		if(!town.isEmpty()&&town!="0"){
			condition.append(" and substr(org,1,2) ="+town.trim());
		}			

		condition.append(" order by create_time desc ");
		return BOAccessChangeEngine.getBeans(null, condition.toString(), parameter, startNum, endNum, false);
	}

	
	//查询渠道修改信息记录数
	public int queryAccessChangeCount(String beginTime,String endTime,String applyname,String objectid, String principle,String town)throws Exception{
		StringBuffer condition = new StringBuffer();
		HashMap<String,String> parameter = new HashMap<String,String>();
		condition.append(" 1=1 ");
		if(!beginTime.isEmpty()){
			condition.append(" AND create_time>=:beginTime ");
			parameter.put("beginTime", beginTime);
		}

		if(!endTime.isEmpty()){
			condition.append(" and create_time<=:endTime ");	
			parameter.put("endTime", endTime);
		}

		if(!applyname.isEmpty()){
			condition.append(" and APPLY_NAME like '%"+applyname.trim()+"%' ");
		}
		
		if(!objectid.isEmpty()){
			condition.append(" and ACCESS_ID ="+objectid.trim());
		}	
		if(!principle.isEmpty()){
			condition.append(" and principle ="+principle.trim());
		}			

		if(!town.isEmpty()&&town!="0"){
			condition.append(" and substr(org,1,2) ="+town.trim());
		}			
		return BOAccessChangeEngine.getBeansCount(condition.toString(), parameter);
	}
	
	//删除修改申请信息
	public void delAccessChangeValue(int accessid)throws Exception{
		IBOAccessChangeValue accessChangeMain = BOAccessChangeEngine.getBean(accessid);
		accessChangeMain.delete();
		BOAccessChangeEngine.save(accessChangeMain);
		StringBuffer condition = new StringBuffer();
		condition.append(" 1=1 ");
		condition.append(" and "+IBOAccessChangeDetailValue.S_AccessId+"=:accessid");
		HashMap<String,String> parameter = new HashMap<String,String>();
		parameter.put("accessid", String.valueOf(accessid));
		BOAccessChangeDetailBean[] accessChangeDetailBeans = BOAccessChangeDetailEngine.getBeans(condition.toString(), parameter);
		for(int i=0;i<accessChangeDetailBeans.length;i++){
			accessChangeDetailBeans[i].delete();
			BOAccessChangeDetailEngine.save(accessChangeDetailBeans[i]);
		}
	}
	
}
