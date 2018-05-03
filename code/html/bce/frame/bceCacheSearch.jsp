<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<%@ page import="com.ai.bce.web.BceFrameAction"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jsv2/UserData_v2.js">

</script>
<html>
	<head>
	</head>
	<body>
		<div>
			<fieldset>
				<legend>
					<%=LocaleResourceFactory.getResource("BES0000861") %>
				</legend>
				<table>
					<tr>
						<td><%=LocaleResourceFactory.getResource("BES0000862") %></td>
						<td>
							<select id="isBce">
								<option value="1">
									<%=LocaleResourceFactory.getResource("BES0000863") %>
								</option>
								<option value="0">
									<%=LocaleResourceFactory.getResource("BES0000864") %>
								</option>
							</select>
						</td>
						<td>							<%=LocaleResourceFactory.getResource("BES0000865") %></td>
						<td>
							<select id="isEjb">
								<option value="1">
									<%=LocaleResourceFactory.getResource("BES0000868") %>
								</option>
								<option value="0">
									<%=LocaleResourceFactory.getResource("BES0000869") %>
								</option>
							</select>
						</td>
						<td>
							<td>
								<%=LocaleResourceFactory.getResource("BES0000866") %>
							</td>
							<td>
								<select id="listCache">
								</select>
							</td>
						</td>
					</tr>
					<tr>
						<td>
							Key:
						</td>
						<td colspan="4">
							<input type="text" id="Key_Value" />
						</td>
						<td>
							<input id="i_select" type="button" value="<%=LocaleResourceFactory.getResource("BES0000860") %>" />  
						</td>
						<td><font color="red"><%=LocaleResourceFactory.getResource("BES0000859") %></font>
							<%=LocaleResourceFactory.getResource("BES0000858") %><a href="<%=request.getContextPath()%>/crm/common/CacheRefresh.jsp" >crm/common/CacheRefresh.jsp </a>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>
					<%=LocaleResourceFactory.getResource("BES0000867") %>
				</legend>
				<div id="listData">
					
				</div>
			</fieldset>
		</div>
		
		<script type="text/javascript">
		refreshList(1);
		function $(id){
			return document.getElementById(id);
		}
		$("isBce").onchange=function(){
				var isBce = $("isBce").value;
				refreshList(isBce);
		};
		function refreshList(isBce){
			var url = "<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=getCacheList&isBce="+isBce;
			var ud = PostInfo(url,"");
			var listCache = $("listCache");
			if(ud.getValueByName("FLAG")=="Y"){
				var listCahe = ud.getValueByName("listCache");
				var array = listCahe.split(",");
				listCache.options.length=0;
				for(var i= 0;i<array.length;i++){
					if(array[i]!=""){
						listCache.options.add(new Option(array[i],array[i]));
					}
				}
			}
		}
		 $("i_select").onclick=function(){
			 	var isBce=$("isBce").value;
			 	var isEjb =$("isEjb").value;
			 	var cacheKey =$("listCache").value;
			 	var Key_Value = $("Key_Value").value;
			 	var url = "<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=getCacheData&isBce="+isBce+"&isEjb="+isEjb+"&cacheKey="+cacheKey+"&Key_Value="+Key_Value;
				var ud = PostInfo(url,"");
				var i=0;
				var listData  = $("listData");
				var html ="<table width=\"98%\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_out\">";
					html=html+"<tr><td class=\"table_head\" width=\"5%\">Total records</td><td class=\"table_head\">record</td></tr>"
				for(;;){
					var value = ud.getValueByName("data"+i);
					if(value == null){
						break;
					}
					html=html+"<tr><td class=\"td_one\">"+(i+1)+"</td><td class=\"td_one\">";
					html= html+value;
					html=html+"</td></tr>";
					i++;
				}
				var html = html+"</table>";
				listData.innerHTML = html;
		};
	
	</script>
	</body>
</html>