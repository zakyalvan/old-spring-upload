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
		<div class="table-responsive">
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Content Type</th>
						<th>Description</th>
						<th>Timestamp</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty files}">
							<tr>
								<td colspan="6" align="center"><i>No files to display</i></td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${files}" var="file" varStatus="loop">
							<tr>
								<td><c:out value="${loop.index + 1}"/></td>
								<td><c:out value="${file.name}"/></td>
								<td><c:out value="${file.contentType}"/></td>
								<td><c:out value="${file.description}"/></td>
								<td><c:out value="${file.uploadTimestamp}"/></td>
								<td>
									<a href="download?file=${file.id}">Download</a>
									<a href="remove?file=${file.id}">Remove</a>
								</td>
							</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</body>
</html>