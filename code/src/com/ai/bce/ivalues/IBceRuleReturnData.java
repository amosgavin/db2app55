package com.ai.bce.ivalues;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;

public interface IBceRuleReturnData extends Serializable {
	// 获取校验返回信息
	public String getMsg();

	/**
	 * // 设置校验返回信息
	 * 
	 * @deprecated use setMsgByKey 方法替代：
	 */
	public void setMsg(String msg);

	// 获取校验结果
	public int getResultCode();

	/**
	 * 设置校验结果，其值取自： BceUtil.JAVA_RULE_RETURN_CODE_YES 1 允许
	 * BceUtil.JAVA_RULE_RETURN_CODE_WARNNING 2 允许，但是有警告
	 * BceUtil.JAVA_RULE_RETURN_CODE_NO 3 不允许
	 */
	public void setResultCode(int resultCode);

	public void setCustomResultCode(String customResultCode);

	public String getCustomResultCode();

	public void addFailDc(DataContainerInterface failDc);

	public void addSuccessDc(DataContainerInterface successDc);

	public void addWarnningDc(DataContainerInterface warnningDc);

	// 获取失败列表，对批量校验有用
	public DataContainerInterface[] getFailDcList();

	// 获取成功列表，对批量校验有用
	public DataContainerInterface[] getSuccessDcList();

	// 获取告警列表，对批量校验有用
	public DataContainerInterface[] getWarnningDcList();

	/**
	 * 通过国际化设置相关提示数据
	 * 
	 * @param msg
	 * @param params
	 */
	public void setMsgByKey(String msg, Object[] params);

	public Object[] getMsgParams();

	/**
	 * 通过国际化设置相关提示数据
	 * 
	 * @param key
	 */
	public void setMsgByKey(String key);

	public String getKey();

	/**
	 * 仅仅设置Key 不设置Message
	 * 
	 * @param key
	 */
	public void setKey(String key);

	/**
	 * 返回消息重置去Request
	 * 
	 * @return
	 */
	public Map getRequestParameMap();

	/**
	 * 设置返回消息重置去Request
	 * 
	 * @param requestParameMap
	 */
	public void setRequestParameMap(Map requestParameMap);

	void setBceRuleData(IBceRuleData bceRuleData);

	List<IBceRuleData> getBceRuleData();

}
