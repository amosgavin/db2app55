package com.asiainfo.sale.activity.web;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.sale.activity.bo.BOContractBean;
import com.asiainfo.sale.activity.bo.BOMainDetailContractBean;
import com.asiainfo.sale.activity.ivalues.IBOContractValue;
import com.asiainfo.sale.activity.ivalues.IBOMainDetailContractValue;
import com.asiainfo.sale.activity.service.interfaces.IContractSV;
import com.asiainfo.sale.activity.service.interfaces.IMainDetailContractSV;

public class MainDetailContractAction extends BaseAction{
	private transient static Log log = LogFactory.getLog(MainDetailContractAction.class);

	public void saveContract(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOMainDetailContractBean.class });


		IBOMainDetailContractValue[] ContractValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOMainDetailContractBean[]) {
				ContractValues = (BOMainDetailContractBean[]) obj;
			}
		}

		IMainDetailContractSV ContractSV = (IMainDetailContractSV) ServiceFactory
				.getService(IMainDetailContractSV.class);

		try {
			if (null == ContractValues || 0 == ContractValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				ContractSV.saveContract(ContractValues);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	public void makeSure(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		CustomProperty cp = CustomProperty.getInstance();
		Calendar cal =Calendar.getInstance();
		int year =cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		String month2 = "" + year + (month < 10 ? "0" + month : month);
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql="insert into hbsale.Contract_sure(month,flag,create_time) values ('"+month2+"','1',current timestamp)";
		try{
			conn = ConnectUtil.getConnection();
			st = conn.createStatement();
			st.executeUpdate(sql);
			cp.set("FLAG", "Y");
			}catch(Exception e){
				cp.set("FLAG", "N");
				e.printStackTrace();
			}finally{
				HttpUtil.showInfo(response, cp);
				try {
					if (rs != null)
						rs.close();
					if (st != null)
						st.close();
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	public void querymakeSure(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		CustomProperty cp = CustomProperty.getInstance();
		Calendar cal =Calendar.getInstance();
		int year =cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		String month2 = "" + year + (month < 10 ? "0" + month : month);
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String flag ="0";
		String sql="select flag from hbsale.Contract_sure where month = '"+month2+"'";
		try{
			conn = ConnectUtil.getConnection();
			st = conn.createStatement();
			rs =st.executeQuery(sql);
			if(rs.next()){
			flag =rs.getString("FLAG");
			}
			if(flag.equals("1")){
			cp.set("FLAG", flag);
			}
			else if (flag.equals("0") || flag == null || flag.equals("")){
				cp.set("FLAG", "0");
			}
			}catch(Exception e){
				cp.set("FLAG", flag);
				e.printStackTrace();
			}finally{
				HttpUtil.showInfo(response, cp);
				try {
					if (rs != null)
						rs.close();
					if (st != null)
						st.close();
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	public void queryremain(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		CustomProperty cp = CustomProperty.getInstance();
		String count="";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql="SELECT count (*)               "+ 
		"  FROM (SELECT b.IS_CONTRACT              "+
		"   FROM hbsale.sale_main_t a, hbsale.sale_detail_t b    "+
		"WHERE a.id = b.sale_id AND b.RESERVE2 = 1 "+
		"  AND b.IS_CONTRACT IS NULL               "+
		" UNION ALL                                "+
		" SELECT IS_CONTRACT                       "+
		"   FROM hbsale.MAIN_DETAIL_CONTRACT              "+
		"  WHERE IS_CONTRACT IS NULL)              ";
		try{
			conn = ConnectUtil.getConnection();
			st = conn.createStatement();
			rs =st.executeQuery(sql);
			if(rs.next()){
				count =rs.getString("1");
				cp.set("COUNT", count);
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				HttpUtil.showInfo(response, cp);
				try {
					if (rs != null)
						rs.close();
					if (st != null)
						st.close();
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}
