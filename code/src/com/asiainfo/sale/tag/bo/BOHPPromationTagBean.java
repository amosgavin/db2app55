package com.asiainfo.sale.tag.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.tag.ivalues.*;

public class BOHPPromationTagBean extends DataContainer implements DataContainerInterface,IBOHPPromationTagValue{

  private static String  m_boName = "com.asiainfo.sale.tag.bo.BOHPPromationTag";



  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Area = "AREA";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_ShowFlag = "SHOW_FLAG";
  public final static  String S_Pid = "PID";
  public final static  String S_BusiName = "BUSI_NAME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_IsSp = "IS_SP";
  public final static  String S_Fill = "FILL";
  public final static  String S_FirstClassify = "FIRST_CLASSIFY";
  public final static  String S_TagCode = "TAG_CODE";
  public final static  String S_Remark = "REMARK";
  public final static  String S_Charge = "CHARGE";
  public final static  String S_AccountType = "ACCOUNT_TYPE";
  public final static  String S_Cycle = "CYCLE";
  public final static  String S_TagType = "TAG_TYPE";
  public final static  String S_StockNumber = "STOCK_NUMBER";
  public final static  String S_StockFlag = "STOCK_FLAG";
  public final static  String S_ThirfClassify = "THIRF_CLASSIFY";
  public final static  String S_OverdueTime = "OVERDUE_TIME";
  public final static  String S_Sumcharge = "SUMCHARGE";
  public final static  String S_Id = "ID";
  public final static  String S_StockCharge = "STOCK_CHARGE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOHPPromationTagBean() throws AIException{
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

  public void initPid(int value){
     this.initProperty(S_Pid,new Integer(value));
  }
  public  void setPid(int value){
     this.set(S_Pid,new Integer(value));
  }
  public  void setPidNull(){
     this.set(S_Pid,null);
  }

  public int getPid(){
        return DataType.getAsInt(this.get(S_Pid));
  
  }
  public int getPidInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Pid));
      }

  public void initBusiName(String value){
     this.initProperty(S_BusiName,value);
  }
  public  void setBusiName(String value){
     this.set(S_BusiName,value);
  }
  public  void setBusiNameNull(){
     this.set(S_BusiName,null);
  }

  public String getBusiName(){
       return DataType.getAsString(this.get(S_BusiName));
  
  }
  public String getBusiNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusiName));
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

  public void initFirstClassify(String value){
     this.initProperty(S_FirstClassify,value);
  }
  public  void setFirstClassify(String value){
     this.set(S_FirstClassify,value);
  }
  public  void setFirstClassifyNull(){
     this.set(S_FirstClassify,null);
  }

  public String getFirstClassify(){
       return DataType.getAsString(this.get(S_FirstClassify));
  
  }
  public String getFirstClassifyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FirstClassify));
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

  public void initCharge(double value){
     this.initProperty(S_Charge,new Double(value));
  }
  public  void setCharge(double value){
     this.set(S_Charge,new Double(value));
  }
  public  void setChargeNull(){
     this.set(S_Charge,null);
  }

  public double getCharge(){
        return DataType.getAsDouble(this.get(S_Charge));
  
  }
  public double getChargeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Charge));
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

  public void initCycle(int value){
     this.initProperty(S_Cycle,new Integer(value));
  }
  public  void setCycle(int value){
     this.set(S_Cycle,new Integer(value));
  }
  public  void setCycleNull(){
     this.set(S_Cycle,null);
  }

  public int getCycle(){
        return DataType.getAsInt(this.get(S_Cycle));
  
  }
  public int getCycleInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Cycle));
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

  public void initThirfClassify(String value){
     this.initProperty(S_ThirfClassify,value);
  }
  public  void setThirfClassify(String value){
     this.set(S_ThirfClassify,value);
  }
  public  void setThirfClassifyNull(){
     this.set(S_ThirfClassify,null);
  }

  public String getThirfClassify(){
       return DataType.getAsString(this.get(S_ThirfClassify));
  
  }
  public String getThirfClassifyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ThirfClassify));
      }

  public void initOverdueTime(Timestamp value){
     this.initProperty(S_OverdueTime,value);
  }
  public  void setOverdueTime(Timestamp value){
     this.set(S_OverdueTime,value);
  }
  public  void setOverdueTimeNull(){
     this.set(S_OverdueTime,null);
  }

  public Timestamp getOverdueTime(){
        return DataType.getAsDateTime(this.get(S_OverdueTime));
  
  }
  public Timestamp getOverdueTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OverdueTime));
      }

  public void initSumcharge(double value){
     this.initProperty(S_Sumcharge,new Double(value));
  }
  public  void setSumcharge(double value){
     this.set(S_Sumcharge,new Double(value));
  }
  public  void setSumchargeNull(){
     this.set(S_Sumcharge,null);
  }

  public double getSumcharge(){
        return DataType.getAsDouble(this.get(S_Sumcharge));
  
  }
  public double getSumchargeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Sumcharge));
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

  public void initStockCharge(double value){
     this.initProperty(S_StockCharge,new Double(value));
  }
  public  void setStockCharge(double value){
     this.set(S_StockCharge,new Double(value));
  }
  public  void setStockChargeNull(){
     this.set(S_StockCharge,null);
  }

  public double getStockCharge(){
        return DataType.getAsDouble(this.get(S_StockCharge));
  
  }
  public double getStockChargeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_StockCharge));
      }


 
 }

