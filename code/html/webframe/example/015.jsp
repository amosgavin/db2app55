<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
 
<html>
<head>
<title>模板015</title>
<!--普通弹出窗口模板页面说明 -->
<!--
1、本模板适用于普通弹出窗口的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、弹出窗口应以实际内容为准，原则上不可过大，也不允许出现滚动条，若内容实在过多，也只允许出现上下滚动条；
4、请注意：弹出窗口的宽度请不要超过1000px、高度请不要超过700px；
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
  <ai:button text="按钮弹出窗口" id="query1" onclick="moreQuery()" />&nbsp;&nbsp;
  <!--对于<a href>打开的窗口必须使用“#nogo”; -->
  <a href="#nogo" class="b" onClick="moreQuery()">高级搜索>></a>
</div>

</body>
</html>
<script language="javascript">
function moreQuery(){
   window.showModalDialog("<%=request.getContextPath()%>/webframe/example/open01.jsp",'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:600px");
}
</script>