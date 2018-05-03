package com.asiainfo.sale.common.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.asiainfo.openboss.obsystem.openbuffer.intHolder;
import com.asiainfo.sale.common.bo.BOProxyBean;
import com.asiainfo.sale.common.bo.BOProxyEngine;
import com.asiainfo.sale.common.bo.BOProxyShowEngine;
import com.asiainfo.sale.common.dao.interfaces.IProxyDAO;
import com.asiainfo.sale.common.ivalues.IBOProxyShowValue;
import com.asiainfo.sale.common.ivalues.IBOProxyValue;

public class ProxyDAOImpl implements IProxyDAO {

	public IBOProxyShowValue[] getProxyShow(String authorId, String createrId,
			String proxyerId, String mFlag, String state) throws Exception {
		HashMap parameter = new HashMap();

		String condition = " 1=1 ";
		if (null != authorId && !"".equals(authorId)
				&& !"null".equals(authorId)) {
			condition = condition + " AND " + IBOProxyValue.S_AuthorStaffId
					+ " = :authorId";
			parameter.put("authorId", authorId);
		}
		if (null != createrId && !"".equals(createrId)
				&& !"null".equals(createrId)) {
			condition = condition + " AND " + IBOProxyValue.S_CreateStaffId
					+ " = :createrId";
			parameter.put("createrId", createrId);
		}
		if (null != proxyerId && !"".equals(proxyerId)
				&& !"null".equals(proxyerId)) {
			condition = condition + " AND " + IBOProxyValue.S_ProxyStaffId
					+ " = :proxyerId";
			parameter.put("proxyerId", proxyerId);
		}
		if (null != mFlag && !"".equals(mFlag) && !"null".equals(mFlag)) {
			condition = condition + " AND " + IBOProxyValue.S_MFlag
					+ " = :mFlag";
			parameter.put("mFlag", mFlag);
		}
		if (null != state && !"".equals(state) && !"null".equals(state)) {
			condition = condition + " AND " + IBOProxyValue.S_State
					+ " = :state";
			parameter.put("state", state);
		}
		return BOProxyShowEngine.getBeans(condition, parameter);
	}

	public IBOProxyValue[] getProxy(String authorId, String createrId,
			String proxyerId, String mFlag, String state) throws Exception {
		HashMap parameter = new HashMap();

		String condition = " 1=1 ";
		if (null != authorId && !"".equals(authorId)
				&& !"null".equals(authorId)) {
			condition = condition + " AND " + IBOProxyValue.S_AuthorStaffId
					+ " = :authorId";
			parameter.put("authorId", authorId);
		}
		if (null != createrId && !"".equals(createrId)
				&& !"null".equals(createrId)) {
			condition = condition + " AND " + IBOProxyValue.S_CreateStaffId
					+ " = :createrId";
			parameter.put("createrId", createrId);
		}
		if (null != proxyerId && !"".equals(proxyerId)
				&& !"null".equals(proxyerId)) {
			condition = condition + " AND " + IBOProxyValue.S_ProxyStaffId
					+ " = :proxyerId";
			parameter.put("proxyerId", proxyerId);
		}
		if (null != mFlag && !"".equals(mFlag) && !"null".equals(mFlag)) {
			condition = condition + " AND " + IBOProxyValue.S_MFlag
					+ " = :mFlag";
			parameter.put("mFlag", mFlag);
		}
		if (null != state && !"".equals(state) && !"null".equals(state)) {
			condition = condition + " AND " + IBOProxyValue.S_State
					+ " = :state";
			parameter.put("state", state);
		}
		return BOProxyEngine.getBeans(condition, parameter);
	}
	
	public IBOProxyShowValue getProxyById(String id) throws Exception {
		return BOProxyShowEngine.getBean(Long.valueOf(id).longValue());
	}

	public IBOProxyShowValue getProxyByParentId(String id) throws Exception {
		HashMap parameter = new HashMap();
		String condition = " 1=1 ";
		if (null != id && !"".equals(id) && !"null".equals(id)) {
			condition = condition + " AND " + IBOProxyValue.S_MFlag + " = :id";
			parameter.put("id", id);
		} else {
			return null;
		}
		return BOProxyShowEngine.getBeans(condition, parameter)[0];
	}

	public String[] setProxy(String createrId, String proxyerId, String mFlag)
			throws Exception {
		List<IBOProxyValue> iboProxyValues = this._getParentProxyValue(createrId);
		List<IBOProxyValue> iboProxyValuesTmp = new LinkedList<IBOProxyValue>();
		IBOProxyValue[] iboProxyParentValues = null;
		for (IBOProxyValue iboProxyValue : iboProxyValues) {
			if("1".equals(iboProxyValue.getMFlag())){
				iboProxyParentValues = this.getProxy(null, null, createrId,	null, "1");
				for (IBOProxyValue iboProxyParentValue : iboProxyParentValues) {

					if ("1".equals(iboProxyParentValue.getMFlag())) {
						iboProxyValuesTmp.add(iboProxyParentValue);
					}
				}
			}
		}

		IBOProxyValue iboProxyValueNew = null;
		int forCount = 0;
		for (IBOProxyValue iboProxyValue : iboProxyValuesTmp) {
			iboProxyValueNew = new BOProxyBean();
			iboProxyValueNew.setId(BOProxyEngine.getNewId().longValue());
			iboProxyValueNew.setAuthorStaffId(iboProxyValue.getAuthorStaffId());
			iboProxyValueNew.setCreateStaffId(createrId);
			iboProxyValueNew.setProxyStaffId(proxyerId);
			iboProxyValueNew.setProxyDate(BOProxyEngine.getSysDate());
			iboProxyValueNew.setMFlag(iboProxyValue.getMFlag());
			iboProxyValueNew.setState("1");
			iboProxyValueNew.setParentId(iboProxyValue.getId());
			
			BOProxyEngine.save(iboProxyValueNew);
			forCount++;
		}
		forCount++;
		iboProxyValueNew = new BOProxyBean();
		iboProxyValueNew.setId(BOProxyEngine.getNewId().longValue());
		iboProxyValueNew.setAuthorStaffId(createrId);
		iboProxyValueNew.setCreateStaffId(createrId);
		iboProxyValueNew.setProxyStaffId(proxyerId);
		iboProxyValueNew.setProxyDate(BOProxyEngine.getSysDate());
		iboProxyValueNew.setMFlag(mFlag);
		iboProxyValueNew.setState("1");
		BOProxyEngine.save(iboProxyValueNew);
		return new String[] { "0000", String.valueOf(forCount) };
	}

	public String[] delProxy(String createrId) throws Exception {
		IBOProxyValue[] iboProxyValues = this.getProxy(createrId, null, null,
				null, "1");
		int forCount1 = 0;
		for (IBOProxyValue iboProxyValue : iboProxyValues) {
			iboProxyValue.setState("0");
			iboProxyValue.setModifyTime(BOProxyEngine.getSysDate());
			forCount1++;
			BOProxyEngine.save(iboProxyValue);
		}

		IBOProxyValue[] iboProxyValues2 = this.getProxy(null, createrId, null,
				null, "1");
		int forCount2 = 0;
		for (IBOProxyValue iboProxyValue : iboProxyValues2) {
			iboProxyValue.setState("0");
			iboProxyValue.setModifyTime(BOProxyEngine.getSysDate());
			forCount2++;
			BOProxyEngine.save(iboProxyValue);
		}

		return new String[] { "0000", String.valueOf(forCount1 + forCount2) };
	}

	private List<IBOProxyValue> _getParentProxyValue(String proxyerId) throws Exception {
		List<IBOProxyValue> iboProxyValueList = new LinkedList<IBOProxyValue>();
		IBOProxyValue[] iboProxyValues = this.getProxy(null, null, proxyerId, null, "1");
		for (IBOProxyValue iboProxyValue : iboProxyValues) {
			if(iboProxyValue.getAuthorStaffId().equals(iboProxyValue.getCreateStaffId())){
				iboProxyValueList.add(iboProxyValue);
			}
		}
		return iboProxyValueList;
	}

	public IBOProxyShowValue[] getParentProxyValue(String proxyerId) throws Exception {
		List<IBOProxyShowValue> iboProxyShowValueList = new LinkedList<IBOProxyShowValue>();
		IBOProxyShowValue[] iboProxyShowValues = this.getProxyShow(null, null, proxyerId, null, "1");
		for (IBOProxyShowValue iboProxyShowValue : iboProxyShowValues) {
			if(iboProxyShowValue.getAuthorStaffId().equals(iboProxyShowValue.getCreateStaffId())){
				iboProxyShowValueList.add(iboProxyShowValue);
			}
		}
		IBOProxyShowValue[] iboProxyShowValuesOut = new IBOProxyShowValue[iboProxyShowValueList.size()];
		int i = 0;
		for (IBOProxyShowValue iboProxyShowValue : iboProxyShowValueList) {
			iboProxyShowValuesOut[i] = iboProxyShowValue;
			i++;
		}
		return iboProxyShowValuesOut;
	}

	public int getParentProxyValueCount(String proxyerId) throws Exception {
		List iboProxyShowValueList = new LinkedList();
		IBOProxyShowValue[] iboProxyShowValues = this.getProxyShow(null, null, proxyerId, null, "1");
		for (IBOProxyShowValue iboProxyShowValue : iboProxyShowValues) {
			if(iboProxyShowValue.getAuthorStaffId().equals(iboProxyShowValue.getCreateStaffId())){
				iboProxyShowValueList.add(iboProxyShowValue);
			}
		}
		return this.getParentProxyValue(proxyerId).length;
	}
	
	public IBOProxyShowValue getNextProxyValue(String proxyerId) throws Exception {
		IBOProxyShowValue[] iboProxyShowValues = this.getProxyShow(null, proxyerId, null, null, "1");
		for (IBOProxyShowValue iboProxyShowValue : iboProxyShowValues) {
			if(iboProxyShowValue.getAuthorStaffId().equals(iboProxyShowValue.getCreateStaffId())){
				return iboProxyShowValue;
			}
		}
		return null;
	}
}
