package com.ai.bce.util.bean;

import java.io.Serializable;
import java.util.Date;

import com.ai.common.util.TimeUtil;

public class PrintProductInfo implements Serializable{
	//产品编号
	private long prod_id;
	//生效时间
	private String effective_Date;
	//失效时间
	private String expire_Date;
	//标识 增加 0/取消 1
	private long flag;
	
	public String getEffective_Date() {
		return effective_Date;
	}
	public void setEffective_Date(Date effective_Date) {
		this.effective_Date = TimeUtil.getTruncDate(effective_Date).toString();
	}
	public String getExpire_Date() {
		return expire_Date;
	}
	public void setExpire_Date(Date expire_Date) {
		this.expire_Date = TimeUtil.getTruncDate(expire_Date).toString();
	}
	public long getFlag() {
		return flag;
	}
	public void setFlag(long flag) {
		this.flag = flag;
	}
	public long getProd_id() {
		return prod_id;
	}
	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}
	
	
}
