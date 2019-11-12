<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../jquery-1.8.0.min.js"></script>
<script src="../Highcharts-7.0.2/code/highcharts.js"></script>
</head>
<body>
<div id="container" style="width:800px;height:500px"></div>
<button id="button" onclick="addSeries()">add series</button>
<script type="text/javascript">
	$(function(){
		var chart = $('#container').highcharts({
			chart:{
				events: {
					addSeries:function(){
					var label = this.renderer.label("this is the first custom label",100,120)
					.attr({
						fill: Highcharts.getOptions().colors[0],
						padding: 10,
						r: 5,
						zIndex: 8
					})
					.css({
						color: '#FFFFFF'
					})
					.add(); 
					setTimeout(function(){
						label.fadeOut();
					},1000)
				}
			}
		},
			xAxis:{
				categories:['jan','feb','mar','apr','may','jun','july','aug','sep','oct','nov','dec']
			},
			series: [{
				data: [100,150,158,200,250,300,350,320,280,200,160,140]
			}]
		})
	})
	
	function addSeries(){
		debugger;
		var chart1 = $('#container').highcharts();
		chart1.addSeries({
			data: [216.4, 194.1, 95.6, 54.4, 29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5]
		});
	}
	
</script>
</body>
</html>