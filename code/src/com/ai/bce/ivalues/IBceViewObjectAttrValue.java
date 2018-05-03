package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceViewObjectAttrValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_AttrValue = "ATTR_VALUE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ObjectId = "OBJECT_ID";
  public final static  String S_AttrParam = "ATTR_PARAM";

  public  Integer  getStateAsInteger();

public int getState();


  public  Long  getAttrIdAsLong();

public long getAttrId();



public String getAttrValue();



public String getRemarks();


  public  Long  getObjectIdAsLong();

public long getObjectId();



public String getAttrParam();




  public  void setState(Integer value);

public  void setState(int value);



  public  void setAttrId(Long value);

public  void setAttrId(long value);




public  void setAttrValue(String value);




public  void setRemarks(String value);



  public  void setObjectId(Long value);

public  void setObjectId(long value);




public  void setAttrParam(String value);


}
