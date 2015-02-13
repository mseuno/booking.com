<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin_new_admin.title"/></title>

	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
	
<script type="text/javascript">
	function validateForm() {
		var email = document.forms["form"]["email"].value;
		var password = document.forms["form"]["password"].value;

		if (email == "" || password == "") {
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
		
		<div id="body" style="margin-left: 10px ">
			
			<div id="menu" style="width: 200px; float: left;">
				<jsp:include page="/pages/extranet/admin_cabinet/menu_admin.jsp"></jsp:include>
		 </div>
				
				 <div id="content" align="center">
				 
						<h2><bk:printProperty key="admin_new_admin.page_name"/></h2>
						
		<div>
			<c:if test="${message != null}">
				<font color="red">${message}</font>
			</c:if>
		</div>

				<form action="newadmin" method="post" id="form"
					onsubmit="return validateForm()">
					<table>
						<tr>
							<td><bk:printProperty key="admin_new_admin.email"/></td>
							<td><input type="text" name="email" value="${userlogin }"
								required="true" /></td>
						</tr>
		
						<tr>
							<td><bk:printProperty key="admin_new_admin.password"/></td>
							<td><input type="text" name="password" 
								required="true"  /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="admin_new_admin.first_name"/></td>
							<td><input type="text" name="firstName" value="${userfirstName }"
								 /></td>
						</tr>
						<tr>
							<td><bk:printProperty key="admin_new_admin.last_name"/></td>
							<td><input type="text" name="lastName" value="${userlastName }"
								 /></td>
						</tr>
						<tr>
							<td colspan="2"></td>
						</tr>
		
						<tr>
							<td></td>
							<td align="center" colspan="2"><input align="bottom"
								type="submit" value="<bk:printProperty key="admin_new_admin.submit_register"/>" name="newAdmin"/></td>
						</tr>
		
					</table>
				</form>
				
				
				
					</div>
				</div>
			</div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
				
</body>
</html>