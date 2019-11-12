<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=basePath %>/webpage/jquery-1.8.0.min.js"></script>
<script src="<%=basePath %>/webpage/Highcharts-7.0.2/code/highcharts.js"></script>
<script src="<%=basePath %>/webpage/Highcharts-7.0.2/code/modules/exporting.js"></script>
<script src="<%=basePath %>/webpage/Highcharts-7.0.2/code/modules/offline-exporting.js"></script>
<script src="<%=basePath %>/webpage/Highcharts805/series-label.js"></script>
<script src="<%=basePath %>/webpage/Highcharts805/highcharts-zh_CN.js"></script>
<script src="<%=basePath %>/webpage/Highcharts805/oldie.js"></script>
<title>测试</title>
</head>
<body>
<a href="/springDemo/testController?goPage&param=t" target="_blank">hello</a>
<input type="button" id="testSessionTransfer" onclick="doSessionTransfer()" value="真的">
<input type="button" id="uploadSVG" onclick="doUpload()" value="测试">
<div id="container"></div>
<script type="text/javascript">
	function doSessionTransfer(){
		
		$.ajax({
			url : '/springDemo/loginController.do?doLogin',
			type : 'post',
			success : function(data){
				if(data.success){
					window.location.href= "http://localhost:7088/fd-offline/schemeBaseController.do?goPage&token=" + data.token;
				}
			},
			error: function(HttpServletRequest,textStatus,errorThrown){
				console.log(textStatus);
			}
		})
	}
	
	$(function(){
		debugger;
		var dafaultMenuItem = Highcharts.getOptions().exporting.buttons.contextButton.menuItems;
		Highcharts.chart('container', {
			exporting: {
				url: "http://localhost:8095/springDemo/highchartsExportController.do?doExport",
				buttons: {
					contextButton: {
						// 自定义导出菜单项目及顺序
						menuItems: [
							dafaultMenuItem[0],
							{
								separator: true
							},
							dafaultMenuItem[3],
							{
								text: '下载 PDF 文件',
								onclick: function() {
									this.exportChart({
										type: 'application/pdf',
									});
								}
							},
							{
								text: '自定义项目',
								onclick: function() {
									doUpload();
									this.exportChart({
										type: 'image/png',
									});
								}
							},
							dafaultMenuItem[5],
							dafaultMenuItem[1],
							{
								text: '跳转链接',
								onclick: function() {
									window.location.href= 'https://www.hcharts.cn';
								}
							}
						]
					}
				}
			},
			title: {
				text: '离线导出（浏览器端导出，无需提交数据到导出服务器）'
			},
			subtitle: {
				text: '请点击右侧导出按钮进行操作'
			},
			chart: {
				type: 'area'
			},
			xAxis: {
				categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
			},
			series: [{
				data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 126.0, 148.5, 216.4, 194.1, 95.6, 54.4]
			}]
		});
	})
	
	
	function getsvg(){
		var chart = $('#container').highcharts();//获取Highcharts对象
		var svg = chart.getSVG();
		return svg;
	}
	
	function doUpload(){
		debugger;
		var svg = getsvg();
		$.ajax({
			url : '/springDemo/highchartsExportController.do?SvgCache',
			data : {
				type : 'image/png',
				svg : svg
			},
			type : 'post',
			dataType : 'json',
			cache : false,
			async : false,
			success : function(d){
				if(d.success){
					alert("chenggong");
				}
			}
		})
	}
</script>
</body>
</html>