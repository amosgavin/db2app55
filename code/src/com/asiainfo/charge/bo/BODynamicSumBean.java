package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BODynamicSumBean extends DataContainer implements DataContainerInterface,IBODynamicSumValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BODynamicSum";



  public final static  String S_Barpu = "BARPU";
  public final static  String S_AccountCourse = "ACCOUNT_COURSE";
  public final static  String S_Carpu = "CARPU";
  public final static  String S_AddUserCount = "ADD_USER_COUNT";
  public final static  String S_Id = "ID";
  public final static  String S_EarningInfo = "EARNING_INFO";
  public final static  String S_AddUserArpu = "ADD_USER_ARPU";
  public final static  String S_Mid = "MID";
  public final static  String S_InfoTotal = "INFO_TOTAL";
  public final static  String S_Cearning = "CEARNING";
  public final static  String S_Aarpu = "AARPU";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BODynamicSumBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initBarpu(double value){
     this.initProperty(S_Barpu,new Double(value));
  }
  public  void setBarpu(double value){
     this.set(S_Barpu,new Double(value));
  }
  public  void setBarpuNull(){
     this.set(S_Barpu,null);
  }

  public double getBarpu(){
        return DataType.getAsDouble(this.get(S_Barpu));
  
  }
  public double getBarpuInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Barpu));
      }

  public void initAccountCourse(String value){
     this.initProperty(S_AccountCourse,value);
  }
  public  void setAccountCourse(String value){
     this.set(S_AccountCourse,value);
  }
  public  void setAccountCourseNull(){
     this.set(S_AccountCourse,null);
  }

  public String getAccountCourse(){
       return DataType.getAsString(this.get(S_AccountCourse));
  
  }
  public String getAccountCourseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AccountCourse));
      }

  public void initCarpu(double value){
     this.initProperty(S_Carpu,new Double(value));
  }
  public  void setCarpu(double value){
     this.set(S_Carpu,new Double(value));
  }
  public  void setCarpuNull(){
     this.set(S_Carpu,null);
  }

  public double getCarpu(){
        return DataType.getAsDouble(this.get(S_Carpu));
  
  }
  public double getCarpuInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Carpu));
      }

  public void initAddUserCount(long value){
     this.initProperty(S_AddUserCount,new Long(value));
  }
  public  void setAddUserCount(long value){
     this.set(S_AddUserCount,new Long(value));
  }
  public  void setAddUserCountNull(){
     this.set(S_AddUserCount,null);
  }

  public long getAddUserCount(){
        return DataType.getAsLong(this.get(S_AddUserCount));
  
  }
  public long getAddUserCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AddUserCount));
      }

  public void initId(String value){
     this.initProperty(S_Id,value);
  }
  public  void setId(String value){
     this.set(S_Id,value);
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public String getId(){
       return DataType.getAsString(this.get(S_Id));
  
  }
  public String getIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Id));
      }

  public void initEarningInfo(double value){
     this.initProperty(S_EarningInfo,new Double(value));
  }
  public  void setEarningInfo(double value){
     this.set(S_EarningInfo,new Double(value));
  }
  public  void setEarningInfoNull(){
     this.set(S_EarningInfo,null);
  }

  public double getEarningInfo(){
        return DataType.getAsDouble(this.get(S_EarningInfo));
  
  }
  public double getEarningInfoInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_EarningInfo));
      }

  public void initAddUserArpu(double value){
     this.initProperty(S_AddUserArpu,new Double(value));
  }
  public  void setAddUserArpu(double value){
     this.set(S_AddUserArpu,new Double(value));
  }
  public  void setAddUserArpuNull(){
     this.set(S_AddUserArpu,null);
  }

  public double getAddUserArpu(){
        return DataType.getAsDouble(this.get(S_AddUserArpu));
  
  }
  public double getAddUserArpuInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_AddUserArpu));
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

  public void initInfoTotal(double value){
     this.initProperty(S_InfoTotal,new Double(value));
  }
  public  void setInfoTotal(double value){
     this.set(S_InfoTotal,new Double(value));
  }
  public  void setInfoTotalNull(){
     this.set(S_InfoTotal,null);
  }

  public double getInfoTotal(){
        return DataType.getAsDouble(this.get(S_InfoTotal));
  
  }
  public double getInfoTotalInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_InfoTotal));
      }

  public void initCearning(double value){
     this.initProperty(S_Cearning,new Double(value));
  }
  public  void setCearning(double value){
     this.set(S_Cearning,new Double(value));
  }
  public  void setCearningNull(){
     this.set(S_Cearning,null);
  }

  public double getCearning(){
        return DataType.getAsDouble(this.get(S_Cearning));
  
  }
  public double getCearningInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Cearning));
      }

  public void initAarpu(double value){
     this.initProperty(S_Aarpu,new Double(value));
  }
  public  void setAarpu(double value){
     this.set(S_Aarpu,new Double(value));
  }
  public  void setAarpuNull(){
     this.set(S_Aarpu,null);
  }

  public double getAarpu(){
        return DataType.getAsDouble(this.get(S_Aarpu));
  
  }
  public double getAarpuInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Aarpu));
      }


 
 }

