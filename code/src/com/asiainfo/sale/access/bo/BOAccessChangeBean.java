package com.asiainfo.sale.access.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.access.ivalues.*;

public class BOAccessChangeBean extends DataContainer implements DataContainerInterface,IBOAccessChangeValue{

  private static String  m_boName = "com.asiainfo.sale.access.bo.BOAccessChange";



  public final static  String S_Remark = "REMARK";
  public final static  String S_AccesDetail = "ACCES_DETAIL";
  public final static  String S_Org = "ORG";
  public final static  String S_ETime = "E_TIME";
  public final static  String S_Scale = "SCALE";
  public final static  String S_BTime = "B_TIME";
  public final static  String S_OType = "O_TYPE";
  public final static  String S_OldBand = "OLD_BAND";
  public final static  String S_Dep = "DEP";
  public final static  String S_OObject = "O_OBJECT";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_State = "STATE";
  public final static  String S_NewBand = "NEW_BAND";
  public final static  String S_AccessId = "ACCESS_ID";
  public final static  String S_Tel = "TEL";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_ApplyName = "APPLY_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOAccessChangeBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initRemark(String value){
     this.initProperty(S_Remark,value);
  }
  public  void setRemark(String value){
     this.set(S_Remark,value);
  }
  public  void setRemarkNull(){
     this.set(S_Remark,null);
  }

  public String getRemark(){
       return DataType.getAsString(this.get(S_Remark));
  
  }
  public String getRemarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark));
      }

  public void initAccesDetail(String value){
     this.initProperty(S_AccesDetail,value);
  }
  public  void setAccesDetail(String value){
     this.set(S_AccesDetail,value);
  }
  public  void setAccesDetailNull(){
     this.set(S_AccesDetail,null);
  }

  public String getAccesDetail(){
       return DataType.getAsString(this.get(S_AccesDetail));
  
  }
  public String getAccesDetailInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AccesDetail));
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

  public void initETime(Timestamp value){
     this.initProperty(S_ETime,value);
  }
  public  void setETime(Timestamp value){
     this.set(S_ETime,value);
  }
  public  void setETimeNull(){
     this.set(S_ETime,null);
  }

  public Timestamp getETime(){
        return DataType.getAsDateTime(this.get(S_ETime));
  
  }
  public Timestamp getETimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ETime));
      }

  public void initScale(String value){
     this.initProperty(S_Scale,value);
  }
  public  void setScale(String value){
     this.set(S_Scale,value);
  }
  public  void setScaleNull(){
     this.set(S_Scale,null);
  }

  public String getScale(){
       return DataType.getAsString(this.get(S_Scale));
  
  }
  public String getScaleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Scale));
      }

  public void initBTime(Timestamp value){
     this.initProperty(S_BTime,value);
  }
  public  void setBTime(Timestamp value){
     this.set(S_BTime,value);
  }
  public  void setBTimeNull(){
     this.set(S_BTime,null);
  }

  public Timestamp getBTime(){
        return DataType.getAsDateTime(this.get(S_BTime));
  
  }
  public Timestamp getBTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_BTime));
      }

  public void initOType(String value){
     this.initProperty(S_OType,value);
  }
  public  void setOType(String value){
     this.set(S_OType,value);
  }
  public  void setOTypeNull(){
     this.set(S_OType,null);
  }

  public String getOType(){
       return DataType.getAsString(this.get(S_OType));
  
  }
  public String getOTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OType));
      }

  public void initOldBand(String value){
     this.initProperty(S_OldBand,value);
  }
  public  void setOldBand(String value){
     this.set(S_OldBand,value);
  }
  public  void setOldBandNull(){
     this.set(S_OldBand,null);
  }

  public String getOldBand(){
       return DataType.getAsString(this.get(S_OldBand));
  
  }
  public String getOldBandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OldBand));
      }

  public void initDep(String value){
     this.initProperty(S_Dep,value);
  }
  public  void setDep(String value){
     this.set(S_Dep,value);
  }
  public  void setDepNull(){
     this.set(S_Dep,null);
  }

  public String getDep(){
       return DataType.getAsString(this.get(S_Dep));
  
  }
  public String getDepInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Dep));
      }

  public void initOObject(String value){
     this.initProperty(S_OObject,value);
  }
  public  void setOObject(String value){
     this.set(S_OObject,value);
  }
  public  void setOObjectNull(){
     this.set(S_OObject,null);
  }

  public String getOObject(){
       return DataType.getAsString(this.get(S_OObject));
  
  }
  public String getOObjectInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OObject));
      }

  public void initCreateTime(Timestamp value){
     this.initProperty(S_CreateTime,value);
  }
  public  void setCreateTime(Timestamp value){
     this.set(S_CreateTime,value);
  }
  public  void setCreateTimeNull(){
     this.set(S_CreateTime,null);
  }

  public Timestamp getCreateTime(){
        return DataType.getAsDateTime(this.get(S_CreateTime));
  
  }
  public Timestamp getCreateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
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

  public void initNewBand(String value){
     this.initProperty(S_NewBand,value);
  }
  public  void setNewBand(String value){
     this.set(S_NewBand,value);
  }
  public  void setNewBandNull(){
     this.set(S_NewBand,null);
  }

  public String getNewBand(){
       return DataType.getAsString(this.get(S_NewBand));
  
  }
  public String getNewBandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NewBand));
      }

  public void initAccessId(int value){
     this.initProperty(S_AccessId,new Integer(value));
  }
  public  void setAccessId(int value){
     this.set(S_AccessId,new Integer(value));
  }
  public  void setAccessIdNull(){
     this.set(S_AccessId,null);
  }

  public int getAccessId(){
        return DataType.getAsInt(this.get(S_AccessId));
  
  }
  public int getAccessIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_AccessId));
      }

  public void initTel(String value){
     this.initProperty(S_Tel,value);
  }
  public  void setTel(String value){
     this.set(S_Tel,value);
  }
  public  void setTelNull(){
     this.set(S_Tel,null);
  }

  public String getTel(){
       return DataType.getAsString(this.get(S_Tel));
  
  }
  public String getTelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Tel));
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


 
 }

