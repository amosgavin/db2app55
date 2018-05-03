/**
	文件名称：EditType.js
	作者	: 墙 辉
	编制时间: 2002-09-10
	文件内容：所有关于WEB页面界面处理对象定义
	包括对象：
		DataType：		数据类型对象基类
		DTString：	字符数据类型
		DTDate：	日期数据类型
		DTDouble：	浮点数数据类型
		DTNumber：	整数数据类型
		DTEmail：	电子邮件地址数据类型
		DTPostcode：	邮政编码数据类型

        //修改MaxLength 为M
        //Decimal ------>D
**/

/**
  数据类型对象基类
**/
S_DataType_Varchar = "VARCHAR";
S_DataType_String = "STRING";
S_DataType_Date = "DATE";
S_DataType_DateTime = "DATETIME";
S_DataType_Double = "DOUBLE";
S_DataType_Float = "FLOAT";
S_DataType_Number = "NUMBER";
S_DataType_Int = "INT";
S_DataType_Integer ="INTEGER";
S_DataType_Email = "EMAIL";
S_DataType_Postcode = "POSTCODE";
S_DataType_Long = "LONG";
S_DataType_Short="SHORT";

function DataType(type,maxlength,decimal)
{
  if (type)
  {  type = type.toUpperCase();
     switch (type){
         case S_DataType_Varchar:      obj = new DTString(maxlength);  	break;
	 case S_DataType_String:        obj = new DTString(maxlength);  	break;
	 case S_DataType_Date:	 	obj = new DTDate();	   	break;
	 case S_DataType_DateTime:	obj = new DTDateTime();	   	break;
         case S_DataType_Float:	 	obj = new DTDouble(maxlength,decimal);	   	break;
	 case S_DataType_Double:	obj = new DTDouble(maxlength,decimal);	   	break;
         case S_DataType_Int:	 	obj = new DTNumber(maxlength);	   	break;
         case S_DataType_Integer:      obj = new DTNumber(maxlength);	   	break;
	 case S_DataType_Number:	obj = new DTNumber(maxlength);	   	break;
	 case S_DataType_Email:	 	obj = new DTEmail(maxlength);	   	break;
	 case S_DataType_Postcode:	obj = new DTPostcode();  	break;
	 case S_DataType_Long:          obj = new DTLong(maxlength); break;
	 case S_DataType_Short:		 obj = new DTNumber(maxlength);	   	break;
         default :alert(g_I18NMessage("appframe_core","datatype_no_deal",new Array(type)));
	 }
  }
  else
     obj = new DTString();
  return obj;
}


/**
  字符数据类型
**/
function DTString(maxlength)
{ this.Name = S_DataType_String;
  this.MaxLength = 20;
  if(maxlength)
        this.MaxLength = maxlength;

  this.getName = function() { return this.Name;}
  this.getMaxLength = function() { return this.MaxLength;}
  this.checkKey = function(keyCode,str){
//    if ((this.MaxLength)&&(str.length > this.MaxLength - 1))   	return false;
    if (keyCode == 39)        return false;
    return true;
  }
  this.verify = function(str){
    if(g_GetStrLen(str) > this.MaxLength)
    {  alert(g_I18NMessage("appframe_core","datatype_str_len",new Array(this.MaxLength+"")));
  	return false;
     }
    var keyCode;
    for(var i=0; i < str.length; i++)
    {
	keyCode = str.charCodeAt(i);
	if ((keyCode == 38)||(keyCode == 39)||(keyCode == 60))
	{
	   alert(g_I18NMessage("appframe_core","datatype_illegal")+str.value.substr(i,1));
           return false;
	}
    }
    return true;
  }
}
/**
  日期数据类型
**/
function DTDate()
{ this.Name = S_DataType_Date;
  this.getMaxLength = function() { return 10;}
  this.getName = function() { return this.Name;}
  this.checkKey = function(keyCode,str)
  {
   // if (str.length > 10  - 1) 	return false;
    //===可输入“数字”、“-”符号
    if (!((keyCode >=48 && keyCode <=57)||(keyCode == 45)))
	return false;

    return true;

  }
  this.verify = function(str)
  {
    if (str.length > 10)
    {   alert(g_I18NMessage("appframe_core","datatype_date"));
  	return false;
    }

    	var r,re,strMM,strDD;
	re=/\d{4}\-\d{2}\-\d{2}/i;
	r=str.search(re);
	if (r == -1)
	{
	  alert(g_I18NMessage("appframe_core","datatype_date"));
	  return false;
	}
	else
	{
	  strMM=str.substring(5,7);
	  strDD=str.substring(8,10);
	  if (strMM > 12 || strDD > 31)
	  {
	    alert(g_I18NMessage("appframe_core","datatype_month"));
	    return false;
	  }
	}
	//==是否有非法字付
	for(var j=0; j < str.length; j++)
	{
	   var keyCODE = str.charCodeAt(j);
	   if ((keyCODE >=48 && keyCODE <=57)|| keyCODE == 45)
	   {}
	   else
	   {
	 	alert(g_I18NMessage("appframe_core","datatype_illegal")+str.substr(j,1));
		return false;
	   }
	}
     return true;
  }
}
/**
  日期时间数据类型
**/
function DTDateTime()
{ this.Name = S_DataType_DateTime;
  this.getMaxLength = function() { return 19;}
  this.getName = function() { return this.Name;}
  this.checkKey = function(keyCode,str)
  {
   // if (str.length > 10  - 1) 	return false;
    //===可输入“数字”、“-”,":"符号
    if (!((keyCode >=48 && keyCode <=57)||(keyCode == 45)||(keyCode == 58)||(keyCode == 32)))
	return false;

    return true;

  }
  this.verify = function(str)
  {
    if (str.length > 19)
    {   alert(g_I18NMessage("appframe_core","datatype_datetime"));
  	return false;
    }
    	var r,re,strMM,strDD;
	re=/\d{4}\-\d{2}\-\d{2}/i;
	r=str.search(re);
	if (r == -1)
	{
	  alert(g_I18NMessage("appframe_core","datatype_date"));
	  return false;
	}
	else
	{
	  strMM=str.substring(5,7);
	  strDD=str.substring(8,10);
	  if (strMM > 12 || strDD > 31)
	  {
	    alert(g_I18NMessage("appframe_core","datatype_month"));
	    return false;
	  }
	}
	//==是否有非法字付
	for(var j=0; j < str.length; j++)
	{
	   var keyCODE = str.charCodeAt(j);
	   if ((keyCODE >=48 && keyCODE <=57)|| keyCODE == 45||keyCODE == 58||(keyCODE == 32))
	   {}
	   else
	   {
	 	alert(g_I18NMessage("appframe_core","datatype_illegal")+str.substr(j,1));
		return false;
	   }
	}
     return true;
  }
}
function DTDouble(maxlength,decimal)
{ this.Name = S_DataType_Double;
  this.MaxLength =10;
  this.Decimal =2;
  if(maxlength)
     this.MaxLength = maxlength;
  if (decimal)
     this.Decimal = decimal;

  this.getName = function() { return this.Name;}
  this.getMaxLength = function() { return parseInt(this.MaxLength) + 1;}
  this.checkKey = function(keyCode,str)
  {
    //if ((this.MaxLength)&&(str.length > this.MaxLength + 1 -1)) return false;
     //===可输入“数字”、“.”符号
    if (!((keyCode >=48 && keyCode <=57)||(keyCode == 46)||(keyCode == 45)))
	return false;

    return true;
  }
  this.verify = function(ObjStr)  {

    }
}
/**
  长整形数据类型
**/
function DTLong(maxlength)
{ this.Name = S_DataType_Number;
  this.MaxLength = 20;
  if(maxlength)
     this.MaxLength = maxlength;

  this.getName = function() { return this.Name;}
  this.getMaxLength = function() { return this.MaxLength;}
  this.checkKey = function(keyCode,str)
  {
    //if ((this.MaxLength)&&(str.length > this.MaxLength))return false;
    //===可输入“数字”
    if (!(keyCode >=48 && keyCode <=57||(keyCode == 45)))
	return false;

    return true;
  }
  this.verify = function(str)
  {
    if ((this.MaxLength)&&(str.length > this.MaxLength ))
    {  alert(g_I18NMessage("appframe_core","datatype_str_len",new Array(this.MaxLength+"")));
         return false;
    }

    for(var j=0; j < str.length; j++)
    {
	var keyCode = str.charCodeAt(j);
	if (!(keyCode >=48 && keyCode <=57||(keyCode == 45)))
	{
	  alert(g_I18NMessage("appframe_core","datatype_illegal")+str.substr(j,1));
  	  return false;
	 }
   }
   return true;
  }
}
/**
  整型数据类型
**/
function DTNumber(maxlength)
{ this.Name = S_DataType_Number;
  this.MaxLength = 10;
  if(maxlength)
     this.MaxLength = maxlength;

  this.getName = function() { return this.Name;}
  this.getMaxLength = function() { return this.MaxLength;}
  this.checkKey = function(keyCode,str)
  {
    //if ((this.MaxLength)&&(str.length > this.MaxLength))return false;
    //===可输入“数字”
    if (!(keyCode >=48 && keyCode <=57||(keyCode == 45)))
	return false;

    return true;
  }
  this.verify = function(str)
  {
    if ((this.MaxLength)&&(str.length > this.MaxLength ))
    {  alert(g_I18NMessage("appframe_core","datatype_str_len",new Array(this.MaxLength+"")));
         return false;
    }

    for(var j=0; j < str.length; j++)
    {
	var keyCode = str.charCodeAt(j);
	if (!(keyCode >=48 && keyCode <=57||(keyCode == 45)))
	{
	  alert(g_I18NMessage("appframe_core","datatype_illegal")+str.substr(j,1));
  	  return false;
	 }
   }
   return true;

  }
}
function DTEmail(maxlength)
{ this.Name = S_DataType_Email
  this.MaxLength = 20;
  if(maxlength)
     this.MaxLength = maxlength;

  this.getName = function() { return this.Name;}
  this.getMaxLength = function() { return this.MaxLength;}
  this.checkKey = function(keyCode,str)
  {
   // if ((this.MaxLength)&&(str.length > this.MaxLength - 1))  	return false;

   //===可输入“数字”、“@”符号、“-”符号、“_”符号
   if (!((keyCode >=48 && keyCode <=57)||(keyCode >=65 && keyCode <=90)||(keyCode >=97 && keyCode <=122)||(keyCode == 64)||(keyCode == 45)||(keyCode == 95)||(keyCode == 46)))
     return false

   return true;

  }
  this.verify = function(ObjStr)  {showError("",this.Name +"：" + ObjStr);}
}
function DTPostcode()
{ this.Name = S_DataType_Postcode;
  this.getName = function() { return this.Name;}
  this.getMaxLength = function() { return 6;}
  this.checkKey = function(keyCode,str)
  {
  // if (str.length >6 - 1) //最大长度为6  	return false;
    //===可输入“数字”
    if (!(keyCode >=48 && keyCode <=57)){
    return false;
    }

    return true;
  }
  this.verify = function(str)
  {     
  if ((this.MaxLength)&&(str.length != this.MaxLength))
        {  alert(g_I18NMessage("appframe_core","datatype_post"));
              return false;
         }
        for(var j=0; j < str.length; j++)
        {
            var keyCode = str.charCodeAt(j);
            if (!(keyCode >=48 && keyCode <=57))
            {
              alert(g_I18NMessage("appframe_core","datatype_illegal")+str.substr(j,1));
                return false;
             }
        }
        return true;
  }
}
