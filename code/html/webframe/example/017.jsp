<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/topopenwin.js" type="text/javascript"></script>
<title>模板017</title>
<!--按钮/小图片引用样式模板页面说明 -->
<!--
1、本模板适用于各种应用ai:button进行操作及自定义按钮的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、个模块间分别用ai:contractframe套用分割；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
6、自定义button注意事项：样式（css）请写在\html\theme\颜色目录\css\other.css中（请注明样式说明），相关图片请放在\html\theme\颜色目录\images\other\中；
7、自定义button样式原则：样式对应动作依次为初始化、鼠标经过、灰色不可用，命名规则分别为*/*Hover/*Disabled（注意大小写），如：classname="icon_bk"则css样式分别为.icon_bk/.icon_bkHover/.icon_bkDisabled；
8、联动按钮请参考最下列的“修改”、“保存”示例；
 -->
</head>

<body>
<ai:contractframe id="自定义button示例" contenttype="table" title="自定义button示例" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td height="30">
           <ai:button id="" onclick="" classname="icon_bk" />&nbsp;
           <ai:button id="" onclick="" classname="icon_message" enable="false" />&nbsp;
           <ai:button id="" onclick="" classname="icon_call" enable="false" />&nbsp;
           <ai:button id="" onclick="" classname="icon_bs" />&nbsp;
           <ai:button id="" onclick="" classname="icon_edit" />&nbsp;
           <ai:button id="" onclick="" classname="icon_fk" />&nbsp;
           <ai:button id="" onclick="" classname="icon_ft" />&nbsp;
           <ai:button id="" onclick="" classname="icon_mail" />&nbsp;
           <ai:button id="" onclick="" classname="icon_newinfo" />&nbsp;
           <ai:button id="" onclick="" classname="icon_note" />&nbsp;
           <ai:button id="" onclick="" classname="icon_se" />&nbsp;
           <ai:button id="" onclick="" classname="icon_up" />&nbsp;
           <ai:button text="新增" id="" onclick="" classname="icon_add" />&nbsp;
           <ai:button text="修改" id="" onclick="" classname="icon_modifiy" enable="false" />&nbsp;
           <ai:button text="导出" id="" onclick="" classname="icon_port" />&nbsp;
           <ai:button text="标记完成" id="" onclick="" classname="icon_finish" /></td>
		</tr>
		<tr>
			<td height="1" bgcolor="#999999"></td>
		</tr>
      </table>
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
		</tr>
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

<div class="area_button">
	<ai:button text="修改" id="modify" onclick="onClickModify();" />&nbsp;&nbsp;
	<ai:button text="保存" id="sure" onclick="onClickSure();" enable="false"/>
</div>

	</body>
</html>
<script language="javascript">

	function onClickModify(){
		
		getModifyDistrictBt().setDisabled(true);
		getSureDistrictBt().setDisabled(false);

	}
	
	function onClickSure(){

	   	getModifyDistrictBt().setDisabled(false);
		getSureDistrictBt().setDisabled(true);
	 
	}
	
	function getModifyDistrictBt(){
		return g_AIButtonManager.get("modify");
	}
	function getSureDistrictBt(){
		return g_AIButtonManager.get("sure");
	}
	
</script>