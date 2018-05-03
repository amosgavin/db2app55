package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BOListItemBean extends DataContainer implements DataContainerInterface{

  private static String  m_boName = "com.ai.bce.bo.BOListItem";



  public final static  String S_Item4 = "ITEM4";
  public final static  String S_Item2 = "ITEM2";
  public final static  String S_Item3 = "ITEM3";
  public final static  String S_Item1 = "ITEM1";
  public final static  String S_Item6 = "ITEM6";
  public final static  String S_Item5 = "ITEM5";
  public final static  String S_Item8 = "ITEM8";
  public final static  String S_Item7 = "ITEM7";
  public final static  String S_Item9 = "ITEM9";
  public final static  String S_Item10 = "ITEM10";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOListItemBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
 }


  public void initItem4(String value){
     this.initProperty(S_Item4,value);
  }
  public  void setItem4(String value){
     this.set(S_Item4,value);
  }
  public  void setItem4Null(){
     this.set(S_Item4,null);
  }

  public String getItem4(){
       return DataType.getAsString(this.get(S_Item4));
  
  }
  public String getItem4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item4));
      }

  public void initItem2(String value){
     this.initProperty(S_Item2,value);
  }
  public  void setItem2(String value){
     this.set(S_Item2,value);
  }
  public  void setItem2Null(){
     this.set(S_Item2,null);
  }

  public String getItem2(){
       return DataType.getAsString(this.get(S_Item2));
  
  }
  public String getItem2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item2));
      }

  public void initItem3(String value){
     this.initProperty(S_Item3,value);
  }
  public  void setItem3(String value){
     this.set(S_Item3,value);
  }
  public  void setItem3Null(){
     this.set(S_Item3,null);
  }

  public String getItem3(){
       return DataType.getAsString(this.get(S_Item3));
  
  }
  public String getItem3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item3));
      }

  public void initItem1(String value){
     this.initProperty(S_Item1,value);
  }
  public  void setItem1(String value){
     this.set(S_Item1,value);
  }
  public  void setItem1Null(){
     this.set(S_Item1,null);
  }

  public String getItem1(){
       return DataType.getAsString(this.get(S_Item1));
  
  }
  public String getItem1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item1));
      }

  public void initItem6(String value){
     this.initProperty(S_Item6,value);
  }
  public  void setItem6(String value){
     this.set(S_Item6,value);
  }
  public  void setItem6Null(){
     this.set(S_Item6,null);
  }

  public String getItem6(){
       return DataType.getAsString(this.get(S_Item6));
  
  }
  public String getItem6InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item6));
      }

  public void initItem5(String value){
     this.initProperty(S_Item5,value);
  }
  public  void setItem5(String value){
     this.set(S_Item5,value);
  }
  public  void setItem5Null(){
     this.set(S_Item5,null);
  }

  public String getItem5(){
       return DataType.getAsString(this.get(S_Item5));
  
  }
  public String getItem5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item5));
      }

  public void initItem8(String value){
     this.initProperty(S_Item8,value);
  }
  public  void setItem8(String value){
     this.set(S_Item8,value);
  }
  public  void setItem8Null(){
     this.set(S_Item8,null);
  }

  public String getItem8(){
       return DataType.getAsString(this.get(S_Item8));
  
  }
  public String getItem8InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item8));
      }

  public void initItem7(String value){
     this.initProperty(S_Item7,value);
  }
  public  void setItem7(String value){
     this.set(S_Item7,value);
  }
  public  void setItem7Null(){
     this.set(S_Item7,null);
  }

  public String getItem7(){
       return DataType.getAsString(this.get(S_Item7));
  
  }
  public String getItem7InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item7));
      }

  public void initItem9(String value){
     this.initProperty(S_Item9,value);
  }
  public  void setItem9(String value){
     this.set(S_Item9,value);
  }
  public  void setItem9Null(){
     this.set(S_Item9,null);
  }

  public String getItem9(){
       return DataType.getAsString(this.get(S_Item9));
  
  }
  public String getItem9InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item9));
      }

  public void initItem10(String value){
     this.initProperty(S_Item10,value);
  }
  public  void setItem10(String value){
     this.set(S_Item10,value);
  }
  public  void setItem10Null(){
     this.set(S_Item10,null);
  }

  public String getItem10(){
       return DataType.getAsString(this.get(S_Item10));
  
  }
  public String getItem10InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item10));
      }


 
 }

