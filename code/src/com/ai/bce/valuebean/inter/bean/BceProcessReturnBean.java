package com.ai.bce.valuebean.inter.bean;

import java.io.Serializable;
import java.util.HashMap;

import com.ai.bce.valuebean.inter.ivalue.IBceProcessReturnValue;

/**
 * ����������ֵ����
 * 
 * @since 1.0
 * @ClassName: BceProcessReturnBean.java
 * @Description: TODO(������һ�仰��������������)
 * @author Qinjin Peng
 * @date 2011-6-15 ����10:25:28
 * @version 1.0
 */
public class BceProcessReturnBean implements IBceProcessReturnValue {
	/**
	 * ����ֵ������������ظ�ǰ̨
	 */
	private HashMap params;
	/**
	 * ���ص���Ϣ��������ʾ��Ϣ��
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
