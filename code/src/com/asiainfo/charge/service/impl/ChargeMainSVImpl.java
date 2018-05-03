package com.asiainfo.charge.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.common.ivalues.IBOBsStaticDataValue;
import com.ai.common.util.ExceptionUtil;
import com.ai.common.util.StaticDataUtil;
import com.asiainfo.charge.dao.interfaces.IChargeMainDAO;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainDeValue;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;
import com.asiainfo.charge.service.interfaces.IChargeMainSV;

public class ChargeMainSVImpl implements IChargeMainSV {
	public void delChargeMain(String id) throws Exception{
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		chargeMainDAO.delChargeMain(id);
	}
	
	public void chargeStateToUse(String id)throws Exception, RuntimeException{
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		chargeMainDAO.chargeStateToUse(id);
	}
	
	public void chargeStateToNoUse(String id)throws Exception, RuntimeException{
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		chargeMainDAO.chargeStateToNoUse(id);
	}
	public IBOChargeApplyMainValue IChargeMainshow(String id) throws Exception {
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		return chargeMainDAO.IChargeMainshow(id);
	}

	public void delChargeDetail(String applyid) throws Exception{
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		chargeMainDAO.delChargeDetail(applyid);
	}
	
	public void delChargeDetail(IBOChargeInfoValue[] IBOChargeInfoValue) throws Exception {
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		chargeMainDAO.delChargeDetail(IBOChargeInfoValue);
	}

	@Override
	public IBOChargeInfoValue[] getChargeDetailByFeeType(String mainId, String feetype, int startNum, int endNum) throws Exception {
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		return chargeMainDAO.getChargeDetailByFeeType(mainId, feetype, startNum, endNum);
	}

	@Override
	public int getCountByFeeType(String mainId, String feetype) throws Exception {
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		return chargeMainDAO.getCountByFeeType(mainId, feetype);
	}

	@Override
	public String saveChargeMain(IBOChargeApplyMainValue chargeMainValue) throws Exception, RuntimeException {
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		return chargeMainDAO.saveChargeMain(chargeMainValue);
	}

	@Override
	public void saveChargeMain(IBOChargeApplyMainValue[] chargeMainValue) throws Exception, RuntimeException {
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		chargeMainDAO.saveChargeMain(chargeMainValue);
	}

	@Override
	public IBOChargeApplyMainDeValue[] ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname, int $startrowindex,
			int $endrowindex) throws Exception, RuntimeException {
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		return chargeMainDAO.ChargeMainshow(applyid, feetype, applyTime, applyEndTime, principle, isSubmit, townname, appname, $startrowindex, $endrowindex);

	}

	@Override
	public int ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname) throws Exception, RuntimeException {
		IChargeMainDAO chargeMainDAO = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		return chargeMainDAO.ChargeMainshow(applyid, feetype, applyTime, applyEndTime, principle, isSubmit, townname, appname);
	}

	@Override
	public void saveChargeConcessDetailInfo(IBOChargeConcessDetailInfoValue[] chargeConcessDetailInfoValues) throws Exception, RuntimeException {
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		if (chargeConcessDetailInfoValues != null && chargeConcessDetailInfoValues.length > 0) {
			dao.saveChargeConcessDetailInfo(chargeConcessDetailInfoValues);
		} else {
			ExceptionUtil.throwBusinessException("没有需要保存的数据！");
		}
	}

	/**
	 * 查询记录总条数
	 */
	@Override
	public int queryChargeConcessDetailInfoCountByConssId(String concessId) throws Exception, RuntimeException {
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		Map<Object, String> map = new HashMap<Object, String>();
		map.put(IBOChargeConcessDetailInfoValue.S_Conssid, concessId);
		return dao.queryChargeConcessDetailInfoCount(map);
	}
	
	@Override
	public IBOChargeConcessDetailInfoValue[] queryChargeConcessDetailInfoByConssId(String concessId,   int start, int end)throws Exception, RuntimeException {
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		Map<Object, String> map = new HashMap<Object, String>();
		map.put(IBOChargeConcessDetailInfoValue.S_Conssid, concessId);
		IBOChargeConcessDetailInfoValue[] chargeConcessDetailInfoValues = dao.queryChargeConcessDetailInfo(map, start, end);
		IBOBsStaticDataValue[] staticDataValues = StaticDataUtil	.getStaticData("YHB_BUSI_TYPE_DATA");
		for (int i = 0; i < chargeConcessDetailInfoValues.length; i++) {
			for (int j = 0; j < staticDataValues.length; j++) {
				if(staticDataValues[j].getCodeValue().equals(chargeConcessDetailInfoValues[i].getDetailType())){
					chargeConcessDetailInfoValues[i].setDetailType(staticDataValues[j].getCodeName());
				}
			}
		}
		return chargeConcessDetailInfoValues;
	}

	@Override
	public IBOChargeConcessInfoValue[] queryChargeConcessInfo(String concessId, int start, int end) throws Exception, RuntimeException {
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		Map<Object, String> map = new HashMap<Object, String>();
		map.put(IBOChargeConcessInfoValue.S_Concessid, concessId);
		IBOChargeConcessInfoValue[] chargeConcessInfoValues = dao.queryChargeConcessInfo(map, start, end);
		return chargeConcessInfoValues;
	}

	@Override
	public int queryChargeConcessInfoCount(String concessId) throws Exception, RuntimeException {
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		Map<Object, String> map = new HashMap<Object, String>();
		map.put(IBOChargeConcessInfoValue.S_Concessid, concessId);
		return dao.queryChargeConcessInfoCount(map);
	}

	@Override
	public int saveChargeConcessInfo(IBOChargeConcessInfoValue[] chargeConcessInfoValues) throws Exception, RuntimeException {
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		if (chargeConcessInfoValues != null && chargeConcessInfoValues.length > 0) {
			int concessId = dao.saveChargeConcessInfo(chargeConcessInfoValues);
			return concessId;
		} else {
			ExceptionUtil.throwBusinessException("没有需要保存的数据！");
		}
		return 0;
	}

	@Override
	public  int findChargeConcessByMid(String mid) throws Exception, RuntimeException {
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		if (mid != null ) {
			int concessId = dao.findChargeConcessByMid(mid);
			return concessId;
		} else {
			ExceptionUtil.throwBusinessException("没有需要保存的数据！");
		}
		return 0;
	}

	@Override
	public IBOChargeConcessInfoValue[] findChargeConcessByConcessId(String concessId) throws Exception, RuntimeException {
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		if (concessId != null ) {
			IBOChargeConcessInfoValue [] values = dao.findChargeConcessByConcessId(concessId);
			return values;
		} else {
			ExceptionUtil.throwBusinessException("没有需要保存的数据！");
		}
		return null;
	}
	
	public String cloneSaleMain (String id, String staffId, String orgId,String mid)throws Exception, RuntimeException{
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
	 return	dao.cloneSaleMain(id, staffId, orgId,mid);
	}
	
	public void changeChargeState(String mid,String state)throws Exception, RuntimeException{
		IBOChargeApplyMainValue iBOChargeApplyMainValue = this.IChargeMainshow(mid);
		iBOChargeApplyMainValue.setIsSubmit(state);
		this.saveChargeMain(iBOChargeApplyMainValue);
	}

	@Override
	public String codeRepeat(String id) throws Exception, RuntimeException {
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		return dao.codeRepeat(id);
		
	}
	
	public boolean haveBossId(String id)throws Exception, RuntimeException{
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		return dao.haveBossId(id);
	}
	
	public IBOChargeInfoValue[] getChargeDetailByNewMainid(String mainId, int startNum, int endNum)  throws Exception{
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		return dao.getChargeDetailByNewMainid(mainId, startNum, endNum);
	}
	
	public int getChargeDetailByNewMainidCount(String mainId)  throws Exception{
		IChargeMainDAO dao = (IChargeMainDAO) ServiceFactory.getService(IChargeMainDAO.class);
		return dao.getChargeDetailByNewMainidCount(mainId);
	}
}
