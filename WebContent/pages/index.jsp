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
    
 // 动态菜单数据
    var treeData = [{
           text : "功能菜单",
           children : [
        	   {
                   text : "系统管理",
                   state : "closed",
                   children : [
                	   {
                           text : "修改密码",
                           attributes : {
                               url : "<%=basePath%>toResetPasswd"
                           }
                       },
                	   {
                           text : "日志管理",
                           attributes : {
                               url : "<%=basePath%>logmanager"
                           }
                       }
                   ]
               }, 
               {
                   text : "用户管理",
                   attributes : {
                       url : "<%=basePath%>usermanager"
                   }
               },
               {
                   text : "文件管理",
                   state : "closed",
                   children : [
                	   {
                           text : "上传文件",
                           attributes : {
                        	   url : "<%=basePath%>toUpload"
                           }
                       },
                       {
                    	   text: "下载文件",
                    	   attributes : {
                    		   url : "<%=basePath%>toDownload"
                    	   }
                       }
                   ]
               }
           ]
       }
   ];
 
 
    $(function () {
    	// 加载左侧菜单
       $("#tree").tree({
           data : treeData,
           lines :  true,
           onClick :  function (node) {
                if (node.attributes) {
                   Open(node.text, node.attributes.url);
               }
        	}
       });
    	
    	// 在右边center区域打开菜单，新增tab
       function Open(text, url){
           if ($("#tabs").tabs('exists', text)) {
              $('#tabs').tabs('select', text);
         	} else {
         	  var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
              $('#tabs').tabs('add', {
                  title : text,
                  closable :  true,
                  content : content
              });
          }
      }; 
    	
   	});
       
    </script> 
  </head>
  
   <body class="easyui-layout">
   		<!-- top部分 -->
       <div data-options="region:'north',split:false" style="height:60px;">
       		<h4>欢迎您，${user.userName}&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>logout">注销</a></h4>
       </div>
       
       <!-- bottom部分 -->
<!--        <div  data-options="region:'south',title:'South Title',split:true" style="height:50px;">
       			
       </div> -->
       
       
<!--        <div data-options="region:'east',title:'East',split:true" style="width:200px;"></div> -->

       <!-- 左侧菜单导航部分 -->
       <div data-options="region:'west',split:false" style="width:200px;">
       		<ul id ="tree"></ul>
       </div> 
       
       
       <div id="mainPanel" data-options="region:'center'," style="padding:5px;background:#eee;">
		     <div  class ="easyui-tabs"  fit ="true"  border ="false"  id ="tabs" >
      					<div  title ="首页" >
      						<p>欢迎访问meify的个人后台管理系统</p>
      					</div >
   			 </div >
       </div>
       
   </body>
</html>
