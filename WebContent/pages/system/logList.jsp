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
<title>日志列表</title>

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

	<table id="dg" title="日志管理" class="easyui-datagrid"
		style="width: 750px; height: 365px" url="<%=basePath %>getLogByCondition"
		pagination="true" rownumbers="true" fitColumns="true"
		singleSelect="true" toolbar="#tb" >
		<thead>
			<tr>
				<th field="id" width="50">编号</th>
				<th field="type" width="50">类型</th>
				<th field="ip" width="50">访问ip</th>
				<th field="description" width="50">类</th>
				<th field="method" width="50">方法</th>
				<th field="operator" width="50">操作人员</th>
				<th field="time" width="50">时间</th>
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
