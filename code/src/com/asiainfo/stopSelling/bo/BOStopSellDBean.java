package com.asiainfo.stopSelling.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.stopSelling.ivalues.*;

public class BOStopSellDBean extends DataContainer implements DataContainerInterface,IBOStopSellDValue{

  private static String  m_boName = "com.asiainfo.stopSelling.bo.BOStopSellD";



  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_ExeArea = "EXE_AREA";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_BatchCode = "BATCH_CODE";
  public final static  String S_BatchName = "BATCH_NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_EndDate = "END_DATE";
  public final static  String S_PreOffdate = "PRE_OFFDATE";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_ChargeType = "CHARGE_TYPE";
  public final static  String S_Mainid = "MAINID";
  public final static  String S_Market = "MARKET";
  public final static  String S_LevelCode = "LEVEL_CODE";
  public final static  String S_Id = "ID";
  public final static  String S_WorkDate = "WORK_DATE";
  public final static  String S_LevelName = "LEVEL_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOStopSellDBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initExeArea(String value){
     this.initProperty(S_ExeArea,value);
  }
  public  void setExeArea(String value){
     this.set(S_ExeArea,value);
  }
  public  void setExeAreaNull(){
     this.set(S_ExeArea,null);
  }

  public String getExeArea(){
       return DataType.getAsString(this.get(S_ExeArea));
  
  }
  public String getExeAreaInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExeArea));
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

  public void initBusiType(String value){
     this.initProperty(S_BusiType,value);
  }
  public  void setBusiType(String value){
     this.set(S_BusiType,value);
  }
  public  void setBusiTypeNull(){
     this.set(S_BusiType,null);
  }

  public String getBusiType(){
       return DataType.getAsString(this.get(S_BusiType));
  
  }
  public String getBusiTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusiType));
      }

  public void initBatchCode(String value){
     this.initProperty(S_BatchCode,value);
  }
  public  void setBatchCode(String value){
     this.set(S_BatchCode,value);
  }
  public  void setBatchCodeNull(){
     this.set(S_BatchCode,null);
  }

  public String getBatchCode(){
       return DataType.getAsString(this.get(S_BatchCode));
  
  }
  public String getBatchCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BatchCode));
      }

  public void initBatchName(String value){
     this.initProperty(S_BatchName,value);
  }
  public  void setBatchName(String value){
     this.set(S_BatchName,value);
  }
  public  void setBatchNameNull(){
     this.set(S_BatchName,null);
  }

  public String getBatchName(){
       return DataType.getAsString(this.get(S_BatchName));
  
  }
  public String getBatchNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BatchName));
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

  public void initEndDate(Timestamp value){
     this.initProperty(S_EndDate,value);
  }
  public  void setEndDate(Timestamp value){
     this.set(S_EndDate,value);
  }
  public  void setEndDateNull(){
     this.set(S_EndDate,null);
  }

  public Timestamp getEndDate(){
        return DataType.getAsDateTime(this.get(S_EndDate));
  
  }
  public Timestamp getEndDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_EndDate));
      }

  public void initPreOffdate(Timestamp value){
     this.initProperty(S_PreOffdate,value);
  }
  public  void setPreOffdate(Timestamp value){
     this.set(S_PreOffdate,value);
  }
  public  void setPreOffdateNull(){
     this.set(S_PreOffdate,null);
  }

  public Timestamp getPreOffdate(){
        return DataType.getAsDateTime(this.get(S_PreOffdate));
  
  }
  public Timestamp getPreOffdateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_PreOffdate));
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

  public void initChargeType(String value){
     this.initProperty(S_ChargeType,value);
  }
  public  void setChargeType(String value){
     this.set(S_ChargeType,value);
  }
  public  void setChargeTypeNull(){
     this.set(S_ChargeType,null);
  }

  public String getChargeType(){
       return DataType.getAsString(this.get(S_ChargeType));
  
  }
  public String getChargeTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChargeType));
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

  public void initMarket(String value){
     this.initProperty(S_Market,value);
  }
  public  void setMarket(String value){
     this.set(S_Market,value);
  }
  public  void setMarketNull(){
     this.set(S_Market,null);
  }

  public String getMarket(){
       return DataType.getAsString(this.get(S_Market));
  
  }
  public String getMarketInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Market));
      }

  public void initLevelCode(String value){
     this.initProperty(S_LevelCode,value);
  }
  public  void setLevelCode(String value){
     this.set(S_LevelCode,value);
  }
  public  void setLevelCodeNull(){
     this.set(S_LevelCode,null);
  }

  public String getLevelCode(){
       return DataType.getAsString(this.get(S_LevelCode));
  
  }
  public String getLevelCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevelCode));
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

  public void initWorkDate(Timestamp value){
     this.initProperty(S_WorkDate,value);
  }
  public  void setWorkDate(Timestamp value){
     this.set(S_WorkDate,value);
  }
  public  void setWorkDateNull(){
     this.set(S_WorkDate,null);
  }

  public Timestamp getWorkDate(){
        return DataType.getAsDateTime(this.get(S_WorkDate));
  
  }
  public Timestamp getWorkDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_WorkDate));
      }

  public void initLevelName(String value){
     this.initProperty(S_LevelName,value);
  }
  public  void setLevelName(String value){
     this.set(S_LevelName,value);
  }
  public  void setLevelNameNull(){
     this.set(S_LevelName,null);
  }

  public String getLevelName(){
       return DataType.getAsString(this.get(S_LevelName));
  
  }
  public String getLevelNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevelName));
      }
  public void undelete(){
	  super.m_isDeleted=false;
  }

 
 }

