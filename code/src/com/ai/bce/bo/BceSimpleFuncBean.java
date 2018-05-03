package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceSimpleFuncBean extends DataContainer implements DataContainerInterface,IBceSimpleFuncValue{

  private static String  m_boName = "com.ai.bce.bo.BceSimpleFunc";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_DealService = "DEAL_SERVICE";
  public final static  String S_OrdBo = "ORD_BO";
  public final static  String S_FuncId = "FUNC_ID";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_OrdDatasource = "ORD_DATASOURCE";
  public final static  String S_DealWorkflow = "DEAL_WORKFLOW";
  public final static  String S_RowsetName = "ROWSET_NAME";
  public final static  String S_InsBo = "INS_BO";
  public final static  String S_InsDatasource = "INS_DATASOURCE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceSimpleFuncBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("Cannot reset ObjectType");
 }


  public void initModuleId(long value){
     this.initProperty(S_ModuleId,new Long(value));
  }
  public  void setModuleId(long value){
     this.set(S_ModuleId,new Long(value));
  }

  public  void setModuleId(Long value){
     this.set(S_ModuleId,value);
  }
  
  public  Long  getModuleIdAsLong(){
     return (Long )this.get(S_ModuleId);
  }
  
  
  public  void setModuleIdNull(){
     this.set(S_ModuleId,null);
  }

  public long getModuleId(){
        return DataType.getAsLong(this.get(S_ModuleId));
  
  }
  public long getModuleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ModuleId));
      }

  public void initState(int value){
     this.initProperty(S_State,new Integer(value));
  }
  public  void setState(int value){
     this.set(S_State,new Integer(value));
  }

  public  void setState(Integer value){
     this.set(S_State,value);
  }
  
  public  Integer  getStateAsInteger(){
     return (Integer )this.get(S_State);
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

  public void initDealService(String value){
     this.initProperty(S_DealService,value);
  }
  public  void setDealService(String value){
     this.set(S_DealService,value);
  }

  
  
  public  void setDealServiceNull(){
     this.set(S_DealService,null);
  }

  public String getDealService(){
       return DataType.getAsString(this.get(S_DealService));
  
  }
  public String getDealServiceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DealService));
      }

  public void initOrdBo(String value){
     this.initProperty(S_OrdBo,value);
  }
  public  void setOrdBo(String value){
     this.set(S_OrdBo,value);
  }

  
  
  public  void setOrdBoNull(){
     this.set(S_OrdBo,null);
  }

  public String getOrdBo(){
       return DataType.getAsString(this.get(S_OrdBo));
  
  }
  public String getOrdBoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrdBo));
      }

  public void initFuncId(long value){
     this.initProperty(S_FuncId,new Long(value));
  }
  public  void setFuncId(long value){
     this.set(S_FuncId,new Long(value));
  }

  public  void setFuncId(Long value){
     this.set(S_FuncId,value);
  }
  
  public  Long  getFuncIdAsLong(){
     return (Long )this.get(S_FuncId);
  }
  
  
  public  void setFuncIdNull(){
     this.set(S_FuncId,null);
  }

  public long getFuncId(){
        return DataType.getAsLong(this.get(S_FuncId));
  
  }
  public long getFuncIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FuncId));
      }

  public void initBceFrameId(long value){
     this.initProperty(S_BceFrameId,new Long(value));
  }
  public  void setBceFrameId(long value){
     this.set(S_BceFrameId,new Long(value));
  }

  public  void setBceFrameId(Long value){
     this.set(S_BceFrameId,value);
  }
  
  public  Long  getBceFrameIdAsLong(){
     return (Long )this.get(S_BceFrameId);
  }
  
  
  public  void setBceFrameIdNull(){
     this.set(S_BceFrameId,null);
  }

  public long getBceFrameId(){
        return DataType.getAsLong(this.get(S_BceFrameId));
  
  }
  public long getBceFrameIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BceFrameId));
      }

  public void initOrdDatasource(String value){
     this.initProperty(S_OrdDatasource,value);
  }
  public  void setOrdDatasource(String value){
     this.set(S_OrdDatasource,value);
  }

  
  
  public  void setOrdDatasourceNull(){
     this.set(S_OrdDatasource,null);
  }

  public String getOrdDatasource(){
       return DataType.getAsString(this.get(S_OrdDatasource));
  
  }
  public String getOrdDatasourceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrdDatasource));
      }

  public void initDealWorkflow(String value){
     this.initProperty(S_DealWorkflow,value);
  }
  public  void setDealWorkflow(String value){
     this.set(S_DealWorkflow,value);
  }

  
  
  public  void setDealWorkflowNull(){
     this.set(S_DealWorkflow,null);
  }

  public String getDealWorkflow(){
       return DataType.getAsString(this.get(S_DealWorkflow));
  
  }
  public String getDealWorkflowInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DealWorkflow));
      }

  public void initRowsetName(String value){
     this.initProperty(S_RowsetName,value);
  }
  public  void setRowsetName(String value){
     this.set(S_RowsetName,value);
  }

  
  
  public  void setRowsetNameNull(){
     this.set(S_RowsetName,null);
  }

  public String getRowsetName(){
       return DataType.getAsString(this.get(S_RowsetName));
  
  }
  public String getRowsetNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RowsetName));
      }

  public void initInsBo(String value){
     this.initProperty(S_InsBo,value);
  }
  public  void setInsBo(String value){
     this.set(S_InsBo,value);
  }

  
  
  public  void setInsBoNull(){
     this.set(S_InsBo,null);
  }

  public String getInsBo(){
       return DataType.getAsString(this.get(S_InsBo));
  
  }
  public String getInsBoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InsBo));
      }

  public void initInsDatasource(String value){
     this.initProperty(S_InsDatasource,value);
  }
  public  void setInsDatasource(String value){
     this.set(S_InsDatasource,value);
  }

  
  
  public  void setInsDatasourceNull(){
     this.set(S_InsDatasource,null);
  }

  public String getInsDatasource(){
       return DataType.getAsString(this.get(S_InsDatasource));
  
  }
  public String getInsDatasourceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InsDatasource));
      }


 
 }

