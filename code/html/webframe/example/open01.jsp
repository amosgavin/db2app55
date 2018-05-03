<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
 
<html>
<head>
<title>弹出页面1</title>
<!--弹出的窗口模板页面说明 -->
<!--
1、本模板为使用弹出DIV可拖动半透明窗口所加载的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
 -->
</head>

<body>
<ai:contractframe id="客户信息" contenttype="table" title="客户信息" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">客户名称：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:120"/></td>
           <td class="td_font">联系电话：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:120"/></td>
		</tr>
		<tr>
           <td class="td_font">客户属性：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:120"/></td>
           <td class="td_font">联系地址：</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:120"/></td>
		</tr>
		<tr>
           <td class="td_font">邮政编码：</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:120"/></td>
           <td class="td_font">备注：</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:120"/></td>
           <td class="td_button"><ai:button text="查询" id="" onclick="" /></td>
		</tr>
      </table>
</ai:contractframe>

<ai:contractframe id="客户信息列表" contenttype="table" title="客户信息列表" width="100%" allowcontract="true" frameclosed="false">
  <ai:contractitem/>
<ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="6" width="100%" height="140" ondblink="">
          <ai:col fieldname="ATTACH_ID" width="15%"/>
       		<ai:col fieldname="BUSI_SHEET_ID" width="15%" />
       		<ai:col fieldname="BUSI_TYPE_CODE" width="30%" />
       		<ai:col fieldname="NAME" width="40%" />
           </ai:table>
</ai:contractframe>

<div class="area_button">
  <ai:button text="确定" id="" onclick="" />&nbsp;&nbsp;
  <ai:button text="关闭" id="" onclick="" /> 
</div>

</body>
</html>
<script language="javascript">

</script>