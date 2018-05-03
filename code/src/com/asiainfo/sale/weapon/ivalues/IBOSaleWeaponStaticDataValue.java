package com.asiainfo.sale.weapon.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleWeaponStaticDataValue extends DataStructInterface{

  public final static  String S_SortId = "SORT_ID";
  public final static  String S_CodeName = "CODE_NAME";
  public final static  String S_IsUsed = "IS_USED";
  public final static  String S_CodeNameNls = "CODE_NAME_NLS";
  public final static  String S_CodeId = "CODE_ID";
  public final static  String S_MarketType = "MARKET_TYPE";
  public final static  String S_ExternCode = "EXTERN_CODE";
  public final static  String S_CodeType = "CODE_TYPE";


public int getSortId();

public String getCodeName();

public int getIsUsed();

public String getCodeNameNls();

public long getCodeId();

public String getMarketType();

public String getExternCode();

public String getCodeType();


public  void setSortId(int value);

public  void setCodeName(String value);

public  void setIsUsed(int value);

public  void setCodeNameNls(String value);

public  void setCodeId(long value);

public  void setMarketType(String value);

public  void setExternCode(String value);

public  void setCodeType(String value);
}
