package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOSaleRelatCgroupBean extends DataContainer implements DataContainerInterface,IBOSaleRelatCgroupValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOSaleRelatCgroup";



  public final static  String S_RelatType = "RELAT_TYPE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_CgroupRegion = "CGROUP_REGION";
  public final static  String S_CgroupId = "CGROUP_ID";
  public final static  String S_Id = "ID";
  public final static  String S_CgroupTab = "CGROUP_TAB";
  public final static  String S_CgroupName = "CGROUP_NAME";
  public final static  String S_CgroupEndTime = "CGROUP_END_TIME";
  public final static  String S_RelatId = "RELAT_ID";
  public final static  String S_CgroupBeginTime = "CGROUP_BEGIN_TIME";
  public final static  String S_CgroupFlag = "CGROUP_FLAG";
  public final static  String S_CgroupUsernum = "CGROUP_USERNUM";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleRelatCgroupBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initRelatType(String value){
     this.initProperty(S_RelatType,value);
  }
  public  void setRelatType(String value){
     this.set(S_RelatType,value);
  }
  public  void setRelatTypeNull(){
     this.set(S_RelatType,null);
  }

  public String getRelatType(){
       return DataType.getAsString(this.get(S_RelatType));
  
  }
  public String getRelatTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelatType));
      }

  public void initOrderId(String value){
     this.initProperty(S_OrderId,value);
  }
  public  void setOrderId(String value){
     this.set(S_OrderId,value);
  }
  public  void setOrderIdNull(){
     this.set(S_OrderId,null);
  }

  public String getOrderId(){
       return DataType.getAsString(this.get(S_OrderId));
  
  }
  public String getOrderIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderId));
      }

  public void initCgroupRegion(String value){
     this.initProperty(S_CgroupRegion,value);
  }
  public  void setCgroupRegion(String value){
     this.set(S_CgroupRegion,value);
  }
  public  void setCgroupRegionNull(){
     this.set(S_CgroupRegion,null);
  }

  public String getCgroupRegion(){
       return DataType.getAsString(this.get(S_CgroupRegion));
  
  }
  public String getCgroupRegionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CgroupRegion));
      }

  public void initCgroupId(String value){
     this.initProperty(S_CgroupId,value);
  }
  public  void setCgroupId(String value){
     this.set(S_CgroupId,value);
  }
  public  void setCgroupIdNull(){
     this.set(S_CgroupId,null);
  }

  public String getCgroupId(){
       return DataType.getAsString(this.get(S_CgroupId));
  
  }
  public String getCgroupIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CgroupId));
      }

  public void initId(int value){
     this.initProperty(S_Id,new Integer(value));
  }
  public  void setId(int value){
     this.set(S_Id,new Integer(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public int getId(){
        return DataType.getAsInt(this.get(S_Id));
  
  }
  public int getIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Id));
      }

  public void initCgroupTab(String value){
     this.initProperty(S_CgroupTab,value);
  }
  public  void setCgroupTab(String value){
     this.set(S_CgroupTab,value);
  }
  public  void setCgroupTabNull(){
     this.set(S_CgroupTab,null);
  }

  public String getCgroupTab(){
       return DataType.getAsString(this.get(S_CgroupTab));
  
  }
  public String getCgroupTabInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CgroupTab));
      }

  public void initCgroupName(String value){
     this.initProperty(S_CgroupName,value);
  }
  public  void setCgroupName(String value){
     this.set(S_CgroupName,value);
  }
  public  void setCgroupNameNull(){
     this.set(S_CgroupName,null);
  }

  public String getCgroupName(){
       return DataType.getAsString(this.get(S_CgroupName));
  
  }
  public String getCgroupNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CgroupName));
      }

  public void initCgroupEndTime(Timestamp value){
     this.initProperty(S_CgroupEndTime,value);
  }
  public  void setCgroupEndTime(Timestamp value){
     this.set(S_CgroupEndTime,value);
  }
  public  void setCgroupEndTimeNull(){
     this.set(S_CgroupEndTime,null);
  }

  public Timestamp getCgroupEndTime(){
        return DataType.getAsDateTime(this.get(S_CgroupEndTime));
  
  }
  public Timestamp getCgroupEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CgroupEndTime));
      }

  public void initRelatId(String value){
     this.initProperty(S_RelatId,value);
  }
  public  void setRelatId(String value){
     this.set(S_RelatId,value);
  }
  public  void setRelatIdNull(){
     this.set(S_RelatId,null);
  }

  public String getRelatId(){
       return DataType.getAsString(this.get(S_RelatId));
  
  }
  public String getRelatIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelatId));
      }

  public void initCgroupBeginTime(Timestamp value){
     this.initProperty(S_CgroupBeginTime,value);
  }
  public  void setCgroupBeginTime(Timestamp value){
     this.set(S_CgroupBeginTime,value);
  }
  public  void setCgroupBeginTimeNull(){
     this.set(S_CgroupBeginTime,null);
  }

  public Timestamp getCgroupBeginTime(){
        return DataType.getAsDateTime(this.get(S_CgroupBeginTime));
  
  }
  public Timestamp getCgroupBeginTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CgroupBeginTime));
      }

  public void initCgroupFlag(String value){
     this.initProperty(S_CgroupFlag,value);
  }
  public  void setCgroupFlag(String value){
     this.set(S_CgroupFlag,value);
  }
  public  void setCgroupFlagNull(){
     this.set(S_CgroupFlag,null);
  }

  public String getCgroupFlag(){
       return DataType.getAsString(this.get(S_CgroupFlag));
  
  }
  public String getCgroupFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CgroupFlag));
      }

  public void initCgroupUsernum(String value){
     this.initProperty(S_CgroupUsernum,value);
  }
  public  void setCgroupUsernum(String value){
     this.set(S_CgroupUsernum,value);
  }
  public  void setCgroupUsernumNull(){
     this.set(S_CgroupUsernum,null);
  }

  public String getCgroupUsernum(){
       return DataType.getAsString(this.get(S_CgroupUsernum));
  
  }
  public String getCgroupUsernumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CgroupUsernum));
      }


 
 }

