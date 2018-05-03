package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceBatInputFormatBean extends DataContainer implements DataContainerInterface,IBceBatInputFormatValue{

  private static String  m_boName = "com.ai.bce.bo.BceBatInputFormat";



  public final static  String S_MaxNo = "MAX_NO";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_SplitChar = "SPLIT_CHAR";
  public final static  String S_InputType = "INPUT_TYPE";
  public final static  String S_RoleId = "ROLE_ID";
  public final static  String S_ParseService = "PARSE_SERVICE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_BusiService = "BUSI_SERVICE";
  public final static  String S_BusinessId = "BUSINESS_ID";
  public final static  String S_StyleImg = "STYLE_IMG";
  public final static  String S_ConfigId = "CONFIG_ID";
  public final static  String S_Extra1 = "EXTRA_1";
  public final static  String S_StyleDesc = "STYLE_DESC";
  public final static  String S_RetChar = "RET_CHAR";
  public final static  String S_ProdSpecId = "PROD_SPEC_ID";
  public final static  String S_Extra2 = "EXTRA_2";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceBatInputFormatBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
 }


  public void initMaxNo(int value){
     this.initProperty(S_MaxNo,new Integer(value));
  }
  public  void setMaxNo(int value){
     this.set(S_MaxNo,new Integer(value));
  }
  public  void setMaxNoNull(){
     this.set(S_MaxNo,null);
  }

  public int getMaxNo(){
        return DataType.getAsInt(this.get(S_MaxNo));
  
  }
  public int getMaxNoInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_MaxNo));
      }

  public void initModuleId(long value){
     this.initProperty(S_ModuleId,new Long(value));
  }
  public  void setModuleId(long value){
     this.set(S_ModuleId,new Long(value));
  }
  public  void setModuleIdNull(){
     this.set(S_ModuleId,null);
  }

  public long getModuleId(){
        return DataType.getAsLong(this.get(S_ModuleId));
  
  }
  public long getModuleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ModuleId));
      }

  public void initState(int value){
     this.initProperty(S_State,new Integer(value));
  }
  public  void setState(int value){
     this.set(S_State,new Integer(value));
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public int getState(){
        return DataType.getAsInt(this.get(S_State));
  
  }
  public int getStateInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_State));
      }

  public void initSplitChar(String value){
     this.initProperty(S_SplitChar,value);
  }
  public  void setSplitChar(String value){
     this.set(S_SplitChar,value);
  }
  public  void setSplitCharNull(){
     this.set(S_SplitChar,null);
  }

  public String getSplitChar(){
       return DataType.getAsString(this.get(S_SplitChar));
  
  }
  public String getSplitCharInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SplitChar));
      }

  public void initInputType(int value){
     this.initProperty(S_InputType,new Integer(value));
  }
  public  void setInputType(int value){
     this.set(S_InputType,new Integer(value));
  }
  public  void setInputTypeNull(){
     this.set(S_InputType,null);
  }

  public int getInputType(){
        return DataType.getAsInt(this.get(S_InputType));
  
  }
  public int getInputTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_InputType));
      }

  public void initRoleId(long value){
     this.initProperty(S_RoleId,new Long(value));
  }
  public  void setRoleId(long value){
     this.set(S_RoleId,new Long(value));
  }
  public  void setRoleIdNull(){
     this.set(S_RoleId,null);
  }

  public long getRoleId(){
        return DataType.getAsLong(this.get(S_RoleId));
  
  }
  public long getRoleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RoleId));
      }

  public void initParseService(String value){
     this.initProperty(S_ParseService,value);
  }
  public  void setParseService(String value){
     this.set(S_ParseService,value);
  }
  public  void setParseServiceNull(){
     this.set(S_ParseService,null);
  }

  public String getParseService(){
       return DataType.getAsString(this.get(S_ParseService));
  
  }
  public String getParseServiceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParseService));
      }

  public void initRemarks(String value){
     this.initProperty(S_Remarks,value);
  }
  public  void setRemarks(String value){
     this.set(S_Remarks,value);
  }
  public  void setRemarksNull(){
     this.set(S_Remarks,null);
  }

  public String getRemarks(){
       return DataType.getAsString(this.get(S_Remarks));
  
  }
  public String getRemarksInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remarks));
      }

  public void initBusiService(String value){
     this.initProperty(S_BusiService,value);
  }
  public  void setBusiService(String value){
     this.set(S_BusiService,value);
  }
  public  void setBusiServiceNull(){
     this.set(S_BusiService,null);
  }

  public String getBusiService(){
       return DataType.getAsString(this.get(S_BusiService));
  
  }
  public String getBusiServiceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusiService));
      }

  public void initBusinessId(long value){
     this.initProperty(S_BusinessId,new Long(value));
  }
  public  void setBusinessId(long value){
     this.set(S_BusinessId,new Long(value));
  }
  public  void setBusinessIdNull(){
     this.set(S_BusinessId,null);
  }

  public long getBusinessId(){
        return DataType.getAsLong(this.get(S_BusinessId));
  
  }
  public long getBusinessIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusinessId));
      }

  public void initStyleImg(String value){
     this.initProperty(S_StyleImg,value);
  }
  public  void setStyleImg(String value){
     this.set(S_StyleImg,value);
  }
  public  void setStyleImgNull(){
     this.set(S_StyleImg,null);
  }

  public String getStyleImg(){
       return DataType.getAsString(this.get(S_StyleImg));
  
  }
  public String getStyleImgInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StyleImg));
      }

  public void initConfigId(long value){
     this.initProperty(S_ConfigId,new Long(value));
  }
  public  void setConfigId(long value){
     this.set(S_ConfigId,new Long(value));
  }
  public  void setConfigIdNull(){
     this.set(S_ConfigId,null);
  }

  public long getConfigId(){
        return DataType.getAsLong(this.get(S_ConfigId));
  
  }
  public long getConfigIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ConfigId));
      }

  public void initExtra1(String value){
     this.initProperty(S_Extra1,value);
  }
  public  void setExtra1(String value){
     this.set(S_Extra1,value);
  }
  public  void setExtra1Null(){
     this.set(S_Extra1,null);
  }

  public String getExtra1(){
       return DataType.getAsString(this.get(S_Extra1));
  
  }
  public String getExtra1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Extra1));
      }

  public void initStyleDesc(String value){
     this.initProperty(S_StyleDesc,value);
  }
  public  void setStyleDesc(String value){
     this.set(S_StyleDesc,value);
  }
  public  void setStyleDescNull(){
     this.set(S_StyleDesc,null);
  }

  public String getStyleDesc(){
       return DataType.getAsString(this.get(S_StyleDesc));
  
  }
  public String getStyleDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StyleDesc));
      }

  public void initRetChar(String value){
     this.initProperty(S_RetChar,value);
  }
  public  void setRetChar(String value){
     this.set(S_RetChar,value);
  }
  public  void setRetCharNull(){
     this.set(S_RetChar,null);
  }

  public String getRetChar(){
       return DataType.getAsString(this.get(S_RetChar));
  
  }
  public String getRetCharInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RetChar));
      }

  public void initProdSpecId(long value){
     this.initProperty(S_ProdSpecId,new Long(value));
  }
  public  void setProdSpecId(long value){
     this.set(S_ProdSpecId,new Long(value));
  }
  public  void setProdSpecIdNull(){
     this.set(S_ProdSpecId,null);
  }

  public long getProdSpecId(){
        return DataType.getAsLong(this.get(S_ProdSpecId));
  
  }
  public long getProdSpecIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ProdSpecId));
      }

  public void initExtra2(String value){
     this.initProperty(S_Extra2,value);
  }
  public  void setExtra2(String value){
     this.set(S_Extra2,value);
  }
  public  void setExtra2Null(){
     this.set(S_Extra2,null);
  }

  public String getExtra2(){
       return DataType.getAsString(this.get(S_Extra2));
  
  }
  public String getExtra2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Extra2));
      }


 
 }

