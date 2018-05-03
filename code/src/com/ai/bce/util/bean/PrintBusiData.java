package com.ai.bce.util.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
//import com.asiainfo.crm.so.common.print.interfacesclass.ISoBusiPrintInfo;

public class PrintBusiData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2084442485946595617L;
	private long pk ;//对应于数据库中的流水
	private String businessId ;//对应的是bce中的businessId
	private long customerOrdId = 0;
	private String billId=null;
	private Map printInfoData = null;//必须传remarkInfo 各个业务反馈回来的描述信息：比如 新订购XXX套餐  套餐变更 退订
	private Map printInfoIdData = null;//产品信息（用来给平台装载特殊信息） 产品Id
	private String printType ; //如果不传 默认为Crm侧打印
	private String regionId;
	private String bceFrameId;
	private long userId;
	private Map<String,Object> extendsMap;//扩展备用map用来传送扩展字段的值
	
	
	public void setIntoExtendsMap(String key,Object obj){
		if(null==extendsMap){
			extendsMap = new HashMap<String, Object>();
		}
		extendsMap.put(key, obj);
	}
	
	public Object getFromExtendsMap(String key){
		if(null!=extendsMap && !extendsMap.isEmpty()){
			if(extendsMap.containsKey(key)){
				return extendsMap.get(key);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setPrintType(String print_Type){
		if(StringUtils.isEmpty(print_Type)){
			//this.printType=ISoBusiPrintInfo.CRM_PRINT;
		}else{
			this.printType=print_Type;
		}
	}
	public String getPrintType() {
		return printType;
	}	

	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public long getCustomerOrdId() {
		return customerOrdId;
	}
	public void setCustomerOrdId(long customerOrdId) {
		this.customerOrdId = customerOrdId;
	}
	public long getPk() {
		return pk;
	}
	public void setPk(long pk) {
		this.pk = pk;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public Map getPrintInfoData() {
		return printInfoData;
	}
	public void setPrintInfoData(Map printInfoData) {
		this.printInfoData = printInfoData;
	}
	public Map getPrintInfoIdData() {
		return printInfoIdData;
	}
	public void setPrintInfoIdData(Map printInfoIdData) {
		this.printInfoIdData = printInfoIdData;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getBceFrameId() {
		return bceFrameId;
	}
	public void setBceFrameId(String bceFrameId) {
		this.bceFrameId = bceFrameId;
	}
	
	
}
