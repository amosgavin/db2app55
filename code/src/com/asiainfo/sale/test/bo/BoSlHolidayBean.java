package com.asiainfo.sale.test.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.test.ivalues.*;

public class BoSlHolidayBean extends DataContainer implements DataContainerInterface,IBoSlHolidayValue{

  private static String  m_boName = "com.asiainfo.sale.test.bo.BoSlHoliday";



  public final static  String S_HolidayId = "HOLIDAY_ID";
  public final static  String S_State = "STATE";
  public final static  String S_HolidayDate = "HOLIDAY_DATE";
  public final static  String S_HolidayName = "HOLIDAY_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BoSlHolidayBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initHolidayId(int value){
     this.initProperty(S_HolidayId,new Integer(value));
  }
  public  void setHolidayId(int value){
     this.set(S_HolidayId,new Integer(value));
  }
  public  void setHolidayIdNull(){
     this.set(S_HolidayId,null);
  }

  public int getHolidayId(){
        return DataType.getAsInt(this.get(S_HolidayId));
  
  }
  public int getHolidayIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_HolidayId));
      }

  public void initState(int value){
     this.initProperty(S_State,new Integer(value));
  }
  public  void setState(int value){
     this.set(S_State,new Integer(value));
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public int getState(){
        return DataType.getAsInt(this.get(S_State));
  
  }
  public int getStateInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_State));
      }

  public void initHolidayDate(Timestamp value){
     this.initProperty(S_HolidayDate,value);
  }
  public  void setHolidayDate(Timestamp value){
     this.set(S_HolidayDate,value);
  }
  public  void setHolidayDateNull(){
     this.set(S_HolidayDate,null);
  }

  public Timestamp getHolidayDate(){
        return DataType.getAsDateTime(this.get(S_HolidayDate));
  
  }
  public Timestamp getHolidayDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_HolidayDate));
      }

  public void initHolidayName(String value){
     this.initProperty(S_HolidayName,value);
  }
  public  void setHolidayName(String value){
     this.set(S_HolidayName,value);
  }
  public  void setHolidayNameNull(){
     this.set(S_HolidayName,null);
  }

  public String getHolidayName(){
       return DataType.getAsString(this.get(S_HolidayName));
  
  }
  public String getHolidayNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_HolidayName));
      }


 
 }

