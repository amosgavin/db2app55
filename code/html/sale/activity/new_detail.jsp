<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<%String visible="false"; %>

<html>
<head>
<title>������Ϣ</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage()">
<%@include file="/sale/activity/include/_mainShow.jsp"%>
    <ai:dbform formid="saleDetailForm"  initial="false"
            setname="com.asiainfo.sale.activity.web.SETSaleDetail"
            conditionname="condition" parametersname="parameters"
            onvalchange="onSaleTypeChange" editable="true"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleDetailSV"
            implservice_querymethod="getSaleDetailById(String id)">
<ai:contractframe id="saleDetailFrame" contenttype="table" title="������Ҫ��Ϣ" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>
            	<td class="td_font">�����·��ࣺ</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="RESERVE2" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">����ģ�棺</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="SALE_FLAG" width="150"/></td>
            </tr>
            <tr id="sfhyj">
                <td class="td_font">�ն����ͣ�</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="IS_CONTRACT" width="150"/></td>
            </tr>
            </tr>
                <td class="td_font">ϸ���г���</td>
                <td ><ai:dbformfield formid="saleDetailForm" fieldname="MARKET"  width="150"/><%--<img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="marketSimpleSelected();" align="absmiddle" style="cursor:hand;"/>--%><span class="font_red">*</span></td>
                <td class="td_font">��λ������</td>
                <td colspan="1"><ai:dbformfield formid="saleDetailForm" fieldname="RESERVE3" width="150"/></td>
            </tr>
            <tr>
                <td class="td_font">���α��룺</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="SALE_ACTIVE_CODE" width="170" editable="false"/>
                    <ai:dbformfield formid="saleDetailForm" fieldname="DETAIL_ID" visible="false"/>
                    <ai:dbformfield formid="saleDetailForm" fieldname="SALE_ID" visible="false"/>
                    <ai:dbformfield formid="saleDetailForm" fieldname="WEAPON_ID" visible="false"/>
            </tr>
            <tr>
                <td class="td_font">�������ƣ�</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="SALE_ACTIVE_NAME" width="360"/><span class="font_red">*</span></td>
            </tr>
            <%--<tr id="jthdxs">
             <td class="td_font">���ʽ��</td>
                <td colspan="1"><ai:dbformfield formid="saleDetailForm" fieldname="RESERVE1" width="150" visible="false"/></td>
            </tr> --%>
            <tr>
                <td class="td_font">����˵����</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="LEVEL_DESC" height="50" width="450"/></td>
            </tr>
            <tr>
            	<td class="td_font">����������Ч���ޣ�</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="EXT6"  width="150"/><span class="font_red">(������)���ͻ��������� ��xx��xx�ո�ʽΪ���ֽ������ڡ�</span>
            </tr>
            <tr>
                <td class="td_font">ָ����������ID��</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="HANDLE_WEBSITE_ID"  width="450"/>(��";"�ֿ�a;b;c;d)</td>
            </tr>
            <tr>
                <td class="td_font">ָ��������ID��</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="HANDLE_EMPLOYEE_ID"  width="450"/>(��";"�ֿ�a;b;c;d)</td>
            </tr>
             <tr id="hometype">
                <td class="td_font"><b>�Ƿ�������(�����������):</b></td><td><ai:dbformfield formid="saleDetailForm" fieldname="HOME_TYPE" width="10" visible="false"/>
	        		<input type="radio" id="broband_input1" name="L_HOME_TYPE" value="0" onclick="checkhometype(0)" />��&nbsp;
	        		<input type="radio" id="broband_input2" name="L_HOME_TYPE" value="1" onclick="checkhometype(1)" />��&nbsp;<span class="font_red">*</span></td>
                <td colspan="2"></td>
            </tr>
             <tr id='islimcmboname'>
                <td align="left" colspan="4"><b> �Ƿ���û��޶��ײ͵ķ��ã�</b></td>
            </tr>
            <tr id='islimcmbo'>
	        	<td class="td_font">�Ƿ��޶��ײͷ��ã�</td>
	        	<td colspan=""><ai:dbformfield formid="saleDetailForm" fieldname="IS_LIMIT_COMBO" width="10" visible="false"/>
	        		<input type="radio" id="combo_input1" name="IS_L_COMBO" value="0" onclick="checklimittype(0)" />��&nbsp;
	        		<input type="radio" id="combo_input2" name="IS_L_COMBO" value="1" onclick="checklimittype(1)" />��&nbsp;<span class="font_red">*</span></td>
	        	<td class="td_font" id='limit_amount_0'>�޶���</td>
                <td colspan="1" id='limit_amount_1'><ai:dbformfield formid="saleDetailForm" fieldname="LIMIT_AMOUNT" width="150"/>(Ԫ)<span class="font_red">*</span></td>
        	</tr>
            <%-- <tr>
        		<td class="td_font">�Ƿ���Ҫ�������ѣ�</td>
        		<td colspan=3 ><ai:dbformfield formid="saleDetailForm" fieldname="IS_SEND_SMS" width="10" visible="false"/>
        			<input type="checkbox" id="selSendType0" value="0" onclick="checkboxSts(0);" />����Ҫ��������&nbsp;
        			<input type="checkbox" id="selSendType1" value="1" onclick="checkboxSts(1);" />ҵ���������</td>
        	</tr> 
            <tr id="channel_tr" style="display: none">
                <td class="td_font">����������</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="OPEN_CHANNEL"  width="450"/></td>
            </tr>
            <tr style="display: none;">
            	<td align="left" colspan="4"><b>���ι���Ŀ��ͻ�Ⱥ��</b></td>
            </tr>
            <tr style="display: none;">
            	<td class="td_font">�ͻ�Ⱥ���룺</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="CUST_GROUP_ID" width="150" editable="false"/><span class="font_red">*</span>
                	<ai:dbformfield formid="saleDetailForm" fieldname="CUST_GROUP_TAB" width="150" visible="false"/>
                	<ai:dbformfield formid="saleDetailForm" fieldname="CGROUP_REGION" width="150" visible="false"/>
                	<ai:dbformfield formid="saleDetailForm" fieldname="EXT7" width="150" visible="false"/>
                </td>
                <td class="td_font">�ͻ�Ⱥ����</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="CUST_GROUP_NAME" width="150" editable="false"/>
                    <img id="select" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" 
       	                 alt="" onClick="(selectCGroup())" align="absmiddle" style="cursor: hand;" />
       	                 <span class="font_red">*</span></td>
            </tr>
            <tr style="display: none;">
            	<td class="td_font">�ͻ�Ⱥ��ʼʱ�䣺</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="CGROUP_BEGIN_TIME" width="150" />
                	<span class="font_red">*</span></td>
                <td class="td_font">�ͻ�Ⱥ����ʱ�䣺</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="CGROUP_END_TIME" width="150" />
                	<span class="font_red">*</span></td>
            </tr> --%>
            <tr>
                <td align="left" colspan="4"><b>���Ի�ҵ����ʾ��Ϣ��</b></td>
            </tr>
            <tr>
	        	<td class="td_font">��ʾ���ͣ�</td>
	        	<td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="EXT1" width="10" visible="false"/>
	        		<input type="checkbox" id="hint0_input" value="0" onclick="checkboxSts(0);" />ǰ̨������Ϣ��ʾ&nbsp;
	        		<input type="checkbox" id="hint1_input" value="1" onclick="checkboxSts(1);" />�º������ʾ&nbsp;
	               	<input type="checkbox" id="hint2_input" value="2" onclick="checkboxSts(2);" />��Ʊ��ӡ��Ϣ��ʾ&nbsp;
	               	<input type="checkbox" id="hint3_input" value="3" onclick="checkboxSts(3);" />�����ӡ��Ϣ��ʾ</td>
        	</tr>
        	<tr id="hint0_tr" style="display: none;">
        		<td class="td_font">ǰ̨������Ϣ��ʾ��</td>
        		<td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="EXT2" height="60" width="70%"/><span class="font_red">*</span></td>
        	</tr>
        	<tr id="hint1_tr" style="display: none;">
        		<td class="td_font">�º������ʾ(���300��)��</td>
        		<td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="EXT3" height="50" width="70%" /><span class="font_red">*</span></td>
        	</tr>
        	<tr id="hint2_tr" style="display: none;">
        		<td class="td_font">��Ʊ��ӡ��Ϣ��ʾ(���40��)��</td>
        		<td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="EXT4" height="60" width="70%"/><span class="font_red">*</span></td>
        	</tr>
        	<tr id="hint3_tr" style="display: none;">
        		<td class="td_font">�����ӡ��Ϣ��ʾ��</td>
        		<td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="EXT5" height="50" width="70%" /><span class="font_red">*</span></td>
        	</tr>
            <tr>
                <td id="SALETYPE_OTHERSALE_td_1" class="td_font">Ӫ�����ͣ�</td>
                <td id="SALETYPE_OTHERSALE_td_2" colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="SALETYPE_OTHERSALE" width="450"/></td>
            </tr>
            <tr>
                <td id="SALETYPE_DES_OTHERSALE_td_1" class="td_font">Ӫ������������</td>
                <td id="SALETYPE_DES_OTHERSALE_td_2" colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="SALETYPE_DES_OTHERSALE" width="450"/></td>
            </tr>
            <tr id="dis1" style="display: none;">
                <td align="left" colspan="4"><b>�ͻ������������ʸ�������</b></td>
            </tr>
            <tr id="dis2" style="display: none;">
                <td class="td_font">Ʒ�Ƽ��ʷѣ�</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="BRAND_DESC" width="450"/></td>
            </tr>
            <tr id="dis3" style="display: none;">
                <td class="td_font">����������</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="OTHER_USERINFO" width="450"/></td>
            </tr>
            <tr id="dis4" >
                <td align="left" colspan="4"><b>������Ϣ��</b></td>
            </tr>
            <tr>
            	<td class="td_font">����������</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="MANAGE_CONDITION"  width="150"/></td>
            </tr>
            <tr id="dis5" >
                <td class="td_font">����Ҫ��</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="EXCLUDE_DEMAND" height="36" width="450"/></td>
            </tr>
            <tr id="dis6" >
                <td class="td_font">����������ߣ�</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="CHANNEL_PAY_POLICY" height="36" width="450"/></td>
            </tr>
            <%--<tr>
                <td class="td_font">�����</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="PUBLICITY_WORD" height="66" width="450"/></td>
            </tr>
            --%><tr style="display: none;">
                <td align="left" colspan="4"><b>�û���ģ��</b></td>
            </tr>
            <tr style="display: none;">
                <td class="td_font">��������û�����</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="MAX_PERSON" width="150"/>(��)<span class="font_red">*</span></td>
                <td class="td_font">Ԥ���û���ģ��</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="PRE_PERSON" width="150"/>(��)<span class="font_red">*</span></td>
            </tr>
            <tr>
                <td align="left" colspan="4"><b>��Դ���ã�</b></td>
            </tr>
            <tr>
            <td class="td_font">�ն˲�����</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="TERMINAL_COST" width="100"/>(��Ԫ)<span class="font_red"></span></td>
            <td class="td_font">�ۿ����ã�</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="ACTION_OUT" width="100"/>(��Ԫ)<span class="font_red"></span></td>
            <td class="td_font">�������֣�</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="PROMOTE_SCORE" width="100"/>(��Ԫ)<span class="font_red"></span></td>
            <td class="td_font">�����ѣ�</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="SALE_POINT" width="100"/>(��Ԫ)<span class="font_red"></span></td>
            </tr>
             <tr>
             <td class="td_font">�ն˲���ʣ������</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="TERMINAL_COST_REMAIN" width="100" editable="false"/>(��Ԫ)<span class="font_red"></span></td>
             <td class="td_font">�ۿ�����ʣ������</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="ACTION_OUT_REMAIN" width="100" editable="false"/>(��Ԫ)<span class="font_red"></span></td>
             <td class="td_font">��������ʣ������</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="PROMOTE_SCORE_REMAIN" width="100" editable="false"/>(��Ԫ)<span class="font_red"></span></td>
             <td class="td_font">������ʣ������</td>
                <td><ai:dbformfield formid="saleDetailForm" fieldname="SALE_POINT_REMAIN" width="100" editable="false"/>(��Ԫ)<span class="font_red"></span></td>
            </tr>
        </table>
</ai:contractframe>

<ai:contractframe id="userScaleListframe" contenttype="table" title="�û���ģ" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
    	<ai:button id="bt_addUserScale" text="����" onclick="addUserScale()"/>
    	<ai:button id="bt_delUserScale" text="ɾ������ѡ�" onclick="doWork('delUserScale()')"/>
    </ai:contractitem>
    <ai:table
        tableid="userScaleListTable"
        setname="com.asiainfo.sale.activity.web.SETUserScale"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleUserScaleSV"
        implservice_querymethod="getUserScaleByRelaId(String relaId,String infoType, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCnUserScaleListByRelaId(String relaId,String infoType)"
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

<ai:contractframe id="channelListframe" contenttype="table" title="����������Ϣ�������" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
    	<ai:button id="bt_addChannl" text="����" onclick="addChannel()"/>
    	<ai:button id="bt_delChannl" text="ɾ������ѡ�" onclick="doWork('delChannel()')"/>
    </ai:contractitem>
    <ai:table
        tableid="channelListTable"
        setname="com.asiainfo.sale.activity.web.SETChannelInfo"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleChannelInfoSV"
        implservice_querymethod="getChannelInfoByRelaId(String relaId,String relaType, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCnChannelListByRelaId(String relaId, String relaType)"
        initial="false"  multiselect="true"
        pagesize="15" editable="true" width="100%"
        height="120" needrefresh="true">
        <ai:col fieldname="REGION" width="15%" />
        <ai:col fieldname="CHANNEL_CODE" width="30%" />
        <ai:col fieldname="OPERATION" width="15%" />
        <ai:col fieldname="ID" width="15%" visible="false"/>
        <ai:col fieldname="REL_ID" width="15%" visible="false"/>
        <ai:col fieldname="REL_TYPE" width="15%" visible="false"/>
    </ai:table>
</ai:contractframe>
<ai:contractframe id="cgroupListframe" contenttype="table" title="Ŀ��ͻ�Ⱥ��Ϣ" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
    	<ai:button id="bt_addCgroup" text="����" onclick="addCgroup()"/>
    	<ai:button id="bt_delCgroup" text="ɾ������ѡ�" onclick="doWork('delCgroup()')"/>
    </ai:contractitem>
    <ai:table
        tableid="cgroupListTable"
        setname="com.asiainfo.sale.activity.web.SETSaleRelatCgroup"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" 
        implservice_name="com.asiainfo.sale.activity.service.interfaces.ICustGroupSV"
        implservice_querymethod="getSaleRelatCgroupByRelaId(String relaId,String relaType, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCnSaleRelatCgroupByRelaId(String relaId, String relaType)"
        initial="false"  multiselect="true" 
        pagesize="15" editable="true" width="100%"
        height="120" needrefresh="true">
        <ai:col fieldname="CGROUP_ID" width="15%" editable="false"/>
        <ai:col fieldname="CGROUP_NAME" width="30%" editable="false"/>
        <ai:col fieldname="CGROUP_REGION" width="15%" editable="false"/>
        <ai:col fieldname="CGROUP_FLAG" width="10%" />
        <ai:col fieldname="CGROUP_BEGIN_TIME" width="10%"/>
        <ai:col fieldname="CGROUP_END_TIME" width="10%" />
        <ai:col fieldname="ID" width="1%" visible="false"/>
        <ai:col fieldname="CGROUP_TAB" width="30%" visible="false"/>
        <ai:col fieldname="CGROUP_USERNUM" width="30%" visible="false"/>
        <ai:col fieldname="ORDER_ID" width="15%" visible="false"/>
        <ai:col fieldname="RELAT_ID" width="15%" visible="false"/>
        <ai:col fieldname="RELAT_TYPE" width="15%" visible="false"/>
    </ai:table>
</ai:contractframe>
<ai:contractframe id="saleDetailframe2" contenttype="table" title="�ɱ�����" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem><ai:button text="ѡ������" id="bt_weaponSelect1" onclick="weaponSelect()" />&nbsp;&nbsp;<ai:button id="bt_refreshCompute4weapon" text="ˢ��" onclick="doWork('refreshCompute4weapon()')"/></ai:contractitem>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
				<td id="BACK_PROPORTION_td_1" class="td_font">������ʣ�</td> 
	           	<td id="BACK_PROPORTION_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="PRE_DISCOUNT" width="100" editable="false"/>%</td>
	           	<ai:dbformfield formid="saleDetailForm" fieldname="BACK_PROPORTION" width="100" editable="false" visible="false"/>
	           	<!--  <td id="BACK_PROPORTION_td_1" class="td_font">�ͻ��ر��ʣ�</td> -->
	           	<td id="PRE_STORE_TO_PRESENT_td_1" class="td_font">Ԥ�������ͱ�����</td>
	           	<td id="PRE_STORE_TO_PRESENT_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="PRE_STORE_TO_PRESENT" width="100" editable="false"/>%</td>
			</tr>
            <tr>
                <td id="PRE_INCOME_td_1" class="td_font">����Ԥ��</td>
                <td id="PRE_INCOME_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="PRE_INCOME" width="150" editable="false"/>(Ԫ)</td>
                <td id="FEE_DISCOUNT_td_1" class="td_font">Ԥ�ƻ����ۿۣ�</td>
                <td id="FEE_DISCOUNT_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="FEE_DISCOUNT" width="150" editable="false"/>(Ԫ)</td>
            </tr>
            <tr>
                <td id="PRE_INCOME2_td_1" class="td_font">Ԥ�����룺</td>
                <td id="PRE_INCOME2_td_2" colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="PRE_INCOME2" width="150" editable="false"/>(Ԫ)</td>
            </tr>
            <tr>
                <td id="BUSINESS_DISCOUNT_td_1" class="td_font">Ԥ��ҵ���ۿۣ�</td>
                <td id="BUSINESS_DISCOUNT_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="BUSINESS_DISCOUNT" width="100" editable="false"/>(Ԫ)</td>
                <td id="MOBILE_COST_td_1" class="td_font">�ն˳ɱ���</td>
                <td id="MOBILE_COST_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="MOBILE_COST" width="100" editable="false"/>(Ԫ)</td>
            </tr>
            <tr>
                <td id="ELECPAY_COST_td_1" class="td_font">���ӹ���ȯ�ɱ���</td>
                <td id="ELECPAY_COST_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="ELECPAY_COST" width="100" editable="false"/>(Ԫ)</td>
                <td id="MOBILEPAY_COST_td_1" class="td_font">�ֻ�����ɱ���</td>
                <td id="MOBILEPAY_COST_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="MOBILEPAY_COST" width="100" editable="false"/>(Ԫ)</td>
            </tr>
            <tr>
                <td id="ELECGOODS_COST_td_1" class="td_font">�������ȯ�ɱ���</td>
                <td id="ELECGOODS_COST_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="ELECGOODS_COST" width="100" editable="false"/>(Ԫ)</td>
                <td id="GOODS_COST_td_1" class="td_font">��Ʒ�ɱ���</td>
                <td id="GOODS_COST_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="GOODS_COST" width="100" editable="false"/>(Ԫ)</td>
            </tr>
			<tr>
	           	<td id="CHANNEL_PAY_td_1" class="td_font">�������</td>
	           	<td id="CHANNEL_PAY_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="CHANNEL_PAY" width="100"/>(Ԫ)</td>
	           	<td id="ESTIMATE_AD_FEE_td_1" class="td_font">��������ѣ�</td>
	           	<td id="ESTIMATE_AD_FEE_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="ESTIMATE_AD_FEE" width="100"/>(Ԫ)</td>
			</tr>
			<tr>
                <td id="ESTIMATE_OTHER_FEE_td_1" class="td_font">������</td>
                <td id="ESTIMATE_OTHER_FEE_td_2"><ai:dbformfield formid="saleDetailForm" fieldname="ESTIMATE_OTHER_FEE" width="100"/>(Ԫ)
                <ai:dbformfield formid="saleDetailForm" fieldname="COST_TOTAL" width="100" visible="false"/></td>
			</tr>
		</table>
</ai:contractframe>
</ai:dbform>
<%@include file="/sale/activity/include/_weaponInfo.jsp"%>
<div class="area_button" id="goods_tag_div" style="display: none;">
<%@include file="/sale/activity/include/_goodsTag.jsp"%>
</div>
<div class="area_button">
	<ai:button id="bt_saveSaleMain" text="���棨�����ñ�ǩ������д˰�ʣ�" onclick="doWork('saveSaleDetail()')"/>&nbsp;
    <ai:button id="bt_gotoExplanTag" text="��һ�������������Ϣ��д " onclick="doWork('saveAndGotoExplanTag()')"/>
</div>
</body>
</html>
<ai:loginuser/>
<script type="text/javascript">
var _cgroupListTab = g_TableRowSetManager.get("cgroupListTable");
var _channelListTab = g_TableRowSetManager.get("channelListTable");
var _userScaleListTab = g_TableRowSetManager.get("userScaleListTable");
var is_tableSaleDetailListTableRowSetEditAble = true;
var saleDetailForm = g_FormRowSetManager.get("saleDetailForm");
//function _tableSaleDetailGroupListTableRowSet(){
//	return g_TableRowSetManager.get("saleDetailGroupListTable");
//}
function _tableSaleDetailListTableRowSet(){ 
	return g_TableRowSetManager.get("saleDetailListTable");
}

function _fromSaleDetailFormRowSet(){
	return g_FormRowSetManager.get("saleDetailForm");
}


function getMainId() {
    return _fromSaleMainFormRowSet.getValue("MAINID");
}

function initOper()
{
    var orderId = "<%=request.getParameter("orderId")%>";
    if ("" == orderId || "null" == orderId){
    	return;
    }
    _fromSaleOrderFormRowSet().refresh("&orderId="+orderId);
	include_refreshSaleMainTable(orderId);
	_include_fromSaleMainTabRowSet().setRow(0);
	newSaleDetail();
	saleDetailForm.setValue("SALE_FLAG",11);
	//var saleType=saleDetailForm.getValue("SALE_FLAG");
	include_setWeaponFrom(11);
	var editable = "<%=request.getParameter("editable")%>";
    if (editable == "false") {
    	saleDetailForm.setEditSts(false);
    	is_tableSaleDetailListTableRowSetEditAble = false;
    	setButtonDisabled();
    	_channelListTab.setEditSts(false);
    	_userScaleListTab.setEditSts(false);
    	_cgroupListTab.setEditSts(false);
    }
	document.getElementById("TableRowSet_cgroupListTable").onclick= calendarDlg;
	document.getElementById("TableRowSet_userScaleListTable").onclick= scaleCalendarDlg;
	document.getElementById("sfhyj").style.display="none";
	saleDetailForm.removeListBoxOption("is_contract","null");
}

function clsTable(table){
    var cols = table.count();
    for (var i=cols; i>0;i--){
        table.deleteRow(i-1);
    }
}

function onSaleTypeChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText)
{
	/**
    if (pFieldName == 'ISACTIVE_SALE') {
        if ("true" == pOldText) {
            document.getElementById("zdyxd1").style.display="block";
            document.getElementById("zdyxd2").style.display="block";
        } else {
            document.getElementById("zdyxd1").style.display="none";
            document.getElementById("zdyxd2").style.display="none";
        }
    }
	*/
	if (pFieldName == 'SALE_FLAG') {
		var saleType = saleDetailForm.getValue("SALE_FLAG");
        _include_formWeaponSelectFormRowSet().newRow();
        clsTable(_include_formDetailTagTabTableRowSet());
		initDetailForm();
        initComputeFormClose();
		initComputeFormOpen(saleType);
		
	}
<%--	if (pFieldName == 'RESERVE2'){--%>
<%--		if(saleDetailForm.getValue("RESERVE2")=="1"){--%>
<%--			document.getElementById("sfhyj").style.display="block";--%>
<%--			}--%>
<%--		}else{--%>
<%--			document.getElementById("sfhyj").style.display="none";--%>
<%--		}--%>
<%--	if (pFieldName == 'IS_CONTRACT'){--%>
<%--	     if(saleDetailForm.getValue("IS_CONTRACT")=="3"){--%>
<%--	    	    document.getElementById("sfhyj").style.display="block";--%>
<%--				document.getElementById("yysm").style.display="block";--%>
<%--				}--%>
<%--			else{--%>
<%--				document.getElementById("yysm").style.display="none";--%>
<%--			}--%>
<%--	     }--%>
      if (pFieldName == 'RESERVE2' || pFieldName == 'IS_CONTRACT'){
    	  var _RESERVE2=saleDetailForm.getValue("RESERVE2");
    	  if(_RESERVE2=='1'){
    		  document.getElementById("sfhyj").style.display="block";
    	  }else{
    		  document.getElementById("sfhyj").style.display="none";
    	  }
      }
      setLimAmount();
      
	}

function initDetailForm(){
	//document.getElementById("sfhyj").style.display="none";
	saleDetailForm.setColEditSts("SALE_ACTIVE_CODE",false);
    //saleDetailForm.setFocus("SALE_FLAG");
    //saleDetailForm.setFocus("MARKET");
    //saleDetailForm.setFocus("SALE_ACTIVE_NAME");
    //saleDetailForm.setValue("SALE_FLAG",11);
    //saleDetailForm.setValue("RESERVE2",1);
    saleDetailForm.setValue("MARKET",1);
    saleDetailForm.setValue("RESERVE3",0);
    saleDetailForm.setColEditSts("OPEN_CHANNEL",false);
	document.getElementById("SALETYPE_OTHERSALE_td_1").style.display="none";
    document.getElementById("SALETYPE_OTHERSALE_td_2").style.display="none";
    saleDetailForm.setValue("SALETYPE_OTHERSALE","");
    document.getElementById("SALETYPE_DES_OTHERSALE_td_1").style.display="none";
    document.getElementById("SALETYPE_DES_OTHERSALE_td_2").style.display="none";
    saleDetailForm.setValue("SALETYPE_DES_OTHERSALE","");
    
}

function initComputeFormClose(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="none";
    document.getElementById("BACK_PROPORTION_td_2").style.display="none";
    saleDetailForm.setValue("BACK_PROPORTION","");
    saleDetailForm.setColEditSts("BACK_PROPORTION",false);
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="none";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="none";
    saleDetailForm.setValue("PRE_STORE_TO_PRESENT","");
    saleDetailForm.setColEditSts("PRE_STORE_TO_PRESENT",false);
    document.getElementById("PRE_INCOME_td_1").style.display="none";
    document.getElementById("PRE_INCOME_td_2").style.display="none";
    saleDetailForm.setValue("PRE_INCOME","");
    saleDetailForm.setValue("PRE_INCOME2","");
    saleDetailForm.setColEditSts("PRE_INCOME",false);
    saleDetailForm.setColEditSts("PRE_INCOME2",false);
    document.getElementById("FEE_DISCOUNT_td_1").style.display="none";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="none";
    saleDetailForm.setValue("FEE_DISCOUNT","");
    saleDetailForm.setColEditSts("FEE_DISCOUNT",false);
    document.getElementById("BUSINESS_DISCOUNT_td_1").style.display="none";
    document.getElementById("BUSINESS_DISCOUNT_td_2").style.display="none";
    saleDetailForm.setValue("BUSINESS_DISCOUNT","");
    saleDetailForm.setColEditSts("BUSINESS_DISCOUNT",false);
    document.getElementById("MOBILE_COST_td_1").style.display="none";
    document.getElementById("MOBILE_COST_td_2").style.display="none";
    saleDetailForm.setValue("MOBILE_COST","");
    saleDetailForm.setColEditSts("MOBILE_COST",false);
    document.getElementById("ELECPAY_COST_td_1").style.display="none";
    document.getElementById("ELECPAY_COST_td_2").style.display="none";
    saleDetailForm.setValue("ELECPAY_COST","");
    saleDetailForm.setColEditSts("ELECPAY_COST",false);
    document.getElementById("MOBILEPAY_COST_td_1").style.display="none";
    document.getElementById("MOBILEPAY_COST_td_2").style.display="none";
    saleDetailForm.setValue("MOBILEPAY_COST","");
    saleDetailForm.setColEditSts("MOBILEPAY_COST",false);
    document.getElementById("ELECGOODS_COST_td_1").style.display="none";
    document.getElementById("ELECGOODS_COST_td_2").style.display="none";
    saleDetailForm.setValue("ELECGOODS_COST","");
    saleDetailForm.setColEditSts("ELECGOODS_COST",false);
    document.getElementById("GOODS_COST_td_1").style.display="none";
    document.getElementById("GOODS_COST_td_2").style.display="none";
    saleDetailForm.setValue("GOODS_COST","");
    saleDetailForm.setColEditSts("GOODS_COST",false);
    //saleDetailForm.setValue("CHANNEL_PAY","");
    saleDetailForm.setColEditSts("CHANNEL_PAY",false);
    //saleDetailForm.setValue("ESTIMATE_AD_FEE","");
    saleDetailForm.setColEditSts("ESTIMATE_AD_FEE",false);
    //saleDetailForm.setValue("ESTIMATE_OTHER_FEE","");
    saleDetailForm.setColEditSts("ESTIMATE_OTHER_FEE",false);
    saleDetailForm.setValue("COST_TOTAL","");
    saleDetailForm.setColEditSts("COST_TOTAL",false);
}

function initComputeFormOpen(saleType){
    saleDetailForm.setColEditSts("ESTIMATE_AD_FEE",is_tableSaleDetailListTableRowSetEditAble);
    saleDetailForm.setColEditSts("ESTIMATE_OTHER_FEE",is_tableSaleDetailListTableRowSetEditAble);
    saleDetailForm.setColEditSts("CHANNEL_PAY",is_tableSaleDetailListTableRowSetEditAble);
	if (saleType == 11) {
	    initDetailForm11();
	} else if (saleType == 12) {
	    initDetailForm12();
	}else if (saleType == 18) {
	    initDetailForm12();
	} else if (saleType == 13||saleType == 16) {
	    initDetailForm13();
	} else if (saleType == 14) {
	    initDetailForm14();
	} else if (saleType == 15) {
	    initDetailForm15();
	} else if (saleType == 21) {
	    initDetailForm21();
	} else if (saleType == 22) {
	    initDetailForm22();
	} else if (saleType == 31) {
	    initDetailForm31();
	} else if (saleType == 41) {
	    initDetailForm41();
	} else{
       //alert("��������Ϊ��");
    }
}

function initDetailForm11(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_1").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="block";
    document.getElementById("goods_tag_div").style.display="none";
}

function initDetailForm12(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    document.getElementById("ELECPAY_COST_td_1").style.display="block";
	    document.getElementById("ELECPAY_COST_td_2").style.display="block";
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    document.getElementById("MOBILEPAY_COST_td_1").style.display="block";
	    document.getElementById("MOBILEPAY_COST_td_2").style.display="block";
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    document.getElementById("ELECGOODS_COST_td_1").style.display="block";
	    document.getElementById("ELECGOODS_COST_td_2").style.display="block";
    }
    document.getElementById("goods_tag_div").style.display="none";
}

function initDetailForm13(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("GOODS_COST_td_1").style.display="block";
    document.getElementById("GOODS_COST_td_2").style.display="block";
    document.getElementById("goods_tag_div").style.display="block";
}

function initDetailForm14(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_1").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_2").style.display="block";
    document.getElementById("goods_tag_div").style.display="none";
}

function initDetailForm15(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_1").style.display="block";
    document.getElementById("PRE_STORE_TO_PRESENT_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_1").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="block";
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECPAY_COST_td_1").style.display="block";
        document.getElementById("ELECPAY_COST_td_2").style.display="block";
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("MOBILEPAY_COST_td_1").style.display="block";
        document.getElementById("MOBILEPAY_COST_td_2").style.display="block";
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECGOODS_COST_td_1").style.display="block";
        document.getElementById("ELECGOODS_COST_td_2").style.display="block";
    }
    document.getElementById("GOODS_COST_td_1").style.display="block";
    document.getElementById("GOODS_COST_td_2").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_1").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_2").style.display="block";
    document.getElementById("goods_tag_div").style.display="block";
}

function initDetailForm21(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("MOBILE_COST_td_1").style.display="block";
    document.getElementById("MOBILE_COST_td_2").style.display="block";
    document.getElementById("goods_tag_div").style.display="none";
}

function initDetailForm22(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_1").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="block";
}

function initDetailForm31(){
    document.getElementById("BACK_PROPORTION_td_1").style.display="block";
    document.getElementById("BACK_PROPORTION_td_2").style.display="block";
    document.getElementById("PRE_INCOME_td_1").style.display="block";
    document.getElementById("PRE_INCOME_td_2").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_1").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="block";
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECPAY_COST_td_1").style.display="block";
        document.getElementById("ELECPAY_COST_td_2").style.display="block";
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("MOBILEPAY_COST_td_1").style.display="block";
        document.getElementById("MOBILEPAY_COST_td_2").style.display="block";
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECGOODS_COST_td_1").style.display="block";
        document.getElementById("ELECGOODS_COST_td_2").style.display="block";
    }
    document.getElementById("GOODS_COST_td_1").style.display="block";
    document.getElementById("GOODS_COST_td_2").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_1").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_2").style.display="block";
    document.getElementById("goods_tag_div").style.display="none";
}

function initResDetailForm(){
	var org = g_GetUserInfo().ORG_ID.substr(0, 2);
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleDetailAction?action=queryres&city_id='+org;
	var recode = PostInfo(strUrl, null);
	var TERMINAL_COST_REMAIN=recode.getValueByName("TERMINAL_COST");
	var ACTION_OUT_REMAIN=recode.getValueByName("ACTION_OUT");
	var PROMOTE_SCORE_REMAIN=recode.getValueByName("PROMOTE_SCORE");
	var SALE_POINT_REMAIN=recode.getValueByName("PROMOTE_SCORE");
	if(parseFloat(TERMINAL_COST_REMAIN)<0||TERMINAL_COST_REMAIN==null){
		saleDetailForm.setValue("TERMINAL_COST_REMAIN","0");
	}else{
		saleDetailForm.setValue("TERMINAL_COST_REMAIN",TERMINAL_COST_REMAIN);
	}
	if(parseFloat(ACTION_OUT_REMAIN)<0||ACTION_OUT_REMAIN==null){
		saleDetailForm.setValue("ACTION_OUT_REMAIN","0");
	}else{
		saleDetailForm.setValue("ACTION_OUT_REMAIN",ACTION_OUT_REMAIN);
	}
	if(parseFloat(PROMOTE_SCORE_REMAIN)<0||PROMOTE_SCORE_REMAIN==null){
		saleDetailForm.setValue("PROMOTE_SCORE_REMAIN","0");
	}else{
		saleDetailForm.setValue("PROMOTE_SCORE_REMAIN",PROMOTE_SCORE_REMAIN);
	}
	if(parseFloat(SALE_POINT_REMAIN)<0||SALE_POINT_REMAIN==null){
		saleDetailForm.setValue("SALE_POINT_REMAIN","0");
	}else{
		saleDetailForm.setValue("SALE_POINT_REMAIN",SALE_POINT_REMAIN);
	}
}

function initDetailForm41(){
    document.getElementById("SALETYPE_OTHERSALE_td_1").style.display="block";
    document.getElementById("SALETYPE_OTHERSALE_td_2").style.display="block";
    document.getElementById("SALETYPE_DES_OTHERSALE_td_1").style.display="block";
    document.getElementById("SALETYPE_DES_OTHERSALE_td_2").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_1").style.display="block";
    document.getElementById("FEE_DISCOUNT_td_2").style.display="block";
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECPAY_COST_td_1").style.display="block";
        document.getElementById("ELECPAY_COST_td_2").style.display="block";
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("MOBILEPAY_COST_td_1").style.display="block";
        document.getElementById("MOBILEPAY_COST_td_2").style.display="block";
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        document.getElementById("ELECGOODS_COST_td_1").style.display="block";
        document.getElementById("ELECGOODS_COST_td_2").style.display="block";
    }
    document.getElementById("GOODS_COST_td_1").style.display="block";
    document.getElementById("GOODS_COST_td_2").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_1").style.display="block";
    document.getElementById("BUSINESS_DISCOUNT_td_2").style.display="block";
    document.getElementById("goods_tag_div").style.display="block";
}

function newSaleDetail()
{
	saleDetailForm.newRow();
    _include_formWeaponSelectFormRowSet().newRow();
    clsTable(_include_formDetailTagTabTableRowSet());
    //AIContractFrame_OpenClose("weaponInfoframe");
    //AIContractFrame_closeMe();
	//saleDetailForm.setEditSts(true);
	initDetailForm();
    initComputeFormClose();
    saleDetailForm.setValue("SALE_FLAG",11);
    initComputeFormOpen(11);
	//var mainId = _include_fromSaleMainFormRowSet().getValue("MAINID");
	var curRow = _include_fromSaleMainTabRowSet().getCurRowIndex();
	var mainId = _include_fromSaleMainTabRowSet().getValue(curRow,"MAINID");
	saleDetailForm.setValue("SALE_ID",mainId);
	var isGroup = _include_fromSaleMainTabRowSet().getValue(curRow, "ISGROUP");
	if(isGroup == "true") {
		document.getElementById("dis1").style.display="none";
		document.getElementById("dis2").style.display="none";
		document.getElementById("dis3").style.display="none";
		document.getElementById("dis4").style.display="none";
		document.getElementById("dis5").style.display="none";
		document.getElementById("dis6").style.display="none";
		//document.getElementById("jthdxs").style.display="block";
	} else {
		document.getElementById("dis1").style.display="block";
		document.getElementById("dis2").style.display="block";
		document.getElementById("dis3").style.display="block";
		document.getElementById("dis4").style.display="block";
		document.getElementById("dis5").style.display="block";
		document.getElementById("dis6").style.display="block";
		//document.getElementById("jthdxs").style.display="none";
		saleDetailForm.setValue("RESERVE3",0);
	}
	document.getElementById("sfhyj").style.display="none";
	nullLimitCombo();
	//saleDetailForm.setFocus("RESERVE2");
	//saleDetailForm.setFocus("RESERVE3");
	//��ջ�Ʒ�嵥
	var goodsTagTab = g_TableRowSetManager.get("goodsTagTab");
	goodsTagTab.refresh("&saleItemId=0");
	_goodsTagIdsGolobe = '';
	_channelListTab.clear();
	_userScaleListTab.clear();
	_cgroupListTab.clear();
	//���checkbox
	setCheckBox("");
	initResDetailForm();
	/*document.getElementById('selSendType0').checked = false;
	document.getElementById('selSendType1').checked = false;*/
}

function initPage()
{
	initOper();
}

function saveSaleDetail(saveFlag)
{
	var curRow = _include_fromSaleMainTabRowSet().getCurRowIndex();
	var mainId = _include_fromSaleMainTabRowSet().getValue(curRow, "MAINID");
	var saleFlag = saleDetailForm.getValue("SALE_FLAG");
    if(parseFloat(saleDetailForm.getValue("TERMINAL_COST"))>parseFloat(saleDetailForm.getValue("TERMINAL_COST_REMAIN"))){
    	alert("�����ն˲�����Դ���ܴ��ڵ�ǰ�ն˲���ʣ����");
    	return;
    }
    if(parseFloat(saleDetailForm.getValue("ACTION_OUT"))>parseFloat(saleDetailForm.getValue("ACTION_OUT_REMAIN"))){
    	alert("�����ۿ�������Դ���ܴ��ڵ�ǰ�ۿ�����ʣ����");
    	return;
    }
    if(parseFloat(saleDetailForm.getValue("PROMOTE_SCORE"))>parseFloat(saleDetailForm.getValue("PROMOTE_SCORE_REMAIN"))){
    	alert("�������������Դ���ܴ��ڵ�ǰ��������ʣ����");
    	return;
    }
    if(parseFloat(saleDetailForm.getValue("SALE_POINT"))>parseFloat(saleDetailForm.getValue("SALE_POINT_REMAIN"))){
    	alert("�����������Դ���ܴ��ڵ�ǰ������ʣ����");
    	return;
    }
	if (null == mainId || "" == mainId) {
		return alert("����ѡ�����Σ�");
	}
	saleDetailForm.setValue("SALE_ID",mainId);
	//��鹴ѡ��ҵ����ʾ�Ƿ���д��
	if (!examineHint()) {
		return;
	}
	//��ҵ����ʾcheckbox�е�ֵ���õ�EXT1�ֶ�
	saleDetailForm.setValue("EXT1",getHintCheckBoxVal());
	saleDetailForm.setValue("IS_LIMIT_COMBO",getIsLimitComboValue());
	var checkFlag = 0;
    var note = "�ڱ���֮ǰ���������ѡ��";
    if ("" == saleDetailForm.getValue("SALE_ACTIVE_NAME"))
    {
        note = note + "���������ơ�";
        checkFlag++;
    }
    if ("" == saleDetailForm.getValue("RESERVE2"))
    {
        note = note + "�����η�����Ϣ��";
        checkFlag++;
    }
	if (saleDetailForm.getValue("RESERVE2") != "1"){
		saleDetailForm.setValue("IS_CONTRACT",null);
	}   

	if(saleDetailForm.getValue("RESERVE2") == "1" && saleDetailForm.getValue("IS_CONTRACT")==""){
		note = note + "���ն����͡�";
        checkFlag++;
	}
	if(saleDetailForm.getValue("HOME_TYPE")==""){
		note = note + "���Ƿ�������(�����������)��";
        checkFlag++;
	}
	
		if(saleDetailForm.getValue("IS_LIMIT_COMBO")==""){
			note = note + "���Ƿ��޶��ײͷ��á�";
        	checkFlag++;
			
		}else if(saleDetailForm.getValue("IS_LIMIT_COMBO")=="0"&&saleDetailForm.getValue("LIMIT_AMOUNT")==""){
			note = note + "���޶���";
        	checkFlag++;
		}
		
	
    /*if ("" == saleDe tailForm.getValue("CUST_GROUP_ID"))
    {
        note = note + "��Ŀ��ͻ�Ⱥ��Ϣ��";
        checkFlag++;
    } */
    if (("17" == saleFlag || "23" == saleFlag) && 
    		("" == saleDetailForm.getValue("EXT6") || "0" == saleDetailForm.getValue("EXT6")))
    {
        note = note + "������������Ч�ڽ�ֹʱ�䡱";
        checkFlag++;
    }
   /* if ("" == saleDetailForm.getValue("MAX_PERSON"))
    {
        note = note + "����������û�����";
        checkFlag++;
    }
    if ("" == saleDetailForm.getValue("PRE_PERSON"))
    {
        note = note + "��Ԥ���û���ģ��";
        checkFlag++;
    }*/
    if ("" == saleDetailForm.getValue("WEAPON_ID"))
    {
        note = note + "��������";
        checkFlag++;
    }
    if (5 == checkFlag){
    	return "Y";
    }
    if (0 < checkFlag){
    	if ("C" == saveFlag){
    		return "C";
    	}
        note = note + "!";
        alert(note);
        return;
    }
    
    if(!refreshCompute4weapon()){
    	return;
    }
    // �����ʶ˰�� �޸�ʱ�䣺2014-11-26
    savaTag();
    //2015-7-1 ������ϢΪ������
    if (_channelListTab.getTotalRowCount() == 0) {
    	return alert("����д����������Ϣ��");
    } else {
    	for (var k=0; k<_channelListTab.getTotalRowCount(); ++k) {
	    	if (_channelListTab.getValue(k,"REGION") == ""
	    	    || _channelListTab.getValue(k,"CHANNEL_CODE") == ""
	    	    || _channelListTab.getValue(k,"OPERATION") == "") {
	    		return alert("������Ϣ����Ϊ�գ�");
	    	}
    	}
    }
    if (_userScaleListTab.getTotalRowCount()> 0) {
    	for (var k=0; k<_userScaleListTab.getTotalRowCount(); ++k) {
	    	if (_userScaleListTab.getValue(k,"REGION") == ""
	    	    || _userScaleListTab.getValue(k,"MAX_USERS") == ""
	    	  ) {
	    		return alert("��ģ��Ϣ����Ϊ�գ�");
	    	}
    	}
    }
    if (_cgroupListTab.getTotalRowCount() >= 1) {
    	for (var j=0; j<_cgroupListTab.getTotalRowCount(); ++j) {
	    	if (_cgroupListTab.getValue(j,"CGROUP_FLAG") == ""
	    	    || _cgroupListTab.getValue(j,"CGROUP_BEGIN_TIME") == ""
	    	    || _cgroupListTab.getValue(j,"CGROUP_END_TIME") == "") {
	    		return alert("Ŀ��ͻ�Ⱥ��Ϣ������Ϊ�յģ�");
	    	}
    	}
    }
    
    if ("O" != saleDetailForm.getSts())
    {
		var list = new Array();
		list.push(saleDetailForm);
		var goodsTagIds = '';
		var saleDetailCode = saleDetailForm.getValue("SALE_ACTIVE_CODE");
		if (saleDetailCode == null || saleDetailCode == ''){
			var goodsTagTab = g_TableRowSetManager.get("goodsTagTab");
			var goodsTaglength = goodsTagTab.getTotalRowCount();
			for (var i = 0; i < goodsTaglength; ++i){
				if (i != 0 && goodsTagIds != '') goodsTagIds += ',';
	   			goodsTagIds += goodsTagTab.getValue(i,"WPID");
			}
			
			if(saleFlag == 13 && goodsTagIds == ''){
				return alert("��ѡ���Ʒ��ǩ��");
			}
		}
		var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleDetailAction?action=saveSaleDetail';
		var recode = saveRowSet(strUrl, list);
        var rFlag = recode.getValueByName("FLAG");
        var levId = recode.getValueByName("LEVID");
        if (levId == null || levId == 'null' || levId == "") {
        	levId = saleDetailForm.getValue("DETAIL_ID");
        }
        // ����������Ŀ��ͻ�Ⱥ���û���ģ
        saveChannel(levId,'n');
        saveUserScale(levId,'n');
        saveCgroup(levId,'n');
        
		if ("Y" == rFlag) {
    	   _include_tableSaleDetailListTableRowSet().refresh("&mainId="+mainId);
    	   var orderId = "<%=request.getParameter("orderId")%>";
    	   window.parent.refreshMainTab(orderId);
		   newSaleDetail();
		   _include_formWeaponSelectFormRowSet().newRow();
		   clsTable(_include_formDetailTagTabTableRowSet());
		   saleDetailForm.setValue("SALE_FLAG",11);
		   //��ջ�Ʒ�嵥
		   var goodsTagTab = g_TableRowSetManager.get("goodsTagTab");
		   goodsTagTab.refresh("&saleItemId=0");
		   _goodsTagIdsGolobe = '';
		}
        return rFlag;
	} else {
		// ����������Ŀ��ͻ�Ⱥ
		saveChannel(saleDetailForm.getValue("DETAIL_ID"),'y');
		saveUserScale(saleDetailForm.getValue("DETAIL_ID"),'y');
		saveCgroup(saleDetailForm.getValue("DETAIL_ID"),'n');
        return "Y";
	}
    
}

function saveAndGotoExplanTag()
{
	var flag = saveSaleDetail("C");
    if ("Y" == flag)
    {
        gotoExplanTag();
    } else if ("C" == flag){
    	if (confirm("��ǰ�����Ӫ������Ϣ���������޷����棬ȷ��Ҫ������һ����")){
    		gotoExplanTag();
    	}
    }
}

function gotoExplanTag()
{   
    window.parent.setTabItem("activityTab","activity_3");
}

function showDetailInfo()
{
	
	var curRow = _tableSaleDetailListTableRowSet().getRow();
	var detailId = _tableSaleDetailListTableRowSet().getValue(curRow, "DETAIL_ID");
	saleDetailForm.refresh("&id=" + detailId);
	if(saleDetailForm.getValue("RESERVE2")=="1"){
		document.getElementById("sfhyj").style.display="block";
  	}
	setLimAmount();

    //getSeq=recode.getValueByName("SEQ");
	//saleDetailForm.setEditSts(is_tableSaleDetailListTableRowSetEditAble);
	saleDetailForm.setColEditSts("SALE_ACTIVE_CODE",false);
	
	/*document.getElementById('selSendType0').checked = false;
	document.getElementById('selSendType1').checked = false;*/
	var getIsSendSmsVal=_tableSaleDetailListTableRowSet().getValue(curRow,"IS_SEND_SMS");  
	if("null" != getIsSendSmsVal && "" != getIsSendSmsVal){
    	getcheckboxSts(getIsSendSmsVal);
    }
	refreshWeapon(saleDetailForm.getValue("WEAPON_ID"));
	saleDetailForm.setStsToOld();
	var goodsTagTab = g_TableRowSetManager.get("goodsTagTab");
	goodsTagTab.refresh("&saleItemId=" + detailId);
	
	_channelListTab.refresh("&relaId="+detailId+"&relaType=lev");
	_userScaleListTab.refresh("&relaId="+detailId+"&infoType=lev");
	_cgroupListTab.refresh("&relaId="+detailId+"&relaType=lev");
	document.getElementById("TableRowSet_cgroupListTable").onclick= calendarDlg;
	document.getElementById("TableRowSet_userScaleListTable").onclick= scaleCalendarDlg;
	
	setCheckBox(saleDetailForm.getValue("EXT1"));
	var jfValidity = saleDetailForm.getValue("EXT6");
	switch (jfValidity) {
		case '1': 
			saleDetailForm.setValue("EXT6",'3��31��'); 
			break;
		case '2': 
			saleDetailForm.setValue("EXT6",'6��30��'); 
			break;
		case '3': 
			saleDetailForm.setValue("EXT6",'9��30��'); 
			break;
		case '4': 
			saleDetailForm.setValue("EXT6",'12��31��'); 
			break;
		default: 
			break;
	}
	initResDetailForm();
}

/**
function showDetailList()
{
	var curRow = _tableSaleDetailGroupListTableRowSet().getRow();
	var mainId = _fromSaleMainFormRowSet.getValue("MAINID");
	var saleFlag = _tableSaleDetailGroupListTableRowSet().getValue(curRow, "SALE_FLAG");
	doShowDetailList(mainId, saleFlag);
}
*/

function alertTagsRefreshMainShow(mainId){
	window.parent.resetTabitemsMainShow(mainId);
}

function doShowDetailList(mainId, saleFlag)
{
	_tableSaleDetailListTableRowSet().refresh("&mainId=" + mainId +"&saleFlag=" + saleFlag);
}

function selectStaff()
{
	var url = "<%=request.getContextPath()%>/secframe/orgmodel/operator/StaffSelect_s.jsp";
	var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px");
	if(result != null){
		var value;
		var text;
   		for(var i=0;i < result.elements.length;i++)
  		{
  			alert(result.elements[i].value+"~"+result.elements[i].text);
  			if (i == 0)
  			{
	  			value = result.elements[i].value;
	  			text = result.elements[i].text;
  			} else {
	  			value = value + ";" + result.elements[i].value
	  			text = text + ";" + result.elements[i].text;
  			}
  		}
		_fromWfCheckFormRowSet.setValue("STAFFS", value, text); 
	}
} 

function test1()
{
	saleDetailForm.refreshListBox("SALE_FLAG","codeType=qd",true);
}
</script>
<script language='javascript' src='<%=request.getContextPath()%>/sale/common/js/computeTools.js' ></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/activity/js/computeCost4saleDetail.js"></script>
<script type="text/javascript">
function weaponSelect(){
	var info = "";
    if("" == saleDetailForm.getValue("SALE_FLAG")){
        alert("��ѡ������ǰ��������д�����͡���");
        saleDetailForm.setFocus("SALE_FLAG");
        return;
    }
    if("" == saleDetailForm.getValue("MARKET")){
        alert("��ѡ������ǰ��������д��ϸ���г�����");
        saleDetailForm.setFocus("MARKET");
        return;
    }
	if("" == saleDetailForm.getValue("PRE_PERSON")){
		//alert("��ѡ������ǰ��������д��Ԥ���û���ģ����");
		//saleDetailForm.setFocus("PRE_PERSON");
		//return;
	}
	//AIContractFrame_OpenClose("weaponInfoframe");
    //AIContractFrame_closeMe();
    var url = "<%=request.getContextPath()%>/sale/weapon/WeaponSelectAc.jsp";
    var style = "dialogWidth:800px";
    var initVal = saleDetailForm.getValue("SALE_FLAG") + ";" + saleDetailForm.getValue("MARKET");
    var paraObj = new Object();
    paraObj.itemTypes = initVal;
	var retMsg = window.showModalDialog(url, paraObj, style);
	if(retMsg==null){return;}
    refreshWeapon(retMsg.split(",")[0]);
    saleDetailForm.setValue("WEAPON_ID",_include_formWeaponSelectFormRowSet().getValue("WID"));
}

function refreshWeapon(weaponId){
	_include_formWeaponSelectFormRowSet().refresh("&wwid="+weaponId+"&name="+"&busiType=");
	//��ʼ����ƷЭ��������
	//initAttachCfgOpt(_include_formWeaponSelectFormRowSet().getValue("STANDBY_NUM3"));
    _include_formDetailTagTabTableRowSet().refresh("&weaponId="+weaponId);
    include_setWeaponFrom();
    //AIContractFrame_OpenClose("weaponInfoframe");
    //AIContractFrame_openMe();
    var baseFee = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        baseFee = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //��������
    var baseMonth = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        baseMonth = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //�����ܽ��
    var baseTotal = baseFee*baseMonth;
    var presentTotal = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT");
    if (baseTotal == 0) {
    	saleDetailForm.setValue("PRE_DISCOUNT", 0);
    } else {
    	saleDetailForm.setValue("PRE_DISCOUNT", ((presentTotal/baseTotal)*100).toFixed(2));
    }
    compute4weapon();
}

function compute4weapon(){
	if("" == _include_formWeaponSelectFormRowSet().getValue("SALE_FLAG")) {
		return alert("����ѡ��������Ϣ��");
	}
	saleType = _include_formWeaponSelectFormRowSet().getValue("SALE_FLAG");
	initComputeFormClose();
	if(saleType==11){
		compute4weapon11();
    } else if(saleType==12||saleType==16){
        compute4weapon12();
    } else if(saleType==18){
    	compute4weapon18();
    }else if(saleType==13){
        compute4weapon13();
	} else if(saleType==14){
        compute4weapon14();
	} else if(saleType==15){
        compute4weapon15();
	} else if(saleType==21){
        compute4weapon21();
	} else if(saleType==22){
        compute4weapon22();
	} else if(saleType==31){
        compute4weapon31();
	} else if(saleType==41){
        compute4weapon41();
	} else if(saleType==17 || saleType==23){
	} else {
	   alert("��������Ϊ��");
	}
	initComputeFormOpen(saleType);
}

function refreshCompute4weapon(){
    if("" == _include_formWeaponSelectFormRowSet().getValue("SALE_FLAG")) {
    	alert("����ѡ��������Ϣ��");
        return false;
    }
    saleType = _include_formWeaponSelectFormRowSet().getValue("SALE_FLAG");
    if(saleType==11){
        compute4weapon11();
    } else if(saleType==12||saleType==16){
        compute4weapon12();
    } else if(saleType==18){
    	compute4weapon18();
    }else if(saleType==13){
        compute4weapon13();
    } else if(saleType==14){
        compute4weapon14();
    } else if(saleType==15){
        compute4weapon15();
    } else if(saleType==21){
        compute4weapon21();
    } else if(saleType==22){
        compute4weapon22();
    } else if(saleType==31){
        compute4weapon31();
    } else if(saleType==41){
        compute4weapon41();
    } else if(saleType==17 || saleType==23) {
    	
    } else {
       alert("��������Ϊ��");
       return false;
    }
    return true;
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">
//����Ӫ����
function zdyxdMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleZDYXDMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:250px;dialogWidth:440px";
    var iniVal = saleDetailForm.getValue("ACTIVE_SALE_SITE");
    saleDetailForm.setValue("ACTIVE_SALE_SITE",onItemMultiplySelected(url, iniVal, style));
}

//����
function channelMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleChannelMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = saleDetailForm.getValue("OPEN_CHANNEL");
    saleDetailForm.setValue("OPEN_CHANNEL",onItemMultiplySelected(url, iniVal, style));
}

//ϸ���г�
function marketSimpleSelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleMarketSimpleSelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:100px";
    var rVal = onItemSimpleSelected(url, null, style);
    saleDetailForm.setValue("MARKET",rVal.split(";")[0]);
}
</script>
<script type="text/javascript">
function setButtonDisabled(){
    document.getElementById('bt_weaponSelect1').style.visibility='hidden';
	document.getElementById('bt_refreshCompute4weapon').style.visibility='hidden';
	document.getElementById('bt_newSaleDetail').style.visibility='hidden';
	document.getElementById('bt_delSaleDetail').style.visibility='hidden';
	document.getElementById('bt_applyWeapon').style.visibility='hidden';
	document.getElementById('bt_addGoodsTag').style.visibility='hidden';
	document.getElementById('bt_delGoodsTag').style.visibility='hidden';
	document.getElementById('bt_saveSaleMain').style.visibility='hidden';
	document.getElementById('bt_gotoExplanTag').style.visibility='hidden';
	document.getElementById('bt_addChannl').style.visibility='hidden';
	document.getElementById('bt_delChannl').style.visibility='hidden';
	document.getElementById('bt_addCgroup').style.visibility='hidden';
	document.getElementById('bt_delCgroup').style.visibility='hidden';
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>

<script type="text/javascript">
/*function  getSelSendType() {
	var busiTypeVal = "";  //�Ƿ���Ҫ��������
	var aSelBusiType = new Array("selSendType0", "selSendType1"); 
    var pos = 0;
   	for(pos = 0;pos<aSelBusiType.length;pos++){
    	if (document.getElementById(aSelBusiType[pos]).checked) {
      		if (busiTypeVal != ""){
            	busiTypeVal += ";";
          	}
      		busiTypeVal += document.getElementById(aSelBusiType[pos]).value;
        }
    }
    return busiTypeVal;
}

function checkboxSts(POS) {
	if(POS == 0){
		if(true == document.getElementById('selSendType0').checked){
			document.getElementById('selSendType1').checked = false;
		}
	}
	if(POS == 1){
		if(true == document.getElementById('selSendType1').checked){
			document.getElementById('selSendType0').checked = false;
		}
	}
}		
	
//��ʾ���� �Ƿ���Ҫ��������
function getcheckboxSts(sendType){
	//alert(sendType);
	if(sendType != null && sendType != ""){
    	var eMailBusiTypeArr = sendType.split(";");
    	for(var i = 0; i < eMailBusiTypeArr.length; i++){
    		document.getElementById("selSendType"+eMailBusiTypeArr[i]).checked = true;
    	}
    }
}*/
function examineHint() {
	if (document.getElementById('hint0_input').checked && saleDetailForm.getValue("EXT2") == '') {
		alert ("������д��ǰ̨������Ϣ��ʾ��");
		return false;
	}
	if (document.getElementById('hint1_input').checked && saleDetailForm.getValue("EXT3") == '') {
		alert ("������д���º������ʾ��");
		return false;
	}
	if (document.getElementById('hint2_input').checked && saleDetailForm.getValue("EXT4") == '') {
		alert ("������д�÷�Ʊ��ӡ��Ϣ��ʾ��");
		return false;
	}
	if (document.getElementById('hint3_input').checked && saleDetailForm.getValue("EXT5") == '') {
		alert ("������д�������ӡ��Ϣ��ʾ��");
		return false;
	}
	return true;
}

function getHintCheckBoxVal(){
	var hintVal = "";  //�Ƿ���Ҫ��������
   	for(var pos = 0; pos < 4; ++pos){
    	if (document.getElementById("hint" + pos + "_input").checked) {
      		if (hintVal != ""){
            	hintVal += ";";
          	}
      		hintVal += document.getElementById("hint" + pos + "_input").value;
        }
    }
    return hintVal;
}

function getIsLimitComboValue(){
	var islimcombov = document.getElementsByName("IS_L_COMBO");
	var value='';
	for(var i = 0;i<islimcombov.length;i++){
		if(islimcombov[i].checked){
			value=i;
			break;
		}
	}
	return value;
}

function setCheckBox(hintVal) {
	document.getElementById("hint0_input").checked = false;
    document.getElementById("hint1_input").checked = false;
    document.getElementById("hint2_input").checked = false;
    document.getElementById("hint3_input").checked = false;
	if(hintVal != null && hintVal != ""){
    	var hintVec = hintVal.split(";");
    	for(var i = 0; i < hintVec.length; i++){
    		document.getElementById("hint"+hintVec[i] + "_input").checked = true;
    		document.getElementById("hint"+hintVec[i] + "_tr").style.display="block";
    	}
    } 
	if(true == document.getElementById('hint0_input').checked){
		document.getElementById("hint0_tr").style.display="block";
	} else {
		document.getElementById("hint0_tr").style.display="none";
	}
	if(true == document.getElementById('hint1_input').checked){
		document.getElementById("hint1_tr").style.display="block";
	} else {
		document.getElementById("hint1_tr").style.display="none";
	}
	if(true == document.getElementById('hint2_input').checked){
		document.getElementById("hint2_tr").style.display="block";
	} else {
		document.getElementById("hint2_tr").style.display="none";
	}
	if(true == document.getElementById('hint3_input').checked){
		document.getElementById("hint3_tr").style.display="block";
	} else {
		document.getElementById("hint3_tr").style.display="none";
	}
}

function checklimittype(t){
	if(t==0){
		document.getElementById("limit_amount_0").style.display="block";
		document.getElementById("limit_amount_1").style.display="block";
		saleDetailForm.setValue("IS_LIMIT_COMBO","0");
	}else if(t==1){
		document.getElementById("limit_amount_0").style.display="none";
		document.getElementById("limit_amount_1").style.display="none";
		saleDetailForm.setValue("LIMIT_AMOUNT",'');
		saleDetailForm.setValue("IS_LIMIT_COMBO","1");
	}
}

function checkhometype(t){
	if(t==0){
		saleDetailForm.setValue("HOME_TYPE","0");
	}else if(t==1){
		saleDetailForm.setValue("HOME_TYPE","1");
	}
}
function checkboxSts(pos) {
	if(pos == 0){
		if(true == document.getElementById('hint0_input').checked){
			document.getElementById("hint0_tr").style.display="block";
		} else {
			document.getElementById("hint0_tr").style.display="none";
		}
	}
	if(pos == 1){
		if(true == document.getElementById('hint1_input').checked){
			document.getElementById("hint1_tr").style.display="block";
		} else {
			document.getElementById("hint1_tr").style.display="none";
		}
	}
	if(pos == 2){
		if(true == document.getElementById('hint2_input').checked){
			document.getElementById("hint2_tr").style.display="block";
		} else {
			document.getElementById("hint2_tr").style.display="none";
		}
	}
	if(pos == 3){
		if(true == document.getElementById('hint3_input').checked){
			document.getElementById("hint3_tr").style.display="block";
		} else {
			document.getElementById("hint3_tr").style.display="none";
		}
	}
}

// �û���ģ
function addUserScale() {
	_userScaleListTab.newRow(false);
	var curRow = _userScaleListTab.getCurRowIndex();
	_userScaleListTab.setValue(curRow,"INFO_TYPE", 'lev');
	_userScaleListTab.setValue(curRow,"START_TIME", saleStartTime);
	_userScaleListTab.setValue(curRow,"END_TIME", saleEndTime);
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
		levId = saleDetailForm.getValue("DETAIL_ID");
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
	_userScaleListTab.refresh("&relaId="+levId+"&infoType=lev");
}

// ����
function addChannel() {
	_channelListTab.newRow(false);
	var curRow = _channelListTab.getCurRowIndex();
	_channelListTab.setValue(curRow,"REL_TYPE", 'lev');
	_channelListTab.setValue(curRow,"CHANNEL_CODE", 'ALL');
	_channelListTab.setValue(curRow,"REGION", getDefualtExearea());
}

function delChannel() {
	var delChannelList = new Array();
	delChannelList = _channelListTab.getSelectedRows();
	var delChannelRc = delChannelList.length;
    if (delChannelRc < 1) {
        return alert("�빴ѡҪɾ���ļ�¼��");
    }
    var relId = _channelListTab.getValue(0,"REL_ID");
    while (delChannelRc > 0) {
	    delChannelRc--;
	    _channelListTab.deleteRow(delChannelList[delChannelRc]);
    }
    if (relId == null || relId==""){
    	return;
    }
    saveChannel("", "y");
}

function saveChannel(levId, alertFlag) {
	if (levId != null && levId != "") {
		for (var i=0; i< _channelListTab.getTotalRowCount(); ++i) {
			_channelListTab.setValue(i, "REL_ID", levId);
		}
	} else {
		levId = saleDetailForm.getValue("DETAIL_ID");
	}
	var list = new Array();
	list.push(_channelListTab);
  	var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.ChannelInfoAction?action=save';
	var recode = saveRowSet(strUrl, list);
  	var rFlag = recode.getValueByName("FLAG");
  	if (alertFlag == 'y' && rFlag == 'Y') {
  		alert("�����ɹ���");
  	} else if (alertFlag == 'y' && rFlag == 'N') {
  		alert("����ʧ�ܣ�");
  	}
	_channelListTab.refresh("&relaId="+levId+"&relaType=lev");
}

// Ŀ��ͻ�Ⱥ
function addCgroup() {
	var url = "<%=request.getContextPath()%>/sale/activity/include/_custGroup.jsp?orgId="+g_GetUserInfo().ORG_ID.substr(0,2);
    var style = "dialogWidth:600px;dialogHeight:600px"; 
    var retMsg = window.showModalDialog(url, '', style);
    if(retMsg==null || retMsg==''){
    	return;
    } else {
		_cgroupListTab.newRow(false);
		var curRow = _cgroupListTab.getCurRowIndex();
		_cgroupListTab.setValue(curRow,"RELAT_TYPE", 'lev');
		_cgroupListTab.setValue(curRow,"ORDER_ID", _fromSaleOrderFormRowSet().getValue("ORDER_ID"));
    	_cgroupListTab.setValue(curRow,"CGROUP_ID",retMsg.split(",")[0]);
    	_cgroupListTab.setValue(curRow,"CGROUP_TAB",retMsg.split(",")[1]);
    	_cgroupListTab.setValue(curRow,"CGROUP_NAME",retMsg.split(",")[2]);
    	_cgroupListTab.setValue(curRow,"CGROUP_REGION",retMsg.split(",")[3]);
    	_cgroupListTab.setValue(curRow,"CGROUP_USERNUM",retMsg.split(",")[4]);
    }
}

function delCgroup() {
	var delCgroupList = new Array();
	delCgroupList = _cgroupListTab.getSelectedRows();
	var delCgroupRc = delCgroupList.length;
    if (delCgroupRc < 1) {
        return alert("�빴ѡҪɾ���ļ�¼��");
    }
    var relId = _channelListTab.getValue(0,"REL_ID");
    while (delCgroupRc > 0) {
	    delCgroupRc--;
	    _cgroupListTab.deleteRow(delCgroupList[delCgroupRc]);
    }
    if (relId == null || relId==""){
    	return;
    }
    saveCgroup("", "y");
}

function nullLimitCombo(){
	 document.getElementById("combo_input1").checked=false;
     document.getElementById("combo_input2").checked=false;
     document.getElementById("broband_input1").checked=false;
	 document.getElementById("broband_input2").checked=false;
     document.getElementById("limit_amount_0").style.display="none";
     document.getElementById("limit_amount_1").style.display="none";
	 saleDetailForm.setValue("HOME_TYPE","");
     saleDetailForm.setValue("LIMIT_AMOUNT","");
     saleDetailForm.setValue("IS_LIMIT_COMBO","");
}
function setLimAmount(){
		var _IS_LIMIT_COMBO = saleDetailForm.getValue("IS_LIMIT_COMBO");
		var _HOME_TYPE = saleDetailForm.getValue("HOME_TYPE");
		if(_IS_LIMIT_COMBO=='0'){
			document.getElementById("combo_input1").checked=true;
			document.getElementById("limit_amount_0").style.display="block";
			document.getElementById("limit_amount_1").style.display="block";
		}else if(_IS_LIMIT_COMBO=='1'){
			document.getElementById("limit_amount_0").style.display="none";
    		document.getElementById("limit_amount_1").style.display="none";
			document.getElementById("combo_input2").checked=true;
		}else{
			document.getElementById("combo_input1").checked=false;
			document.getElementById("combo_input2").checked=false;
			document.getElementById("limit_amount_0").style.display="none";
    		document.getElementById("limit_amount_1").style.display="none";
    		saleDetailForm.setValue("LIMIT_AMOUNT","");
     		saleDetailForm.setValue("IS_LIMIT_COMBO","");
		}
		if(_HOME_TYPE=='0'){
			document.getElementById("broband_input1").checked=true;			
		}else if(_HOME_TYPE=='1'){
			document.getElementById("broband_input2").checked=true;
		}else{
			document.getElementById("broband_input1").checked=false;
			document.getElementById("broband_input2").checked=false;
			saleDetailForm.setValue("HOME_TYPE","");
		}
}

function saveCgroup(levId, alertFlag) {
	if (levId != null && levId != "") {
		for (var i=0; i< _cgroupListTab.getTotalRowCount(); ++i) {
			_cgroupListTab.setValue(i, "RELAT_ID", levId);
		}
	} else {
		levId = saleDetailForm.getValue("DETAIL_ID");
	}
	var list = new Array();
	list.push(_cgroupListTab);
  	var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.CustGroupAction?action=save';
	var recode = saveRowSet(strUrl, list);
  	var rFlag = recode.getValueByName("FLAG");
  	if (alertFlag == 'y' && rFlag == 'Y') {
  		alert("�����ɹ���");
  	} else if (alertFlag == 'y' && rFlag == 'N') {
  		alert("����ʧ�ܣ�");
  	}
	_cgroupListTab.refresh("&relaId="+levId+"&relaType=lev");
	document.getElementById("TableRowSet_cgroupListTable").onclick= calendarDlg;
	document.getElementById("TableRowSet_userScaleListTable").onclick= scaleCalendarDlg;
}

function calendarDlg() {
	var curRow = _cgroupListTab.getRow();
	var curCol = _cgroupListTab.getCol();
	if(_cgroupListTab.getRowEditSts(curRow) == true && (curCol==4 || curCol==5)){
	     var url = "<%=request.getContextPath()%>/jsv2/DBCalendarDlg_zh_CN.htm";
	     var ret = window.showModalDialog(url, obj, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:220px;dialogWidth:200px;unadorned:yes");
	     if (ret != null && ret != "" && ret != "none") {
			if (curCol == 4) {
				if (_cgroupListTab.getValue(curRow,"CGROUP_END_TIME") !="" &&
						-1 != g_CompareDate(ret, _cgroupListTab.getValue(curRow,"CGROUP_END_TIME"))) {
					return alert("��ʼʱ�����С�ڽ���ʱ��")
				}
				_cgroupListTab.setValue(curRow, "CGROUP_BEGIN_TIME", ret);
			} else if (curCol == 5) {
				if (_cgroupListTab.getValue(curRow,"CGROUP_BEGIN_TIME") !="" &&
						-1 != g_CompareDate(_cgroupListTab.getValue(curRow,"CGROUP_BEGIN_TIME"),ret)) {
					return alert("����ʱ�������ڿ�ʼʱ��")
				}
				_cgroupListTab.setValue(curRow, "CGROUP_END_TIME", ret);
			}
	     }
	     _cgroupListTab.setFocus(0,0);
	}
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
</script>


