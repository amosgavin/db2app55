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
	<!-- appframe��js�� -->
		<ai:scriptinclude src="/jsv2/Globe_v2.jsp" />
		<ai:scriptinclude src="/jsv2/UserData_v2.js" />
		<!-- bce��js�� -->
		<script src="<%=request.getContextPath()%>/bce/frame/BceFrame.js"></script>
		<script src="<%=request.getContextPath()%>/bce/frame/BceSubmitData.js"></script>
		<script src="<%=request.getContextPath()%>/bce/frame/BceSubmitUtil.js"></script>
		<%--ҵ�����������ҳ��--%>
		<title><i18n:message key="BES0000012" res="CRM"/></title>
	</head>
		<%
			//��ȡ����������	
			String CenterType = HttpUtil.getAsString(request, "CenterType");
			String CenterValue = HttpUtil.getAsString(request, "CenterValue");
			String regionId = HttpUtil.getAsString(request, "REGION_ID");
			//�ж�����������regionIdΪ�յ��ҿͻ���Ų�Ϊ��ʱ������ݿͻ���Ų�ѯ����������������ֱ��ȥ����Ա�����ڵ�����
			if (StringUtils.isBlank(regionId)) {
				regionId = (String) SessionManager.getUser().get("REGION_ID");
			}
			request.setAttribute("REGION_ID", regionId);
			//ҵ�������ʼ��������Ϣ
			BceMainBean.initial(request, response);
			
		  //����У��
    	IBceRuleReturnData returnData = BceFrameAction.isBusiCanDo(request);
    	String msg = null;
			if (returnData != null) {
				//�������������ת����ҳ��
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
			//��ȡҳ������
			IQPageFramePageValue[] pageFramePages = BceMainBean.getSoOfferBusipageConfigs();
			String soBusioperFrameId = BceMainBean.getStrBceFrameId();
			String pageFrameType = BceMainBean.getStrPageFrameType();
			
			request.setAttribute(BceUtil.BCE_FRAME_ID_KEY,soBusioperFrameId);
			BceFrameAction.writeFrameRuleDetails(pageContext,request, out);
		%>
	<script language="JavaScript" type="text/javascript">
	  //��BceFrame.js ��ʹ��
	  gFrameType = <%=pageFrameType%>;
	  
		function displayMessage(str){
		  var ret = confirm(str); 
		  if(ret == false){
		     window.location = G_RTN_URL;
		  }
		}
		//��ʼ��
		function initPage(){
		   	BCEFrame_hideWaitingBanner();
		   	<%
	    	//����ں�̨У�����ʱ,�о�����Ϣ.��ֱ����ʾ����alert�Ի���.
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
							<%--��������Ϣ��--%><i18n:message key="BES0000013" res="CRM"/>

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
									//�����Զ������
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
			<%--��һ��--%>
			<ai:button text="BES0000014" onclick="gBceFrame_goPre()"
				enable='<%=BceMainBean.getStrPrePage() == "" ? "false"
						: "true"%>'
				id="gBceFrame_preBtn" i18nRes="CRM"/>
			&nbsp;
			<%--��һ��--%>
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
			<%--�����ύ--%>
			<ai:button text="BES0000016" onclick="gBceFrame_save()"
				enable="<%=enableSaveBtn%>" id="gBceFrame_saveBtn" i18nRes="CRM"/>
			&nbsp;
			<%--ȡ ��--%>
			<ai:button text="BES0000017" onclick="gBceFrame_cancel()" enable="true"
				id="gBceFrame_cancelBtn" i18nRes="CRM"/>
		</div>
	</BODY>	
</HTML>
<script language="JavaScript" type="text/javascript">
	var STR_REGION_ID = "CenterType=RegionId&CenterValue=<%=regionId%>";//�������ĵ��ַ��� 
	var STR_COMM_PARAM="<%=BceMainBean.getStrCommParam()%>";	
	//����ÿ��ҳ������ݼ�����					
	var g_SoFrame_objPageSetsArray = new Array();
	<%BceMainBean.getSoFrameRowSet(out);%>

	//��ȡ����ID
	function getBusiOperId(){
	    return "<%=BceMainBean.getStrBusiOperId()%>";
	}
	//��ȡ��������
	function getBusiOperName(){
		return "<%=BceMainBean.getStrBusiOperName()%>";
	}
	//��ȡ�������ID
	function getBusioperFrameId(){
		return "<%=soBusioperFrameId%>";
	}
	//��ȡ���б��
	function getRegionId(){
		return "<%=regionId%>";
	}
	//��ʾ�ȴ���
    BCEFrame_showWaitingBanner();
</script>