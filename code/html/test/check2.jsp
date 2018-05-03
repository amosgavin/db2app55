<%@ page contentType="text/html; charset=GBK"%>
<script type="text/javascript">
    var url = "/db2app55/dbformrefresh?action=refreshlist&pk=-1&F_SETNAME=com_asiainfo_workflow_util_web_SETFWOperate&F_FIELDNAME=RESULT&F_DSID=com.asiainfo.workflow.utli.web.DSTaskRoute&F_ISCOND=y&templateCode=template.TownSaleCaseApprove&taskId=4&url_source=XMLHTTP";
    var XMLSender = new ActiveXObject("Microsoft.XMLHTTP");
    XMLSender.Open("POST",url,false);
    XMLSender.setRequestHeader("Content-Type","multipart/form-data");
    XMLSender.send(null);
    
   // if(monitor_flag ==true){
     // recordExecEndTime();
    //}
    
    alert(XMLSender.responseText);
</script>