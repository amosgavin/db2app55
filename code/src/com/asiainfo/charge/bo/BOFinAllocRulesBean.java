package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOFinAllocRulesBean extends DataContainer implements DataContainerInterface,IBOFinAllocRulesValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOFinAllocRules";



  public final static  String S_CallingExpense = "CALLING_EXPENSE";
  public final static  String S_SmsExpense = "SMS_EXPENSE";
  public final static  String S_MobilesecretaryExpense = "MOBILESECRETARY_EXPENSE";
  public final static  String S_MonthfixedExpense = "MONTHFIXED_EXPENSE";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_IncomingshowExpense = "INCOMINGSHOW_EXPENSE";
  public final static  String S_MmsExpense = "MMS_EXPENSE";
  public final static  String S_WapsmsExpense = "WAPSMS_EXPENSE";
  public final static  String S_RingtonesExpense = "RINGTONES_EXPENSE";
  public final static  String S_ElineExpense = "ELINE_EXPENSE";
  public final static  String S_GloabalcallingExpense = "GLOABALCALLING_EXPENSE";
  public final static  String S_WapgprsExpense = "WAPGPRS_EXPENSE";
  public final static  String S_Id = "ID";
  public final static  String S_CalltransferExpense = "CALLTRANSFER_EXPENSE";
  public final static  String S_Others = "OTHERS";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOFinAllocRulesBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initCallingExpense(String value){
     this.initProperty(S_CallingExpense,value);
  }
  public  void setCallingExpense(String value){
     this.set(S_CallingExpense,value);
  }
  public  void setCallingExpenseNull(){
     this.set(S_CallingExpense,null);
  }

  public String getCallingExpense(){
       return DataType.getAsString(this.get(S_CallingExpense));
  
  }
  public String getCallingExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CallingExpense));
      }

  public void initSmsExpense(String value){
     this.initProperty(S_SmsExpense,value);
  }
  public  void setSmsExpense(String value){
     this.set(S_SmsExpense,value);
  }
  public  void setSmsExpenseNull(){
     this.set(S_SmsExpense,null);
  }

  public String getSmsExpense(){
       return DataType.getAsString(this.get(S_SmsExpense));
  
  }
  public String getSmsExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SmsExpense));
      }

  public void initMobilesecretaryExpense(String value){
     this.initProperty(S_MobilesecretaryExpense,value);
  }
  public  void setMobilesecretaryExpense(String value){
     this.set(S_MobilesecretaryExpense,value);
  }
  public  void setMobilesecretaryExpenseNull(){
     this.set(S_MobilesecretaryExpense,null);
  }

  public String getMobilesecretaryExpense(){
       return DataType.getAsString(this.get(S_MobilesecretaryExpense));
  
  }
  public String getMobilesecretaryExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MobilesecretaryExpense));
      }

  public void initMonthfixedExpense(String value){
     this.initProperty(S_MonthfixedExpense,value);
  }
  public  void setMonthfixedExpense(String value){
     this.set(S_MonthfixedExpense,value);
  }
  public  void setMonthfixedExpenseNull(){
     this.set(S_MonthfixedExpense,null);
  }

  public String getMonthfixedExpense(){
       return DataType.getAsString(this.get(S_MonthfixedExpense));
  
  }
  public String getMonthfixedExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MonthfixedExpense));
      }

  public void initChargeId(String value){
     this.initProperty(S_ChargeId,value);
  }
  public  void setChargeId(String value){
     this.set(S_ChargeId,value);
  }
  public  void setChargeIdNull(){
     this.set(S_ChargeId,null);
  }

  public String getChargeId(){
       return DataType.getAsString(this.get(S_ChargeId));
  
  }
  public String getChargeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChargeId));
      }

  public void initIncomingshowExpense(String value){
     this.initProperty(S_IncomingshowExpense,value);
  }
  public  void setIncomingshowExpense(String value){
     this.set(S_IncomingshowExpense,value);
  }
  public  void setIncomingshowExpenseNull(){
     this.set(S_IncomingshowExpense,null);
  }

  public String getIncomingshowExpense(){
       return DataType.getAsString(this.get(S_IncomingshowExpense));
  
  }
  public String getIncomingshowExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IncomingshowExpense));
      }

  public void initMmsExpense(String value){
     this.initProperty(S_MmsExpense,value);
  }
  public  void setMmsExpense(String value){
     this.set(S_MmsExpense,value);
  }
  public  void setMmsExpenseNull(){
     this.set(S_MmsExpense,null);
  }

  public String getMmsExpense(){
       return DataType.getAsString(this.get(S_MmsExpense));
  
  }
  public String getMmsExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MmsExpense));
      }

  public void initWapsmsExpense(String value){
     this.initProperty(S_WapsmsExpense,value);
  }
  public  void setWapsmsExpense(String value){
     this.set(S_WapsmsExpense,value);
  }
  public  void setWapsmsExpenseNull(){
     this.set(S_WapsmsExpense,null);
  }

  public String getWapsmsExpense(){
       return DataType.getAsString(this.get(S_WapsmsExpense));
  
  }
  public String getWapsmsExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WapsmsExpense));
      }

  public void initRingtonesExpense(String value){
     this.initProperty(S_RingtonesExpense,value);
  }
  public  void setRingtonesExpense(String value){
     this.set(S_RingtonesExpense,value);
  }
  public  void setRingtonesExpenseNull(){
     this.set(S_RingtonesExpense,null);
  }

  public String getRingtonesExpense(){
       return DataType.getAsString(this.get(S_RingtonesExpense));
  
  }
  public String getRingtonesExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RingtonesExpense));
      }

  public void initElineExpense(String value){
     this.initProperty(S_ElineExpense,value);
  }
  public  void setElineExpense(String value){
     this.set(S_ElineExpense,value);
  }
  public  void setElineExpenseNull(){
     this.set(S_ElineExpense,null);
  }

  public String getElineExpense(){
       return DataType.getAsString(this.get(S_ElineExpense));
  
  }
  public String getElineExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ElineExpense));
      }

  public void initGloabalcallingExpense(String value){
     this.initProperty(S_GloabalcallingExpense,value);
  }
  public  void setGloabalcallingExpense(String value){
     this.set(S_GloabalcallingExpense,value);
  }
  public  void setGloabalcallingExpenseNull(){
     this.set(S_GloabalcallingExpense,null);
  }

  public String getGloabalcallingExpense(){
       return DataType.getAsString(this.get(S_GloabalcallingExpense));
  
  }
  public String getGloabalcallingExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GloabalcallingExpense));
      }

  public void initWapgprsExpense(String value){
     this.initProperty(S_WapgprsExpense,value);
  }
  public  void setWapgprsExpense(String value){
     this.set(S_WapgprsExpense,value);
  }
  public  void setWapgprsExpenseNull(){
     this.set(S_WapgprsExpense,null);
  }

  public String getWapgprsExpense(){
       return DataType.getAsString(this.get(S_WapgprsExpense));
  
  }
  public String getWapgprsExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WapgprsExpense));
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

  public void initCalltransferExpense(String value){
     this.initProperty(S_CalltransferExpense,value);
  }
  public  void setCalltransferExpense(String value){
     this.set(S_CalltransferExpense,value);
  }
  public  void setCalltransferExpenseNull(){
     this.set(S_CalltransferExpense,null);
  }

  public String getCalltransferExpense(){
       return DataType.getAsString(this.get(S_CalltransferExpense));
  
  }
  public String getCalltransferExpenseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CalltransferExpense));
      }

  public void initOthers(String value){
     this.initProperty(S_Others,value);
  }
  public  void setOthers(String value){
     this.set(S_Others,value);
  }
  public  void setOthersNull(){
     this.set(S_Others,null);
  }

  public String getOthers(){
       return DataType.getAsString(this.get(S_Others));
  
  }
  public String getOthersInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Others));
      }


 
 }

