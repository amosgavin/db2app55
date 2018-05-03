<%--
	作者：江晓莉
	创建日期:2013-10-11
	功能说明：资费套餐查询

 --%>
<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.secframe.common.bo.SysOperateLog"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page
	import="com.asiainfo.common.service.interfaces.IAbstractProductExtSV"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>
<%@ page import="com.asiainfo.charge.ivalues.IBOProductExtDescValue"%>
<script language="javascript"
	src="<%=request.getContextPath()%>/jsv2/DBListBox.js"></script>

<%
IAbstractProductExtSV sv = (IAbstractProductExtSV) ServiceFactory
			.getService(IAbstractProductExtSV.class);
	IBOProductExtDescValue[] values = sv.getColsName("", "", "1", "",
			-1, -1); //全部选出
	List<String> cols = new ArrayList<String>();
	Map distinctCols = new HashMap();
	List<String> colList = new ArrayList<String>();
	List<String> gprsCols = new ArrayList<String>(); //gprs  只有一个，列无重复
	List<String> typeList = new ArrayList<String>();
	List<String> gprsTitles = new ArrayList<String>(); //gprs 列不会重复
	for (int i = 0; i < values.length; i++) {
		String ext_type = values[i].getExtType();
		if (ext_type.equals("GPRS")) {
			gprsCols.add(values[i].getExtCode());
			gprsTitles.add(values[i].getExtName());

		}  
		else if(!"SALE".equals(ext_type)) {
			if (null == distinctCols.get(values[i].getExtCode())) {
				distinctCols.put(values[i].getExtCode(), values[i]
						.getExtName());
				colList.add(values[i].getExtCode());
			}
			cols.add(values[i].getExtCode());
			typeList.add(values[i].getExtType());
		}

	}
%>
<html>

	<head>
		<title>资费套餐查询</title>

	</head>
	<body onLoad="init();">
		<input type="hidden" id="qryCols" />
		<ai:contractframe id="prodInfoQry" contenttype="table" title="查询信息"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform setname="com.asiainfo.charge.web.SETPrivGprsAttr"
				formid="formQry"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false">

				<table>
					<thead>
						<tr>
							<td class="td_font" width="150">
								优惠名称
							</td>
							<td width="200">
								<ai:dbformfield formid="formQry" fieldname="PRIVNAME"
									width="150" />
							</td>
							<td class="td_font" width="150">
								资费类型
							</td>
							<td width="200">
								<ai:listbox ds="com.asiainfo.sale.common.web.DSSaleStaticData"
									parameters="codeType=priv_type" id="privType"
									onchange="selectGrid();" width="150" />
							</td>
							<td class="td_font" width="150">
								优惠ID
							</td>
							<td width="200">
								<ai:dbformfield formid="formQry" fieldname="PRIVID" width="150" />
							</td>
						</tr>
					</thead>
					<tbody id="priv_qry">
						<tr>
							<td class="td_font" width="150">
								赠送内容说明
							</td>
							<td width="200">
								<ai:dbformfield formid="formQry" fieldname="ATTR_NAME"
									width="150" />
							</td>
							<td class="td_font" width="150">
								资费政策号
							</td>
							<td width="200">
								<input type="text" id="planId1" name="planId1" width="150" />
							</td>
							<td class="td_font" width="150">
								是否按天折算
							</td>
							<td width="200">
								<ai:listbox ds="com.asiainfo.sale.common.web.DSSaleStaticData"
									parameters="codeType=IS_CHARGE_PROD_EXT" id="isCanDay1"
									nullid="" nulltext="请选择" width="150" />
							</td>
						</tr>
						<tr>
							<td class="td_font" width="150">
								赠送时长下限
							</td>
							<td width="150">
								<input type="text" name="cost_low" id="cost_low"  onkeyup="this.value=this.value.replace(/[^\d]/g,'')" />
							</td>
							<td class="td_font" width="150">
								赠送时长上限
							</td>
							<td width="150">
								<input type="text" name="cost_up" id="cost_up"  onkeyup="this.value=this.value.replace(/[^\d]/g,'')" />
							</td>
						</tr>

					</tbody>
					<tbody id="gprs_qry" style="display: none">
						<tr>
							<td class="td_font" width="150">
								资费政策号
							</td>
							<td width="200">
								<input type="text" id="planId2" name="planId2" width="150" />
							</td>
							<td class="td_font" width="150">
								国内流量下限
							</td>
							<td width="200">
								<input type="text" id="free3_low" name="free3_low"  onkeyup="this.value=this.value.replace(/[^\d]/g,'')"/>
							</td>
							<td class="td_font" width="150">
								国内流量上限
							</td>
							<td width="200">
								<input type="text" id="free3_up" name="free3_up"  onkeyup="this.value=this.value.replace(/[^\d]/g,'')"/>
							</td>

						</tr>
						<tr>
							<td class="td_font" width="150">
								省内流量下限
							</td>
							<td width="200">
								<input type="text" id="free1_low" name="free1_low"  onkeyup="this.value=this.value.replace(/[^\d]/g,'')"/>
							</td>
							<td class="td_font" width="150">
								省内流量上限
							</td>
							<td width="200">
								<input type="text" id="free1_up" name="free1_up"  onkeyup="this.value=this.value.replace(/[^\d]/g,'')"/>
							</td>

							<td class="td_font" width="150">
								是否区别TD
							</td>
							<td width="200">
								<ai:dbformfield formid="formQry" fieldname="GROUPID" width="150" />
							</td>

						</tr>
						<tr>
							<td class="td_font" width="150">
								省际流量下限
							</td>
							<td width="200">
								<input type="text" id="free2_low" name="free2_low" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" />
							</td>
							<td class="td_font" width="150">
								省际流量上限
							</td>
							<td width="200">
								<input type="text" id="free2_up" name="free2_up"  onkeyup="this.value=this.value.replace(/[^\d]/g,'')"/>
							</td>
							<td class="td_font" width="150">
								是否按天折算
							</td>
							<td width="200">
								<ai:listbox ds="com.asiainfo.sale.common.web.DSSaleStaticData"
									parameters="codeType=IS_CHARGE_PROD_EXT" id="isCanDay2"
									nullid="" nulltext="请选择" width="150" />
							</td>

						</tr>
						<tr>
							<td class="td_font" width="150">
								是否区分上下半月
							</td>
							<td width="200">
								<ai:dbformfield formid="formQry" fieldname="HALFFLAG"
									width="150" />
							</td>
						</tr>

					</tbody>
				</table>

			</ai:dbform>

			<table>
				<tr align="right">
					<td width="750" colspan="5">
					<td>
						
						<ai:button id="qryProdInfo" text="查询" onclick="qryProdInfo()" />
						&nbsp;
						<ai:button id="qryMoreProdInfo" text="高级查询"
							onclick="qryMoreProdInfo()" />

					</td>
				</tr>
			</table>
		</ai:contractframe>
		<div id="basicInfo" style="display: block">
			<ai:contractframe id="basicProdInfo" contenttype="table"
				title="基本资费套餐信息(双击查看历史信息)" width="100%" allowcontract="true"
				frameclosed="false">
				<ai:contractitem />
				<ai:table tableid="basicProd"
					setname="com.asiainfo.charge.web.SETProductInfo"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.asiainfo.charge.service.interfaces.IProdInfoQrySV"
					implservice_querymethod="getBasicProdInfo(String qryCols,String prodName,
											String type, String attrId,String privId,String condStr,int $STARTROWINDEX,int $ENDROWINDEX )"
					implservice_countmethod="getBasicProdInfoCount(String qryCols,String prodName, String type,String attrId,
											String privId,String condStr)"
					initial="false" ondbclick="showHis" onrowchange="" pagesize="20"
					onafterturnpage="recoverInfo" editable="" width="100%" height="180"
					needrefresh="true" multiselect="true">

					<%
						for (int i = 0; i < colList.size(); i++) {
							String fieldname = colList.get(i);
							String title = (String) distinctCols.get(fieldname);
					%>
					<ai:col fieldname="<%=fieldname%>" title="<%=title%>"
						visible="true" />
					<%
						}
					%>

				</ai:table>

			</ai:contractframe>
		</div>

		<div id="gprsInfo" style="display: none">
			<ai:contractframe id="gprsProdInfo" contenttype="table"
				title="流量资费套餐信息(双击查看历史信息)" width="100%" allowcontract="true"
				frameclosed="false">
				<ai:contractitem />
				<ai:table tableid="gprsProd"
					setname="com.asiainfo.charge.web.SETGprsProductInfo"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.asiainfo.charge.service.interfaces.IProdInfoQrySV"
					implservice_querymethod="getBasicProdInfo(String qryCols,String prodName,
											String type, String attrId,String privId,String condStr,int $STARTROWINDEX,int $ENDROWINDEX )"
					implservice_countmethod="getBasicProdInfoCount(String qryCols,String prodName, String type,String attrId,
											String privId,String condStr)"
					initial="false" ondbclick="showHis" onrowchange="" pagesize="20"
					editable="" width="100%" height="180" needrefresh="true"
					multiselect="true">

					<%
						for (int i = 0; i < gprsCols.size(); i++) {
							String fieldname1 = gprsCols.get(i);
							String title1 = gprsTitles.get(i);
					%>
					<ai:col fieldname="<%=fieldname1%>" title="<%=title1%>"
						visible="true" />
					<%
						}
					%>

				</ai:table>

			</ai:contractframe>
		</div>

		<div class="area_button">

			<ai:button id="addAttr" text="属性管理" onclick="addAttr()" />
			&nbsp;&nbsp;
			<ai:button id="modifyData" text="修改数据" onclick="modifyData()" />

		</div>


	</body>
</html>
<script language="javascript" type="text/javascript">

	var formQry =g_FormRowSetManager.get("formQry");
	var basicProdInfo =g_TableRowSetManager.get("basicProd");
	g_getListBox("privType").delItem("SALE");

	var colsArray = new Array();
	var gprsProdInfo = g_TableRowSetManager.get("gprsProd");
	
	<% for(String str:cols){ %>
	colsArray.push("<%=str%>");
	<%}%>
	
	
	var typeArray = new Array();
	<% for(String type:typeList){ %>
		typeArray.push("<%=type%>");
	<%}%>
	
	
	function init(){
	
		var type = g_getListBox("privType").getID();
		controlColsShow("basicProd",type);
		
	}
	
	//翻页后恢复信息
	function recoverInfo(){
			var type = g_getListBox("privType").getID();
			controlColsShow("basicProd",type);
	}
	
	//控制列的显示与隐藏
	function controlColsShow(gridId,type){
		var qryArray = new Array();
		
		
		if(type !="GPRS"){
			for(var i = 0; i < typeArray.length; i ++){
				if(type == typeArray[i]){
				  
					g_TableRowSetManager.get(gridId).setColVisible(colsArray[i],true);
				
					qryArray.push(colsArray[i]);
					//alert(colsArray[i]);
					//out.print(colsArray[i]);
					
					
				}
				else{
					var isUse = false;
				
					for(var j= 0; j <qryArray.length; j++){
					
						if(colsArray[i] == qryArray[j]){
							
							isUse = true;
							break;
							
						}	
						else{
							isUse = false;
							continue;
						}
					}
					
					if(!isUse){
						
						g_TableRowSetManager.get(gridId).setColVisible(colsArray[i],false);
					}
				}
				
			}
		}
		else{
				<%for(int i = 0 ; i < gprsCols.size();i ++){	
				%>
						qryArray.push("<%=gprsCols.get(i)%>");
				<%}%>
				
		}
		
		document.getElementById("qryCols").value = qryArray.join();
	
		
		
		
	}

	function addAttr(){

		var type = g_getListBox("privType").getID();
	
		var url = "<%=request.getContextPath()%>/charge/product/attrMgr.jsp?type="+type;
		var result = window.showModalDialog(url,'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:800px");
	
		window.location.reload();
			
		
	}
	
	function qryProdInfo(){
		var cond = getCond("");
		executeQry(cond);
		
	}
	function executeQry(cond){
	
		//add by jiangxl 新增查询条件拼接
		var qryFlag = "";
		var privType = g_getListBox("privType").getID();
		if(privType != null && privType !=""){
			if(privType == "GPRS"){
				qryFlag = "2";
			}
			else{
				qryFlag ="1";
				
			}	
		}else{
			alert("请选择资费类型!");
			return;
		}

		var msg = "请稍后......";
		var qry_fun = function(){
			if(qryFlag=="" || qryFlag =="1"){
				g_TableRowSetManager.get("basicProd").refresh(cond);
				controlColsShow("basicProd",privType);
		
			}
			if(qryFlag ==""||qryFlag =="2"){
				gprsProdInfo.refresh(cond);
				
			}
		}
		beginAIWaitBanner(qry_fun,msg);
		
		
	}

	function selectGrid(){
	
		var privType = g_getListBox("privType").getID();
			
		if(privType == "GPRS"){
			
			controlColsShow("gprsProd",privType);
			document.getElementById("gprsInfo").style.display = "block";
			document.getElementById("basicInfo").style.display ="none";
			document.getElementById("priv_qry").style.display="none";
			document.getElementById("gprs_qry").style.display="block";
			
		}
		else{
			document.getElementById("gprsInfo").style.display = "none";
			document.getElementById("basicInfo").style.display ="block";
			document.getElementById("priv_qry").style.display="block";
			document.getElementById("gprs_qry").style.display="none";
			controlColsShow("basicProd",privType);
		}
	   
	  
	}
	
	function modifyData(){
		var extType = g_getListBox("privType").getID(); 
		if(extType == "GPRS"){
			gridId= "gprsProd";
		}
		else {
			gridId = "basicProd";
		}
		
		var selectRows = g_TableRowSetManager.get(gridId).getSelectedRows();
		if(selectRows.length <=0){
			alert("请选择要修改的记录");
			return;
		}
		if (selectRows.length>1){
			alert("您只能选择一条记录");
			return;
		}
		
		var privId = g_TableRowSetManager.get(gridId).getValue(selectRows[0],"PRIVID");
		var attrId = "";
		if(extType != "GPRS"){
			attrId =  g_TableRowSetManager.get(gridId).getValue(selectRows[0],"ATTR_ID");
		}
		
		var url = "<%=request.getContextPath()%>/charge/product/modifyData.jsp?type="+extType+"&privId="+privId+"&attrId="+attrId;
		var result = window.showModalDialog(url,'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:800px");
		qryProdInfo();
		
		
	}
	
	function showHis(){
		var extType =  g_getListBox("privType").getID();
		if(extType == "GPRS"){
			gridId= "gprsProd";
		}
		else {
			gridId = "basicProd";
		}
		var privId = g_TableRowSetManager.get(gridId).getValue(g_TableRowSetManager.get(gridId).getRow(),"PRIVID");
		var attrId = "";
		if(extType != "GPRS"){
		 attrId =  g_TableRowSetManager.get(gridId).getValue(g_TableRowSetManager.get(gridId).getRow(),"ATTR_ID");
		}
		var url = "<%=request.getContextPath()%>/charge/product/attrDataHis.jsp?extType="+extType+"&privId="+privId+"&attrId="+attrId;
		window.open(url);
	}
	
	function qryMoreProdInfo(){
		var extType =  g_getListBox("privType").getID();
		var url = "<%=request.getContextPath()%>/charge/product/advanceQry.jsp?extType="+extType;
		var result = window.showModalDialog(url,'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:800px");
		
	
		var cond = getCond(result);
		
		executeQry(cond);
		
	}
	
	function getCond(appendStr){
		var condStr= "";
		var prodName = encodeURI(formQry.getValue("PRIVNAME"));
		var privType =g_getListBox("privType").getID();
		var qryCols = document.getElementById("qryCols").value ;
		var cond = "";
		if(null != qryCols && ""!= qryCols){
			cond+="&qryCols="+qryCols;
		}
		
		if(prodName!=null && prodName != ""){
			cond += "&prodName="+prodName;
			
		}
		if(privType != null && privType !=""){
		
			cond+="&type="+privType;
			condStr += getCondStr(privType);
			var privId = formQry.getValue("PRIVID");
			if(null != privId && ""!=privId){
				if(""!=condStr){
					condStr+=" and ";
				}
				condStr+="PRIVID='"+privId+"'";
				
			}
			
		}
	
		if(null != appendStr && ""!= appendStr){
			if(""!=condStr){
				condStr+=" and ";
			}
			condStr+=appendStr;
		}
		
		cond +="&condStr="+encodeURI(condStr);
		
		return cond;
	}
	
	function getCondStr(extType){
		var condStr = "";
		if(extType == "GPRS"){
			var planId2  = document.getElementById("planId2").value;
				if(null != planId2 && ""!= planId2){
					if(condStr != ""){
						condStr +=" and ";
					}
					condStr+="RATEPLANID='"+planId2+"'";
				}
				var free3_low =  document.getElementById("free3_low").value;
				var free3_up =  document.getElementById("free3_up").value;
				var free2_low =  document.getElementById("free2_low").value;
				var free2_up =  document.getElementById("free2_up").value;
				var free1_low =  document.getElementById("free1_low").value;
				var free1_up =  document.getElementById("free1_up").value;
				if(null != free3_low && ""!= free3_low){
					if(condStr != ""){
						condStr +=" and ";
					}
					condStr+="STD_FREE3>="+free3_low;
				}
				if(null != free3_up && ""!= free3_up){
					if(condStr != ""){
						condStr +=" and ";
					}
					condStr+="STD_FREE3<="+free3_up;
				}
				if(null != free2_low && ""!= free2_low){
					if(condStr != ""){
						condStr +=" and ";
					}
					condStr+="STD_FREE2>="+free2_low;
				}
				if(null != free2_up && ""!= free2_up){
					if(condStr != ""){
						condStr +=" and ";
					}
					condStr+="STD_FREE2<="+free2_up;
				}
				if(null != free1_low && ""!= free1_low){
					if(condStr != ""){
						condStr +=" and ";
					}
					condStr+="STD_FREE1>="+free1_low;
				}
				if(null != free1_up && ""!= free1_up){
					if(condStr != ""){
						condStr +=" and ";
					}
					condStr+="STD_FREE1<="+free1_up;
				}
				var groupId = formQry.getValue("GROUPID");
				var isCanDay2 = g_getListBox("isCanDay2").getID();
				
				if(null != groupId && ""!= groupId){
					if(condStr != ""){
						condStr +=" and ";
					}
				
					if(groupId == "1"){
						condStr+="GROUPID='TD'";
					}
					else{
						condStr+="(GROUPID='GPRS' or GROUPID is null)";
					}
					
				}
				if(null != isCanDay2 && ""!= isCanDay2){
					if(condStr != ""){
						condStr +=" and ";
					}
					condStr+="ISCALBYDAY="+isCanDay2;
				}
				
				var halfFlag =  formQry.getValue("HALFFLAG");
				if(null != halfFlag && ""!= halfFlag){
					if(condStr != ""){
						condStr +=" and ";
					}
					condStr+="HALFFLAG="+halfFlag;
				}
				
		
		}
		else{
			var attrName = formQry.getValue("ATTR_NAME");
			var planId1 = document.getElementById("planId1").value;
			var isCanDay1 = g_getListBox("isCanDay1").getID();
			var cost_low = document.getElementById("cost_low").value;
			var cost_up = document.getElementById("cost_up").value;
			if(null != attrName && ""!= attrName){
				if(condStr != ""){
					condStr +=" and ";
				}
		      	condStr+="ATTR_NAME LIKE '%"+attrName+"%'";	
					
			}
			if(null != planId1 && ""!= planId1){
				if(condStr != ""){
					condStr +=" and ";
				}
		      	condStr+="RATEPLANID='"+planId1+"'";	
					
			}
			if(null != isCanDay1 && ""!= isCanDay1){
				if(condStr != ""){
					condStr +=" and ";
				}
		      condStr+="ISCALBYDAY="+isCanDay1;
					
			}
			
			if(null != cost_low && ""!= cost_low){
					if(condStr != ""){
						condStr +=" and ";
					}
					condStr+="PRIV_COST>="+cost_low;
				}
				if(null != cost_up && ""!= cost_up){
					if(condStr != ""){
						condStr +=" and ";
					}
					condStr+="PRIV_COST<="+cost_up;
				}
			
		}
	
		return condStr;
	}
	
	
</script>