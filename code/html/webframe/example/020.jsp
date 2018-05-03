<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>模板020</title>
<!--时间日期控件模板页面说明 -->
<!--
1、本模板适用于调用时间日期的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、查询及查询结果分别用ai:contractframe套用分割；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
6、含时分秒请在相应set中设置<EditType>DBDateTime</EditType>，不含请设置<EditType>DBDate</EditType>；
 -->
</head>

<body>
<ai:contractframe id="客户信息" contenttype="table" title="客户信息" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
 <ai:dbform formid="formAttach" setname="com.ai.frame.attach.SETSysAttach" initial="false" >
    <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
                <td class="td_font">客户名称：</td>
                <td><ai:dbformfield fieldname="ATTACH_ID" formid="formAttach" visible="true" width="150"/></td>
                <td class="td_font">开始时间:<br>时/分/秒</td>
                <td><ai:dbformfield fieldname="DATE_TIME_CODE"  formid="formAttach" visible="true" width="150"/></td>
                <td class="td_font">结束时间：</td>
                <td><ai:dbformfield fieldname="DATE_CODE" formid="formAttach" visible="true" width="150"/></td>
           <td class="td_button"><ai:button text="查询" id="" onclick="" /></td>
        </tr>
    </table>
</ai:dbform>
</ai:contractframe>

<ai:contractframe id="客户信息列表" contenttype="table" title="客户信息列表" width="100%" allowcontract="false" frameclosed="false">
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
  <ai:button text="导出Excel" id="" onclick="" />&nbsp;&nbsp;
  <ai:button text="重新查询" id="" onclick="" />&nbsp;&nbsp;
  <ai:button text="不可用" id="" onclick="" enable="false" />
</div>

</body>
</html>
<script language="javascript">

</script>