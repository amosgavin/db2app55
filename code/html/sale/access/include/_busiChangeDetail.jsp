<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<head>
<title>业务变更申请</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/jquery/jquery-1.8.3.js" type="text/javascript"></script>
</head>
<div id = "sale_div">
<ai:contractframe id="saleBusiChangeframe" contenttype="table" title="业务变更-营销案信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="删除" id="del_bt1" onclick="delBusiChangeDetail('sale')"/></ai:contractitem>
	<ai:table tableid="saleBusiChangeTab" setname="com.asiainfo.sale.access.web.SETBusiChangeDetail" height="100" multiselect="true" oncellchange="" 
		oncontextmenu="" needrefresh="true" onrowchange="showSaleBusiChangeDetailInfo" pagesize="30"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV"
		implservice_querymethod="getBusiChangeDetailByPID(String busiId, String busiType,int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="getBusiChangeDetailCountByPID(String busiId, String busiType)" 
		initial="false" editable="false">
	        	<ai:col fieldname="BUSID_ID" visible="false"/>
	        	<ai:col fieldname="ACT_CODE" visible="false"/>
	            <ai:col fieldname="ACT_NAME" width="250" visible="true"/>
	            <ai:col title="档次编码" fieldname="LEV_CODE" width="200" visible="true"/>
	        	<ai:col title="档次名称" fieldname="LEV_NAME" width="250" visible="true"/>
	            <ai:col fieldname="HAS_TICKET" width="170" visible="true"/>
	            <ai:col fieldname="CHANGE_TYPE" width="250" visible="true"/>
	</ai:table>
</ai:contractframe>
</div>
<div id = "charge_div">
<ai:contractframe id="chargeBusiChangeframe" contenttype="table" title="业务变更-资费案信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="删除" id="del_bt2" onclick="delBusiChangeDetail('charge')"/></ai:contractitem>
	<ai:table tableid="chargeBusiChangeTab" setname="com.asiainfo.sale.access.web.SETBusiChangeDetail" height="100" multiselect="true" oncellchange="" 
		oncontextmenu="" needrefresh="true" onrowchange="showChargeBusiChangeDetailInfo" pagesize="30"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV"
		implservice_querymethod="getBusiChangeDetailByPID(String busiId, String busiType,int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="getBusiChangeDetailCountByPID(String busiId, String busiType)" 
		initial="false" editable="false">
	        	<ai:col fieldname="BUSID_ID" visible="false"/>
	            <ai:col title="BOSS资费编码" fieldname="LEV_CODE" width="250" visible="true"/>
	        	<ai:col title="BOSS资费名称" fieldname="LEV_NAME" width="250" visible="true"/>
	            <ai:col fieldname="CHANGE_TYPE" width="300" visible="true"/>
	</ai:table>
</ai:contractframe>
</div>
<div id="net_div">
<ai:contractframe id="netBusiChangeframe" contenttype="table" title="业务变更-入网方案信息 " width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="删除" id="del_bt3" onclick="delBusiChangeDetail('net')"/></ai:contractitem>
	<ai:table tableid="netBusiChangeTab" setname="com.asiainfo.sale.access.web.SETBusiChangeDetail" height="100" multiselect="true" oncellchange="" 
		oncontextmenu="" needrefresh="true" onrowchange="showNetBusiChangeDetailInfo" pagesize="30"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV"
		implservice_querymethod="getBusiChangeDetailByPID(String busiId, String busiType,int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="getBusiChangeDetailCountByPID(String busiId, String busiType)" 
		initial="false" editable="false">
	        	<ai:col fieldname="BUSID_ID" visible="false"/>
	            <ai:col title="BOSS入网方案编码" fieldname="LEV_CODE" width="250" visible="true"/>
	        	<ai:col title="BOSS入网方案名称" fieldname="LEV_NAME" width="250" visible="true"/>
	            <ai:col fieldname="CHANGE_TYPE" width="300" visible="true"/>
	</ai:table>
</ai:contractframe>
</div>
<div id="changeinfo_crm_div" style="display: none">
<ai:contractframe id="ModDetailframe" contenttype="table" title="CRM-变更明细" width="100%" allowcontract="true" frameclosed="true">
<ai:contractitem/>
    <div id="privmod_div" style="display: none">
	<ai:contractframe id="PrivDetailframe" contenttype="table" title="档次-基本信息" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivDetailTab" footdisplay="none"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing" 
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="60" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="营销方案编码" fieldname="COL1" width="180" />
		        <ai:col title="营销方案名称" fieldname="COL2" width="170" />
		        <ai:col title="开始时间" fieldname="COL3" width="170" />
		        <ai:col title="停用时间" fieldname="COL4" width="200" />
		        <ai:col title="营销方案类型" fieldname="COL5" width="170" />
		        <ai:col title="创建单位" fieldname="COL6" width="100" />
		        <ai:col title="优惠对象类型" fieldname="COL7" width="130" />
		        <ai:col title="优惠价值" fieldname="COL8" width="100" />
		 </ai:table>
	</ai:contractframe>
	
	<ai:contractframe id="Privorgframe" contenttype="table" title="档次-使用单位" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivorgTab" footdisplay="rowcount"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="营销方案编码" fieldname="COL1" width="180" />
		        <ai:col title="单位编码" fieldname="COL2" width="170" />
		        <ai:col title="创建时间" fieldname="COL3" width="170" />
		        <ai:col title="状态" fieldname="COL4" width="170" />
		        <ai:col title="状态时间" fieldname="COL5" width="170" />
		</ai:table>
	</ai:contractframe>  
		
	<ai:contractframe id="Privrewardframe" contenttype="table" title="档次-可选奖品" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivrewardTab" footdisplay="none"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="营销方案编码" fieldname="COL1" width="180" />
		        <ai:col title="计算方式" fieldname="COL2" width="170" />
		        <ai:col title="优惠值" fieldname="COL3" width="170" />
		        <ai:col title="奖品编码" fieldname="COL4" width="170" />
		        <ai:col title="奖品包ID(无用)" fieldname="COL5" width="170" />
		        <ai:col title="选择方式" fieldname="COL6" width="170" />
		        <ai:col title="状态时间" fieldname="COL7" width="170" />
		</ai:table>
	</ai:contractframe>
	
	<ai:contractframe id="Privoperframe" contenttype="table" title="档次-指定工号" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivoperTab" footdisplay="none"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="营销方案编码" fieldname="COL1" width="180" />
		        <ai:col title="地区" fieldname="COL2" width="170" />
		        <ai:col title="对象编码" fieldname="COL3" width="170" />
		        <ai:col title="操作方式" fieldname="COL4" width="170" />
		        <ai:col title="操作员/工作组" fieldname="COL5" width="170" />
		        <ai:col title="创建时间" fieldname="COL6" width="170" />
		        <ai:col title="状态" fieldname="COL7" width="70" />
		        <ai:col title="状态时间" fieldname="COL8" width="130" />
		</ai:table>
	</ai:contractframe>
	
	<ai:contractframe id="otherInfoframe" contenttype="table" title="档次-其它变更" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="otherInfoTab" footdisplay="rowcount"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="255" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="100" />
		        <ai:col title="" fieldname="COL1" width="180" />
		        <ai:col title="" fieldname="COL2" width="170" />
		        <ai:col title="" fieldname="COL3" width="170" />
		        <ai:col title="" fieldname="COL4" width="170" />
		        <ai:col title="" fieldname="COL5" width="170" />
		        <ai:col title="" fieldname="COL6" width="170" />
		        <ai:col title="" fieldname="COL7" width="70" />
		        <ai:col title="" fieldname="COL8" width="130" />
		        <ai:col title="" fieldname="COL9" width="130" />
		        <ai:col title="" fieldname="COL10" width="130" />
		        <ai:col title="" fieldname="COL11" width="130" />
		        <ai:col title="" fieldname="COL12" width="130" />
		        <ai:col title="" fieldname="COL13" width="130" />
		        <ai:col title="" fieldname="COL14" width="130" />
		        <ai:col title="" fieldname="COL15" width="130" />
		        <ai:col title="" fieldname="COL16" width="130" />
		        <ai:col title="" fieldname="COL17" width="130" />
		        <ai:col title="" fieldname="COL18" width="130" />
		        <ai:col title="" fieldname="COL19" width="130" />
		        <ai:col title="" fieldname="COL20" width="130" />
		</ai:table>
	</ai:contractframe>
	</div>
	
	<div id="prodmod_div" style="display: none">
	<ai:contractframe id="prodInfoframe" contenttype="table" title="批次-变更信息" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="prodInfoTab" footdisplay="rowcount"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="255" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="100" />
		        <ai:col title="" fieldname="COL1" width="180" />
		        <ai:col title="" fieldname="COL2" width="170" />
		        <ai:col title="" fieldname="COL3" width="170" />
		        <ai:col title="" fieldname="COL4" width="170" />
		        <ai:col title="" fieldname="COL5" width="170" />
		        <ai:col title="" fieldname="COL6" width="170" />
		        <ai:col title="" fieldname="COL7" width="70" />
		        <ai:col title="" fieldname="COL8" width="130" />
		        <ai:col title="" fieldname="COL9" width="130" />
		        <ai:col title="" fieldname="COL10" width="130" />
		        <ai:col title="" fieldname="COL11" width="130" />
		        <ai:col title="" fieldname="COL12" width="130" />
		        <ai:col title="" fieldname="COL13" width="130" />
		        <ai:col title="" fieldname="COL14" width="130" />
		        <ai:col title="" fieldname="COL15" width="130" />
		        <ai:col title="" fieldname="COL16" width="130" />
		        <ai:col title="" fieldname="COL17" width="130" />
		        <ai:col title="" fieldname="COL18" width="130" />
		        <ai:col title="" fieldname="COL19" width="130" />
		        <ai:col title="" fieldname="COL20" width="130" />
		</ai:table>
	</ai:contractframe>
	</div>
	<ai:contractframe id="crmAuditframe" contenttype="table" title="审核" width="100%" allowcontract="false" frameclosed="false">
		<ai:contractitem/>
		<ai:dbform formid="crmAuditForm" initial="false" editable="true"
				setname="com.asiainfo.common.web.SETCrmAuditLog">
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr><td class="td_font">审核意见：</td>
		           	<td><ai:dbformfield formid="crmAuditForm" fieldname="CONTENT" width="600" height="50"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="INTERFACE_ID" width="170" visible="false"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="MODE_ID" width="170" visible="false"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="BOSS_CODE" width="170" visible="false"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="AUDIT_FLAG" width="170" visible="false"/>
		           	    <ai:button id="bt_yes" text="审核通过"  onclick="auditPrivMod(1)"/>
				        <ai:button id="bt_no" text="驳    回"  onclick="auditPrivMod(0)"/></td>
			</table>
	    </ai:dbform>
	</ai:contractframe>
</ai:contractframe>
</div>

<ai:contractframe id="busiChangeDetailframe" contenttype="table" title="变更信息" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem><ai:button text="新增" id="new_add_bt" onclick="newBusiChangeDetail()" /></ai:contractitem>

<ai:dbform formid="busiChangeDetailForm" 
          setname="com.asiainfo.sale.access.web.SETBusiChangeDetail"
          conditionname="condition" parametersname="parameters"
          editable="true" initial="false" onvalchange="onBusiChangeDetailFormValChange"
          datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
          implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV"
          implservice_querymethod="getBusiChangeDetailByID(String busiDId)" >
    <table width="100%" align="center" border="0" cellpadding="1" cellspacing="1">
     <tr>
       <td class="td_font">变更对象：</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_OBJECT" width="170"/><span class="font_red">*</span>
       	   <ai:dbformfield formid="busiChangeDetailForm" fieldname="BUSID_ID" width="60" editable="" visible="false"/>
       	   <ai:dbformfield formid="busiChangeDetailForm" fieldname="BUSI_ID" width="170" editable="" visible="false"/>
       </td>
       <td class="td_font">变更内容：</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_TYPE" width="200" height="50" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="busiChangeTypeMultiplySelected();"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
       </td>
     </tr>
     <tr id ="dq_kf_tr" style="display: block">
     <td class="td_font">业务类别：</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="DQ_KF" width="170"/><span class="font_red">*</span></td>
     </tr>
     <tr><td>&nbsp;&nbsp;</td></tr>
     <tr>
       <td align="left" colspan="4"><b><span class="font_red">变更前详情：</span></b></td>
     </tr>
     <tr id="query_tr" style="display: block">
     	<td id="query_td" class="td_font">查询营销案：</td>
     	<td><img id="select" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" 
       	   alt="" onClick="(selectExistInfo())" align="absmiddle" style="cursor: hand;" /></td>
     </tr>
     <tr id = "ticket_tr" style="display: block">
       <td class="td_font">变更批/档次：</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="REMARK6" width="170"/><span class="font_red">*(变更批次，档次编码可不填)</span></td>
       <td class="td_font">是否含有电子卷：</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="HAS_TICKET" width="200"/><span class="font_red">*</span></td>
     </tr>
     <tr id="act_tr" style="display: block">
     	<td class="td_font">批次编码：</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="ACT_CODE" width="170"/><span class="font_red">*</span></td>
     	<td class="td_font">批次名称：</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="ACT_NAME" width="200"/><span class="font_red">*</span></td>
     </tr> 
     <tr>
     	<td id="level_code_td" class="td_font">旧档次boss编码：</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="LEV_CODE" width="170"/><span class="font_red">*(变更前,不要修改)</span></td>
     	<td id="level_name_td" class="td_font">旧档次名称：</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="LEV_NAME" width="200"/><span class="font_red">*(变更前,不要修改)</span></td>
     </tr> 
     <tr>
        <td class="td_font">平台档次id：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="REMARK1" width="170"/><span class="font_red">*</span></td>
     </tr>
      <tr><td>&nbsp;&nbsp;</td></tr>
     <tr>
        <td class="td_font">资费营销平台或OA审批单号：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="SALE_CHARGE_ORDER" width="170" />查看工单信息<img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="checkSaleInfo();"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
     </tr>
     <tr>
       <td class="td_font">计划成本（元）：</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_BASE" width="170" /><span class="font_red">*</span></td>
       <td class="td_font">其中，电子券金额（元）：</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_TICKET_SUM" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr>
        <td class="td_font">执行开始时间：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_BEGIN_TIME" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">执行结束时间：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_END_TIME" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr>
        <td class="td_font">赠送货品名称：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PRESENT_GOODS_NAME" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">货品单价（元/个）：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PRESENT_GOODS_PRICE" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr>
        <td class="td_font">原开放渠道节点数量：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_CHANNEL_NUM" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">开放渠道类型：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_EXEC_CHANNEL" width="180" /><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="channelTypeMultiplySelected();"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
     </tr>
     <tr>
        <td class="td_font">原开放工号数量：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_JOBNUM" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">原开放品牌名称：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_OPEN_BRAND" width="180" /><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="oldOpenBrandMultiplySelected();"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
     </tr>
     <tr>
        <td class="td_font">原开放资费数量：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_CHARGE_NUM" width="170" /><span class="font_red">*</span></td>
     </tr>
     <tr><td>&nbsp;&nbsp;</td></tr>
     <tr>
       <td align="left" colspan="4"><b><span class="font_red">变更详情：</span></b></td>
     </tr>
     <tr><td>&nbsp;&nbsp;</td></tr>
        <tr>
     	<td id="level_code_td" class="td_font">变更后档次boss编码：</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="REMARK2" width="170"/></td>
     	<td id="level_name_td" class="td_font">变更后档次名称：</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="REMARK3" width="200"/></td>
     </tr> 
     <tr id="source_append_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">资源追加：</span></td>
     </tr>
     <tr id="source_append_tr2" style="display: none;">
       <td class="td_font">追加金额（元）：</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="APPEND_BASE" width="170" /><span class="font_red">*</span></td>
       <td class="td_font">其中，电子券金额（元）：</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="TICKET_SUM" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr id="time_over_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">时间终止：</span></td>
     </tr>
     <tr id="time_over_tr2" style="display: none;">
        <td class="td_font">是否时间终止：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="IS_END" width="170" /><span class="font_red">*</span></td>
     </tr>
     <tr id="time_appen_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">时间延长：</span><b><span class="font_red">(请提供活动详情、活动效果评估的附件)</span></b></td>
     </tr>
     <tr id="time_appen_tr2" style="display: none;">
        <td class="td_font">执行开始时间：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_BEGIN_TIME" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">执行结束时间：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_END_TIME" width="200" /><span class="font_red">*</span></td>
     </tr>
      <tr id="goods_change_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">货品变更：</span></td>
     </tr>
     <tr id="goods_change_tr2" style="display: none;">
        <td class="td_font">赠送货品名称：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_GOODS_NAME" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">货品单价（元/个）：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_GOODS_PRICE" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr id="channel_change_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">开放渠道变更：</span></td>
     </tr>
     <tr id="channel_change_tr2" style="display: none;">
        <td class="td_font">增加渠道节点数量：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANNEL_ADD" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">删减渠道节点数量：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANNEL_DEL" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr id="jobnum_change_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">开放工号变更：</span></td>
     </tr>
     <tr id="jobnum_change_tr2" style="display: none;">
        <td class="td_font">增加开放工号数量：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="JOBNUM_ADD" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">删减开放工号数量：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="JOBNUM_DEL" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr id="brand_change_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">品牌变更：</span></td>
     </tr>
     <tr id="brand_change_tr2" style="display: none;">
        <td class="td_font">开放品牌名称：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_OPEN_BRAND" width="170" /><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="newOpenBrandMultiplySelected();"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
     </tr>
     <tr id="charge_change_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">资费变更：</span></td>
     </tr>
     <tr id="charge_change_tr2" style="display: none;">
        <td class="td_font">增加开放资费数量：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="BRAND_CHARGE_ADD" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">删减开放资费数量：</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="BRAND_CHARGE_DEL" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr id="user_scale_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">用户规模变更：</span></td>
     </tr>
     <tr id="user_scale" style="display: none;">
     <td colspan="4">
	<ai:contractframe id="userScaleListframe" contenttype="table" title="用户规模变更" width="100%" allowcontract="true" frameclosed="false">
    	<ai:contractitem>
    		<ai:button id="bt_addUserScale" text="新增" onclick="addUserScale()"/>
    		<ai:button id="bt_delUserScale" text="删除（勾选项）" onclick="doWork('delUserScale()')"/>
    	</ai:contractitem>
   		 <ai:table
       		 tableid="userScaleListTable"
        	setname="com.asiainfo.sale.activity.web.SETUserScale"
        	tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        	implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleUserScaleSV"
        	implservice_querymethod="getUserScaleByRelaId(String relaId ,String infoType, int $STARTROWINDEX, int $ENDROWINDEX)"
        	implservice_countmethod="getCnUserScaleListByRelaId(String relaId ,String infoType)"
        	initial="false"  multiselect="true"
        	pagesize="15" editable="true" width="100%"
        	height="120" needrefresh="true">
        	<ai:col fieldname="REGION" width="15%" />
        	<ai:col fieldname="MAX_USERS" width="15%" />
        	<ai:col fieldname="START_TIME" width="15%" />
        	<ai:col fieldname="END_TIME" width="15%" />
        	<ai:col fieldname="ID" width="10%" visible="false"/>
        	<ai:col fieldname="REL_ID" width="15%" visible="false"/>
        	<ai:col fieldname="PRE_USERS" width="15%" visible="false"/>
        	<ai:col fieldname="INFO_TYPE" width="15%" visible="false"/>
   	 	</ai:table>
	</ai:contractframe>
	</td>
	</tr>
     <tr><td colspan="4" align="center"><ai:button text="保存变更明细信息" id="busid_bt" onclick="doWork('saveBusiChangeDetailInfo()')"/></td></tr>
   </table>
</ai:dbform>
</ai:contractframe>
<script language="javascript" src="<%=request.getContextPath()%>/sale/activity/js/requestToCrm.js"></script>
<script type="text/javascript">

var saleBusiChangeTab = g_TableRowSetManager.get("saleBusiChangeTab");
var chargeBusiChangeTab = g_TableRowSetManager.get("chargeBusiChangeTab");
var netBusiChangeTab = g_TableRowSetManager.get("netBusiChangeTab");
var busiChangeDetailForm = g_FormRowSetManager.get("busiChangeDetailForm");
var _userScaleListTab = g_TableRowSetManager.get("userScaleListTable");
var levSTime="";
var levETime="";
// 变更单号
var modoID = "";

function initBusiChangeDetailInfo(){
	saleBusiChangeTab.refresh("&busiId="+busiId+"&busiType=sale");
	chargeBusiChangeTab.refresh("&busiId="+busiId+"&busiType=charge");
	netBusiChangeTab.refresh("&busiId="+busiId+"&busiType=net");
	tableShowControl();
}

function tableShowControl() {
	if (saleBusiChangeTab.getTotalRowCount() == 0) {
		document.getElementById("sale_div").style.display="none";
	} else {
		document.getElementById("sale_div").style.display="block";
	}
	if (chargeBusiChangeTab.getTotalRowCount() == 0) {
		document.getElementById("charge_div").style.display="none";
	} else {
		document.getElementById("charge_div").style.display="block";
	}
	if (netBusiChangeTab.getTotalRowCount() == 0) {
		document.getElementById("net_div").style.display="none";
	} else {
		document.getElementById("net_div").style.display="block";
	}
}

function saveBusiChangeDetailInfo(){
   /* 为了临时让业务变更在测试库可以用才注释的   */
   if (busiChangeDetailForm.getValue("CHANGE_OBJECT") == 'sale') {
	   if (prodcheck() == false) {
		   if(!confirm("填写档次、批次编码在CRM端没查到,您确定要继续！")){
			   return;
		   }
	   } 
   }
   if ("O" != busiChangeDetailForm.getSts()){
	    if (busiId == '') return alert("请先保存好业务变更主信息！");
	    if (checkMustWrite() == false) return;
	    busiChangeDetailForm.setValue("BUSI_ID",busiId);
	    if (busiChangeDetailForm.getValue("CHANGE_OBJECT") == 'charge' || busiChangeDetailForm.getValue("CHANGE_OBJECT") == 'net') {
	    	if (saleBusiChangeTab.getTotalRowCount() > 0) {
	    		return alert("业务变更工单只能包含全是营销案或者（资费+入网方案）！");
	    	}
	    }
	    if (busiChangeDetailForm.getValue("CHANGE_OBJECT") == 'sale') {
	    	if (chargeBusiChangeTab.getTotalRowCount() > 0 || netBusiChangeTab.getTotalRowCount() > 0) {
	    		return alert("业务变更工单只能包含全是营销案或者（资费+入网方案）！");
	    	}
	    }
	    if (busiChangeDetailForm.getValue("CHANGE_OBJECT") == 'charge') {
	    	busiChangeDetailForm.setValue("DQ_KF","");
	    }
		var list = new Array();
		list.push(busiChangeDetailForm);
		
		var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.BusiChangeDetailAction?action=saveBusiChangeDetailInfo';
		var recode = saveRowSet(strUrl, list);
	    var rFlag = recode.getValueByName("FLAG");
	    var relId = recode.getValueByName("RELID");
	    if (relId == null || relId == 'null' || relId == "") {
        	relId = busiChangeDetailForm.getValue("BUSID_ID");
        }
		if ("Y" == rFlag)
		{
		  saleBusiChangeTab.refresh("&busiId="+busiId+"&busiType=sale");
		  chargeBusiChangeTab.refresh("&busiId="+busiId+"&busiType=charge");
		  netBusiChangeTab.refresh("&busiId="+busiId+"&busiType=net");
		  saveUserScale(relId,'n');
		  newBusiChangeDetail();
		  busiChangeDetailForm.setEditSts(true);
		  busiChangeDetailForm.setColEditSts("CHANGE_TYPE","FALSE");
		  tableShowControl();
		}
	}else{
		saveUserScale(busiChangeDetailForm.getValue("BUSID_ID"),'y');
	}
}
//活动批次ID，档次ID校验
function prodcheck() {
	var privID = busiChangeDetailForm.getValue("LEV_CODE");
	var prodID = busiChangeDetailForm.getValue("ACT_CODE");
	var retCheckInfo = query_CRM("Prodcheck",privID,prodID);
	return retCheckInfo.body.isExist == '存在';
}

function newBusiChangeDetail(){
	//busiChangeDetailForm.clearListBox("CHANGE_OBJECT");
	busiChangeDetailForm.newRow();
	busiChangeDetailForm.setColEditSts("CHANGE_TYPE","FALSE");
	//busiChangeDetailForm.setFocus("CHANGE_OBJECT");
	//busiChangeDetailForm.setValue("CHANGE_OBJECT","charge");
	busiChangeDetailForm.setFocus("CHANGE_OBJECT");
	busiChangeDetailForm.setFocus("REMARK6");
	saleBusiChangeTab.refresh("&busiId="+busiId+"&busiType=sale");
	chargeBusiChangeTab.refresh("&busiId="+busiId+"&busiType=charge");
	netBusiChangeTab.refresh("&busiId="+busiId+"&busiType=net");
	_userScaleListTab.clear();
	document.getElementById("user_scale").style.display="none";
	document.getElementById("user_scale_tr1").style.display="none";
}

function delBusiChangeDetail(changeObject){
	if(confirm("您确定要删除！")){
		var targetTab;
		if (changeObject == 'sale') {
			targetTab = saleBusiChangeTab;
		} else if (changeObject == 'charge'){
			targetTab = chargeBusiChangeTab;
		} else if (changeObject == 'net'){
			targetTab = netBusiChangeTab;
		}
		var delRows = targetTab.getSelectedRows();
		var delRowCount = delRows.length;
		if (delRowCount == 0) {
			alert("请先选择要删除的行");
			return;
		}
		while (delRowCount > 0) {
			delRowCount--;
			targetTab.deleteRow(delRows[delRowCount]);
		}
		var list = new Array();
		list.push(targetTab);
		var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.access.web.BusiChangeDetailAction?action=deleteBusiChangeDetailBatch';
		var ud = saveRowSet(strUrl, list);
		if (ud.getValueByName("FLAG") == "Y") {
			targetTab.refresh("&busiId="+busiId+"&busiType="+changeObject);
	        newBusiChangeDetail();
	        tableShowControl();
		} else {
			alert(ud.getValueByName("MESSAGE"));
			return;
		}
	}
}

function selectExistInfo(){
	var changeObject = busiChangeDetailForm.getValue("CHANGE_OBJECT");
    if("" == changeObject){
        alert("在选择前，请先填写“变更对象”！");
        busiChangeDetailForm.setFocus("CHANGE_OBJECT");
        return;
    }
    var url = "<%=request.getContextPath()%>/sale/access/include/_selectSaleOrCharge.jsp?batchType="+changeObject;
    var style = "dialogWidth:800px";
    var retMsg = window.showModalDialog(url, '', style);
    if(retMsg==null || retMsg==''){
    	return;
    } else {
    	busiChangeDetailForm.setValue("SALE_CHARGE_ORDER",retMsg.split(",")[0]);
    	busiChangeDetailForm.setValue("ACT_NAME",retMsg.split(",")[1]);
    	busiChangeDetailForm.setValue("ACT_CODE",retMsg.split(",")[2]);
    	busiChangeDetailForm.setValue("LEV_CODE",retMsg.split(",")[3]);
    	busiChangeDetailForm.setValue("LEV_NAME",retMsg.split(",")[4]);
    	busiChangeDetailForm.setValue("PLAN_BEGIN_TIME",retMsg.split(",")[5]);
    	levSTime = retMsg.split(",")[5];
    	busiChangeDetailForm.setValue("PLAN_END_TIME",retMsg.split(",")[6]);
    	levETime = retMsg.split(",")[6];
    	busiChangeDetailForm.setValue("REMARK1",retMsg.split(",")[7]);
    	busiChangeDetailForm.setColEditSts("LEV_CODE",false);
    	busiChangeDetailForm.setColEditSts("LEV_NAME",false);
    	busiChangeDetailForm.setColEditSts("REMARK1",false);
    }
}

function showSaleBusiChangeDetailInfo(oldIndex,newIndex){
    if(-1 != oldIndex) {
       saleBusiChangeTab.setRowBgColor(oldIndex,"");
    }
    saleBusiChangeTab.setRowBgColor(newIndex,"yellow");
    showBusiChangeDetail(saleBusiChangeTab.getValue(newIndex, "BUSID_ID"));
	chargeBusiChangeTab.refresh("&busiId="+busiId+"&busiType=charge");
	netBusiChangeTab.refresh("&busiId="+busiId+"&busiType=net");
	var privID = busiChangeDetailForm.getValue("LEV_CODE");
	var prodID = busiChangeDetailForm.getValue("ACT_CODE");
	var taskTag = "<%=request.getParameter("taskTag")%>";
   	if (taskTag == 'busi013') {
   		document.getElementById("changeinfo_crm_div").style.display="block";
  		showProdModDetail(privID, prodID);
  		showPrivModDetail(privID, prodID);
   	}
   	document.getElementById("TableRowSet_userScaleListTable").onclick= scaleCalendarDlg;
}

function showPrivModDetail(privID, prodID) {
	
	var PrivDetailTab = g_TableRowSetManager.get("PrivDetailTab");
	var PrivorgTab = g_TableRowSetManager.get("PrivorgTab");
	var PrivrewardTab = g_TableRowSetManager.get("PrivrewardTab");
	var PrivoperTab = g_TableRowSetManager.get("PrivoperTab");
	var otherInfoTab = g_TableRowSetManager.get("otherInfoTab");
	var privModDetail = query_CRM("Privmoddetailqry",privID, "");
	if (privModDetail == "") return;
	if (privModDetail.body.array.$list == "") return ;
	document.getElementById("privmod_div").style.display="block"
	document.all("contractFrame_ModDetailframe").style.display='block';
	modoID = privModDetail.body.array.$list[0].MODOID;
	var objname = "";
	var attr = "";
	var otherAttrNum = 0;
	var detAttr = ["营销方案编码","营销方案名称","开始时间","停用时间","营销方案类型","创建单位","优惠对象类型","优惠价值"];
	var orgAttr = ["营销方案编码","单位编码","创建时间","状态","状态时间"];
	var operAttr = ["营销方案编码","地区","对象编码","操作方式","操作员/工作组","创建时间","状态","状态日期"];
	var rewardAttr = ["营销方案编码","计算方式","优惠值","奖品编码","奖品包ID(无用)","选择方式","状态时间"];
	for (var i=0; i< privModDetail.body.array.$list.length; ++i) {
		if (privModDetail.body.array.$list[i].OBJNAME == "档次基本信息") {
			if (PrivDetailTab.count() ==  0 || objname != privModDetail.body.array.$list[i].OBJNAME 
					|| (attr.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME) != -1)) {
				PrivDetailTab.newRow(false);
				attr = "";
			}
			PrivDetailTab.setValue(PrivDetailTab.count()-1,"COL0", privModDetail.body.array.$list[i].MODTYPE);
			for (var j = 1; j < 9; ++j) {
				if (privModDetail.body.array.$list[i].OBJATTRNAME == detAttr[j-1]) {
					if (privModDetail.body.array.$list[i].OLDVALUE == "") {
						PrivDetailTab.setValue(PrivDetailTab.count()-1,"COL"+j, privModDetail.body.array.$list[i].NEWVALUE);
					} else {
						PrivDetailTab.setValue(PrivDetailTab.count()-1,"COL"+j, privModDetail.body.array.$list[i].OLDVALUE + "-->" + privModDetail.body.array.$list[i].NEWVALUE);
					}
					attr +=privModDetail.body.array.$list[i].OBJATTRNAME;
					break;
				}
			}
		} else if (privModDetail.body.array.$list[i].OBJNAME == "使用单位") {
			if (PrivorgTab.count() ==  0 || objname != privModDetail.body.array.$list[i].OBJNAME
					|| (attr.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME) != -1)){
				PrivorgTab.newRow(false);
				attr = "";
			}
			PrivorgTab.setValue(PrivorgTab.count()-1,"COL0", privModDetail.body.array.$list[i].MODTYPE);
			for (var j = 1; j < 6; ++j) {
				if (privModDetail.body.array.$list[i].OBJATTRNAME == orgAttr[j-1]) {
					PrivorgTab.setValue(PrivorgTab.count()-1,"COL"+j, privModDetail.body.array.$list[i].NEWVALUE);
					attr +=privModDetail.body.array.$list[i].OBJATTRNAME;
					break;
				}
			}
		} else if (privModDetail.body.array.$list[i].OBJNAME == "指定工号") {
			if (PrivoperTab.count() ==  0 || objname != privModDetail.body.array.$list[i].OBJNAME
					|| (attr.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME) != -1)){
				PrivoperTab.newRow(false);
				attr = "";
			}
			PrivoperTab.setValue(PrivoperTab.count()-1,"COL0", privModDetail.body.array.$list[i].MODTYPE);
			for (var j = 1; j < 9; ++j) {
				if (privModDetail.body.array.$list[i].OBJATTRNAME == operAttr[j-1]) {
					PrivoperTab.setValue(PrivoperTab.count()-1,"COL"+j, privModDetail.body.array.$list[i].NEWVALUE);
					attr +=privModDetail.body.array.$list[i].OBJATTRNAME;
					break;
				}
			}
		} else if (privModDetail.body.array.$list[i].OBJNAME == "可选奖品") {
			if (PrivrewardTab.count() ==  0 || objname != privModDetail.body.array.$list[i].OBJNAME
					|| (attr.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME) != -1)){
				PrivrewardTab.newRow(false);
				attr = "";
			}
			PrivrewardTab.setValue(PrivrewardTab.count()-1,"COL0", privModDetail.body.array.$list[i].MODTYPE);
			for (var j = 1; j < 8; ++j) {
				if (privModDetail.body.array.$list[i].OBJATTRNAME == rewardAttr[j-1]) {
					PrivrewardTab.setValue(PrivrewardTab.count()-1,"COL"+j, privModDetail.body.array.$list[i].NEWVALUE);
					attr +=privModDetail.body.array.$list[i].OBJATTRNAME;
					break;
				}
			}
		} else {
			if (otherInfoTab.count() == 0 || objname != privModDetail.body.array.$list[i].OBJNAME
					|| (attr.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME) != -1)) {
				otherInfoTab.newRow(false);
				otherInfoTab.setRowBgColor(otherInfoTab.count()-1,'A1A1A1');
				otherInfoTab.newRow(false);
				otherInfoTab.setRowBgColor(otherInfoTab.count()-1,'FFFFFF');
				//otherInfoTab.newRow(false);
				attr = "";
				otherAttrNum = 0;
			}
			++otherAttrNum;
			otherInfoTab.setValue(otherInfoTab.count()-2,"COL0", privModDetail.body.array.$list[i].OBJNAME);
			otherInfoTab.setValue(otherInfoTab.count()-1,"COL0", privModDetail.body.array.$list[i].MODTYPE);
			otherInfoTab.setValue(otherInfoTab.count()-2,"COL"+otherAttrNum, privModDetail.body.array.$list[i].OBJATTRNAME);
			otherInfoTab.setValue(otherInfoTab.count()-1,"COL"+otherAttrNum, privModDetail.body.array.$list[i].NEWVALUE);
			attr +=privModDetail.body.array.$list[i].OBJATTRNAME;
		}
		objname = privModDetail.body.array.$list[i].OBJNAME;
	}
	
	/*
	privModDetailTab.DefaultRowHeight =125;
	var j = -1;
	var chargeVal = '';
	var objName = '';
	return;
	for (var i=0; i< privModDetail.body.array.$list.length; ++i) {
		if (objName != privModDetail.body.array.$list[i].OBJNAME || 
				(objName == privModDetail.body.array.$list[i].OBJNAME
				 && chargeVal.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME) != -1)) {
			j++ ;
			if (i==1) alert(chargeVal.indexOf(privModDetail.body.array.$list[i].OBJNAME) + " " + chargeVal.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME));
			chargeVal = '';
			privModDetailTab.newRow(false);
		}
		objName = privModDetail.body.array.$list[i].OBJNAME;
		if (privModDetail.body.array.$list[i].MODTYPE == "更新" ) {
			chargeVal = chargeVal + privModDetail.body.array.$list[i].OBJATTRNAME + ": " + privModDetail.body.array.$list[i].OLDVALUE + "-->" + privModDetail.body.array.$list[i].NEWVALUE + "\n";
		} else if (privModDetail.body.array.$list[i].MODTYPE != "更新" ){
			chargeVal = chargeVal + privModDetail.body.array.$list[i].OBJATTRNAME + ": " + privModDetail.body.array.$list[i].NEWVALUE + "\n";
		}
		privModDetailTab.setValue(j,"MODOID",privModDetail.body.array.$list[i].MODOID);
		privModDetailTab.setValue(j,"OBJNAME",privModDetail.body.array.$list[i].OBJNAME);
		//privModDetailTab.setValue(i,"OBJATTRNAME",privModDetail.body.array.$list[i].OBJATTRNAME);
		privModDetailTab.setValue(j,"MODTYPE",privModDetail.body.array.$list[i].MODTYPE);
		//privModDetailTab.setValue(i,"OLDVALUE",privModDetail.body.array.$list[i].OLDVALUE);
		privModDetailTab.setValue(j,"NEWVALUE",chargeVal);
	}  */
}

function showProdModDetail(privID, prodID) {
	
	var prodInfoTab = g_TableRowSetManager.get("prodInfoTab");
	var prodModDetail = query_CRM("Prodmoddetailqry",'', prodID);
	if (prodModDetail == "") return;
	if (prodModDetail.body.array.$list == "") return;
	document.getElementById("prodmod_div").style.display="block";
	document.all("contractFrame_ModDetailframe").style.display='block';
	modoID = prodModDetail.body.array.$list[0].MODOID;
	for (var i=0; i< prodModDetail.body.array.$list.length; ++i) {
		if (prodInfoTab.count() == 0 || objname != prodModDetail.body.array.$list[i].OBJNAME
						|| (attr.indexOf(prodModDetail.body.array.$list[i].OBJATTRNAME) != -1)) {
			prodInfoTab.newRow(false);
			prodInfoTab.setRowBgColor(prodInfoTab.count()-1,'A1A1A1');
			prodInfoTab.newRow(false);
			prodInfoTab.setRowBgColor(prodInfoTab.count()-1,'FFFFFF');
			//prodInfoTab.newRow(false);
			attr = "";
			otherAttrNum = 0;
		}
		++otherAttrNum;
		prodInfoTab.setValue(prodInfoTab.count()-2,"COL0", prodModDetail.body.array.$list[i].OBJNAME);
		prodInfoTab.setValue(prodInfoTab.count()-1,"COL0", prodModDetail.body.array.$list[i].MODTYPE);
		prodInfoTab.setValue(prodInfoTab.count()-2,"COL"+otherAttrNum, prodModDetail.body.array.$list[i].OBJATTRNAME);
		if (prodModDetail.body.array.$list[i].OLDVALUE == "") {
			prodInfoTab.setValue(prodInfoTab.count()-1,"COL"+otherAttrNum, prodModDetail.body.array.$list[i].NEWVALUE);
		} else {
			prodInfoTab.setValue(prodInfoTab.count()-1,"COL"+otherAttrNum, prodModDetail.body.array.$list[i].OLDVALUE + "-->" + prodModDetail.body.array.$list[i].NEWVALUE);
		}
		attr +=prodModDetail.body.array.$list[i].OBJATTRNAME;
		objname = prodModDetail.body.array.$list[i].OBJNAME;
	}
}

function showChargeBusiChangeDetailInfo(oldIndex,newIndex){
    if(-1 != oldIndex) {
       chargeBusiChangeTab.setRowBgColor(oldIndex,"");
    }
    chargeBusiChangeTab.setRowBgColor(newIndex,"yellow");
    showBusiChangeDetail(chargeBusiChangeTab.getValue(newIndex, "BUSID_ID"));
    saleBusiChangeTab.refresh("&busiId="+busiId+"&busiType=sale");
	netBusiChangeTab.refresh("&busiId="+busiId+"&busiType=net");
}
function showNetBusiChangeDetailInfo(oldIndex,newIndex){
    if(-1 != oldIndex) {
       netBusiChangeTab.setRowBgColor(oldIndex,"");
    }
    netBusiChangeTab.setRowBgColor(newIndex,"yellow");
    showBusiChangeDetail(netBusiChangeTab.getValue(newIndex, "BUSID_ID"));
    saleBusiChangeTab.refresh("&busiId="+busiId+"&busiType=sale");
	chargeBusiChangeTab.refresh("&busiId="+busiId+"&busiType=charge");
}

function showBusiChangeDetail(busiDId){
	busiChangeDetailForm.refresh("&busiDId="+busiDId);
	_userScaleListTab.refresh("&relaId="+busiDId+"&infoType=cha");
	showChangeTypeTr(busiChangeDetailForm.getValue("CHANGE_TYPE"));
	showChangeObjectTag(busiChangeDetailForm.getValue("CHANGE_OBJECT"));
}

function checkChargeType() {
	var len1 = saleBusiChangeTab.getTotalRowCount();
	for (var i = 0 ; i < len1; ++i) {
		if (saleBusiChangeTab.getValue(i,"CHANGE_TYPE").indexOf("资源追加") >= 0 ||
			saleBusiChangeTab.getValue(i,"CHANGE_TYPE").indexOf("时间延长") >= 0	)
		    return true;
	}
	/*var len2 = chargeBusiChangeTab.getTotalRowCount();
	for (var m = 0 ; m < len2; ++m) {
		if (chargeBusiChangeTab.getValue(m,"CHANGE_TYPE").indexOf("资源追加") >= 0 ||
			chargeBusiChangeTab.getValue(m,"CHANGE_TYPE").indexOf("时间延长") >= 0	)
		    return true;
	}
	var len3 = netBusiChangeTab.getTotalRowCount();
	for (var n = 0 ; n < len3; ++n) {
		if (netBusiChangeTab.getValue(n,"CHANGE_TYPE").indexOf("资源追加") >= 0 ||
			netBusiChangeTab.getValue(n,"CHANGE_TYPE").indexOf("时间延长") >= 0	)
		    return true;
	}*/
	return false;
}

function checkSaleInfo () {
	var url = '';
	var batchId = busiChangeDetailForm.getValue("SALE_CHARGE_ORDER");
	var batchType = busiChangeDetailForm.getValue("CHANGE_OBJECT");
	if (batchType == null || batchType == ''){
		return alert("请选择变更对象！");
	}
	if (batchId == null || batchId == ''){
		return alert("请填写审批单号！");
	}
	//检查工单在平台中是否存在
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.BusiChangeDetailAction?action=isExistBatchId&batchId='+batchId +'&batchType='+batchType;
	var recode = PostInfo(strUrl);
	var rFlag = recode.getValueByName("FLAG");
	if ("Y" != rFlag)
	{
	  return alert("填写的审批单号在平台中不存在！");
	}
	//跳转到工单详细信息页面
	if (busiChangeDetailForm.getValue("CHANGE_OBJECT") == "sale")
	{
		url = "<%=request.getContextPath()%>/sale/activity/new.jsp?orderId="+busiChangeDetailForm.getValue("SALE_CHARGE_ORDER") + "&editable=false";
	}
	if (busiChangeDetailForm.getValue("CHANGE_OBJECT") == "charge")
	{
		url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeSelectInfo.jsp?applyid="+busiChangeDetailForm.getValue("SALE_CHARGE_ORDER");
	}
	//window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:600px;dialogWidth:680px");
	window.open(url, "newwin", 'height=1000,width=800,top=0,left=0,help=yes,toolbar=yes,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
				
}

function busiChangeTypeMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/BusiChangeTypeMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = busiChangeDetailForm.getValue("CHANGE_TYPE");
    busiChangeDetailForm.setValue("CHANGE_TYPE",onItemMultiplySelected(url, iniVal, style));
}

function channelTypeMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/channelTypeMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = busiChangeDetailForm.getValue("PLAN_EXEC_CHANNEL");
    busiChangeDetailForm.setValue("PLAN_EXEC_CHANNEL",onItemMultiplySelected(url, iniVal, style));
}

function oldOpenBrandMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/openBrandMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = busiChangeDetailForm.getValue("PLAN_OPEN_BRAND");
    busiChangeDetailForm.setValue("PLAN_OPEN_BRAND",onItemMultiplySelected(url, iniVal, style));
}

function newOpenBrandMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/openBrandMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = busiChangeDetailForm.getValue("CHANGE_OPEN_BRAND");
    busiChangeDetailForm.setValue("CHANGE_OPEN_BRAND",onItemMultiplySelected(url, iniVal, style));
}

function onBusiChangeDetailFormValChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
	
	if (pFieldName == 'CHANGE_OBJECT'){
		showChangeObjectTag(pOldText);
	}
	if (pFieldName == 'CHANGE_TYPE') {
		showChangeTypeTr(pOldText);
	}
}

function showChangeObjectTag(chageObject) {
	if (chageObject == "sale"){
			document.getElementById("act_tr").style.display="block";
			document.getElementById("ticket_tr").style.display="block";
			document.getElementById("query_tr").style.display="block";
			document.getElementById("level_code_td").innerText="档次编码：";
			document.getElementById("level_name_td").innerText="档次名称：";
			document.getElementById("query_td").innerText="查询营销案：";
			document.getElementById("dq_kf_tr").style.display="block";
		} else if (chageObject == "charge"){
			document.getElementById("act_tr").style.display="none";
			document.getElementById("ticket_tr").style.display="none";
			document.getElementById("query_tr").style.display="block";
			document.getElementById("level_code_td").innerText="BOSS资费编码：";
			document.getElementById("level_name_td").innerText="BOSS资费名称：";
			document.getElementById("query_td").innerText="查询资费案：";
			document.getElementById("dq_kf_tr").style.display="none";
		} else if (chageObject == "net"){
			document.getElementById("act_tr").style.display="none";
			document.getElementById("ticket_tr").style.display="none";
			document.getElementById("query_tr").style.display="none";
			document.getElementById("level_code_td").innerText="BOSS入网方案编码：";
			document.getElementById("level_name_td").innerText="BOSS入网方案名称：";
			document.getElementById("dq_kf_tr").style.display="block";
		}
}

function showChangeTypeTr(changeType){
	if (changeType.indexOf("时间终止") >= 0) {
		if (changeType.split(";").length>1){
			alert("时间终止与其它选项冲突，请确认！");
		}
		document.getElementById("time_over_tr1").style.display="block";
		document.getElementById("time_over_tr2").style.display="block";
	} else {
		document.getElementById("time_over_tr1").style.display="none";
		document.getElementById("time_over_tr2").style.display="none";
	}
	if (changeType.indexOf("资源追加") >= 0) {
		document.getElementById("source_append_tr1").style.display="block";
		document.getElementById("source_append_tr2").style.display="block";
	} else {
		document.getElementById("source_append_tr1").style.display="none";
		document.getElementById("source_append_tr2").style.display="none";
	}
	if (changeType.indexOf("时间延长") >= 0) {
		document.getElementById("time_appen_tr1").style.display="block";
		document.getElementById("time_appen_tr2").style.display="block";
	} else {
		document.getElementById("time_appen_tr1").style.display="none";
		document.getElementById("time_appen_tr2").style.display="none";
	}
	if (changeType.indexOf("货品变更") >= 0) {
		document.getElementById("goods_change_tr1").style.display="block";
		document.getElementById("goods_change_tr2").style.display="block";
	} else {
		document.getElementById("goods_change_tr1").style.display="none";
		document.getElementById("goods_change_tr2").style.display="none";
	}
	if (changeType.indexOf("开放渠道变更") >= 0) {
		document.getElementById("channel_change_tr1").style.display="block";
		document.getElementById("channel_change_tr2").style.display="block";
	} else {
		document.getElementById("channel_change_tr1").style.display="none";
		document.getElementById("channel_change_tr2").style.display="none";
	}
	if (changeType.indexOf("开放工号变更") >= 0) {
		document.getElementById("jobnum_change_tr1").style.display="block";
		document.getElementById("jobnum_change_tr2").style.display="block";
	} else {
		document.getElementById("jobnum_change_tr1").style.display="none";
		document.getElementById("jobnum_change_tr2").style.display="none";
	}
	if (changeType.indexOf("品牌变更") >= 0) {
		document.getElementById("brand_change_tr1").style.display="block";
		document.getElementById("brand_change_tr2").style.display="block";
	} else {
		document.getElementById("brand_change_tr1").style.display="none";
		document.getElementById("brand_change_tr2").style.display="none";
	}
	if (changeType.indexOf("资费变更") >= 0) {
		document.getElementById("charge_change_tr1").style.display="block";
		document.getElementById("charge_change_tr2").style.display="block";
	} else {
		document.getElementById("charge_change_tr1").style.display="none";
		document.getElementById("charge_change_tr2").style.display="none";
	}
	if (changeType.indexOf("用户规模") >= 0) {
		document.getElementById("user_scale").style.display="block";
		document.getElementById("user_scale_tr1").style.display="block";
	} else {
		document.getElementById("user_scale").style.display="none";
		document.getElementById("user_scale_tr1").style.display="none";
	}
	
}

function checkMustWrite(){
	var changeType = busiChangeDetailForm.getValue("CHANGE_TYPE");
	if (busiChangeDetailForm.getValue("CHANGE_OBJECT") == '') {
		alert("请选择变更对象！");
		return false;
	    
	}
	if (changeType == '') {
	    alert("请选择变更内容！");
	    return false;
	}
	if (busiChangeDetailForm.getValue("CHANGE_OBJECT") != 'charge'){
		if("" == busiChangeDetailForm.getValue("DQ_KF")){
			alert("请选择业务类别");
					return false;
		}
		}
	if ("sale" == busiChangeDetailForm.getValue("CHANGE_OBJECT")) {
	    if ("" == busiChangeDetailForm.getValue("ACT_CODE")) {
		    alert("请填写批次编码！");
		    return false;
	   	}
	    if ("" == busiChangeDetailForm.getValue("ACT_NAME")){
	    	alert("请填写批次名称！");
	    	return false;
	    }
	    if ("2" != busiChangeDetailForm.getValue("REMARK6")) {
	    	
		    if ("" == busiChangeDetailForm.getValue("LEV_CODE")){
		    	alert("请填写档次编码！");
		    	return false;
		    }
		    if ("" == busiChangeDetailForm.getValue("LEV_NAME")){
		    	alert("请填写档次名称！");
		    	return false;
		    }
	    }
	    if ("" == busiChangeDetailForm.getValue("HAS_TICKET")){
	    	alert("请选择是否包含电子券！");
	    	return false;
	    }
	   /* if ("" == busiChangeDetailForm.getValue("REMARK1")){
	    	alert("请填写平台档次id！");
	    	return false;
	    } */
	}
	if ("charge" == busiChangeDetailForm.getValue("CHANGE_OBJECT")) {
	    if ("" == busiChangeDetailForm.getValue("LEV_CODE")){
	    	alert("请填写BOSS资费编码！");
	    	return false;
	    }
	    if ("" == busiChangeDetailForm.getValue("LEV_NAME")){
	    	alert("请填写BOSS资费名称！");
	    	return false;
	    }
	    /* if ("" == busiChangeDetailForm.getValue("REMARK1")){
	    	alert("请填写平台档次id！");
	    	return false;
	    } */
	}
	if ("net" == busiChangeDetailForm.getValue("CHANGE_OBJECT")) {
	    if ("" == busiChangeDetailForm.getValue("LEV_CODE")){
	    	alert("请填写BOSS入网方案编码！");
	    	return false;
	    }
	    if ("" == busiChangeDetailForm.getValue("LEV_NAME")){
	    	alert("请填写BOSS入网方案名称！");
	    	return false;
	    }
	}
	if (changeType.indexOf("资源追加") >= 0) {
		if ("" == busiChangeDetailForm.getValue("APPEND_BASE")){
	    	alert("请填写追加金额！");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("TICKET_SUM")){
	    	alert("请填写电子券金额！");
	    	return false;
	    }
	}
	if (changeType.indexOf("时间终止") >= 0) {
		if ("" == busiChangeDetailForm.getValue("IS_END")){
	    	alert("请填写时间终止！");
	    	return false;
	    }
	}
	if (changeType.indexOf("时间延长") >= 0) {
		if ("" == busiChangeDetailForm.getValue("CHANGE_BEGIN_TIME")){
	    	alert("请填写执行开始时间！");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("CHANGE_END_TIME")){
	    	alert("请填写执行结束时间！");
	    	return false;
	    }
	}
	if (changeType.indexOf("货品变更") >= 0) {
		if ("" == busiChangeDetailForm.getValue("CHANGE_GOODS_NAME")){
	    	alert("请填写赠送货品名称！");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("CHANGE_GOODS_PRICE")){
	    	alert("请填写货品单价！");
	    	return false;
	    }
	}
	if (changeType.indexOf("开放渠道变更") >= 0) {
		if ("" == busiChangeDetailForm.getValue("CHANNEL_ADD")){
	    	alert("请填写增加渠道节点数量！");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("CHANNEL_DEL")){
	    	alert("请填写删减渠道节点数量！");
	    	return false;
	    }
	}
	if (changeType.indexOf("开放工号变更") >= 0) {
		if ("" == busiChangeDetailForm.getValue("JOBNUM_ADD")){
	    	alert("请填写增加开放工号数量！");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("JOBNUM_DEL")){
	    	alert("请填写删减开放工号数量！");
	    	return false;
	    }
	}
	if (changeType.indexOf("品牌变更") >= 0) {
		if ("" == busiChangeDetailForm.getValue("CHANGE_OPEN_BRAND")){
	    	alert("请填写开放品牌名称！");
	    	return false;
	    }
	}
	if (changeType.indexOf("资费变更") >= 0) {
		if ("" == busiChangeDetailForm.getValue("BRAND_CHARGE_ADD")){
	    	alert("请填写增加开放资费数量！");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("BRAND_CHARGE_DEL")){
	    	alert("请填写删减开放资费数量！");
	    	return false;
	    }
	}
}

function auditPrivMod(flag) {
	var crmAuditForm = g_FormRowSetManager.get("crmAuditForm");
	var privID = busiChangeDetailForm.getValue("LEV_CODE");
	var prodID = busiChangeDetailForm.getValue("ACT_CODE");
	var retState;
	//var modeID = privModDetailTab.getValue(privModDetailTab.getRow(),"MODOID");
	if (modoID == "") return alert("请选择需要审核的变更单号！");
	if (busiChangeDetailForm.getValue("REMARK6") == 2) {
		retState = audit_CRM("Prodmodaudit", '', prodID, modoID, flag);
   	} else {
   		retState = audit_CRM("Privmodaudit", privID, '', modoID, flag);
   	}
	if (retState.head.retCode == 0) {
		alert("审核成功！");
	} else {
		crmAuditForm.setValue("CONTENT","审核失败");
		alert("审核失败！");
	}
	crmAuditForm.setValue("INTERFACE_ID","Privmodaudit");
	crmAuditForm.setValue("BOSS_CODE",privID);
	crmAuditForm.setValue("MODE_ID",modoID);
	crmAuditForm.setValue("AUDIT_FLAG",flag);
	var list = new Array();
	list.push(crmAuditForm);
	var strUrl = _gModuleName + '/business/com.asiainfo.common.web.CrmAuditLogAction?action=saveAuditLog';
	var recode = saveRowSet(strUrl, list);
}

// 用户规模
function addUserScale() {
	
	if(busiChangeDetailForm.getValue("SALE_CHARGE_ORDER")==null||busiChangeDetailForm.getValue("SALE_CHARGE_ORDER")==''){
		alert("未选择营销案");
		return fale;
	}
	_userScaleListTab.newRow(false);
	var curRow = _userScaleListTab.getCurRowIndex();
	_userScaleListTab.setValue(curRow,"INFO_TYPE", 'cha');
	_userScaleListTab.setValue(curRow,"START_TIME", busiChangeDetailForm.getValue("PLAN_BEGIN_TIME").toString().substring(0,10));
	_userScaleListTab.setValue(curRow,"END_TIME", busiChangeDetailForm.getValue("PLAN_END_TIME").toString().substring(0,10));
	_userScaleListTab.setValue(curRow,"REGION", getDefualtExearea());
}

function delUserScale() {
	var delUserScaleList = new Array();
	delUserScaleList = _userScaleListTab.getSelectedRows();
	var delUserScaleRc = delUserScaleList.length;
    if (delUserScaleRc < 1) {
        return alert("请勾选要删除的记录！");
    }
    var relId = _userScaleListTab.getValue(0,"REL_ID");
    while (delUserScaleRc > 0) {
	    delUserScaleRc--;
	    _userScaleListTab.deleteRow(delUserScaleList[delUserScaleRc]);
    }
    if (relId == null || relId==""){
    	return;
    }
    saveUserScale("", "y");
}

function saveUserScale(levId, alertFlag) {
	if (levId != null && levId != "") {
		for (var i=0; i< _userScaleListTab.getTotalRowCount(); ++i) {
			_userScaleListTab.setValue(i, "REL_ID", levId);
		}
	} else {
		levId = busiChangeDetailForm.getValue("BUSID_ID");
	}
	var changeType = busiChangeDetailForm.getValue("CHANGE_TYPE");
	if (changeType.indexOf("用户规模") >= 0) {
		if(_userScaleListTab.getTotalRowCount()==0){
			alert("用户规模为空");
			return;
		}
		
	}else{
		return;
	}
	
	var list = new Array();
	list.push(_userScaleListTab);
  	var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.UserScaleAction?action=save';
	var recode = saveRowSet(strUrl, list);
  	var rFlag = recode.getValueByName("FLAG");
  	if (alertFlag == 'y' && rFlag == 'Y') {
  		alert("操作成功！");
  	} else if (alertFlag == 'y' && rFlag == 'N') {
  		alert("操作失败！");
  	}
	_userScaleListTab.refresh("&relaId="+levId+"&infoType=cha");
}

function scaleCalendarDlg(){
	var curRow = _userScaleListTab.getRow();
	var curCol = _userScaleListTab.getCol();
	if(_userScaleListTab.getRowEditSts(curRow) == true && (curCol==2|| curCol==3)){
	     var url = "<%=request.getContextPath()%>/jsv2/DBCalendarDlg_zh_CN.htm";
	     var ret = window.showModalDialog(url, obj, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:220px;dialogWidth:200px;unadorned:yes");
	     if (ret != null && ret != "" && ret != "none") {
			if (curCol == 2) {
				if (_userScaleListTab.getValue(curRow,"START_TIME") !="" &&
						-1 != g_CompareDate(ret, _userScaleListTab.getValue(curRow,"START_TIME"))) {
					return alert("开始时间必须小于结束时间")
				}
				_userScaleListTab.setValue(curRow, "START_TIME", ret);
			} else if (curCol == 3) {
				if (_userScaleListTab.getValue(curRow,"END_TIME") !="" &&
						-1 != g_CompareDate(_userScaleListTab.getValue(curRow,"END_TIME"),ret)) {
					return alert("结束时间必须大于开始时间")
				}
				_userScaleListTab.setValue(curRow, "END_TIME", ret);
			}
	     }
	     _userScaleListTab.setFocus(0,0);
	}
}

function getDefualtExearea(){
	var org = g_GetUserInfo().ORG_ID.substr(0,2);
	var cases = {
	  	10:999,
		11:270,
		17:710,
		13:711,
		26:712,
		25:713,
		12:714,
		19:715,
		20:716,
		14:717,
		15:718,
		16:719,
		24:722,
		23:724,
		18:728,
		27:728,
		28:728
	};
	if (cases[org]) {
  		return (cases[org]);
	}
}

function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
