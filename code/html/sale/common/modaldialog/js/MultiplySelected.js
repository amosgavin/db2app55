var paraObj = window.dialogArguments;
var itemTypes = paraObj.itemTypes;     

function initPage(){
    var  aray = new   Array();
    var sourceList=getItemListObject(); 
    aray = itemTypes.split(";");
    for (var i=0;i< aray.length; i++){  
        for(var j=0;j<sourceList.length;j++){ 
            //alert(sourceList.options[j].value+" "+aray[i]);   
            if(sourceList.options[j].text ==aray[i]){
                sourceList.selectedIndex=j;  
                selectItem(true);
                break; 
            }
        }                
    }       
}

function onSubmit(){
    var selectedItemList =getSelectedItemListObject();
    var brands=new Array();
    for(var i=0;i<selectedItemList.length;i++){
        brands[i]=selectedItemList.options[i].text+"&&"
        brands[i]+=selectedItemList.options[i].value;
    }
    window.returnValue = brands;
    window.close();
}
function selectItemAction(itemList){
    selectItem(true);    
}
function deleteItemAction(selectedItemList){
    selectItem(false);   
}
//»ù´¡·½·¨
function selectItem(flag){
    var sourceList =null;
    var selectedList=null;
    if(flag){
        sourceList=getItemListObject();
        selectedList=getSelectedItemListObject();
    }else{
        sourceList=getSelectedItemListObject();
        selectedList=getItemListObject();       
    }
    var selectedIndex=sourceList.selectedIndex;
    if(selectedIndex<0){return;}
    for(var i=0;i<selectedList.length;i++){ 
        if(sourceList.options[sourceList.selectedIndex].value ==selectedList.options[i].value)
        {return false;}
    }   
    selectedList.options[selectedList.length] = new Option(sourceList.options[sourceList.selectedIndex].text,sourceList.options[sourceList.selectedIndex].value,false,false);
    sourceList.options.remove(selectedIndex)
    return true;
}
function clearSelectedItemAction(){
    var selectedItemList=getSelectedItemListObject();
    var itemList=getItemListObject();   
    selectItem(false);  
    for(var i=selectedItemList.options.length-1;i>=0;i--){ 
        itemList.options[itemList.length] = new Option(selectedItemList.options[i].text,selectedItemList.options[i].value,false,false);
        selectedItemList.options.remove(i)
    }
}
function getItemListObject(){
    return document.getElementById("itemList"); 
}
function getSelectedItemListObject(){
    return document.getElementById("selectedItemList"); 
}