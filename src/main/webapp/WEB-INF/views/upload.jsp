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
			<table>
				<tr>
					<td colspan="2"><form:errors path="*" element="div" /></td>
				</tr>
				<tr>
					<td><label for="name">Name</label></td>
					<td><form:input path="name" id="name"/></td>
				</tr>
				<tr>
					<td><label for="name">Description</label></td>
					<td><form:textarea path="description" id="name" rows="3"/></td>
				</tr>
				<tr>
					<td><label>File</label></td>
					<td><input type="file" name="file" id="file"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><button type="submit">Upload</button></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>