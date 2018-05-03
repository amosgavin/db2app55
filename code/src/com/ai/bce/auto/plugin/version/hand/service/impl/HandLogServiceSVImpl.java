package com.ai.bce.auto.plugin.version.hand.service.impl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.auto.plugin.version.hand.HandLogServiceImpl;
import com.ai.bce.auto.plugin.version.hand.bean.ColumnBean;
import com.ai.bce.auto.plugin.version.hand.bean.HandAttrBean;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerDtlParamsBean;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerDtlParamsEngine;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOpBean;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOpDtlBean;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOpDtlEngine;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOpEngine;
import com.ai.bce.auto.plugin.version.hand.dao.interfaces.IHandLogDAO;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerDtlParamsValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerHandValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOpDtlValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOpValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOrdValue;
import com.ai.bce.auto.plugin.version.hand.service.interfaces.IHandLogServiceSV;
import com.ai.bce.auto.plugin.version.hand.util.SqlUtil;
import com.ai.bce.util.BceUtil;
import com.ai.bce.util.ReflectUtils;

public class HandLogServiceSVImpl implements IHandLogServiceSV {

	public boolean logService(HandAttrBean handAttrBean) throws Exception,
			RemoteException {

		IBceVerOpDtlValue bceVerOpDtlValue = new BceVerOpDtlBean();
		bceVerOpDtlValue.setObjName(handAttrBean.getObjectClass());
		bceVerOpDtlValue
				.setOperType(String.valueOf(handAttrBean.getOperType()));
		bceVerOpDtlValue.setState(BceUtil.STATE_NOMAL);
		long dtl_id = BceVerOpDtlEngine.getNewId().longValue();
		bceVerOpDtlValue.setDtlId(dtl_id);
		bceVerOpDtlValue.setOpId(handAttrBean.getOpId());
		bceVerOpDtlValue.setTabName(handAttrBean.getTableName());
		List clomnes = handAttrBean.getClomnes();
		IBceVerDtlParamsValue[] paramsValues = new IBceVerDtlParamsValue[clomnes
				.size()];
		for (int i = 0; i < clomnes.size(); i++) {
			IBceVerDtlParamsValue bceVerDtlParamsValue = new BceVerDtlParamsBean();
			bceVerDtlParamsValue.setDtlId(dtl_id);
			bceVerDtlParamsValue.setState(BceUtil.STATE_NOMAL);
			ColumnBean columnBean = (ColumnBean) clomnes.get(i);
			bceVerDtlParamsValue.setColumnName(columnBean.getClomnName());
			bceVerDtlParamsValue.setNewValue(columnBean.getNewValue());
			bceVerDtlParamsValue.setOldValue(columnBean.getOldValue());
			bceVerDtlParamsValue.setValueType(columnBean.getValueType());
			bceVerDtlParamsValue.setIsPk(columnBean.isPk()?1:0);
			bceVerDtlParamsValue.setDtlParamId(BceVerDtlParamsEngine.getNewId()
					.longValue());
			//bceVerDtlParamsValue.setIsPk(1);
			paramsValues[i] = bceVerDtlParamsValue;
		}
		IHandLogDAO handLogDAO = (IHandLogDAO) ServiceFactory
				.getService(IHandLogDAO.class);
		handLogDAO.saveVerOpDtl(bceVerOpDtlValue, paramsValues);
		return true;
	}

	public IBceVerOpValue logServiceOrd(HandAttrBean handAttrBean)
			throws Exception, RemoteException {
		IHandLogDAO handLogDAO = (IHandLogDAO) ServiceFactory
				.getService(IHandLogDAO.class);
		IBceVerOpValue bceVerOpValue = new BceVerOpBean();
		bceVerOpValue.setOpId(BceVerOpEngine.getNewId().longValue());
		bceVerOpValue.setOrdId(new Long(handAttrBean.getOrdSn()).longValue());
		bceVerOpValue.setOpDate(BceUtil.getTimestampByDate(new Date()));
		bceVerOpValue.setServiceId(handAttrBean.getServiceId());
		bceVerOpValue.setMethodName(handAttrBean.getMethodName());
		bceVerOpValue.setState(BceUtil.STATE_NOMAL);
		bceVerOpValue.setOpUser(handAttrBean.getOpId());
		bceVerOpValue.setYearM(ReflectUtils.getFormatDate(new Date(),
				ReflectUtils.FORMATE_YEAR_MONTH));
		bceVerOpValue = handLogDAO.saveVerOp(bceVerOpValue);
		return bceVerOpValue;
	}

	/**
	 * 创建订单服务
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param verOrdValue
	 * @param
	 * @return
	 * @param
	 * @throws Exception
	 * @param
	 * @throws RemoteException
	 *             设定文件
	 * @return 返回类型
	 * @throws
	 */
	public IBceVerOrdValue createOrder(IBceVerOrdValue verOrdValue)
			throws Exception, RemoteException {

		IHandLogDAO handLogDAO = (IHandLogDAO) ServiceFactory
				.getService(IHandLogDAO.class);
		handLogDAO.createOrder(verOrdValue);
		return verOrdValue;
	}

	public IBceVerHandValue lodServiceHand(IBceVerHandValue verHandValue)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IHandLogDAO handLogDAO = (IHandLogDAO) ServiceFactory
				.getService(IHandLogDAO.class);
		handLogDAO.createVerHand(verHandValue);
		return verHandValue;
	}

	public boolean setVerOrdSn(String ordSn) throws Exception, RemoteException {
		// TODO Auto-generated method stub
		ServiceManager.getUser().set(HandLogServiceImpl.VERSION_ORD_SN, ordSn);
		return true;
	}

	public String exportSQlByOrdId(long ordId,boolean isHf) throws Exception {
		StringBuffer sql = new StringBuffer();
		IBceVerOpValue[] opValues = getOpValuesByOrdId(ordId,isHf);
		IBceVerOrdValue ordValue = getOrdValueByOrdId(ordId);
		sql.append("/**\n系统版本号：" + ordValue.getVersionId() + "\n需求单名称:"
				+ ordValue.getOrdName() + "\n需求单申请人：" + ordValue.getApplyUser()
				+ "\n需求单申请日期：" + ordValue.getCreatDate() + "\n需要单操作人:\n需求单ID："
				+ ordValue.getOrdUseId() + "\n备注：" + ordValue.getRemarks()
				+ "\n**/");
		for (int i = 0; i < opValues.length; i++) {
			IBceVerOpDtlValue[] opDtlValues = getOpDtlValuesByOpId(opValues[i]
					.getOpId(),isHf);
			sql.append("\n");
			for (int j = 0; j < opDtlValues.length; j++) {
				String tableName = opDtlValues[j].getTabName();
				String opType = opDtlValues[j].getOperType();
				IBceVerDtlParamsValue[] paramsValues = getOpParamsByDtlId(opDtlValues[j]
						.getDtlId());
				
				Map newValue = new HashMap();
				Map oldValue = new HashMap();
				Map columnType = new HashMap();
				/*IBceVerTabinfoValue[] verTabinfoValue = getBceVerTabInfoValuesByTabName(tableName);*/
				/*String[] pk = new String[verTabinfoValue.length];
				for (int k = 0; k < verTabinfoValue.length; k++) {
					pk[k] = verTabinfoValue[k].getPrimaryCol();
				}*/
				List pkList = new LinkedList();
				for (int k = 0; k < paramsValues.length; k++) {
					IBceVerDtlParamsValue paramsValue = paramsValues[k];
					newValue.put(paramsValue.getColumnName(), paramsValue
							.getNewValue());
					oldValue.put(paramsValue.getColumnName(), paramsValue
							.getOldValue());
					columnType.put(paramsValue.getColumnName(), paramsValue
							.getValueType());
					if(paramsValue.getIsPk()==1)
						pkList.add(paramsValue.getColumnName());
				}
				String oSql = "";
				String[] pk = (String[]) pkList.toArray(new String[0]);
				int IopType = Integer.valueOf(opType).intValue();
				if(!isHf)
					 oSql = SqlUtil.exportSqlByDtl(tableName, oldValue, newValue, pk,
						opType, columnType);
				else
					oSql = SqlUtil.exportSqlByDtl(tableName, newValue,oldValue , pk,
							IopType==1?"2":IopType==2?"1":"3", columnType);
				sql.append(oSql);
				sql.append("\n");
			}
		}
		return sql.toString();
	}

/*	private IBceVerTabinfoValue[] getBceVerTabInfoValuesByTabName(
			String tableName) throws Exception {
		// TODO Auto-generated method stub
		IHandLogDAO handLogDAO = (IHandLogDAO) ServiceFactory
		.getService(IHandLogDAO.class);

		return handLogDAO.getBceVerTabInfoValuesByTabName(tableName);
	}
*/
	private IBceVerOrdValue getOrdValueByOrdId(long ordId) throws Exception {
		// TODO Auto-generated method stu
		IHandLogDAO handLogDAO = (IHandLogDAO) ServiceFactory
		.getService(IHandLogDAO.class);
		
		return handLogDAO.getOrdValueByOrdId(ordId);
	}

	

	private IBceVerDtlParamsValue[] getOpParamsByDtlId(long dtlId)
			throws Exception {
		// TODO Auto-generated method stub
		IHandLogDAO handLogDAO = (IHandLogDAO) ServiceFactory
				.getService(IHandLogDAO.class);

		return handLogDAO.getOpParamsByDtlId(dtlId);
	}

	private IBceVerOpDtlValue[] getOpDtlValuesByOpId(long opId, boolean isHf)
			throws Exception {
		// TODO Auto-generated method stub
		IHandLogDAO handLogDAO = (IHandLogDAO) ServiceFactory
				.getService(IHandLogDAO.class);

		return handLogDAO.getOpDtlValuesByOpId(opId,isHf);
	}

	private IBceVerOpValue[] getOpValuesByOrdId(long ordId, boolean isHf) throws Exception {
		// TODO Auto-generated method stub
		IHandLogDAO handLogDAO = (IHandLogDAO) ServiceFactory
				.getService(IHandLogDAO.class);

		return handLogDAO.getOpValuesByOrdId(ordId,isHf);
	}

	
}
