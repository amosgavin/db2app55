package com.asiainfo.sale.weapon.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOWeaponTagRelaValue extends DataStructInterface{

  public final static  String S_TagId = "TAG_ID";
  public final static  String S_WeaponId = "WEAPON_ID";
  public final static  String S_SaleFlag = "SALE_FLAG";
  public final static  String S_Id = "ID";


public String getTagId();

public String getWeaponId();

public String getSaleFlag();

public int getId();


public  void setTagId(String value);

public  void setWeaponId(String value);

public  void setSaleFlag(String value);

public  void setId(int value);
}
