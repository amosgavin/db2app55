package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOSaleStaticDataBean extends DataContainer implements DataContainerInterface,IBOSaleStaticDataValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOSaleStaticData";



  public final static  String S_IsUsed = "IS_USED";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_CodeNameNls = "CODE_NAME_NLS";
  public final static  String S_CodeName = "CODE_NAME";
  public final static  String S_CodeType = "CODE_TYPE";
  public final static  String S_CodeId = "CODE_ID";
  public final static  String S_ExternCode = "EXTERN_CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleStaticDataBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initIsUsed(int value){
     this.initProperty(S_IsUsed,new Integer(value));
  }
  public  void setIsUsed(int value){
     this.set(S_IsUsed,new Integer(value));
  }
  public  void setIsUsedNull(){
     this.set(S_IsUsed,null);
  }

  public int getIsUsed(){
        return DataType.getAsInt(this.get(S_IsUsed));
  
  }
  public int getIsUsedInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsUsed));
      }

  public void initSortId(int value){
     this.initProperty(S_SortId,new Integer(value));
  }
  public  void setSortId(int value){
     this.set(S_SortId,new Integer(value));
  }
  public  void setSortIdNull(){
     this.set(S_SortId,null);
  }

  public int getSortId(){
        return DataType.getAsInt(this.get(S_SortId));
  
  }
  public int getSortIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SortId));
      }

  public void initCodeNameNls(String value){
     this.initProperty(S_CodeNameNls,value);
  }
  public  void setCodeNameNls(String value){
     this.set(S_CodeNameNls,value);
  }
  public  void setCodeNameNlsNull(){
     this.set(S_CodeNameNls,null);
  }

  public String getCodeNameNls(){
       return DataType.getAsString(this.get(S_CodeNameNls));
  
  }
  public String getCodeNameNlsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CodeNameNls));
      }

  public void initCodeName(String value){
     this.initProperty(S_CodeName,value);
  }
  public  void setCodeName(String value){
     this.set(S_CodeName,value);
  }
  public  void setCodeNameNull(){
     this.set(S_CodeName,null);
  }

  public String getCodeName(){
       return DataType.getAsString(this.get(S_CodeName));
  
  }
  public String getCodeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CodeName));
      }

  public void initCodeType(String value){
     this.initProperty(S_CodeType,value);
  }
  public  void setCodeType(String value){
     this.set(S_CodeType,value);
  }
  public  void setCodeTypeNull(){
     this.set(S_CodeType,null);
  }

  public String getCodeType(){
       return DataType.getAsString(this.get(S_CodeType));
  
  }
  public String getCodeTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CodeType));
      }

  public void initCodeId(String value){
     this.initProperty(S_CodeId,value);
  }
  public  void setCodeId(String value){
     this.set(S_CodeId,value);
  }
  public  void setCodeIdNull(){
     this.set(S_CodeId,null);
  }

  public String getCodeId(){
       return DataType.getAsString(this.get(S_CodeId));
  
  }
  public String getCodeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CodeId));
      }

  public void initExternCode(String value){
     this.initProperty(S_ExternCode,value);
  }
  public  void setExternCode(String value){
     this.set(S_ExternCode,value);
  }
  public  void setExternCodeNull(){
     this.set(S_ExternCode,null);
  }

  public String getExternCode(){
       return DataType.getAsString(this.get(S_ExternCode));
  
  }
  public String getExternCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExternCode));
      }


 
 }

