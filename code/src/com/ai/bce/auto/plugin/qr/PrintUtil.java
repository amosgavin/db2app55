/**   
 * @Title: PrintUtil.java 
 * @Package com.ai.bce.auto.plugin.qr 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Qinjin Peng (Pengqj@asiainfo-linkage.com)   
 * @date 2011-4-3 上午10:59:10 
 * @version V1.0   
 */
package com.ai.bce.auto.plugin.qr;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.BusinessException;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.appframe2.privilege.UserInfoInterface;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.json.JsonUtil;
import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.ivalues.IBceQrAttrValue;
import com.ai.bce.ivalues.IBceQrTemplateValue;
import com.ai.bce.ivalues.IBceWarnValue;
import com.ai.bce.util.BceCommonStore;
import com.ai.bce.util.BceConfigServer;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceSVUtil;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;
import com.ai.bce.util.BusiPrintInvoke;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.util.ReflectUtils;
import com.ai.bce.valuebean.BceDataBean;
import com.ai.common.util.CenterUtil;
import com.ai.common.util.ExceptionUtil;
import com.ai.common.util.TimeUtil;
import com.ai.omframe.instance.ivalues.IInsUserValue;
import com.ai.omframe.order.data.ivalues.ISoOrderData;
import com.ai.omframe.order.service.interfaces.IOrderQrySV;
import com.ai.omframe.util.InsServiceFactory;
import com.ai.omframe.util.OMFrameException;
import com.ai.omframe.util.SoDataFactory;
import com.ai.omframe.util.SoServiceFactory;
import com.asiainfo.crm.common.ivalues.IBOBsParaDetailValue;
import com.asiainfo.crm.customer.teaminvoke.out.ivalues.ICmCustomerValue;
//import com.asiainfo.crm.so.common.print.AbstractGetPrintTamplateValue;
//import com.asiainfo.crm.so.common.print.PrintConst;
//import com.asiainfo.crm.so.common.print.valuebean.PrintBusiData;
import com.asiainfo.crm.so.instance.rboss.ivalues.IBOSoBusiPrintInfoValue;
import com.asiainfo.crm.so.instance.rboss.service.interfaces.ISoBusiPrintInfoSV;
//import com.asiainfo.crm.so.order.rboss.ivalues.IBOSoBusiPrintValue;
//import com.asiainfo.crm.so.order.rboss.service.interfaces.ISoBusiPrintSV;
import com.asiainfo.crm.so.teaminvoke.in.service.interfaces.ICust2CrmSV;
import com.ai.secframe.common.Constants;


/**
 * @ClassName: PrintUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Qinjin Peng
 * @date 2011-4-3 上午10:59:10
 * 
 */

public class PrintUtil {
	public static transient final Log log = LogFactory.getLog(PrintUtil.class);

	/**
	 * @param bceData2
	 *            获取打印Map
	 * 
	 * @Title: print
	 * @Description: TODO
	 * @param @param bceFrameid
	 * @param @param customOrderId
	 * @param @return
	 * @param @throws Exception
	 * @return Map
	 * @throws
	 */
	public static Map print(long bceFrameid, String customOrderId,
			IBceData bceData2) throws Exception {
		Map contentMap = new HashMap();
//		if (bceData2 == null)
//			BceException
//					.throwException("bceData2 is null! pealse recommited ! ");
		return contentMap;
	}

	/**
	 * @Title: removeBceData
	 * @Description: TODO
	 * @param @param customOrderId
	 * @return void
	 * @throws
	 */
	private static void removeBceData() {
		// TODO Auto-generated method stub
		// BceCommonStore.removeObjectFromStore(String.valueOf(customOrderId));
	}

	/**
	 * @throws BceException
	 *             获取BceData
	 * 
	 * @Title: getIBceBceData
	 * @Description: TODO
	 * @param @param customiD
	 * @param @return
	 * @return IBceData
	 * @throws
	 */
	public static IBceData getIBceBceData() throws BceException {
		return (IBceData) BceCommonStore
				.getObjectFromSessionByKey(BceUtil.BCE_COSTOMER_ORDER_CACHE_KEY);
	}

	/**
	 * 设置BceData至缓存
	 * 
	 * @Title: putBceData
	 * @Description: TODO
	 * @param @param customId
	 * @param @param bceData
	 * @return void
	 * @throws
	 */
	public static void putBceData(long customId, IBceData bceData) {
		BceCommonStore.putObjectToStore(String.valueOf(customId), bceData);
	}

	public static void putCustomOrderId(long customOrderId) {
		BceCommonStore.putSomeThingToThread("CUSTOM_ORDER_ID",
				Long.valueOf(customOrderId));
	}

	public static long getCustomOrderId() {
		String custom_order_id = String.valueOf(BceCommonStore
				.getSomeThingFromThread("CUSTOM_ORDER_ID"));
		long custom_id = -1;
		if (StringUtils.isNumeric(custom_order_id)) {
			custom_id = Long.valueOf(String.valueOf(BceCommonStore
					.getSomeThingFromThread("CUSTOM_ORDER_ID")));
		}
		return custom_id;
	}

	public static String getPrintContent(long bceFrameId, String orderId,String commPara)
			throws Exception {
		String regionId = (String) SessionManager.getUser().get(
				BceSVUtil.REGION_ID);
		if (StringUtils.isNotBlank(regionId)
				&& !CenterFactory.isSetCenterInfo()) {
			CenterFactory.setCenterInfoByTypeAndValue("RegionId", regionId);
		}
		IBceQrTemplateValue templateValue = BceServiceFactory.getBceFrameSV()
				.getTemplateValueByframeId(bceFrameId);
		IBceQrAttrValue[] attrs = BceServiceFactory.getBceFrameSV()
				.getQrTempAttrs(0, null, templateValue.getTemplateId(), true);
		StringBuffer script = new StringBuffer();
		IBceData bceData = getIBceBceData();
		PrintUtil.removeBceData();
		Map localMap = print(bceFrameId, orderId, bceData);
		HashMap paramMap = new HashMap();
		for (int i = 0; attrs != null && i < attrs.length; i++) {
			IBceQrAttrValue attrValue = attrs[ i];
			/**
			 * 子属性
			 */
			StringBuffer buffer = new StringBuffer();
			String key = attrValue.getAttrName();
			/**
			 * 判断key是否为记录业务信息：eg：全球通xxx套餐资费XX元
			 */
			Object value = "";
			if (StringUtils.isBlank(attrValue.getBceGetRule()))
				value = localMap.get(key);
			else {
				HashMap map = new HashMap(); 
				map.put("BCEDATA", bceData);
				map.put("ATTR", attrValue);
				map.put("COUSTOM_ORDER_ID", String.valueOf(orderId));
				map.put("VERIFY_NAME",
						SessionManager.getUser().get("VERIFY_NAME"));
				/**
				 * 修改：for合并打印  传入billId 给后面的数据 让其根据billId查询公用的打印信息
				 */
				if(bceData == null){
					map.put("COMM_PARA", commPara);
				}else{
					map.put("BILL_ID", getBillIdFromBceData(bceData));
				}
				
				value = BceUtil.evalExpr(attrValue.getBceGetRule(), map);
			}
			String keyValue = "";
			if (Map.class.isInstance(value)) {
				IBceQrAttrValue[] childAttr = BceServiceFactory.getBceFrameSV()
						.getQrTempAttrs(attrValue.getAttrId(), key,
								templateValue.getTemplateId(), false);
				Map lSetMap = (Map) value;
				for (int j = 0; j < childAttr.length; i++) {
					IBceQrAttrValue qrAttrValue = childAttr[j];
					Object object = lSetMap.get(qrAttrValue.getAttrName());
					String rst = getDisVlaue(j, qrAttrValue, object);
					buffer.append(rst);
				}
			} else if (List.class.isInstance(value)) {
				List li = (List) value;
				for (int j = 0; j < li.size(); j++) {
					Object object = li.get(j);
					String rst = getDisVlaue(j, attrValue, object);
					buffer.append(rst);
				}
			} else {
				keyValue = getDisVlaue(0, attrValue, value);
			}
			if (StringUtils.isBlank(keyValue)) {
				keyValue = buffer.toString();
			}
			keyValue = StringUtils.replace(keyValue, "\r", "\\r");
			keyValue = StringUtils.replace(keyValue, "\n", "\\n");
			paramMap.put(key, keyValue);
			String keyB = StringUtils.replace(keyValue, "\"", "\\\"");
			script.append("EtCell.SetAliasCell(\"" + key + "\",\"" + keyB
					+ "\");");
			//keyValue = StringUtils.replace(keyValue, "\"", "\\\"");
		}
		script.append("\n");
		String json = JsonUtil.getJsonFromMap(paramMap);
		//json = StringUtils.replace(json, "\"", "\\\"");
		script.append("returnMsg = '" + json + "';");
		return script.toString();
	}

	/**
	 * @throws Exception 
	 * @Title: getDisVlaue
	 * @Description: TODO
	 * @param @param i
	 * @param @param attrValue
	 * @param @param object
	 * @param @return
	 * @return String
	 * @throws
	 */
	private static String getDisVlaue(int i, IBceQrAttrValue attrValue,
			Object object) throws Exception {
		String rst = attrValue.getTempString();
		String paramRe = attrValue.getParamRe();
		if (StringUtils.isBlank(paramRe)) {
			rst = "${STR}";
			paramRe = "${STR}";
		}
		String[] params = StringUtils.split(paramRe);
		if (paramRe.indexOf("${STR}") < 0) {
			// 采取对象模式 ${.KEY}
			for (int k = 0; k < params.length; k++) {
				String param = params[k];
				String keyMethod = getGetMethodName(param);
				Object objecy = ReflectUtils.methodInvoke(object.getClass()
						.getName(), keyMethod, new Class[] {}, new Object[] {},
						object);
				rst = StringUtils.replace(rst, param, String.valueOf(objecy));
			}
		}
		if (String.class.isInstance(object)) {
			for (int k = 0; params != null && k < params.length; k++) {
				if (StringUtils.equals(params[k], "${STR}")) {
					rst = StringUtils.replace(rst, "${STR}", object.toString());
				}
				if (StringUtils.equals(params[k], "${LINE}"))
					rst = StringUtils.replace(rst, "${LINE}",
							String.valueOf(i + ":"));
			}
		}
		
		if(StringUtils.equals(rst,"${STR}")){
			rst= "";
		}
		return rst;
	}

	/**
	 * @Title: getGetMethodName
	 * @Description: TODO
	 * @param @param key
	 * @param @return
	 * @return String
	 * @throws
	 */
	private static String getGetMethodName(String key) {
		String keyMethod = "";
		int indexOf = key.indexOf(".");
		if (indexOf + 1 <= key.length() - 1) {
			String key_1 = key.substring(indexOf + 1, key.length() - 1);
			key_1 = key_1.substring(0, 1);
			keyMethod = "get" + key_1.toUpperCase() + key.substring(1);
		}
		return keyMethod;
	}

	public static String getWarnContent(long bceFrameId, String businessId,
			String changeName, String changeValue) throws Exception {

		IBceWarnValue bceWarnValue = BceServiceFactory.getBceFrameSV()
				.getWarnContent(bceFrameId, businessId, changeName,
						changeValue, 1);

		return bceWarnValue == null ? "" : bceWarnValue.getWarnContent();
	}

	public static Object getDefaultValueByMethodName(String methodName,
			IBceData bceData) throws Exception {
		return getMethod(methodName, bceData);
	}

	private static Object getMethod(String methodName, Object srcObject)
			throws Exception {
		Object object = srcObject;
		if (methodName.startsWith("{[")) {
			String[] allValue = StringUtils.splitByWholeSeparator(
					methodName.substring(2, methodName.length() - 2), "].[");
			Map objMap = new HashMap();
			for (int i = 0; i < allValue.length; i++) {
				String[] params = StringUtils.splitByWholeSeparator(
						allValue[i], ",");
				if (params.length != 2)
					ExceptionUtil.throwBusinessException("BES0000831",
							allValue[i]);
				String key = params[0].substring(1, params[0].length() - 1);
				objMap.put(key, getMethod(params[1], object));
			}
			object = objMap;
			return object;
		}
		// 执行方法体
		if (methodName.startsWith("{")) {
			String[] methods = StringUtils.split(
					methodName.substring(1, methodName.length() - 1), ".");
			if (methods.length < 2)
				ExceptionUtil.throwBusinessException("BES0000824", methodName);
			if (!"BCE".equals(methods[0])) {
				String className = methods[0];
				className = StringUtils.replace(className, "_", ".");
				object = ReflectUtils.methodInvoke(className, methods[1],
						new Class[] { IBceData.class },
						new Object[] { srcObject }, object);
				return object;
			}
			for (int i = 1; i < methods.length; i++) {
				// System.out.println(methods[i]);
				String length = "";
				String[] methodAme = StringUtils.split(methods[i], "[]{}<>()'");
				String methodname = methodAme[0];
				List cles = new ArrayList();
				List objs = new ArrayList();
				for (int k = 1; k < methodAme.length; k++) {
					String[] keyV = StringUtils.split(methodAme[k], '|');
					if (keyV.length == 1) {
						length = methodAme[k];
						break;
					}

					cles.add(getClass(keyV[0]));
					objs.add(keyV[1]);
				}
				object = ReflectUtils.methodInvoke(object.getClass().getName(),
						methodname, (Class[]) cles.toArray(new Class[0]),
						objs.toArray(new Object[0]), object);
				if (methods[i].endsWith("]")) {
					if (!object.getClass().isArray())
						ExceptionUtil.throwBusinessException("BES0000826",
								methods[i]);
					int i_length = Integer.valueOf(length).intValue();
					if (i_length >= Array.getLength(object))
						ExceptionUtil.throwBusinessException("BES0000827",
								methods[i]);
					object = Array.get(object, i_length);
				}
				if (methods[i].endsWith(">")) {
					if (!List.class.isInstance(object))
						ExceptionUtil.throwBusinessException("BES0000828",
								methods[i]);
					List obj = (List) object;
					int i_length = Integer.valueOf(length).intValue();
					if (i_length >= obj.size())
						ExceptionUtil.throwBusinessException("BES0000829",
								methods[i]);
					object = obj.get(i_length);
				}
				if (methods[i].endsWith("}")) {
					if (!Map.class.isInstance(object))
						ExceptionUtil.throwBusinessException("BES0000830",
								methods[i]);
					Map obj = (Map) object;
					object = obj.get(length);
				}

			}
		}
		return object;
	}

	public static void main(String[] args) throws Exception {

		System.out
				.println(getNewId("com.ai.omframe.order.service.impl.OrderSaveHelperSVImpl"));
	}

	/**
	 * @Title: getClass
	 * @Description: TODO
	 * @param @param string
	 * @param @return
	 * @return Class
	 * @throws
	 */
	private static Class getClass(String string) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("STRING", String.class);
		return (Class) map.get(string);
	}

	/**
	 * 获取当前业务的订单ID
	 * 
	 * @throws Exception
	 * @Title: getNewId
	 * @Description: TODO
	 * @param @return
	 * @return long
	 * @throws
	 */
	public static Object getNewId(String dealSeviceName) throws Exception {
		// TODO Auto-generated method stub
		Map commonMap = (Map) BceConfigServer
				.getRegisterConfig("print_getId_plugin");
		if (commonMap == null) {
			if (log.isWarnEnabled()) {
				log.warn(LocaleResourceFactory.getResource("BES0000835"));
			}
			return "";
		}
		Map keyV = (Map) commonMap.get("orderIdGenMap");
		String value = (String) keyV.get(dealSeviceName);
		if (StringUtils.isBlank(value))
			return "";
		String[] clM = StringUtils.split(value, "()");
		String clazz = clM[0];
		Object id = null;
		for (int i = 1; i < clM.length; i++) {
			if (i != 1)
				clazz = id.getClass().getName();

			id = ReflectUtils.methodInvoke(clazz, clM[i], null, null, id);
		}
		return id;
	}

	/**
	 * 获取已经生成的客户订单编号
	 * 
	 * @return
	 */
	public static String getCustomOrderCode() {
		return String.valueOf(BceCommonStore
				.getSomeThingFromThread("CUSTOM_ORDER_CODE"));
	}

	public static void putCustomOrderCode(String customOrderCode) {
		BceCommonStore.putSomeThingToThread("CUSTOM_ORDER_CODE",
				customOrderCode);
	}

	/**
	 * 封装该方法使其兼容从Session里面去取打印信息 以及从db里面去取打印信息组装成map
	 * 然后交给下游的方法进行判断是发送平台还是本地打印 
	 * @return map 
	 * @throws Exception
	 */
//	public static String getPrintContentMap(String dbRegionId,String[] dbIdArray,String[] sessionIdArray,String billId) throws Exception{
//		List<PrintBusiData> commList = new ArrayList();//用来存放合并后的打印信息
//		StringBuilder scirpt = new StringBuilder("");
//		if(null != dbIdArray && dbIdArray.length>0){
//			//从数据库中获取打印信息
//			//根据info_no获取要打印的数据
//			ISoBusiPrintSV soBusiPrintSV =(ISoBusiPrintSV)getServiceExtInWebLayer(ISoBusiPrintSV.class,dbRegionId);
//			//ISoBusiPrintSV soBusiPrintSV =(ISoBusiPrintSV)ServiceFactory.getService(ISoBusiPrintSV.class);
//			/*
//			UserInfoInterface user = SessionManager.getUser();
//			String opUserRegionId = String.valueOf(user.get("REGION_ID"));
//			ISoBusiPrintSV soBusiPrintSV =null;
//			if(!opUserRegionId.equals(dbRegionId)){
//				soBusiPrintSV = (ISoBusiPrintSV)ServiceFactory.getCrossCenterService(ISoBusiPrintSV.class);
//			}else{
//				soBusiPrintSV = (ISoBusiPrintSV)ServiceFactory.getService(ISoBusiPrintSV.class);
//			}*/
//			IBOSoBusiPrintValue[] ivaluesOfDB = soBusiPrintSV.getBusiPrintByInfoNoArray(dbIdArray, dbRegionId,billId);
//			if(null != ivaluesOfDB && ivaluesOfDB.length>0){
//				//调用方法将IBOSoBusiPrintValue 转化为PrintBusiData 然后放在commList中
//				commList=convertToPrintBusiData(commList,ivaluesOfDB);
//			}
//		}
//		if(null != sessionIdArray && sessionIdArray.length>0){
//			//从缓存中获取本次要打印的数据
//			commList = selectedOfSessionData(commList, sessionIdArray, billId);
//		}
//		if(commList.size()>0){
//			//调用方法将commList中的数据转化为要分发出去的Map
//			Map map = convertListToBusiPrintMap(commList);
//			if(null != map && !map.isEmpty()){
//				Iterator itr = map.keySet().iterator();
//				while(itr.hasNext()){
//					String key = (String)itr.next();
//					String keyValue = StringUtils.replace(String.valueOf(map.get(key)), "\n", "\\n");
//					keyValue = StringUtils.replace(keyValue, "\r", "\\r");
//					String keyB = StringUtils.replace(keyValue, "\"", "\\\"");
//					scirpt.append("EtCell.SetAliasCell(\"" + key + "\",\"" + keyB
//							+ "\");");
//				}
//				scirpt.append("\n");
//				String json = JsonUtil.getJsonFromMap(map);
//				json = json.replace("\'", "");
//				scirpt.append("returnMsg = '" + json + "';");
//			}
//		}
//		//清除缓存变量移动到PrintInfoAction中去做
//		return scirpt.toString();
//	}
	
//	private static Map convertListToBusiPrintMap(List<PrintBusiData> commList) throws Exception{
//		Map map = null;
//		if(null != commList && !commList.isEmpty()){
//			map = new HashMap();
//			//获取数据
//			//add by qiangao:第一次从printBusiData中获取数据 减少数据库查询，条件是各个业务在做的时候要数据放到PrintBusiData的PrintInfoData字段
//			for(int i=0;i<commList.size();i++){
//				map=getAttrValByList(commList.get(i), map);
//			}
//			//第二次再把获取不到的数据通过反射方式去获取调用查询数据的一系列方法
//			//隔离开bce和项目代码
//			//modify by qiangao for 优化逻辑连带修改（整合普通打印模板和宽带打印模板）
//			IBceQrAttrValue[] attrs = getAttrsByPrintBusiData(commList.get(0));
//			for(int i=0;i<commList.size();i++){
//				reflectInfo(commList.get(i),map,attrs);
//			}
//			map = getCommInfo(commList, map);
//		}
////		String ordRemarks = (String)map.get("ORD_REMARKS");
////		if(!StringUtils.isEmpty(ordRemarks)){
////			ordRemarks=ordRemarks;
////			map.put("ORD_REMARKS", ordRemarks);
////		}
//		String busiList = (String)map.get("BUSI_NAME_LIST");
//		if(!StringUtils.isEmpty(busiList)){
//			busiList="您办理了业务："+busiList;
//			map.put("BUSI_NAME_LIST", busiList);
//		}
//		return map;
//	}
	
//	private static Object reflectInfo(PrintBusiData printBusiData,Map map,IBceQrAttrValue[] attrs) throws Exception{
//		String businessId = printBusiData.getBusinessId();
//		String billId = printBusiData.getBillId();
//		long orderId = printBusiData.getCustomerOrdId();
//		Map printInfoDataMap =(Map)printBusiData.getPrintInfoData();
//		Map printInfoIdMap = printBusiData.getPrintInfoIdData();
//		
//		StringBuffer busiRemarkDesc = new StringBuffer();
//		StringBuffer busiNameDesc = new StringBuffer();
//		IBOBsParaDetailValue bo = null;
//		String className =null;
//		String tmpOrdRemark = null;
//		String tmpBusiName = null;
//		AbstractGetPrintTamplateValue abstractFunGetPrintTamplate = null;
//		IBceData bceData =null;
//		if(orderId>0){
//			try{
////				CenterFactory.setCenterInfoByTypeAndValue("BillId",billId);
//			bceData = SoServiceFactory.getOrderQrySrv().getSoOrderData(orderId);
//			}catch (OMFrameException e) {
//				if(!e.getMessage().equals("OMS1000044:"+LocaleResourceFactory.getResource("OMS1000044"))){
//					throw e;
//				}
//			}
//		}
//		
//		for(int i=0;i<attrs.length;i++){
//			String attrName = attrs[i].getAttrName();
//			String bceGetRule = attrs[i].getBceGetRule();
//			if(bceGetRule.equals("ABSTRACT")){
//				//各个业务特殊信息
//				Object obj = printInfoDataMap.get(attrName);
//				if(null != obj){
//					//如果前面传就取传的
//					map.put(attrName, obj);
//				}else{
//					//没传按照配置去取
//					bo = BceUtil.getParaDetailValue("X", String.valueOf(businessId),
//							attrName);
//					if(null != bo){
//						//IBceData bceData = SoDataFactory.getSoOrderDataFromDB(orderId);
//						className =bo.getPara1();
//						abstractFunGetPrintTamplate = (AbstractGetPrintTamplateValue)ReflectUtils.constructorNewInstance(className, null, null);
//						Object value=abstractFunGetPrintTamplate.getTamplateValue(businessId, attrName,billId,bceData);
//						if(Map.class.isInstance(value)){
//							Map subMap =(Map)value;
//							Iterator itr= subMap.keySet().iterator();
//							while(itr.hasNext()){
//								String key = (String)itr.next();
//								String subkeyMappingVal = (String)subMap.get(key);
//								if(null != subkeyMappingVal && subkeyMappingVal!=""){
//									//模板上哪些key 为了优化一把去取
//									map.put(key, subkeyMappingVal);
//								}
//							}
//						}else if(String.class.isInstance(value)){
//							if(null!= value && value!=""){
//								
//								if(attrName.equals("BUSI_INFO_FORUSER"))
//								{
//									String remindInfo=(String)map.get(attrName);
//									if(null != remindInfo){
//										remindInfo+="\n"+value;
//									}else{
//										remindInfo="";
//										remindInfo+=value;
//									}
//									map.put(attrName, remindInfo);
//								}else
//								{
//									map.put(attrName, value);
//								}
//							}
//						}
//					}
//				}
//			}else if(bceGetRule.equals(attrName)){
//				//特殊信息字段 如果变化字段多 建议将来搞成配置 ，如果不多代码写死无妨
//				if(attrName.equals("ORD_REMARKS")){
//					//获取各个业务的表述信息
//					tmpOrdRemark = (String)(printBusiData.getPrintInfoData().get("ORD_REMARKS"));
//					String ordRemark=(String)map.get("ORD_REMARKS");
//					if(null != ordRemark){
//						ordRemark+="\n"+tmpOrdRemark;
//					}else{
//						ordRemark="";
//						ordRemark+=tmpOrdRemark;
//					}
//					map.put("ORD_REMARKS", ordRemark);
//				}else if(attrName.equals("BUSI_NAME_LIST")){
//					//获取业务操作
//					tmpBusiName=(String)(printBusiData.getPrintInfoData().get("BUSI_NAME_LIST"));
//					String busiNameList=(String)map.get("BUSI_NAME_LIST");
//					if(null != busiNameList){
//						busiNameList+="、"+tmpBusiName;
//					}else{
//						busiNameList="";
//						busiNameList+=tmpBusiName;
//					}
//					map.put("BUSI_NAME_LIST", busiNameList);
//				}
//			}
////			else{
////				//公用信息取值
////				HashMap infoMap = new HashMap();
////				infoMap.put("BCEDATA", bceData);
////				infoMap.put("ATTR", attrs[i]);
////				infoMap.put("COUSTOM_ORDER_ID", String.valueOf(orderId));
////				infoMap.put("VERIFY_NAME",
////						SessionManager.getUser().get("VERIFY_NAME"));
////				infoMap.put("PRINT_BUSI_DATA", printBusiData);
////				infoMap.put("RESULT_MAP", map);
////				/**
////				 * 修改：for合并打印  传入billId 给后面的数据 让其根据billId查询公用的打印信息
////				 */
////				infoMap.put("BILL_ID", billId);
////				Object value = BceUtil.evalExpr(attrs[i].getBceGetRule(), infoMap);
////				//取出值 然后设置到最终的map里面去
////				map.put(attrName, value);
////			}
//			//拼装产品变化列表
//			if(null != printInfoIdMap && !printInfoIdMap.isEmpty()){
//				List list = (List)printInfoIdMap.get("PRODUCT_LIST");
//				if(null!=list && !list.isEmpty())
//				{
//					map.put("PROD_LIST", list);
//				}
//			}
//		}
//		
//		
//		return map;
//	}
//	
//	/**
//	 * 将数据库里面查询出来的IBOSoBusiPrintValue[]数据转化到list中去
//	 * @param commList
//	 * @return
//	 */
//	private static List<PrintBusiData> convertToPrintBusiData(List<PrintBusiData> commList,IBOSoBusiPrintValue[] values) throws Exception{
//		for(int i=0;i<values.length;i++){
//			//获取数据
//			String billId = values[i].getBillId();
//			String businessId = values[i].getDealType();
//			String pk = String.valueOf(values[i].getInfoNo());
//			String regionId = values[i].getRegion();
//			String printType = values[i].getPrintType();
//			String infoDataStr = values[i].getInfoData();
//			Map printInfoData = JsonUtil.getMapFromJsObject(infoDataStr);
//			String infoIdDataStr = values[i].getInfoIdData();
//			Map printInfoIdData = JsonUtil.getMapFromJsObject(infoIdDataStr);
//			long bceFrameId = Long.valueOf(values[i].getBceFrameId()).longValue();
//			
//			//拼装数据
//			PrintBusiData data = new PrintBusiData();
//			data.setBillId(billId);
//			data.setBusinessId(businessId);
//			data.setPk(Long.valueOf(pk));
//			data.setRegionId(regionId);
//			data.setPrintType(printType);
//			data.setPrintInfoData(printInfoData);
//			data.setPrintInfoIdData(printInfoIdData);
//			data.setBceFrameId(String.valueOf(bceFrameId));
//			//添加数据到list
//			commList.add(data);
//		}
//		return commList;
//	}
//	
//	/**
//	 * session中选中的数据放到list中
//	 * @param commList
//	 * @param sessionIdArray
//	 * @param billId
//	 * @return
//	 * @throws Exception
//	 */
//	private static List<PrintBusiData> selectedOfSessionData(List<PrintBusiData> commList,String[] sessionIdArray,String billId) throws Exception{
//		//判断session里面是否有本次需要打印的东东
//		Map sessionPrintInfo = (Map)BceCommonStore.getObjectFromSessionByKey("PRINT_INFO_MAP_BILL");
//		if(null != sessionPrintInfo && !sessionPrintInfo.isEmpty()){
//				Map postToPrintSessionKey = new HashMap();
//				if(null!=sessionIdArray && sessionIdArray.length>0){
//					for(int j=0;j<sessionIdArray.length;j++){
//						postToPrintSessionKey.put(sessionIdArray[j], null);
//					}
//				}
//				//从缓存中取的数据
//				List<PrintBusiData> list = (List)sessionPrintInfo.get(billId);
//				if(null != list){
//					for(int i=0;i<list.size();i++){
//						PrintBusiData printBusiData = list.get(i);
//						String pk = String.valueOf(printBusiData.getPk());
//						if(postToPrintSessionKey.containsKey(pk)){
//							commList.add(printBusiData);
//						}
//					}
//					//commList.addAll(list);//合并到commList中
//				}
//		}
//		return commList;
//	}
//	
//	/**
//	 * 给无纸化平台使用的打印信息封装到List 每一个订单对应一个List中的对象
//	 * @param dbRegionId
//	 * @param dbIdArray
//	 * @param billId 
//	 * @return
//	 * @throws Exception
//	 */
//	public static Map getPrintBusiInfoForPlat(String dbRegionId,String[] dbIdArray,String[] sessionIdArray,String billId) throws Exception{
//		Map result =new HashMap();
//		List<String> businessList = new ArrayList<String>();
//		List<Map> platPrintInfoList = null;
//		List<PrintBusiData> commList = new ArrayList();//用来存放合并后的打印信息
//		StringBuilder scirpt = new StringBuilder("");
//		long printTemplateId = 0;
//		if(null != dbIdArray && dbIdArray.length>0){
//			//从数据库中获取打印信息 
//			//根据info_no获取要打印的数据
//			ISoBusiPrintSV soBusiPrintSV =(ISoBusiPrintSV)getServiceExtInWebLayer(ISoBusiPrintSV.class,dbRegionId);
//			//ISoBusiPrintSV soBusiPrintSV =(ISoBusiPrintSV)ServiceFactory.getService(ISoBusiPrintSV.class);
//			/*
//			UserInfoInterface user = SessionManager.getUser();
//			String opUserRegionId = String.valueOf(user.get("REGION_ID"));
//			ISoBusiPrintSV soBusiPrintSV =null;
//			if(!opUserRegionId.equals(dbRegionId)){
//				soBusiPrintSV = (ISoBusiPrintSV)ServiceFactory.getCrossCenterService(ISoBusiPrintSV.class);
//			}else{
//				soBusiPrintSV = (ISoBusiPrintSV)ServiceFactory.getService(ISoBusiPrintSV.class);
//			}*/
//			IBOSoBusiPrintValue[] ivaluesOfDB = soBusiPrintSV.getBusiPrintByInfoNoArray(dbIdArray, dbRegionId,billId);
//			if(null != ivaluesOfDB && ivaluesOfDB.length>0){
//				//调用方法将IBOSoBusiPrintValue 转化为PrintBusiData 然后放在commList中
//				commList=convertToPrintBusiData(commList,ivaluesOfDB);
//			}
//		}
//		//判断session里面是否有本次需要打印的东东
//		Map sessionPrintInfo = (Map)BceCommonStore.getObjectFromSessionByKey("PRINT_INFO_MAP_BILL");
//		if(null != sessionIdArray && sessionIdArray.length>0){
//				//从缓存中取的数据
//				selectedOfSessionData(commList, sessionIdArray, billId);
//		}
//		if(null!=commList && commList.size()>0){
//			platPrintInfoList = new ArrayList();
//			String businessId = "";
//			//隔离开bce和项目代码
//			//modify by qiangao for 优化逻辑连带修改（整合普通打印模板和宽带打印模板）
//			IBceQrAttrValue[] attrs = getAttrsByPrintBusiData(commList.get(0));
//			//modify by qiangao 
//			Map commMap = new HashMap();
//			commMap = getCommInfo(commList, commMap);
//			for(int i=0;i<commList.size();i++){
//				PrintBusiData prinBusiData = commList.get(i);
//				Map oneOfOrd = new HashMap();
//				oneOfOrd=(Map) reflectInfo(prinBusiData, oneOfOrd,attrs);
//				//取公用信息
//				addMap(commMap, oneOfOrd);
//				businessId = prinBusiData.getBusinessId();
//				if(!StringUtils.isEmpty(businessId)){
//					businessList.add(businessId);
//				}else{
//					businessList.add("0");
//				}
//				platPrintInfoList.add(oneOfOrd);
//			}
//			String bceFrameId = commList.get(0).getBceFrameId();
//			printTemplateId=BceServiceFactory.getBceFrameSV().getBceFrameValue(Long.valueOf(bceFrameId).longValue()).getPrintTemplateId();
//		}
//		result.put("PRINT_TEMPLATE_ID", printTemplateId);
//		result.put("PRINT_LIST", platPrintInfoList);
//		result.put("PRINT_BUSI_LIST", businessList);
//		return result;
//	}
//	
//	
	
//	/**
//	 * 工单补打获取打印内容 add by xuhang (本地打印)
//	 * @return map 
//	 * @throws Exception
//	 */
//	public static String getSupplyPrintContentMap(String dbRegionId,String dbIds,String billId) throws Exception{
//		List<PrintBusiData> commList = new ArrayList();//用来存放合并后的打印信息
//		String[] dbIdArray = dbIds.split("_");
//		StringBuilder scirpt = new StringBuilder("");
//		if(null != dbIdArray && dbIdArray.length>0){
//			//从数据库中获取打印信息
//			//根据info_no获取要打印的数据
//			ISoBusiPrintSV soBusiPrintSV =(ISoBusiPrintSV)getServiceExtInWebLayer(ISoBusiPrintSV.class,dbRegionId);
//
//			IBOSoBusiPrintValue[] ivaluesOfDB = soBusiPrintSV.getBusiPrintByInfoNoArray(dbIdArray, dbRegionId,billId);
//			if(null != ivaluesOfDB && ivaluesOfDB.length>0){
//				//调用方法将IBOSoBusiPrintValue 转化为PrintBusiData 然后放在commList中
//				commList=convertToPrintBusiData(commList,ivaluesOfDB);
//			}
//		}
//	 
//		if(commList.size()>0){
//			//调用方法将commList中的数据转化为要分发出去的Map
//			Map map = convertListToBusiPrintMap(commList);
//			if(null != map && !map.isEmpty()){
//				Iterator itr = map.keySet().iterator();
//				while(itr.hasNext()){
//					String key = (String)itr.next();
//					String keyValue = StringUtils.replace(String.valueOf(map.get(key)), "\n", "\\n");
//					keyValue = StringUtils.replace(keyValue, "\r", "\\r");
//					String keyB = StringUtils.replace(keyValue, "\"", "\\\"");
//					scirpt.append("EtCell.SetAliasCell(\"" + key + "\",\"" + keyB
//							+ "\");");
//				}
//				scirpt.append("\n");
//				String json = JsonUtil.getJsonFromMap(map);
//				scirpt.append("returnMsg = '" + json + "';");
//			}
//		}
//		//清除缓存变量移动到PrintInfoAction中去做
//		return scirpt.toString();
//	}
	
	/**
	 * 工单补打获取打印内容 add by xuhang(无纸化打印)
	 * @return map 
	 * @throws Exception
	 */
//	public static Map getSupplyPrintBusiInfoForPlat(String dbRegionId,String dbIds,String billId,String create_date) throws Exception{
//		List<String> businessList = new ArrayList<String>();
//
//		String[] dbIdArray = dbIds.split("_");
//		Map result =new HashMap();
//		List<Map> platPrintInfoList = null;
//		List<PrintBusiData> commList = new ArrayList();//用来存放合并后的打印信息
//		StringBuilder scirpt = new StringBuilder("");
//		long printTemplateId = 0;
//		if(null != dbIdArray && dbIdArray.length>0){
//			//从数据库中获取打印信息
//			//根据info_no获取要打印的数据
//			//ISoBusiPrintSV soBusiPrintSV =(ISoBusiPrintSV)getServiceExtInWebLayer(ISoBusiPrintSV.class,dbRegionId);
//			ISoBusiPrintSV soBusiPrintSV = (ISoBusiPrintSV)ServiceFactory.getService(ISoBusiPrintSV.class);
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
//			java.util.Date judCreateDate = df.parse(create_date);
//			Timestamp cfd = TimeUtil.getCurrentMonthFirstDate(judCreateDate);
//			Timestamp ced = TimeUtil.getCurrentMonthEndDate(judCreateDate);
//
//			IBOSoBusiPrintValue[] ivaluesOfDB = soBusiPrintSV.getBusiPrintByInfoNoArray(dbIdArray, dbRegionId,billId,df.format(cfd),df.format(ced));
//			
//			if(null != ivaluesOfDB && ivaluesOfDB.length>0){
//				//调用方法将IBOSoBusiPrintValue 转化为PrintBusiData 然后放在commList中
//				commList=convertToPrintBusiData(commList,ivaluesOfDB);
//			}
//		}
// 
//		if(null!=commList && commList.size()>0){
//			platPrintInfoList = new ArrayList();
//			String businessId = "";
//			//隔离开bce和项目代码
//			//modify by qiangao for 优化逻辑连带修改（整合普通打印模板和宽带打印模板）
//			IBceQrAttrValue[] attrs = getAttrsByPrintBusiData(commList.get(0));
//			//modify by qiangao 
//			Map commMap = new HashMap();
//			commMap = getCommInfo(commList, commMap);
//			for(int i=0;i<commList.size();i++){
//				PrintBusiData prinBusiData = commList.get(i);
//				businessId = prinBusiData.getBusinessId();
//				if(!StringUtils.isEmpty(businessId)){
//					businessList.add(businessId);
//				}else{
//					businessList.add("0");
//				}
//				Map oneOfOrd = new HashMap();
//				reflectInfo(prinBusiData, oneOfOrd,attrs);
//				//取公用信息
//				addMap(commMap, oneOfOrd);
//				platPrintInfoList.add(oneOfOrd);
//			}
//			String bceFrameId = commList.get(0).getBceFrameId();
//			printTemplateId=BceServiceFactory.getBceFrameSV().getBceFrameValue(Long.valueOf(bceFrameId).longValue()).getPrintTemplateId();
//		}
//		result.put("PRINT_TEMPLATE_ID", printTemplateId);
//		result.put("PRINT_LIST", platPrintInfoList);
//		result.put("PRINT_BUSI_LIST", businessList);
//
//		return result;
//		
//		
//	}
//	
//	
//	/**
//	 * 工单重打获取打印内容 add by xuhang(本地打印)
//	 * @return map 
//	 * @throws Exception
//	 */
//	public static String getRePrintContentMap(String dbRegionId,String print_id,String billId,String createDate) throws Exception{
//		CenterFactory.setCenterInfoByTypeAndValue("RegionId", dbRegionId);
//
//		ISoBusiPrintInfoSV sv = (ISoBusiPrintInfoSV)ServiceFactory.getService(ISoBusiPrintInfoSV.class);
//	 
//		IBOSoBusiPrintInfoValue value = sv.getPrintInfo(print_id,createDate,dbRegionId);
//		StringBuffer sb = new StringBuffer();
//		String content = value.getSureSheetArgs();
//	 	content = StringUtils.replace(content, "\n", "\\n");
//	 	content = StringUtils.replace(content, "\r", "\\r");
//	  
//		Map map = JsonUtil.getMapFromJsObject(content);
// 
//		StringBuilder scirpt = new StringBuilder("");
//
//			if(null != map && !map.isEmpty()){
//				Iterator itr = map.keySet().iterator();
//				while(itr.hasNext()){
//					String key = (String)itr.next();
//					String keyValue = StringUtils.replace(String.valueOf(map.get(key)), "\n", "\\n");
//					keyValue = StringUtils.replace(keyValue, "\r", "\\r");
//					String keyB = StringUtils.replace(keyValue, "\"", "\\\"");
//					scirpt.append("EtCell.SetAliasCell(\"" + key + "\",\"" + keyB
//							+ "\");");
//				}
//				scirpt.append("\n");
//				String json = JsonUtil.getJsonFromMap(map);
//				json = json.replace("\'", "");
//				scirpt.append("returnMsg = '" + json + "';");
//			}
//	 
//		//清除缓存变量移动到PrintInfoAction中去做
//		return scirpt.toString();
//	}
//	
	public static String dealDisStr(String templateStr,Map<String,String> map) throws Exception {
		String result = null;
		if(templateStr.indexOf("{")!=1 && templateStr.indexOf("}")!=-1){
			Iterator<String> keyItr = map.keySet().iterator();
			while(keyItr.hasNext()){
				String key = keyItr.next();
				String val = map.get(key);
				templateStr=templateStr.replace("{"+key+"}", val);
			}
			result=templateStr;
		}
		return result;
	}
	
	public static String getBillIdFromBceData(IBceData bceData) throws Exception{
		String billId = null;
		if(null!=bceData){
			if(bceData instanceof BceDataBean){
				billId = ((BceDataBean)bceData).getUserData("BILL_ID");
			}else if(bceData instanceof ISoOrderData){
				billId = ((ISoOrderData)bceData).getBillId();
			}
		}
		return billId;
	}
	
	/**
	 * 该方法只限web层用
	 * 
	 * @param clazz
	 * @param currentRegionId
	 * @return
	 * @throws Exception
	 */
	private static Object getServiceExtInWebLayer(Class clazz,String currentRegionId) throws Exception{
		UserInfoInterface user = SessionManager.getUser();
			String opUserRegionId = String.valueOf(user.get("REGION_ID"));
			Object service =null;
			if(!opUserRegionId.equals(currentRegionId)){
				service = ServiceFactory.getCrossCenterService(clazz);
			}else{
				service = ServiceFactory.getService(clazz);
			}
		return service;
	}
	
	
	private static Map getAttrVal(Map resultMap,IBceQrAttrValue[] attrs,Map infoMap) throws Exception{
		if(null!=resultMap && resultMap.size()>0){
			resultMap = new HashMap();
		}
		if(null!=attrs && attrs.length>0 && null!=infoMap && !infoMap.isEmpty()){
			String attrName = null;
			String val = "";
			for(int i=0;i<attrs.length;i++){
				attrName=attrs[i].getAttrName();
				//add by qiangao 剔除特殊处理的字段（可以叠加的字段）
				if(infoMap.containsKey(attrName) && !attrName.equals(attrs[i].getBceGetRule())){
					val=String.valueOf(infoMap.get(attrName));
					if(null!=val && !StringUtils.isEmpty(val)){
						resultMap.put(attrName, val);
					}
				}
			}
		}
		return resultMap;
	}
	
//	private static Map getAttrValByList(PrintBusiData printBusiData,Map resultMap) throws Exception{
//		IBceFrameValue bceFrameVal = BceServiceFactory.getBceFrameSV().getBceFrameValue(Long.valueOf(printBusiData.getBceFrameId()));
//		long printTemplateId = bceFrameVal.getPrintTemplateId();
//		if(printTemplateId>0){
//			if(!BusiPrintInvoke.isInMergedTemplateIds(bceFrameVal)){
//				throw new BusinessException("业务对应的打印模板不是可以合并的打印模板");
//			}
//		}
//		IBceQrTemplateValue bceQrTemplateVal = BceServiceFactory.getBceFrameSV().getTemplateValueByTmmplateId(bceFrameVal.getPrintTemplateId());
//		IBceQrAttrValue[] attrs = BceServiceFactory.getBceFrameSV()
//			.getQrTempAttrs(0, null, bceQrTemplateVal.getTemplateId(), true);
//		Map infoMap = printBusiData.getPrintInfoData();
//		resultMap = getAttrVal(resultMap, attrs, infoMap);
//		return resultMap;
//	}
//	
//	/**
//	 * 获取可以合并的模板ID 
//	 * 调用该方法的地方
//	 * 一定是能确定多个业务使用的是同一个模板 
//	 * 否则不能调用该方法
//	 * @param printBusiData
//	 * @return
//	 * @throws Exception
//	 */
//	private static IBceQrAttrValue[] getAttrsByPrintBusiData(PrintBusiData printBusiData) throws Exception {
//		IBceFrameValue bceFrameVal = BceServiceFactory.getBceFrameSV().getBceFrameValue(Long.valueOf(printBusiData.getBceFrameId()));
//		long printTemplateId = bceFrameVal.getPrintTemplateId();
//		if(printTemplateId>0){
//			if(!BusiPrintInvoke.isInMergedTemplateIds(bceFrameVal)){
//				throw new BusinessException("业务对应的打印模板不是可以合并的打印模板");
//			}
//		}
//		//修改之前是20111124 修改之后这里能够 获取的是在BceUtil.getParaDetailValue("X", "PrintSpecial","MergedTemplateIds");上配置过的模板数据 目前包涵（20111124和20111125）
//		IBceQrTemplateValue bceQrTemplateVal = BceServiceFactory.getBceFrameSV().getTemplateValueByTmmplateId(bceFrameVal.getPrintTemplateId());
//		IBceQrAttrValue[] attrs = BceServiceFactory.getBceFrameSV()
//			.getQrTempAttrs(0, null, bceQrTemplateVal.getTemplateId(), true);
//		return attrs;
//	}
//	/**
//	 * 给本地打印使用 拼装公用信息
//	 * @param commList
//	 * @param resultMap
//	 * @return
//	 * @throws Exception
//	 */
//	private static Map getCommInfo(List<PrintBusiData> commList,Map resultMap) throws Exception{
//		//公用信息取值
//		HashMap infoMap = new HashMap();
//		List<IBceData> listBceData = new ArrayList();
//		PrintBusiData printBusiData = null;
//		long custOrdId = 0;
//		HashMap<String,PrintBusiData> subBusiIdPrintBusiData = new HashMap();
//		for(int i=0;i<commList.size();i++){
//			printBusiData = commList.get(i);
//			String businessId = printBusiData.getBusinessId();
//			custOrdId = printBusiData.getCustomerOrdId();
//			if(custOrdId>0){
//				//异步工单的时候才会有数据才能重现BCEData
//				try{
//					String regionId = CenterUtil.getRegionIdByOrderId(custOrdId);
//					String userRegionId = String.valueOf(SessionManager.getUser().get(BceSVUtil.REGION_ID));
//					IBceData bceData = null;
//					if(regionId.equals(userRegionId)){
//						 bceData = SoServiceFactory.getOrderQrySrv().getSoOrderData(custOrdId);
//					}else{
//						IOrderQrySV orderQrySV = (IOrderQrySV)ServiceFactory.getCrossCenterService(IOrderQrySV.class);
//						bceData = orderQrySV.getSoOrderData(custOrdId);
//					}
//					if(null!=bceData)
//						listBceData.add(bceData);
//				}catch (OMFrameException e) {
//					if(!e.getMessage().equals("OMS1000044:"+LocaleResourceFactory.getResource("OMS1000044"))){
//						throw e;
//					}
//				}
//			}
//			//if(subBusiIdPrintBusiData.containsKey(businessId)){
//				//不管该businessId是否已经存在 将其覆盖掉
//				subBusiIdPrintBusiData.put(printBusiData.getBusinessId(), printBusiData);
//			//}
//			
//		}
//		//由于到此的模板数据一定是同一个模板所以取任何一个均可获得配置数据
//		IBceQrAttrValue[] attrs =null;
//		String billId = null;
//		if(null!=commList && !commList.isEmpty()){
//			attrs = getAttrsByPrintBusiData(commList.get(0));
//			billId = commList.get(0).getBillId();
//		}
//		
//		
//		infoMap.put("BCE_DATA_LIST", listBceData);
//		infoMap.put("ATTRS", attrs);
//		//infoMap.put("COUSTOM_ORDER_ID", String.valueOf(orderId));
//		infoMap.put("VERIFY_NAME",
//				SessionManager.getUser().get("VERIFY_NAME"));
//		infoMap.put("BUSIID_PRINTBUSIDATA", subBusiIdPrintBusiData);
//		infoMap.put("RESULT_MAP", resultMap);
//		
//		/**
//		 * 修改：for合并打印  传入billId 给后面的数据 让其根据billId查询公用的打印信息
//		 */
//		infoMap.put("BILL_ID", billId);
//		Object valueMap = BceUtil.evalExpr("${com.asiainfo.crm.so.common.print.common.PrintBceInfoData:getTamplateValue}$", infoMap);
//		//取出值 然后设置到最终的map里面去
//		resultMap = (Map)valueMap;
//		return resultMap;
//	}
//	
	/**
	 * 给无纸化平台打印使用拼装公用信息
	 * @param printBusiData
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Deprecated
//	private static Map getCommInfo(PrintBusiData printBusiData,Map map) throws Exception{
//		String businessId = printBusiData.getBusinessId();
//		String billId = printBusiData.getBillId();
//		long orderId = printBusiData.getCustomerOrdId();
//		Map printInfoDataMap =(Map)printBusiData.getPrintInfoData();
//		Map printInfoIdMap = printBusiData.getPrintInfoIdData();
//		//隔离开bce和项目代码
//		//modify by qiangao for 优化逻辑连带修改（整合普通打印模板和宽带打印模板）
//		IBceQrAttrValue[] attrs = getAttrsByPrintBusiData(printBusiData);
//		StringBuffer busiRemarkDesc = new StringBuffer();
//		StringBuffer busiNameDesc = new StringBuffer();
//		IBOBsParaDetailValue bo = null;
//		String className =null;
//		String tmpOrdRemark = null;
//		String tmpBusiName = null;
//		AbstractGetPrintTamplateValue abstractFunGetPrintTamplate = null;
//		IBceData bceData =null;
//		if(orderId>0){
//			try{
//			bceData = SoServiceFactory.getOrderQrySrv().getSoOrderData(orderId);
//			}catch (OMFrameException e) {
//				if(!e.getMessage().equals("OMS1000044:"+LocaleResourceFactory.getResource("OMS1000044"))){
//					throw e;
//				}
//			}
//		}
//		
//		for(int i=0;i<attrs.length;i++){
//			String attrName = attrs[i].getAttrName();
//			String bceGetRule = attrs[i].getBceGetRule();
//			//公用信息取值
//			HashMap infoMap = new HashMap();
//			infoMap.put("BCEDATA", bceData);
//			infoMap.put("ATTR", attrs[i]);
//			infoMap.put("ATTRS", attrs);
//			infoMap.put("COUSTOM_ORDER_ID", String.valueOf(orderId));
//			infoMap.put("VERIFY_NAME",
//					SessionManager.getUser().get("VERIFY_NAME"));
//			infoMap.put("PRINT_BUSI_DATA", printBusiData);
//			infoMap.put("RESULT_MAP", map);
//			/**
//			 * 修改：for合并打印  传入billId 给后面的数据 让其根据billId查询公用的打印信息
//			 */
//			infoMap.put("BILL_ID", billId);
//			Object value = BceUtil.evalExpr(attrs[i].getBceGetRule(), infoMap);
//			//取出值 然后设置到最终的map里面去
//			map.put(attrName, value);
//		}
//		return map;
//	}
//	
//	
	/**
	 *  将src的map内容添加到obj中去
	 * @param src
	 * @param obj
	 * @return
	 */
	public static Map addMap(Map src,Map obj){		
		if(null == src || src.isEmpty()){
			return obj;
		}
		if(null == obj ){
			obj = new HashMap();
		}
		Set<String> keySet = src.keySet();
		Iterator keyItr = keySet.iterator();
		while(keyItr.hasNext()){
			String key = String.valueOf(keyItr.next());
			Object val = src.get(key);
			String tmp = String.valueOf(val);
			if(null!=val && !StringUtils.isEmpty(String.valueOf(val).trim())){
				obj.put(key, val);
			}else{
				if(!(obj.containsKey(key) && null!=obj.get(key) && !StringUtils.isEmpty(String.valueOf(obj.get(key)).trim()))){
					obj.put(key, "");
				}
			}
		}
		return obj;
	}
	
	/**
	 * 工单补打获取打印内容 add by xuhang (本地打印)
	 * @return map 
	 * @throws Exception
	 */
//	public static String getSupplyPrintContentMap(String dbRegionId,String dbIds,String billId,String create_date) throws Exception{
//		List<PrintBusiData> commList = new ArrayList();//用来存放合并后的打印信息
//		String[] dbIdArray = dbIds.split("_");
//		StringBuilder scirpt = new StringBuilder("");
//		if(null != dbIdArray && dbIdArray.length>0){
//			//从数据库中获取打印信息
//			//根据info_no获取要打印的数据
//			//ISoBusiPrintSV soBusiPrintSV =(ISoBusiPrintSV)getServiceExtInWebLayer(ISoBusiPrintSV.class,dbRegionId);
//			ISoBusiPrintSV soBusiPrintSV =(ISoBusiPrintSV)ServiceFactory.getService(ISoBusiPrintSV.class);
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
//			java.util.Date judCreateDate = df.parse(create_date);
//			Timestamp cfd = TimeUtil.getCurrentMonthFirstDate(judCreateDate);
//			Timestamp ced = TimeUtil.getCurrentMonthEndDate(judCreateDate);
//
//			IBOSoBusiPrintValue[] ivaluesOfDB = soBusiPrintSV.getBusiPrintByInfoNoArray(dbIdArray, dbRegionId,billId,df.format(cfd),df.format(ced));
//			if(null != ivaluesOfDB && ivaluesOfDB.length>0){
//				//调用方法将IBOSoBusiPrintValue 转化为PrintBusiData 然后放在commList中
//				commList=convertToPrintBusiData(commList,ivaluesOfDB);
//			}
//		}
//	 
//		if(commList.size()>0){
//			//调用方法将commList中的数据转化为要分发出去的Map
//			Map map = convertListToBusiPrintMap(commList);
//			if(null != map && !map.isEmpty()){
//				Iterator itr = map.keySet().iterator();
//				while(itr.hasNext()){
//					String key = (String)itr.next();
//					String keyValue = StringUtils.replace(String.valueOf(map.get(key)), "\n", "\\n");
//					keyValue = StringUtils.replace(keyValue, "\r", "\\r");
//					String keyB = StringUtils.replace(keyValue, "\"", "\\\"");
//					scirpt.append("EtCell.SetAliasCell(\"" + key + "\",\"" + keyB
//							+ "\");");
//				}
//				scirpt.append("\n");
//				String json = JsonUtil.getJsonFromMap(map);
//				json = json.replace("\'", "");
//				scirpt.append("returnMsg = '" + json + "';");
//			}
//		}
//		//清除缓存变量移动到PrintInfoAction中去做
//		return scirpt.toString();
//	}
	/**
	 * 工单重打获取打印内容 add by xuhang (无纸化打印)
	 * @return map 
	 * @throws Exception
	 */
	/*public static Map getRePrintBusiInfoForPlat(String dbRegionId,String print_id,String billId) throws Exception{
		CenterFactory.setCenterInfoByTypeAndValue("RegionId", dbRegionId);

		ISoBusiPrintInfoSV sv = (ISoBusiPrintInfoSV)ServiceFactory.getService(ISoBusiPrintInfoSV.class);
	 
		IBOSoBusiPrintInfoValue value = sv.getPrintInfo(print_id,dbRegionId);
		StringBuffer sb = new StringBuffer();
		String content = value.getSureSheetArgs();
	 	content = StringUtils.replace(content, "\n", "\\n");
	 	content = StringUtils.replace(content, "\r", "\\r");
	  
		Map map = JsonUtil.getMapFromJsObject(content);
 
		Map result =new HashMap();
		List<Map> platPrintInfoList = new ArrayList();
		List<PrintBusiData> commList = new ArrayList();//用来存放合并后的打印信息
		StringBuilder scirpt = new StringBuilder("");
		long printTemplateId =value.getTemplateId();
 
 
		platPrintInfoList.add(map);
 
	 
		result.put("PRINT_TEMPLATE_ID", printTemplateId);
		result.put("PRINT_LIST", platPrintInfoList);
		return result;
		
	}
	*/
	
}
