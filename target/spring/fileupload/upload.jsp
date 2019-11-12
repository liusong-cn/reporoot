<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName()+":"+ request.getServerPort() +path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
 input{
	 display:block;
	 backgroundcolor:red;
	 color:red;
 }
 
 /*#button {
	 display:block;
 }**/
</style>
<title>Insert title here</title>
</head>
<body>
<form action="<%=basePath %>fileUploadController.do?fileUpload" method="post" enctype="multipart/form-data">
	<input type="submit" value="upload" id="button">
	<!-- form表单中提交是根据name属性传值的，因此如果如果元素无name属性，即无法提交 -->
	<input type="file" name="file">
</form>
</body>
</html>