package com.ai.bce.web;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.ai.appframe2.web.HttpUtil;
import com.ai.bce.ivalues.IBceFramePageRoleValue;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;
import com.ai.bce.util.BceException;

public class EventRuleProcessHelper {
	
	
	 public static final String REQ_SO_RULE_DATA_KEY = "SO_RULE_DATA_ATTRIBUTE_KEY";
	    //1-��ʼ��У��
	    public static final int RULE_TYPE_INIT = 1;
	    //2-�ύʱУ��
	    public static final int RULE_TYPE_SUBMIT = 2;
	    //3-�¼�����
	    public static final int RULE_TYPE_EVENT = 3;	    
	    //4-dbform�ֶε���ҳ�������ȡ��
	    public static final int RULE_TYPE_GET_URL_PARAM = 4;

	    public static final int EVENT_TYPE_DBFORM = 1;

	    public static final int EVENT_TYPE_DBGRID = 2;

	    public static final int EVENT_TYPE_NORMAL = 3;

	    public static final int EVENT_TYPE_WINDOWLOAD = 4;
	    
	    private static HashMap scriptMap = new HashMap();
	    
    
    /**
     * ����ҳ������,ת��Ϊҳ��js����ű�.
     *
     * @param writer
     * @param ruleValues
     * @param SoSessionDataMap
     * @throws Exception
     */
    public static void writerRuleToPage(PageContext pageContext,HttpServletRequest req,Writer writer, IQBceRulesetRuleValue[] ruleValues, Map SoSessionDataMap) throws Exception {
    	String ROLE_MACRO_STR="$PAGE_ROLE_ID";
    	//ҳ������д�request�л�ȡ�����Ķ��巽ʽ��$REQUEST.CUSTOMER_ID
    	String MACRO_REQUEST="$REQUEST";
    	if (ruleValues != null && ruleValues.length > 0) {
            VelocityContext context = new VelocityContext();
            context.put("SoSessionData", SoSessionDataMap);
            StringBuffer strBuff = new StringBuffer();
            StringBuffer eventBuff = new StringBuffer();
            StringBuffer onloadEventBuff = new StringBuffer();
            StringBuffer submitRuleBuff=new StringBuffer();
            for (int i = 0; i < ruleValues.length; i++) {
            	//����JS�ļ�            	
            	String includeFileStr=writeJsFile(pageContext,req.getContextPath(),ruleValues[i].getFileName());
            	if(StringUtils.isNotBlank(includeFileStr)){
            		strBuff.append(includeFileStr);
            	}
            	if(StringUtils.isBlank(ruleValues[i].getFileName())||
            			StringUtils.isBlank(ruleValues[i].getFuncName())){
            		continue;
            	}
            	
                //��ʼ������ע�ᵽwindows_onload
                if (ruleValues[i].getRuleTriggerType() == RULE_TYPE_INIT) {
                    onloadEventBuff.append("\nwindow.attachEvent(\"onload\",").append("g_AIEventMethod_" + ruleValues[i].getRuleId()).append(");\n");
                    onloadEventBuff.append("  function g_AIEventMethod_").append(ruleValues[i].getRuleId()).append("(){\n");
                    onloadEventBuff.append("     "+ruleValues[i].getFuncName()).append("(");
                    if (StringUtils.isNotBlank(ruleValues[i].getParamValueList())) {
                        String[] paras = StringUtils.split(ruleValues[i].getParamValueList(), ",");
                        String[] paraTypes=StringUtils.split(ruleValues[i].getParamList(), ",");
                        if (paras==null&&paraTypes==null){
                        	
                        }else{
                        	if (paras.length!=paraTypes.length){
                        		//�����ж�����βκ�ҳ����򼯹��������ж����ʵ�ε�������ƥ�䣡
                        		 BceException.throwException("BES0000006");
                        	}
                        }
                        for (int j = 0; j < paras.length; j++) {
                        	String paramValue=paras[j];
                        	if (StringUtils.contains(paramValue, MACRO_REQUEST)){
                        		String[] AryValue=StringUtils.split(paramValue, ".");
                        		if (AryValue.length<2){
                        			//ҳ����򼯹���������ʵ�θ�ʽ�������Ӧ����Ϊ��$REQUEST.CUSTOMER_ID��
                        			throw new BceException("BES0000007");
                        		}
                        		paramValue=(String)req.getParameter(AryValue[1]);
                        		if (StringUtils.isBlank(paramValue)){
                        			paramValue=(String)req.getAttribute(AryValue[1]);
                        		}
                        	}
                            onloadEventBuff.append("\"").append(paramValue).append("\"");
                            if (j < paras.length - 1) {
                                onloadEventBuff.append(",");
                            }
                        }

                    }
                    onloadEventBuff.append("    );\n");
                    onloadEventBuff.append("  }\n");
                }
                //������ύУ�����͵ģ��������ύУ�麯��
                else if (ruleValues[i].getRuleTriggerType() == RULE_TYPE_SUBMIT){
                	submitRuleBuff.append(ruleValues[i].getFuncName())
                	.append("(")
                	.append(ruleValues[i].getParamList() == null ? "" : ruleValues[i].getParamList())
                	.append(")$");
                }
                
                //����Ǻ������͹���,���Ҷ���id,����event���ֶβ�Ϊ��.����Ҫ���¼�.add event bind
                else if (StringUtils.isNotBlank(ruleValues[i].getObjName())
                        && StringUtils.isNotBlank(ruleValues[i].getEventName())
                        && ruleValues[i].getRuleTriggerType() == RULE_TYPE_EVENT) {
                    //������¼�����Ϊnormal,��˵������һ���html�¼�
                    if (ruleValues[i].getEventObjType() == EVENT_TYPE_NORMAL) {
                    	//pSrcName,pEvent,pFunc,pParam
                        eventBuff.append("g_AIEvent.register(\"").append(ruleValues[i].getObjName()).append("\",\"");
                        eventBuff.append(ruleValues[i].getEventName()).append("\",\"");
                        eventBuff.append(ruleValues[i].getFuncName() == null ? "" : ruleValues[i].getFuncName()).append("\",");
                        eventBuff.append(ruleValues[i].getParamValueList() == null ? "" : ruleValues[i].getParamValueList());
                        eventBuff.append(");\n");
                    }else if (ruleValues[i].getEventObjType() == EVENT_TYPE_DBFORM) {
                    	String formId=ruleValues[i].getObjName();
                    	if(StringUtils.contains(formId, ROLE_MACRO_STR)){
                        	long beFrameId=HttpUtil.getAsLong(req, BceUtil.BCE_FRAME_ID_KEY);
                        	long pageFramePageId=HttpUtil.getAsLong(req, BceUtil.PAGE_FRAME_PAGE_ID_KEY);
                        	IBceFramePageRoleValue[] roles= BceServiceFactory.getBceFrameSV().getBceFramePageRoles(beFrameId, pageFramePageId);
                        	if (roles!=null&&roles.length>0) {
                        		for (int j = 0; j < roles.length; j++) {
                        			formId=StringUtils.replace(formId, ROLE_MACRO_STR, String.valueOf(roles[j].getRoleId()));
                                    //pFormId,pFormField,pEvent,pFuncName,pParam
                                    eventBuff.append("g_AIEvent.registerDBForm(\"").append(formId).append("\",");
                                    eventBuff.append("\"").append("\",");
                                    eventBuff.append("\"").append(ruleValues[i].getEventName()).append("\",");
                                    eventBuff.append("\"").append(ruleValues[i].getFuncName()).append("\",");
                                    eventBuff.append("\"").append(ruleValues[i].getParamValueList() == null ? "" : ruleValues[i].getParamValueList()).append("\"");
                                    eventBuff.append(");\n");
								}                        		
							}
                    	}else{
                            //pFormId,pFormField,pEvent,pFuncName,pParam
                            eventBuff.append("g_AIEvent.registerDBForm(\"").append(formId).append("\",");
                            eventBuff.append("\"").append(ruleValues[i].getChildObjName() == null ? "" : ruleValues[i].getChildObjName()).append("\",");
                            eventBuff.append("\"").append(ruleValues[i].getEventName()).append("\",");
                            eventBuff.append("\"").append(ruleValues[i].getFuncName()).append("\",");
                            eventBuff.append("\"").append(ruleValues[i].getParamValueList() == null ? "" : ruleValues[i].getParamValueList()).append("\"");
                            eventBuff.append(");\n");                   		
                    	}
                    }
                }
            }
            
            strBuff.append("<script type=\"text/javascript\">\n");
            
            //����ϵͳ�Լ����¼����¼�
            if (eventBuff.length() > 0) {
                strBuff.append("  function g_AIEvent_initial(){\n");
                strBuff.append("    "+eventBuff);
                strBuff.append("  }\n");
                strBuff.append("\nwindow.attachEvent(\"onload\",g_AIEvent_initial);\n");
            }
            
            //��������Ϊonload���¼�,
            strBuff.append(onloadEventBuff);            
            
            //�ύʱ��У���¼���
            if(submitRuleBuff.length()>0){
            	strBuff.append("  function pageValidatePlugIn(){\n");
            	String[] rules=StringUtils.split(submitRuleBuff.toString(),"$");
            	for (int j = 0; j < rules.length; j++) {
            		strBuff.append("    var r=").append(rules[j]).append(";\n");
            		strBuff.append("    if (r==false) return false;\n");
				}
            	strBuff.append("  }\n");
            }
            strBuff.append("</script>");

            Velocity.evaluate(context, writer, "", strBuff.toString());
        }
    }
    
    public static String writeJsFile(PageContext pageContext,String contextPath,String fileName){
    	String retValue=null;
    	String jsKey = "BEFRAME_RULE_JS_FILE_" + fileName;
        if (StringUtils.isBlank((String) pageContext.getAttribute(jsKey))) {
          String jsStr = null;
          if (scriptMap.containsKey(jsKey) == false) {
            if (jsKey.indexOf(".vbs") > 0) {

              scriptMap.put(jsKey, "<script language=\"vbscript\" src=\"" +
            		  contextPath + fileName +
                            "\" type=\"text/vbscript\"></script>\n");

            }
            else {
              scriptMap.put(jsKey, "<script language=\"javascript\" src=\"" +
            		  contextPath + fileName +
                            "\" type=\"text/javascript\"></script>\n");
            }
          }
          jsStr = (String)scriptMap.get(jsKey);
          pageContext.setAttribute(jsKey, jsStr);
          retValue=jsStr;
        }
        return retValue;
    }
}
