package com.ai.bce.util.bean;

import java.io.Serializable;
import java.util.Map;

public class PluginBean implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	String name;
	String type;
	boolean isLoadFile;
	boolean isUse;
	Map serviceMap;
	String proxyClass;
	boolean isProxy;
	boolean isUseServiceMap;
	boolean isUseLocal;
	
	

	public boolean isUseLocal() {
		return isUseLocal;
	}

	public void setUseLocal(boolean isUseLocal) {
		this.isUseLocal = isUseLocal;
	}

	public boolean isProxy() {
		return isProxy;
	}

	public void setProxy(boolean isProxy) {
		this.isProxy = isProxy;
	}

	public boolean isUseServiceMap() {
		return isUseServiceMap;
	}

	public void setUseServiceMap(boolean isUseServiceMap) {
		this.isUseServiceMap = isUseServiceMap;
	}

	public String getProxyClass() {
		return proxyClass;
	}

	public void setProxyClass(String proxyClass) {
		this.proxyClass = proxyClass;
	}

	public Map getServiceMap() {
		return serviceMap;
	}

	public void setServiceMap(Map serviceMap) {
		this.serviceMap = serviceMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isLoadFile() {
		return isLoadFile;
	}

	public void setLoadFile(boolean isLoadFile) {
		this.isLoadFile = isLoadFile;
	}

	public boolean isUse() {
		return isUse;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}

	private String fileName;
	private String staticName;
	private String className;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getStaticName() {
		return staticName;
	}

	public void setStaticName(String staticName) {
		this.staticName = staticName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
