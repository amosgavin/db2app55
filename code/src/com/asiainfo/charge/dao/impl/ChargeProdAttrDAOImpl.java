package com.asiainfo.charge.dao.impl;

import java.rmi.RemoteException;
import java.util.HashMap;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.util.StringUtils;
import com.ai.common.util.ExceptionUtil;
import com.asiainfo.charge.bo.BOChargeApplyProdAttrEngine;
import com.asiainfo.charge.bo.BOChargeApplyProdAttrExtEngine;
import com.asiainfo.charge.bo.BOChargeInfoExtEngine;
import com.asiainfo.charge.dao.interfaces.IChargeMainDeDAO;
import com.asiainfo.charge.dao.interfaces.IChargeProdAttrDAO;
import com.asiainfo.charge.ivalues.IBOChargeApplyProdAttrExtValue;
import com.asiainfo.charge.ivalues.IBOChargeApplyProdAttrValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoExtValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;
import com.asiainfo.charge.service.interfaces.IChargeMainDeSV;

public class ChargeProdAttrDAOImpl implements IChargeProdAttrDAO {

	private IChargeMainDeDAO getChargeMainDeDAO() {

		return (IChargeMainDeDAO) ServiceFactory
				.getService(IChargeMainDeDAO.class);
	}

	@Override
	public void saveProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues)
			throws Exception, RemoteException {

		for (int i = 0; i < prodAttrValues.length; i++) {
			if (prodAttrValues[i].isNew()) {
				String getSeqByProdAttrId = BOChargeApplyProdAttrEngine
						.getNewId().toString();
				if (null == prodAttrValues[i].getApplyId()
						|| "" == prodAttrValues[i].getApplyId()) {
					prodAttrValues[i].setApplyId(getSeqByProdAttrId);
				}
			}
			if (prodAttrValues[i].isModified()) {
				// prodAttrValues[i].setOperType("2");
			}
		}

		BOChargeApplyProdAttrEngine.saveBatch(prodAttrValues);

	}

	@Override
	public void delProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues)
			throws Exception, RemoteException {
		for (int i = 0; i < prodAttrValues.length; i++) {
			// if (Log.isDebugEnabled()) {
			// Log.debug(prodAttrValues[i]);
			// }
			prodAttrValues[i].delete();
		}

		BOChargeApplyProdAttrEngine.saveBatch(prodAttrValues);
	}

	@Override
	public IBOChargeApplyProdAttrExtValue getProdAttrExtById(String chargeId)
			throws Exception, RemoteException {

		HashMap paramMap = new HashMap();
		StringBuffer condition = new StringBuffer(" 1=1 ");

		if (!StringUtils.isEmptyString(chargeId)) {
			condition.append(" and ").append(
					IBOChargeApplyProdAttrExtValue.S_ChargeId).append(
					" = :chargeId ");
			paramMap.put("chargeId", chargeId);
		}

		IBOChargeApplyProdAttrExtValue[] values = BOChargeApplyProdAttrExtEngine
				.getBeans(condition.toString(), paramMap);
		if (values.length > 0) {
			return values[0];
		} else {
			return null;
		}

	}

	@Override
	public String saveProdAttrExt(IBOChargeApplyProdAttrExtValue objProdAttrExt)
			throws Exception, RemoteException {
		if (null != objProdAttrExt) {
			if (objProdAttrExt.isNew()) {
				objProdAttrExt.setApplyId(BOChargeApplyProdAttrExtEngine
						.getNewId().toString());
				objProdAttrExt.setCreateTime(BOChargeApplyProdAttrExtEngine
						.getSysDate());
				objProdAttrExt.setOperType("1");
				// objProdAttrExt.setStsToNew();
			}
			if (objProdAttrExt.isModified()) {
				// IBOChargeApplyProdAttrExtValue tempValue =
				// BOChargeApplyProdAttrExtEngine.getBean(IBOChargeApplyProdAttrExtValue.getId());
				// String operType = objProdAttrExt.getOperType();
				objProdAttrExt.setModifyTime(BOChargeApplyProdAttrExtEngine
						.getSysDate());
				objProdAttrExt.setOperType("2");
				// IBOChargeApplyProdAttrExtValue[] oldValues = new
				// IBOChargeApplyProdAttrExtValue[] {objProdAttrExt};
				// this.saveProdAttrExtToHis(oldValues);
			}

			BOChargeApplyProdAttrExtEngine.save(objProdAttrExt);
			boolean isModProdAttr = false;
			IBOChargeApplyProdAttrValue[] prodAttrValues = (IBOChargeApplyProdAttrValue[]) getProdAttrById(
					objProdAttrExt.getChargeId(), -1, -1);
			for (int i = 0; i < prodAttrValues.length; i++) {
				String applyMainId = prodAttrValues[i].getApplyMainId();
				if (StringUtils.isEmptyString(applyMainId)) {
					prodAttrValues[i].setApplyMainId(objProdAttrExt
							.getApplyId()); // CHARGE_APPLY_PROD_ATTR_T与CHARGE_APPLY_PROD_ATTR_EXT_T表关联起来
					isModProdAttr = true;
				}

			}
			if (isModProdAttr) {
				saveProdAttr(prodAttrValues);
			}

			// 更新新资费结构的档次套餐名称
			String itemName = objProdAttrExt.getApplyName();
			String chargeId = objProdAttrExt.getChargeId();
			if (!StringUtils.isEmptyString(chargeId)) {
				IBOChargeInfoValue chargeMainValue = getChargeMainDeDAO()
						.IChargeMainDeshow(chargeId);
				chargeMainValue.setExt5(itemName);
				chargeMainValue.setExt6(1);
				getChargeMainDeDAO().saveChargeMainDe(chargeMainValue);
			}

			return objProdAttrExt.getChargeId();
		} else {
			ExceptionUtil.throwBusinessException("没有需要保存的数据",
					"IBOChargeApplyProdAttrExtValue");
			return null;
		}
	}

	@Override
	public IBOChargeApplyProdAttrValue[] getProdAttrById(String chargeId,
			int startNum, int endNum) throws Exception, RemoteException {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap paramMap = new HashMap();

		if (!StringUtils.isEmptyString(chargeId)) {
			condition.append(" and ").append(
					IBOChargeApplyProdAttrValue.S_ChargeId).append(
					" = :chargeId ");
			paramMap.put("chargeId", chargeId);
		}
		condition.append(" order by ").append(
				IBOChargeApplyProdAttrValue.S_ApplyId);

		return BOChargeApplyProdAttrEngine.getBeans(null, condition.toString(),
				paramMap, startNum, endNum, false);
	}

	@Override
	public int getProdAttrCount(String chargeId) throws Exception,
			RemoteException {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap paramMap = new HashMap();

		if (!StringUtils.isEmptyString(chargeId)) {
			condition.append(" and ").append(
					IBOChargeApplyProdAttrValue.S_ChargeId).append(
					" = :chargeId ");
			paramMap.put("chargeId", chargeId);
		}

		return BOChargeApplyProdAttrEngine.getBeansCount(condition.toString(),
				paramMap);
	}

	public void updateChargeInfo(String chargeId, String prodItemName)
			throws Exception, RuntimeException {
		IChargeMainDeSV chargeMainDeSV = (IChargeMainDeSV) ServiceFactory
				.getService(IChargeMainDeSV.class);
		if (!StringUtils.isEmptyString(chargeId)
				&& !StringUtils.isEmptyString(prodItemName)) {
			IBOChargeInfoValue chargeInfoValue = chargeMainDeSV
					.IChargeMainDeshow(chargeId);
			chargeInfoValue.setExt5(prodItemName);
			chargeMainDeSV.saveChargeMainDe(chargeInfoValue);
		}

	}

	public void saveProdAttr(IBOChargeApplyProdAttrValue[] prodAttrValues,
			IBOChargeInfoExtValue[] infoExtValues) throws Exception {
		
		if (null != prodAttrValues ) {
			for (int i = 0; i < prodAttrValues.length; i++) {
				if (prodAttrValues[i].isNew()) {
					String getSeqByProdAttrId = BOChargeApplyProdAttrEngine
							.getNewId().toString();
					if (null == prodAttrValues[i].getApplyId()
							|| "" == prodAttrValues[i].getApplyId()) {
						prodAttrValues[i].setApplyId(getSeqByProdAttrId);
					}
					if (null != infoExtValues && i < infoExtValues.length ) {
						infoExtValues[i].setApplyId(getSeqByProdAttrId);
						infoExtValues[i]
								.setMid(prodAttrValues[i].getChargeId());
					}

				}
				if (prodAttrValues[i].isModified()) {
					if (null != infoExtValues && i < infoExtValues.length) {
						if (infoExtValues[i].isNew()) {
							infoExtValues[i].setApplyId(prodAttrValues[i]
									.getApplyId());
							infoExtValues[i].setMid(prodAttrValues[i]
									.getChargeId());
						}
					}
				}
				
				if(null!=infoExtValues && i < infoExtValues.length){
					String type = prodAttrValues[i].getProdType();
					if("1".equals(type)){
						type ="VOICE";
					}else if ("2".equals(type)) {
						type = "SMS";

					} else if ("3".equals(type)) {
						type = "MMS";
					} else if ("4".equals(type)) {
						type = "GPRSNOBUSY";
					}
					
					infoExtValues[i].setPrivType(type);
					infoExtValues[i].setStatus("1");
				}
			}

			BOChargeApplyProdAttrEngine.saveBatch(prodAttrValues);
			if (null != infoExtValues && infoExtValues.length > 0) {
				BOChargeInfoExtEngine.save(infoExtValues);
			}
		} else if (null != infoExtValues) {
			for (int j = 0; j < infoExtValues.length; j++) {
				infoExtValues[j].setStatus("1");
			}
			BOChargeInfoExtEngine.save(infoExtValues);
		}

	}

}