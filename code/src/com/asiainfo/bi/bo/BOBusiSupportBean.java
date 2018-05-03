package com.asiainfo.bi.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.bi.ivalues.*;

public class BOBusiSupportBean extends DataContainer implements DataContainerInterface,IBOBusiSupportValue{

  private static String  m_boName = "com.asiainfo.bi.bo.BOBusiSupport";



  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_State = "STATE";
  public final static  String S_Wid = "WID";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_Superior = "SUPERIOR";
  public final static  String S_Lcn = "LCN";
  public final static  String S_DispatchDate = "DISPATCH_DATE";
  public final static  String S_Diffday = "DIFFDAY";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Bcn = "BCN";
  public final static  String S_Itemtype = "ITEMTYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOBusiSupportBean() throws AIException{
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

  public void initWid(String value){
     this.initProperty(S_Wid,value);
  }
  public  void setWid(String value){
     this.set(S_Wid,value);
  }
  public  void setWidNull(){
     this.set(S_Wid,null);
  }

  public String getWid(){
       return DataType.getAsString(this.get(S_Wid));
  
  }
  public String getWidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Wid));
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

  public void initSuperior(String value){
     this.initProperty(S_Superior,value);
  }
  public  void setSuperior(String value){
     this.set(S_Superior,value);
  }
  public  void setSuperiorNull(){
     this.set(S_Superior,null);
  }

  public String getSuperior(){
       return DataType.getAsString(this.get(S_Superior));
  
  }
  public String getSuperiorInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Superior));
      }

  public void initLcn(int value){
     this.initProperty(S_Lcn,new Integer(value));
  }
  public  void setLcn(int value){
     this.set(S_Lcn,new Integer(value));
  }
  public  void setLcnNull(){
     this.set(S_Lcn,null);
  }

  public int getLcn(){
        return DataType.getAsInt(this.get(S_Lcn));
  
  }
  public int getLcnInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Lcn));
      }

  public void initDispatchDate(Timestamp value){
     this.initProperty(S_DispatchDate,value);
  }
  public  void setDispatchDate(Timestamp value){
     this.set(S_DispatchDate,value);
  }
  public  void setDispatchDateNull(){
     this.set(S_DispatchDate,null);
  }

  public Timestamp getDispatchDate(){
        return DataType.getAsDateTime(this.get(S_DispatchDate));
  
  }
  public Timestamp getDispatchDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_DispatchDate));
      }

  public void initDiffday(int value){
     this.initProperty(S_Diffday,new Integer(value));
  }
  public  void setDiffday(int value){
     this.set(S_Diffday,new Integer(value));
  }
  public  void setDiffdayNull(){
     this.set(S_Diffday,null);
  }

  public int getDiffday(){
        return DataType.getAsInt(this.get(S_Diffday));
  
  }
  public int getDiffdayInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Diffday));
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

  public void initCreateDate(Timestamp value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(Timestamp value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public Timestamp getCreateDate(){
        return DataType.getAsDateTime(this.get(S_CreateDate));
  
  }
  public Timestamp getCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
      }

  public void initBcn(int value){
     this.initProperty(S_Bcn,new Integer(value));
  }
  public  void setBcn(int value){
     this.set(S_Bcn,new Integer(value));
  }
  public  void setBcnNull(){
     this.set(S_Bcn,null);
  }

  public int getBcn(){
        return DataType.getAsInt(this.get(S_Bcn));
  
  }
  public int getBcnInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Bcn));
      }

  public void initItemtype(String value){
     this.initProperty(S_Itemtype,value);
  }
  public  void setItemtype(String value){
     this.set(S_Itemtype,value);
  }
  public  void setItemtypeNull(){
     this.set(S_Itemtype,null);
  }

  public String getItemtype(){
       return DataType.getAsString(this.get(S_Itemtype));
  
  }
  public String getItemtypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Itemtype));
      }


 
 }

