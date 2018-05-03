package com.asiainfo.stopSelling.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.stopSelling.ivalues.*;

public class BOStopSellMBean extends DataContainer implements DataContainerInterface,IBOStopSellMValue{

  private static String  m_boName = "com.asiainfo.stopSelling.bo.BOStopSellM";



  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_State = "STATE";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_OrgName = "ORG_NAME";
  public final static  String S_ItemType = "ITEM_TYPE";
  public final static  String S_PropTime = "PROP_TIME";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_Mainid = "MAINID";
  public final static  String S_PropStaff = "PROP_STAFF";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_Tel = "TEL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOStopSellMBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initApplyName(String value){
     this.initProperty(S_ApplyName,value);
  }
  public  void setApplyName(String value){
     this.set(S_ApplyName,value);
  }
  public  void setApplyNameNull(){
     this.set(S_ApplyName,null);
  }

  public String getApplyName(){
       return DataType.getAsString(this.get(S_ApplyName));
  
  }
  public String getApplyNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ApplyName));
      }

  public void initRemark1(String value){
     this.initProperty(S_Remark1,value);
  }
  public  void setRemark1(String value){
     this.set(S_Remark1,value);
  }
  public  void setRemark1Null(){
     this.set(S_Remark1,null);
  }

  public String getRemark1(){
       return DataType.getAsString(this.get(S_Remark1));
  
  }
  public String getRemark1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark1));
      }

  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initRemark2(String value){
     this.initProperty(S_Remark2,value);
  }
  public  void setRemark2(String value){
     this.set(S_Remark2,value);
  }
  public  void setRemark2Null(){
     this.set(S_Remark2,null);
  }

  public String getRemark2(){
       return DataType.getAsString(this.get(S_Remark2));
  
  }
  public String getRemark2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark2));
      }

  public void initRemark3(String value){
     this.initProperty(S_Remark3,value);
  }
  public  void setRemark3(String value){
     this.set(S_Remark3,value);
  }
  public  void setRemark3Null(){
     this.set(S_Remark3,null);
  }

  public String getRemark3(){
       return DataType.getAsString(this.get(S_Remark3));
  
  }
  public String getRemark3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark3));
      }

  public void initRemark4(String value){
     this.initProperty(S_Remark4,value);
  }
  public  void setRemark4(String value){
     this.set(S_Remark4,value);
  }
  public  void setRemark4Null(){
     this.set(S_Remark4,null);
  }

  public String getRemark4(){
       return DataType.getAsString(this.get(S_Remark4));
  
  }
  public String getRemark4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark4));
      }

  public void initDescription(String value){
     this.initProperty(S_Description,value);
  }
  public  void setDescription(String value){
     this.set(S_Description,value);
  }
  public  void setDescriptionNull(){
     this.set(S_Description,null);
  }

  public String getDescription(){
       return DataType.getAsString(this.get(S_Description));
  
  }
  public String getDescriptionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Description));
      }

  public void initOrgName(String value){
     this.initProperty(S_OrgName,value);
  }
  public  void setOrgName(String value){
     this.set(S_OrgName,value);
  }
  public  void setOrgNameNull(){
     this.set(S_OrgName,null);
  }

  public String getOrgName(){
       return DataType.getAsString(this.get(S_OrgName));
  
  }
  public String getOrgNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrgName));
      }

  public void initItemType(String value){
     this.initProperty(S_ItemType,value);
  }
  public  void setItemType(String value){
     this.set(S_ItemType,value);
  }
  public  void setItemTypeNull(){
     this.set(S_ItemType,null);
  }

  public String getItemType(){
       return DataType.getAsString(this.get(S_ItemType));
  
  }
  public String getItemTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ItemType));
      }

  public void initPropTime(Timestamp value){
     this.initProperty(S_PropTime,value);
  }
  public  void setPropTime(Timestamp value){
     this.set(S_PropTime,value);
  }
  public  void setPropTimeNull(){
     this.set(S_PropTime,null);
  }

  public Timestamp getPropTime(){
        return DataType.getAsDateTime(this.get(S_PropTime));
  
  }
  public Timestamp getPropTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_PropTime));
      }

  public void initIsDelete(String value){
     this.initProperty(S_IsDelete,value);
  }
  public  void setIsDelete(String value){
     this.set(S_IsDelete,value);
  }
  public  void setIsDeleteNull(){
     this.set(S_IsDelete,null);
  }

  public String getIsDelete(){
       return DataType.getAsString(this.get(S_IsDelete));
  
  }
  public String getIsDeleteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsDelete));
      }

  public void initMainid(int value){
     this.initProperty(S_Mainid,new Integer(value));
  }
  public  void setMainid(int value){
     this.set(S_Mainid,new Integer(value));
  }
  public  void setMainidNull(){
     this.set(S_Mainid,null);
  }

  public int getMainid(){
        return DataType.getAsInt(this.get(S_Mainid));
  
  }
  public int getMainidInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Mainid));
      }

  public void initPropStaff(String value){
     this.initProperty(S_PropStaff,value);
  }
  public  void setPropStaff(String value){
     this.set(S_PropStaff,value);
  }
  public  void setPropStaffNull(){
     this.set(S_PropStaff,null);
  }

  public String getPropStaff(){
       return DataType.getAsString(this.get(S_PropStaff));
  
  }
  public String getPropStaffInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PropStaff));
      }

  public void initPrincipal(String value){
     this.initProperty(S_Principal,value);
  }
  public  void setPrincipal(String value){
     this.set(S_Principal,value);
  }
  public  void setPrincipalNull(){
     this.set(S_Principal,null);
  }

  public String getPrincipal(){
       return DataType.getAsString(this.get(S_Principal));
  
  }
  public String getPrincipalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Principal));
      }

  public void initOrgId(String value){
     this.initProperty(S_OrgId,value);
  }
  public  void setOrgId(String value){
     this.set(S_OrgId,value);
  }
  public  void setOrgIdNull(){
     this.set(S_OrgId,null);
  }

  public String getOrgId(){
       return DataType.getAsString(this.get(S_OrgId));
  
  }
  public String getOrgIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrgId));
      }

  public void initTel(String value){
     this.initProperty(S_Tel,value);
  }
  public  void setTel(String value){
     this.set(S_Tel,value);
  }
  public  void setTelNull(){
     this.set(S_Tel,null);
  }

  public String getTel(){
       return DataType.getAsString(this.get(S_Tel));
  
  }
  public String getTelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Tel));
      }
  public void undelete(){
	  super.m_isDeleted=false;
  }

 
 }

