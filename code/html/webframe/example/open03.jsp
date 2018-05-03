<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
 
<html>
<head>
<title>弹出页面5</title>
<!--弹出的DIV窗口模板页面说明 -->
<!--
1、本模板为使用弹出DIV可拖动半透明窗口所加载的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、使用者需引用jsv2目录下的openwin.js和topopenwin.js；
4、关闭及刷新/调用上层界面的方法可参考script中的写法；
5、对于已弹出的DIV窗口，不能再弹出类似DIV窗口，提示/成功/警告窗口仅为窗口关闭动作；
 -->
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/topopenwin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/openwin.js"></script>
<body>
<ai:contractframe id="查询条件" contenttype="table" title="查询条件" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
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
           <td class="td_button"><ai:button text="查询" id="" onclick="" /></td>
		</tr>
      </table>
</ai:contractframe>

<div class="area_tab">
<ai:tab id="ddd2" width="100%" height="360" type="h">
	<ai:tabitem id="dd1" title="定单统计结果" src="tab5.jsp" initial="true" />
	<ai:tabitem id="dd2" title="客户日访问量" src="tab2.jsp" isDeletable="true"/>
	<ai:tabitem id="dd3" title="客户群" src="tab2.jsp" isDeletable="true"/>
	<ai:tabitem id="dd4" title="费用查询结果" src="tab2.jsp" />
</ai:tab>
</div>

<div class="area_button">
  <ai:button text="确定" id="" onclick="query()" />&nbsp;&nbsp;
  <ai:button text="成功" id="query" onclick="query2()" />&nbsp;&nbsp;
  <ai:button text="提示" id="query" onclick="query3()" />&nbsp;&nbsp;
  <ai:button text="警告" id="query" onclick="query4()" />&nbsp;&nbsp;
  <ai:button text="关闭" id="" onclick="closeme()" />&nbsp;&nbsp;
  <!--对于<a href>打开的窗口必须使用“#nogo”; -->
   <a href="#nogo" id="query" onClick="query5();">打开DIV窗口</a> 
</div>

</body>
</html>
<script language="javascript">
function query2(){
	ai.success('流程申请成功','流程申请成功，是否继续？');
}

function query3(){
	ai.word('工单提交提示','您已完成工单提交，是否继续？');
}

function query4(){
	ai.alert('超时警告','您已超时，请重新登录！');
}

function query5(){
 ai.open('打开窗口1','<%=request.getContextPath()%>/webframe/example/open02.jsp',900, 500);
}

/*单纯弹出DIV窗口关闭方法*/
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