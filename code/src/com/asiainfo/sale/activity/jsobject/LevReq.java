package com.asiainfo.sale.activity.jsobject;

import java.util.ArrayList;

public class LevReq {

	Level level;
	ArrayList<Channel> channellist;
	ArrayList<Org> orglist;
	ArrayList<CustGroup> custgroupallow;
	ArrayList<CustGroup> custgroupforbid;

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
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
