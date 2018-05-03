/**
��ȡListbox����:
	g_getListBox(id)����ȡ�����б�����֮�����ʹ�÷���:
����:
	getID():��ȡIDֵ
	getValue()����ȡ�ı�ֵ
	setValue(value):������������Դ��ָ��value����ĿΪѡ��״̬
	addItem(id,value):����һ��option
	delItem(id):ɾ��ָ��value��option
	delSelItem():ɾ��ѡ����option
	refresh(para):���ݲ�������ˢ������
	delAllItem():ɾ����������������
	getAllItem():�����б������е�ֵ��text����������Ϊarray������Ϊobject��object.idΪֵ��obj.valueΪ�ı�
	setDisabled(value):����������Ŀ��úͲ����õ�״̬��true��������,false����,
									��������úͲ����õ���ʽ��AppFrameCss.jsp�ж���
	filterValue(input_value):����input_value��ֵ�Զ����������б�				
�¼�: 
	OnItemChange ,���� id, text
	OnItemClick,  ���� id, text
	OnItemDblClick,���� id, text
*/

function g_getListBox(id){
	var UIObject = document.all(id);
	if(UIObject == null){
	    alert(g_I18NMessage("appframe_core","listbox_no") + id);
	    return;
	}
    if(UIObject.getID == null){
	   // alert("Initial");
	   UIObject.getID = DBListBoxTag_getID;
	   UIObject.getValue = DBListBoxTag_getValue;
	       UIObject.setValue = DBListBoxTag_setValue;
	       UIObject.addItem = DBListBoxTag_addItem;
	       UIObject.delItem = DBListBoxTag_delItem;
	       UIObject.delSelItem = DBListBoxTag_delSelItem;
	       UIObject.getAllItem = DBListBoxTag_getAllItem;
	       UIObject.delAllItem = DBListBoxTag_delAllItem;
	       UIObject.refresh = DBListBoxTag_refresh;
	       
	       //add by hexg
	       UIObject.setDisabled = DBListBoxTag_setDisabled;
           UIObject.clearFilterBackupData = DBListBoxTag_clearFilterBackupData;
           UIObject.filterValue = DBListBoxTag_filterValue;
           UIObject.replaceRefresh = DBListBoxTag_replaceRefresh;
    }
	return UIObject;
}

function DBListBoxTag_getID()
{

   if(this.showtype && this.showtype=="list")
	{
	   if(this.selectedIndex<0) return "";
	   var reValArray = new Array();
	   for(var i=0;i<this.options.length;i++)
		{
	   if(this.options(i).selected)
			{
			   reValArray[reValArray.length] = this.options(i).value;
			}
		}
       return reValArray.join(",");
	}
	else
	{
       if(this.selectedIndex<0) return "";
	    var selectOption = this.options(this.selectedIndex);
       if((selectOption) &&(selectOption.value))
	    return selectOption.value;
       return "";
	}

}

function DBListBoxTag_getValue()
{
	if(this.showtype && this.showtype=="list")
	{
	   if(this.selectedIndex<0) return "";
	   var reValArray = new Array();
	   for(var i=0;i<this.options.length;i++)
		{
	   if(this.options(i).selected)
			{
			   reValArray[reValArray.length] = this.options(i).text;
			}
		}
       return reValArray.join(",");
	}
	else
	{
	if(this.selectedIndex<0) return "";
			var selectOption = this.options(this.selectedIndex);
		if (selectOption)
			return selectOption.text
		else
			return "";
	}
}

function DBListBoxTag_setValue(id)
{
   if (id || id ==0 )
   {
     if(this.showtype && this.showtype=="list")
	   {
	   var selIdArray = id.split(",");

		   if(selIdArray)
		   {
		      for(var i=0;i<this.options.length;i++)
			{

			      for(var j=0;j<selIdArray.length;j++)
				   {
		      if(this.options[i].value == selIdArray[j] || (!this.options[i].value) && this.options[i].text ==selIdArray[j])
				   {
			     this.options[i].selected = true;
			     break;
		       }
				   }
				}
		   }


	   }
     else
	   {
	  for(var i=0;i<this.options.length;i++)
		  {
	     if(this.options[i].value == id || (!this.options[i].value) && this.options[i].text ==id)
			 {
		    this.options[i].selected = true;
		    return;
	     }
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


function DBListBoxTag_addItem(id,text)
{
  this.options[this.options.length] = new Option(text,id,false);
  this.clearFilterBackupData();
}

function DBListBoxTag_delItem(id)
{

     for(var i=this.options.length-1;i>=0;i--)
	  {
	   if(this.options(i).value == id)
	    {
		this.options.remove(i);
	    }
	  }
    this.clearFilterBackupData();

}

function DBListBoxTag_delSelItem()
{
     if(this.showtype && this.showtype=="list")
	{
	   if(this.selectedIndex<0) return ;
	   for(var i=this.options.length-1;i>=0;i--)
		{
		  if(this.options(i).selected)
			{
			    this.options.remove(i);
			}
		}

	}
     else
	{
	  if(this.selectedIndex<0) return ;
	  var selectOption = this.options(this.selectedIndex);
	  if (selectOption)
		this.options.remove(this.selectedIndex);

	}
    this.clearFilterBackupData();
}
function DBListBoxTag_refresh(pPara,nullId,nullText)
{	
	var hasNull =true
	//����û��ⲿû�д���Ĭ����ʾ���ı�����ʾTAG�е��ı���ID
	if(nullId==null || nullText==null){
		hasNull = this.hasNull;
		nullId = this.nullId;
		nullText = this.nullText;
	}
   var ListDataSourceStatic = createStaticListDataSource(this.ds,pPara,hasNull,nullId,nullText);
   if(ListDataSourceStatic!=null)
     {
       this.options.length = 0;
       ListDataSourceStatic.fillListBox(null,0,this,null,null);
     }
   this.clearFilterBackupData();
}

function DBListBoxTag_replaceRefresh(pPara,nullId,nullText)
{ 
  var hasNull =true
  //����û��ⲿû�д���Ĭ����ʾ���ı�����ʾTAG�е��ı���ID
  if(nullId==null || nullText==null){
    hasNull = this.hasNull;
    nullId = this.nullId;
    nullText = this.nullText;
  }
  //��յ�ǰ����
  this.options.length = 0;
  this.clearFilterBackupData();
  
  //�ӷ�������ȡ
  var tUrl = gListSrcQueryURL + "?eventid=html&dsid=" + this.ds;
  if (pPara)
      tUrl = tUrl + "&" + pPara;
  if(hasNull){
      tUrl = tUrl + "&hasNull=true";
  }
  if(nullId){
      tUrl = tUrl + "&nullId=" + nullId;
  }
  if(nullText){
      tUrl = tUrl + "&nullText=" + nullText;
  }
  var reStr = PostInfotoServer(tUrl ,'');
  
  var index = this.outerHTML.indexOf(">");
  var str = this.outerHTML.substring(0,index+1);
  this.outerHTML = str + reStr;
}

//ֵ�ı���Ӧ�¼�
function g_ListBoxTag_OnChange(listBoxObjId)
{
  var listBoxObj = g_getListBox(listBoxObjId);
  if(listBoxObj!=null && listBoxObj.options && listBoxObj.selectedIndex>=0)
  {
    var id = listBoxObj.getID();
    var text = listBoxObj.getValue();
    if(listBoxObj.OnItemChange && listBoxObj.OnItemChange!="")
    {
      eval(listBoxObj.OnItemChange+"('"+id+"','"+text+"')");
    }
  }
}

//�����¼���Ӧ����
function g_ListBoxTag_OnClick(listBoxObjId)
{
  var listBoxObj = g_getListBox(listBoxObjId);
  if(listBoxObj!=null && listBoxObj.options && listBoxObj.selectedIndex>=0)
  {
    var id = listBoxObj.getID();
    var text = listBoxObj.getValue();
    if(listBoxObj.OnItemClick && listBoxObj.OnItemClick!="")
    {
      eval(listBoxObj.OnItemClick+"('"+id+"','"+text+"')");
    }
  }
}
//˫����Ӧ�¼�
function g_ListBoxTag_OnDblClick(listBoxObjId)
{
  var listBoxObj = g_getListBox(listBoxObjId);
  if(listBoxObj!=null && listBoxObj.options && listBoxObj.selectedIndex>=0)
  {
    var id = listBoxObj.getID();
    var text = listBoxObj.getValue();
    if(listBoxObj.OnItemDblClick && listBoxObj.OnItemDblClick!="")
    {
      eval(listBoxObj.OnItemDblClick+"('"+id+"','"+text+"')");
    }
  }
}

function DBListBoxTag_getAllItem()
{

  var reValArray = new Array();
  for(var i=0;i<this.options.length;i++)
    {
	reValArray[reValArray.length] = {id:this.options(i).value,value:this.options(i).text};
    }
  return reValArray;

}


function DBListBoxTag_delAllItem()
{
  this.options.length = 0;
  this.clearFilterBackupData();
}

//������������û��߿���״̬ ,�������ΪNULL��
function DBListBoxTag_setDisabled(disabled_flag){
	if(disabled_flag){
		this.disabled = true;
		this.className = 'DBListBox_disabled_style';
	}
	else
	{
		this.disabled = false;
		this.className = 'DBListBox_normal_style';
	}
}

//���������б������
function DBListBoxTag_filterValue(input_value){
  //�����˵����ݷ��빫������
  
  if(this.p_selectNames == null){
	  this.p_selectNames = new Array();
	  this.p_selectOptions = new Array();
	  this.p_filterValues = new Array();
	  this.p_includeText = new Array();
  }
  selectNames = this.p_selectNames;
  selectOptions = this.p_selectOptions;
  filterValues = this.p_filterValues;
  includeText = this.p_includeText;
  
  fireFilter(input_value,this);
}
//��ձ�������
function DBListBoxTag_clearFilterBackupData(){
  selectNames = this.p_selectNames;
  selectOptions = this.p_selectOptions;
  filterValues = this.p_filterValues;
  includeText = this.p_includeText;
  clearOption(this);
}




//==========��������������˹���===========
var selectNames = null;
var selectOptions = null;
var filterValues = null;
var includeText = null;

//��Ӱ���������
function addIncludeText(in_text){
  includeText[includeText.length] = in_text;
}

//����ѱ���ѡ������
function clearOption(select_obj){
  if(selectNames ==null) {
    return;
  }
  //����ѱ�������
  var index_new = -1;
  for(var i=0;i<selectNames.length; i++){
    if(select_obj.name == selectNames[i]){
      index_new = i;
      break;
    }
  }
  //����ѱ��ݵ�����
  selectOptions[index_new] = null;
  selectNames[index_new] = null;
  filterValues[index_new] = null;
} 

//����ѡ������
function backupOption(input_value,select_obj,index){
  //���ѡ���Ƿ����б���
  if(index > 0 && selectOptions[index] != null){
    retrun;
  }
  var backup_selectOptions = new Array(select_obj.options.length);
  for(var i=0;i<backup_selectOptions.length; i++){
      backup_selectOptions[i] = select_obj.options[i];
  }
  var index_new = selectNames.length;
  selectNames[index_new] = select_obj.name;
  selectOptions[index_new] = backup_selectOptions;
} 

//��ԭѡ������
function restoreOption(input_value,select_obj,index){
  if(index < 0){
    retrun;
  }
  var backup_selectOptions = selectOptions[index];
  if(backup_selectOptions==null){
    return;
  }
  if(backup_selectOptions.length != select_obj.options.length){
    select_obj.options.length = 0;
    for(var i=0;i<backup_selectOptions.length; i++){
        select_obj.options[i] = backup_selectOptions[i];
    }
  }
  filterValues[index] = "";
  //����ȱʡѡ��
  if(select_obj.options.length >= 1){
    select_obj.options[0].selected = true;
  }
  if(select_obj.onchange){
    select_obj.onchange(select_obj);       
  }
}

//����ѡ������ ,index��ʾ����ѡ�������
function doFilter(input_value,select_obj,index){
  if(input_value == ""){
    return;
  }
  //��������
  var caseSensitive = false;
  var keystr = input_value;
  if(!caseSensitive){   
    keystr = keystr.toUpperCase();
  }
  //����б��ݣ�ȡ�����е�����������
  var index_new = -1;
  for(var i=0;i<selectNames.length; i++){
    if(select_obj.name == selectNames[i]){
      index_new = i;
      break;
    }
  }
  var filter_Options;
  if(index_new == -1){
    filter_Options = select_obj.options;
  }else{
    filter_Options = selectOptions[index_new];
  }
  //����
  var new_selectOptions = new Array(0);
  var selectLength = filter_Options.length
  for(var i=0;i<selectLength; i++){
    var searchText = filter_Options[i].text;
    if(!caseSensitive){   
      searchText = searchText.toUpperCase();
    }
    var include = false;
    for(var j=0;j<includeText.length; j++){
      if(searchText==includeText[i]){
        include = true;
        break;
      }
    }
      if(include || searchText.indexOf(keystr)!= -1){
          new_selectOptions[new_selectOptions.length]= filter_Options[i];
      }
  }
  //������˳�����
  if(select_obj.options.length != new_selectOptions.length){
    select_obj.options.length = 0;
    for(var i=0;i<new_selectOptions.length; i++){
      select_obj.options[i] = new_selectOptions[i];
    }
    //����ȱʡѡ��
    if(select_obj.options.length >= 1){
      select_obj.options[0].selected = true;
    }
    if(select_obj.onchange){
      select_obj.onchange(select_obj);
    }
  }
  //���ݹ�������
  filterValues[index] = input_value;
}

//ͨ���ض�ֵ��������ѡ���������,�ܵ����
function fireFilter(input_value,select_obj){
  if(select_obj==null){
    return;
  }
  if(select_obj.disable){
    return;
  }
  var input_value = Trim(input_value); 
  //���ѡ���Ƿ��б���
  var index = -1;
  for(var i=0;i<selectNames.length; i++){
    if(select_obj.name == selectNames[i]){
      index = i;
      break;
    }
  }
  //�ж���Ҫ���Ķ���
  var action = new Array();
  
  //����ǵ�һ�ι����򱸷�����
  if(index == -1){
    action[action.length] = "backupOption";
  }
  
  //�������Ĺ��˵����ݲ�Ϊ�ղ��Ҳ��ǵ�һ���ˣ���Ҫ��ԭһ������
  if(input_value=="" && index >=0){
    action[action.length] = "restoreOption";
  }
  //��ʼ��������
  if(input_value!=""){
    action[action.length] = "doFilter";
  }
  //ִ��action�еĲ���
  for(var i=0;i<action.length; i++){
    eval(action[i]+"(input_value,select_obj,index)");
  }
}



//ȥ�����ҿո�
function Trim(str){
    return RTrim(LTrim(str));
}
function LTrim(str){
    var whitespace = new String(" \t\n\r");
    var s = new String(str);
    if (whitespace.indexOf(s.charAt(0)) != -1){
        var j=0, i = s.length;
        while (j < i && whitespace.indexOf(s.charAt(j)) != -1){
            j++;
        }
        s = s.substring(j, i);
    }
    return s;
}
function RTrim(str){
    var whitespace = new String(" \t\n\r");
    var s = new String(str);
    if (whitespace.indexOf(s.charAt(s.length-1)) != -1){
        var i = s.length - 1;
        while (i >= 0 && whitespace.indexOf(s.charAt(i)) != -1){
            i--;
        }
        s = s.substring(0, i+1);
    }
    return s;
}
