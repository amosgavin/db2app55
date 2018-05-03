<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="orgrelat.selorg" res="i18n.secframe_resource"/></title>
  </head>
  
  <body>
  <ai:contractframe id="" contenttype="table" title="orgrelat.orgsel" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
              <ai:contractitem/>
	<table width="98%" border="0" cellpadding="0" cellspacing="1">
      <tr>
        <td  align="left" valign="top">
            <ai:dbtree_new id="orgTree"
						datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel"
						multiselect="false" height="320" width="100%" ishaveline="true" 
						ondblclick="doubleClickOrg" onselect="selectOrg"/>
      </td>
      </tr>
    </table>
    </ai:contractframe>
        <div class="area_button">
        <ai:button text="orgrelat.confirm" i18nRes="i18n.secframe_resource" id="affirm" onclick="doubleClickOrg()"/>
          &nbsp;
          <ai:button text="orgrelat.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
       </div>
  </body>
  <script type="text/javascript">

        /**
         * ѡ��һ����֯�ڵ㡣����ȷ����ť�����Ժͻһ�
         */
	    function selectOrg()
	    {
		    document.getElementById("affirm").disabled  = false;
		    var orgTree = g_DBTreeNewManager.get("orgTree");
		    var curNode = orgTree.getCurNodeInfo();
		    // ���ڵ㲻����
		    if(curNode.value == "-1")
		    {
			    document.getElementById("affirm").disabled  = true;
		    }
	    }
        
	  	/**
	  	 * ˫��ѡ����֯�ϵ�һ����֯��㣬�����䷵��
	  	 */
		function doubleClickOrg()
		{
			var orgTree = g_DBTreeNewManager.get("orgTree");
			var curNode = orgTree.getCurNodeInfo();
			
			if(curNode == null)
			{
				//alert("��ѡ����֯��");
				alert(g_I18NMessage("secframe_orgrelat", "secframe_orgrelat_selorg"));
				return false;
			}
			
			// ���ڵ㲻����
			if(curNode.value == "-1")
			{
				return false;
			}
			
			window.returnValue = curNode;
			window.self.close();
		}
		/**
		 * �˳�
		 */
		function cancel()
		{	
			window.self.close();
		}
  </script>
</html>
