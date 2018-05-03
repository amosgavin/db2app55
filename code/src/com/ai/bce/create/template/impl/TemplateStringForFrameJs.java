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
���ܵ���ǰ̨���򼯵Ĺ�ϵҲ����bce_frame_java_ruleset_rel(����)�У����ӹ������ͣ�У��㣬99 ���ǰ̨У�����

ȡ��ȫ�����򣬰������߼�����js������������ҳ�棺

////
���������߼������ˣ�ֱ�Ӱ�seq_no��˳��ִ��
////
�� �ܾ������� ��������

����ִ�оܾ��Ĺ���
	�������check_typeΪȫ��ͨ��
	  �й���ͨ����ֱ�ӷ�����ת��G_RTN_URLҳ��
	�������check_typeΪ������ͨ��
	  �й���ͨ�������ڵ�ǰҳ���Ƿ���Ҫ��ʾδͨ���Ĺ�����Ϣ����
  
Ȼ��ִ�о���Ĺ���
     �й���ͨ���������confirm��ȷ���������ȡ�����ת��G_RTN_URL
////

���򷵻�����{true/false,""}
 */

public class TemplateStringForFrameJs extends TemplateStringForJs{

	private StringBuffer initFunction = new StringBuffer();
	private StringBuffer submitFunction = new StringBuffer();
	
	public String dispalayString(long bceFrameId) throws Exception {
		Map paramMap = BceUtil.getMap(request);
		//��ܹ�����JSУ�����
		IBceFrameJavaRulesetRelValue[] ruleSet = BceServiceFactory.getBceFrameSV().getRegistedRuleSet(bceFrameId, BceUtil.RULE_SET_TYPE_FRAME_JS, paramMap);
		if(ruleSet == null || ruleSet.length == 0)
			return "";
		
		for(int i=0;i<ruleSet.length;i++){
		  //��ѯ���򼯹����Ĺ���
			IQBceRulesetRuleValue[] rules = BceServiceFactory.getBceFrameSV().getRulesByRulesetId(ruleSet[i].getRulesetId());
      if(rules == null || rules.length == 0)
      	continue;
      
      ruleMap.clear();
      loadRules(rules);      
      
      //�����ǲ���ͨ�������������Ƚ��鷳
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
			 * ���Ӷ�filetype���ͽ���У��
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
		// window.onload����
		case EventRuleProcessHelper.RULE_TYPE_INIT:
			dealInitRules(rules,verifyType,checkType);
			break;
		// �¼�����
		case EventRuleProcessHelper.RULE_TYPE_EVENT:
			//�ݲ�֧���¼�����
			break;
		// �ύ�¼�
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
		Set varDefineSet = new HashSet();// ��ֹ�ظ�����
		for (int i = 0; i < rules.size(); i++) {
			IQBceRulesetRuleValue rule = (IQBceRulesetRuleValue) rules.get(i);
			//����verifyType
			verifyType = (int)rule.getVerifyType();

			//�������
			String[] tmpParams = getParames(rule, varDefineSet);
			String params = tmpParams[0];
			String params_value = tmpParams[1];
			String forActionSt = tmpParams[2];
			String func = "";
			
			//��װ����
			switch ((int) rule.getRuleType()) {
			case BceUtil.RULE_TYPE_JS:
				// ƴװ�����Ͳ�����(��:functionName(aaa,bbb))
				function += params_value;
				func = BceAutoPageUtil.getTemplateString("JS0000024",
						new String[] { rule.getFuncName(), params });
				
				//�¼�
				if(rule.getRuleKind() == 2){
					function += func + ";\n";
				}
				//������Ĺ���
				else if(verifyType == BceUtil.RULE_VERIFY_TYPE_WARNING){
					function += BceAutoPageUtil.getTemplateString(templateW,
							new String[] {i+"", func });
				}
				//����ܾ��Ĺ���
				else{
					//������ͨ��
					if(checkType == BceUtil.RULE_CHECK_TYPE_PART){
						function += BceAutoPageUtil.getTemplateString("JS0000034",
								new String[] { func });
					}
					//����ȫ��ͨ��
					else{
						function += BceAutoPageUtil.getTemplateString(templateR,
								new String[] { func });
					}
				}
				break;
			case BceUtil.RULE_TYPE_JAVA:
				function += params_value;

				//�¼�
				if(rule.getRuleKind() == 2){
					func = BceAutoPageUtil.getTemplateString("JS0000038",new String[] { forActionSt });
					function += func + ";\n";
				}
				//������Ĺ���
				else if(verifyType == BceUtil.RULE_VERIFY_TYPE_WARNING){
					func = BceAutoPageUtil.getTemplateString("JS0000039",new String[] { forActionSt });
					function += BceAutoPageUtil.getTemplateString(templateW,
							new String[] {i+"", func });
				}
				//����ܾ��Ĺ���
				else{
					func = BceAutoPageUtil.getTemplateString("JS0000038",new String[] { forActionSt });
					//������ͨ��
					if(checkType == BceUtil.RULE_CHECK_TYPE_PART){
						function += BceAutoPageUtil.getTemplateString("JS0000034",
								new String[] { func });
					}
					//����ȫ��ͨ��
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
