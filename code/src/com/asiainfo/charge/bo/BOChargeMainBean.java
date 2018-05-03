package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeMainBean extends DataContainer implements DataContainerInterface,IBOChargeMainValue{

  @Override
	public void unDelete() {
		// TODO Auto-generated method stub
		super.unDelete();
	}
private static String  m_boName = "com.asiainfo.charge.bo.BOChargeMain";



  public final static  String S_Reamrk1 = "REAMRK_1";
  public final static  String S_Reamrk2 = "REAMRK_2";
  public final static  String S_State = "STATE";
  public final static  String S_Reamrk5 = "REAMRK_5";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Reamrk3 = "REAMRK_3";
  public final static  String S_Reamrk4 = "REAMRK_4";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_Org = "ORG";
  public final static  String S_MainId = "MAIN_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeMainBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initReamrk1(String value){
     this.initProperty(S_Reamrk1,value);
  }
  public  void setReamrk1(String value){
     this.set(S_Reamrk1,value);
  }
  public  void setReamrk1Null(){
     this.set(S_Reamrk1,null);
  }

  public String getReamrk1(){
       return DataType.getAsString(this.get(S_Reamrk1));
  
  }
  public String getReamrk1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reamrk1));
      }

  public void initReamrk2(String value){
     this.initProperty(S_Reamrk2,value);
  }
  public  void setReamrk2(String value){
     this.set(S_Reamrk2,value);
  }
  public  void setReamrk2Null(){
     this.set(S_Reamrk2,null);
  }

  public String getReamrk2(){
       return DataType.getAsString(this.get(S_Reamrk2));
  
  }
  public String getReamrk2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reamrk2));
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

  public void initReamrk5(String value){
     this.initProperty(S_Reamrk5,value);
  }
  public  void setReamrk5(String value){
     this.set(S_Reamrk5,value);
  }
  public  void setReamrk5Null(){
     this.set(S_Reamrk5,null);
  }

  public String getReamrk5(){
       return DataType.getAsString(this.get(S_Reamrk5));
  
  }
  public String getReamrk5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reamrk5));
      }

  public void initModifyTime(Timestamp value){
     this.initProperty(S_ModifyTime,value);
  }
  public  void setModifyTime(Timestamp value){
     this.set(S_ModifyTime,value);
  }
  public  void setModifyTimeNull(){
     this.set(S_ModifyTime,null);
  }

  public Timestamp getModifyTime(){
        return DataType.getAsDateTime(this.get(S_ModifyTime));
  
  }
  public Timestamp getModifyTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyTime));
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

  public void initReamrk3(String value){
     this.initProperty(S_Reamrk3,value);
  }
  public  void setReamrk3(String value){
     this.set(S_Reamrk3,value);
  }
  public  void setReamrk3Null(){
     this.set(S_Reamrk3,null);
  }

  public String getReamrk3(){
       return DataType.getAsString(this.get(S_Reamrk3));
  
  }
  public String getReamrk3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reamrk3));
      }

  public void initReamrk4(String value){
     this.initProperty(S_Reamrk4,value);
  }
  public  void setReamrk4(String value){
     this.set(S_Reamrk4,value);
  }
  public  void setReamrk4Null(){
     this.set(S_Reamrk4,null);
  }

  public String getReamrk4(){
       return DataType.getAsString(this.get(S_Reamrk4));
  
  }
  public String getReamrk4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reamrk4));
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


 
 }

