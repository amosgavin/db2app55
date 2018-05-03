package com.asiainfo.bi.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.bi.ivalues.*;

public class BOOrderCfgTraceBean extends DataContainer implements DataContainerInterface,IBOOrderCfgTraceValue{

  private static String  m_boName = "com.asiainfo.bi.bo.BOOrderCfgTrace";



  public final static  String S_CfgStaff = "CFG_STAFF";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_ApplyStaff = "APPLY_STAFF";
  public final static  String S_PcId = "PC_ID";
  public final static  String S_DcCode = "DC_CODE";
  public final static  String S_DcName = "DC_NAME";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_OrderName = "ORDER_NAME";
  public final static  String S_PcName = "PC_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOOrderCfgTraceBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initCfgStaff(String value){
     this.initProperty(S_CfgStaff,value);
  }
  public  void setCfgStaff(String value){
     this.set(S_CfgStaff,value);
  }
  public  void setCfgStaffNull(){
     this.set(S_CfgStaff,null);
  }

  public String getCfgStaff(){
       return DataType.getAsString(this.get(S_CfgStaff));
  
  }
  public String getCfgStaffInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CfgStaff));
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

  public void initOrderId(long value){
     this.initProperty(S_OrderId,new Long(value));
  }
  public  void setOrderId(long value){
     this.set(S_OrderId,new Long(value));
  }
  public  void setOrderIdNull(){
     this.set(S_OrderId,null);
  }

  public long getOrderId(){
        return DataType.getAsLong(this.get(S_OrderId));
  
  }
  public long getOrderIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrderId));
      }

  public void initApplyStaff(String value){
     this.initProperty(S_ApplyStaff,value);
  }
  public  void setApplyStaff(String value){
     this.set(S_ApplyStaff,value);
  }
  public  void setApplyStaffNull(){
     this.set(S_ApplyStaff,null);
  }

  public String getApplyStaff(){
       return DataType.getAsString(this.get(S_ApplyStaff));
  
  }
  public String getApplyStaffInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ApplyStaff));
      }

  public void initPcId(String value){
     this.initProperty(S_PcId,value);
  }
  public  void setPcId(String value){
     this.set(S_PcId,value);
  }
  public  void setPcIdNull(){
     this.set(S_PcId,null);
  }

  public String getPcId(){
       return DataType.getAsString(this.get(S_PcId));
  
  }
  public String getPcIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PcId));
      }

  public void initDcCode(String value){
     this.initProperty(S_DcCode,value);
  }
  public  void setDcCode(String value){
     this.set(S_DcCode,value);
  }
  public  void setDcCodeNull(){
     this.set(S_DcCode,null);
  }

  public String getDcCode(){
       return DataType.getAsString(this.get(S_DcCode));
  
  }
  public String getDcCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DcCode));
      }

  public void initDcName(String value){
     this.initProperty(S_DcName,value);
  }
  public  void setDcName(String value){
     this.set(S_DcName,value);
  }
  public  void setDcNameNull(){
     this.set(S_DcName,null);
  }

  public String getDcName(){
       return DataType.getAsString(this.get(S_DcName));
  
  }
  public String getDcNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DcName));
      }

  public void initFinishDate(Timestamp value){
     this.initProperty(S_FinishDate,value);
  }
  public  void setFinishDate(Timestamp value){
     this.set(S_FinishDate,value);
  }
  public  void setFinishDateNull(){
     this.set(S_FinishDate,null);
  }

  public Timestamp getFinishDate(){
        return DataType.getAsDateTime(this.get(S_FinishDate));
  
  }
  public Timestamp getFinishDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_FinishDate));
      }

  public void initOrderName(String value){
     this.initProperty(S_OrderName,value);
  }
  public  void setOrderName(String value){
     this.set(S_OrderName,value);
  }
  public  void setOrderNameNull(){
     this.set(S_OrderName,null);
  }

  public String getOrderName(){
       return DataType.getAsString(this.get(S_OrderName));
  
  }
  public String getOrderNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderName));
      }

  public void initPcName(String value){
     this.initProperty(S_PcName,value);
  }
  public  void setPcName(String value){
     this.set(S_PcName,value);
  }
  public  void setPcNameNull(){
     this.set(S_PcName,null);
  }

  public String getPcName(){
       return DataType.getAsString(this.get(S_PcName));
  
  }
  public String getPcNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PcName));
      }


 
 }

