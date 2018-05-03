package com.asiainfo.sale.tag.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.tag.ivalues.*;

public class HPRowPromationTagBean extends DataContainer implements DataContainerInterface,IHPRowPromationTagValue{

  private static String  m_boName = "com.asiainfo.sale.tag.bo.HPRowPromationTag";



  public final static  String S_State = "STATE";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_Pid = "PID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Remark = "REMARK";
  public final static  String S_TagCode = "TAG_CODE";
  public final static  String S_Cycle = "CYCLE";
  public final static  String S_AccountType = "ACCOUNT_TYPE";
  public final static  String S_TagType = "TAG_TYPE";
  public final static  String S_Atid = "ATID";
  public final static  String S_Id = "ID";
  public final static  String S_StockCharge = "STOCK_CHARGE";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Name = "NAME";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Area = "AREA";
  public final static  String S_IsSp = "IS_SP";
  public final static  String S_ShowFlag = "SHOW_FLAG";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_Fill = "FILL";
  public final static  String S_Charge = "CHARGE";
  public final static  String S_StockNumber = "STOCK_NUMBER";
  public final static  String S_StockFlag = "STOCK_FLAG";
  public final static  String S_Sumcharge = "SUMCHARGE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public HPRowPromationTagBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initModifyTime(Timestamp value){
     this.initProperty(S_ModifyTime,value);
  }
  public  void setModifyTime(Timestamp value){
     this.set(S_ModifyTime,value);
  }
  public  void setModifyTimeNull(){
     this.set(S_ModifyTime,null);
  }

  public Timestamp getModifyTime(){
        return DataType.getAsDateTime(this.get(S_ModifyTime));
  
  }
  public Timestamp getModifyTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyTime));
      }

  public void initPid(long value){
     this.initProperty(S_Pid,new Long(value));
  }
  public  void setPid(long value){
     this.set(S_Pid,new Long(value));
  }
  public  void setPidNull(){
     this.set(S_Pid,null);
  }

  public long getPid(){
        return DataType.getAsLong(this.get(S_Pid));
  
  }
  public long getPidInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Pid));
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

  public void initRemark(String value){
     this.initProperty(S_Remark,value);
  }
  public  void setRemark(String value){
     this.set(S_Remark,value);
  }
  public  void setRemarkNull(){
     this.set(S_Remark,null);
  }

  public String getRemark(){
       return DataType.getAsString(this.get(S_Remark));
  
  }
  public String getRemarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark));
      }

  public void initTagCode(String value){
     this.initProperty(S_TagCode,value);
  }
  public  void setTagCode(String value){
     this.set(S_TagCode,value);
  }
  public  void setTagCodeNull(){
     this.set(S_TagCode,null);
  }

  public String getTagCode(){
       return DataType.getAsString(this.get(S_TagCode));
  
  }
  public String getTagCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TagCode));
      }

  public void initCycle(long value){
     this.initProperty(S_Cycle,new Long(value));
  }
  public  void setCycle(long value){
     this.set(S_Cycle,new Long(value));
  }
  public  void setCycleNull(){
     this.set(S_Cycle,null);
  }

  public long getCycle(){
        return DataType.getAsLong(this.get(S_Cycle));
  
  }
  public long getCycleInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Cycle));
      }

  public void initAccountType(String value){
     this.initProperty(S_AccountType,value);
  }
  public  void setAccountType(String value){
     this.set(S_AccountType,value);
  }
  public  void setAccountTypeNull(){
     this.set(S_AccountType,null);
  }

  public String getAccountType(){
       return DataType.getAsString(this.get(S_AccountType));
  
  }
  public String getAccountTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AccountType));
      }

  public void initTagType(String value){
     this.initProperty(S_TagType,value);
  }
  public  void setTagType(String value){
     this.set(S_TagType,value);
  }
  public  void setTagTypeNull(){
     this.set(S_TagType,null);
  }

  public String getTagType(){
       return DataType.getAsString(this.get(S_TagType));
  
  }
  public String getTagTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TagType));
      }

  public void initAtid(long value){
     this.initProperty(S_Atid,new Long(value));
  }
  public  void setAtid(long value){
     this.set(S_Atid,new Long(value));
  }
  public  void setAtidNull(){
     this.set(S_Atid,null);
  }

  public long getAtid(){
        return DataType.getAsLong(this.get(S_Atid));
  
  }
  public long getAtidInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Atid));
      }

  public void initId(long value){
     this.initProperty(S_Id,new Long(value));
  }
  public  void setId(long value){
     this.set(S_Id,new Long(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public long getId(){
        return DataType.getAsLong(this.get(S_Id));
  
  }
  public long getIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Id));
      }

  public void initStockCharge(long value){
     this.initProperty(S_StockCharge,new Long(value));
  }
  public  void setStockCharge(long value){
     this.set(S_StockCharge,new Long(value));
  }
  public  void setStockChargeNull(){
     this.set(S_StockCharge,null);
  }

  public long getStockCharge(){
        return DataType.getAsLong(this.get(S_StockCharge));
  
  }
  public long getStockChargeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_StockCharge));
      }

  public void initRemark1(long value){
     this.initProperty(S_Remark1,new Long(value));
  }
  public  void setRemark1(long value){
     this.set(S_Remark1,new Long(value));
  }
  public  void setRemark1Null(){
     this.set(S_Remark1,null);
  }

  public long getRemark1(){
        return DataType.getAsLong(this.get(S_Remark1));
  
  }
  public long getRemark1InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Remark1));
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

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
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

  public void initArea(String value){
     this.initProperty(S_Area,value);
  }
  public  void setArea(String value){
     this.set(S_Area,value);
  }
  public  void setAreaNull(){
     this.set(S_Area,null);
  }

  public String getArea(){
       return DataType.getAsString(this.get(S_Area));
  
  }
  public String getAreaInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Area));
      }

  public void initIsSp(String value){
     this.initProperty(S_IsSp,value);
  }
  public  void setIsSp(String value){
     this.set(S_IsSp,value);
  }
  public  void setIsSpNull(){
     this.set(S_IsSp,null);
  }

  public String getIsSp(){
       return DataType.getAsString(this.get(S_IsSp));
  
  }
  public String getIsSpInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSp));
      }

  public void initShowFlag(String value){
     this.initProperty(S_ShowFlag,value);
  }
  public  void setShowFlag(String value){
     this.set(S_ShowFlag,value);
  }
  public  void setShowFlagNull(){
     this.set(S_ShowFlag,null);
  }

  public String getShowFlag(){
       return DataType.getAsString(this.get(S_ShowFlag));
  
  }
  public String getShowFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ShowFlag));
      }

  public void initSaleId(long value){
     this.initProperty(S_SaleId,new Long(value));
  }
  public  void setSaleId(long value){
     this.set(S_SaleId,new Long(value));
  }
  public  void setSaleIdNull(){
     this.set(S_SaleId,null);
  }

  public long getSaleId(){
        return DataType.getAsLong(this.get(S_SaleId));
  
  }
  public long getSaleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SaleId));
      }

  public void initFill(String value){
     this.initProperty(S_Fill,value);
  }
  public  void setFill(String value){
     this.set(S_Fill,value);
  }
  public  void setFillNull(){
     this.set(S_Fill,null);
  }

  public String getFill(){
       return DataType.getAsString(this.get(S_Fill));
  
  }
  public String getFillInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Fill));
      }

  public void initCharge(long value){
     this.initProperty(S_Charge,new Long(value));
  }
  public  void setCharge(long value){
     this.set(S_Charge,new Long(value));
  }
  public  void setChargeNull(){
     this.set(S_Charge,null);
  }

  public long getCharge(){
        return DataType.getAsLong(this.get(S_Charge));
  
  }
  public long getChargeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Charge));
      }

  public void initStockNumber(String value){
     this.initProperty(S_StockNumber,value);
  }
  public  void setStockNumber(String value){
     this.set(S_StockNumber,value);
  }
  public  void setStockNumberNull(){
     this.set(S_StockNumber,null);
  }

  public String getStockNumber(){
       return DataType.getAsString(this.get(S_StockNumber));
  
  }
  public String getStockNumberInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StockNumber));
      }

  public void initStockFlag(String value){
     this.initProperty(S_StockFlag,value);
  }
  public  void setStockFlag(String value){
     this.set(S_StockFlag,value);
  }
  public  void setStockFlagNull(){
     this.set(S_StockFlag,null);
  }

  public String getStockFlag(){
       return DataType.getAsString(this.get(S_StockFlag));
  
  }
  public String getStockFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StockFlag));
      }

  public void initSumcharge(long value){
     this.initProperty(S_Sumcharge,new Long(value));
  }
  public  void setSumcharge(long value){
     this.set(S_Sumcharge,new Long(value));
  }
  public  void setSumchargeNull(){
     this.set(S_Sumcharge,null);
  }

  public long getSumcharge(){
        return DataType.getAsLong(this.get(S_Sumcharge));
  
  }
  public long getSumchargeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Sumcharge));
      }


 
 }

