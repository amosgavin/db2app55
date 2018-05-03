<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>标题/套框组件汇总模板</title>
<!--标题/套框组件汇总模板页面说明 -->
<!--
1、本模板适用于各种标题/套框组件的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、ai:contentframe使用注意：宽度请设置100%，高度由里面内容自然撑开；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）；
5、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
 -->
</head>

<body>
<ai:contentframe id="客户信息1" title="客户信息1" width="99%" contenttype="table">
	 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">客户名称：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/><span class="font_red">*</span></td>
           <td class="td_font">联系电话：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/><span class="font_red">*</span></td>
           <td class="td_font">客户属性：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">联系地址：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/><span class="font_red">*</span></td>
           <td class="td_font">邮政编码：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">备注：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>
</ai:contentframe>

<ai:contractframe id="客户信息2" title="客户信息2" width="100%" contenttype="table" allowcontract="true" frameclosed="false">
  <ai:contractitem/>
	 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">客户名称：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:130"/><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="选择客户" onClick="sel_org();" align="absmiddle" style="cursor:hand;"/></td>
           <td class="td_font">联系电话：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">客户属性：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:130"/><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/add.gif"  alt="增加客户属性" onClick="sel_org();" align="absmiddle" style="cursor:hand;"/></td>
		</tr>
		<tr>
           <td class="td_font">联系地址：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">邮政编码：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:130"/><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/refresh.gif"  alt="刷新编码" onClick="sel_org();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
           <td class="td_font">备注：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>
</ai:contractframe>

<ai:contractframe id="客户信息3" title="客户信息3" width="100%" contenttype="table" allowcontract="true" frameclosed="false">
	<ai:contractitem>
	<div class="t-bot-mc-word"><span class="font_red">注：</span>点击“更多信息”显示更多查询信息</div>
    <div class="t-bot-mc-button">
           <ai:button text="+更多信息" id="btnMore" onclick="moreQueryCondition();" />&nbsp;&nbsp;
           <ai:button text="查询" id="" onclick="" />&nbsp;&nbsp;
		   <ai:button text="重置" id="" onclick="" />
	</div>
	</ai:contractitem>
	 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">客户名称：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:130"/><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/check.gif"  alt="选择组织" onClick="sel_org();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
           <td class="td_font">联系电话：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">客户属性：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">联系地址：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">邮政编码：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:130"/><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/clean.gif"  alt="清除编码" onClick="sel_org();" align="absmiddle" style="cursor:hand;"/></td>
           <td class="td_font">备注：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>  
      <!-- 隐藏的更多查询条件 -->
      <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" id="moreQueryCondition" style="display:none">
         <tr>
           <td class="td_font">客户名称1：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/><span class="font_red">*</span></td>
           <td class="td_font">联系电话1：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">客户属性1：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">联系地址1：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">邮政编码1：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">备注1：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>    
</ai:contractframe>

<ai:contractframe id="客户信息4" title="客户信息4" width="100%" contenttype="table" allowcontract="true" frameclosed="true">
	<ai:contractitem>
	<div class="t-bot-mc-left">捆绑套餐：<span class="font_red">99元包月</span>&nbsp;&nbsp;预缴：<span class="font_red">200元</span>&nbsp;&nbsp;催缴：<span class="font_red">无</span></div>
    <div class="t-bot-mc-button">
			<ai:button text="新增" id="" onclick="" classname="icon_add" />
	        <ai:button text="修改" id="" onclick="" classname="icon_modifiy" />
	        <ai:button text="导出" id="" onclick="" classname="icon_port" />
	        <ai:button text="标记完成" id="" onclick="" classname="icon_finish" />
	</div>
	</ai:contractitem>
	 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">客户名称：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">联系电话：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">客户属性：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">联系地址：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">邮政编码：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">备注：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>      
</ai:contractframe>

<ai:contractframe id="客户信息5" title="客户信息5" width="100%" contenttype="table" allowcontract="true" frameclosed="false">
	<ai:contractitem>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
         <tr height="22">
           <td><img src="<%=request.getContextPath()%>/webframe/images/icon_add.gif" align="absmiddle">&nbsp;<a href="#nogo" class="a">新增</a>&nbsp;&nbsp;
           <img src="<%=request.getContextPath()%>/webframe/images/icon_modifiy.gif" align="absmiddle">&nbsp;<a href="#nogo" class="a">修改</a>&nbsp;&nbsp;
           <img src="<%=request.getContextPath()%>/webframe/images/icon_port.gif" align="absmiddle">&nbsp;<a href="#nogo" class="a">导出</a>&nbsp;&nbsp;
           <img src="<%=request.getContextPath()%>/webframe/images/icon_finish.gif" align="absmiddle">&nbsp;<a href="#nogo" class="a">标记完成</a></td>
           <td class="t-bot-mc-button"><a href="#nogo" class="b" onClick="moreQuery()">高级搜索>></a>&nbsp;&nbsp;</td>
		</tr>
      </table>
	</ai:contractitem>
	 <ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="5" width="100%" height="120" ondblink="" onlyquery="true">
          <ai:col fieldname="ATTACH_ID" width="10%"/>
       		<ai:col fieldname="BUSI_SHEET_ID" width="15%" />
       		<ai:col fieldname="BUSI_TYPE_CODE" width="15%" />
       		<ai:col fieldname="REMARKS" width="30%" />
       		<ai:col fieldname="NAME" width="30%" />
           </ai:table>     
</ai:contractframe>

</body>
</html>
<script language="javascript">
/*显示或隐藏查询条件*/
var flag = false;
function moreQueryCondition(){		
		if(!flag){
			document.getElementById("moreQueryCondition").style.display="block";
			g_AIButtonManager.get("btnMore").setText("-隐藏信息");
			flag = true;
		}else{
			document.getElementById("moreQueryCondition").style.display="none";
			g_AIButtonManager.get("btnMore").setText("+更多信息");
			flag = false;
		}		
}

function moreQuery(){
   window.showModalDialog("<%=request.getContextPath()%>/webframe/example/open01.jsp",'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:600px");
}
</script>