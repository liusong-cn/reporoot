<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="button" value="test" onclick="aspectTest()">
<script>

	function getText() {
		var re = new XMLHttpRequest();
		re.open('get',
				'http://localhost:7088/spring/loginController.do?testXMLRequest');
		//re.setRequestHeader("Access-Control-Allow-Orgin","*");
		re.onreadystatechange = function() {
			if (re.readyState === 4 && re.status === 200) {
				var type = re.getResponseHeader("Content-Type");
				if (type.match(/^text/)) {
					//callback(re.responseText)	
					alert(re.responseText);
				}

			}
		}
		re.send(null);
	}

</script>
</body>
</html>