<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="sec.orgtree.orgstructtree" res="i18n.secframe_resource"/></title>
	</head>
	
	<body>

						
            <ai:contractframe id="c1" contenttype="table"
						title="sec.orgtree.orgselect" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<div class="t-bot-mc-button">
					           <ai:button id="byorgbtn" text="sec.operator.query.org" i18nRes="i18n.secframe_resource" onclick="QueryByOrg()" enable="false" />
							   <ai:button id="bycondbtn" text="sec.operator.query.condition" i18nRes="i18n.secframe_resource" onclick="QueryByCond()"/>
  					</div>
              <ai:contractitem/>
              <table width="99%" align="center" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td>
  					
  				
  				<div id="bycond" style="display: none; height:500px;">
								<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0SSSSS">
					                      <tr>
					                        <td class="td_font"><i18n:message key="sec.org.name" res="i18n.secframe_resource"/>：</td>
					                        <td>
					                        	<input value="" type="text" id="name" style="width:130"/>
					                        </td>
					                      </tr>
					             </table>
					                    <div class="area_button">
											<ai:button text="sec.query" i18nRes="i18n.secframe_resource" id="searchOrgBtn" onclick="searchOrganize()"/>
										</div>
										<div>
										<ai:table tableid="dbTableOrg"
							setname="com.ai.secframe.orgmodel.web.SETSecOrganize"
							initial="false" multiselect="false" editable="false"
							tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
							parametersname="com.ai.secframe.orgmodel.web.SecOrganizeAction"
							 pagesize="10" onrowchange="affirm2"
							width="290" height="200" needrefresh="true" footdisplay="true">
			
                   <ai:col fieldname="ORGANIZE_ID"  width="30%" visible="true"/>
                   <ai:col fieldname="ORGANIZE_NAME" width="70%" visible="true"/>
                
                   	    </ai:table>
                   	    <div class="area_button">
                   	    <ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()" />
                   	    </div>
										</div>
										
							</div>
							<div id="byorg">
							<table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
              					<ai:dbtree_new id="orgTree"
						datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModelPub"
						multiselect="false" height="360" width="100%" ishaveline="true" ondblclick="chkCur" onselect="selectOrg"/>
								</td>
								
							</tr>
						</table>
						 <div class="area_button">
	  		<ai:button text="sec.confirm" i18nRes="i18n.secframe_resource" id="affirm" onclick="affirm()"/>&nbsp;&nbsp;
            <ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
    </div>
            				</div>
            				
								</td>
							</tr>
						</table>
					</ai:contractframe>
    
	</body>
</html>
<script type="text/javascript">
<!--
var curNode = null;
var dbTree = g_DBTreeNewManager.get("orgTree");
var dbTable = g_TableRowSetManager.get("dbTableOrg")
function affirm(){
	curNode = dbTree.getCurNodeInfo();
	
	if(curNode == null){
		alert(g_I18NMessage("secframe_orgselectdialog", "secframe_orgselectdialog_selorg"));
		return false;
	}
	
	// 根节点不处理
	if(curNode.value == "-1")
	{
		return false;
	}
	
	window.returnValue = curNode;
	window.self.close();
}
function affirm2(){
	var orgId=dbTable.getValue(dbTable.getRow(),"ORGANIZE_ID");
	var orgName=dbTable.getValue(dbTable.getRow(),"ORGANIZE_NAME");
	var object = new Object();
	object.value=orgId;
	object.text=orgName;
	window.returnValue = object;
	
	window.close();
}
/**
 * 选中一个组织节点。处理确定按钮的亮显和灰化
 */
function selectOrg()
{
	document.getElementById("affirm").disabled  = false;
	var tmpNode = dbTree.getCurNodeInfo();
	// 根节点不处理
	if(tmpNode.value == "-1")
	{
		document.getElementById("affirm").disabled  = true;
	}
}
function Organize(orgId,orgName){
	this.orgId = orgId;
	this.orgName = orgName;
}

function QueryByOrg()
	{
		document.getElementById("byorg").style.display="block";
		document.getElementById("bycond").style.display="none";
		g_AIButtonManager.get("byorgbtn").setDisabled(true);
		g_AIButtonManager.get("bycondbtn").setDisabled(false);
	}

function QueryByCond()
	{
		document.getElementById("byorg").style.display="none";
		document.getElementById("bycond").style.display="block";
		g_AIButtonManager.get("byorgbtn").setDisabled(false);
		g_AIButtonManager.get("bycondbtn").setDisabled(true);
	}

function searchOrganize(){
		
		var dbTableOrg = getDBTableOrg(); 
		var name =g_StringTrim(document.getElementById("name").value);
		
		if(name==null||name==""){
			alert(g_I18NMessage("secframe_common", "condition_empty"));
			return;
		}
		var nameCond = "";
		var flag = false;
		if(name != null && name != "")
		{
			name = encodeURI(name); 
			name = encodeURI(name);
			nameCond = "name="+name;
		}
		
	
		dbTableOrg.refresh("refreshPub",nameCond);		
	    }
	  
function getDBTableOrg()
	{
		return g_TableRowSetManager.get("dbTableOrg");
	}
	
function cancel(){	
	window.self.close();
}
function chkCur(){
	affirm();
}
//-->
</script>
