package com.ai.bce.valuebean.inter.ivalue;

import java.io.Serializable;
import java.util.HashMap;

/**
 * ��������������
 * 
 * @since 1.0
 * @ClassName: IBceProcessReturnValue.java
 * @Description: TODO(������һ�仰��������������)
 * @author Qinjin Peng
 * @date 2011-6-15 ����10:31:06
 * @version 1.0
 */
public interface IBceProcessReturnValue extends Serializable {
	public HashMap getParams();

	public void setParams(HashMap params);

	public HashMap getMsg();

	public void setMsg(HashMap msg);
}
