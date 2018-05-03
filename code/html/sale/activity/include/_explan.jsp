<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="saleOtherframe" contenttype="table" title="服务相关信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="saleMainExplanForm" 
            setname="com.asiainfo.sale.activity.web.SETSaleMain"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleMainSV"
            implservice_querymethod="getSaleMainById(String id)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        	 <tr>
                <td colspan="6"><B>按照《湖北公司关于下发《中国移动湖北公司营销活动服务准则》的通知》（鄂移客[2014]767号）文件要求，所有营销案必须填写服务预案表。</B></td>
            </tr>
            <tr>
            	<td colspan="6">下载模版：<a href="javascript:downTemplate(1)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">服务预案表.xlsx</span></a></td></tr>
            <tr><td colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	<a href="javascript:downTemplate(3)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">业务营销活动稽核方案模版.xlsx</span></a></td></tr></tr>
            <tr><td><br/></td></tr>
            <!--  
            <tr>
                <td colspan="6">传播方案：&nbsp;&nbsp;<a href="javascript:include_showOffInfo('PRORPLAN')"><font color="red">填写说明</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="PRORPLAN" height="56" width="650" editable="true"/>
                    <ai:dbformfield formid="saleMainExplanForm" fieldname="MAINID" width="50" visible="false"/></td>
            </tr>
            <tr id='PRORPLAN' style='display: none;'>
                <td colspan="6"><font color="blue"> 1、传播口号：<br/>
                                 2、传播方式及渠道（广播电视、报纸杂志、户外广告、网络广告其他广告展览、印刷、其他宣传等）</font></td>
            </tr>
            <tr>
                <td colspan="6">客服解释口径：&nbsp;&nbsp;<a href="javascript:include_showOffInfo('EXPLANATION')"><font color="red">填写说明</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="EXPLANATION" height="160" width="650"/></td>
            </tr>
            <tr id='EXPLANATION' style='display: none;'>
                <td colspan="6"><font color="blue"> 1、请问一下这个促销的主要内容是什么？<br/>
                                用客户化的语言简要描述促销的内容(主要卖点）<br/>
                                2、我是否能参与这次促销活动？<br/>
                                描述客户参与资格，品牌要求，互斥要求等<br/>
                                3、我可以在哪里进行办理？<br/>
                                描述办理渠道和办理方式<br/>
                                4、我参加这次活动将享受哪些优惠？<br/>
                                描述客户可以享受的优惠（送话费、电子券、礼品、终端、数据业务等）<br/>
                                5、我参加本次活动什么时候可以开始享受优惠，优惠期什么时候结束？<br/>
                                描述优惠的持续时间<br/>
                                6、优惠到期后我将如何取消业务？（只针对数据业务营销）<br/>
                                描述取消方式<br/>
                                7、每月返帐时间是什么时候？<br/>
                                描述每月各种金额的返帐时间<br/>
                                8、我参加本次活动后的资费标准是什么，是否额外收取其他费用？<br/>
                                描述资费标准<br/>
                                9、是否有保底及其他要求？<br/>
                                描述客户需付出的代价（积分、保底、捆绑的产品及其周期）<br/>
                                10、如活动需两个号码合户办理，预存话费及保底标识添加在哪个号码上？<br/>
                                描述BOSS系统中对应活动标识，预存话费及保底标识添加规则<br/>
                                11、保底中是否包SP、国际业务？<br/>
                                描述保底中是否包SP、国际业务<br/>
                                12、我是否可以提前终止合约？<br/>
                                 描述合约是否可终止的条件<br/>
                                13、参加这个活动有没有什么要特别注意的？<br/>
                                特殊情况的处理原则说明（不可办理停机保号，拆包处理原则等）”</font></td>
            </tr>
            -->
            <tr>
                <td colspan="6">主动营销要求：&nbsp;&nbsp;<a href="javascript:include_showOffInfo('SALEDEMAND')"><font color="red">填写说明</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="SALEDEMAND" height="80" width="650"/></td>
            </tr>
            <tr id='SALEDEMAND' style='display: none;'>
                <td colspan="6"><font color="blue"> 1、主动营销活动时间范围：示例 4月1日至4月30日<br/>
                                 2、主动营销用户提取规则：示例：GPRS5元套餐：ARPU在30元以上/手机支持上网/上月通话次数大于50次<br/>
                                 3、主动营销用语：<br/>
                                10086挂机短信：70字以内，示例：拨打朋友的电话总能听到新鲜的铃音？不用再羡慕，上中国移动音乐门户music.10086.cn，网罗最新潮、最个性彩铃，“响”法72变，让朋友们爱上给你打电话。<br/>
                                网厅登陆短信：70字以内，示例：中国移动手机上网，多种套餐超低资费，不用再省流量，想怎么玩就怎么玩。即时聊天、浏览网页、发表评论、查看地图……手机就是掌上电脑。<br/>
                                短厅使用短信：70字以内，示例：订机票、订酒店、找路线、享优惠……就打12580，帮您轻松搞定大小事。移动客户还能享受查询结果免费发送到手机，多一份备忘，多一份安心。</font></td>
            <!--  
            <tr>
                <td colspan="6">经分统计要求：&nbsp;&nbsp;<a href="javascript:include_showOffInfo('STATREQUEST')"><font color="red">填写说明</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="STATREQUEST" height="60" width="650"/></td>
            </tr>
            <tr id='STATREQUEST' style='display: none;'>
                <td colspan="6"><font color="blue"> 1、所需统计的指标、口径及取数周期<br/>
                                2、报表格式及模版<br/>
                                3、实现的时间要求</font></td>
            </tr>
            <tr>
                <td colspan="6">财务和业务稽核方案(<font color="red">请参照模版填写</font>)&nbsp;&nbsp;<a href="javascript:include_showOffInfo('BUSINESSCHECKPLAN')"><font color="red">填写说明</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="BUSINESSCHECKPLAN" height="70" width="650"/></td>
            </tr>
            <tr id='BUSINESSCHECKPLAN' style='display: none;'>
                <td colspan="6"><font color="blue"> 1、 稽核负责单位/部门；<br/>
                                2、 稽核周期：每日、每旬、每月；<br/>
                                3、 稽核数据的来源：现有稽核系统或分公司支撑中心自行提取等；<br/>
                                4、 稽核的方法：常规稽核，或给出异常情况的条件规则，提取数据后核查；<br/>
                                5、 稽核操作手册：若是全省已有的稽核手段则可以简要说明；若是新的稽核内容，则需提供详尽说明材料。</font></td>
            </tr>
            -->
            <tr>
                <td colspan="6">特殊情况说明：&nbsp;&nbsp;<a href="javascript:include_showOffInfo('SPECIALNOTE')"><font color="red">填写说明</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="SPECIALNOTE" height="100" width="650"/></td>
            </tr>
            <tr id='SPECIALNOTE' style='display: none;'>
                <td colspan="6"><font color="blue"> 1、 若需身份证件/密码办理，则要说明非实名制/无密码客户是否可以参与，如何参与；<br/>
                                2、 对于带保底要求的营销案，若参与的客户停机保号，需明确保底是否继续收取；<br/>
                                3、 营销案的办理权限管理，如只限自办厅、只限市公司特定部门、只限指定工号等；<br/>
                                4、 明确营销案客户是否可以重复参加；<br/>
                                5、 明确参与营销案的客户，能否再办理分合户、过户、等付费账户发生变化的业务；<br/>
                                6、 明确可参与营销案的客户其付费方式的要求，如仅限现金客户；<br/>
                                7、 明确已合户客户的参与原则，即一个账户下多个用户，每个用户(号码)是否可以分别参与营销案；</font></td>
            </tr>
        </table>
    </ai:dbform>
</ai:contractframe>
<script type="text/javascript">
function _include_fromSaleMainExplanFormRowSet(){
    return g_FormRowSetManager.get("saleMainExplanForm");
}

function include_refreshSaleMainExplanForm(mainId) {
    _include_fromSaleMainExplanFormRowSet().refresh("&id=" + mainId);
}

function include_showOffInfo(obj)
{
    if (document.getElementById(obj).style.display == "none")
    {
        document.getElementById(obj).style.display = "block";
    } else {
        document.getElementById(obj).style.display = "none";
    }
}

function downTemplate(id) {
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AttachAction?action=downLoadFile&idList='+id;
    window.location.href = strUrl;
}
</script>