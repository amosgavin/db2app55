<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ taglib uri="/WEB-INF/crossgrid.tld" prefix="crossgrid" %>
<html>
<head>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/PopMenu_v2.js"></script>
<title>模板019</title>
<!--DBGrid示例模板页面说明 -->
<!--
1、本模板适用于DBGrid表格前台分类jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、查询及查询结果分别用ai:contractframe套用分割；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、同一页面2组及以上ai:table使用注意：宽度请设置100%，高度请设置120（有合计行请加20=140），条数请设置6条（pagesize="5"），若有多项可酌情减少；
6、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
7、使用右键菜单需引用jsv2目录下的PopMenu_v2.js；
 -->
 <script language="JavaScript">
var tmpGroupModel = new AIPopMenuModel();
  tmpGroupModel.addPopMenuItem("1","表格操作",null,"rootRefresh");
  tmpGroupModel.addPopMenuItem("2","新增",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("3","修改",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("4","删除",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("1","刷新表格",null,"rootRefresh");
  tmpGroupModel.addPopMenuItem("1","刷新页面",null,"rootRefresh");
  var popMenu = new AIPopMenu(tmpGroupModel);
 
  document.onclick=hide;
  function show()
  {
  popMenu.showPopMenu();
 
  }
  function hide()
  {
  popMenu.hidePopMenu();
  }

</script>
</head>

<body>
<ai:contractframe id="可编辑DBGrid示例" contenttype="table" title="可编辑DBGrid示例" width="100%" allowcontract="ture" frameclosed="false">
  <ai:contractitem/>
 <ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect"  
        needrefresh="true" editable="true" initial="true" multiselect="true"
          pagesize="5" width="100%" height="120" ondblink="">
       		<ai:col fieldname="BUSI_TYPE_CODE" width="30%" editable="true" />
       		<ai:col fieldname="REMARKS" width="40%" editable="true" />
       		<ai:col fieldname="NAME" width="30%" editable="true" />
           </ai:table>
</ai:contractframe>

<ai:contractframe id="合计行DBGrid/含右键菜单示例" contenttype="table" title="合计行DBGrid/含右键菜单示例" width="100%" allowcontract="ture" frameclosed="false">
  <ai:contractitem/>
 <ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect2"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="5" width="100%" height="140" ondblink="" oncontextmenu="show"
           onresize="true">
        <ai:col fieldname="ATTACH_ID" width="10%"/>
        <ai:col fieldname="BUSI_SHEET_ID" width="15%" total="true" />
        <ai:col fieldname="BUSI_TYPE_CODE" width="15%" />
        <ai:col fieldname="REMARKS" width="30%" total="true" />
        <ai:col fieldname="NAME" width="30%" />
           </ai:table>
</ai:contractframe>

<ai:contractframe id="发票使用统计列表" contenttype="table" title="发票使用统计列表" width="100%" allowcontract="true" frameclosed="false">
  <ai:contractitem/>
	<crossgrid:crossgrid id="invoceStockDetail" showtype="crossgrid" onrowselect="" oncolselect="" configname="CrossGridDataDefine"
				  datamodel="com.ai.appframe2.analyse.DemoCrossGridDatamodelImpl"
				  width="100%" height="240"  isshowselect="false">
				  <crossgrid:crossgridpivot name="bmh" area="COL" selectvalue=" " issubtotal="true"   ordertype="desc"/>
				  <crossgrid:crossgridpivot name="year" area="ROW" selectvalue=" " issubtotal="true"    ordertype="asc"/>
				  <crossgrid:crossgridpivot name="month" area="ROW" selectvalue=" " issubtotal="true"    ordertype="asc"/>
				  <crossgrid:crossgridpivot name="spbh" area="COL" selectvalue=" " issubtotal="true"    />
				  <crossgrid:crossgridpivot name="meas" area="COL" selectvalue=" " issubtotal="true"   />
	</crossgrid:crossgrid>
</ai:contractframe>

<div class="area_button">
  <ai:button text="正常按钮" id="query1" onclick="" />&nbsp;&nbsp;
  <ai:button text="不可用按钮" id="query3" onclick="" enable="false" />
</div>

</body>
</html>
