package com.ai.bce.util;

import com.ai.appframe2.util.locale.AppframeLocaleFactory;

/**
 * 国际化资源工具
 * 
 * @since 1.0
 * @ClassName: LocaleResourceFactory.java
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Qinjin Peng
 * @date 2011-6-20 上午10:45:20
 * @version 1.0
 */
public class LocaleResourceFactory {
	private static final String RESOURCE_NAME = "CRM";

	/**
	 * Exception Key
	 * 
	 * @param pKey
	 * @return Pkey:PKeyName
	 */
	public static String getException(String pKey) {
		return pKey + ":"
				+ AppframeLocaleFactory.getResource(RESOURCE_NAME, pKey);
	}

	/**
	 * 获取国际化Excption资源
	 * 
	 * @param pKey
	 *            key
	 * @param pParams
	 *            参数
	 * @return 字符串
	 */
	public static String getException(String pKey, Object[] pParams) {
		return pKey
				+ ":"
				+ AppframeLocaleFactory.getResource(RESOURCE_NAME, pKey,
						pParams);
	}

	/**
	 * 获取国际化资源
	 * 
	 * @param pKey
	 *            key
	 * @return 资源字符串
	 */
	public static String getResource(String pKey) {
		return AppframeLocaleFactory.getResource(RESOURCE_NAME, pKey);
	}

	/**
	 * 获取国际化资源
	 * 
	 * @param pKey
	 *            key
	 * @param pParams
	 *            参数
	 * @return 字符串
	 */
	public static String getResource(String pKey, Object[] pParams) {
		return AppframeLocaleFactory.getResource(RESOURCE_NAME, pKey, pParams);
	}
}
