package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeInfoExtBean extends DataContainer implements DataContainerInterface,IBOChargeInfoExtValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeInfoExt";



  public final static  String S_Ext53 = "EXT53";
  public final static  String S_Ext52 = "EXT52";
  public final static  String S_Ext51 = "EXT51";
  public final static  String S_Ext50 = "EXT50";
  public final static  String S_Ext199 = "EXT199";
  public final static  String S_Ext197 = "EXT197";
  public final static  String S_Ext198 = "EXT198";
  public final static  String S_Ext195 = "EXT195";
  public final static  String S_Ext196 = "EXT196";
  public final static  String S_Ext193 = "EXT193";
  public final static  String S_Ext194 = "EXT194";
  public final static  String S_Ext191 = "EXT191";
  public final static  String S_Ext192 = "EXT192";
  public final static  String S_Ext45 = "EXT45";
  public final static  String S_Ext190 = "EXT190";
  public final static  String S_Ext46 = "EXT46";
  public final static  String S_Ext43 = "EXT43";
  public final static  String S_Ext44 = "EXT44";
  public final static  String S_Ext49 = "EXT49";
  public final static  String S_Ext47 = "EXT47";
  public final static  String S_Ext48 = "EXT48";
  public final static  String S_Ext60 = "EXT60";
  public final static  String S_Ext62 = "EXT62";
  public final static  String S_Ext61 = "EXT61";
  public final static  String S_Ext64 = "EXT64";
  public final static  String S_Ext63 = "EXT63";
  public final static  String S_Ext189 = "EXT189";
  public final static  String S_Ext188 = "EXT188";
  public final static  String S_FeeId = "FEE_ID";
  public final static  String S_Ext184 = "EXT184";
  public final static  String S_Ext185 = "EXT185";
  public final static  String S_Ext186 = "EXT186";
  public final static  String S_Ext187 = "EXT187";
  public final static  String S_Ext9 = "EXT9";
  public final static  String S_Ext180 = "EXT180";
  public final static  String S_Ext181 = "EXT181";
  public final static  String S_Ext182 = "EXT182";
  public final static  String S_Ext183 = "EXT183";
  public final static  String S_Ext54 = "EXT54";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_Ext55 = "EXT55";
  public final static  String S_Ext7 = "EXT7";
  public final static  String S_Ext56 = "EXT56";
  public final static  String S_Ext8 = "EXT8";
  public final static  String S_Ext57 = "EXT57";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Ext58 = "EXT58";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext59 = "EXT59";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_Ext31 = "EXT31";
  public final static  String S_Ext30 = "EXT30";
  public final static  String S_Ext179 = "EXT179";
  public final static  String S_Ext178 = "EXT178";
  public final static  String S_Ext177 = "EXT177";
  public final static  String S_Ext171 = "EXT171";
  public final static  String S_Ext172 = "EXT172";
  public final static  String S_Ext170 = "EXT170";
  public final static  String S_Ext175 = "EXT175";
  public final static  String S_Ext176 = "EXT176";
  public final static  String S_Ext173 = "EXT173";
  public final static  String S_Ext29 = "EXT29";
  public final static  String S_Ext174 = "EXT174";
  public final static  String S_Ext27 = "EXT27";
  public final static  String S_Ext28 = "EXT28";
  public final static  String S_Ext25 = "EXT25";
  public final static  String S_Ext26 = "EXT26";
  public final static  String S_Ext23 = "EXT23";
  public final static  String S_Ext24 = "EXT24";
  public final static  String S_Ext21 = "EXT21";
  public final static  String S_Ext22 = "EXT22";
  public final static  String S_Ext40 = "EXT40";
  public final static  String S_Ext42 = "EXT42";
  public final static  String S_Ext41 = "EXT41";
  public final static  String S_Ext167 = "EXT167";
  public final static  String S_Ext166 = "EXT166";
  public final static  String S_Ext169 = "EXT169";
  public final static  String S_Ext168 = "EXT168";
  public final static  String S_Ext160 = "EXT160";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_Ext161 = "EXT161";
  public final static  String S_Ext162 = "EXT162";
  public final static  String S_Ext163 = "EXT163";
  public final static  String S_Ext164 = "EXT164";
  public final static  String S_Ext165 = "EXT165";
  public final static  String S_Ext36 = "EXT36";
  public final static  String S_Ext37 = "EXT37";
  public final static  String S_Ext38 = "EXT38";
  public final static  String S_Ext39 = "EXT39";
  public final static  String S_Ext32 = "EXT32";
  public final static  String S_Ext33 = "EXT33";
  public final static  String S_Ext34 = "EXT34";
  public final static  String S_Ext35 = "EXT35";
  public final static  String S_Ext92 = "EXT92";
  public final static  String S_Ext93 = "EXT93";
  public final static  String S_Ext90 = "EXT90";
  public final static  String S_Ext91 = "EXT91";
  public final static  String S_Ext96 = "EXT96";
  public final static  String S_Ext97 = "EXT97";
  public final static  String S_Ext94 = "EXT94";
  public final static  String S_Caseid = "CASEID";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Ext95 = "EXT95";
  public final static  String S_Ext89 = "EXT89";
  public final static  String S_Ext88 = "EXT88";
  public final static  String S_Ext87 = "EXT87";
  public final static  String S_Ext99 = "EXT99";
  public final static  String S_Ext98 = "EXT98";
  public final static  String S_Ext74 = "EXT74";
  public final static  String S_Ext75 = "EXT75";
  public final static  String S_Ext72 = "EXT72";
  public final static  String S_Ext73 = "EXT73";
  public final static  String S_Ext70 = "EXT70";
  public final static  String S_Mid = "MID";
  public final static  String S_Ext71 = "EXT71";
  public final static  String S_Ext69 = "EXT69";
  public final static  String S_Ext68 = "EXT68";
  public final static  String S_Ext67 = "EXT67";
  public final static  String S_Ext66 = "EXT66";
  public final static  String S_Ext65 = "EXT65";
  public final static  String S_ApplyId = "APPLY_ID";
  public final static  String S_Ext83 = "EXT83";
  public final static  String S_Ext84 = "EXT84";
  public final static  String S_Ext85 = "EXT85";
  public final static  String S_Ext86 = "EXT86";
  public final static  String S_PrivType = "PRIV_TYPE";
  public final static  String S_Ext80 = "EXT80";
  public final static  String S_Ext81 = "EXT81";
  public final static  String S_Ext82 = "EXT82";
  public final static  String S_Ext77 = "EXT77";
  public final static  String S_Ext76 = "EXT76";
  public final static  String S_Ext79 = "EXT79";
  public final static  String S_Ext78 = "EXT78";
  public final static  String S_Ext110 = "EXT110";
  public final static  String S_Ext119 = "EXT119";
  public final static  String S_Ext116 = "EXT116";
  public final static  String S_Ext115 = "EXT115";
  public final static  String S_Ext118 = "EXT118";
  public final static  String S_Ext117 = "EXT117";
  public final static  String S_Ext112 = "EXT112";
  public final static  String S_Ext111 = "EXT111";
  public final static  String S_Ext114 = "EXT114";
  public final static  String S_Ext113 = "EXT113";
  public final static  String S_Ext245 = "EXT245";
  public final static  String S_Ext246 = "EXT246";
  public final static  String S_Ext243 = "EXT243";
  public final static  String S_Ext244 = "EXT244";
  public final static  String S_Ext242 = "EXT242";
  public final static  String S_Ext241 = "EXT241";
  public final static  String S_Ext109 = "EXT109";
  public final static  String S_Ext240 = "EXT240";
  public final static  String S_Ext108 = "EXT108";
  public final static  String S_Ext107 = "EXT107";
  public final static  String S_Ext106 = "EXT106";
  public final static  String S_Ext105 = "EXT105";
  public final static  String S_Ext104 = "EXT104";
  public final static  String S_Ext103 = "EXT103";
  public final static  String S_Ext102 = "EXT102";
  public final static  String S_Ext101 = "EXT101";
  public final static  String S_Ext100 = "EXT100";
  public final static  String S_Ext20 = "EXT20";
  public final static  String S_Ext19 = "EXT19";
  public final static  String S_Ext18 = "EXT18";
  public final static  String S_Ext17 = "EXT17";
  public final static  String S_Ext16 = "EXT16";
  public final static  String S_Ext15 = "EXT15";
  public final static  String S_Ext14 = "EXT14";
  public final static  String S_Ext13 = "EXT13";
  public final static  String S_Ext12 = "EXT12";
  public final static  String S_Ext11 = "EXT11";
  public final static  String S_Ext10 = "EXT10";
  public final static  String S_Ext211 = "EXT211";
  public final static  String S_Ext210 = "EXT210";
  public final static  String S_Ext213 = "EXT213";
  public final static  String S_Ext212 = "EXT212";
  public final static  String S_Ext215 = "EXT215";
  public final static  String S_Ext214 = "EXT214";
  public final static  String S_Ext217 = "EXT217";
  public final static  String S_Ext216 = "EXT216";
  public final static  String S_Ext152 = "EXT152";
  public final static  String S_Ext219 = "EXT219";
  public final static  String S_Ext151 = "EXT151";
  public final static  String S_Ext218 = "EXT218";
  public final static  String S_Ext154 = "EXT154";
  public final static  String S_Ext153 = "EXT153";
  public final static  String S_Ext150 = "EXT150";
  public final static  String S_Ext159 = "EXT159";
  public final static  String S_Ext155 = "EXT155";
  public final static  String S_Ext156 = "EXT156";
  public final static  String S_Ext157 = "EXT157";
  public final static  String S_Ext158 = "EXT158";
  public final static  String S_Ext202 = "EXT202";
  public final static  String S_Ext201 = "EXT201";
  public final static  String S_Ext200 = "EXT200";
  public final static  String S_Ext206 = "EXT206";
  public final static  String S_Ext205 = "EXT205";
  public final static  String S_Ext204 = "EXT204";
  public final static  String S_Ext203 = "EXT203";
  public final static  String S_Ext143 = "EXT143";
  public final static  String S_Ext142 = "EXT142";
  public final static  String S_Ext209 = "EXT209";
  public final static  String S_Ext141 = "EXT141";
  public final static  String S_Ext208 = "EXT208";
  public final static  String S_Ext140 = "EXT140";
  public final static  String S_Ext207 = "EXT207";
  public final static  String S_Ext148 = "EXT148";
  public final static  String S_Ext149 = "EXT149";
  public final static  String S_Ext146 = "EXT146";
  public final static  String S_Ext147 = "EXT147";
  public final static  String S_Ext144 = "EXT144";
  public final static  String S_Ext145 = "EXT145";
  public final static  String S_Ext237 = "EXT237";
  public final static  String S_Ext236 = "EXT236";
  public final static  String S_Ext239 = "EXT239";
  public final static  String S_Ext238 = "EXT238";
  public final static  String S_Ext233 = "EXT233";
  public final static  String S_Ext232 = "EXT232";
  public final static  String S_Ext235 = "EXT235";
  public final static  String S_Ext234 = "EXT234";
  public final static  String S_Status = "STATUS";
  public final static  String S_Ext130 = "EXT130";
  public final static  String S_Ext132 = "EXT132";
  public final static  String S_Ext131 = "EXT131";
  public final static  String S_Ext133 = "EXT133";
  public final static  String S_Ext134 = "EXT134";
  public final static  String S_Ext135 = "EXT135";
  public final static  String S_Ext136 = "EXT136";
  public final static  String S_Ext137 = "EXT137";
  public final static  String S_Ext138 = "EXT138";
  public final static  String S_Ext139 = "EXT139";
  public final static  String S_Ext230 = "EXT230";
  public final static  String S_Ext231 = "EXT231";
  public final static  String S_Ext228 = "EXT228";
  public final static  String S_Ext227 = "EXT227";
  public final static  String S_Ext226 = "EXT226";
  public final static  String S_Ext225 = "EXT225";
  public final static  String S_Ext224 = "EXT224";
  public final static  String S_Ext223 = "EXT223";
  public final static  String S_Ext222 = "EXT222";
  public final static  String S_Ext221 = "EXT221";
  public final static  String S_Ext121 = "EXT121";
  public final static  String S_Ext120 = "EXT120";
  public final static  String S_Ext229 = "EXT229";
  public final static  String S_Ext124 = "EXT124";
  public final static  String S_Ext125 = "EXT125";
  public final static  String S_Ext122 = "EXT122";
  public final static  String S_Ext123 = "EXT123";
  public final static  String S_Ext128 = "EXT128";
  public final static  String S_Ext129 = "EXT129";
  public final static  String S_Ext126 = "EXT126";
  public final static  String S_Ext127 = "EXT127";
  public final static  String S_Ext220 = "EXT220";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeInfoExtBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initExt53(String value){
     this.initProperty(S_Ext53,value);
  }
  public  void setExt53(String value){
     this.set(S_Ext53,value);
  }
  public  void setExt53Null(){
     this.set(S_Ext53,null);
  }

  public String getExt53(){
       return DataType.getAsString(this.get(S_Ext53));
  
  }
  public String getExt53InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext53));
      }

  public void initExt52(String value){
     this.initProperty(S_Ext52,value);
  }
  public  void setExt52(String value){
     this.set(S_Ext52,value);
  }
  public  void setExt52Null(){
     this.set(S_Ext52,null);
  }

  public String getExt52(){
       return DataType.getAsString(this.get(S_Ext52));
  
  }
  public String getExt52InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext52));
      }

  public void initExt51(String value){
     this.initProperty(S_Ext51,value);
  }
  public  void setExt51(String value){
     this.set(S_Ext51,value);
  }
  public  void setExt51Null(){
     this.set(S_Ext51,null);
  }

  public String getExt51(){
       return DataType.getAsString(this.get(S_Ext51));
  
  }
  public String getExt51InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext51));
      }

  public void initExt50(String value){
     this.initProperty(S_Ext50,value);
  }
  public  void setExt50(String value){
     this.set(S_Ext50,value);
  }
  public  void setExt50Null(){
     this.set(S_Ext50,null);
  }

  public String getExt50(){
       return DataType.getAsString(this.get(S_Ext50));
  
  }
  public String getExt50InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext50));
      }

  public void initExt199(String value){
     this.initProperty(S_Ext199,value);
  }
  public  void setExt199(String value){
     this.set(S_Ext199,value);
  }
  public  void setExt199Null(){
     this.set(S_Ext199,null);
  }

  public String getExt199(){
       return DataType.getAsString(this.get(S_Ext199));
  
  }
  public String getExt199InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext199));
      }

  public void initExt197(String value){
     this.initProperty(S_Ext197,value);
  }
  public  void setExt197(String value){
     this.set(S_Ext197,value);
  }
  public  void setExt197Null(){
     this.set(S_Ext197,null);
  }

  public String getExt197(){
       return DataType.getAsString(this.get(S_Ext197));
  
  }
  public String getExt197InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext197));
      }

  public void initExt198(String value){
     this.initProperty(S_Ext198,value);
  }
  public  void setExt198(String value){
     this.set(S_Ext198,value);
  }
  public  void setExt198Null(){
     this.set(S_Ext198,null);
  }

  public String getExt198(){
       return DataType.getAsString(this.get(S_Ext198));
  
  }
  public String getExt198InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext198));
      }

  public void initExt195(String value){
     this.initProperty(S_Ext195,value);
  }
  public  void setExt195(String value){
     this.set(S_Ext195,value);
  }
  public  void setExt195Null(){
     this.set(S_Ext195,null);
  }

  public String getExt195(){
       return DataType.getAsString(this.get(S_Ext195));
  
  }
  public String getExt195InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext195));
      }

  public void initExt196(String value){
     this.initProperty(S_Ext196,value);
  }
  public  void setExt196(String value){
     this.set(S_Ext196,value);
  }
  public  void setExt196Null(){
     this.set(S_Ext196,null);
  }

  public String getExt196(){
       return DataType.getAsString(this.get(S_Ext196));
  
  }
  public String getExt196InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext196));
      }

  public void initExt193(String value){
     this.initProperty(S_Ext193,value);
  }
  public  void setExt193(String value){
     this.set(S_Ext193,value);
  }
  public  void setExt193Null(){
     this.set(S_Ext193,null);
  }

  public String getExt193(){
       return DataType.getAsString(this.get(S_Ext193));
  
  }
  public String getExt193InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext193));
      }

  public void initExt194(String value){
     this.initProperty(S_Ext194,value);
  }
  public  void setExt194(String value){
     this.set(S_Ext194,value);
  }
  public  void setExt194Null(){
     this.set(S_Ext194,null);
  }

  public String getExt194(){
       return DataType.getAsString(this.get(S_Ext194));
  
  }
  public String getExt194InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext194));
      }

  public void initExt191(String value){
     this.initProperty(S_Ext191,value);
  }
  public  void setExt191(String value){
     this.set(S_Ext191,value);
  }
  public  void setExt191Null(){
     this.set(S_Ext191,null);
  }

  public String getExt191(){
       return DataType.getAsString(this.get(S_Ext191));
  
  }
  public String getExt191InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext191));
      }

  public void initExt192(String value){
     this.initProperty(S_Ext192,value);
  }
  public  void setExt192(String value){
     this.set(S_Ext192,value);
  }
  public  void setExt192Null(){
     this.set(S_Ext192,null);
  }

  public String getExt192(){
       return DataType.getAsString(this.get(S_Ext192));
  
  }
  public String getExt192InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext192));
      }

  public void initExt45(String value){
     this.initProperty(S_Ext45,value);
  }
  public  void setExt45(String value){
     this.set(S_Ext45,value);
  }
  public  void setExt45Null(){
     this.set(S_Ext45,null);
  }

  public String getExt45(){
       return DataType.getAsString(this.get(S_Ext45));
  
  }
  public String getExt45InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext45));
      }

  public void initExt190(String value){
     this.initProperty(S_Ext190,value);
  }
  public  void setExt190(String value){
     this.set(S_Ext190,value);
  }
  public  void setExt190Null(){
     this.set(S_Ext190,null);
  }

  public String getExt190(){
       return DataType.getAsString(this.get(S_Ext190));
  
  }
  public String getExt190InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext190));
      }

  public void initExt46(String value){
     this.initProperty(S_Ext46,value);
  }
  public  void setExt46(String value){
     this.set(S_Ext46,value);
  }
  public  void setExt46Null(){
     this.set(S_Ext46,null);
  }

  public String getExt46(){
       return DataType.getAsString(this.get(S_Ext46));
  
  }
  public String getExt46InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext46));
      }

  public void initExt43(String value){
     this.initProperty(S_Ext43,value);
  }
  public  void setExt43(String value){
     this.set(S_Ext43,value);
  }
  public  void setExt43Null(){
     this.set(S_Ext43,null);
  }

  public String getExt43(){
       return DataType.getAsString(this.get(S_Ext43));
  
  }
  public String getExt43InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext43));
      }

  public void initExt44(String value){
     this.initProperty(S_Ext44,value);
  }
  public  void setExt44(String value){
     this.set(S_Ext44,value);
  }
  public  void setExt44Null(){
     this.set(S_Ext44,null);
  }

  public String getExt44(){
       return DataType.getAsString(this.get(S_Ext44));
  
  }
  public String getExt44InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext44));
      }

  public void initExt49(String value){
     this.initProperty(S_Ext49,value);
  }
  public  void setExt49(String value){
     this.set(S_Ext49,value);
  }
  public  void setExt49Null(){
     this.set(S_Ext49,null);
  }

  public String getExt49(){
       return DataType.getAsString(this.get(S_Ext49));
  
  }
  public String getExt49InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext49));
      }

  public void initExt47(String value){
     this.initProperty(S_Ext47,value);
  }
  public  void setExt47(String value){
     this.set(S_Ext47,value);
  }
  public  void setExt47Null(){
     this.set(S_Ext47,null);
  }

  public String getExt47(){
       return DataType.getAsString(this.get(S_Ext47));
  
  }
  public String getExt47InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext47));
      }

  public void initExt48(String value){
     this.initProperty(S_Ext48,value);
  }
  public  void setExt48(String value){
     this.set(S_Ext48,value);
  }
  public  void setExt48Null(){
     this.set(S_Ext48,null);
  }

  public String getExt48(){
       return DataType.getAsString(this.get(S_Ext48));
  
  }
  public String getExt48InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext48));
      }

  public void initExt60(String value){
     this.initProperty(S_Ext60,value);
  }
  public  void setExt60(String value){
     this.set(S_Ext60,value);
  }
  public  void setExt60Null(){
     this.set(S_Ext60,null);
  }

  public String getExt60(){
       return DataType.getAsString(this.get(S_Ext60));
  
  }
  public String getExt60InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext60));
      }

  public void initExt62(String value){
     this.initProperty(S_Ext62,value);
  }
  public  void setExt62(String value){
     this.set(S_Ext62,value);
  }
  public  void setExt62Null(){
     this.set(S_Ext62,null);
  }

  public String getExt62(){
       return DataType.getAsString(this.get(S_Ext62));
  
  }
  public String getExt62InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext62));
      }

  public void initExt61(String value){
     this.initProperty(S_Ext61,value);
  }
  public  void setExt61(String value){
     this.set(S_Ext61,value);
  }
  public  void setExt61Null(){
     this.set(S_Ext61,null);
  }

  public String getExt61(){
       return DataType.getAsString(this.get(S_Ext61));
  
  }
  public String getExt61InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext61));
      }

  public void initExt64(String value){
     this.initProperty(S_Ext64,value);
  }
  public  void setExt64(String value){
     this.set(S_Ext64,value);
  }
  public  void setExt64Null(){
     this.set(S_Ext64,null);
  }

  public String getExt64(){
       return DataType.getAsString(this.get(S_Ext64));
  
  }
  public String getExt64InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext64));
      }

  public void initExt63(String value){
     this.initProperty(S_Ext63,value);
  }
  public  void setExt63(String value){
     this.set(S_Ext63,value);
  }
  public  void setExt63Null(){
     this.set(S_Ext63,null);
  }

  public String getExt63(){
       return DataType.getAsString(this.get(S_Ext63));
  
  }
  public String getExt63InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext63));
      }

  public void initExt189(String value){
     this.initProperty(S_Ext189,value);
  }
  public  void setExt189(String value){
     this.set(S_Ext189,value);
  }
  public  void setExt189Null(){
     this.set(S_Ext189,null);
  }

  public String getExt189(){
       return DataType.getAsString(this.get(S_Ext189));
  
  }
  public String getExt189InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext189));
      }

  public void initExt188(String value){
     this.initProperty(S_Ext188,value);
  }
  public  void setExt188(String value){
     this.set(S_Ext188,value);
  }
  public  void setExt188Null(){
     this.set(S_Ext188,null);
  }

  public String getExt188(){
       return DataType.getAsString(this.get(S_Ext188));
  
  }
  public String getExt188InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext188));
      }

  public void initFeeId(String value){
     this.initProperty(S_FeeId,value);
  }
  public  void setFeeId(String value){
     this.set(S_FeeId,value);
  }
  public  void setFeeIdNull(){
     this.set(S_FeeId,null);
  }

  public String getFeeId(){
       return DataType.getAsString(this.get(S_FeeId));
  
  }
  public String getFeeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeeId));
      }

  public void initExt184(String value){
     this.initProperty(S_Ext184,value);
  }
  public  void setExt184(String value){
     this.set(S_Ext184,value);
  }
  public  void setExt184Null(){
     this.set(S_Ext184,null);
  }

  public String getExt184(){
       return DataType.getAsString(this.get(S_Ext184));
  
  }
  public String getExt184InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext184));
      }

  public void initExt185(String value){
     this.initProperty(S_Ext185,value);
  }
  public  void setExt185(String value){
     this.set(S_Ext185,value);
  }
  public  void setExt185Null(){
     this.set(S_Ext185,null);
  }

  public String getExt185(){
       return DataType.getAsString(this.get(S_Ext185));
  
  }
  public String getExt185InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext185));
      }

  public void initExt186(String value){
     this.initProperty(S_Ext186,value);
  }
  public  void setExt186(String value){
     this.set(S_Ext186,value);
  }
  public  void setExt186Null(){
     this.set(S_Ext186,null);
  }

  public String getExt186(){
       return DataType.getAsString(this.get(S_Ext186));
  
  }
  public String getExt186InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext186));
      }

  public void initExt187(String value){
     this.initProperty(S_Ext187,value);
  }
  public  void setExt187(String value){
     this.set(S_Ext187,value);
  }
  public  void setExt187Null(){
     this.set(S_Ext187,null);
  }

  public String getExt187(){
       return DataType.getAsString(this.get(S_Ext187));
  
  }
  public String getExt187InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext187));
      }

  public void initExt9(String value){
     this.initProperty(S_Ext9,value);
  }
  public  void setExt9(String value){
     this.set(S_Ext9,value);
  }
  public  void setExt9Null(){
     this.set(S_Ext9,null);
  }

  public String getExt9(){
       return DataType.getAsString(this.get(S_Ext9));
  
  }
  public String getExt9InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext9));
      }

  public void initExt180(String value){
     this.initProperty(S_Ext180,value);
  }
  public  void setExt180(String value){
     this.set(S_Ext180,value);
  }
  public  void setExt180Null(){
     this.set(S_Ext180,null);
  }

  public String getExt180(){
       return DataType.getAsString(this.get(S_Ext180));
  
  }
  public String getExt180InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext180));
      }

  public void initExt181(String value){
     this.initProperty(S_Ext181,value);
  }
  public  void setExt181(String value){
     this.set(S_Ext181,value);
  }
  public  void setExt181Null(){
     this.set(S_Ext181,null);
  }

  public String getExt181(){
       return DataType.getAsString(this.get(S_Ext181));
  
  }
  public String getExt181InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext181));
      }

  public void initExt182(String value){
     this.initProperty(S_Ext182,value);
  }
  public  void setExt182(String value){
     this.set(S_Ext182,value);
  }
  public  void setExt182Null(){
     this.set(S_Ext182,null);
  }

  public String getExt182(){
       return DataType.getAsString(this.get(S_Ext182));
  
  }
  public String getExt182InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext182));
      }

  public void initExt183(String value){
     this.initProperty(S_Ext183,value);
  }
  public  void setExt183(String value){
     this.set(S_Ext183,value);
  }
  public  void setExt183Null(){
     this.set(S_Ext183,null);
  }

  public String getExt183(){
       return DataType.getAsString(this.get(S_Ext183));
  
  }
  public String getExt183InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext183));
      }

  public void initExt54(String value){
     this.initProperty(S_Ext54,value);
  }
  public  void setExt54(String value){
     this.set(S_Ext54,value);
  }
  public  void setExt54Null(){
     this.set(S_Ext54,null);
  }

  public String getExt54(){
       return DataType.getAsString(this.get(S_Ext54));
  
  }
  public String getExt54InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext54));
      }

  public void initExt5(String value){
     this.initProperty(S_Ext5,value);
  }
  public  void setExt5(String value){
     this.set(S_Ext5,value);
  }
  public  void setExt5Null(){
     this.set(S_Ext5,null);
  }

  public String getExt5(){
       return DataType.getAsString(this.get(S_Ext5));
  
  }
  public String getExt5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext5));
      }

  public void initExt6(String value){
     this.initProperty(S_Ext6,value);
  }
  public  void setExt6(String value){
     this.set(S_Ext6,value);
  }
  public  void setExt6Null(){
     this.set(S_Ext6,null);
  }

  public String getExt6(){
       return DataType.getAsString(this.get(S_Ext6));
  
  }
  public String getExt6InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext6));
      }

  public void initExt55(String value){
     this.initProperty(S_Ext55,value);
  }
  public  void setExt55(String value){
     this.set(S_Ext55,value);
  }
  public  void setExt55Null(){
     this.set(S_Ext55,null);
  }

  public String getExt55(){
       return DataType.getAsString(this.get(S_Ext55));
  
  }
  public String getExt55InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext55));
      }

  public void initExt7(String value){
     this.initProperty(S_Ext7,value);
  }
  public  void setExt7(String value){
     this.set(S_Ext7,value);
  }
  public  void setExt7Null(){
     this.set(S_Ext7,null);
  }

  public String getExt7(){
       return DataType.getAsString(this.get(S_Ext7));
  
  }
  public String getExt7InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext7));
      }

  public void initExt56(String value){
     this.initProperty(S_Ext56,value);
  }
  public  void setExt56(String value){
     this.set(S_Ext56,value);
  }
  public  void setExt56Null(){
     this.set(S_Ext56,null);
  }

  public String getExt56(){
       return DataType.getAsString(this.get(S_Ext56));
  
  }
  public String getExt56InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext56));
      }

  public void initExt8(String value){
     this.initProperty(S_Ext8,value);
  }
  public  void setExt8(String value){
     this.set(S_Ext8,value);
  }
  public  void setExt8Null(){
     this.set(S_Ext8,null);
  }

  public String getExt8(){
       return DataType.getAsString(this.get(S_Ext8));
  
  }
  public String getExt8InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext8));
      }

  public void initExt57(String value){
     this.initProperty(S_Ext57,value);
  }
  public  void setExt57(String value){
     this.set(S_Ext57,value);
  }
  public  void setExt57Null(){
     this.set(S_Ext57,null);
  }

  public String getExt57(){
       return DataType.getAsString(this.get(S_Ext57));
  
  }
  public String getExt57InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext57));
      }

  public void initCreateDate(Timestamp value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(Timestamp value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public Timestamp getCreateDate(){
        return DataType.getAsDateTime(this.get(S_CreateDate));
  
  }
  public Timestamp getCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
      }

  public void initExt58(String value){
     this.initProperty(S_Ext58,value);
  }
  public  void setExt58(String value){
     this.set(S_Ext58,value);
  }
  public  void setExt58Null(){
     this.set(S_Ext58,null);
  }

  public String getExt58(){
       return DataType.getAsString(this.get(S_Ext58));
  
  }
  public String getExt58InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext58));
      }

  public void initExt1(String value){
     this.initProperty(S_Ext1,value);
  }
  public  void setExt1(String value){
     this.set(S_Ext1,value);
  }
  public  void setExt1Null(){
     this.set(S_Ext1,null);
  }

  public String getExt1(){
       return DataType.getAsString(this.get(S_Ext1));
  
  }
  public String getExt1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext1));
      }

  public void initExt59(String value){
     this.initProperty(S_Ext59,value);
  }
  public  void setExt59(String value){
     this.set(S_Ext59,value);
  }
  public  void setExt59Null(){
     this.set(S_Ext59,null);
  }

  public String getExt59(){
       return DataType.getAsString(this.get(S_Ext59));
  
  }
  public String getExt59InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext59));
      }

  public void initExt2(String value){
     this.initProperty(S_Ext2,value);
  }
  public  void setExt2(String value){
     this.set(S_Ext2,value);
  }
  public  void setExt2Null(){
     this.set(S_Ext2,null);
  }

  public String getExt2(){
       return DataType.getAsString(this.get(S_Ext2));
  
  }
  public String getExt2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext2));
      }

  public void initExt3(String value){
     this.initProperty(S_Ext3,value);
  }
  public  void setExt3(String value){
     this.set(S_Ext3,value);
  }
  public  void setExt3Null(){
     this.set(S_Ext3,null);
  }

  public String getExt3(){
       return DataType.getAsString(this.get(S_Ext3));
  
  }
  public String getExt3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext3));
      }

  public void initExt4(String value){
     this.initProperty(S_Ext4,value);
  }
  public  void setExt4(String value){
     this.set(S_Ext4,value);
  }
  public  void setExt4Null(){
     this.set(S_Ext4,null);
  }

  public String getExt4(){
       return DataType.getAsString(this.get(S_Ext4));
  
  }
  public String getExt4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext4));
      }

  public void initExt31(String value){
     this.initProperty(S_Ext31,value);
  }
  public  void setExt31(String value){
     this.set(S_Ext31,value);
  }
  public  void setExt31Null(){
     this.set(S_Ext31,null);
  }

  public String getExt31(){
       return DataType.getAsString(this.get(S_Ext31));
  
  }
  public String getExt31InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext31));
      }

  public void initExt30(String value){
     this.initProperty(S_Ext30,value);
  }
  public  void setExt30(String value){
     this.set(S_Ext30,value);
  }
  public  void setExt30Null(){
     this.set(S_Ext30,null);
  }

  public String getExt30(){
       return DataType.getAsString(this.get(S_Ext30));
  
  }
  public String getExt30InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext30));
      }

  public void initExt179(String value){
     this.initProperty(S_Ext179,value);
  }
  public  void setExt179(String value){
     this.set(S_Ext179,value);
  }
  public  void setExt179Null(){
     this.set(S_Ext179,null);
  }

  public String getExt179(){
       return DataType.getAsString(this.get(S_Ext179));
  
  }
  public String getExt179InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext179));
      }

  public void initExt178(String value){
     this.initProperty(S_Ext178,value);
  }
  public  void setExt178(String value){
     this.set(S_Ext178,value);
  }
  public  void setExt178Null(){
     this.set(S_Ext178,null);
  }

  public String getExt178(){
       return DataType.getAsString(this.get(S_Ext178));
  
  }
  public String getExt178InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext178));
      }

  public void initExt177(String value){
     this.initProperty(S_Ext177,value);
  }
  public  void setExt177(String value){
     this.set(S_Ext177,value);
  }
  public  void setExt177Null(){
     this.set(S_Ext177,null);
  }

  public String getExt177(){
       return DataType.getAsString(this.get(S_Ext177));
  
  }
  public String getExt177InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext177));
      }

  public void initExt171(String value){
     this.initProperty(S_Ext171,value);
  }
  public  void setExt171(String value){
     this.set(S_Ext171,value);
  }
  public  void setExt171Null(){
     this.set(S_Ext171,null);
  }

  public String getExt171(){
       return DataType.getAsString(this.get(S_Ext171));
  
  }
  public String getExt171InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext171));
      }

  public void initExt172(String value){
     this.initProperty(S_Ext172,value);
  }
  public  void setExt172(String value){
     this.set(S_Ext172,value);
  }
  public  void setExt172Null(){
     this.set(S_Ext172,null);
  }

  public String getExt172(){
       return DataType.getAsString(this.get(S_Ext172));
  
  }
  public String getExt172InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext172));
      }

  public void initExt170(String value){
     this.initProperty(S_Ext170,value);
  }
  public  void setExt170(String value){
     this.set(S_Ext170,value);
  }
  public  void setExt170Null(){
     this.set(S_Ext170,null);
  }

  public String getExt170(){
       return DataType.getAsString(this.get(S_Ext170));
  
  }
  public String getExt170InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext170));
      }

  public void initExt175(String value){
     this.initProperty(S_Ext175,value);
  }
  public  void setExt175(String value){
     this.set(S_Ext175,value);
  }
  public  void setExt175Null(){
     this.set(S_Ext175,null);
  }

  public String getExt175(){
       return DataType.getAsString(this.get(S_Ext175));
  
  }
  public String getExt175InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext175));
      }

  public void initExt176(String value){
     this.initProperty(S_Ext176,value);
  }
  public  void setExt176(String value){
     this.set(S_Ext176,value);
  }
  public  void setExt176Null(){
     this.set(S_Ext176,null);
  }

  public String getExt176(){
       return DataType.getAsString(this.get(S_Ext176));
  
  }
  public String getExt176InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext176));
      }

  public void initExt173(String value){
     this.initProperty(S_Ext173,value);
  }
  public  void setExt173(String value){
     this.set(S_Ext173,value);
  }
  public  void setExt173Null(){
     this.set(S_Ext173,null);
  }

  public String getExt173(){
       return DataType.getAsString(this.get(S_Ext173));
  
  }
  public String getExt173InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext173));
      }

  public void initExt29(String value){
     this.initProperty(S_Ext29,value);
  }
  public  void setExt29(String value){
     this.set(S_Ext29,value);
  }
  public  void setExt29Null(){
     this.set(S_Ext29,null);
  }

  public String getExt29(){
       return DataType.getAsString(this.get(S_Ext29));
  
  }
  public String getExt29InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext29));
      }

  public void initExt174(String value){
     this.initProperty(S_Ext174,value);
  }
  public  void setExt174(String value){
     this.set(S_Ext174,value);
  }
  public  void setExt174Null(){
     this.set(S_Ext174,null);
  }

  public String getExt174(){
       return DataType.getAsString(this.get(S_Ext174));
  
  }
  public String getExt174InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext174));
      }

  public void initExt27(String value){
     this.initProperty(S_Ext27,value);
  }
  public  void setExt27(String value){
     this.set(S_Ext27,value);
  }
  public  void setExt27Null(){
     this.set(S_Ext27,null);
  }

  public String getExt27(){
       return DataType.getAsString(this.get(S_Ext27));
  
  }
  public String getExt27InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext27));
      }

  public void initExt28(String value){
     this.initProperty(S_Ext28,value);
  }
  public  void setExt28(String value){
     this.set(S_Ext28,value);
  }
  public  void setExt28Null(){
     this.set(S_Ext28,null);
  }

  public String getExt28(){
       return DataType.getAsString(this.get(S_Ext28));
  
  }
  public String getExt28InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext28));
      }

  public void initExt25(String value){
     this.initProperty(S_Ext25,value);
  }
  public  void setExt25(String value){
     this.set(S_Ext25,value);
  }
  public  void setExt25Null(){
     this.set(S_Ext25,null);
  }

  public String getExt25(){
       return DataType.getAsString(this.get(S_Ext25));
  
  }
  public String getExt25InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext25));
      }

  public void initExt26(String value){
     this.initProperty(S_Ext26,value);
  }
  public  void setExt26(String value){
     this.set(S_Ext26,value);
  }
  public  void setExt26Null(){
     this.set(S_Ext26,null);
  }

  public String getExt26(){
       return DataType.getAsString(this.get(S_Ext26));
  
  }
  public String getExt26InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext26));
      }

  public void initExt23(String value){
     this.initProperty(S_Ext23,value);
  }
  public  void setExt23(String value){
     this.set(S_Ext23,value);
  }
  public  void setExt23Null(){
     this.set(S_Ext23,null);
  }

  public String getExt23(){
       return DataType.getAsString(this.get(S_Ext23));
  
  }
  public String getExt23InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext23));
      }

  public void initExt24(String value){
     this.initProperty(S_Ext24,value);
  }
  public  void setExt24(String value){
     this.set(S_Ext24,value);
  }
  public  void setExt24Null(){
     this.set(S_Ext24,null);
  }

  public String getExt24(){
       return DataType.getAsString(this.get(S_Ext24));
  
  }
  public String getExt24InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext24));
      }

  public void initExt21(String value){
     this.initProperty(S_Ext21,value);
  }
  public  void setExt21(String value){
     this.set(S_Ext21,value);
  }
  public  void setExt21Null(){
     this.set(S_Ext21,null);
  }

  public String getExt21(){
       return DataType.getAsString(this.get(S_Ext21));
  
  }
  public String getExt21InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext21));
      }

  public void initExt22(String value){
     this.initProperty(S_Ext22,value);
  }
  public  void setExt22(String value){
     this.set(S_Ext22,value);
  }
  public  void setExt22Null(){
     this.set(S_Ext22,null);
  }

  public String getExt22(){
       return DataType.getAsString(this.get(S_Ext22));
  
  }
  public String getExt22InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext22));
      }

  public void initExt40(String value){
     this.initProperty(S_Ext40,value);
  }
  public  void setExt40(String value){
     this.set(S_Ext40,value);
  }
  public  void setExt40Null(){
     this.set(S_Ext40,null);
  }

  public String getExt40(){
       return DataType.getAsString(this.get(S_Ext40));
  
  }
  public String getExt40InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext40));
      }

  public void initExt42(String value){
     this.initProperty(S_Ext42,value);
  }
  public  void setExt42(String value){
     this.set(S_Ext42,value);
  }
  public  void setExt42Null(){
     this.set(S_Ext42,null);
  }

  public String getExt42(){
       return DataType.getAsString(this.get(S_Ext42));
  
  }
  public String getExt42InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext42));
      }

  public void initExt41(String value){
     this.initProperty(S_Ext41,value);
  }
  public  void setExt41(String value){
     this.set(S_Ext41,value);
  }
  public  void setExt41Null(){
     this.set(S_Ext41,null);
  }

  public String getExt41(){
       return DataType.getAsString(this.get(S_Ext41));
  
  }
  public String getExt41InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext41));
      }

  public void initExt167(String value){
     this.initProperty(S_Ext167,value);
  }
  public  void setExt167(String value){
     this.set(S_Ext167,value);
  }
  public  void setExt167Null(){
     this.set(S_Ext167,null);
  }

  public String getExt167(){
       return DataType.getAsString(this.get(S_Ext167));
  
  }
  public String getExt167InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext167));
      }

  public void initExt166(String value){
     this.initProperty(S_Ext166,value);
  }
  public  void setExt166(String value){
     this.set(S_Ext166,value);
  }
  public  void setExt166Null(){
     this.set(S_Ext166,null);
  }

  public String getExt166(){
       return DataType.getAsString(this.get(S_Ext166));
  
  }
  public String getExt166InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext166));
      }

  public void initExt169(String value){
     this.initProperty(S_Ext169,value);
  }
  public  void setExt169(String value){
     this.set(S_Ext169,value);
  }
  public  void setExt169Null(){
     this.set(S_Ext169,null);
  }

  public String getExt169(){
       return DataType.getAsString(this.get(S_Ext169));
  
  }
  public String getExt169InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext169));
      }

  public void initExt168(String value){
     this.initProperty(S_Ext168,value);
  }
  public  void setExt168(String value){
     this.set(S_Ext168,value);
  }
  public  void setExt168Null(){
     this.set(S_Ext168,null);
  }

  public String getExt168(){
       return DataType.getAsString(this.get(S_Ext168));
  
  }
  public String getExt168InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext168));
      }

  public void initExt160(String value){
     this.initProperty(S_Ext160,value);
  }
  public  void setExt160(String value){
     this.set(S_Ext160,value);
  }
  public  void setExt160Null(){
     this.set(S_Ext160,null);
  }

  public String getExt160(){
       return DataType.getAsString(this.get(S_Ext160));
  
  }
  public String getExt160InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext160));
      }

  public void initStaffId(String value){
     this.initProperty(S_StaffId,value);
  }
  public  void setStaffId(String value){
     this.set(S_StaffId,value);
  }
  public  void setStaffIdNull(){
     this.set(S_StaffId,null);
  }

  public String getStaffId(){
       return DataType.getAsString(this.get(S_StaffId));
  
  }
  public String getStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StaffId));
      }

  public void initExt161(String value){
     this.initProperty(S_Ext161,value);
  }
  public  void setExt161(String value){
     this.set(S_Ext161,value);
  }
  public  void setExt161Null(){
     this.set(S_Ext161,null);
  }

  public String getExt161(){
       return DataType.getAsString(this.get(S_Ext161));
  
  }
  public String getExt161InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext161));
      }

  public void initExt162(String value){
     this.initProperty(S_Ext162,value);
  }
  public  void setExt162(String value){
     this.set(S_Ext162,value);
  }
  public  void setExt162Null(){
     this.set(S_Ext162,null);
  }

  public String getExt162(){
       return DataType.getAsString(this.get(S_Ext162));
  
  }
  public String getExt162InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext162));
      }

  public void initExt163(String value){
     this.initProperty(S_Ext163,value);
  }
  public  void setExt163(String value){
     this.set(S_Ext163,value);
  }
  public  void setExt163Null(){
     this.set(S_Ext163,null);
  }

  public String getExt163(){
       return DataType.getAsString(this.get(S_Ext163));
  
  }
  public String getExt163InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext163));
      }

  public void initExt164(String value){
     this.initProperty(S_Ext164,value);
  }
  public  void setExt164(String value){
     this.set(S_Ext164,value);
  }
  public  void setExt164Null(){
     this.set(S_Ext164,null);
  }

  public String getExt164(){
       return DataType.getAsString(this.get(S_Ext164));
  
  }
  public String getExt164InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext164));
      }

  public void initExt165(String value){
     this.initProperty(S_Ext165,value);
  }
  public  void setExt165(String value){
     this.set(S_Ext165,value);
  }
  public  void setExt165Null(){
     this.set(S_Ext165,null);
  }

  public String getExt165(){
       return DataType.getAsString(this.get(S_Ext165));
  
  }
  public String getExt165InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext165));
      }

  public void initExt36(String value){
     this.initProperty(S_Ext36,value);
  }
  public  void setExt36(String value){
     this.set(S_Ext36,value);
  }
  public  void setExt36Null(){
     this.set(S_Ext36,null);
  }

  public String getExt36(){
       return DataType.getAsString(this.get(S_Ext36));
  
  }
  public String getExt36InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext36));
      }

  public void initExt37(String value){
     this.initProperty(S_Ext37,value);
  }
  public  void setExt37(String value){
     this.set(S_Ext37,value);
  }
  public  void setExt37Null(){
     this.set(S_Ext37,null);
  }

  public String getExt37(){
       return DataType.getAsString(this.get(S_Ext37));
  
  }
  public String getExt37InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext37));
      }

  public void initExt38(String value){
     this.initProperty(S_Ext38,value);
  }
  public  void setExt38(String value){
     this.set(S_Ext38,value);
  }
  public  void setExt38Null(){
     this.set(S_Ext38,null);
  }

  public String getExt38(){
       return DataType.getAsString(this.get(S_Ext38));
  
  }
  public String getExt38InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext38));
      }

  public void initExt39(String value){
     this.initProperty(S_Ext39,value);
  }
  public  void setExt39(String value){
     this.set(S_Ext39,value);
  }
  public  void setExt39Null(){
     this.set(S_Ext39,null);
  }

  public String getExt39(){
       return DataType.getAsString(this.get(S_Ext39));
  
  }
  public String getExt39InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext39));
      }

  public void initExt32(String value){
     this.initProperty(S_Ext32,value);
  }
  public  void setExt32(String value){
     this.set(S_Ext32,value);
  }
  public  void setExt32Null(){
     this.set(S_Ext32,null);
  }

  public String getExt32(){
       return DataType.getAsString(this.get(S_Ext32));
  
  }
  public String getExt32InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext32));
      }

  public void initExt33(String value){
     this.initProperty(S_Ext33,value);
  }
  public  void setExt33(String value){
     this.set(S_Ext33,value);
  }
  public  void setExt33Null(){
     this.set(S_Ext33,null);
  }

  public String getExt33(){
       return DataType.getAsString(this.get(S_Ext33));
  
  }
  public String getExt33InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext33));
      }

  public void initExt34(String value){
     this.initProperty(S_Ext34,value);
  }
  public  void setExt34(String value){
     this.set(S_Ext34,value);
  }
  public  void setExt34Null(){
     this.set(S_Ext34,null);
  }

  public String getExt34(){
       return DataType.getAsString(this.get(S_Ext34));
  
  }
  public String getExt34InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext34));
      }

  public void initExt35(String value){
     this.initProperty(S_Ext35,value);
  }
  public  void setExt35(String value){
     this.set(S_Ext35,value);
  }
  public  void setExt35Null(){
     this.set(S_Ext35,null);
  }

  public String getExt35(){
       return DataType.getAsString(this.get(S_Ext35));
  
  }
  public String getExt35InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext35));
      }

  public void initExt92(String value){
     this.initProperty(S_Ext92,value);
  }
  public  void setExt92(String value){
     this.set(S_Ext92,value);
  }
  public  void setExt92Null(){
     this.set(S_Ext92,null);
  }

  public String getExt92(){
       return DataType.getAsString(this.get(S_Ext92));
  
  }
  public String getExt92InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext92));
      }

  public void initExt93(String value){
     this.initProperty(S_Ext93,value);
  }
  public  void setExt93(String value){
     this.set(S_Ext93,value);
  }
  public  void setExt93Null(){
     this.set(S_Ext93,null);
  }

  public String getExt93(){
       return DataType.getAsString(this.get(S_Ext93));
  
  }
  public String getExt93InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext93));
      }

  public void initExt90(String value){
     this.initProperty(S_Ext90,value);
  }
  public  void setExt90(String value){
     this.set(S_Ext90,value);
  }
  public  void setExt90Null(){
     this.set(S_Ext90,null);
  }

  public String getExt90(){
       return DataType.getAsString(this.get(S_Ext90));
  
  }
  public String getExt90InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext90));
      }

  public void initExt91(String value){
     this.initProperty(S_Ext91,value);
  }
  public  void setExt91(String value){
     this.set(S_Ext91,value);
  }
  public  void setExt91Null(){
     this.set(S_Ext91,null);
  }

  public String getExt91(){
       return DataType.getAsString(this.get(S_Ext91));
  
  }
  public String getExt91InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext91));
      }

  public void initExt96(String value){
     this.initProperty(S_Ext96,value);
  }
  public  void setExt96(String value){
     this.set(S_Ext96,value);
  }
  public  void setExt96Null(){
     this.set(S_Ext96,null);
  }

  public String getExt96(){
       return DataType.getAsString(this.get(S_Ext96));
  
  }
  public String getExt96InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext96));
      }

  public void initExt97(String value){
     this.initProperty(S_Ext97,value);
  }
  public  void setExt97(String value){
     this.set(S_Ext97,value);
  }
  public  void setExt97Null(){
     this.set(S_Ext97,null);
  }

  public String getExt97(){
       return DataType.getAsString(this.get(S_Ext97));
  
  }
  public String getExt97InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext97));
      }

  public void initExt94(String value){
     this.initProperty(S_Ext94,value);
  }
  public  void setExt94(String value){
     this.set(S_Ext94,value);
  }
  public  void setExt94Null(){
     this.set(S_Ext94,null);
  }

  public String getExt94(){
       return DataType.getAsString(this.get(S_Ext94));
  
  }
  public String getExt94InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext94));
      }

  public void initCaseid(String value){
     this.initProperty(S_Caseid,value);
  }
  public  void setCaseid(String value){
     this.set(S_Caseid,value);
  }
  public  void setCaseidNull(){
     this.set(S_Caseid,null);
  }

  public String getCaseid(){
       return DataType.getAsString(this.get(S_Caseid));
  
  }
  public String getCaseidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Caseid));
      }

  public void initModifyDate(Timestamp value){
     this.initProperty(S_ModifyDate,value);
  }
  public  void setModifyDate(Timestamp value){
     this.set(S_ModifyDate,value);
  }
  public  void setModifyDateNull(){
     this.set(S_ModifyDate,null);
  }

  public Timestamp getModifyDate(){
        return DataType.getAsDateTime(this.get(S_ModifyDate));
  
  }
  public Timestamp getModifyDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyDate));
      }

  public void initExt95(String value){
     this.initProperty(S_Ext95,value);
  }
  public  void setExt95(String value){
     this.set(S_Ext95,value);
  }
  public  void setExt95Null(){
     this.set(S_Ext95,null);
  }

  public String getExt95(){
       return DataType.getAsString(this.get(S_Ext95));
  
  }
  public String getExt95InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext95));
      }

  public void initExt89(String value){
     this.initProperty(S_Ext89,value);
  }
  public  void setExt89(String value){
     this.set(S_Ext89,value);
  }
  public  void setExt89Null(){
     this.set(S_Ext89,null);
  }

  public String getExt89(){
       return DataType.getAsString(this.get(S_Ext89));
  
  }
  public String getExt89InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext89));
      }

  public void initExt88(String value){
     this.initProperty(S_Ext88,value);
  }
  public  void setExt88(String value){
     this.set(S_Ext88,value);
  }
  public  void setExt88Null(){
     this.set(S_Ext88,null);
  }

  public String getExt88(){
       return DataType.getAsString(this.get(S_Ext88));
  
  }
  public String getExt88InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext88));
      }

  public void initExt87(String value){
     this.initProperty(S_Ext87,value);
  }
  public  void setExt87(String value){
     this.set(S_Ext87,value);
  }
  public  void setExt87Null(){
     this.set(S_Ext87,null);
  }

  public String getExt87(){
       return DataType.getAsString(this.get(S_Ext87));
  
  }
  public String getExt87InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext87));
      }

  public void initExt99(String value){
     this.initProperty(S_Ext99,value);
  }
  public  void setExt99(String value){
     this.set(S_Ext99,value);
  }
  public  void setExt99Null(){
     this.set(S_Ext99,null);
  }

  public String getExt99(){
       return DataType.getAsString(this.get(S_Ext99));
  
  }
  public String getExt99InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext99));
      }

  public void initExt98(String value){
     this.initProperty(S_Ext98,value);
  }
  public  void setExt98(String value){
     this.set(S_Ext98,value);
  }
  public  void setExt98Null(){
     this.set(S_Ext98,null);
  }

  public String getExt98(){
       return DataType.getAsString(this.get(S_Ext98));
  
  }
  public String getExt98InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext98));
      }

  public void initExt74(String value){
     this.initProperty(S_Ext74,value);
  }
  public  void setExt74(String value){
     this.set(S_Ext74,value);
  }
  public  void setExt74Null(){
     this.set(S_Ext74,null);
  }

  public String getExt74(){
       return DataType.getAsString(this.get(S_Ext74));
  
  }
  public String getExt74InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext74));
      }

  public void initExt75(String value){
     this.initProperty(S_Ext75,value);
  }
  public  void setExt75(String value){
     this.set(S_Ext75,value);
  }
  public  void setExt75Null(){
     this.set(S_Ext75,null);
  }

  public String getExt75(){
       return DataType.getAsString(this.get(S_Ext75));
  
  }
  public String getExt75InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext75));
      }

  public void initExt72(String value){
     this.initProperty(S_Ext72,value);
  }
  public  void setExt72(String value){
     this.set(S_Ext72,value);
  }
  public  void setExt72Null(){
     this.set(S_Ext72,null);
  }

  public String getExt72(){
       return DataType.getAsString(this.get(S_Ext72));
  
  }
  public String getExt72InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext72));
      }

  public void initExt73(String value){
     this.initProperty(S_Ext73,value);
  }
  public  void setExt73(String value){
     this.set(S_Ext73,value);
  }
  public  void setExt73Null(){
     this.set(S_Ext73,null);
  }

  public String getExt73(){
       return DataType.getAsString(this.get(S_Ext73));
  
  }
  public String getExt73InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext73));
      }

  public void initExt70(String value){
     this.initProperty(S_Ext70,value);
  }
  public  void setExt70(String value){
     this.set(S_Ext70,value);
  }
  public  void setExt70Null(){
     this.set(S_Ext70,null);
  }

  public String getExt70(){
       return DataType.getAsString(this.get(S_Ext70));
  
  }
  public String getExt70InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext70));
      }

  public void initMid(String value){
     this.initProperty(S_Mid,value);
  }
  public  void setMid(String value){
     this.set(S_Mid,value);
  }
  public  void setMidNull(){
     this.set(S_Mid,null);
  }

  public String getMid(){
       return DataType.getAsString(this.get(S_Mid));
  
  }
  public String getMidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Mid));
      }

  public void initExt71(String value){
     this.initProperty(S_Ext71,value);
  }
  public  void setExt71(String value){
     this.set(S_Ext71,value);
  }
  public  void setExt71Null(){
     this.set(S_Ext71,null);
  }

  public String getExt71(){
       return DataType.getAsString(this.get(S_Ext71));
  
  }
  public String getExt71InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext71));
      }

  public void initExt69(String value){
     this.initProperty(S_Ext69,value);
  }
  public  void setExt69(String value){
     this.set(S_Ext69,value);
  }
  public  void setExt69Null(){
     this.set(S_Ext69,null);
  }

  public String getExt69(){
       return DataType.getAsString(this.get(S_Ext69));
  
  }
  public String getExt69InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext69));
      }

  public void initExt68(String value){
     this.initProperty(S_Ext68,value);
  }
  public  void setExt68(String value){
     this.set(S_Ext68,value);
  }
  public  void setExt68Null(){
     this.set(S_Ext68,null);
  }

  public String getExt68(){
       return DataType.getAsString(this.get(S_Ext68));
  
  }
  public String getExt68InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext68));
      }

  public void initExt67(String value){
     this.initProperty(S_Ext67,value);
  }
  public  void setExt67(String value){
     this.set(S_Ext67,value);
  }
  public  void setExt67Null(){
     this.set(S_Ext67,null);
  }

  public String getExt67(){
       return DataType.getAsString(this.get(S_Ext67));
  
  }
  public String getExt67InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext67));
      }

  public void initExt66(String value){
     this.initProperty(S_Ext66,value);
  }
  public  void setExt66(String value){
     this.set(S_Ext66,value);
  }
  public  void setExt66Null(){
     this.set(S_Ext66,null);
  }

  public String getExt66(){
       return DataType.getAsString(this.get(S_Ext66));
  
  }
  public String getExt66InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext66));
      }

  public void initExt65(String value){
     this.initProperty(S_Ext65,value);
  }
  public  void setExt65(String value){
     this.set(S_Ext65,value);
  }
  public  void setExt65Null(){
     this.set(S_Ext65,null);
  }

  public String getExt65(){
       return DataType.getAsString(this.get(S_Ext65));
  
  }
  public String getExt65InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext65));
      }

  public void initApplyId(String value){
     this.initProperty(S_ApplyId,value);
  }
  public  void setApplyId(String value){
     this.set(S_ApplyId,value);
  }
  public  void setApplyIdNull(){
     this.set(S_ApplyId,null);
  }

  public String getApplyId(){
       return DataType.getAsString(this.get(S_ApplyId));
  
  }
  public String getApplyIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ApplyId));
      }

  public void initExt83(String value){
     this.initProperty(S_Ext83,value);
  }
  public  void setExt83(String value){
     this.set(S_Ext83,value);
  }
  public  void setExt83Null(){
     this.set(S_Ext83,null);
  }

  public String getExt83(){
       return DataType.getAsString(this.get(S_Ext83));
  
  }
  public String getExt83InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext83));
      }

  public void initExt84(String value){
     this.initProperty(S_Ext84,value);
  }
  public  void setExt84(String value){
     this.set(S_Ext84,value);
  }
  public  void setExt84Null(){
     this.set(S_Ext84,null);
  }

  public String getExt84(){
       return DataType.getAsString(this.get(S_Ext84));
  
  }
  public String getExt84InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext84));
      }

  public void initExt85(String value){
     this.initProperty(S_Ext85,value);
  }
  public  void setExt85(String value){
     this.set(S_Ext85,value);
  }
  public  void setExt85Null(){
     this.set(S_Ext85,null);
  }

  public String getExt85(){
       return DataType.getAsString(this.get(S_Ext85));
  
  }
  public String getExt85InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext85));
      }

  public void initExt86(String value){
     this.initProperty(S_Ext86,value);
  }
  public  void setExt86(String value){
     this.set(S_Ext86,value);
  }
  public  void setExt86Null(){
     this.set(S_Ext86,null);
  }

  public String getExt86(){
       return DataType.getAsString(this.get(S_Ext86));
  
  }
  public String getExt86InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext86));
      }

  public void initPrivType(String value){
     this.initProperty(S_PrivType,value);
  }
  public  void setPrivType(String value){
     this.set(S_PrivType,value);
  }
  public  void setPrivTypeNull(){
     this.set(S_PrivType,null);
  }

  public String getPrivType(){
       return DataType.getAsString(this.get(S_PrivType));
  
  }
  public String getPrivTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PrivType));
      }

  public void initExt80(String value){
     this.initProperty(S_Ext80,value);
  }
  public  void setExt80(String value){
     this.set(S_Ext80,value);
  }
  public  void setExt80Null(){
     this.set(S_Ext80,null);
  }

  public String getExt80(){
       return DataType.getAsString(this.get(S_Ext80));
  
  }
  public String getExt80InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext80));
      }

  public void initExt81(String value){
     this.initProperty(S_Ext81,value);
  }
  public  void setExt81(String value){
     this.set(S_Ext81,value);
  }
  public  void setExt81Null(){
     this.set(S_Ext81,null);
  }

  public String getExt81(){
       return DataType.getAsString(this.get(S_Ext81));
  
  }
  public String getExt81InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext81));
      }

  public void initExt82(String value){
     this.initProperty(S_Ext82,value);
  }
  public  void setExt82(String value){
     this.set(S_Ext82,value);
  }
  public  void setExt82Null(){
     this.set(S_Ext82,null);
  }

  public String getExt82(){
       return DataType.getAsString(this.get(S_Ext82));
  
  }
  public String getExt82InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext82));
      }

  public void initExt77(String value){
     this.initProperty(S_Ext77,value);
  }
  public  void setExt77(String value){
     this.set(S_Ext77,value);
  }
  public  void setExt77Null(){
     this.set(S_Ext77,null);
  }

  public String getExt77(){
       return DataType.getAsString(this.get(S_Ext77));
  
  }
  public String getExt77InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext77));
      }

  public void initExt76(String value){
     this.initProperty(S_Ext76,value);
  }
  public  void setExt76(String value){
     this.set(S_Ext76,value);
  }
  public  void setExt76Null(){
     this.set(S_Ext76,null);
  }

  public String getExt76(){
       return DataType.getAsString(this.get(S_Ext76));
  
  }
  public String getExt76InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext76));
      }

  public void initExt79(String value){
     this.initProperty(S_Ext79,value);
  }
  public  void setExt79(String value){
     this.set(S_Ext79,value);
  }
  public  void setExt79Null(){
     this.set(S_Ext79,null);
  }

  public String getExt79(){
       return DataType.getAsString(this.get(S_Ext79));
  
  }
  public String getExt79InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext79));
      }

  public void initExt78(String value){
     this.initProperty(S_Ext78,value);
  }
  public  void setExt78(String value){
     this.set(S_Ext78,value);
  }
  public  void setExt78Null(){
     this.set(S_Ext78,null);
  }

  public String getExt78(){
       return DataType.getAsString(this.get(S_Ext78));
  
  }
  public String getExt78InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext78));
      }

  public void initExt110(String value){
     this.initProperty(S_Ext110,value);
  }
  public  void setExt110(String value){
     this.set(S_Ext110,value);
  }
  public  void setExt110Null(){
     this.set(S_Ext110,null);
  }

  public String getExt110(){
       return DataType.getAsString(this.get(S_Ext110));
  
  }
  public String getExt110InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext110));
      }

  public void initExt119(String value){
     this.initProperty(S_Ext119,value);
  }
  public  void setExt119(String value){
     this.set(S_Ext119,value);
  }
  public  void setExt119Null(){
     this.set(S_Ext119,null);
  }

  public String getExt119(){
       return DataType.getAsString(this.get(S_Ext119));
  
  }
  public String getExt119InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext119));
      }

  public void initExt116(String value){
     this.initProperty(S_Ext116,value);
  }
  public  void setExt116(String value){
     this.set(S_Ext116,value);
  }
  public  void setExt116Null(){
     this.set(S_Ext116,null);
  }

  public String getExt116(){
       return DataType.getAsString(this.get(S_Ext116));
  
  }
  public String getExt116InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext116));
      }

  public void initExt115(String value){
     this.initProperty(S_Ext115,value);
  }
  public  void setExt115(String value){
     this.set(S_Ext115,value);
  }
  public  void setExt115Null(){
     this.set(S_Ext115,null);
  }

  public String getExt115(){
       return DataType.getAsString(this.get(S_Ext115));
  
  }
  public String getExt115InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext115));
      }

  public void initExt118(String value){
     this.initProperty(S_Ext118,value);
  }
  public  void setExt118(String value){
     this.set(S_Ext118,value);
  }
  public  void setExt118Null(){
     this.set(S_Ext118,null);
  }

  public String getExt118(){
       return DataType.getAsString(this.get(S_Ext118));
  
  }
  public String getExt118InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext118));
      }

  public void initExt117(String value){
     this.initProperty(S_Ext117,value);
  }
  public  void setExt117(String value){
     this.set(S_Ext117,value);
  }
  public  void setExt117Null(){
     this.set(S_Ext117,null);
  }

  public String getExt117(){
       return DataType.getAsString(this.get(S_Ext117));
  
  }
  public String getExt117InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext117));
      }

  public void initExt112(String value){
     this.initProperty(S_Ext112,value);
  }
  public  void setExt112(String value){
     this.set(S_Ext112,value);
  }
  public  void setExt112Null(){
     this.set(S_Ext112,null);
  }

  public String getExt112(){
       return DataType.getAsString(this.get(S_Ext112));
  
  }
  public String getExt112InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext112));
      }

  public void initExt111(String value){
     this.initProperty(S_Ext111,value);
  }
  public  void setExt111(String value){
     this.set(S_Ext111,value);
  }
  public  void setExt111Null(){
     this.set(S_Ext111,null);
  }

  public String getExt111(){
       return DataType.getAsString(this.get(S_Ext111));
  
  }
  public String getExt111InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext111));
      }

  public void initExt114(String value){
     this.initProperty(S_Ext114,value);
  }
  public  void setExt114(String value){
     this.set(S_Ext114,value);
  }
  public  void setExt114Null(){
     this.set(S_Ext114,null);
  }

  public String getExt114(){
       return DataType.getAsString(this.get(S_Ext114));
  
  }
  public String getExt114InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext114));
      }

  public void initExt113(String value){
     this.initProperty(S_Ext113,value);
  }
  public  void setExt113(String value){
     this.set(S_Ext113,value);
  }
  public  void setExt113Null(){
     this.set(S_Ext113,null);
  }

  public String getExt113(){
       return DataType.getAsString(this.get(S_Ext113));
  
  }
  public String getExt113InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext113));
      }

  public void initExt245(String value){
     this.initProperty(S_Ext245,value);
  }
  public  void setExt245(String value){
     this.set(S_Ext245,value);
  }
  public  void setExt245Null(){
     this.set(S_Ext245,null);
  }

  public String getExt245(){
       return DataType.getAsString(this.get(S_Ext245));
  
  }
  public String getExt245InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext245));
      }

  public void initExt246(String value){
     this.initProperty(S_Ext246,value);
  }
  public  void setExt246(String value){
     this.set(S_Ext246,value);
  }
  public  void setExt246Null(){
     this.set(S_Ext246,null);
  }

  public String getExt246(){
       return DataType.getAsString(this.get(S_Ext246));
  
  }
  public String getExt246InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext246));
      }

  public void initExt243(String value){
     this.initProperty(S_Ext243,value);
  }
  public  void setExt243(String value){
     this.set(S_Ext243,value);
  }
  public  void setExt243Null(){
     this.set(S_Ext243,null);
  }

  public String getExt243(){
       return DataType.getAsString(this.get(S_Ext243));
  
  }
  public String getExt243InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext243));
      }

  public void initExt244(String value){
     this.initProperty(S_Ext244,value);
  }
  public  void setExt244(String value){
     this.set(S_Ext244,value);
  }
  public  void setExt244Null(){
     this.set(S_Ext244,null);
  }

  public String getExt244(){
       return DataType.getAsString(this.get(S_Ext244));
  
  }
  public String getExt244InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext244));
      }

  public void initExt242(String value){
     this.initProperty(S_Ext242,value);
  }
  public  void setExt242(String value){
     this.set(S_Ext242,value);
  }
  public  void setExt242Null(){
     this.set(S_Ext242,null);
  }

  public String getExt242(){
       return DataType.getAsString(this.get(S_Ext242));
  
  }
  public String getExt242InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext242));
      }

  public void initExt241(String value){
     this.initProperty(S_Ext241,value);
  }
  public  void setExt241(String value){
     this.set(S_Ext241,value);
  }
  public  void setExt241Null(){
     this.set(S_Ext241,null);
  }

  public String getExt241(){
       return DataType.getAsString(this.get(S_Ext241));
  
  }
  public String getExt241InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext241));
      }

  public void initExt109(String value){
     this.initProperty(S_Ext109,value);
  }
  public  void setExt109(String value){
     this.set(S_Ext109,value);
  }
  public  void setExt109Null(){
     this.set(S_Ext109,null);
  }

  public String getExt109(){
       return DataType.getAsString(this.get(S_Ext109));
  
  }
  public String getExt109InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext109));
      }

  public void initExt240(String value){
     this.initProperty(S_Ext240,value);
  }
  public  void setExt240(String value){
     this.set(S_Ext240,value);
  }
  public  void setExt240Null(){
     this.set(S_Ext240,null);
  }

  public String getExt240(){
       return DataType.getAsString(this.get(S_Ext240));
  
  }
  public String getExt240InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext240));
      }

  public void initExt108(String value){
     this.initProperty(S_Ext108,value);
  }
  public  void setExt108(String value){
     this.set(S_Ext108,value);
  }
  public  void setExt108Null(){
     this.set(S_Ext108,null);
  }

  public String getExt108(){
       return DataType.getAsString(this.get(S_Ext108));
  
  }
  public String getExt108InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext108));
      }

  public void initExt107(String value){
     this.initProperty(S_Ext107,value);
  }
  public  void setExt107(String value){
     this.set(S_Ext107,value);
  }
  public  void setExt107Null(){
     this.set(S_Ext107,null);
  }

  public String getExt107(){
       return DataType.getAsString(this.get(S_Ext107));
  
  }
  public String getExt107InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext107));
      }

  public void initExt106(String value){
     this.initProperty(S_Ext106,value);
  }
  public  void setExt106(String value){
     this.set(S_Ext106,value);
  }
  public  void setExt106Null(){
     this.set(S_Ext106,null);
  }

  public String getExt106(){
       return DataType.getAsString(this.get(S_Ext106));
  
  }
  public String getExt106InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext106));
      }

  public void initExt105(String value){
     this.initProperty(S_Ext105,value);
  }
  public  void setExt105(String value){
     this.set(S_Ext105,value);
  }
  public  void setExt105Null(){
     this.set(S_Ext105,null);
  }

  public String getExt105(){
       return DataType.getAsString(this.get(S_Ext105));
  
  }
  public String getExt105InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext105));
      }

  public void initExt104(String value){
     this.initProperty(S_Ext104,value);
  }
  public  void setExt104(String value){
     this.set(S_Ext104,value);
  }
  public  void setExt104Null(){
     this.set(S_Ext104,null);
  }

  public String getExt104(){
       return DataType.getAsString(this.get(S_Ext104));
  
  }
  public String getExt104InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext104));
      }

  public void initExt103(String value){
     this.initProperty(S_Ext103,value);
  }
  public  void setExt103(String value){
     this.set(S_Ext103,value);
  }
  public  void setExt103Null(){
     this.set(S_Ext103,null);
  }

  public String getExt103(){
       return DataType.getAsString(this.get(S_Ext103));
  
  }
  public String getExt103InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext103));
      }

  public void initExt102(String value){
     this.initProperty(S_Ext102,value);
  }
  public  void setExt102(String value){
     this.set(S_Ext102,value);
  }
  public  void setExt102Null(){
     this.set(S_Ext102,null);
  }

  public String getExt102(){
       return DataType.getAsString(this.get(S_Ext102));
  
  }
  public String getExt102InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext102));
      }

  public void initExt101(String value){
     this.initProperty(S_Ext101,value);
  }
  public  void setExt101(String value){
     this.set(S_Ext101,value);
  }
  public  void setExt101Null(){
     this.set(S_Ext101,null);
  }

  public String getExt101(){
       return DataType.getAsString(this.get(S_Ext101));
  
  }
  public String getExt101InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext101));
      }

  public void initExt100(String value){
     this.initProperty(S_Ext100,value);
  }
  public  void setExt100(String value){
     this.set(S_Ext100,value);
  }
  public  void setExt100Null(){
     this.set(S_Ext100,null);
  }

  public String getExt100(){
       return DataType.getAsString(this.get(S_Ext100));
  
  }
  public String getExt100InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext100));
      }

  public void initExt20(String value){
     this.initProperty(S_Ext20,value);
  }
  public  void setExt20(String value){
     this.set(S_Ext20,value);
  }
  public  void setExt20Null(){
     this.set(S_Ext20,null);
  }

  public String getExt20(){
       return DataType.getAsString(this.get(S_Ext20));
  
  }
  public String getExt20InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext20));
      }

  public void initExt19(String value){
     this.initProperty(S_Ext19,value);
  }
  public  void setExt19(String value){
     this.set(S_Ext19,value);
  }
  public  void setExt19Null(){
     this.set(S_Ext19,null);
  }

  public String getExt19(){
       return DataType.getAsString(this.get(S_Ext19));
  
  }
  public String getExt19InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext19));
      }

  public void initExt18(String value){
     this.initProperty(S_Ext18,value);
  }
  public  void setExt18(String value){
     this.set(S_Ext18,value);
  }
  public  void setExt18Null(){
     this.set(S_Ext18,null);
  }

  public String getExt18(){
       return DataType.getAsString(this.get(S_Ext18));
  
  }
  public String getExt18InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext18));
      }

  public void initExt17(String value){
     this.initProperty(S_Ext17,value);
  }
  public  void setExt17(String value){
     this.set(S_Ext17,value);
  }
  public  void setExt17Null(){
     this.set(S_Ext17,null);
  }

  public String getExt17(){
       return DataType.getAsString(this.get(S_Ext17));
  
  }
  public String getExt17InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext17));
      }

  public void initExt16(String value){
     this.initProperty(S_Ext16,value);
  }
  public  void setExt16(String value){
     this.set(S_Ext16,value);
  }
  public  void setExt16Null(){
     this.set(S_Ext16,null);
  }

  public String getExt16(){
       return DataType.getAsString(this.get(S_Ext16));
  
  }
  public String getExt16InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext16));
      }

  public void initExt15(String value){
     this.initProperty(S_Ext15,value);
  }
  public  void setExt15(String value){
     this.set(S_Ext15,value);
  }
  public  void setExt15Null(){
     this.set(S_Ext15,null);
  }

  public String getExt15(){
       return DataType.getAsString(this.get(S_Ext15));
  
  }
  public String getExt15InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext15));
      }

  public void initExt14(String value){
     this.initProperty(S_Ext14,value);
  }
  public  void setExt14(String value){
     this.set(S_Ext14,value);
  }
  public  void setExt14Null(){
     this.set(S_Ext14,null);
  }

  public String getExt14(){
       return DataType.getAsString(this.get(S_Ext14));
  
  }
  public String getExt14InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext14));
      }

  public void initExt13(String value){
     this.initProperty(S_Ext13,value);
  }
  public  void setExt13(String value){
     this.set(S_Ext13,value);
  }
  public  void setExt13Null(){
     this.set(S_Ext13,null);
  }

  public String getExt13(){
       return DataType.getAsString(this.get(S_Ext13));
  
  }
  public String getExt13InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext13));
      }

  public void initExt12(String value){
     this.initProperty(S_Ext12,value);
  }
  public  void setExt12(String value){
     this.set(S_Ext12,value);
  }
  public  void setExt12Null(){
     this.set(S_Ext12,null);
  }

  public String getExt12(){
       return DataType.getAsString(this.get(S_Ext12));
  
  }
  public String getExt12InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext12));
      }

  public void initExt11(String value){
     this.initProperty(S_Ext11,value);
  }
  public  void setExt11(String value){
     this.set(S_Ext11,value);
  }
  public  void setExt11Null(){
     this.set(S_Ext11,null);
  }

  public String getExt11(){
       return DataType.getAsString(this.get(S_Ext11));
  
  }
  public String getExt11InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext11));
      }

  public void initExt10(String value){
     this.initProperty(S_Ext10,value);
  }
  public  void setExt10(String value){
     this.set(S_Ext10,value);
  }
  public  void setExt10Null(){
     this.set(S_Ext10,null);
  }

  public String getExt10(){
       return DataType.getAsString(this.get(S_Ext10));
  
  }
  public String getExt10InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext10));
      }

  public void initExt211(String value){
     this.initProperty(S_Ext211,value);
  }
  public  void setExt211(String value){
     this.set(S_Ext211,value);
  }
  public  void setExt211Null(){
     this.set(S_Ext211,null);
  }

  public String getExt211(){
       return DataType.getAsString(this.get(S_Ext211));
  
  }
  public String getExt211InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext211));
      }

  public void initExt210(String value){
     this.initProperty(S_Ext210,value);
  }
  public  void setExt210(String value){
     this.set(S_Ext210,value);
  }
  public  void setExt210Null(){
     this.set(S_Ext210,null);
  }

  public String getExt210(){
       return DataType.getAsString(this.get(S_Ext210));
  
  }
  public String getExt210InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext210));
      }

  public void initExt213(String value){
     this.initProperty(S_Ext213,value);
  }
  public  void setExt213(String value){
     this.set(S_Ext213,value);
  }
  public  void setExt213Null(){
     this.set(S_Ext213,null);
  }

  public String getExt213(){
       return DataType.getAsString(this.get(S_Ext213));
  
  }
  public String getExt213InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext213));
      }

  public void initExt212(String value){
     this.initProperty(S_Ext212,value);
  }
  public  void setExt212(String value){
     this.set(S_Ext212,value);
  }
  public  void setExt212Null(){
     this.set(S_Ext212,null);
  }

  public String getExt212(){
       return DataType.getAsString(this.get(S_Ext212));
  
  }
  public String getExt212InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext212));
      }

  public void initExt215(String value){
     this.initProperty(S_Ext215,value);
  }
  public  void setExt215(String value){
     this.set(S_Ext215,value);
  }
  public  void setExt215Null(){
     this.set(S_Ext215,null);
  }

  public String getExt215(){
       return DataType.getAsString(this.get(S_Ext215));
  
  }
  public String getExt215InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext215));
      }

  public void initExt214(String value){
     this.initProperty(S_Ext214,value);
  }
  public  void setExt214(String value){
     this.set(S_Ext214,value);
  }
  public  void setExt214Null(){
     this.set(S_Ext214,null);
  }

  public String getExt214(){
       return DataType.getAsString(this.get(S_Ext214));
  
  }
  public String getExt214InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext214));
      }

  public void initExt217(String value){
     this.initProperty(S_Ext217,value);
  }
  public  void setExt217(String value){
     this.set(S_Ext217,value);
  }
  public  void setExt217Null(){
     this.set(S_Ext217,null);
  }

  public String getExt217(){
       return DataType.getAsString(this.get(S_Ext217));
  
  }
  public String getExt217InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext217));
      }

  public void initExt216(String value){
     this.initProperty(S_Ext216,value);
  }
  public  void setExt216(String value){
     this.set(S_Ext216,value);
  }
  public  void setExt216Null(){
     this.set(S_Ext216,null);
  }

  public String getExt216(){
       return DataType.getAsString(this.get(S_Ext216));
  
  }
  public String getExt216InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext216));
      }

  public void initExt152(String value){
     this.initProperty(S_Ext152,value);
  }
  public  void setExt152(String value){
     this.set(S_Ext152,value);
  }
  public  void setExt152Null(){
     this.set(S_Ext152,null);
  }

  public String getExt152(){
       return DataType.getAsString(this.get(S_Ext152));
  
  }
  public String getExt152InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext152));
      }

  public void initExt219(String value){
     this.initProperty(S_Ext219,value);
  }
  public  void setExt219(String value){
     this.set(S_Ext219,value);
  }
  public  void setExt219Null(){
     this.set(S_Ext219,null);
  }

  public String getExt219(){
       return DataType.getAsString(this.get(S_Ext219));
  
  }
  public String getExt219InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext219));
      }

  public void initExt151(String value){
     this.initProperty(S_Ext151,value);
  }
  public  void setExt151(String value){
     this.set(S_Ext151,value);
  }
  public  void setExt151Null(){
     this.set(S_Ext151,null);
  }

  public String getExt151(){
       return DataType.getAsString(this.get(S_Ext151));
  
  }
  public String getExt151InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext151));
      }

  public void initExt218(String value){
     this.initProperty(S_Ext218,value);
  }
  public  void setExt218(String value){
     this.set(S_Ext218,value);
  }
  public  void setExt218Null(){
     this.set(S_Ext218,null);
  }

  public String getExt218(){
       return DataType.getAsString(this.get(S_Ext218));
  
  }
  public String getExt218InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext218));
      }

  public void initExt154(String value){
     this.initProperty(S_Ext154,value);
  }
  public  void setExt154(String value){
     this.set(S_Ext154,value);
  }
  public  void setExt154Null(){
     this.set(S_Ext154,null);
  }

  public String getExt154(){
       return DataType.getAsString(this.get(S_Ext154));
  
  }
  public String getExt154InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext154));
      }

  public void initExt153(String value){
     this.initProperty(S_Ext153,value);
  }
  public  void setExt153(String value){
     this.set(S_Ext153,value);
  }
  public  void setExt153Null(){
     this.set(S_Ext153,null);
  }

  public String getExt153(){
       return DataType.getAsString(this.get(S_Ext153));
  
  }
  public String getExt153InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext153));
      }

  public void initExt150(String value){
     this.initProperty(S_Ext150,value);
  }
  public  void setExt150(String value){
     this.set(S_Ext150,value);
  }
  public  void setExt150Null(){
     this.set(S_Ext150,null);
  }

  public String getExt150(){
       return DataType.getAsString(this.get(S_Ext150));
  
  }
  public String getExt150InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext150));
      }

  public void initExt159(String value){
     this.initProperty(S_Ext159,value);
  }
  public  void setExt159(String value){
     this.set(S_Ext159,value);
  }
  public  void setExt159Null(){
     this.set(S_Ext159,null);
  }

  public String getExt159(){
       return DataType.getAsString(this.get(S_Ext159));
  
  }
  public String getExt159InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext159));
      }

  public void initExt155(String value){
     this.initProperty(S_Ext155,value);
  }
  public  void setExt155(String value){
     this.set(S_Ext155,value);
  }
  public  void setExt155Null(){
     this.set(S_Ext155,null);
  }

  public String getExt155(){
       return DataType.getAsString(this.get(S_Ext155));
  
  }
  public String getExt155InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext155));
      }

  public void initExt156(String value){
     this.initProperty(S_Ext156,value);
  }
  public  void setExt156(String value){
     this.set(S_Ext156,value);
  }
  public  void setExt156Null(){
     this.set(S_Ext156,null);
  }

  public String getExt156(){
       return DataType.getAsString(this.get(S_Ext156));
  
  }
  public String getExt156InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext156));
      }

  public void initExt157(String value){
     this.initProperty(S_Ext157,value);
  }
  public  void setExt157(String value){
     this.set(S_Ext157,value);
  }
  public  void setExt157Null(){
     this.set(S_Ext157,null);
  }

  public String getExt157(){
       return DataType.getAsString(this.get(S_Ext157));
  
  }
  public String getExt157InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext157));
      }

  public void initExt158(String value){
     this.initProperty(S_Ext158,value);
  }
  public  void setExt158(String value){
     this.set(S_Ext158,value);
  }
  public  void setExt158Null(){
     this.set(S_Ext158,null);
  }

  public String getExt158(){
       return DataType.getAsString(this.get(S_Ext158));
  
  }
  public String getExt158InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext158));
      }

  public void initExt202(String value){
     this.initProperty(S_Ext202,value);
  }
  public  void setExt202(String value){
     this.set(S_Ext202,value);
  }
  public  void setExt202Null(){
     this.set(S_Ext202,null);
  }

  public String getExt202(){
       return DataType.getAsString(this.get(S_Ext202));
  
  }
  public String getExt202InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext202));
      }

  public void initExt201(String value){
     this.initProperty(S_Ext201,value);
  }
  public  void setExt201(String value){
     this.set(S_Ext201,value);
  }
  public  void setExt201Null(){
     this.set(S_Ext201,null);
  }

  public String getExt201(){
       return DataType.getAsString(this.get(S_Ext201));
  
  }
  public String getExt201InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext201));
      }

  public void initExt200(String value){
     this.initProperty(S_Ext200,value);
  }
  public  void setExt200(String value){
     this.set(S_Ext200,value);
  }
  public  void setExt200Null(){
     this.set(S_Ext200,null);
  }

  public String getExt200(){
       return DataType.getAsString(this.get(S_Ext200));
  
  }
  public String getExt200InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext200));
      }

  public void initExt206(String value){
     this.initProperty(S_Ext206,value);
  }
  public  void setExt206(String value){
     this.set(S_Ext206,value);
  }
  public  void setExt206Null(){
     this.set(S_Ext206,null);
  }

  public String getExt206(){
       return DataType.getAsString(this.get(S_Ext206));
  
  }
  public String getExt206InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext206));
      }

  public void initExt205(String value){
     this.initProperty(S_Ext205,value);
  }
  public  void setExt205(String value){
     this.set(S_Ext205,value);
  }
  public  void setExt205Null(){
     this.set(S_Ext205,null);
  }

  public String getExt205(){
       return DataType.getAsString(this.get(S_Ext205));
  
  }
  public String getExt205InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext205));
      }

  public void initExt204(String value){
     this.initProperty(S_Ext204,value);
  }
  public  void setExt204(String value){
     this.set(S_Ext204,value);
  }
  public  void setExt204Null(){
     this.set(S_Ext204,null);
  }

  public String getExt204(){
       return DataType.getAsString(this.get(S_Ext204));
  
  }
  public String getExt204InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext204));
      }

  public void initExt203(String value){
     this.initProperty(S_Ext203,value);
  }
  public  void setExt203(String value){
     this.set(S_Ext203,value);
  }
  public  void setExt203Null(){
     this.set(S_Ext203,null);
  }

  public String getExt203(){
       return DataType.getAsString(this.get(S_Ext203));
  
  }
  public String getExt203InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext203));
      }

  public void initExt143(String value){
     this.initProperty(S_Ext143,value);
  }
  public  void setExt143(String value){
     this.set(S_Ext143,value);
  }
  public  void setExt143Null(){
     this.set(S_Ext143,null);
  }

  public String getExt143(){
       return DataType.getAsString(this.get(S_Ext143));
  
  }
  public String getExt143InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext143));
      }

  public void initExt142(String value){
     this.initProperty(S_Ext142,value);
  }
  public  void setExt142(String value){
     this.set(S_Ext142,value);
  }
  public  void setExt142Null(){
     this.set(S_Ext142,null);
  }

  public String getExt142(){
       return DataType.getAsString(this.get(S_Ext142));
  
  }
  public String getExt142InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext142));
      }

  public void initExt209(String value){
     this.initProperty(S_Ext209,value);
  }
  public  void setExt209(String value){
     this.set(S_Ext209,value);
  }
  public  void setExt209Null(){
     this.set(S_Ext209,null);
  }

  public String getExt209(){
       return DataType.getAsString(this.get(S_Ext209));
  
  }
  public String getExt209InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext209));
      }

  public void initExt141(String value){
     this.initProperty(S_Ext141,value);
  }
  public  void setExt141(String value){
     this.set(S_Ext141,value);
  }
  public  void setExt141Null(){
     this.set(S_Ext141,null);
  }

  public String getExt141(){
       return DataType.getAsString(this.get(S_Ext141));
  
  }
  public String getExt141InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext141));
      }

  public void initExt208(String value){
     this.initProperty(S_Ext208,value);
  }
  public  void setExt208(String value){
     this.set(S_Ext208,value);
  }
  public  void setExt208Null(){
     this.set(S_Ext208,null);
  }

  public String getExt208(){
       return DataType.getAsString(this.get(S_Ext208));
  
  }
  public String getExt208InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext208));
      }

  public void initExt140(String value){
     this.initProperty(S_Ext140,value);
  }
  public  void setExt140(String value){
     this.set(S_Ext140,value);
  }
  public  void setExt140Null(){
     this.set(S_Ext140,null);
  }

  public String getExt140(){
       return DataType.getAsString(this.get(S_Ext140));
  
  }
  public String getExt140InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext140));
      }

  public void initExt207(String value){
     this.initProperty(S_Ext207,value);
  }
  public  void setExt207(String value){
     this.set(S_Ext207,value);
  }
  public  void setExt207Null(){
     this.set(S_Ext207,null);
  }

  public String getExt207(){
       return DataType.getAsString(this.get(S_Ext207));
  
  }
  public String getExt207InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext207));
      }

  public void initExt148(String value){
     this.initProperty(S_Ext148,value);
  }
  public  void setExt148(String value){
     this.set(S_Ext148,value);
  }
  public  void setExt148Null(){
     this.set(S_Ext148,null);
  }

  public String getExt148(){
       return DataType.getAsString(this.get(S_Ext148));
  
  }
  public String getExt148InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext148));
      }

  public void initExt149(String value){
     this.initProperty(S_Ext149,value);
  }
  public  void setExt149(String value){
     this.set(S_Ext149,value);
  }
  public  void setExt149Null(){
     this.set(S_Ext149,null);
  }

  public String getExt149(){
       return DataType.getAsString(this.get(S_Ext149));
  
  }
  public String getExt149InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext149));
      }

  public void initExt146(String value){
     this.initProperty(S_Ext146,value);
  }
  public  void setExt146(String value){
     this.set(S_Ext146,value);
  }
  public  void setExt146Null(){
     this.set(S_Ext146,null);
  }

  public String getExt146(){
       return DataType.getAsString(this.get(S_Ext146));
  
  }
  public String getExt146InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext146));
      }

  public void initExt147(String value){
     this.initProperty(S_Ext147,value);
  }
  public  void setExt147(String value){
     this.set(S_Ext147,value);
  }
  public  void setExt147Null(){
     this.set(S_Ext147,null);
  }

  public String getExt147(){
       return DataType.getAsString(this.get(S_Ext147));
  
  }
  public String getExt147InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext147));
      }

  public void initExt144(String value){
     this.initProperty(S_Ext144,value);
  }
  public  void setExt144(String value){
     this.set(S_Ext144,value);
  }
  public  void setExt144Null(){
     this.set(S_Ext144,null);
  }

  public String getExt144(){
       return DataType.getAsString(this.get(S_Ext144));
  
  }
  public String getExt144InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext144));
      }

  public void initExt145(String value){
     this.initProperty(S_Ext145,value);
  }
  public  void setExt145(String value){
     this.set(S_Ext145,value);
  }
  public  void setExt145Null(){
     this.set(S_Ext145,null);
  }

  public String getExt145(){
       return DataType.getAsString(this.get(S_Ext145));
  
  }
  public String getExt145InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext145));
      }

  public void initExt237(String value){
     this.initProperty(S_Ext237,value);
  }
  public  void setExt237(String value){
     this.set(S_Ext237,value);
  }
  public  void setExt237Null(){
     this.set(S_Ext237,null);
  }

  public String getExt237(){
       return DataType.getAsString(this.get(S_Ext237));
  
  }
  public String getExt237InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext237));
      }

  public void initExt236(String value){
     this.initProperty(S_Ext236,value);
  }
  public  void setExt236(String value){
     this.set(S_Ext236,value);
  }
  public  void setExt236Null(){
     this.set(S_Ext236,null);
  }

  public String getExt236(){
       return DataType.getAsString(this.get(S_Ext236));
  
  }
  public String getExt236InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext236));
      }

  public void initExt239(String value){
     this.initProperty(S_Ext239,value);
  }
  public  void setExt239(String value){
     this.set(S_Ext239,value);
  }
  public  void setExt239Null(){
     this.set(S_Ext239,null);
  }

  public String getExt239(){
       return DataType.getAsString(this.get(S_Ext239));
  
  }
  public String getExt239InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext239));
      }

  public void initExt238(String value){
     this.initProperty(S_Ext238,value);
  }
  public  void setExt238(String value){
     this.set(S_Ext238,value);
  }
  public  void setExt238Null(){
     this.set(S_Ext238,null);
  }

  public String getExt238(){
       return DataType.getAsString(this.get(S_Ext238));
  
  }
  public String getExt238InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext238));
      }

  public void initExt233(String value){
     this.initProperty(S_Ext233,value);
  }
  public  void setExt233(String value){
     this.set(S_Ext233,value);
  }
  public  void setExt233Null(){
     this.set(S_Ext233,null);
  }

  public String getExt233(){
       return DataType.getAsString(this.get(S_Ext233));
  
  }
  public String getExt233InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext233));
      }

  public void initExt232(String value){
     this.initProperty(S_Ext232,value);
  }
  public  void setExt232(String value){
     this.set(S_Ext232,value);
  }
  public  void setExt232Null(){
     this.set(S_Ext232,null);
  }

  public String getExt232(){
       return DataType.getAsString(this.get(S_Ext232));
  
  }
  public String getExt232InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext232));
      }

  public void initExt235(String value){
     this.initProperty(S_Ext235,value);
  }
  public  void setExt235(String value){
     this.set(S_Ext235,value);
  }
  public  void setExt235Null(){
     this.set(S_Ext235,null);
  }

  public String getExt235(){
       return DataType.getAsString(this.get(S_Ext235));
  
  }
  public String getExt235InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext235));
      }

  public void initExt234(String value){
     this.initProperty(S_Ext234,value);
  }
  public  void setExt234(String value){
     this.set(S_Ext234,value);
  }
  public  void setExt234Null(){
     this.set(S_Ext234,null);
  }

  public String getExt234(){
       return DataType.getAsString(this.get(S_Ext234));
  
  }
  public String getExt234InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext234));
      }

  public void initStatus(String value){
     this.initProperty(S_Status,value);
  }
  public  void setStatus(String value){
     this.set(S_Status,value);
  }
  public  void setStatusNull(){
     this.set(S_Status,null);
  }

  public String getStatus(){
       return DataType.getAsString(this.get(S_Status));
  
  }
  public String getStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Status));
      }

  public void initExt130(String value){
     this.initProperty(S_Ext130,value);
  }
  public  void setExt130(String value){
     this.set(S_Ext130,value);
  }
  public  void setExt130Null(){
     this.set(S_Ext130,null);
  }

  public String getExt130(){
       return DataType.getAsString(this.get(S_Ext130));
  
  }
  public String getExt130InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext130));
      }

  public void initExt132(String value){
     this.initProperty(S_Ext132,value);
  }
  public  void setExt132(String value){
     this.set(S_Ext132,value);
  }
  public  void setExt132Null(){
     this.set(S_Ext132,null);
  }

  public String getExt132(){
       return DataType.getAsString(this.get(S_Ext132));
  
  }
  public String getExt132InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext132));
      }

  public void initExt131(String value){
     this.initProperty(S_Ext131,value);
  }
  public  void setExt131(String value){
     this.set(S_Ext131,value);
  }
  public  void setExt131Null(){
     this.set(S_Ext131,null);
  }

  public String getExt131(){
       return DataType.getAsString(this.get(S_Ext131));
  
  }
  public String getExt131InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext131));
      }

  public void initExt133(String value){
     this.initProperty(S_Ext133,value);
  }
  public  void setExt133(String value){
     this.set(S_Ext133,value);
  }
  public  void setExt133Null(){
     this.set(S_Ext133,null);
  }

  public String getExt133(){
       return DataType.getAsString(this.get(S_Ext133));
  
  }
  public String getExt133InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext133));
      }

  public void initExt134(String value){
     this.initProperty(S_Ext134,value);
  }
  public  void setExt134(String value){
     this.set(S_Ext134,value);
  }
  public  void setExt134Null(){
     this.set(S_Ext134,null);
  }

  public String getExt134(){
       return DataType.getAsString(this.get(S_Ext134));
  
  }
  public String getExt134InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext134));
      }

  public void initExt135(String value){
     this.initProperty(S_Ext135,value);
  }
  public  void setExt135(String value){
     this.set(S_Ext135,value);
  }
  public  void setExt135Null(){
     this.set(S_Ext135,null);
  }

  public String getExt135(){
       return DataType.getAsString(this.get(S_Ext135));
  
  }
  public String getExt135InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext135));
      }

  public void initExt136(String value){
     this.initProperty(S_Ext136,value);
  }
  public  void setExt136(String value){
     this.set(S_Ext136,value);
  }
  public  void setExt136Null(){
     this.set(S_Ext136,null);
  }

  public String getExt136(){
       return DataType.getAsString(this.get(S_Ext136));
  
  }
  public String getExt136InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext136));
      }

  public void initExt137(String value){
     this.initProperty(S_Ext137,value);
  }
  public  void setExt137(String value){
     this.set(S_Ext137,value);
  }
  public  void setExt137Null(){
     this.set(S_Ext137,null);
  }

  public String getExt137(){
       return DataType.getAsString(this.get(S_Ext137));
  
  }
  public String getExt137InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext137));
      }

  public void initExt138(String value){
     this.initProperty(S_Ext138,value);
  }
  public  void setExt138(String value){
     this.set(S_Ext138,value);
  }
  public  void setExt138Null(){
     this.set(S_Ext138,null);
  }

  public String getExt138(){
       return DataType.getAsString(this.get(S_Ext138));
  
  }
  public String getExt138InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext138));
      }

  public void initExt139(String value){
     this.initProperty(S_Ext139,value);
  }
  public  void setExt139(String value){
     this.set(S_Ext139,value);
  }
  public  void setExt139Null(){
     this.set(S_Ext139,null);
  }

  public String getExt139(){
       return DataType.getAsString(this.get(S_Ext139));
  
  }
  public String getExt139InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext139));
      }

  public void initExt230(String value){
     this.initProperty(S_Ext230,value);
  }
  public  void setExt230(String value){
     this.set(S_Ext230,value);
  }
  public  void setExt230Null(){
     this.set(S_Ext230,null);
  }

  public String getExt230(){
       return DataType.getAsString(this.get(S_Ext230));
  
  }
  public String getExt230InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext230));
      }

  public void initExt231(String value){
     this.initProperty(S_Ext231,value);
  }
  public  void setExt231(String value){
     this.set(S_Ext231,value);
  }
  public  void setExt231Null(){
     this.set(S_Ext231,null);
  }

  public String getExt231(){
       return DataType.getAsString(this.get(S_Ext231));
  
  }
  public String getExt231InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext231));
      }

  public void initExt228(String value){
     this.initProperty(S_Ext228,value);
  }
  public  void setExt228(String value){
     this.set(S_Ext228,value);
  }
  public  void setExt228Null(){
     this.set(S_Ext228,null);
  }

  public String getExt228(){
       return DataType.getAsString(this.get(S_Ext228));
  
  }
  public String getExt228InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext228));
      }

  public void initExt227(String value){
     this.initProperty(S_Ext227,value);
  }
  public  void setExt227(String value){
     this.set(S_Ext227,value);
  }
  public  void setExt227Null(){
     this.set(S_Ext227,null);
  }

  public String getExt227(){
       return DataType.getAsString(this.get(S_Ext227));
  
  }
  public String getExt227InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext227));
      }

  public void initExt226(String value){
     this.initProperty(S_Ext226,value);
  }
  public  void setExt226(String value){
     this.set(S_Ext226,value);
  }
  public  void setExt226Null(){
     this.set(S_Ext226,null);
  }

  public String getExt226(){
       return DataType.getAsString(this.get(S_Ext226));
  
  }
  public String getExt226InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext226));
      }

  public void initExt225(String value){
     this.initProperty(S_Ext225,value);
  }
  public  void setExt225(String value){
     this.set(S_Ext225,value);
  }
  public  void setExt225Null(){
     this.set(S_Ext225,null);
  }

  public String getExt225(){
       return DataType.getAsString(this.get(S_Ext225));
  
  }
  public String getExt225InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext225));
      }

  public void initExt224(String value){
     this.initProperty(S_Ext224,value);
  }
  public  void setExt224(String value){
     this.set(S_Ext224,value);
  }
  public  void setExt224Null(){
     this.set(S_Ext224,null);
  }

  public String getExt224(){
       return DataType.getAsString(this.get(S_Ext224));
  
  }
  public String getExt224InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext224));
      }

  public void initExt223(String value){
     this.initProperty(S_Ext223,value);
  }
  public  void setExt223(String value){
     this.set(S_Ext223,value);
  }
  public  void setExt223Null(){
     this.set(S_Ext223,null);
  }

  public String getExt223(){
       return DataType.getAsString(this.get(S_Ext223));
  
  }
  public String getExt223InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext223));
      }

  public void initExt222(String value){
     this.initProperty(S_Ext222,value);
  }
  public  void setExt222(String value){
     this.set(S_Ext222,value);
  }
  public  void setExt222Null(){
     this.set(S_Ext222,null);
  }

  public String getExt222(){
       return DataType.getAsString(this.get(S_Ext222));
  
  }
  public String getExt222InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext222));
      }

  public void initExt221(String value){
     this.initProperty(S_Ext221,value);
  }
  public  void setExt221(String value){
     this.set(S_Ext221,value);
  }
  public  void setExt221Null(){
     this.set(S_Ext221,null);
  }

  public String getExt221(){
       return DataType.getAsString(this.get(S_Ext221));
  
  }
  public String getExt221InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext221));
      }

  public void initExt121(String value){
     this.initProperty(S_Ext121,value);
  }
  public  void setExt121(String value){
     this.set(S_Ext121,value);
  }
  public  void setExt121Null(){
     this.set(S_Ext121,null);
  }

  public String getExt121(){
       return DataType.getAsString(this.get(S_Ext121));
  
  }
  public String getExt121InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext121));
      }

  public void initExt120(String value){
     this.initProperty(S_Ext120,value);
  }
  public  void setExt120(String value){
     this.set(S_Ext120,value);
  }
  public  void setExt120Null(){
     this.set(S_Ext120,null);
  }

  public String getExt120(){
       return DataType.getAsString(this.get(S_Ext120));
  
  }
  public String getExt120InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext120));
      }

  public void initExt229(String value){
     this.initProperty(S_Ext229,value);
  }
  public  void setExt229(String value){
     this.set(S_Ext229,value);
  }
  public  void setExt229Null(){
     this.set(S_Ext229,null);
  }

  public String getExt229(){
       return DataType.getAsString(this.get(S_Ext229));
  
  }
  public String getExt229InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext229));
      }

  public void initExt124(String value){
     this.initProperty(S_Ext124,value);
  }
  public  void setExt124(String value){
     this.set(S_Ext124,value);
  }
  public  void setExt124Null(){
     this.set(S_Ext124,null);
  }

  public String getExt124(){
       return DataType.getAsString(this.get(S_Ext124));
  
  }
  public String getExt124InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext124));
      }

  public void initExt125(String value){
     this.initProperty(S_Ext125,value);
  }
  public  void setExt125(String value){
     this.set(S_Ext125,value);
  }
  public  void setExt125Null(){
     this.set(S_Ext125,null);
  }

  public String getExt125(){
       return DataType.getAsString(this.get(S_Ext125));
  
  }
  public String getExt125InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext125));
      }

  public void initExt122(String value){
     this.initProperty(S_Ext122,value);
  }
  public  void setExt122(String value){
     this.set(S_Ext122,value);
  }
  public  void setExt122Null(){
     this.set(S_Ext122,null);
  }

  public String getExt122(){
       return DataType.getAsString(this.get(S_Ext122));
  
  }
  public String getExt122InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext122));
      }

  public void initExt123(String value){
     this.initProperty(S_Ext123,value);
  }
  public  void setExt123(String value){
     this.set(S_Ext123,value);
  }
  public  void setExt123Null(){
     this.set(S_Ext123,null);
  }

  public String getExt123(){
       return DataType.getAsString(this.get(S_Ext123));
  
  }
  public String getExt123InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext123));
      }

  public void initExt128(String value){
     this.initProperty(S_Ext128,value);
  }
  public  void setExt128(String value){
     this.set(S_Ext128,value);
  }
  public  void setExt128Null(){
     this.set(S_Ext128,null);
  }

  public String getExt128(){
       return DataType.getAsString(this.get(S_Ext128));
  
  }
  public String getExt128InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext128));
      }

  public void initExt129(String value){
     this.initProperty(S_Ext129,value);
  }
  public  void setExt129(String value){
     this.set(S_Ext129,value);
  }
  public  void setExt129Null(){
     this.set(S_Ext129,null);
  }

  public String getExt129(){
       return DataType.getAsString(this.get(S_Ext129));
  
  }
  public String getExt129InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext129));
      }

  public void initExt126(String value){
     this.initProperty(S_Ext126,value);
  }
  public  void setExt126(String value){
     this.set(S_Ext126,value);
  }
  public  void setExt126Null(){
     this.set(S_Ext126,null);
  }

  public String getExt126(){
       return DataType.getAsString(this.get(S_Ext126));
  
  }
  public String getExt126InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext126));
      }

  public void initExt127(String value){
     this.initProperty(S_Ext127,value);
  }
  public  void setExt127(String value){
     this.set(S_Ext127,value);
  }
  public  void setExt127Null(){
     this.set(S_Ext127,null);
  }

  public String getExt127(){
       return DataType.getAsString(this.get(S_Ext127));
  
  }
  public String getExt127InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext127));
      }

  public void initExt220(String value){
     this.initProperty(S_Ext220,value);
  }
  public  void setExt220(String value){
     this.set(S_Ext220,value);
  }
  public  void setExt220Null(){
     this.set(S_Ext220,null);
  }

  public String getExt220(){
       return DataType.getAsString(this.get(S_Ext220));
  
  }
  public String getExt220InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext220));
      }


 
 }

