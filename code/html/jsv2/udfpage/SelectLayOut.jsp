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
<title>ѡ��ҳ�沼��
</title>
<head>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>

</head>
<body  onload="" >

<table align="center">
  <tr align="center">
    <td class="FormTDName">ѡ��ҵ�����</td>
    <td class="FormTD"><ai:listbox ds="com.ai.appframe2.udfpage.DSBusinessObject" id="lblBusinessObject" width="200"  onchange="refreshPageLayout();"
      nullid="-1" nulltext="��ѡ��ҵ�����" /></td>
  </tr>
  <tr align="center">
    <td class="FormTDName">ѡ��ҵ�񲼾֣�</td>
    <td class="FormTD"><ai:listbox ds="com.ai.appframe2.udfpage.DSPageLayout" id="lblPageLayout" width="200"
      nullid="-1"  nulltext="��ѡ��ҳ�沼��"/></td>
  </tr>
  <tr align="center">
    <td  colspan="2">
      <input type="button"  value="�½�ҳ�沼��" onclick="newLayout();" class="B" style="width:100"/>
      <input type="button"  value="�༭�Զ����ֶ�" onclick="udfField();" class="B" style="width:100"/>
    </td>
 </tr>
 <tr align="center">
   <td   colspan="2">
      <input type="button"  value="�༭ҳ�沼��" onclick="nextPage();" class="B" style="width:100"/>
      <input type="button"  value="ɾ��ҳ�沼��" onclick="deletePage();" class="B" style="width:100"/>
    </td>
  </tr>
</table>

</body>
</html>
<script language="javascript">
 refreshPageLayout();
 function newLayout(){
   aBusinessObjectId=g_getListBox("lblBusinessObject").getID();
   if (aBusinessObjectId&&aBusinessObjectId!=-1){
     BUSINESS_OBJECT_NAME=g_getListBox("lblBusinessObject").getValue();
     var param="?BUSINESS_OBJECT_ID="+aBusinessObjectId+"&BUSINESS_OBJECT_NAME="+BUSINESS_OBJECT_NAME;
     var r=window.showModalDialog("NewPageLayOut.jsp"+param,window,"scroll:no;resizable:no;status:no;dialogHeight:300px;dialogWidth:300px");
     if (r!=null&&r!=-1){
       alert("����ҵ�񲼾ֳɹ���");
       refreshPageLayout();
     }
   } else{
     alert("��ѡ��ҵ�����");
   }
 }

 function refreshPageLayout(){
   aBusinessObjectId=g_getListBox("lblBusinessObject").getID();
   if (aBusinessObjectId&&aBusinessObjectId!=-1){
     BUSINESS_OBJECT_NAME=g_getListBox("lblBusinessObject").getValue();
     refreshListBox("lblPageLayout","pBusinessObjectId="+aBusinessObjectId);
     g_getListBox("lblPageLayout").addItem("-1","��ѡ��ҳ�沼��");
   }else{
     g_getListBox("lblPageLayout").setValue("-1");
   }
 }

 function nextPage(){
   PAGE_LAYOUT_ID=g_getListBox("lblPageLayout").getID();
   if (PAGE_LAYOUT_ID&&PAGE_LAYOUT_ID>0){
     PAGE_LAYOUT_NAME=g_getListBox("lblPageLayout").getValue();
     window.location="PageDesign.jsp?PAGE_LAYOUT_ID="+PAGE_LAYOUT_ID
     +"&PAGE_LAYOUT_NAME="+PAGE_LAYOUT_NAME
     +"&BUSINESS_OBJECT_NAME="+BUSINESS_OBJECT_NAME;
   }else{
     alert("��ѡ��һ��ҳ�沼�֣�");
     return;
   }
 }

function deletePage(){
   PAGE_LAYOUT_ID=g_getListBox("lblPageLayout").getID();
   PAGE_LAYOUT_NAME=g_getListBox("lblPageLayout").getValue();
   if (PAGE_LAYOUT_ID&&PAGE_LAYOUT_ID>0){
     if (confirm("��ȷ��ɾ��ҳ�沼��"+PAGE_LAYOUT_NAME+"��")){
       var param="&PAGE_LAYOUT_ID="+PAGE_LAYOUT_ID;
     	var resu=PostInfo("/business/com.ai.appframe2.udfpage.action.UserDefinePageAction?action=deletePageLayout"+param,"").getValueByName("RESU");
        if (resu!="Y"){
          alert(resu);
        }else{
          //ˢ���б�
          alert("ҳ�沼��"+PAGE_LAYOUT_NAME+"ɾ���ɹ���");
          refreshPageLayout();
        }
     }
   }else{
     alert("��ѡ��һ��ҳ�沼�֣�");
     return;
   }
 }

 function udfField(){
   PAGE_LAYOUT_ID=g_getListBox("lblPageLayout").getID();
   aBusinessObjectId=g_getListBox("lblBusinessObject").getID();
   if (PAGE_LAYOUT_ID&&PAGE_LAYOUT_ID>0){
     PAGE_LAYOUT_NAME=g_getListBox("lblPageLayout").getValue();
     window.location="UserDefineFieldQuery.jsp?PAGE_LAYOUT_ID="+PAGE_LAYOUT_ID
     +"&PAGE_LAYOUT_NAME="+PAGE_LAYOUT_NAME
     +"&BUSINESS_OBJECT_ID="+aBusinessObjectId
     +"&BUSINESS_OBJECT_NAME="+BUSINESS_OBJECT_NAME;
   }else{
     alert("��ѡ��һ��ҳ�沼�֣�");
     return;
   }
 }
 PAGE_LAYOUT_ID=null;
 PAGE_LAYOUT_NAME=null;
 BUSINESS_OBJECT_NAME=null;
</script>
