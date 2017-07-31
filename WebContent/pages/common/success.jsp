<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>操作成功</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/default/easyui.css">

    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/icon.css">

    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/color.css">

    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/demo/demo.css">

    <script type="text/javascript" src="<%=basePath %>easyui/jquery.min.js"></script>

    <script type="text/javascript" src="<%=basePath %>easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		$(function(){

	　　 }); 
	</script>
	
  </head>
  
<body>
	<h3>操作成功！</h3>
</body>
</html>
