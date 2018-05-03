package com.asiainfo.costWarn.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.costWarn.ivalues.*;

public class BOConfigureBean extends DataContainer implements DataContainerInterface,IBOConfigureValue{

  private static String  m_boName = "com.asiainfo.costWarn.bo.BOConfigure";



  public final static  String S_Telphone = "TELPHONE";
  public final static  String S_Bumen = "BUMEN";
  public final static  String S_Staffid = "STAFFID";
  public final static  String S_Staffname = "STAFFNAME";
  public final static  String S_City = "CITY";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOConfigureBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initTelphone(String value){
     this.initProperty(S_Telphone,value);
  }
  public  void setTelphone(String value){
     this.set(S_Telphone,value);
  }
  public  void setTelphoneNull(){
     this.set(S_Telphone,null);
  }

  public String getTelphone(){
       return DataType.getAsString(this.get(S_Telphone));
  
  }
  public String getTelphoneInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Telphone));
      }

  public void initBumen(String value){
     this.initProperty(S_Bumen,value);
  }
  public  void setBumen(String value){
     this.set(S_Bumen,value);
  }
  public  void setBumenNull(){
     this.set(S_Bumen,null);
  }

  public String getBumen(){
       return DataType.getAsString(this.get(S_Bumen));
  
  }
  public String getBumenInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Bumen));
      }

  public void initStaffid(String value){
     this.initProperty(S_Staffid,value);
  }
  public  void setStaffid(String value){
     this.set(S_Staffid,value);
  }
  public  void setStaffidNull(){
     this.set(S_Staffid,null);
  }

  public String getStaffid(){
       return DataType.getAsString(this.get(S_Staffid));
  
  }
  public String getStaffidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Staffid));
      }

  public void initStaffname(String value){
     this.initProperty(S_Staffname,value);
  }
  public  void setStaffname(String value){
     this.set(S_Staffname,value);
  }
  public  void setStaffnameNull(){
     this.set(S_Staffname,null);
  }

  public String getStaffname(){
       return DataType.getAsString(this.get(S_Staffname));
  
  }
  public String getStaffnameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Staffname));
      }

  public void initCity(String value){
     this.initProperty(S_City,value);
  }
  public  void setCity(String value){
     this.set(S_City,value);
  }
  public  void setCityNull(){
     this.set(S_City,null);
  }

  public String getCity(){
       return DataType.getAsString(this.get(S_City));
  
  }
  public String getCityInitialValue(){
        return DataType.getAsString(this.getOldObj(S_City));
      }


 
 }

