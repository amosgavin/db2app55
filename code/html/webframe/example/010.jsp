<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>模板010</title>
<!--左右结构（含查询）模板页面说明 -->
<!--
1、本模板适用于左右结构（含查询）的jsp页面；左边固定宽度，右边自适应宽度；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、查询及查询结果分别用ai:contractframe套用分割；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、查询结果ai:table使用注意：宽度请设置100%，高度请设置220，条数请设置10条（pagesize="10"），若有多项可酌情减少；
6、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
 -->
</head>

<body>
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="220" valign="top">
<ai:contractframe id="客户查询" contenttype="table" title="客户查询" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<table border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">客户名称：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:100"/></td>
		</tr>
		<tr>
           <td class="td_font">客户属性：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:100"/></td>
		</tr>
		<tr>
           <td class="td_font">联系电话：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:100"/></td>
		</tr>
         <tr>
           <td class="td_font">联系地址：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:100"/></td>
		</tr>
		<tr>
           <td class="td_font">邮政编码：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:100"/></td>
		</tr>
		<tr>
           <td class="td_font">备注：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:100"/></td>
		</tr>
         <tr>
           <td class="td_font">客户名称：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:100"/></td>
		</tr>
		<tr>
           <td class="td_font">客户属性：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:100"/></td>
		</tr>
		<tr>
           <td class="td_font">联系电话：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:100"/></td>
		</tr>
         <tr>
           <td class="td_font">联系地址：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:100"/></td>
		</tr>
		<tr>
           <td class="td_font">邮政编码：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:100"/></td>
		</tr>
		<tr>
           <td class="td_font">备注：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:100"/></td>
		</tr>
         <tr>
           <td class="td_font">客户名称：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:100"/></td>
		</tr>
		<tr>
           <td class="td_font">客户属性：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:100"/></td>
		</tr>
		<tr>
           <td class="td_font">联系电话：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:100"/></td>
		</tr>
         <tr>
           <td class="td_font">联系地址：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:100"/></td>
		</tr>
		<tr>
           <td class="td_font">邮政编码：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:100"/></td>
		</tr>
		<tr>			
           <td colspan="2" class="area_button"><ai:button text="查询" id="" onclick="" /></td>
		</tr>
</table>
</ai:contractframe>
</td>
<td width="10"></td>
<td valign="top" align="right">
<ai:contractframe id="客户修改列表" contenttype="table" title="客户修改列表" width="100%" allowcontract="false" frameclosed="false">
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