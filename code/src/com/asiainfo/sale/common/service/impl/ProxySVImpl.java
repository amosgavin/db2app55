package com.asiainfo.sale.common.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.common.dao.interfaces.IProxyDAO;
import com.asiainfo.sale.common.ivalues.IBOProxyShowValue;
import com.asiainfo.sale.common.service.interfaces.IProxySV;

public class ProxySVImpl implements IProxySV {
	public String[] delProxy(String createrId) throws RuntimeException,
			Exception {
		return ((IProxyDAO) ServiceFactory.getService(IProxyDAO.class))
				.delProxy(createrId);
	}

	public String[] setProxy(String createrId, String proxyerId, String mFlag)
			throws RuntimeException, Exception {
		return ((IProxyDAO) ServiceFactory.getService(IProxyDAO.class))
				.setProxy(createrId, proxyerId, mFlag);
	}

	public IBOProxyShowValue[] getAllProxyValue(String proxyerId)
			throws RuntimeException, Exception {
		return ((IProxyDAO) ServiceFactory.getService(IProxyDAO.class))
				.getProxyShow(null, null, proxyerId, null, null);
	}

	public IBOProxyShowValue[] getParentProxyValue(String proxyerId)
			throws RuntimeException, Exception {
		return ((IProxyDAO) ServiceFactory.getService(IProxyDAO.class))
				.getParentProxyValue(proxyerId);
	}

	public IBOProxyShowValue getNextProxyValue(String proxyerId)
			throws RuntimeException, Exception {
		return ((IProxyDAO) ServiceFactory.getService(IProxyDAO.class))
				.getNextProxyValue(proxyerId);
	}

	public int getParentProxyValueCount(String proxyerId)
			throws RuntimeException, Exception {
		return ((IProxyDAO) ServiceFactory.getService(IProxyDAO.class))
				.getParentProxyValueCount(proxyerId);
	}
}
