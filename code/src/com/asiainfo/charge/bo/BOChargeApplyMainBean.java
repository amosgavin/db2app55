package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeApplyMainBean extends DataContainer implements DataContainerInterface,IBOChargeApplyMainValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeApplyMain";



  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_ApplyModifyTime = "APPLY_MODIFY_TIME";
  public final static  String S_BackGround = "BACK_GROUND";
  public final static  String S_SaleFashion = "SALE_FASHION";
  public final static  String S_ApplyTime = "APPLY_TIME";
  public final static  String S_ExtendChannel = "EXTEND_CHANNEL";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_ApplyMark = "APPLY_MARK";
  public final static  String S_FeeType = "FEE_TYPE";
  public final static  String S_ConsumeAnalyse = "CONSUME_ANALYSE";
  public final static  String S_MainId = "MAIN_ID";
  public final static  String S_ApplyEndTime = "APPLY_END_TIME";
  public final static  String S_Flack = "FLACK";
  public final static  String S_MarketType = "MARKET_TYPE";
  public final static  String S_IsSubmit = "IS_SUBMIT";
  public final static  String S_UserCircs = "USER_CIRCS";
  public final static  String S_Org = "ORG";
  public final static  String S_ApplyId = "APPLY_ID";
  public final static  String S_EChannelBear = "E_CHANNEL_BEAR";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeApplyMainBean() throws AIException{
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

  public void initApplyModifyTime(Timestamp value){
     this.initProperty(S_ApplyModifyTime,value);
  }
  public  void setApplyModifyTime(Timestamp value){
     this.set(S_ApplyModifyTime,value);
  }
  public  void setApplyModifyTimeNull(){
     this.set(S_ApplyModifyTime,null);
  }

  public Timestamp getApplyModifyTime(){
        return DataType.getAsDateTime(this.get(S_ApplyModifyTime));
  
  }
  public Timestamp getApplyModifyTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ApplyModifyTime));
      }

  public void initBackGround(String value){
     this.initProperty(S_BackGround,value);
  }
  public  void setBackGround(String value){
     this.set(S_BackGround,value);
  }
  public  void setBackGroundNull(){
     this.set(S_BackGround,null);
  }

  public String getBackGround(){
       return DataType.getAsString(this.get(S_BackGround));
  
  }
  public String getBackGroundInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BackGround));
      }

  public void initSaleFashion(String value){
     this.initProperty(S_SaleFashion,value);
  }
  public  void setSaleFashion(String value){
     this.set(S_SaleFashion,value);
  }
  public  void setSaleFashionNull(){
     this.set(S_SaleFashion,null);
  }

  public String getSaleFashion(){
       return DataType.getAsString(this.get(S_SaleFashion));
  
  }
  public String getSaleFashionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleFashion));
      }

  public void initApplyTime(Timestamp value){
     this.initProperty(S_ApplyTime,value);
  }
  public  void setApplyTime(Timestamp value){
     this.set(S_ApplyTime,value);
  }
  public  void setApplyTimeNull(){
     this.set(S_ApplyTime,null);
  }

  public Timestamp getApplyTime(){
        return DataType.getAsDateTime(this.get(S_ApplyTime));
  
  }
  public Timestamp getApplyTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ApplyTime));
      }

  public void initExtendChannel(String value){
     this.initProperty(S_ExtendChannel,value);
  }
  public  void setExtendChannel(String value){
     this.set(S_ExtendChannel,value);
  }
  public  void setExtendChannelNull(){
     this.set(S_ExtendChannel,null);
  }

  public String getExtendChannel(){
       return DataType.getAsString(this.get(S_ExtendChannel));
  
  }
  public String getExtendChannelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendChannel));
      }

  public void initPrinciple(String value){
     this.initProperty(S_Principle,value);
  }
  public  void setPrinciple(String value){
     this.set(S_Principle,value);
  }
  public  void setPrincipleNull(){
     this.set(S_Principle,null);
  }

  public String getPrinciple(){
       return DataType.getAsString(this.get(S_Principle));
  
  }
  public String getPrincipleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Principle));
      }

  public void initApplyMark(String value){
     this.initProperty(S_ApplyMark,value);
  }
  public  void setApplyMark(String value){
     this.set(S_ApplyMark,value);
  }
  public  void setApplyMarkNull(){
     this.set(S_ApplyMark,null);
  }

  public String getApplyMark(){
       return DataType.getAsString(this.get(S_ApplyMark));
  
  }
  public String getApplyMarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ApplyMark));
      }

  public void initFeeType(String value){
     this.initProperty(S_FeeType,value);
  }
  public  void setFeeType(String value){
     this.set(S_FeeType,value);
  }
  public  void setFeeTypeNull(){
     this.set(S_FeeType,null);
  }

  public String getFeeType(){
       return DataType.getAsString(this.get(S_FeeType));
  
  }
  public String getFeeTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeeType));
      }

  public void initConsumeAnalyse(String value){
     this.initProperty(S_ConsumeAnalyse,value);
  }
  public  void setConsumeAnalyse(String value){
     this.set(S_ConsumeAnalyse,value);
  }
  public  void setConsumeAnalyseNull(){
     this.set(S_ConsumeAnalyse,null);
  }

  public String getConsumeAnalyse(){
       return DataType.getAsString(this.get(S_ConsumeAnalyse));
  
  }
  public String getConsumeAnalyseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ConsumeAnalyse));
      }

  public void initMainId(String value){
     this.initProperty(S_MainId,value);
  }
  public  void setMainId(String value){
     this.set(S_MainId,value);
  }
  public  void setMainIdNull(){
     this.set(S_MainId,null);
  }

  public String getMainId(){
       return DataType.getAsString(this.get(S_MainId));
  
  }
  public String getMainIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MainId));
      }

  public void initApplyEndTime(Timestamp value){
     this.initProperty(S_ApplyEndTime,value);
  }
  public  void setApplyEndTime(Timestamp value){
     this.set(S_ApplyEndTime,value);
  }
  public  void setApplyEndTimeNull(){
     this.set(S_ApplyEndTime,null);
  }

  public Timestamp getApplyEndTime(){
        return DataType.getAsDateTime(this.get(S_ApplyEndTime));
  
  }
  public Timestamp getApplyEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ApplyEndTime));
      }

  public void initFlack(String value){
     this.initProperty(S_Flack,value);
  }
  public  void setFlack(String value){
     this.set(S_Flack,value);
  }
  public  void setFlackNull(){
     this.set(S_Flack,null);
  }

  public String getFlack(){
       return DataType.getAsString(this.get(S_Flack));
  
  }
  public String getFlackInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Flack));
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

  public void initIsSubmit(String value){
     this.initProperty(S_IsSubmit,value);
  }
  public  void setIsSubmit(String value){
     this.set(S_IsSubmit,value);
  }
  public  void setIsSubmitNull(){
     this.set(S_IsSubmit,null);
  }

  public String getIsSubmit(){
       return DataType.getAsString(this.get(S_IsSubmit));
  
  }
  public String getIsSubmitInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSubmit));
      }

  public void initUserCircs(String value){
     this.initProperty(S_UserCircs,value);
  }
  public  void setUserCircs(String value){
     this.set(S_UserCircs,value);
  }
  public  void setUserCircsNull(){
     this.set(S_UserCircs,null);
  }

  public String getUserCircs(){
       return DataType.getAsString(this.get(S_UserCircs));
  
  }
  public String getUserCircsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserCircs));
      }

  public void initOrg(String value){
     this.initProperty(S_Org,value);
  }
  public  void setOrg(String value){
     this.set(S_Org,value);
  }
  public  void setOrgNull(){
     this.set(S_Org,null);
  }

  public String getOrg(){
       return DataType.getAsString(this.get(S_Org));
  
  }
  public String getOrgInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Org));
      }

  public void initApplyId(String value){
     this.initProperty(S_ApplyId,value);
  }
  public  void setApplyId(String value){
     this.set(S_ApplyId,value);
  }
  public  void setApplyIdNull(){
     this.set(S_ApplyId,null);
  }

  public String getApplyId(){
       return DataType.getAsString(this.get(S_ApplyId));
  
  }
  public String getApplyIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ApplyId));
      }

  public void initEChannelBear(String value){
	     this.initProperty(S_EChannelBear,value);
	  }
	  public  void setEChannelBear(String value){
	     this.set(S_EChannelBear,value);
	  }
	  public  void setEChannelBearNull(){
	     this.set(S_EChannelBear,null);
	  }

	  public String getEChannelBear(){
	       return DataType.getAsString(this.get(S_EChannelBear));
	  
	  }
	  public String getEChannelBearInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_EChannelBear));
	      }


 }

