<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>货品配置</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initGoods()">

<ai:contractframe id="writeTagInfoframe" contenttype="table" title="货品查询" width="100%" allowcontract="true" frameclosed="false" >
	<%@include file="/sale/activity/include/_goodsTagSelect.jsp"%>
	</ai:contractframe>
<div id="saveGoods">	
<ai:contractframe id="writeTagInfoframe" contenttype="table" title="添加或修改货品" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:dbform formid="tagGoodsForm" initial="false"
			setname="com.asiainfo.sale.tag.web.SETGoodsPromation" 
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
            implservice_querymethod="getGoodsById(String id)"
		    editable="true">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
	           	<tr>
	           		<td class="td_font">资源ID：</td>
	           		<td >
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="TAG_CODE" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">一级分类：</td>
	           		<td>
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="FIRST_CLASSIFY" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">二级分类：</td>
	           		<td>
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="TAG_TYPE" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	<tr>
	           		<td class="td_font">三级分类：</td>
	           		<td>
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="BUSI_NAME" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">四级分类：</td>
	           		<td>
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="THIRF_CLASSIFY" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">五级分类：</td>
	           		<td>
		           		<ai:dbformfield formid="tagGoodsForm" fieldname="NAME" width="150"/><span class="font_red">*</span>
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
	           		<td><ai:dbformfield formid="tagGoodsForm" fieldname="MODIFY_TIME" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">失效时间：</td>
	           		<td><ai:dbformfield formid="tagGoodsForm" fieldname="OVERDUE_TIME" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<div class="area_button"><ai:button id="newTag" text="保存货品" onclick="saveGoodslist()"/></div>	
</div>

 <%@include file="/sale/common/include/_check.jsp"%>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script> 
<script type="text/javascript">
  var tagGoodsForm = g_FormRowSetManager.get("tagGoodsForm");	

  function initGoods(){
  if(taskTag=="PB001"){
	  document.getElementById("tagCode").style.display="none";
	  document.getElementById("saveGoods").style.display="none";
  }else if(taskTag=="PB002"){
	  document.getElementById("selectStaff").style.display="none";
	  document.getElementById("saveGoods").style.display="block";  
  }	
	  tagGoodsForm.setColEditSts("FIRST_CLASSIFY",false);
	  tagGoodsForm.setColEditSts("BUSI_NAME",false);
	  tagGoodsForm.setColEditSts("THIRF_CLASSIFY",false);
	  tagGoodsForm.setColEditSts("OVERDUE_TIME",false);
	  tagGoodsForm.setColEditSts("MODIFY_TIME",false);
	  
	  tagGoodsForm.setColEditSts("NAME",false);
	  tagGoodsForm.setColEditSts("TAG_TYPE",false);
	  tagGoodsForm.setColEditSts("CHARGE",false);
	  tagGoodsForm.setColEditSts("SUMCHARGE",false);
	  tagGoodsForm.setColEditSts("AREA",false);
	  tagGoodsForm.setColEditSts("SHOW_FLAG",false);
	  tagGoodsForm.setColEditSts("STOCK_FLAG",false);
	  document.getElementById("delGoods").style.display="none";
	  initCheckPage();
  }
  
  function saveGoodslist(){
  if(tagGoodsForm.getValue("TAG_CODE")==""){
  alert("请填写资源ID");
  return;
  }
  		var list = new Array();
		list.push(tagGoodsForm);
		var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveGoods';
		var recode = saveRowSet(strUrl, list);
		if ("Y" == recode.getValueByName("FLAG") )
		{
		location.reload();
		}
  }
  
 function marketMultiplySelected(){
   var tagGoodsForm = g_FormRowSetManager.get("tagGoodsForm");	
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/Areatype.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = tagGoodsForm.getValue("AREA");
    tagGoodsForm.setValue("AREA",onItemMultiplySelected(url, iniVal, style));
} 

function closePage(){
   window.opener.location.reload();
    window.self.close();
}

</script>
  </body>

</html>
