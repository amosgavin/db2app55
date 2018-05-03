<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>湖北移动公司营销管理系统</title>
</head>
<body onload="">
  <div class="area_button">
    <input id="abc" value="" type="text" class="input" style="width:200px;"/>
    <ai:button text="staffselect.search" i18nRes="i18n.secframe_resource" id="searchOperBtn" onclick="select.searchPackage()"/>
  </div>
</body>
</html>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">
var select = {};
select.searchPackage = function() {
    var result = openSelect.optionalPackeg();
    if(result != null){
        var outsth = "";
        for(var i=0;i < result.elements.length;i++)
        {
            outsth = outsth + result.elements[i].packageId+"："+result.elements[i].name+"；";
        }
        document.getElementById("abc").value = outsth;
    }
} 
</script>