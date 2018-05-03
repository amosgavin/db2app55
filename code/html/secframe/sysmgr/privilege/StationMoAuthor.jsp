<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
  <title></title>
</head>
<body>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
  <tr>
     <td  align="left" width="220" valign="top">
              <ai:contractframe id="" contenttype="table" title="sec.stationmoauthor.selstationauthor" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
              <ai:contractitem/>
              <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
        			<tr>
         			  <td>
		              <ai:dbtree_new id="orgStationTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
							multiselect="false" height="510" width="100%" ishaveline="true" onselect="orgStationClick"/>
					</td>
                  </tr>
              </table>			
		      </ai:contractframe>				
     </td>
     <td valign="top" align="right">	
     <ai:contractframe id="" contenttype="table" title="sec.stationmoauthor.stationlist" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			  <ai:contractitem/>
     			<ai:table  tableid="MoStationTable"		          
     	 			setname="com.ai.secframe.orgmodel.web.SETSecStation" 
					tablemodel="com.ai.appframe2.web.tag.ActionDataModel"		
					parametersname="com.ai.secframe.orgmodel.web.SecOpStationAction"
					initial="false"  pagesize="20" width="100%" height="420" 
					needrefresh="true" footdisplay="true" onrowchange="selectStation" ondbclick="selectMo">							
				  <ai:col fieldname="STATION_ID" width="20%" visible="false"/>	
				           <ai:col fieldname="CODE" width="20%"  visible="true" />
				           <ai:col fieldname="NAME" width="20%"  visible="true"/>
				           <ai:col fieldname="STATION_TYPE_ID" width="20%"  visible="true"/>
				           <ai:col fieldname="ORGANIZE_ID" width="20%"  visible="true"/>
				           <ai:col fieldname="CREATE_DATE" width="20%"  visible="true"/>
				           <ai:col fieldname="NOTES" visible="false"/>
               </ai:table>
              </ai:contractframe>
       <div id="buttonDiv" class="area_button">       
          <ai:button id="saveMoStAuthor" text="sec.stationmoauthor.change" i18nRes="i18n.secframe_resource" onclick="changeMoStationAuthor()"/>
       </div>   
	  </td>
	  </tr>
	  </table>														        	
</body>
  <script type="text/javascript">
  	var selStationId ="";
	/**
	 * 点击组织节点显示该组织所包含的岗位
	 */
	function orgStationClick()
	{
		var orgTree = g_DBTreeNewManager.get("orgStationTree");
		var curNode = orgTree.getCurNodeInfo();
		if(curNode != null && curNode.value != null)
		{
			if(curNode.value == -1)
			{
				return;
			}
			var rowset = g_TableRowSetManager.get("MoStationTable");
			rowset.refresh("refreshStation","organizeId="+curNode.value+"&operId=");
		}
	}
	function selectStation()
	{
	   var stationTable = g_TableRowSetManager.get("MoStationTable");
	   selStationId = stationTable.getValue(stationTable.getRow(), "STATION_ID");
	}
	function selectMo()
	{
	   var stationTable = g_TableRowSetManager.get("MoStationTable");
	   selStationId = stationTable.getValue(stationTable.getRow(), "STATION_ID");
	   var result = window.showModalDialog("<%=request.getContextPath()%>/secframe/sysmgr/privilege/SelectStationMoAuthorDialog.jsp",selStationId,"scroll:no;resizable:no;status:no;dialogHeight:500px;dialogWidth:300px");
	   selStationId = "";
	}
	function changeMoStationAuthor()
	{
	   if (null == selStationId || "" == selStationId)
        { 
             alert(g_I18NMessage("secframe_stationmoauthor" , "secframe_stationmoauthor_change"));
             return;
        }
	   var result = window.showModalDialog("<%=request.getContextPath()%>/secframe/sysmgr/privilege/SelectStationMoAuthorDialog.jsp",selStationId,"scroll:no;resizable:no;status:no;dialogHeight:500px;dialogWidth:300px");
	   selStationId = "";
	}

  </script>
</html>
