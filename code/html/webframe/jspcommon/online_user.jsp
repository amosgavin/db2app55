<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=StyleSheet HREF="<%=request.getContextPath()%>/aicommon/sysjs/AIFrameDBCSS_css.jsp" TYPE="text/css">
<title>orgnizeҳ��</title>
<%@ include file="/webframe/jspcommon/includedhead.jsp"%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*"%>
<%@ page import="com.ai.appframe2.privilege.*"%>

<%
 String actionName = request.getParameter("actionName");
 if(actionName!=null && actionName.equals("del"))
 {

   String[] serialIds = request.getParameterValues("serialID");
   if(serialIds!=null && serialIds.length>0)
   {
    boolean killSelf = false;
    for(int i=0;i<serialIds.length;i++)
    {
      UserInfoInterface selUser = UserManagerFactory.getUserManager().getLogedUsersBySerialID(serialIds[i]);
      UserManagerFactory.getUserManager().loginOut(selUser);

    }
   }
 }
 UserInfoInterface[] users = com.ai.appframe2.privilege.UserManagerFactory.getUserManager().getLogedUsers();



%>
<SCRIPT LANGUAGE="JavaScript">
function refreshUser()
   {

       myform.actionName.value = "refresh";
       myform.submit();
   }
function delOnlineUser()
   {
      var checkboxArray= document.all.item("serialID");
	 // alert(checkboxArray.length);
      var selCodeStr ="";
      var selNum=0;
      if(checkboxArray==null)
	  {
	    alert("������Ա��");
	    return;
	  }
      if(checkboxArray.length)
	  {
	     //alert("checkboxArray.length="+checkboxArray.length);
	     for(var i=0;i<checkboxArray.length;i++)
		   {
		      if(checkboxArray[i].checked)
			  {
			    selNum++;
			    selCodeStr += checkboxArray[i].value+"$";
			 }
		   }
	 }
      else//ֻ��һ�������û�
	 {
	     alert(checkboxArray.checked);
		 if(checkboxArray.checked)
		 {
		  selCodeStr =checkboxArray.value;
		  selNum=1;
		 }
	  }
      //alert("selCodeStr="+selCodeStr+" selNum="+selNum);
      if(selCodeStr=="" || selNum==0)
	    alert("��ѡ��Ҫע��������Ա��");
      else
	  {
	    //alert("selCodeStr="+selCodeStr);
	if(window.confirm("�Ƿ�ȷ��Ҫע����Ա��"))
		{
			myform.actionName.value = "del";
			myform.submit();
		}

	  }


   }

function test(obj)
{
   var checkArray = document.all.item("sessionId");
  if(checkArray!=null && checkArray.length>0)
  {
    for(var i=0;i<checkArray.length;i++)
    {
	  checkArray[i].checked = obj.checked;
     }

  }
  else if(checkArray!=null)
    checkArray.checked = obj.checked;
}

function checkSelAction(obj)
{
  if(!obj.checked)
  {
    document.all.item("selAll").checked = false;
  }
}
</SCRIPT>
</head>
<body>
<form name="myform" method="POST" action="online_user.jsp" >
 <input type="hidden" name="actionName" value="">
<!--====================== ��ҳ�����������ҳ������=========================-->
<div style="width:100%;height:550;overflow:auto;">
<!--========ҳ�������������������̫�࣬����style����"overflow: auto;" ��Ⱥ͸߶ȿɵ�======-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="AreaTitle">��¼Ա����Ϣ</td>
  </tr>
</table>
<table align="center" width="80%">
 <tr bgcolor="#c6dcee" height="30">
    <td width="30"><input type="checkbox" id="selAll" name="selAll" onclick="test(this)"/></td>
    <td width="20%" class="FormTD" align="middle"><b>������ַ</b></td>
    <td width="20%" class="FormTD" align="middle"><b>Ա������</b></td>
    <td width="20%" class="FormTD" align="middle"><b>Ա������</b></td>
    <td width="20%" class="FormTD" align="middle"><b>������֯</b></td>
    <td width="20%" class="FormTD" align="middle"><b>��¼ʱ��</b></td>
     <td width="20%" class="FormTD" align="middle"><b>sessionid</b></td>
 </tr>
 <%
try{
 if(users!=null && users.length>0)
      {
	 for(int i=0;i<users.length;i++){

 %>
 <tr bgcolor="#F0F3FB" height="25">
   <td><input type="checkbox" id="serialID" name="serialID" value="<%=users[i].getSerialID()%>" onclick="checkSelAction(this)"/></td>
   <td class="FormTD" align="middle"><%=users[i].getIP()%></td>
   <td class="FormTD" align="middle"><%=users[i].getCode()%></td>
   <td class="FormTD" align="middle"><%=users[i].getName()%></td>
   <td class="FormTD" align="middle"><%=users[i].getOrgName()!=null?users[i].getOrgName():"&nbsp;"%></td>
   <td class="FormTD" align="middle"><%=users[i].getLoginTime()!=null?users[i].getLoginTime().toString():"&nbsp;"%></td>
   <td class="FormTD" align="middle"><%=users[i].getSessionID()!=null?users[i].getSessionID():"&nbsp;"%></td>
 <%
	}
  }
}
catch(Exception ex){}
 %>
</table>
<br> <br>
 <table align="center" width="80%">
 <tr>
    <td align="center">
		  <img src="<%=request.getContextPath()%>/image/button/logout.gif" style="cursor:hand;" align="absmiddle" value="ע��Ա��" name="delDetail" onclick="delOnlineUser()">
		  <img src="<%=request.getContextPath()%>/image/button/renovation.gif" style="cursor:hand;" align="absmiddle" value="ˢ���б�" name="delDetail" onclick="refreshUser()">
	</td>
 <tr>
 </table>

<!--======================  ҳ������ =========================-->
</div>
</form>
</BODY>


