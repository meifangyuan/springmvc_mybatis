<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
    <title>文件下载</title>

  </head>
  
  <body>
    <h2>文件上传</h2>
    
    <form action="upload" enctype="multipart/form-data" method="post">
    	<table>
    		<tr>
    		<td>请选择文件：</td>
    		<td><input type="file" name="file"></td>
    		</tr>
    		
    		<tr>
    		<td><input type="submit" name="上传"></td>
    		</tr>
    	</table>
    </form>
    
    
    <h3>
    	<a href="<%=basePath%>/download?fileName=demo.jpg">点击下载图片</a>
    </h3>
	
  </body>
</html>
