<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script> 
<style type="text/css"> 
input.editable{
	background: white;
	border:1px solid red;
	margin:0;
	width: 80px;
	height: 18px;
	padding:1px 3px;
	vertical-align:middle;
}

table.stats
{
	text-align: center;
	font-family: Verdana, Geneva, Arial, Helvetica, sans-serif,"华文中宋";
	font-weight: normal;
	font-size: 13px;
	color: black;
	width: 600px;
	background-color: blank;
	border: 1px;
	border-collapse: collapse;
	border-spacing: 0px;
}

</style>
</head>
  
<body> 
<ai:contractframe id="saleWeaponMainframe" contenttype="table" title="静态损益测算（存量用户转资费后不考虑业务量激发情况下的损益测算）" width="100%" height="366" allowcontract="true" frameclosed="fale">
<ai:contractitem/>
	存量转资费用户数 : <input id='_staticSum_user' type="text"></input>
	<ai:button text="统   计" id="_static_Sum" onclick="_staticSumCompute()"/>
	<ai:button text="保   存" id="_static_save" onclick="_staticSumSava()"/>
	<table border="1" borderColor="blank" id="_staticSumtable" class="stats">
		<tr>
			<th nowrap="nowrap" width=110>项目</th>
			<th nowrap="nowrap" width=80>转资费前</th>
			<th nowrap="nowrap" width=80>转资费后</th>
			<th nowrap="nowrap" width=80>变化幅度(%)</th>
			<th nowrap="nowrap" width=80>户均变化</th>
			<th nowrap="nowrap" width=120>总体变化</th>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>固定费(元)</td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>户均本地时长(分钟)</td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>户均本地收入(元)</td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>户均长途时长(分钟)</td>
			<td nowrap="nowrap" width=80 height="23px"> </td>
			<td nowrap="nowrap" width=80 height="23px"> </td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>户均长途收入(元)</td>
			<td nowrap="nowrap" width=80 height="23px"> </td>
			<td nowrap="nowrap" width=80 height="23px"> </td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>户均漫游时长(分钟)</td>
			<td nowrap="nowrap" width=80 height="23px"> </td>
			<td nowrap="nowrap" width=80 height="23px"> </td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>户均漫游收入(元)</td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>户均流量(M)</td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>户均流量收入(元)</td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>户均短信条数(条)</td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>户均短信收入(元)</td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>其他户均收入(元)</td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
		<tr>
			<td nowrap="nowrap" width=110>ARPU</td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=80 height="23px" bgColor="gray"></td>
			<td nowrap="nowrap" width=120 height="23px" bgColor="gray"></td>
		</tr>
</table>

</ai:contractframe>
</body>
<script type="text/javascript">
    function _staticSumSetToEditable(tableid){
    	
    	var grandId = _fromChargeMainDeFormRowSet.getValue("MID");
    	document.getElementById('_staticSum_user').onkeyup = function(){ 
    		var userNum = document.getElementById('_staticSum_user');
    		//限制收入数据的长度不大于 9
				if (userNum.value.toString().length > 9){
					userNum.value = (userNum.value.toString()).substr(0, 9);
				}
    		userNum.value = userNum.value.replace(/[^\d]/g,"");
	     };
        document.getElementById(tableid).onclick=_staticSumEditCell;
        var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeStaticSumAction?action=getSaveRecords&grandId="+grandId;
        var ret = PostInfo(strUrl,null);
        var savedRecords = ret.getValueByName("savedRecords");
        if (savedRecords == null || savedRecords=='') return;
        var records = savedRecords.split(";");
        var tb = document.getElementById('_staticSumtable');
        document.getElementById('_staticSum_user').value = records[0];
        for (var i = 1; i < 13; ++i){
        	tb.rows[i].cells[1].innerHTML = (records[i].split(",")[0])*100/100;
		    tb.rows[i].cells[2].innerHTML = (records[i].split(",")[1])*100/100;
        }
        _staticSumCompute();
    } 
    
    function _staticSumEditCell(event){  
	    var currentCell;  
	      
	    if(event == null){
	        currentCell = window.event.srcElement;  
	    }else{  
	        currentCell = event.target;   
	    }  
	    
	    if ( currentCell.cellIndex == 0 || currentCell.cellIndex > 2 || currentCell.parentNode.rowIndex > 12) {
	    	return;
	    }
	    
	    if(currentCell.tagName.toLowerCase() == "td"){  
	        var input = document.createElement("input");  
	        input.type = 'text';  
	        input.className = 'editable';
	        //input.setAttribute('class', 'editable');  
	        input.value = currentCell.innerHTML;  
	        input.width = currentCell.style.width;
	        input.height = currentCell.style.height;
	        
	        input.onblur = function(){  
	            currentCell.innerHTML = input.value;  
	            //currentCell.removeChild(input);  
	        };  
	        input.onkeyup = function(){ 
	        	
	        	clearNoNum(input);
	        };  
	  
	        currentCell.innerHTML = '';  
	        currentCell.appendChild(input);  
	        input.focus();
	    }     
	}  
    
	 function clearNoNum(obj){
	  //限制收入数据的长度不大于 9
		if (obj.value.toString().length > 9){
			obj.value = (obj.value.toString()).substr(0, 9);
		}
		//先把非数字的都替换掉，除了数字和.
		obj.value = obj.value.replace(/[^\d.]/g,"");
		//必须保证第一个为数字而不是.
		obj.value = obj.value.replace(/^\./g,"");
		//保证只有出现一个.而没有多个.
		obj.value = obj.value.replace(/\.{2,}/g,".");
		//保证.只出现一次，而不能出现两次以上
		obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	  }
	    
	  function _staticSumcheckInput(input){
		 alert(input);
		 var re = /^\d+[.]?\d*$/;   //判断字符串是否为数字     //判断正整数 /^[1-9]+[0-9]*]*$/  
	     if (!re.test(input))
	    {
	        alert("请输入数字(例:0.02)");
	        e.value = /^\d+/.exec(e.value);
	     }
		   return false;
	  }
  
  function _staticSumIsNumberKeyCode(keycode){
	  
	 // alert(keycode);
        if(keycode>=48&&keycode<=57)
            return true;
        else if(keycode>=96&&keycode<=105)
            return true;
        else if(keycode==8||keycode==13||keycode==9||keycode==46)
            return true;
        else if(keycode==190||keycode==110){
        	return true;
        }
        else if(keycode<=40&&keycode>=37)
            return true;
        return false;
    }
  function _staticSumCompute(){
	  
	  var tb = document.getElementById('_staticSumtable');
	  var userNum = document.getElementById('_staticSum_user').value;
	  
	  if(!userNum||userNum=='') {
		  alert('请填写存量转资费用户数');
		  return;
	  }
	  
	  if (!tb || !tb.rows[0])  return '';
	  
	  var rowsNum = tb.rows.length;
	  var colsNum = tb.rows[0].cells.length;
	  
	  for (var i = 1; i<rowsNum; i++){
	     
		 if (i != rowsNum-1){
			 
		      var val1 = tb.rows[i].cells[1].innerHTML;
		      var val2 = tb.rows[i].cells[2].innerHTML;
		      var val3 = 0;
		      var val4 = parseFloat(val2?val2:0)-parseFloat(val1?val1:0);
		      var val5 = (parseFloat(val2?val2:0)-parseFloat(val1?val1:0))*userNum;
		      if (val1!=0){
		    	  val3 = (Number(parseFloat(val2?val2:0)/parseFloat(val1?val1:0))-1)*100;
		      }
		      
		      tb.rows[i].cells[3].innerHTML = (val3.toFixed(2))*100/100;
		      tb.rows[i].cells[4].innerHTML = (val4.toFixed(2))*100/100;
		      tb.rows[i].cells[5].innerHTML = (val5.toFixed(2))*100/100;
	     } else {
	    	 for(var j=1; j<colsNum; ++j){
	    		 
	    		var arpu = parseFloat(tb.rows[1].cells[j].innerHTML?tb.rows[1].cells[j].innerHTML:0)
		    	 								+parseFloat(tb.rows[3].cells[j].innerHTML?tb.rows[3].cells[j].innerHTML:0)
		    	 							    +parseFloat(tb.rows[5].cells[j].innerHTML?tb.rows[5].cells[j].innerHTML:0)
		    	 							    +parseFloat(tb.rows[7].cells[j].innerHTML?tb.rows[7].cells[j].innerHTML:0)
		    	 							    +parseFloat(tb.rows[9].cells[j].innerHTML?tb.rows[9].cells[j].innerHTML:0)
		    	 							    +parseFloat(tb.rows[11].cells[j].innerHTML?tb.rows[11].cells[j].innerHTML:0)
		    	 							    +parseFloat(tb.rows[12].cells[j].innerHTML?tb.rows[12].cells[j].innerHTML:0);
	    	 	tb.rows[i].cells[j].innerHTML = (arpu.toFixed(2))*100/100;
	    	 }
	     }
	  }
	}
  
	function _staticSumSava(){
		
		var grandId = _fromChargeMainDeFormRowSet.getValue("MID");
		var tb = document.getElementById('_staticSumtable');
		var rowsNum = tb.rows.length;
	  	var colsNum = tb.rows[0].cells.length;
	  	if(""==grandId){
	  		alert("请先保存资费档次！");
	  		return;
	  	}
		var str = document.getElementById('_staticSum_user').value;
		if(!str||str=='') {
		  alert('请填写存量转资费用户数');
		  return;
	  	}
		str = grandId + ',' + str;
		for (var i=1; i<rowsNum-1; ++i){
			
			str += ';';
			for (var j=1; j<3; ++j){
				
				var tmp = tb.rows[i].cells[j].innerHTML;
				if (!tmp||tmp=='') tmp=0;
				if (j==2) str += ',';
				str += tmp;
			}
		}
		_staticSumCompute();
		var ud = PostInfo("<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeStaticSumAction?action=saveChargeStaticSum&sumStr="+str);
		var sunNum=tb.rows[13].cells[5].innerHTML;
		_fromChargeMainDeFormRowSet.setValue("DOOR_EARNING",sunNum);
		if ("O" != _fromChargeMainDeFormRowSet.getSts())
   	{
			saveChargeMainInclude();
		}
		if (ud.getValueByName("FLAG") == "Y") {
			alert("静态损益测算保存成功！");
		} else {
			alert("保存失败,确认输入值是否合理！");
			return;
		}
		tb.refresh();
	}
</script> 
</html>
