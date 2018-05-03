package com.ai.bce.util.bean;

import java.io.Serializable;
import java.util.Date;

import com.ai.common.util.TimeUtil;

public class PrintProductInfo implements Serializable{
	//��Ʒ���
	private long prod_id;
	//��Чʱ��
	private String effective_Date;
	//ʧЧʱ��
	private String expire_Date;
	//��ʶ ���� 0/ȡ�� 1
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
