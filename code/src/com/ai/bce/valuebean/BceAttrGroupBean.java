/***********************************************************************
 * Module:       BceAttrGroupBean.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Dec 22, 2010
 ***********************************************************************/

package com.ai.bce.valuebean;

import java.util.ArrayList;
import java.util.List;

import com.ai.appframe2.web.tag.FieldItemInterface;

public class BceAttrGroupBean{
   private long id;
   private String title;
   private boolean isVisiable = false;
   private boolean isAllowStract;
   private boolean isFrameClosed;
   private String groupStyle;
   private String attr1;
   private String attr2;
   private String attr3;
   private String attr4;
   private String attr5;
   private int visiableCount = 0;
   private List fieldList = new ArrayList();
   
  public void addVisiableCount(){
  	visiableCount++;
  }
  
	public List getFieldList() {
		return fieldList;
	}
	public void addField(FieldItemInterface fieldItem) {
		this.fieldList.add(fieldItem);
	}
	public String getGroupStyle() {
		return groupStyle;
	}
	public void setGroupStyle(String groupStyle) {
		this.groupStyle = groupStyle;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isAllowStract() {
		return isAllowStract;
	}
	public void setAllowStract(boolean isAllowStract) {
		this.isAllowStract = isAllowStract;
	}
	public boolean isFrameClosed() {
		return isFrameClosed;
	}
	public void setFrameClosed(boolean isFrameClosed) {
		this.isFrameClosed = isFrameClosed;
	}
	public boolean isVisiable() {
		if(isVisiable == true){
			isVisiable = visiableCount > 0;
		}
		return isVisiable;
	}
	public void setVisiable(boolean isVisiable) {
		this.isVisiable = isVisiable;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getAttr2() {
		return attr2;
	}
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	public String getAttr3() {
		return attr3;
	}
	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}
	public String getAttr4() {
		return attr4;
	}
	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}
	public String getAttr5() {
		return attr5;
	}
	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}
   
}
