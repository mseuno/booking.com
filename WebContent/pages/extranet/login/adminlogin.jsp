<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><bk:printProperty key="admin_login.title"/></title>
	
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/lib/ui-lightness/jquery-ui-1.10.4.custom.min.css"/>
	
	<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery.cookie.js"></script>
	<script type="text/javascript" src="resources/js/lib/jquery-ui-1.10.4.custom.min.js"></script>
	<script type="text/javascript" src="resources/js/home.page.js"></script>

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

	<jsp:include page="/pages/header.jsp"></jsp:include>
	
	<div id="body">
		
	 <div id="content" align="center">
		<div>
			<c:if test="${message != null}">
				<font color="red">${message}"</font>
			</c:if>
		</div>

		<form action="adminlogin" method="post" name="form"
			onsubmit="return validateForm()">
			<table>
				<tr><bk:printProperty key="admin_login.page_name"/></tr>
				<tr>
					<td><bk:printProperty key="admin_login.email"/></td>
					<td>
					<c:choose>
						<c:when test="${admin_login != null}">
    						<input type="text" name="login" value="${admin_login}" />
  						</c:when>
  						<c:otherwise>
   							<input type="text" name="login" value="${admin_cookie_email}" />
  						</c:otherwise>
					</c:choose>	
					
					</td>
				</tr>

				<tr>
					<td><bk:printProperty key="admin_login.password"/></td>
					<td><input type="password" name="password"
						value="<c:out value="${user.password}" />" /></td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>

				<tr>
					<td align="center" colspan="2">
					<input align="bottom" type="submit" value="<bk:printProperty key="admin_login.submit_sign_in"/>" />
					
					
					</td>
				</tr>

			</table>
		</form>
	</div>
			
	</div>

</div>
	
<jsp:include page="/pages/footer.jsp"></jsp:include>

</body>
</html>