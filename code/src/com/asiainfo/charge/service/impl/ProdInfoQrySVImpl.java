package com.asiainfo.charge.service.impl;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.secframe.orgmodel.ivalues.IBOSecStaffValue;
import com.ai.secframe.orgmodel.service.interfaces.ISecOperatorSV;
import com.asiainfo.charge.bo.BOProductExtBean;
import com.asiainfo.charge.bo.BOProductExtDescBean;
import com.asiainfo.charge.dao.interfaces.IProdInfoQryDAO;
import com.asiainfo.charge.ivalues.IBOProductExtDescValue;
import com.asiainfo.charge.ivalues.IBOProductExtValue;
import com.asiainfo.charge.service.interfaces.IProdInfoQrySV;
import com.asiainfo.common.service.impl.AbstractProductExtSVImpl;

public class ProdInfoQrySVImpl extends AbstractProductExtSVImpl implements
		IProdInfoQrySV {

	public DataContainer[] getBasicProdInfo(String cols, String prodName,
			String type, String attrId, String privId, String condStr,
			int startrowindex, int endrowindex) throws Exception {
		if (null != prodName) {
			prodName = URLDecoder.decode(prodName, "utf-8");
		}
		if (null != condStr) {
			condStr = URLDecoder.decode(condStr, "utf-8");
		}
		System.out.println("condStr====" + condStr);
		return getDao().getBasicProdInfo(cols, prodName, type, attrId, privId,
				condStr, startrowindex, endrowindex);

	}

	public int getBasicProdInfoCount(String cols, String prodName, String type,
			String attrId, String privId, String condStr) throws Exception {
		if (null != prodName) {
			prodName = URLDecoder.decode(prodName, "utf-8");
		}

		if (null != condStr) {
			condStr = URLDecoder.decode(condStr, "utf-8");
		}
		int count = getDao().getBasicProdInfoCount(cols, prodName, type,
				attrId, privId, condStr);
		return count;

	}

	public IProdInfoQryDAO getDao() {

		return (IProdInfoQryDAO) ServiceFactory
				.getService(IProdInfoQryDAO.class);

	}

	/**
	 * 向扩展字段中插入初始值
	 */
	public void saveInitialValues(String extType, String staffId)
			throws Exception {
		IProdInfoQryDAO dao = getDao();
		List extList = new ArrayList();
		if (null != extType && !extType.equals("")) {

			if (extType.equals("GPRS")) { // gprs
				dao.initialGprsValue(extType);

			} else {
				dao.initialBasicValue(extType);
			}
		} else {
			return;
		}

	}

	public void changeSts(String privId, String attrId, String state,
			String extType, String staffId) throws Exception {
		IProdInfoQryDAO dao = getDao();
		IBOProductExtValue dataValue = dao.getDataValue(privId, attrId,
				extType, "1");
		if (null != dataValue) {

			dataValue.setState(state);
			dataValue.setStaffId(staffId);
			dataValue.setModifyDate(new Timestamp(System.currentTimeMillis()));
			dao
					.saveProductExtValue(new BOProductExtBean[] { (BOProductExtBean) dataValue });
		}

	}

	public void saveProductExtValue(IBOProductExtValue[] saveValues)
			throws Exception {

		IProdInfoQryDAO dao = getDao();
		dao.saveProductExtValue(saveValues);
	}

	public DataContainer[] qryProductInfoHis(String displayCols,
			String basicCols, String tableName, String privId, String attrId,
			String state, String extType, int startIndex, int endIndex)
			throws Exception {

		IProdInfoQryDAO dao = getDao();
		DataContainer[] values = dao
				.qryProductInfoHis(displayCols, basicCols, tableName, privId,
						attrId, state, extType, startIndex, endIndex);
		ISecOperatorSV staffSv = (ISecOperatorSV) ServiceFactory
				.getService(ISecOperatorSV.class);
		for (int i = 0; i < values.length; i++) {
			String staffId = values[i].getAsString("STAFF_ID");
			IBOSecStaffValue staffValue = staffSv.getStaffById(Long
					.parseLong(staffId));
			values[i].set("STAFF_ID", staffValue.getStaffName());

		}

		return values;
	}

	public int qryProductInfoHisCount(String displayCols, String basicCols,
			String tableName, String privId, String attrId, String state,
			String extType) throws Exception {
		IProdInfoQryDAO dao = getDao();
		return dao.qryProductInfoHisCount(displayCols, basicCols, tableName,
				privId, attrId, state, extType);

	}

//	public IBOProductExtDescValue[] getExtAttrs(String privType)
//			throws Exception {
//		IProdInfoQryDAO dao = getDao();
//		if (null == privType || "".equals(privType)) {
//			return new BOProductExtDescBean[0];
//		}
//		return dao.getColsName("", privType, "1", "1", -1, -1);
//
//	}

}
