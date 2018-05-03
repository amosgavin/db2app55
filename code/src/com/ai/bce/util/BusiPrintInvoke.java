package com.ai.bce.util;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.json.JsonUtil;
import com.ai.bce.auto.plugin.qr.PrintUtil;
import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.util.bean.PreDealBusiPrintBean;
import com.ai.bce.util.define.DealBusiPrint;
import com.ai.bce.util.define.PreDealBusiPrint;
import com.ai.bce.valuebean.BceDataBean;
import com.ai.common.i18n.BusinessException;
import com.ai.common.util.CenterUtil;
import com.ai.common.util.ExceptionUtil;
import com.ai.common.util.TimeUtil;
import com.ai.omframe.instance.ivalues.IInsUserValue;
import com.ai.omframe.instance.service.interfaces.IInstanceQrySV;
import com.ai.omframe.order.data.ivalues.ISoData;
import com.ai.omframe.order.data.ivalues.ISoOrderData;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.crm.common.ivalues.IBOBsParaDetailValue;
import com.asiainfo.crm.common.service.interfaces.IBaseSV;
//import com.asiainfo.crm.so.common.print.DealBusiPrintInfo;
//import com.asiainfo.crm.so.common.print.valuebean.PrintBusiData;
//import com.asiainfo.crm.so.order.base.ivalues.IBOOrdxExpireDealValue;
//import com.asiainfo.crm.so.order.rboss.bo.BOSoBusiPrintBean;
//import com.asiainfo.crm.so.order.rboss.ivalues.IBOSoBusiPrintValue;
//import com.asiainfo.crm.so.order.rboss.service.interfaces.ISoBusiPrintSV;
//import com.asiainfo.crm.so.web.PrintInfoAction;

public class BusiPrintInvoke {
	private transient static Log log = LogFactory.getLog(BusiPrintInvoke.class);
	private BusiPrintInvoke(){}
	
	public static BusiPrintInvoke _getInstance(){
		return new BusiPrintInvoke();
	}
	
	/**
	 * 合并打印 预处理接口调用 [渠道类型是营业厅的才调用下面的方法]
	 * @param bceData
	 * @param beFrameId
	 * @throws Exception
	 */
//	public PreDealBusiPrintBean printBusiDoBefore(IBceData bceData,long beFrameId) throws Exception{
//		String channelType = this.getChannelType(bceData);
//		IBceFrameValue beFrame = BceServiceFactory.getBceFrameSV().getBceFrameValue(beFrameId);
//		String dealType = String.valueOf(beFrame.getBusinessId());
//		boolean isBatchOrd = getIsBatchOrder(bceData);
//		if(beFrame.getPrintTemplateId()>0 && !StringUtils.isEmpty(channelType) && "1".equals(channelType) && !isBatchOrd){
//			String bceTamplateId = String.valueOf(beFrame.getPrintTemplateId());
//			String paramData = beFrame.getParamData();
//			IBOBsParaDetailValue bo = this.getImplClass(dealType, paramData,"PrintPreDeal");
//			PreDealBusiPrintBean obj = null;
//			if(null!=bo){
//				if(isCanDo(beFrameId, bo)){
//					String className = bo.getPara1();
//					PreDealBusiPrint preDealBusiPrint = (PreDealBusiPrint) ReflectUtils.constructorNewInstance(className, null, null);
//					
//					 obj = preDealBusiPrint.doPreDealBusiPrint(bceData);
//				}
//			}
//			return obj;
//		}
//		return null;
//	}
	
	/**
	 * [渠道类型是营业厅的才调用下面的方法]
	 * @param bceData
	 * @param beFrameId
	 * @param preDealBusiPrintBean
	 * @return
	 * @throws Exception
	 */
//	public Map printBusiInvoke(IBceData bceData,long beFrameId,PreDealBusiPrintBean preDealBusiPrintBean) throws Exception{
//		//long businessId=0;
//		long userId=0;
//		//String businessId=this.getBusinessIdByBceFrameId(beFrameId);
//		String channelType = this.getChannelType(bceData);
//		boolean isBatchOrd = getIsBatchOrder(bceData);
//		IBceFrameValue beFrame = BceServiceFactory.getBceFrameSV().getBceFrameValue(beFrameId);
//		if(beFrame.getPrintTemplateId()>0 && !StringUtils.isEmpty(channelType) && "1".equals(channelType) && !isBatchOrd){
//			String businessId = String.valueOf(beFrame.getBusinessId());
//			String paramData = beFrame.getParamData();
//			String billIdInfo =null;
//			String RegionId = null;
//			Map info = null;
//			if(bceData instanceof ISoData){
//				//billIdInfo = ((ISoOrderData)bceData).getBillId();
//				RegionId = ((ISoOrderData)bceData).getRegionId();
//			}else if(bceData instanceof BceDataBean){
//				billIdInfo = (String)(bceData.getUserData("BILL_ID"));
//			}
//			
//			if(!StringUtils.isEmpty(billIdInfo))
//			{
//				
//				CenterFactory.setCenterInfoByTypeAndValue(CenterUtil.BILL_ID,
//					billIdInfo);
//				
//			}
//			else if(!StringUtils.isEmpty(RegionId)){
//				CenterFactory.setCenterInfoByTypeAndValue(CenterUtil.REGION_ID,
//						RegionId);
//			}
//			String dealType = businessId;
//			IBOBsParaDetailValue bo = this.getImplClass(dealType, paramData,"PrintDeal");
//			if(null != bo){
//				if(isCanDo(beFrameId, bo)){
//						String className = bo.getPara1(); 
//						DealBusiPrint soBusiPrintSV = (DealBusiPrint) ReflectUtils.constructorNewInstance(className, null, null);
//
//						soBusiPrintSV.setSoBusiPrintInfo(bceData,preDealBusiPrintBean);
//						soBusiPrintSV.saveBusiPrintInfo(beFrameId);
//						info = soBusiPrintSV.getSetBusiPrintInfo();//获取各个业务设置过来的打印信息 
//				}
//						
//			}
//			return info;
//		}
//		return null;
//	}
//	
	
	private String getBusinessIdByBceFrameId(long bceFrameId) throws Exception{
		IBceFrameValue beFrame = BceServiceFactory.getBceFrameSV().getBceFrameValue(bceFrameId);
		String businessId = String.valueOf(beFrame.getBusinessId());
	
		return businessId;
	}
	
//	public static List<PreDealBusiPrintBean> getPreDealObjectFromSessionCache(String billId,String businessId) throws Exception,RemoteException{
//		List<PreDealBusiPrintBean> obj = null;
//		Map cache = (Map)BceCommonStore.getObjectFromSessionByKey("PRINT_PRE_DEAL_OBJECT");
//		if(null!=cache && !cache.isEmpty()){
//			Map preDealPrint = (Map)cache.get(billId);
//			if(null!=preDealPrint && !preDealPrint.isEmpty()){
//				obj = (List<PreDealBusiPrintBean>)preDealPrint.get(businessId);
//			}else{
//				return obj;
//			}
//		}
//		return obj;
//	}
	
	/**
	 * 清除cache
	 * @param billId
	 * @param businessId
	 * @throws Exception
	 */
	public static void clearPreDealObjectFromSessionCache(String billId,String businessId) throws Exception{
		Map cache = (Map)BceCommonStore.getObjectFromSessionByKey("PRINT_PRE_DEAL_OBJECT");
		if(null!=cache && !cache.isEmpty()){
			Map preDealPrint = (Map)cache.get(billId);
			if(null!=preDealPrint && !preDealPrint.isEmpty()){
				Object obj = (List<PreDealBusiPrintBean>)preDealPrint.get(businessId);
				if(null != obj){
					//清除该List
					preDealPrint.remove(businessId);
				}
			}
		}
	}
	
	/**
	 * 清除cache
	 * @param billId
	 * @throws Exception
	 */
	public static void clreaPreDealObjectFromSessionCacheByBillId(String billId) throws Exception{
		Map cache = (Map)BceCommonStore.getObjectFromSessionByKey("PRINT_PRE_DEAL_OBJECT");
		if(null!=cache && !cache.isEmpty()){
			Map preDealPrint = (Map)cache.get(billId);
			if(null!=preDealPrint && !preDealPrint.isEmpty()){
				cache.remove(billId);
			}
		}
	}
	
	public static IBOBsParaDetailValue getImplClass(String dealType,String paramData,String preOrAfter) throws Exception{
		IBOBsParaDetailValue bo = null;
		if(StringUtils.isEmpty(paramData)){
			 bo = BceUtil.getParaDetailValue("X", preOrAfter,
					dealType);
			 if(null!=bo) return bo;
		}
		if(!StringUtils.isEmpty(paramData)){
			 bo = BceUtil.getParaDetailValue("X", preOrAfter,
						dealType+"$"+paramData);
			 if(null!=bo){
				 return bo;
			 } 
			 else{
				 bo = BceUtil.getParaDetailValue("X", preOrAfter,
							dealType);
					 if(null!=bo) return bo;
			 }
		}
		return bo;
	}
	
	
//	public void putPrePrintBusiBeanIntoSession(PreDealBusiPrintBean obj) throws Exception{
//		//设置到缓存中处理
//		if(null!=obj){
//			//添加到bce的缓存中
//			String key_1 = obj.getBillId();
//			String key_2 = obj.getBuinessId();
//			Map cache = (Map)BceCommonStore.getObjectFromSessionByKey("PRINT_PRE_DEAL_OBJECT");
//			if(null==cache){
//				cache = new HashMap();
//				BceCommonStore.putObjectToSession("PRINT_PRE_DEAL_OBJECT", cache);
//			}
//			Map preDealPrint=(Map)cache.get(key_1);
//			if(null!=preDealPrint && !preDealPrint.isEmpty()){
//				List contentList=(List)preDealPrint.get(key_2);
//				if(null!=contentList && contentList.size()>0){
//					contentList.add(obj);
//				}else{
//					contentList = new ArrayList();
//					contentList.add(obj);
//					preDealPrint.put(key_2, contentList);
//				}
//			}else{
//				preDealPrint = new HashMap();
//				List list = new ArrayList();
//				list.add(obj);
//				preDealPrint.put(key_2, list);
//				cache.put(key_1, preDealPrint);
//			}
//			BceCommonStore.putObjectToSession("PRINT_PRE_DEAL_OBJECT", cache);
//		}
//	}
	
	
	public void putPrintDealResultInfoIntoSession(Map info) throws Exception{
		if(null != info && !info.isEmpty())
		{
			Map cache = (Map)BceCommonStore.getObjectFromSessionByKey("PRINT_INFO_MAP_BILL");
			
			//合并到缓存中
			Iterator itr = info.keySet().iterator();
			while(itr.hasNext()){
				String billId = (String)itr.next();
				if(cache != null && !cache.isEmpty())
				{
					//取当前缓存中的list
					List listInfo = (List)cache.get(billId);
					if(null != listInfo){
						//取本次业务受理进来的list
						List thisTimeList = (List)(info.get(billId));
						//合并两个list
						listInfo.addAll(thisTimeList);
					}else{
						cache.put(billId, (List)(info.get(billId)));
					}
				}else{
					cache=info;
				}
				
			}
			//设置打印信息到缓存
			BceCommonStore.putObjectToSession("PRINT_INFO_MAP_BILL", cache);
		}
	}
	
	/**
	 * 从Session中移除指定的打印数据
	 * @param billId
	 * @param pks
	 * @throws Exception
	 */
//	public void removePrintDealResultInfoFromSession(String billId,String[] pks) throws Exception{
//		Map cache = (Map)BceCommonStore.getObjectFromSessionByKey("PRINT_INFO_MAP_BILL");
//		if(null != cache && cache.size()>0){
//			List listInfo = (List)cache.get(billId);
//			if(null != listInfo && null != pks && pks.length>0){
//				Map tmpMap = new HashMap();
//				for(int i=0;i<listInfo.size();i++){
//					PrintBusiData pbd =(PrintBusiData)(listInfo.get(i));
//					String pk = String.valueOf(pbd.getPk());
//					tmpMap.put(pk, pbd);
//				}
//				listInfo.clear();
//				for(int i=0;i<pks.length;i++){
//					if(tmpMap.containsKey(pks[i])){
//						tmpMap.remove(pks[i]);
//					}
//				}
//				if(null!=tmpMap && !tmpMap.isEmpty()){
//					Iterator itr = tmpMap.keySet().iterator();
//					while(itr.hasNext()){
//						listInfo.add(tmpMap.get(String.valueOf(itr.next())));
//					}
//				}
//				//还原到cahce
//				if(!listInfo.isEmpty()){
//					cache.put(billId, listInfo);
//				}
//			}
//		}
//	}
//	
//	private String getChannelType(IBceData bceData) throws Exception{
//		String channelType = "";
//		if(bceData instanceof ISoOrderData){
//			channelType = String.valueOf(((ISoOrderData)bceData).getChannelType());
//		}else if(bceData instanceof BceDataBean){
//			channelType = bceData.getUserData("CHANNEL_TYPE");
//		}
//		return channelType;
//	}
//	
//	/**
//	 * 过滤批量受理数据 如果是批量返回true
//	 * @param bceData
//	 * @return
//	 * @throws Exception
//	 */
//	private boolean getIsBatchOrder(IBceData bceData) throws Exception{
//		boolean result = false;
//		if(bceData instanceof ISoOrderData){
//			result = ((ISoOrderData)bceData).isBatchOrder();
//		}
//		return result;
//	}
//	
	private boolean isOtherPlatUser(IBceData bceData) throws Exception{
		boolean result = false;
		
		return false;
	}
	
	/**
	 * 判断当前处理的bceFrameId是否为不需要做合并打印处理的业务
	 * @param bceFrameId
	 * @param bo
	 * @return
	 * @throws Exception
	 */
	private boolean isCanDo(long bceFrameId,IBOBsParaDetailValue bo) throws Exception{
		boolean result = true;
		String notNeedDealFrameId = bo.getPara2();
		if(!StringUtils.isEmpty(notNeedDealFrameId)){
			String[] notNeedDealFrameIdArg = notNeedDealFrameId.split("|");
			String bceFrameIdStr = String.valueOf(bceFrameId);
			for(int i=0;i<notNeedDealFrameIdArg.length;i++){
				if(!"0".equals(bceFrameIdStr) && !"".equals(bceFrameIdStr) && bceFrameIdStr.equals(notNeedDealFrameIdArg[i])){
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	
	public static boolean isInMergedTemplateIds(IBceFrameValue bceFrame) throws Exception{
		boolean isInMergedTemplate = false;
		String printTamplateId = String.valueOf(bceFrame.getPrintTemplateId());
		IBOBsParaDetailValue bo =null;
		bo = BceUtil.getParaDetailValue("X", "PrintSpecial",
		"MergedTemplateIds");
		if(null !=bo){
			String megedTemplateIdArgStr =  bo.getParaName();
			if(!StringUtils.isEmpty(megedTemplateIdArgStr)){
				String[] megedTemplateIdArg = megedTemplateIdArgStr.split(",");
				String megedTemplateId = null;
				for(int i=0;i<megedTemplateIdArg.length;i++){
					megedTemplateId = StringUtils.trim(megedTemplateIdArg[i]);
					if(!StringUtils.isEmpty(megedTemplateId)){
						if(megedTemplateId.equals(printTamplateId)){
							isInMergedTemplate=true;
							break;
						}
					}
				}
			}
		}
		return isInMergedTemplate;
	}
	
//	public static String doPrintBusiForCanncelOrd(long bceFrameId,PrintBusiData data) throws Exception{
//		StringBuffer postParam = null;
//		if(bceFrameId>0 && null!=data){
//			long custOrdId = data.getCustomerOrdId();
//			if(custOrdId<=0){
//				//客户订单必须大于0
//				ExceptionUtil.throwBusinessException("");
//				return null;
//			}
//			String regionId = data.getRegionId();
//			if(StringUtils.isEmpty(regionId)){
//				//RegionId不能为空
//				ExceptionUtil.throwBusinessException("");
//				return null;
//			}
//			String printType = data.getPrintType();
//			if(StringUtils.isEmpty(printType)){
//				//打印类型不能为空
//				ExceptionUtil.throwBusinessException("");
//				return null;
//			}
//			Map printInfoData = data.getPrintInfoData();
//			if(null== printInfoData || printInfoData.isEmpty()){
//				//打印具体明细[printInfoData]不能为空
//				ExceptionUtil.throwBusinessException("");
//				return null;
//			}
//			Map printInfoIdData = data.getPrintInfoIdData();
//			if(null==printInfoData ){
//				log.debug("警告:特殊信息为空");
//			}
//			ISoBusiPrintSV soBusiPrintSV = (ISoBusiPrintSV)ServiceFactory.getCrossCenterService(ISoBusiPrintSV.class);
//			soBusiPrintSV.savePrintBusiDataAsSoBusiPrintValue(bceFrameId, data,data.getRegionId());
//			String dbRegionId = data.getRegionId();
//			String infoNo = String.valueOf(data.getPk());
//			postParam.append("keyOfDBArray=").append(infoNo);
//			postParam.append("&");
//			postParam.append("regionIdArray=").append(dbRegionId);
//		}
//		if(null!=postParam){
//			return postParam.toString();
//		}
//		return null;
//	}
//	
	
}
