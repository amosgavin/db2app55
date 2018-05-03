<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>弹出页面3</title>
<!--弹出的DIV窗口模板页面说明 -->
<!--
1、本模板为使用弹出DIV可拖动半透明窗口所加载的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、使用者需引用jsv2目录下的openwin.js和topopenwin.js；
4、关闭及刷新/调用上层界面的方法可参考script中的写法；
 -->
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/topopenwin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/openwin.js"></script>
<body>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="220" valign="top">
<div class="area_tab">
<ai:tab id="ddd1" width="220" height="400" type="h">
	<ai:tabitem id="dd1" title="统计数量" src="tab4.jsp" initial="true" />
	<ai:tabitem id="dd2" title="日访问量" src="tab3.jsp" isDeletable="true"/>
</ai:tab>
</div>
</td>
<td width="10"></td>
<td valign="top" align="right">
<ai:contractframe id="客户修改列表" contenttype="table" title="客户修改列表" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="10" width="100%" height="220" ondblink="">
          <ai:col fieldname="ATTACH_ID" width="105"/>
       		<ai:col fieldname="BUSI_SHEET_ID" width="150" />
       		<ai:col fieldname="BUSI_TYPE_CODE" width="200" />
       		<ai:col fieldname="REMARKS" width="160" />
       		<ai:col fieldname="NAME" width="160" />
           </ai:table>
</ai:contractframe>

<ai:contractframe id="客户属性修改" contenttype="table" title="客户属性修改" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">客户名称：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">联系电话：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">客户属性：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
           <td class="td_font">联系地址：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">邮政编码：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">备注：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>
</ai:contractframe>
		</td>
	</tr>
</table>

<div class="area_button">
  <ai:button text="确定" id="" onclick="query()" />&nbsp;&nbsp;
  <ai:button text="关闭" id="" onclick="closeme()" />
</div>

</body>
</html>
<script language="javascript">
/*弹出DIV窗口关闭方法*/
function closeme(){
  ai.closePopup();
}
 
/*弹出DIV窗口刷新并关闭方法*/
 function query(){
 //parentWin为弹出窗口上一级
	var parentWin = ai.getOpener();
	if(parentWin != null)
		//为上一级增加一个table parentWin.addTable();
		//传个参数给上级方法  parentWin.test(param);
   //刷新上一级
   parentWin.location.reload();		

	//关闭窗口
	ai.closePopup();
} 
 
</script>