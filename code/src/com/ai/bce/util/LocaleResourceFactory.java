package com.ai.bce.util;

import com.ai.appframe2.util.locale.AppframeLocaleFactory;

/**
 * ���ʻ���Դ����
 * 
 * @since 1.0
 * @ClassName: LocaleResourceFactory.java
 * @Description: TODO(������һ�仰��������������)
 * @author Qinjin Peng
 * @date 2011-6-20 ����10:45:20
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
	 * ��ȡ���ʻ�Excption��Դ
	 * 
	 * @param pKey
	 *            key
	 * @param pParams
	 *            ����
	 * @return �ַ���
	 */
	public static String getException(String pKey, Object[] pParams) {
		return pKey
				+ ":"
				+ AppframeLocaleFactory.getResource(RESOURCE_NAME, pKey,
						pParams);
	}

	/**
	 * ��ȡ���ʻ���Դ
	 * 
	 * @param pKey
	 *            key
	 * @return ��Դ�ַ���
	 */
	public static String getResource(String pKey) {
		return AppframeLocaleFactory.getResource(RESOURCE_NAME, pKey);
	}

	/**
	 * ��ȡ���ʻ���Դ
	 * 
	 * @param pKey
	 *            key
	 * @param pParams
	 *            ����
	 * @return �ַ���
	 */
	public static String getResource(String pKey, Object[] pParams) {
		return AppframeLocaleFactory.getResource(RESOURCE_NAME, pKey, pParams);
	}
}
