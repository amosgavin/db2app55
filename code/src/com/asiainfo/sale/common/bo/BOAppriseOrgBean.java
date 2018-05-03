package com.asiainfo.sale.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOAppriseOrgBean extends DataContainer implements DataContainerInterface,IBOAppriseOrgValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOAppriseOrg";



  public final static  String S_Id = "ID";
  public final static  String S_OrgStr = "ORG_STR";
  public final static  String S_WorkflowId = "WORKFLOW_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOAppriseOrgBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 @Override
public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initOrgStr(String value){
     this.initProperty(S_OrgStr,value);
  }
  public  void setOrgStr(String value){
     this.set(S_OrgStr,value);
  }
  public  void setOrgStrNull(){
     this.set(S_OrgStr,null);
  }

  public String getOrgStr(){
       return DataType.getAsString(this.get(S_OrgStr));
  
  }
  public String getOrgStrInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrgStr));
      }

  public void initWorkflowId(String value){
     this.initProperty(S_WorkflowId,value);
  }
  public  void setWorkflowId(String value){
     this.set(S_WorkflowId,value);
  }
  public  void setWorkflowIdNull(){
     this.set(S_WorkflowId,null);
  }

  public String getWorkflowId(){
       return DataType.getAsString(this.get(S_WorkflowId));
  
  }
  public String getWorkflowIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WorkflowId));
      }


 
 }

