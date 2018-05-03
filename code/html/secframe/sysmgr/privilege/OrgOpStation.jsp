<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<HTML>
	<head>
		<title><i18n:message key="sec.orgopstation.stationselect" res="i18n.secframe_resource"/></title>
	</head>
	<body>
	<ai:contractframe id="" contenttype="table"
						title="sec.orgopstation.stationselect" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
						
					<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
						<tr>
							<td class="td_font">
								<i18n:message key="sec.orgopstation.orgname" res="i18n.secframe_resource"/>
							</td>
							<td>
								<input type="text" readonly id="orgName"
									value="<%=SessionManager.getUser().getOrgName() + "|"
					+ SessionManager.getUser().getOrgId()%>" style="width:150px;">
								<input type="hidden" readonly id="orgId"
									value="<%=SessionManager.getUser().getOrgId()%>">
							</td>
							<td class="td_font">
								<i18n:message key="sec.orgopstation.stationname" res="i18n.secframe_resource"/>
							</td>
							<td><input type="text" readonly id="stationName" value="" style="width:130px;"><img id="selOrgBtn" border="0" src="<%=request.getContextPath()%>/webframe/images/check.gif"  alt="" onClick="selectStation()" align="absmiddle" style="cursor:hand;"/>
								<input type="hidden" id="stationId" value="">
							</td>
						</tr>
					</table>
					</ai:contractframe>
					
								
	</body>
	<script language="javascript">
var flag = 1;
var orgName = document.getElementById("orgName");
var orgId = document.getElementById("orgId");
var stationName = document.getElementById("stationName");
var stationId = document.getElementById("stationId");
init();
function selOrg(){
	var ret = orgSelectDialog(-1);
	if(ret!=null){
		orgName.value = ret[0].orgName;
		orgId.value = ret[0].orgId;
	}
	init();
}

function init(){
	window.parent.qryObj(orgId.value+":"+stationId.value);
}

function selectStation(){
	var url = "StationSelect.jsp?selectType=oneStationSelect";
	var ret = window.showModalDialog(url,"" , "scroll:no;resizable:no;help:no;status:no;dialogHeight:450px;dialogWidth:700px");
  	if(ret!=null){
  		ret[0] = ret[0].substr(0,ret[0].length-1);
  		ret[1] = ret[1].substr(0,ret[1].length-1);
  		stationName.value=ret[1];
  		stationId.value=ret[0];
  		orgName.value = ret[2].orgName+"|"+ret[2].orgId;
		orgId.value = ret[2].orgId;
  		init();
  	}
}


</script>
</html>