// ????????????????????
function var_to_obj(val)
{
	this.value=val;
}
// ??????????????????
function is_greater(field,crit,limit)
{
	var Ret = (is_numeric(field,-1) ) ? (field.value > limit )  : false;
	if (!Ret)
		doCritCode(field,crit,"Value must be greater than "+limit);
	return(Ret);
}
// ??????????????????
function is_less(field,crit,limit)
{
	var Ret = (is_numeric(field,-1) ) ? (field.value < limit )  : false;
	if (!Ret)
		doCritCode(field,crit,"Value must be less than "+limit);
	return(Ret);
}

function Compare_Number(Num1,Num2){
	var ret = (Number(Num1) < Number(Num2))?false:true;
	return ret;
}

//????????????????????Num1>Num2 return:true;Num1<=Num2 return:false
function Compare_Date(Num1,Num2)
{
		var pos1,pos2,end;
		var para1,para2,para3,para4,para5,para6;

		//para1:??
		//para2:??
		//para3:??
		end=Num1.length;
		pos1=Num1.indexOf("-",0);
		pos2=Num1.indexOf("-",pos1+1);
		para1=Num1.substring(0,pos1);
		para2=Num1.substring(pos1+1,pos2);
		para3=Num1.substring(pos2+1,end);
		para1=parseFloat(para1);
		para2=parseFloat(para2);
		para3=parseFloat(para3);
		end=Num2.length;
		pos1=Num2.indexOf("-",0);
		pos2=Num2.indexOf("-",pos1+1);
		para4=Num2.substring(0,pos1);
		para5=Num2.substring(pos1+1,pos2);
		para6=Num2.substring(pos2+1,end);
		para4=parseFloat(para4);
		para5=parseFloat(para5);
		para6=parseFloat(para6);
		if(para1>para4)
		{
			return true;
		}
		else if(para1==para4)
		{
			if(para2>para5)
			{
				return true;
			}
			else if(para2==para5)
			{
				if(para3>para6)
				{
					return true;
				}
			}
		}
		return false;

}
//format float data as:*****.**
//decplaces:????????
function FloatFormat(expr,decplaces)
{
        var str = "" + Math.round(eval(expr)*Math.pow(10,decplaces));
        while(str.length <= decplaces)
        {
                str = "0" + str;
        }

        var decpoint = str.length - decplaces;
        return str.substring(0,decpoint) + "." + str.substring(decpoint,str.length);
}
function is_numeric(field,crit,msg)
{
	var Ret = true;
	var NumStr="0123456789";
	var decUsed=false;
	var chr;
	for (i=0;i<field.value.length;++i)
	{
		chr=field.value.charAt(i);
		if (NumStr.indexOf(chr,0)==-1)
		{
			if ( (!decUsed) && chr==".")
			{
				decUsed=true;
			}
			else
			{
				Ret=false;
			}
		}
	}
	if (!Ret)
		doCritCode(field,crit,msg);
	return(Ret);
}
 // ??????????????
function is_price(field,crit,msg)
{
	var Ret = true;
	var NumStr="0123456789";
	var decUsed=false;
	var chr;
	for (i=0;i<field.value.length;++i)
	{
		chr=field.value.charAt(i);
		if (NumStr.indexOf(chr,0)==-1)
		{
			if ( (!decUsed) && chr==".")
			{
				decUsed=true;
			}
			else
			{
				Ret=false;
			}
		}
	}
	if(Ret)
	{
		if(decUsed&&(field.value.length-field.value.indexOf('.')<4))
		;
		else if(decUsed)
			Ret=false;
	}
	if (!Ret)
		doCritCode(field,crit,msg);
	return(Ret);
}
 // ???????????? true:?? false:????
function Is_Null(field,crit,msg)
{
	Text=""+Trim(field.value);

	if(Text.length)
	{
		for(var i=0;i<Text.length;i++)
		if(Text.charAt(i)!=" ")
		break;
		if(i>=Text.length)
			Ret=true;
		else
			Ret=false;
	}
	else
		Ret=true;
	if (Ret)
		doCritCode(field,crit,msg);
	return(Ret);
}
//????????????????true:????false????????
function Null_Ok(field,crit,msg1,msg2)
{
	Text=""+Trim(field.value);

	if(Text.length)
	{
		for(var i=0;i < Text.length;i++)
			if(Text.charAt(i)!=" ")
				break;
		if(i>=Text.length)

			Ret=true;
		else
			Ret=false;
	}else{
		Ret=true;
	}
	if(Ret)
	{
		if(!confirm(msg2))
			doCritCode(field,crit,msg1);
		else
			Ret = false;
	}
	return(Ret);
}

function IsSpace(field)
{
	var Text=""+field.value;
	if(Text.length)
	{
		for(var i=0;i<Text.length;i++)
			if(Text.charAt(i)!=" ")
				break;
		if(i>=Text.length)
			field.value="";
	}
}

function doCritCode(field,crit,msg)
{
	if ( (-1!=crit) )
	{
		alert(msg)
		if (crit==1)
		{
			field.focus();  // focus does not work on certain netscape versions
			field.select();
		}
	}
}
// ??????????????true:????????false:????????
function Is_Int(field,crit,msg){
	var Ret = true;
	var NumStr="0123456789";
	var chr;

	for (i=0;i<field.value.length;i++)
	{
		chr=field.value.charAt(i);
		if (NumStr.indexOf(chr,0)==-1)
		{
			Ret=false;
		}
	}
	if (!Ret)
		doCritCode(field,crit,msg);
	return(Ret);
}
// ?????????????? ????date????false ??date????true
function is_date(field,crit,msg){
	var Ret = false;
	var mark1;
	var mark2;
	var days

	if(field.value=="")
		return true;
	cd=new Date();

	if ( (mark1 = field.value.indexOf('-'))==-1)
		mark1=field.value.indexOf('-')
	if (mark1>-1)
	{
		if ( (mark2 = field.value.indexOf('-',mark1+1)) ==-1)
			mark2=field.value.indexOf('-',mark1+1);
		if ((mark2>-1)&&(mark2+1<field.value.length) )
		{
			year = new var_to_obj(field.value.substring(0,mark1));
			month = new var_to_obj(field.value.substring(mark1+1,mark2));
			day = new var_to_obj(field.value.substring(mark2+1,field.value.length));
			days = getDaysInMonth(month.value,year.value) + 1

			if (
				(is_greater(day,-1,0))&&(is_less(day,-1,days))&&
				(is_greater(month,-1,0))&&(is_less(month,-1,13))&&
				(is_greater(year,-1,1900))&&(is_less(year,-1,2500))
				)
				Ret=true;
		}
	}
	if (!Ret) doCritCode(field,crit,msg);

	return(Ret);
}

function is_date2(tmpy,tmpm,tmpd)
{
	year=new String (tmpy);
	month=new String (tmpm);
	day=new String (tmpd)
	if ((tmpy.length!=4) || (tmpm.length>2) || (tmpd.length>2))
	{
		return false;
	}
	if (!((1<=month) && (12>=month) && (31>=day) && (1<=day)) )
	{
		return false;
	}
	if (!( ((year % 4)==0) && ((year % 400)==0) ) && (month==2) && (day==29))
	{
		return false;
	}
	if ((month<=7) && ((month % 2)==0) && (day>=31))
	{
		return false;

	}
	if ((month>=8) && ((month % 2)==1) && (day>=31))
	{
		return false;
	}
	if ((month==2) && (day==30))
	{
		return false;
	}

	return true;
}


function doCrit(field,crit,msg)
{
	if ( (-1!=crit) )
	{
		alert(msg);
		if (crit==1)
		{
			field.focus();  // focus does not work on certain netscape versions
		}
	}
}
// ????????????????????????
function IsSelected(field,crit,msg)
{
	value=""+field.options[field.selectedIndex].value;
	if(value=="0")
		Ret=true;
	else
		Ret=false;
	if (Ret)
		doCrit(field,crit,msg);
	return(Ret);
}
//??????????radio?????? field:form1.appid
function IsChecked(field,msg)
{
       l = field.length;
       if(l==undefined){
	 if(!field.checked){
	  alert(msg);
	  return false
	 }
	 else{
	  return true
	 }
       }
       else{
         flag=0;
         for(i=0;i<l;i++){
	   if(field[i].checked==true){
	   flag++;
	   }
         }

         if(flag==0){
	   alert(msg);
	   return false
         }
         else{
	   return true
         }
       }
}



// ??????????????
// cCharacter????????
function isCharacter( cCharacter )
{
	var sFormat = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	if( sFormat.indexOf( cCharacter, 0 ) == -1 )
	{
		return false;
	}

	return true;
}

// ??????????????????????????????
// cCharacter????????
function isOtherNameCharacter( cCharacter )
{
	var sFormat = "_";

	if( sFormat.indexOf( cCharacter, 0 ) == -1 )
	{
		return false;
	}

	return true;
}

// ??????????????????????????
// sValue????????
function isNameCharacter( sValue )
{
	if( sValue == null )
	{
		return false;
	}

	for( i = 0; i < sValue.length; i ++ )
	{
		var cCharacter = sValue.charAt( i );
		if( isDigital( cCharacter ) == false && isCharacter( cCharacter ) == false && isOtherNameCharacter( cCharacter ) == false )
		{
			return false;
		}
	}

	return true;
}

// ??????????Email
// sValue????????????????????a@b.c.d????????
function isEmail( sValue )
{
	var iFirstIndex = 0;
	var iSecondIndex = sValue.indexOf( '@' );
	if( iSecondIndex == -1 )
	{
		return false;
	}

	var sTemp = sValue.substring( iFirstIndex, iSecondIndex );
	if( isNameCharacter( sTemp ) == false )
	{
		return false;
	}

	iSecondIndex = sValue.indexOf( '.' );
	if( iSecondIndex == -1 || sValue.substring( sValue.length-1, sValue.length ) == '.' )
	{
		return false;
	}
	else if(  sTemp.length == sValue.length - 2 )	// The last two characters are '@' and '.'
	{
		return false;
	}
	else
	{
		var sTempValue = sValue;
		iSecondIndex = sValue.indexOf( '@' );
		while( iSecondIndex != -1 )
		{
			iFirstIndex = iSecondIndex + 1;
			sTempValue = sTempValue.substring( iFirstIndex, sTempValue.length );	// The right section of value
			iSecondIndex = sTempValue.indexOf( '.' );
			//document.write( "sTempValue=" + sTempValue + "<br>" );
			sTemp = sTempValue.substring( 0, iSecondIndex );
			//document.write( "sTemp=" + sTemp + "<br>" );
			if( isNameCharacter( sTemp ) == false )
			{
				return false;
			}
		}

		if( isNameCharacter( sTempValue ) == false )
		{
			return false;
		}
	}

	return true;
}

// ??????????????
// sValue????????????????????????????
function isZIP( sValue )
{
	if( sValue == null )
	{
		return false;
	}

	if( sValue.length != 6 )
	{
		return false;
	}
	else
	{
		for( i = 0; i < 6; i ++ )
		{
			if( isDigital( sValue.charAt( i ) ) == false )
			{
				return false;
			}
		}
	}

	return true;
}

// ????????????????????
// sValue????????
function isDigitalString( sValue )
{
	if( sValue == null )
	{
		return false;
	}

	for( i = 0; i < sValue.length; i ++ )
	{
		if( isDigital( sValue.charAt( i ) ) == false )
		{
			return false;
		}
	}
}


//IsEmpty??????????????????????????
function IsEmpty(his)
{
   flag = true;
   for(var i=0;i<his.length;i++)
   {
      if(his.charAt(i)!=" ")
      {
         flag = false;
         break;
      }
   }
   return flag;
}
//Trim??????????????????????????
function Trim(his)
{
   //??????????????????
   Pos_Start = -1;
   for(var i=0;i<his.length;i++)
   {
     if(his.charAt(i)!=" ")
      {
         Pos_Start = i;
         break;
      }
   }
   //??????????????????
   Pos_End = -1;
   for(var i=his.length-1;i>=0;i--)
   {
     if(his.charAt(i)!=" ")
      {
         Pos_End = i;
         break;
      }
   }
   //????????????
   Str_Return = ""
   if(Pos_Start!=-1 && Pos_End!=-1)
   {
		for(var i=Pos_Start;i<=Pos_End;i++)
		{
			   Str_Return = Str_Return + his.charAt(i);
		}
   }
   return Str_Return;
}
//IsDigital????????????????????????????(int or long)????
function isDigital(str)
{
  for(ilen=0;ilen<str.length;ilen++)
  {
    if(str.charAt(ilen) < '0' || str.charAt(ilen) > '9' )
    {
       return false;
    }
  }
  return true;
}
//IsFloat????????????????????????????(int or long or float)????
function IsFloat(str)
{
  flag_Dec = 0
  for(ilen=0;ilen<str.length;ilen++)
  {
    if(str.charAt(ilen) == '.')
    {
       flag_Dec++;
	   if(flag_Dec > 1)
          return false;
       else
          continue;
    }
    if(str.charAt(ilen) < '0' || str.charAt(ilen) > '9' )
    {
       return false;
    }
  }
  return true;
}
//IsTelephone??????????????????????????????'-','*','()'????
function IsTelephone(str)
{
  for(ilen=0;ilen<str.length;ilen++)
  {
    if(str.charAt(ilen) < '0' || str.charAt(ilen) > '9' )
    {
		if((str.charAt(ilen)!='-')&&(str.charAt(ilen)!='*')&&(str.charAt(ilen)!=';')&&(str.charAt(ilen)!='(')&&(str.charAt(ilen)!=')'))
        return false;
    }
  }
  return true;
}
//????????????2/18/2000 ----2000-2-18
	function dateTransfer(strdate)
	{

		var pos1,pos2,end;
		var para1,para2,para3;
		var newdate;
		newdate="";
		//para1:??
		//para2:??
		//para3:??
		if(Trim(strdate)=="")
		{
			return(newdate);
		}
		end=strdate.length;
		pos1=strdate.indexOf("/",0);
		pos2=strdate.indexOf("/",pos1+1);
		para1=strdate.substring(0,pos1);
		para2=strdate.substring(pos1+1,pos2);
		para3=strdate.substring(pos2+1,end);
		newdate=para3+"-"+para1+"-"+para2;
		return(newdate);
	}
//????????2000-10-20 ---->10/20/2000
function transferDate(str)
{
  var m=4;
  var strlen=str.length
  var n=strlen-1;
  if(Trim(str)=="")
  {
		return(str);
  }
  while (n>=strlen-2)
  {
   if(str.charAt(n)=="-")
    {
      break;
    }
   n=n-1
  }
  trimstr=str.substring(m+1,n)+"/"+ str.substring(n+1,strlen)+"/"+str.substring(0,m)
  return(trimstr);
}

//??????????????
function ispassword( sValue )
{
	if( sValue == null )
	{
		return false;
	}

	for( i = 0; i < sValue.length; i ++ )
	{
		var cCharacter = sValue.charAt( i );
		if( isDigital( cCharacter ) == false && isCharacter( cCharacter ) == false && isOtherNameCharacter( cCharacter ) == false)
		{
			return false;
		}
	}

	return true;
}

//????????????????????
//??????????Year--????
//          ??????:????????????????true??????????false.

function isLeapYear (Year) {
if (((Year % 4)==0) && ((Year % 100)!=0) || ((Year % 400)==0)) {
return (true);
} else { return (false); }
}

//??????????????????
//??????????month--??;year--??
//          ????????days--????
function getDaysInMonth(month,year)  {
var days;
if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)  days=31;
else if (month==4 || month==6 || month==9 || month==11) days=30;
else if (month==2)  {
if (isLeapYear(year)) { days=29; }
else { days=28; }
}
return (days);
}




  function ratifyTime(str){

		  var Ret = false;
		  //??????????

          var str1=str.value.substring(3,2);
		  //??????????
		  var str2=str.value.substring(6,5);
			var phour;
		  var pmin;
		  var psec;

          if(str1!=":"||str2!=":")
		  {
			alert("????????????????01:01:01");
		    str.focus();
			return(false);
		  };


		  phour=parseFloat(str.value.substring(2,0));//????
		  pmin=parseFloat(str.value.substring(5,3));//????
		  psec=parseFloat(str.value.substring(8,6));//??

		  if(phour>23||phour<0){
			alert("????????????????????23??????????0");
			str.focus();
			return(false);
		  };
          if(pmin>59||pmin<0){
			alert("????????????????????59??????????0");
			str.focus();
			return(false);
		  };
		  if(psec>59||psec<0){
			alert("??????????????????59??????????0");
			str.focus();
			return(false);
		  };


	      return(true);
		}



		//??????????????????????????0??????????1??????????2
		function compareTime(str1,str2){
		  var phour1;
		  var pmin1;
		  var psec1;

		  var phour2;
		  var pmin2;
		  var psec2;

		  phour1=parseFloat(str1.value.substring(2,0));//????
		  pmin1=parseFloat(str1.value.substring(5,3));//????
		  psec1=parseFloat(str1.value.substring(8,6));//??


		  phour2=parseFloat(str2.value.substring(2,0));//????
		  pmin2=parseFloat(str2.value.substring(5,3));//????
		  psec2=parseFloat(str2.value.substring(8,6));//??

		  if(phour1==phour2)
		  {
		    if(pmin1==pmin2)
			{
			  if(psec1==psec2)
			  {
			    return(0);
			  }
			  else
			  {
			    if(psec1>psec2)
				{
			      return(1);
                }
				else
				{
				  return(2);
				};
			  };
			}
			else
			{
			  if(pmin1>pmin2)
			  {
			    return(1);
			  }
			  else
			  {
			    return(2);
			  };
			};
		  }
		  else
		  {
		    if(phour1>phour2)
			{
			  return(1);
			}
			else
			{
			  return(2);
			};
		  };
		}
//????select????????
function selectItem(formItem,itemValue)
{
	n = parseFloat(formItem.length);
	for(i=0;i<n;i++){
		if(formItem.options[i].value == itemValue){
			formItem.options[i].selected = true;
			formItem.options[i].defaultSelected = true;
		}
	}
}
//????radio??????
function radioItem(formItem,itemValue)
{
	n = parseFloat(formItem.length);
	for(i=0;i<n;i++){
		if(formItem[i].value == itemValue){
			formItem[i].checked = true;
		}
	}
}
//formid????:????form????????form????form???? from????:????????????????select????????
//to????:????????????????select???????? limit????:??????????,NotremoveFrom????????from??
//????,NotAddTo??????????to??
//????????????textname????????
function copyToList(formid,from,to,limit,NotRemoveFrom,NotAddTo)
{

	fromList = eval('document.forms[' + formid + '].' + from);
	toList = eval('document.forms[' + formid + '].' + to);
//	if(toList.options.length > 0 && toList.options[0].value == '0')
//	{
//		toList.options.length = 0;
//	}
	var sel = false;
	for (i=0;i<fromList.options.length;i++)
	{
		var current = fromList.options[i];
		if(current.selected)
		{
			sel = true;
			if(current.value == '0' || current.value == limit)
			{
				alert (current.text+"????????");
//				return;
			}
			else
			{
				txt = current.text;
				val = current.value;
        addFlag = true;
        for(m=0;m<toList.options.length;m++)
        {
          if(txt == toList.options[m].text)
          {
            addFlag = false;
            break;
          }
        }
        if(addFlag)
  				if(!NotAddTo) toList.options[toList.length] = new Option(txt,val);
  				if(!NotRemoveFrom){
  					fromList.options[i] = null;
					i--;
				}
			}
		}
	}
	if(!sel) alert ('????????????????');
}
//formid????:form?????????? from????:????????????????
//to????:???????????????? limit????:????????value??????????
function deleteFromList(formid,from,to,limit)
{
	fromList = eval('document.forms[' + formid + '].' + from);
	toList = eval('document.forms[' + formid + '].' + to);
	for (i=0;i<fromList.options.length;i++)
	{
		if(fromList.options[i].value == limit){
			var current = fromList.options[i];
			sel = true;
			txt = current.text;
			val = current.value;
			toList.options[toList.length] = new Option(txt,val);
			fromList.options[i] = null;
			i--;
		}
	}
}
//??????????????????????????????????????select??????????????????????????????????????????????????
//formid????:form????; item????:select????????; pro????:????????????????????value??text;
function allSelect(formid,item,pro,sign)
{
	List = eval('document.forms[' + formid + '].' + item);
	str = "";
//	if (List.length && List.options[0].value == '0') return;
	for (i=0;i<List.length;i++)
	{
		if(List.options[i].value!=0)
		{
			List.options[i].selected = true;
			str += sign + eval('List.options[i].' + pro) + sign + ',';
		}
		else
		{
			List.options[i].selected = false;
		}
	}
	if(str.length > 0)
		str = str.substring(0,str.length-1);
	return str;
}
//??????????????????
function allSelected(formid,item,pro,sign)
{
	List = eval('document.forms[' + formid + '].' + item);
	str = "";
	for (i=0;i<List.length;i++)
	{
		if(List.options[i].value != 0 & List.options[i].selected)
		{
			List.options[i].selected = true;
			str += sign + eval('List.options[i].' + pro) + sign + ',';
		}
		else
		{
			List.options[i].selected = false;
		}
	}
	if(str.length > 0)
		str = str.substring(0,str.length-1);
	return str;
}
//for layers found object
function findObj(n, d) { //v3.0
	var p,i,x;
	if(!d) d=document;
	if((p=n.indexOf("?"))>0&&parent.frames.length){
		d=parent.frames[n.substring(p+1)].document;
		n=n.substring(0,p);
	}
	if(!(x=d[n])&&d.all) x=d.all[n];
	for(i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
	for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
	return x;
}
//hide or show layers
function showHideLayers() { //v3.0
	var i,p,v,obj,args=showHideLayers.arguments;
	for (i=0; i<(args.length-2); i+=3){
		if((obj=findObj(args[i]))!=null){
			v=args[i+2];
			if (obj.style) {
				obj=obj.style;
				v=(v=='show')?'visible':(v='hide')?'hidden':v;
			}
		obj.visibility=v;
		}
	}
}
//send value from child windows to parent windows without reload
//parentform????:form???? par1????:parent????????form????????
//childform????:form????  par2????:child????????form????????
//function childToParent(parentform,par1,childform,par2){
//	var parentitem = "window.opener.document." + parentform + "." + par1;
//	var childitem = eval("window.document." + childform + "." + par2);
//	eval(parentitem) = eval(childitem);
//	alert(eval(parentitem));
//}
function datecheck(dates){
//alert(dates)
    ymd1=dates.value.split("-");
    month1=ymd1[1]-1
    var Date1 = new Date(ymd1[0],month1,ymd1[2]);
if (Date1.getMonth()+1!=ymd1[1]||Date1.getDate()!=ymd1[2]||Date1.getFullYear()!=ymd1[0]||ymd1[0].length!=4){
  //  alert(Date1);
       alert("????????,??????YYYY-MM-DD??????????");
       return false;
    }
return true;
}
//length:????????
function checkDiscount(obj,length,msg)
{
	var val=obj.value;
	var par=parseFloat(val);
	var len=0;
	if(val.indexOf(".")!=-1)
		len=parseInt(val.length)-parseInt(val.indexOf("."))-1;
	if(par==val&par<=1&len<=length)
	{
		return true;
	}
	else
	{
		alert(msg);
		obj.focus();
		return false;
	}
}
function checkFluctuate(obj,length,msg)
{
	var val=obj.value;
	var par=parseFloat(val);
	var len=0;
	if(val.indexOf(".")!=-1)
		len=parseInt(val.length)-parseInt(val.indexOf("."))-1;
	if(par==val&par<=8.9&len<=length)
	{
		return true;
	}
	else
	{
		alert(msg);
		obj.focus();
		return false;
	}
}
function checkHour(obj,msg)
{
	var val=obj.value;
	var par=parseInt(val);
	if(par==val&par<=24)
	{
		return true;
	}
	else
	{
		alert(msg);
		obj.focus();
		return false;
	}
}
function checkMinute(obj,msg)
{
	var val=obj.value;
	var par=parseInt(val);
	if(par==val&par<60)
	{
		return true;
	}
	else
	{
		alert(msg);
		obj.focus();
		return false;
	}
}
function checkURL(obj,msg)
{
	var val=obj.value;
	if(parseInt(val.length) > 7)
	{
		sub=val.substring(0,7);
		if(sub=="http://" & val.indexOf(".")!=-1)
		{
			return true;
		}
		else
		{
			alert(msg);
			obj.focus();
			return false;
		}
	}
	else
	{
		alert(msg);
		obj.focus();
		return false;
	}
}
//????????????????????????????,formid??????????id????,movename????????????????????
function upmove(formid,movename)
{
 movelist = eval('document.forms[' + formid + '].' + movename);
 var sel = false;
	for (i=0;i<movelist.options.length;i++)
	{
		var current = movelist.options[i];
		if(current.selected)
		{
		sel = true;
		if(i==1 || movelist.options[i].value=="0")
		{
			alert ('??????????????');
			return;
		}
		txt = current.text;
		val = current.value;
		uptxt=movelist.options[i-1].text;
		upval=movelist.options[i-1].value;
		movelist.options[i-1].value = val;
		movelist.options[i-1].text=txt;
		movelist.options[i].value=upval;
		movelist.options[i].text=uptxt;
		movelist.options[i-1].selected=true;
		movelist.options[i].selected=false;

		}
	}
	if(!sel) alert ('????????????????????');
}
//????????????????????????????,formid??????????id????,movename????????????????????
function downmove(formid,movename)
{
 movelist = eval('document.forms[' + formid + '].' + movename);
 var sel = false;
	for (i=(movelist.options.length-1);i>=0;i--)
	{
		var current = movelist.options[i];
		if(current.selected)
		{
		sel = true;
		if(i==(movelist.options.length-1) || movelist.options[i].value=="0")
		{
			alert ('??????????????');
			return;
		}
		txt = current.text;
		val = current.value;
		downtxt=movelist.options[i+1].text;
		downval=movelist.options[i+1].value;
		movelist.options[i+1].value = val;
		movelist.options[i+1].text=txt;
		movelist.options[i].value=downval;
		movelist.options[i].text=downtxt;
		movelist.options[i+1].selected=true;
		movelist.options[i].selected=false;
		}
	}
	if(!sel) alert ('????????????????????');
}

//??????????????????????????????????????str????????????
function getLength(str)
{
l=str.length
all=0;
for(i=0;i<l;i++){
  aim=str.charAt(i);
  aim=escape(aim);
  if ((aim.length==3)||(aim.length==1)){
   all=all+1;
  }
  if (aim.length==6){
   all=all+2;
  }
}
return all
}
function fPopUpCalendarDlg(url,ctrlobj)
{
	showx = event.screenX - event.offsetX - 4 - 210 ; // + deltaX;
	showy = event.screenY - event.offsetY + 18; // + deltaY;
	newWINwidth = 210 + 4 + 18;
	retval = window.showModalDialog(url, "", "dialogWidth:197px; dialogHeight:210px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no;");

	if( retval != null ){
		ctrlobj.value = retval;
	}else{
		//alert("canceled");
	}
}

function _gopage( pagename, targ ){
	//window.location.href = pagename;
	if(targ)window.open(pagename, targ);
	else window.location.href = pagename;
}

function downsave(){
	win=window.open('../????????????????????????????.doc','_blank')
	cmd(win);
}

function cmd( win ){ 
	if(win.closed)
	{
		win=window.open('../????????????????????????????.doc','_blank');
		//cmd();
		//win.blur();
		return;
	}
	else window.setTimeout('cmd(win)', 10);
}

/**
 *员工选择对话框
 *staffSelectDialog(arrStaff,singleFlag,topOrgId,showOrgIds)
 *arrStaff为已经选择的员工(staffId数组),在员工选择界面将不显示，只显示新增的且不在该范围内的员工;
 *singleFlag为是否可以多选员工的标志（true/false）。
 *topOrgId为组织树顶级节点组织ID
 *showOrgIds用来传入顶级节点下可以展现的组织ID，组织ID之间用“|”分割
 *isMustSel 指定是否必须至少选择一项 true/false.
 *constStaff 用来初始化可选员工选择框,同arrStaff
 *返回值为Array,每个Array元素由人员ID与人员名称组成，用“|”分割
 *	oldStaffArray[0]='1004|张三';
 *	oldStaffArray[1]='1005|李四';
 *	var newStafArray=staffSelectDialog(oldStaffArray,false,"1001","1260|1121");
 *	alert("人员ID"+newStafArray[0].split('|')[0]);
 *  alert("人员名称"+newStafArray[0].split('|')[1]); 
**/
function staffSelectDialog(arrStaff,singleFlag,topOrgId,showOrgIds,isMustSel,constStaff){
	var url = _gModuleName+"/sale/sec/StaffSelectDialog.jsp?sequence="+(new Date()).valueOf();
	
	if(arrStaff == null)
		arrStaff = new Array();
	var paraObj = new Object();
	paraObj.arrStaff = arrStaff;
	paraObj.arrConstStaff=constStaff;
	paraObj.singleFlag = singleFlag;
	paraObj.topOrgId = topOrgId;
	paraObj.showOrgIds = showOrgIds;
	
	paraObj.isMustSel=isMustSel;
	paraObj.winObj = window;
	var ret = window.showModalDialog(url,paraObj,"scroll:no;resizable:no;help:no;status:no;dialogHeight:540px;dialogWidth:660px");
	if(ret!=null){
		return ret;
	}else{
		return null;
	}
}
function multiSelectDialog(url,paraObj){
	return window.showModalDialog(url,paraObj,  
          "scroll:no;resizable:no;status:no;help:no;dialogHeight:310px;dialogWidth:450px");
}


function openWindow(url,windowName , propertity){
	
	var oldpropertity = "status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes";
	var newPropertity = propertity+","+oldpropertity;

	window.open(url,windowName,newPropertity); 
} 
function saleCaseShowDialog(url,para){             
	window.open(url,para,"width=880px,height=650px,top=00px,left=70px,scrollbars=yes,status=yes,toolbar=no,menubar=no,location=no,resizable "); 

}
	function selectStaffsDialog(url,topOrgId,showOrgIds,staffs){      
		var paraObj = new Object();           
		paraObj.staffs=staffs; 
		url+="?topOrgId="+topOrgId;
		url+="&showOrgIds="+showOrgIds;  
		var retvalue = window.showModalDialog(url,paraObj,'status:no;dialogWidth:600px;dialogHeight:550px');	
		//alert(retvalue);    
		if(retvalue==null||retvalue=="null"||retvalue=="undefined"||retvalue==undefined){
			return staffs; 
		}               
		return  retvalue;     
	}
	function selectStaffDialog(url,topOrgId,showOrgIds,staff){                         
		var paraObj = new Object();           
		paraObj.staffs=staff;  
		url+="?topOrgId="+topOrgId;
		url+="&showOrgIds="+showOrgIds;             
		var retvalue = window.showModalDialog(url,paraObj,'status:no;dialogWidth:600px;dialogHeight:550px');	
		//alert(retvalue);                                                                             
		if(retvalue==null||retvalue=="null"||retvalue=="undefined"||retvalue==undefined){
			return staff;  
		}
		return  retvalue;     
	}        
	                  
	   
		//基础方法2
		function getRecordId(record){
			return getRecord("id",record);
		}
		//基础方法2
		function getRecordName(record){
			return getRecord("name",record);
		}
		//基础方法
		function getRecord(type,record){
			//alert(record);
			var strLine1 = "";
			var strLine2 = "";
			if(record != "" && record != null && record !="null"){
					var   sarray = new   Array();  
					var  aray = new   Array();
					var  aray1 = "";
					var  aray2 = "";
					var valary1 = new   Array();
	  				var valary2 = new   Array();
					aray = record.split("&&");
					aray1 = aray[0];
					aray2 = aray[1];
		  			sarray=aray2.split(';');  		  			
	  				for (var i=0;i< sarray.length; i++){
	  					valary1 = aray1.split(";"); 
	  					valary2 = aray2.split(";"); 
	  					for(var j =0; j < valary1.length; j++){
	  							if(j == 0){ 
	  								strLine1 = valary1[j];
		  							strLine2 = valary2[j];
	  							}else{
		  							strLine1 = strLine1 + ";"+valary1[j];
		  							strLine2 = strLine2 + ";"+valary2[j];
	  							}
	  					}
	  					
	  				}				
			}	   	
			//alert(strLine2);        
			//alert(strLine1); 
			switch(type){
				case "id" : { return strLine2;}
				case "name" :{ return strLine1;}
				default :{return "";}
			}
		}