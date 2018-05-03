package com.asiainfo.sale.weapon.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.weapon.ivalues.*;

public class BOSaleWeaponSignOrAduitBean extends DataContainer implements DataContainerInterface,IBOSaleWeaponSignOrAduitValue{

  private static String  m_boName = "com.asiainfo.sale.weapon.bo.BOSaleWeaponSignOrAduit";



  public final static  String S_Tlabel = "TLABEL";
  public final static  String S_WeaponName = "WEAPON_NAME";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_NetAge = "NET_AGE";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_Mid = "MID";
  public final static  String S_TaskType = "TASK_TYPE";
  public final static  String S_Wlabel = "WLABEL";
  public final static  String S_Id = "ID";
  public final static  String S_SaleFlag = "SALE_FLAG";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_MarketType = "MARKET_TYPE";
  public final static  String S_TaskTag = "TASK_TAG";
  public final static  String S_TaskStaffId = "TASK_STAFF_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleWeaponSignOrAduitBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initTlabel(String value){
     this.initProperty(S_Tlabel,value);
  }
  public  void setTlabel(String value){
     this.set(S_Tlabel,value);
  }
  public  void setTlabelNull(){
     this.set(S_Tlabel,null);
  }

  public String getTlabel(){
       return DataType.getAsString(this.get(S_Tlabel));
  
  }
  public String getTlabelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Tlabel));
      }

  public void initWeaponName(String value){
     this.initProperty(S_WeaponName,value);
  }
  public  void setWeaponName(String value){
     this.set(S_WeaponName,value);
  }
  public  void setWeaponNameNull(){
     this.set(S_WeaponName,null);
  }

  public String getWeaponName(){
       return DataType.getAsString(this.get(S_WeaponName));
  
  }
  public String getWeaponNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WeaponName));
      }

  public void initStationId(String value){
     this.initProperty(S_StationId,value);
  }
  public  void setStationId(String value){
     this.set(S_StationId,value);
  }
  public  void setStationIdNull(){
     this.set(S_StationId,null);
  }

  public String getStationId(){
       return DataType.getAsString(this.get(S_StationId));
  
  }
  public String getStationIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StationId));
      }

  public void initNetAge(String value){
     this.initProperty(S_NetAge,value);
  }
  public  void setNetAge(String value){
     this.set(S_NetAge,value);
  }
  public  void setNetAgeNull(){
     this.set(S_NetAge,null);
  }

  public String getNetAge(){
       return DataType.getAsString(this.get(S_NetAge));
  
  }
  public String getNetAgeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NetAge));
      }

  public void initTaskId(String value){
     this.initProperty(S_TaskId,value);
  }
  public  void setTaskId(String value){
     this.set(S_TaskId,value);
  }
  public  void setTaskIdNull(){
     this.set(S_TaskId,null);
  }

  public String getTaskId(){
       return DataType.getAsString(this.get(S_TaskId));
  
  }
  public String getTaskIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskId));
      }

  public void initMid(String value){
     this.initProperty(S_Mid,value);
  }
  public  void setMid(String value){
     this.set(S_Mid,value);
  }
  public  void setMidNull(){
     this.set(S_Mid,null);
  }

  public String getMid(){
       return DataType.getAsString(this.get(S_Mid));
  
  }
  public String getMidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Mid));
      }

  public void initTaskType(String value){
     this.initProperty(S_TaskType,value);
  }
  public  void setTaskType(String value){
     this.set(S_TaskType,value);
  }
  public  void setTaskTypeNull(){
     this.set(S_TaskType,null);
  }

  public String getTaskType(){
       return DataType.getAsString(this.get(S_TaskType));
  
  }
  public String getTaskTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskType));
      }

  public void initWlabel(String value){
     this.initProperty(S_Wlabel,value);
  }
  public  void setWlabel(String value){
     this.set(S_Wlabel,value);
  }
  public  void setWlabelNull(){
     this.set(S_Wlabel,null);
  }

  public String getWlabel(){
       return DataType.getAsString(this.get(S_Wlabel));
  
  }
  public String getWlabelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Wlabel));
      }

  public void initId(String value){
     this.initProperty(S_Id,value);
  }
  public  void setId(String value){
     this.set(S_Id,value);
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public String getId(){
       return DataType.getAsString(this.get(S_Id));
  
  }
  public String getIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Id));
      }

  public void initSaleFlag(String value){
     this.initProperty(S_SaleFlag,value);
  }
  public  void setSaleFlag(String value){
     this.set(S_SaleFlag,value);
  }
  public  void setSaleFlagNull(){
     this.set(S_SaleFlag,null);
  }

  public String getSaleFlag(){
       return DataType.getAsString(this.get(S_SaleFlag));
  
  }
  public String getSaleFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleFlag));
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

  public void initMarketType(String value){
     this.initProperty(S_MarketType,value);
  }
  public  void setMarketType(String value){
     this.set(S_MarketType,value);
  }
  public  void setMarketTypeNull(){
     this.set(S_MarketType,null);
  }

  public String getMarketType(){
       return DataType.getAsString(this.get(S_MarketType));
  
  }
  public String getMarketTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MarketType));
      }

  public void initTaskTag(String value){
     this.initProperty(S_TaskTag,value);
  }
  public  void setTaskTag(String value){
     this.set(S_TaskTag,value);
  }
  public  void setTaskTagNull(){
     this.set(S_TaskTag,null);
  }

  public String getTaskTag(){
       return DataType.getAsString(this.get(S_TaskTag));
  
  }
  public String getTaskTagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskTag));
      }

  public void initTaskStaffId(String value){
     this.initProperty(S_TaskStaffId,value);
  }
  public  void setTaskStaffId(String value){
     this.set(S_TaskStaffId,value);
  }
  public  void setTaskStaffIdNull(){
     this.set(S_TaskStaffId,null);
  }

  public String getTaskStaffId(){
       return DataType.getAsString(this.get(S_TaskStaffId));
  
  }
  public String getTaskStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskStaffId));
      }


 
 }

