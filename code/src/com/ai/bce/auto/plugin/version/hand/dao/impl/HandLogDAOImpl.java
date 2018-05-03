package com.ai.bce.auto.plugin.version.hand.dao.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.ai.bce.auto.plugin.version.hand.bo.BceVerDtlParamsEngine;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerHandEngine;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOpDtlEngine;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOpEngine;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOrdEngine;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerTabinfoEngine;
import com.ai.bce.auto.plugin.version.hand.dao.interfaces.IHandLogDAO;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerDtlParamsValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerHandValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOpDtlValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOpValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOrdValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerTabinfoValue;
import com.ai.bce.ivalues.IBceSimpleFuncValue;

public class HandLogDAOImpl implements IHandLogDAO {

	public IBceVerOpValue saveVerOp(IBceVerOpValue opValue) throws Exception,
			RemoteException {
		// TODO Auto-generated method stub

		BceVerOpEngine.save(opValue);
		return opValue;
	}

	public void saveVerOpDtl(IBceVerOpDtlValue opDtlValue,
			IBceVerDtlParamsValue[] dtlParamsValues) throws Exception,
			RemoteException {
		// TODO Auto-generated method stub
		BceVerOpDtlEngine.save(opDtlValue);
		for (int i = 0; i < dtlParamsValues.length; i++) {
			BceVerDtlParamsEngine.save(dtlParamsValues[i]);
		}
	}

	public IBceVerOrdValue createOrder(IBceVerOrdValue verOrdValue)
			throws Exception, RemoteException {
		verOrdValue.setOrdId(BceVerOrdEngine.getNewId().longValue());
		// TODO Auto-generated method stub
		BceVerOrdEngine.save(verOrdValue);
		return verOrdValue;
	}

	public void createVerHand(IBceVerHandValue verHandValue) throws Exception,
			RemoteException {
		// TODO Auto-generated method stub
		verHandValue.setVersionId(BceVerHandEngine.getNewId().longValue());
		// TODO Auto-generated method stub
		BceVerHandEngine.save(verHandValue);
	}

	public IBceVerOpDtlValue[] getOpDtlValuesByOpId(long opId,boolean isHf) throws Exception {
		// TODO Auto-generated method stub
		String cond = IBceVerOpDtlValue.S_OpId + " = :opid and state = 1 ";
		if(isHf)
			cond+=" order by "+IBceVerOpDtlValue.S_DtlId +" desc ";
		else
			cond+=" order by "+IBceVerOpDtlValue.S_DtlId +" asc ";
		Map param = new HashMap();
		param.put("opid", new Long(opId));
		return BceVerOpDtlEngine.getBeans(cond, param);
	}

	public IBceVerDtlParamsValue[] getOpParamsByDtlId(long dtlId) throws Exception {
		// TODO Auto-generated method stub
		String cond = IBceVerDtlParamsValue.S_DtlId + " = :opid and state = 1 ";
		Map param = new HashMap();
		param.put("opid", new Long(dtlId));
		return BceVerDtlParamsEngine.getBeans(cond,param);
	}

	public IBceVerOpValue[] getOpValuesByOrdId(long ordId,boolean isHf) throws Exception {
		// TODO Auto-generated method stub
		String cond = IBceVerOpValue.S_OrdId + " = :opid and state = 1 ";
		if(isHf)
			cond+=" order by "+IBceVerOpValue.S_OpId +" desc ";
		else
			cond+=" order by "+IBceVerOpValue.S_OpId +" asc ";
		Map param = new HashMap();
		param.put("opid", new Long(ordId));
		return BceVerOpEngine.getBeans(cond,param);
	}

	public IBceVerTabinfoValue[] getBceVerTabInfoValuesByTabName(
			String tableName) throws Exception {
		// TODO Auto-generated method stub
		String cond = IBceVerTabinfoValue.S_TableName + " = :opid and state = 1 ";
		Map param = new HashMap();
		param.put("opid", tableName);
		return BceVerTabinfoEngine.getBeans(cond, param);
	}

	public IBceVerOrdValue getOrdValueByOrdId(long ordId) throws Exception {
		// TODO Auto-generated method stub
		return BceVerOrdEngine.getBean(ordId);
	}

}
