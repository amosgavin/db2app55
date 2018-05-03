package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOAppriseMarkBean extends DataContainer implements DataContainerInterface,IBOAppriseMarkValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOAppriseMark";



  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_DealTime = "DEAL_TIME";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_ReadTime = "READ_TIME";
  public final static  String S_IsReaded = "IS_READED";
  public final static  String S_AppriseFlag = "APPRISE_FLAG";
  public final static  String S_Depart = "DEPART";
  public final static  String S_OrganizeId = "ORGANIZE_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOAppriseMarkBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initOrganizeName(String value){
     this.initProperty(S_OrganizeName,value);
  }
  public  void setOrganizeName(String value){
     this.set(S_OrganizeName,value);
  }
  public  void setOrganizeNameNull(){
     this.set(S_OrganizeName,null);
  }

  public String getOrganizeName(){
       return DataType.getAsString(this.get(S_OrganizeName));
  
  }
  public String getOrganizeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrganizeName));
      }

  public void initDealTime(Timestamp value){
     this.initProperty(S_DealTime,value);
  }
  public  void setDealTime(Timestamp value){
     this.set(S_DealTime,value);
  }
  public  void setDealTimeNull(){
     this.set(S_DealTime,null);
  }

  public Timestamp getDealTime(){
        return DataType.getAsDateTime(this.get(S_DealTime));
  
  }
  public Timestamp getDealTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_DealTime));
      }

  public void initSendTime(Timestamp value){
     this.initProperty(S_SendTime,value);
  }
  public  void setSendTime(Timestamp value){
     this.set(S_SendTime,value);
  }
  public  void setSendTimeNull(){
     this.set(S_SendTime,null);
  }

  public Timestamp getSendTime(){
        return DataType.getAsDateTime(this.get(S_SendTime));
  
  }
  public Timestamp getSendTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_SendTime));
      }

  public void initStaffName(String value){
     this.initProperty(S_StaffName,value);
  }
  public  void setStaffName(String value){
     this.set(S_StaffName,value);
  }
  public  void setStaffNameNull(){
     this.set(S_StaffName,null);
  }

  public String getStaffName(){
       return DataType.getAsString(this.get(S_StaffName));
  
  }
  public String getStaffNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StaffName));
      }

  public void initReadTime(Timestamp value){
     this.initProperty(S_ReadTime,value);
  }
  public  void setReadTime(Timestamp value){
     this.set(S_ReadTime,value);
  }
  public  void setReadTimeNull(){
     this.set(S_ReadTime,null);
  }

  public Timestamp getReadTime(){
        return DataType.getAsDateTime(this.get(S_ReadTime));
  
  }
  public Timestamp getReadTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ReadTime));
      }

  public void initIsReaded(String value){
     this.initProperty(S_IsReaded,value);
  }
  public  void setIsReaded(String value){
     this.set(S_IsReaded,value);
  }
  public  void setIsReadedNull(){
     this.set(S_IsReaded,null);
  }

  public String getIsReaded(){
       return DataType.getAsString(this.get(S_IsReaded));
  
  }
  public String getIsReadedInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsReaded));
      }

  public void initAppriseFlag(String value){
     this.initProperty(S_AppriseFlag,value);
  }
  public  void setAppriseFlag(String value){
     this.set(S_AppriseFlag,value);
  }
  public  void setAppriseFlagNull(){
     this.set(S_AppriseFlag,null);
  }

  public String getAppriseFlag(){
       return DataType.getAsString(this.get(S_AppriseFlag));
  
  }
  public String getAppriseFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AppriseFlag));
      }

  public void initDepart(String value){
     this.initProperty(S_Depart,value);
  }
  public  void setDepart(String value){
     this.set(S_Depart,value);
  }
  public  void setDepartNull(){
     this.set(S_Depart,null);
  }

  public String getDepart(){
       return DataType.getAsString(this.get(S_Depart));
  
  }
  public String getDepartInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Depart));
      }

  public void initOrganizeId(String value){
     this.initProperty(S_OrganizeId,value);
  }
  public  void setOrganizeId(String value){
     this.set(S_OrganizeId,value);
  }
  public  void setOrganizeIdNull(){
     this.set(S_OrganizeId,null);
  }

  public String getOrganizeId(){
       return DataType.getAsString(this.get(S_OrganizeId));
  
  }
  public String getOrganizeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrganizeId));
      }


 
 }

