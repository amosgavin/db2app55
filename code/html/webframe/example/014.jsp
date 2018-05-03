<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>模板014</title>
<!--TAB页（左右结构）模板页面说明 -->
<!--
1、本模板适用于TAB页（左右结构）的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、查询及查询结果分别用ai:contractframe套用分割；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、查询结果ai:table使用注意：宽度请设置100%，高度请设置220，条数请设置10条（pagesize="10"），若有多项可酌情减少；
6、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
7、ai:tab使用注意：宽度请设置100%，高度请设置400，若有多项可酌情减少；initial属性（初始化时是否聚焦 值：true/false）；isDeletable属性（是否含关闭按钮 值：true/false）
8、不在table中排版的TAB页，请外面套用（ class="area_tab"）；
 -->
</head>

<body>
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="220" valign="top">
<div class="area_tab">
<ai:tab id="ddd1" width="220" height="490" type="h">
	<ai:tabitem id="dd1" title="统计数量" src="tab3.jsp" initial="true" />
	<ai:tabitem id="dd2" title="日访问量" src="tab3.jsp" isDeletable="true"/>
</ai:tab>
</div>
</td>
<td width="10"></td>
<td valign="top" align="right">
<div class="area_tab">
<ai:tab id="ddd2" width="100%" height="330" type="h">
	<ai:tabitem id="dd1" title="定单统计结果" src="tab1.jsp" initial="true" />
	<ai:tabitem id="dd2" title="客户日访问量" src="tab2.jsp" isDeletable="true"/>
	<ai:tabitem id="dd3" title="客户群" src="tab1.jsp" isDeletable="true"/>
	<ai:tabitem id="dd4" title="费用查询结果" src="tab2.jsp" />
</ai:tab>
</div>

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

<div class="area_button">
  <ai:button text="正常按钮" id="query1" onclick="" />&nbsp;&nbsp;
  <ai:button text="不可用按钮" id="query3" onclick="" enable="false" />
</div>
		</td>
	</tr>
</table>
</body>
</html>
<script language="javascript">

</script>