<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.secframe.common.Constants"%>
<html>
 <%
    String rootId = Constants.STR_FUNC_ROOT_ID;
	long orgId = SessionManager.getUser().getOrgId();
 %>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<title></title>
<script language="javascript">
var rootId = "<%=rootId%>";
var filterStyle = "";//���˷�ʽ
var oldOrgId = "";

//չʾ��֯����ѡ��һ����֯
function get_branch()
{
  oldOrgId = document.all("org_id").value;
  var orgId="<%=orgId%>";
  var retVal = orgSelectDialog(orgId);
  document.all.org_id.value = retVal.value;
  var ogrName = retVal.text;
  document.all.org_name.value = ogrName.substring(0,ogrName.length-1);
  
  if(oldOrgId != retVal.value){
    saveOwn_rowChg(oldOrgId,"-1");	
    beginAIWaitBanner(refreshOwnModuleTree,"");
  }
}

function orgModuleFilter(){
	var regionCode = gdetailFormRowSet().getValue("REGION_CODE");
    saveOwn_rowChg("-1",regionCode);	
	filterStyle = "org";
	checkOrgAndRegion();
    beginAIWaitBanner(initOwnTreeTable,"",200);  
     
}
function regionModuleFilter(){
    var orgId = document.all.org_id.value;
    saveOwn_rowChg(orgId,"-1");	
    filterStyle = "region";
    checkOrgAndRegion();
    beginAIWaitBanner(initOwnTreeTable,"",200);
}
/*
 * �����֯�͵���radio��ѡ����� 
 * ����ѡ�е���� �� ���� ������ʾ
 */
function checkOrgAndRegion()
{
	var orgCheck = document.all.radio_module_filter_id[0].checked;
	var regionCodeCheck = document.all.radio_module_filter_id[1].checked;
	if (orgCheck == true)
	{
	    document.all.org_td_1.style.display = "block";
	    document.all.org_td_2.style.display = "block";

	    document.all.region_td_1.style.display = "none";
	    document.all.region_td_2.style.display = "none";
	}
	
	if (regionCodeCheck == true)
	{
	    document.all.org_td_1.style.display = "none";
	    document.all.org_td_2.style.display = "none";

	    document.all.region_td_1.style.display = "block";
	    document.all.region_td_2.style.display = "block";
	    
	    var firstEnumValueForRegionCode = "0";
	    
		// �����б�Ĭ��ѡ�е�һ���������ᴥ��DBForm��onvaluechange�¼�
		// �����ֶ����õ�һ��ѡ��Ӷ�����onvaluechange�¼�
		if (gdetailFormRowSet().getValue("REGION_CODE") == "")
		{
			gdetailFormRowSet().setValue("REGION_CODE",firstEnumValueForRegionCode);
		}
	}
}

/*
 * ���DomainId�ĳ�ʼ��ѡ�����
 */
function checkDomain()
{
	var firstEnumValueForDomainId = "1";
	
	// �����б�Ĭ��ѡ�е�һ���������ᴥ��DBForm��onvaluechange�¼�
	// �����ֶ����õ�һ��ѡ��Ӷ�����onvaluechange�¼�
	if (gsubFormRowSet().getValue("DOMAIN_ID") == "")
	{
		gsubFormRowSet().setValue("DOMAIN_ID",firstEnumValueForDomainId);
	}
}

</script>
</head>

<body onunload="backClearSession();">
<table width="78%" align="center" border="0" cellpadding="0" cellspacing="0">
 <tr>
  <td valign="top" align="top"> 
  	<ai:contractframe id="" contenttype="table" title="sec.func.funcfilter" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>	
	<ai:dbform setname="com.ai.secframe.sysmgr.web.SETSecFunctionFilter" formid="detailForm" onvalchange="detailForm_ValueChange" initial="false" editable="true">

    <table width="78%" align="center" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td>      
		   <table width="58%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td class="td_font"><i18n:message key="sec.org.func.filter" res="i18n.secframe_resource"/></td>
                <td><input type="radio" name="radio_module_filter_id" onclick="orgModuleFilter()"></td>
                <td class="td_font"><i18n:message key="sec.region.func.filter" res="i18n.secframe_resource"/></td>
                <td><input type="radio" name="radio_module_filter_id" onclick="regionModuleFilter()"></td>
              </tr>	
            </table>
        </td>
      </tr>
      <tr>
        <td>
           <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
              <tr>
                <td id="org_td_1" class="td_font" style="display:block;"><i18n:message key="sec.funcfilter.organize" res="i18n.secframe_resource"/></td>
                <td id="org_td_2" style="display:block;">
                  <input id="org_id" type="hidden">
				  <input id="org_name" readonly="readonly" style="width:130"/><img name="query_org_id" onclick="get_branch();" border="0" src="<%=request.getContextPath()%>/webframe/images/check.gif" onClick="selectOrgnize();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
                </td>
				<td id="region_td_1" class="td_font" style="display:none;"><i18n:message key="sec.funcfilter.region" res="i18n.secframe_resource"/></td>
				<td id="region_td_2" style="display:none;"><ai:dbformfield fieldname="REGION_CODE" formid="detailForm" visible="true" width="150"/></td>
				
				<ai:dbform setname="com.ai.secframe.sysmgr.web.SETSecRole" formid="subForm" onvalchange="subForm_ValueChange" initial="false" editable="true">
				<td class="td_font"><i18n:message key="sec.funcfilter.domain" res="i18n.secframe_resource"/></td>
                <td><ai:dbformfield fieldname="DOMAIN_ID" formid="subForm" visible="true" width="150"/></td>
                </ai:dbform>
              </tr>
            </table>
        </td>
      </tr>
    </table>
    </ai:dbform>
    </ai:contractframe>
  </td>
 </tr>
</table>

<table><tr><td height="5"></td></tr></table>

<table width="78%" align="center" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top" align="top">   
      <table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
	    <tr>
          <td>
            <ai:contractframe id="" contenttype="table" title="sec.funcfilter.available" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
		     <ai:contractitem/>
		     <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
				<tr><td>
                    <ai:dbtree_new id="selModuleTree" datamodel="com.ai.secframe.sysmgr.web.SecFuncByDomainTreeDataModule" 
                                   multiselect="false" height="360" width="100%" />
				</td></tr></table>
			</ai:contractframe>
          </td>
          
          <td align=center width="150">
            <img id="add_id" border="0" src="<%=request.getContextPath()%>/webframe/images/icon/right.gif"  alt="" onClick="add();" align="absmiddle" style="cursor:hand;"/>
            <br><br>
            <img id="del_id" border="0" src="<%=request.getContextPath()%>/webframe/images/icon/left.gif"  alt="" onClick="del();" align="absmiddle" style="cursor:hand;"/>
          </td>
          
		  <td align="right">
		    <ai:contractframe id="" contenttype="table" title="sec.funcfilter.filterfunc" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
		     <ai:contractitem/>
		     <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
				<tr><td>
                    <ai:dbtree_new id="ownModuleTree" datamodel="com.ai.secframe.sysmgr.web.SecFuncTreeFilterDataModel" 
                                   multiselect="false" height="360" width="100%" />
				</td></tr></table>
			</ai:contractframe>
	      </td>
        </tr>
     </table>
    </td>
   </tr>
</table>
<ai:pagearea id="��ť����">
<table border="0"  width="78%" align="center">
  <tr>
	<td width="80%"></td>
	<td>
	   <table border="0"  align="right">
		 <tr><td align="left" >
				<input  id="save_id" type="button" value="����" class="btn-2word" onclick='save();'>
			 </td>
			 <td align="right" >
			    <input  id="cancel_id" type="button" value="����" class="btn-2word" onclick='cancel();'>
			 </td>
		 </tr>
	    </table>
	</td>
   </tr>
</table>
</ai:pagearea>
</body>

<ai:script id="subForm_ValueChange" parameters="col,oldValue,newValue" remark="�� subForm ���ݵ�Ԫֵ�ı��¼�����">
    if(col == "DOMAIN_ID"){
	    if(oldValue != newValue){
		    if(filterStyle == "region"){
                var regionCode = gdetailFormRowSet().getValue("REGION_CODE");
                saveOwn_rowChg("-1",regionCode);	
			}else if(filterStyle == "org"){ 
				var orgId = document.all.org_id.value;
                saveOwn_rowChg(orgId,"-1");	
			}
			var refreshTreeTemp=function refreshTreeTemp(){
			    refreshSelModuleTree();
			    refreshOwnModuleTree();
		    }
			beginAIWaitBanner(refreshTreeTemp,"");
		}               
	}
</ai:script>
<ai:script id="gsubFormRowSet" remark="��ȡ������">
    return g_FormRowSetManager.get("subForm");
</ai:script>

<ai:script id="gdetailFormRowSet" remark="��ȡ������">
    return g_FormRowSetManager.get("detailForm");
</ai:script>		
				       
<ai:script id="detailForm_ValueChange" parameters="col,oldValue,newValue" remark="�� detailForm ���ݵ�Ԫֵ�ı��¼�����">
    saveOwn_rowChg("-1",oldValue);
                 
    if(col == "REGION_CODE"){ 
        if(oldValue != newValue){ //ˢ�±����˲˵��� 
	        beginAIWaitBanner(refreshOwnModuleTree,""); 
	    } 
    }               
</ai:script>
<ai:script id="refreshOwnModuleTree" remark="ˢ�±����˲˵���">
						var subForm = gsubFormRowSet();
						var domainId = subForm.getValue("DOMAIN_ID");
						if(domainId == ""){
						  domainId = -1;
						}       
		           	   if(filterStyle == "region"){ 
		           	      var detailFormRowSet = gdetailFormRowSet(); 
		           	      var regionCode = detailFormRowSet.getValue("REGION_CODE"); 
		           	      var regionCodeName = detailFormRowSet.getDisplayText("REGION_CODE"); 
		           	      if(regionCode == "") {
		           	         regionCode = "-1"; 
		           	      }
		           	      var dbTreeOwn = g_DBTreeNewManager.get("ownModuleTree"); 
		           	      var ownRootVal = rootId; 
		           	      dbTreeOwn.setRootNodeInfo(ownRootVal,regionCodeName,"region"); 
		           	      var strUrl = "operation=INIT"; 
		           	      strUrl += "&regionCode=" + regionCode;
		           	      strUrl +="&domainId=" + domainId; 
		           	      dbTreeOwn.refresh(ownRootVal,"1",strUrl); 
		           	   }else if(filterStyle == "org"){ 
		           	     
		           	     var orgId = document.all.org_id.value; 
		           	     var orgName = document.all.org_name.value; 
		           	     var dbTreeOwn = g_DBTreeNewManager.get("ownModuleTree"); 
		           	     var ownRootVal = rootId; 
		           	     if(orgId == ""){
		           	        orgId = "-1"; 
		           	     }
		           	     dbTreeOwn.setRootNodeInfo(ownRootVal,orgName,"org"); 
		           	     var strUrl = "operation=INIT"; 
		           	     strUrl += "&orgId=" + orgId; 
		           	     strUrl +="&domainId=" + domainId; 
		           	     dbTreeOwn.refresh(ownRootVal,"1",strUrl); 
		           	   } 
		           	     clearAddTable(); 
		           	     clearDelTable(); 
		           	     clearLeafTable(); 
		           	     update_to_old();		
</ai:script>	

<div id = "add_del" style="display:none">
<ai:table tableid="delModuleTable" setname="com.ai.secframe.sysmgr.web.SETSecFunction" footdisplay="none" needrefresh="false" tablemodel="com.ai.appframe2.web.obd.OBDDataModel"  initial="false">
	<ai:col fieldname="FUNC_ID" visible="true" />
</ai:table>
<ai:script id="gdelModuleTableRowSet" remark="��ȡ������">
  return g_TableRowSetManager.get("delModuleTable");
</ai:script>
<ai:table tableid="addModuleTable" setname="com.ai.secframe.sysmgr.web.SETSecFunction" footdisplay="none"  needrefresh="false" tablemodel="com.ai.appframe2.web.obd.OBDDataModel"  initial="false">
	<ai:col fieldname="FUNC_ID" visible="true" />
</ai:table>
<ai:script id="gaddModuleTableRowSet" remark="��ȡ������">
  return g_TableRowSetManager.get("addModuleTable");
</ai:script>
<ai:table tableid="oldModuleTable" setname="com.ai.secframe.sysmgr.web.SETSecFunction" footdisplay="none" needrefresh="false" tablemodel="com.ai.appframe2.web.obd.OBDDataModel"  initial="false">
	<ai:col fieldname="FUNC_ID" visible="true" />
</ai:table>
<ai:script id="goldModuleTableRowSet" remark="��ȡ������">
    return g_TableRowSetManager.get("oldModuleTable");
</ai:script>
<ai:table tableid="leafModuleTable" setname="com.ai.secframe.sysmgr.web.SETSecFunction" footdisplay="none" needrefresh="false" tablemodel="com.ai.appframe2.web.obd.OBDDataModel"  initial="false">
    <ai:col fieldname="FUNC_ID" visible="true" />
</ai:table>
<ai:script id="gleafModuleTableRowSet" remark="��ȡ������">
    return g_TableRowSetManager.get("leafModuleTable");
</ai:script>
</div>

	<ai:script id="ISOrgSel" parameters="" remark="�Ƿ�����֯��ѡ��">							      
		var orgId = document.all.org_id.value;
		var orgName = document.all.org_name.value;
		if(orgId == ""){
		   alert("��ѡ��һ����֯��");
		   document.all.query_org_id.focus();
		   return false;
		}else{
		   return true;
		}
	</ai:script>
	
	<ai:script id="ISRegionSel" parameters="" remark="�Ƿ��е�����ѡ��">
		var detailFormRowSet = gdetailFormRowSet();
		var regionCode = detailFormRowSet.getValue("REGION_CODE");

�������� if(regionCode == ""){
           alert("��ѡ��һ��������");
           detailFormRowSet.setFocus("REGION_CODE");
           return false; 
        }else{
           return true;
        }	
	</ai:script>	
	
		<ai:script id="IsTreeRootSel" parameters="" remark="�Ƿ�ѡ�е�������֯">
		if(filterStyle == "region"){
		   if(ISRegionSel() == false){
		      return false;
		   }else{
		      return true;
		   }    
		   
		}else if(filterStyle == "org"){
		  if(ISOrgSel() == false){
		     return false;
		  }else{
		     return true;
		  }
		}else{
		  return false;
		}
	</ai:script>	
	
	<ai:script id="isSelModuleTreeNodeSel" parameters="" remark="�жϿ��ò˵������Ƿ���Ҷ�ӽڵ㱻ѡ��">
	    var dbTreeSel = g_DBTreeNewManager.get("selModuleTree");   	
		var curSelNodeInfo = dbTreeSel.getCurNodeInfo();		

        if(curSelNodeInfo == null || curSelNodeInfo.value ==rootId){
           alert("���ڿ�ѡ���ò˵�����ѡ��һ���˵���");
           return false;
        }else{
           return true;
        }
��  </ai:script>

	<ai:script id="isOwnModuleTreeNodeSel" parameters="" remark="�жϱ����˲˵������Ƿ���Ҷ�ӽڵ㱻ѡ��">
	  var dbTreeOwn = g_DBTreeNewManager.get("ownModuleTree");   	
	  var curOwnNodeInfo = dbTreeOwn.getCurNodeInfo();		

      if(curOwnNodeInfo == null || curOwnNodeInfo.value == rootId){
         alert("���ڹ��˲˵�����ѡ��һ���˵��ڵ㣡");
         return false;
      }else{
         return true;
      }
��</ai:script>
	
	<ai:script id="add" parameters="" remark="����">	
	   if(IsTreeRootSel() == false){
	      return;
	   }
	��  if(isSelModuleTreeNodeSel() == false){
	      return;
	   }
		var dbTreeOwn = g_DBTreeNewManager.get("ownModuleTree");
		var dbTreeSel = g_DBTreeNewManager.get("selModuleTree");
		var curSelNode = dbTreeSel.getCurNodeInfo();
		var curSelNodeVal = curSelNode.value;
		var curSelNodeText = curSelNode.text;
		
		//����ˢ�����еĸ��ڵ�
	    var rootOwnNode = DBTreeNew_Public_getRootNodeObj("ownModuleTree");//�õ����ڵ�

        var strUrl = "operation=ADD";	 
        strUrl += "&curSelNodeVal=" + curSelNodeVal; 
	    dbTreeOwn.buildChildNode(rootOwnNode,"",strUrl);
    
		update_add_table(curSelNodeVal);
	</ai:script>


	<ai:script id="del" parameters="" remark="ɾ��">
	�� if(IsTreeRootSel() == false){
	      return;
	   }
     
	  if(isOwnModuleTreeNodeSel() == false){
	      return;
	  }
    
	  var dbTreeOwn = g_DBTreeNewManager.get("ownModuleTree");   	
	  var curOwnNode = dbTreeOwn.getCurNodeInfo();
	  var curOwnNodeVal = curOwnNode.value;
	  var curOwnNodeText = curOwnNode.text;

      var childNodeInfo = dbTreeOwn.getChildrenNodesInfo(curOwnNodeVal);
		
      //����ˢ�����еĸ��ڵ�
	  var rootOwnNode = DBTreeNew_Public_getRootNodeObj("ownModuleTree");//�õ����ڵ�
    
     //�õ���ɾ���ڵ�Ķ���
	 var leafModuleTable = gleafModuleTableRowSet();        
	 leafModuleTable.clear();
	 getLeaf(curOwnNodeVal,dbTreeOwn,leafModuleTable);
			  
     var strUrl = "operation=DEL";	 
     strUrl += '&curOwnNodeVal=' + curOwnNodeVal; 
	 dbTreeOwn.buildChildNode(rootOwnNode,"1",strUrl);
	  
	 update_del_table(curOwnNodeVal);
	</ai:script>

	<ai:script id="update_add_table" parameters="curNodeVal" remark="���������б�">
		 var addModuleTable = gaddModuleTableRowSet(); 
		 var delModuleTable = gdelModuleTableRowSet();
		 var oldModuleTable = goldModuleTableRowSet();
		  
		 var leafModuleTable = gleafModuleTableRowSet();
		 leafModuleTable.clear();
		 var dbTreeSel = g_DBTreeNewManager.get("selModuleTree");

		 getLeaf(curNodeVal,dbTreeSel,leafModuleTable);
 
		 var cntleafModuldTable = leafModuleTable.count();	
		 
		 var indexExistInDel = -1;
		 var indexExistInOld = -1;
    		  
		 for(var j = 0;j < cntleafModuldTable;j++){
			 var curNodeValTemp = leafModuleTable.getValue(j,"FUNC_ID");
			 indexExistInOld = indexInTable(curNodeValTemp,oldModuleTable);
			 indexExistInDel = indexInTable(curNodeValTemp,delModuleTable);
  
		     if(indexExistInDel == -1 && indexExistInOld == -1){
		         insert_table(addModuleTable,curNodeValTemp);
		     }else if(indexExistInDel > -1 && indexExistInOld > -1){
		         remove_table(delModuleTable,curNodeValTemp);
		     }  
		 }
		 clearLeafTable();		
	</ai:script>
	
	<ai:script id="update_del_table" parameters="curNodeVal" remark="����ɾ���б�">
		 var addModuleTable = gaddModuleTableRowSet(); 
		 var delModuleTable = gdelModuleTableRowSet();
		 var oldModuleTable = goldModuleTableRowSet();
		 var leafModuleTable = gleafModuleTableRowSet();
		 var cntleafModuldTable = leafModuleTable.count();
		    
		 var dbTreeOwn = g_DBTreeNewManager.get("ownModuleTree");
		 
		 var indexExistInAdd = -1;
		 var indexExistInOld = -1;
     
		 for(var j = 0;j < cntleafModuldTable;j++){
			 var curNodeValTemp = leafModuleTable.getValue(j,"FUNC_ID");
	
			 indexExistInOld = indexInTable(curNodeValTemp,oldModuleTable);
			 indexExistInAdd = indexInTable(curNodeValTemp,addModuleTable);
 
		     if(indexExistInAdd == -1 && indexExistInOld > -1){
		         insert_table(delModuleTable,curNodeValTemp);
		     }else if(indexExistInAdd > -1 && indexExistInOld == -1){
		         remove_table(addModuleTable,curNodeValTemp);
		     }  
		 }

		 clearLeafTable();	
	</ai:script>

	<ai:script id="indexInTable" parameters="curVal,maintable" remark="curVal�Ƿ���maintable���д��ڣ���󷵻�indexֵ�������ڷ���-1">
        var cntMainTable = maintable.count();
        for(var i = 0;i < cntMainTable;i++){
            var curValTemp = maintable.getValue(i,"FUNC_ID");
            if(curVal == curValTemp){
               return i;
         }
     }		
		 return -1;
	</ai:script>

	<ai:script id="update_to_old" parameters="" remark="����old�б�">

     var dbTreeOwn = g_DBTreeNewManager.get("ownModuleTree");
     var rootOwnNode = DBTreeNew_Public_getRootNodeObj("ownModuleTree");//�õ����ڵ�
     var rootOwnVal = rootOwnNode.I;

	 var oldModuleTable = goldModuleTableRowSet(); 
	 oldModuleTable.clear(); 
	  
	 var leafModuleTable = gleafModuleTableRowSet();
	 leafModuleTable.clear();   
	 
     getLeaf(rootOwnVal,dbTreeOwn,leafModuleTable);   

     var cntLeafModuleTable = leafModuleTable.count();
	 for(var i = 0;i < cntLeafModuleTable;i++){
		  oldModuleTable.newRow();
		  copyRowSet(leafModuleTable,i,oldModuleTable,i);
	 }    
	 leafModuleTable.clear();  
	</ai:script>


	<ai:script id="insert_table" parameters="add_del_table,nodeVal" remark="��ĳ��funcId������������ڣ���ô�����룬�������">
		var cnt_add_del_table = add_del_table.count();
		var isExistInTable = false;
		for(var i = 0;i < cnt_add_del_table;i++){
		   var curNodeVal = add_del_table.getValue(i,"FUNC_ID");
		   if(curNodeVal == nodeVal){
		      isExistInTable = true;
		      break;
		   }
		}

		if(isExistInTable == false){
		   add_del_table.newRow();
		   add_del_table.setValue(add_del_table.getRow(),"FUNC_ID",nodeVal,nodeVal);
		}
	</ai:script>

	<ai:script id="remove_table" parameters="add_del_table,nodeVal" remark="��ĳ��funcId�ӱ��ɾ�����������ɾ��">

		var cnt_add_del_table = add_del_table.count();
		var isExistInTable = false;
		var indexExistInTable = -1;

		for(var i = 0;i < cnt_add_del_table;i++){
		   var curNodeVal = add_del_table.getValue(i,"FUNC_ID");
		   if(curNodeVal == nodeVal){
		      isExistInTable = true;
		      indexExistInTable = i;
		      break;
		   }
		}

		if(isExistInTable == true){
		   add_del_table.deleteRow(indexExistInTable);
		}
	</ai:script>

	<ai:script id="getLeaf" parameters="curNodeVal,dbTree,leafModuleTable" remark="�õ���ǰ�ڵ������Ҷ��">	
		 var childNodeInfo = dbTree.getChildrenNodesInfo(curNodeVal);
 
		 if(childNodeInfo.length == 0 && curNodeVal != rootId){
		    leafModuleTable.newRow();
		    leafModuleTable.setValue(leafModuleTable.getRow(),"FUNC_ID",curNodeVal,curNodeVal);
		 }
		
	     for(var i = 0; i < childNodeInfo.length;i++){
	        var curNodeValTemp = childNodeInfo[i].value;
	        getLeaf(curNodeValTemp,dbTree,leafModuleTable);
	     }
	</ai:script>	

	<ai:script id="save">
	�� if(IsTreeRootSel() == false){
	     return;
	  }
	   
     var addModuleTable = gaddModuleTableRowSet();
	 var delModuleTable = gdelModuleTableRowSet();

     var add_cnt = addModuleTable.count();
     var del_cnt = delModuleTable.count();
     if(add_cnt == 0 && del_cnt == 0){
       alert("��δ�޸��κ����ݣ�");
       return;
     }
     
     
     var list = new Array();
     list[0] = addModuleTable;//����
     list[1] = delModuleTable;//����
     
	 var detailFormRowSet = gdetailFormRowSet();
	 var regionCode = "";
	 var orgId = "";
	 if(filterStyle == "region"){
		regionCode = detailFormRowSet.getValue("REGION_CODE");
		if(regionCode == ""){
		   regionCode = "-1";
		}
		orgId = "-1";
	 }else if(filterStyle == "org"){
	    orgId = document.all.org_id.value;
	    if(orgId == ""){
	       orgId = "-1";
	    }
		regionCode = "-1";
	 }
  
     var strUrl ='<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecFuncFilterAction?action=save&saveMethod=save_filter_module';
     strUrl = strUrl + '&add_cnt='+ add_cnt;
     strUrl = strUrl + '&del_cnt='+ del_cnt;
     strUrl = strUrl + '&regionCode='+ regionCode;
     strUrl = strUrl + '&orgId='+ orgId;  
     
     if(!window.confirm("��ȷ����Ҫ���浱ǰ�ı����˲˵���")){
          return;
     }

	 var r = saveRowSet(strUrl,list,false,false);//���һ������Ϊfalse,��ʾ�ύ��������
	 var flag = r.getValueByName("FLAG");
	 if(null != flag && "" != flag && flag =="INFO"){
			clearAddTable();
			clearDelTable();
			clearLeafTable();
			update_to_old();
	 }else{
	    var msg = r.getValueByName("msg");
        alert(msg);
        clearAddTable();
		clearDelTable();
	 }

	</ai:script>

<ai:script id="saveOwn_rowChg" parameters="orgId,regionCode" remark="���м�¼�ı�ʱ�򱣴�">	
						
		var addModuleTable = gaddModuleTableRowSet(); 
		var delModuleTable = gdelModuleTableRowSet();		 
					  
		var add_cnt = addModuleTable.count();
		var del_cnt = delModuleTable.count(); 
	    if(regionCode == ""){
	       regionCode = "-1";
	    }
	    if(orgId == ""){
	       orgId = "-1";
	    }
       
		if(add_cnt == 0 && del_cnt == 0){
		
		}else{
		 if(confirm( "��ǰ�Ĳ˵��������Ѿ��ı�,�Ƿ񱣴棡")){				       
		    var list = new Array();
		    list[0] = addModuleTable;//����
		    list[1] = delModuleTable;//����								     
            var strUrl ='<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecFuncFilterAction?action=save&saveMethod=save_filter_module';
            strUrl = strUrl + '&add_cnt='+ add_cnt;
	        strUrl = strUrl + '&del_cnt='+ del_cnt;
	        strUrl = strUrl + '&regionCode='+ regionCode;
	        strUrl = strUrl + '&orgId='+ orgId;     
 							      
		    var result = saveRowSet(strUrl,list,false,false);//���һ������Ϊfalse,��ʾ�ύ��������	
		    var msg = result.getValueByName("msg");
            alert(msg);
		 }
		 	clearAddTable();
			clearDelTable();
		}
	
</ai:script>

<ai:script id="cancel" parameters="" remark="����">
	�� if(IsTreeRootSel() == false){
	       return;
	   }
	  beginAIWaitBanner(refreshOwnModuleTree,"");
</ai:script>

<ai:script id="refreshSelModuleTree" remark="ˢ�¿��ò˵���">          		      
 		var dbTreeSel = g_DBTreeNewManager.get("selModuleTree");   	
		var ownRootVal = rootId;
        var subForm = gsubFormRowSet();
        var domainId = subForm.getValue("DOMAIN_ID");
        if(domainId == ""){
           domainId = -1;
        }
         
		dbTreeSel.setRootNodeInfo(ownRootVal,"���ò˵�","Module");
        var strUrl = "operation=INIT";
        strUrl += "&domainId=" + domainId;
		dbTreeSel.refresh(ownRootVal,"1",strUrl);
 </ai:script>	

 <ai:script id="setSelModuleTreeNull" remark="ˢ�¿��ò˵���">          		      
 		var dbTreeSel = g_DBTreeNewManager.get("selModuleTree");   	
		var ownRootVal = "-999999";
        var strUrl = "operation=INIT";
		dbTreeSel.setRootNodeInfo(ownRootVal,"���ò˵�","Module");
		dbTreeSel.refresh(ownRootVal,"1",strUrl);
 </ai:script>	

 <ai:script id="initOwnTreeTable" remark="��ʼ�����˲˵����ͱ��">  
    refreshOwnModuleTree();
	clearAddTable();
	clearDelTable();
	clearLeafTable();									
    update_to_old();  ��
 </ai:script>	
 <ai:script id="clearAddTable" parameters="" remark="���add��">  
	var addModuleTable = gaddModuleTableRowSet(); 
	addModuleTable.clear();			  
 </ai:script>		

 <ai:script id="clearDelTable" parameters="" remark="���del��">  
	var delModuleTable = gdelModuleTableRowSet(); 
	delModuleTable.clear();			  
 </ai:script>		

 <ai:script id="clearLeafTable" parameters="" remark="���leaf��">  
	var leafModuleTable = gleafModuleTableRowSet(); 
	leafModuleTable.clear();			  
 </ai:script>		

 <ai:script id="clearOldTable" parameters="" remark="���old��">  
	var oldModuleTable = goldModuleTableRowSet(); 
	oldModuleTable.clear();			  
 </ai:script>		


 <ai:script id="page_init" parameters="" remark="��ʼ��">

    document.all.radio_module_filter_id[0].checked = true;
    filterStyle	= "org";
    
    checkOrgAndRegion();	
    checkDomain();
    
    initOwnTreeTable();	
    refreshSelModuleTree();     
 </ai:script>
 <ai:script id="backClearSession" parameters="" remark="�˳�֮ǰ���SESSION" >                       
    var strUrl = "<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.SecFuncFilterAction?action=save&saveMethod=backClearSession";
    var r = postInfotoServer(strUrl,null);
 </ai:script>
 <script>
   page_init();
 </script>
</html>