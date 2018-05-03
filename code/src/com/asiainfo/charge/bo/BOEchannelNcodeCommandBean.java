package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOEchannelNcodeCommandBean extends DataContainer implements DataContainerInterface,IBOEchannelNcodeCommandValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOEchannelNcodeCommand";



  public final static  String S_ProdPackage = "PROD_PACKAGE";
  public final static  String S_OpenCommand = "OPEN_COMMAND";
  public final static  String S_BaseProduct = "BASE_PRODUCT";
  public final static  String S_PriTariff = "PRI_TARIFF";
  public final static  String S_ProdPackage2 = "PROD_PACKAGE2";
  public final static  String S_CancelCommand = "CANCEL_COMMAND";
  public final static  String S_InfoType = "INFO_TYPE";
  public final static  String S_Name = "NAME";
  public final static  String S_Ncode = "NCODE";
  public final static  String S_BusiRule = "BUSI_RULE";
  public final static  String S_GProduct = "G_PRODUCT";
  public final static  String S_AddAttr = "ADD_ATTR";
  public final static  String S_Id = "ID";
  public final static  String S_RelId = "REL_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOEchannelNcodeCommandBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initProdPackage(String value){
     this.initProperty(S_ProdPackage,value);
  }
  public  void setProdPackage(String value){
     this.set(S_ProdPackage,value);
  }
  public  void setProdPackageNull(){
     this.set(S_ProdPackage,null);
  }

  public String getProdPackage(){
       return DataType.getAsString(this.get(S_ProdPackage));
  
  }
  public String getProdPackageInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProdPackage));
      }

  public void initOpenCommand(String value){
     this.initProperty(S_OpenCommand,value);
  }
  public  void setOpenCommand(String value){
     this.set(S_OpenCommand,value);
  }
  public  void setOpenCommandNull(){
     this.set(S_OpenCommand,null);
  }

  public String getOpenCommand(){
       return DataType.getAsString(this.get(S_OpenCommand));
  
  }
  public String getOpenCommandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OpenCommand));
      }

  public void initBaseProduct(String value){
     this.initProperty(S_BaseProduct,value);
  }
  public  void setBaseProduct(String value){
     this.set(S_BaseProduct,value);
  }
  public  void setBaseProductNull(){
     this.set(S_BaseProduct,null);
  }

  public String getBaseProduct(){
       return DataType.getAsString(this.get(S_BaseProduct));
  
  }
  public String getBaseProductInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BaseProduct));
      }

  public void initPriTariff(String value){
     this.initProperty(S_PriTariff,value);
  }
  public  void setPriTariff(String value){
     this.set(S_PriTariff,value);
  }
  public  void setPriTariffNull(){
     this.set(S_PriTariff,null);
  }

  public String getPriTariff(){
       return DataType.getAsString(this.get(S_PriTariff));
  
  }
  public String getPriTariffInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PriTariff));
      }

  public void initProdPackage2(String value){
     this.initProperty(S_ProdPackage2,value);
  }
  public  void setProdPackage2(String value){
     this.set(S_ProdPackage2,value);
  }
  public  void setProdPackage2Null(){
     this.set(S_ProdPackage2,null);
  }

  public String getProdPackage2(){
       return DataType.getAsString(this.get(S_ProdPackage2));
  
  }
  public String getProdPackage2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProdPackage2));
      }

  public void initCancelCommand(String value){
     this.initProperty(S_CancelCommand,value);
  }
  public  void setCancelCommand(String value){
     this.set(S_CancelCommand,value);
  }
  public  void setCancelCommandNull(){
     this.set(S_CancelCommand,null);
  }

  public String getCancelCommand(){
       return DataType.getAsString(this.get(S_CancelCommand));
  
  }
  public String getCancelCommandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CancelCommand));
      }

  public void initInfoType(String value){
     this.initProperty(S_InfoType,value);
  }
  public  void setInfoType(String value){
     this.set(S_InfoType,value);
  }
  public  void setInfoTypeNull(){
     this.set(S_InfoType,null);
  }

  public String getInfoType(){
       return DataType.getAsString(this.get(S_InfoType));
  
  }
  public String getInfoTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InfoType));
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

  public void initNcode(String value){
     this.initProperty(S_Ncode,value);
  }
  public  void setNcode(String value){
     this.set(S_Ncode,value);
  }
  public  void setNcodeNull(){
     this.set(S_Ncode,null);
  }

  public String getNcode(){
       return DataType.getAsString(this.get(S_Ncode));
  
  }
  public String getNcodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ncode));
      }

  public void initBusiRule(String value){
     this.initProperty(S_BusiRule,value);
  }
  public  void setBusiRule(String value){
     this.set(S_BusiRule,value);
  }
  public  void setBusiRuleNull(){
     this.set(S_BusiRule,null);
  }

  public String getBusiRule(){
       return DataType.getAsString(this.get(S_BusiRule));
  
  }
  public String getBusiRuleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusiRule));
      }

  public void initGProduct(String value){
     this.initProperty(S_GProduct,value);
  }
  public  void setGProduct(String value){
     this.set(S_GProduct,value);
  }
  public  void setGProductNull(){
     this.set(S_GProduct,null);
  }

  public String getGProduct(){
       return DataType.getAsString(this.get(S_GProduct));
  
  }
  public String getGProductInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GProduct));
      }

  public void initAddAttr(String value){
     this.initProperty(S_AddAttr,value);
  }
  public  void setAddAttr(String value){
     this.set(S_AddAttr,value);
  }
  public  void setAddAttrNull(){
     this.set(S_AddAttr,null);
  }

  public String getAddAttr(){
       return DataType.getAsString(this.get(S_AddAttr));
  
  }
  public String getAddAttrInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AddAttr));
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

  public void initRelId(long value){
     this.initProperty(S_RelId,new Long(value));
  }
  public  void setRelId(long value){
     this.set(S_RelId,new Long(value));
  }
  public  void setRelIdNull(){
     this.set(S_RelId,null);
  }

  public long getRelId(){
        return DataType.getAsLong(this.get(S_RelId));
  
  }
  public long getRelIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RelId));
      }


 
 }

