package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBcePageValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_PageTemplate = "PAGE_TEMPLATE";
  public final static  String S_PageType = "PAGE_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PageRulesetId = "PAGE_RULESET_ID";
  public final static  String S_PageId = "PAGE_ID";
  public final static  String S_IsDataMust = "IS_DATA_MUST";
  public final static  String S_PageUrl = "PAGE_URL";
  public final static  String S_PageLoadType = "PAGE_LOAD_TYPE";
  public final static  String S_IsGetPageData = "IS_GET_PAGE_DATA";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();



public String getPageTemplate();


  public  Integer  getPageTypeAsInteger();

public int getPageType();



public String getRemarks();


  public  Long  getPageRulesetIdAsLong();

public long getPageRulesetId();


  public  Long  getPageIdAsLong();

public long getPageId();


  public  Integer  getIsDataMustAsInteger();

public int getIsDataMust();



public String getPageUrl();


  public  Integer  getPageLoadTypeAsInteger();

public int getPageLoadType();


  public  Integer  getIsGetPageDataAsInteger();

public int getIsGetPageData();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);




public  void setPageTemplate(String value);



  public  void setPageType(Integer value);

public  void setPageType(int value);




public  void setRemarks(String value);



  public  void setPageRulesetId(Long value);

public  void setPageRulesetId(long value);



  public  void setPageId(Long value);

public  void setPageId(long value);



  public  void setIsDataMust(Integer value);

public  void setIsDataMust(int value);




public  void setPageUrl(String value);



  public  void setPageLoadType(Integer value);

public  void setPageLoadType(int value);



  public  void setIsGetPageData(Integer value);

public  void setIsGetPageData(int value);


}
