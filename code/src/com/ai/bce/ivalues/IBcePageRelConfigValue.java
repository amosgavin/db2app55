package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBcePageRelConfigValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_PreRelateId = "PRE_RELATE_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PageRelId = "PAGE_REL_ID";
  public final static  String S_PageId = "PAGE_ID";
  public final static  String S_TemplateId = "TEMPLATE_ID";
  public final static  String S_RelateType = "RELATE_TYPE";
  public final static  String S_SeqNo = "SEQ_NO";
  public final static  String S_RelateObjId = "RELATE_OBJ_ID";

  public  Integer  getStateAsInteger();

public int getState();


  public  Long  getPreRelateIdAsLong();

public long getPreRelateId();



public String getRemarks();


  public  Long  getPageRelIdAsLong();

public long getPageRelId();


  public  Long  getPageIdAsLong();

public long getPageId();



public String getTemplateId();



public String getRelateType();


  public  Integer  getSeqNoAsInteger();

public int getSeqNo();


  public  Long  getRelateObjIdAsLong();

public long getRelateObjId();




  public  void setState(Integer value);

public  void setState(int value);



  public  void setPreRelateId(Long value);

public  void setPreRelateId(long value);




public  void setRemarks(String value);



  public  void setPageRelId(Long value);

public  void setPageRelId(long value);



  public  void setPageId(Long value);

public  void setPageId(long value);




public  void setTemplateId(String value);




public  void setRelateType(String value);



  public  void setSeqNo(Integer value);

public  void setSeqNo(int value);



  public  void setRelateObjId(Long value);

public  void setRelateObjId(long value);


}
