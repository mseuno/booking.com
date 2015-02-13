<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:choose>

	<c:when test="${fn:length(hotel.rooms) gt 0}">
	
		<div class="booking-table-conatiner">
			<table>
				<tr>
					<th><bk:printProperty key="available_rooms_fragment.room_type"/></th>
					<th><bk:printProperty key="available_rooms_fragment.number_of_person"/></th>
					<th><bk:printProperty key="available_rooms_fragment.count"/></th>
					<th><bk:printProperty key="available_rooms_fragment.cost"/></th>
					<th><bk:printProperty key="available_rooms_fragment.booking"/></th>
				</tr>
				
				
				<tr>
					<td colspan="4" style="padding: 0"></td>
					<td rowspan="1000" class="booking-cell">
						
						<c:if test="${showUserInfo}">
							<div id="user-info-form">
								<div>
									<div class="input-error"><bk:printProperty key="available_rooms_fragment.name_error"/></div>
									<div class="label"><bk:printProperty key="available_rooms_fragment.name"/></div>
									<input placeholder="" class="booking-form-field" type="text" id="user-name-field" required="required"/>
								</div>
								<div>
									<div class="input-error"><bk:printProperty key="available_rooms_fragment.surname_error"/></div>
									<div class="label"><bk:printProperty key="available_rooms_fragment.surname"/></div>
									<input placeholder="" class="booking-form-field" type="text" id="user-surname-field" required="required"/>
								</div>
								<div>
									<div class="input-error"><bk:printProperty key="available_rooms_fragment.mail_error"/></div>
									<div class="label"><bk:printProperty key="available_rooms_fragment.mail"/></div>
									<input placeholder="mail@example.com" class="booking-form-field" type="email" id="user-mail-field" required="required"/>
								</div>
								<div>	
									<div class="input-error"><bk:printProperty key="available_rooms_fragment.phone_error"/></div>
									<div class="label"><bk:printProperty key="available_rooms_fragment.phone"/></div>
									<input placeholder="093123456" class="booking-form-field" type="text" id="user-phone-field" required="required"/>
								</div>
							</div>
						</c:if>
						
						<div id="booking-form-total-price">
							$0
						</div>
						<div id="booking-form-book-btn">
							<bk:printProperty key="available_rooms_fragment.book_it"/>
						</div>
					
					</td>
				</tr>
				
				<c:forEach items="${hotel.rooms}" var="room">
					<tr class="room-table-row" data-param="${room.id}">
						<td class="room-type">
							${room.roomInfo.name}
						</td>
						<td class="number-of-people">
							${room.numberOfPeople}
						</td>
						<td>
							<select class="room-count-selector" data-param="${room.id}">
								<option value="0">0</option>
								<c:forEach begin="1" end="${room.numberOfRooms}" var="roomCount">
									<option value="${roomCount}">
										${roomCount}
									</option>				
								</c:forEach>
							</select>
						</td>
						<td class="cost">
							$
							<span class="room-cost" id="room-cost-${room.id}">
								${room.cost}
							</span>
						</td>
					</tr>
				</c:forEach>
			</table>
		
		</div>
			
	</c:when>
	<c:otherwise>
		<bk:printProperty key="hotel.page.no_rooms_available"/>
	</c:otherwise>
</c:choose>
