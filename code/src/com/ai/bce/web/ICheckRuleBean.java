package com.ai.bce.web;

import java.io.Serializable;

public class ICheckRuleBean implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	 */
	private static final long serialVersionUID = 1L;
	private String flag;
	private String message;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
