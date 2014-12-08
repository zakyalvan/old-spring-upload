<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Uploaded List</title>
	</head>
	<body>
		<h1>Uploaded Files</h1>
		<p>Bellow are list of uploaded files, you can download the files by clicking "Download" link on each file row.</p>
		<a href="upload">Upload New</a>
		<div>
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Path</th>
						<th>Timestamp</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${files}" var="file" varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td>${file.name}</td>
						<td>${file.path}</td>
						<td>${file.uploadTimestamp}</td>
						<td>
							<a href="download?file=${file.id}">Download</a>
							<a href="remove?file=${file.id}">Remove</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>