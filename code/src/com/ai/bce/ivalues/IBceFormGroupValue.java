package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceFormGroupValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_IsClosed = "IS_CLOSED";
  public final static  String S_Attr3 = "ATTR_3";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_GroupId = "GROUP_ID";
  public final static  String S_Attr4 = "ATTR_4";
  public final static  String S_FormId = "FORM_ID";
  public final static  String S_GroupStyle = "GROUP_STYLE";
  public final static  String S_Attr5 = "ATTR_5";
  public final static  String S_Attr1 = "ATTR_1";
  public final static  String S_GroupName = "GROUP_NAME";
  public final static  String S_IsAllowStract = "IS_ALLOW_STRACT";
  public final static  String S_Attr2 = "ATTR_2";
  public final static  String S_SeqNo = "SEQ_NO";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();


  public  Integer  getIsClosedAsInteger();

public int getIsClosed();



public String getAttr3();


  public  Long  getBceFrameIdAsLong();

public long getBceFrameId();


  public  Long  getGroupIdAsLong();

public long getGroupId();



public String getAttr4();



public String getFormId();



public String getGroupStyle();



public String getAttr5();



public String getAttr1();



public String getGroupName();


  public  Integer  getIsAllowStractAsInteger();

public int getIsAllowStract();



public String getAttr2();


  public  Integer  getSeqNoAsInteger();

public int getSeqNo();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);



  public  void setIsClosed(Integer value);

public  void setIsClosed(int value);




public  void setAttr3(String value);



  public  void setBceFrameId(Long value);

public  void setBceFrameId(long value);



  public  void setGroupId(Long value);

public  void setGroupId(long value);




public  void setAttr4(String value);




public  void setFormId(String value);




public  void setGroupStyle(String value);




public  void setAttr5(String value);




public  void setAttr1(String value);




public  void setGroupName(String value);



  public  void setIsAllowStract(Integer value);

public  void setIsAllowStract(int value);




public  void setAttr2(String value);



  public  void setSeqNo(Integer value);

public  void setSeqNo(int value);


}
