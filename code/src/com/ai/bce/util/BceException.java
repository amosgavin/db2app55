package com.ai.bce.util;


public class BceException extends Exception {
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;

	public BceException(String pKey) {
		super(LocaleResourceFactory.getException(pKey));
	}
	public BceException(Throwable t) {
		super(t);
	}
	public BceException(String pKey, String pMsg) {
		super(LocaleResourceFactory.getException(pKey) + pMsg);
	}

	public BceException(String pKey, String pMsg, Object[] pParams) {
		super(LocaleResourceFactory.getException(pKey, pParams) + pMsg);
	}

	public BceException(String pKey, Object[] pParams) {
		super(LocaleResourceFactory.getException(pKey, pParams));
	}

	public BceException(String pKey, Throwable e) {
		super(LocaleResourceFactory.getException(pKey), e);
	}

	public BceException(String pKey, String pMsg, Throwable e) {
		super(LocaleResourceFactory.getException(pKey) + pMsg, e);
	}

	public BceException(String pKey, Object[] pParams, Throwable e) {
		super(LocaleResourceFactory.getException(pKey, pParams), e);
	}

	public static void throwException(String key, Object[] pParams)
			throws BceException {
		throw new BceException(key, pParams);
	}

	public static void throwException(String key) throws BceException {
		throw new BceException(key);
	}

	public static void throwException(String pKey, Object[] pParams, Throwable e)
			throws BceException {
		throw new BceException(pKey, pParams, e);
	}

}
