package com.asiainfo.sale.weapon.service.impl;

import java.net.URLDecoder;
import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.sale.weapon.bo.BOWeaponTagRelaBean;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponDAO;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponSValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponSignOrAduitValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV;

public class SaleWeaponSVImpl implements ISaleWeaponSV {
	public int selectName(String name) throws Exception, RuntimeException {
		return ((ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class)).selectName(name);
	}

	// 删除武器和标签对应关系
	public void delWeaponTagRela(String wid, String tagid) throws Exception {
		((ISaleWeaponDAO) ServiceFactory.getService(ISaleWeaponDAO.class))
				.delWeaponTagRela(wid, tagid);
	}

	public void delSaleWeapon(IBOSaleWeaponValue[] saleWeaponValues) {
	}

	public int getCount(String mid, String wwid, String wid, String name,
			String marketType, String backMonth, String baseMonth,
			String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age) throws Exception,
			RuntimeException {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getCount(mid, wwid, wid, URLDecoder.decode(name,
				"utf-8"), marketType, backMonth, baseMonth, lLimit, bLimit,
				saleFlag, presentBusiMonth, busiType, netAge, couponsValue,
				selfBusi, goodAdoptDirectory, state, presentBusiAmount,
				presentReachAmount, presentValuePermon, presentBusi2Amount,
				zfqType, presentBusi4Amount, openMonth, minNet_age, maxNet_age);
	}

	public int getCountByID(String id) throws Exception, RuntimeException {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getCountByID(id);
	}

	public int getCountByMainId(String mainId) throws Exception,
			RuntimeException {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getCountByMainId(mainId);
	}

	public IBOSaleWeaponValue[] getSaleWeapon(String mid, String wwid,
			String wid, String name, String marketType, String backMonth,
			String baseMonth, String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age, int startNum, int endNum)
			throws Exception, RuntimeException {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getSaleWeapon(mid, wwid, wid, URLDecoder.decode(
				name, "utf-8"), marketType, backMonth, baseMonth, lLimit,
				bLimit, saleFlag, presentBusiMonth, URLDecoder.decode(busiType,
						"utf-8"), netAge, couponsValue, selfBusi,
				goodAdoptDirectory, state, presentBusiAmount,
				presentReachAmount, presentValuePermon, presentBusi2Amount,
				zfqType, presentBusi4Amount, openMonth, minNet_age, maxNet_age,
				startNum, endNum);
	}

	public IBOSaleWeaponSValue[] getSaleWeaponS(String wwid, String wid,
			String name, String marketType, String backMonth, String baseMonth,
			String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age, int startNum, int endNum)
			throws Exception, RuntimeException {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getSaleWeaponS(wwid, wid, name, marketType,
				backMonth, baseMonth, lLimit, bLimit, saleFlag,
				presentBusiMonth, busiType, netAge, couponsValue, selfBusi,
				goodAdoptDirectory, state, presentBusiAmount,
				presentReachAmount, presentValuePermon, presentBusi2Amount,
				zfqType, presentBusi4Amount, openMonth, minNet_age, maxNet_age,
				startNum, endNum);
	}

	public IBOSaleWeaponValue[] getSaleWeaponByID(String id, int startNum,
			int endNum) throws Exception, RuntimeException {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getSaleWeaponByID(id, startNum, endNum);
	}

	public IBOSaleWeaponSValue getSaleWeaponSByID(String id, int startNum,
			int endNum) throws Exception, RuntimeException {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getSaleWeaponSByID(id, startNum, endNum);
	}

	public IBOSaleWeaponValue[] getSaleWeaponByMainId(String mainId,
			int startNum, int endNum) throws Exception, RuntimeException {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getSaleWeaponByMainId(mainId, startNum, endNum);
	}

	public void saveSaleWeapon(IBOSaleWeaponValue[] saleWeaponValues)
			throws Exception, RuntimeException {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		saleWeaponDAO.saveSaleWeapon(saleWeaponValues);
	}

	public int getCountSignOrAduit(String wid, String taskTag)
			throws Exception, RuntimeException {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getCountSignOrAduit(wid, taskTag);
	}

	public IBOSaleWeaponSignOrAduitValue[] getSaleWeaponSignOrAduit(String wid,
			String taskTag, int startNum, int endNum) throws Exception,
			RuntimeException {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getSaleWeaponSignOrAduit(wid, taskTag, startNum,
				endNum);
	}

	public void saveWeaponTagRela(BOWeaponTagRelaBean weaponTagRelaBean)
			throws Exception {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		saleWeaponDAO.saveWeaponTagRela(weaponTagRelaBean);
	}

	public IBOPromationTagValue[] getTagBeanByWeaponWid(String wid)
			throws Exception {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getTagBeanByWeaponWid(wid);
	}

	public IBOPromationTagValue[] getSpareTagDetailByWeaponId(String weaponId)
			throws Exception {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getSpareTagDetailByWeaponId(weaponId);
	}

	public void saveTagDetail(IBOPromationTagValue[] tagDetailValues, int pid)
			throws Exception {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		saleWeaponDAO.saveTagDetail(tagDetailValues, pid);

	}

	public IBOPromationTagValue[] getWaitTagsID() throws Exception {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getWaitTagsID();
	}

	public BOWeaponTagRelaBean getWeaponTagRelaByWS(String wid, String saletype)
			throws Exception {
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getWeaponTagRelaByWS(wid, saletype);
	}

	public void changeWeaponState(String mainId, String state) throws Exception {
		IBOSaleWeaponValue[] weapons = this.getSaleWeaponByMainId(mainId, 1, 1);
		// 武器一对多修改
		for (int i = 0; i < weapons.length; i++) {

			weapons[i].setState(state);
		}
		this.saveSaleWeapon(weapons);

	}

	@Override
	public IBOSaleWeaponValue[] getSaleWeaponOnlyByID(String id)
			throws Exception, RuntimeException {
		// TODO Auto-generated method stub
		if (id != null && !id.equals("")) {
			ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
					.getService(ISaleWeaponDAO.class);
			return saleWeaponDAO.getSaleWeaponOnlyByID(id);
		} else {
			return null;
		}
	}

	@Override
	public IBOSaleWeaponValue[] getSaleWeaponOnlyByMID(String mid)
			throws Exception, RuntimeException {
		// TODO Auto-generated method stub
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		return saleWeaponDAO.getSaleWeaponOnlyByMID(mid);
	}

	@Override
	public void delWeapons(IBOSaleWeaponValue[] saleWeaponValues)
			throws Exception, RuntimeException {
		// TODO Auto-generated method stub
		ISaleWeaponDAO saleWeaponDAO = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		saleWeaponDAO.delWeapons(saleWeaponValues);
	}

	public IBOSaleWeaponValue[] getSaleWeaponByActivityId(String activityId)
			throws Exception, RuntimeException {
		return ((ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class))
				.getSaleWeaponByActivityId(activityId);
	}

	@Override
	public int getSaleWeaponCountByActivityId(String activityId)
			throws Exception {

		return ((ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class))
				.getSaleWeaponCountByActivityId(activityId);
	}

	@Override
	public IBOPromationTagValue[] getSpareTagByActivityId(String activityId)
			throws Exception {

		return ((ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class))
				.getSpareTagByActivityId(activityId);
	}

	@Override
	public int getSpareTagCountByActivityId(String activityId) throws Exception {

		return ((ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class))
				.getSpareTagCountByActivityId(activityId);
	}

	@Override
	public boolean needWeaponTestAudit(String workflowId) throws Exception {

		return ((ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class))
				.needWeaponTestAudit(workflowId);
	}
}
