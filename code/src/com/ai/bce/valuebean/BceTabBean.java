package com.ai.bce.valuebean;

import java.io.Serializable;

import com.ai.bce.ivalues.IBceFrameAreaPagetabValue;
import com.ai.bce.ivalues.IBceFrameTabitemValue;

public class BceTabBean implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô) 
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
