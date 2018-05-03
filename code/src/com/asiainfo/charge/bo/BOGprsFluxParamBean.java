package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOGprsFluxParamBean extends DataContainer implements DataContainerInterface,IBOGprsFluxParamValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOGprsFluxParam";



  public final static  String S_Statusdate = "STATUSDATE";
  public final static  String S_Groupid = "GROUPID";
  public final static  String S_Status = "STATUS";
  public final static  String S_Rateplanid = "RATEPLANID";
  public final static  String S_StdFree4 = "STD_FREE4";
  public final static  String S_Gettype = "GETTYPE";
  public final static  String S_Iscalbyday = "ISCALBYDAY";
  public final static  String S_Pkgcode = "PKGCODE";
  public final static  String S_StdFree1 = "STD_FREE1";
  public final static  String S_Halfflag = "HALFFLAG";
  public final static  String S_StdFree3 = "STD_FREE3";
  public final static  String S_StdFree2 = "STD_FREE2";
  public final static  String S_Exesql = "EXESQL";
  public final static  String S_Privname = "PRIVNAME";
  public final static  String S_Privid = "PRIVID";
  public final static  String S_AccExesql = "ACC_EXESQL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOGprsFluxParamBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initStatusdate(Timestamp value){
     this.initProperty(S_Statusdate,value);
  }
  public  void setStatusdate(Timestamp value){
     this.set(S_Statusdate,value);
  }
  public  void setStatusdateNull(){
     this.set(S_Statusdate,null);
  }

  public Timestamp getStatusdate(){
        return DataType.getAsDateTime(this.get(S_Statusdate));
  
  }
  public Timestamp getStatusdateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_Statusdate));
      }

  public void initGroupid(String value){
     this.initProperty(S_Groupid,value);
  }
  public  void setGroupid(String value){
     this.set(S_Groupid,value);
  }
  public  void setGroupidNull(){
     this.set(S_Groupid,null);
  }

  public String getGroupid(){
       return DataType.getAsString(this.get(S_Groupid));
  
  }
  public String getGroupidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Groupid));
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

  public void initStdFree4(int value){
     this.initProperty(S_StdFree4,new Integer(value));
  }
  public  void setStdFree4(int value){
     this.set(S_StdFree4,new Integer(value));
  }
  public  void setStdFree4Null(){
     this.set(S_StdFree4,null);
  }

  public int getStdFree4(){
        return DataType.getAsInt(this.get(S_StdFree4));
  
  }
  public int getStdFree4InitialValue(){
        return DataType.getAsInt(this.getOldObj(S_StdFree4));
      }

  public void initGettype(int value){
     this.initProperty(S_Gettype,new Integer(value));
  }
  public  void setGettype(int value){
     this.set(S_Gettype,new Integer(value));
  }
  public  void setGettypeNull(){
     this.set(S_Gettype,null);
  }

  public int getGettype(){
        return DataType.getAsInt(this.get(S_Gettype));
  
  }
  public int getGettypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Gettype));
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

  public void initStdFree1(int value){
     this.initProperty(S_StdFree1,new Integer(value));
  }
  public  void setStdFree1(int value){
     this.set(S_StdFree1,new Integer(value));
  }
  public  void setStdFree1Null(){
     this.set(S_StdFree1,null);
  }

  public int getStdFree1(){
        return DataType.getAsInt(this.get(S_StdFree1));
  
  }
  public int getStdFree1InitialValue(){
        return DataType.getAsInt(this.getOldObj(S_StdFree1));
      }

  public void initHalfflag(int value){
     this.initProperty(S_Halfflag,new Integer(value));
  }
  public  void setHalfflag(int value){
     this.set(S_Halfflag,new Integer(value));
  }
  public  void setHalfflagNull(){
     this.set(S_Halfflag,null);
  }

  public int getHalfflag(){
        return DataType.getAsInt(this.get(S_Halfflag));
  
  }
  public int getHalfflagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Halfflag));
      }

  public void initStdFree3(int value){
     this.initProperty(S_StdFree3,new Integer(value));
  }
  public  void setStdFree3(int value){
     this.set(S_StdFree3,new Integer(value));
  }
  public  void setStdFree3Null(){
     this.set(S_StdFree3,null);
  }

  public int getStdFree3(){
        return DataType.getAsInt(this.get(S_StdFree3));
  
  }
  public int getStdFree3InitialValue(){
        return DataType.getAsInt(this.getOldObj(S_StdFree3));
      }

  public void initStdFree2(int value){
     this.initProperty(S_StdFree2,new Integer(value));
  }
  public  void setStdFree2(int value){
     this.set(S_StdFree2,new Integer(value));
  }
  public  void setStdFree2Null(){
     this.set(S_StdFree2,null);
  }

  public int getStdFree2(){
        return DataType.getAsInt(this.get(S_StdFree2));
  
  }
  public int getStdFree2InitialValue(){
        return DataType.getAsInt(this.getOldObj(S_StdFree2));
      }

  public void initExesql(String value){
     this.initProperty(S_Exesql,value);
  }
  public  void setExesql(String value){
     this.set(S_Exesql,value);
  }
  public  void setExesqlNull(){
     this.set(S_Exesql,null);
  }

  public String getExesql(){
       return DataType.getAsString(this.get(S_Exesql));
  
  }
  public String getExesqlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Exesql));
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

  public void initAccExesql(String value){
     this.initProperty(S_AccExesql,value);
  }
  public  void setAccExesql(String value){
     this.set(S_AccExesql,value);
  }
  public  void setAccExesqlNull(){
     this.set(S_AccExesql,null);
  }

  public String getAccExesql(){
       return DataType.getAsString(this.get(S_AccExesql));
  
  }
  public String getAccExesqlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AccExesql));
      }


 
 }

