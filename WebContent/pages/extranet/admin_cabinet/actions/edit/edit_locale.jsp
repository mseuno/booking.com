<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin.edit_locales.title"/></title>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
	
	<script type="text/javascript">
	function validateForm() {
		var update_name = document.forms["form"]["update_name"].value;

		if (update_name == "" ) {
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
				<h1><bk:printProperty key="admin.edit_locales.page_name"/></h1>
					
		<div>
			<c:if test="${message != null}">
				<font color="red">${message}</font>
			</c:if>
		</div>
		
					<form action="adminlocale" method="post" onsubmit="return validateForm()">
						
						<table>
							
							
							
							<tr>
								<td>
									<bk:printProperty key="admin.edit_locales.local_name"/>
								</td>
								<td>
									<input type = text value = "${locale.name }" name="update_name" >
								</td>
							</tr>
							
							<tr>
								<td>
									<input type="hidden" value="${locale.id }" name="locale_id">
									<input type="submit" name="update" value="<bk:printProperty key="admin.edit_locales.submit_update"/>">
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