package com.ai.bce.valuebean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.bce.ivalues.IBceRuleData;
import com.ai.bce.ivalues.IBceRuleReturnData;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.common.i18n.CrmLocaleFactory;

/**
 * Bce 实现返回值对象描述实现
 * @author pecho
 *
 */
public class BceRuleReturnDataBean implements IBceRuleReturnData {
	/**
	 * 
	 */
	private int resultCode;
	private String customResultCode;
	private String msg;
	private List succAry = new ArrayList();
	private List failAry = new ArrayList();
	private List warnningAry = new ArrayList();
	private String key;
	private Map requestParamMap;
	private Object[] params = new Object[] {};
	private List<IBceRuleData> bceRuleData = new ArrayList<IBceRuleData>();

	public String getKey() {
		return key;
	}

	public void setMsgByKey(String key) {
		this.key = key;
		this.msg = CrmLocaleFactory.getResource(key);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public void addFailDc(DataContainerInterface failDc) {
		failAry.add(failDc);
	}

	public void addSuccessDc(DataContainerInterface successDc) {
		succAry.add(successDc);
	}

	public void addWarnningDc(DataContainerInterface warnningDc) {
		warnningAry.add(warnningDc);
	}

	public DataContainerInterface[] getFailDcList() {
		return (DataContainerInterface[]) failAry.toArray(new DataContainerInterface[0]);
	}

	public DataContainerInterface[] getSuccessDcList() {
		return (DataContainerInterface[]) succAry.toArray(new DataContainerInterface[0]);
	}

	public DataContainerInterface[] getWarnningDcList() {
		return (DataContainerInterface[]) warnningAry.toArray(new DataContainerInterface[0]);
	}

	/**
	 * 推荐使用
	 */
	public void setMsgByKey(String key, Object[] params) {
		this.key = key;
		this.msg = LocaleResourceFactory.getResource(key, params);
		this.params = params;
	}

	public String getCustomResultCode() {
		return customResultCode;
	}

	public void setCustomResultCode(String customResultCode) {
		this.customResultCode = customResultCode;
	}

	public Map getRequestParameMap() {
		return this.requestParamMap;
	}

	public void setRequestParameMap(Map requestParameMap) {
		this.requestParamMap = requestParameMap;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object[] getMsgParams() {
		return params;
	}

	public void setBceRuleData(IBceRuleData bceRuleData) {
		this.bceRuleData.add(bceRuleData);
	}

	public List<IBceRuleData> getBceRuleData() {
		return this.bceRuleData;
	}
}
