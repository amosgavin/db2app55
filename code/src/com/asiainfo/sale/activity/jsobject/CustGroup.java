package com.asiainfo.sale.activity.jsobject;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("custgroupforbid")
public class CustGroup {

	String CUSTGROUPID;
	String REGION;
	String BEGINDATE;
	String ENDDATE;

	public String getCUSTGROUPID() {
		return CUSTGROUPID;
	}

	public void setCUSTGROUPID(String cUSTGROUPID) {
		CUSTGROUPID = cUSTGROUPID;
	}

	public String getREGION() {
		return REGION;
	}

	public void setREGION(String rEGION) {
		REGION = rEGION;
	}

	public String getBEGINDATE() {
		return BEGINDATE;
	}

	public void setBEGINDATE(String bEGINDATE) {
		BEGINDATE = bEGINDATE;
	}

	public String getENDDATE() {
		return ENDDATE;
	}

	public void setENDDATE(String eNDDATE) {
		ENDDATE = eNDDATE;
	}

}
