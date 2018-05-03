<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title>选择可选资费包</title>
  </head>
  <body onload="initPage()">
  <table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td valign="top" colspan="3">
  <div>
    编码：<input value="" type="text" id="packageid" class="input" style="width:80px;"/>
    名称：<input value="" type="text" id="name" class="input" style="width:150px;"/>
    <ai:button text="staffselect.search" i18nRes="i18n.secframe_resource" id="searchOperBtn" onclick="search()"/>
  </div>
  </td>
  </tr>
    <tr>
        <td width="230" valign="top">
<ai:contractframe id="contractframe1" contenttype="table" title="可选资费包" width="100%" allowcontract="false" frameclosed="false">
 <ai:contractitem/>
      <ai:table tableid="dbTableExist"
	        setname="com.asiainfo.charge.web.SETOptionalPackaeg"
	        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	        implservice_name="com.asiainfo.charge.service.interfaces.IOptionalPackageSV"
	        implservice_querymethod="getOptionalPackaegValues(String id, String name, int $STARTROWINDEX, int $ENDROWINDEX)"
	        implservice_countmethod="getCountOptionalPackaegValues(String id, String name)"
	        ondbclick="addThis" multiselect="true"
	        initial="false" editable="false" pagesize="200"
	        width="300" height="320" needrefresh="true" footdisplay="true">
	          <ai:col fieldname="PACKAGEID" width="100" visible="true"/>
	          <ai:col fieldname="NAME" width="150" visible="true"/>
        </ai:table>
</ai:contractframe>
</td>
        <td align="middle" valign="center" >
  <img border="0" src="<%=request.getContextPath()%>/webframe/images/icon/right.gif"  alt="设为选中" onClick="add()" align="absmiddle" style="cursor:hand"/><br/><br/>
  <img border="0" src="<%=request.getContextPath()%>/webframe/images/icon/left.gif"  alt="取消选中" onClick="remove()" align="absmiddle" style="cursor:hand"/>
</td>
<td align="right" valign="top" >
<ai:contractframe id="contractframe1" contenttype="table" title="已选中的资费包" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:table tableid="selectElementTable"
       setname="com.asiainfo.charge.web.SETOptionalPackaeg"
       initial="false" multiselect="true" editable="false"
       ondbclick="delThis"
       width="300" height="290" needrefresh="true" footdisplay="true">
             <ai:col fieldname="PACKAGEID" width="100" visible="true"/>
             <ai:col fieldname="NAME" width="150" visible="true"/>
</ai:table> 
</ai:contractframe> 
<div class="area_button">
    <ai:button text="确定" id="cancel" onclick="doReturn()"/>
    <ai:button text="orgrelat.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
</div>
</td>
</tr>
</table>
  </body>
</html>
  <script type="text/javascript">
    var _sourceElementsTable = g_TableRowSetManager.get("dbTableExist");
    var _selectElementsTable = g_TableRowSetManager.get("selectElementTable");
    
    function cancel()
    {   
        window.self.close();
    }
    
    function getDbTableExist()
    {
        return g_TableRowSetManager.get("dbTableExist");
    }
    /**
     * 点击组织节点显示该组织下的员工
     */
    function initPage()
    {
        _sourceElementsTable.refresh();
    }
    /**
     * 查询操作员与员工信息
     */
    function search(){
        var dbTable = getDbTableExist(); 
        var packageid = document.getElementById("packageid").value;
        var name = document.getElementById("name").value;
        var nameCond = "";
        var packageidCond = "";
        
        var flag = false;
        if(packageid != null && packageid != "")
        {
            packageidCond = "id="+packageid;
        }
        if(name != null && name != "")
        {
            name = encodeURI(name); 
            nameCond = "name="+name;
        }
        var cond = "";
        
        if(packageidCond != "")
        {
            if(flag)
            {
                cond = cond +"&"+ packageidCond;
            }
            else 
            {
                cond = cond +  packageidCond;
                flag = true;
            }
        }
        if(nameCond != "")
        {
            if(flag)
            {
                cond = cond +"&"+ packageidCond;
            }
            else 
            {
                cond = cond + nameCond;
                flag = true;
            }
        }
        dbTable.refresh(cond);
    }

    /**
     * 选择已有的员工
     */
    function doReturn()
    {
        //if(_selectElementsTable.count() > 0)
        //{
            var returnJSON = {"elements":[]};
            for(var i=0;i<_selectElementsTable.count();i++)
            {
                returnJSON.elements.push({
                                            "packageId":_selectElementsTable.getValue(i, "PACKAGEID"),
                                            "name":_selectElementsTable.getValue(i, "NAME")
                                        });
            }
            window.returnValue = returnJSON;
            window.self.close();
        //}
    }
    
    function remove()
    {
        if( _selectElementsTable.getSelectedRows()!=null&&_selectElementsTable.getSelectedRows().length>0)
        {
            for(var i=0;i < _selectElementsTable.count();i++)
            {
                if(_selectElementsTable.isSelected(i))
                {
                    _selectElementsTable.deleteRow(i);
                    i--;
                }
            }
         }
         else
         {
          alert("请选择要删除的对象！");
          //alert(g_I18NMessage("secframe_role_exclude" , "sec_role_exclude_selexclude"));
         }
       
    }
    
    function add()
    {
        if( _sourceElementsTable.getSelectedRows()!=null&&_sourceElementsTable.getSelectedRows().length>0)
        {
                var selRows = _sourceElementsTable.getSelectedRows();
                for(var i=0;i<selRows.length;i++)
                {
                    if (!isInTable(_selectElementsTable,"PACKAGEID",_sourceElementsTable.getValue(selRows[i],"PACKAGEID")))
                    {
                        _selectElementsTable.newRow(false);
                        _selectElementsTable.setValue(_selectElementsTable.getRow(),"PACKAGEID",_sourceElementsTable.getValue(selRows[i],"PACKAGEID"),_sourceElementsTable.getValue(selRows[i],"PACKAGEID"));
                        _selectElementsTable.setValue(_selectElementsTable.getRow(),"NAME",_sourceElementsTable.getValue(selRows[i],"NAME"),_sourceElementsTable.getValue(selRows[i],"NAME"));
                    }
                }
                /**
                for(var i=0;i < _sourceElementsTable.count();i++)
                {
                    if(_sourceElementsTable.isSelected(i))
                    {
                        _sourceElementsTable.deleteRow(i);
                        i--;
                    }
                }
                */
         }
         else
         {
          alert("请选择要添加的对象！");
          //alert(g_I18NMessage("secframe_role_exclude" , "sec_role_exclude_delexclude"));
         }
        
    }
    
    function addThis(){
        var row =_sourceElementsTable.getRow();
         
        if (!isInTable(_selectElementsTable,"PACKAGEID",_sourceElementsTable.getValue(row,"PACKAGEID")))
        {
            _selectElementsTable.newRow(false);
            _selectElementsTable.setValue(_selectElementsTable.getRow(),"PACKAGEID",_sourceElementsTable.getValue(row,"PACKAGEID"),_sourceElementsTable.getValue(row,"PACKAGEID"));
            _selectElementsTable.setValue(_selectElementsTable.getRow(),"NAME",_sourceElementsTable.getValue(row,"NAME"),_sourceElementsTable.getValue(row,"NAME"));
        }
    }
    
    function delThis(){
        _selectElementsTable.deleteRow(_selectElementsTable.getCurRowIndex());
    }
    
    function isInTable(selectElementsTable,itemName,value)
    {
        for(var i=0;i < selectElementsTable.count();i++)
        {
            if(selectElementsTable.getValue(i,itemName) == value)
            {
                return true;
            }
        }
    }
  </script>