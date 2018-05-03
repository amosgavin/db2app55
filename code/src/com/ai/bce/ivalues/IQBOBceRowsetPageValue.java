package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOBceRowsetPageValue extends DataStructInterface{

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


  public  Long  getStateAsLong();

public long getState();



public String getPageTemplate();


  public  Long  getPageTypeAsLong();

public long getPageType();



public String getRemarks();


  public  Long  getPageRulesetIdAsLong();

public long getPageRulesetId();


  public  Long  getPageIdAsLong();

public long getPageId();


  public  Long  getIsDataMustAsLong();

public long getIsDataMust();



public String getPageUrl();


  public  Long  getPageLoadTypeAsLong();

public long getPageLoadType();


  public  Long  getIsGetPageDataAsLong();

public long getIsGetPageData();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Long value);

public  void setState(long value);




public  void setPageTemplate(String value);



  public  void setPageType(Long value);

public  void setPageType(long value);




public  void setRemarks(String value);



  public  void setPageRulesetId(Long value);

public  void setPageRulesetId(long value);



  public  void setPageId(Long value);

public  void setPageId(long value);



  public  void setIsDataMust(Long value);

public  void setIsDataMust(long value);




public  void setPageUrl(String value);



  public  void setPageLoadType(Long value);

public  void setPageLoadType(long value);



  public  void setIsGetPageData(Long value);

public  void setIsGetPageData(long value);


}
