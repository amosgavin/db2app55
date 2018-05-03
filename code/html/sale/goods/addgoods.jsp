<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="logger.query.login.titile" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="">

<ai:contractframe id="writeTagInfoframe" contenttype="table" title="货品查询" width="100%" allowcontract="true" frameclosed="false" >
	<%@include file="/sale/activity/include/_goodsTagSelect.jsp"%>
	</ai:contractframe>
	
<ai:contractframe id="writeTagInfoframe" contenttype="table" title="添加或修改货品" width="100%" allowcontract="true" frameclosed="false" >
	<table><td id="newGoods"> <ai:button id="newGoods" text="重置货品"  onclick="addNewGoods()"/></td></table>
	<ai:contractitem/>
	<ai:dbform formid="tagGoodsForm" initial="false"
			setname="com.asiainfo.sale.tag.web.SETGoodsPromation" 
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
            implservice_querymethod="getGoodsById(String id)"
		    editable="true">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
	           	<tr>
	           		<td class="td_font">一级分类：</td>
	           		<td>
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="FIRST_CLASSIFY" width="150"  editable="false"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">二级分类：</td>
	           		<td>
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="TAG_TYPE" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">三级分类：</td>
	           		<td>
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="BUSI_NAME" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	<tr>
	           		<td class="td_font">四级分类：</td>
	           		<td>
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="THIRF_CLASSIFY" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">五级分类：</td>
	           		<td>
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="NAME" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">生产厂家：</td>
	           		<td>
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="REMARK" width="150"/>
	           		</td>
	           	</tr>
	            <tr>
	           		<td class="td_font" >采购价：</td>
	           		<td><ai:dbformfield formid="tagGoodsForm" fieldname="CHARGE" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font" id="month1">指导价：</td>
	           		<td id="month2"><ai:dbformfield formid="tagGoodsForm" fieldname="SUMCHARGE" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	<tr  id="">
	           		<td class="td_font">开放地市：</td>
	           		<td colspan="3"><ai:dbformfield formid="tagGoodsForm" fieldname="AREA" width="300"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="marketMultiplySelected();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	 <tr>
	           		<td class="td_font">开放活动类型：</td>
	           		<td><ai:dbformfield formid="tagGoodsForm" fieldname="STOCK_FLAG" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">采购类别：</td>
	           		<td><ai:dbformfield formid="tagGoodsForm" fieldname="SHOW_FLAG" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	<tr>
	           		<td class="td_font">生效时间：</td>
	           		<td><ai:dbformfield formid="tagGoodsForm" fieldname="MODIFY_TIME" width="150"  editable="false"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">失效时间：</td>
	           		<td><ai:dbformfield formid="tagGoodsForm" fieldname="OVERDUE_TIME" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<div class="area_button"><ai:button id="newTag" text="保存货品" onclick="saveGoodslist()"/></div>	
 
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script> 
<script type="text/javascript">
  var tagGoodsForm = g_FormRowSetManager.get("tagGoodsForm");	
  document.getElementById("delGoods").style.display="block";
  tagGoodsForm.setValue("FIRST_CLASSIFY","促销物资大类");
  function saveGoodslist(){
	  if ("O" != tagGoodsForm.getSts())
	    {
	  		var list = new Array();
			list.push(tagGoodsForm);
			var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveGoods';
			var recode = saveRowSet(strUrl, list);
			if ("Y" == recode.getValueByName("FLAG") )
			{
			location.reload();
			}
	  }
  }
  
 function marketMultiplySelected(){
   var tagGoodsForm = g_FormRowSetManager.get("tagGoodsForm");	
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/Areatype.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = tagGoodsForm.getValue("AREA");
    tagGoodsForm.setValue("AREA",onItemMultiplySelected(url, iniVal, style));
} 

function addNewGoods(){
//location.reload();
tagGoodsForm.newRow();
//tagGoodsForm.setColEditSts("FIRST_CLASSIFY",false);
tagGoodsForm.setValue("FIRST_CLASSIFY","促销物资大类");
g_AIButtonManager.get("newTag").setDisabled(false);
}
</script>
  </body>

</html>
