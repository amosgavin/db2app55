package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeCfgBean extends DataContainer implements DataContainerInterface,IBOChargeCfgValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeCfg";



  public final static  String S_MapName = "MAP_NAME";
  public final static  String S_BatchCode = "BATCH_CODE";
  public final static  String S_ProductName = "PRODUCT_NAME";
  public final static  String S_RelaSetName = "RELA_SET_NAME";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_ProductCode = "PRODUCT_CODE";
  public final static  String S_CourseCode = "COURSE_CODE";
  public final static  String S_PreCode = "PRE_CODE";
  public final static  String S_RelaFeegroupName = "RELA_FEEGROUP_NAME";
  public final static  String S_PreName = "PRE_NAME";
  public final static  String S_FeeGroupCode = "FEE_GROUP_CODE";
  public final static  String S_AccountsCode = "ACCOUNTS_CODE";
  public final static  String S_SetModifyReason = "SET_MODIFY_REASON";
  public final static  String S_SetCode = "SET_CODE";
  public final static  String S_RelaFeegroupCode = "RELA_FEEGROUP_CODE";
  public final static  String S_FeegroupModifyReason = "FEEGROUP_MODIFY_REASON";
  public final static  String S_Reamrk7 = "REAMRK7";
  public final static  String S_Cfid = "CFID";
  public final static  String S_FeeGroupName = "FEE_GROUP_NAME";
  public final static  String S_RelaMapCode = "RELA_MAP_CODE";
  public final static  String S_Flag = "FLAG";
  public final static  String S_MapModifyReason = "MAP_MODIFY_REASON";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_CourseName = "COURSE_NAME";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_Remark5 = "REMARK5";
  public final static  String S_BatchName = "BATCH_NAME";
  public final static  String S_Remark6 = "REMARK6";
  public final static  String S_MapCode = "MAP_CODE";
  public final static  String S_SetNm = "SET_NM";
  public final static  String S_RelaSetCode = "RELA_SET_CODE";
  public final static  String S_AccountsName = "ACCOUNTS_NAME";
  public final static  String S_RelaMapName = "RELA_MAP_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeCfgBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initMapName(String value){
     this.initProperty(S_MapName,value);
  }
  public  void setMapName(String value){
     this.set(S_MapName,value);
  }
  public  void setMapNameNull(){
     this.set(S_MapName,null);
  }

  public String getMapName(){
       return DataType.getAsString(this.get(S_MapName));
  
  }
  public String getMapNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MapName));
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

  public void initProductName(String value){
     this.initProperty(S_ProductName,value);
  }
  public  void setProductName(String value){
     this.set(S_ProductName,value);
  }
  public  void setProductNameNull(){
     this.set(S_ProductName,null);
  }

  public String getProductName(){
       return DataType.getAsString(this.get(S_ProductName));
  
  }
  public String getProductNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProductName));
      }

  public void initRelaSetName(String value){
     this.initProperty(S_RelaSetName,value);
  }
  public  void setRelaSetName(String value){
     this.set(S_RelaSetName,value);
  }
  public  void setRelaSetNameNull(){
     this.set(S_RelaSetName,null);
  }

  public String getRelaSetName(){
       return DataType.getAsString(this.get(S_RelaSetName));
  
  }
  public String getRelaSetNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelaSetName));
      }

  public void initChargeId(int value){
     this.initProperty(S_ChargeId,new Integer(value));
  }
  public  void setChargeId(int value){
     this.set(S_ChargeId,new Integer(value));
  }
  public  void setChargeIdNull(){
     this.set(S_ChargeId,null);
  }

  public int getChargeId(){
        return DataType.getAsInt(this.get(S_ChargeId));
  
  }
  public int getChargeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ChargeId));
      }

  public void initProductCode(String value){
     this.initProperty(S_ProductCode,value);
  }
  public  void setProductCode(String value){
     this.set(S_ProductCode,value);
  }
  public  void setProductCodeNull(){
     this.set(S_ProductCode,null);
  }

  public String getProductCode(){
       return DataType.getAsString(this.get(S_ProductCode));
  
  }
  public String getProductCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProductCode));
      }

  public void initCourseCode(String value){
     this.initProperty(S_CourseCode,value);
  }
  public  void setCourseCode(String value){
     this.set(S_CourseCode,value);
  }
  public  void setCourseCodeNull(){
     this.set(S_CourseCode,null);
  }

  public String getCourseCode(){
       return DataType.getAsString(this.get(S_CourseCode));
  
  }
  public String getCourseCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CourseCode));
      }

  public void initPreCode(String value){
     this.initProperty(S_PreCode,value);
  }
  public  void setPreCode(String value){
     this.set(S_PreCode,value);
  }
  public  void setPreCodeNull(){
     this.set(S_PreCode,null);
  }

  public String getPreCode(){
       return DataType.getAsString(this.get(S_PreCode));
  
  }
  public String getPreCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreCode));
      }

  public void initRelaFeegroupName(String value){
     this.initProperty(S_RelaFeegroupName,value);
  }
  public  void setRelaFeegroupName(String value){
     this.set(S_RelaFeegroupName,value);
  }
  public  void setRelaFeegroupNameNull(){
     this.set(S_RelaFeegroupName,null);
  }

  public String getRelaFeegroupName(){
       return DataType.getAsString(this.get(S_RelaFeegroupName));
  
  }
  public String getRelaFeegroupNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelaFeegroupName));
      }

  public void initPreName(String value){
     this.initProperty(S_PreName,value);
  }
  public  void setPreName(String value){
     this.set(S_PreName,value);
  }
  public  void setPreNameNull(){
     this.set(S_PreName,null);
  }

  public String getPreName(){
       return DataType.getAsString(this.get(S_PreName));
  
  }
  public String getPreNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreName));
      }

  public void initFeeGroupCode(String value){
     this.initProperty(S_FeeGroupCode,value);
  }
  public  void setFeeGroupCode(String value){
     this.set(S_FeeGroupCode,value);
  }
  public  void setFeeGroupCodeNull(){
     this.set(S_FeeGroupCode,null);
  }

  public String getFeeGroupCode(){
       return DataType.getAsString(this.get(S_FeeGroupCode));
  
  }
  public String getFeeGroupCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeeGroupCode));
      }

  public void initAccountsCode(String value){
     this.initProperty(S_AccountsCode,value);
  }
  public  void setAccountsCode(String value){
     this.set(S_AccountsCode,value);
  }
  public  void setAccountsCodeNull(){
     this.set(S_AccountsCode,null);
  }

  public String getAccountsCode(){
       return DataType.getAsString(this.get(S_AccountsCode));
  
  }
  public String getAccountsCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AccountsCode));
      }

  public void initSetModifyReason(String value){
     this.initProperty(S_SetModifyReason,value);
  }
  public  void setSetModifyReason(String value){
     this.set(S_SetModifyReason,value);
  }
  public  void setSetModifyReasonNull(){
     this.set(S_SetModifyReason,null);
  }

  public String getSetModifyReason(){
       return DataType.getAsString(this.get(S_SetModifyReason));
  
  }
  public String getSetModifyReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SetModifyReason));
      }

  public void initSetCode(String value){
     this.initProperty(S_SetCode,value);
  }
  public  void setSetCode(String value){
     this.set(S_SetCode,value);
  }
  public  void setSetCodeNull(){
     this.set(S_SetCode,null);
  }

  public String getSetCode(){
       return DataType.getAsString(this.get(S_SetCode));
  
  }
  public String getSetCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SetCode));
      }

  public void initRelaFeegroupCode(String value){
     this.initProperty(S_RelaFeegroupCode,value);
  }
  public  void setRelaFeegroupCode(String value){
     this.set(S_RelaFeegroupCode,value);
  }
  public  void setRelaFeegroupCodeNull(){
     this.set(S_RelaFeegroupCode,null);
  }

  public String getRelaFeegroupCode(){
       return DataType.getAsString(this.get(S_RelaFeegroupCode));
  
  }
  public String getRelaFeegroupCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelaFeegroupCode));
      }

  public void initFeegroupModifyReason(String value){
     this.initProperty(S_FeegroupModifyReason,value);
  }
  public  void setFeegroupModifyReason(String value){
     this.set(S_FeegroupModifyReason,value);
  }
  public  void setFeegroupModifyReasonNull(){
     this.set(S_FeegroupModifyReason,null);
  }

  public String getFeegroupModifyReason(){
       return DataType.getAsString(this.get(S_FeegroupModifyReason));
  
  }
  public String getFeegroupModifyReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeegroupModifyReason));
      }

  public void initReamrk7(String value){
     this.initProperty(S_Reamrk7,value);
  }
  public  void setReamrk7(String value){
     this.set(S_Reamrk7,value);
  }
  public  void setReamrk7Null(){
     this.set(S_Reamrk7,null);
  }

  public String getReamrk7(){
       return DataType.getAsString(this.get(S_Reamrk7));
  
  }
  public String getReamrk7InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reamrk7));
      }

  public void initCfid(int value){
     this.initProperty(S_Cfid,new Integer(value));
  }
  public  void setCfid(int value){
     this.set(S_Cfid,new Integer(value));
  }
  public  void setCfidNull(){
     this.set(S_Cfid,null);
  }

  public int getCfid(){
        return DataType.getAsInt(this.get(S_Cfid));
  
  }
  public int getCfidInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Cfid));
      }

  public void initFeeGroupName(String value){
     this.initProperty(S_FeeGroupName,value);
  }
  public  void setFeeGroupName(String value){
     this.set(S_FeeGroupName,value);
  }
  public  void setFeeGroupNameNull(){
     this.set(S_FeeGroupName,null);
  }

  public String getFeeGroupName(){
       return DataType.getAsString(this.get(S_FeeGroupName));
  
  }
  public String getFeeGroupNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeeGroupName));
      }

  public void initRelaMapCode(String value){
     this.initProperty(S_RelaMapCode,value);
  }
  public  void setRelaMapCode(String value){
     this.set(S_RelaMapCode,value);
  }
  public  void setRelaMapCodeNull(){
     this.set(S_RelaMapCode,null);
  }

  public String getRelaMapCode(){
       return DataType.getAsString(this.get(S_RelaMapCode));
  
  }
  public String getRelaMapCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelaMapCode));
      }

  public void initFlag(String value){
     this.initProperty(S_Flag,value);
  }
  public  void setFlag(String value){
     this.set(S_Flag,value);
  }
  public  void setFlagNull(){
     this.set(S_Flag,null);
  }

  public String getFlag(){
       return DataType.getAsString(this.get(S_Flag));
  
  }
  public String getFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Flag));
      }

  public void initMapModifyReason(String value){
     this.initProperty(S_MapModifyReason,value);
  }
  public  void setMapModifyReason(String value){
     this.set(S_MapModifyReason,value);
  }
  public  void setMapModifyReasonNull(){
     this.set(S_MapModifyReason,null);
  }

  public String getMapModifyReason(){
       return DataType.getAsString(this.get(S_MapModifyReason));
  
  }
  public String getMapModifyReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MapModifyReason));
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

  public void initCourseName(String value){
     this.initProperty(S_CourseName,value);
  }
  public  void setCourseName(String value){
     this.set(S_CourseName,value);
  }
  public  void setCourseNameNull(){
     this.set(S_CourseName,null);
  }

  public String getCourseName(){
       return DataType.getAsString(this.get(S_CourseName));
  
  }
  public String getCourseNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CourseName));
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

  public void initRemark6(String value){
     this.initProperty(S_Remark6,value);
  }
  public  void setRemark6(String value){
     this.set(S_Remark6,value);
  }
  public  void setRemark6Null(){
     this.set(S_Remark6,null);
  }

  public String getRemark6(){
       return DataType.getAsString(this.get(S_Remark6));
  
  }
  public String getRemark6InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark6));
      }

  public void initMapCode(String value){
     this.initProperty(S_MapCode,value);
  }
  public  void setMapCode(String value){
     this.set(S_MapCode,value);
  }
  public  void setMapCodeNull(){
     this.set(S_MapCode,null);
  }

  public String getMapCode(){
       return DataType.getAsString(this.get(S_MapCode));
  
  }
  public String getMapCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MapCode));
      }

  public void initSetNm(String value){
     this.initProperty(S_SetNm,value);
  }
  public  void setSetNm(String value){
     this.set(S_SetNm,value);
  }
  public  void setSetNmNull(){
     this.set(S_SetNm,null);
  }

  public String getSetNm(){
       return DataType.getAsString(this.get(S_SetNm));
  
  }
  public String getSetNmInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SetNm));
      }

  public void initRelaSetCode(String value){
     this.initProperty(S_RelaSetCode,value);
  }
  public  void setRelaSetCode(String value){
     this.set(S_RelaSetCode,value);
  }
  public  void setRelaSetCodeNull(){
     this.set(S_RelaSetCode,null);
  }

  public String getRelaSetCode(){
       return DataType.getAsString(this.get(S_RelaSetCode));
  
  }
  public String getRelaSetCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelaSetCode));
      }

  public void initAccountsName(String value){
     this.initProperty(S_AccountsName,value);
  }
  public  void setAccountsName(String value){
     this.set(S_AccountsName,value);
  }
  public  void setAccountsNameNull(){
     this.set(S_AccountsName,null);
  }

  public String getAccountsName(){
       return DataType.getAsString(this.get(S_AccountsName));
  
  }
  public String getAccountsNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AccountsName));
      }

  public void initRelaMapName(String value){
     this.initProperty(S_RelaMapName,value);
  }
  public  void setRelaMapName(String value){
     this.set(S_RelaMapName,value);
  }
  public  void setRelaMapNameNull(){
     this.set(S_RelaMapName,null);
  }

  public String getRelaMapName(){
       return DataType.getAsString(this.get(S_RelaMapName));
  
  }
  public String getRelaMapNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelaMapName));
      }


 
 }

