<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<head>
<title>ҵ��������</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/jquery/jquery-1.8.3.js" type="text/javascript"></script>
</head>
<div id = "sale_div">
<ai:contractframe id="saleBusiChangeframe" contenttype="table" title="ҵ����-Ӫ������Ϣ" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="ɾ��" id="del_bt1" onclick="delBusiChangeDetail('sale')"/></ai:contractitem>
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
	            <ai:col title="���α���" fieldname="LEV_CODE" width="200" visible="true"/>
	        	<ai:col title="��������" fieldname="LEV_NAME" width="250" visible="true"/>
	            <ai:col fieldname="HAS_TICKET" width="170" visible="true"/>
	            <ai:col fieldname="CHANGE_TYPE" width="250" visible="true"/>
	</ai:table>
</ai:contractframe>
</div>
<div id = "charge_div">
<ai:contractframe id="chargeBusiChangeframe" contenttype="table" title="ҵ����-�ʷѰ���Ϣ" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="ɾ��" id="del_bt2" onclick="delBusiChangeDetail('charge')"/></ai:contractitem>
	<ai:table tableid="chargeBusiChangeTab" setname="com.asiainfo.sale.access.web.SETBusiChangeDetail" height="100" multiselect="true" oncellchange="" 
		oncontextmenu="" needrefresh="true" onrowchange="showChargeBusiChangeDetailInfo" pagesize="30"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV"
		implservice_querymethod="getBusiChangeDetailByPID(String busiId, String busiType,int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="getBusiChangeDetailCountByPID(String busiId, String busiType)" 
		initial="false" editable="false">
	        	<ai:col fieldname="BUSID_ID" visible="false"/>
	            <ai:col title="BOSS�ʷѱ���" fieldname="LEV_CODE" width="250" visible="true"/>
	        	<ai:col title="BOSS�ʷ�����" fieldname="LEV_NAME" width="250" visible="true"/>
	            <ai:col fieldname="CHANGE_TYPE" width="300" visible="true"/>
	</ai:table>
</ai:contractframe>
</div>
<div id="net_div">
<ai:contractframe id="netBusiChangeframe" contenttype="table" title="ҵ����-����������Ϣ " width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="ɾ��" id="del_bt3" onclick="delBusiChangeDetail('net')"/></ai:contractitem>
	<ai:table tableid="netBusiChangeTab" setname="com.asiainfo.sale.access.web.SETBusiChangeDetail" height="100" multiselect="true" oncellchange="" 
		oncontextmenu="" needrefresh="true" onrowchange="showNetBusiChangeDetailInfo" pagesize="30"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV"
		implservice_querymethod="getBusiChangeDetailByPID(String busiId, String busiType,int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="getBusiChangeDetailCountByPID(String busiId, String busiType)" 
		initial="false" editable="false">
	        	<ai:col fieldname="BUSID_ID" visible="false"/>
	            <ai:col title="BOSS������������" fieldname="LEV_CODE" width="250" visible="true"/>
	        	<ai:col title="BOSS������������" fieldname="LEV_NAME" width="250" visible="true"/>
	            <ai:col fieldname="CHANGE_TYPE" width="300" visible="true"/>
	</ai:table>
</ai:contractframe>
</div>
<div id="changeinfo_crm_div" style="display: none">
<ai:contractframe id="ModDetailframe" contenttype="table" title="CRM-�����ϸ" width="100%" allowcontract="true" frameclosed="true">
<ai:contractitem/>
    <div id="privmod_div" style="display: none">
	<ai:contractframe id="PrivDetailframe" contenttype="table" title="����-������Ϣ" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivDetailTab" footdisplay="none"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing" 
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="60" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="Ӫ����������" fieldname="COL1" width="180" />
		        <ai:col title="Ӫ����������" fieldname="COL2" width="170" />
		        <ai:col title="��ʼʱ��" fieldname="COL3" width="170" />
		        <ai:col title="ͣ��ʱ��" fieldname="COL4" width="200" />
		        <ai:col title="Ӫ����������" fieldname="COL5" width="170" />
		        <ai:col title="������λ" fieldname="COL6" width="100" />
		        <ai:col title="�Żݶ�������" fieldname="COL7" width="130" />
		        <ai:col title="�Żݼ�ֵ" fieldname="COL8" width="100" />
		 </ai:table>
	</ai:contractframe>
	
	<ai:contractframe id="Privorgframe" contenttype="table" title="����-ʹ�õ�λ" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivorgTab" footdisplay="rowcount"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="Ӫ����������" fieldname="COL1" width="180" />
		        <ai:col title="��λ����" fieldname="COL2" width="170" />
		        <ai:col title="����ʱ��" fieldname="COL3" width="170" />
		        <ai:col title="״̬" fieldname="COL4" width="170" />
		        <ai:col title="״̬ʱ��" fieldname="COL5" width="170" />
		</ai:table>
	</ai:contractframe>  
		
	<ai:contractframe id="Privrewardframe" contenttype="table" title="����-��ѡ��Ʒ" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivrewardTab" footdisplay="none"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="Ӫ����������" fieldname="COL1" width="180" />
		        <ai:col title="���㷽ʽ" fieldname="COL2" width="170" />
		        <ai:col title="�Ż�ֵ" fieldname="COL3" width="170" />
		        <ai:col title="��Ʒ����" fieldname="COL4" width="170" />
		        <ai:col title="��Ʒ��ID(����)" fieldname="COL5" width="170" />
		        <ai:col title="ѡ��ʽ" fieldname="COL6" width="170" />
		        <ai:col title="״̬ʱ��" fieldname="COL7" width="170" />
		</ai:table>
	</ai:contractframe>
	
	<ai:contractframe id="Privoperframe" contenttype="table" title="����-ָ������" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivoperTab" footdisplay="none"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="Ӫ����������" fieldname="COL1" width="180" />
		        <ai:col title="����" fieldname="COL2" width="170" />
		        <ai:col title="�������" fieldname="COL3" width="170" />
		        <ai:col title="������ʽ" fieldname="COL4" width="170" />
		        <ai:col title="����Ա/������" fieldname="COL5" width="170" />
		        <ai:col title="����ʱ��" fieldname="COL6" width="170" />
		        <ai:col title="״̬" fieldname="COL7" width="70" />
		        <ai:col title="״̬ʱ��" fieldname="COL8" width="130" />
		</ai:table>
	</ai:contractframe>
	
	<ai:contractframe id="otherInfoframe" contenttype="table" title="����-�������" width="100%" allowcontract="false" frameclosed="false">
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
	<ai:contractframe id="prodInfoframe" contenttype="table" title="����-�����Ϣ" width="100%" allowcontract="false" frameclosed="false">
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
	<ai:contractframe id="crmAuditframe" contenttype="table" title="���" width="100%" allowcontract="false" frameclosed="false">
		<ai:contractitem/>
		<ai:dbform formid="crmAuditForm" initial="false" editable="true"
				setname="com.asiainfo.common.web.SETCrmAuditLog">
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr><td class="td_font">��������</td>
		           	<td><ai:dbformfield formid="crmAuditForm" fieldname="CONTENT" width="600" height="50"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="INTERFACE_ID" width="170" visible="false"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="MODE_ID" width="170" visible="false"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="BOSS_CODE" width="170" visible="false"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="AUDIT_FLAG" width="170" visible="false"/>
		           	    <ai:button id="bt_yes" text="���ͨ��"  onclick="auditPrivMod(1)"/>
				        <ai:button id="bt_no" text="��    ��"  onclick="auditPrivMod(0)"/></td>
			</table>
	    </ai:dbform>
	</ai:contractframe>
</ai:contractframe>
</div>

<ai:contractframe id="busiChangeDetailframe" contenttype="table" title="�����Ϣ" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem><ai:button text="����" id="new_add_bt" onclick="newBusiChangeDetail()" /></ai:contractitem>

<ai:dbform formid="busiChangeDetailForm" 
          setname="com.asiainfo.sale.access.web.SETBusiChangeDetail"
          conditionname="condition" parametersname="parameters"
          editable="true" initial="false" onvalchange="onBusiChangeDetailFormValChange"
          datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
          implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV"
          implservice_querymethod="getBusiChangeDetailByID(String busiDId)" >
    <table width="100%" align="center" border="0" cellpadding="1" cellspacing="1">
     <tr>
       <td class="td_font">�������</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_OBJECT" width="170"/><span class="font_red">*</span>
       	   <ai:dbformfield formid="busiChangeDetailForm" fieldname="BUSID_ID" width="60" editable="" visible="false"/>
       	   <ai:dbformfield formid="busiChangeDetailForm" fieldname="BUSI_ID" width="170" editable="" visible="false"/>
       </td>
       <td class="td_font">������ݣ�</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_TYPE" width="200" height="50" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="busiChangeTypeMultiplySelected();"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
       </td>
     </tr>
     <tr id ="dq_kf_tr" style="display: block">
     <td class="td_font">ҵ�����</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="DQ_KF" width="170"/><span class="font_red">*</span></td>
     </tr>
     <tr><td>&nbsp;&nbsp;</td></tr>
     <tr>
       <td align="left" colspan="4"><b><span class="font_red">���ǰ���飺</span></b></td>
     </tr>
     <tr id="query_tr" style="display: block">
     	<td id="query_td" class="td_font">��ѯӪ������</td>
     	<td><img id="select" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" 
       	   alt="" onClick="(selectExistInfo())" align="absmiddle" style="cursor: hand;" /></td>
     </tr>
     <tr id = "ticket_tr" style="display: block">
       <td class="td_font">�����/���Σ�</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="REMARK6" width="170"/><span class="font_red">*(������Σ����α���ɲ���)</span></td>
       <td class="td_font">�Ƿ��е��Ӿ�</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="HAS_TICKET" width="200"/><span class="font_red">*</span></td>
     </tr>
     <tr id="act_tr" style="display: block">
     	<td class="td_font">���α��룺</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="ACT_CODE" width="170"/><span class="font_red">*</span></td>
     	<td class="td_font">�������ƣ�</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="ACT_NAME" width="200"/><span class="font_red">*</span></td>
     </tr> 
     <tr>
     	<td id="level_code_td" class="td_font">�ɵ���boss���룺</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="LEV_CODE" width="170"/><span class="font_red">*(���ǰ,��Ҫ�޸�)</span></td>
     	<td id="level_name_td" class="td_font">�ɵ������ƣ�</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="LEV_NAME" width="200"/><span class="font_red">*(���ǰ,��Ҫ�޸�)</span></td>
     </tr> 
     <tr>
        <td class="td_font">ƽ̨����id��</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="REMARK1" width="170"/><span class="font_red">*</span></td>
     </tr>
      <tr><td>&nbsp;&nbsp;</td></tr>
     <tr>
        <td class="td_font">�ʷ�Ӫ��ƽ̨��OA�������ţ�</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="SALE_CHARGE_ORDER" width="170" />�鿴������Ϣ<img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="checkSaleInfo();"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
     </tr>
     <tr>
       <td class="td_font">�ƻ��ɱ���Ԫ����</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_BASE" width="170" /><span class="font_red">*</span></td>
       <td class="td_font">���У�����ȯ��Ԫ����</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_TICKET_SUM" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr>
        <td class="td_font">ִ�п�ʼʱ�䣺</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_BEGIN_TIME" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">ִ�н���ʱ�䣺</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_END_TIME" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr>
        <td class="td_font">���ͻ�Ʒ���ƣ�</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PRESENT_GOODS_NAME" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">��Ʒ���ۣ�Ԫ/������</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PRESENT_GOODS_PRICE" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr>
        <td class="td_font">ԭ���������ڵ�������</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_CHANNEL_NUM" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">�����������ͣ�</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_EXEC_CHANNEL" width="180" /><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="channelTypeMultiplySelected();"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
     </tr>
     <tr>
        <td class="td_font">ԭ���Ź���������</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_JOBNUM" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">ԭ����Ʒ�����ƣ�</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_OPEN_BRAND" width="180" /><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="oldOpenBrandMultiplySelected();"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
     </tr>
     <tr>
        <td class="td_font">ԭ�����ʷ�������</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="PLAN_CHARGE_NUM" width="170" /><span class="font_red">*</span></td>
     </tr>
     <tr><td>&nbsp;&nbsp;</td></tr>
     <tr>
       <td align="left" colspan="4"><b><span class="font_red">������飺</span></b></td>
     </tr>
     <tr><td>&nbsp;&nbsp;</td></tr>
        <tr>
     	<td id="level_code_td" class="td_font">����󵵴�boss���룺</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="REMARK2" width="170"/></td>
     	<td id="level_name_td" class="td_font">����󵵴����ƣ�</td>
     	<td><ai:dbformfield formid="busiChangeDetailForm" fieldname="REMARK3" width="200"/></td>
     </tr> 
     <tr id="source_append_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">��Դ׷�ӣ�</span></td>
     </tr>
     <tr id="source_append_tr2" style="display: none;">
       <td class="td_font">׷�ӽ�Ԫ����</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="APPEND_BASE" width="170" /><span class="font_red">*</span></td>
       <td class="td_font">���У�����ȯ��Ԫ����</td>
       <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="TICKET_SUM" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr id="time_over_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">ʱ����ֹ��</span></td>
     </tr>
     <tr id="time_over_tr2" style="display: none;">
        <td class="td_font">�Ƿ�ʱ����ֹ��</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="IS_END" width="170" /><span class="font_red">*</span></td>
     </tr>
     <tr id="time_appen_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">ʱ���ӳ���</span><b><span class="font_red">(���ṩ����顢�Ч�������ĸ���)</span></b></td>
     </tr>
     <tr id="time_appen_tr2" style="display: none;">
        <td class="td_font">ִ�п�ʼʱ�䣺</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_BEGIN_TIME" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">ִ�н���ʱ�䣺</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_END_TIME" width="200" /><span class="font_red">*</span></td>
     </tr>
      <tr id="goods_change_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">��Ʒ�����</span></td>
     </tr>
     <tr id="goods_change_tr2" style="display: none;">
        <td class="td_font">���ͻ�Ʒ���ƣ�</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_GOODS_NAME" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">��Ʒ���ۣ�Ԫ/������</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_GOODS_PRICE" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr id="channel_change_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">�������������</span></td>
     </tr>
     <tr id="channel_change_tr2" style="display: none;">
        <td class="td_font">���������ڵ�������</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANNEL_ADD" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">ɾ�������ڵ�������</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANNEL_DEL" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr id="jobnum_change_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">���Ź��ű����</span></td>
     </tr>
     <tr id="jobnum_change_tr2" style="display: none;">
        <td class="td_font">���ӿ��Ź���������</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="JOBNUM_ADD" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">ɾ�����Ź���������</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="JOBNUM_DEL" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr id="brand_change_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">Ʒ�Ʊ����</span></td>
     </tr>
     <tr id="brand_change_tr2" style="display: none;">
        <td class="td_font">����Ʒ�����ƣ�</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="CHANGE_OPEN_BRAND" width="170" /><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="newOpenBrandMultiplySelected();"  align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
     </tr>
     <tr id="charge_change_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">�ʷѱ����</span></td>
     </tr>
     <tr id="charge_change_tr2" style="display: none;">
        <td class="td_font">���ӿ����ʷ�������</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="BRAND_CHARGE_ADD" width="170" /><span class="font_red">*</span></td>
        <td class="td_font">ɾ�������ʷ�������</td>
        <td><ai:dbformfield formid="busiChangeDetailForm" fieldname="BRAND_CHARGE_DEL" width="200" /><span class="font_red">*</span></td>
     </tr>
     <tr id="user_scale_tr1" style="display: none;">
       <td align="left" colspan="4"><span class="font_yellow">�û���ģ�����</span></td>
     </tr>
     <tr id="user_scale" style="display: none;">
     <td colspan="4">
	<ai:contractframe id="userScaleListframe" contenttype="table" title="�û���ģ���" width="100%" allowcontract="true" frameclosed="false">
    	<ai:contractitem>
    		<ai:button id="bt_addUserScale" text="����" onclick="addUserScale()"/>
    		<ai:button id="bt_delUserScale" text="ɾ������ѡ�" onclick="doWork('delUserScale()')"/>
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
     <tr><td colspan="4" align="center"><ai:button text="��������ϸ��Ϣ" id="busid_bt" onclick="doWork('saveBusiChangeDetailInfo()')"/></td></tr>
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
// �������
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
   /* Ϊ����ʱ��ҵ�����ڲ��Կ�����ò�ע�͵�   */
   if (busiChangeDetailForm.getValue("CHANGE_OBJECT") == 'sale') {
	   if (prodcheck() == false) {
		   if(!confirm("��д���Ρ����α�����CRM��û�鵽,��ȷ��Ҫ������")){
			   return;
		   }
	   } 
   }
   if ("O" != busiChangeDetailForm.getSts()){
	    if (busiId == '') return alert("���ȱ����ҵ��������Ϣ��");
	    if (checkMustWrite() == false) return;
	    busiChangeDetailForm.setValue("BUSI_ID",busiId);
	    if (busiChangeDetailForm.getValue("CHANGE_OBJECT") == 'charge' || busiChangeDetailForm.getValue("CHANGE_OBJECT") == 'net') {
	    	if (saleBusiChangeTab.getTotalRowCount() > 0) {
	    		return alert("ҵ��������ֻ�ܰ���ȫ��Ӫ�������ߣ��ʷ�+������������");
	    	}
	    }
	    if (busiChangeDetailForm.getValue("CHANGE_OBJECT") == 'sale') {
	    	if (chargeBusiChangeTab.getTotalRowCount() > 0 || netBusiChangeTab.getTotalRowCount() > 0) {
	    		return alert("ҵ��������ֻ�ܰ���ȫ��Ӫ�������ߣ��ʷ�+������������");
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
//�����ID������IDУ��
function prodcheck() {
	var privID = busiChangeDetailForm.getValue("LEV_CODE");
	var prodID = busiChangeDetailForm.getValue("ACT_CODE");
	var retCheckInfo = query_CRM("Prodcheck",privID,prodID);
	return retCheckInfo.body.isExist == '����';
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
	if(confirm("��ȷ��Ҫɾ����")){
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
			alert("����ѡ��Ҫɾ������");
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
        alert("��ѡ��ǰ��������д��������󡱣�");
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
	var detAttr = ["Ӫ����������","Ӫ����������","��ʼʱ��","ͣ��ʱ��","Ӫ����������","������λ","�Żݶ�������","�Żݼ�ֵ"];
	var orgAttr = ["Ӫ����������","��λ����","����ʱ��","״̬","״̬ʱ��"];
	var operAttr = ["Ӫ����������","����","�������","������ʽ","����Ա/������","����ʱ��","״̬","״̬����"];
	var rewardAttr = ["Ӫ����������","���㷽ʽ","�Ż�ֵ","��Ʒ����","��Ʒ��ID(����)","ѡ��ʽ","״̬ʱ��"];
	for (var i=0; i< privModDetail.body.array.$list.length; ++i) {
		if (privModDetail.body.array.$list[i].OBJNAME == "���λ�����Ϣ") {
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
		} else if (privModDetail.body.array.$list[i].OBJNAME == "ʹ�õ�λ") {
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
		} else if (privModDetail.body.array.$list[i].OBJNAME == "ָ������") {
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
		} else if (privModDetail.body.array.$list[i].OBJNAME == "��ѡ��Ʒ") {
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
		if (privModDetail.body.array.$list[i].MODTYPE == "����" ) {
			chargeVal = chargeVal + privModDetail.body.array.$list[i].OBJATTRNAME + ": " + privModDetail.body.array.$list[i].OLDVALUE + "-->" + privModDetail.body.array.$list[i].NEWVALUE + "\n";
		} else if (privModDetail.body.array.$list[i].MODTYPE != "����" ){
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
		if (saleBusiChangeTab.getValue(i,"CHANGE_TYPE").indexOf("��Դ׷��") >= 0 ||
			saleBusiChangeTab.getValue(i,"CHANGE_TYPE").indexOf("ʱ���ӳ�") >= 0	)
		    return true;
	}
	/*var len2 = chargeBusiChangeTab.getTotalRowCount();
	for (var m = 0 ; m < len2; ++m) {
		if (chargeBusiChangeTab.getValue(m,"CHANGE_TYPE").indexOf("��Դ׷��") >= 0 ||
			chargeBusiChangeTab.getValue(m,"CHANGE_TYPE").indexOf("ʱ���ӳ�") >= 0	)
		    return true;
	}
	var len3 = netBusiChangeTab.getTotalRowCount();
	for (var n = 0 ; n < len3; ++n) {
		if (netBusiChangeTab.getValue(n,"CHANGE_TYPE").indexOf("��Դ׷��") >= 0 ||
			netBusiChangeTab.getValue(n,"CHANGE_TYPE").indexOf("ʱ���ӳ�") >= 0	)
		    return true;
	}*/
	return false;
}

function checkSaleInfo () {
	var url = '';
	var batchId = busiChangeDetailForm.getValue("SALE_CHARGE_ORDER");
	var batchType = busiChangeDetailForm.getValue("CHANGE_OBJECT");
	if (batchType == null || batchType == ''){
		return alert("��ѡ��������");
	}
	if (batchId == null || batchId == ''){
		return alert("����д�������ţ�");
	}
	//��鹤����ƽ̨���Ƿ����
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.BusiChangeDetailAction?action=isExistBatchId&batchId='+batchId +'&batchType='+batchType;
	var recode = PostInfo(strUrl);
	var rFlag = recode.getValueByName("FLAG");
	if ("Y" != rFlag)
	{
	  return alert("��д������������ƽ̨�в����ڣ�");
	}
	//��ת��������ϸ��Ϣҳ��
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
			document.getElementById("level_code_td").innerText="���α��룺";
			document.getElementById("level_name_td").innerText="�������ƣ�";
			document.getElementById("query_td").innerText="��ѯӪ������";
			document.getElementById("dq_kf_tr").style.display="block";
		} else if (chageObject == "charge"){
			document.getElementById("act_tr").style.display="none";
			document.getElementById("ticket_tr").style.display="none";
			document.getElementById("query_tr").style.display="block";
			document.getElementById("level_code_td").innerText="BOSS�ʷѱ��룺";
			document.getElementById("level_name_td").innerText="BOSS�ʷ����ƣ�";
			document.getElementById("query_td").innerText="��ѯ�ʷѰ���";
			document.getElementById("dq_kf_tr").style.display="none";
		} else if (chageObject == "net"){
			document.getElementById("act_tr").style.display="none";
			document.getElementById("ticket_tr").style.display="none";
			document.getElementById("query_tr").style.display="none";
			document.getElementById("level_code_td").innerText="BOSS�����������룺";
			document.getElementById("level_name_td").innerText="BOSS�����������ƣ�";
			document.getElementById("dq_kf_tr").style.display="block";
		}
}

function showChangeTypeTr(changeType){
	if (changeType.indexOf("ʱ����ֹ") >= 0) {
		if (changeType.split(";").length>1){
			alert("ʱ����ֹ������ѡ���ͻ����ȷ�ϣ�");
		}
		document.getElementById("time_over_tr1").style.display="block";
		document.getElementById("time_over_tr2").style.display="block";
	} else {
		document.getElementById("time_over_tr1").style.display="none";
		document.getElementById("time_over_tr2").style.display="none";
	}
	if (changeType.indexOf("��Դ׷��") >= 0) {
		document.getElementById("source_append_tr1").style.display="block";
		document.getElementById("source_append_tr2").style.display="block";
	} else {
		document.getElementById("source_append_tr1").style.display="none";
		document.getElementById("source_append_tr2").style.display="none";
	}
	if (changeType.indexOf("ʱ���ӳ�") >= 0) {
		document.getElementById("time_appen_tr1").style.display="block";
		document.getElementById("time_appen_tr2").style.display="block";
	} else {
		document.getElementById("time_appen_tr1").style.display="none";
		document.getElementById("time_appen_tr2").style.display="none";
	}
	if (changeType.indexOf("��Ʒ���") >= 0) {
		document.getElementById("goods_change_tr1").style.display="block";
		document.getElementById("goods_change_tr2").style.display="block";
	} else {
		document.getElementById("goods_change_tr1").style.display="none";
		document.getElementById("goods_change_tr2").style.display="none";
	}
	if (changeType.indexOf("�����������") >= 0) {
		document.getElementById("channel_change_tr1").style.display="block";
		document.getElementById("channel_change_tr2").style.display="block";
	} else {
		document.getElementById("channel_change_tr1").style.display="none";
		document.getElementById("channel_change_tr2").style.display="none";
	}
	if (changeType.indexOf("���Ź��ű��") >= 0) {
		document.getElementById("jobnum_change_tr1").style.display="block";
		document.getElementById("jobnum_change_tr2").style.display="block";
	} else {
		document.getElementById("jobnum_change_tr1").style.display="none";
		document.getElementById("jobnum_change_tr2").style.display="none";
	}
	if (changeType.indexOf("Ʒ�Ʊ��") >= 0) {
		document.getElementById("brand_change_tr1").style.display="block";
		document.getElementById("brand_change_tr2").style.display="block";
	} else {
		document.getElementById("brand_change_tr1").style.display="none";
		document.getElementById("brand_change_tr2").style.display="none";
	}
	if (changeType.indexOf("�ʷѱ��") >= 0) {
		document.getElementById("charge_change_tr1").style.display="block";
		document.getElementById("charge_change_tr2").style.display="block";
	} else {
		document.getElementById("charge_change_tr1").style.display="none";
		document.getElementById("charge_change_tr2").style.display="none";
	}
	if (changeType.indexOf("�û���ģ") >= 0) {
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
		alert("��ѡ��������");
		return false;
	    
	}
	if (changeType == '') {
	    alert("��ѡ�������ݣ�");
	    return false;
	}
	if (busiChangeDetailForm.getValue("CHANGE_OBJECT") != 'charge'){
		if("" == busiChangeDetailForm.getValue("DQ_KF")){
			alert("��ѡ��ҵ�����");
					return false;
		}
		}
	if ("sale" == busiChangeDetailForm.getValue("CHANGE_OBJECT")) {
	    if ("" == busiChangeDetailForm.getValue("ACT_CODE")) {
		    alert("����д���α��룡");
		    return false;
	   	}
	    if ("" == busiChangeDetailForm.getValue("ACT_NAME")){
	    	alert("����д�������ƣ�");
	    	return false;
	    }
	    if ("2" != busiChangeDetailForm.getValue("REMARK6")) {
	    	
		    if ("" == busiChangeDetailForm.getValue("LEV_CODE")){
		    	alert("����д���α��룡");
		    	return false;
		    }
		    if ("" == busiChangeDetailForm.getValue("LEV_NAME")){
		    	alert("����д�������ƣ�");
		    	return false;
		    }
	    }
	    if ("" == busiChangeDetailForm.getValue("HAS_TICKET")){
	    	alert("��ѡ���Ƿ��������ȯ��");
	    	return false;
	    }
	   /* if ("" == busiChangeDetailForm.getValue("REMARK1")){
	    	alert("����дƽ̨����id��");
	    	return false;
	    } */
	}
	if ("charge" == busiChangeDetailForm.getValue("CHANGE_OBJECT")) {
	    if ("" == busiChangeDetailForm.getValue("LEV_CODE")){
	    	alert("����дBOSS�ʷѱ��룡");
	    	return false;
	    }
	    if ("" == busiChangeDetailForm.getValue("LEV_NAME")){
	    	alert("����дBOSS�ʷ����ƣ�");
	    	return false;
	    }
	    /* if ("" == busiChangeDetailForm.getValue("REMARK1")){
	    	alert("����дƽ̨����id��");
	    	return false;
	    } */
	}
	if ("net" == busiChangeDetailForm.getValue("CHANGE_OBJECT")) {
	    if ("" == busiChangeDetailForm.getValue("LEV_CODE")){
	    	alert("����дBOSS�����������룡");
	    	return false;
	    }
	    if ("" == busiChangeDetailForm.getValue("LEV_NAME")){
	    	alert("����дBOSS�����������ƣ�");
	    	return false;
	    }
	}
	if (changeType.indexOf("��Դ׷��") >= 0) {
		if ("" == busiChangeDetailForm.getValue("APPEND_BASE")){
	    	alert("����д׷�ӽ�");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("TICKET_SUM")){
	    	alert("����д����ȯ��");
	    	return false;
	    }
	}
	if (changeType.indexOf("ʱ����ֹ") >= 0) {
		if ("" == busiChangeDetailForm.getValue("IS_END")){
	    	alert("����дʱ����ֹ��");
	    	return false;
	    }
	}
	if (changeType.indexOf("ʱ���ӳ�") >= 0) {
		if ("" == busiChangeDetailForm.getValue("CHANGE_BEGIN_TIME")){
	    	alert("����дִ�п�ʼʱ�䣡");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("CHANGE_END_TIME")){
	    	alert("����дִ�н���ʱ�䣡");
	    	return false;
	    }
	}
	if (changeType.indexOf("��Ʒ���") >= 0) {
		if ("" == busiChangeDetailForm.getValue("CHANGE_GOODS_NAME")){
	    	alert("����д���ͻ�Ʒ���ƣ�");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("CHANGE_GOODS_PRICE")){
	    	alert("����д��Ʒ���ۣ�");
	    	return false;
	    }
	}
	if (changeType.indexOf("�����������") >= 0) {
		if ("" == busiChangeDetailForm.getValue("CHANNEL_ADD")){
	    	alert("����д���������ڵ�������");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("CHANNEL_DEL")){
	    	alert("����дɾ�������ڵ�������");
	    	return false;
	    }
	}
	if (changeType.indexOf("���Ź��ű��") >= 0) {
		if ("" == busiChangeDetailForm.getValue("JOBNUM_ADD")){
	    	alert("����д���ӿ��Ź���������");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("JOBNUM_DEL")){
	    	alert("����дɾ�����Ź���������");
	    	return false;
	    }
	}
	if (changeType.indexOf("Ʒ�Ʊ��") >= 0) {
		if ("" == busiChangeDetailForm.getValue("CHANGE_OPEN_BRAND")){
	    	alert("����д����Ʒ�����ƣ�");
	    	return false;
	    }
	}
	if (changeType.indexOf("�ʷѱ��") >= 0) {
		if ("" == busiChangeDetailForm.getValue("BRAND_CHARGE_ADD")){
	    	alert("����д���ӿ����ʷ�������");
	    	return false;
	    }
		if ("" == busiChangeDetailForm.getValue("BRAND_CHARGE_DEL")){
	    	alert("����дɾ�������ʷ�������");
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
	if (modoID == "") return alert("��ѡ����Ҫ��˵ı�����ţ�");
	if (busiChangeDetailForm.getValue("REMARK6") == 2) {
		retState = audit_CRM("Prodmodaudit", '', prodID, modoID, flag);
   	} else {
   		retState = audit_CRM("Privmodaudit", privID, '', modoID, flag);
   	}
	if (retState.head.retCode == 0) {
		alert("��˳ɹ���");
	} else {
		crmAuditForm.setValue("CONTENT","���ʧ��");
		alert("���ʧ�ܣ�");
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

// �û���ģ
function addUserScale() {
	
	if(busiChangeDetailForm.getValue("SALE_CHARGE_ORDER")==null||busiChangeDetailForm.getValue("SALE_CHARGE_ORDER")==''){
		alert("δѡ��Ӫ����");
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
        return alert("�빴ѡҪɾ���ļ�¼��");
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
	if (changeType.indexOf("�û���ģ") >= 0) {
		if(_userScaleListTab.getTotalRowCount()==0){
			alert("�û���ģΪ��");
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
  		alert("�����ɹ���");
  	} else if (alertFlag == 'y' && rFlag == 'N') {
  		alert("����ʧ�ܣ�");
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
					return alert("��ʼʱ�����С�ڽ���ʱ��")
				}
				_userScaleListTab.setValue(curRow, "START_TIME", ret);
			} else if (curCol == 3) {
				if (_userScaleListTab.getValue(curRow,"END_TIME") !="" &&
						-1 != g_CompareDate(_userScaleListTab.getValue(curRow,"END_TIME"),ret)) {
					return alert("����ʱ�������ڿ�ʼʱ��")
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
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>
