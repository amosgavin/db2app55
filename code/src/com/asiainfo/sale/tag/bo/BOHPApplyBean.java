package com.asiainfo.sale.tag.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.tag.ivalues.*;

public class BOHPApplyBean extends DataContainer implements DataContainerInterface,IBOHPApplyValue{

  private static String  m_boName = "com.asiainfo.sale.tag.bo.BOHPApply";



  public final static  String S_Recordid = "RECORDID";
  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_ApplyTime = "APPLY_TIME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOHPApplyBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initApplyTime(Timestamp value){
     this.initProperty(S_ApplyTime,value);
  }
  public  void setApplyTime(Timestamp value){
     this.set(S_ApplyTime,value);
  }
  public  void setApplyTimeNull(){
     this.set(S_ApplyTime,null);
  }

  public Timestamp getApplyTime(){
        return DataType.getAsDateTime(this.get(S_ApplyTime));
  
  }
  public Timestamp getApplyTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ApplyTime));
      }


 
 }

