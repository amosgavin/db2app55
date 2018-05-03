package com.asiainfo.sale.activity.jsobject;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("request")
public class ActReq {

	Act act;
	ArrayList<Channel> channellist;
	ArrayList<Org> orglist;
	ArrayList<CustGroup> custgroupallow;
	ArrayList<CustGroup> custgroupforbid;

	public ActReq() {
		super();
	}

	public Act getAct() {
		return act;
	}

	public void setAct(Act act) {
		this.act = act;
	}

	public ArrayList<Channel> getChannellist() {
		return channellist;
	}

	public void setChannellist(ArrayList<Channel> channellist) {
		this.channellist = channellist;
	}

	public ArrayList<Org> getOrglist() {
		return orglist;
	}

	public void setOrglist(ArrayList<Org> orglist) {
		this.orglist = orglist;
	}

	public ArrayList<CustGroup> getCustgroupallow() {
		return custgroupallow;
	}

	public void setCustgroupallow(ArrayList<CustGroup> custgroupallow) {
		this.custgroupallow = custgroupallow;
	}

	public ArrayList<CustGroup> getCustgroupforbid() {
		return custgroupforbid;
	}

	public void setCustgroupforbid(ArrayList<CustGroup> custgroupforbid) {
		this.custgroupforbid = custgroupforbid;
	}

}
