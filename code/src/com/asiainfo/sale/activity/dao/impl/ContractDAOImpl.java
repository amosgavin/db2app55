package com.asiainfo.sale.activity.dao.impl;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.sale.activity.bo.BOContractEngine;
import com.asiainfo.sale.activity.dao.interfaces.IContractDAO;
import com.asiainfo.sale.activity.ivalues.IBOContractValue;

public class ContractDAOImpl implements IContractDAO{

	@Override
	public int getContractCountBySql(String saleMainCode, String saleMainName,
			String saleActiveCode, String saleActiveName, String isContract)
			throws Exception {
		String condition=getCondition(saleMainCode,
				saleMainName,saleActiveCode,saleActiveName,isContract);
		return BOContractEngine.getBeansCount(condition, null);
	}

	@Override
	public IBOContractValue[] getContractInfoBySql(String saleMainCode,
			String saleMainName, String saleActiveCode, String saleActiveName,
			String isContract, int startNum, int endNum) throws Exception {
		String condition=getCondition(saleMainCode,
				saleMainName,saleActiveCode,saleActiveName,isContract);
		String sql="SELECT a.sale_main_code,    "+  
		"       a.sale_main_name,    "+
		"       b.sale_active_code,  "+
		"       b.sale_active_name,  "+
		"       b.RESERVE2,          "+
		"       b.IS_CONTRACT        "+
		"  FROM sale_main_t a,       "+
		"  sale_detail_t b           "+
		" WHERE a.id = b.sale_id     "+
		" and b.RESERVE2=1 and       "+condition;
		// return BOContractEngine.getBeansFromSql(sql, null);
		return BOContractEngine.getBeans(null, condition
				+ " order by sale_active_code desc ", null, startNum, endNum, false);
	}
	
	private String getCondition(String saleMainCode, String saleMainName,
			String saleActiveCode, String saleActiveName, String isContract) throws Exception {

		String condition = " 1=1 ";
		if (saleMainCode != null && !saleMainCode.equals("")) {
			condition += " and sale_main_code = '"
					+ saleMainCode+"'";
		}
		if (saleMainName != null && !saleMainName.equals("")) {
			condition += " and sale_main_name like '%"
					+ URLDecoder.decode(saleMainName, "utf-8") + "%'";
		}
		if (saleActiveCode != null && !saleActiveCode.equals("")) {
			condition += " and sale_active_code = '"
					+ saleActiveCode +"'";
		}
		if (saleActiveName != null && !saleActiveName.equals("")) {
			condition += " and sale_active_name like '%"
					+ URLDecoder.decode(saleActiveName, "utf-8") + "%'";
		}
		if (isContract != null && !isContract.equals("")) {
			if(isContract.equals("null")){
				condition += " and is_contract is null ";
			}else{
			condition += " and is_contract = '"
					+ isContract +"'";
			}
		}
		return condition;
	}

	@Override
	public String saveContract(IBOContractValue[] ContractValues)
			throws Exception, RuntimeException {
		for(int i = 0; i<ContractValues.length; i++){
			IBOContractValue ContractValue=ContractValues[i];
			String iscontract = ContractValue.getIsContract();
			String sale_active_code = ContractValue.getSaleActiveCode();
			String sql="";
			if(iscontract.equals("null")){
				sql = "update hbsale.sale_detail_t set is_contract="+iscontract+" where sale_active_code='"+sale_active_code+"'";
			}else{
			sql = "update hbsale.sale_detail_t set is_contract='"+iscontract+"'"+" where sale_active_code='"+sale_active_code+"'";
			}
			try {
				Connection conn = ServiceManager.getSession().getConnection();
				Statement st = conn.createStatement();
                st.executeUpdate(sql);
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
