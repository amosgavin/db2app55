<%@ page contentType="text/html; charset=GBK" %>

<html>
<head>

<title></title>
<style>
 body { margin: 0px;}
 div { overflow: scroll; height: 100px; width: 1200px; }
</style>

</head>

<body  bgcolor="#869ca7" style="text-align: center">

<p>cacheList</p>
<table border="0" width="50%" id="table2" height="80%" align="center" >
<%
try {
String id = request.getParameter("id");
if(id!=null && !id.equals("")){
  String[] name = org.apache.commons.lang.StringUtils.split(id,",");
  for (int i = 0; i < name.length; i++) {
      Class clazz = Class.forName(name[i]);
      if (com.ai.appframe2.complex.cache.CacheFactory._getCacheInstances().containsKey(clazz)) {
	com.ai.appframe2.complex.cache.ICache cache = (com.ai.appframe2.complex.cache.ICache) com.ai.appframe2.complex.cache.CacheFactory._getCacheInstances().get(clazz);
	cache.refresh();
      }

  }
}
}
catch (Throwable ex) {
  ex.printStackTrace();
}
%>

<%

  java.util.HashMap map = com.ai.appframe2.complex.cache.CacheFactory._getCacheInstances();

  java.util.Set keys = map.keySet();

  java.util.List list = new java.util.ArrayList();
  for (java.util.Iterator iter = keys.iterator(); iter.hasNext(); ) {
    Class item = (Class) iter.next();
    list.add(item.getName());
  }


  String[] name = (String[])list.toArray(new String[0]);
  java.util.Arrays.sort(name, new com.ai.appframe2.complex.util.StringLengthDescComparator());
  for (int i = 0; i < name.length; i++) {
     out.print("<tr>");
     out.print("<td><p align=\"center\"><font size=\"4\"><input type=\"checkbox\" value=\""+name[i]+"\" name=\"cacheCheck\"></font></td><td><font size=\"2\">"+name[i]+"</font></td>\n");
     out.print("</tr>");
  }

%>

</table>
<input type="button" name="selectAll" value="Select All" onclick="checkAll('cacheCheck')">
<input type="button" name="selectAll" value="Diselect All" onclick="clearAll('cacheCheck')">
<input type="button" name="selectAll" value="Refresh" onclick="refresh('cacheCheck')">
</body>

</html>

<script type="text/javascript">

function checkAll(name){
	var el = document.getElementsByTagName('input');
	var len = el.length;
	for(var i=0; i<len; i++){
		if((el[i].type=="checkbox") && (el[i].name==name)){
			el[i].checked = true;
		}
	}
}

function clearAll(name){
	var el = document.getElementsByTagName('input');
	var len = el.length;
	for(var i=0; i<len; i++){
		if((el[i].type=="checkbox") && (el[i].name==name)){
			el[i].checked = false;
		}
	}
}

function refresh(cacheIds){
	var showCache = new Array();
	var el = document.getElementsByTagName('input');
	var len = el.length;
	var cache = "";
	var l2 = 0;
	for(var i=0; i<len; i++){
		if((el[i].type=="checkbox") && (el[i].name==cacheIds)){
			if(el[i].checked){
			  cache +=","+el[i].value;
			  showCache.push(el[i].value);
			  l2++;
			}
		}
	}

	if(l2==0){
	  alert("Please choose one cache at least");
	  return;
	}


	var b = "Choosed cache\n";
	for(var i=0;i<showCache.length;i++){
	  b+=showCache[i]+"\t\t";
	  if(i!=0 && (i%2==0) ){
	   b+="\n";
	  }
	}

	window.location.href='<%=request.getContextPath()%>/sale/common/CacheRefresh.jsp?id='+cache;
}


//-->
</script>
