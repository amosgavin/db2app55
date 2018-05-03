package com.ai.bce.auto.plugin.ejb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.bce.util.BceProxy;

public class BceServiceProxy extends BceProxy {
	public static transient final Log log = LogFactory
			.getLog(BceServiceProxy.class);

	public BceServiceProxy(Class[] clazzes) {
		super(clazzes);
	}

}
