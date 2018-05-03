package com.asiainfo.bi.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.bi.ivalues.*;

public class BOBusiSupportSBean extends DataContainer implements DataContainerInterface,IBOBusiSupportSValue{

  private static String  m_boName = "com.asiainfo.bi.bo.BOBusiSupportS";



  public final static  String S_Salen = "SALEN";
  public final static  String S_Totaly = "TOTALY";
  public final static  String S_Chargen = "CHARGEN";
  public final static  String S_Busin = "BUSIN";
  public final static  String S_Total = "TOTAL";
  public final static  String S_Diffgt30 = "DIFFGT30";
  public final static  String S_Saley = "SALEY";
  public final static  String S_Diffls15 = "DIFFLS15";
  public final static  String S_Weaponn = "WEAPONN";
  public final static  String S_Chargey = "CHARGEY";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_Diff15to30 = "DIFF15TO30";
  public final static  String S_Totaln = "TOTALN";
  public final static  String S_Weapony = "WEAPONY";
  public final static  String S_Busiy = "BUSIY";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOBusiSupportSBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initSalen(long value){
     this.initProperty(S_Salen,new Long(value));
  }
  public  void setSalen(long value){
     this.set(S_Salen,new Long(value));
  }
  public  void setSalenNull(){
     this.set(S_Salen,null);
  }

  public long getSalen(){
        return DataType.getAsLong(this.get(S_Salen));
  
  }
  public long getSalenInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Salen));
      }

  public void initTotaly(long value){
     this.initProperty(S_Totaly,new Long(value));
  }
  public  void setTotaly(long value){
     this.set(S_Totaly,new Long(value));
  }
  public  void setTotalyNull(){
     this.set(S_Totaly,null);
  }

  public long getTotaly(){
        return DataType.getAsLong(this.get(S_Totaly));
  
  }
  public long getTotalyInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Totaly));
      }

  public void initChargen(long value){
     this.initProperty(S_Chargen,new Long(value));
  }
  public  void setChargen(long value){
     this.set(S_Chargen,new Long(value));
  }
  public  void setChargenNull(){
     this.set(S_Chargen,null);
  }

  public long getChargen(){
        return DataType.getAsLong(this.get(S_Chargen));
  
  }
  public long getChargenInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Chargen));
      }

  public void initBusin(long value){
     this.initProperty(S_Busin,new Long(value));
  }
  public  void setBusin(long value){
     this.set(S_Busin,new Long(value));
  }
  public  void setBusinNull(){
     this.set(S_Busin,null);
  }

  public long getBusin(){
        return DataType.getAsLong(this.get(S_Busin));
  
  }
  public long getBusinInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Busin));
      }

  public void initTotal(long value){
     this.initProperty(S_Total,new Long(value));
  }
  public  void setTotal(long value){
     this.set(S_Total,new Long(value));
  }
  public  void setTotalNull(){
     this.set(S_Total,null);
  }

  public long getTotal(){
        return DataType.getAsLong(this.get(S_Total));
  
  }
  public long getTotalInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Total));
      }

  public void initDiffgt30(long value){
     this.initProperty(S_Diffgt30,new Long(value));
  }
  public  void setDiffgt30(long value){
     this.set(S_Diffgt30,new Long(value));
  }
  public  void setDiffgt30Null(){
     this.set(S_Diffgt30,null);
  }

  public long getDiffgt30(){
        return DataType.getAsLong(this.get(S_Diffgt30));
  
  }
  public long getDiffgt30InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Diffgt30));
      }

  public void initSaley(long value){
     this.initProperty(S_Saley,new Long(value));
  }
  public  void setSaley(long value){
     this.set(S_Saley,new Long(value));
  }
  public  void setSaleyNull(){
     this.set(S_Saley,null);
  }

  public long getSaley(){
        return DataType.getAsLong(this.get(S_Saley));
  
  }
  public long getSaleyInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Saley));
      }

  public void initDiffls15(long value){
     this.initProperty(S_Diffls15,new Long(value));
  }
  public  void setDiffls15(long value){
     this.set(S_Diffls15,new Long(value));
  }
  public  void setDiffls15Null(){
     this.set(S_Diffls15,null);
  }

  public long getDiffls15(){
        return DataType.getAsLong(this.get(S_Diffls15));
  
  }
  public long getDiffls15InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Diffls15));
      }

  public void initWeaponn(long value){
     this.initProperty(S_Weaponn,new Long(value));
  }
  public  void setWeaponn(long value){
     this.set(S_Weaponn,new Long(value));
  }
  public  void setWeaponnNull(){
     this.set(S_Weaponn,null);
  }

  public long getWeaponn(){
        return DataType.getAsLong(this.get(S_Weaponn));
  
  }
  public long getWeaponnInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Weaponn));
      }

  public void initChargey(long value){
     this.initProperty(S_Chargey,new Long(value));
  }
  public  void setChargey(long value){
     this.set(S_Chargey,new Long(value));
  }
  public  void setChargeyNull(){
     this.set(S_Chargey,null);
  }

  public long getChargey(){
        return DataType.getAsLong(this.get(S_Chargey));
  
  }
  public long getChargeyInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Chargey));
      }

  public void initStaffName(String value){
     this.initProperty(S_StaffName,value);
  }
  public  void setStaffName(String value){
     this.set(S_StaffName,value);
  }
  public  void setStaffNameNull(){
     this.set(S_StaffName,null);
  }

  public String getStaffName(){
       return DataType.getAsString(this.get(S_StaffName));
  
  }
  public String getStaffNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StaffName));
      }

  public void initDiff15to30(long value){
     this.initProperty(S_Diff15to30,new Long(value));
  }
  public  void setDiff15to30(long value){
     this.set(S_Diff15to30,new Long(value));
  }
  public  void setDiff15to30Null(){
     this.set(S_Diff15to30,null);
  }

  public long getDiff15to30(){
        return DataType.getAsLong(this.get(S_Diff15to30));
  
  }
  public long getDiff15to30InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Diff15to30));
      }

  public void initTotaln(long value){
     this.initProperty(S_Totaln,new Long(value));
  }
  public  void setTotaln(long value){
     this.set(S_Totaln,new Long(value));
  }
  public  void setTotalnNull(){
     this.set(S_Totaln,null);
  }

  public long getTotaln(){
        return DataType.getAsLong(this.get(S_Totaln));
  
  }
  public long getTotalnInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Totaln));
      }

  public void initWeapony(long value){
     this.initProperty(S_Weapony,new Long(value));
  }
  public  void setWeapony(long value){
     this.set(S_Weapony,new Long(value));
  }
  public  void setWeaponyNull(){
     this.set(S_Weapony,null);
  }

  public long getWeapony(){
        return DataType.getAsLong(this.get(S_Weapony));
  
  }
  public long getWeaponyInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Weapony));
      }

  public void initBusiy(long value){
     this.initProperty(S_Busiy,new Long(value));
  }
  public  void setBusiy(long value){
     this.set(S_Busiy,new Long(value));
  }
  public  void setBusiyNull(){
     this.set(S_Busiy,null);
  }

  public long getBusiy(){
        return DataType.getAsLong(this.get(S_Busiy));
  
  }
  public long getBusiyInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Busiy));
      }


 
 }

