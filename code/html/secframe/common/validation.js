/*
	Copyright 2002-2008 the original author or authors.
*/

/*
	Author(s): Hxx
*/

//У���Ƿ�ȫ���������
function isDigit(s)
{
    var patrn=/^[0-9]{1,20}$/;
    if (!patrn.exec(s)) return false
    return true
}
//У���¼����ֻ������5-20������ĸ��ͷ���ɴ����֡���_������.�����ִ�
function isRegisterUserName(s)
{
    var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
    if (!patrn.exec(s)) return false
    return true
}
//У���û�������ֻ������1-30������ĸ��ͷ���ִ�
function isTrueName(s)
{
    var patrn=/^[a-zA-Z]{1,30}$/;
    if (!patrn.exec(s)) return false
    return true
}
//У�����룺ֻ������6-20����ĸ�����֡��»���
function isPasswd(s)
{
    var patrn=/^(\w){6,20}$/;
    if (!patrn.exec(s)) return false
    return true
}
//У����ͨ�绰��������룺���ԡ�+����ͷ���������⣬�ɺ��С�-��
function isTel(s)
{
    //var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?(\d){1,12})+$/;
    var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s)) return false
    return true
}
//У���ֻ����룺���������ֿ�ͷ���������⣬�ɺ��С�-��
function isMobil(s)
{
    var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s)) return false
    return true
}
//У����������
function isPostalCode(s)
{
    //var patrn=/^[a-zA-Z0-9]{3,12}$/;
    var patrn=/^[a-zA-Z0-9 ]{3,12}$/;
    if (!patrn.exec(s)) return false
    return true
}
//У�������ؼ���
function isSearch(s)
{
    var patrn="/^[^`~!@#$%^&*()+=|\\\][\]\{\}:;'\,.<>/?]{1}[^`~!@$%^&()+=|\\\][\]\{\}:;'\,.<>?]{0,19}$/";
    if (!patrn.exec(s)) return false
    return true
}
//У���Ƿ�IP��ַ
function isIP(s) //by zergling
{
    var patrn=/^[0-9.]{1,20}$/;
    if (!patrn.exec(s)) return false
    return true
}
 
function isValidIPAddress(ipaddr) {
   var re = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;
   if (re.test(ipaddr)) {
      var parts = ipaddr.split(".");
      if (parseInt(parseFloat(parts[0])) == 0) { return false; }
      for (var i=0; i<parts.length; i++) {
         if (parseInt(parseFloat(parts[i])) > 255) { return false; }
      }
      return true;
   }
   
   return false;
}

<!-- Begin
function verifyIP (IPvalue) {
	errorString = "";
	theName = "IPaddress";
	
	var ipPattern = /^(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})$/;
	var ipArray = IPvalue.match(ipPattern);
	
	if (IPvalue == "0.0.0.0")
		errorString = errorString + theName + ': '+IPvalue+' is a special IP address and cannot be used here.';
	else if (IPvalue == "255.255.255.255")
		errorString = errorString + theName + ': '+IPvalue+' is a special IP address and cannot be used here.';
	if (ipArray == null)
		errorString = errorString + theName + ': '+IPvalue+' is not a valid IP address.';
	else {
		for (i = 0; i < 4; i++) {
			thisSegment = ipArray[i];
			if (thisSegment > 255) {
				errorString = errorString + theName + ': '+IPvalue+' is not a valid IP address.';
				i = 4;
			}
			if ((i == 0) && (thisSegment > 255)) {
				errorString = errorString + theName + ': '+IPvalue+' is a special IP address and cannot be used here.';
				i = 4;
	      	}
	   }
	}
	extensionLength = 3;
	if (errorString == "")
		alert ("That is a valid IP address.");
	else
		alert (errorString);
}
//  End -->

function isValidMacAddress(macAdd) 
 {
  var RegExPattern = /^[0-9a-fA-F:]+$/;
  
  if (!(macAdd.match(RegExPattern)) || macAdd.length != 17) 
	  return false;
  
  return true;
 }
 
 function ValidateAddrMac(addrMac)
{ 
	//var addMacReg = "/^\([0-9A-Z][0-9A-Z]:\)\{5\}[0-9A-Z][0-9A-Z]$/p";
	var addMacReg = /^([0-9A-Z][0-9A-Z]:){5}[0-9A-Z][0-9A-Z]$/;	
	
	if (addMacReg.test(addrMac))
		return true;
	return false;
}
 