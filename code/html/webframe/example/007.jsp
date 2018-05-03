<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%> 
<html>
<head>
<title>模板007</title>
<!--普通查询（上下结构）带TAB（左-横字）模板页面说明 -->
<!--
1、本模板适用于普通查询，及查询后对结果进行操作的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、查询用ai:contractframe套用；查询出的多种结果由ai:tab套用；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、ai:tab使用注意：宽度请设置100%，高度请设置400，若有多项可酌情减少；initial属性（初始化时是否聚焦 值：true/false）；isDeletable属性（是否含关闭按钮 值：true/false）
6、Tab页标签位于左边请注意：超过15个及少于3个中文字请不要使用左Tab页样式（ type="v"），也不要使用含关闭按钮属性（isDeletable）；
7、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
8、不在table中排版的TAB页，请外面套用（ class="area_tab"）；
9、Tab页标签增加可参考011.jsp，另请注意：若有增加Tab页标签，请设置Tab整体宽度为100%，否则都为98%如本模板；
 -->
</head>
<body>
<div class="area_tab">
<ai:tab id="ddd1" width="100%" height="500" type="v">
	<ai:tabitem id="dd1" title="客户群客户群客户群" src="tab1.jsp" initial="true" />
	<ai:tabitem id="dd2" title="客户日访问量" src="tab2.jsp"/>
	<ai:tabitem id="dd3" title="客户群" src="tab1.jsp"/>
	<ai:tabitem id="dd4" title="费用查询结果" src="tab2.jsp" />
</ai:tab>
</div>

<div class="area_button">
  <ai:button text="正常按钮" id="query1" onclick="" />&nbsp;&nbsp;
  <ai:button text="不可用按钮" id="query3" onclick="" enable="false" />
</div>
  
</body>
</html>
<script language="javascript">

</script>