<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin.message.read.title"/></title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
<script type="text/javascript"
	src="resources/js/lib/jquery-2.1.0.min.js"></script>
<style type="text/css">
TABLE {
	width: auto; /* Ширина таблицы */
	border-collapse: collapse; /* Убираем двойные линии между ячейками */
}

TD,TH {
	padding: 3px; /* Поля вокруг содержимого таблицы */
	border: 1px solid black; /* Параметры рамки */
}

TH {
	background: #b0e0e6; /* Цвет фона */
}
</style>


</head>


<body>
	<form action="adminreply" method="get">
		<input type="submit" value="<bk:printProperty key="admin.message.read.submit_decline"/>" name="decline_checked" />
		<input type="submit" value="<bk:printProperty key="admin.message.read.submit_delete"/>" name="delete_checked" />
		<c:forEach items="${manager_message_list }" var="list">
		<br/>
			<table>
		<tr>
			<td width="100">Type: <c:if test="${list.type == 1 }">
							 <bk:printProperty key="admin.message.read.new_country"/>
						</c:if> <c:if test="${list.type == 2 }">
							<bk:printProperty key="admin.message.read.new_region"/>
						</c:if> <c:if test="${list.type == 3 }">
							<bk:printProperty key="admin.message.read.new_city "/>
						</c:if> <c:if test="${list.type == 4 }">
							<bk:printProperty key="admin.message.read.new_street"/>
						</c:if> <c:if test="${list.type == 5 }">
							<bk:printProperty key="admin.message.read.error"/>
						</c:if> <c:if test="${list.type == 6 }">
							<bk:printProperty key="admin.message.read.else"/>
						</c:if>
			</td>
			<td rowspan="3" width="300" align="center">
			<a href="<c:url value="adminreply">
				<c:param name="open" value="${list.id}"/> 
				</c:url>">
				${fn:substring(list.message,0,100)}
			<c:if test = "${fn:length(list.message) > 100 }">
			...
			</c:if>
			</a>
			</td>
			<td align="center">
				<input type="checkbox" value="${list.id }" name="checkbox">
			</td>
		</tr>
		<tr>
			<td>Id: ${list.managerId}</td>
			<td><a
					href="<c:url value="adminreply"  >
								<c:param name="decline" value="${list.id}"/>  
						</c:url>">decline</a></td>
		</tr>
		<tr>
			<td><fmt:formatDate pattern="dd.MM.yyyy" 
            value="${list.lastUpdate}" /></td>
			<td><a
					href="<c:url value="adminreply">
								<c:param name="delete" value="${list.id}"/>  
						</c:url>">delete</a></td>
		</tr>
	</table>
	<br />
		</c:forEach>

	</form>
</body>
</html>


<!-- <td><a href="<c:url value="admincountry">
						<c:param name="idUpdateCountry" value="${country.id}"/>  
						</c:url>" >${country.name}</a></td> -->