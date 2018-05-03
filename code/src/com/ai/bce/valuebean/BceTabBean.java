package com.ai.bce.valuebean;

import java.io.Serializable;

import com.ai.bce.ivalues.IBceFrameAreaPagetabValue;
import com.ai.bce.ivalues.IBceFrameTabitemValue;

public class BceTabBean implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	IBceFrameAreaPagetabValue areaPagetabValue;
	IBceFrameTabitemValue[] tabitemValues;

	public IBceFrameAreaPagetabValue getAreaPagetabValue() {
		return areaPagetabValue;
	}

	public void setAreaPagetabValue(IBceFrameAreaPagetabValue areaPagetabValue) {
		this.areaPagetabValue = areaPagetabValue;
	}

	public IBceFrameTabitemValue[] getTabitemValues() {
		return tabitemValues;
	}

	public void setTabitemValues(IBceFrameTabitemValue[] tabitemValues) {
		this.tabitemValues = tabitemValues;
	}

}
