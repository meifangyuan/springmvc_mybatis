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
    <title>用户列表</title>
    
	<script type="text/javascript">	 
	 
		var url;
		
		function newUser(){
			$('#dlg').dialog('open').dialog('setTitle','新增用户');
			$('#fm').form('clear');
			url = '<%=basePath%>saveUser';
		}
		
		function editUser(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$('#dlg').dialog('open').dialog('setTitle','修改用户信息');
				$('#fm').form('load',row);
				url = '<%=basePath%>updateUser?id='+row.id;
			}
		}
		
		function saveUser(){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
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
		
		function removeUser(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$.messager.confirm('Confirm','是否确定删除该用户?',function(r){
					if (r){
						$.post('<%=basePath%>deleteUser',{id:row.id},function(result){
							if (result.success){
								$('#dg').datagrid('reload');	// reload the user data
							} else {
								$.messager.show({	// show error message
									title: 'Error',
									msg: result.msg
								});
							}
						},'json');
					}
				});
			}
		}
		
		$(function () {  
	        $('#dg').datagrid({  
	            title: '用户管理',  
	            url: "<%=basePath %>getAllUser",
	            loadMsg: '数据正在加载中',
	            pagination: true,
	            rownumbers: true,
	            fitCloumns: true,
	            singleSelect: true,
	            columns: [[{
	            	             field: 'id',
	            	             title: '编号',
	            	             width: 100
	            	       },
	            	       {
	            	    	  	 field: 'userName',
	            	             title: '姓名',
	            	             width: 100
	            	       },
	            	       {
	            	    	  	 field: 'sex',
	            	             title: '性别',
	            	             width: 100,
	            	             formatter:function(val) {
	            	            	 if(val==1) {
	            	            		 return '男';
	            	            	 } else if(val==0) {
	            	            		 return '女';
	            	            	 } else {
	            	            		 return '未知';
	            	            	 }
	            	             }
	            	       },
	            	       {
	            	    	   field: 'age',
	            	    	   title: '年龄',
	            	    	   width: 100
	            	       },
	            	       {
	            	    	   field: 'email',
	            	    	   title: '邮箱',
	            	    	   width: 200
	            	       }
	            ]],
	            toolbar: [{
	                text:'添加用户信息',
		            iconCls: 'icon-add',
		            handler: function(){
		            newUser();
		            }
	            },'-',{
		            text:'修改用户信息',
		            iconCls: 'icon-edit',
		            handler: function(){
		            editUser();
	           	 }
	            },'-',{
		            text:'删除用户信息',
		            iconCls: 'icon-remove',
		            handler: function(){
		            removeUser();
	            	}
	            }]
	            	 
	        });  
	    });  
	</script>
  </head>
  
<body>
	<table id="dg">
	
	</table>
<!-- 	<table id="dg" title="用户管理" class="easyui-datagrid" style="width:750px;height:365px"
			url="<%=basePath %>getAllUser"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="50">编号</th>
				<th field="userName" width="50">姓名</th>
				<th field="sex" width="50">性别</th>
				<th field="age" width="50">年龄</th>
				<th field="email" width="50">邮箱</th>
			</tr>
		</thead>
	</table> 
	
	<div id="toolbar">
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">增加</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">删除</a>
	</div> -->
	
	
	<!-- 新增用户 -->
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;margin-top:300px;padding:20px 20px"
			closed="true" buttons="#dlg-buttons">
		<div class="ftitle">用户信息</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>姓名:</label>
				<input name="userName" class="easyui-validatebox" required="true">
			</div>
			
			<div class="fitem">
				<label>密码:</label>
				<input name="passwd" class="easyui-validatebox" required="true">
			</div>
			
			<div class="fitem">
				<label>性别:</label>
				<select class="easyui-combobox" name="sex">
					<option value="1">男</option>
					<option value="0">女</option>
				</select>
			</div>
	
			<div class="fitem">
				<label>年龄:</label>
				<input name="age">
			</div>
			
			<div class="fitem">
				<label>邮箱:</label>
				<input name="email" class="easyui-validatebox" type="email" required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
  </body>
</html>
