package com.ai.bce.create.template.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.web.HttpUtil;
import com.ai.bce.create.AbstractTemplateString;
import com.ai.bce.ivalues.IBcePageValue;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;
import com.ai.bce.util.BceAutoPageUtil;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;
import com.ai.bce.web.EventRuleProcessHelper;

/**
 * ʵ��JS���������� Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: TemplateStringForJs.java
 * @Description: ����Ĺ�������
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Nov 8, 2010 8:35:53 PM
 */
public class TemplateStringForJs extends AbstractTemplateString {
	public static transient Log log = LogFactory
			.getLog(TemplateStringForJs.class);
	private List submitRule = new LinkedList();

	public static final String PARAM_EVAL = "$EVAL";

	protected Map ruleMap = new HashMap();
	protected Set files = new HashSet();
	/**
	 * ���ӵ�������
	 */
	private List st_ls = new LinkedList();
	/**
	 * ���������б�
	 */
	private HashMap pubVars = new HashMap();

	// �ļ�
	// �����ķ���

	public String dispalayByRusetId(long ruleSetID) throws Exception {
		// TODO Auto-generated method stub
		return getDisplayBuRuleSetId(ruleSetID);
	}

	public String dispalayString(long pageId) throws Exception {
		// TODO Auto-generated method stub
		//
		IBcePageValue pageBean = BceServiceFactory.getBceFrameSV().getBcePage(
				pageId);
		return getDisplayBuRuleSetId(pageBean.getPageRulesetId());
	}

	private String getDisplayBuRuleSetId(long ruleSetId) throws Exception {
		IQBceRulesetRuleValue[] pageRulesetRuleBeans = BceServiceFactory
				.getBceFrameSV().getRulesByRulesetId(ruleSetId);
		loadRules(pageRulesetRuleBeans);
		addScriptFile();
		this.tempBuffer.append(BceAutoPageUtil.getTemplateString("JS0000001",
				new String[] {}));
		for (Iterator iterator = ruleMap.keySet().iterator(); iterator
				.hasNext();) {
			String o = (String) iterator.next();
			String[] util = o.split(":");
			if (util[0] == null)
				throw new BceException("BES0000420");
			List rules = (List) ruleMap.get(o);
			switchRuleType(util, rules);
		}
		doSubmit();
		this.tempBuffer.append(BceAutoPageUtil.getTemplateString("JS0000003",
				null));

		return this.tempBuffer.toString();
	}

	private void switchRuleType(String[] util, List rules) throws Exception {
		switch (Integer.valueOf(util[0]).intValue()) {
		// ��Ӽ��ش����¼�
		case EventRuleProcessHelper.RULE_TYPE_INIT:
			initRule(rules);
			break;
		// �¼�����
		case EventRuleProcessHelper.RULE_TYPE_EVENT:
			eventRule(rules, util);
			break;
		// �ύ�¼�
		case EventRuleProcessHelper.RULE_TYPE_SUBMIT:
			eventSubmit(rules);
			break;
		default:
			break;
		}
		st_ls.clear();
	}

	private void doSubmit() throws Exception {
		// TODO Auto-generated method stub
		this.tempBuffer.append(BceAutoPageUtil.getTemplateString("JS0000020",
				null));
		this.tempBuffer.append(getFunctionName(submitRule, 0));
		this.tempBuffer.append(BceAutoPageUtil.getTemplateString("JS0000021",
				null));
	}

	/**
	 * ����Rules ��SubmitRule��
	 * 
	 * @param rules
	 * @version: v1.0.0
	 * 
	 */
	private void eventSubmit(List rules) {
		// TODO Auto-generated method stub
		submitRule.addAll(rules);
	}

	/**
	 * ���ҳ������¼�
	 * 
	 * @Function: TemplateStringForJs.java
	 * @Description: �ú����Ĺ�������
	 * 
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 10, 2010 11:53:25 AM
	 * 
	 */
	private void initRule(List rules) throws Exception {
		if (rules.size() < 1)
			return;
		String funcName = getFunctionName(rules, 1);
		this.tempBuffer.append(BceAutoPageUtil.getTemplateString(
				"JS0000004",
				new String[] {
						String.valueOf(((IQBceRulesetRuleValue) rules.get(0))
								.getRuleId()), funcName }));
	}

	/**
	 * ��ȡ�����б�
	 * 
	 * @Function: TemplateStringForJs.java
	 * @Description: �ú����Ĺ�������
	 * 
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @param j
	 *            0:submit 1:init 3:dbform 4:normal 5:dbgrid
	 * @throws Exception
	 * @date: Nov 10, 2010 11:53:43 AM
	 * 
	 */
	private String getFunctionName(List rules, int j) throws Exception {
		String functionName = "";
		if (rules.size() < 1)
			return "";

		String uniKEY = BceUtil.getUniKey();
		IQBceRulesetRuleValue ruleValue = (IQBceRulesetRuleValue) rules.get(0);
		String functionStr = "function check_rule_ct_kk_"
				+ ruleValue.getRuleId() + uniKEY + "(){\n";
		// ���onvaluecange��form��grid���¼����⴦��
		String event_name = "";
		if ("onvaluechange".equalsIgnoreCase(ruleValue.getEventName())
				|| j == 3 || j == 5) {
			if (ruleValue.getEventObjType() == 2) {
				event_name = "eventObj" + ruleValue.getRuleId() + "_"
						+ ruleValue.getRulesetId() + "_"
						+ ruleValue.getObjName();
				pubVars.put(
						event_name,
						"g_AiBcecommon.getSrcDbTableFuntion(\""
								+ ruleValue.getObjName() + "\",\""
								+ ruleValue.getEventName() + "\");");
			}

			if (ruleValue.getEventObjType() == 1) {
				event_name = "eventObj" + ruleValue.getRuleId() + "_"
						+ ruleValue.getRulesetId() + "_"
						+ ruleValue.getObjName();
				pubVars.put(
						event_name,
						"g_AiBcecommon.getDbFormSrcFuntion(\""
								+ ruleValue.getObjName() + "\",\""
								+ ruleValue.getEventName() + "\");");
			}

			functionStr = ("function check_rule_ct_kk_" + ruleValue.getRuleId()
					+ uniKEY + "(p1,p2,p3,p4){\n");
		}

		if (StringUtils.isNotBlank(ruleValue.getObjName())) {
			functionStr += " \nif(!g_AiBcecommon.onBusiStart(\""
					+ ruleValue.getObjName() + "\"))return false;\n";
		}
		String funct = "";
		Set varDefineSet = new HashSet();// ��ֹ�ظ�����
		long seq = 0;
		int lt = 0;
		for (int i = 0; i < rules.size(); i++) {
			// ����Ψһ��ʶ
			String uniKey = Integer.toHexString(new Random().nextInt());
			String funcName = "";
			IQBceRulesetRuleValue rule = (IQBceRulesetRuleValue) rules.get(i);
			boolean useBENSHEN = false;
			String[] tmpParams = getParames(rule, varDefineSet);
			String params = tmpParams[0];
			String params_value = tmpParams[1];
			functionStr += params_value;
			String forActionSt = tmpParams[2];

			switch ((int) rule.getRuleType()) {
			case BceUtil.RULE_TYPE_JS:
				if (j == 0) {

					funcName += params_value;
					funcName += BceAutoPageUtil.getTemplateString("JS0000022",
							new String[] { rule.getFuncName() + "(" + params
									+ ")" });
					funct += funcName;
				}
				if (j == 1) {
					funcName += params_value;
					funcName += BceAutoPageUtil.getTemplateString("JS0000023",
							new String[] { rule.getFuncName(), params });
					funct += funcName;
				}
				// ƴװ�����Ͳ�����(��:functionName(aaa,bbb))
				String fac = BceAutoPageUtil.getTemplateString("JS0000024",
						new String[] { rule.getFuncName(), params });
				if (StringUtils.isBlank(params))
					fac = rule.getFuncName();
				if (j == 3) {
					if (seq < rule.getSeqNo()) {
						if (rule.getSeqNo() == 50)
							seq = 51;
						else
							seq = rule.getSeqNo();
					} else {
						seq = seq + 1;
					}
					funcName = "check_rule_ct_kk_" + ruleValue.getRuleId()
							+ uniKEY + "();";
					functionStr += BceAutoPageUtil.getTemplateString(
							"JS0000007",
							new String[] {
									ruleValue.getObjName(),
									ruleValue.getChildObjName() == null ? ""
											: ruleValue.getChildObjName(),
									ruleValue.getEventName(),
									rule.getFuncName(), "", seq + "" });
				}
				if (j == 4) {
					String obJName = ruleValue.getObjName();
					obJName = StringUtils.isBlank(obJName) ? "win" : obJName;
					funcName = BceAutoPageUtil.getTemplateString("JS0000006",
							new String[] {
									obJName,
									ruleValue.getEventName(),
									String.valueOf(ruleValue.getRuleId())
											+ uniKEY });
					if ("onload".equals(ruleValue.getEventName()))
						funcName = "check_rule_ct_kk_"
								+ String.valueOf(ruleValue.getRuleId())
								+ uniKEY + "();";
					// �޲δ���
					if (StringUtils.isNotBlank(fac) && !fac.endsWith(")"))
						fac += "()";
					/*
					 * st_ls.add(BceAutoPageUtil.getTemplateString("JS0000026",
					 * new String[] { obJName, fac, params_value,
					 * String.valueOf(rule.getRuleId()) }));
					 * 
					 * functionStr += "if (!enventNamal_" + obJName + "_" +
					 * String.valueOf(rule.getRuleId()) +
					 * "()){return false;}\n";
					 */
					// ����
					if (rule.getRuleKind() == 1)
						functionStr += "if (!" + fac + "){return false;}\n";
					// �¼�
					else
						functionStr += fac + ";\n";

				}
				if (j == 5) {
					funcName = BceAutoPageUtil.getTemplateString(
							"JS0000032",
							new String[] { ruleValue.getObjName(),
									ruleValue.getEventName(),
									"" + ruleValue.getRuleId() + uniKEY, "" });
					if ((fac.lastIndexOf(')') < 0)
					/*
					 * && "onvaluechange"
					 * .equalsIgnoreCase(((IQBceRulesetRuleValue) rules
					 * .get(0)).getEventName())
					 */)
						fac += "(p1,p2,p3,p4)"; // ֧��Grid�����¼���Ŀǰ���4������
					// ����
					if (rule.getRuleKind() == 1)
						functionStr += "if (!" + fac + "){return false;}\n";
					// �¼�
					else
						functionStr += fac + ";\n";
				}
				break;
			case BceUtil.RULE_TYPE_JAVA:
				/*
				 * funcName = funcName + "\n" + rule.getRuleId() + "=" +
				 * forActionSt;
				 */
				// �����̨������������

				funcName = BceAutoPageUtil.getTemplateString("JS0000015",
						new String[] { String.valueOf(rule.getRuleId()),
								forActionSt, params_value });

				if (j == 3) {
					String funcNamea = funcName;
					funcName = BceAutoPageUtil
							.getTemplateString(
									"JS0000007",
									new String[] {
											ruleValue.getObjName(),
											ruleValue.getChildObjName() == null ? ""
													: ruleValue
															.getChildObjName(),
											ruleValue.getEventName(),
											"check_rule_ct_kk_"
													+ String.valueOf(ruleValue
															.getRuleId())
													+ uniKEY + "", "" });
					// �޲δ���
					st_ls.add(BceAutoPageUtil
							.getTemplateString(
									"JS0000030",
									new String[] {
											String.valueOf(rule.getRuleId())
													+ "_" + uniKey,
											params_value + funcNamea }));
				}
				if (j == 4) {
					String funcNamea = funcName;
					funcName = BceAutoPageUtil.getTemplateString(
							"JS0000031",
							new String[] {
									ruleValue.getObjName(),
									ruleValue.getEventName(),
									String.valueOf(ruleValue.getRuleId())
											+ uniKEY });
					// �޲δ���
					st_ls.add(BceAutoPageUtil
							.getTemplateString(
									"JS0000030",
									new String[] {
											String.valueOf(rule.getRuleId())
													+ "_" + uniKey,
											params_value + funcNamea }));

				}
				if (j == 5) {
					String funcNamea = funcName;
					funcName = BceAutoPageUtil.getTemplateString(
							"JS0000032",
							new String[] {
									ruleValue.getObjName(),
									ruleValue.getEventName(),
									String.valueOf(ruleValue.getRuleId()
											+ uniKEY) });
					// �޲δ���
					st_ls.add(BceAutoPageUtil
							.getTemplateString(
									"JS0000030",
									new String[] {
											String.valueOf(rule.getRuleId())
													+ "_" + uniKey,
											params_value + funcNamea }));

				}
				if (j == 0) {
					funct += funcName;
				}
				functionStr += "if (!on_back_function_" + rule.getRuleId()
						+ "_" + uniKey + "()){return false;}\n";
				break;
			}
			if ("".equals(funct))
				functionName = funcName;
			else
				functionName = funct;
			if (ruleValue.getEventObjType() == 2
					|| ruleValue.getEventObjType() == 1) {
				if ((lt != 0 && lt < 49 && rule.getSeqNo() > 49)
						|| i == rules.size() - 1) {
					if (!useBENSHEN) {
						functionStr += "\nif(" + event_name + "!=null)"
								+ event_name + "(p1,p2,p3,p4);";
						useBENSHEN = true;
					}
					lt = (int) rule.getSeqNo();
				}
			}

		}
		functionStr += "}\n";

		st_ls.add(functionStr);
		return functionName;
	}

	private String addParamByTemplate(String param, String params,
			String value, Set varl) throws Exception {
		params = params
				+ BceAutoPageUtil.getTemplateString("JS0000011",
						new String[] { value });
		// varl.add(param);
		return params;
	}

	/**
	 * �����¼�ʵ����
	 * 
	 * @Function: TemplateStringForJs.java
	 * @Description: �ú����Ĺ�������
	 * 
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @param util
	 * @throws Exception
	 * @date: Nov 9, 2010 3:11:47 PM
	 * 
	 */
	private void eventRule(List rules, String[] util) throws Exception {
		if (rules.size() < 1)
			return;
		// ����Ψһ��ʶ
		String uniKey = Integer.toHexString(new Random().nextInt());
		pubVars.clear();
		String functionName = "";
		if (!StringUtils.isNumeric(util[1]))
			throw new BceException("BES0000422");
		switch (Integer.valueOf(util[1]).intValue()) {
		// ������
		case (EventRuleProcessHelper.EVENT_TYPE_NORMAL):
			functionName = enventRuleNomal(rules);
			break;
		case (EventRuleProcessHelper.EVENT_TYPE_DBFORM):
			functionName = enventRuleDbForm(rules);
			break;
		case (EventRuleProcessHelper.EVENT_TYPE_DBGRID):
			functionName = enventRuleDbGrid(rules);
			break;
		case (EventRuleProcessHelper.EVENT_TYPE_WINDOWLOAD):
			break;
		default:
			break;
		}
		for (Iterator iterator = pubVars.entrySet().iterator(); iterator
				.hasNext();) {
			Entry entry = (Entry) iterator.next();
			this.tempBuffer.append("var " + entry.getKey() + ";\n");
		}
		this.tempBuffer.append(BceAutoPageUtil.getTemplateString(
				"JS0000025",
				new String[] { String.valueOf(((IQBceRulesetRuleValue) rules
						.get(0)).getRuleId()) + uniKey }));
		for (Iterator iterator = pubVars.entrySet().iterator(); iterator
				.hasNext();) {
			Entry entry = (Entry) iterator.next();
			this.tempBuffer.append("" + entry.getKey() + "= "
					+ entry.getValue() + ";\n");
		}
		this.tempBuffer.append(functionName);
		this.tempBuffer.append(BceAutoPageUtil.getTemplateString("JS0000021",
				null));

		for (int i = 0; i < st_ls.size(); i++) {
			String string = (String) st_ls.get(i);
			this.tempBuffer.append(string);
		}
		st_ls.clear();
	}

	/**
	 * ��Ӷ�Grid��֧��
	 * 
	 * @throws Exception
	 * @Title: enventRuleDbGrid
	 * @Description: TODO
	 * @param @param rules
	 * @return void
	 * @throws
	 */
	private String enventRuleDbGrid(List rules) throws Exception {
		// TODO Auto-generated method stub
		String funcName = getFunctionName(rules, 5);
		return funcName;
	}

	/**
	 * ���DBForm �¼�
	 * 
	 * @Function: TemplateStringForJs.java
	 * @Description: �ú����Ĺ�������
	 * 
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 10, 2010 11:52:23 AM
	 * 
	 */
	private String enventRuleDbForm(List rules) throws Exception {
		String funcName = getFunctionName(rules, 3);
		return funcName;

	}

	/**
	 * ����ע���¼�
	 * 
	 * @Function: TemplateStringForJs.java
	 * @Description: �ú����Ĺ�������
	 * 
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 10, 2010 11:52:52 AM
	 * 
	 */
	private String enventRuleNomal(List rules) throws Exception {
		String funcName = getFunctionName(rules, 4);
		return funcName;

	}

	/**
	 * ���Load Js�ļ�
	 * 
	 * @Function: TemplateStringForJs.java
	 * @Description: �ú����Ĺ�������
	 * 
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 9, 2010 11:02:02 AM
	 * 
	 */
	protected void addScriptFile() throws Exception {
		if (isDy())
			this.tempBuffer.append(BceAutoPageUtil.getTemplateString(
					"JS0000019", new String[] { request.getContextPath() }));
		else {
			this.tempBuffer.append(BceAutoPageUtil.getTemplateString(
					"JS0000016", null));
		}
		for (Iterator iterator = files.iterator(); iterator.hasNext();) {

			String file = (String) iterator.next();
			if (this.isDy()) {
				if (BceUtil.getIsDebug())
					this.tempBuffer.append(BceAutoPageUtil.getTemplateString(
							"JS0000017",
							new String[] { request.getContextPath() + file
									+ "?d=" + new Date().getTime() }));
				else
					this.tempBuffer.append(BceAutoPageUtil.getTemplateString(
							"JS0000017",
							new String[] { request.getContextPath() + file }));
			} else {
				if (BceUtil.getIsDebug())
					this.tempBuffer.append(BceAutoPageUtil.getTemplateString(
							"JS0000002", new String[] { file + "?d="
									+ new Date().getTime() }));
				else
					this.tempBuffer.append(BceAutoPageUtil.getTemplateString(
							"JS0000002", new String[] { file }));
			}
		}
	}

	/**
	 * 
	 * @Function: TemplateStringForJs.java
	 * @Description: �ú����Ĺ�������
	 * 
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 8, 2010 10:12:34 PM
	 * 
	 */
	private void loadRules(IQBceRulesetRuleValue[] pageRulesetRuleBeans)
			throws Exception {
		for (int i = 0; i < pageRulesetRuleBeans.length; i++) {

			IQBceRulesetRuleValue pageRulesetRuleBean = pageRulesetRuleBeans[i];
			String key = pageRulesetRuleBean.getRuleTriggerType() + ":"
					+ pageRulesetRuleBean.getEventObjType() + ":"
					+ pageRulesetRuleBean.getObjName() + ":"
					+ pageRulesetRuleBean.getEventName() + ":"
					+ pageRulesetRuleBean.getChildObjName();
			List rules = (List) ruleMap.get(key);
			if (rules == null) {
				rules = new LinkedList();
			}
			rules.add(pageRulesetRuleBean);
			/*
			 * IBceFrameSV iBceFrameSV = BceServiceFactory.getBceFrameSV();
			 * 
			 * IBceRuleValue bceRuleValue = iBceFrameSV
			 * .getBceRule(pageRulesetRuleBean.getRuleId());
			 */
			/**
			 * ���Ӷ�filetype���ͽ���У��
			 */
			if (StringUtils.isNotBlank(pageRulesetRuleBean.getFileName())
					&& pageRulesetRuleBean.getRuleType() == 1)
				files.add(pageRulesetRuleBean.getFileName());
			ruleMap.put(key, rules);
		}
	}

	protected String[] getParames(IQBceRulesetRuleValue rule, Set varDefineSet)
			throws Exception {
		String paramValue = rule.getParamValueList();
		String paramsList = rule.getParamList();
		String[] parames = StringUtils.split(paramValue, ",");
		String[] paramsCs = StringUtils.split(paramsList, ",");
		if (parames != null && paramsCs != null
				&& parames.length != paramsCs.length)
			throw new BceException("BES0000421");
		String params = "";
		String params_value = "";
		/**
		 * Ϊ��̨�ṩ������
		 */
		String forActionSt = "&ruleid=" + rule.getRuleId() + "&";
		if (parames != null) {
			for (int k = 0; k < parames.length; k++) {
				String param = parames[k];
				String[] valuekind = param.split("\\.");
				String varanme = "";
				if (valuekind.length < 2)
					continue;
				if (StringUtils.isNotBlank(params))
					params = params + ",";
				if (PARAM_REQUEST.equals(valuekind[0])) {
					String value = valuekind[1];
					if (!varDefineSet.contains(param)) {
						if (isDy()) {
							value = HttpUtil.getAsString(request, valuekind[1]);
							varanme = BceAutoPageUtil.getTemplateString(
									"JS0000027", new String[] { valuekind[1],
											value });
						} else
							varanme = BceAutoPageUtil.getTemplateString(
									"JS0000008", new String[] { valuekind[1] });
					}
					params = addParamByTemplate(param, params, valuekind[1],
							varDefineSet);

					forActionSt = BceAutoPageUtil.getTemplateString(
							"JS0000029",
							new String[] { forActionSt, String.valueOf(k),
									(valuekind[1]) });
				}
				if (PARAM_DBGRID.equals(valuekind[0])) {
					if (!varDefineSet.contains(param))
						varanme = BceAutoPageUtil.getTemplateString(
								"JS0000009", new String[] { valuekind[2],
										valuekind[1],
										valuekind[1] + valuekind[2] });
					params = addParamByTemplate(param, params, valuekind[1]
							+ valuekind[2], varDefineSet);
					forActionSt = BceAutoPageUtil.getTemplateString(
							"JS0000029",
							new String[] { forActionSt, String.valueOf(k),
									(valuekind[1] + valuekind[2]) });
				}
				if (PARAM_DBFORM.equals(valuekind[0])) {
					if (!varDefineSet.contains(param))
						varanme = BceAutoPageUtil.getTemplateString(
								"JS0000010", new String[] { valuekind[2],
										valuekind[1],
										valuekind[1] + valuekind[2] });
					params = addParamByTemplate(param, params, valuekind[1]
							+ valuekind[2], varDefineSet);
					forActionSt = BceAutoPageUtil.getTemplateString(
							"JS0000029",
							new String[] { forActionSt, String.valueOf(k),
									(valuekind[1] + valuekind[2]) });
				}
				if (PARAM_EVAL.equals(valuekind[0])) {
					String key = BceUtil.getUniKey();
					if (!varDefineSet.contains(key)) {
						String s_eval = valuekind[1];
						s_eval = StringUtils.replace(s_eval, "_", ".");
						varanme = BceAutoPageUtil.getTemplateString(
								"JS0000041", new String[] { s_eval, key });

					}
					params = addParamByTemplate(param, params, key,
							varDefineSet);
					forActionSt = BceAutoPageUtil
							.getTemplateString("JS0000029", new String[] {
									forActionSt, String.valueOf(k), key });
				}

				params_value = params_value + varanme;
				if (PARAM_NORMAL.equals(valuekind[0])) {
					if (!varDefineSet.contains(param)) {
						varanme = BceAutoPageUtil.getTemplateString(
								"JS0000014", new String[] { valuekind[1] });
						params_value = params_value + varanme;
					}
					params = BceAutoPageUtil.getTemplateString("JS0000028",
							new String[] { params, valuekind[1] });
					forActionSt = BceAutoPageUtil.getTemplateString(
							"JS0000029",
							new String[] { forActionSt, String.valueOf(k),
									valuekind[1] });
				}
				if (PARAM_N.equals(valuekind[0])) {
					params = params + "\"" + valuekind[1] + "\"";
					forActionSt = BceAutoPageUtil.getTemplateString(
							"JS0000013",
							new String[] { forActionSt, String.valueOf(k),
									valuekind[1] });
				}

			}
		}
		return new String[] { params, params_value, forActionSt };
	}
}
