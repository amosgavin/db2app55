package com.asiainfo.sale.tag.web;

import java.util.HashMap;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.comframe.client.ComframeClient;
import com.asiainfo.workflow.workflowstat.bo.BOWorkflowStatBean;
import com.asiainfo.sale.tag.ivalues.IBOHPApplyValue;
import com.asiainfo.sale.tag.bo.BOHPApplyBean;
import com.asiainfo.sale.tag.service.interfaces.ITagDetailSV;

public class ProductBossIdMain {

	public static void main(String[] args) {
	 try{
		 ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory.getService(ITagDetailSV.class);
	    //使用武器申请id作为货品BOSSID申请id
 		//如果不存在工单类型为"productCase",且存在有未配置的货品，则发起货品配置流程
 		StringBuffer condition = new StringBuffer();
 		condition.append(" "+BOWorkflowStatBean.S_WorkflowObjectType+" =:type");
 		HashMap<String,String> parameter = new HashMap<String,String>();
 		parameter.put("type", "productCase");
		HashMap<String,String> aVars = new HashMap<String,String>();
		aVars.put("staff", "20004966");
 		while(true){
 			int cnt = ComframeClient.getWorkflowCount("HB", condition.toString(), parameter);
 	 		if(cnt<=0&&tagDetailSV.haveTagCode()){
 	 			IBOHPApplyValue aValue = new BOHPApplyBean();
 	 			String vorgId = "10";
 	 			String newId = tagDetailSV.saveProductApply(aValue);
 				CenterFactory.setDirectCenterInfo(new CenterInfo("0", vorgId));
 	 	 		ComframeClient.createWorkflow("template.ProductBossId", "20005238", "productCase" , newId, aVars, null, null);
 				CenterFactory.setCenterInfoEmpty();
 	 		}
 		}
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }
	}
}
