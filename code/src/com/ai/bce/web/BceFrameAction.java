package com.ai.bce.web;

import java.io.Writer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ClassLoaderUtil;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.multicenter.CenterFactory;
import com.ai.appframe2.privilege.UserInfoInterface;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.bce.auto.plugin.qr.PrintUtil;
import com.ai.bce.create.AbstractTemplateString;
import com.ai.bce.create.template.impl.TemplateStringForFrameJs;
import com.ai.bce.create.template.impl.TemplateStringForJs;
import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceDealReturnData;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.ivalues.IBceRowsetValue;
import com.ai.bce.ivalues.IBceRuleReturnData;
import com.ai.bce.ivalues.IQPageFramePageValue;
import com.ai.bce.ivalues.ISubmitData;
import com.ai.bce.service.interfaces.IBceDataParser;
import com.ai.bce.service.interfaces.IBceFrameSV;
import com.ai.bce.util.BceCommonStore;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceSVUtil;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;
import com.ai.bce.util.BusiPrintInvoke;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.util.ReflectUtils;
import com.ai.bce.util.SubmitDataXmlParseUtil;
import com.ai.bce.util.bean.PreDealBusiPrintBean;
import com.ai.bce.util.define.IBceDealAction;
import com.ai.bce.valuebean.BceDataBean;
import com.ai.bce.valuebean.BceDealReturnDataBean;
import com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV;
import com.ai.common.ivalues.IBOBsStaticDataValue;
import com.ai.common.util.CenterUtil;
import com.ai.common.util.StaticDataUtil;
import com.ai.common.util.TimeUtil;
import com.ai.omframe.instance.ivalues.IInsUserValue;
import com.ai.omframe.instance.service.interfaces.IInstanceQrySV;
import com.asiainfo.crm.inter.common.util.DateTime;
import com.asiainfo.crm.so.instance.rboss.service.interfaces.ISoBusiPrintInfoSV;
//import com.asiainfo.crm.so.order.rboss.ivalues.IBOSoBusiPrintValue;
//import com.asiainfo.crm.so.order.rboss.service.interfaces.ISoBusiPrintSV;

public class BceFrameAction extends BaseAction {
	private static transient Log log = LogFactory.getLog(BceFrameAction.class);

	public IBOBsStaticDataValue[] getStaticData(String codeType)
			throws Exception {
		return StaticDataUtil.getStaticData(codeType);
	}

	/**
	 * 适用于单页面数据提交
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveRowsets(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		try {
			long beFrameId = HttpUtil.getAsLong(request,
					BceUtil.BCE_FRAME_ID_KEY);
			IBceData bceData = new BceDataBean();
			bceData.setBceFrameId(beFrameId);
			BceSVUtil.setDoCenter(false);
			BceSVUtil.SetCrossing(request);
			for (Enumeration en = request.getParameterNames(); en
					.hasMoreElements();) {
				String key = en.nextElement().toString();
				bceData.addUserData(key, HttpUtil.getAsString(request, key));
			}
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(
					request.getInputStream(), null);
			if (dcLists != null && dcLists.length > 0) {
				for (int i = 0; i < dcLists.length; i++) {
					if (dcLists[i] == null)
						continue;
					DataContainerInterface[] dcis = dcLists[i]
							.getColDataContainerInterface(0);
					if (dcis != null && dcis.length > 0) {
						String idKey = "RowsetId_" + (i + 1);
						String id = bceData.getUserData(idKey);
						if (StringUtils.isBlank(id)) {
							id = dcis[0].getTypeName();
						}
						bceData.addNormalRowsetInfo(id,
								dcLists[i].getColDataContainerInterface(0));
					}
				}
			}

			IBceDealReturnData returnData = BceServiceFactory.getBceFrameSV()
					.dealService(beFrameId, bceData, false, 0);
			setCustomProperty(cp, returnData);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			cp.set("MESSAGE", ex.getCause() == null ? ex.getMessage() : ex
					.getCause().getMessage());
		}
		HttpUtil.showInfo(response, cp);
	}

	/**
	 * PostInfo
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		try {
			long beFrameId = HttpUtil.getAsLong(request,
					BceUtil.BCE_FRAME_ID_KEY);

			// 设置中心——————
			BceSVUtil.setDoCenter(false);
			BceSVUtil.SetCrossing(request);
			// 设置跨中心结束

			IBceData bceData = new BceDataBean();
			bceData.setBceFrameId(beFrameId);
			for (Enumeration en = request.getParameterNames(); en
					.hasMoreElements();) {
				String key = en.nextElement().toString();
				bceData.addUserData(key, HttpUtil.getAsString(request, key));
			}

			IBceDealReturnData returnData = BceServiceFactory.getBceFrameSV()
					.dealService(beFrameId, bceData, false, 0);
			// 将ReturnData 数据回写至CustomProperty
			setCustomProperty(cp, returnData);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			cp.set("MESSAGE", ex.getCause() == null ? ex.getMessage() : ex
					.getCause().getMessage());
		}
		HttpUtil.showInfo(response, cp);
	}

	/**
	 * 适用于组合页面数据提交
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveContent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Date startTime = new Date();
		writeLog(startTime, null, null, null, request,null); //记录访问日志
		
		response.setContentType(HttpUtil.HTML_CONTENT_TYPE);
		CustomProperty cp = CustomProperty.getInstance();
		// 设置中心
		BceSVUtil.setDoCenter(false);
		// 设置跨中心服务
		BceSVUtil.SetCrossing(request);

		try {
			
			Map paramMap = BceUtil.getMap(request);
			String IS_CONFIRM = HttpUtil.getAsString(request, "IS_CONFIRM");
			// 如果是已经校验过一次且是警告类型的，则用户确认提交时不再进行规则校验，直接提交。
			if (StringUtils.isNotBlank(IS_CONFIRM)
					&& StringUtils.equalsIgnoreCase("Y", IS_CONFIRM)) {
				cp = this.saveCont(request, paramMap, cp);
			} else {
				// 提交订单之前判断是否有提交订单类的校验规则并执行。
				long beFrameId = HttpUtil.getAsLong(request,
						BceUtil.BCE_FRAME_ID_KEY);
				IBceRuleReturnData returnData = null;
				if (BceSVUtil.checkIsCrossing(beFrameId, null,
						BceUtil.JAVA_RULE_SET_TYPE_ORDER_SUBMIT)) {
					returnData = BceServiceFactory.getCrossRuleEngine()
							.isCanSubmitOrder(beFrameId, -1, null, paramMap);
				} else {
					returnData = BceServiceFactory.getRuleEngine()
							.isCanSubmitOrder(beFrameId, -1, null, paramMap);
				}

				int aFlag = returnData.getResultCode();
				if (aFlag == BceUtil.JAVA_RULE_RETURN_CODE_NO) {
					cp.set("FLAG", BceUtil.STR_NO);
					cp.set("MESSAGE", returnData.getMsg());
				} else if (aFlag == BceUtil.JAVA_RULE_RETURN_CODE_WARNNING) {
					// 如果是警告，则提示用户。
					cp.set("FLAG", BceUtil.STR_WARNNING);
					cp.set("MESSAGE", returnData.getMsg());
				} else {
					cp = this.saveCont(request, paramMap, cp);
				}
			}
			Date endTime = new Date();
			writeLog(startTime, endTime, null, null, request,null);
		} catch (Exception ex) {
			Date endTime = new Date();
			writeLog(startTime, endTime, null, null, request,ex); 
//			log.error(ex.getMessage(), ex);
			cp.set("FLAG", "ERROR");
			cp.set("MESSAGE", ex.getCause() == null ? ex.getMessage() : ex
					.getCause().getMessage());
		}
		HttpUtil.showInfo(response, cp);
	}

	/**
	 * 页面收集的数据提交保存，启动流程
	 * 
	 * @param request
	 * @param cp
	 * @return
	 * @throws Exception
	 */
	private CustomProperty saveCont(HttpServletRequest request, Map paramMap,
			CustomProperty cp) throws Exception {
		long beFrameId = HttpUtil.getAsLong(request, BceUtil.BCE_FRAME_ID_KEY);
		/**
		 * 打印数据
		 */
//		String isPrint = HttpUtil.getAsString(request, "isPrint");
		// BceSVUtil.SetCrossing(request);
		// BceSVUtil.setDoCenter(false);
		IBceData bceData = (IBceData) BceCommonStore
				.getObjectFromSessionByKey(BceUtil.BCE_COSTOMER_ORDER_CACHE_KEY);
		
		Date startTime = new Date();
		writeLog(startTime, null, IBceFrameSV.class.getName(), "getBceFrameValue", request,null);
		
		IBceFrameValue beFrame = BceServiceFactory.getBceFrameSV()
				.getBceFrameValue(beFrameId);
		
		Date endTime = new Date();
		writeLog(startTime, endTime, IBceFrameSV.class.getName(), "getBceFrameValue", request,null);
		
		String key = HttpUtil.getAsString(request, "myrandom");
		String sessionKey = (String) BceCommonStore
				.getObjectFromSessionByKey(BceUtil.BCE_COSTOMER_TRANSATION_RADOM);
		if (bceData == null || !StringUtils.equals(key, sessionKey)) {
			// 清除SessionKey信息
			BceCommonStore
					.clearSessionByKey(BceUtil.BCE_COSTOMER_ORDER_CACHE_KEY);
			BceCommonStore.putObjectToSession(
					BceUtil.BCE_COSTOMER_TRANSATION_RADOM, key);
			ISubmitData[] objSubmitDatas = SubmitDataXmlParseUtil
					.parseSubmitData(request);

			// 使用受理框架配的解析类
			// 需要实现接口：com.ai.bce.service.interfaces.IBceDataParser
			String parserName = beFrame.getDataParser();
			if (StringUtils.isBlank(parserName)) {
				parserName = "com.ai.bce.service.impl.BceDataParserImpl";
			}

			IBceDataParser parser = (IBceDataParser) ClassLoaderUtil.loadClass(
					parserName).newInstance();
			
			startTime = new Date();
			writeLog(startTime, null, parserName, "dataParse", request,null);

			bceData = parser.dataParse(objSubmitDatas, paramMap);
			
			endTime = new Date();
			writeLog(startTime, endTime, parserName, "dataParse", request,null);	
			
			bceData.setSessionId(request.getSession().getId());
			bceData.setBceFrameId(beFrameId);
			BceCommonStore.putObjectToSession(
					BceUtil.BCE_COSTOMER_ORDER_CACHE_KEY, bceData);
		}

		
		//由于调整了打印确认页的信息 所以isPrint_S全是false
		boolean isPrint_S = false;
		String orderId = "";
		orderId = HttpUtil.getAsString(request, "COUSTOM_ORDER_ID");
		//启动流程
		IBceDealReturnData returnData = new BceDealReturnDataBean();

		//在显示打印页之前返回受理结果
		String dealService = BceSVUtil
								 .checkAction(beFrame.getDealService());
		String customId = "";
		if (StringUtils.isBlank(orderId) || "null".equals(orderId)) {
			if (log.isDebugEnabled()) {
				log.debug(LocaleResourceFactory.getResource("BES0000836"));
			}
			startTime = new Date();
			writeLog(startTime, null, IBceFrameSV.class.getName(), "getCoustomOrderCode", request,null);
			
			customId = BceServiceFactory.getBceFrameSV()
					.getCoustomOrderCode(beFrame.getDealService());
			
			endTime = new Date();
			writeLog(startTime, endTime, IBceFrameSV.class.getName(), "getCoustomOrderCode", request,null);
		} else {
			customId = orderId;
		} 
		
		if (StringUtils.equals(BceSVUtil.BCE_USE_SERVICE,
					BceSVUtil.checkAction(beFrame.getDealService()))) {
			startTime = new Date();
			writeLog(startTime, null, IBceFrameSV.class.getName(), "dealService", request,null);
			
			returnData = BceServiceFactory.getBceFrameSV().dealService(
						beFrameId, bceData, isPrint_S, customId);
			endTime = new Date();
			writeLog(startTime, endTime, IBceFrameSV.class.getName(), "dealService", request,null);
		} else {
				IBceDealAction dealAction = (IBceDealAction) ReflectUtils
						.constructorNewInstance(dealService, new Class[] {},
								new Object[] {});
				returnData = dealAction.dealService(beFrameId, bceData,
						isPrint_S, customId);
		}
		Map map =returnData.getProcessReturnMap();
		if(null!=map && map.size()>0){
			BusiPrintInvoke busiPrintInvoke = BusiPrintInvoke._getInstance();
//			PreDealBusiPrintBean preDealBusiPrintBean =(PreDealBusiPrintBean)map.get("preDealBusiPrintBean");
//			if(null != preDealBusiPrintBean){
//				busiPrintInvoke.putPrePrintBusiBeanIntoSession(preDealBusiPrintBean);
//			}
			Map printDealResult = (Map)map.get("printDealResultInfo");
			if(null != printDealResult){
				busiPrintInvoke.putPrintDealResultInfoIntoSession(printDealResult);
			}
		}
		
		// 增加对确认页的处理数据
		//启动流程 
		//add 剔除对统一打印模板的数据控制
		String[][] str=null;
		String[][] tmpArray = null;
		//判断受理是否成功
		if((beFrame.getPrintTemplateId() > 1  && BceServiceFactory
				.getBceFrameSV().getTemplateValueByTmmplateId(
						beFrame.getPrintTemplateId()) != null)){
			
			String[][] dealServiceReturnInfo = returnData.getCustomProperty();
			if(null != dealServiceReturnInfo && dealServiceReturnInfo.length>0){
				tmpArray= new String[1+dealServiceReturnInfo.length][2];
			}else{
				tmpArray= new String[1][2];
			}
			
			if(null !=dealServiceReturnInfo){
				for(int i=0; i<dealServiceReturnInfo.length;i++){
					tmpArray[i][0]=dealServiceReturnInfo[i][0];
					tmpArray[i][1]=dealServiceReturnInfo[i][1];
				}	
			}
			//判断该模板是否在合并打印模板列表中
			if(!BusiPrintInvoke.isInMergedTemplateIds(beFrame)){
				boolean compose=false;
				if(null!=dealServiceReturnInfo && dealServiceReturnInfo.length>0)
				{
					tmpArray[dealServiceReturnInfo.length][0] = "IS_SUCCESS_PRINT_FLAG";
					tmpArray[dealServiceReturnInfo.length][1] = "BCE_QR";
				}else{
					tmpArray[0][0] = "IS_SUCCESS_PRINT_FLAG";
					tmpArray[0][1] = "BCE_QR";
				}
				
			}
			if(null!=tmpArray){
				str = new String[1+tmpArray.length][2];
			}else{
				str = new String[1][2];
			}
			str[0][0] = "COUSTOM_ORDER_ID";
			str[0][1] = String.valueOf(customId);
			if(null!=tmpArray){
				for(int i=0;i<tmpArray.length;i++){
					str[i+1][0]=tmpArray[i][0];
					str[i+1][1]=tmpArray[i][1];
				}
			}
			returnData.setCustomProperty(str);
		}
		
		// 将ReturnData 数据回写至CustomProperty
		setCustomProperty(cp, returnData);//
		

		// 清除线程Bce线程中的数据
		BceCommonStore.clearThread();
		return cp;
	}
	
	/**
	 * 记录日志
	 * @param startTime
	 * @param endTime
	 * @param className
	 * @param method
	 * @param request
	 * @throws Exception
	 */
	public void writeLog(Date startTime, Date endTime,  String className, String method, HttpServletRequest request,Exception ex) throws Exception {
		String startDate = null;
		String endDate = null;
		String operId = null;
		StringBuffer buf = new StringBuffer();
		UserInfoInterface userInfo = SessionManager.getUser();
		if(userInfo!=null){
			operId = userInfo.getCode();
		}
		if(startTime!=null){
			startDate = DateTime.getStringDate(startTime, "yyyy-MM-dd HH:mm:ss SSS");
		}
		if(endTime!=null){
			endDate = DateTime.getStringDate(endTime, "yyyy-MM-dd HH:mm:ss SSS");
		}
		
		UserInfoInterface user = SessionManager.getUser();

		String clientIp = "";
		if (user != null) {
			clientIp = user.getIP();
		}
		String serviceIp=com.ai.appframe2.complex.util.RuntimeServerUtil.getServerIP();

		buf.append("客户端IP："+clientIp);
		buf.append("、服务端IP："+serviceIp);
		buf.append("、进程号："+Thread.currentThread().getId());
		
		if(className!=null){
			buf.append("、服务名称："+className);
			if(method!=null){
				buf.append(".");
				buf.append(method);
			}
		}
		if(startDate!=null&&endDate==null){
			buf.append("、开始调用时间："+startDate);
		}
		if(endDate!=null){
			buf.append("、结束调用时间："+endDate);
		}
		if(startTime!=null&&endTime!=null){
			long time = endTime.getTime()-startTime.getTime();
			buf.append("、调用时长："+time+"毫秒");
		}
		if(operId!=null){
			buf.append("、操作员编号："+operId);
		}
		if(ex!=null&&ex.getMessage()!=null){
			buf.append("异常信息："+ex.getMessage());
		}
		if(ex!=null){
			log.error(buf,ex);
		}
		else{
			log.error(buf);
		}
		
	}

	/**
	 * 将ReturnData 数据回写至CustomProperty
	 * 
	 * @Title: setCustomProperty
	 * @Description: TODO
	 * @param @param cp
	 * @param @param returnData
	 * @return void
	 * @throws
	 */
	private void setCustomProperty(CustomProperty cp,
			IBceDealReturnData returnData) {
		String[][] msg = returnData.getCustomProperty();
		for (int i = 0; i < msg.length; i++) {
			cp.set(msg[i][0], msg[i][1]);
		}
	}

	/**
	 * js event引擎,根据规则集编码或者页面id获取关联的js规则信息,writer到页面上
	 * 
	 * @param req
	 * @param writer
	 * @throws Exception
	 */
	public static void writePageRuleDetails(PageContext pageContext,
			HttpServletRequest req, Writer writer) throws Exception {
		try {
			BceSVUtil.setDoCenter(false);
			String ruleSetCode = HttpUtil.getAsString(req, "PAGE_RULESET_ID");
			if (StringUtils.isNotBlank(ruleSetCode)) {
				AbstractTemplateString sb = new TemplateStringForJs();
				sb.setDy(true);
				sb.setRequest(req);
				writer.append(sb.dispalayByRusetId(Long.valueOf(ruleSetCode)
						.longValue()));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * 将功能点关联的前台规则写到框架页面上
	 * 
	 * @param pageContext
	 * @param req
	 * @param writer
	 * @throws Exception
	 */
	public static void writeFrameRuleDetails(PageContext pageContext,
			HttpServletRequest req, Writer writer) throws Exception {
		BceSVUtil.setDoCenter(false);
		try {
			long bceFrameId = HttpUtil.getAsLong(req, BceUtil.BCE_FRAME_ID_KEY);
			if (bceFrameId <= 0) {
				long businessId = HttpUtil.getAsLong(req,
						BceUtil.BUSIOPER_ID_KEY);
				IBceFrameValue soFrameValue = BceServiceFactory.getBceFrameSV()
						.getBceFrameValue(businessId, BceUtil.getMap(req));
				if (soFrameValue == null) {
					throw new Exception("No bce_frame.business_id:"
							+ businessId);
				}
				bceFrameId = soFrameValue.getBceFrameId();
			}
			AbstractTemplateString sb = new TemplateStringForFrameJs();
			sb.setDy(true);
			sb.setRequest(req);
			writer.append(sb.dispalayString(bceFrameId));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * 根据页面id获取关联的rowset信息,writer到页面上
	 * 
	 * @param req
	 * @param writer
	 * @throws Exception
	 */
	public static void writePageRowsets(PageContext pageContext,
			HttpServletRequest req, Writer writer) throws Exception {
		try {
			long pageFramePageId = HttpUtil
					.getAsLong(req, "PAGE_FRAME_PAGE_ID");
			if (pageFramePageId > 0) {
				IBceRowsetValue[] pageRowSets = BceServiceFactory
						.getBceFrameSV().getPageRowsets(pageFramePageId);
				if (pageRowSets != null) {
					for (int j = 0; j < pageRowSets.length; j++) {
						long rowSetId = pageRowSets[j].getRowsetId();
						long rowSetType = pageRowSets[j].getRowsetType();
						String rowSetKey = pageRowSets[j].getRowsetKey();
						String rowSetMethod = pageRowSets[j].getRowsetMethod();
						writePageJs((JspWriter) writer, rowSetId, rowSetType,
								rowSetKey, rowSetMethod, pageFramePageId, j);
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	public static void writePageJs(JspWriter out, long rowSetId,
			long rowSetType, String rowSetKey, String rowSetMethod,
			long pageId, int j) throws Exception {
		out.println("  var objPageSet" + rowSetId + " = new PageRowSet();");
		out.println("  objPageSet" + rowSetId + ".rowSetType = '" + rowSetType
				+ "';");
		out.println("  objPageSet" + rowSetId + ".rowSetKey = '" + rowSetKey
				+ "';");
		out.println("  objPageSet" + rowSetId + ".rowSetMethod = '"
				+ rowSetMethod + "';");
		if (j == 0) {
			out.println("  g_SoFrame_objPageSetsArray['ID_" + pageId
					+ "'] = new PageRowSets();");
		}
		out.println("  g_SoFrame_objPageSetsArray['ID_" + pageId
				+ "'].addPageRowSet(objPageSet" + rowSetId + ");");

	}

	/**
	 * 根据业务操作编号查询关联的rowset和rule信息,writer到页面上
	 * 
	 * @param req
	 * @param writer
	 * @throws Exception
	 */
	public static String writePageInfos(PageContext pageContext,
			HttpServletRequest req, Writer writer) throws Exception {
		try {
			long businessId = HttpUtil.getAsLong(req, BceUtil.BUSIOPER_ID_KEY);
			if (businessId > 0) {
				IBceFrameValue soFrameValue = BceServiceFactory.getBceFrameSV()
						.getBceFrameValue(businessId, BceUtil.getMap(req));
				if (soFrameValue == null) {
					throw new Exception("No bce_frame.business_id:"
							+ businessId);
				}

				IQPageFramePageValue[] soOfferBusipageConfigs = BceServiceFactory
						.getBceFrameSV().getPageFramePages(
								soFrameValue.getBceFrameId(),
								soFrameValue.getPageFrameId());
				if (soOfferBusipageConfigs == null
						|| soOfferBusipageConfigs.length == 0) {
					throw new BceException("BES0000009");
				}
				// 规则
				long rulesetId = soOfferBusipageConfigs[0].getPageRulesetId();
				if (rulesetId > 0) {
					AbstractTemplateString sb = new TemplateStringForJs();
					sb.setDy(true);
					sb.setRequest(req);
					writer.append(sb.dispalayByRusetId(rulesetId));
				}

				// 数据集
				long pageFramePageId = soOfferBusipageConfigs[0]
						.getPageFramePageId();
				IBceRowsetValue[] pageRowSets = BceServiceFactory
						.getBceFrameSV().getPageRowsets(pageFramePageId);
				if (pageRowSets != null) {
					writer.write("<script type=\"text/javascript\">\n");
					writer.write("var pageId = \"ID_" + pageFramePageId
							+ "\";\r\n");
					writer.write("var g_SoFrame_objPageSetsArray = new Array();");

					for (int j = 0; j < pageRowSets.length; j++) {
						long rowSetId = pageRowSets[j].getRowsetId();
						long rowSetType = pageRowSets[j].getRowsetType();
						String rowSetKey = pageRowSets[j].getRowsetKey();
						String rowSetMethod = pageRowSets[j].getRowsetMethod();
						writePageJs((JspWriter) writer, rowSetId, rowSetType,
								rowSetKey, rowSetMethod, pageFramePageId, j);
					}
					writer.write("</script>");
				}
				String pageUrl = soOfferBusipageConfigs[0].getPageUrl();
				if (pageUrl.indexOf("?") > 0)
					pageUrl = pageUrl + "&";
				else
					pageUrl = pageUrl + "?";
				return pageUrl + BceUtil.BUSIOPER_ID_KEY + "=" + businessId
						+ "&" + BceUtil.BCE_FRAME_ID_KEY + "="
						+ soFrameValue.getBceFrameId();
			}
			return "";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	public static IBceRuleReturnData isBusiCanDo(HttpServletRequest req)
	throws Exception {
		Map paramMap = BceUtil.getMap(req);
		String strBceFrameId = (String) paramMap.get(BceUtil.BCE_FRAME_ID_KEY);
		long bceFrameId = -1;
		if (StringUtils.isNotBlank(strBceFrameId)) {
			bceFrameId = Long.parseLong(strBceFrameId);
		}
		String strBusinessId = (String) paramMap.get(BceUtil.BUSIOPER_ID_KEY);
		long businessId = -1;
		if (StringUtils.isNotBlank(strBusinessId)) {
			businessId = Long.parseLong(strBusinessId);
		}
		if (bceFrameId <= 0) {
			// 查询受理框架
			IBceFrameValue aBceFrame = BceServiceFactory.getBceFrameSV()
			.getBceFrameValue(businessId, paramMap);
			if (aBceFrame == null) {
				throw new BceException("BES0000418");
			} else {
				bceFrameId = aBceFrame.getBceFrameId();
			}
		}
		BceSVUtil.setDoCenter(false);
		IBceRuleReturnData returnData = null;
		if (BceSVUtil.checkIsCrossing(bceFrameId, paramMap,
				BceUtil.JAVA_RULE_SET_TYPE_NORMAL))
			returnData = BceServiceFactory.getCrossRuleEngine().isBusiCanDo(
					bceFrameId, businessId, paramMap, paramMap);
		else
			returnData = BceServiceFactory.getRuleEngine().isBusiCanDo(
					bceFrameId, businessId, paramMap, paramMap);
		return returnData;
	}

	public void getWarnNingContent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		try {
			long bceFrameID = HttpUtil.getAsLong(request,
					BceUtil.BCE_FRAME_ID_KEY);
			String businessId = HttpUtil.getAsString(request, "BUSINESS_ID");
			String changeName = HttpUtil.getAsString(request, "CHANGE_NAME");
			String changeValue = HttpUtil.getAsString(request, "CHANGE_VALUE");
			String content = PrintUtil.getWarnContent(bceFrameID, businessId,
					changeName, changeValue);
			cp.set("CONTENT", content);
			cp.set("FALG", "Y");

		} catch (Exception e) {
			log.error("is Error :", e);
			cp.set("FALG", "N");
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	/**
	 * 清数据缓存
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void clearCache(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BceCommonStore.clearSessionByKey(BceUtil.BCE_COSTOMER_ORDER_CACHE_KEY);
	}
//
//	public void saveOrderInfo(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		CustomProperty cp = CustomProperty.getInstance();
//		try{
//		String orderId = HttpUtil.getAsString(request, "orderid");
//		String templateId_S = HttpUtil.getAsString(request, "templateId");
//		long templateId = HttpUtil.getAsLong(request, "templateId");
//		long businessId = HttpUtil.getAsLong(request, BceUtil.BUSIOPER_ID_KEY);
//		String billId = HttpUtil.getAsString(request, "BillId");
//		String printType = HttpUtil.getAsString(request, "printType");
//		String checkFlag = "0";
//		String userRegionId =null;
//		IInstanceQrySV insQrySV = null;
//		UserInfoInterface user = SessionManager.getUser();
//		String opUserRegionId = String.valueOf(user.get("REGION_ID")); 
//		if(!StringUtils.isEmpty(billId))
//		{
//			   userRegionId = CenterUtil.getRegionIdByBillId(billId);
//			   if(!opUserRegionId.equals(userRegionId)){
//				   insQrySV=(IInstanceQrySV)ServiceFactory.getCrossCenterService(IInstanceQrySV.class);
//			   } else {
//				   insQrySV=(IInstanceQrySV)ServiceFactory.getService(IInstanceQrySV.class);
//			   }
//		}else{
//			insQrySV=(IInstanceQrySV)ServiceFactory.getService(IInstanceQrySV.class);
//		}
//		long userId = 0;
//		if(!StringUtils.isEmpty(billId)){
//			try{
//				IInsUserValue insUserVal = insQrySV.getInstUserByBillId(billId);
//				if(null !=insUserVal){
//					userId = insUserVal.getUserId();
//				}
//			}catch(NullPointerException e){
//				//对宽带开户这种异步工单做处理 屏蔽该种情况
//				userId =0;
//			}
//		}
//		String conString = HttpUtil.getStringFromBufferedReader(request);
//		boolean isCrossCenter = false;
//		if(!StringUtils.isEmpty(billId) && !opUserRegionId.equals(userRegionId))  {
//			isCrossCenter = true;
//		} else {
//			isCrossCenter = false;
//		}
//		String printId = this.getPrintId(conString);
//		if(!StringUtils.isEmpty(printId)){
//			//查询稽核标识
//			checkFlag = getCheckFlag(opUserRegionId, billId, isCrossCenter, printId, checkFlag);
//		}
//		if(isCrossCenter){
//			com.ai.appframe2.complex.center.CenterFactory.setCenterInfoByTypeAndValue("BillId", String
//					.valueOf(billId));
//		}else{
//			BceSVUtil.setDoCenter(false);
//		}
//		ISoBusiPrintInfoSV printInfoSV = (ISoBusiPrintInfoSV) ServiceFactory
//				.getService(ISoBusiPrintInfoSV.class);
//		printInfoSV.savePrintInfo(orderId, templateId, conString, businessId,userId,printType,billId,checkFlag);
//		cp.set("IS_SAVED", "true");
//		}catch (Exception e) {
//			CustomProperty cpTmp = dealOracleSaveTooMuchData(e);
//			String isTooMuchData = getOracleExpFlag(cpTmp);
//			log.error("is Error :", e);
//			cp.set("IS_SAVED", "false");
//			cp.set("isTooMuchData", isTooMuchData);
//		}finally {
//				HttpUtil.showInfo(response, cp);
//		}
//	}
	
	/**
	 * 查询获取稽核标识
	 * @param opUserRegionId
	 * @param billId
	 * @param isCrossCenter
	 * @param printId
	 * @param checkFlag
	 * @return
	 * @throws Exception
	 */
//	private String getCheckFlag(String opUserRegionId,String billId,boolean isCrossCenter,String printId,String checkFlag) throws Exception{
//		String regionId = opUserRegionId;
//		ISoBusiPrintSV printSV = null;
//		if(isCrossCenter){
//				regionId = CenterUtil.getRegionIdByBillId(billId);
//				printSV = (ISoBusiPrintSV) ServiceFactory
//				.getCrossCenterService(ISoBusiPrintSV.class);
//		}else{
//			printSV = (ISoBusiPrintSV) ServiceFactory
//			.getService(ISoBusiPrintSV.class);
//		}
//		Timestamp curTime = TimeUtil.getPrimaryDataSourceSysDate();
//		CenterFactory.pushCenterInfo(CenterUtil.REGION_ID, regionId);
//		IBOSoBusiPrintValue[] ivalue = printSV.getBusiPrintByPrintId(printId, curTime, regionId);
//		CenterFactory.popCenterInfo();
//		boolean setCheckFlag=false;
//		if(null!=ivalue){
//			String checkFlagVal = null;
//			for(int i=0;i<ivalue.length;i++){
//				checkFlagVal = ivalue[i].getCheckFlag();
//				if("1".equals(checkFlagVal)){
//					checkFlag = "1";
//					break;
//				}
//			}
//		}
//		return checkFlag;
//	}
	
	private String getPrintId(String conString) throws Exception{
		int flag =  conString.indexOf("\"PRINT_ID\":\"");
		int startIndex =0;
		int endIndex=0;
		String infoSino="";
		if(flag!=-1){
			flag = flag+"PRINT_ID".length();
			startIndex =flag+4;
			endIndex = startIndex+19;
			String printId = conString.substring(startIndex, endIndex);
			return printId;
		}
		return "";
	}
	
	public void template2Svg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/xml; charset=utf-8");
		String templateIDStr = HttpUtil.getParameter(request, "template_id");
		long templateId = 0;
		if (templateIDStr != null && templateIDStr.length() > 0
				&& !"null".equals(templateIDStr)) {
			templateId = Long.parseLong(templateIDStr);
		}
		String taskTag = HttpUtil.getParameter(request, "task_tag");
		IWorkflowConsoleSV aWorkflowConsoleSV = (IWorkflowConsoleSV) ServiceFactory
				.getService(IWorkflowConsoleSV.class);
		response.getWriter().print(
				aWorkflowConsoleSV.toSvg(templateId, taskTag));
	}

	/**
	 * 生成IbceData
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void useGenData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IBceDealReturnData returnData = new BceDealReturnDataBean();
		CustomProperty cp = CustomProperty.getInstance();
		try {
			Map paramMap = BceUtil.getMap(request);
			long beFrameId = HttpUtil.getAsLong(request,
					BceUtil.BCE_FRAME_ID_KEY);
			boolean us = true;
			/**
			 * 打印数据
			 */
			String[][] str = new String[2][2];
			String isPrint = HttpUtil.getAsString(request, "isPrint");
			BceSVUtil.SetCrossing(request);
			BceSVUtil.setDoCenter(false);
			IBceData bceData = (IBceData) BceCommonStore
					.getObjectFromSessionByKey(BceUtil.BCE_COSTOMER_ORDER_CACHE_KEY);
			IBceFrameValue beFrame = BceServiceFactory.getBceFrameSV()
					.getBceFrameValue(beFrameId);
			String key = HttpUtil.getAsString(request, "myrandom");
			String sessionKey = (String) BceCommonStore
					.getObjectFromSessionByKey(BceUtil.BCE_COSTOMER_TRANSATION_RADOM);
			/**
			 * 判断是否在打印合并列表中
			 */
			//boolean us = BusiPrintInvoke.isInMergedTemplateIds(beFrame);
			if (bceData == null || !StringUtils.equals(key, sessionKey)) {
				// 清除SessionKey信息
				BceCommonStore
						.clearSessionByKey(BceUtil.BCE_COSTOMER_ORDER_CACHE_KEY);
				BceCommonStore.putObjectToSession(
						BceUtil.BCE_COSTOMER_TRANSATION_RADOM, key);
				ISubmitData[] objSubmitDatas = SubmitDataXmlParseUtil
						.parseSubmitData(request);

				// 使用受理框架配的解析类
				// 需要实现接口：com.ai.bce.service.interfaces.IBceDataParser
				String parserName = beFrame.getDataParser();
				if (StringUtils.isBlank(parserName)) {
					parserName = "com.ai.bce.service.impl.BceDataParserImpl";
				}

				IBceDataParser parser = (IBceDataParser) ClassLoaderUtil
						.loadClass(parserName).newInstance();
				bceData = parser.dataParse(objSubmitDatas, paramMap);
				bceData.setSessionId(request.getSession().getId());
				bceData.setBceFrameId(beFrameId);
				BceCommonStore.putObjectToSession(
						BceUtil.BCE_COSTOMER_ORDER_CACHE_KEY, bceData);
			}
			String orderId = HttpUtil.getAsString(request, "COUSTOM_ORDER_ID");
			if (StringUtils.isBlank(orderId)) {
				if (log.isDebugEnabled()) {
					log.debug(LocaleResourceFactory.getResource("BES0000836"));
				}
				orderId = BceServiceFactory.getBceFrameSV()
						.getCoustomOrderCode(beFrame.getDealService());
			}
			//if(!us){
			if (us) {
				//如果不在合并列表中才走单独的
				str[0][0] = "IS_SUCCESS";
				str[0][1] = "BCE_QR";
				str[1][0] = "COUSTOM_ORDER_ID";
				str[1][1] = String.valueOf(orderId);
			}
			returnData.setCustomProperty(str);
			// 将ReturnData 数据回写至CustomProperty
		} finally {
			setCustomProperty(cp, returnData);//
			HttpUtil.showInfo(response, cp);
		}
	}

	 private static String getOracleExpFlag(CustomProperty cp) throws Exception{
    	 String isTooMuchData=null;
    	 if(null==cp){
    		 isTooMuchData="N";
    	 }
    	 isTooMuchData = cp.get("DATA_TOO_MUCH");
    	 if(StringUtils.isEmpty(isTooMuchData)){
    		 isTooMuchData="N";
    	 }
    	 return isTooMuchData;
     }
     
     private static CustomProperty dealOracleSaveTooMuchData(Exception e) throws Exception{
    	 CustomProperty cp = CustomProperty.getInstance();
    	 if(e instanceof SQLException){
				String errInfo = e.getMessage();
				int endCodeIndex = errInfo.indexOf(":");
				String oracleErrCode = errInfo.substring(0, endCodeIndex);
				if("ORA-01461".equals(oracleErrCode)){
					//oralce中当字符过大会将字符指的是varchar2类型的转换为Long来处理 故抛：ORA-01461: 仅能绑定要插入 LONG 列的 LONG 值
					cp.set("DATA_TOO_MUCH", "Y");
				}else if("ORA-01462".equals(oracleErrCode)){
					cp.set("DATA_TOO_MUCH", "Y");
				}else{
					throw e;
				}
			}
    	 return cp;
     }
}
