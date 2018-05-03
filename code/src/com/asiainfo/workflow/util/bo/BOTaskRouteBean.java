package com.asiainfo.workflow.util.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.workflow.util.ivalues.*;

public class BOTaskRouteBean extends DataContainer implements DataContainerInterface,IBOTaskRouteValue{

  private static String  m_boName = "com.asiainfo.workflow.util.bo.BOTaskRoute";



  public final static  String S_Userid = "USERID";
  public final static  String S_Tasktype = "TASKTYPE";
  public final static  String S_Taskid = "TASKID";
  public final static  String S_Lable = "LABLE";
  public final static  String S_Usertype = "USERTYPE";
  public final static  String S_Condition = "CONDITION";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOTaskRouteBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initUserid(String value){
     this.initProperty(S_Userid,value);
  }
  public  void setUserid(String value){
     this.set(S_Userid,value);
  }
  public  void setUseridNull(){
     this.set(S_Userid,null);
  }

  public String getUserid(){
       return DataType.getAsString(this.get(S_Userid));
  
  }
  public String getUseridInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Userid));
      }

  public void initTasktype(String value){
     this.initProperty(S_Tasktype,value);
  }
  public  void setTasktype(String value){
     this.set(S_Tasktype,value);
  }
  public  void setTasktypeNull(){
     this.set(S_Tasktype,null);
  }

  public String getTasktype(){
       return DataType.getAsString(this.get(S_Tasktype));
  
  }
  public String getTasktypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Tasktype));
      }

  public void initTaskid(long value){
     this.initProperty(S_Taskid,new Long(value));
  }
  public  void setTaskid(long value){
     this.set(S_Taskid,new Long(value));
  }
  public  void setTaskidNull(){
     this.set(S_Taskid,null);
  }

  public long getTaskid(){
        return DataType.getAsLong(this.get(S_Taskid));
  
  }
  public long getTaskidInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Taskid));
      }

  public void initLable(String value){
     this.initProperty(S_Lable,value);
  }
  public  void setLable(String value){
     this.set(S_Lable,value);
  }
  public  void setLableNull(){
     this.set(S_Lable,null);
  }

  public String getLable(){
       return DataType.getAsString(this.get(S_Lable));
  
  }
  public String getLableInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Lable));
      }

  public void initUsertype(String value){
     this.initProperty(S_Usertype,value);
  }
  public  void setUsertype(String value){
     this.set(S_Usertype,value);
  }
  public  void setUsertypeNull(){
     this.set(S_Usertype,null);
  }

  public String getUsertype(){
       return DataType.getAsString(this.get(S_Usertype));
  
  }
  public String getUsertypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Usertype));
      }

  public void initCondition(String value){
     this.initProperty(S_Condition,value);
  }
  public  void setCondition(String value){
     this.set(S_Condition,value);
  }
  public  void setConditionNull(){
     this.set(S_Condition,null);
  }

  public String getCondition(){
       return DataType.getAsString(this.get(S_Condition));
  
  }
  public String getConditionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Condition));
      }


 
 }

