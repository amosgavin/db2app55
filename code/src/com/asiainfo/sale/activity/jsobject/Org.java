package com.asiainfo.sale.activity.jsobject;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ORGID")
public class Org {

	String ORGID;

	public String getORGID() {
		return ORGID;
	}

	public void setORGID(String oRGID) {
		ORGID = oRGID;
	}

}
