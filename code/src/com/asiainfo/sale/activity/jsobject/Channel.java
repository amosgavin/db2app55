package com.asiainfo.sale.activity.jsobject;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("channel")
public class Channel {

	String CHANNELID;
	String OPERATION;
	String REGION;

	public String getCHANNELID() {
		return CHANNELID;
	}
	public void setCHANNELID(String cHANNELID) {
		CHANNELID = cHANNELID;
	}
	public String getOPERATION() {
		return OPERATION;
	}
	public void setOPERATION(String oPERATION) {
		OPERATION = oPERATION;
	}
	public String getREGION() {
		return REGION;
	}
	public void setREGION(String rEGION) {
		REGION = rEGION;
	}

}
