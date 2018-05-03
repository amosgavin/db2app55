package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOBcePageRelRowsetValue extends DataStructInterface{

  public final static  String S_RowsetMethod = "ROWSET_METHOD";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RowsetId = "ROWSET_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_RowsetKey = "ROWSET_KEY";
  public final static  String S_RowsetType = "ROWSET_TYPE";


public String getRowsetMethod();


  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Long  getStateAsLong();

public long getState();


  public  Long  getRowsetIdAsLong();

public long getRowsetId();



public String getRemarks();



public String getRowsetKey();


  public  Long  getRowsetTypeAsLong();

public long getRowsetType();





public  void setRowsetMethod(String value);



  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Long value);

public  void setState(long value);



  public  void setRowsetId(Long value);

public  void setRowsetId(long value);




public  void setRemarks(String value);




public  void setRowsetKey(String value);



  public  void setRowsetType(Long value);

public  void setRowsetType(long value);


}
