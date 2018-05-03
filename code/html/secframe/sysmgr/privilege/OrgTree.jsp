<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
<head>
<title><i18n:message key="sec.orgtree.orgstructtree" res="i18n.secframe_resource"/></title>
</head>
<body>
<ai:contractframe id="" contenttype="table"
						title="sec.orgtree.orgselect" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
						
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
          <td class="td_font"><i18n:message key="sec.orgtree.orgid" res="i18n.secframe_resource"/></td>
          <td><input type="text"  readonly id="orgId" value="<%=SessionManager.getUser().getOrgId()%>" style="width:150px;"></td>
          <td class="td_font"><i18n:message key="sec.orgtree.orgname" res="i18n.secframe_resource"/></td>
          <td><input type="text"  readonly id="orgName" value="<%=SessionManager.getUser().getOrgName()%>" style="width:130px;"><img id="selOrgBtn" border="0" src="<%=request.getContextPath()%>/webframe/images/check.gif"  alt="" onClick="selOrg()" align="absmiddle" style="cursor:hand;"/></td>
        </tr>
      </table>
					</ai:contractframe>
</body>
<script language="javascript">
var flag = 1;
var orgName = document.getElementById("orgName");
var orgId = document.getElementById("orgId");
init();
function selOrg(){
    var organizeId="<%=SessionManager.getUser().getOrgId()%>";
	var ret = orgSelectDialog(organizeId);
	if(ret!=null){
		orgName.value = ret.text;
		orgId.value = ret.value;
	}
	init();
}
function init(){
	window.parent.qryObj(orgId.value);
}
</script>
</html>