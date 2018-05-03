/**
  hexg ,2007-5-9
  �򻯵ı��JS�ؼ������ֻ֧��ֻ����������֧���޸ġ�ɾ��������������
  �ñ��֧��ԭ�����ؼ��ĸ����¼���Ӧ
*/

var g_TableRowSetManager = new TableRowSetManager();
//���������
function TableRowSetManager(){
  this.List = new Array();
  
  this.push = function(obj){
    this.List[obj.DBGridPK] = obj;
    return obj.DBGridPK;
  }
  
  this.get = function(pk){
    var result = this.List[pk];
    if(!result){
      var obj = document.all("TableRowSet_ParentDiv_" + pk);
      if(obj == null) return null;

      //����obj.onlyQuery��ֵͬ��������ͬ��tablerowset
      if(obj.onlyQuery != null && 
          (obj.onlyQuery==false || obj.onlyQuery=='false')){
        result = new TableRowSet(pk);  
      }else{
        result = new TableRowSetSimple(pk);
      }
    }
    return result;
  }
  
  this.remove = function(pk){
    this.List[pk] = null;
  }

  this.reinitial = function(pk){
    this.get(pk).reinitial();
  }
}


function TableRowSetSimple(aName,aPkName){
  this.DBGridPK = aName;
  this.pkName = aPkName; //���ݼ��������ֶ�����
  g_TableRowSetManager.push(this);
  this.initial();
}

TableRowSetSimple.prototype.count = Public_Table_count; 
TableRowSetSimple.prototype.realcount = Public_Table_realcount;
TableRowSetSimple.prototype.hasTotalRow = Public_Table_hasTotalRow;
TableRowSetSimple.prototype.resize = Public_Table_resize;
TableRowSetSimple.prototype.getColCount = Public_Table_getColCount;
TableRowSetSimple.prototype.getVisiColCount = Public_Table_getVisiColCount;
TableRowSetSimple.prototype.getColIndex = Public_Table_getColIndex;
TableRowSetSimple.prototype.getNameByIndex = Public_Table_getNameByIndex;
TableRowSetSimple.prototype.setTitle = Public_Table_setTitle;
TableRowSetSimple.prototype.setTitleByIndex = Public_Table_setTitleByIndex;
TableRowSetSimple.prototype.getTitle = Public_Table_getTitle;
TableRowSetSimple.prototype.getTitleByIndex = Public_Table_getTitleByIndex;
TableRowSetSimple.prototype.getServerPK = Public_Table_getServerPK;
TableRowSetSimple.prototype.getCurRowIndex = Public_Table_getRow;
TableRowSetSimple.prototype.getTotalRowCount = Public_Table_getTotalRowCount;
TableRowSetSimple.prototype.getColWidth = Public_Table_getColWidth;
TableRowSetSimple.prototype.setColWidth = Public_Table_setColWidth;
TableRowSetSimple.prototype.getMutilSelectColIndex = Public_Table_getMutilSelectColIndex
TableRowSetSimple.prototype.getSelectedRows = Public_Table_getSelectedRows
TableRowSetSimple.prototype.getRowId = Public_Table_getRowId
TableRowSetSimple.prototype.getRow = Public_Table_getRow;
TableRowSetSimple.prototype.getCol = Public_Table_getCol;
TableRowSetSimple.prototype.setPageSize = Public_Table_setPageSize;
TableRowSetSimple.prototype.toExcelUrl = Public_Table_toExcelUrl;
TableRowSetSimple.prototype.selectAll = Public_Table_selectAll;
TableRowSetSimple.prototype.rowSelected = Public_Table_rowSelected;
TableRowSetSimple.prototype.isSelected = Public_Table_isSelected;
TableRowSetSimple.prototype.disabledSelect =Public_Table_disabledSelect;
TableRowSetSimple.prototype.setAllSelectCheckBoxSts = Public_Table_setAllSelectCheckBoxSts;
TableRowSetSimple.prototype.getColNames = Public_Table_getColNames;
TableRowSetSimple.prototype.visibleSelect  = Public_Table_visibleSelect;
TableRowSetSimple.prototype.getStartRowIndex = Public_Table_getStartRowIndex;
TableRowSetSimple.prototype.getEndRowIndex = Public_Table_getEndRowIndex;
TableRowSetSimple.prototype.setRow = Public_Table_setRow;
TableRowSetSimple.prototype.setFocus = Public_Table_setFocus;
TableRowSetSimple.prototype.setFocusByName = Public_Table_setFocusByName;
TableRowSetSimple.prototype.print = Public_Table_print;
TableRowSetSimple.prototype.refreshForObd = Public_Table_refreshForObd;
TableRowSetSimple.prototype.refresh = Public_Table_refresh;
TableRowSetSimple.prototype.refreshByDefineQeruy = Public_Table_refreshByDefineQeruy;

TableRowSetSimple.prototype.getValue = Public_SimpleTable_getValue;
TableRowSetSimple.prototype.getDisplayText = Public_SimpleTable_getDisplayText;
TableRowSetSimple.prototype.toXmlString = Public_SimpleTable_toXmlString;
TableRowSetSimple.prototype.toXmlStringOfSelects = Public_SimpleTable_toXmlStringOfSelects;
TableRowSetSimple.prototype.setColVisible = Public_Table_setColVisible;

TableRowSetSimple.prototype.getTableObject = Private_Table_getTableObject;
TableRowSetSimple.prototype.getRowObj = Private_Table_getRowObj;
TableRowSetSimple.prototype.restoreTableInfo = Private_Table_restoreTableInfo;
TableRowSetSimple.prototype.recordTableInfo = Private_Table_recordTableInfo;
TableRowSetSimple.prototype.adjustHeadDivWidth = Private_Table_adjustHeadDivWidth;
TableRowSetSimple.prototype.getRowHeadColCount = Private_Table_getRowHeadColCount;
TableRowSetSimple.prototype.modifyRowSequence  = Private_Table_modifyRowSequence;
TableRowSetSimple.prototype.currentRowChange = Private_Table_currentRowChange;

TableRowSetSimple.prototype.initial = Private_SimpleTable_initial;
TableRowSetSimple.prototype.reinitial = Private_SimpleTable_reinitial;
TableRowSetSimple.prototype.getCell = Private_SimpleTable_getCell;
TableRowSetSimple.prototype.getCellByName = Private_SimpleTable_getCellByName;
TableRowSetSimple.prototype.sort = Private_SimpleTable_sort;
TableRowSetSimple.prototype.tdOnFocus = Private_SimpleTable_tdOnFocus
TableRowSetSimple.prototype.toXmlStringRow = Private_SimpleTable_toXmlStringRow;
TableRowSetSimple.prototype.toXmlStringOfRows = Private_SimpleTable_toXmlStringOfRows;
TableRowSetSimple.prototype.clear = Private_SimpleTable_clear;
TableRowSetSimple.prototype.setColSortFunction = Public_SimpleTable_setColSortFunction;
TableRowSetSimple.prototype.setColSortIcon = Private_SimpleTable_setColSortIcon;
TableRowSetSimple.prototype.getClassName = Private_SimpleTable_getClassName;

TableRowSetSimple.prototype.adjustTableSize = PrivateIE_Table_adjustTableSize

//���ñ��ĳһ�е����򷽷�
function Public_SimpleTable_setColSortFunction(colName ,sortFunction){
  var f = null;
  if(typeof(sortFunction)=='function'){
    f = sortFunction;
  }
  else if(typeof(sortFunction)=='string'){
    eval("f=" + sortFunction);
  }else{
    return;
  }
  //�����򷽷�����ȫ�ֱ���
  if(this.sortFunctionArray ==null){
    this.sortFunctionArray = new Array();
  }
  colName = colName.toUpperCase();
  this.sortFunctionArray[colName] = f;
}

//��ȡָ���е�ֵ
function Public_SimpleTable_getValue(rowIndex,colName){
  var tmpRow = this.getRowObj(rowIndex);
  if (tmpRow == null)
     return null;

  colName = colName.toUpperCase();
  var colEditType = this.colEditType[colName];

  //����������У���ֱ�ӷ���TR������
  if(colEditType == null){
    return eval("tmpRow." + colName);
  }

  var colIndex = parseInt(this.colIndexs[colName]);
  var cell = tmpRow.cells(colIndex + this.getRowHeadColCount());
  
  if(cell.I !=null && typeof(cell.I)!='undefined'){
    return cell.I;
  }
  //������������У�����ݱ༭����ȡֵ
  if(colEditType == g_DBHTML_STRING){
    return cell.innerHTML;
  }else if(colEditType == g_DBTREE_STRING){
    return cell.childNodes(cell.childNodes.length -1).innerText;
  }else{
    return cell.innerText;
  }
}

//��ȡ��ʾ�ı�
function Public_SimpleTable_getDisplayText(rowIndex,colName){
  var tmpRow = this.getRowObj(rowIndex);
  if (tmpRow == null)
     return null;

  colName = colName.toUpperCase();
  var colEditType = this.colEditType[colName];

  //����������У���ֱ�ӷ���TR������
  if(colEditType == null){
    return eval("tmpRow." + colName);
  }

  var colIndex = parseInt(this.colIndexs[colName]);
  var cell = tmpRow.cells(colIndex + this.getRowHeadColCount());

  if(cell.T !=null && typeof(cell.T)!='undefined'){
    return cell.T;
  }
  
  //������������У�����ݱ༭����ȡֵ
  if(colEditType == g_DBHTML_STRING){
    return cell.innerHTML;
  }else if(colEditType == g_DBTREE_STRING){
    return cell.childNodes(cell.childNodes.length -1).innerText;
  }else{
    return cell.innerText;
  }
}


//���ء���ʾ������,flag: true��ʾ��ʾ�� false��ʾ���ء����ָ��б���������dbgrid��col tag�ж��壬���Ҳ������ֶ�
function Public_Table_setColVisible(colName ,flag){
	colName = colName.toUpperCase();
	var index = this.getColIndex(colName);
	if(index<0){
		alert(g_I18NMessage("appframe_core","table_illegal_field"));
		return;	
	} 
	
	index = index + this.getRowHeadColCount();
	
	//���ⵥԪ��
	var cell = this.HeadTable.rows(0).cells(index );
	
    if(cell == null){
    	alert(g_I18NMessage("appframe_core","table_no_col"));
    	return;	
    }
     
    //������
    if(flag == false || flag == "false"){
    	//����Ѿ���������ֱ�ӷ���
    	if(cell.preWidth !=null){
    		return;
    	}
    	
    	//��������ǰ�ĳ���
		cell.preWidth= cell.width;
		
		//��Ϊcell.width���ܽ���0����������������ص�ʱ�������style.with��
		//��֮����ʾ��ʱ������ȰѶ����style.width������գ�����width������Խ��п������
		cell.style.width="0px";
		
		this.HeadTable.width = parseInt(this.HeadTable.width) - cell.preWidth;
      	
      	if (this.DataTable !=null && this.DataTable.rows.length >0){
	      	this.DataTable.rows(0).cells(index).style.width="0px";
	      	this.DataTable.width = parseInt(this.DataTable.width) - cell.preWidth;
	    }
	    
      	 
    }
    //��ʾ��
	else if(flag ==true || flag == "true"){
    	//���û�����أ���ֱ�ӷ���
    	if(cell.preWidth ==null){
    		return;
    	} 
      	
      	cell.style.width=null;
		cell.width= cell.preWidth  ;
      	this.HeadTable.width = parseInt(this.HeadTable.width) + parseInt(cell.preWidth);
      	
      	if (this.DataTable !=null && this.DataTable.rows.length >0){
      		this.DataTable.rows(0).cells(index).style.width=null;
	      	this.DataTable.rows(0).cells(index).width = cell.preWidth;
	      	this.DataTable.width = parseInt(this.DataTable.width)  + parseInt(cell.preWidth);
	    }	

    	cell.preWidth = null;    	
    	this.adjustTableSize(this.DBGridPK);
    }
	else{
		alert(g_I18NMessage("appframe_core","table_display_param"));
	}
	
	
	var head_div = window.document.all("HeadDiv_" + this.DBGridPK);
	var data_div = window.document.all("TableDiv_" + this.DBGridPK);
	Private_Table_adjustHeadDivWidth(head_div,data_div);
}

//��ȡָ���е�״̬
function Public_SimpleTable_getRowSts(rowIndex){
  return "O";
}

//��ѡ����д����xml����
function  Public_SimpleTable_toXmlStringOfSelects(colnames,isIncludeDisplayAttr){
  return this.toXmlStringOfRows(this.getSelectedRows(),colnames,isIncludeDisplayAttr);
}
//��ָ�����д����XML����
function  Private_SimpleTable_toXmlStringOfRows(aRows,colnames,isIncludeDisplayAttr){
  var result = new Array();

  var colIndexs = new Array();
  if(colnames == null || colnames.length == 0){
    for(var i=0;i< this.getColCount();i++){
      colIndexs[i] = i;
    }
  }else{
    var tmpNames = (""+colnames).split(",");
    for(var i=0;i<tmpNames.length;i++){
      colIndexs[i] = this.getColIndex(tmpNames[i]);
    }
  }

  for(var i=0;i<aRows.length;i++){
    var s= this.toXmlStringRow(aRows[i],false,colIndexs,isIncludeDisplayAttr);
    if(s.length >0)
      result[result.length] = (s);
  }

  if(result.length ==0)
    return "";

  return "<RowSet Name='" + this.HeadTable.setname + "' FullName='" +  this.HeadTable.setfullname + "' "
            + " Sts='U'>"+ result.join("") + "</RowSet>";
}
//��ȡ����XML String
function  Public_SimpleTable_toXmlString(isOnlySendModifyData,colnames,isIncludeDisplayAttr){
  var result = new Array();
  var colIndexs = new Array();
  if(colnames == null || colnames.length == 0){
    for(var i=0;i< this.getColCount();i++){
      colIndexs[i] = i;
    }
  }else{
    var tmpNames = (""+colnames).split(",");
    for(var i=0;i<tmpNames.length;i++){
      colIndexs[i] = this.getColIndex(tmpNames[i]);
    }
  }

  for(var i=0;i<this.count();i++){
    var s= this.toXmlStringRow(i,isOnlySendModifyData,colIndexs,isIncludeDisplayAttr);
    if(s.length >0)
      result[result.length] = (s);
    }

  if(result.length ==0)return "";

  return "<RowSet Name='" + this.HeadTable.setname + "' FullName='" +  this.HeadTable.setfullname + "' "
          + " Sts='U'>" + result.join("") + "</RowSet>";
}
//��ָ�����д����XML����
function Private_SimpleTable_toXmlStringRow(rowIndex,isOnlySendModifyData,colIndexs,isIncludeDisplayAttr){
  if(isOnlySendModifyData == null) isOnlySendModifyData = true;
  if(isIncludeDisplayAttr ==null) isIncludeDisplayAttr = false;

  var sts = "O";
  if (isOnlySendModifyData == true)
    return "";

  var result = new Array();
  result[result.length] = ("<Row ID='" + this.getRowId(rowIndex) + "' Sts='" + sts + "'>");

  for(var i=0;i< colIndexs.length;i++){
    var colName = this.getNameByIndex(colIndexs[i]);
    var xmlStr = "<Col Name='" + colName  + "'" + " Sts='" + sts + "'";
        
    var value = this.getValue(rowIndex ,colName);
    var text =null;
    if(isIncludeDisplayAttr) {
      text = value;
    }

    if (value)
      xmlStr += " OldID='" + Private_Table_checkAndTrans(value) + "'";
    if (text)
      xmlStr += " OldText ='" + Private_Table_checkAndTrans(text) +"' ";
    xmlStr = xmlStr + "/>"
    
    result[result.length] = xmlStr;
  }
  result[result.length] = ("</Row>");
  
  return result.join("");
}


//��ʼ�����
function  Private_SimpleTable_initial(){
  this.CurRow = -1;
  this.CurCol = -1;

  this.TableRowSetDiv = document.all("TableRowSet_" + this.DBGridPK);
  this.HeadAndTableDiv = document.all("HeadAndTableDiv_" + this.DBGridPK);
  this.HeadDiv  = document.all("HeadDiv_" + this.DBGridPK);
  this.TableDiv  = document.all("TableDiv_" + this.DBGridPK);
  this.FootDiv = document.all("FootDiv_" + this.DBGridPK);

  this.HeadTable = document.all("HeadTable_" + this.DBGridPK);
  this.FootTable = document.all("FootTable_" + this.DBGridPK);
  this.DataTable = document.all("DataTable_" + this.DBGridPK);
 
  this.DBTreeColName = this.HeadTable.DBTreeColName;
  this.currPage =parseInt(this.DataTable.currPage);
  this.pageCount = parseInt(this.DataTable.pageCount);
  this.totalRowCount =  parseInt(this.FootTable.totalRowCount);
  
  this.isMutilSelect = false;
  this.isRowSequence = false;
  if (!this.TableRowSetDiv.isRowSequence)
      this.isRowSequence = false;
  else
      this.isRowSequence = true;

  if (!this.TableRowSetDiv.isMutilSelect)
      this.isMutilSelect = false;
  else
      this.isMutilSelect = true;
  
  //����ÿһ�еı༭ģʽ
  this.colEditType = new Array();
  this.colDataType = new Array();
  this.colIndexs = new Array();
  //��������ֶ���Ϣ
  this.visioColCount =0;
  this.colNames = new Array();
  
  var cells = this.HeadTable.rows(0).cells;

  var headCount = this.getRowHeadColCount();
  for(i=0;i<cells.length-headCount;i++){
    this.colEditType[cells[i+ headCount].FieldID] = cells[i + headCount].editType;
    this.colDataType[cells[i+ headCount].FieldID] = cells[i + headCount].dataType;
    this.colIndexs[cells[i+ headCount].FieldID] = "" + i;
    this.colNames[i] = cells[i+ headCount].FieldID;
    this.visioColCount = this.visioColCount+1;
  }
  
  //������
  var tmpHideColNames = this.HeadTable.rows(0).FieldIDs;
 
  if(tmpHideColNames){
    var list = splitString(tmpHideColNames,",");
    for(var i=0;i<list.length;i++){
      this.colIndexs[list[i].toUpperCase()] = i + this.visioColCount;
      this.colNames[ i + this.visioColCount] = list[i];
    }
  }
  
  //�ж��Ƿ��кϼ���
  this.m_hasTotalRow = false;
  var allCount = this.DataTable.rows.length;
  if (allCount > 0 ){
    var totalRow = this.DataTable.rows(allCount - 1);
    if (totalRow.IsTotal)
      this.m_hasTotalRow = true;
  }
  
  //��ʼ����ǰ���и߶�,add by hexg 20060625 ,
  //����û��������и߲����и߲�Ϊ-1�Ļ��������û���rowheight��Ϊȱʡ���и�
  if(this.TableRowSetDiv.RowHeight == null && this.TableRowSetDiv.RowHeight>0)
    this.DefaultRowHeight =this.TableRowSetDiv.RowHeight;

  if(this.TableRowSetDiv.S_OnGridDbClick){
    eval("this.OnGridDbClick = " + this.TableRowSetDiv.S_OnGridDbClick);
  }
  if(this.TableRowSetDiv.S_OnTitleDbClick){
    eval("this.S_OnTitleDbClick = " + this.TableRowSetDiv.S_OnTitleDbClick);
  }
  if(this.TableRowSetDiv.S_OnValueChange){
    eval("this.OnValueChange = " + this.TableRowSetDiv.S_OnValueChange);
  }
  if(this.TableRowSetDiv.S_OnRowFocusChange){
    eval("this.OnRowFocusChange = " + this.TableRowSetDiv.S_OnRowFocusChange);
  }
  if(this.TableRowSetDiv.S_OnCellFocusChange){
    eval("this.OnCellFocusChange = " + this.TableRowSetDiv.S_OnCellFocusChange);
  }
  //ʧȥ�����¼�
  if(this.TableRowSetDiv.S_OnFocusOut){
    eval("this.OnFocusOut = " +this.TableRowSetDiv.S_OnFocusOut);
  }
  if(this.TableRowSetDiv.S_OnContextMenu){
      eval("this.OnContextMenu = " + this.TableRowSetDiv.S_OnContextMenu);
  }
  if(this.TableRowSetDiv.S_OnBeforeTurnPage){
      eval("this.OnBeforeTurnPage = " + this.TableRowSetDiv.S_OnBeforeTurnPage);
  }
  if(this.TableRowSetDiv.S_OnAfterTurnPage){
      eval("this.OnAfterTurnPage = " + this.TableRowSetDiv.S_OnAfterTurnPage);
  }
  if(this.TableRowSetDiv.S_OnRowSelected){
      eval("this.OnRowSelected = " + this.TableRowSetDiv.S_OnRowSelected);
  }
  if(this.TableRowSetDiv.S_OnDBLink){
      eval("this.OnDBLink = " + this.TableRowSetDiv.S_OnDBLink);
  }
  if(this.TableRowSetDiv.S_OnResize){
      eval("this.OnResize = " + this.TableRowSetDiv.S_OnResize);
  }
  
  
  
  this.getTableObject().onmouseover= Private_SimpleTable_showColTips;
  
}

//���³�ʼ�������ˢ�¡���ҳ��ʱ�����
function Private_SimpleTable_reinitial(){
  this.CurRow = -1;
  this.CurCol = -1;

  this.TableRowSetDiv = document.all("TableRowSet_" + this.DBGridPK);
  this.HeadAndTableDiv = document.all("HeadAndTableDiv_" + this.DBGridPK);
  this.HeadDiv  = document.all("HeadDiv_" + this.DBGridPK);
  this.TableDiv  = document.all("TableDiv_" + this.DBGridPK);
  this.FootDiv = document.all("FootDiv_" + this.DBGridPK);

  this.HeadTable = document.all("HeadTable_" + this.DBGridPK);
  this.FootTable = document.all("FootTable_" + this.DBGridPK);
  this.DataTable = document.all("DataTable_" + this.DBGridPK);
  
  this.DBTreeColName = this.HeadTable.DBTreeColName;
  this.currPage =parseInt(this.DataTable.currPage);
  this.pageCount = parseInt(this.DataTable.pageCount);
  this.totalRowCount =  parseInt(this.FootTable.totalRowCount);
  
 //����ÿһ�еı༭ģʽ
  this.colEditType = new Array();
  this.colIndexs = new Array();
  //��������ֶ���Ϣ
  this.visioColCount =0;
  this.colNames = new Array();
  
  var cells = this.HeadTable.rows(0).cells;

  var headCount = this.getRowHeadColCount();
  for(i=0;i<cells.length-headCount;i++){
    this.colEditType[cells[i+ headCount].FieldID] = cells[i + headCount].editType;
    this.colIndexs[cells[i+ headCount].FieldID] = "" + i;
    this.colNames[i] = cells[i+ headCount].FieldID;
    this.visioColCount = this.visioColCount+1;
  }
  
  //������
  var tmpHideColNames = this.HeadTable.rows(0).FieldIDs;
  if(tmpHideColNames){
    var list = splitString(tmpHideColNames,",");
    for(var i=0;i<list.length;i++){
      this.colIndexs[list[i].toUpperCase()] = i + this.visioColCount;
      this.colNames[ i + this.visioColCount] = list[i];
    }
  }
  
  this.getTableObject().onmouseover= Private_SimpleTable_showColTips;
    
  //�����µ�PK
  var tableTagInfo = document.all("TableTagInfo_" + this.DBGridPK);
  if(tableTagInfo != null && tableTagInfo.newGridPK !=null && tableTagInfo.newGridPK !=''){
  	var parentDiv = document.all("TableRowSet_ParentDiv_"+ this.DBGridPK);
  	parentDiv.PK = tableTagInfo.newGridPK;
  }
}


function Private_SimpleTable_showColTips(){  
var obj = window.event.srcElement;
  
	if(event.srcElement.tagName !='TD')return;
else{
   obj = obj.parentNode;
   obj.className="td_hover";
  }
	//����Ѿ���ʾ������������
	if(event.srcElement.title != null && event.srcElement.title != "" )return;
	
  	event.srcElement.title = event.srcElement.innerText;
}


//�����кź�������ȡ���ڵ�Ԫ�����
function Private_SimpleTable_getCellByName(index,name){
  var colIndex = this.getColIndex(name);
  var cell = this.getCell(index,colIndex);
  return cell;
}

//�����кź���������ȡ��Ԫ�����
function Private_SimpleTable_getCell(rowIndex,colIndex){
  var tmpRow = this.getRowObj(rowIndex);
  if (tmpRow == null)return null;
  
  if((colIndex == null)|| colIndex<0|| colIndex >= this.getVisiColCount())
      return null;
      
  return tmpRow.cells(colIndex +   this.getRowHeadColCount());
}

//����
function Private_SimpleTable_sort(colName,sortType,sortFunction){ //false ����
  var valueArray = new Array(); //��Ҫ������е�ֵ
  var valueRowArray = new Array();
  var nullRowArray = new Array();//��ֵ��Ӧ���б������
  var tmpValue = "";
  var tmpArray;
  var tmpList = new Array();
  var rowCount = this.count();
  var currRowObj = this.getRowObj(this.CurRow);//��¼��ǰ�ж���

  for(var i=0;i< rowCount ;i++){//����ֵ���з���
    tmpValue = this.getDisplayText(i,colName);
    if (!tmpValue)
      nullRowArray.push(i);
    else{
      tmpArray = valueRowArray[tmpValue];
      if (!tmpArray){
        tmpArray = new Array();
        valueArray.push(tmpValue);
        valueRowArray[tmpValue] = tmpArray;
      }
      tmpArray.push(i);
    }
  }
  
  if (valueArray.length == 0)
    return false;
    
  var dataType = this.colDataType[colName];

  if(sortFunction !=null){ 
    valueArray = valueArray.sort(sortFunction);   
  }
  //��������֣����������򣬷������ַ���������Ҳ�ǰ��ַ�����
  else if(dataType=='Float' || dataType=='Number'|| dataType=='Double'
    || dataType=='Short' || dataType=='int' || dataType=='Integer'
    || dataType=='Long'){
    valueArray = valueArray.sort(sortDigit);
  }else {
    valueArray = valueArray.sort(sortFunction);
  }
  if (sortType != false){
    for(var i=0;i<valueArray.length;i++){
      tmpArray = valueRowArray[valueArray[i]];
      for(var j=0;j< tmpArray.length;j++)
        tmpList.push(tmpArray[j]);
    }
  }else{
    for(var i = valueArray.length -1;i>=0;i--){
      tmpArray = valueRowArray[valueArray[i]];
      for(var j=0;j< tmpArray.length ;j++)
        tmpList.push(tmpArray[j]);
    }
  }

  for(var i=0;i<nullRowArray.length;i++)
    tmpList.push(nullRowArray[i]);

  for(var i=0;i<tmpList.length;i++){
    if(i == tmpList[i])continue;
    this.getRowObj(i).swapNode(this.getRowObj(tmpList[i]));

    for(var j= i + 1;j < tmpList.length;j++)
      if(tmpList[j] == i){
        tmpList[j] = tmpList[i];
        break;
    }
  }

  //�������õ�һ�еĿ��
  var tmpFirstRow = this.getRowObj(0);
  if(tmpFirstRow){
    for(var i = 0;i <  this.HeadTable.rows(0).cells.length ;i++)
      tmpFirstRow.cells(i).width = this.HeadTable.rows(0).cells(i).width;
  }
  //���������е���ʾ��ʽ
  this.modifyRowSequence(0);

  var dataTalbe = this.getTableObject()
  var tmpIndex =this.getMutilSelectColIndex();
  for(var i=0;i < dataTalbe.rows.length;i++){
    if ((dataTalbe.rows(i).isSelected)&&(dataTalbe.rows(i).isSelected == true)){
      dataTalbe.rows(i).className ="GD-SelectRow";
      dataTalbe.rows(i).cells(tmpIndex).children(0).checked = true;
    }
  }

  //�������õ�ǰ���к�
  if(currRowObj){
    this.CurRow = currRowObj.rowIndex;
    currRowObj.className = "GD-CurrentRow";
  }
}

//���Ԫ��ʧȥ�����¼�
function Private_SimpleTable_tdOnFocus(newRowId ,newColId){
  var oldRowIndex = this.CurRow;
  var oldColIndex = this.CurCol;
  newRowId =parseInt(newRowId);
  newColId =parseInt(newColId);
  var oldCell = this.getCell(this.CurRow,this.CurCol);
  if(oldCell)  oldCell.bgColor = "";

  this.currentRowChange(-1,oldRowIndex);

  var obj = this.getCell(newRowId,newColId);
  if (obj) obj.bgColor = this.CurCellBgColor;

  this.CurRow = newRowId;
  this.CurCol = newColId;

  this.currentRowChange(this.CurRow,-1);
  if (this.CurRow != oldRowIndex){
    if (this.OnRowFocusChange)
      this.OnRowFocusChange(oldRowIndex,newRowId);
  }
  if (this.OnCellFocusChange)
    this.OnCellFocusChange(oldRowIndex,oldColIndex,newRowId,newColId);
    
  return true;
}

//���ݱ��ʧȥ����
function PrivateIE_SimpleTable_dataOnFocusOut(aGridPK){
  var parentObj = g_TableRowSetManager.get(aGridPK);
  if(parentObj.CurRow < 0 || parentObj.CurCol < 0){
    return;
  }
  
  //�ж��Ƿ���ʧȥ��������û��¼�
  var dbgrid = g_TableRowSetManager.get(aGridPK);
  if(dbgrid.OnFocusOut==null)return;
  
  //�жϵ�ǰ�õ�����Ķ����Ƿ������head div��
  var head_div = document.getElementById("HeadAndTableDiv_" + aGridPK);
  var toElement = event.toElement;

  while(true){
    //˵���õ�����
    if(toElement==null ||toElement.tagName=='BODY')break;

    //˵���������ڲ�,û��ʧȥ����
    if(toElement== head_div)return;
      toElement = toElement.parentNode;
  }
  dbgrid.OnFocusOut();
}



var g_DBTREE_STRING = "DBTree";
var g_DBHTML_STRING = "DBHtml";

//��̬���ñ���ˮƽ�ʹ�ֱ������,���¹�����������ñ��̧ͷ�Ŀ��
function Private_Table_adjustHeadDivWidth(head_div ,data_div){
	try{
	  if(data_div.scrollHeight>data_div.clientHeight){
	      head_div.style.width=parseInt(data_div.style.width)-17;
	  }else{
	    head_div.style.width=data_div.style.width;
	  }
	
	  var srcollcontrolbar = document.getElementById("ScrollControlbar_" + data_div.DBGridPK);
	  if(srcollcontrolbar!=null){
	    srcollcontrolbar.style.width = parseInt(head_div.childNodes[0].width);
	  }
	}catch(e){}
}

//��ȡ������
function Private_Table_getTableObject(){
  return this.DataTable;
}

//��ȡ�ж���
function Private_Table_getRowObj(rowIndex){
  if(rowIndex == null){
    alert(g_I18NMessage("appframe_core","table_row_null"));
    return null;
  }
  rowIndex = parseInt(rowIndex);
  if ((rowIndex >=0)&&(rowIndex < this.realcount()))
     return this.getTableObject().rows(rowIndex);
  else
     return null;
}
//�жϵ�ǰ����Ƿ���ںϼ���
function Public_Table_hasTotalRow(){
  return this.m_hasTotalRow;
}
//��ȡ��ǰ����¼���������������ϼ���
function Public_Table_count(){
  if (this.hasTotalRow() == true)
    return this.getTableObject().rows.length - 1;
  else
    return this.getTableObject().rows.length;
}
//��ȡ��ǰ������ݵ��������������ϼ���
function Public_Table_realcount(){
  return this.getTableObject().rows.length;
}

//��ȡ��ǰ�е�����������������
function Public_Table_getColCount(){
  return this.colNames.length;
}
//��ȡ�������е��ܼ�¼��
function Public_Table_getVisiColCount(){
  return this.visioColCount;
}
//����������ȡ���е�����
function Public_Table_getColIndex(name){
  name = name.toUpperCase();
  var index = this.colIndexs[name];
  if(index == null)
    index = -1;
  return parseInt(index);
}
//���������Ż�ȡ����
function Public_Table_getNameByIndex(colIndex){
    return this.colNames[colIndex];
}
//��ȡ��ǰ��ѯ�����µ��ܼ�¼��
function Public_Table_getTotalRowCount(){ return this.totalRowCount;}
//�������ñ��Ĵ�С
function Public_Table_resize(width, height) {
try{
  var s = this.TableDiv.style.width;
  var index = s.indexOf("px");
  var oldWidth = parseInt(s.substring(0,index));

  s = this.TableDiv.style.height;
  index = s.indexOf("px");
  var oldHeight = parseInt(s.substring(0,index));

  if (width != "" && width != "-1") {
    width = parseInt(width);
    this.HeadAndTableDiv.style.width = width;
    this.TableDiv.style.width = width;
    this.FootDiv.style.width = width;
    this.FootTable.style.width = width;
  }else{
    width = this.HeadAndTableDiv.style.width;
  }
  if (height != "" && height != "-1") {
    height = parseInt(height);
    this.TableDiv.style.height = height;
  }else{
    height = this.TableDiv.style.height;
  }
  
   this.currentWidth = width;
   this.currentHeight = height;
   
  if(this.OnResize){
    this.OnResize(oldWidth,oldHeight,width,height);
  }
  
  this.adjustHeadDivWidth(this.HeadDiv,this.TableDiv);
  return true;
  }catch(e){
    alert(e + this.OnResize);
    return false;
  }
}

//��ȡ��ѡ�������е�����
function Public_Table_getMutilSelectColIndex(){
  var colIndex = 0;
  if(this.isRowSequence == true)
    colIndex = 1;
  return   colIndex;
}
//��ȡָ���е�ID������¼ID
function Public_Table_getRowId(rowIndex){
  var tmpRow = this.getRowObj(rowIndex);
  return tmpRow.I;
}
//��ȡ��ǰ������ڵ��к�
function Public_Table_getRow(){
   return this.CurRow;
}
//��ȡ��ǰ������ڵ��к�
function Public_Table_getCol(){
   return this.CurCol;
}
//��ȡ��ǰ����ѡ����к�
function Public_Table_getSelectedRows(){
   var result = new Array();
   if (this.isMutilSelect== true){
     var colIndex =this.getMutilSelectColIndex();
     for(var i=0; i < this.count();i++){
       var tmpRow = this.getRowObj(i);
       if (tmpRow.cells(colIndex).children(0).checked == true)
         result[result.length] = (i);
     }
   }
   else if (this.CurRow >=0)
     result[result.length] = (this.CurRow);

   return result;
}
//���ñ��ÿҳ�ļ�¼����
function Public_Table_setPageSize(aPageSize){
  var parentDiv = document.all("TableRowSet_ParentDiv_"+ this.DBGridPK);
  var pk = parentDiv.PK;
  var tUrl = _gModuleName + "/gridturnpage?action=setpagesize&pk=" + pk +"&pagesize=" + aPageSize;
  PostInfotoServer(tUrl,"");
}
//��ȡ����ǰ��񵼳�excel��URL��ַ
function Public_Table_toExcelUrl(filename ,onlyCurrentPageData ,useCurrentTitle,eachCount,userZipFormat){
  //�ж��Ƿ�ֻȡ��ǰҳ��
  var pageIndex = -1;
  if(onlyCurrentPageData!=null && (onlyCurrentPageData =='true' || onlyCurrentPageData ==true)){
    pageIndex = this.currPage;
    if(pageIndex==null || pageIndex=='') 
      pageIndex=-1;
  }
  
  if(useCurrentTitle==null)useCurrentTitle =false;
  
  var parentDiv = document.all("TableRowSet_ParentDiv_"+ this.DBGridPK);
  var pk = parentDiv.PK;
  
  //��ȡ��ǰ�������еı���
  var titles =''
  if(useCurrentTitle){
    for(i=0;i<this.getVisiColCount();i++){
        titles = titles + this.colNames[i]+"=";
        titles = titles + this.getTitle(this.colNames[i]) + ";";
    }
    if(titles==''){
      alert(g_I18NMessage("appframe_core","table_no_data"));
      return;
    }
    titles = g_ConditonStrEncode(titles.substring(0,titles.length -1));
  }
  
  if(eachCount == null) eachCount = -1;
  if(userZipFormat == null){
  	userZipFormat = false;
  }
  
  var excelOutputPK = -1;
  var tableTagInfo = document.all("TableTagInfo_" + this.DBGridPK);
  if(tableTagInfo != null && tableTagInfo.excelOutputPK !=null && tableTagInfo.excelOutputPK !=''){
  	 excelOutputPK = tableTagInfo.excelOutputPK;
  }
  
  var tUrl = _gModuleName + "/gridturnpage?action=toexcel&pk=" + pk +"&excelOutputPK="+excelOutputPK
      +"&filename=" + g_ConditonStrEncode(filename) +"&pageIndex=" + pageIndex +
      "&columnTitle=" + titles+ "&eachCount="+eachCount + "&userZipFormat="+userZipFormat;
  
  return tUrl;
}
//�����и�ѡ��ȫѡ��ȫ��ѡ����ָ���Ƿ���Ӧ�¼�
function Public_Table_selectAll(isSelected,isTriggerEvent){
  var colIndex =this.getMutilSelectColIndex();
  this.HeadTable.rows(0).cells(colIndex).children(0).checked = isSelected;
  for(var i=0; i < this.count();i++){
       var tmpRow = this.getRowObj(i);
       if(tmpRow.cells(colIndex).children(0) && tmpRow.cells(colIndex).children(0).style.display !="none"){
          tmpRow.isSelected = isSelected;
          tmpRow.cells(colIndex).children(0).checked = isSelected;
       }
  }
  if(isTriggerEvent != false){
       isTriggerEvent =true;
  }
  if(isTriggerEvent &&  this.OnRowSelected){
     this.OnRowSelected(-100,isSelected);
  }
}
//���ñ��ĳһ�еļ�¼��ѡ���״̬
function Public_Table_rowSelected(rowIndex,isSelected,isTriggerEvent){
  if (this.isMutilSelect== false){
    this.setRow(rowIndex);
    return;
  }

  var tmpRow = this.getRowObj(rowIndex);
  if (tmpRow==null)return;
  
  var colIndex =this.getMutilSelectColIndex();
  tmpRow.cells(colIndex).children(0).checked = isSelected;
  tmpRow.isSelected = isSelected;

  this.currentRowChange(rowIndex,this.CurRow);
  this.currentRowChange(this.CurRow,rowIndex);

  if(isTriggerEvent != false){
    isTriggerEvent =true;
  }
  if(isTriggerEvent && this.OnRowSelected){
    this.OnRowSelected(rowIndex,isSelected);
  }
}
//�ж�ĳһ�и�ѡ���Ƿ���ѡ��״̬
function Public_Table_isSelected(rowIndex){
  var result = false;
  if (this.isMutilSelect== true){
    var tmpRow = this.getRowObj(rowIndex);
    var colIndex =this.getMutilSelectColIndex();
    if ((tmpRow) &&(tmpRow.cells(colIndex).children(0).checked == true))
         result = true;
  }else if(this.CurRow  == rowIndex){
    result = true;
  }
  return result;
}
//���ñ��̧ͷ��ȫѡ��ѡ���״̬
function Public_Table_setAllSelectCheckBoxSts(flag){
  this.disabledSelect(-100,!flag)
}
//���ñ��ĳһ�и�ѡ���״̬�������̧ͷ��ѡ����rowIndex=-100
function Public_Table_disabledSelect(rowIndex,flag){
  if (this.isMutilSelect== true){
    var tmpRow;
    if(rowIndex == -100){
      tmpRow = this.HeadTable.rows(0);
    }else{
      tmpRow = this.getRowObj(rowIndex);
    }
    if(tmpRow){
      var colIndex =this.getMutilSelectColIndex();
      var obj = tmpRow.cells(colIndex).children(0);
      obj.disabled = flag;
    }
  }
}
//����ָ���еĸ�ѡ����ʾ��������
function Public_Table_visibleSelect(rowIndex,flag){
  var str = "none";
  if(flag == true)
    str = "block";

  if (this.isMutilSelect== true){
    var tmpRow;
    if(rowIndex == -100){
      tmpRow = this.HeadTable.rows(0);
    }else{
      tmpRow = this.getRowObj(rowIndex);
    }
    if(tmpRow){
      var colIndex =this.getMutilSelectColIndex();
      var obj = tmpRow.cells(colIndex).children(0);
      obj.style.display =str;
    }
  }
}
//������������title
function Public_Table_setTitle(colName,aTitle){
  var index = this.getColIndex(colName);
  this.setTitleByIndex(index,aTitle);
}
//�����������ñ�����
function Public_Table_setTitleByIndex(index,aTitle){
  if(index >=0){
    //���ı��title�������
    if(this.changeTitleArr == null){
      this.changeTitleArr = new Array();
    }
    this.changeTitleArr["" + index] = aTitle
    
    var cell = this.HeadTable.rows(0).cells(index + this.getRowHeadColCount());
    if(cell.childNodes.length<2){
      cell.innerText=aTitle;
    }else{
      cell.childNodes[1].innerText=aTitle;
    }
  }
}
//����������ȡtitle
function Public_Table_getTitle(colName){
  var index = this.getColIndex(colName);
  if(index >=0 && index <this.getVisiColCount()){
    return this.getTitleByIndex(index);
  }
  else{
    alert(g_I18NMessage("appframe_core","table_illegal_field") + ": " + colName);
  }
}
//����������ȡ������
function Public_Table_getTitleByIndex(index){
  if(index >=0 && index <this.getVisiColCount()){
    var cell = this.HeadTable.rows(0).cells(index + this.getRowHeadColCount());
    if(cell.childNodes.length<2){
      return cell.innerText;
    }else{
      return cell.childNodes[1].innerText;
    }
  }else{
    alert(g_I18NMessage("appframe_core","table_illegal_index") + index);
  }
}
//��ȡ����ڷ�����������
function Public_Table_getServerPK(){
  var parentDiv = document.all("TableRowSet_ParentDiv_"+ this.DBGridPK);
  return parentDiv.PK;
}
//��ȡ����еĿ��
function Public_Table_getColWidth(colIndex){
  if(colIndex == null || colIndex<0 || colIndex>=this.getVisiColCount()) return -1;
  
   var cell = this.HeadTable.rows(0).cells(colIndex + this.getRowHeadColCount());
   if(cell)
      return cell.width;
   else
      return -1;
}
//���ñ���еĿ��
function Public_Table_setColWidth(colName,newWidth){
  var colIndex = this.getColIndex(colName);
  var incWidth  = newWidth - this.getColWidth(colIndex);
  for(var i=0;i< this.HeadTable.rows.length; i++){
    this.HeadTable.rows(i).cells(colIndex + this.getRowHeadColCount()).width = newWidth;
  }
  this.HeadTable.width = parseInt(this.HeadTable.width) + incWidth;

  if (this.DataTable && this.DataTable.rows.length >0){
    this.DataTable.rows(0).cells(colIndex+this.getRowHeadColCount()).width = newWidth;
    this.DataTable.width = parseInt(this.DataTable.width) + incWidth;
  }
}

//��ȡ��ǰ������е�����,����������
function Public_Table_getColNames(){ return this.colNames;}
//��ȡ��¼��һ������
function Public_Table_getStartRowIndex(){
  return 0;
}
//��ȡ��¼���һ������
function Public_Table_getEndRowIndex(){
  return this.count() - 1;
}
//ѡ��ĳһ��
function Public_Table_setRow(rowIndex){
  this.tdOnFocus(rowIndex,this.CurCol);
}
//�����������к�ѡ��ĳ����Ԫ��
function Public_Table_setFocusByName(rowIndex,colName){
  var index = this.getColIndex(colName);
  this.setFocus(rowIndex,index);
}
//�����кź��к�ѡ��ĳ����Ԫ��
function Public_Table_setFocus(rowIndex,colIndex){
  rowIndex = parseInt(rowIndex);
  colIndex = parseInt(colIndex);
  this.tdOnFocus(rowIndex,colIndex);
}
//��ӡ���
function Public_Table_print(printTitle){
    var html = "<table border='1' borderColor='#000000' width ='" + this.HeadTable.width +"'"
    + "style='border-collapse: collapse;table-layout: fixed'>"
    + this.HeadTable.tHead.outerHTML
    + this.DataTable.tBodies(0).outerHTML
    +"</table>";
    if(!printTitle)
    printTitle="";
    var list= new Array();
    list[0] = printTitle;
    list[1] = html;
    window.showModalDialog( _gModuleName+ "/jsv2/print.htm",list,'resizable:no;help:no; status:no;resizable:yes;dialogWidth:600px;dialogHeight:400px');
}
//���ˢ��
function Public_Table_refresh(aCondition,parameter,qryset,isShowErrMsg){
  return this.refreshByDefineQeruy(null,aCondition,parameter,qryset,isShowErrMsg);
}
function Public_Table_refreshForObd(parameters,qryset,aCondition,isShowErrMsg){
  var obj =  this.refresh(aCondition,parameters,qryset,isShowErrMsg);
  if(this.count()==0){
    this.visibleSelect(-100,false);
  }
  return obj;
}
function Public_Table_refreshByDefineQeruy(queryid,aCondition,parameter,qryset,isShowErrMsg){
  this.recordTableInfo();
  var obj= Private_Table_refreshLast(this.DBGridPK,aCondition,parameter,qryset,queryid,isShowErrMsg);
  this.restoreTableInfo();
  return obj;
}
function Private_Table_refreshData(aGridPK,aCondition,parameter,qryset,queryid,isShowErrMsg,qrysetXmlFlag){
  return Private_Table_refreshLast(aGridPK,aCondition,parameter,qryset,queryid,isShowErrMsg,qrysetXmlFlag);
}
function Private_Table_refreshLast(aGridPK,aCondition,parameter,qryset,queryid,isShowErrMsg,qrysetXmlFlag){
  var parentDiv = document.all("TableRowSet_ParentDiv_"+ aGridPK);
  if(parentDiv.canrefresh == "false"){
    alert(g_I18NMessage("appframe_core","table_cannot_refresh"));
    return;
  }
  parentDiv.refreshOpt=true;
  var pk = parentDiv.PK;

  var conditionname = parentDiv.conditionname;
  if ((conditionname) && (aCondition))
    aCondition = conditionname + "=" +g_ConditonStrEncode(aCondition);

  var tUrl = _gModuleName + "/gridturnpage?";
  if(!queryid){
    tUrl = tUrl + "action=refresh&pk=" + pk +"&" + aCondition;
  }else{
    tUrl = tUrl + "action=refreshbydefinequery&pk=" + pk +"&queryid="+ queryid+"&"+ aCondition;
  }
  if(parameter)
    tUrl = tUrl + "&" + parameter;
  
  //��԰ٷ���ˢ�µģ��ѵ�ǰ�Ŀ�ȴ�����̨
  if(parentDiv.percentWidth != null && parentDiv.percentWidth != '' ){
  	tUrl = tUrl + "&tmpPercentWidth=" + document.all("HeadAndTableDiv_" +aGridPK).clientWidth ;
  }
  
  var tmpstr=""
  if(qryset != null){
    if(qryset.getClassName!=undefined && qryset.getClassName()=="UserDataClass"){
      tmpstr = tmpstr + qryset.toXmlString(true);
    }
    else if(typeof(qryset)=="string"){
      tmpstr = qryset;
    }else{
      var tmpstr  = "<RootInfo>"
      if(qrysetXmlFlag!=null && qrysetXmlFlag==false){
        tmpstr = tmpstr + qryset.toXmlString(false);
      }
      else{
        tmpstr = tmpstr + qryset.toXmlString(true);
      }
      tmpstr = tmpstr   + "</RootInfo>";
    }
  }

	var xmlNode =null;
	if(parentDiv.isSTable != null && parentDiv.isSTable !=""){
		xmlNode = g_TableRowSetManager.get(aGridPK).s_refresh(tUrl,tmpstr);
	}else{
	  //���ػ���
	  if(pk=='-1'){
		tUrl = tUrl + "&localcache=table";
		tmpstr = document.all("TableTagInfo_" + aGridPK).value +tmpstr;
	  }
	  var sRe=PostInfotoServer(tUrl,tmpstr);
	  var xml = new ActiveXObject("Msxml.DOMDocument");
	  xml.async = false;
	  xml.loadXML(sRe);
	  xmlNode = xml.documentElement;
   }

  //����д�������ʾ������Ϣ��ֱ�ӷ���
  if(xmlNode.nodeName=="UD"){
    var ud =createUserDataClass(xmlNode);
    if(isShowErrMsg != false){
      var message =ud.getValueByName("MESSAGE");
      if(message){
        alert(message);
      }
    }
    return ud;
  }
  parentDiv.innerHTML = xmlNode.text;
  g_TableRowSetManager.reinitial(aGridPK);

  //û���κδ�����Ϣ������һ��null��
  return null;
}

//��ѡ����иı��ʱ�������еı�����ɫ
function Private_Table_currentRowChange(newRowIndex,oldRowIndex){
  var tmpRow = null;
  if ((oldRowIndex >=this.getStartRowIndex())&&(oldRowIndex <= this.getEndRowIndex())){
    tmpRow = this.getRowObj(oldRowIndex);
    if(tmpRow){
      if ((tmpRow.isSelected)&&(tmpRow.isSelected == true)){
        tmpRow.className ="GD-SelectRow";
        //�����û����õ�ĳһ�е��ض���ɫ
        if(this.SelectBgColor)
          tmpRow.style.backgroundColor = this.SelectBgColor;
      }else{//
        if(oldRowIndex %2==0)
          tmpRow.className ="GD-Two";
        else
          tmpRow.className ="GD-One";
        if(tmpRow.SelfBgColor)
          tmpRow.backgroundColor = tmpRow.SelfBgColor;
        else
          tmpRow.backgroundColor = "";
      }
    }
  }
  if ((newRowIndex >=this.getStartRowIndex())&&(newRowIndex <= this.getEndRowIndex())){
    tmpRow = this.getRowObj(newRowIndex);
    if(tmpRow){
      tmpRow.className = "GD-CurrentRow";
      if(this.CurRowBgColor)
        tmpRow.backgroundColor = this.CurRowBgColor;
    }
  }
  //����ǰ��Ԫ��ı�����ɫ
  if (this.CurCol >=0){
    var tmpCell = this.getCell(oldRowIndex,this.CurCol);
    if (tmpCell){
      tmpCell.bgColor = "";
      tmpCell.className="GD-TD";
    }
    tmpCell = this.getCell(newRowIndex,this.CurCol);
    if(tmpCell){
      tmpCell.className="GD-CurrentCell";
      if(this.CurCellBgColor)
        tmpCell.bgColor = this.CurCellBgColor;
    }
  }
}
//��������������
function  Private_SimpleTable_clear(){
  var obj =this.getTableObject();
  for(var rowIndex = obj.rows.length- 1;rowIndex>=0;rowIndex--)
      obj.deleteRow(rowIndex);
}
//��ȡ��񸽼�����ռ�����������ѡ�л����к���
function Private_Table_getRowHeadColCount(){
  var result =0;
  if (this.isMutilSelect == true)
     result = result+ 1;

  if (this.isRowSequence == true)
     result = result+ 1;
  return result;
}

//��¼���Ĵ�С���п� ���Լ���������λ�� ��hexg ,2007-4-25
function Private_Table_recordTableInfo(){
  //�����ԭ�ȵĿ��
  if(this.colWidthArray == null){
    this.colWidthArray = new Array();
  }
  
  //�����ԭ����Щ�б��û�������
  if(this.colHideByUserArray == null){
    this.colHideByUserArray = new Array();
  }
  
  var cells = this.HeadTable.rows(0).cells;
  for(i=0;i<cells.length;i++){
  	//������в����أ����¼��ǰ��ȣ����򣬼�¼����֮ǰ�Ŀ��
  	if(cells(i).preWidth == null){
    	this.colWidthArray[i] = cells(i).width;
    	this.colHideByUserArray[i] = false;
    }else{
    	this.colWidthArray[i] = cells(i).preWidth;
    	this.colHideByUserArray[i] = true;
    }
  }
  //��¼ԭ�ȹ��������ڵĴ�ֱλ�ú�ˮƽλ��
  this.scrollLeft = this.TableDiv.scrollLeft;
  this.scrollTop = this.TableDiv.scrollTop;
}

//��ԭ���Ĵ�С���п� ����������λ�� ,�Լ���̬���ù���title
function Private_Table_restoreTableInfo(){
  //����ԭ�ȵĳ��Ϳ�
  if(this.currentWidth && this.currentHeight){
    this.resize(this.currentWidth,this.currentHeight);
  }

  //����ԭ�ȸ����еĿ��
  if(this.colWidthArray != null){
    //����̧ͷ�п�
    var cells = this.HeadTable.rows(0).cells;
    for(i=0;i<this.colWidthArray.length;i++){
    	this.HeadTable.width = parseInt(this.HeadTable.width ) + (this.colWidthArray[i]-cells(i).width);
        cells(i).width = this.colWidthArray[i];
  }  
    //���������п�
    var rows = this.DataTable.rows;
    if(rows.length>0){
      var cells = rows(0).cells;
        for(i=0;i<this.colWidthArray.length;i++){
          cells(i).width = this.colWidthArray[i];
        }  
    }
    
   	this.DataTable.width=this.HeadTable.width;
   	
   	//��ԭ�����ص����ٴ�����
   	for(i=0;i<this.colHideByUserArray.length;i++){
    	if(this.colHideByUserArray[i] == true){
        	this.setColVisible(this.HeadTable.rows(0).cells(i).FieldID , false);
        }
	}  
  }
  
  //����ԭ�ȹ��������ڵĴ�ֱλ�ú�ˮƽλ��
  if(this.scrollLeft!= null && this.TableDiv.scrollWidth>this.scrollLeft){
    this.TableDiv.scrollLeft = this.scrollLeft;
  }
  if(this.scrollTop!= null && this.TableDiv.scrollHeight>this.scrollTop){
    this.TableDiv.scrollTop = this.scrollTop;
  }
  
  //��ԭͨ��JS���ù��ı���TITLE
  if(this.changeTitleArr != null){
    for(var prop in this.changeTitleArr){
    	if(isNaN(parseInt(prop)))continue;
        this.setTitleByIndex(parseInt(prop) ,this.changeTitleArr[prop]);
    }
  }
  
  this.adjustHeadDivWidth(this.HeadDiv,this.TableDiv);
}
//�������ñ������е���ʽ
function Private_Table_modifyRowSequence(rowIndex){
   var dataTable = this.getTableObject();
   for(var i=rowIndex;i < dataTable.rows.length;i++){
      if(this.isRowSequence == true){
           dataTable.rows(i).cells(0).innerText = i+1;
      }
      if(dataTable.rows(i).IsTotal)
         dataTable.rows(i).className ="GD-Total-TR";
      else if(i%2==0)
         dataTable.rows(i).className ="GD-Two";
      else
         dataTable.rows(i).className ="GD-One";
   }
}

//���ַ�����
function sortFunction(a,b){
  if(a == b)
    return 0;
  else if (a > b)
    return 1;
  else
    return -1;
}

//����������
function sortDigit(a,b){
  var tmpA = parseFloat(a);
  var tmpB = parseFloat(b);
  if(isNaN(tmpA) == false && isNaN(tmpB)== false){
     if(tmpA == tmpB)
       return 0;
     else if (tmpA > tmpB)
       return 1;
     else
       return -1;
  }else{
     if(a == b)
       return 0;
     else if (a > b)
       return 1;
     else
       return -1;
  }
}

function Private_SimpleTable_getClassName(){ return "TableRowSetSimple";}

function Private_Table_checkAndTrans(str){
  str = str.toString();
  if(Private_Table_checkStr(str))
    return Private_Table_transStr(str);
  else
    return str;

}
function Private_Table_checkStr(str){
  if(str.indexOf("&")>=0||str.indexOf(">")>=0||str.indexOf("<")>=0||str.indexOf("'")>=0||str.indexOf('"')>=0)
    return true;
   else
    return false;
}
/**
���������ַ��滻,add by zhuwg
 */
function Private_Table_transStr(str){
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
//====���´���ʵ�ֱ��̧ͷ��������======
var g_Grid_Min_ColWidth = 10;
var g_Grid_Min_RowHeight = 10;
//����ڱ��̧ͷ�ƶ�ʱ����Ӧ�¼�
function Private_TableDrag_mouseMove(element){
    if (element.isContentEditable) return;
    if(element.isBeginDrop) return;
    
    var obj = window.event.srcElement;
     //alert(obj.tagName);
      //alert(Math.abs(event.offsetX - obj.clientWidth));
    if ((obj.tagName.toLowerCase() == "td"  || obj.tagName.toLowerCase() == "span") && Math.abs(event.offsetX - obj.clientWidth) <= 5){

       obj.runtimeStyle.cursor='col-resize';
      }
    else if ((element.IsRowResize =="true"||element.IsRowResize==true)&&(obj.tagName.toLowerCase() == "td"  || obj.tagName.toLowerCase() == "span") && Math.abs(event.offsetY - obj.clientHeight) <= 3)
      {obj.runtimeStyle.cursor='row-resize';        }
    else
{      obj.runtimeStyle.cursor='default';}
}
//���̧ͷ��갴����Ӧ�¼�
function Private_TableDrag_mouseDown(element){
    if (element.isContentEditable) return;
    var obj = window.event.srcElement;
    if ((obj.tagName.toLowerCase() == "td")&&  Math.abs(event.offsetX - obj.clientWidth) <= 5)
    {             
      obj.runtimeStyle.cursor='col-resize';   
      element.isBeginDrop = true;
      obj.dragDrop();
      element.isBeginDrop = false;
      var incWidth = element.endScreenX - element.startScreenX;
      Private_TableDrag_setColWidth(element,obj.cellIndex,incWidth);
      obj.runtimeStyle.cursor='default';
    }else if ((element.IsRowResize =="true"||element.IsRowResize ==true)&&(obj.tagName.toLowerCase() == "td"  || obj.tagName.toLowerCase() == "span") && Math.abs(event.offsetY - obj.clientHeight) <= 3){
      obj.runtimeStyle.cursor='row-resize';   
      element.isBeginDrop = true;        
      obj.dragDrop();
      element.isBeginDrop = false;
      var incHeight = element.endScreenY - element.startScreenY;
      Private_TableDrag_setRowHeight(element,obj.parentNode,incHeight);
      obj.runtimeStyle.cursor='default';
    }
     else if((obj.tagName.toLowerCase() == "span")&&  Math.abs(event.offsetX - obj.clientWidth) <= 5)
    {
    obj = obj.parentNode;
     obj.runtimeStyle.cursor='col-resize';   
      element.isBeginDrop = true;
      obj.dragDrop();
      element.isBeginDrop = false;
      var incWidth = element.endScreenX - element.startScreenX;
      Private_TableDrag_setColWidth(element,obj.cellIndex,incWidth);
      obj.runtimeStyle.cursor='default';
    }    
    else if ((element.IsRowResize =="true"||element.IsRowResize ==true)&&(obj.tagName.toLowerCase() == "span") && Math.abs(event.offsetY - obj.clientHeight) <= 3){
      obj=obj.parentNode;
      obj.runtimeStyle.cursor='row-resize';   
      element.isBeginDrop = true;        
      obj.dragDrop();
      element.isBeginDrop = false;
      var incHeight = element.endScreenY - element.startScreenY;
      Private_TableDrag_setRowHeight(element,obj.parentNode,incHeight);
      obj.runtimeStyle.cursor='default';
    }          
}

//���ñ�ͷ�п�
function Private_TableDrag_setColWidth(element,colIndex,incWidth){
  if ((element.IsCustomerColResizeFunc == "true") ||(element.IsCustomerColResizeFunc == true)){
    var newWidth  = parseInt(element.rows(0).cells(colIndex).width )+ incWidth;
    if(newWidth < 5){
     newWidth =5;
     incWidth = newWidth -parseInt(element.rows(0).cells(colIndex).width );
    }
    for(var i=0;i< element.rows.length; i++){
       element.rows(i).cells(colIndex).width = newWidth;
    }
    element.width = parseInt(element.width) + incWidth;

    var dataTable = document.all("DataTable_" + element.DBGridPK);
    if (dataTable && dataTable.rows.length >0){
      dataTable.rows(0).cells(colIndex).width = newWidth;
      dataTable.width = parseInt(dataTable.width) + incWidth;
    }
   
    var head_div = window.document.all("HeadDiv_" + element.DBGridPK);
    var data_div = window.document.all("TableDiv_" + element.DBGridPK);
    Private_Table_adjustHeadDivWidth(head_div,data_div);
    return;
  }
  if (aTable.rows.length <=0) return;
  
  var newWidth = parseInt(aTable.rows(0).cells(colIndex).clientWidth) + parseInt(incWidth);
  if (newWidth <g_Grid_Min_ColWidth){
     newWidth = g_Grid_Min_ColWidth;
     incWidth = newWidth - parseInt(aTable.rows(0).cells(colIndex).clientWidth);
  }
  aTable.style.width = parseInt(aTable.clientWidth) + incWidth + 1;
  aTable.width = aTable.style.width;
  
  for(var i=0;i<aTable.rows.length;i++)
   aTable.rows(i).cells(colIndex).width = newWidth;
} 

//���ñ�ͷ�и�
function Private_TableDrag_setRowHeight(aTable,aRow,incHeight){
  var newHeight = aRow.clientHeight + parseInt(incHeight);
  if (newHeight < g_Grid_Min_RowHeight){
     newHeight = g_Grid_Min_RowHeight;
     incHeight = newHeight -  aRow.clientHeight;
  }
  aTable.height = aTable.clientHeight +  incHeight + 1;
  aRow.height = newHeight;
  aTable.style.height = aTable.height;
}
//���̧ͷ����������Ӧ�¼�
function Private_TableDrag_endDrag(element){        
  element.endScreenX =event.screenX;
  element.endScreenY =event.screenY;
  window.event.returnValue = false;
  window.event.cancelBubble = true;
}
//���̧ͷ������ʼ��Ӧ�¼�
function Private_TableDrag_beginDrag(element){
  element.startScreenX =event.screenX;
  element.startScreenY =event.screenY;
}
//====���ϴ���ʵ�ֱ��̧ͷ��������======

//===���´���ΪIEҳ������HTML����ʱ����====
//˫�����̧ͷ��Ӧ�¼�

function PrivateIE_Table_OnTitleDbClick(aGridPK){
  var obj = window.event.srcElement;
  //�����div����������һ��
  if(obj.tagName.toLowerCase() =='span'){
    obj = obj.parentNode;
  }
  
  if (obj.FieldID && (obj.tagName.toLowerCase() == "td" || obj.tagName.toLowerCase() == "th")){
      var parentObj = g_TableRowSetManager.get(aGridPK);
      var parentDiv = document.all("TableRowSet_ParentDiv_"+ aGridPK);
  
      //���ֶε�sorttype�����������div��
      var fieldTypeSort = eval("parentDiv." + obj.FieldID +"_SortType");
      if(fieldTypeSort == true){
            fieldTypeSort = false;
            eval("parentDiv." + obj.FieldID +"_SortType=false");
      }else{
            fieldTypeSort = true;
            eval("parentDiv." + obj.FieldID +"_SortType=true");
      }
      
      //�����˫���¼�����ִ��˫���¼�������ִ��Ĭ�ϵ�����ʽ
      if(parentObj.S_OnTitleDbClick){
        parentObj.S_OnTitleDbClick(obj.FieldID ,fieldTypeSort);
      }else {
        var sortFunction = null;
        if(parentObj.sortFunctionArray != null){
          sortFunction = parentObj.sortFunctionArray[obj.FieldID];
          if(typeof(sortFunction)=='undefined'){
            sortFunction = null;
          }
        }
	    parentObj.sort(obj.FieldID,fieldTypeSort,sortFunction);
      }
      
      //��������ͼ��
      parentObj.setColSortIcon(obj.FieldID,fieldTypeSort);
  }
}

function TableRowSet_OnDBLink(aGridPK,aColName,aId){
  var parentObj = g_TableRowSetManager.get(aGridPK);
  if(parentObj.OnDBLink){
  	  TableRowSet_OnClick(aGridPK);
      parentObj.OnDBLink(aColName,aId);
  }
}

function TableRowSet_OnClick(aGridPK){
  var obj = window.event.srcElement;
  var parentObj = g_TableRowSetManager.get(aGridPK);
  if ((obj.tagName == "TD")){
    var rowid = parseInt(obj.parentNode.rowIndex);
    var colid = parseInt(obj.cellIndex) - parentObj.getRowHeadColCount();
    parentObj.tdOnFocus(rowid,colid);
  }else if((obj.tagName == "A" ||obj.tagName == "SPAN")){
    var rowid = parseInt(obj.parentNode.parentNode.rowIndex);
    var colid = parseInt(obj.parentNode.cellIndex) - parentObj.getRowHeadColCount();
    parentObj.tdOnFocus(rowid,colid);
  }else if((obj.tagName == "INPUT" && obj.type=="checkbox" && obj.AG)){
    var rowid = parseInt(obj.parentNode.parentNode.rowIndex);
    var colid = parseInt(obj.parentNode.cellIndex) - parentObj.getRowHeadColCount();
    var tmpRow = parentObj.getRowObj(rowid);
    if (tmpRow){
         tmpRow.isSelected = obj.checked;
         parentObj.currentRowChange(rowid,parentObj.CurRow);
         parentObj.currentRowChange(parentObj.CurRow,rowid);
    }
    if(colid < 0 && parentObj.OnRowSelected){
       parentObj.OnRowSelected(rowid,obj.checked);
    }
  }
}

//���ñ��ĳһ������ͼ��,sortType��ʾ�����ǽ��� ��ֵ��true/false
function Private_SimpleTable_setColSortIcon(colName ,sortType){
   
colName = colName.toUpperCase();
  
  var cells = this.HeadTable.rows(0).cells;
  for(var i = this.getRowHeadColCount();i <  cells.length ;i++){
    //�����������ͼ��
    if(cells[i].FieldID == colName){  
      if (sortType != false){
        cells[i].childNodes[0].className='GH-SORT-ASC';
      }else{
        cells[i].childNodes[0].className='GH-SORT-DESC';
      } 
    }  
    else{
      cells[i].childNodes[0].className='GH-SORT';
    }
   
  }
}

//�������ȫѡ����Ӧ�¼�
function PrivateIE_Table_allSelectChange(aPK){
  var isSelected = window.event.srcElement.checked;
  var parentObj = g_TableRowSetManager.get(aPK);
  parentObj.selectAll(isSelected,true);
}
//ʵ��̧ͷ�����ݹ�������ͬ��
function PrivateIE_Table_dataDivScroll(headDivName){
  var obj = window.event.srcElement;
  //���¹�����
  var head_div = document.all(headDivName);
  Private_Table_adjustHeadDivWidth(head_div,obj);
  head_div.scrollLeft = obj.scrollLeft;
}
//��������ݱ�����Ҽ�
function PrivateIE_Table_dataDoContextMenu(aGridPK ,bOnFocus){
  var obj = window.event.srcElement;
  var parentObj = g_TableRowSetManager.get(aGridPK);
  if(parentObj){
    var rowid =-1;
    var colid =-1;
    if (obj.tagName == "TD" && bOnFocus == true){
        rowid = parseInt(obj.parentNode.rowIndex);
        colid = parseInt(obj.cellIndex) - parentObj.getRowHeadColCount();
        parentObj.tdOnFocus(rowid,colid);
    }
    if(parentObj.OnContextMenu)
      parentObj.OnContextMenu(rowid,colid)
  }
  window.event.returnValue = null;
}

//���ݱ��ID���ñ�������
function PrivateIE_Table_adjustTableSize(tableId){
	try{
	  //������DIV
	  var outerDiv = document.all("HeadAndTableDiv_" + tableId);
	  
	  //���ñ�ͷDIV������DIV�Ĵ�С
	  var head_div = window.document.all("HeadDiv_" + tableId);
	  var data_div = window.document.all("TableDiv_" + tableId);
	  
	  
	  head_div.style.width = outerDiv.clientWidth;
	  data_div.style.width = outerDiv.clientWidth;
	  
	
	  //���ñ��β��DIV��table�Ŀ��
	  var footdiv = document.all("FootDiv_"+ tableId);
	  var foottable = document.all("FootTable_"+ tableId);
	  foottable.width = outerDiv.offsetWidth;
	  footdiv.width = outerDiv.offsetWidth;
	  
	  //����ÿ���еĿ��
	  var head_table = document.all("HeadTable_" + tableId);
	  var headtable_cells = head_table.rows(0).cells;
	  
	 
	  var totalPercentWidth = 0;
	 
	  for(i=0;i<headtable_cells.length;i++){
	  	if(headtable_cells[i].percentWidth ==null || headtable_cells[i].percentWidth =='')continue;
	  	if(headtable_cells(i).preWidth != null && headtable_cells(i).preWidth!='')continue;
	  	
	  	//������
	  	if(totalPercentWidth==0){
			totalPercentWidth=outerDiv.clientWidth;
			if(data_div.scrollHeight>data_div.clientHeight ){
				totalPercentWidth = totalPercentWidth-17;
			}
			
			for(k=0;k<headtable_cells.length;k++){
				if(headtable_cells[k].FieldID ==null || headtable_cells[k].FieldID ==''){
					totalPercentWidth = totalPercentWidth -headtable_cells[k].offsetWidth;
				}
			}	
	  	}
	  	
	  	var percent =  headtable_cells[i].percentWidth.replace("%","");
	  	var incWidth = parseInt(percent)/100 * totalPercentWidth - headtable_cells[i].width-1;
	  	
	  	Private_TableDrag_setColWidth(head_table,i,incWidth)
	  }
	  	
	  Private_Table_adjustHeadDivWidth(head_div ,data_div);
  
	  //���ñ��û�в�ѯ����¼��div
	  var dataTable = document.all("DataTable_" + tableId);
      if (dataTable ==null || dataTable.rows.length == 0){
      	 var parentDiv = document.all("TableRowSet_ParentDiv_"+ tableId);
      	 var noResultDiv = document.all("NoResultDiv_" + tableId);
      	 if(noResultDiv != null && parentDiv.refreshOpt==true){
      	 	noResultDiv.style.display='';
      	 	noResultDiv.style.height=data_div.clientHeight-20;
      	 }
      }
   }catch(e){
  	//������ڼ��ص�ʱ�򱨴�����onload��ʱ��Ҫ����һ��
  	if(event == null || event.srcElement == null){
		var adjust_onload= function(){
			PrivateIE_Table_adjustTableSize(tableId);
  		}
  		window.attachEvent('onload', adjust_onload);
  	}
  }
}

//�����ݱ����˫��
function PrivateIE_SimpleTable_dataOnDbClick(aGridPK){
  var obj = window.event.srcElement;
  var parentObj = g_TableRowSetManager.get(aGridPK);
  if ((obj.tagName == "TD")){
    var rowid = parseInt(obj.parentNode.rowIndex);
    var colid = parseInt(obj.cellIndex) - parentObj.getRowHeadColCount();
    parentObj.tdOnFocus(rowid,colid);
    if (parentObj.OnGridDbClick)
      parentObj.OnGridDbClick(rowid,colid);
  }
}

//���ҳ
function TableRowSet_turnPage(aGridPK,tag){
  var sTime = new Date();
  var parentObj = g_TableRowSetManager.get(aGridPK);
  if(parentObj.pageCount <=1)
   return;
  var pageIndex;

  if(tag =="first") pageIndex = 1;
  else if(tag =="previous") pageIndex = parentObj.currPage - 1;
  else if(tag =="next") pageIndex = parentObj.currPage + 1;
  else if(tag =="last") pageIndex = parentObj.pageCount;
  else if(tag =="goto"){
     var s = document.all("TableRowSet_"+ aGridPK + "_goToPage").value;
     if(s == null || s =="")
       return;
     pageIndex =parseInt(s);
      if( isNaN(parseInt(pageIndex))==true){
         alert(g_I18NMessage("appframe_core","table_page_err"));
         return;
      }
  }
  if (pageIndex <1)  pageIndex = 1;
  else if(pageIndex > parentObj.pageCount) pageIndex = parentObj.pageCount;

  if(pageIndex == parentObj.currPage)
    return;

  if(parentObj.OnBeforeTurnPage){
      var b = parentObj.OnBeforeTurnPage(parentObj.currPage,pageIndex);
      if(b == false)
         return;
  }

  var parentDiv = document.all("TableRowSet_ParentDiv_"+ aGridPK);
  
  var xmlNode =null;
  if(parentDiv.isSTable == null || parentDiv.isSTable ==""){
		var pk = parentDiv.PK;
		var tUrl = _gModuleName + "/gridturnpage?action=turnpage&pk=" + pk +"&newpage=" + pageIndex;
		var xml= new ActiveXObject("Msxml.DOMDocument");
		xml.async = false;
		var b = xml.load(tUrl);
		xmlNode = xml.documentElement;
  }else{
  	xmlNode = parentObj.s_turnPage(aGridPK ,pageIndex);
  }

  parentObj.recordTableInfo();
  parentDiv.innerHTML = xmlNode.text;
  g_TableRowSetManager.reinitial(aGridPK);
  parentObj.restoreTableInfo();
}


//���ݱ�񵥻�
function PrivateIE_Table_dataOnClick(aGridPK){
  var obj = window.event.srcElement;
  var parentObj = g_TableRowSetManager.get(aGridPK);
  if ((obj.tagName == "TD")){
    var rowid = parseInt(obj.parentNode.rowIndex);
    var colid = parseInt(obj.cellIndex) - parentObj.getRowHeadColCount();
    parentObj.tdOnFocus(rowid,colid);
  }else if((obj.tagName == "A" ||obj.tagName == "SPAN")){
    var rowid = parseInt(obj.parentNode.parentNode.rowIndex);
    var colid = parseInt(obj.parentNode.cellIndex) - parentObj.getRowHeadColCount();
    parentObj.tdOnFocus(rowid,colid);
  }else if((obj.tagName == "INPUT" && obj.type=="checkbox" && obj.AG)){
    var rowid = parseInt(obj.parentNode.parentNode.rowIndex);
    var colid = parseInt(obj.parentNode.cellIndex) - parentObj.getRowHeadColCount();
    var tmpRow = parentObj.getRowObj(rowid);
    if (tmpRow){
      tmpRow.isSelected = obj.checked;
      parentObj.currentRowChange(rowid,parentObj.CurRow);
      parentObj.currentRowChange(parentObj.CurRow,rowid);
    }
    if(colid < 0 && parentObj.OnRowSelected){
       parentObj.OnRowSelected(rowid,obj.checked);
    }
  }else if(obj.tagName =="INPUT" && obj.DBTreeExtend){//���ڵ����չ
    var rowid = parseInt(obj.parentNode.parentNode.rowIndex);
    var colid = parseInt(obj.parentNode.cellIndex) - parentObj.getRowHeadColCount();
    var resultRowList = new Array();
    if(obj.parentNode.parentNode.isopen == false){
      obj.value ="-";
      parentObj.open(rowid,resultRowList,true);
    }else{
      obj.value ='+';
      parentObj.close(rowid,resultRowList,true);
    }
  }
}

function TableRowSet_onkeyfunc(func,aGridPK) {
	var obj = g_TableRowSetManager.get(aGridPK);
	try{
		eval(func+"('"+window.event.keyCode+"','"+obj.getRow()+"','"+obj.getCol()+"')");
	}catch(ex){
		alert(ex.name+":"+ex.message);
	}
}


function TableRowSet_clearPageGridsCache(){
	
	var divs = document.getElementsByTagName("div");
	var gridPks = new Array();
	for (var i = 0;i < divs.length;i++){
		if (divs[i].id.indexOf("TableRowSet_ParentDiv_") > -1 && divs[i].PK !="-1"){
			gridPks.push(divs[i].PK);
		}
	}
	if (gridPks.length > 0){
	    var XMLSender = g_GetXMLHTTPRequest();
	    XMLSender.Open("POST",_gModuleName + "/gridturnpage?action=clearpks&pks="+gridPks.join(","),true);
	    XMLSender.setRequestHeader("Content-Type","multipart/form-data");
	    XMLSender.send(null);
	}
	window.detachEvent("onunload",TableRowSet_clearPageGridsCache);
}
if (typeof(_isClearCacheObj)!="undefined" && _isClearCacheObj == "Y"
	&& typeof(_isClearCacheFuncLoad)=="undefined"){
	window.attachEvent("onunload",TableRowSet_clearPageGridsCache);
	var _isClearCacheFuncLoad=true;
}




//-----------------------add------------------------------------------------
 
//����뿪  table�������еı����ص���ʼ��
function Private_TableDrag_mouseOutTab(aGridPK){
         var obj = window.event.srcElement;
      var parentObj = g_TableRowSetManager.get(aGridPK);
      var tagname = obj.tagName;
     var rowid = parseInt(obj.parentNode.rowIndex);
     
    var i = rowid;
    
    if(tagname=="TD"&&i%2==0&&tagname!="TABLE"){
    obj = obj.parentNode;
    obj.className="GD-Two";
    }
     
    if(tagname=="TD"&&tagname!="TABLE"&&i%2!=0)
    {
    obj = obj.parentNode;
    obj.className="GD-One";
    }
    
    
    
}
//�����ͣ �ı�title�ı���
function Private_TableDrag_mouseOver(element){
    if (element.isContentEditable) return;
   if(element.isBeginDrop) return;
    var obj = window.event.srcElement;
    var tagname = obj.tagName.toLowerCase();
     if(tagname=="td"){
   obj.className="title_hover";
   }
   if(tagname=="span"){
   obj = obj.parentNode;
   obj.className="title_hover";
   }

}
//����뿪  title�ı����ص���ʼ��
function Private_TableDrag_mouseOut(element){
     if (element.isContentEditable) return;
   if(element.isBeginDrop) return;
    
    var obj = window.event.srcElement;
   var tagname = obj.tagName.toLowerCase();
    if(tagname=="td"){
   obj.className="GH-TD";
   }
      if(tagname=="span"){
   obj = obj.parentNode;
   obj.className="GH-TD";
   }
 }

