package com.asiainfo.sale.complain.dao.impl;

import com.asiainfo.sale.complain.bo.BOOrderComplainsDetailEngine;
import com.asiainfo.sale.complain.dao.interfaces.IOrderComplainDetailDAO;
import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsDetailValue;

public class OrderComplainDetailDAOImpl implements IOrderComplainDetailDAO {

	@Override
	public void deleteOrderComplainDetailBatch(
			IBOOrderComplainsDetailValue[] orderComplainDetailValues)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBOOrderComplainsDetailValue getOrderComplainDetailByID(String Id)
			throws Exception {
		// TODO Auto-generated method stub
		if(Id != null && !Id.equals("")){
			return BOOrderComplainsDetailEngine.getBean(Integer.parseInt(Id));
		}
		return null;
	}

	@Override
	public IBOOrderComplainsDetailValue[] getOrderComplainDetailByPID(
			String complainId, int startNum, int endNum) throws Exception {
		// TODO Auto-generated method stub
		if (complainId != null && !complainId.equals("")) {
			String condition = IBOOrderComplainsDetailValue.S_ComplainsId + " = "
					+ complainId +" and is_delete is null";
			return BOOrderComplainsDetailEngine.getBeans(null, condition, null,
					startNum, endNum, false);
		}
		return null;
	}

	@Override
	public int getOrderComplainDetailCountByPID(String complainId)
			throws Exception {
		// TODO Auto-generated method stub
		if (complainId != null && !complainId.equals("")) {
			String condition = IBOOrderComplainsDetailValue.S_ComplainsId + " = "
					+ complainId +" and is_delete is null";
			return BOOrderComplainsDetailEngine.getBeansCount(condition, null);
		}
		return 0;
	}

	@Override
	public boolean isExistBatchId(String batchId, String batchType)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveOrderComplainDetail(
			IBOOrderComplainsDetailValue OrderComplainDetailValue)
			throws Exception {
		// TODO Auto-generated method stub
		int Did = OrderComplainDetailValue.getId();
		if(OrderComplainDetailValue != null){
			if(OrderComplainDetailValue.isNew()){
				Did = BOOrderComplainsDetailEngine.getNewId().intValue();
				OrderComplainDetailValue.setId(Did);
				OrderComplainDetailValue.setStsToNew();
			}
			BOOrderComplainsDetailEngine.save(OrderComplainDetailValue);
		}
		return Did;
	}

	@Override
	public void delOrderComplainDetail(
			IBOOrderComplainsDetailValue[] OrderComplainDetailValues)
			throws Exception {
		// TODO Auto-generated method stub
		if(OrderComplainDetailValues != null){
			for(int i = 0;i<OrderComplainDetailValues.length;i++){
				OrderComplainDetailValues[i].undelete();
				OrderComplainDetailValues[i].setIsDelete("1");
			}
			BOOrderComplainsDetailEngine.save(OrderComplainDetailValues);
		}
	}

}
