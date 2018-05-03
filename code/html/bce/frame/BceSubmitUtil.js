function getUDXMLString(mapArray)
{
    var udStr = "";

    for(var i=0;i<mapArray.length;i++)
        udStr += "<p n='"+mapArray[i].key+"'>"+mapArray[i].value+"</p>";

    udStr = "<UD>"+udStr+"</UD>";

    return udStr;
}

function getNodeXMLString(frameName,frmName,frmType,isGetAllData)
{
    var rowSetObj;
    var xmlStr = "";
    var rowSetManagerName = "g_FormRowSetManager";

    if(frmType=="TABLE")
        rowSetManagerName = "g_TableRowSetManager";

    try{
        var autoInvokeStr = "rowSetObj ="+frameName+"."+rowSetManagerName+".get('"+frmName+"');";
        if(frameName=="")
            autoInvokeStr = "rowSetObj ="+rowSetManagerName+".get('"+frmName+"');";
        eval(autoInvokeStr);
        xmlStr = rowSetObj.toXmlString(isGetAllData);
    }catch(e){
        xmlStr = "";
    }

    if(xmlStr!=null&&xmlStr!="") {
        xmlStr = "<nodexml name='"+frmName+"' xmltype=''>"+
                 "<RootInfo>"+
                 xmlStr+
                 "</RootInfo>"+
                 "</nodexml>";
    }

    return xmlStr;
}

function getSubmitXMLString(currentPageId,nextPageId,subXMLList)
{
    var submitXML = "<submitdata name='main' curpageid='"+currentPageId+
                    "' nextpageid='"+nextPageId+"'>"+
                    "<nodeinfo name='ID_"+currentPageId+"' infotype=''>"+
                    subXMLList.join("")+
                    "</nodeinfo>"+
                    "</submitdata>";
    return submitXML;
}

//根据身份证号码获取生日
function getBirthDayFromID(certifiCode)
{
    var birthDay = "";
    if(certifiCode.length==15)
        birthDay = "19"+certifiCode.substring(6,8)+"-"+certifiCode.substring(8,10)+"-"+certifiCode.substring(10,12);
    else
        birthDay = certifiCode.substring(6,10)+"-"+certifiCode.substring(10,12)+"-"+certifiCode.substring(12,14);
    return birthDay;
}

function BackToDeskTop()
{
    window.location = G_RTN_URL;
}
