/**
���ܣ���ʾ������,�����еĺ����������Զ��رս�����.
���÷�ʽ��
	beginAIWaitBanner(funcObj,msg);
����˵��: 
	funcObj:һ��function�������string�ַ���;
	msg:�ڽ���������ʾ����������;
���������:
	��jsv2/AppFrameCss.jsp�ж���,����Ϊ: AIAPPFRAME_WAIT_MAIN_CSS;

����ʾ��:
	1������string�ַ���,Ҫ�����еĺ����������������߲���Ϊ��������ȫ�ֱ�����
		beginAIWaitBanner("run_process()","��ȴ�....");  
		beginAIWaitBanner("run_process('����1','����2')" , "��ȴ�....");
		beginAIWaitBanner("run_process(para1,para2)" , "��ȴ�....");//Ҫ��para1��para2����Ϊȫ�ֱ���
	
	2�����еĺ��������������Ҳ���Ϊ�ֲ���������ʱ������ʱ����һ��function��Ȼ�����
	��ʱfunction���ݸ���������
		
		�ӽ�����ǰ��function save(){
					var arr = new Array(); //�ֲ�����,��������
					arr[0]='1';
					arr[1]='2';
					//.... 
					
					run_process(arr);	//׼���ӽ������ĺ��������ֲ�����Ϊ������
					
					//�������д��뽫������������
					//beginAIWaitBanner("run_process(arr)","��ȴ�....");  
				 }
				 
		�ӽ�������function save(){
					 var arr = new Array(); //�ֲ�����,��������
					 arr[0]='1';
					 arr[1]='2';
					 //....
					
					 //��׼���ӽ������ĺ�����һ��function��װ��Ȼ�󴫵ݸ�������
					 var f_fun = function(){	
					 	 run_process(arr);	
					 }
					
					 //�����������������
					 beginAIWaitBanner("f_run","��ȴ�...."); 
				  }
*/

var global_tmp_funtion =null;

function beginAIWaitBanner(funcObj,msg){
	//���funObjΪfunction����,��ֱ�Ӹ�ֵ
	if(typeof(funcObj)=='function'){
		global_tmp_funtion = funcObj;
	}
	//���funcObjΪstring����,�򹹽�һ��function����
	else if(typeof(funcObj)=='string'){
		global_tmp_funtion = function(){
			eval(funcObj);
		}
	}
	else{
	  //���������봫��һ��Function�������һ���ַ���
		alert(g_I18NMessage("appframe_core","waitbanner_param_err"));
		return;
	}
	
	if(document.getElementById("AIAPPFRAME_WAIT_DIV")==null){
		var divObj = document.createElement("div");
		document.body.appendChild(divObj);
		divObj.style.visibility = "visible";
		
		divObj.id = "AIAPPFRAME_WAIT_DIV";
		divObj.className = "AIAPPFRAME_WAIT_MAIN_CSS";
		divObj.innerHTML="<table width=\"100%\" height=\"100%\" border=0><tr><td align=\"center\" valign=\"middle\"><TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 class=\"AIAPPFRAME_WAIT_DIV_CSS\"><TR><td width=20></td><td width=60 height=80 align=center><span  class=\"AIAPPFRAME_WAIT_LOAD_CSS\"></span></td><td id=\"AIAPPFRAME_WAIT_DIV_CONTENT\">"+g_I18NMessage("appframe_core","waitbanner_wait")+"</td></tr></table></td></tr></table>";
	}
	else{
		document.getElementById("AIAPPFRAME_WAIT_DIV").style.visibility = "visible";
	}
	
	if(msg!=null && msg!=""){
		document.getElementById("AIAPPFRAME_WAIT_DIV_CONTENT").innerText = msg;
	}
	
	window.setTimeout("global_tmp_funtion();endAIWaitBanner();",10);
}

function endAIWaitBanner(){
	if(document.getElementById("AIAPPFRAME_WAIT_DIV")!=null){
		document.getElementById("AIAPPFRAME_WAIT_DIV").style.visibility  = "hidden";
	}
}
