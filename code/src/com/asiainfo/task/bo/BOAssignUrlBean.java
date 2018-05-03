package com.asiainfo.task.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.task.ivalues.*;

public class BOAssignUrlBean extends DataContainer implements DataContainerInterface,IBOAssignUrlValue{

  private static String  m_boName = "com.asiainfo.task.bo.BOAssignUrl";



  public final static  String S_NodeTag = "NODE_TAG";
  public final static  String S_Id = "ID";
  public final static  String S_NodeName = "NODE_NAME";
  public final static  String S_FlowName = "FLOW_NAME";
  public final static  String S_Url = "URL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOAssignUrlBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initNodeTag(String value){
     this.initProperty(S_NodeTag,value);
  }
  public  void setNodeTag(String value){
     this.set(S_NodeTag,value);
  }
  public  void setNodeTagNull(){
     this.set(S_NodeTag,null);
  }

  public String getNodeTag(){
       return DataType.getAsString(this.get(S_NodeTag));
  
  }
  public String getNodeTagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NodeTag));
      }

  public void initId(int value){
     this.initProperty(S_Id,new Integer(value));
  }
  public  void setId(int value){
     this.set(S_Id,new Integer(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public int getId(){
        return DataType.getAsInt(this.get(S_Id));
  
  }
  public int getIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Id));
      }

  public void initNodeName(String value){
     this.initProperty(S_NodeName,value);
  }
  public  void setNodeName(String value){
     this.set(S_NodeName,value);
  }
  public  void setNodeNameNull(){
     this.set(S_NodeName,null);
  }

  public String getNodeName(){
       return DataType.getAsString(this.get(S_NodeName));
  
  }
  public String getNodeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NodeName));
      }

  public void initFlowName(String value){
     this.initProperty(S_FlowName,value);
  }
  public  void setFlowName(String value){
     this.set(S_FlowName,value);
  }
  public  void setFlowNameNull(){
     this.set(S_FlowName,null);
  }

  public String getFlowName(){
       return DataType.getAsString(this.get(S_FlowName));
  
  }
  public String getFlowNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FlowName));
      }

  public void initUrl(String value){
     this.initProperty(S_Url,value);
  }
  public  void setUrl(String value){
     this.set(S_Url,value);
  }
  public  void setUrlNull(){
     this.set(S_Url,null);
  }

  public String getUrl(){
       return DataType.getAsString(this.get(S_Url));
  
  }
  public String getUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Url));
      }


 
 }

