package com.asiainfo.charge.dao.impl;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.charge.bo.BOChargeApplyMainEngine;
import com.asiainfo.charge.bo.BOChargeMainEngine;
import com.asiainfo.charge.dao.interfaces.IChargeNewMainDAO;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainValue;
import com.asiainfo.charge.ivalues.IBOChargeMainValue;

public class ChargeNewMainDAOImpl implements IChargeNewMainDAO{
	private final static transient Log log = LogFactory.getLog(ChargeMainDAOImpl.class);
	//20130528资费结束状态的更改
	public void chargeStateToUse(String id)throws Exception, RuntimeException {
		IBOChargeMainValue chargeMain=IChargeMainshow(id);
			 chargeMain.setState("3");
			 chargeMain.unDelete();
			 //chargeMain.setStsToNew();
			 BOChargeMainEngine.save(chargeMain);
	}
	//20130528资费结束状态的更改
	public void chargeStateToNoUse(String id)throws Exception, RuntimeException{
		IBOChargeMainValue chargeMain=IChargeMainshow(id);
			 chargeMain.setState("4");
			 chargeMain.unDelete();
			 BOChargeMainEngine.save(chargeMain);
	}
	
	public IBOChargeMainValue IChargeMainshow(String id) throws Exception {
		return BOChargeMainEngine.getBean(id);
	}
	
	public String saveChargeNewMain(IBOChargeMainValue chargeNewMainValue)  throws Exception, RuntimeException{
		if(chargeNewMainValue.isNew()){
			chargeNewMainValue.setMainId(BOChargeMainEngine.getNewId().toString());
			chargeNewMainValue.setState("1");
			chargeNewMainValue.setCreateTime(BOChargeMainEngine.getSysDate());
		}else{
			chargeNewMainValue.setModifyTime(BOChargeMainEngine.getSysDate());
		}
		 BOChargeMainEngine.save(chargeNewMainValue);
		return chargeNewMainValue.getMainId();
	}
	
	
	public IBOChargeApplyMainValue[] getApplyMainsByMainId(String mainid) throws Exception, RuntimeException{
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if(StringUtils.isNotBlank(mainid)){
			condition.append(" AND "+IBOChargeApplyMainValue.S_MainId+" = :mainid");
			parameter.put("mainid", mainid);
		}
		return BOChargeApplyMainEngine.getBeans(condition.toString(), parameter);
	}
	@Override
	public IBOChargeMainValue[] IChargeNewMainByMessage(String id,
			String applyTime, String applyEndTime, String principle,
			String isSubmit, String townname, String appname,
			int $startrowindex, int $endrowindex) throws Exception {
		Object[] objects =getCondition(id,applyTime,applyEndTime,principle,isSubmit,townname,appname);
		String sql=(String) objects[0] +" order by " + IBOChargeMainValue.S_CreateTime+" desc ";
		return BOChargeMainEngine.getBeans(null,sql, (Map) objects[1],$startrowindex,$endrowindex,false);
	}
	@Override
	public int IChargeNewMainByMessageCount(String id,
			String applyTime, String applyEndTime, String principle,
			String isSubmit, String townname, String appname) throws Exception {
		Object[] objects =getCondition(id,applyTime,applyEndTime,principle,isSubmit,townname,appname);
		String sql=(String) objects[0];
		return BOChargeMainEngine.getBeansCount(sql, (Map) objects[1]);
	}
	
	public  Object[] getCondition(String id,
			String applyTime, String applyEndTime, String principle,
			String isSubmit, String townname, String appname) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 and is_delete is null");
		if (StringUtils.isNotBlank(id)) {
			condition.append(" AND " + IBOChargeMainValue.S_MainId + " = :mainid");
			parameter.put("mainid", id);
		}
		if (StringUtils.isNotBlank(principle)) {
			condition.append(" AND " + IBOChargeMainValue.S_Principle + " = :principle");
			parameter.put("principle", principle);
		}
		if (StringUtils.isNotBlank(isSubmit)) {
			condition.append(" AND " + IBOChargeMainValue.S_State + " = :isSubmit");
			parameter.put("isSubmit", isSubmit);
		}
		if (StringUtils.isNotBlank(appname)) {
			condition.append(" AND " + IBOChargeMainValue.S_Reamrk1 + " like :appname ");
			parameter.put("appname", "%" + URLDecoder.decode(appname,"utf-8")+"%");
		}
		if (StringUtils.isNotBlank(applyTime)) {
			condition.append(" AND " + IBOChargeMainValue.S_CreateTime + " >= :applyTime");
			parameter.put("applyTime", applyTime);
		}
		if (StringUtils.isNotBlank(applyEndTime)) {
			condition.append(" AND " + IBOChargeMainValue.S_CreateTime + " <= :applyEndTime");
			parameter.put("applyEndTime", applyEndTime);
		}
		if(StringUtils.isNotBlank(townname)&&!townname.equals("18")){
			condition.append(" AND " +  IBOChargeMainValue.S_Org + " like :townname ");
			parameter.put("townname", townname+"%");
		}
		if(townname.equals("18")){
			condition.append(" AND substr(org,1,2) in  ('27' ,'28', '18')");
		}
		return new Object[] { condition.toString(), parameter };
	}
	@Override
	public void delChargeMain(String id) throws Exception, RuntimeException {
		IBOChargeMainValue chargeMainValue=this.IChargeMainshow(id);
		chargeMainValue.unDelete();
		chargeMainValue.setIsDelete("1");
		BOChargeMainEngine.save(chargeMainValue);
	}
}
