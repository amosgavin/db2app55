/**   
 * @Title: BceUseProxyUtil.java 
 * @Package com.ai.bce.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Qinjin Peng (Pengqj@asiainfo-linkage.com)   
 * @date 2011-4-18 下午05:40:34 
 * @version V1.0   
 */
package com.ai.bce.util.define;

import java.lang.reflect.Method;

/**
 * @ClassName: BceUseProxyUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Qinjin Peng
 * @date 2011-4-18 下午05:40:34
 * 
 */

public interface BceUseProxyInterface {

	/**
	 * 
	 * @Title: useAfter
	 * @Description: TODO
	 * @param @param object
	 * @param @param proxy
	 * @param @param method
	 * @param @param args
	 * @param @param idClassName
	 * @param @throws Exception
	 * @return void
	 * @throws
	 */
	public void useAfter(Object object, Object proxy, Method method,
			Object[] args, String idClassName) throws Exception;

	/**
	 * 
	 * @Title: useBefore
	 * @Description: TODO
	 * @param @param object
	 * @param @param proxy
	 * @param @param method
	 * @param @param args
	 * @param @param idClassName
	 * @param @throws Exception
	 * @return void
	 * @throws
	 */
	public void useBefore(Object object, Object proxy, Method method,
			Object[] args, String idClassName) throws Exception;
}
