<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>模板013</title>
<!--TAB页（可增加标签）模板页面说明 -->
<!--
1、本模板适用于TAB页（上下结构）的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、查询及查询结果分别用ai:contractframe套用分割；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、查询结果ai:table使用注意：宽度请设置100%，高度请设置220，条数请设置10条（pagesize="10"），若有多项可酌情减少；
6、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
7、ai:tab使用注意：宽度请设置100%，高度请设置400，若有多项可酌情减少；initial属性（初始化时是否聚焦 值：true/false）；isDeletable属性（是否含关闭按钮 值：true/false）
8、不在table中排版的TAB页，请外面套用（ class="area_tab"）；若TAB高度为百分比则不添加任何样式；
9、Tab页标签增加可参考此模板，另请注意：若有增加Tab页标签，请设置Tab整体宽度为100%，否则都为98%；
 -->
</head>

<body>
<div class="area_tab">
<ai:tab id="ddd1" width="100%" height="240" type="h">
	<ai:tabitem id="dd1" title="定单统计结果" src="tab1.jsp" initial="true" />
	<ai:tabitem id="dd2" title="客户日访问量" src="tab2.jsp" isDeletable="true"/>
	<ai:tabitem id="dd3" title="客户群" src="tab1.jsp" isDeletable="true"/>
	<ai:tabitem id="dd4" title="费用查询结果" src="tab2.jsp" />
</ai:tab>
</div>

<div class="area_tab">
<ai:tab id="ddd2" width="100%" height="200" type="b">
	<ai:tabitem id="dd1" title="定单统计结果" src="tab1.jsp" initial="true" />
	<ai:tabitem id="dd2" title="客户日访问量" src="tab2.jsp" isDeletable="true"/>
	<ai:tabitem id="dd3" title="客户群" src="tab1.jsp" isDeletable="true"/>
	<ai:tabitem id="dd4" title="费用查询结果" src="tab2.jsp" />
</ai:tab>
</div>

<div class="area_button">
  <ai:button text="上面增加Tab页标签" id="query1" onclick="test()" />&nbsp;&nbsp;
  <ai:button text="下面增加Tab页标签" id="query2" onclick="test1()" />&nbsp;&nbsp;
  <ai:button text="不可用按钮" id="query3" onclick="" enable="false" />
</div>

</body>
</html>
<script language="javascript">
function test(){
openNewTabItem("ddd1","费用查询结果费用查询结","费用查询结果费用查询结","tab2.jsp","true");
}
function test1(){
openNewTabItem("ddd2","费用查询结果","费用查询结果","tab2.jsp","true");
}
</script>