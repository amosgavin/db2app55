<!--
/**
 * ѡ����չBO����.
 * @param ����:
          oldStaffArray-Ա����������.�ڸ������е�BONAME����ʾ��ѡ���б���.
          isSingleSel-�Ƿ�ѡ��־,1��ʾÿ��ֻ��ѡ��һ��,2��ʾ����ѡ����
          winObj-window����

 * @return ͨ��window.returnVal����ÿ��ѡ��BO��name,���ѡ����BO������ֵ����","�ָ�.
           ��ѡ��"ȡ��",����"undefined";
 * @author: HuangCheng
*/
-->
<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
	<head>
	</head>
	<SCRIPT LANGUAGE="JavaScript" for="window" even="onload">

</SCRIPT>
	<script language="javascript">

//��ѯ�����е�BO����
function getAllBoNames()
{
   var url = "<%=request.getContextPath()%>/business/com.ai.secframe.sysmgr.web.PrivilegeAction?action=queryExtendBo";
   var retVal = PostInfotoServer(url,"");
   var newBoArray = retVal.split(",");
   for(var i=0;i<newBoArray.length;i++)
   {
       if( !isOldBo( newBoArray[i] ) && newBoArray[i] != "" )
         srcList[srcList.length] = new Option( newBoArray[i],newBoArray[i],false,false);
   }
}

//�ж�BO�Ƿ��Ѿ��������ϵ�BO������
function isOldBo( boName )
{
  for( var i=0;i<oldArray.length;i++)
  {
    if( oldArray[i] == boName )
       return true;
  }
  return false;
}

function confirmFunc()
{
    var result = "";
    for (var i=0;i<srcList.length;i++)
    {
      if( srcList[i].selected )
        result += srcList[i].text+",";
    }
    if (result.charAt(result.length-1) == ',')
	result = result.substr(0,result.length-1);
    window.returnValue = result;
    window.close();
}

function cancel()
{
    window.returnValue = "undefined";
    window.close();
}

</script>

	<body onload="getAllBoNames()">
<ai:contractframe id="" contenttype="table" title="sec.extboselect.boselect" i18nRes="i18n.secframe_resource" width="98%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
			<table border="0" cellspacing="0" cellpadding="0"
				class="modeContArea" width="100%" height="300" align="center">
				<tr>
					<td>
						<select id="src_list"  size="20" name="src_list" multiple>
						</select>
					</td>
				</tr>

			</table>
			
</ai:contractframe>
            <div class ="area_button">
						<ai:button style="cursor:hand;" text="sec.confirm" i18nRes="i18n.secframe_resource" onclick="confirmFunc()" />
						&nbsp;&nbsp;
						<ai:button style="cursor:hand;" text="sec.cancel" i18nRes="i18n.secframe_resource" onclick="cancel()" />
			</div>
	</body>
	<SCRIPT LANGUAGE="JavaScript" for="window" even="onload">
    var gParamObject = dialogArguments;
    /********************�����б�*******************/
    var oldArray = null;
    //��ѡ�Ͷ�ѡ��־
    var isSingleSel = 1;
    var winObj = null;
    window.returnValue = "undefined";
    var srcList = document.all.item("src_list").options;
    if(gParamObject)
    {
	   //��ȡ����
        oldArray = gParamObject.oldArray;
        isSingleSel =  gParamObject.isSingleSel;
        winObj = gParamObject.winObj;
       //���õ�ѡ���߶�ѡ
	if(isSingleSel==1)
	    document.all.item("src_list").multiple = false;
        else
	    document.all.item("src_list").multiple = true;
    }
</script>
</html>
