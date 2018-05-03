package com.ai.bce.create.template.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.ai.bce.ivalues.IBceFrameJavaRulesetRelValue;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;
import com.ai.bce.util.BceAutoPageUtil;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;
import com.ai.bce.web.EventRuleProcessHelper;


/**
功能点与前台规则集的关系也配在bce_frame_java_ruleset_rel(改名)中，增加规则集类型（校验点，99 框架前台校验规则）

取到全部规则，按以下逻辑生成js代码输出到框架页面：

////
不按以下逻辑处理了，直接按seq_no的顺序执行
////
按 拒绝，警告 分类排序

首先执行拒绝的规则
	如果配置check_type为全部通过
	  有规则不通过则直接返回跳转至G_RTN_URL页面
	如果配置check_type为允许部分通过
	  有规则通过则留在当前页（是否需要提示未通过的规则信息？）
  
然后执行警告的规则
     有规则不通过，则调用confirm，确定则继续，取消则调转至G_RTN_URL
////

规则返回数组{true/false,""}
 */

public class TemplateStringForFrameJs extends TemplateStringForJs{

	private StringBuffer initFunction = new StringBuffer();
	private StringBuffer submitFunction = new StringBuffer();
	
	public String dispalayString(long bceFrameId) throws Exception {
		Map paramMap = BceUtil.getMap(request);
		//框架关联的JS校验规则
		IBceFrameJavaRulesetRelValue[] ruleSet = BceServiceFactory.getBceFrameSV().getRegistedRuleSet(bceFrameId, BceUtil.RULE_SET_TYPE_FRAME_JS, paramMap);
		if(ruleSet == null || ruleSet.length == 0)
			return "";
		
		for(int i=0;i<ruleSet.length;i++){
		  //查询规则集关联的规则
			IQBceRulesetRuleValue[] rules = BceServiceFactory.getBceFrameSV().getRulesByRulesetId(ruleSet[i].getRulesetId());
      if(rules == null || rules.length == 0)
      	continue;
      
      ruleMap.clear();
      loadRules(rules);      
      
      //不考虑部分通过的情况，处理比较麻烦
      int checkType = BceUtil.RULE_CHECK_TYPE_ALL;//ruleSet[i].getCheckType();
      for (Iterator iterator = ruleMap.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				String[] util = key.split(":");
				if (util[0] == null || util[0].equals("0"))
					throw new BceException("BES0000420");
				dealRules(util, (List) ruleMap.get(key),checkType);
			}
		}
		
    addScriptFile();
    
    tempBuffer.append(BceAutoPageUtil.getTemplateString("JS0000001",new String[] {}));
    tempBuffer.append(BceAutoPageUtil.getTemplateString("JS0000004",
				new String[] {"0", initFunction.toString() }));
    tempBuffer.append(BceAutoPageUtil.getTemplateString("JS0000040",null));
    tempBuffer.append(submitFunction.toString());
    tempBuffer.append(BceAutoPageUtil.getTemplateString("JS0000021",null));
    tempBuffer.append(BceAutoPageUtil.getTemplateString("JS0000003",null));
		
		return tempBuffer.toString();
	}
	
	private void loadRules(IQBceRulesetRuleValue[] pageRulesetRuleBeans)throws Exception {
		for (int i = 0; i < pageRulesetRuleBeans.length; i++) {

			IQBceRulesetRuleValue pageRulesetRuleBean = pageRulesetRuleBeans[i];
			String key = pageRulesetRuleBean.getRuleTriggerType()+""/* + ":"
					+ pageRulesetRuleBean.getVerifyType()*/;
			List rules = (List) ruleMap.get(key);
			if (rules == null) {
				rules = new LinkedList();
			}
			rules.add(pageRulesetRuleBean);
			/**
			 * 增加对filetype类型进行校验
			 */
			if (StringUtils.isNotBlank(pageRulesetRuleBean.getFileName())
					&& pageRulesetRuleBean.getRuleType() == 1)
				files.add(pageRulesetRuleBean.getFileName());
			ruleMap.put(key, rules);
		}
	}

	private void dealRules(String[] util, List rules,int checkType) throws Exception {
		if(rules == null || rules.size() == 0)
			return;
		int verifyType = -1;//Integer.parseInt(util[1]);
		switch (Integer.parseInt(util[0])) {
		// window.onload触发
		case EventRuleProcessHelper.RULE_TYPE_INIT:
			dealInitRules(rules,verifyType,checkType);
			break;
		// 事件触发
		case EventRuleProcessHelper.RULE_TYPE_EVENT:
			//暂不支持事件触发
			break;
		// 提交事件
		case EventRuleProcessHelper.RULE_TYPE_SUBMIT:
			dealSubmitRules(rules,verifyType,checkType);
			break;
		default:
			break;
		}
	}
	
	private void dealInitRules(List rules,int verifyType,int checkType)throws Exception{
		String function = getFunction(rules, verifyType, checkType, "init");
		initFunction.append(function);
	}
	
  private void dealSubmitRules(List rules,int verifyType,int checkType)throws Exception{
  	String function = getFunction(rules, verifyType, checkType, "submit");
  	submitFunction.append(function);  	
	}
  
  private String getFunction(List rules,int verifyType,int checkType,String dealType)throws Exception{
  	String templateW = "JS0000033";
  	String templateR = "JS0000035";
  	if(dealType.equals("submit")){
  		templateW = "JS0000036";
    	templateR = "JS0000037";
  	}
  	String function = "";
		Set varDefineSet = new HashSet();// 防止重复定义
		for (int i = 0; i < rules.size(); i++) {
			IQBceRulesetRuleValue rule = (IQBceRulesetRuleValue) rules.get(i);
			//重置verifyType
			verifyType = (int)rule.getVerifyType();

			//处理参数
			String[] tmpParams = getParames(rule, varDefineSet);
			String params = tmpParams[0];
			String params_value = tmpParams[1];
			String forActionSt = tmpParams[2];
			String func = "";
			
			//封装规则
			switch ((int) rule.getRuleType()) {
			case BceUtil.RULE_TYPE_JS:
				// 拼装方法和参数串(如:functionName(aaa,bbb))
				function += params_value;
				func = BceAutoPageUtil.getTemplateString("JS0000024",
						new String[] { rule.getFuncName(), params });
				
				//事件
				if(rule.getRuleKind() == 2){
					function += func + ";\n";
				}
				//处理警告的规则
				else if(verifyType == BceUtil.RULE_VERIFY_TYPE_WARNING){
					function += BceAutoPageUtil.getTemplateString(templateW,
							new String[] {i+"", func });
				}
				//处理拒绝的规则
				else{
					//允许部分通过
					if(checkType == BceUtil.RULE_CHECK_TYPE_PART){
						function += BceAutoPageUtil.getTemplateString("JS0000034",
								new String[] { func });
					}
					//必须全部通过
					else{
						function += BceAutoPageUtil.getTemplateString(templateR,
								new String[] { func });
					}
				}
				break;
			case BceUtil.RULE_TYPE_JAVA:
				function += params_value;

				//事件
				if(rule.getRuleKind() == 2){
					func = BceAutoPageUtil.getTemplateString("JS0000038",new String[] { forActionSt });
					function += func + ";\n";
				}
				//处理警告的规则
				else if(verifyType == BceUtil.RULE_VERIFY_TYPE_WARNING){
					func = BceAutoPageUtil.getTemplateString("JS0000039",new String[] { forActionSt });
					function += BceAutoPageUtil.getTemplateString(templateW,
							new String[] {i+"", func });
				}
				//处理拒绝的规则
				else{
					func = BceAutoPageUtil.getTemplateString("JS0000038",new String[] { forActionSt });
					//允许部分通过
					if(checkType == BceUtil.RULE_CHECK_TYPE_PART){
						function += BceAutoPageUtil.getTemplateString("JS0000034",
								new String[] { func });
					}
					//必须全部通过
					else{
						function += BceAutoPageUtil.getTemplateString(templateR,
								new String[] { func });
					}
				}
				break;
			}
		}
		return function;
  }
}
