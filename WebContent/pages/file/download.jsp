<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>追风筝的人</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/demo/demo.css">
    <script type="text/javascript" src="<%=basePath %>easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"> 
    
    </script>
  </head>
  
  <body>
    	<table id="tt" title="文件下载" class="easyui-datagrid" style="width:550px;height:250px"
    			url="<%=basePath %>getAllFile"
    			idField="itemid" pagination="true"
    			iconCls="icon-save">
    		<thead>
    			<tr>
    				<th field="ck" checkbox="true"></th>
    				<th field="fileName" width="80">文件名称</th>
    			</tr>
    		</thead>
    	</table>
	
  </body>
</html>
