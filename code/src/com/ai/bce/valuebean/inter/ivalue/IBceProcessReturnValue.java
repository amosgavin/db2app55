package com.ai.bce.valuebean.inter.ivalue;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 工作流参数定义
 * 
 * @since 1.0
 * @ClassName: IBceProcessReturnValue.java
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Qinjin Peng
 * @date 2011-6-15 上午10:31:06
 * @version 1.0
 */
public interface IBceProcessReturnValue extends Serializable {
	public HashMap getParams();

	public void setParams(HashMap params);

	public HashMap getMsg();

	public void setMsg(HashMap msg);
}
