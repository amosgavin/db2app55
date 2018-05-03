package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOFinaAllocRulesBean extends DataContainer implements DataContainerInterface,IBOFinaAllocRulesValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOFinaAllocRules";



  public final static  String S_IncomingshowExpenseValue = "INCOMINGSHOW_EXPENSE_VALUE";
  public final static  String S_Others1Value = "OTHERS1_VALUE";
  public final static  String S_MmsExpenseValue = "MMS_EXPENSE_VALUE";
  public final static  String S_Others2Value = "OTHERS2_VALUE";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_IncomingshowExpense = "INCOMINGSHOW_EXPENSE";
  public final static  String S_SmsExpenseValue = "SMS_EXPENSE_VALUE";
  public final static  String S_Others3Value = "OTHERS3_VALUE";
  public final static  String S_WapgprsExpenseValue = "WAPGPRS_EXPENSE_VALUE";
  public final static  String S_WlanValue = "WLAN_VALUE";
  public final static  String S_Others1Name = "OTHERS1_NAME";
  public final static  String S_Id = "ID";
  public final static  String S_CallingExpenseValue = "calling_expense_value";
  public final static  String S_Others4Name = "OTHERS4_NAME";
  public final static  String S_Wlan = "WLAN";
  public final static  String S_Others4Value = "OTHERS4_VALUE";
  public final static  String S_WapsmsExpenseValue = "WAPSMS_EXPENSE_VALUE";
  public final static  String S_SmsExpense = "SMS_EXPENSE";
  public final static  String S_MonthfixedExpense = "MONTHFIXED_EXPENSE";
  public final static  String S_MonthfixedExpenseValue = "MONTHFIXED_EXPENSE_VALUE";
  public final static  String S_Others2Name = "OTHERS2_NAME";
  public final static  String S_MmsExpense = "MMS_EXPENSE";
  public final static  String S_CallingExpense = "calling_expense";
  public final static  String S_WapsmsExpense = "WAPSMS_EXPENSE";
  public final static  String S_WapgprsExpense = "WAPGPRS_EXPENSE";
  public final static  String S_Others3Name = "OTHERS3_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOFinaAllocRulesBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initIncomingshowExpenseValue(String value){
     this.initProperty(S_IncomingshowExpenseValue,value);
  }
  public  void setIncomingshowExpenseValue(String value){
     this.set(S_IncomingshowExpenseValue,value);
  }
  public  void setIncomingshowExpenseValueNull(){
     this.set(S_IncomingshowExpenseValue,null);
  }

  public String getIncomingshowExpenseValue(){
       return DataType.getAsString(this.get(S_IncomingshowExpenseValue));
  
  }
  public String getIncomingshowExpenseValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IncomingshowExpenseValue));
      }

  public void initOthers1Value(String value){
     this.initProperty(S_Others1Value,value);
  }
  public  void setOthers1Value(String value){
     this.set(S_Others1Value,value);
  }
  public  void setOthers1ValueNull(){
     this.set(S_Others1Value,null);
  }

  public String getOthers1Value(){
       return DataType.getAsString(this.get(S_Others1Value));
  
  }
  public String getOthers1ValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Others1Value));
      }

  public void initMmsExpenseValue(String value){
     this.initProperty(S_MmsExpenseValue,value);
  }
  public  void setMmsExpenseValue(String value){
     this.set(S_MmsExpenseValue,value);
  }
  public  void setMmsExpenseValueNull(){
     this.set(S_MmsExpenseValue,null);
  }

  public String getMmsExpenseValue(){
       return DataType.getAsString(this.get(S_MmsExpenseValue));
  
  }
  public String getMmsExpenseValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MmsExpenseValue));
      }

  public void initOthers2Value(String value){
     this.initProperty(S_Others2Value,value);
  }
  public  void setOthers2Value(String value){
     this.set(S_Others2Value,value);
  }
  public  void setOthers2ValueNull(){
     this.set(S_Others2Value,null);
  }

  public String getOthers2Value(){
       return DataType.getAsString(this.get(S_Others2Value));
  
  }
  public String getOthers2ValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Others2Value));
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

  public void initSmsExpenseValue(String value){
     this.initProperty(S_SmsExpenseValue,value);
  }
  public  void setSmsExpenseValue(String value){
     this.set(S_SmsExpenseValue,value);
  }
  public  void setSmsExpenseValueNull(){
     this.set(S_SmsExpenseValue,null);
  }

  public String getSmsExpenseValue(){
       return DataType.getAsString(this.get(S_SmsExpenseValue));
  
  }
  public String getSmsExpenseValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SmsExpenseValue));
      }

  public void initOthers3Value(String value){
     this.initProperty(S_Others3Value,value);
  }
  public  void setOthers3Value(String value){
     this.set(S_Others3Value,value);
  }
  public  void setOthers3ValueNull(){
     this.set(S_Others3Value,null);
  }

  public String getOthers3Value(){
       return DataType.getAsString(this.get(S_Others3Value));
  
  }
  public String getOthers3ValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Others3Value));
      }

  public void initWapgprsExpenseValue(String value){
     this.initProperty(S_WapgprsExpenseValue,value);
  }
  public  void setWapgprsExpenseValue(String value){
     this.set(S_WapgprsExpenseValue,value);
  }
  public  void setWapgprsExpenseValueNull(){
     this.set(S_WapgprsExpenseValue,null);
  }

  public String getWapgprsExpenseValue(){
       return DataType.getAsString(this.get(S_WapgprsExpenseValue));
  
  }
  public String getWapgprsExpenseValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WapgprsExpenseValue));
      }

  public void initWlanValue(String value){
     this.initProperty(S_WlanValue,value);
  }
  public  void setWlanValue(String value){
     this.set(S_WlanValue,value);
  }
  public  void setWlanValueNull(){
     this.set(S_WlanValue,null);
  }

  public String getWlanValue(){
       return DataType.getAsString(this.get(S_WlanValue));
  
  }
  public String getWlanValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WlanValue));
      }

  public void initOthers1Name(String value){
     this.initProperty(S_Others1Name,value);
  }
  public  void setOthers1Name(String value){
     this.set(S_Others1Name,value);
  }
  public  void setOthers1NameNull(){
     this.set(S_Others1Name,null);
  }

  public String getOthers1Name(){
       return DataType.getAsString(this.get(S_Others1Name));
  
  }
  public String getOthers1NameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Others1Name));
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

  public void initCallingExpenseValue(String value){
     this.initProperty(S_CallingExpenseValue,value);
  }
  public  void setCallingExpenseValue(String value){
     this.set(S_CallingExpenseValue,value);
  }
  public  void setCallingExpenseValueNull(){
     this.set(S_CallingExpenseValue,null);
  }

  public String getCallingExpenseValue(){
       return DataType.getAsString(this.get(S_CallingExpenseValue));
  
  }
  public String getCallingExpenseValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CallingExpenseValue));
      }

  public void initOthers4Name(String value){
     this.initProperty(S_Others4Name,value);
  }
  public  void setOthers4Name(String value){
     this.set(S_Others4Name,value);
  }
  public  void setOthers4NameNull(){
     this.set(S_Others4Name,null);
  }

  public String getOthers4Name(){
       return DataType.getAsString(this.get(S_Others4Name));
  
  }
  public String getOthers4NameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Others4Name));
      }

  public void initWlan(String value){
     this.initProperty(S_Wlan,value);
  }
  public  void setWlan(String value){
     this.set(S_Wlan,value);
  }
  public  void setWlanNull(){
     this.set(S_Wlan,null);
  }

  public String getWlan(){
       return DataType.getAsString(this.get(S_Wlan));
  
  }
  public String getWlanInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Wlan));
      }

  public void initOthers4Value(String value){
     this.initProperty(S_Others4Value,value);
  }
  public  void setOthers4Value(String value){
     this.set(S_Others4Value,value);
  }
  public  void setOthers4ValueNull(){
     this.set(S_Others4Value,null);
  }

  public String getOthers4Value(){
       return DataType.getAsString(this.get(S_Others4Value));
  
  }
  public String getOthers4ValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Others4Value));
      }

  public void initWapsmsExpenseValue(String value){
     this.initProperty(S_WapsmsExpenseValue,value);
  }
  public  void setWapsmsExpenseValue(String value){
     this.set(S_WapsmsExpenseValue,value);
  }
  public  void setWapsmsExpenseValueNull(){
     this.set(S_WapsmsExpenseValue,null);
  }

  public String getWapsmsExpenseValue(){
       return DataType.getAsString(this.get(S_WapsmsExpenseValue));
  
  }
  public String getWapsmsExpenseValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WapsmsExpenseValue));
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

  public void initMonthfixedExpenseValue(String value){
     this.initProperty(S_MonthfixedExpenseValue,value);
  }
  public  void setMonthfixedExpenseValue(String value){
     this.set(S_MonthfixedExpenseValue,value);
  }
  public  void setMonthfixedExpenseValueNull(){
     this.set(S_MonthfixedExpenseValue,null);
  }

  public String getMonthfixedExpenseValue(){
       return DataType.getAsString(this.get(S_MonthfixedExpenseValue));
  
  }
  public String getMonthfixedExpenseValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MonthfixedExpenseValue));
      }

  public void initOthers2Name(String value){
     this.initProperty(S_Others2Name,value);
  }
  public  void setOthers2Name(String value){
     this.set(S_Others2Name,value);
  }
  public  void setOthers2NameNull(){
     this.set(S_Others2Name,null);
  }

  public String getOthers2Name(){
       return DataType.getAsString(this.get(S_Others2Name));
  
  }
  public String getOthers2NameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Others2Name));
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

  public void initOthers3Name(String value){
     this.initProperty(S_Others3Name,value);
  }
  public  void setOthers3Name(String value){
     this.set(S_Others3Name,value);
  }
  public  void setOthers3NameNull(){
     this.set(S_Others3Name,null);
  }

  public String getOthers3Name(){
       return DataType.getAsString(this.get(S_Others3Name));
  
  }
  public String getOthers3NameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Others3Name));
      }


 
 }

