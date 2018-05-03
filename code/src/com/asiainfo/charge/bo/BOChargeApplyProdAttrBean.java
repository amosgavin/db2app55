package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeApplyProdAttrBean extends DataContainer implements DataContainerInterface,IBOChargeApplyProdAttrValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeApplyProdAttr";



  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_ProdName = "PROD_NAME";
  public final static  String S_ApplyId = "APPLY_ID";
  public final static  String S_UnitPrice = "UNIT_PRICE";
  public final static  String S_ApplyMainId = "APPLY_MAIN_ID";
  public final static  String S_AreaType = "AREA_TYPE";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_TestItemA = "TEST_ITEM_A";
  public final static  String S_TestItemB = "TEST_ITEM_B";
  public final static  String S_GivesAmount = "GIVES_AMOUNT";
  public final static  String S_ProdType = "PROD_TYPE";
  public final static  String S_TestItemC = "TEST_ITEM_C";
  public final static  String S_AreaName = "AREA_NAME";
  public final static  String S_TestPrincipal = "TEST_PRINCIPAL";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_GivesAmountType = "GIVES_AMOUNT_TYPE";
  public final static  String S_Ext7 = "EXT7";
  public final static  String S_Ext8 = "EXT8";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeApplyProdAttrBean() throws AIException{
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

  public void initProdName(String value){
     this.initProperty(S_ProdName,value);
  }
  public  void setProdName(String value){
     this.set(S_ProdName,value);
  }
  public  void setProdNameNull(){
     this.set(S_ProdName,null);
  }

  public String getProdName(){
       return DataType.getAsString(this.get(S_ProdName));
  
  }
  public String getProdNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProdName));
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

  public void initUnitPrice(double value){
     this.initProperty(S_UnitPrice,new Double(value));
  }
  public  void setUnitPrice(double value){
     this.set(S_UnitPrice,new Double(value));
  }
  public  void setUnitPriceNull(){
     this.set(S_UnitPrice,null);
  }

  public double getUnitPrice(){
        return DataType.getAsDouble(this.get(S_UnitPrice));
  
  }
  public double getUnitPriceInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_UnitPrice));
      }

  public void initApplyMainId(String value){
     this.initProperty(S_ApplyMainId,value);
  }
  public  void setApplyMainId(String value){
     this.set(S_ApplyMainId,value);
  }
  public  void setApplyMainIdNull(){
     this.set(S_ApplyMainId,null);
  }

  public String getApplyMainId(){
       return DataType.getAsString(this.get(S_ApplyMainId));
  
  }
  public String getApplyMainIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ApplyMainId));
      }

  public void initAreaType(String value){
     this.initProperty(S_AreaType,value);
  }
  public  void setAreaType(String value){
     this.set(S_AreaType,value);
  }
  public  void setAreaTypeNull(){
     this.set(S_AreaType,null);
  }

  public String getAreaType(){
       return DataType.getAsString(this.get(S_AreaType));
  
  }
  public String getAreaTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AreaType));
      }

  public void initPrincipal(String value){
     this.initProperty(S_Principal,value);
  }
  public  void setPrincipal(String value){
     this.set(S_Principal,value);
  }
  public  void setPrincipalNull(){
     this.set(S_Principal,null);
  }

  public String getPrincipal(){
       return DataType.getAsString(this.get(S_Principal));
  
  }
  public String getPrincipalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Principal));
      }

  public void initTestItemA(String value){
     this.initProperty(S_TestItemA,value);
  }
  public  void setTestItemA(String value){
     this.set(S_TestItemA,value);
  }
  public  void setTestItemANull(){
     this.set(S_TestItemA,null);
  }

  public String getTestItemA(){
       return DataType.getAsString(this.get(S_TestItemA));
  
  }
  public String getTestItemAInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TestItemA));
      }

  public void initTestItemB(String value){
     this.initProperty(S_TestItemB,value);
  }
  public  void setTestItemB(String value){
     this.set(S_TestItemB,value);
  }
  public  void setTestItemBNull(){
     this.set(S_TestItemB,null);
  }

  public String getTestItemB(){
       return DataType.getAsString(this.get(S_TestItemB));
  
  }
  public String getTestItemBInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TestItemB));
      }

  public void initGivesAmount(String value){
     this.initProperty(S_GivesAmount,value);
  }
  public  void setGivesAmount(String value){
     this.set(S_GivesAmount,value);
  }
  public  void setGivesAmountNull(){
     this.set(S_GivesAmount,null);
  }

  public String getGivesAmount(){
       return DataType.getAsString(this.get(S_GivesAmount));
  
  }
  public String getGivesAmountInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GivesAmount));
      }

  public void initProdType(String value){
     this.initProperty(S_ProdType,value);
  }
  public  void setProdType(String value){
     this.set(S_ProdType,value);
  }
  public  void setProdTypeNull(){
     this.set(S_ProdType,null);
  }

  public String getProdType(){
       return DataType.getAsString(this.get(S_ProdType));
  
  }
  public String getProdTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProdType));
      }

  public void initTestItemC(String value){
     this.initProperty(S_TestItemC,value);
  }
  public  void setTestItemC(String value){
     this.set(S_TestItemC,value);
  }
  public  void setTestItemCNull(){
     this.set(S_TestItemC,null);
  }

  public String getTestItemC(){
       return DataType.getAsString(this.get(S_TestItemC));
  
  }
  public String getTestItemCInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TestItemC));
      }

  public void initAreaName(String value){
     this.initProperty(S_AreaName,value);
  }
  public  void setAreaName(String value){
     this.set(S_AreaName,value);
  }
  public  void setAreaNameNull(){
     this.set(S_AreaName,null);
  }

  public String getAreaName(){
       return DataType.getAsString(this.get(S_AreaName));
  
  }
  public String getAreaNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AreaName));
      }

  public void initTestPrincipal(String value){
     this.initProperty(S_TestPrincipal,value);
  }
  public  void setTestPrincipal(String value){
     this.set(S_TestPrincipal,value);
  }
  public  void setTestPrincipalNull(){
     this.set(S_TestPrincipal,null);
  }

  public String getTestPrincipal(){
       return DataType.getAsString(this.get(S_TestPrincipal));
  
  }
  public String getTestPrincipalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TestPrincipal));
      }

  public void initExt5(int value){
     this.initProperty(S_Ext5,new Integer(value));
  }
  public  void setExt5(int value){
     this.set(S_Ext5,new Integer(value));
  }
  public  void setExt5Null(){
     this.set(S_Ext5,null);
  }

  public int getExt5(){
        return DataType.getAsInt(this.get(S_Ext5));
  
  }
  public int getExt5InitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Ext5));
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

  public void initGivesAmountType(String value){
     this.initProperty(S_GivesAmountType,value);
  }
  public  void setGivesAmountType(String value){
     this.set(S_GivesAmountType,value);
  }
  public  void setGivesAmountTypeNull(){
     this.set(S_GivesAmountType,null);
  }

  public String getGivesAmountType(){
       return DataType.getAsString(this.get(S_GivesAmountType));
  
  }
  public String getGivesAmountTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GivesAmountType));
      }

  public void initExt7(double value){
     this.initProperty(S_Ext7,new Double(value));
  }
  public  void setExt7(double value){
     this.set(S_Ext7,new Double(value));
  }
  public  void setExt7Null(){
     this.set(S_Ext7,null);
  }

  public double getExt7(){
        return DataType.getAsDouble(this.get(S_Ext7));
  
  }
  public double getExt7InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Ext7));
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

