<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
 
<html>
<head>
<title>模板016</title>
<!--普通弹出DIV可拖动半透明（提示）窗口模板页面说明 -->
<!--
1、本模板适用于普通弹出DIV可拖动半透明（提示）窗口的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、使用者需引用jsv2目录下的openwin.js和topopenwin.js；
4、ai.open调用打开窗口属性分别为：打开窗口命名、调用页面名称、窗口宽度、窗口高度，如：ai.open('打开窗口1','test1.jsp',520, 290);
5、ai.success调用打开“成功”窗口属性分别为：打开成功窗口命名、打开窗口后要书写的文字（不超过中文50个字），如：；ai.success('流程申请成功','流程申请成功，是否继续？')
6、ai.word调用打开“提示”窗口属性分别为：打开提示窗口命名、打开窗口后要书写的文字（不超过中文50个字），如：ai.word('工单提交提示','您已完成工单提交，是否继续？')；
7、ai.alert调用打开“警告”窗口属性分别为：打开警告窗口命名、打开窗口后要书写的文字（不超过中文50个字），如：ai.alert('超时警告','您已超时，请重新登录！')；
8、ai.open调用打开窗口属性分别为：打开窗口命名、调用页面名称、窗口宽度、窗口高度，如：ai.open('打开窗口1','test1.jsp',520, 290);
9、请注意：弹出DIV窗口的宽度请不要超过1000px、高度请不要超过700px；
10、弹出DIV窗口比较耗内存，不推荐在大型BOSS类项目中使用；
 -->
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/topopenwin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/openwin.js"></script>
<body style="overflow:hidden">
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
  <ai:button text="tab页中弹出DIV窗口" id="query" onclick="query2()"/>
  <ai:button text="成功" id="query" onclick="query3()" />&nbsp;&nbsp;
  <ai:button text="提示" id="query" onclick="query4()" />&nbsp;&nbsp;
  <ai:button text="警告" id="query" onclick="query5()" />&nbsp;&nbsp;
  <!--对于<a href>打开的窗口必须使用“#nogo”; -->
  <a href="#nogo" id="query" onClick="query5();">打开DIV提示窗口</a> 
</div>

</body>
</html>
<script language="javascript">
function query1(){
 ai.open('打开窗口1','<%=request.getContextPath()%>/webframe/example/open02.jsp',900, 500);
}
function query2(){
 ai.open('打开窗口2','<%=request.getContextPath()%>/webframe/example/open03.jsp',900, 550);
}
function query3(){
	ai.success('流程申请成功','流程申请成功，是否继续？');
}

function query4(){
	ai.word('工单提交提示','您已完成工单提交，是否继续？');
}

function query5(){
	ai.alert('超时警告','您已超时，请重新登录！');
}
	  
</script>