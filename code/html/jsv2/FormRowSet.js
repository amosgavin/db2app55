/**  
 ��
 ������ �� ����   2005/09/23

 ��ʹ�÷���������FormDemo.jsp
   FormRowSetManager ��Form���ݼ�����������ҳ���ڵ����б��������й���
      ���췽������ҳ�����ʱ�Զ�������
      ������Ա����ʹ�õķ�����
	get(pk)������Form�������ݼ���Ψһ��ʶ��ȡForm���ݼ�����
      ����������
	push(formRowSet):�������������һ��Form���ݼ���
	remove(pk)��ɾ��һ�����ݼ�����
      �÷�˵����
	������Աֻ��ʹ��get(pk)������ȡForm���ݶ���Ȼ��������ݶ������ط��������磺
	  var rowset = g_FormRowSetManager.get("staff");


   FormRowSet�� �����ݼ����
      ���췽����ͨ��AIDBFormTag�๹��HTML�ı�
      ������Ա����ʹ�÷�����
	isEditable() form�Ƿ�ɱ༭�����form��ÿһ���ֶζ����ɱ༭��return false�����򷵻�true
	isColEditable(fieldname) form��ĳ���ֶ��Ƿ�ɱ༭
	setEditSts(value)���������ñ��ı༭״̬��value = true(�ɱ༭),false(���ɱ༭)
	setColEditSts(fieldName,value)���������������еĿɱ༭���� value = true(�ɱ༭),false(���ɱ༭)
	getValue(fieldName)����ȡָ����Ԫ������ֵ
	getDisplayText(fieldName)����ȡָ����Ԫ����ʾֵ
    
    
    getFormRowSetInfo()���ص�ǰFORMROWSET�Ļ�����Ϣ����һ�����飬ÿ�������е�ֵΪÿ���ֶε�
                    Ӣ��������������״̬����ֵ����ֵ���ϵ���ʾֵ���µ���ʾֵ��������ÿ�����Ե����ƣ�
                  fieldName:Ӣ����,fieldTitle:������,fieldSts:״̬,
                  oldValue:��ֵ ,newValue:��ֵ,oldText:�ϵ���ʾֵ,newText:�µ���ʾֵ
                  ��var arr = formRowSet.getFormRowSetInfo();
                  alert(arr[0].fieldName)
	setValue(fieldName,value,Text)�������кţ�������������ֵ, value����ֵ text��ʾֵ
	toXmlString(flag)��������ת��ΪXml�ַ�����flag==true��Ĭ�ϣ�ֻ���Ķ�������ת��Ϊxml��false������������ת��Ϊxml��
	setStsToOld()������form���ݼ�״̬Ϊ��O��Ϊ������
	setStsToDel()������form���ݼ��ϵ�״̬δɾ��״̬
	setStsToNew():����form���ݼ���Ϊ������״̬�����ԭ�ֶ���ֵ�����ֶ�ΪN�����û��ֵ�����ֶ�ΪNN
	newRow()������һ�����ݣ���ʱ��״̬ΪNN,form������ȫ�������
	refresh(conditon,parameter,qryset):����������������ˢ��,����������˵����Ϣ
	refreshForObd(parameters,qryset):��ѯ��������ѯ��SET���ݼ�
	setFocus(fieldName):�����ƶ��ֶ�Ϊѡ��״̬
	getSts():���ص�ǰ����״̬��NN������״̬��N������ĳЩ�������޸ģ�U�޸�״̬��O��״̬��Dɾ��״̬
	getTitle(fieldName) ��ȡָ���е�������

	getEditType(fieldname)��ȡָ���еı༭����.���ı���������.
	getColNames() ���������ֶε����ơ���ORGAIZE_ID,REMRKS
	clearValue(pFieldName) ���ָ���ֶ�ֵ��״̬����
    getFieldSts(pFieldName) ��ȡ�ֶε�״̬,NNΪ�� ,N��ʾ�½�,O��ʾû�޸�,D��ʾɾ��,U��ʾ�޸�
    getOldValue(pFieldName)��ȡ�ֶε���ֵ
	clearListBox(fieldName):���������ѡ��
	refreshDynamicListBox(fieldName):ˢ�¶�̬��������Դ�����ݣ�ƥ��idΪ�����ı�,fieldNameΪ�ֶ����ƣ���Ϊ","�ָ�
    
    setImeModeSts(fieldName,sts);//������ر�ĳ���ֶε�����������ƣ�sts=true��ʾ������false��ʾ�ر�
    
	 ֧�ֵ��¼���
	OnValueChange �� ����˵����col,oldValue,newValue,dbformpk
	onFoucsIn:    �ֶλ�ý����¼�������FieldName  val,text
	onFoucsOut:   �ֶ�ʧȥ�����¼�������FieldName  val,text
        ondblink:���������ӻ���openwin�İ�ťʱ���ø÷���������formid��fieldname��val��text��para
        ����para������set�����õ�opName�����е�����

	����У�鷽��(Appframe3.0������ʹ���Ǳ���include CommUtil.js�ļ�)
	1.FormRowSet.isFieldNull(pFieldNames,isShowAlert)
		�ж�DBForm��ָ���ֶ��Ƿ�Ϊ�գ����Ϊ�շ���true����alert���档���򷵻�false
		 pFieldNames -- У����ֶ����ƴ���ÿ���ַ���"," �ָ�,���Ϊ�ձ�ʾȫ������У��
		 isShowAlert -- Ϊ���Ƿ񵯳�alert����
		����ֵ-true/false
       2.FormRowSet.validate(pFieldNames,isJudgeNull,isShowAlert)
		       �ֶκϷ���У�顣����set���õ��ֶ����ͣ���󳤶ȣ����ȶ��û�����������ж�����alert���棬���򷵻�false
		֧��String�����֣����㣬date��datetime�����ͣ�������set������ƥ�䡣
		 pFieldNames -- У����ֶ����ƴ���ÿ���ַ���"," �ָ�,���Ϊ�ձ�ʾȫ������У��
		 isJudgeNull -- �Ƿ�����Ƿ�Ϊ�յ��ж���������isFieldNull��������
		 isShowAlert -- Ϊ���Ƿ񵯳�alert����
       3.verfiy(fieldName) [deprecated]
          �ֶκϷ���У��,Ϊvalidate�����ļ��ݷ���������˵��ͬvalidate

***********/
  //dbform��������Ӧ��class�Ķ�Ӧ����
  var g_FormFieldstyleArray =
	{ DBEdit:"dbform_inputfield_style",
	 DBListBox:"dbform_listbox_input_style",
	 DBLable:"dbform_lable_style",
	 DBDate:"dbform_dbdate_input_style",
	 DBDateTime:"dbform_dbdate_input_style",
	 DBPassword:"dbform_password_style",
	 DBTextArea:"dbform_textarea_style",
	 DBCheckBox:"dbform_checkbox_style",
	 DBLink:"dbform_dblink_style",
	 DBOpenWin:"dbform_dbopenwin_editor_style",
	 DBSpan:"dbform_dbspan_style",
         DBHtml:"dbform_dbhtml_style",
         DBFile:"dbform_dbfile_style"
    }
  var g_FormFieldDisabledStyleArray =
	{ DBEdit:"dbform_disable_style",
	  DBListBox:"dbform_listbox_input_disable_style",
	  DBLable:"dbform_disable_style",
	  DBDate:"dbform_disable_style",
	  DBDateTime:"dbform_disable_style",
	  DBPassword:"dbform_disable_style",
	  DBTextArea:"dbform_disable_style",
	  DBCheckBox:"dbform_disable_style",
	  DBLink:"dbform_disable_style",
	  DBOpenWin:"dbform_disable_style",
	  DBFile:"dbform_disable_style"


    }




//�ؼ����Ƶ�ȫ�ֶ���
 var g_Form_DBEdit = "DBEdit";
 var g_Form_DBListBox = "DBListBox";
 var g_Form_DBLable = "DBLable";
 var g_Form_DBDate = "DBDate";
 var g_Form_DBDateTime = "DBDateTime";
 var g_Form_DBPassword = "DBPassword";
 var g_Form_DBTextArea = "DBTextArea";
 var g_Form_DBCheckBox="DBCheckBox";
 var g_Form_DBLink = "DBLink";
 var g_Form_DBSpan = "DBSpan";
 var g_Form_DBHtml = "DBHtml";
 var g_Form_DBFile ="DBFile";

  //��һ���ı�һ����ť�Ŀؼ�������Ӫҵϵͳ���Զ�����ҳ�棬��������¼���������dblink����
 var g_Form_DBOpenWin = "DBOpenWin";
 
 var g_Form_ShowMaskString = "***";


//formrowset��inital�����ȡ����
function FormRowSet_getInitErrorData(pFormId){
      if(document.all("FormRowSet_CUSTOM_ERROR_" + pFormId)==null)
      {
         return null;
      }
      else
      {
      var errorXmlNode = document.all("FormRowSet_CUSTOM_ERROR_" + pFormId).XMLDocument.childNodes(0);
      //alert(errorXmlNode);
      if(errorXmlNode==null)
      {
      return null;
      }
      else{
      return createUserDataClass(errorXmlNode,false);
      }
      }
  }

//formrowset�Ĺ�����
function FormRowSetManager(){
 this.List = new Array();
 this.push = function(formRowSet){
      this.List[formRowSet.DBFormPK] = formRowSet;
      return formRowSet.DBFormPK;
 }
 this.get = function(pk){
    var result = this.List[pk];
    if(!result){
       result = new FormRowSet(pk);
    }

    return result;
 }
 this.remove = function(pk){
   this.List[pk] = null;
 }
}
var g_FormRowSetManager = new FormRowSetManager();

function FormRowSet(aName){
  this.DBFormPK = aName;
  g_FormRowSetManager.push(this);
  this.SeqId="-1";
  this.setName="";//set������
  this.setFName="";//set��fullname
   
  this.Sts = "O";
  this.RowId = "-1";
  this.IsEditable = "true";
  this.ListDataSource = null;
  this.fieldNameArray = new Array();//ҳ����ʹ��<tag:dbformfield>˵������Ч�ֶ�����
  this.conditionName = "";
  
  this.canModifyFieldNames="";//mo�пɱ༭���ֶ����ƣ���,�ָ�
  this.showFieldNames =""; //mo�пɲ鿴���ֶΣ���,�ָ�
  
  this.OnValueChangeFunc =null;
  this.OnFocusInFunc = null;
  this.OnFocusOutFunc= null;
  this.OnKeyPressFunc= null;
  this.OnKeyDownFunc= null;
  this.OnBeforePasteFunc= null;
  this.OnDBLinkFunc= null;
  this.AfterRefreshPlugInFuncName = "g_AIAfterDBFormRefreshFunc";
  this.initial();

}

/**
 * DBForm�Ķ���ӿڷ���
 */
FormRowSet.prototype.isEditable = FormRowSet_isEditable;
FormRowSet.prototype.isColEditable = FormRowSet_isColEditable;
FormRowSet.prototype.setEditSts = FormRowSet_setEditSts;
FormRowSet.prototype.setColEditSts = FormRowSet_setColEditSts;

FormRowSet.prototype.getColNames = FormRowSet_getValidFieldNames;
FormRowSet.prototype.setValue = FormRowSet_setValue;
FormRowSet.prototype.getValue = FormRowSet_getValue;
FormRowSet.prototype.clearValue = FormRowSet_clearValue;
FormRowSet.prototype.getDisplayText = FormRowSet_getDisplayText;
FormRowSet.prototype.setFocus = FormRowSet_setFocus;
FormRowSet.prototype.getSts = FormRowSet_getSts;
FormRowSet.prototype.getTitle = FormRowSet_getTitle;
FormRowSet.prototype.getEditType = FormRowSet_getEditType;
FormRowSet.prototype.clearListBox =FormRowSet_clearListBox
FormRowSet.prototype.addListBoxElement =FormRowSet_addListBoxElement;
FormRowSet.prototype.toXmlString = FormRowSet_toXmlString;


FormRowSet.prototype.setStsToOld = FormRowSet_setStsToOld;
FormRowSet.prototype.setStsToDel = FormRowSet_setStsToDel;
FormRowSet.prototype.setStsToNew = FormRowSet_setStsToNew;

FormRowSet.prototype.newRow = FormRowSet_newRow;


FormRowSet.prototype.refresh = FormRowSet_refresh;
FormRowSet.prototype.refreshForObd = FormRowSet_refreshForObd;

FormRowSet.prototype.refreshDynamicListBox = FormRowSet_refreshDynamicListBox;
FormRowSet.prototype.refreshListBox = FormRowSet_refreshListBox;




//�����¼������ķ�������
FormRowSet.prototype.onValueChange = FormRowSet_SetOnValueChangeFunc;
FormRowSet.prototype.onFocusIn = FormRowSet_SetOnFocusInFunc;
FormRowSet.prototype.onFocusOut = FormRowSet_SetOnFocusOutFunc;
FormRowSet.prototype.onDBLink = FormRowSet_SetOnDBLinkFunc;

FormRowSet.prototype.isFieldNull = FormRowSet_isFieldNull;
FormRowSet.prototype.validate = FormRowSet_validate;
FormRowSet.prototype.verify = FormRowSet_verify;

FormRowSet.prototype.setImeModeSts = FormRowSet_setImeModeSts;
FormRowSet.prototype.removeListBoxOption = FormRowSet_removeListBoxOption;

FormRowSet.prototype.onKeyPress = FormRowSet_SetOnKeyPressFunc;
FormRowSet.prototype.onKeyDown = FormRowSet_SetOnKeyDownFunc;
FormRowSet.prototype.onBeforePaste = FormRowSet_SetOnBeforePasteFunc;

/**
 * DBFrom���ڲ�����
 */
FormRowSet.prototype.getClassName = FormRowSet_getClassName;
FormRowSet.prototype.initial = FormRowSet_initial;

FormRowSet.prototype.exeOnValueChange = FormRowSet_exeOnValueChange;
FormRowSet.prototype.exeOnFocusIn  = FormRowSet_exeOnFocusIn;
FormRowSet.prototype.exeOnFocusOut = FormRowSet_exeOnFocusOut;
FormRowSet.prototype.exeOnDBLink = FormRowSet_exeOnDBLink;
FormRowSet.prototype.getValuePrivate = FormRowSet_getValuePrivate;
FormRowSet.prototype.getFieldShowText =FormRowSet_getFieldShowText;
FormRowSet.prototype.getOldValue = FormRowSet_getOldValue;
FormRowSet.prototype.getOldDisplayText =FormRowSet_getOldDisplayText;
FormRowSet.prototype.getFieldSts =FormRowSet_getFieldSts
FormRowSet.prototype.getFormRowSetInfo =FormRowSet_getFormRowSetInfo
FormRowSet.prototype.setID = FormRowSet_setID;

FormRowSet.prototype.exeOnKeyPress = FormRowSet_exeOnKeyPress;
FormRowSet.prototype.exeOnKeyDown = FormRowSet_exeOnKeyDown;
FormRowSet.prototype.exeOnBeforePaste = FormRowSet_exeOnBeforePaste;



/***************************************************************
* �ڲ�����ʵ��
******************************************************************/


function FormRowSet_getClassName()
{
  return "FormRowSet";
}

function FormRowSet_setID(id){
  this.RowId = id;
}
function  FormRowSet_initial()
{
  var xmlNode = document.all("FormXml_" + this.DBFormPK).XMLDocument.childNodes(0);
  this.SeqId = xmlNode.attributes.getNamedItem("seqid").nodeValue;
  this.setName=xmlNode.attributes.getNamedItem("setname").nodeValue;
  this.setFName=xmlNode.attributes.getNamedItem("setfname").nodeValue;
  for(var i = 0;i < xmlNode.childNodes.length;i++)
  {
	  var tmpNode = xmlNode.childNodes(i);
      if ( tmpNode.nodeName == "HEAD")
	     this.ListDataSource = new ListDataSourceFactory(tmpNode);
      else if( tmpNode.nodeName  == "PKVALLIST")
	      {
		    if(tmpNode.childNodes(0)!=null)
		 {
		       this.RowId = tmpNode.childNodes(0).text;
		 }
		  }
	  else if( tmpNode.nodeName  == "ROWSTS")
	     {
		  this.Sts = tmpNode.text;

	 }
      else if( tmpNode.nodeName  == "EDITABLE")
	     {
		  this.IsEditable = tmpNode.text;

	 }
      else if( tmpNode.nodeName  == "CONDITIONNAME")
	     {
		  this.conditionName = tmpNode.text;

	 }
	 else if(tmpNode.nodeName == "CAN_MODIFY_COL")
	 	{
	 		this.canModifyFieldNames = tmpNode.text;
	 	}
	 else if(tmpNode.nodeName=="SHOW_COL")
	 	{
	 		this.showFieldNames = tmpNode.text;
	 	}	
	  else if(tmpNode.nodeName  == "EVENTLIST")
		  {
		   for(var j=0;j<tmpNode.childNodes.length;j++)
			 {
			    if(tmpNode.childNodes(j).nodeName == "EVENT")
				 {
				   var cNode = tmpNode.childNodes(j);
				  try
				  {
				    if(cNode.attributes.getNamedItem("NAME").nodeValue == "ONVALCHANGE")
					 {
					   eval("this.OnValueChangeFunc =" + cNode.text);
					 }
				    if(cNode.attributes.getNamedItem("NAME").nodeValue == "ONDBLINK")
					 {
					   eval("this.OnDBLinkFunc = "+cNode.text);
					 }
				    if(cNode.attributes.getNamedItem("NAME").nodeValue == "ONFOCUSIN")
					{
					   eval("this.OnFocusInFunc = "+cNode.text);
					}
				    if(cNode.attributes.getNamedItem("NAME").nodeValue == "ONFOCUSOUT")
					{
					   eval("this.OnFocusOutFunc ="+ cNode.text);
					}
				    if(cNode.attributes.getNamedItem("NAME").nodeValue == "ONKEYPRESS")
				       {
					   eval("this.OnKeyPressFunc = "+cNode.text);
				       }
				    if(cNode.attributes.getNamedItem("NAME").nodeValue == "ONKEYDOWN")
				    {
					     eval("this.OnKeyDownFunc = "+cNode.text);
				    }
				    if(cNode.attributes.getNamedItem("NAME").nodeValue == "ONBEFOREPASTE")
				    {
					     eval("this.OnBeforePasteFunc = "+cNode.text);
				    }
				  }
				  catch(e)
				  {
				    alert("[FormRowSet.initial]"+g_I18NMessage("appframe_core","form_init_err")+cNode.text);
					throw e;
				  }

				 }
			 }
	     }
  }
 
  
    var allSpanObjs = document.all.tags("SPAN");
    for(var i=0;i<allSpanObjs.length;i++)
    {
      if(allSpanObjs[i].DBFormPK && allSpanObjs[i].FieldName && allSpanObjs[i].DBFormPK==this.DBFormPK)
      {
	    this.fieldNameArray[this.fieldNameArray.length] = allSpanObjs[i].FieldName;
      }
    }
  
  




}



function FormRowSet_exeOnValueChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText)
{
  
  
  if(this.OnValueChangeFunc!=null)
    {

      //�첽ִ���û����Ƶ�onvaluechange�ķ���.
      try
	    {
	      this.OnValueChangeFunc(pFieldName,pOldVal,pNewVal,this.DBFormPK);     
	      /**
	       var runFun = function(){
	         
			   }
         window.setTimeout("runFun();runFun=null;",0);
         */

	      
	      
	      
	    }
      catch(e)
       {
	  alert("[FormRowSet.exeOnValueChange]"+g_I18NMessage("appframe_core","form_fun_err",new Array("OnValueChange"))+this.OnValueChangeFunc);
	  throw e;
       }
    }
}


function FormRowSet_exeOnFocusIn(pFieldName,pVal,pText)
{
    if(this.OnFocusInFunc!=null)
    {

      try
	{
	   this.OnFocusInFunc(pFieldName,pVal,pText);
	}
       catch(e)
       {
	  alert("[FormRowSet.exeOnFocusIn]"+g_I18NMessage("appframe_core","form_fun_err",new Array("OnFocusIn"))+this.OnFocusInFunc);
	  throw e;
       }
    }
}


function FormRowSet_exeOnFocusOut(pFieldName,pVal,pText)
{
    if(this.OnFocusOutFunc!=null)
    {

      try
	{
	  this.OnFocusOutFunc(pFieldName,pVal,pText);
	}
       catch(e)
       {
	  alert("[FormRowSet.exeOnFocusOut]"+g_I18NMessage("appframe_core","form_fun_err",new Array("OnFocusOut"))+this.OnFocusOutFunc);
	  throw e;
       }
    }
}


function FormRowSet_exeOnDBLink(pDBFormPK,pFieldName,pVal,pText,pPara)
{
  var reVal = null;
  if(this.OnDBLinkFunc!=null)
  {
    try
    {
       reVal = this.OnDBLinkFunc(pDBFormPK,pFieldName,pVal,pText,pPara);

    }
    catch(e)
    {
      alert("[FormRowSet.exeOnDBLink]"+g_I18NMessage("appframe_core","form_fun_err",new Array("OnDBLink"))+this.OnDBLinkFunc);
      throw e;
    }
  }
  return reVal;
}


function FormRowSet_exeOnKeyPress(pFieldName,pField)
{
   if(this.OnKeyPressFunc!=null)
  {
    try
    {
       this.OnKeyPressFunc(pFieldName,pField);

    }
    catch(e)
    {
      alert("[FormRowSet.exeOnKeyPress]"+g_I18NMessage("appframe_core","form_fun_err",new Array("OnKeyPress"))+this.OnKeyPressFunc+".ex:"+e);
      throw e;
    }
  }
}

function FormRowSet_exeOnKeyDown(pFieldName,pField)
{
   if(this.OnKeyDownFunc!=null)
  {
    try
    {
       this.OnKeyDownFunc(pFieldName,pField);

    }
    catch(e)
    {
      alert("[FormRowSet.exeOnKeyDown]"+g_I18NMessage("appframe_core","form_fun_err",new Array("OnKeyDown"))+this.OnKeyDownFunc+".ex:"+e);
      throw e;
    }
  }
}

function FormRowSet_exeOnBeforePaste(pFieldName)
{
   if(this.OnBeforePasteFunc!=null)
  {
    try
    {
       this.OnBeforePasteFunc(pFieldName);

    }
    catch(e)
    {
      alert("[FormRowSet.exeOnBeforePaste]"+g_I18NMessage("appframe_core","form_fun_err",new Array("OnBeforePaste"))+this.OnBeforePasteFunc+".ex:"+e);
      throw e;
    }
  }
}

function  FormRowSet_getValuePrivate(rowIndex,fieldName)
{
  return this.getValue(fieldName);
}

//�õ�ҳ��FormField��ͬ���������ʾ��ҳ����������ֵ������Ҫ����showField��mask�����ж�
function FormRowSet_getFieldShowText(pFieldName,pDisplayText)
{
	 var reVal = pDisplayText;
	 if(this.showFieldNames.length!=0 && this.showFieldNames.indexOf(pFieldName+",")<0)
	   {
	     reVal= g_Form_ShowMaskString;    
	   }
	 return reVal;    
}

function FormRowSet_getOldValue(pFieldName)
{
	var reVal="";
	var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
  if(fieldObj)
  {
  	reVal = fieldObj.OldI;
  }
  return reVal;
	
}
function FormRowSet_getOldDisplayText(pFieldName)
{
	var reVal="";
	var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
  if(fieldObj)
  {
  	reVal = fieldObj.OldT;
  }
  return reVal;
}






/***************************************************************
 *
* �ⲿ����ʵ��
 ******************************************************************/
function FormRowSet_isEditable()
{
  var fieldNames = this.getColNames();
  if(fieldNames==null)
  {
    return false;
  }
  var reFlag = false;
  for(var i=0;i<fieldNames.length;i++)
  {

    if(this.isColEditable(fieldNames[i])==true)
      {
	reFlag = true;
	break;
      }
  }
  return reFlag;
}

function FormRowSet_isColEditable(pFieldName)
{
  var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
  if(fieldObj)
  {
    if(fieldObj.IsEditable=="true")
      return true;
    else
      return false;
  }
  else
  {
      alert("[FormRowSet.isColEditable]."+g_I18NMessage("appframe_core","form_no_field")+".FieldName="+pFieldName);
      return null;
  }
}


function FormRowSet_setEditSts(pFlag)
{
   for(var i=0;i<this.fieldNameArray.length;i++)
   {
      this.setColEditSts(this.fieldNameArray[i],pFlag);
   }
}

function FormRowSet_setColEditSts(pFieldName,pFlag)
{

     var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName)

     if(fieldObj!=null && fieldObj.Action_OnSetEditable)
     {
			 /*
			 1.�жϿ��޸��ֶ��б��Ƿ�Ϊ�գ�
			   �����Ϊ�գ����б��е��ֶβſ�������Ϊ�ɱ༭�������ֶζ����ɡ�
			   ���Ϊ�գ������жϿɲ鿴�ֶ��Ƿ�Ϊ�ա�
			   ���mask�ɲ鿴�ֶβ�Ϊ�գ���ֻ�пɲ鿴���ֶο����ñ༭�ֶΣ�����mask���ֶβ��ɱ༭
			   ���mask�ɲ鿴�ֶ�Ϊ�� �����������жϡ�
			 */
			 if(pFlag)
			 {
	       /**
	       ���ֶ����ڡ��ɲ鿴�ֶΡ��У����ߡ��ɲ鿴�ֶΡ�Ϊ�ա�����һ��
	       ���ֶ����� ���ɱ༭�ֶΡ� ���� ���ɱ༭�ֶ�Ϊ�ա�
	       ��ɱ༭
	       */
	       if(this.showFieldNames.length==0 || this.showFieldNames.indexOf(fieldObj.FieldName+",")>=0)
	       {
	         if(this.canModifyFieldNames.length==0 || this.canModifyFieldNames.indexOf(fieldObj.FieldName+",")>=0)
           	{
           		fieldObj.Action_OnSetEditable(pFlag);
           	}
	       }  
			 
			 }
      else
      	{
      		fieldObj.Action_OnSetEditable(pFlag);
      	}
     }
}


function FormRowSet_getValidFieldNames()
{
  return this.fieldNameArray;
}


function FormRowSet_setValue(pFieldName,pVal,pText,isTrigerEvent)
{
   var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
   if(fieldObj)
   {
     if(pText==null || pText=="")
	       pText  = pVal;
	 if(isTrigerEvent!=null && isTrigerEvent==false)
       fieldObj.Action_SetValue(pVal,pText,false);
     else
       fieldObj.Action_SetValue(pVal,pText,true); 
   }
}

function FormRowSet_getValue(pFieldName)
{
   var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
   if(fieldObj)
   {
     return  fieldObj.Action_GetValue();

   }
   else{
      //alert("[FormRowSet.getValue]�޷��ҵ����ƶ�Ӧ���ֶζ���.FieldName="+pFieldName);
      return null;
   }
}

function FormRowSet_getDisplayText(pFieldName)
{
   var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
   if(fieldObj)
   {
      return fieldObj.Action_GetDisplayText();

   }
   else{
      //alert("[FormRowSet.getDisplayText]�޷��ҵ����ƶ�Ӧ���ֶζ���.FieldName="+pFieldName);
      return null;
   }
}

function FormRowSet_toXmlString(flag)
{
   if(flag == null) flag = true;
   var headXmlArray = new Array();
   var result = new Array();

   var oldSts = this.Sts;

   for(var i=0;i<this.fieldNameArray.length;i++){
     var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,this.fieldNameArray[i]);
     this.getValue(this.fieldNameArray[i]);
     
     if(oldSts!=this.Sts){
       break;
     }
   }

   for(var i=0;i<this.fieldNameArray.length;i++)
   {
     var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,this.fieldNameArray[i]);
     if(fieldObj)
     {
       result[result.length] = fieldObj.Action_ToXmlString(flag);
     }
   }
   if(flag){
     if(this.Sts=="O") return "";
   }
   if(FormRowSet_All_StringTrim(result.join(""))==""){
	return "";
     }
   else
     {
	     headXmlArray[headXmlArray.length] ="<RowSet Name='";
	headXmlArray[headXmlArray.length] = this.setName;
	headXmlArray[headXmlArray.length] = "' FullName='";
	headXmlArray[headXmlArray.length] = this.setFName;
	headXmlArray[headXmlArray.length] = "' ";
	headXmlArray[headXmlArray.length] = " Sts='U'>";
	headXmlArray[headXmlArray.length] = "<Row ";
	if(this.Sts=="U" || this.Sts=="D"){
		headXmlArray[headXmlArray.length] = " ID='";
		headXmlArray[headXmlArray.length] = this.RowId;
		headXmlArray[headXmlArray.length] = "' ";
	}
	headXmlArray[headXmlArray.length] = "Sts='";
	headXmlArray[headXmlArray.length] = this.Sts;
	headXmlArray[headXmlArray.length] = "'>";
	result[result.length] ="</Row>";
	result[result.length] ="</RowSet>";
	return headXmlArray.join("")+result.join("");
     }

}

function FormRowSet_setFocus(pFieldName)
{
  var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
  if(fieldObj)
  {
    if(fieldObj.IsEditable=="false")
     return;
    if(fieldObj.Action_OnFocus)
    {
      fieldObj.Action_OnFocus();

    }
    else
    {
	//hexg,û�к����������Լ�try catchֱ�ӹ���
	  try{
      	fieldObj.childNodes(0).focus();
      }catch(e){}
    }

  }

}

function FormRowSet_setStsToOld()
{
  this.Sts = "O";
  for(var i=0;i<this.fieldNameArray.length;i++)
     {
	  var selObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,this.fieldNameArray[i]);
	   if(selObj)
		{
		  selObj.Sts = "O";
		  selObj.OldI = selObj.I;
		  selObj.OldT = selObj.T;
		}
     }
}

function FormRowSet_setStsToDel()
{
  this.Sts = "D";
}
//����form���ݼ���Ϊ������״̬�����ԭ�ֶ���ֵ�����ֶ�״̬ΪN�����û��ֵ�����ֶ�״̬ΪNN��ֻ�е������ֶζ�û��ֵʱ����״̬ΪNN������ΪN
function FormRowSet_setStsToNew()
{
   var isNNFlag = true;
   for(var i=0;i<this.fieldNameArray.length;i++)
	{
		selObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,this.fieldNameArray[i]);
	  if(selObj)
		{
		  if(selObj.I!="")
		   {
			  selObj.Sts = "N";
			  selObj.OldI = "";
			  selObj.OldT = "";
			  isNNFlag = false;
		   }
		  else
		   {
			  selObj.Sts = "NN";
			  selObj.OldI = "";
			  selObj.OldT = "";

		    }

		}
      }
      if(isNNFlag)
	this.Sts = "NN";
      else
	this.Sts = "N";
}

function FormRowSet_newRow()
{
   for(var i=0;i<this.fieldNameArray.length;i++)
	{
	  selObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,this.fieldNameArray[i]);
	  if(selObj)
	  {
	     selObj.Action_SetValue("","",false);
	     selObj.Sts = "NN";
	     selObj.OldI = "";
	     selObj.OldT = "";
	  }
	}
   this.Sts = "NN";

}
function FormRowSet_getSts()
{

  return this.Sts;
}
function FormRowSet_getTitle(pFieldName)
{
   selObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
   if(selObj){
     return selObj.tt;
   }
   else
     return null;
}


function FormRowSet_getEditType(pFieldName)
{
  selObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
  if(selObj)
  {
    return selObj.EditType;
  }
  else
  {
    alert("[FormRowSet.getEditType]."+g_I18NMessage("appframe_core","form_no_field")+".FieldName="+pFieldName);
    return null;
  }
}

function FormRowSet_SetOnValueChangeFunc(pFuncName)
{

  if(pFuncName == null || FormRowSet_All_StringTrim(pFuncName)=="")
    {
      this.OnValueChangeFunc = null;
    }
    else
    {
      try
      {
	eval("this.OnValueChangeFunc ="+pFuncName);

      }
      catch(e)
      {
	alert("[FormRowSet.onValueChange]"+g_I18NMessage("appframe_core","form_no_func")+pFuncName);
	throw e;
      }

    }

}



function FormRowSet_SetOnFocusInFunc(pFuncName)
{

    if(pFuncName==null || FormRowSet_All_StringTrim(pFuncName)=="")
    {
      this.OnFocusInFunc = null;
    }
    else
    {
      try
      {
	eval("this.OnFocusInFunc ="+pFuncName);
      }
      catch(e)
      {
	alert("[FormRowSet.setOnFocusIn]"+g_I18NMessage("appframe_core","form_no_func")+pFuncName);
	throw e;
      }

    }

}

function FormRowSet_SetOnFocusOutFunc(pFuncName)
{

    if(pFuncName == null || FormRowSet_All_StringTrim(pFuncName)=="")
    {
      this.OnFocusOutFunc = null;
    }
    else
    {
      try
      {
	eval("this.OnFocusOutFunc ="+pFuncName);
      }
      catch(e)
      {
	alert("[FormRowSet.OnFocusOut]"+g_I18NMessage("appframe_core","form_no_func")+pFuncName);
	throw e;
      }

    }

}


function FormRowSet_SetOnKeyPressFunc(pFuncName)
{

    if(pFuncName==null || FormRowSet_All_StringTrim(pFuncName)=="")
    {
      this.OnKeyPressFunc = null;
    }
    else
    {
      try
      {
	eval("this.OnKeyPressFunc ="+pFuncName);
      }
      catch(e)
      {
	alert("[FormRowSet.OnKeyPress]"+g_I18NMessage("appframe_core","form_no_func")+pFuncName);
	throw e;
      }

    }

}

function FormRowSet_SetOnKeyDownFunc(pFuncName)
{

    if(pFuncName==null || FormRowSet_All_StringTrim(pFuncName)=="")
    {
      this.OnKeyDownFunc = null;
    }
    else
    {
      try
      {
	eval("this.OnKeyDownFunc ="+pFuncName);
      }
      catch(e)
      {
	alert("[FormRowSet.OnKeyDown]"+g_I18NMessage("appframe_core","form_no_func")+pFuncName);
	throw e;
      }

    }

}

function FormRowSet_SetOnBeforePasteFunc(pFuncName)
{

    if(pFuncName==null || FormRowSet_All_StringTrim(pFuncName)=="")
    {
      this.OnBeforePasteFunc = null;
    }
    else
    {
      try
      {
	eval("this.OnBeforePasteFunc ="+pFuncName);
      }
      catch(e)
      {
	alert("[FormRowSet.OnBeforePaste]"+g_I18NMessage("appframe_core","form_no_func")+pFuncName);
	throw e;
      }

    }

}

function FormRowSet_SetOnDBLinkFunc(pFuncName)
{
  if(pFuncName==null || FormRowSet_All_StringTrim(pFuncName)=="")
    {
      this.OnDBLinkFunc = null;
    }
    else
    {
      try
      {
	eval("this.OnDBLinkFunc ="+pFuncName);
      }
      catch(e)
      {
	alert("[FormRowSet.OnDBLink]"+g_I18NMessage("appframe_core","form_no_func")+pFuncName);
	throw e;
      }

    }

}

function FormRowSet_refreshListBox(pFieldName,pCondition,isTriggerEvent)
{
  if(pFieldName==null || FormRowSet_All_StringTrim(pFieldName)=="")
  {
    return;
  }
  
  if(isTriggerEvent!=null && isTriggerEvent==true){
    isTriggerEvent=true;
  }
  else{
    isTriggerEvent=false;
  }
    
  var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
  if(fieldObj && (fieldObj.EditType).toLowerCase() == g_Form_DBListBox.toLowerCase()){
     //get listsource name
     var ls=fieldObj.ls;
     var oldLsObj = this.ListDataSource.find(ls);
     if(oldLsObj!=null && oldLsObj.ListDataSourceType){
       if(oldLsObj.ListDataSourceType=="Static"){
          var lsFName=fieldObj.lsf;
          //
          var tUrl =_gModuleName +  "/dbformrefresh?action=refreshlist&pk="+this.SeqId+"&F_SETNAME="+this.setFName+"&F_FIELDNAME="+pFieldName
                   +"&F_DSID="+fieldObj.lsf;
          if (pCondition && FormRowSet_All_StringTrim(pCondition)!=""){
            tUrl+="&F_ISCOND=y&"+pCondition;
          }
          else{
            tUrl+="&F_ISCOND=n";
          }
         
          var sRe=PostInfotoServer(tUrl,'');
          var xml = g_GetXMLDocument();
          xml.loadXML(sRe);
          var newLsObj=new ListDataSourceStatic(null,xml.documentElement);
          if(newLsObj){
            newLsObj.setName(oldLsObj.getName());
            this.ListDataSource.replace(newLsObj);
            if(fieldObj.Action_SetValue){
               fieldObj.Action_SetValue(fieldObj.Action_GetValue(),"",false);
            }
          }  
       
       }
       else{
         var tmpEditor = FormRowSet_Field_DBListBox_getEditor(this,pFieldName,curVal,curText);
         if(tmpEditor.selectedIndex!=null && tmpEditor.selectedIndex==0 && curVal != tmpEditor.getID() && isTriggerEvent)
         {
	       fieldObj.Action_SetValue(tmpEditor.getID(),tmpEditor.getValue(),true);
         }
         else
         {
	       fieldObj.Action_SetValue(tmpEditor.getID(),tmpEditor.getValue(),false);
         }
       }
       
       
     }
     
  }
}


function FormRowSet_refreshDynamicListBox(pFieldNames)
{
  if(pFieldNames==null || FormRowSet_All_StringTrim(pFieldNames)=="")
  {
    return;
  }
  var fieldNameArray = pFieldNames.split(",");
  for(var i=0;i<fieldNameArray.length;i++)
  {
     var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,fieldNameArray[i]);

     if(fieldObj && (fieldObj.EditType).toLowerCase() == g_Form_DBListBox.toLowerCase())
     {
       var curVal = fieldObj.Action_GetValue();
       var curText = fieldObj.Action_GetDisplayText();
       var tmpEditor = FormRowSet_Field_DBListBox_getEditor(this,fieldNameArray[i],curVal,curText);
       if(tmpEditor.selectedIndex!=null && tmpEditor.selectedIndex==0 && curVal != tmpEditor.getID())
       {
	 fieldObj.Action_SetValue(tmpEditor.getID(),tmpEditor.getValue(),true);

       }
       else
       {
	fieldObj.Action_SetValue(tmpEditor.getID(),tmpEditor.getValue(),false);
       }
     }
  }
}

function FormRowSet_refresh(whereCon,parameters,qryset,isShowErrorAlert)
{
	if(whereCon==null)whereCon="";
	if(parameters==null)parameters="";
  var reFlag = "-1";//Ĭ�Ϸ��أ����Ϊ"0",���سɹ���"-1"Ϊȱʡrefreshʧ�ܷ���ֵ
  var pk = this.SeqId;
  var aCondition = whereCon;
  if(this.conditionName!=null && this.conditionName!="")
	{
	  aCondition = this.conditionName+"="+g_ConditonStrEncode(aCondition);
	}
  var tUrl =_gModuleName +  "/dbformrefresh?action=refresh&pk="+pk+"&"+aCondition;
  if(parameters)
    tUrl = tUrl + "&" + parameters;

  var tmpstr = "";
  if(qryset!=null){
      tmpstr  = "<RootInfo>"
      if(qryset != null)
	 tmpstr = tmpstr + qryset.toXmlString(false);
      tmpstr = tmpstr   + "</RootInfo>";

   }
   tmpstr = document.all("DBFormTagInfo_" + this.DBFormPK ).value+tmpstr;
   var sRe=PostInfotoServer(tUrl,tmpstr);
   var xml = new ActiveXObject("Msxml.DOMDocument");
   xml.async = false;
   xml.loadXML(sRe);
   var xmlNode = xml.documentElement;
   if(xmlNode)
	{
       var ud = createUserDataClass(xmlNode);
       if(ud.getValueByName("FLAG")=="SUCCESS")
       {
		   this.RowId=ud.getValueByName("PKVAL");
		   this.Sts = ud.getValueByName("STS");
		   if(this.Sts=="NN")
			{
			  this.newRow();
			}
		  else
			{

			  for(var i=0;i<this.fieldNameArray.length;i++)
			     {
				  var spanObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,this.fieldNameArray[i]);
				  if(spanObj)
				     {

					var newVal = ud.getValueByName(this.fieldNameArray[i]);
					 var newText = ud.getValueByName(this.fieldNameArray[i]+"_AIDISPLAY_VAL");

					if(newVal==null) newVal = "";
					if(newText==null) newText = newVal;
					this.clearValue(this.fieldNameArray[i]);

				  	spanObj.Action_SetValue(newVal,newText,false);

				    }
			    }
			  this.setStsToOld();
			  this.Sts = ud.getValueByName("STS");
			}
	  reFlag=null;

	}
       else if(ud.getValueByName("FLAG")=="ERROR_USER")
	{

            reFlag=ud;
	}
       else{
           if(isShowErrorAlert!=false)
           {
             var msg = ud.getValueByName("MESSAGE");
             alert(g_I18NMessage("appframe_core","form_refresh_err")+msg);
           }
	   reFlag=ud;
	}

       //���ò������������в����������ִ�в�����������ķ���������Ϊƽ̨����ʱ������Ӧ�ô���ĸı��������ӵģ�ƽ��ʹ��ʱ�����ǣ�
       if(this.AfterRefreshPlugInFuncName!=null && this.AfterRefreshPlugInFuncName!="")
       {
	  var afterRefreshFuncObj = null;
	  try
	  {
		  eval("afterRefreshFuncObj="+this.AfterRefreshPlugInFuncName);
	  }
	  catch(e)
	  {
		      afterRefreshFuncObj =null;
	  }
	  if(afterRefreshFuncObj!=null)
	  {
	    afterRefreshFuncObj(this,reFlag);
	  }
       }

       return reFlag;



    }
}
function FormRowSet_refreshForObd(parameters,qryset,isShowErrorAlert)
{
   return this.refresh(null,parameters,qryset,isShowErrorAlert);
}

//��ĳ��ָ���ֶε�ֵȫ�����
function FormRowSet_clearValue(pFieldName)
{
  var spanObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
  if(spanObj)
  {
	spanObj.Action_SetValue("","",false);
	spanObj.I = "";
	spanObj.T = "";
	spanObj.OldI = "";
	spanObj.OldT = "";
	spanObj.OldValue=null;

  }
}

/**
 �ж�DBForm��ָ���ֶ��Ƿ�Ϊ�գ����Ϊ�շ���true����alert���档���򷵻�false
 pFieldNames -- У����ֶ����ƴ���ÿ���ַ���"," �ָ�,���Ϊ�ձ�ʾȫ������У��
 isShowAlert -- Ϊ���Ƿ�alert����
*/
function FormRowSet_isFieldNull(pFieldNames,isShowAlert)
{

  if(isShowAlert==null) isShowAlert = true;
  var flag = false;

  var fieldArray = this.getColNames();

  if(pFieldNames!=null && g_StringTrim(pFieldNames)!="")
  {
    fieldArray = pFieldNames.split(",");
  }

  for(var i=0;i<fieldArray.length ;i++)
  {
    var fieldValue = this.getValue(fieldArray[i]);
    if(fieldValue==null || g_StringTrim(fieldValue)=="")
    {
       if(isShowAlert)
       {
	  var fieldTitle = this.getTitle(fieldArray[i]);
	  alert(g_I18NMessage("appframe_core","form_cannot_null",new Array(fieldTitle)));
       }
       flag = true;
       break;
    }
  }
  return flag;

}

//��ȡ�ֶε�״̬ NNΪ�� ,N��ʾ�½�,O��ʾû�޸�,D��ʾɾ��,U��ʾ�޸�
function FormRowSet_getFieldSts(pFieldName)
{
  var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
 
  var OldId = fieldObj.OldI;
  var NewId = fieldObj.Action_GetValue();

  //���޸�״̬ʱ�������ǰ��ֵ��Ȼ���Ϊ"",�������ֶ�״̬ΪD״̬��
  if(fieldObj.Sts=="U")
  {
    if(OldId && !NewId) fieldObj.Sts = "D";
  }
  else if(fieldObj.Sts=="D"){
    if(OldId!=null && NewId!=null && NewId!='') fieldObj.Sts = "U";
  }

  return fieldObj.Sts;
}

//���ص�ǰFORMROWSET�Ļ�����Ϣ������ÿ���ֶε�Ӣ��������������״̬����ֵ����ֵ���ϵ���ʾֵ���µ���ʾֵ
//fieldName:Ӣ����,fieldTitle:������,fieldSts:״̬,
//        oldValue:��ֵ ,newValue:��ֵ,oldText:�ϵ���ʾֵ,newText:�µ���ʾֵ
function FormRowSet_getFormRowSetInfo(){
  var formRowSetInfo = new Array();
  var fieldArray = this.getColNames();
 
  for(var i=0;i<fieldArray.length ;i++)
  {
    var fieldValue = this.getValue(fieldArray[i]);
    var fieldTitle = this.getTitle(fieldArray[i]);
    
    var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,fieldArray[i]);
    var OldId = fieldObj.OldI;
    var OldText = fieldObj.OldT;
    var NewId = fieldObj.Action_GetValue();
    var NewText = fieldObj.Action_GetDisplayText();

    //���޸�״̬ʱ�������ǰ��ֵ��Ȼ���Ϊ"",�������ֶ�״̬ΪD״̬��
    if(fieldObj.Sts=="U")
    {
      if(OldId && !NewId) fieldObj.Sts = "D";
    }
    else if(fieldObj.Sts=="D"){
      if(OldId!=null && NewId!=null && NewId!='') fieldObj.Sts = "U";
    }
  
    var info={fieldName:fieldArray[i],fieldTitle:fieldTitle,fieldSts:fieldObj.Sts,
        oldValue:OldId ,newValue:NewId,oldText:OldText,newText:NewText};
    formRowSetInfo[formRowSetInfo.length] = info;
  }
  
  return formRowSetInfo;
}
function FormRowSet_validate(pFieldNames,isJudgeNull,isShowAlert)
{
  if(isShowAlert==null) isShowAlert = true;
  
  var fieldArray = this.getColNames();
  if(pFieldNames!=null && g_StringTrim(pFieldNames)!="")
  {
    fieldArray = pFieldNames.split(",");
  }

  for(var i=0;i<fieldArray.length ;i++){
     var fieldValue = this.getValue(fieldArray[i]);  
     var fieldTitle = this.getTitle(fieldArray[i]);  
     
     if(((FormRowSet_All_getFieldSpanObj(this.DBFormPK,fieldArray[i]).isn=="N"  || isJudgeNull==true) && (fieldValue==null ||  g_StringTrim(fieldValue)=="")) 
     	 )
     {
     	
       if(isShowAlert)
       {

	       alert(g_I18NMessage("appframe_core","form_cannot_null",new Array(fieldTitle)));
         this.setFocus(fieldArray[i]);
       }
      return false;
    }
     //����ֶοɿ�,����У�鲻��Ҫ�� 
    if(fieldValue==null ||  g_StringTrim(fieldValue)==""){
      continue;
    }
    var dataType = FormRowSet_All_getFieldSpanObj(this.DBFormPK,fieldArray[i]).da;
    var maxLen = FormRowSet_All_getFieldSpanObj(this.DBFormPK,fieldArray[i]).ml;
    var decimal = FormRowSet_All_getFieldSpanObj(this.DBFormPK,fieldArray[i]).dec;
    if(FormRowSet_All_isValidate(fieldValue,fieldTitle,dataType,maxLen,decimal,isShowAlert)==false)
    {

      return false;
    }
  }
  return true;

}

function FormRowSet_All_isValidate(pVal,pTitle,pDataType,pMaxLen,pDecimal,pIsShowAlert)
{

  if(pDecimal==null ||  g_StringTrim(pMaxLen)=="")  pDecimal=0;
  var reVal = true;
  var maxLen = -1;
  if(pMaxLen!=null &&  g_StringTrim(pMaxLen)!="" && parseInt(pMaxLen)!=NaN)
  {
    maxLen = parseInt(pMaxLen);
  }
  if(pDataType == "Float" || pDataType=="Double")
  {
    if(maxLen!=-1 && g_GetStrLen(pVal)>maxLen)
    {
      reVal = false;
      if(pIsShowAlert)
      {
	alert(g_I18NMessage("appframe_core","form_illegal_1",new Array(pTitle,pMaxLen+"")));
      }
    }
    if(reVal==true && g_IsFloat(pVal,pDecimal)==false)
    {
      reVal = false;
      if(pIsShowAlert)
      {
	alert(g_I18NMessage("appframe_core","form_illegal_2",new Array(pTitle,pDecimal+"")));
      }
    }
    //���ڴ����ȵ�С����������λ�� ���ܳ���(maxLen-pDecimal) hexg ,2006-11-28
    var tmp = "" +parseInt(pVal);
    if(tmp.length>(maxLen-pDecimal)){
      alert(g_I18NMessage("appframe_core","form_illegal_3",new Array(pTitle,(maxLen-pDecimal)+"")));
      reVal = false;
    }
    
  }
  else if(pDataType == "String")
  {
   // alert(g_GetStrLen(pVal));
    if(maxLen!=-1 && g_GetStrLen(pVal)>maxLen)
    {
      reVal = false;
      if(pIsShowAlert)
      {
	alert(g_I18NMessage("appframe_core","form_illegal_4",new Array(pTitle,pMaxLen+"")));
      }
    }
  }
  else if(pDataType == "Integer" || pDataType=="Long"  || pDataType=="Short" || pDataType=="int")
  {
    if(g_IsDigit(pVal)==false)
    {
      reVal = false;
      if(pIsShowAlert)
      {
	alert(g_I18NMessage("appframe_core","form_illegal_5",new Array(pTitle)));
      }
    }
    if(reVal==true && maxLen!=-1 && g_GetStrLen(pVal)>maxLen)
    {
      reVal = false;
      if(pIsShowAlert)
      {
	alert(g_I18NMessage("appframe_core","form_illegal_6",new Array(pTitle,pMaxLen+"")));
      }
    }
  }
  else if(pDataType == "Date" )
  {
     if(g_IsDate(pVal)==false)
    {
      reVal = false;
      if(pIsShowAlert)
      {
	alert(g_I18NMessage("appframe_core","form_illegal_7",new Array(pTitle)));
      }
    }
  }
  else if(pDataType=="DateTime")
  {
    if(g_IsDateTime(pVal)==false)
    {
      reVal = false;
      if(pIsShowAlert)
      {
	alert(g_I18NMessage("appframe_core","form_illegal_8",new Array(pTitle)));
      }
    }
  }

  else if(pDataType == "PostCode")
  {
    if(g_IsPostalCode(pVal)==false)
    {
      reVal = false;
      if(pIsShowAlert)
      {
	alert(g_I18NMessage("appframe_core","form_illegal_9",new Array(pTitle)));
      }
    }
  }
  
  return reVal;

}

function FormRowSet_verify(pFieldName)
{
  return this.validate(pFieldName,true,true);
}
function FormRowSet_addListBoxElement(pFieldName,value,text)
{
	var listDataSourceName = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName).ls;
    var source = this.ListDataSource.find(listDataSourceName);
    if(source!=null){
    	source.addOption(value,text);
    }
}
function FormRowSet_clearListBox(pFieldName)
{
  var listDataSourceName = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName).ls;
  var source = this.ListDataSource.find(listDataSourceName);

  if(source!=null)
     source.clear();
  var spanObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);

  if(spanObj)
  {
     spanObj.Action_SetValue("","",false);
  }
}

//---add by zhouQiqi----2008-08-29---
//---delete option by id--------------------
function FormRowSet_removeListBoxOption(pFieldName,id)
{
  var listDataSourceName = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName).ls;
  var source = this.ListDataSource.find(listDataSourceName);

  if(source!=null)
     source.removeOption(id);
  var spanObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,pFieldName);
  if(spanObj)
  {
     spanObj.Action_SetValue("","",false);
  }
}
















/**********************************************************************************
*���пؼ���ͳһʹ�õķ���
*
*
**********************************************************************************/
function FormRowSet_Span_OnFocusIn(spanObj)
{

  if(spanObj)
  {
     if(spanObj.isFieldInital == "false")
     {
       FormRowSet_AllField_initial(spanObj);

     }

    if(spanObj.IsEditable=="false")
      return;


    var fromObj = window.event.fromElement;
    //���fromElement��span�ĺ��Ӷ��󣬲��㽹��õ�
    for(var i=0;i<spanObj.childNodes.length;i++)
    {

      if(fromObj == spanObj.childNodes(i))
	{
	  FormRowSet_All_CancelBubble();
	  return false;
	}
    }

    if(spanObj.Action_OnFocus)
    {
      spanObj.Action_OnFocus();
    }
    //����༭״̬.
    spanObj.isEditing=true;

    var dbFormObj = g_FormRowSetManager.get(spanObj.DBFormPK);
    dbFormObj.exeOnFocusIn(spanObj.FieldName,spanObj.I,spanObj.T);



  }


}

function FormRowSet_Span_OnFocusOut(spanObj)
{

  if(spanObj && spanObj.DBFormPK)
  {
    if(spanObj.IsEditable == "false")
      return;
    var targetObj = null;
    if(window.event)
      targetObj = window.event.toElement;
    if(targetObj==null)
       return;
    for(var i=0;i<spanObj.childNodes.length;i++)
    {

    if(targetObj == spanObj.childNodes(i)  || targetObj.parentNode == spanObj.childNodes(i))
    {
      return;
    }
   }
   if(spanObj.Action_OnBlur)
    {
	spanObj.Action_OnBlur(spanObj);
    }
   //����༭״̬.
   spanObj.isEditing=false;
   var dbFormObj = g_FormRowSetManager.get(spanObj.DBFormPK);
   dbFormObj.exeOnFocusOut(spanObj.FieldName,spanObj.I,spanObj.T);

  }


}


function FormRowSet_AllField_initial(obj)
{
   var spanObj =obj
   if(spanObj && spanObj.DBFormPK && spanObj.EditType && 
   		(spanObj.isFieldInital).toLowerCase()=="false")
   {
   	 var tmp_span_editType = spanObj.EditType.toLowerCase();
   	 
     eval("spanObj.Action_GetValue=FormRowSet_AllField_GetValue");
     eval("spanObj.Action_GetDisplayText=FormRowSet_AllField_GetDisplayText");
     eval("spanObj.Action_ToXmlString=FormRowSet_AllField_toXmlString");
    
     

     if(tmp_span_editType == g_Form_DBListBox.toLowerCase())
     {
       eval("spanObj.Action_OnFocus=FormRowSet_Field_DBListBox_OnFocus");
       eval("spanObj.Action_OnSetEditable= FormRowSet_Field_DBListBox_OnSetEditable");

       eval("spanObj.Action_SetValue=FormRowSet_Field_DBListBox_SetValue");
       eval("spanObj.Action_OnBlur=FormRowSet_Field_DBListBox_onBlur");
       eval("spanObj.Action_SetTips=FormRowSet_AllField_SetDisplayTextAsTitle");


     }
     else if(tmp_span_editType == g_Form_DBEdit.toLowerCase() )
     {
	 eval("spanObj.Action_OnSetEditable= FormRowSet_AllField_OnSetEditable");
	 eval("spanObj.Action_SetValue=FormRowSet_AllField_SetValue");
	 eval("spanObj.Action_OnBlur=FormRowSet_AllField_OnBlur");
	 eval("spanObj.Action_SetTips=FormRowSet_AllField_SetValueAsTitle");
     }
     else if(tmp_span_editType == g_Form_DBPassword.toLowerCase())
     {
	eval("spanObj.Action_OnSetEditable= FormRowSet_AllField_OnSetEditable");
	eval("spanObj.Action_SetValue=FormRowSet_AllField_SetValue");
	eval("spanObj.Action_OnBlur=FormRowSet_AllField_OnBlur");
     }
     else if(tmp_span_editType == g_Form_DBLable.toLowerCase())
     {
	 eval("spanObj.Action_SetValue=FormRowSet_AllField_ShowText_SetValue");
	 eval("spanObj.Action_SetTips=FormRowSet_AllField_SetDisplayTextAsTitle");
     }

     else if(tmp_span_editType == g_Form_DBLink.toLowerCase())
     {
	eval("spanObj.Action_SetValue=FormRowSet_Field_DBLink_SetValue");
     }

     else if(tmp_span_editType == g_Form_DBCheckBox.toLowerCase())
     {
	eval("spanObj.Action_OnSetEditable= FormRowSet_Field_DBCheckBox_OnSetEditable");
	eval("spanObj.Action_SetValue=FormRowSet_Field_DBCheckBox_OnSetValue");


     }
     else if(tmp_span_editType == g_Form_DBDate.toLowerCase() 
     	|| tmp_span_editType == g_Form_DBDateTime.toLowerCase())
     {
     //hexg 
	eval("spanObj.Action_OnSetEditable= FormRowSet_Field_DBDate_OnSetEditable");
	eval("spanObj.Action_SetValue=FormRowSet_AllField_SetValue");
	eval("spanObj.Action_OnBlur=FormRowSet_DateTimeField_OnBlur");
	eval("spanObj.Action_GetValue=FormRowSet_DATE_GetValue");
     }
     else if(tmp_span_editType == g_Form_DBTextArea.toLowerCase())
     {
       eval("spanObj.Action_OnSetEditable= FormRowSet_AllField_OnSetEditable");
       eval("spanObj.Action_SetValue=FormRowSet_Field_DBTextArea_SetValue");
       eval("spanObj.Action_OnBlur=FormRowSet_AllField_OnBlur");
       eval("spanObj.Action_GetDisplayText=FormRowSet_Field_DBTextArea_GetDisplayText");
       eval("spanObj.Action_GetValue=FormRowSet_Field_DBTextArea_GetValue");


     }
     else if(tmp_span_editType == g_Form_DBOpenWin.toLowerCase())
     {
       eval("spanObj.Action_SetValue=FormRowSet_AllField_ShowText_SetValue");
       eval("spanObj.Action_OnSetEditable= FormRowSet_Field_DBOpenWin_OnSetEditable");
     }
     else if(tmp_span_editType == g_Form_DBSpan.toLowerCase())
     {
	 eval("spanObj.Action_SetValue=FormRowSet_Field_DBSpan_SetValue");
	 eval("spanObj.Action_SetTips=FormRowSet_AllField_SetDisplayTextAsTitle");
     }
     else if(tmp_span_editType == g_Form_DBHtml.toLowerCase())
     {
        eval("spanObj.Action_SetValue=FormRowSet_Field_DBHtml_SetValue");
     }
     else if(tmp_span_editType == g_Form_DBFile.toLowerCase())
     {
       eval("spanObj.Action_SetValue=FormRowSet_Field_DBLink_SetValue");
     }

     spanObj.isFieldInital ="true";

   }

}

//hexg 20060607
//���Ӷ����ں�ʱ����ʧȥ�����ʱ����ж�
function FormRowSet_DateTimeField_OnBlur(spanObj){
	if(spanObj && spanObj.DBFormPK && spanObj.EditType)
	{	
		var bValid = false;
		var value = spanObj.childNodes(0).value;
		
		//�������Ϊ�գ�Ĭ��Ϊ�Ϸ�ֵ
		if(value==''){
			bValid = true;
		}else{
			if((spanObj.EditType).toLowerCase() == g_Form_DBDate.toLowerCase()) {
				bValid = g_IsDate(value);
				if(!bValid){
					alert("'" +value +"'" + g_I18NMessage("appframe_core","form_illegal_10"));
				}
			}
			else if((spanObj.EditType).toLowerCase() == g_Form_DBDateTime.toLowerCase()){
				bValid = g_IsDateTime(value);
				if(!bValid){
					alert("'" +value +"'" + g_I18NMessage("appframe_core","form_illegal_11"));
				}
			}
		}
		
		if(bValid){
			spanObj.Action_SetValue(spanObj.childNodes(0).value,spanObj.childNodes(0).value,true);
		}else{
			spanObj.Action_SetValue('','',true);
	    }
	}
}

function FormRowSet_All_getFieldSpanObj(pDBFormPK,pFieldName)
{
  var obj =  document.all("FormRowSet_"+pDBFormPK+"_"+pFieldName.toUpperCase());
  if(obj && obj.isFieldInital)
  {
    if(obj.isFieldInital=="false")
      FormRowSet_AllField_initial(obj);
  }
  return obj;
}

function FormRowSet_All_getStyleName(pEditType,pFlag)
{
  var name = null;
  if(pFlag == true)
  {
     name = g_FormFieldstyleArray[pEditType];
     if(name==null)
     {
       alert("[FormRowSet_All_getStyleName]"+g_I18NMessage("appframe_core","form_no_css",new Array("class"))+pEditType);
     }
  }
  else
  {
     name =  g_FormFieldDisabledStyleArray[pEditType];
     if(name==null)
     {
       alert("[FormRowSet_All_getStyleName]"+g_I18NMessage("appframe_core","form_no_css",new Array("disbled class"))+pEditType);
     }

  }
  return name;
}

//�������ڿ��getvalue�����ٶ����ڵĺϷ��Խ���У��
function FormRowSet_DATE_GetValue()
{
 	if(this && this.isEditing && this.DBFormPK && this.EditType)
	{	
		var value = this.childNodes(0).value;
		this.Action_SetValue(this.childNodes(0).value,this.childNodes(0).value,true);
	}
  return this.I;
}

function FormRowSet_AllField_GetValue()
{
  if(this.isEditing && this.Action_OnBlur)
    {
      this.Action_OnBlur(this);
    }
  return this.I;
}
function FormRowSet_AllField_GetDisplayText()
{
  if(this.isEditing && this.Action_OnBlur)
    {
	this.Action_OnBlur(this);
    }
  return this.T;
}


function FormRowSet_AllField_SetValue(pVal,pDisplayText,pIsCreateEvent)
{
  var dbFormObj = g_FormRowSetManager.get(this.DBFormPK);
  if(pDisplayText==null)pDisplayText = pVal;
  
  this.childNodes(0).value = dbFormObj.getFieldShowText(this.FieldName,pDisplayText);
  FormRowSet_AllField_Private_SetValue(this,pVal,pDisplayText,pIsCreateEvent);

}
function FormRowSet_AllField_ShowText_SetValue(pVal,pDisplayText,pIsCreateEvent)
{
  var dbFormObj = g_FormRowSetManager.get(this.DBFormPK);
  this.childNodes(0).value =dbFormObj.getFieldShowText(this.FieldName,pDisplayText);
  FormRowSet_AllField_Private_SetValue(this,pVal,pDisplayText,pIsCreateEvent);


}


function FormRowSet_AllField_Private_SetValue(pSpanObj,pVal,pDisplayText,pIsCreateEvent)
{

  if(pIsCreateEvent==null) pIsCreateEvent = false;
  if(pDisplayText == null) pDisplayText = pVal;
  var isDiff = false;
  var oldVal="";
  var oldText="";
  if(pSpanObj.oldVal==null)
    pSpanObj.oldVal=pSpanObj.I;

  if(pSpanObj.oldVal!=pVal)
  {
    isDiff = true;
    oldVal = pSpanObj.oldVal==null?"":pSpanObj.oldVal;
    oldText= pSpanObj.oldText;
  }


  pSpanObj.oldVal =pVal;
  pSpanObj.oldText = pDisplayText;
  pSpanObj.I = ""+pVal;
  pSpanObj.T = pDisplayText;
  //�޸�sts

  if(pSpanObj.OldI!=pSpanObj.I)
  {

    if(pSpanObj.Sts == "O")
      {
       pSpanObj.Sts = "U";
      }
     else if(pSpanObj.Sts == "NN" || pSpanObj.Sts=="N")
      {
       pSpanObj.Sts = "N";
      }
  }
  if(pSpanObj.Action_SetTips)
  {
    pSpanObj.Action_SetTips();
  }
  var dbFormObj = g_FormRowSetManager.get(pSpanObj.DBFormPK);

  

  if(pIsCreateEvent!=null && pIsCreateEvent==true && isDiff)
  {
    if(dbFormObj.Sts =="O")
    {
      dbFormObj.Sts = "U";
    }
    if(dbFormObj.Sts =="NN" || dbFormObj.Sts=="N")
    {
      dbFormObj.Sts ="N";
    }
    dbFormObj.exeOnValueChange(pSpanObj.FieldName,oldVal,oldText,pSpanObj.I,pSpanObj.T);
  }

}




function FormRowSet_AllField_OnBlur(spanObj)
{
  //var spanObj = srcObj.parentElement;
  if(spanObj && spanObj.DBFormPK && spanObj.EditType)
  {
    spanObj.Action_SetValue(spanObj.childNodes(0).value,spanObj.childNodes(0).value,true);
  }
}

function FormRowSet_AllField_OnSetEditable(pFlag)
{
  FormRowSet_AllField_Private_OnSetEditable(this,pFlag)
}

function FormRowSet_AllField_Private_OnSetEditable(pSpanObj,pFlag)
{

  if(pSpanObj.onfocusout)
     pSpanObj.onfocusout();

  var styleName = FormRowSet_All_getStyleName(pSpanObj.EditType,pFlag);
  if(pFlag == true)
    {
      pSpanObj.childNodes(0).readOnly = false;
      pSpanObj.childNodes(0).className =styleName;
      pSpanObj.IsEditable = "true";
    }
  else
    {
      pSpanObj.childNodes(0).readOnly = true;

      pSpanObj.childNodes(0).className =styleName;
      pSpanObj.IsEditable = "false";
    }

}

function FormRowSet_AllField_toXmlString(pFlag)
{

	var reValArray = new Array();
	if(this.Sts=="NN")
		return "";
    
	//���������޸Ĺ�����
	if(this.Sts=="N")
     {
	  //������������ݣ��������Ķ��������Ķ���value����Ϊ""������Ϊ��NN,�������xml��
	  if(this.I==null || this.I==""){
		return "";
	  }
     }
     var OldId = this.OldI;
     var OldText = this.OldT;
     //��ֹNewId�����ֵ�ʱ�򣬲���Ϊ0ʱ�������⣬����ǰͷ������
     var NewId = ""+this.Action_GetValue();
     var NewText = ""+this.Action_GetDisplayText();
     
     if(OldId == OldText)
		OldText = "";
     if(NewId == NewText)
       NewText = "";

     if (this.Sts =="O")
	{

	  if(pFlag)
	  {
	    if (OldId)
	      reValArray[reValArray.length] = (" OldID='" + FormRowSet_All_CheckAndTrans(OldId) + "' ");
	    if (OldText)
	      reValArray[reValArray.length] = (" OldText ='" + FormRowSet_All_CheckAndTrans(OldText) +"' ");
	  }
	  else
	  {
	    if(OldId!=null && OldText!=null)
	    {

		reValArray[reValArray.length] = (" OldID='" + FormRowSet_All_CheckAndTrans(OldId) + "' ");
		reValArray[reValArray.length] = ("OldText ='" + FormRowSet_All_CheckAndTrans(OldText) +"' ");
	    }

	  }
	if(FormRowSet_All_StringTrim(reValArray.join(""))!="")
	{
	  reValArray[reValArray.length]=">";
	}



	}
    //����״̬ʱ������U,D,N(����)
    else
	{

	  //���޸�״̬ʱ�������ǰ��ֵ��Ȼ���Ϊ"",�������ֶ�״̬ΪD״̬��
	  if(this.Sts=="U")
	  {
      
	  	if((OldId!=null && OldId!='') && (NewId==null || NewId=='')){
         this.Sts = "D";
        }
	  }
	  //hexg ,20060923�������´���
	  else if(this.Sts=="D"){
	  	if(OldId!=null && NewId!=null && NewId!='') this.Sts = "U";
	  }
	  
	  if (OldId)
	       reValArray[reValArray.length] = (" OldID='" + FormRowSet_All_CheckAndTrans(OldId) + "'");
	  if (OldText)
	       reValArray[reValArray.length] = (" OldText ='" + FormRowSet_All_CheckAndTrans(OldText) +"' ");
	  if(this.Sts == "U")
	  {
	    if(NewId!=null)
	    reValArray[reValArray.length] = ( " ID ='" + FormRowSet_All_CheckAndTrans(NewId) +"' ");
	  }
	 else
	 {
	   if(NewId)
	      reValArray[reValArray.length] = ( " ID ='" + FormRowSet_All_CheckAndTrans(NewId) +"' ");
	 }




	 if (NewText){
	    NewText = FormRowSet_All_CheckAndTrans(NewText);
	    if(NewText.replace(" ","").length ==0){
	       reValArray[reValArray.length] = " NewText=\"" + NewText + "\">";
	    }else
	       reValArray[reValArray.length] =(">"+ FormRowSet_All_CheckAndTrans(NewText));
	  }
	else
	 {
	   if(FormRowSet_All_StringTrim(reValArray.join(""))!="")
	    {
	     reValArray[reValArray.length]=">";
	    }
	 }





	}

     if(FormRowSet_All_StringTrim(reValArray.join(""))!="")
     {
       return "<Col Name='"+this.FieldName + "' Sts= '"+this.Sts+"' "+reValArray.join("")+"</Col>";
     }
     else
     {
	return "";
     }



}

function  FormRowSet_All_StringTrim(str){
  return str.replace(/(^\s*)|(\s*$)/g, "");
}



//���������ַ��滻
function FormRowSet_All_TransStr(str)
  {

    if(str=="")return str;
    strArray=str.split("&");
    tmpStr=strArray[0];
    if(strArray.length>1)
	for(i=1;i<strArray.length;i++)
    {
      tmpStr+="&amp;";
      tmpStr+=strArray[i];
    }
    str=tmpStr;
    while(str.indexOf(">")>=0)
    {
      index=str.indexOf(">");
      str=str.substring(0,index)+"&gt;"+str.substring(index+1,str.length);
    }
    while(str.indexOf("<")>=0)
    {
      index=str.indexOf("<");
      str=str.substring(0,index)+"&lt;"+str.substring(index+1,str.length);
    }
    while(str.indexOf("'")>=0)
    {
      index=str.indexOf("'");
      str=str.substring(0,index)+"&apos;"+str.substring(index+1,str.length);
    }
    while(str.indexOf('"')>=0)
    {
      index=str.indexOf('"');
      str=str.substring(0,index)+"&quot;"+str.substring(index+1,str.length);
    }
    return str;
  }
function FormRowSet_All_CheckAndTrans(str){
   str = str.toString();
   if(FormRowSet_All_CheckStr(str))
     return FormRowSet_All_TransStr(str);
   else
     return str;

}
function FormRowSet_All_CheckStr(str)
  {

    if(str.indexOf("&")>=0||str.indexOf(">")>=0||str.indexOf("<")>=0||str.indexOf("'")>=0||str.indexOf('"')>=0)
      return true;
    else
      return false;
  }
function FormRowSet_All_CancelBubble()
{

     window.event.returnValue = false;
     window.event.cancelBubble=true;

}


function FormRowSet_AllField_getCursorPosition(pUIObj)
{
  var qswh="@#%#^&#*$";
  //pUIObj.focus();
  rng=document.selection.createRange();
  rng.text=qswh;
  var pos=pUIObj.value.indexOf(qswh);
  rng.moveStart("character", -qswh.length);
  rng.text="";
  //window.status = pos;
  return pos;
}

function FormRowSet_AllField_OnKeyPress(pUIObj)
{
	if(pUIObj && pUIObj.parentNode.DBFormPK)
  {
    var dbFormPk = pUIObj.parentNode.DBFormPK;
    var fieldName = pUIObj.parentNode.FieldName;
    var dbFormObj = g_FormRowSetManager.get(dbFormPk);
    dbFormObj.exeOnKeyPress(fieldName,pUIObj);
  }
}

function FormRowSet_AllField_OnKeyDown(pUIObj)
{
	if(pUIObj.caretRange==null)
	{
	   pUIObj.caretRange =document.selection.createRange(); 
	}
	if(pUIObj && pUIObj.parentNode.DBFormPK)
  {
    var dbFormPk = pUIObj.parentNode.DBFormPK;
    var fieldName = pUIObj.parentNode.FieldName;
    var dbFormObj = g_FormRowSetManager.get(dbFormPk);
    dbFormObj.exeOnKeyDown(fieldName,pUIObj);
  }
}
//�ֶι��õ�keyup�¼�����
function FormRowSet_AllField_OnKeyUp(pUIObj)
{
  if(pUIObj.readOnly || pUIObj.disabled){
    return;
  }
  if(pUIObj && pUIObj.parentNode.DBFormPK)
  {
    var dbFormPk = pUIObj.parentNode.DBFormPK;
    var fieldName = pUIObj.parentNode.FieldName;
    var dataType = pUIObj.parentNode.da;
    var maxLen = pUIObj.parentNode.ml;

    var changePosFlag = false;
    if(pUIObj.caretRange!=null)
    {
      	var inputText =  pUIObj.caretRange.text; 
      	
        var bFilter =false;
        
      	if(dataType == "Integer" || dataType=="Long" || dataType=="Short" || dataType=="int")
        {
          var tmp = inputText;
          inputText = inputText.replace(/[^\d\-]/g,'');
          if(inputText != tmp){
            bFilter =true;
          }
        }
        //������float����
       if(dataType == "Float" || dataType=="Double"){
          var tmp = inputText;
          inputText = inputText.replace(/[^(\d ,\.\-)]/g,'');
          if(inputText != tmp){
            bFilter =true;
          }
        }
        
        if(dataType=="PostCode")
        {
          var tmp = inputText;
          maxLen = 6;
          inputText = inputText.replace(/[^\d]/g,'');
          if(inputText != tmp){
            bFilter =true;
          }
        }
        //�������Ƶ�ʱ����
        if((g_GetStrLen(pUIObj.value)-maxLen)>0)
        {
			var valid_len = g_GetStrLen(inputText) - (g_GetStrLen(pUIObj.value)-maxLen);
			
            if(valid_len==0){
				pUIObj.caretRange.text='';
			}
			else{
				pUIObj.caretRange.text = g_getSubStrInByte(inputText,valid_len);	
			}
		}
        //���û�г�����������,���������ֵ�����˵�,����Ӧһ��
        else if(bFilter){
            pUIObj.caretRange.text = inputText;
        }
     
      
    }
    pUIObj.caretRange = null;
  }

}


//�ֶι��õ�onbeforepatst����
function FormRowSet_AllField_OnBeforePaste(pUIObj)
{
  if(pUIObj && pUIObj.parentNode.DBFormPK && clipboardData.getData('text')!=null)
  {
    var dbFormPk = pUIObj.parentNode.DBFormPK;
    var fieldName = pUIObj.parentNode.FieldName;
    var dataType = pUIObj.parentNode.da;
    var maxLen = pUIObj.parentNode.ml;
    
    var dbFormObj = g_FormRowSetManager.get(dbFormPk);
    dbFormObj.exeOnBeforePaste(fieldName);
           
    if(dataType == "Integer" || dataType=="Long" || dataType=="Short" || dataType=="int")
    {
      clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''));
    }
    if(dataType=="PostCode")
    {
      maxLen = 6;
      clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''));
    }
    
    if(g_GetStrLen(pUIObj.value)-maxLen)
    {
      var valid_len = g_GetStrLen(document.selection.createRange().text) - (g_GetStrLen(pUIObj.value)-maxLen);
      var pastedata = g_getSubStrInByte(clipboardData.getData('text'),valid_len);
		
        
		if(pastedata==''){
			window.event.returnValue=false
		}else{
            if(clipboardData.getData('text').length>pastedata.length){
	          alert(g_I18NMessage("appframe_core","form_copy_err"));
	        }
			clipboardData.setData('text',pastedata);
		}
	 }
  }

}


//���ÿؼ���valueֵΪtitle����
function FormRowSet_AllField_SetValueAsTitle()
{
  var newTitle = this.I;
  this.childNodes(0).title = newTitle;
}
//���ÿؼ���displayTextΪtitle����
function FormRowSet_AllField_SetDisplayTextAsTitle()
{
   var newTitle = this.T;
   this.childNodes(0).title = newTitle;
}






/**********************************************************************************/











/****************DBListBox**********************************************************/



function FormRowSet_Field_DBListBox_OnFocus()
{
    if(this.editor!=null) {
   		return;
   	}
   	
    var dbFormObj = g_FormRowSetManager.get(this.DBFormPK);
    var tmpWidth = this.childNodes(0).style.pixelWidth;
    var tmpHeight = this.childNodes(0).style.pixelHeight;
    
    this.editor = FormRowSet_Field_DBListBox_getEditor(dbFormObj,this.FieldName,this.I,this.T);
    
    if(this.listOptionEditable =='true'){
    	this.childNodes(0).readOnly = false;
    	this.childNodes(0).onfocusout = null;
    	
    	this.editor.setRect(tmpWidth,(tmpHeight));
    	var newSpanObject = document.createElement("span");
    	
		newSpanObject.style.cssText="overflow:hidden;display:inline";
	    newSpanObject.style.width=20;
	    newSpanObject.appendChild(this.editor);
	    this.appendChild(newSpanObject);
	    
	   
	    
	    this.childSpan = newSpanObject;
	    
	    this.childNodes(0).style.width = tmpWidth-newSpanObject.style.pixelWidth;
	    this.editor.style.marginLeft = this.childNodes(0).offsetLeft - newSpanObject.offsetLeft;
	    
	    if(this.I == null || this.I ==''){
	    	if(this.editor.selectedIndex !=null  && this.editor.selectedIndex==0 && this.I!= this.editor.getID()){
     			this.Action_SetValue(this.editor.getID(),this.editor.getValue(),false);
    		}
	    }
	    else{
		    var options  =this.editor.options;
		  	var isSelfOption = true;
		  	for(i=0;i<options.length;i++){
		  		if(options[i].value == this.I){
		  			isSelfOption = false;
		  			break;
		  		}
		  	}
		  	
		  	if(isSelfOption == true){
		  		options[options.length] = new Option(this.I , this.I,true,true);
		  	}
	  	}
    }else{
    	this.childNodes(0).style.display="none";
    	this.appendChild(this.editor);
    	this.editor.setRect(tmpWidth,(tmpHeight));
    	
  		if(this.editor.selectedIndex !=null  && this.editor.selectedIndex==0 && this.I!= this.editor.getID())
   		{
     		this.Action_SetValue(this.editor.getID(),this.editor.getValue(),false);
    	}
    }   
    
   
    
    //��ֹ����ҳ�治�ɼ�ʱִ����δ������,���ʧȥ����ʧ�ܣ�������ʧȥ����
    try{
    	this.editor.focus();
    }catch(e){
    	this.Action_OnBlur(this);
    }
}

function FormRowSet_Field_DBListBox_OnSetEditable(pFlag)
{
  if(this.childNodes.length==2)
  {
    this.Action_OnBlur(this);
  }
  FormRowSet_AllField_Private_OnSetEditable(this,pFlag);


}

//�����б�༭����setValue����
function FormRowSet_Field_DBListBox_Editor_SetValue(id,displayText){
   if (id || id ==0 ){
     for(var i=0;i<this.options.length;i++){
       if(this.options[i].value == id || (!this.options[i].value) && this.options[i].text ==id){
	 this.options[i].selected = true;
	 return;
       }
     }
   }
   else if(this.options.length>=1){
	 this.selectedIndex = 0;
      }
   else
	{
	  this.selectedIndex = -1;
	}
}
function FormRowSet_Field_DBListBox_Editor_getID(){
      if(this.selectedIndex<0) return "";
	    var selectOption = this.options(this.selectedIndex);
	if((selectOption) &&(selectOption.value))
	    return selectOption.value;
	 return "";

}
 function FormRowSet_Field_DBListBox_Editor_setRect(pWidth,pHeight)
{
  if(pWidth && parseInt(pWidth,10)>0)
     this.style.pixelWidth=pWidth;
  if(pHeight && parseInt(pHeight,10)>0)
     this.style.pixelHeight = pHeight;

}
function FormRowSet_Field_DBListBox_Editor_getValue(){
      if(this.selectedIndex<0) return "";
	  var selectOption = this.options(this.selectedIndex);
      if (selectOption)
	return selectOption.text
      else
	return "";
}



function FormRowSet_Field_DBListBox_getEditor(pDBFormObj,pFieldName,pVal,pText)
{
   var dispAttr = FormRowSet_All_getFieldSpanObj(pDBFormObj.DBFormPK,pFieldName).lsdis;
   var ls = FormRowSet_All_getFieldSpanObj(pDBFormObj.DBFormPK,pFieldName).ls;
   var UIObject = document.createElement("select");
   UIObject.UIType ="DBListBox";
   UIObject.setValue=FormRowSet_Field_DBListBox_Editor_SetValue;
   UIObject.getID = FormRowSet_Field_DBListBox_Editor_getID;
   UIObject.getValue = FormRowSet_Field_DBListBox_Editor_getValue;
   UIObject.setRect = FormRowSet_Field_DBListBox_Editor_setRect;
  
   var listsource = pDBFormObj.ListDataSource.find(ls);
   if(listsource){
      listsource.fillListBox(pDBFormObj,0,UIObject,dispAttr,pVal);
   }
   UIObject.setValue(pVal,pText);
   UIObject.className ="dbform_listbox_list_style";
   UIObject.onchange = FormRowSet_Field_DBListBox_ListBoxOnChange;
   return UIObject;
  
}

function FormRowSet_Field_DBListBox_onBlur(spanObj)
{	
  var textObject = spanObj.childNodes(0);
  if(this.editor!=null && spanObj.listOptionEditable =='true' ){
  	var options  =this.editor.options;
  	var isSelfOption = true;
  	for(i=0;i<options.length;i++){
  		if(options[i].text == textObject.value){
  			isSelfOption = false;
  			break;
  		}
  	}
  	
  	if(isSelfOption == true){
  		options[options.length] = new Option(textObject.value , textObject.value,true,true);
  	}
  }
  
  if(spanObj.childNodes.length==2 && this.editor!=null)
  {
     var newText = spanObj.editor.getValue();
     var newVal =  spanObj.editor.getID();
     if(newText=="") newText = newVal;
     spanObj.Action_SetValue(newVal,newText,true);
     spanObj.childNodes(0).style.display="inline";
     
     if(spanObj.childSpan != null){
     	spanObj.childNodes(0).onfocusout=FormRowSet_All_CancelBubble;
     	spanObj.removeChild(spanObj.childSpan);
     	this.childNodes(0).style.width = this.childNodes(0).style.pixelWidth+spanObj.childSpan.style.pixelWidth
     }else if(spanObj.editor!=null){
	     spanObj.removeChild(spanObj.editor);
     }
     spanObj.editor = null;
     spanObj.childSpan = null;
  }
}

function FormRowSet_Field_DBListBox_ListBoxOnChange()
{
  var srcObj = event.srcElement;
  if(srcObj && srcObj.parentNode && typeof(srcObj.parentNode.DBFormPK) =='undefined'){
  	srcObj = srcObj.parentNode;
  }

  if(srcObj && srcObj.parentNode && srcObj.parentNode.DBFormPK)
  {
     var spanObj = srcObj.parentNode;
     var newText = spanObj.editor.getValue();
     var newVal =  spanObj.editor.getID();
     if(newText=="") newText = newVal;
     
     spanObj.Action_SetValue(newVal,newText,true);
  }
}
function FormRowSet_Field_DBListBox_SetValue(pVal,pDisplayText,pIsCreateEvent)
{
  var dbFormObj = g_FormRowSetManager.get(this.DBFormPK);
  var newText = "";
  if(dbFormObj.ListDataSource!=null || dbFormObj.ListDataSource!="")
  {
	var newText=null;
	var lsName=FormRowSet_All_getFieldSpanObj(this.DBFormPK,this.FieldName).ls;
	var lsDispName=FormRowSet_All_getFieldSpanObj(this.DBFormPK,this.FieldName).lsdis;
	if(lsName!=""){
		  var listsource = dbFormObj.ListDataSource.find(lsName);
		  if(listsource)
		     newText = listsource.findTextById(pVal,lsDispName);
		}
	//modified by hexg 20060614
	if(newText==null)
	    newText =pDisplayText;
  }
  //modify by zr 2007-2-7.��������б���ڣ�����Ҫ���������б����ʾֵ
  if(this.editor!=null){
	     this.editor.setValue(pVal,newText);
  }

  FormRowSet_AllField_Private_SetValue(this,pVal,newText,pIsCreateEvent);
  
  var dbFormObj = g_FormRowSetManager.get(this.DBFormPK);
  this.childNodes(0).value = dbFormObj.getFieldShowText(this.FieldName, this.T);

}


/*************************************************end dblistbox******************************/



/*************begin dbcheckbox**************************************************************/
function FormRowSet_Field_DBCheckBox_OnClick(checkObj)
{
  var spanObj = checkObj.parentElement;
  if(spanObj && spanObj.DBFormPK)
  {
    if(checkObj.checked)
    {
      spanObj.Action_SetValue(checkObj.CV,checkObj.CV,true);
    }
    else
    {
      spanObj.Action_SetValue(checkObj.UCV,checkObj.UCV,true);
    }
  }
}
function FormRowSet_Field_DBCheckBox_OnSetValue(pVal,pDisplayText,pIsCreateEvent)
{

  if(pVal==this.childNodes(0).CV)
  {
    this.childNodes(0).checked= true;
  }
  else{
    pVal = this.childNodes(0).UCV;
    this.childNodes(0).checked = false;
  }
  FormRowSet_AllField_Private_SetValue(this,pVal,pVal,pIsCreateEvent);
}

function FormRowSet_Field_DBCheckBox_OnSetEditable(pFlag)
{
  if(pFlag)
  {
     this.childNodes(0).disabled = false;
     this.IsEditable = "true";
  }
  else
  {
     this.childNodes(0).disabled = true;
     this.IsEditable = "false";
  }


}

/*************end dbcheckbox***************************************************************/


/*************start dbdate,dbdateTime***************************************************************/
function FormRowSet_Field_DBDate_Btn_OnClick(btnObj)
{
  var spanObj = btnObj.parentElement;
  if(spanObj && spanObj.DBFormPK)
  {
    var oldDate = spanObj.Action_GetValue();
    var showType = "date";
    if((spanObj.EditType).toLowerCase() == g_Form_DBDateTime.toLowerCase())
       showType = "datetime";
    var paramObj = {showtype:showType,definedate:oldDate};
    var dlgLeft = event.screenX;
    var dlgTop = event.screenY;
    var height = "280";
    if(showType=="datetime")
       height = "320";
    var newDate = openCalendarDlg(paramObj,"scroll:no;resizable:no;status:no;dialogLeft:"+dlgLeft+";dialogTop:"+dlgTop+";dialogHeight:"+height+"px;dialogWidth:230px");
    if(newDate && newDate != "none")
       spanObj.Action_SetValue(newDate,newDate,true);

  }
}

function FormRowSet_Field_DBDate_OnSetEditable(pFlag)
{
  FormRowSet_AllField_Private_OnSetEditable(this,pFlag);
  if(pFlag)
   this.childNodes(1).disabled = false;
  else
   this.childNodes(1).disabled = true;
}

/*************end dbdate,dbdateTime***************************************************************/

/********************dblink***********************************************************************/
function FormRowSet_Field_OnDBLinkClick(pDBFormPK,pFieldName)
{
  var formObj =  g_FormRowSetManager.get(pDBFormPK);
  var val = formObj.getValue(pDBFormPK);
  var text = formObj.getDisplayText(pDBFormPK);
  formObj.exeOnDBLink(pDBFormPK,pFieldName,val,text);
}
function FormRowSet_Field_DBLink_SetValue(pVal,pDisplayText,pIsCreateEvent)
{
  FormRowSet_AllField_Private_SetValue(this,pVal,pDisplayText,pIsCreateEvent);
  if(pDisplayText == null)  pDisplayText= pVal;
  var dbFormObj = g_FormRowSetManager.get(this.DBFormPK);
  this.childNodes(0).innerText = dbFormObj.getFieldShowText(this.FieldName,pDisplayText);
  
}



/********************end dblink*******************************************************************/


/******************dbopenwin*********************************************************************/
function FormRowSet_Field_DBOpenWin_BtnClick(btnObj,pPara)
{
  var spanObj = btnObj.parentElement;
  if(spanObj && spanObj.DBFormPK)
  {
     var formObj =  g_FormRowSetManager.get(spanObj.DBFormPK);
     var val = formObj.getValue(spanObj.FieldName);
     var text = formObj.getDisplayText(spanObj.FieldName);
     var returnObj = formObj.exeOnDBLink(spanObj.DBFormPK,spanObj.FieldName,val,text,pPara);
     if(returnObj!=null && returnObj.id!=null)
     {
	 val = returnObj.id;
	 if(returnObj.text!=null)
	   {
	     text = returnObj.text;
	   }
	 else
	   {
	    text = val;
	    }
	spanObj.Action_SetValue(val,text,true);
      }
  }
}

function FormRowSet_Field_DBOpenWin_OnSetEditable(pFlag)
{
  FormRowSet_AllField_Private_OnSetEditable(this,pFlag);
  //��һ���ı��������ɱ༭.
  this.childNodes(0).disabled = true;
  if(pFlag)
   this.childNodes(1).disabled = false;
  else
   this.childNodes(1).disabled = true;
}
/***************** end openwin*******************************************************************/


/******************dbfile*********************************************************************/
function FormRowSet_Field_DBFile_BtnClick(btnObj,pBusiType) 
{
	if(pBusiType==null||pBusiType==""){
		alert("δ����ҵ�����ͣ�");
		return;
	}
	//����ҵ�����ͻ�ȡ����·��
	//var rr=PostInfo(_gModuleName+"/business/com.ai.frame.attach.AttachAction?action=getSavePath&BUSI_TYPE="+pBusiType,"");
	//var aSavePath=rr.getValueByName("SAVE_PATH");	
	//����uploadFileNew.jsp
	retObj=window.showModalDialog(_gModuleName+"/webframe/attach/uploadFileNew.jsp",window,"scroll:no;resizable:no;status:no;dialogHeight:400px;dialogWidth:500px");
	if (retObj!=null){
	  //�����ļ���
	  var spanObj = btnObj.parentElement;
	  if(spanObj && spanObj.DBFormPK)
	  {	  	
	  	var sVirtualFile=retObj.virtualFileName;	  
	  	var fileName=retObj.fileName;	 	
	  	spanObj.Action_SetValue(sVirtualFile,fileName,true);
	  }	
	}
}

function FormRowSet_Field_OnDBFileClick(btnObj,pBusiType){
  var spanObj = btnObj.parentElement;
  if(spanObj && spanObj.DBFormPK)
  {
     var formObj =  g_FormRowSetManager.get(spanObj.DBFormPK);
     var filename = formObj.getValue(spanObj.FieldName);
     var disptext = formObj.getDisplayText(spanObj.FieldName);
     filename=g_StringTrim(filename);
     if(filename == '')return;
     
     window.open (_gModuleName+'/business/com.ai.frame.attach.AttachAction?action=doDownload&FILE_NAME='+filename+"&BUSI_TYPE="+pBusiType); 
   }	
}
/***************** end dbfile*******************************************************************/

/****************DBTextArea*********************************************************/
function  FormRowSet_Field_DBTextArea_SetValue(pVal,pDisplayText,pIsCreateEvent)
{ 
	
   //hexg ,2006-8-18
   var tmp_pVal = pVal.replace(/\x0d\x0a/g,'@~');
   
   FormRowSet_AllField_Private_SetValue(this,tmp_pVal,tmp_pVal,pIsCreateEvent);
   var dbFormObj = g_FormRowSetManager.get(this.DBFormPK);
 
  //hexg
   tmp_pVal = pVal.replace(/@~/g,'\x0d\x0a');
   this.childNodes(0).value = dbFormObj.getFieldShowText(this.FieldName,tmp_pVal);
}
function  FormRowSet_Field_DBTextArea_GetValue()
{
   if(this.Action_OnBlur)
    {
	this.Action_OnBlur(this);
    }
       
  //var re =/[\r][\n]/g;
 // return this.I.replace(re,"\\n");
 return this.I;
}
function FormRowSet_Field_DBTextArea_GetDisplayText()
{
   if(this.Action_OnBlur)
    {
	this.Action_OnBlur(this);
    }
  //var re =/[\r][\n]/g;
  //return this.T.replace(re,"\\n");
   return this.T;
}

/****************DBSpan*********************************************************/
function  FormRowSet_Field_DBSpan_SetValue(pVal,pDisplayText,pIsCreateEvent)
{
   FormRowSet_AllField_Private_SetValue(this,pVal,pDisplayText,pIsCreateEvent);
   var dbFormObj = g_FormRowSetManager.get(this.DBFormPK);
   this.childNodes(0).innerText = dbFormObj.getFieldShowText(this.FieldName,pDisplayText);
  
}
/*******************************************************************************/


/****************DBHtml*********************************************************/
function  FormRowSet_Field_DBHtml_SetValue(pVal,pDisplayText,pIsCreateEvent)
{
   FormRowSet_AllField_Private_SetValue(this,pVal,pDisplayText,pIsCreateEvent);
   var dbFormObj = g_FormRowSetManager.get(this.DBFormPK);
   this.childNodes(0).innerHTML = dbFormObj.getFieldShowText(this.FieldName,pDisplayText);
   
}
/*******************************************************************************/

//����һ���ֶε����������Ƿ���
function FormRowSet_setImeModeSts(fieldName,sts){
  var fieldObj = FormRowSet_All_getFieldSpanObj(this.DBFormPK,fieldName);
  if(!fieldObj) return;
  if(sts){
    fieldObj.childNodes(0).style.imeMode ='auto';
  }else{
    fieldObj.childNodes(0).style.imeMode ='disabled';
  }
}