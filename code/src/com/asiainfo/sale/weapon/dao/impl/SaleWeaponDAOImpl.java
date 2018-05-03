package com.asiainfo.sale.weapon.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.exolab.castor.util.List;

import com.ai.appframe2.common.SessionManager;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.sale.activity.bo.BOSaleMainEngine;
import com.asiainfo.sale.tag.bo.BOPromationTagEngine;
import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponBean;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponEngine;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponSEngine;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponSignOrAduitEngine;
import com.asiainfo.sale.weapon.bo.BOWeaponTagRelaBean;
import com.asiainfo.sale.weapon.bo.BOWeaponTagRelaEngine;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponDAO;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponSValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponSignOrAduitValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;
import com.asiainfo.sale.weapon.ivalues.IBOWeaponTagRelaValue;
import com.asiainfo.task.bo.BOVmTaskEngine;

public class SaleWeaponDAOImpl implements ISaleWeaponDAO {
	// ��ѯ�����������Ƿ��ظ�
	public int selectName(String name) throws Exception, RuntimeException {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (StringUtils.isNotBlank(name)) {
			condition.append(" AND " + IBOSaleWeaponValue.S_WeaponName
					+ " = :name");
			parameter.put("name", name);
		}
		IBOSaleWeaponValue[] saleWeaponValue = BOSaleWeaponEngine.getBeans(
				condition.toString(), parameter);
		if (saleWeaponValue.length == 0) {
			return 0; // û���ظ�
		} else {
			for (int i = 0; i < saleWeaponValue.length; i++) {
				String aa = saleWeaponValue[i].getState();
				if (!saleWeaponValue[i].getState().equals("A")
						&& !saleWeaponValue[i].getState().equals("N")) {
					if (saleWeaponValue[i].getState().equals("C")) {
						return 1; // ���ظ�,״̬Ϊ���ύ
					}
					if (saleWeaponValue[i].getState().equals("W")) {
						return 2; // ���ظ�,״̬Ϊ������
					}
					if (saleWeaponValue[i].getState().equals("U")) {
						return 3; // ���ظ�,״̬Ϊ����
					}
				}
			}
			return 0; // û���ظ�
		}

	}

	// public int selectName(String id)throws Exception, RuntimeException{
	// ����������ѯ��ǩ��Ϣ
	// IBOPromationTagValue[] promationTagValue=this.getTagBeanByWeaponWid(id);
	// StringBuffer condition = new StringBuffer();
	// ArrayList btag=new ArrayList();
	// for(int i=0;i<promationTagValue.length;i++){
	// if(i==0){
	// condition.append(" select * from HBSALE.WEAPON_TAG_RELA_T where tag_id ="+promationTagValue[i].getId());
	// }else{
	// condition.append("intersect select * from HBSALE.WEAPON_TAG_RELA_T where tag_id ="+promationTagValue[i].getId());
	// }
	// btag.add(promationTagValue[i].getId());
	// }
	//		
	// //���ݱ�ǩIDȡ������ѯ����
	// BOWeaponTagRelaBean[] WeaponTagRelaBean
	// =BOWeaponTagRelaEngine.getBeansFromSql(condition.toString(),null);
	// for(int i=0;i<WeaponTagRelaBean.length;i++){
	//		
	// ArrayList atag=new ArrayList();
	// IBOPromationTagValue[]
	// apromationTagValue=this.getTagBeanByWeaponWid(WeaponTagRelaBean[i].getWeaponId());
	// System.out.print("==========="+WeaponTagRelaBean[i].getWeaponId());
	// for(int j=0;j<apromationTagValue.length;j++){
	// atag.add(apromationTagValue[j].getId());
	// }
	//			
	// if(btag.containsAll(atag)&&atag.size()==btag.size()){
	// IBOSaleWeaponValue[]
	// saleWeaponValue=this.getSaleWeaponByID(WeaponTagRelaBean[i].getWeaponId()
	// ,-1, -1);
	// if(!saleWeaponValue[0].getState().equals("A")&&!saleWeaponValue[0].getState().equals("N")){
	// if(saleWeaponValue[0].getState().equals("C")){
	// return 1; //���ظ�,״̬Ϊ���ύ
	// }
	// if(saleWeaponValue[0].getState().equals("W")){
	// return 2; //���ظ�,״̬Ϊ������
	// }
	// if(saleWeaponValue[0].getState().equals("U")){
	// return 3; //���ظ�,״̬Ϊ����
	// }
	// }
	// }
	// }
	// for(int i=0;i<saleWeaponValue.length;i++){
	// if(!saleWeaponValue[i].getId().equals(id)){
	// //String aa=saleWeaponValue[i].getState();
	// if(!saleWeaponValue[i].getState().equals("A")&&!saleWeaponValue[i].getState().equals("N")){
	// if(saleWeaponValue[i].getState().equals("C")){
	// return 1; //���ظ�,״̬Ϊ���ύ
	// }
	// if(saleWeaponValue[i].getState().equals("W")){
	// return 2; //���ظ�,״̬Ϊ������
	// }
	// if(saleWeaponValue[i].getState().equals("U")){
	// return 3; //���ظ�,״̬Ϊ����
	// }
	// }
	// }
	// }
	// return 0;
	// }

	public void delSaleWeapon(IBOSaleWeaponValue[] saleWeaponValues)
			throws Exception, RuntimeException {
		for (int i = 0; i < saleWeaponValues.length; i++) {
			saleWeaponValues[i].delete();
		}
		BOSaleWeaponEngine.save(saleWeaponValues);
	}

	public int getCount(String mid, String wwid, String wid, String name,
			String marketType, String backMonth, String baseMonth,
			String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age) throws Exception {
		Object[] objects = getCondition(mid, wwid, wid, name, marketType,
				backMonth, baseMonth, lLimit, bLimit, saleFlag,
				presentBusiMonth, busiType, netAge, couponsValue, selfBusi,
				goodAdoptDirectory, state, presentBusiAmount,
				presentReachAmount, presentValuePermon, presentBusi2Amount,
				zfqType, presentBusi4Amount, openMonth, minNet_age, maxNet_age);
		return BOSaleWeaponEngine.getBeansCount((String) objects[0],
				(Map) objects[1]);
	}

	public int getCountByID(String id) throws Exception {
		Map parameter = new HashMap();
		String condition = " 1 = 1 AND " + IBOSaleWeaponValue.S_Id + " = :id";
		parameter.put("id", id);
		return BOSaleWeaponEngine.getBeansCount(condition, parameter);
	}

	public int getCountByMainId(String mainId) throws Exception {
		Map parameter = new HashMap();
		String condition = " 1 = 1 AND " + IBOSaleWeaponValue.S_Mid
				+ " = :mainId";
		parameter.put("mainId", mainId);
		return BOSaleWeaponEngine.getBeansCount(condition, parameter);
	}

	// ����������ѯ����
	public IBOSaleWeaponValue[] getSaleWeapon(String mid, String wwid,
			String wid, String name, String marketType, String backMonth,
			String baseMonth, String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age, int startNum, int endNum)
			throws Exception {
		Object[] objects = getCondition(mid, wwid, wid, name, marketType,
				backMonth, baseMonth, lLimit, bLimit, saleFlag,
				presentBusiMonth, busiType, netAge, couponsValue, selfBusi,
				goodAdoptDirectory, state, presentBusiAmount,
				presentReachAmount, presentValuePermon, presentBusi2Amount,
				zfqType, presentBusi4Amount, openMonth, minNet_age, maxNet_age);
		String sql = (String) objects[0] + 
	    " and ("+ IBOSaleWeaponValue.S_IsDelete + "!='1' or " + IBOSaleWeaponValue.S_IsDelete+" is null)"
		+"order by "
				+ IBOSaleWeaponValue.S_CreateTime + " desc ";
		return BOSaleWeaponEngine.getBeans(null, sql, (Map) objects[1],
				startNum, endNum, false);
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
			throws Exception {
		Object[] objects = getCondition("", wwid, wid, name, marketType,
				backMonth, baseMonth, lLimit, bLimit, saleFlag,
				presentBusiMonth, busiType, netAge, couponsValue, selfBusi,
				goodAdoptDirectory, state, presentBusiAmount,
				presentReachAmount, presentValuePermon, presentBusi2Amount,
				zfqType, presentBusi4Amount, openMonth, minNet_age, maxNet_age);
		// String salef=" AND " + " (( " +IBOSaleWeaponValue.S_Org
		// +
		// " = "+SessionManager.getUser().getOrgId()+" and "+IBOSaleWeaponValue.S_SaleFlag
		// + "= '12'"+" ) or ("+IBOSaleWeaponValue.S_SaleFlag
		// + "<> '12'))";
		String sql = " (( "
				+ IBOSaleWeaponSValue.S_Org
				+ " like "
				+ "'"
				+ String.valueOf(SessionManager.getUser().getOrgId())
						.substring(0, 2) + "%'" + " and "
				+ IBOSaleWeaponSValue.S_SaleFlag + "= '12'" + " ) or ("
				+ IBOSaleWeaponSValue.S_SaleFlag + "<> '12'))" + " AND "
				+ (String) objects[0] + " order by "
				+ IBOSaleWeaponValue.S_CreateTime + " desc ";
		// return (IBOSaleWeaponSValue[]) this.getSaleWeaponSByID(wid, startNum,
		// endNum);
		return BOSaleWeaponSEngine.getBeans(null, sql, (Map) objects[1],
				startNum, endNum, false);
	}

	// ������ID��ѯ����
	public IBOSaleWeaponValue[] getSaleWeaponByID(String id, int startNum,
			int endNum) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (StringUtils.isNotBlank(id)) {
			condition.append(" AND " + IBOSaleWeaponValue.S_Id + " = :wid");
			parameter.put("wid", id);
		}
		return BOSaleWeaponEngine.getBeans(condition.toString(), parameter);
	}

	public IBOSaleWeaponSValue getSaleWeaponSByID(String id, int startNum,
			int endNum) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (StringUtils.isNotBlank(id)) {
			condition.append(" AND " + IBOSaleWeaponSValue.S_Id + " = :wid");
			parameter.put("wid", id);
		}
		return BOSaleWeaponSEngine.getBeans(condition.toString(), parameter)[0];
	}

	// ������ID��ѯ��������Ϣ
	public IBOSaleWeaponValue[] getSaleWeaponByMainId(String mainId,
			int startNum, int endNum) throws Exception {
		Map parameter = new HashMap();
		String condition = " 1 = 1 AND " + IBOSaleWeaponValue.S_Mid
				+ " = :mainId";
		parameter.put("mainId", mainId);
		return BOSaleWeaponEngine.getBeans(condition, parameter);
	}

	// ����������޸�
	public void saveSaleWeapon(IBOSaleWeaponValue[] saleWeaponValues)
			throws Exception {
		BOSaleWeaponBean[] saleWeaponBeans = BOSaleWeaponEngine
				.transfer(saleWeaponValues);
		for (int i = 0; i < saleWeaponBeans.length; i++) {
			if (saleWeaponBeans[i].isNew()
					|| 0 >= Integer.parseInt(saleWeaponBeans[i].getId())) {
				saleWeaponBeans[i].setId(BOSaleWeaponEngine.getNewId()
						.toString());
				saleWeaponValues[i]
						.setCreateTime(BOSaleMainEngine.getSysDate());
				saleWeaponValues[i].setStaffid(String.valueOf(SessionManager
						.getUser().getID()));
			}
		}
		BOSaleWeaponEngine.saveBatch(saleWeaponBeans);
	}

	/**
	 * ��ѯ����ƴװ
	 * 
	 * @param name
	 * @param marketType
	 * @param backMonth
	 * @param baseMonth
	 * @param lLimit
	 * @param bLimit
	 * @param presentPermon
	 * @param presentMonth
	 * @param pLimit
	 * @param netAge
	 * @param couponsValue
	 * @param selfBusi
	 * @param directory
	 * @return Object[] Object[0] String ��ѯ����; Object[1] Map ��ѯ����
	 */
	private Object[] getCondition(String mid, String wwid, String wid,
			String name, String marketType, String backMonth, String baseMonth,
			String lLimit, String bLimit, String saleFlag,
			String presentBusiMonth, String busiType, String netAge,
			String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state, String presentBusiAmount, String presentReachAmount,
			String presentValuePermon, String presentBusi2Amount,
			String zfqType, String presentBusi4Amount, String openMonth,
			String minNet_age, String maxNet_age) {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (StringUtils.isNotBlank(mid)) {
			condition
					.append(" AND " + IBOSaleWeaponValue.S_Staffid + " = :mid");
			parameter.put("mid", mid);
		}
		// ���
		if (wwid != null && !wwid.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_Id + " = :wid");
			parameter.put("wid", wwid);
		}
		if (wid != null && !wid.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_Mid + " = :wid");
			parameter.put("wid", wid);
		}
		// ����
		if (name != null && !name.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_WeaponName
					+ " like :name");
			parameter.put("name", "%" + name + "%");
		}
		// �г�
		if (marketType != null && !marketType.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_MarketType
					+ " = :marketType");
			parameter.put("marketType", marketType);
		}
		// ����
		// if (netAge != null && !netAge.equals("")) {
		// condition.append(" AND " + IBOSaleWeaponValue.S_NetAge
		// + " = :netAge");
		// parameter.put("netAge", netAge);
		// }
		if (minNet_age != null && !minNet_age.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_MinnetAge
					+ " >= :minNet_age");
			parameter.put("minNet_age", minNet_age);
		}
		if (maxNet_age != null && !maxNet_age.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_MaxnetAge
					+ " <= :maxNet_age");
			parameter.put("maxNet_age", maxNet_age);
		}
		// �����
		if (saleFlag != null && !saleFlag.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_SaleFlag
					+ " = :saleFlag");

			parameter.put("saleFlag", saleFlag);
		}
		// ״̬
		if (state != null && !state.equals("")) {
			if (state.equals("O")) {
				condition.append(" AND " + IBOSaleWeaponValue.S_State
						+ " in ('U','W','O','C')");
			} else {
				condition.append(" AND " + IBOSaleWeaponValue.S_State
						+ " = :state");
				parameter.put("state", state);
			}
		} else {
			condition.append(" AND " + IBOSaleWeaponValue.S_State + " != 'O'");
		}
		// �������
		if (bLimit != null && !bLimit.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_BLimit
					+ " = :bLimit");
			parameter.put("bLimit", bLimit);
		}

		// �����·�
		if (backMonth != null && !backMonth.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_BackMonth
					+ " = :backMonth");
			parameter.put("backMonth", backMonth);
		}
		// ��������
		if (baseMonth != null && !baseMonth.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_BaseMonth
					+ " = :baseMonth");
			parameter.put("baseMonth", baseMonth);
		}
		// ���׶��
		if (lLimit != null && !lLimit.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_LLimit
					+ " = :lLimit");
			parameter.put("lLimit", lLimit);
		}

		// Ԥ�滰�ѽ��
		if (couponsValue != null && !couponsValue.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_PrestoreFee
					+ " >= :couponsValue");
			parameter.put("couponsValue", couponsValue);
		}

		if (selfBusi != null && !selfBusi.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_PrestoreFee
					+ " <= :selfBusi");
			parameter.put("selfBusi", selfBusi);
		}

		// ���ͻ��ѽ��
		if (presentBusiAmount != null && !presentBusiAmount.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_PresentBusiAmount
					+ " >= :presentBusiAmount");
			parameter.put("presentBusiAmount", presentBusiAmount);
		}

		if (presentReachAmount != null && !presentReachAmount.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_PresentBusiAmount
					+ " <= :presentReachAmount");
			parameter.put("presentReachAmount", presentReachAmount);
		}
		// ����֧����
		if (presentBusi2Amount != null && !presentBusi2Amount.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_PresentBusi2Amount
					+ " = :presentBusi2Amount");
			parameter.put("presentBusi2Amount", presentBusi2Amount);
		}
		// ����֧��������

		if (zfqType != null && !zfqType.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_ZfqType
					+ "= :zfqType");
			parameter.put("zfqType", zfqType);
		}
		// ��Ʒҵ���ܼ�ֵ

		// ��Ʒ�ɹ�Ŀ¼

		// ��Ʒ����ָ����

		// ����ҵ���ܼ�ֵ
		if (presentBusi4Amount != null && !presentBusi4Amount.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_PresentBusi4Amount
					+ " = :presentBusi4Amount");
			parameter.put("presentBusi4Amount", presentBusi4Amount);
		}
		// ҵ������
		if (busiType != null && !busiType.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_BusiType
					+ " like :busiType");
			parameter.put("busiType", "%" + busiType + "%");
		}

		// �ն�ʵ�ʹ����

		// �ն�����

		// �ն�����ָ����

		// �ն˳ɱ������

		// ÿ������

		if (presentValuePermon != null && !presentValuePermon.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_PresentValuePermon
					+ " = :presentValuePermon");
			parameter.put("presentValuePermon", presentValuePermon);
		}
		// ��������
		if (presentBusiMonth != null && !presentBusiMonth.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_PresentBusiMonth
					+ " = :presentBusiMonth");
			parameter.put("presentBusiMonth", presentBusiMonth);
		}

		// ���ݰ�ÿ�¼�ֵ
		if (goodAdoptDirectory != null && !goodAdoptDirectory.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_ValuePermonth
					+ " = :goodAdoptDirectory");
			parameter.put("goodAdoptDirectory", goodAdoptDirectory);
		}
		// ���ݰ�ÿ������
		if (openMonth != null && !openMonth.equals("")) {
			condition.append(" AND " + IBOSaleWeaponValue.S_OpenMonth
					+ " = :openMonth");
			parameter.put("openMonth", openMonth);
		}

		// String salef=" AND " + " (( " +IBOSaleWeaponValue.S_Org
		// +
		// " = "+SessionManager.getUser().getOrgId()+" and "+IBOSaleWeaponValue.S_SaleFlag
		// + "= '12'"+" ) or ("+IBOSaleWeaponValue.S_SaleFlag
		// + "<> '12'))";
		// condition.append(salef);
		//	
		return new Object[] { condition.toString(), parameter };
	}

	// ��������ID�����͵õ���������
	public int getCountSignOrAduit(String wid, String taskTag) throws Exception {

		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (wid != null) {
			// System.out.println("klklklk"+name);
			condition.append(" AND " + IBOSaleWeaponSignOrAduitValue.S_Mid
					+ " = :wid");
			parameter.put("wid", wid);
		}
		if (taskTag != null && !taskTag.equals("")) {
			// System.out.println("klklklk"+name);
			condition.append(" AND " + IBOSaleWeaponSignOrAduitValue.S_TaskTag
					+ " = :taskTag");
			parameter.put("taskTag", taskTag);
		}
		return BOSaleWeaponSignOrAduitEngine.getBeansCount(
				condition.toString(), parameter);
	}

	// ��������ID�����͵õ�������Ϣ
	public IBOSaleWeaponSignOrAduitValue[] getSaleWeaponSignOrAduit(String wid,
			String taskTag, int startNum, int endNum) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		String staffid = String.valueOf(SessionManager.getUser().getID());
		if (StringUtils.isNotBlank(staffid) && !"w01".equals(taskTag)
				&& !"w02".equals(taskTag) && !"w04".equals(taskTag)
				&& !"w05".equals(taskTag)) {
			condition.append(" AND "
					+ IBOSaleWeaponSignOrAduitValue.S_TaskStaffId
					+ " = :staffid");
			parameter.put("staffid", staffid);
		}
		if (wid != null) {
			condition.append(" AND " + IBOSaleWeaponSignOrAduitValue.S_Mid
					+ " = :wid");
			parameter.put("wid", wid);
		}
		if (taskTag != null && !taskTag.equals("")) {
			condition.append(" AND " + IBOSaleWeaponSignOrAduitValue.S_TaskTag
					+ " = :taskTag");
			parameter.put("taskTag", taskTag);
		}
		return BOSaleWeaponSignOrAduitEngine.getBeans(null, condition
				.toString(), parameter, startNum, endNum, false);
	}

	// �����ʶ������������
	public void saveWeaponTagRela(BOWeaponTagRelaBean weaponTagRelaBean)
			throws Exception {
		if (weaponTagRelaBean.isNew()) {
			weaponTagRelaBean
					.setId(BOWeaponTagRelaEngine.getNewId().intValue());
		}
		BOWeaponTagRelaEngine.save(weaponTagRelaBean);
	}

	// ɾ���޸ĵ�ʱ������ͬ���͵ı�ʶ
	public void delWeaponTagRela(String wid, String tagid) throws Exception {
		// String condition = IBOWeaponTagRelaValue.S_WeaponId + " = " + wid
		// +IBOWeaponTagRelaValue.S_TagId + " = "+tagid;
		String sql = "select * from  hbsale.WEAPON_TAG_RELA_T where  weapon_id= "
				+ "'" + wid + "'" + " and tag_id = " + "'" + tagid + "'";
		// BOWeaponTagRelaBean weaponTagRelaBean=new BOWeaponTagRelaBean();
		// weaponTagRelaBean=BOWeaponTagRelaEngine.getBeansFromSql(sql,null)[0];
		BOWeaponTagRelaBean[] weaponTagRelaBean = BOWeaponTagRelaEngine
				.getBeansFromSql(sql, null);
		for (int i = 0; i < weaponTagRelaBean.length; i++) {
			weaponTagRelaBean[i].delete();
		}
		BOWeaponTagRelaEngine.save(weaponTagRelaBean);
	}

	// ��������ID�͵������͵õ�������ʶ��Ӧ�����Ϣ
	public BOWeaponTagRelaBean getWeaponTagRelaByWS(String wid, String saletype)
			throws Exception {
		String sql = "select * from  hbsale.WEAPON_TAG_RELA_T where weapon_id= "
				+ wid + " and sale_flag = " + saletype;
		return BOWeaponTagRelaEngine.getBeansFromSql(sql, null)[0];
	}

	// ��������ID�õ���ʶ����Ϣ
	public IBOPromationTagValue[] getTagBeanByWeaponWid(String wid)
			throws Exception {
		String sql = "select * from sale_tag_detail_t where id in (select tag_id from WEAPON_TAG_RELA_T a,sale_weapon_t b where a.weapon_id =b.id and a.weapon_id="
				+ wid + ")";
		return BOPromationTagEngine.getBeansFromSql(sql, null);
	}

	public IBOPromationTagValue[] getSpareTagDetailByWeaponId(String weaponId)
			throws Exception {

		String condition = IBOWeaponTagRelaValue.S_WeaponId + " = " + weaponId;
		ArrayList<IBOPromationTagValue> spareTags = new ArrayList<IBOPromationTagValue>();

		try {
			IBOWeaponTagRelaValue weaponTagRelas[] = BOWeaponTagRelaEngine
					.getBeans(condition, null);
			for (int i = 0; i < weaponTagRelas.length; ++i) {
				if (weaponTagRelas[i] != null) {
					IBOPromationTagValue temp = BOPromationTagEngine
							.getBean(Integer.parseInt(weaponTagRelas[i]
									.getTagId()));
					if (null != temp && temp.getState().equals("99")) {
						spareTags.add(temp);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IBOPromationTagValue[]) spareTags
				.toArray(new IBOPromationTagValue[spareTags.size()]);
	}

	// ������޸ı�ǩ��״̬
	public void saveTagDetail(IBOPromationTagValue[] tagDetailValues, int pid)
			throws Exception {
		for (int i = 0; i < tagDetailValues.length; i++) {
			// ��������ҪȡID
			if (tagDetailValues[i].isNew()) {
				tagDetailValues[i].setId(BOPromationTagEngine.getNewId()
						.intValue());
				tagDetailValues[i].setStsToNew();
				tagDetailValues[i].set("PID", pid);
				tagDetailValues[i].set("STATE", "3");
			}
		}
		BOPromationTagEngine.save(tagDetailValues);

	}

	// ��ѯ����״̬Ϊ�����в��ұ�ǩΪ���õı�ǩ��Ϣ
	public IBOPromationTagValue[] getWaitTagsID() throws Exception {
		String sql = " select distinct c.* from sale_Weapon_t a,WEAPON_TAG_RELA_T b,SALE_TAG_DETAIL_T c where a.id=b.weapon_id  and b.tag_id=c.id and c.state='99' and a.state='W'";
		return BOPromationTagEngine.getBeansFromSql(sql, null);
	}

	@Override
	public IBOSaleWeaponValue[] getSaleWeaponOnlyByID(String id)
			throws Exception {
		// TODO Auto-generated method stub
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (StringUtils.isNotBlank(id)) {
			condition.append(" AND " + IBOSaleWeaponValue.S_Id + " = :wid");
			parameter.put("wid", id);
		}
		return BOSaleWeaponEngine.getBeans(condition.toString(), parameter);
	}

	@Override
	public IBOSaleWeaponValue[] getSaleWeaponOnlyByMID(String mid)
			throws Exception {
		// TODO Auto-generated method stub
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (StringUtils.isNotBlank(mid)) {
			condition.append(" AND " + IBOSaleWeaponValue.S_Mid + " = :mid");
			parameter.put("mid", mid);
		}
		return BOSaleWeaponEngine.getBeans(condition.toString(), parameter);
	}

	@Override
	public void delWeapons(IBOSaleWeaponValue[] saleWeaponValues)
			throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < saleWeaponValues.length; i++) {
			saleWeaponValues[i].undelete();
			saleWeaponValues[i].setIsDelete("1");
		}
		BOSaleWeaponEngine.save(saleWeaponValues);
		
	}

	public IBOSaleWeaponValue[] getSaleWeaponByActivityId(String activityId)
			throws Exception {

		String condition = "select * from sale_weapon_t where id in (select weapon_id from sale_detail_t where sale_id in (select id from sale_main_t where order_id="
				+ activityId + "))";
		return BOSaleWeaponEngine.getBeansFromSql(condition, null);
	}

	@Override
	public int getSaleWeaponCountByActivityId(String activityId)
			throws Exception {

		return getSaleWeaponByActivityId(activityId).length;
	}

	@Override
	public IBOPromationTagValue[] getSpareTagByActivityId(String activityId)
			throws Exception {

		String condition = "SELECT st.* "
				+ "FROM (SELECT DISTINCT wt.tag_id "
				+ "FROM sale_main_t sm,"
				+ "SALE_DETAIL_T sd,"
				+ "sale_weapon_t sw, "
				+ "WEAPON_TAG_RELA_T wt "
				+ "WHERE     sm.ID = sd.SALE_ID "
				+ "AND sd.WEAPON_ID = sw.ID "
				+ "AND sw.ID = wt.WEAPON_ID "
				+ "AND sm.order_id = "
				+ activityId
				+ ") a, sale_tag_detail_t st "
				+ "WHERE a.TAG_ID = st.ID AND st.STATE = '99' AND st.tag_type <> '11'";
		return BOPromationTagEngine.getBeansFromSql(condition, null);
	}

	@Override
	public int getSpareTagCountByActivityId(String activityId) throws Exception {

		return getSpareTagByActivityId(activityId).length;
	}

	@Override
	public boolean needWeaponTestAudit(String workflowId) throws Exception {

		String condition = " WORKFLOW_ID='" + workflowId
				+ "' and TASK_TAG='wp02'";
		return (BOVmTaskEngine.getBeansCount(condition, null) > 0);
	}

}
