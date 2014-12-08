<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Upload Form</title>
	</head>
	<body>
		<h1>Upload Form</h1>
		<form:form commandName="fileUpload" method="post" enctype="multipart/form-data">
			<form:errors path="*" element="div" />

			<label for="name">Name</label>
			<form:input path="name" id="name"/>
			<label>File</label>
			<input type="file" name="file" id="file">
			<button type="submit">Upload</button>
		</form:form>
	</body>
</html>