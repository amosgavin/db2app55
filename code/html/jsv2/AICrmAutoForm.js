
function AICrmAutoFormDbLink(pDBFormPk,pFieldName,val,text,para)
{
    //��ѯ�Ƿ���ȡ�����ĺ���
    //����еĻ�����ȡ������
    var param="";
    try{
      eval("param = getOpenWinFieldParam_" + pFieldName +"('"+pFieldName+"');");
    }catch(e){
      param="";
    }
   if(para!=null && !g_StringTrim(para)==""){
      var paraArray = para.split("|||");
      if(paraArray!=null && paraArray.length>=2)
      {
//	alert(paraArray[0]);
//	alert(paraArray[1]);
//	alert(_gModuleName);

	//����ֱ�ӵ���
	var url = _gModuleName + paraArray[0];
	if (param!=null&&param!=""&&param!="undefined"){
	  url+=param;
	}
	return window.showModalDialog(url,window,paraArray[1]);
      }
      else
      {
	alert("[AICrmAutoFormDbLink]"+g_I18NMessage("appframe_core","autoform_param_err")+" param="+para);
	return null;
      }
   }
}
