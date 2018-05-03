package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceViewObjectValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_ObjTypeId = "OBJ_TYPE_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ObjectId = "OBJECT_ID";
  public final static  String S_Name = "NAME";
  public final static  String S_SeqNo = "SEQ_NO";

  public  Integer  getStateAsInteger();

public int getState();



public String getObjTypeId();



public String getRemarks();


  public  Long  getObjectIdAsLong();

public long getObjectId();



public String getName();


  public  Integer  getSeqNoAsInteger();

public int getSeqNo();




  public  void setState(Integer value);

public  void setState(int value);




public  void setObjTypeId(String value);




public  void setRemarks(String value);



  public  void setObjectId(Long value);

public  void setObjectId(long value);




public  void setName(String value);



  public  void setSeqNo(Integer value);

public  void setSeqNo(int value);


}
