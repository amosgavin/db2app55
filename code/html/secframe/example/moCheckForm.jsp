<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="sec.func.funcmgr" res="i18n.secframe_resource"/></title>
</head>
<body>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
 <tr>
           <td width="220" valign="top">
           <ai:contractframe id="" contenttype="table" title="sec.func.funcmgr" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
		  <ai:contractitem/>
		  <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
			<ai:dbtree_new id="secfunction_tree" height="500" width="100%" 
				   datamodel="com.ai.secframe.sysmgr.web.SecFunctionDataModel" 
				   initial="true" ishaveline="true"
				   onselect="SecfuncInfoLoad" />
						</td>
					</tr>
				</table>
			</ai:contractframe>
		</td>
		<td valign="top" align="right">
		<ai:dbform formid="secfuncform" 
			datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
			setname="com.ai.secframe.sysmgr.web.SETSecFunction" 
			implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecFunctionSV"
			implservice_querymethod="querySecFunction"
			initial="false"
			mo="com.ai.secframe.renlltest.moCheckFormAttr" operator="moCheckFormAttr" modealtype="hidden">
			 
              <ai:contractframe id="" contenttype="table" title="sec.func.info" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			  <ai:contractitem/>
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                <tr>
                  		<td class="td_font"><i18n:message key="sec.func.code" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="FUNC_CODE" formid="secfuncform" width="150" /><span class="font_red">*</span>
                        <td class="td_font"><i18n:message key="sec.func.name" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="NAME" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.img" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="FUNC_IMG" formid="secfuncform" width="150" /></td>
                        <td class="td_font"><i18n:message key="sec.func.type" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="FUNC_TYPE" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.typeparam" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="FUNC_ARG" formid="secfuncform" width="150" /></td>
                        <td class="td_font"><i18n:message key="sec.func.dllfile" res="i18n.secframe_resource"/>：</td>
                        <td><ai:dbformfield fieldname="DLL_PATH" formid="secfuncform" width="150" /></td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.url" res="i18n.secframe_resource"/>：</td>
                        <td  colspan="5"><ai:dbformfield fieldname="VIEWNAME" formid="secfuncform" width="410" />
                          </td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.note" res="i18n.secframe_resource"/>：</td>
                        <td  colspan="5"><ai:dbformfield fieldname="NOTES" formid="secfuncform" width="410" /></td>
                      </tr>
              </table>
			</ai:contractframe>
          	 </ai:dbform>
          	 <div id="buttonDiv" class="area_button">
              <ai:button mo="com.ai.secframe.renlltest.moCheckFormButton" operator="moCheckButton" text="sec.func.addbutton" i18nRes="i18n.secframe_resource" id="addFunc" onclick="newMenuItemAction()"/>&nbsp;&nbsp;
              <ai:button text="sec.func.savebutton" i18nRes="i18n.secframe_resource" id="save" onclick="updateAction()"/>&nbsp;&nbsp;
              <ai:button text="sec.func.delbutton" i18nRes="i18n.secframe_resource" id="delSysFunc" onclick="delMenuItemAction()"/>
            </div>
            <div align="left">
             <p><font color="red">
               &nbsp;&nbsp;&nbsp;&nbsp; 除了FUNC_CODE和FUNC_TYPE字段有显示出来，其他的字段都给隐藏了。
			<br>&nbsp;&nbsp;&nbsp;&nbsp; 在此处我们只控制了FUNC_CODE和FUNC_TYPE这两个字段的显示，如果想要控制其他的字段，只要将其他的字段属性添加到MO的属性中就可以了。
	        <br>&nbsp;&nbsp;&nbsp;&nbsp; 如果操作员没有该MO的权限，那打开页面时就会提示错误信息。
		     </font>
			<p><font color="red">
			&nbsp;&nbsp;&nbsp;&nbsp; 对于新增按钮，我们也进行了控制，如果操作员拥有该mo权限，才可以操作此按钮；如果操作员没有该mo权限，则按钮处于灰化不可点击状态。从而实现了对按钮操作权限的控制。
			</font></p>
			<p><font color="blue">
			&nbsp;&nbsp;&nbsp;&nbsp; 当点击左侧的树时，只有“系统管理”下的菜单的FUNC_CODE和FUNC_TYPE字段值可以显示出来，其它模块下的菜单的这两个字段不能显示，这是因为我们在MO授权时配置了PARENT_ID=2的限制条件。
			</font></p>
            
            
            </div>
            </td>
            </tr>
        </table>
          	 
</body>

<script language="javascript">

var secFuncRowSet = g_FormRowSetManager.get("secfuncform");
var dbtree = g_DBTreeNewManager.get("secfunction_tree");

function refreshTree(){
   var dbtree = g_DBTreeNewManager.get("secfunction_tree");
   var ud = dbtree.refresh(null,1);
}

function SecfuncInfoLoad(){
	var conStr = "";
	//setBtnDisabled(2);
	var dbtree = g_DBTreeNewManager.get("secfunction_tree");
	var curNode = dbtree.getCurNodeInfo();
	var curSysfuncId = curNode.value;
	if(curNode== null || curSysfuncId ==""){
	  //setBtnDisabled(3);
	  return;
	}
	if(curSysfuncId==1){
		document.all.item("save").disabled = true;
		document.all.item("delSysFunc").disabled = true;
	}
	conStr ="STATE=1 and FUNC_ID="+curSysfuncId ;
	secFuncRowSet.refresh(conStr);
    secFuncRowSet = g_FormRowSetManager.get("secfuncform");
}
</script>
</html>
