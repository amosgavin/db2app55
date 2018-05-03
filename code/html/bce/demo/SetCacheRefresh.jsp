<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<HTML>
<head><title>set缓存刷新</title></head>
<body>
<table border=0 cellspacing=0 cellpadding=0 align="center" width="100%">
  <tr><td>
    <ai:contractframe id="set缓存列表" contenttype="table" title="set缓存列表" width="100%" allowcontract="false" frameclosed="false">
		  <ai:contractitem/>
		    <ai:table tableid="tblInfo" setname="com.ai.bce.web.BceAttr"
          tablemodel="com.ai.bce.web.SetCacheAction"
          needrefresh="true" initial="true" multiselect="true" editable="false" pagesize="100" height="220" width="100%">
         <ai:col fieldname="ATTR_NAME" width="100%" title="SET名称"/>
       </ai:table>
		</ai:contractframe>
  </td></tr>
  <tr><td align="center">
    <ai:button text="刷新表格" onclick="refreshTbl()"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <ai:button text="清除选中set" onclick="clearSet()"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <ai:button text="全部清除" onclick="clearAll()"/>
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
    alert("请选择要清除的set!");
    return;
  }
  if(confirm("确定清除?")==true){
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
  if(confirm("确定全部清除?")==true){
    var url = "<%=request.getContextPath()%>/business/com.ai.bce.web.SetCacheAction?action=refreshSet";
    var msg = PostInfo(url);
    alert(msg.getValueByName("MESSAGE"));
    refreshTbl();
  }
}
</script>
