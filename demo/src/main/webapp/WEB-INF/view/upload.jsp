<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>上传网页</title>
</head>
<body>
	<form action="uploadFileHandler" method="post" enctype="multipart/form-data">
		文件:<input type="file" name="uploadfile" /><br/>
		文件名:<input type="text" name="fileName" /><br/>
		<input type="submit" value="上传" /><br/>
	</form>
</body>
</html>