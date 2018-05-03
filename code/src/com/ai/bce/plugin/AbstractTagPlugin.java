package com.ai.bce.plugin;

import com.ai.bce.bo.BceViewObjectBean;


/**
 * 接口抽象实现类 Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: AbstractPlgin.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Nov 1, 2010 2:48:46 PM
 */
public abstract class AbstractTagPlugin {
	protected StringBuffer displayBuffer = new StringBuffer();

	/**
	 * 插件必须实现此方法
	 * 
	 * @Function: AbstractTagPlugin.java
	 * @Description: 该函数的功能描述
	 * 
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 1, 2010 8:15:14 PM
	 * 
	 */
	public abstract String display(BceViewObjectBean viewObjectBean,
			int pageframeId, String template_id) throws Exception;
	
	
	
}
