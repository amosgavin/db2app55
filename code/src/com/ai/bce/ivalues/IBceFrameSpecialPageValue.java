package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceFrameSpecialPageValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_PageParam = "PAGE_PARAM";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_PageFramePageId = "PAGE_FRAME_PAGE_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PageRulesetId = "PAGE_RULESET_ID";
  public final static  String S_PageTitle = "PAGE_TITLE";
  public final static  String S_IsDataMust = "IS_DATA_MUST";
  public final static  String S_IsGetPageData = "IS_GET_PAGE_DATA";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();



public String getPageParam();


  public  Long  getBceFrameIdAsLong();

public long getBceFrameId();


  public  Long  getPageFramePageIdAsLong();

public long getPageFramePageId();



public String getRemarks();


  public  Long  getPageRulesetIdAsLong();

public long getPageRulesetId();



public String getPageTitle();


  public  Integer  getIsDataMustAsInteger();

public int getIsDataMust();


  public  Integer  getIsGetPageDataAsInteger();

public int getIsGetPageData();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);




public  void setPageParam(String value);



  public  void setBceFrameId(Long value);

public  void setBceFrameId(long value);



  public  void setPageFramePageId(Long value);

public  void setPageFramePageId(long value);




public  void setRemarks(String value);



  public  void setPageRulesetId(Long value);

public  void setPageRulesetId(long value);




public  void setPageTitle(String value);



  public  void setIsDataMust(Integer value);

public  void setIsDataMust(int value);



  public  void setIsGetPageData(Integer value);

public  void setIsGetPageData(int value);


}
