<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<title>模板018</title>
<!--加载等待模板页面说明 -->
<!--
1、本模板适用于查询时间较长，及加载较多内容的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、查询及查询结果分别用ai:contractframe套用分割；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
6、加载内容出现的loading可参考“查询”按钮点击效果；
7、loading文字注意：请不要超过30个字，如“正在处理，请稍后...”，后面3个请统一为半角点（非句号）；
8、不要每个页面都使用加载等待，只有加载时间超过5秒的才使用，使用加载等待组件需引用jsv2目录下的AIWaitBanner.js；
 -->
</head>

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
           <td class="td_button"><ai:button text="查询" id="query" onclick="query()" /></td>
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
  <ai:button text="导出Excel" id="query" onclick="query()" />&nbsp;&nbsp;
  <ai:button text="重新查询" id="query" onclick="query()" />&nbsp;&nbsp;
  <ai:button text="不可用" id="" onclick="" enable="false" />
</div>

</body>
</html>
<script language="javascript">
function queryclick(){
}

function query(){ 
 	beginAIWaitBanner("queryclick()","正在处理，请稍后...");
}
	  
</script>