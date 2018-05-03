<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
 
<html>
<head>
<title>tab5</title>

</head>

<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/topopenwin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/openwin.js"></script>
<body>
<ai:contractframe id="客户信息" contenttype="table" title="客户信息" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
 <ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
         pagesize="10" width="100%" height="220" ondblink="">
          <ai:col fieldname="ATTACH_ID" width="10%"/>
       		<ai:col fieldname="BUSI_SHEET_ID" width="15%" />
       		<ai:col fieldname="BUSI_TYPE_CODE" width="15%" />
       		<ai:col fieldname="REMARKS" width="30%" />
       		<ai:col fieldname="NAME" width="30%" />
           </ai:table>
</ai:contractframe>

<div class="area_button">
  <ai:button text="弹出DIV窗口" id="query" onclick="query1()" />&nbsp;&nbsp;
  <ai:button text="成功" id="query" onclick="query2()" />&nbsp;&nbsp;
  <ai:button text="提示" id="query" onclick="query3()" />&nbsp;&nbsp;
  <ai:button text="警告" id="query" onclick="query4()" />&nbsp;&nbsp;
  <!--对于<a href>打开的窗口必须使用“#nogo”; -->
  <a href="#nogo" id="query" onClick="query3();">打开DIV提示窗口</a> 
</div>

</body>
</html>
<script language="javascript">
function query1(){
 ai.open('打开窗口1','<%=request.getContextPath()%>/webframe/example/open02.jsp',900,500);
}

function query2(){
	ai.success('流程申请成功','流程申请成功，是否继续？');
}

function query3(){
	ai.word('工单提交提示','您已完成工单提交，是否继续？');
}

function query4(){
	ai.alert('超时警告','您已超时，请重新登录！');
}
</script>