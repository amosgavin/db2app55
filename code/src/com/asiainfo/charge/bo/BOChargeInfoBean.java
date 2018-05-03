package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeInfoBean extends DataContainer implements DataContainerInterface,IBOChargeInfoValue{

  @Override
	public void unDelete() {
		// TODO Auto-generated method stub
		super.unDelete();
	}
private static String  m_boName = "com.asiainfo.charge.bo.BOChargeInfo";
  public final static  String S_FlowCharge = "FLOW_CHARGE";
  public final static  String S_EarningTotal = "EARNING_TOTAL";
  public final static  String S_ChargeType = "CHARGE_TYPE";
  public final static  String S_Mid = "MID";
  public final static  String S_DoorDamnify = "DOOR_DAMNIFY";
  public final static  String S_Case = "CASE";
  public final static  String S_ChargeCategory = "CHARGE_CATEGORY";
  public final static  String S_InaddUserCount = "INADD_USER_COUNT";
  public final static  String S_ApplyId = "APPLY_ID";
  public final static  String S_FeeMark = "FEE_MARK";
  public final static  String S_DoorEarning = "DOOR_EARNING";
  public final static  String S_NinnerTochargeCount = "NINNER_TOCHARGE_COUNT";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_PreferentialId2 = "PREFERENTIAL_ID2";
  public final static  String S_PreferentialId1 = "PREFERENTIAL_ID1";
  public final static  String S_PreferentialId4 = "PREFERENTIAL_ID4";
  public final static  String S_FeeName = "FEE_NAME";
  public final static  String S_PreferentialId3 = "PREFERENTIAL_ID3";
  public final static  String S_AddUserMarket = "ADD_USER_MARKET";
  public final static  String S_PreferentialId5 = "PREFERENTIAL_ID5";
  public final static  String S_EarningDamnify = "EARNING_DAMNIFY";
  public final static  String S_IsDivide = "IS_DIVIDE";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_Ext7 = "EXT7";
  public final static  String S_Ext8 = "EXT8";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_IntendingAcount = "INTENDING_ACOUNT";
  public final static  String S_IsSendSms = "IS_SEND_SMS";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_IsGroup = "IS_GROUP";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_SpliceMutexRule = "SPLICE_MUTEX_RULE";
  public final static  String S_Ext4 = "EXT4";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initFlowCharge(String value){
     this.initProperty(S_FlowCharge,value);
  }
  public  void setFlowCharge(String value){
     this.set(S_FlowCharge,value);
  }
  public  void setFlowChargeNull(){
     this.set(S_FlowCharge,null);
  }

  public String getFlowCharge(){
       return DataType.getAsString(this.get(S_FlowCharge));
  
  }
  public String getFlowChargeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FlowCharge));
      }

  public void initEarningTotal(String value){
     this.initProperty(S_EarningTotal,value);
  }
  public  void setEarningTotal(String value){
     this.set(S_EarningTotal,value);
  }
  public  void setEarningTotalNull(){
     this.set(S_EarningTotal,null);
  }

  public String getEarningTotal(){
       return DataType.getAsString(this.get(S_EarningTotal));
  
  }
  public String getEarningTotalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EarningTotal));
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

  public void initDoorDamnify(double value){
     this.initProperty(S_DoorDamnify,new Double(value));
  }
  public  void setDoorDamnify(double value){
     this.set(S_DoorDamnify,new Double(value));
  }
  public  void setDoorDamnifyNull(){
     this.set(S_DoorDamnify,null);
  }

  public double getDoorDamnify(){
        return DataType.getAsDouble(this.get(S_DoorDamnify));
  
  }
  public double getDoorDamnifyInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_DoorDamnify));
      }

  public void initCase(String value){
     this.initProperty(S_Case,value);
  }
  public  void setCase(String value){
     this.set(S_Case,value);
  }
  public  void setCaseNull(){
     this.set(S_Case,null);
  }

  public String getCase(){
       return DataType.getAsString(this.get(S_Case));
  
  }
  public String getCaseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Case));
      }

  public void initChargeCategory(String value){
     this.initProperty(S_ChargeCategory,value);
  }
  public  void setChargeCategory(String value){
     this.set(S_ChargeCategory,value);
  }
  public  void setChargeCategoryNull(){
     this.set(S_ChargeCategory,null);
  }

  public String getChargeCategory(){
       return DataType.getAsString(this.get(S_ChargeCategory));
  
  }
  public String getChargeCategoryInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChargeCategory));
      }

  public void initInaddUserCount(String value){
     this.initProperty(S_InaddUserCount,value);
  }
  public  void setInaddUserCount(String value){
     this.set(S_InaddUserCount,value);
  }
  public  void setInaddUserCountNull(){
     this.set(S_InaddUserCount,null);
  }

  public String getInaddUserCount(){
       return DataType.getAsString(this.get(S_InaddUserCount));
  
  }
  public String getInaddUserCountInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InaddUserCount));
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

  public void initFeeMark(String value){
     this.initProperty(S_FeeMark,value);
  }
  public  void setFeeMark(String value){
     this.set(S_FeeMark,value);
  }
  public  void setFeeMarkNull(){
     this.set(S_FeeMark,null);
  }

  public String getFeeMark(){
       return DataType.getAsString(this.get(S_FeeMark));
  
  }
  public String getFeeMarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeeMark));
      }

  public void initDoorEarning(double value){
     this.initProperty(S_DoorEarning,new Double(value));
  }
  public  void setDoorEarning(double value){
     this.set(S_DoorEarning,new Double(value));
  }
  public  void setDoorEarningNull(){
     this.set(S_DoorEarning,null);
  }

  public double getDoorEarning(){
        return DataType.getAsDouble(this.get(S_DoorEarning));
  
  }
  public double getDoorEarningInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_DoorEarning));
      }

  public void initNinnerTochargeCount(int value){
     this.initProperty(S_NinnerTochargeCount,new Integer(value));
  }
  public  void setNinnerTochargeCount(int value){
     this.set(S_NinnerTochargeCount,new Integer(value));
  }
  public  void setNinnerTochargeCountNull(){
     this.set(S_NinnerTochargeCount,null);
  }

  public int getNinnerTochargeCount(){
        return DataType.getAsInt(this.get(S_NinnerTochargeCount));
  
  }
  public int getNinnerTochargeCountInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_NinnerTochargeCount));
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

  public void initPreferentialId2(String value){
     this.initProperty(S_PreferentialId2,value);
  }
  public  void setPreferentialId2(String value){
     this.set(S_PreferentialId2,value);
  }
  public  void setPreferentialId2Null(){
     this.set(S_PreferentialId2,null);
  }

  public String getPreferentialId2(){
       return DataType.getAsString(this.get(S_PreferentialId2));
  
  }
  public String getPreferentialId2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreferentialId2));
      }

  public void initPreferentialId1(String value){
     this.initProperty(S_PreferentialId1,value);
  }
  public  void setPreferentialId1(String value){
     this.set(S_PreferentialId1,value);
  }
  public  void setPreferentialId1Null(){
     this.set(S_PreferentialId1,null);
  }

  public String getPreferentialId1(){
       return DataType.getAsString(this.get(S_PreferentialId1));
  
  }
  public String getPreferentialId1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreferentialId1));
      }

  public void initPreferentialId4(String value){
     this.initProperty(S_PreferentialId4,value);
  }
  public  void setPreferentialId4(String value){
     this.set(S_PreferentialId4,value);
  }
  public  void setPreferentialId4Null(){
     this.set(S_PreferentialId4,null);
  }

  public String getPreferentialId4(){
       return DataType.getAsString(this.get(S_PreferentialId4));
  
  }
  public String getPreferentialId4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreferentialId4));
      }

  public void initFeeName(String value){
     this.initProperty(S_FeeName,value);
  }
  public  void setFeeName(String value){
     this.set(S_FeeName,value);
  }
  public  void setFeeNameNull(){
     this.set(S_FeeName,null);
  }

  public String getFeeName(){
       return DataType.getAsString(this.get(S_FeeName));
  
  }
  public String getFeeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeeName));
      }

  public void initPreferentialId3(String value){
     this.initProperty(S_PreferentialId3,value);
  }
  public  void setPreferentialId3(String value){
     this.set(S_PreferentialId3,value);
  }
  public  void setPreferentialId3Null(){
     this.set(S_PreferentialId3,null);
  }

  public String getPreferentialId3(){
       return DataType.getAsString(this.get(S_PreferentialId3));
  
  }
  public String getPreferentialId3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreferentialId3));
      }

  public void initAddUserMarket(String value){
     this.initProperty(S_AddUserMarket,value);
  }
  public  void setAddUserMarket(String value){
     this.set(S_AddUserMarket,value);
  }
  public  void setAddUserMarketNull(){
     this.set(S_AddUserMarket,null);
  }

  public String getAddUserMarket(){
       return DataType.getAsString(this.get(S_AddUserMarket));
  
  }
  public String getAddUserMarketInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AddUserMarket));
      }

  public void initPreferentialId5(String value){
     this.initProperty(S_PreferentialId5,value);
  }
  public  void setPreferentialId5(String value){
     this.set(S_PreferentialId5,value);
  }
  public  void setPreferentialId5Null(){
     this.set(S_PreferentialId5,null);
  }

  public String getPreferentialId5(){
       return DataType.getAsString(this.get(S_PreferentialId5));
  
  }
  public String getPreferentialId5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreferentialId5));
      }

  public void initEarningDamnify(double value){
     this.initProperty(S_EarningDamnify,new Double(value));
  }
  public  void setEarningDamnify(double value){
     this.set(S_EarningDamnify,new Double(value));
  }
  public  void setEarningDamnifyNull(){
     this.set(S_EarningDamnify,null);
  }

  public double getEarningDamnify(){
        return DataType.getAsDouble(this.get(S_EarningDamnify));
  
  }
  public double getEarningDamnifyInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_EarningDamnify));
      }

  public void initIsDivide(String value){
     this.initProperty(S_IsDivide,value);
  }
  public  void setIsDivide(String value){
     this.set(S_IsDivide,value);
  }
  public  void setIsDivideNull(){
     this.set(S_IsDivide,null);
  }

  public String getIsDivide(){
       return DataType.getAsString(this.get(S_IsDivide));
  
  }
  public String getIsDivideInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsDivide));
      }

  public void initExt5(String value){
     this.initProperty(S_Ext5,value);
  }
  public  void setExt5(String value){
     this.set(S_Ext5,value);
  }
  public  void setExt5Null(){
     this.set(S_Ext5,null);
  }

  public String getExt5(){
       return DataType.getAsString(this.get(S_Ext5));
  
  }
  public String getExt5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext5));
      }

  public void initExt6(int value){
     this.initProperty(S_Ext6,new Integer(value));
  }
  public  void setExt6(int value){
     this.set(S_Ext6,new Integer(value));
  }
  public  void setExt6Null(){
     this.set(S_Ext6,null);
  }

  public int getExt6(){
        return DataType.getAsInt(this.get(S_Ext6));
  
  }
  public int getExt6InitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Ext6));
      }

  public void initExt7(int value){
     this.initProperty(S_Ext7,new Integer(value));
  }
  public  void setExt7(int value){
     this.set(S_Ext7,new Integer(value));
  }
  public  void setExt7Null(){
     this.set(S_Ext7,null);
  }

  public int getExt7(){
        return DataType.getAsInt(this.get(S_Ext7));
  
  }
  public int getExt7InitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Ext7));
      }

  public void initExt8(double value){
     this.initProperty(S_Ext8,new Double(value));
  }
  public  void setExt8(double value){
     this.set(S_Ext8,new Double(value));
  }
  public  void setExt8Null(){
     this.set(S_Ext8,null);
  }

  public double getExt8(){
        return DataType.getAsDouble(this.get(S_Ext8));
  
  }
  public double getExt8InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Ext8));
      }

  public void initExt1(String value){
     this.initProperty(S_Ext1,value);
  }
  public  void setExt1(String value){
     this.set(S_Ext1,value);
  }
  public  void setExt1Null(){
     this.set(S_Ext1,null);
  }

  public String getExt1(){
       return DataType.getAsString(this.get(S_Ext1));
  
  }
  public String getExt1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext1));
      }

  public void initIntendingAcount(int value){
     this.initProperty(S_IntendingAcount,new Integer(value));
  }
  public  void setIntendingAcount(int value){
     this.set(S_IntendingAcount,new Integer(value));
  }
  public  void setIntendingAcountNull(){
     this.set(S_IntendingAcount,null);
  }

  public int getIntendingAcount(){
        return DataType.getAsInt(this.get(S_IntendingAcount));
  
  }
  public int getIntendingAcountInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IntendingAcount));
      }

  public void initIsSendSms(String value){
     this.initProperty(S_IsSendSms,value);
  }
  public  void setIsSendSms(String value){
     this.set(S_IsSendSms,value);
  }
  public  void setIsSendSmsNull(){
     this.set(S_IsSendSms,null);
  }

  public String getIsSendSms(){
       return DataType.getAsString(this.get(S_IsSendSms));
  
  }
  public String getIsSendSmsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSendSms));
      }

  public void initExt2(String value){
     this.initProperty(S_Ext2,value);
  }
  public  void setExt2(String value){
     this.set(S_Ext2,value);
  }
  public  void setExt2Null(){
     this.set(S_Ext2,null);
  }

  public String getExt2(){
       return DataType.getAsString(this.get(S_Ext2));
  
  }
  public String getExt2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext2));
      }

  public void initIsGroup(String value){
     this.initProperty(S_IsGroup,value);
  }
  public  void setIsGroup(String value){
     this.set(S_IsGroup,value);
  }
  public  void setIsGroupNull(){
     this.set(S_IsGroup,null);
  }

  public String getIsGroup(){
       return DataType.getAsString(this.get(S_IsGroup));
  
  }
  public String getIsGroupInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsGroup));
      }

  public void initExt3(String value){
     this.initProperty(S_Ext3,value);
  }
  public  void setExt3(String value){
     this.set(S_Ext3,value);
  }
  public  void setExt3Null(){
     this.set(S_Ext3,null);
  }

  public String getExt3(){
       return DataType.getAsString(this.get(S_Ext3));
  
  }
  public String getExt3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext3));
      }

  public void initSpliceMutexRule(String value){
     this.initProperty(S_SpliceMutexRule,value);
  }
  public  void setSpliceMutexRule(String value){
     this.set(S_SpliceMutexRule,value);
  }
  public  void setSpliceMutexRuleNull(){
     this.set(S_SpliceMutexRule,null);
  }

  public String getSpliceMutexRule(){
       return DataType.getAsString(this.get(S_SpliceMutexRule));
  
  }
  public String getSpliceMutexRuleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SpliceMutexRule));
      }

  public void initExt4(String value){
     this.initProperty(S_Ext4,value);
  }
  public  void setExt4(String value){
     this.set(S_Ext4,value);
  }
  public  void setExt4Null(){
     this.set(S_Ext4,null);
  }

  public String getExt4(){
       return DataType.getAsString(this.get(S_Ext4));
  
  }
  public String getExt4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext4));
      }


 
 }

