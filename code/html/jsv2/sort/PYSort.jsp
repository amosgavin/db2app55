<%@ page contentType="text/html; charset=GBK"%>
//���ļ��ṩƴ������


//����GB2312����ƴ�������ŵ㣺��������JAVA��̨���ٶȿ�
//ȱ�㣺���ܶԲ���GB2312�еĺ��ֽ�������
function sortByGB2312(a, b){
    for (var i=0; i<a.length; i++){
      var codeA = private_getGB2312AscCode(a.charAt(i))
      var codeB = private_getGB2312AscCode(b.charAt(i))

      if(codeA>codeB) return 1;
      else if(codeA< codeB) return -1;
    }
    return 0
}

//����GBKȫ�ַ������������ŵ㣺�ܶ����еĺ���ƴ����������
//ȱ�㣺�Բ���GB2312 ��Χ�ڵĺ�����Ҫ����JAVA��̨���ٶ���΢����
function sortByGBK(a,b){
      for (var i=0; i<a.length; i++){
      var codeA = private_getAllHzAscCode(a.charAt(i))
      var codeB = private_getAllHzAscCode(b.charAt(i))
      
      if(codeA>codeB) return 1;
      else if(codeA < codeB) return -1;
    }
    return 0
}

//��ȡ���к��ֵ�ƴ����GB2312 �е�λ��
function private_getAllHzAscCode(char){
   if (char.charCodeAt(0) == null || char=='') return ""
    var code = char.charCodeAt(0);
    if(code < 1328 ) return code;
    
    try{
	    //����vbscript��ȡascii��
	    var ascCode = vbasc(char)
	    ascCode = eval("0x"+ascCode)
	  }catch(e){
	  	return char;
	  }
    
    try{
	    if(ascCode <55292){
	    	return ascCode;
	    } else {
	    	ascCode = private_getGBKCode(char);
	    }
	  }catch(e){
	  	return ascCode;
	  }
    
    return ascCode;
}

//��ȡһ�����ֵı��룬����ú�����GB2312��Χ�ڣ���ֱ�ӷ��ظñ��룬
//����ú��ֲ���GB2312��Χ�ڣ����Ȼ�ȡ�ú��ֵ�ƴ����Ȼ�����ƴ��
//��ȡ��ƴ����GB2312 �����е�λ��
var GBKArray = new Array();
function private_getGBKCode(char){
	//�ӻ���������Ѱ��
    var tmp = GBKArray[char];
    if(tmp != null ) return tmp;
    //���ú�̨��ȡ�ú��ֵı���
    var path = "<%=request.getContextPath()%>";
    path = path + "/business/com.ai.appframe2.util.GetGBKCodeAction?action=getGBKCodeInGB2312&url_source=XMLHTTP&hz=" + char;
    
    var XMLSender=null;
		if (typeof ActiveXObject != "undefined"){   
			XMLSender=new ActiveXObject("Microsoft.XMLHTTP");   
		}
		else if (window.XMLHttpRequest) {                        
			XMLSender=new XMLHttpRequest();
		} 
    XMLSender.Open("POST",path,false);

    XMLSender.setRequestHeader("Content-Type","multipart/form-data");

    XMLSender.send('');
    var result =  XMLSender.responseText;

    
    //���û�в鵽���������������ascii code ����
    if(result ==''){
      result = ascCode;
    }
    //����̨��ѯ����ŵ�JS����
    GBKArray[char] = result;
    return result;  
}

//��ȡһ�����ֵĴ�ASC��
function private_getGB2312AscCode(char){
    if (char.charCodeAt(0) == null || char=='') return ""
    var code = char.charCodeAt(0);
    if(code < 1328 ) return code;
    
    //����vbscript��ȡascii��
    try{
    	var ascCode = vbasc(char)
    	ascCode = eval("0x"+ascCode)
    	return ascCode;
    }catch(e){
    	return char;
    }
  }
  
  

//����lv��nv ��λ�ã��������˸о����岻�����ԾͲ���������
function private_adjustCode(code){
	if(code == null || code =="") return code;
	
	if(code==50606) code=50613;
	else if(code>=50607 && code<50610) code = code -1;
	else if(code>=49855 && code<49869 )code = 49896 -(49869-code);
	else if(code>=49869 && code<49896)code = code -(49869-49855);
	
	return code;
}
  