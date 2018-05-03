<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<script language="JavaScript"
	src="<%=request.getContextPath()%>/jsv2/CommUtil.js"></script>
<html>
<head>
	<title><i18n:message key="sec.moopadd.addmo" res="i18n.secframe_resource"/></title>
<script language="javascript">                                                                                                                                                                
function MoOp(func_id,name, is_query, title ,func_name)                                                                                                                                       
{                                                                                                                                                                                                                                                                                                                                                                                        
    this.func_id = func_id;                                                                                                                                                                   
    this.name = name;                                                                                                                                                                         
    this.is_query = is_query;                                                                                                                                                                 
    this.title = title;                                                                                                                                                                       
    this.func_name=func_name;                                                                                                                                                                 
}                                                                                                                                                                                             
                                                                                                                                                                                              
   function insertFunc()                                                                                                                                                                      
   {
    var dbformMoOp = g_FormRowSetManager.get("dbformMoOp");                                                                                                                                   
   	if( dbformMoOp.getValue("NAME") == null ||                                                                                                                                                
        dbformMoOp.getValue("NAME") == ""){                                                                                                                                                   
   			alert(g_I18NMessage("secframe_moopadd", "sec_moopadd_must"));                                                                                                                                                            
   			return;                                                                                                                                                                               
   		}                                                                                                                                                                                       
    var objRelat=new MoOp(dbformMoOp.getValue("FUNC_ID"),dbformMoOp.getValue("NAME"),dbformMoOp.getValue("IS_QUERY"),dbformMoOp.getValue("TITLE"),document.getElementById("func_name").value);
                                                                                                                                                                                              
    window.returnValue = objRelat;                                                                                                                                                            
	window.close();                                                                                                                                                                             
   }                                                                                                                                                                                          
                                                                                                                                                                                              
   function closeWindowFunc()                                                                                                                                                                 
   {                                                                                                                                                                                          
    top.close();                                                                                                                                                                              
   }                                                                                                                                                                                          
</script>   
</head>
<body>
		<ai:dbform formid="dbformMoOp"
				setname="com.ai.secframe.sysmgr.web.SETSecMoOp"
				datamodel="com.ai.appframe2.web.datamodel.QueryModelForService"
				implservice_name="com.ai.secframe.sysmgr.service.interfaces.ISecMoSV"
				implservice_querymethod="queryMoOp" initial="false"
				editable="true">
				<ai:dbformfield formid="dbformMoOp" fieldname="FUNC_ID"  visible="false"/>
			<ai:contractframe id="" contenttype="table" title="sec.moopadd.detail" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
			  <ai:contractitem/>
		  		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
     			<tr>
				   <td class="td_font"><i18n:message key="sec.moopadd.name" res="i18n.secframe_resource"/></td>
					<td><ai:dbformfield formid="dbformMoOp" fieldname="NAME" width="170" height="20" editable="true" visible="true" /><span class="font_red">*</span></td>
				</tr>
				<tr>
                   <td class="td_font"><i18n:message key="sec.moopadd.query" res="i18n.secframe_resource"/></td>
					<td><ai:dbformfield formid="dbformMoOp" fieldname="IS_QUERY" width="170" height="20" editable="true" visible="true" /><span class="font_red">*</span></td>			
				</tr>
				<tr>
					<td class="td_font"><i18n:message key="sec.moopadd.title" res="i18n.secframe_resource"/></td>
					<td><ai:dbformfield formid="dbformMoOp" fieldname="TITLE" width="170" height="20" editable="true" visible="true" /></td>					
				</tr>						
				<tr>
					<td class="td_font"><i18n:message key="sec.moopadd.tablename" res="i18n.secframe_resource"/></td>
					<td>
						<input type="text" width="180" height="20" value="" width="150" id="func_name" disabled="disabled"><img id="selectDis" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="sel_func();" align="absmiddle" style="cursor:hand;"/>			
					</td>
				</tr>						
               	</table>
               </ai:contractframe>	
			</ai:dbform>
       <div class ="area_button">
		<ai:button text="sec.confirm" i18nRes="i18n.secframe_resource" id="okBtn"
			onclick="insertFunc()" style="cursor:hand"></ai:button>
		<ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" id="cancelBtn"
			onclick="closeWindowFunc()" style="cursor:hand"></ai:button>
	   </div>		


</body>
<script language="javascript">                                                                                                                                                                                                               
	var dbformSecMoOp=g_FormRowSetManager.get("dbformMoOp");        
		dbformSecMoOp.setValue("IS_QUERY","N");
		dbformSecMoOp.setValue("FUNC_ID","0");                                                
	function sel_func()                                             
	{
	 var dbformSecMoOp=g_FormRowSetManager.get("dbformMoOp");                                                                   
	 var ret = funcSelectDialog(-1);
     if(ret!=null){
     	 if("null"==ret[0].url){
     	 	alert(g_I18NMessage("secframe_moopadd", "secframe_moopadd_leaf"));
     	 	return;
     	 }
	     dbformSecMoOp.setValue("FUNC_ID",ret[0].funcId);           
	     document.getElementById("func_name").value=ret[0].funcName;
     }                                                            
	}                                                                        
</script>  

</html>
