<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>营销资源使用情况</title>
		<style type="text/css">
       .father{
		    border:1px solid#111111;
		    padding:25px;
		       }
		.son1{
    		padding: 15px;
			background-color: #12F048;
			border: 0px dashed #1F0606;
			position: absolute;
			font-family: 黑体，幼圆;
			font-size: 12px;
			left: 20px;
			top: 90px;
			width: 2px;
			height: 60px;
			word-wrap: break-word;
    		}
    	 .son2{
    		padding: 15px;
			background-color: #12F048;
			border: 0px dashed #1F0606;
			position: absolute;
			font-family: 黑体，幼圆;
			font-size: 12px;
			left: 20px;
			top: 250px;
			width: 2px;
			height: 60px;
			word-wrap: break-word;
    		}
		</style>
		<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
		<script language="javascript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js" type="text/javascript"></script>
	</head>
  	<body onload="initPage();">
  	<div id="used_div">
	    <ai:contractframe id="saleResAllotTFrame" contenttype="table" title="各地市营销资源使用（%）" width="75%" allowcontract="false" frameclosed="false">
		    <ai:contractitem/>
		    <ai:table
		        tableid="saleResUsedTable" 
		        setname="com.asiainfo.sale.activity.web.SETSaleResourceUsed"
		        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleResourceSV"
		        implservice_querymethod="selectResourceUsed(String cityId)"
		        initial="false"  multiselect="false"
		        pagesize="17" editable="false" width="110%" 
		        height="470" needrefresh="true" footdisplay="none">
		        <ai:col fieldname="CITY_NAME" width="100" />
		        <ai:col fieldname="P_TERM_USED" width="110" />
		        <ai:col fieldname="L_TERM_USED" width="110" />
		        <ai:col fieldname="P_DISC_USED" width="110" />
		        <ai:col fieldname="L_DISC_USED" width="110" />
<%--		        <ai:col fieldname="P_POINTS_USED" width="110" />--%>
<%--		        <ai:col fieldname="L_POINTS_USED" width="110" />--%>
		        <ai:col fieldname="P_JF_USED" width="110" />
		        <ai:col fieldname="L_JF_USED" width="110" />
		        <ai:col fieldname="P_FJF_USED" width="110" />
		        <ai:col fieldname="L_FJF_USED" width="110" />
		        <ai:col fieldname="P_PROMT_USED" width="110" />
		        <ai:col fieldname="L_PROMT_USED" width="110" />
		    </ai:table> 
		</ai:contractframe>
	</div>
	<div class="father">
	<div class="son1">省级资源池</div>
	<div class="son2">地市资源池</div>
	<div id="main" style="height:400px"; width:1000px; float:right;></div>
	</div>
  	</body>
  	<ai:loginuser/>
  	<script type="text/javascript">
  	document.getElementById("used_div").style.display="none";
  	var saleResUsedTable = g_TableRowSetManager.get("saleResUsedTable");
  	var org = g_GetUserInfo().ORG_ID.substr(0,2);
  	var city='';
  	switch(org){
  		case '10':city='省公司';break;
  		case '15':city='恩施';break;
  		case '13':city='鄂州';break;
  		case '25':city='黄冈';break;
  		case '12':city='黄石';break;
  		case '18':city='省公司';break;
  		case '23':city='荆门';break;
  		case '20':city='荆州';break;
  		case '27':city='潜江';break;
  		case '16':city='十堰';break;
  		case '24':city='随州';break;
  		case '28':city='天门';break;
  		case '11':city='武汉';break;
  		case '17':city='襄樊';break;
  		case '26':city='孝感';break;
  		case '19':city='咸宁';break;
  		case '14':city='宜昌';break;
  		default:city='';
  		}
  	saleResUsedTable.refresh("&cityId="+org);
  	function initPage() {
  		document.getElementById("used_div").style.display="none";
  	}
  	</script>
  	<script src="./echarts-all.js"></script>
  	 <script type="text/javascript">
        // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('main')); 
        var P_TERM_USED=saleResUsedTable.getValue(0,"P_TERM_USED");
        var L_TERM_USED=saleResUsedTable.getValue(0,"L_TERM_USED");
        var P_DISC_USED=saleResUsedTable.getValue(0,"P_DISC_USED");
        var L_DISC_USED=saleResUsedTable.getValue(0,"L_DISC_USED");
        var P_JF_USED=saleResUsedTable.getValue(0,"P_JF_USED");
        var L_JF_USED=saleResUsedTable.getValue(0,"L_JF_USED");
        var P_FJF_USED=saleResUsedTable.getValue(0,"P_FJF_USED");
        var L_FJF_USED=saleResUsedTable.getValue(0,"L_FJF_USED");
        var P_PROMT_USED=saleResUsedTable.getValue(0,"P_PROMT_USED");
        var L_PROMT_USED=saleResUsedTable.getValue(0,"L_PROMT_USED");
        var labelTop = {
    normal : {
        label : {
            show : true,
            position : 'center',
            formatter : '{b}',
            textStyle: {
                baseline : 'bottom'
            }
        },
        labelLine : {
            show : false
        }
    }
};
var labelFromatter = {
    normal : {
        label : {
            formatter : function (params){
                return 100 - params.value + '%'
            },
            textStyle: {
                baseline : 'top'
            }
        }
    }
};
var labelBottom = {
    normal : {
        color: '#ccc',
        label : {
            show : true,
            position : 'center'
        },
        labelLine : {
            show : false
        }
    },
    emphasis: {
        color: 'rgba(0,0,0,0)'
    }
};
var radius = [40, 55];
option = {
    legend: {
        x : 'center',
        y : 'center',
        data:[
<%--            'GoogleMaps','Facebook','Youtube','Google+','Weixin',--%>
<%--            'Twitter', 'Skype', 'Messenger', 'Whatsapp', 'Instagram'--%>
        ]
    },
    title : {
        text: city+'营销资源使用',
        //subtext: 'from global web index',
        x: 'center'
    },
    /*toolbox: {
        show : true,
        feature : {
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true, 
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        width: '20%',
                        height: '30%',
                        itemStyle : {
                            normal : {
                                label : {
                                    formatter : function (params){
                                        return 'other\n' + params.value + '%\n'
                                    },
                                    textStyle: {
                                        baseline : 'middle'
                                    }
                                }
                            },
                        } 
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },*/
    series : [
        {
            type : 'pie',
            center : ['10%', '30%'],
            radius : radius,
            x: '0%', // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:100-P_TERM_USED, itemStyle : labelBottom},
                {name:'终端-省', value:P_TERM_USED,itemStyle : labelTop}
            ]
        },
        {
            type : 'pie',
            center : ['30%', '30%'],
            radius : radius,
            x:'40%', // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:100-P_DISC_USED, itemStyle : labelBottom},
                {name:'折扣-省', value:P_DISC_USED,itemStyle : labelTop}
            ]
        },
        {
            type : 'pie',
            center : ['50%', '30%'],
            radius : radius,
            y: '55%',   // for funnel
            x: '0%',    // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:100-P_JF_USED, itemStyle : labelBottom},
                {name:'积分-省', value:P_JF_USED,itemStyle : labelTop}
            ]
        },
        {
            type : 'pie',
            center : ['70%', '30%'],
            radius : radius,
            y: '55%',   // for funnel
            x: '0%',    // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:100-P_FJF_USED, itemStyle : labelBottom},
                {name:'非积分-省', value:P_FJF_USED,itemStyle : labelTop}
            ]
        },
        {
            type : 'pie',
            center : ['90%', '30%'],
            radius : radius,
            y: '55%',   // for funnel
            x:'40%', // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:100-P_PROMT_USED, itemStyle : labelBottom},
                {name:'促销费-省', value:P_PROMT_USED,itemStyle : labelTop}
            ]
        },
        {
            type : 'pie',
            center : ['10%', '70%'],
            radius : radius,
            x:'20%', // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:100-L_TERM_USED, itemStyle : labelBottom},
                {name:'终端-地市', value:L_TERM_USED,itemStyle : labelTop}
            ]
        },
        {
            type : 'pie',
            center : ['30%', '70%'],
            radius : radius,
            x:'60%', // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:100-L_DISC_USED, itemStyle : labelBottom},
                {name:'折扣-地市', value:L_DISC_USED,itemStyle : labelTop}
            ]
        },
        {
            type : 'pie',
            center : ['50%', '70%'],
            radius : radius,
            y: '55%',   // for funnel
            x:'20%',    // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:100-L_JF_USED, itemStyle : labelBottom},
                {name:'积分-地市', value:L_JF_USED,itemStyle : labelTop}
            ]
        },
        {
            type : 'pie',
            center : ['70%', '70%'],
            radius : radius,
            y: '55%',   // for funnel
            x:'20%',    // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:100-L_FJF_USED, itemStyle : labelBottom},
                {name:'非积分-地市', value:L_FJF_USED,itemStyle : labelTop}
            ]
        },
        {
            type : 'pie',
            center : ['90%', '70%'],
            radius : radius,
            y: '55%',   // for funnel
            x:'60%', // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:100-L_PROMT_USED, itemStyle : labelBottom},
                {name:'促销费-地市', value:L_PROMT_USED,itemStyle : labelTop}
            ]
        }
    ]
};
        // 为echarts对象加载数据 
        myChart.setOption(option); 
    </script>
</html>
