/**
 * �Զ����ѯ�����б��Ӧ��tag����ƥ���js������
 */
function g_ListBoxOnChange(listBoxObj)
{
  if(listBoxObj!=null && listBoxObj.options && listBoxObj.selectedIndex>=0)
  {
    var id = listBoxObj.options[listBoxObj.selectedIndex].value;
    var text = listBoxObj.options[listBoxObj.selectedIndex].text;
    if(listBoxObj.S_OnChange && listBoxObj.S_OnChange!="")
    {
      eval(listBoxObj.S_OnChange+"('"+id+"','"+text+"')");
    }
  }
}
/**
 * �����Ի�����ʾ�Զ����ѯ�����öԻ���
* pFuncCode ����ģ�����
* pStaffId Ա����staffidֵ�����Ϊ����ʾ��ǰ��½Ա����staffid
* return true/false ��ʾ�����Ƿ���¹���
 */
function g_ShowDefineQryDlg(pFuncCode,pStaffId)
{
   var staffId = pStaffId;
   if(pStaffId==null)
	   staffId = g_GetUserInfo().STAFF_ID;
   var flag = window.showModalDialog( _gModuleName+ "/webframe/defineqry/querydefinedlg.jsp?STAFF_ID="+staffId+"&FUNC_CODE="+pFuncCode,window,"scroll:no;resizable:no;status:no;dialogHeight:530px;dialogWidth:745px");
   return flag;
}


/**
* ���Զ����ѯ���б����refresh��idΪ�Զ��������б�tag���idֵ
*/
function g_RefreshDefineQryListBox(id)
{
   var obj = document.getElementById(id);
   if(obj!=null && obj.FUNC_CODE && obj.STAFF_ID)
   {
     var funcCode = obj.FUNC_CODE;
     var staffId = obj.STAFF_ID;
     //alert(funcCode+","+staffId);
     var ListDataSourceStatic = createStaticListDataSource("com.ai.appframe2.defineqry.bean.DSDefineQryListBox","arg0="+funcCode+"&arg1="+staffId);
     if(ListDataSourceStatic!=null)
     {
       obj.options.length = 0;
       ListDataSourceStatic.fillListBox(null,0,obj,null,null);
     }


   }
}