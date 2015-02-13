<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><bk:printProperty key="pages.user_registration.tytle"/></title>
	
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>


<script type="text/javascript">
	function validateForm() {
		var login = document.forms["form"]["login"].value;
		var password = document.forms["form"]["password"].value;

		if (login == "" || password == "") {
			alert("You must fill in all of the required fields!");
			return false;
		}
		return true;
	}
</script>

</head>
<body>

<div class="wrapper">

	<jsp:include page="header.jsp"></jsp:include>
	
	<div id="body">
		
	 <div id="content" align="center">
		<div>
			<c:if test="${message != null}">
				<font color="red">${message}</font>
			</c:if>
		</div>

		<form action="userregistration" method="post" name="form"
			onsubmit="return validateForm()">
			<table>
				<tr><bk:printProperty key="pages.user_registration.page_name"/></tr>
				<tr>
					<td><bk:printProperty key="pages.user_registration.emeil"/></td>
					<td><input type="text" name="email"
						value="<c:out value="${user_login}" />" /></td>
				</tr>

				<tr>
					<td><bk:printProperty key="pages.user_registration.password"/></td>
					<td><input type="password" name="password"
						value="<c:out value="${user_password}" />" /></td>
				</tr>
				<tr>
					<td><bk:printProperty key="pages.user_registration.first_name"/></td>
					<td><input type="text" name="firstName"
						value="<c:out value="${user_firstName}" />" /></td>
				</tr>
				<tr>
					<td><bk:printProperty key="pages.user_registration.last_name"/></td>
					<td><input type="text" name="lastName"
						value="<c:out value="${user_lastName}" />" /></td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>

				<tr>
					<td align="center" colspan="2"><input align="bottom"
						type="submit" value="<bk:printProperty key="pages.user_registration.submit_register"/>" /></td>
				</tr>

			</table>
		</form>
	</div>
			
	</div>

</div>
	
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>