<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/webframe/jspcommon/includedhead.jsp"%>
<%! String strPageLayoutId;String strBusinessObjectId;%>
<%
strPageLayoutId     =  request.getParameter("PAGE_LAYOUT_ID");
strBusinessObjectId =  request.getParameter("BUSINESS_OBJECT_ID");
%>
<!--
/**
 * @since 2005.10
 * @author ���²�
 * @version 1.0
 * */
-->
<html>
<head>
  <script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/FormRowSet.js"></script>
  <script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/TableRowSet.js"></script>
  <script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>

<title>
�û��Զ����ֶ���Ϣ��ѯ
</title>

</head>
<body bgcolor="#ffffff">
<label class="AreaTitleMx">�û��Զ����ֶ���Ϣ��ѯ</label>
<table align="center"><br>
  <tr>
    <td>
      <fieldset id="contentFieldset" style="width:620;text-align:right;font-size:12">
	<legend>��ѯ����</legend>
	<ai:dbform formid="UserDefineFieldQueryForm" setname="com.ai.appframe2.udfpage.SETUserDefinedProperty" initial="false">
	  <table align="center" style="width:600;text-align:right;font-size:12">
	    <tr>
             <td class="FormTDName" nowrap="nowrap">ҳ�沼�֣�</td>
             <td class="FormTD" align="left">
             	<ai:dbformfield fieldname="PAGELAYOUT_ID" width="180" formid="UserDefineFieldQueryForm"/>
             </td>
             <td class="FormTDName" nowrap="nowrap">ҵ�����</td>
	      <td class="FormTD" align="left">
		 <ai:dbformfield fieldname="BUSINESS_OBJECT_ID" width="180" formid="UserDefineFieldQueryForm"/>
	      </td>
            </tr>
            <tr>
	      <td class="FormTDName" nowrap="nowrap">�ֶ����ƣ�</td>
	      <td class="FormTD" colspan="3" align="left">
		 <input type="text" name="InputFieldName" style="width:442">
	      </td>
	      <td>
		<img src="/image/button/check.gif" style="cursor:hand;" align="absmiddle"  value="��ѯ" name="btn_qry" onclick="Query()" >
	      </td>
	    </tr>
	  </table>
	</ai:dbform>
      </fieldset>
    </td>
  </tr>

  <tr align="center">
    <td>
      <ai:table setname="com.ai.appframe2.udfpage.SETUserDefinedProperty" tableid="UserDefineFieldGrid" initial="false" editable="false" onrowchange="GridRowChange"
		  needrefresh="true" pagesize="30" multiselect="false" height="200" width="600">
	<table style="width:620;text-align:center;font-size:12" >
          <ai:col fieldname="PROP_ID" editable="false" visible="false"/>
          <ai:col fieldname="PAGELAYOUT_ID" editable="false"/>
          <ai:col fieldname="BUSINESS_OBJECT_ID" editable="false"/>
          <ai:col fieldname="TITLE" editable="false"/>
          <ai:col fieldname="NAME" editable="false"/>
          <ai:col fieldname="IS_MUST" editable="false"/>
          <ai:col fieldname="EDIT_TYPE" editable="false"/>
          <ai:col fieldname="DEFAULT_VALUE" editable="false"/>
          <ai:col fieldname="VALUE_LIST_ID" editable="false"/>
          <ai:col fieldname="INTERFACE_CLASS" editable="false"/>
          <ai:col fieldname="REMARKS" editable="false"/>
          <ai:col fieldname="STATE" editable="false" visible="false" />
	</table>
      </ai:table>
    </td>
  </tr>

    <tr align="center">
      <td>
	<fieldset id="contentFieldset" style="width:620;text-align:center;font-size:12">
	  <legend>��������</legend>
	  <table align="center" style="width:600;text-align:center;font-size:12">
	  <tr align="center">
	    <td width="155" align="center">
	      <img src="/image/button/add.gif" style="cursor:hand;"   align="absmiddle"  value="����" name="btn_add" onclick="Add()" >
	    </td>
	    <td width="155" align="center">
	      <img src="/image/button/amend.gif" style="cursor:hand;" align="absmiddle"  value="�޸�" name="btn_mod" onclick="Edit()" >
	    </td>
	    <td width="155" align="center">
	      <img src="/image/button/clean.gif" style="cursor:hand;" align="absmiddle"  value="ɾ��" name="btn_del" onclick="Delete()" >
	    </td>
	   </tr>
	  </table>
	</fieldset>
    </td>
    </tr>
</table>

</body>
</html>

<script LANGUAGE="JavaScript" for="window" even="onload">
  var strPropId = "";
  var strPageLayoutId = "<%=strPageLayoutId%>";
  var strBusinessObjectId = "<%=strBusinessObjectId%>";
  init();

  function init() {
    g_FormRowSetManager.get("UserDefineFieldQueryForm").setValue("BUSINESS_OBJECT_ID",strBusinessObjectId);
    g_FormRowSetManager.get("UserDefineFieldQueryForm").setValue("PAGELAYOUT_ID",strPageLayoutId);

    g_FormRowSetManager.get("UserDefineFieldQueryForm").setColEditSts("BUSINESS_OBJECT_ID",false);
    g_FormRowSetManager.get("UserDefineFieldQueryForm").setColEditSts("PAGELAYOUT_ID",false);

    g_TableRowSetManager.get("UserDefineFieldGrid").refresh("BUSINESS_OBJECT_ID = " + strBusinessObjectId + " AND PAGELAYOUT_ID=" + strPageLayoutId + " AND STATE = 'U'");
    g_TableRowSetManager.get("UserDefineFieldGrid").setRow(0);
    strPropId = g_TableRowSetManager.get("UserDefineFieldGrid").getValue(0,"PROP_ID");
  }

  function Query(){
    var strQry = " STATE = 'U' ";
    var strFieldName = InputFieldName.value;

    if (strBusinessObjectId!=null && strBusinessObjectId!=""){
      strQry = strQry + " AND BUSINESS_OBJECT_ID = " + strBusinessObjectId ;
    }
    if (strFieldName!=null && strFieldName!=""){
	 strQry = strQry + " AND NAME like '%" + strFieldName + "%'";
    }
    strQry =  strQry + " AND PAGELAYOUT_ID =" + strPageLayoutId;
    g_TableRowSetManager.get("UserDefineFieldGrid").refresh(strQry);
    var list = g_TableRowSetManager.get("UserDefineFieldGrid");
    if (list.count() > 0){
      list.setRow(0);
      strPropId = list.getValue(0,"PROP_ID");
    }else{
      strPropId = "";
      alert("δ�鵽�����������Զ����ֶ���Ϣ!");
    }
  }

  function Add(){
    //�ж��Ƿ���Խ�������
    var strAddFlag = PostInfotoServer("/business/com.ai.appframe2.udfpage.action.UserDefineFieldDataAction?action=getIsMayAddFlag&PageLayoutId=" + strPageLayoutId + "&BusinessObjectId=" + strBusinessObjectId,'');
    if (strAddFlag == "E" ){
      alert("ҵ����󲻴����Զ�����ֶ�!");
      return;
    }
    if (strAddFlag == "N" ){
      alert("ҵ������Զ����ֶεĸ����Ѿ��ﵽ���,�����Լ�������!\n\r����ɾ�����õ��Զ����ֶκ���������!");
      return;
    }
    var arr = new Array(4);
    arr[0] = strPropId;
    arr[1] = strPageLayoutId;
    arr[2] = strBusinessObjectId;
    arr[3] = "add";
    window.showModalDialog("/jsv2/udfpage/UserDefineField.jsp",arr,"scroll:yes;resizable:no;status:no;help:no;dialogHeight:360px;dialogWidth:700px");
    Query();
  }

  function GridRowChange(oldRow,newRow){
    var gridRowSet = g_TableRowSetManager.get("UserDefineFieldGrid");
    strPropId = gridRowSet.getValue(newRow,"PROP_ID");
  }

  function Delete(){
    if(confirm("��ȷ��ɾ��������¼��")){
      g_TableRowSetManager.get("UserDefineFieldGrid").setValue(g_TableRowSetManager.get("UserDefineFieldGrid").getRow(),"STATE",'E');
      var list = new Array();
      list.push(g_TableRowSetManager.get("UserDefineFieldGrid"));
      saveRowSet('/business/com.ai.appframe2.udfpage.action.UserDefineFieldDataAction?action=saveUserDefineFieldData',list);
      Query();
    }
  }

  function Edit() {
    if (strPropId == null || strPropId == ""){
    	return;
    }
    var arr = new Array(4);
    arr[0] = strPropId;
    arr[1] = strPageLayoutId;
    arr[2] = strBusinessObjectId;
    arr[3] = "modify";
    window.showModalDialog("/jsv2/udfpage/UserDefineField.jsp",arr,"scroll:yes;resizable:no;status:no;help:no;dialogHeight:360px;dialogWidth:700px");
    Query();
  }


</script>
