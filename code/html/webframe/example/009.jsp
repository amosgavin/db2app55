<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>模板009</title>
<!--内容较多结构模板页面说明 -->
<!--
1、本模板适用于内容较多，上下/左右混杂的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、查询及查询结果分别用ai:contractframe套用分割；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、查询结果ai:table使用注意：宽度请设置100%，高度请设置220，条数请设置10条（pagesize="10"），若有多项可酌情减少；
6、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
7、如果存在左右结构，请尽量保持左右高度一致；
 -->
</head>

<body>

<ai:contractframe id="查询条件一" contenttype="table" title="查询条件一" width="100%" allowcontract="true" frameclosed="false">
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

<ai:contractframe id="客户信息" contenttype="table" title="客户信息" width="100%" allowcontract="true" frameclosed="false">
  <ai:contractitem/>
 <ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect1"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="5" width="100%" height="120" ondblink="">
          <ai:col fieldname="ATTACH_ID" width="10%"/>
       		<ai:col fieldname="BUSI_SHEET_ID" width="15%" />
       		<ai:col fieldname="BUSI_TYPE_CODE" width="15%" />
       		<ai:col fieldname="REMARKS" width="30%" />
       		<ai:col fieldname="NAME" width="30%" />
           </ai:table>
</ai:contractframe>

<ai:contractframe id="查询条件二" contenttype="table" title="查询条件二" width="100%" allowcontract="true" frameclosed="false">
  <ai:contractitem/>
 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">客户名称：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">联系电话：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">客户属性：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
           <td class="td_button"><ai:button text="查询" id="" onclick="" /></td>
		</tr>
      </table>
</ai:contractframe>

<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="49%" valign="top">
<ai:contractframe id="模块功能一" contenttype="table" title="模块功能一" width="99%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect2"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="4" width="100%" height="81" ondblink="">
          <ai:col fieldname="ATTACH_ID" width="20%"/>
       		<ai:col fieldname="BUSI_SHEET_ID" width="40%" />
       		<ai:col fieldname="BUSI_TYPE_CODE" width="40%" />
           </ai:table>
</ai:contractframe>
</td>
<td width="49%" valign="top" align="right">
<ai:contractframe id="模块功能二" contenttype="table" title="模块功能二" width="99%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect3"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="4" width="100%" height="81" ondblink="">
          <ai:col fieldname="ATTACH_ID" width="20%"/>
       		<ai:col fieldname="BUSI_SHEET_ID" width="40%" />
       		<ai:col fieldname="BUSI_TYPE_CODE" width="40%" />
           </ai:table>
</ai:contractframe>
		</td>
	</tr>
</table>

<div class="area_button">
  <ai:button text="正常按钮" id="query1" onclick="" />&nbsp;&nbsp;
  <ai:button text="不可用按钮" id="query3" onclick="" enable="false" />
</div>

</body>
</html>
<script language="javascript">

</script>