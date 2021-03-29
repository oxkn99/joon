<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ROOT</title>
</head>
<body>
	<h1>HomeWork</h1>
	<div id=homework_List>
        <c:forEach items="${workList}" var="entry">
        <c:choose>
    <c:when test="${entry.check eq true}">
    <input type="checkbox"  checked="checked" onclick="return false;"/>
    ${entry.title} <br/>
    </c:when>
    <c:otherwise>
    <input type="checkbox"  onclick="return false;"/>
    ${entry.title} <br/>
    </c:otherwise>
		</c:choose>
		</c:forEach>

	</div>
</body>
</html>