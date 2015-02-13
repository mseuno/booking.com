<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:choose>

	<c:when test="${success}">
		<div class="success-book">
			<bk:printProperty key="result_fragments.success"/>
		</div>
	</c:when>
	<c:otherwise>
		<div class="error-book">
			<bk:printProperty key="result_fragments.error"/>
		</div>
	</c:otherwise>
</c:choose>
	

