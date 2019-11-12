<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<title>Insert title here</title>
</head>
<body>
<table id="dg"></table>  
<script type="text/javascript">
	$(function(){
		$('#dg').datagrid({    
		    columns:[[    
		        {field:'code',title:'Code',width:100,sortable : true},    
		        {field:'name',title:'Name',width:100},    
		        {field:'price',title:'Price',width:100,align:'right'}    
		    ]],
		    data : [{code: '1',name : '2',price: '3'}],
		    onClickCell : function(index, field, value){
		    	alert(index + "--"+ field + "--"+ value );
		    },
		    onBeforeSortColumn : function(sort,order){
		    	alert(sort);
		    	return true;
		    }
		});  
	})
</script>
</body>
</html>