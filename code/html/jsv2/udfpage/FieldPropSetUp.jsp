<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/jspcommon/includedhead.jsp"%>
<%@ taglib uri="/WEB-INF/pagelayout.tld" prefix="pagelayout" %>

<html>
<title>�����ֶε�ColSpan�Ϳ��
</title>
<head>

</head>
<body  onload="" >
<table align="center">
  <tr>
    <td colspan="4"><label >ColSpan������1����10��֮�������</label></td>
  </tr>
  <tr>
    <td  class="FormTDName">ԭColSpan��</td>
    <td class="FormTD"><label id="oldColSpan" ></label></td>
    <td class="FormTDName">��ColSpan��</td>
    <td class="FormTD"><input type="text" name="newColSpan" size="10" ></td>
  </tr>
  <tr>
    <td  class="FormTDName">ԭ��󳤶ȣ�</td>
    <td class="FormTD"><label id="oldMaxLength" ></label></td>
    <td class="FormTDName">����󳤶ȣ�</td>
    <td class="FormTD"><input type="text" name="newMaxLength" size="10" ></td>
  </tr>
  <tr>
    <td  class="FormTDName">ԭС��λ����</td>
    <td class="FormTD"><label id="oldDecimalLength" ></label></td>
    <td class="FormTDName">��С��λ����</td>
    <td class="FormTD"><input type="text" name="newDecimalLength" size="10" ></td>
  </tr>
  <tr align="center">
    <td colspan="4" align="center"><input type="button"  value="ȷ��" onclick="ok();"/></td>
  </tr>
</table>

</body>
</html>
<script language="javascript">
OLD_COL_SPAN=null;
OLD_MAX_LENGTH=null;
OLD_DECIMAL_LENGTH=null;
 var gParamObject = dialogArguments;
 if (gParamObject){
     var aOldColSpan=gParamObject.oldColSpan;
     if (aOldColSpan!=null){
       document.all.item("oldColSpan").innerText=aOldColSpan;
       document.all.item("newColSpan").value=aOldColSpan;
       OLD_COL_SPAN=aOldColSpan;
     }
//     var isCanModifyLength=gParamObject.isCanModifyWidth;
//     if (isCanModifyLength==false){
//       document.all.item("newMaxLength").disabled=true;
//       document.all.item("newDecimalLength").disabled=true;
//     }
     var aOldMaxLength=gParamObject.oldMaxLength;
     if (aOldMaxLength!=null){
       document.all.item("oldMaxLength").innerText=aOldMaxLength;
       document.all.item("newMaxLength").value=aOldMaxLength;
       OLD_MAX_LENGTH=aOldMaxLength;
     }
     var aOldDecimalLength=gParamObject.oldDecimalLength;
     if (aOldDecimalLength!=null){
       document.all.item("oldDecimalLength").innerText=aOldDecimalLength;
       document.all.item("newDecimalLength").value=aOldDecimalLength;
       OLD_DECIMAL_LENGTH=aOldDecimalLength;
     }
 }
 function ok(){
   var aNewColSpan=document.all.item("newColSpan").value;
   var aNewMaxLength=document.all.item("newMaxLength").value;
   var aNewDecimalLength=document.all.item("newDecimalLength").value;

   if (aNewColSpan==aOldColSpan&&aNewMaxLength==aOldMaxLength&&aOldDecimalLength==null){
     alert("��û���޸��κ����ݣ�");
     return;
   }
   if (aNewColSpan&&(aNewColSpan<=0 || aNewColSpan>10)){
     alert("������1����10��֮���ColSpan��");
     return;
   }

   var retObj=new Object();
   retObj.colSpan=aNewColSpan;
   retObj.maxLength=aNewMaxLength;
   retObj.decimalLength=aNewDecimalLength;
   top.returnValue=retObj;
   top.close();
 }
</script>
