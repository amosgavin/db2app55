<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/jspcommon/includedhead.jsp"%>
<%@ taglib uri="/WEB-INF/pagelayout.tld" prefix="pagelayout" %>
<!--
/**
 * @since 2005.10
 * @author ������
 * @version 1.0
 * */
-->
<html>
<title>����Section������
</title>
<head>

</head>
<body  onload="" >

<table>
  <tr>
    <td>���⣺</td>
    <td><input type="text" name="secTitle" size="10"></td>
  </tr>
  <tr>
    <td>ÿ��������</td>
    <td><input type="text" name="secCols" size="10" value="2"></td>
  </tr>
  <tr>
    <td>��ȣ�</td>
    <td><input type="text" name="secWidth" size="10" value="700"></td>
  </tr>
  <tr>
    <td>�Ƿ�ָ����⣺</td>
    <td>
      <select id="secIsDisp">
        <option selected>��</option>
        <option>��</option>
      </select>
    </td>
  </tr>
  <tr align="center">
    <td colspan="2"><input type="button"  class="B" value=" ȷ �� " onclick="ok();"/></td>
  </tr>
</table>

</body>
</html>
<script language="javascript">
 var gParamObject = dialogArguments;
 if (gParamObject){
   if (gParamObject.isEdit==true){
     var aTitle=gParamObject.title;
     var aCol=gParamObject.cols;
     var aIsDisp=gParamObject.isDisp;
     var aSecWidth=gParamObject.secWidth;
     document.all.item("secTitle").value=aTitle;
     document.all.item("secCols").value=aCol;
     document.all.item("secWidth").value=aSecWidth;
     document.all.item("secCols").disabled=true;
     if (aIsDisp=="Y"){
       document.all.item("secIsDisp")[0].selected=true;
     }else{
       document.all.item("secIsDisp")[1].selected=true;
     }
   }
 }
 function ok(){
   var aTitle=document.all.item("secTitle").value;
   var aCol=document.all.item("secCols").value;
   var aSecWidth=document.all.item("secWidth").value;
   if (aTitle==null||aTitle==""){
     alert("��������ɲ��ֱ��⣡");
     return;
   }
  if (aCol==null||aCol==""){
     alert("��������ɲ���ÿ�е�������");
     return;
   }
  if (aSecWidth==null||aSecWidth==""){
	aSecWidth=0;
   }
   var aIsDisp="N";
   if (document.all.item("secIsDisp")[0].selected==true){
     aIsDisp="Y";
   }
   var retValue=new Object();
   retValue.title=aTitle;
   retValue.cols=aCol;
   retValue.secWidth=aSecWidth;
   retValue.isDisp=aIsDisp;
   top.returnValue=retValue;
   top.close();
 }
</script>
