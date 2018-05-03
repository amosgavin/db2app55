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
                  		<td class="td_font"><i18n:message key="sec.func.code" res="i18n.secframe_resource"/>��</td>
                        <td><ai:dbformfield fieldname="FUNC_CODE" formid="secfuncform" width="150" /><span class="font_red">*</span>
                        <td class="td_font"><i18n:message key="sec.func.name" res="i18n.secframe_resource"/>��</td>
                        <td><ai:dbformfield fieldname="NAME" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.img" res="i18n.secframe_resource"/>��</td>
                        <td><ai:dbformfield fieldname="FUNC_IMG" formid="secfuncform" width="150" /></td>
                        <td class="td_font"><i18n:message key="sec.func.type" res="i18n.secframe_resource"/>��</td>
                        <td><ai:dbformfield fieldname="FUNC_TYPE" formid="secfuncform" width="150" /><span class="font_red">*</span></td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.typeparam" res="i18n.secframe_resource"/>��</td>
                        <td><ai:dbformfield fieldname="FUNC_ARG" formid="secfuncform" width="150" /></td>
                        <td class="td_font"><i18n:message key="sec.func.dllfile" res="i18n.secframe_resource"/>��</td>
                        <td><ai:dbformfield fieldname="DLL_PATH" formid="secfuncform" width="150" /></td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.url" res="i18n.secframe_resource"/>��</td>
                        <td  colspan="5"><ai:dbformfield fieldname="VIEWNAME" formid="secfuncform" width="410" />
                          </td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="sec.func.note" res="i18n.secframe_resource"/>��</td>
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
               &nbsp;&nbsp;&nbsp;&nbsp; ����FUNC_CODE��FUNC_TYPE�ֶ�����ʾ�������������ֶζ��������ˡ�
			<br>&nbsp;&nbsp;&nbsp;&nbsp; �ڴ˴�����ֻ������FUNC_CODE��FUNC_TYPE�������ֶε���ʾ�������Ҫ�����������ֶΣ�ֻҪ���������ֶ�������ӵ�MO�������оͿ����ˡ�
	        <br>&nbsp;&nbsp;&nbsp;&nbsp; �������Աû�и�MO��Ȩ�ޣ��Ǵ�ҳ��ʱ�ͻ���ʾ������Ϣ��
		     </font>
			<p><font color="red">
			&nbsp;&nbsp;&nbsp;&nbsp; ����������ť������Ҳ�����˿��ƣ��������Աӵ�и�moȨ�ޣ��ſ��Բ����˰�ť���������Աû�и�moȨ�ޣ���ť���ڻһ����ɵ��״̬���Ӷ�ʵ���˶԰�ť����Ȩ�޵Ŀ��ơ�
			</font></p>
			<p><font color="blue">
			&nbsp;&nbsp;&nbsp;&nbsp; �����������ʱ��ֻ�С�ϵͳ�����µĲ˵���FUNC_CODE��FUNC_TYPE�ֶ�ֵ������ʾ����������ģ���µĲ˵����������ֶβ�����ʾ��������Ϊ������MO��Ȩʱ������PARENT_ID=2������������
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
