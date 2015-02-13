<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin.message.reply.title"/></title>
</head>


</head>

<body>
	<table>
		<tr>
			<td>
				<pre>${message.message}</pre>
			</td>
		</tr>
		<tr>
			<td><bk:printProperty key="admin.message.reply.page_name"/> <br />
				<form action="adminreply" method="post">
					<textarea rows="10" cols="70" name="text_area"></textarea>
					<br /> <input type="submit" name="send" value="<bk:printProperty key="admin.message.reply.submit_submit"/>" />
				</form>

			</td>
		</tr>
	</table>
</body>
</html>