<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/webframe/jspcommon/includedhead.jsp"%>
<!--
/**
 * @since 2005.10
 * @author ���²�
 * @version 1.0
 * */
-->
<html>
<head>
<title>
�û��Զ����ֶι���
</title>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>

</head>
<body bgcolor="#ffffff">
<label class="AreaTitleMx">�û��Զ����ֶ���Ϣά��</label>
<table align="center"><br>
  <tr align="center">
    <td>
      <fieldset id="contentFieldset" style="width:620;text-align:center;font-size:12">
	<legend>�û��Զ����ֶ���Ϣ</legend>
	<ai:dbform formid="UserDefineFieldForm" setname="com.ai.appframe2.udfpage.SETUserDefinedProperty" initial="false">
	    <table align="center" style="width:600;text-align:center;font-size:12">
             <tr>
               <td><ai:dbformfield fieldname="PROP_ID" width="150" visible="false" formid="UserDefineFieldForm"/>
             </tr>
	     <tr>
               	<td class="FormTDName">ҳ�沼�֣�</td>
                <td class="FormTD">
                  <ai:dbformfield fieldname="PAGELAYOUT_ID" width="150" formid="UserDefineFieldForm"/>
                </td>
                <td class="FormTDName">ҵ�����</td>
                <td class="FormTD">
                  <ai:dbformfield fieldname="BUSINESS_OBJECT_ID" width="150" formid="UserDefineFieldForm"/>
		</td>
             </tr>
             <tr>
                <td class="FormTDName">�ֶα��⣺</td>
		<td class="FormTD">
		   <ai:dbformfield fieldname="TITLE" width="150" formid="UserDefineFieldForm"/>
		</td>
                <td class="FormTDName">�ֶ����ƣ�</td>
                <td class="FormTD">
                  <ai:dbformfield fieldname="NAME" width="150" formid="UserDefineFieldForm"/>
		</td>
             </tr>
             <tr>
               <td class="FormTDName">�༭���ͣ�</td>
		<td class="FormTD">
		   <ai:dbformfield fieldname="EDIT_TYPE" width="150" formid="UserDefineFieldForm"/>
		</td>
               <td class="FormTDName">�Ƿ���</td>
                <td class="FormTD">
                  <ai:dbformfield fieldname="IS_MUST" width="150" formid="UserDefineFieldForm"/>
		</td>
             </tr>
             <tr>
               <td class="FormTDName">ȱʡֵ��</td>
              	<td class="FormTD">
                  <ai:dbformfield fieldname="DEFAULT_VALUE" width="150" formid="UserDefineFieldForm"/>
		</td>
             </tr>
             <tr>
               <td class="FormTDName">����ֵ�б�</td>
		<td class="FormTD" colspan="3">
		   <ai:dbformfield fieldname="VALUE_LIST_ID" width="290" formid="UserDefineFieldForm"/>
                   <input type="button" value="���" name="btn_input" onclick="Input()">(����ֵ֮����;���)
		</td>
             </tr>
             <tr>
                <td class="FormTDName">�ӿ��ࣺ</td>
                <td class="FormTD" colspan="3">
                  <ai:dbformfield fieldname="INTERFACE_CLASS" width="450" formid="UserDefineFieldForm"/>
		</td>
             </tr>
             <tr>
		<td class="FormTDName">��ע��</td>
		<td class="FormTD" colspan="3"><ai:dbformfield fieldname="STATE" visible="false" width="150" formid="UserDefineFieldForm"/>
		  <ai:dbformfield fieldname="REMARKS" width="450" formid="UserDefineFieldForm"/>
		</td>
	     </tr>
	  </table>
	</ai:dbform>
      </fieldset>
    </td>
  </tr>

    <tr align="center">
      <td>
	  <table align="center" style="width:600;text-align:center;font-size:12">
	  <tr align="center">
	    <td align="center">
	      <img src="/image/button/save.gif" style="cursor:hand;" align="absmiddle"   value="����" name="btn_save" onclick="Save()" >
	    </td>
	  </tr>
	  </table>
    </td>
    </tr>
</table>

</body>
</html>

<script LANGUAGE="JavaScript" for="window" even="onload">
  var strParameterarr = window.dialogArguments;
  var strPropId = strParameterarr[0];
  var strPageLayoutId = strParameterarr[1];
  var strBusinessObjectId = strParameterarr[2];
  var strOperType = strParameterarr[3];
  init();

  function init() {
    if (strOperType != "add") {
    	g_FormRowSetManager.get("UserDefineFieldForm").refresh("PROP_ID = " + strPropId);
    }
    if ( strOperType == "add"){
      Add();
    }else if (strOperType == "modify"){
      Edit();
    }else{
      Delete();
    }
  }

  function Add(){
    setStatus(strOperType);
    g_FormRowSetManager.get("UserDefineFieldForm").newRow();
    //�˴�setֵ��Ϊ��NAME����������Դ�ķ����ܹ�ִ��
    g_FormRowSetManager.get("UserDefineFieldForm").setValue("PROP_ID","-1");
    g_FormRowSetManager.get("UserDefineFieldForm").setValue("PAGELAYOUT_ID",strPageLayoutId);
    g_FormRowSetManager.get("UserDefineFieldForm").setValue("BUSINESS_OBJECT_ID",strBusinessObjectId);
    g_FormRowSetManager.get("UserDefineFieldForm").setColEditSts("BUSINESS_OBJECT_ID",false);
    g_FormRowSetManager.get("UserDefineFieldForm").setValue("STATE","U");
    g_FormRowSetManager.get("UserDefineFieldForm").setValue("IS_MUST","N","��");
  }

  function Save(){
    if(confirm("��ȷ��Ҫ������")){
      	var strBusinessObjectId = g_FormRowSetManager.get("UserDefineFieldForm").getValue("BUSINESS_OBJECT_ID");
      	var strTitle = g_FormRowSetManager.get("UserDefineFieldForm").getValue("TITLE");
      	var strName  = g_FormRowSetManager.get("UserDefineFieldForm").getValue("NAME");
       	var strEditType = g_FormRowSetManager.get("UserDefineFieldForm").getValue("EDIT_TYPE");
       	//var strDecimalNum =  g_FormRowSetManager.get("UserDefineFieldForm").getValue("DECIMAL_NUM");
      	if ( strOperType != "delete" && strBusinessObjectId == null || strBusinessObjectId == ""){
           alert("ҵ����󲻿�Ϊ��,������!");
           return;
      	}
      	if ( strOperType != "delete" && strTitle == null || strTitle == ""){
           alert("�ֶα��ⲻ��Ϊ��,������!");
           return;
      	}
      	if ( strOperType != "delete" && strName == null || strName == ""){
           alert("�ֶ����Ʋ���Ϊ��,������!");
           return;
      	}
      	if ( strOperType != "delete" && strEditType == null || strEditType == ""){
           alert("�༭���Ͳ���Ϊ��,������!");
           return;
      	}
        //�ж��ֶα����Ƿ����
        var strIsTitleExist = PostInfotoServer("/business/com.ai.appframe2.udfpage.action.UserDefineFieldDataAction?action=getIsFieldTitleExists&PageLayoutId=" + strPageLayoutId + "&BusinessObjectId=" + strBusinessObjectId + "&Title=" + strTitle + "&FieldName=" + strName,'');
        if (strIsTitleExist == "Y"){
          alert("�ڶ�Ӧ��ҳ�沼�ֺ�ҵ������Զ����ֶζ�����,�ֶα����Ѿ�����,����������!");
          return;
        }
        //�����õ�prop_idֵ���
        if ( strOperType == "add"){
          g_FormRowSetManager.get("UserDefineFieldForm").setValue("PROP_ID","");
        }
    	var list = new Array();
    	list.push(g_FormRowSetManager.get("UserDefineFieldForm"));
    	saveRowSet('/business/com.ai.appframe2.udfpage.action.UserDefineFieldDataAction?action=saveUserDefineFieldData',list);
        window.close();
    }
  }

  function Delete(){
    var rowSet = g_FormRowSetManager.get("UserDefineFieldForm");
    rowSet.setValue("STATE",'E');
    setStatus(strOperType);
  }

  function Edit() {
    setStatus("modify");
    setStatus(strOperType);
    g_FormRowSetManager.get("UserDefineFieldForm").setColEditSts("BUSINESS_OBJECT_ID",false);
    g_FormRowSetManager.get("UserDefineFieldForm").setColEditSts("PAGELAYOUT_ID",false);
  }

  function setStatus(status){
    if(status == "delete"){
      g_FormRowSetManager.get("UserDefineFieldForm").setEditSts(false);
    }
    else if ((status == "add") || (status = "modify")){
      g_FormRowSetManager.get("UserDefineFieldForm").setEditSts(true);
      g_FormRowSetManager.get("UserDefineFieldForm").setColEditSts("BUSINESS_OBJECT_ID",false);
      g_FormRowSetManager.get("UserDefineFieldForm").setColEditSts("PAGELAYOUT_ID",false);
    }
  }

  function Input(){
    var strPropValue =  window.showModalDialog("/jsv2/udfpage/ValueListInputDlg.jsp",window,"scroll:yes;resizable:no;status:no;help:no;dialogHeight:200px;dialogWidth:300px");
    if (strPropValue != null && strPropValue != "" && strPropValue != "null"){
    	var strPropValues = g_FormRowSetManager.get("UserDefineFieldForm").getValue("VALUE_LIST_ID");
        if (strPropValues == null || strPropValues == ""){
          g_FormRowSetManager.get("UserDefineFieldForm").setValue("VALUE_LIST_ID",strPropValue);
        }else{
          g_FormRowSetManager.get("UserDefineFieldForm").setValue("VALUE_LIST_ID",strPropValues + ";" + strPropValue);
        }
    }
  }


</script>
