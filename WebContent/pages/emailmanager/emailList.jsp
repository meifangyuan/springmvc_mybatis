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

<link rel="stylesheet" type="text/css"
	href="<%=basePath %>easyui/themes/default/easyui.css">

<link rel="stylesheet" type="text/css"
	href="<%=basePath %>easyui/themes/icon.css">

<link rel="stylesheet" type="text/css"
	href="<%=basePath %>easyui/themes/color.css">

<link rel="stylesheet" type="text/css"
	href="<%=basePath %>easyui/demo/demo.css">

<script type="text/javascript" src="<%=basePath %>easyui/jquery.min.js"></script>

<script type="text/javascript"
	src="<%=basePath %>easyui/jquery.easyui.min.js"></script>
<title>邮件列表</title>

<script type="text/javascript">  
    $(function() {

    	
    });
    
    function doSearch(){
    	var startTime = $('#startTime').val();
    	var endTime = $('#endTime').val();

    	$('#dg').datagrid('load',
    			  {
  		            	startTime: startTime,
  		                endTime: endTime
  		          });
    }
    
    

</script>
</head>

<body>

	<table id="dg" title="邮件管理" class="easyui-datagrid"
		style="width: 750px; height: 365px" url="<%=basePath %>getEmailByCondition"
		pagination="true" rownumbers="true" fitColumns="true"
		singleSelect="true" toolbar="#tb" >
		<thead>
			<tr>
				<th field="id" width="50">编号</th>
				<th field="from" width="50">发送方</th>
				<th field="to" width="50">接收方</th>
				<th field="subject" width="50">标题</th>
				<th field="content" width="50">内容</th>
				<th field="time" width="50">时间</th>
				<th field="success" width="50">结果</th>
			</tr>
		</thead>
	</table>
	
	
<div id="tb" style="padding:3px">
	<span>起始日期:</span>
	<input id="startTime" type="text" class="easyui-datetimebox" style="width:180px;line-height:26px;border:1px solid #ccc">
	<span>截止日期:</span>
	<input id="endTime" type="text" class="easyui-datetimebox" style="width:180px;line-height:26px;border:1px solid #ccc">
	<a href="javascript:void(0);" class="easyui-linkbutton" style="margin-left:20px;" plain="false" onclick="doSearch()">查找</a>
</div>

</body>
</html>
