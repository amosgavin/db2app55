<%@ page contentType="text/html; charset=GBK" %>

/**
 * ���ڲ�ѯʱ�����ڿؼ���ѡ�����ڣ��������������Ӧ�Ŀؼ��С�
 */
function calendar(obj, isDisplayTime) {
	var dlgLeft = event.screenX;
	var dlgTop = event.screenY;
    var url="<%=request.getContextPath()%>/jsv2/Calendar.htm";
    var character = "dialogWidth:394px;dialogHeight:280px;dialogLeft:"+dlgLeft+";dialogTop:"+dlgTop+";center:yes;help:no;resizable:no;status:no;scroll:no";
    var paramObj = new Array();
    paramObj[0] = obj;
    if (isDisplayTime == false) {
    	paramObj[1] = false;
    } else {
    	paramObj[1] = true;
    }
    window.showModalDialog(url,paramObj,character);
}
