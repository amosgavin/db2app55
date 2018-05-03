<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>


<%@page import="com.ai.appframe2.common.SessionManager"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.ai.bce.ivalues.IQPageFramePageValue"%>
<%@ page import="com.ai.bce.web.BceFrameAction" %>
<%@page import="com.ai.bce.ivalues.IBceRuleReturnData"%>
<%@page import="com.ai.bce.util.BceUtil"%>
<jsp:useBean id="BceMainBean" scope="page" class="com.ai.bce.web.BceMainBean">
</jsp:useBean>
<html>
	<head>
	<!-- appframe的js包 -->
		<ai:scriptinclude src="/jsv2/Globe_v2.jsp" />
		<ai:scriptinclude src="/jsv2/UserData_v2.js" />
		<!-- bce的js包 -->
		<script src="<%=request.getContextPath()%>/bce/frame/BceFrame.js"></script>
		<script src="<%=request.getContextPath()%>/bce/frame/BceSubmitData.js"></script>
		<script src="<%=request.getContextPath()%>/bce/frame/BceSubmitUtil.js"></script>
		<%--业务受理主框架页面--%>
		<title><i18n:message key="BES0000012" res="CRM"/></title>
	</head>
		<%
			//获取分中心类型	
			String CenterType = HttpUtil.getAsString(request, "CenterType");
			String CenterValue = HttpUtil.getAsString(request, "CenterValue");
			String regionId = HttpUtil.getAsString(request, "REGION_ID");
			//判断如果传入参数regionId为空的且客户编号不为空时，则根据客户编号查询出所属地区；否则直接去操作员的所在地区。
			if (StringUtils.isBlank(regionId)) {
				regionId = (String) SessionManager.getUser().get("REGION_ID");
			}
			request.setAttribute("REGION_ID", regionId);
			//业务受理初始化所有信息
			BceMainBean.initial(request, response);
			
		  //规则校验
    	IBceRuleReturnData returnData = BceFrameAction.isBusiCanDo(request);
    	String msg = null;
			if (returnData != null) {
				//如果规则不允许，跳转出错页面
				if (returnData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_NO) {
					request.setAttribute("ERROR_MSG", returnData.getMsg());
					request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
					return;
				} 
				else if (returnData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_WARNNING) {
					msg = returnData.getMsg();
				}
			}
			
			String firstTitle = "";
			String itemPrefix = "T_ITEM_";
			//获取页面数组
			IQPageFramePageValue[] pageFramePages = BceMainBean.getSoOfferBusipageConfigs();
			String soBusioperFrameId = BceMainBean.getStrBceFrameId();
			String pageFrameType = BceMainBean.getStrPageFrameType();
			
			request.setAttribute(BceUtil.BCE_FRAME_ID_KEY,soBusioperFrameId);
			BceFrameAction.writeFrameRuleDetails(pageContext,request, out);
		%>
	<script language="JavaScript" type="text/javascript">
	  //在BceFrame.js 中使用
	  gFrameType = <%=pageFrameType%>;
	  
		function displayMessage(str){
		  var ret = confirm(str); 
		  if(ret == false){
		     window.location = G_RTN_URL;
		  }
		}
		//初始化
		function initPage(){
		   	BCEFrame_hideWaitingBanner();
		   	<%
	    	//如果在后台校验规则时,有警告信息.则直接显示警告alert对话框.
	    	if(msg!=null){
	        	out.print("displayMessage('"+msg+"');");
	    	}
			%>
		}
		function setFrameHeight(frameName,height){
		    var frame = document.getElementById(frameName);
		    if(frame!=null)
		        frame.height= height;
		}
	</script>
	<BODY onLoad="initPage()">
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="100%" class="font_blue">
					<img
						src="<%=request.getContextPath()%>/image/button/icon_globe.gif"
						align="absmiddle">
					&nbsp;<%=BceMainBean.getStrBusiOperName()%>
							<%--——向导信息：--%><i18n:message key="BES0000013" res="CRM"/>

					<div valign="top" style="valign: top; display: inline"
						id="SOFRAME_TITLE_BANNER"
						titles="<%=StringUtils.join(BceMainBean.getTitles(), "-")%>"
						initedpage="0"></div>
					<script type="text/javascript">
		                gBceFrame_setTitleFocus(0);
		                gBceFrame_setReturnPage("<%=BceMainBean.getStrReturnPage()%>");
		                gBceFrame_setPrePage("<%=BceMainBean.getStrPrePage()%>", "<%=BceMainBean.getStrReturnPage()%>");
	            	</script>
				</td>
			</tr>
			<tr>
				<td>

					<div id='SOFRAME_DIV' pagesize="<%=pageFramePages.length%>"
						curpage="0" pageframeid=''>
						<%
							if ("3".equals(pageFrameType)) {
						%><table align="center" width="100%">
							<%
								}
							%>
							<%
								for (int i = 0; i < pageFramePages.length; i++) {
									String url = (request.getContextPath() + pageFramePages[i]
											.getPageUrl());
									String param = "PAGE_FRAME_PAGE_ID="
											+ pageFramePages[i].getPageFramePageId()
											+ "&PAGE_RULESET_ID="
											+ pageFramePages[i].getPageRulesetId() + "&"
											+ BceMainBean.getStrCommParam() + "&BUSIOPER_ID="
											+ HttpUtil.getAsString(request, "BUSIOPER_ID")
											+ "&REGION_ID=" + regionId;
									if (StringUtils.isNotBlank(CenterType)) {
										param += "&CenterType=" + CenterType;
									}
									if (StringUtils.isNotBlank(CenterValue)) {
										param += "&CenterValue=" + CenterValue;
									}
									//传递自定义参数
									if (StringUtils.isNotBlank(udfParamStr)) {
										param += "&UDF_PARAM_STR=" + udfParamStr;
									}
									if (url.indexOf("?") >= 0) {
										url += "&" + param;
									} else {
										url += "?" + param;
									}
									boolean showFrameContent = false;
									if ("3".equals(pageFrameType))
										showFrameContent = true;
									else {
										if (i == 0)
											showFrameContent = true;
									}
							%>
							<script type="text/javascript">gPageIdList[gPageIdList.length] =<%=pageFramePages[i].getPageFramePageId()%></script>
							<%
								if ("3".equals(pageFrameType)) {
							%>
							<tr>
								<td valign="top">
									<table border="0" cellspacing="0" cellpadding="0"
										background="<%=request.getContextPath()%>/jsv2/image/button/title_bg1.gif">
										<tr>
											<td width="40" height="20">
												<img
													src="<%=request.getContextPath()%>/jsv2/image/button/title_left1.gif">
											</td>
											<td class="title2"><%=pageFramePages[i].getPageTitle()%></td>
											<td width="20" height="20">
												<img
													src="<%=request.getContextPath()%>/jsv2/image/button/title_right1.gif">
											</td>
										</tr>
									</table>
									<table width="100%" border="0" align="center" cellpadding="0"
										cellspacing="1" bgcolor="#D2DFE7">
										<tr>
											<td align="center" valign="top" bgcolor="#FFFFFF">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td height="5"></td>
													</tr>
													<tr>
														<td valign="top">
															<%
																}
															%>
															<iframe <%if (!"3".equals(pageFrameType)) {%>
																onload="BCEFrame_hideWaitingBanner()" <%}%>
																title="<%=pageFramePages[i].getPageTitle()%>"
																id="ID_<%=(pageFramePages[i].getPageFramePageId())%>"
																src="<%=(showFrameContent ? url : "")%>"
																distsrc="<%=url%>"
																busipageid="<%=pageFramePages[i].getPageFramePageId()%>"
																isgetdata="<%=pageFramePages[i].getIsGetPageData()%>"
																isdatamust="<%=pageFramePages[i].getIsDataMust()%>"
																pageloadtype="<%=pageFramePages[i].getPageLoadType()%>"
																frameborder="0" align="middle" scrolling="auto"
																marginwidth="0" marginheight="0" width="100%"
																<%if (!"3".equals(pageFrameType)) {%> height="360" <%}%>
																style='display: <%=(showFrameContent ? "block" : "none")%>'
																name="<%=(itemPrefix + i)%>">
															</iframe>
															<%
																if ("3".equals(pageFrameType)) {
															%>
														</td>
													</tr>
													<tr>
														<td height="5"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<%
								}
							%>
							<%
								}
							%>
							<%
								if ("3".equals(pageFrameType)) {
							%>
						</table>
						<%
							}
						%>
					</div>
				</td>
			</tr>
		</table>
		<div id="btnArea" align="center">
			<br>
			<%
				if (!"3".equals(pageFrameType)) {
			%>
			<%--上一步--%>
			<ai:button text="BES0000014" onclick="gBceFrame_goPre()"
				enable='<%=BceMainBean.getStrPrePage() == "" ? "false"
						: "true"%>'
				id="gBceFrame_preBtn" i18nRes="CRM"/>
			&nbsp;
			<%--下一步--%>
			<ai:button text="BES0000015" onclick="gBceFrame_goNext()" enable='true'
				id="gBceFrame_nextBtn" i18nRes="CRM"/>
			&nbsp;
			<%
				}
				String enableSaveBtn = "false";
				if ("3".equals(pageFrameType)) {
					enableSaveBtn = "true";
				}
			%>
			<%--受理提交--%>
			<ai:button text="BES0000016" onclick="gBceFrame_save()"
				enable="<%=enableSaveBtn%>" id="gBceFrame_saveBtn" i18nRes="CRM"/>
			&nbsp;
			<%--取 消--%>
			<ai:button text="BES0000017" onclick="gBceFrame_cancel()" enable="true"
				id="gBceFrame_cancelBtn" i18nRes="CRM"/>
		</div>
	</BODY>	
</HTML>
<script language="JavaScript" type="text/javascript">
	var STR_REGION_ID = "CenterType=RegionId&CenterValue=<%=regionId%>";//设置中心的字符串 
	var STR_COMM_PARAM="<%=BceMainBean.getStrCommParam()%>";	
	//生成每个页面的数据集参数					
	var g_SoFrame_objPageSetsArray = new Array();
	<%BceMainBean.getSoFrameRowSet(out);%>

	//获取操作ID
	function getBusiOperId(){
	    return "<%=BceMainBean.getStrBusiOperId()%>";
	}
	//获取操作名称
	function getBusiOperName(){
		return "<%=BceMainBean.getStrBusiOperName()%>";
	}
	//获取操作框架ID
	function getBusioperFrameId(){
		return "<%=soBusioperFrameId%>";
	}
	//获取地市编号
	function getRegionId(){
		return "<%=regionId%>";
	}
	//显示等待条
    BCEFrame_showWaitingBanner();
</script>