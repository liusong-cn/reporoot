<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../datagrid/easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="../datagrid/easyui/themes/icon.css">
<script type="text/javascript" src="../jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../datagrid/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div id="tt" class="easyui-tabs" style="width:auto;height:250px;">   
    <div title="Tab1" style="padding:20px;display:none;">   
        tab1   <input type="button" onclick="createTab()" title="ren" value="人"> 
    </div>   
    <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">   
        tab2    
    </div>   
    <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">   
        tab3    
    </div>   
</div>
<script type="text/javascript">

	function createTab(){
		$('#tt').tabs('add',{    
		    title:'New Tab',    
		    content:'Tab Body',    
		    closable:true,    
		    tools:[{    
		        iconCls:'icon-mini-refresh',    
		        handler:function(){    
		            alert('refresh');    
		        }    
		    }]    
		}); 
	}
</script>
</body>
</html>