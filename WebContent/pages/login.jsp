<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/default/easyui.css">

    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/icon.css">

    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/color.css">

    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/demo/demo.css">

    <script type="text/javascript" src="<%=basePath %>easyui/jquery.min.js"></script>

    <script type="text/javascript" src="<%=basePath %>easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//alert("aaa");
	　　 }); 
	</script>
	
  </head>
  
<body>

	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="用户登录" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" action="login" method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input class="easyui-textbox" type="text" name="userName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-textbox" type="password" name="passwd" data-options="required:true,validType:'password'"></input></td>
	    		</tr>
	    		
    			<tr>
	    			<td colspan="2"><font color="red">${requestScope.message}</font></td>
	    		</tr>

	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">登录</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">取消</a>
	    </div>
	    </div>
	</div>
	<script>
		function submitForm(){
			$('#ff').submit();
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
</html>
