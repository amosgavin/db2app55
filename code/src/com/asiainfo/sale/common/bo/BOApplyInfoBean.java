package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOApplyInfoBean extends DataContainer implements DataContainerInterface,IBOApplyInfoValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOApplyInfo";



  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Recordid = "RECORDID";
  public final static  String S_CreateStaffName = "CREATE_STAFF_NAME";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_Orgname = "ORGNAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOApplyInfoBean() throws AIException{
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

  public void initCreateTime(Timestamp value){
     this.initProperty(S_CreateTime,value);
  }
  public  void setCreateTime(Timestamp value){
     this.set(S_CreateTime,value);
  }
  public  void setCreateTimeNull(){
     this.set(S_CreateTime,null);
  }

  public Timestamp getCreateTime(){
        return DataType.getAsDateTime(this.get(S_CreateTime));
  
  }
  public Timestamp getCreateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
      }

  public void initRecordid(String value){
     this.initProperty(S_Recordid,value);
  }
  public  void setRecordid(String value){
     this.set(S_Recordid,value);
  }
  public  void setRecordidNull(){
     this.set(S_Recordid,null);
  }

  public String getRecordid(){
       return DataType.getAsString(this.get(S_Recordid));
  
  }
  public String getRecordidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Recordid));
      }

  public void initCreateStaffName(String value){
     this.initProperty(S_CreateStaffName,value);
  }
  public  void setCreateStaffName(String value){
     this.set(S_CreateStaffName,value);
  }
  public  void setCreateStaffNameNull(){
     this.set(S_CreateStaffName,null);
  }

  public String getCreateStaffName(){
       return DataType.getAsString(this.get(S_CreateStaffName));
  
  }
  public String getCreateStaffNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CreateStaffName));
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

  public void initOrgname(String value){
     this.initProperty(S_Orgname,value);
  }
  public  void setOrgname(String value){
     this.set(S_Orgname,value);
  }
  public  void setOrgnameNull(){
     this.set(S_Orgname,null);
  }

  public String getOrgname(){
       return DataType.getAsString(this.get(S_Orgname));
  
  }
  public String getOrgnameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Orgname));
      }


 
 }

