<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:choose>

	<c:when test="${fn:length(hotel.rooms) gt 0}">
		<table>
			<tr>
				<th><bk:printProperty key="all_room_fragments.room_type"/></th>
				<th><bk:printProperty key="all_room_fragments.number_of_person"/></th>
				<th><bk:printProperty key="all_room_fragments.cost"/></th>
			</tr>
			<c:forEach items="${hotel.rooms}" var="room">
				<tr>
					<td class="room-type">
						${room.roomInfo.name}
					</td>
					<td class="number-of-people">
						${room.numberOfPeople}
					</td>
					<td class="cost">
						$ ${room.cost}
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<bk:printProperty key="hotel.page.no_rooms_available"/>
	</c:otherwise>
</c:choose>
	

