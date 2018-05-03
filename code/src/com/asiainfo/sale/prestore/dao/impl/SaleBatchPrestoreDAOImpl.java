package com.asiainfo.sale.prestore.dao.impl;

import java.net.URLDecoder;
import java.rmi.RemoteException;
import java.util.HashMap;
import com.ai.appframe2.util.StringUtils;

import com.asiainfo.sale.prestore.bo.BOSaleBatchPrestoreBean;
import com.asiainfo.sale.prestore.bo.BOSaleBatchPrestoreEngine;
import com.asiainfo.sale.prestore.bo.BOSaleBatchPrestoreHisBean;
import com.asiainfo.sale.prestore.bo.BOSaleBatchPrestoreHisEngine;
import com.asiainfo.sale.prestore.bo.BOSaleBatchPrestoreListEngine;

import com.asiainfo.sale.prestore.dao.interfaces.ISaleBatchPrestoreDAO;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreHisValue;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreListValue;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreValue;
import com.ai.appframe2.common.ServiceManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SaleBatchPrestoreDAOImpl implements ISaleBatchPrestoreDAO {


	@Override
	public String saveSaleBatchPrestore(IBOSaleBatchPrestoreValue objValue) throws Exception {
		if (null != objValue){	
			if (objValue.isNew()) {
				objValue.setId(BOSaleBatchPrestoreEngine.getNewId().toString());
				objValue.setCreateTime(BOSaleBatchPrestoreEngine.getSysDate());
				objValue.setIsSubmit("1");
				objValue.setOperType("1");
				objValue.setStsToNew();
				}	
			if(objValue.isModified()){
				//IBOSaleBatchPrestoreValue tempValue = BOSaleBatchPrestoreEngine.getBean(objSaleBatchPrestoreValue.getId());
				String operType = objValue.getOperType();
				if(!operType.equals("4")){
					objValue.setOperType("2");
				}
				objValue.setModifyTime(BOSaleBatchPrestoreEngine.getSysDate());
				IBOSaleBatchPrestoreValue[] oldValues = new IBOSaleBatchPrestoreValue[] {objValue};
				this.saleBatchPrestoreToHis(oldValues);
			}
			objValue.setDoneTime(BOSaleBatchPrestoreEngine.getSysDate());
			BOSaleBatchPrestoreEngine.save(objValue);
			return objValue.getId();
		}else{
			//log.error("没有需要保存的数据");
			//ExceptionUtil.throwBusinessException("没有需要保存的数据", "IBOSaleBatchPrestoreValue"); 
			return null;
		}
	}
	
	@Override
	public IBOSaleBatchPrestoreValue getSaleMainShowById(String id)
			throws Exception {
		IBOSaleBatchPrestoreValue value = BOSaleBatchPrestoreEngine.getBean(id);
		return BOSaleBatchPrestoreEngine.getBean(id);
	}

	@Override
	public IBOSaleBatchPrestoreListValue[] queryPrestoreInfo(String applyId,
			String applyName, String principal, String regionCode,
			String beginTime, String endTime, String isSubmit, int startNum,
			int endNum) throws Exception, RemoteException {
		
		StringBuffer condition = new StringBuffer(" 1=1 ");
		condition.append(" and is_delete is null");
		HashMap paramMap = new HashMap();
		
		if (!StringUtils.isEmptyString(applyId)) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_Id).append(" = :applyId ");
			paramMap.put("applyId", applyId);
		}
		if (!StringUtils.isEmptyString(applyName)) {
			applyName = URLDecoder.decode(applyName,"utf-8");
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_ApplyName).append(" like :applyName ");
			paramMap.put("applyName", applyName + "%");
		}
		if (!StringUtils.isEmptyString(principal)) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_Principal).append(" = :principal ");
			paramMap.put("principal", principal);
		}
		if (!StringUtils.isEmptyString(regionCode)&& !regionCode.equals("0")) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_AreaCode).append(" = :regionCode ");
			paramMap.put("regionCode", regionCode);
		}

/*		if (!StringUtils.isEmptyString(beginTime) && !StringUtils.isEmptyString(endTime)){
			condition.append(" and ");
			condition.append(IBOSaleBatchPrestoreListValue.S_CreateTime).append(" between ").append("to_date(:beginTime,'yyyy-MM-dd hh24:mi:ss')").append(" and ").append("to_date(:endTime,'yyyy-MM-dd hh24:mi:ss')");
			paramMap.put("beginTime", beginTime);
			paramMap.put("endTime", endTime);
		}*/
		
		if (!StringUtils.isEmptyString(beginTime)) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_CreateTime).append(" >= to_date(:beginTime ,'yyyymmdd hh24:mi:ss') ");
			paramMap.put("beginTime", beginTime);
		}		
		if (!StringUtils.isEmptyString(endTime)) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_CreateTime).append(" <= to_date(:endTime ,'yyyymmdd hh24:mi:ss') ");
			paramMap.put("endTime", endTime);
		}
		
		if (!StringUtils.isEmptyString(isSubmit)) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_IsSubmit).append(" = :isSubmit ");
			paramMap.put("isSubmit", isSubmit);
		}
		condition.append(" order by ").append(IBOSaleBatchPrestoreListValue.S_Id).append(" desc");
		return BOSaleBatchPrestoreListEngine.getBeans(null, condition.toString(), paramMap, startNum, endNum, false);

		
		
	}

	@Override
	public int queryPrestoreInfoCount(String applyId, String applyName,String principal, String regionCode, String beginTime,
			String endTime, String isSubmit) throws Exception, RemoteException {
		
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap paramMap = new HashMap();
		
		if (!StringUtils.isEmptyString(applyId)) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_Id).append(" = :applyId ");
			paramMap.put("applyId", applyId);
		}
		if (!StringUtils.isEmptyString(applyName)) {
			applyName = URLDecoder.decode(applyName,"utf-8");
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_ApplyName).append(" like :applyName ");
			paramMap.put("applyName", applyName + "%");
		}
		if (!StringUtils.isEmptyString(principal)) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_Principal).append(" = :principal ");
			paramMap.put("principal", principal);
		}
		if (!StringUtils.isEmptyString(regionCode) && !regionCode.equals("0")) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_AreaCode).append(" = :regionCode ");
			paramMap.put("regionCode", regionCode);
		}
		
		if (!StringUtils.isEmptyString(beginTime)) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_CreateTime).append(" >= to_date(:beginTime ,'yyyymmdd hh24:mi:ss') ");
			paramMap.put("beginTime", beginTime);
		}		
		if (!StringUtils.isEmptyString(endTime)) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_CreateTime).append(" <= to_date(:endTime ,'yyyymmdd hh24:mi:ss') ");
			paramMap.put("endTime", endTime);
		}
		if (!StringUtils.isEmptyString(isSubmit)) {
			condition.append(" and ").append(IBOSaleBatchPrestoreListValue.S_IsSubmit).append(" = :isSubmit ");
			paramMap.put("isSubmit", isSubmit);
		}
		return BOSaleBatchPrestoreListEngine.getBeansCount(condition.toString(), paramMap);

	}

	@Override
	public void delSaleBatchPrestoreById(String applyId) throws Exception {
		IBOSaleBatchPrestoreValue prestoreMain = getPrestoreMainById(applyId);
		if (null != prestoreMain) {
			IBOSaleBatchPrestoreValue[] oldValues = new IBOSaleBatchPrestoreValue[] {prestoreMain};
			this.saleBatchPrestoreToHis(oldValues);
			prestoreMain.unDelete();
			prestoreMain.setIsDelete("1");
			BOSaleBatchPrestoreEngine.save(prestoreMain);
		}
		
	}
	
	public IBOSaleBatchPrestoreValue getPrestoreMainById(String id) throws Exception {
		return BOSaleBatchPrestoreEngine.getBean(id);
	}
	

	@Override
	public void saleBatchPrestoreToHis(
			IBOSaleBatchPrestoreValue[] saleBatchPrestoreValues)
			throws Exception {
		for (int i = 0; i < saleBatchPrestoreValues.length; i++) {
			IBOSaleBatchPrestoreHisValue ojbHis = new BOSaleBatchPrestoreHisBean();
			BOSaleBatchPrestoreBean obj = BOSaleBatchPrestoreEngine.getBean(saleBatchPrestoreValues[i].getId()); //删除前，先查询出来
			if (saleBatchPrestoreValues[i].isDeleted()) {
				obj.setOperType("3");  //操作类型为 3-删除
				obj.setIsDelete("1"); //增加删除标志
			}
			ojbHis.copy(obj);
			ojbHis.setStsToNew();
			ojbHis.setDoneTime(ServiceManager.getOpDateTime());  //Timestamp 操作时间
			BOSaleBatchPrestoreHisEngine.save(ojbHis);
		}		
	}

	@Override
	public void deletePrestoreInfo(
			IBOSaleBatchPrestoreValue[] saleBatchPrestoreValues)
			throws Exception {
		for (int i = 0; i < saleBatchPrestoreValues.length; i++) {
			//if (Log.isDebugEnabled()) {
			//	Log.debug(CmCustomerEmailMakeValues[i]);
			//}
			saleBatchPrestoreValues[i].unDelete();
			saleBatchPrestoreValues[i].setIsDelete("1");
			BOSaleBatchPrestoreEngine.save(saleBatchPrestoreValues[i]);
			
		}
		
	}
	
	
}
