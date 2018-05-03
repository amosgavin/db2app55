package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceVObjectConfValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_ImplClass = "IMPL_CLASS";
  public final static  String S_ObjTypeId = "OBJ_TYPE_ID";
  public final static  String S_TypeDesc = "TYPE_DESC";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_IsSelfDefine = "IS_SELF_DEFINE";
  public final static  String S_TypeTagValue = "TYPE_TAG_VALUE";

  public  Integer  getStateAsInteger();

public int getState();



public String getImplClass();



public String getObjTypeId();



public String getTypeDesc();



public String getRemarks();


  public  Integer  getIsSelfDefineAsInteger();

public int getIsSelfDefine();



public String getTypeTagValue();




  public  void setState(Integer value);

public  void setState(int value);




public  void setImplClass(String value);




public  void setObjTypeId(String value);




public  void setTypeDesc(String value);




public  void setRemarks(String value);



  public  void setIsSelfDefine(Integer value);

public  void setIsSelfDefine(int value);




public  void setTypeTagValue(String value);


}
