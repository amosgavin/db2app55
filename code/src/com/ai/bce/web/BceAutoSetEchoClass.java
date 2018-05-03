/***********************************************************************
 * Module:       BceAutoSetEchoClass.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Nov 18, 2010
 ***********************************************************************/

package com.ai.bce.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.set.FieldTypeSetDB;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.tag.FieldItemInterface;
import com.ai.appframe2.web.tag.IDBAutoFormEchoClass;
import com.ai.bce.ivalues.IBceFormGroupValue;
import com.ai.bce.ivalues.IBceRuleValue;
import com.ai.bce.ivalues.IQBceBusinessAttrValue;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.valuebean.BceAttrGroupBean;

public class BceAutoSetEchoClass implements IDBAutoFormEchoClass{
	private static final String FIELD_ITEM_LIST = "fieldItemList";
	private static final String FORM_ID = "formId";
	private static final String GROUP_MAP = "groupMap";
	
	public void invokeDBAutoFormEchoMethod(PageContext pPageContext,VelocityContext pVelocityContext, FieldTypeSetDB pFieldTypeSetDB) throws Exception {
		ServletRequest req = pPageContext.getRequest();
		long bceFrameId = HttpUtil.getAsLong(req, BceUtil.BCE_FRAME_ID_KEY);
		String formId = (String)pVelocityContext.get(FORM_ID);
		Map fieldItemMap = (Map)pVelocityContext.get(FIELD_ITEM_LIST);		
		List hideFieldList = (List)req.getAttribute(BceUtil.HIDE_FIELD_LIST);
		IQBceBusinessAttrValue[] attrs = (IQBceBusinessAttrValue[])req.getAttribute("BUSI_ATTRS");
		//国际化
		pVelocityContext.put("LocaleFunction",LocaleResourceFactory.class.newInstance());
		
		//设置隐藏字段
		setHideField(fieldItemMap, hideFieldList, attrs);
		
		//设置扩展信息
		setExtInfo(bceFrameId,formId,fieldItemMap,attrs,pPageContext,pVelocityContext);
		
		//设置分组
		dealGroup(bceFrameId,formId,fieldItemMap,attrs,pPageContext,pVelocityContext);
		
		//字段校验及分组
		setFieldValidation(formId, attrs, pVelocityContext);
	}
	
	protected void setExtInfo(long bceFrameId,String formId,Map fieldItemMap,IQBceBusinessAttrValue[] attrs,PageContext pPageContext,VelocityContext pVelocityContext)throws Exception{
		
	}
	
	protected void setHideField(Map fieldItemMap,List hideFieldList,IQBceBusinessAttrValue[] attrs)throws Exception{
		Set fieldNameSet = fieldItemMap.keySet();		
		for(Iterator it=fieldNameSet.iterator();it.hasNext();){
			String fieldName = (String)it.next();
			
			FieldItemInterface fieldItem = (FieldItemInterface)fieldItemMap.get(fieldName);
			
			if(hideFieldList != null && hideFieldList.contains(fieldName)){
				fieldItem.setVisible(false);
			}
			for(int k=0;k<attrs.length;k++){
				if(fieldName.equals(attrs[k].getAttrCode())){
					if(StringUtils.isNotBlank(attrs[k].getFieldWidth())){
						fieldItem.setWidth(attrs[k].getFieldWidth());
					}
					if(StringUtils.isNotBlank(attrs[k].getFieldHeight())){
						fieldItem.setHeight(attrs[k].getFieldHeight());
					}
					if(attrs[k].getColSpan()!=0){
						fieldItem.setColSpan((int)attrs[k].getColSpan());
					}
					
					break;
				}
			}
		}
	}
	
	protected void dealGroup(long bceFrameId,String formId,Map fieldItemMap,IQBceBusinessAttrValue[] attrs,PageContext pPageContext,VelocityContext pVelocityContext)throws Exception{
		IBceFormGroupValue[] groups = BceServiceFactory.getBceFrameSV().getBceFormGroup(bceFrameId, formId);
		if(groups == null || groups.length == 0){
			pVelocityContext.put(GROUP_MAP,"null");
			return;
		}
		
		Map tmpMap = new LinkedHashMap();
		
		for(int i=0;i<attrs.length;i++){
			FieldItemInterface fieldItem = (FieldItemInterface)fieldItemMap.get(attrs[i].getAttrCode());
			if(fieldItem == null)
				continue;
			
			long groupId = attrs[i].getGroupId();
			BceAttrGroupBean groupBean = (BceAttrGroupBean)tmpMap.get(new Long(groupId));
			if(groupBean == null){
				groupBean = new BceAttrGroupBean();
				groupBean.setId(groupId);
				groupBean.setVisiable(false);
				for(int j=0;j<groups.length;j++){
					if(groupId == groups[j].getGroupId()){
						groupBean.setVisiable(true);
						groupBean.setTitle(groups[j].getGroupName()==null?"":groups[j].getGroupName());
					  groupBean.setGroupStyle(groups[j].getGroupStyle()==null?"":groups[j].getGroupStyle());
						groupBean.setAllowStract(groups[j].getIsAllowStract()==1?true:false);
						groupBean.setFrameClosed(groups[j].getIsClosed()==1?true:false);
						groupBean.setAttr1(groups[j].getAttr1()==null?"":groups[j].getAttr1());
						groupBean.setAttr1(groups[j].getAttr2()==null?"":groups[j].getAttr2());
						groupBean.setAttr1(groups[j].getAttr3()==null?"":groups[j].getAttr3());
						groupBean.setAttr1(groups[j].getAttr4()==null?"":groups[j].getAttr4());
						groupBean.setAttr1(groups[j].getAttr5()==null?"":groups[j].getAttr5());
						break;
					}
				}
				tmpMap.put(new Long(groupId), groupBean);
			}
			if(fieldItem.isVisible()){
				groupBean.addVisiableCount();
			}
			groupBean.addField(fieldItem);
		}
		//调整顺序
		Map groupMap = new LinkedHashMap();
		for(int i=0;i<groups.length;i++){
			Long key = new Long(groups[i].getGroupId());
			Object obj = tmpMap.get(key);
			if(obj != null){
				groupMap.put(key, obj);
				tmpMap.remove(key);
			}
		}
		groupMap.putAll(tmpMap);
		pVelocityContext.put(GROUP_MAP,groupMap);
		pVelocityContext.put("context", SessionManager.getContextName());
	}
	
	protected void setFieldValidation(String formId,IQBceBusinessAttrValue[] attrs,VelocityContext pVelocityContext)throws Exception{
		StringBuffer valueChangeFunc = new StringBuffer();
		StringBuffer includeFile = new StringBuffer();
		StringBuffer validFunc = new StringBuffer();
		String formManager = "g_FormRowSetManager.get(\""+formId+"\")";
		for(int i=0;i<attrs.length;i++){
			String ruleIds  = attrs[i].getRuleId();
			if(attrs[i].getIsValidate() == 1 && StringUtils.isNotBlank(ruleIds)){
				String[] ruleIdes  = StringUtils.split(ruleIds, ","); 
				validFunc.append(getValueChangeFunc(formManager,attrs[i].getAttrCode(),attrs[i].getAttrName(),ruleIdes,includeFile));
			}
		}
		
		if(includeFile.length() > 0){
			valueChangeFunc.append(includeFile);
		}
		
		valueChangeFunc.append("<script language=\"javascript\">\n");
		
		if(validFunc.length() > 0){
			valueChangeFunc.append("function change"+formId+"(col,oldValue,newValue,dbformpk){");
			valueChangeFunc.append(validFunc.toString());
			valueChangeFunc.append("}\r\n");
			valueChangeFunc.append("g_AIEvent.registerDBForm(\""+formId+"\"")
			            .append(",\"\",\"onvaluechange\",\"change"+formId+"\",\"\",0);\r\n");
		}
				
		validFunc = new StringBuffer();
		String notNullFields = "";
		for(int i=0;i<attrs.length;i++){
			if(attrs[i].getIsNullable() == 0){
				notNullFields += ","+attrs[i].getAttrCode();
			}
		}
		if(StringUtils.isNotBlank(notNullFields)){
			String tmp = "if(g_FormFieldIsNull(" + formManager + ",\"" + notNullFields.substring(1) + "\") == true){\r\n"
		             + "  return false;\r\n}\r\n";
			validFunc.insert(0,tmp);
		}
		if(validFunc.length() != 0){
			valueChangeFunc.append("function " + formId + "Validate(){\r\n");
			valueChangeFunc.append(validFunc);
			valueChangeFunc.append("return true;}\r\n");
		}
		valueChangeFunc.append("</script>");
		pVelocityContext.put("fieldVliadation", valueChangeFunc.toString());
	}
	
	private String getValueChangeFunc(String formManager,String fieldName,String title,String[] ruleIds,StringBuffer includeFile)throws Exception{
		String func = "";
		func += " if(col == \"" + fieldName + "\"){\r\n var vResult = true;\r\n";
		/*if(StringUtils.isNotBlank(validation)){
			String[] valids = StringUtils.split(validation,",");
			for(int i=0;i<valids.length;i++){
				func += "  if(vResult == true && " + getValidteFuncName(Integer.parseInt(valids[i])) + "(newValue) == false){\r\n"
				      + "  alert(\""+title+" 输入有误!\"); vResult = false;}\r\n";
			}
		}*/
		Map commonMap = new HashMap();
		//运行常量
		commonMap.put("TITLE", title);
		//增加运行常量结束
		for (int i = 0; i < ruleIds.length; i++) {
			String s_ruleId = ruleIds[i];
			if(StringUtils.isBlank(s_ruleId)) continue;
			if(!StringUtils.isNumeric(s_ruleId)) throw new BceException("BES0000409",new Object[]{s_ruleId});
			long ruleId = Long.valueOf(s_ruleId).longValue();
			if(ruleId > 0){
				IBceRuleValue rule = BceServiceFactory.getBceFrameSV().getBceRule(ruleId);
				if(rule == null){
					throw new BceException("BES0000410",new Object[]{new Long(ruleId)});
				}
				if(includeFile.indexOf(rule.getFileName())<0){
					String contextPath = SessionManager.getContextName();
					includeFile.append("<script language=\"javascript\" src=\"" 
						   + contextPath + rule.getFileName() + "\" type=\"text/javascript\"></script>\n");
				}
				String warnString = "";
				String alertMsg = getMessage(rule.getAlertMessage(),commonMap);
				if(StringUtils.isNotBlank(alertMsg)){
					warnString = "alert("+alertMsg+");" ;
				}
				func += "if(vResult == true && " + rule.getFuncName() + "(newValue,oldValue,col,dbformpk) == false){"+warnString+"vResult = false;}\r\n";
			}
		}
		func += "if(vResult == false){\r\n"
			    + formManager + ".setValue(\"" + fieldName + "\",\"\",\"\",false);\r\n"
			    + formManager + ".setFocus(\"" + fieldName + "\");\r\n}\r\n";
		func += "return vResult;}\r\n";
		return func;
	}

	private String getMessage(String alertMessage, Map commonMap) {
		if(StringUtils.isBlank(alertMessage))
			return null;
		// TODO Auto-generated method stub
		Set keys  = commonMap.keySet();
		Iterator iterato = keys.iterator();
		while (iterato.hasNext()) {
			String key  = (String) iterato.next();
			String value = (String) commonMap.get(key);
			alertMessage = 	StringUtils.replace(alertMessage, "${"+key+"}",value );
		}
		//增加处理单元（如确实存在${}格式相关字符，请使用$\{}格式使用，以防被格式化）
		alertMessage = 	"\""+StringUtils.replace(alertMessage, "\\{","{" )+"\"";
		return alertMessage;
	}

/*	private static IBceValidateFuncValue[] validateFuncs = null;
	
	private String getValidteFuncName(int index)throws Exception{
		if(validateFuncs == null){
			validateFuncs = BceServiceFactory.getBceFrameSV().getValidateFuncs();
		}
		for(int i=0;i<validateFuncs.length;i++){
			if(validateFuncs[i].getFuncId() == index){
				return validateFuncs[i].getFuncName();
			}
		}
		throw new Exception("没有func_id为"+index+"的方法，请检查配置!");
	}*/
}
