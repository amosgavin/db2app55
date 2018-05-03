package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BoSaleEitAppriseBean extends DataContainer implements DataContainerInterface,IBoSaleEitAppriseValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BoSaleEitApprise";



  public final static  String S_AomSmsContent = "AOM_SMS_CONTENT";
  public final static  String S_TriggerCondition = "TRIGGER_CONDITION";
  public final static  String S_ProvideArea = "PROVIDE_AREA";
  public final static  String S_SampleDealInterval = "SAMPLE_DEAL_INTERVAL";
  public final static  String S_MaxProvidenumOneday = "MAX_PROVIDENUM_ONEDAY";
  public final static  String S_SaleName = "SALE_NAME";
  public final static  String S_Mid = "MID";
  public final static  String S_MaxReceivenumIncycle = "MAX_RECEIVENUM_INCYCLE";
  public final static  String S_OfdSmsContent = "OFD_SMS_CONTENT";
  public final static  String S_UseBusiProp = "USE_BUSI_PROP";
  public final static  String S_ProvideBeginDate = "PROVIDE_BEGIN_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_MaxReceivenumInliquid = "MAX_RECEIVENUM_INLIQUID";
  public final static  String S_OutOfDateSms = "OUT_OF_DATE_SMS";
  public final static  String S_ParticipateCycle = "PARTICIPATE_CYCLE";
  public final static  String S_EitName = "EIT_NAME";
  public final static  String S_ReceiveBusiPerson = "RECEIVE_BUSI_PERSON";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_Remark5 = "REMARK5";
  public final static  String S_ProvideCall = "PROVIDE_CALL";
  public final static  String S_ProvideEndDate = "PROVIDE_END_DATE";
  public final static  String S_LevcodeRelaLevid = "LEVCODE_RELA_LEVID";
  public final static  String S_ArriveOfMoneySms = "ARRIVE_OF_MONEY_SMS";
  public final static  String S_ActiveType = "ACTIVE_TYPE";
  public final static  String S_ChannelChargeProp = "CHANNEL_CHARGE_PROP";
  public final static  String S_SampleEitValid = "SAMPLE_EIT_VALID";
  public final static  String S_UseBusiPerson = "USE_BUSI_PERSON";
  public final static  String S_AfterBuyeitValid = "AFTER_BUYEIT_VALID";
  public final static  String S_ProvideWholesaleNum = "PROVIDE_WHOLESALE_NUM";
  public final static  String S_AlluseValidDate = "ALLUSE_VALID_DATE";
  public final static  String S_ReceiveBusiProp = "RECEIVE_BUSI_PROP";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BoSaleEitAppriseBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initTriggerCondition(String value){
     this.initProperty(S_TriggerCondition,value);
  }
  public  void setTriggerCondition(String value){
     this.set(S_TriggerCondition,value);
  }
  public  void setTriggerConditionNull(){
     this.set(S_TriggerCondition,null);
  }

  public String getTriggerCondition(){
       return DataType.getAsString(this.get(S_TriggerCondition));
  
  }
  public String getTriggerConditionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TriggerCondition));
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

  public void initSampleDealInterval(String value){
     this.initProperty(S_SampleDealInterval,value);
  }
  public  void setSampleDealInterval(String value){
     this.set(S_SampleDealInterval,value);
  }
  public  void setSampleDealIntervalNull(){
     this.set(S_SampleDealInterval,null);
  }

  public String getSampleDealInterval(){
       return DataType.getAsString(this.get(S_SampleDealInterval));
  
  }
  public String getSampleDealIntervalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SampleDealInterval));
      }

  public void initMaxProvidenumOneday(String value){
     this.initProperty(S_MaxProvidenumOneday,value);
  }
  public  void setMaxProvidenumOneday(String value){
     this.set(S_MaxProvidenumOneday,value);
  }
  public  void setMaxProvidenumOnedayNull(){
     this.set(S_MaxProvidenumOneday,null);
  }

  public String getMaxProvidenumOneday(){
       return DataType.getAsString(this.get(S_MaxProvidenumOneday));
  
  }
  public String getMaxProvidenumOnedayInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MaxProvidenumOneday));
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

  public void initMaxReceivenumIncycle(String value){
     this.initProperty(S_MaxReceivenumIncycle,value);
  }
  public  void setMaxReceivenumIncycle(String value){
     this.set(S_MaxReceivenumIncycle,value);
  }
  public  void setMaxReceivenumIncycleNull(){
     this.set(S_MaxReceivenumIncycle,null);
  }

  public String getMaxReceivenumIncycle(){
       return DataType.getAsString(this.get(S_MaxReceivenumIncycle));
  
  }
  public String getMaxReceivenumIncycleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MaxReceivenumIncycle));
      }

  public void initOfdSmsContent(String value){
     this.initProperty(S_OfdSmsContent,value);
  }
  public  void setOfdSmsContent(String value){
     this.set(S_OfdSmsContent,value);
  }
  public  void setOfdSmsContentNull(){
     this.set(S_OfdSmsContent,null);
  }

  public String getOfdSmsContent(){
       return DataType.getAsString(this.get(S_OfdSmsContent));
  
  }
  public String getOfdSmsContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OfdSmsContent));
      }

  public void initUseBusiProp(String value){
     this.initProperty(S_UseBusiProp,value);
  }
  public  void setUseBusiProp(String value){
     this.set(S_UseBusiProp,value);
  }
  public  void setUseBusiPropNull(){
     this.set(S_UseBusiProp,null);
  }

  public String getUseBusiProp(){
       return DataType.getAsString(this.get(S_UseBusiProp));
  
  }
  public String getUseBusiPropInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UseBusiProp));
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

  public void initMaxReceivenumInliquid(String value){
     this.initProperty(S_MaxReceivenumInliquid,value);
  }
  public  void setMaxReceivenumInliquid(String value){
     this.set(S_MaxReceivenumInliquid,value);
  }
  public  void setMaxReceivenumInliquidNull(){
     this.set(S_MaxReceivenumInliquid,null);
  }

  public String getMaxReceivenumInliquid(){
       return DataType.getAsString(this.get(S_MaxReceivenumInliquid));
  
  }
  public String getMaxReceivenumInliquidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MaxReceivenumInliquid));
      }

  public void initOutOfDateSms(String value){
     this.initProperty(S_OutOfDateSms,value);
  }
  public  void setOutOfDateSms(String value){
     this.set(S_OutOfDateSms,value);
  }
  public  void setOutOfDateSmsNull(){
     this.set(S_OutOfDateSms,null);
  }

  public String getOutOfDateSms(){
       return DataType.getAsString(this.get(S_OutOfDateSms));
  
  }
  public String getOutOfDateSmsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OutOfDateSms));
      }

  public void initParticipateCycle(String value){
     this.initProperty(S_ParticipateCycle,value);
  }
  public  void setParticipateCycle(String value){
     this.set(S_ParticipateCycle,value);
  }
  public  void setParticipateCycleNull(){
     this.set(S_ParticipateCycle,null);
  }

  public String getParticipateCycle(){
       return DataType.getAsString(this.get(S_ParticipateCycle));
  
  }
  public String getParticipateCycleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParticipateCycle));
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

  public void initReceiveBusiPerson(String value){
     this.initProperty(S_ReceiveBusiPerson,value);
  }
  public  void setReceiveBusiPerson(String value){
     this.set(S_ReceiveBusiPerson,value);
  }
  public  void setReceiveBusiPersonNull(){
     this.set(S_ReceiveBusiPerson,null);
  }

  public String getReceiveBusiPerson(){
       return DataType.getAsString(this.get(S_ReceiveBusiPerson));
  
  }
  public String getReceiveBusiPersonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReceiveBusiPerson));
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

  public void initRemark5(String value){
     this.initProperty(S_Remark5,value);
  }
  public  void setRemark5(String value){
     this.set(S_Remark5,value);
  }
  public  void setRemark5Null(){
     this.set(S_Remark5,null);
  }

  public String getRemark5(){
       return DataType.getAsString(this.get(S_Remark5));
  
  }
  public String getRemark5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark5));
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

  public void initLevcodeRelaLevid(String value){
     this.initProperty(S_LevcodeRelaLevid,value);
  }
  public  void setLevcodeRelaLevid(String value){
     this.set(S_LevcodeRelaLevid,value);
  }
  public  void setLevcodeRelaLevidNull(){
     this.set(S_LevcodeRelaLevid,null);
  }

  public String getLevcodeRelaLevid(){
       return DataType.getAsString(this.get(S_LevcodeRelaLevid));
  
  }
  public String getLevcodeRelaLevidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevcodeRelaLevid));
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

  public void initActiveType(String value){
     this.initProperty(S_ActiveType,value);
  }
  public  void setActiveType(String value){
     this.set(S_ActiveType,value);
  }
  public  void setActiveTypeNull(){
     this.set(S_ActiveType,null);
  }

  public String getActiveType(){
       return DataType.getAsString(this.get(S_ActiveType));
  
  }
  public String getActiveTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActiveType));
      }

  public void initChannelChargeProp(String value){
     this.initProperty(S_ChannelChargeProp,value);
  }
  public  void setChannelChargeProp(String value){
     this.set(S_ChannelChargeProp,value);
  }
  public  void setChannelChargePropNull(){
     this.set(S_ChannelChargeProp,null);
  }

  public String getChannelChargeProp(){
       return DataType.getAsString(this.get(S_ChannelChargeProp));
  
  }
  public String getChannelChargePropInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChannelChargeProp));
      }

  public void initSampleEitValid(String value){
     this.initProperty(S_SampleEitValid,value);
  }
  public  void setSampleEitValid(String value){
     this.set(S_SampleEitValid,value);
  }
  public  void setSampleEitValidNull(){
     this.set(S_SampleEitValid,null);
  }

  public String getSampleEitValid(){
       return DataType.getAsString(this.get(S_SampleEitValid));
  
  }
  public String getSampleEitValidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SampleEitValid));
      }

  public void initUseBusiPerson(String value){
     this.initProperty(S_UseBusiPerson,value);
  }
  public  void setUseBusiPerson(String value){
     this.set(S_UseBusiPerson,value);
  }
  public  void setUseBusiPersonNull(){
     this.set(S_UseBusiPerson,null);
  }

  public String getUseBusiPerson(){
       return DataType.getAsString(this.get(S_UseBusiPerson));
  
  }
  public String getUseBusiPersonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UseBusiPerson));
      }

  public void initAfterBuyeitValid(String value){
     this.initProperty(S_AfterBuyeitValid,value);
  }
  public  void setAfterBuyeitValid(String value){
     this.set(S_AfterBuyeitValid,value);
  }
  public  void setAfterBuyeitValidNull(){
     this.set(S_AfterBuyeitValid,null);
  }

  public String getAfterBuyeitValid(){
       return DataType.getAsString(this.get(S_AfterBuyeitValid));
  
  }
  public String getAfterBuyeitValidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AfterBuyeitValid));
      }

  public void initProvideWholesaleNum(double value){
     this.initProperty(S_ProvideWholesaleNum,new Double(value));
  }
  public  void setProvideWholesaleNum(double value){
     this.set(S_ProvideWholesaleNum,new Double(value));
  }
  public  void setProvideWholesaleNumNull(){
     this.set(S_ProvideWholesaleNum,null);
  }

  public double getProvideWholesaleNum(){
        return DataType.getAsDouble(this.get(S_ProvideWholesaleNum));
  
  }
  public double getProvideWholesaleNumInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ProvideWholesaleNum));
      }

  public void initAlluseValidDate(Timestamp value){
     this.initProperty(S_AlluseValidDate,value);
  }
  public  void setAlluseValidDate(Timestamp value){
     this.set(S_AlluseValidDate,value);
  }
  public  void setAlluseValidDateNull(){
     this.set(S_AlluseValidDate,null);
  }

  public Timestamp getAlluseValidDate(){
        return DataType.getAsDateTime(this.get(S_AlluseValidDate));
  
  }
  public Timestamp getAlluseValidDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AlluseValidDate));
      }

  public void initReceiveBusiProp(String value){
     this.initProperty(S_ReceiveBusiProp,value);
  }
  public  void setReceiveBusiProp(String value){
     this.set(S_ReceiveBusiProp,value);
  }
  public  void setReceiveBusiPropNull(){
     this.set(S_ReceiveBusiProp,null);
  }

  public String getReceiveBusiProp(){
       return DataType.getAsString(this.get(S_ReceiveBusiProp));
  
  }
  public String getReceiveBusiPropInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReceiveBusiProp));
      }


 
 }

