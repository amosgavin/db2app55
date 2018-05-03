package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOPrivAttrUsedParamBean extends DataContainer implements DataContainerInterface,IBOPrivAttrUsedParamValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOPrivAttrUsedParam";



  public final static  String S_Iscrosscycle = "ISCROSSCYCLE";
  public final static  String S_AttrName = "ATTR_NAME";
  public final static  String S_SqlText = "SQL_TEXT";
  public final static  String S_PrivRate = "PRIV_RATE";
  public final static  String S_PrivUnit = "PRIV_UNIT";
  public final static  String S_Status = "STATUS";
  public final static  String S_PrivType = "PRIV_TYPE";
  public final static  String S_Rateplanid = "RATEPLANID";
  public final static  String S_AccSql = "ACC_SQL";
  public final static  String S_GetType = "GET_TYPE";
  public final static  String S_Iscalbyday = "ISCALBYDAY";
  public final static  String S_Pkgcode = "PKGCODE";
  public final static  String S_PrivCost = "PRIV_COST";
  public final static  String S_Privname = "PRIVNAME";
  public final static  String S_MinBillcycle = "MIN_BILLCYCLE";
  public final static  String S_Privid = "PRIVID";
  public final static  String S_AttrId = "ATTR_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOPrivAttrUsedParamBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initIscrosscycle(int value){
     this.initProperty(S_Iscrosscycle,new Integer(value));
  }
  public  void setIscrosscycle(int value){
     this.set(S_Iscrosscycle,new Integer(value));
  }
  public  void setIscrosscycleNull(){
     this.set(S_Iscrosscycle,null);
  }

  public int getIscrosscycle(){
        return DataType.getAsInt(this.get(S_Iscrosscycle));
  
  }
  public int getIscrosscycleInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Iscrosscycle));
      }

  public void initAttrName(String value){
     this.initProperty(S_AttrName,value);
  }
  public  void setAttrName(String value){
     this.set(S_AttrName,value);
  }
  public  void setAttrNameNull(){
     this.set(S_AttrName,null);
  }

  public String getAttrName(){
       return DataType.getAsString(this.get(S_AttrName));
  
  }
  public String getAttrNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AttrName));
      }

  public void initSqlText(String value){
     this.initProperty(S_SqlText,value);
  }
  public  void setSqlText(String value){
     this.set(S_SqlText,value);
  }
  public  void setSqlTextNull(){
     this.set(S_SqlText,null);
  }

  public String getSqlText(){
       return DataType.getAsString(this.get(S_SqlText));
  
  }
  public String getSqlTextInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SqlText));
      }

  public void initPrivRate(int value){
     this.initProperty(S_PrivRate,new Integer(value));
  }
  public  void setPrivRate(int value){
     this.set(S_PrivRate,new Integer(value));
  }
  public  void setPrivRateNull(){
     this.set(S_PrivRate,null);
  }

  public int getPrivRate(){
        return DataType.getAsInt(this.get(S_PrivRate));
  
  }
  public int getPrivRateInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PrivRate));
      }

  public void initPrivUnit(String value){
     this.initProperty(S_PrivUnit,value);
  }
  public  void setPrivUnit(String value){
     this.set(S_PrivUnit,value);
  }
  public  void setPrivUnitNull(){
     this.set(S_PrivUnit,null);
  }

  public String getPrivUnit(){
       return DataType.getAsString(this.get(S_PrivUnit));
  
  }
  public String getPrivUnitInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PrivUnit));
      }

  public void initStatus(int value){
     this.initProperty(S_Status,new Integer(value));
  }
  public  void setStatus(int value){
     this.set(S_Status,new Integer(value));
  }
  public  void setStatusNull(){
     this.set(S_Status,null);
  }

  public int getStatus(){
        return DataType.getAsInt(this.get(S_Status));
  
  }
  public int getStatusInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Status));
      }

  public void initPrivType(String value){
     this.initProperty(S_PrivType,value);
  }
  public  void setPrivType(String value){
     this.set(S_PrivType,value);
  }
  public  void setPrivTypeNull(){
     this.set(S_PrivType,null);
  }

  public String getPrivType(){
       return DataType.getAsString(this.get(S_PrivType));
  
  }
  public String getPrivTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PrivType));
      }

  public void initRateplanid(String value){
     this.initProperty(S_Rateplanid,value);
  }
  public  void setRateplanid(String value){
     this.set(S_Rateplanid,value);
  }
  public  void setRateplanidNull(){
     this.set(S_Rateplanid,null);
  }

  public String getRateplanid(){
       return DataType.getAsString(this.get(S_Rateplanid));
  
  }
  public String getRateplanidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Rateplanid));
      }

  public void initAccSql(String value){
     this.initProperty(S_AccSql,value);
  }
  public  void setAccSql(String value){
     this.set(S_AccSql,value);
  }
  public  void setAccSqlNull(){
     this.set(S_AccSql,null);
  }

  public String getAccSql(){
       return DataType.getAsString(this.get(S_AccSql));
  
  }
  public String getAccSqlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AccSql));
      }

  public void initGetType(String value){
     this.initProperty(S_GetType,value);
  }
  public  void setGetType(String value){
     this.set(S_GetType,value);
  }
  public  void setGetTypeNull(){
     this.set(S_GetType,null);
  }

  public String getGetType(){
       return DataType.getAsString(this.get(S_GetType));
  
  }
  public String getGetTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GetType));
      }

  public void initIscalbyday(int value){
     this.initProperty(S_Iscalbyday,new Integer(value));
  }
  public  void setIscalbyday(int value){
     this.set(S_Iscalbyday,new Integer(value));
  }
  public  void setIscalbydayNull(){
     this.set(S_Iscalbyday,null);
  }

  public int getIscalbyday(){
        return DataType.getAsInt(this.get(S_Iscalbyday));
  
  }
  public int getIscalbydayInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Iscalbyday));
      }

  public void initPkgcode(String value){
     this.initProperty(S_Pkgcode,value);
  }
  public  void setPkgcode(String value){
     this.set(S_Pkgcode,value);
  }
  public  void setPkgcodeNull(){
     this.set(S_Pkgcode,null);
  }

  public String getPkgcode(){
       return DataType.getAsString(this.get(S_Pkgcode));
  
  }
  public String getPkgcodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Pkgcode));
      }

  public void initPrivCost(int value){
     this.initProperty(S_PrivCost,new Integer(value));
  }
  public  void setPrivCost(int value){
     this.set(S_PrivCost,new Integer(value));
  }
  public  void setPrivCostNull(){
     this.set(S_PrivCost,null);
  }

  public int getPrivCost(){
        return DataType.getAsInt(this.get(S_PrivCost));
  
  }
  public int getPrivCostInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PrivCost));
      }

  public void initPrivname(String value){
     this.initProperty(S_Privname,value);
  }
  public  void setPrivname(String value){
     this.set(S_Privname,value);
  }
  public  void setPrivnameNull(){
     this.set(S_Privname,null);
  }

  public String getPrivname(){
       return DataType.getAsString(this.get(S_Privname));
  
  }
  public String getPrivnameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Privname));
      }

  public void initMinBillcycle(String value){
     this.initProperty(S_MinBillcycle,value);
  }
  public  void setMinBillcycle(String value){
     this.set(S_MinBillcycle,value);
  }
  public  void setMinBillcycleNull(){
     this.set(S_MinBillcycle,null);
  }

  public String getMinBillcycle(){
       return DataType.getAsString(this.get(S_MinBillcycle));
  
  }
  public String getMinBillcycleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MinBillcycle));
      }

  public void initPrivid(String value){
     this.initProperty(S_Privid,value);
  }
  public  void setPrivid(String value){
     this.set(S_Privid,value);
  }
  public  void setPrividNull(){
     this.set(S_Privid,null);
  }

  public String getPrivid(){
       return DataType.getAsString(this.get(S_Privid));
  
  }
  public String getPrividInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Privid));
      }

  public void initAttrId(String value){
     this.initProperty(S_AttrId,value);
  }
  public  void setAttrId(String value){
     this.set(S_AttrId,value);
  }
  public  void setAttrIdNull(){
     this.set(S_AttrId,null);
  }

  public String getAttrId(){
       return DataType.getAsString(this.get(S_AttrId));
  
  }
  public String getAttrIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AttrId));
      }


 
 }

