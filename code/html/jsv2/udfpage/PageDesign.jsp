<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/jspcommon/includedhead.jsp"%>
<!--
/**
 * @since 2005.10
 * @author ������
 * @version 1.0
 * */
-->
<html>
<title>ҳ�沼�ֶ���
</title>
<head>
		<script language="javascript" src="functions.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/NormalRowset.js"></script>
		<LINK rel="stylesheet" type="text/css" href="Styles.css">
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/HtmlParameter.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/NormalRowSet.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/FieldType_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/DataSource_v2.js"></script>

</head>
<body  onload="" >
<table width="100%" border="0" cellpadding="0" cellspacing="0" >
<tr>
<script language="javascript" src="drag.js"></script>
<SCRIPT>
    isIE = navigator.appName.indexOf("Microsoft") != -1;
    isIE5 = navigator.userAgent.indexOf('MSIE 5.0') > 0;
    isIE55 = navigator.userAgent.indexOf('MSIE 5.5') > 0;
    var isSelfService = '0';
	var isCaseClose = '0';
	var openedWindow = null;
	var currentSelectedObj = null;
    var selectedBucket = new Array();
    var mousedDown = false;
    var currentOffsetX = -1;
    var currentOffsetY = -1;
    var currentHighlightedObj = null;
    var initUsedFields = new Array();
    var maxSection = 0;
    var maxSectionTable = 0;
    var currentDisplayedDiv = null;
    var availableSectionInitPosX;
    var availableSectionInitPosY;
    var availableSectionPosInited = false;
    var cru;
    var displayProperties = false;
	var maxValues = 10;
    document.onmousemove = handleMouseMove;
    if (!isIE5) document.onmouseup = handleMouseUp;
	document.body.onbeforeunload = handleUnload;
</SCRIPT>
<td width="807" valign="top" style="padding-left:5px;">
<div id="Panel_Main">
<TABLE border="0" align="center">
    <TR>
        <TD align="center" bgColor="#ffffff" colSpan="2" style="FONT-WEIGHT: bold; FONT-SIZE: 10pt">
                ͼ����
        </TD>
        <TD width="20" bgColor="#DAA520"></TD>
        <TD>����ҳ�沼����</TD>
        <TD width="20" bgColor="#F5DEB3"></TD>
        <TD>��ҳ�沼����ʹ��</TD>
        <TD width="20" bgColor="#6699cc"></TD>
        <TD>ѡȡ</TD>
        <TD align="right" width="20">
                <IMG  src="../image/udfpage/required.gif"  align=top border=0 >
        </TD>
        <TD>������</TD>
        <TD align="right" width="20">
                <IMG    src="../image/udfpage/readonly.gif"   align=top border=0 >
        </TD>
        <TD>ֻ��</TD>
        <TD align="right" width="20">
        	���ԡ�
        </TD>
        <TD>�Զ�������</TD>

    </TR>
</TABLE>

<TABLE id="ep" cellSpacing="1" cellPadding="0" border="1" width="900" align="center">
<TR>
	<TD width="300" valign="top">
		<TABLE height=1 cellSpacing=0 cellPadding=0 border=0>
		<TBODY>
		<TR>
			<TD id=scrollBuffer bgColor=#0000ff height=1></TD>
		</TR>
		</TBODY>
		</TABLE>
		<DIV id="DivAvailableFieldList">
		</DIV>
		<DIV id="DivProperty">
		</DIV>
		<TABLE id="dragDummy" style="Z-INDEX: 1000; VISIBILITY: hidden; POSITION: absolute; BACKGROUND-COLOR: #000000"
	            height="15" cellSpacing="1" width="25" border=0>
			<TR>
				<TD id="dragDummyValue" style="BACKGROUND-COLOR: #6699cc" noWrap></TD>
			</TR>
		</TABLE>
 	</TD>
        <TD width="600" align="center"  colSpan="6"  valign="middle">
          <table align="center"  border="0" >
            <tr>
              <td>
                <DIV id="DivPageLayoutWorkArea">
                </DIV>
              </td>
            </tr>
            <tr align="center">
              <td>
                            <input  type="button" name="Crm_Control:btnSave" value="����" id="Crm_Control_btnSave" class="B" onclick="saveMe()"  style="width:80;cursor:hand;"/>&nbsp;&nbsp;
                            <INPUT onmouseup='doNothing(event);' class='B' onclick='FieldEdit(event)'; type=button value='�༭�ֶ�����' name='EditFieldProperties' style="width:80;cursor:hand;">&nbsp;
                            <INPUT class='B' onclick="newSection();" type='button' value="�½�ҳ�����" name='NewSection' style="width:80;cursor:hand;">
              </td>
            </tr>
            </table>
        </TD>
   </TR>
</TABLE>
</div>

</td>
</tr>
</table>

</body>
</html>
<script language="javascript">
  //ȡ����
 PAGE_LAYOUT_ID=gHtmlParameter.getParameter("PAGE_LAYOUT_ID");
 PAGE_LAYOUT_NAME=gHtmlParameter.getParameter("PAGE_LAYOUT_NAME");
 BUSINESS_OBJECT_NAME=gHtmlParameter.getParameter("BUSINESS_OBJECT_NAME");

  //�����յ�Section��NormalRowSet
  var parameter=g_ConditonStrEncode("1>2");
  var param="?action=queryRowSet&setName=com.ai.appframe2.udfpage.SETPageSection&param="+parameter;
  SectionNormalRs =g_NormalRowSetManager.create("virtual","/business/defaultaction"+param);
  if (SectionNormalRs==null){
    alert("����ҳ�沼�ַ���RS����");
  }

  //�����յ�Field��NormalRowSet
  var param="?action=queryRowSet&setName=com.ai.appframe2.udfpage.SETOwnerPageLayoutDetail&param="+parameter;
  FieldNormalRs =g_NormalRowSetManager.create("virtual","/business/defaultaction"+param);
  if (FieldNormalRs==null){
    alert("����ҳ�沼���ֶ�RS����");
  }
  //װ��������Ϣ
  var resu=PostInfotoServer("/business/com.ai.appframe2.udfpage.action.UserDefinePageAction?action=getPropertyHtml","");
  document.all.item("DivProperty").innerHTML=resu;
  //alert(resu);
  //װ�ص�ǰҳ�沼��
  var param="&PAGE_LAYOUT_ID="+PAGE_LAYOUT_ID;
  var resu=PostInfotoServer("/business/com.ai.appframe2.udfpage.action.UserDefinePageAction?action=getLayOutAreaHtml"+param,"");
  document.all.item("DivPageLayoutWorkArea").innerHTML=resu;
  //ִ��ҳ�沼�ֽ׶ε�Section��صĽű�
  if (document.all.item("DivSection")&&document.all.item("DivSection").innerHTML){
    eval(document.all.item("DivSection").innerHTML);
  }

  //װ�ص�ǰ�����ֶ�
  var param="&PAGE_LAYOUT_ID="+PAGE_LAYOUT_ID;
  param+="&PAGE_LAYOUT_NAME="+PAGE_LAYOUT_NAME;
  param+="&BUSINESS_OBJECT_NAME="+BUSINESS_OBJECT_NAME;
  var resu=PostInfotoServer("/business/com.ai.appframe2.udfpage.action.UserDefinePageAction?action=getAvalibaleFieldListHtml"+param,"");
  document.all.item("DivAvailableFieldList").innerHTML=resu;
  if (document.all.item("DivFieldList")&&document.all.item("DivFieldList".innerHTML)){
    eval(document.all.item("DivFieldList").innerHTML);
  }

</script>
