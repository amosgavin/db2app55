package com.ai.bce.plugin.autoTable.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.plugin.autoTable.ivalues.*;

public class BceTagPAutotableAttrBean extends DataContainer implements DataContainerInterface,IBceTagPAutotableAttrValue{

  private static String  m_boName = "com.ai.bce.plugin.autoTable.bo.BceTagPAutotableAttr";



  public final static  String S_State = "STATE";
  public final static  String S_DispalyColumn = "DISPALY_COLUMN";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_DisplayType = "DISPLAY_TYPE";
  public final static  String S_Rowspan = "ROWSPAN";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Style = "STYLE";
  public final static  String S_Rowes = "ROWES";
  public final static  String S_Col = "COL";
  public final static  String S_AutotableId = "AUTOTABLE_ID";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_Align = "ALIGN";
  public final static  String S_Name = "NAME";
  public final static  String S_RelConfigId = "REL_CONFIG_ID";
  public final static  String S_Width = "WIDTH";
  public final static  String S_Colspan = "COLSPAN";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceTagPAutotableAttrBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
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

  public void initDispalyColumn(String value){
     this.initProperty(S_DispalyColumn,value);
  }
  public  void setDispalyColumn(String value){
     this.set(S_DispalyColumn,value);
  }
  public  void setDispalyColumnNull(){
     this.set(S_DispalyColumn,null);
  }

  public String getDispalyColumn(){
       return DataType.getAsString(this.get(S_DispalyColumn));
  
  }
  public String getDispalyColumnInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DispalyColumn));
      }

  public void initAttrId(long value){
     this.initProperty(S_AttrId,new Long(value));
  }
  public  void setAttrId(long value){
     this.set(S_AttrId,new Long(value));
  }
  public  void setAttrIdNull(){
     this.set(S_AttrId,null);
  }

  public long getAttrId(){
        return DataType.getAsLong(this.get(S_AttrId));
  
  }
  public long getAttrIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AttrId));
      }

  public void initDisplayType(int value){
     this.initProperty(S_DisplayType,new Integer(value));
  }
  public  void setDisplayType(int value){
     this.set(S_DisplayType,new Integer(value));
  }
  public  void setDisplayTypeNull(){
     this.set(S_DisplayType,null);
  }

  public int getDisplayType(){
        return DataType.getAsInt(this.get(S_DisplayType));
  
  }
  public int getDisplayTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_DisplayType));
      }

  public void initRowspan(int value){
     this.initProperty(S_Rowspan,new Integer(value));
  }
  public  void setRowspan(int value){
     this.set(S_Rowspan,new Integer(value));
  }
  public  void setRowspanNull(){
     this.set(S_Rowspan,null);
  }

  public int getRowspan(){
        return DataType.getAsInt(this.get(S_Rowspan));
  
  }
  public int getRowspanInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Rowspan));
      }

  public void initRemarks(String value){
     this.initProperty(S_Remarks,value);
  }
  public  void setRemarks(String value){
     this.set(S_Remarks,value);
  }
  public  void setRemarksNull(){
     this.set(S_Remarks,null);
  }

  public String getRemarks(){
       return DataType.getAsString(this.get(S_Remarks));
  
  }
  public String getRemarksInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remarks));
      }

  public void initStyle(String value){
     this.initProperty(S_Style,value);
  }
  public  void setStyle(String value){
     this.set(S_Style,value);
  }
  public  void setStyleNull(){
     this.set(S_Style,null);
  }

  public String getStyle(){
       return DataType.getAsString(this.get(S_Style));
  
  }
  public String getStyleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Style));
      }

  public void initRowes(int value){
     this.initProperty(S_Rowes,new Integer(value));
  }
  public  void setRowes(int value){
     this.set(S_Rowes,new Integer(value));
  }
  public  void setRowesNull(){
     this.set(S_Rowes,null);
  }

  public int getRowes(){
        return DataType.getAsInt(this.get(S_Rowes));
  
  }
  public int getRowesInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Rowes));
      }

  public void initCol(int value){
     this.initProperty(S_Col,new Integer(value));
  }
  public  void setCol(int value){
     this.set(S_Col,new Integer(value));
  }
  public  void setColNull(){
     this.set(S_Col,null);
  }

  public int getCol(){
        return DataType.getAsInt(this.get(S_Col));
  
  }
  public int getColInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Col));
      }

  public void initAutotableId(long value){
     this.initProperty(S_AutotableId,new Long(value));
  }
  public  void setAutotableId(long value){
     this.set(S_AutotableId,new Long(value));
  }
  public  void setAutotableIdNull(){
     this.set(S_AutotableId,null);
  }

  public long getAutotableId(){
        return DataType.getAsLong(this.get(S_AutotableId));
  
  }
  public long getAutotableIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AutotableId));
      }

  public void initHeight(String value){
     this.initProperty(S_Height,value);
  }
  public  void setHeight(String value){
     this.set(S_Height,value);
  }
  public  void setHeightNull(){
     this.set(S_Height,null);
  }

  public String getHeight(){
       return DataType.getAsString(this.get(S_Height));
  
  }
  public String getHeightInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Height));
      }

  public void initAlign(String value){
     this.initProperty(S_Align,value);
  }
  public  void setAlign(String value){
     this.set(S_Align,value);
  }
  public  void setAlignNull(){
     this.set(S_Align,null);
  }

  public String getAlign(){
       return DataType.getAsString(this.get(S_Align));
  
  }
  public String getAlignInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Align));
      }

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
      }

  public void initRelConfigId(long value){
     this.initProperty(S_RelConfigId,new Long(value));
  }
  public  void setRelConfigId(long value){
     this.set(S_RelConfigId,new Long(value));
  }
  public  void setRelConfigIdNull(){
     this.set(S_RelConfigId,null);
  }

  public long getRelConfigId(){
        return DataType.getAsLong(this.get(S_RelConfigId));
  
  }
  public long getRelConfigIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RelConfigId));
      }

  public void initWidth(String value){
     this.initProperty(S_Width,value);
  }
  public  void setWidth(String value){
     this.set(S_Width,value);
  }
  public  void setWidthNull(){
     this.set(S_Width,null);
  }

  public String getWidth(){
       return DataType.getAsString(this.get(S_Width));
  
  }
  public String getWidthInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Width));
      }

  public void initColspan(int value){
     this.initProperty(S_Colspan,new Integer(value));
  }
  public  void setColspan(int value){
     this.set(S_Colspan,new Integer(value));
  }
  public  void setColspanNull(){
     this.set(S_Colspan,null);
  }

  public int getColspan(){
        return DataType.getAsInt(this.get(S_Colspan));
  
  }
  public int getColspanInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Colspan));
      }


 
 }

