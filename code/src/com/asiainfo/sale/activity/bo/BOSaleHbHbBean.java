package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOSaleHbHbBean extends DataContainer implements DataContainerInterface,IBOSaleHbHbValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOSaleHbHb";



  public final static  String S_TakeEffectTime = "TAKE_EFFECT_TIME";
  public final static  String S_AomSmsContent = "AOM_SMS_CONTENT";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Mid = "MID";
  public final static  String S_ProvideArea = "PROVIDE_AREA";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_ProvideWholesaleNum = "PROVIDE_WHOLESALE_NUM";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_SaleName = "SALE_NAME";
  public final static  String S_EitName = "EIT_NAME";
  public final static  String S_LoseEffectTime = "LOSE_EFFECT_TIME";
  public final static  String S_ProvideEndDate = "PROVIDE_END_DATE";
  public final static  String S_ProvideBeginDate = "PROVIDE_BEGIN_DATE";
  public final static  String S_ArriveOfMoneySms = "ARRIVE_OF_MONEY_SMS";
  public final static  String S_Id = "ID";
  public final static  String S_ProvideCall = "PROVIDE_CALL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
    	e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  public BOSaleHbHbBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initTakeEffectTime(Timestamp value){
     this.initProperty(S_TakeEffectTime,value);
  }
  public  void setTakeEffectTime(Timestamp value){
     this.set(S_TakeEffectTime,value);
  }
  public  void setTakeEffectTimeNull(){
     this.set(S_TakeEffectTime,null);
  }

  public Timestamp getTakeEffectTime(){
        return DataType.getAsDateTime(this.get(S_TakeEffectTime));
  
  }
  public Timestamp getTakeEffectTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_TakeEffectTime));
      }

  public void initAomSmsContent(String value){
     this.initProperty(S_AomSmsContent,value);
  }
  public  void setAomSmsContent(String value){
     this.set(S_AomSmsContent,value);
  }
  public  void setAomSmsContentNull(){
     this.set(S_AomSmsContent,null);
  }

  public String getAomSmsContent(){
       return DataType.getAsString(this.get(S_AomSmsContent));
  
  }
  public String getAomSmsContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AomSmsContent));
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

  public void initProvideArea(String value){
     this.initProperty(S_ProvideArea,value);
  }
  public  void setProvideArea(String value){
     this.set(S_ProvideArea,value);
  }
  public  void setProvideAreaNull(){
     this.set(S_ProvideArea,null);
  }

  public String getProvideArea(){
       return DataType.getAsString(this.get(S_ProvideArea));
  
  }
  public String getProvideAreaInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvideArea));
      }

  public void initRemark3(long value){
     this.initProperty(S_Remark3,new Long(value));
  }
  public  void setRemark3(long value){
     this.set(S_Remark3,new Long(value));
  }
  public  void setRemark3Null(){
     this.set(S_Remark3,null);
  }

  public long getRemark3(){
        return DataType.getAsLong(this.get(S_Remark3));
  
  }
  public long getRemark3InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Remark3));
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

  public void initProvideWholesaleNum(long value){
     this.initProperty(S_ProvideWholesaleNum,new Long(value));
  }
  public  void setProvideWholesaleNum(long value){
     this.set(S_ProvideWholesaleNum,new Long(value));
  }
  public  void setProvideWholesaleNumNull(){
     this.set(S_ProvideWholesaleNum,null);
  }

  public long getProvideWholesaleNum(){
        return DataType.getAsLong(this.get(S_ProvideWholesaleNum));
  
  }
  public long getProvideWholesaleNumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ProvideWholesaleNum));
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

  public void initSaleName(String value){
     this.initProperty(S_SaleName,value);
  }
  public  void setSaleName(String value){
     this.set(S_SaleName,value);
  }
  public  void setSaleNameNull(){
     this.set(S_SaleName,null);
  }

  public String getSaleName(){
       return DataType.getAsString(this.get(S_SaleName));
  
  }
  public String getSaleNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleName));
      }

  public void initEitName(String value){
     this.initProperty(S_EitName,value);
  }
  public  void setEitName(String value){
     this.set(S_EitName,value);
  }
  public  void setEitNameNull(){
     this.set(S_EitName,null);
  }

  public String getEitName(){
       return DataType.getAsString(this.get(S_EitName));
  
  }
  public String getEitNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EitName));
      }

  public void initLoseEffectTime(Timestamp value){
     this.initProperty(S_LoseEffectTime,value);
  }
  public  void setLoseEffectTime(Timestamp value){
     this.set(S_LoseEffectTime,value);
  }
  public  void setLoseEffectTimeNull(){
     this.set(S_LoseEffectTime,null);
  }

  public Timestamp getLoseEffectTime(){
        return DataType.getAsDateTime(this.get(S_LoseEffectTime));
  
  }
  public Timestamp getLoseEffectTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_LoseEffectTime));
      }

  public void initProvideEndDate(Timestamp value){
     this.initProperty(S_ProvideEndDate,value);
  }
  public  void setProvideEndDate(Timestamp value){
     this.set(S_ProvideEndDate,value);
  }
  public  void setProvideEndDateNull(){
     this.set(S_ProvideEndDate,null);
  }

  public Timestamp getProvideEndDate(){
        return DataType.getAsDateTime(this.get(S_ProvideEndDate));
  
  }
  public Timestamp getProvideEndDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ProvideEndDate));
      }

  public void initProvideBeginDate(Timestamp value){
     this.initProperty(S_ProvideBeginDate,value);
  }
  public  void setProvideBeginDate(Timestamp value){
     this.set(S_ProvideBeginDate,value);
  }
  public  void setProvideBeginDateNull(){
     this.set(S_ProvideBeginDate,null);
  }

  public Timestamp getProvideBeginDate(){
        return DataType.getAsDateTime(this.get(S_ProvideBeginDate));
  
  }
  public Timestamp getProvideBeginDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ProvideBeginDate));
      }

  public void initArriveOfMoneySms(String value){
     this.initProperty(S_ArriveOfMoneySms,value);
  }
  public  void setArriveOfMoneySms(String value){
     this.set(S_ArriveOfMoneySms,value);
  }
  public  void setArriveOfMoneySmsNull(){
     this.set(S_ArriveOfMoneySms,null);
  }

  public String getArriveOfMoneySms(){
       return DataType.getAsString(this.get(S_ArriveOfMoneySms));
  
  }
  public String getArriveOfMoneySmsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ArriveOfMoneySms));
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

  public void initProvideCall(String value){
     this.initProperty(S_ProvideCall,value);
  }
  public  void setProvideCall(String value){
     this.set(S_ProvideCall,value);
  }
  public  void setProvideCallNull(){
     this.set(S_ProvideCall,null);
  }

  public String getProvideCall(){
       return DataType.getAsString(this.get(S_ProvideCall));
  
  }
  public String getProvideCallInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvideCall));
      }


 
 }

