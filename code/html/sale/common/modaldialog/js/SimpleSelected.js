function onSelect(){
    var selectedIndex = document.getElementById("itemList").selectedIndex;
    if(selectedIndex<0){return;}
    window.returnValue = document.getElementById("itemList").options[selectedIndex].value;
    window.close();
}