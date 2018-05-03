package com.ai.bce.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.DataType;
import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.bce.ivalues.IBceRuleReturnData;
import com.ai.bce.ivalues.IBceRuleValue;
import com.ai.bce.util.BceCommonStore;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceSVUtil;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.util.ReflectUtils;

/**
 * 提供给CRM前台应用和后台规则交互基础实现类 Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: BceRuleForJsAction.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Nov 11, 2010 4:27:07 PM
 */
public class BceRuleForJsAction extends BaseAction {
	private static transient Log log = LogFactory.getLog(BceFrameAction.class);
	private static String RULE_ID_PARAM = "ruleid";
	public void checkRule(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType(HttpUtil.HTML_CONTENT_TYPE);
		CustomProperty cp = CustomProperty.getInstance();
		long ruleId = HttpUtil.getAsLong(request, RULE_ID_PARAM);
		//add by zhangx 20111107
		int i_transPrtType = HttpUtil.getAsInt(request, "isXml");//前台数据传到后台的方式
		Map paramMap = null;
        if(i_transPrtType == 1) {
        	String strXmlCtnt = HttpUtil.getStringFromBufferedReader(request);//通过xml报文传送过来 mod by zhangx 20111107
        	paramMap = new HashMap();
        	if (strXmlCtnt != null && !"".equals(strXmlCtnt)) {
	        	String[] xmlCtnts = strXmlCtnt.split("&");
	        	if (xmlCtnts != null && xmlCtnts.length != 0) {
		        	for (int i = 0; i < xmlCtnts.length; i++) {
		        		paramMap.put(xmlCtnts[i].substring(0, xmlCtnts[i].indexOf("=")), xmlCtnts[i].substring((xmlCtnts[i].indexOf("=")+1)));
					}
	        	}
        	}
        }
        //end
        	
		try {
			// 获取CheckRule
			IBceRuleValue bceRuleBean = BceServiceFactory.getBceFrameSV()
					.getBceRule(ruleId);
			String[] parS = StringUtils.split(bceRuleBean.getParamList(), ",");
			String[] values = new String[parS.length];
			Class[] paramClass = new Class[parS.length];
			Object[] params = new Object[parS.length];
			for (int i = 0; i < paramClass.length; i++) {
				//mod by zhangx 20111107
				if(i_transPrtType == 1) {
					values[i] = (paramMap.get("param_" + i) == null)?null:(String)paramMap.get("param_" + i);
				} else {

				    values[i] = HttpUtil.getParameter(request, "param_" + i);
				}
				//end
				paramClass[i] = DataType.getJavaClass(parS[i]);
				params[i] = DataType.transfer(values[i], paramClass[i]);
			}
			if (StringUtils.equals(bceRuleBean.getCenterType(),
					ReflectUtils.BCE_IS_CROSS_SERVICE)
					&& StringUtils.equals(ReflectUtils.BCE_CROSS_SERVICE_Y,
							bceRuleBean.getCenterValueIndex())) {
				if (log.isDebugEnabled()) {
					log.debug(LocaleResourceFactory.getResource("BES0000848"));
				}
				// 设置中心
				BceSVUtil.setDoCenter(false);
				if (log.isDebugEnabled()) {
					log.debug("[注意] 当前规则使用跨中心服务,规则ID:" + ruleId);
				}
				BceSVUtil.SetCrossing();
			} else if (StringUtils.isNotBlank(bceRuleBean.getCenterType())) {

				if (log.isDebugEnabled()) {
					log.debug(LocaleResourceFactory.getResource("BES0000851",
							new String[] { bceRuleBean.getCenterType() }));
				}
				if (!StringUtils.isNumeric(bceRuleBean.getCenterValueIndex())) {
					if (log.isErrorEnabled()) {
						log.error(LocaleResourceFactory.getResource(
								"BES0000850", new String[] { String
										.valueOf(ruleId) }));
					}
					BceException.throwException("BES0000850",
							new String[] { String.valueOf(ruleId) });
				}
				int index = Integer.valueOf(bceRuleBean.getCenterValueIndex())
						.intValue();
				if (index >= paramClass.length) {
					if (log.isErrorEnabled()) {
						log.error(LocaleResourceFactory.getResource(
								"BES0000848", new String[] { String
										.valueOf(ruleId) }));
					}
					BceException.throwException("BES0000848",
							new String[] { String.valueOf(ruleId) });
				}
				String value = values[index];
				CenterFactory.setCenterInfoByTypeAndValue(bceRuleBean
						.getCenterType(), value);

			} else {
				if (log.isDebugEnabled()) {
					log.debug(LocaleResourceFactory.getResource("BES0000848"));
				}
			}

			BceSVUtil.setDoCenter(false);

			IBceRuleReturnData checkRuleBean = (IBceRuleReturnData) ReflectUtils
					.methodInvoke(bceRuleBean.getFileName(), bceRuleBean
							.getFuncName(), paramClass, params, null);
			// 设置信息
			String retVal = "Y";
			if (checkRuleBean.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_NO) {
				retVal = "N";
			}
			String retMsg = "";
			if (checkRuleBean.getMsg() != null) {
				retMsg = checkRuleBean.getMsg();
			}
			cp.set("retVal", retVal);
			cp.set("retMsg", retMsg);
			//
		} catch (Exception e) {
			log.error(e.getCause().getMessage(), e);
			cp.set("retVal", "N");
			cp.set("retMsg", LocaleResourceFactory.getResource("BES0000416")
					+ "(rule_id=" + ruleId + "):" + (e.getCause()!=null?e.getCause().getMessage():e.getMessage()));
		} finally {
			HttpUtil.showInfo(response, cp);
			// iq
			BceCommonStore.clearThread();
		}
	}
}
