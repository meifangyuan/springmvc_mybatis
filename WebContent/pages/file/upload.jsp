
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
<title>上传文件</title>
<script type="text/javascript">	
	function upload() {
		$("#uploadForm").submit();
	}

</script>
</head>


<body>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-panel" title="上传文件"
		style="width: 400px; padding: 20px 50px 20px 50px">
		<form id="uploadForm" action="upload" enctype="multipart/form-data" method="post">
			<div style="margin-bottom: 20px">
				<div>请选择要上传的文件:</div>
				<input class="easyui-filebox" name="file"
					data-options="prompt:'Choose a file...'" style="width: 100%">
			</div>
			<div>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					style="width: 100%" onclick="upload()">上传</a>
			</div>
		</form>
	</div>
</body>
</html>
