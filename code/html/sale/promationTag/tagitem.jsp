<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>��ʶѡ��</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<ai:contractframe id="" contenttype="table" title="ר�Χ��Ŀ��" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETTagItem"
			tableid="tagItemTab"  editable="false"  ondbclick="" 
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="99" initial="false" width="100%"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			implservice_querymethod="getTagItemByType(String itemType)"
			implservice_countmethod="getTagItemByTypeCount(String itemType)" >
            <ai:col  title="��Ŀ����" fieldname="ITEM_CODE" width="40%" editable="false" visible=""/>
            <ai:col  title="��Ŀ������" fieldname="NAME" width="60%" editable="false" visible=""/>		
            <ai:col  title="��Ŀ������" fieldname="ITEM_TYPE" width="98%" editable="false" visible="false"/>	
	</ai:table>
</ai:contractframe>
<div class="area_button">
   <ai:button text="�ر�" id="close" onclick="window.close();" />&nbsp;&nbsp;
</div>
<ai:loginuser />
<script type="text/javascript">
var TagItem = g_TableRowSetManager.get("tagItemTab");
var itemType=<%=request.getParameter("item_type")%>;

inittag();
function inittag(){
TagItem.refresh("&itemType="+itemType);
}
</script>
</body>
</html>