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
    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/demo/demo.css">
    <script type="text/javascript" src="<%=basePath %>easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>easyui/jquery.easyui.min.js"></script>
    <title>发送邮件</title>
    
	<script type="text/javascript">	 
		function toSendEmail(){
			$('#dlg').dialog('open').dialog('setTitle','发送邮件');
			$('#fm').form('clear');
		}
		
		function sendEmail(){
		    var ids = [];
		    var rows = $('#dg').datagrid('getSelections');
		    alert(rows.length);
		    for(var i=0; i<rows.length; i++){
		    	var id = rows[i].id;
		    	alert("id===" + id);
		    	ids.push(id);
		    }
		    alert(ids.join(','));
		    
		    
			$('#fm').form('submit',{
				url: '<%=basePath%>sendEmail?ids=' + ids.join(','),
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					//alert(result);
					var result = eval('('+result+')');
					if (result.success){
						$('#dlg').dialog('close');		// close the dialog
						$('#dg').datagrid('reload');	// reload the user data
					} else {
						$.messager.show({
							title: 'Error',
							msg: result.msg
						});
					}
				}
			});
		}
	</script>
  </head>
  
<body>

 	<table id="dg" title="消息通知" class="easyui-datagrid" style="width:750px;height:365px"
			url="<%=basePath %>getAllUser"
			idField="itemid"
			singleSelect="false"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="id" width="50">编号</th>
				<th field="userName" width="50">姓名</th>
				<th field="email" width="50">邮箱</th>
			</tr>
		</thead>
	</table> 
	
	<div id="toolbar">
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="toSendEmail()">发送邮件</a>
	</div>
	
	
	<!-- 新增用户 -->
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
			closed="true" buttons="#dlg-buttons">
		<div class="ftitle">填写邮件</div>
		<form id="fm" method="post">
			
			<div class="fitem">
				<label>标题:</label>
				<input name="title" class="easyui-validatebox" required="true">
			</div>
			
			<div class="fitem">
				<label>内容:</label>
				<input name="content" class="easyui-validatebox" required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="sendEmail()">发送</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
  </body>
</html>
