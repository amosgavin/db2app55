<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<HTML>
<head><title>set����ˢ��</title></head>
<body>
<table border=0 cellspacing=0 cellpadding=0 align="center" width="100%">
  <tr><td>
    <ai:contractframe id="set�����б�" contenttype="table" title="set�����б�" width="100%" allowcontract="false" frameclosed="false">
		  <ai:contractitem/>
		    <ai:table tableid="tblInfo" setname="com.ai.bce.web.BceAttr"
          tablemodel="com.ai.bce.web.SetCacheAction"
          needrefresh="true" initial="true" multiselect="true" editable="false" pagesize="100" height="220" width="100%">
         <ai:col fieldname="ATTR_NAME" width="100%" title="SET����"/>
       </ai:table>
		</ai:contractframe>
  </td></tr>
  <tr><td align="center">
    <ai:button text="ˢ�±��" onclick="refreshTbl()"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <ai:button text="���ѡ��set" onclick="clearSet()"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <ai:button text="ȫ�����" onclick="clearAll()"/>
  </td></tr>
</table>
</body>
</html>
<script language="javascript">
function getTbl(){
  return g_TableRowSetManager.get("tblInfo");
}

function refreshTbl(){
  getTbl().refresh();
}

function clearSet(){
  var selectedRows = getTbl().getSelectedRows();
  if(selectedRows.length == 0){
    alert("��ѡ��Ҫ�����set!");
    return;
  }
  if(confirm("ȷ�����?")==true){
    var sets = "";
    for(var i=0;i<selectedRows.length;i++){
      sets += getTbl().getValue(selectedRows[i],"ATTR_NAME") + ",";
    }
    var url = "<%=request.getContextPath()%>/business/com.ai.bce.web.SetCacheAction?action=refreshSet&SETS="+sets;
    var msg = PostInfo(url);
    alert(msg.getValueByName("MESSAGE"));
    refreshTbl();
  }
}

function clearAll(){
  if(confirm("ȷ��ȫ�����?")==true){
    var url = "<%=request.getContextPath()%>/business/com.ai.bce.web.SetCacheAction?action=refreshSet";
    var msg = PostInfo(url);
    alert(msg.getValueByName("MESSAGE"));
    refreshTbl();
  }
}
</script>
