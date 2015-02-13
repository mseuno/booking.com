<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin_locale.title"/></title>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
	
<script type="text/javascript">
	function validateForm() {
		var new_locale_name = document.forms["form"]["new_locale_name"].value;
		var new_locale_id = document.forms["form"]["new_locale_id"].value;

		if (new_locale_name == "" || new_locale_id == "") {
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
				<h1><bk:printProperty key="admin_locale.page_name"/></h1>
				
		<div>
			<c:if test="${message != null}">
				<font color="red">${message}</font>
			</c:if>
		</div>
					
					<form action="adminlocale" method="post" id="form"
					onsubmit="return validateForm()">
						<table>
							
								
								
								
							<c:if test="${not empty formLocale }">
								<tr>
									<td>
										<bk:printProperty key="admin_locale.locale_name"/>
									</td>
									<td>
										<input type="text" name="new_locale_name" required="true">
									</td>
									<td>
										<bk:printProperty key="admin_locale.locale_id"/>
									</td>
									<td>
										<input type="text" name="new_locale_id" required="true">
									</td>
								</tr>
								<tr>
									<td>
										<input type="hidden" name="add_locale" value="add">
										<input type="submit" name="add" value="add">
									</td>
								</tr>
								
							</c:if>
								
							<c:if test="${empty formLocale }">
								
								<tr>
									<td>
										<input type="hidden" name="create_locale" value="qwer">
										<input type="submit" name="create" value="<bk:printProperty key="admin_locale.submit_add_new_locale"/>">
									</td>
								</tr>
							
									<c:forEach items="${locales }" var="locale">
										<tr>
											<td>
												<a href="<c:url value="adminlocale">
												<c:param name="edit_update" value="update"/>
												<c:param name="edit_id" value="${locale.id}"/> 
												</c:url>">${locale.name}</a>
											</td>
											<td>
												<c:out value="${locale.id }"></c:out>	
											</td>
										</tr>	
									</c:forEach>
							</c:if>
							
							
						
						</table>
					</form>
				
				
				</div>
			</div>
		</div>	
	<jsp:include page="/pages/footer.jsp"></jsp:include>
				
</body>
</html>