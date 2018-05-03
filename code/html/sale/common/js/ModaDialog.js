function onItemSimpleSelected(url, iniVal, style){
    var retMsg = window.showModalDialog(url, null, style);
    if(retMsg==null){return "";}
    return retMsg;
}

function onItemMultiplySelected(url, iniVal, style){
    var paraObj = new Object();
    paraObj.itemTypes = iniVal;
    var retMsg = window.showModalDialog(url, paraObj, style);
    if(retMsg==null){return "";}
    return getMultiSelectName(retMsg);
}
//基础方法
function getMultiSelectName(itemArray){
    return getMultiSelect(itemArray,false);  
}
//基础方法
function getMultiSelectId(itemArray){
     return getMultiSelect(itemArray,true); 
}
//基础方法
function setMultiSelect(name,id){
    
}
//基础方法
function getMultiSelect(itemArray,flag){
    var names="";
    var ids="";     
      for(var i=0;i<itemArray.length;i++){
        //alert(itemArray[i]);   
        if(i==0){  
            names=getRecordName(itemArray[i]);
            ids=getRecordId(itemArray[i]);
        }else{  
            names+=";"+getRecordName(itemArray[i]);
            ids+=";"+getRecordId(itemArray[i]); 
        }   
      }  
      if(flag){
        return ids;
      }else{
         return names;
      }
}
//基础方法2
    function getRecordId(record){
        return getRecord("id",record);
    }
    //基础方法2
    function getRecordName(record){
        return getRecord("name",record);
    }
    //基础方法
    function getRecord(type,record){
        //alert(record);
        var strLine1 = "";
        var strLine2 = "";
        if(record != "" && record != null && record !="null"){
                var   sarray = new   Array();  
                var  aray = new   Array();
                var  aray1 = "";
                var  aray2 = "";
                var valary1 = new   Array();
                var valary2 = new   Array();
                aray = record.split("&&");
                aray1 = aray[0];
                aray2 = aray[1];
                sarray=aray2.split(';');                    
                for (var i=0;i< sarray.length; i++){
                    valary1 = aray1.split(";"); 
                    valary2 = aray2.split(";"); 
                    for(var j =0; j < valary1.length; j++){
                            if(j == 0){ 
                                strLine1 = valary1[j];
                                strLine2 = valary2[j];
                            }else{
                                strLine1 = strLine1 + ";"+valary1[j];
                                strLine2 = strLine2 + ";"+valary2[j];
                            }
                    }
                    
                }               
        }       
        //alert(strLine2);        
        //alert(strLine1); 
        switch(type){
            case "id" : { return strLine2;}
            case "name" :{ return strLine1;}
            default :{return "";}
        }
    }