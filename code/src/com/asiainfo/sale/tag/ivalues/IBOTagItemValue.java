package com.asiainfo.sale.tag.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOTagItemValue extends DataStructInterface{

  public final static  String S_Name = "NAME";
  public final static  String S_Remark2 = "REMARK_2";
  public final static  String S_Remark1 = "REMARK_1";
  public final static  String S_ItemType = "ITEM_TYPE";
  public final static  String S_Id = "ID";
  public final static  String S_Remark = "REMARK";
  public final static  String S_ItemCode = "ITEM_CODE";


public String getName();

public String getRemark2();

public String getRemark1();

public String getItemType();

public int getId();

public String getRemark();

public String getItemCode();


public  void setName(String value);

public  void setRemark2(String value);

public  void setRemark1(String value);

public  void setItemType(String value);

public  void setId(int value);

public  void setRemark(String value);

public  void setItemCode(String value);
}
