<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<p>${Response}</p>
<h1>Upload Songs</h1>
<table>
    <form:form action="http://localhost:8080/courses/upload-songs" commandName="handleForm" enctype="multipart/form-data">
        <tr>
            <td>Song Name :</td>
            <td><form:input path="songName"/></td>
        </tr>
        <tr>
            <td>Artist Name :</td>
            <td><form:input path="artistName"/></td>
        </tr>
        <tr>
            <td>Gendre :</td>
            <td><form:input path="gendre"/></td>
        </tr>
        <tr>
            <td>description :</td>
            <td><form:textarea path="description"/></td>

        </tr>
        <tr>
            <td>Browse File :</td>
            <td><form:input type="file" path="file" /></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="submit" /></td>
        </tr>
    </form:form>
</table>
</body>