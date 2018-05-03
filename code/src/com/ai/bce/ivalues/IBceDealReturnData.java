package com.ai.bce.ivalues;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

public interface IBceDealReturnData extends Serializable {

	String[][] getCustomProperty();

	//用于构造返回到前台的信息
	void setCustomProperty(String[][] msgs);

	//是否成功
	String getIsSuccess();

	void setIsSuccess(String newIsSuccess);

	//错误信息
	String getErrorMsg();

	void setErrorMsg(String newErrorMsg);

	//成功信息
	String getSuccessMsg();

	void setSuccessMsg(String newSuccessMsg);

	/**
	 * 以下用于创建流程，如无流程则不需要设置
	 */

	//后续处理的流程模板，一般不需要设，如有设置则此处优先级高于bce_frame.workflow_code
	void setWorkflowCode(String code);

	String getWorkflowCode();

	void setWorkflowObjectId(String objId);

	String getWorkflowObjectId();

	void setWorkflowObjectTypeId(String typeId);

	String getWorkflowObjectTypeId();

	void setWorkflowParamMap(Map paramMap);

	Map getWorkflowParamMap();

	void setWorkflowStartTime(Timestamp t);

	Timestamp getWorkflowStartTime();

	void setWorkflowNotes(String notes);

	String getWorkflowNotes();

	void setProcessReturnMap(Map map);

	Map getProcessReturnMap();

	/**
	 * 通过国际化设置相关提示数据
	 * 
	 * @param msg
	 * @param params
	 */
	public void setErrorMsgByKey(String key, Object[] params);

	public Object[] getErrorMsgParams();

	/**
	 * 通过国际化设置相关提示数据
	 * 
	 * @param key
	 */
	public void setErrorMsgByKey(String key);

	/**
	 * 仅仅设置Key 不设置Message
	 * 
	 * @param key
	 */
	public void setErrorMsgKey(String key);

	public String getErrorMsgKey();

}
