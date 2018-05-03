package com.asiainfo.charge.dao.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.charge.bo.BOBillingCheckEngine;
import com.asiainfo.charge.bo.BOChargeApplyMainDeEngine;
import com.asiainfo.charge.bo.BOChargeApplyMainEngine;
import com.asiainfo.charge.bo.BOChargeConcessDetailInfoBean;
import com.asiainfo.charge.bo.BOChargeConcessDetailInfoEngine;
import com.asiainfo.charge.bo.BOChargeConcessInfoBean;
import com.asiainfo.charge.bo.BOChargeConcessInfoEngine;
import com.asiainfo.charge.bo.BOChargeInfoBean;
import com.asiainfo.charge.bo.BOChargeInfoEngine;
import com.asiainfo.charge.bo.BOChargeStaticSumBean;
import com.asiainfo.charge.dao.interfaces.IBillingCheckDAO;
import com.asiainfo.charge.dao.interfaces.IBusiRulesDAO;
import com.asiainfo.charge.dao.interfaces.IChargeMainDAO;
import com.asiainfo.charge.dao.interfaces.IChargeNodeDateDAO;
import com.asiainfo.charge.dao.interfaces.IChargeStaticSumDAO;
import com.asiainfo.charge.dao.interfaces.IDynamicSumDAO;
import com.asiainfo.charge.dao.interfaces.IFinaAllocRulesDAO;
import com.asiainfo.charge.dao.interfaces.IOptionalPackageDAO;
import com.asiainfo.charge.dao.interfaces.IVoiceChargeConcessDAO;
import com.asiainfo.charge.ivalues.IBOBillingCheckValue;
import com.asiainfo.charge.ivalues.IBOBusiRulesValue;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainDeValue;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeNodeDateValue;
import com.asiainfo.charge.ivalues.IBOFinaAllocRulesValue;
import com.asiainfo.charge.bo.BOChargeStaticSumEngine;
import com.asiainfo.charge.ivalues.IBODynamicSumValue;
import com.asiainfo.charge.bo.BODynamicSumEngine;
import com.asiainfo.charge.bo.BOFinaAllocRulesEngine;
import com.asiainfo.charge.bo.BOBusiRulesEngine;
import com.asiainfo.charge.bo.BOChargeNodeDateEngine;
import com.asiainfo.charge.bo.BOOptionalPackaegEngine;

public class ChargeMainDAOImpl implements IChargeMainDAO {
	private final static transient Log log = LogFactory.getLog(ChargeMainDAOImpl.class);
	//20120823资费结束状态的更改
	public void chargeStateToUse(String id)throws Exception, RuntimeException {
			IBOChargeApplyMainValue chargeMain=IChargeMainshow(id);
			 chargeMain.setIsSubmit("3");
			 //chargeMain.setStsToNew();
			 BOChargeApplyMainEngine.save(chargeMain);
	}
	//20120823资费结束状态的更改
	public void chargeStateToNoUse(String id)throws Exception, RuntimeException{
			IBOChargeApplyMainValue chargeMain=IChargeMainshow(id);
			 chargeMain.setIsSubmit("4");
			 BOChargeApplyMainEngine.save(chargeMain);
	}
	//根据主ID删除主信息
	public void delChargeMain(String id) throws Exception{
		IBOChargeApplyMainValue chargeApplyMainValue=this.IChargeMainshow(id);
		chargeApplyMainValue.delete();
		BOChargeApplyMainEngine.save(chargeApplyMainValue);
	}
	// 根据ID查询资费主信息
	public IBOChargeApplyMainValue IChargeMainshow(String id) throws Exception {
		// TODO Auto-generated method stub
		// Map parameter = new HashMap();
		// StringBuffer condition = new StringBuffer(" 1 = 1 ");
		// if(StringUtils.isNotBlank(id)){
		// condition.append(" AND " + IBOChargeApplyMainValue.S_ApplyId
		// + " = :id");
		// parameter.put("id",id);
		// }
		return BOChargeApplyMainEngine.getBean(id);
	}
	
	public void delChargeDetail(IBOChargeInfoValue[] IBOChargeInfoValue) throws Exception {
		for (int i = 0; i < IBOChargeInfoValue.length; i++) {
			IBOChargeInfoValue[i].delete();
		}
		BOChargeInfoEngine.save(IBOChargeInfoValue);
	}

	//根据主ID找到资费档次并删除
	public void delChargeDetail(String applyid) throws Exception{
		IBOChargeInfoValue[] IBOChargeInfoValue=this.getChargeDetailByFeeType(applyid,null,-1,-1);
		if(IBOChargeInfoValue.length>0){
			ChargeNodeDateDAOImpl  nodeDateDAOImpl=null;
			ChargeStaticSumDAOImpl staticSumDAOImpl=null;
			VoiceChargeConcessDAOImpl  chargeConcessDAOImpl=null;
			BillingCheckDAOImpl checkDAOImpl =null;
			DynamicSumDAOImpl  sumDAOImpl=null;
			FinaAllocRulesDAOImpl rules=null;
			BusiRulesDAOImpl busiRules=null;
			for(int i=0;i<IBOChargeInfoValue.length;i++){
 			String mid= IBOChargeInfoValue[i].getMid();
			String type=IBOChargeInfoValue[i].getChargeType();
				if(!type.equals("31")&&!type.equals("41")){
				//资费树删除
				nodeDateDAOImpl=new ChargeNodeDateDAOImpl();
				nodeDateDAOImpl.delChargeNodeDate(mid);
				}
				if(type.equals("31")||type.equals("41")){
					chargeConcessDAOImpl=new VoiceChargeConcessDAOImpl();
					chargeConcessDAOImpl.delVoiceChargeMain(mid);
				}
//				if(type.equals("41")){
//					this.delChargeConcessByMid(mid);
//				}
				//静态删除
				staticSumDAOImpl=new ChargeStaticSumDAOImpl();
				staticSumDAOImpl.delStaticSumByGrandId(mid);
				//动态删除
				sumDAOImpl= new DynamicSumDAOImpl();
				sumDAOImpl.delDynamicSumById(mid);
				//资费对比删除
				checkDAOImpl=new BillingCheckDAOImpl();
				checkDAOImpl.delBillingCheckInfo(mid, -1, -1);
				//财务分摊删除
				rules=new FinaAllocRulesDAOImpl();
				rules.delFinaAllocRules(mid);
				//业务规则删除
				busiRules=new BusiRulesDAOImpl();
				busiRules.delBusiRules(mid);
			}
			this.delChargeDetail(IBOChargeInfoValue);
		}
	}
	//根据主ID和类型查询资费档次信息
	@Override
	public IBOChargeInfoValue[] getChargeDetailByFeeType(String mainId, String feetype, int startNum, int endNum) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 and is_delete is null");
		if (StringUtils.isNotBlank(mainId)) {
			condition.append(" AND " + IBOChargeInfoValue.S_ApplyId + " = :S_ApplyId");
			parameter.put("S_ApplyId", mainId);
		}
		if (StringUtils.isNotBlank(feetype)) {
			condition.append(" AND " + IBOChargeInfoValue.S_ChargeType + " = :feetype");
			parameter.put("feetype", feetype);
		}
		return BOChargeInfoEngine.getBeans(condition.toString(), parameter);
	}

	@Override
	public int getCountByFeeType(String mainId, String feetype) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (StringUtils.isNotBlank(mainId)) {
			condition.append(" AND " + IBOChargeInfoValue.S_ApplyId + " = :mainId");
			parameter.put("mainId", mainId);
		}
		if (StringUtils.isNotBlank(feetype)) {
			condition.append(" AND " + IBOChargeInfoValue.S_ChargeType + " = :feetype");
			parameter.put("feetype", feetype);
		}
		return BOChargeInfoEngine.getBeansCount(condition.toString(), parameter);
	}
	//一对多资费根据工单ID查询资费档次
	public IBOChargeInfoValue[] getChargeDetailByNewMainid(String mainId, int startNum, int endNum)  throws Exception {
		Map parameter = new HashMap();
		String sql="select * from CHARGE_INFO_T M right join ( select APPLY_ID from HBSALE.CHARGE_APPLY_MAIN_T where main_id = :mainId ) a on M.APPLY_ID = a.APPLY_ID  ";
		parameter.put("mainId", mainId);
		return BOChargeInfoEngine.getBeansFromSql(sql, parameter);
	}
	
	public int getChargeDetailByNewMainidCount(String mainId)  throws Exception {
	
		return this.getChargeDetailByNewMainid(mainId, -1, -1).length;
	}

	@Override
	public String saveChargeMain(IBOChargeApplyMainValue chargeMainValue) throws Exception, RuntimeException {
		if (chargeMainValue != null && StringUtils.isNotBlank(chargeMainValue.getApplyName())) {
			// 新增，需要取ID
			if (chargeMainValue.isNew()) {
				chargeMainValue.setApplyId(BOChargeApplyMainEngine.getNewId().toString());
				chargeMainValue.setStsToNew();
				// saleMainValue.setSaleMainCode(getSaleMainCode(saleMainValue));
				chargeMainValue.setIsSubmit("1");
				chargeMainValue.setApplyTime(BOChargeApplyMainEngine.getSysDate());
			} else {
				IBOChargeInfoValue[] IBOChargeInfoValue=this.getChargeDetailByFeeType(chargeMainValue.getApplyId(), "", -1, -1);
				if(IBOChargeInfoValue.length>0){
					String name= chargeMainValue.getApplyName();
					for(int i=0;i<IBOChargeInfoValue.length;i++){
						String fname= IBOChargeInfoValue[i].getFeeName();
						String[] names =fname.split("_");
						fname = name + "_"+ names[1];
						IBOChargeInfoValue[i].setFeeName(fname);
						BOChargeInfoEngine.save(IBOChargeInfoValue[i]);
					}
				}
				chargeMainValue.setApplyModifyTime(BOChargeApplyMainEngine.getSysDate());
			}

			BOChargeApplyMainEngine.save(chargeMainValue);
			return chargeMainValue.getApplyId();
		}
		return null;
	}

	@Override
	public void saveChargeMain(IBOChargeApplyMainValue[] chargeMainValue) throws Exception, RuntimeException {
		BOChargeApplyMainEngine.save(chargeMainValue);
	}

	public Object[] getCondition(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname) throws UnsupportedEncodingException {

		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (StringUtils.isNotBlank(applyid)) {
			condition.append(" AND " + IBOChargeApplyMainValue.S_ApplyId + " = :applyid");
			parameter.put("applyid", applyid);
		}
		if (StringUtils.isNotBlank(feetype)) {
			condition.append(" AND " + IBOChargeApplyMainValue.S_FeeType + " = :feetype");
			parameter.put("feetype", feetype);
		}
		if (StringUtils.isNotBlank(applyTime)) {
			condition.append(" AND " + IBOChargeApplyMainValue.S_ApplyTime + " >= :applyTime");
			parameter.put("applyTime", applyTime);
		}
		if (StringUtils.isNotBlank(applyEndTime)) {
			condition.append(" AND " + IBOChargeApplyMainValue.S_ApplyTime + " <= :applyEndTime");
			parameter.put("applyEndTime", applyEndTime);
		}
		if (StringUtils.isNotBlank(principle)) {
			condition.append(" AND " + IBOChargeApplyMainValue.S_Principle + " = :principle");
			parameter.put("principle", principle);
		}
		if (StringUtils.isNotBlank(isSubmit)) {
			condition.append(" AND " + IBOChargeApplyMainValue.S_IsSubmit + " = :isSubmit");
			parameter.put("isSubmit", isSubmit);
		}
		if(StringUtils.isNotBlank(townname)&&!townname.equals("18")){
			condition.append(" AND " +  IBOChargeApplyMainValue.S_Org + " like :townname ");
			parameter.put("townname", townname+"%");
		}
		if(townname.equals("18")){
			condition.append(" AND substr(org,1,2) in  ('27' ,'28', '18')");
		}
		if(StringUtils.isNotBlank(appname)){
			condition.append(" AND " +  IBOChargeApplyMainValue.S_ApplyName + " like :appname ");
			parameter.put("appname", "%" + URLDecoder.decode(appname,"utf-8")+"%");
		}
		return new Object[] { condition.toString(), parameter };
	}

	public IBOChargeApplyMainDeValue[] ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname, int startnum,
			int endnum) throws Exception, RuntimeException {
		Object[] objects = getCondition(applyid, feetype, applyTime, applyEndTime, principle, isSubmit, townname, appname);
		String sql = (String) objects[0] + " order by " + IBOChargeApplyMainDeValue.S_ApplyTime + " desc ";
		return BOChargeApplyMainDeEngine.getBeans(null, sql, (Map) objects[1], startnum, endnum, false);
	}

	public int ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname) throws Exception, RuntimeException {
		Object[] objects = getCondition(applyid, feetype, applyTime, applyEndTime, principle, isSubmit, townname, appname);
		String sql = (String) objects[0];
		return BOChargeApplyMainDeEngine.getBeansCount(sql, (Map) objects[1]);
	}

	
	public void saveChargeConcessDetailInfo(IBOChargeConcessDetailInfoValue[] chargeConcessDetailInfoValues) throws Exception, RuntimeException {
		BOChargeConcessDetailInfoBean [] beans = BOChargeConcessDetailInfoEngine.transfer(chargeConcessDetailInfoValues);
		for(int i = 0; i < beans.length; i++){
			if (beans[i].isNew()) {
				if (0 == beans[i].getId()) {
					beans[i].setId(BOChargeConcessDetailInfoEngine.getNewId().intValue());
					beans[i].setStsToNew();
				}
			} else if (beans[i].isModified()) {
				log.debug("modify");
			} else if (beans[i].isDeleted()) {
				log.debug("Deleted");
			}
//    		if(dtlValue[i].getStaffId()==0){
//    			int staffID = BOStaffEngine.getNewId().intValue();
//    			dtlValue[i].setStaffId(staffID);
//			}
		}
		BOChargeConcessDetailInfoEngine.saveBatch(beans);
	}

	
	public int queryChargeConcessDetailInfoCount(Map<Object, String> map) throws Exception, RuntimeException {
		StringBuilder condition = new StringBuilder(" 1 = 1 ");
	    HashMap paraMap = new HashMap();
		if(!com.ai.appframe2.util.StringUtils.isEmptyString(map.get(IBOChargeConcessDetailInfoValue.S_Conssid ))){
			condition.append(" AND " + IBOChargeConcessDetailInfoValue.S_Conssid + " = :conssid");
			paraMap.put("conssid", map.get(IBOChargeConcessDetailInfoValue.S_Conssid));
		}
		int countInfo = BOChargeConcessDetailInfoEngine.getBeansCount(condition.toString(), paraMap);
		return countInfo;
	}

	
	public IBOChargeConcessDetailInfoValue[] queryChargeConcessDetailInfo(Map<Object, String> map, int start, int end) throws Exception, RuntimeException {
		 StringBuilder condition = new StringBuilder(" 1 = 1 ");
		    HashMap paraMap = new HashMap();
		    if(!com.ai.appframe2.util.StringUtils.isEmptyString(map.get(IBOChargeConcessDetailInfoValue.S_Conssid ))){
				condition.append(" AND " + IBOChargeConcessDetailInfoValue.S_Conssid + " = :conssid");
				paraMap.put("conssid", map.get(IBOChargeConcessDetailInfoValue.S_Conssid));
			}
			//IBOStaffValue[] staffInfo = BOStaffEngine.getBeans(sb.toString(),map);
			IBOChargeConcessDetailInfoValue[] value =BOChargeConcessDetailInfoEngine.getBeans(null,condition.toString(),paraMap,start,end,false);
			return value;
	}

	
	public IBOChargeConcessInfoValue[] queryChargeConcessInfo(Map<Object, String> map, int start, int end) throws Exception, RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int queryChargeConcessInfoCount(Map<Object, String> map) throws Exception, RuntimeException {
		// TODO Auto-generated method stub
		return 0;
	}

	//数据包保存
	public int saveChargeConcessInfo(IBOChargeConcessInfoValue[] chargeConcessInfoValues) throws Exception, RuntimeException {
		BOChargeConcessInfoBean [] beans = BOChargeConcessInfoEngine.transfer(chargeConcessInfoValues);
		int concessId = 0;
		for(int i = 0; i < beans.length; i++){
			if (beans[i].isNew()) {
				if (0 == beans[i].getConcessid()) {
					beans[i].setConcessid(BOChargeConcessInfoEngine.getNewId().intValue());
					beans[i].setStsToNew();
				}
			} else if (beans[i].isModified()) {
				log.debug("modify");
			} else if (beans[i].isDeleted()) {
				log.debug("Deleted");
			}
			concessId = beans[i].getConcessid();
		}
		BOChargeConcessInfoEngine.saveBatch(beans);
		return concessId;
	}

	//根据档次ID删除数据优惠
	public void delChargeConcessByMid(String mid) throws Exception, RuntimeException {
		 StringBuilder condition = new StringBuilder(" 1 = 1 ");
		    HashMap paraMap = new HashMap();
		    if(!com.ai.appframe2.util.StringUtils.isEmptyString(mid)){
				condition.append(" AND " + IBOChargeConcessInfoValue.S_Mid + " = :mid");
				paraMap.put("mid",mid);
			}
			IBOChargeConcessInfoValue[] value =BOChargeConcessInfoEngine.getBeans(condition.toString(),paraMap);
				if(value.length>0){
					for (int i = 0; i < value.length; i++) {
						value[i].delete();
					}
					BOChargeConcessInfoEngine.save(value);
			}
	}
	@Override
	public int  findChargeConcessByMid(String mid) throws Exception, RuntimeException {
		 StringBuilder condition = new StringBuilder(" 1 = 1 ");
		    HashMap paraMap = new HashMap();
		    if(!com.ai.appframe2.util.StringUtils.isEmptyString(mid)){
				condition.append(" AND " + IBOChargeConcessInfoValue.S_Mid + " = :mid");
				paraMap.put("mid",mid);
			}
			IBOChargeConcessInfoValue[] value =BOChargeConcessInfoEngine.getBeans(condition.toString(),paraMap);
			if(value.length>0){
				return value[0].getConcessid();
			}
			return 0;
	}

	@Override
	public IBOChargeConcessInfoValue[] findChargeConcessByConcessId(String concessId) throws Exception, RuntimeException {
		 StringBuilder condition = new StringBuilder(" 1 = 1 ");
		    HashMap paraMap = new HashMap();
		    if(!com.ai.appframe2.util.StringUtils.isEmptyString(concessId)){
				condition.append(" AND " + IBOChargeConcessInfoValue.S_Concessid + " = :concessId");
				paraMap.put("concessId",concessId);
			}
			IBOChargeConcessInfoValue[] value =BOChargeConcessInfoEngine.getBeans(condition.toString(),paraMap);
			return value;
	}
	
	public String cloneSaleMain (String id, String staffId, String orgId,String mainid) throws Exception, RuntimeException{
		//生成新的主信息
		 IBOChargeApplyMainValue chargeMain= IChargeMainshow(id);
		 chargeMain.setApplyId(BOChargeApplyMainEngine.getNewId().toString());
		 chargeMain.setPrinciple(staffId);
		 chargeMain.setOrg(orgId);
		 chargeMain.setIsSubmit("1");
		 chargeMain.setMainId(mainid);
		 chargeMain.setStsToNew();
		 BOChargeApplyMainEngine.save(chargeMain);
		 String mainNewId=chargeMain.getApplyId();//主ID
		 String type=chargeMain.getFeeType();
		 IBOChargeInfoValue[] chargeInfos= this.getChargeDetailByFeeType(id,chargeMain.getFeeType(),-1,-1);//档次
		 IChargeStaticSumDAO  staticSum = ((IChargeStaticSumDAO) ServiceFactory
					.getService(IChargeStaticSumDAO.class)); //静态
		 //IChargeNodeDateDAO  noteData = ((IChargeNodeDateDAO) ServiceFactory
				//	.getService(IChargeNodeDateDAO.class));		//树保存
		 IDynamicSumDAO dicSunDao = ((IDynamicSumDAO) ServiceFactory
					.getService(IDynamicSumDAO.class)); 	//语音优惠保存
		 IVoiceChargeConcessDAO vPackageDao = ((IVoiceChargeConcessDAO) ServiceFactory
					.getService(IVoiceChargeConcessDAO.class)); 			
		 //数据优惠
		 
		 //动态
		 IBillingCheckDAO check = ((IBillingCheckDAO) ServiceFactory
					.getService(IBillingCheckDAO.class));			//资费对比
		 IFinaAllocRulesDAO rule = ((IFinaAllocRulesDAO) ServiceFactory
					.getService(IFinaAllocRulesDAO.class));		//财务分摊
		 IBusiRulesDAO brule = ((IBusiRulesDAO) ServiceFactory
					.getService(IBusiRulesDAO.class));			//业务规则
		 for (IBOChargeInfoValue chargeInfo : chargeInfos) {
			 String chargeInfoId=chargeInfo.getMid();//档次ID
			 //生成新档次
			 chargeInfo.setMid(BOChargeInfoEngine.getNewId().toString());
			 chargeInfo.setApplyId(mainNewId);
			 if(chargeInfo.getCase()!=null){
			 String code= chargeInfo.getCase().substring(0, 16);
			 String codelast= this.codeRepeat(code);
			 chargeInfo.setCase(code+codelast);
			 chargeInfo.setInaddUserCount("");
			 }
			 chargeInfo.setStsToNew();
			 BOChargeInfoEngine.save(chargeInfo);
			 String mid=chargeInfo.getMid();
			 //生成新的树
			 /*if(!type.equals("31")&&!type.equals("41")){
				 IBOChargeNodeDateValue[] noteDatas=noteData.getChargeNodeDateValuesByChargeId(chargeInfoId);	
				 for(IBOChargeNodeDateValue note:noteDatas){
					 note.setChargeId(mid);
					 note.setId("1");
					 note.setStsToNew();
					 BOChargeNodeDateEngine.save(note);
				 }
			 }*/
			 if(type.equals("31")||type.equals("41")){
					IBOChargeConcessInfoValue  chargeConcessInfoValue=vPackageDao.getVoiceChargeMain(chargeInfoId);
					int vid=chargeConcessInfoValue.getConcessid();
					//复制语音优惠主信息
					int  consessid=BOChargeConcessInfoEngine.getNewId().intValue();
					chargeConcessInfoValue.setConcessid(consessid);
					chargeConcessInfoValue.setMid(Integer.parseInt(mid));
					chargeConcessInfoValue.setStsToNew();
					BOChargeConcessInfoEngine.save(chargeConcessInfoValue);
					//复制语音优惠明细信息
					IBOChargeConcessDetailInfoValue[] concessDetailInfoValues=vPackageDao.getVoiceChargeDetail(String.valueOf(vid));
					if(concessDetailInfoValues!=null){
						if(concessDetailInfoValues.length>0){
							for(IBOChargeConcessDetailInfoValue concessDetailInfoValue:concessDetailInfoValues){
								concessDetailInfoValue.setId(BOChargeConcessDetailInfoEngine.getNewId().intValue());
								concessDetailInfoValue.setConssid(consessid);
								concessDetailInfoValue.setStsToNew();
								BOChargeConcessDetailInfoEngine.save(concessDetailInfoValue);
							}
						}
					}
					
			 }
//			 if(type.equals("41")){
//				 StringBuilder condition = new StringBuilder(" 1 = 1 ");
//				    HashMap paraMap = new HashMap();
//				    if(!com.ai.appframe2.util.StringUtils.isEmptyString(chargeInfoId)){
//						condition.append(" AND " + IBOChargeConcessInfoValue.S_Mid + " = :mid");
//						paraMap.put("mid",chargeInfoId);
//					}
//					IBOChargeConcessInfoValue[] values =BOChargeConcessInfoEngine.getBeans(condition.toString(),paraMap);
//					for(IBOChargeConcessInfoValue value:values){
//						int vid=value.getConcessid();
//						value.setConcessid(BOChargeConcessInfoEngine.getNewId().intValue());
//						value.setMid(Integer.parseInt(mid));
//						value.setStsToNew();
//						BOChargeConcessInfoEngine.save(value);
//						
//					}
//			 }
			 //生成新的静态损益
			 BOChargeStaticSumBean[] staticSums= staticSum.getStaticSumValueByGrandId(chargeInfoId);
			 for( BOChargeStaticSumBean staticSumO : staticSums){
				 staticSumO.setOrderId(BOChargeStaticSumEngine.getNewId().intValue());
				 staticSumO.setGrandId(mid);
				 staticSumO.setStsToNew();
				 BOChargeStaticSumEngine.save(staticSumO);
			 }
			 //生成新的动态损益
			 IBODynamicSumValue micSum=dicSunDao.getDynamicSumById(chargeInfoId);
			 if(micSum!=null){
			 micSum.setId(BODynamicSumEngine.getNewId().toString());
			 micSum.setMid(mid);
			 micSum.setStsToNew();
			 BODynamicSumEngine.save(micSum);
			 }
			 //生成新的资费对比
			 IBOBillingCheckValue[] checkValues=check.queryBillingCheckInfo(chargeInfoId, -1, -1);
			 for(IBOBillingCheckValue checkValue:checkValues){
				 checkValue.setId(BOBillingCheckEngine.getNewId().toString());
				 checkValue.setChargeId(mid);
				 checkValue.setStsToNew();
				 BOBillingCheckEngine.save(checkValue);
			 }
			 //生成新的财务分摊
			 IBOFinaAllocRulesValue[] rules=rule.queryFinaAllocRules(chargeInfoId);
			 for(IBOFinaAllocRulesValue ruleValue:rules){
				 ruleValue.setId(BOFinaAllocRulesEngine.getNewId().toString());
				 ruleValue.setChargeId(mid);
				 ruleValue.setStsToNew();
				 BOFinaAllocRulesEngine.save(ruleValue);
			 }
			 //生成新的业务规则
			 IBOBusiRulesValue brules= brule.queryBusiRules(chargeInfoId);
			 if(StringUtils.isNotBlank(brules.getId())){
			 brules.setId(mid);
			 brules.setStsToNew();
			 BOBusiRulesEngine.save(brules);
			 }
		 }
		 return mainNewId;
	}
	@Override
	public String codeRepeat(String id) throws Exception, RuntimeException {
		String serialNo="001";
		Connection conn = ServiceManager.getSession().getConnection();
		String sql="SELECT count(serialno)  FROM ("
	   				+" SELECT SUBSTR(CASE,17,3) AS SERIALNO FROM HBSALE.CHARGE_INFO_T WHERE SUBSTR(CASE,1,16) = '"+id
					+"' UNION (SELECT SUBSTR(inadd_user_count,17,3) AS SERIALNO FROM HBSALE.CHARGE_INFO_T WHERE SUBSTR(inadd_user_count,1,16) = '"+id+"'))";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
						String sqlc="SELECT  MAX(SERIALNO) serialno FROM ("
			   				+" SELECT SUBSTR(CASE,17,3) AS SERIALNO FROM HBSALE.CHARGE_INFO_T WHERE SUBSTR(CASE,1,16) = '"+id
							+"' UNION (SELECT SUBSTR(inadd_user_count,17,3) AS SERIALNO FROM HBSALE.CHARGE_INFO_T WHERE SUBSTR(inadd_user_count,1,16) = '"+id+"'))";
							st = conn.createStatement();
							rs = st.executeQuery(sqlc);
							if (rs.next()){
							String serialNoTmp = rs.getString("serialno");
							if (null != serialNoTmp && !"".equals(serialNoTmp)) {
								if((Integer.parseInt(serialNoTmp) + 1)>=100){
									serialNo=(Integer.parseInt(serialNoTmp) + 1) + "";
								}else if((Integer.parseInt(serialNoTmp) + 1)>=10&&(Integer.parseInt(serialNoTmp) + 1)<100){
									serialNo="0"+(Integer.parseInt(serialNoTmp) + 1);
								}else{
								serialNo="00"+(Integer.parseInt(serialNoTmp) + 1);
								}
							}
							}
					}
					rs.close();
					st.close();
					conn.close();
		return serialNo;
	}
	
	public boolean haveBossId(String id)throws Exception, RuntimeException{
		if(id!=null){
		String sql="INADD_USER_COUNT='"+id+"'";
		 if(BOChargeInfoEngine.getBeans(sql,null).length>0){
			 return true;
		 }else{
			 return false;
		 }
		 }else{
			 return false;
		 }
	}
}
