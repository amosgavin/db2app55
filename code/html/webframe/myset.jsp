<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>��������</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js" type="text/javascript"></script>
</head>

<body onload='init()'>
<ai:contractframe id="��������" contenttype="table" title="��������" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
<table width="96%" align="center" border="0" cellpadding="1" cellspacing="2">

 <tr><td height="100" align="center"><img src="images/icon/icon_023.gif"><br>
        <br>
        ѡ���Ƿ���ն��ţ�<br></td>
    <td align="center">����(Ĭ��)<br>
        <input type="radio" id="isReceive" name="smsFlag" value="1" ></td>
    <td align="center">������<br>
        <input type="radio" id="isReceive" name="smsFlag" value="0" ></td>
  </tr>
  <tr>
  	<td height="1" colspan="4" bgcolor="#CCCCCC"></td>
  </tr>
 <!--  <tr>
    <td height="100" align="center"><img src="images/font.gif"><br>
        <br>
        ѡ�����壺<br></td>
    <td align="center">12px(Ĭ������)<br>
        <input type="radio" id="fontChk" name="fontChk" value="1" checked></td>
    <td align="center">13px(�ϴ�����)<br>
          <input type="radio" id="fontChk" name="fontChk" value="2"></td>
    <td align="center">14px(�������)<br><input type="radio" id="fontChk" name="fontChk" value="3"></td>
  </tr>
  <tr>
  	<td height="1" colspan="4" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td align="center" height="100"><img src="images/skin.gif"><br>
        <br>ѡ����<br></td>
    <td height="180" align="center">
        <img src="images/classicalblue.gif"><br>
        <br>������ɫ���⣨Ĭ�ϣ�<br>
      <input name="colorChk" type="radio" id="colorChk" class="check" value="1" checked></td>
	<td align="center"><img src="images/softgreen.gif"><br>
	  <br>�滺��ɫ����<br>
        <input id="colorChk" name="colorChk" type="radio" class="check" value="2"></td>
    <td align="center"><img src="images/classicalvista.gif"><br>
      <br>����VISTA����<br>
        <input id="colorChk" name="colorChk" type="radio" class="check" value="3"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="center"><img src="images/asiainfoorange.gif"><br>
      <br>�����ɫ����<br>
        <input id="colorChk" name="colorChk" type="radio" class="check" value="4"></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
  	<td height="1" colspan="4" bgcolor="#CCCCCC"></td>
  </tr>-->
  <tr>
    <td colspan="4" align="center" height="50"><input name="Submit" type="button" id="Submit" value="ȷ��" class="btn-2word" onClick="changeStyle()">
    </td>
  </tr> 
</table>
</ai:contractframe>

</body>

<script type="text/javascript">

function init(){
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.PersonSetAction?action=getSMSFlag';
   	var ret = PostInfo(strUrl,null);
   	var smsFlag = ret.getValueByName("smsFlag");
   	if (smsFlag=="true"){
   		document.all.smsFlag[0].checked = true;
   	} else{
   		document.all.smsFlag[1].checked = true;
   	}
	//document.all.colorChk[stylecookie.charAt(1)-1].checked = true;
	//document.all.fontChk[stylecookie.charAt(2)-1].checked = true;
}

function changeStyle(){
	//var color1 = getChkValue(document.all.colorChk);
	//var font1= getChkValue(document.all.fontChk);
	var isReceiveSMS = getChkValue(document.all.smsFlag);
	
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.PersonSetAction?action=saveCurrentSet';
	var ret = postParamToServer(strUrl, 'isReceiveSMS=' + isReceiveSMS);
	
	//createCookie("style",("1"+ color1 +""+ font1));
	top.location.href = "index.jsp";
}

function getChkValue(elem){
	for(var i=0;i<elem.length;i++)
		if(elem[i].checked)
			return elem[i].value;
	return elem[0].value;
}
</script>
</html>