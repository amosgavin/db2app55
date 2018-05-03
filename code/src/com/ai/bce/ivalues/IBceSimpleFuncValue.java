package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceSimpleFuncValue extends DataStructInterface{

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

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();



public String getDealService();



public String getOrdBo();


  public  Long  getFuncIdAsLong();

public long getFuncId();


  public  Long  getBceFrameIdAsLong();

public long getBceFrameId();



public String getOrdDatasource();



public String getDealWorkflow();



public String getRowsetName();



public String getInsBo();



public String getInsDatasource();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);




public  void setDealService(String value);




public  void setOrdBo(String value);



  public  void setFuncId(Long value);

public  void setFuncId(long value);



  public  void setBceFrameId(Long value);

public  void setBceFrameId(long value);




public  void setOrdDatasource(String value);




public  void setDealWorkflow(String value);




public  void setRowsetName(String value);




public  void setInsBo(String value);




public  void setInsDatasource(String value);


}
