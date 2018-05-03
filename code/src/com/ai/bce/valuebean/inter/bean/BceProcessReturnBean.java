package com.ai.bce.valuebean.inter.bean;

import java.io.Serializable;
import java.util.HashMap;

import com.ai.bce.valuebean.inter.ivalue.IBceProcessReturnValue;

/**
 * 工作流返回值定义
 * 
 * @since 1.0
 * @ClassName: BceProcessReturnBean.java
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Qinjin Peng
 * @date 2011-6-15 上午10:25:28
 * @version 1.0
 */
public class BceProcessReturnBean implements IBceProcessReturnValue {
	/**
	 * 返回值将纳入参数返回给前台
	 */
	private HashMap params;
	/**
	 * 返回的消息将纳入提示消息中
	 */
	private HashMap msg;

	public HashMap getParams() {
		return params;
	}

	public void setParams(HashMap params) {
		this.params = params;
	}

	public HashMap getMsg() {
		return msg;
	}

	public void setMsg(HashMap msg) {
		this.msg = msg;
	}

}
