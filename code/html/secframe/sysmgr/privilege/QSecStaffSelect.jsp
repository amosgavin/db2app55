<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title></title>
<%
	long orgId = SessionManager.getUser().getOrgId();
%>
</head>
<body>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="220" valign="top">
           <ai:contractframe id="" contenttype="table"  title="sec.qsecstaffselect.stationselect" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
		  	<ai:contractitem>
			<div class="t-bot-mc-button">
			<ai:button id="byorgbtn"  text="sec.byorg" i18nRes="i18n.secframe_resource"  onclick="QueryByOrg()"/>
			<%--<ai:button id="bycondbtn" text="sec.bycode" i18nRes="i18n.secframe_resource"  onclick="QueryByCond()"/>--%>
			</div>
			</ai:contractitem>
		  	<div id="bycond" style="display: none; height:450px;">
              <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
				  <td class="td_font"><i18n:message key="sec.qsecstaffselect.stationname" res="i18n.secframe_resource"/></td>
                  <td><input value="" type="text" id="stationName" style="width:150px;"/> </td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.qsecstaffselect.org" res="i18n.secframe_resource"/></td>
					  <td><input type="text"  value="" id="organizeName" style="width:150px;"/>
                        </td>
                <tr >
                  <td colspan="2" class="area_button"><ai:button text="sec.query" i18nRes="i18n.secframe_resource" id="searchOperBtn" onclick="searchStationList()"/>
                  </td>
                <tr>
              </table>
            </div>
            <div id="byorg">
		  	<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                     <td>
              <ai:dbtree_new id="orgTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
					multiselect="false" height="450" width="100%" ishaveline="true" 
					onselect="treeNodeClick"/>
                     </td>
                  </tr>
              </table>
		   </div>
           </ai:contractframe>
		</td>
		<td valign="top" align="right">
           <ai:contractframe id="" contenttype="table"  title="sec.qsecstaffselect.stationlist" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
		  	<ai:contractitem/>
          	 <ai:table tableid="dbTableStation"
						setname="com.ai.secframe.orgmodel.web.SETSecStation"
						initial="false" multiselect="false" editable="false"
						tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
						parametersname="com.ai.secframe.orgmodel.web.SecStationAction"
						ondbclick="selectStation" pagesize="5"
						width="100%" height="120" needrefresh="true" footdisplay="true">
			  <ai:col fieldname="STATION_ID" visible="false" />			
              <ai:col fieldname="CODE" width="30%" editable="true" visible="true" />
              <ai:col fieldname="NAME" width="40%" editable="true" visible="true"/>
               <ai:col fieldname="ORGANIZE_ID" editable="true" visible="false"/>
              <ai:col fieldname="STATE" width="30%" editable="true" visible="true"/>
             <%--
              <ai:col fieldname="STAFF_ID" width="260" editable="true" visible="false"/>
              <ai:col fieldname="ORG_CODE" width="80" editable="true" visible="true"/>
              <ai:col fieldname="ORGANIZE_NAME" width="140" editable="true" visible="true"/>
              --%>
            </ai:table>
           </ai:contractframe>
		   
           <ai:contractframe id="" contenttype="table"  title="sec.qsecstaffselect.selectinterface" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
		  	<ai:contractitem/>
          	<ai:table setname="com.ai.secframe.orgmodel.web.SETSecOpStationOrg" tableid="DBTableOpStation"
							 tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
							 parametersname="com.ai.secframe.orgmodel.web.SecOpStationAction" pagesize="5"
							 initial = "false" multiselect = "true" needrefresh="true" editable = "false" width="100%" height="120">
				 		<ai:col fieldname="OP_STATION_ID"  visible="false"/>
						<ai:col fieldname="CODE"   visible="true"/>
						<ai:col fieldname="STAFF_NAME"  visible="true"/>
						<ai:col fieldname="STATION_ID"  visible="false"/>
						<ai:col fieldname="STATION_NAME"  visible="true"/>
						<ai:col fieldname="ORGANIZE_NAME"  visible="true"/>
						<ai:col fieldname="ORG_CODE"  visible="true"/>
						<ai:col fieldname="CREATE_DATE"  visible="true"/>
						<ai:col fieldname="STATE"  visible="true"/>
				 	</ai:table>
           </ai:contractframe>
	<div class="area_button">
         <ai:button id="onSelectBtn" text="sec.confirm" i18nRes="i18n.secframe_resource" onclick="addOpStation()"/>&nbsp;&nbsp;
    	 <ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" onclick="cancel()"/>
    </div>
	</td>
  </tr>
</table>
<script type="text/javascript">
	var organizeId = -1;
	var curOrgId = -1;
	
	function getDBGridStation()
	{
		return g_TableRowSetManager.get("dbTableStation");
	}
	
	function getDBGridOpStation()
	{
		return g_TableRowSetManager.get("DBTableOpStation");
	}
	/**
	 * 点击组织节点显示该组织所包含的操作员
	 */
	function treeNodeClick(organizeId,organizeName,treeUserObj,treeNodeType)
	{
		var dbgridStation = getDBGridStation();
		if(organizeId == -1)
		{
			return;
		}
		curOrgId = organizeId;
		dbgridStation.refresh("refresh","organizeId="+organizeId);
		// 初始化子页面状态
		//document.frames[0].init(0, -1, curOrgId);
	}
	/**
	 * 根据选中的操作员初始化操作员/岗位信息区
	 */
	function selectStation(){
		
		var dbgridStation = getDBGridStation();
		var stationId = dbgridStation.getValue(dbgridStation.getRow(),"STATION_ID");
		//curOrgId = dbgridStation.getValue(dbgridStation.getRow(),"ORGANIZE_ID");
		var dbGridOpStation=getDBGridOpStation();
		dbGridOpStation.refresh("refresh","stId="+stationId);
	}
	/**
	 * 获取组织树
	 */
	function getOrgTree(){
		var dbTree = g_DBTreeNewManager.get("orgTree");
		return dbTree;
	}
	/**
	 * MO操作员授权
	 */
	function addOpStation(){
	   // alert(getDBGridOpStation().getSelectedRows())
		if(getDBGridOpStation().getTotalRowCount()==0){
			alert(g_I18NMessage("sec_qsecstaffselec", "sec_qsecstaffselect_nonote"));
			return;
		}
		var ids="";
		var codes="";
		var names = "";
		for(var j =0 ;j< getDBGridOpStation().getTotalRowCount() ; j++){
			if(getDBGridOpStation().isSelected(j)){
			 ids= getDBGridOpStation().getValue(j,"OP_STATION_ID") + "," + ids;
			 codes=getDBGridOpStation().getValue(j,"CODE") + "," + codes;
	   		 names= getDBGridOpStation().getValue(j,"STAFF_NAME") + "," + names;
			}
		}
		var list = new Array();
		list[0] = ids;
		list[1] = codes;
		list[2] = names;												
		window.returnValue = list;
		window.self.close();
	}
	/**
	 * 查询操作员与员工信息
	 */
	function searchStationList(){
		return;
		var dbgridStation = getDBGridStation(); 
		var name = document.getElementById("name").value;
		var code = document.getElementById("code").value;
		var bill = document.getElementById("billId").value;
		
		var nameCond = "";
		var codeCond = "";
		var billCond="";
		
		var flag = false;
		
		if(name != null && name != "")
		{
			name = encodeURI(name); 
			name = encodeURI(name);
			nameCond = "name="+name;
		}
		if(code != null && code != "")
		{
			codeCond = "code="+code;
		}
		if(bill != null && bill != "")
		{
			billCond = "billId="+bill;
		}
		var cond = "";
		if(nameCond != "")
		{
			cond = cond + nameCond;
			flag = true;
		}
		
		if(codeCond != "")
		{
			if(flag)
			{
				cond = cond +"&"+ codeCond;
			}
			else 
			{
				cond = cond +  codeCond;
				flag = true;
			}
		}
		if(billCond != "")
		{
			if(flag)
			{
				cond = cond +"&"+ billCond;
			}
			else 
			{
				cond = cond +  billCond;
				flag = true;
			}
		}
		
		if(cond == "")
		{
			alert(g_I18NMessage("sec_qsecstaffselec", "sec_qsecstaffselect_nonote"));
			return ;
		}
		dbgridStation.refresh("refresh",cond);
	}
	/**
	 * 根据组织查询，灰化条件查询按钮
	 */
	function QueryByOrg()
	{
		document.getElementById("byorg").style.display="block";
		document.getElementById("bycond").style.display="none";
		g_AIButtonManager.get("byorgbtn").setDisabled(true);
		g_AIButtonManager.get("bycondbtn").setDisabled(false);
	}
	/**
	 * 根据条件查询，灰化组织查询按钮
	 */
	function QueryByCond()
	{
		document.getElementById("byorg").style.display="none";
		document.getElementById("bycond").style.display="block";
		g_AIButtonManager.get("byorgbtn").setDisabled(false);
		g_AIButtonManager.get("bycondbtn").setDisabled(true);
	}
	g_AIButtonManager.get("byorgbtn").setDisabled(true);
	/**
	 * 退出，关闭窗口
	 */
	function cancel()
	{
		window.returnValue = 0;
		window.self.close();
	}
	</script>
</body>
</html>