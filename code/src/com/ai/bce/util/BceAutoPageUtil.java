package com.ai.bce.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.bo.BceVObjectConfBean;
import com.ai.bce.service.interfaces.IBceAutoPageSV;


/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: BEAutoPageUtil.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Nov 1, 2010 2:27:43 PM
 */
public class BceAutoPageUtil {
	private IBceAutoPageSV iBeAutoPageSV;

	private static final BceAutoPageUtil bceAutoPageUtil = new BceAutoPageUtil();
	private Map tagPlugins = new HashMap();
	private Properties ppts;
	private static final Logger _log = Logger.getLogger(BceAutoPageUtil.class);

	private BceAutoPageUtil() {
		iBeAutoPageSV = (IBceAutoPageSV) ServiceFactory
				.getService(IBceAutoPageSV.class);
		try {
			initTagPlgins();
			initTemplateS();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Init error ："+ e);
		}
	}

	private void initTagPlgins() throws Exception {
		// TODO Auto-generated method stub
		BceVObjectConfBean[] tBeans = iBeAutoPageSV.getTagPlgins();
		for (int i = 0; i < tBeans.length; i++) {
			BceVObjectConfBean buTagPluginsBean = tBeans[i];
			tagPlugins.put(buTagPluginsBean.getObjTypeId(), buTagPluginsBean);
		}
	}

	public static BceVObjectConfBean getTagPluginByObjType(String ObjType) {
		return (BceVObjectConfBean) bceAutoPageUtil.tagPlugins.get(ObjType);
	}

	public static String getTemplateString(String templateType, String[] args)
			throws Exception {
		String target = bceAutoPageUtil.ppts.getProperty(templateType);
		if (StringUtils.isEmpty(target))
			throw new BceException("BES0000402",
							new String[]{templateType, target});
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				target = StringUtils.replace(target, "{" + i + "}", args[i]);
			}
		}
		return target;
	}

	/**
	 * 
	 * 方法用途和描述: 加载属性
	 * 
	 * @param propertyFilePath
	 *            属性文件(包括类路径)
	 * @return 属性
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @throws FileNotFoundException
	 * @date: Oct 23, 2010 10:33:04 PM
	 */
	private static Properties loadPropertyFile(String propertyFilePath)
			throws FileNotFoundException {
		java.io.InputStream is = loadInputStream(propertyFilePath);
		Properties ppts = new Properties();
		try {
			ppts.load(is);
			return ppts;
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(LocaleResourceFactory.getResource("BES0000403",new Object[]{propertyFilePath}), e);
			return null;
		}
	}

	public static java.io.InputStream loadInputStream(String propertyFilePath)
			throws FileNotFoundException {
		java.io.InputStream is = BceAutoPageUtil.class
				.getResourceAsStream(propertyFilePath);
		if (is == null) {
			is = new java.io.FileInputStream(propertyFilePath);
		}
		return is;
	}

	private void initTemplateS() throws Exception, IOException {
		ppts = loadPropertyFile("/com/ai/bce/PageTemplate.properties");
	}

	/**
	 * 
	 * 方法用途和描述: 从文件系统加载属性文件
	 * 
	 * @param propertyFilePath
	 *            属性文件(文件系统的文件路径)
	 * @return 属性
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Oct 23, 2010 10:33:04 PM
	 */
	public static Properties loadPropertyFileByFileSystem(
			final String propertyFilePath) {
		try {
			Properties ppts = new Properties();
			FileInputStream in  = new java.io.FileInputStream(propertyFilePath);
			ppts.load(in);
			in.close();
			return ppts;
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
			_log.error("FileInputStream(\"" + propertyFilePath
					+ "\")! FileNotFoundException: " + e);
			return null;
		} catch (java.io.IOException e) {
			_log.error("Properties.load(InputStream)! IOException: " + e);
			return null;
		}
	}
}
