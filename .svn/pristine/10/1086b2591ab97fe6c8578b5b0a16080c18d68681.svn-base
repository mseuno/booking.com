<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="manager.home.title"/></title>

<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
<script type="text/javascript" src="resources/js/lib/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="resources/js/extranet/manager/edit.hotel.page.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	
	
	<script type="text/javascript">
            /**
            * Функция Скрывает/Показывает блок 
            * @author ox2.ru дизайн студия
            **/
            function showHide(element_id) {
                //Если элемент с id-шником element_id существует
                if (document.getElementById(element_id)) { 
                    //Записываем ссылку на элемент в переменную obj
                    var obj = document.getElementById(element_id); 
                    //Если css-свойство display не block, то: 
                    if (obj.style.display != "block") { 
                        obj.style.display = "block"; //Показываем элемент
                    }
                    else obj.style.display = "none"; //Скрываем элемент
                }
                //Если элемент с id-шником element_id не найден, то выводим сообщение
                else alert("Элемент с id: " + element_id + " не найден!"); 
            }   
        </script>

</head>

<body>
	<div class="wrapper">

		<jsp:include page="/pages/header.jsp"></jsp:include>


		<div id="body" style="margin-left: 10px">

			<div id="menu" style="width: 200px; float: left;">
				<jsp:include page="/pages/extranet/manager_cabinet/menu.jsp"></jsp:include>
			</div>
			<div id="content" align="center">
				<form method="post" action="manager">
						<input  class="btn btn-danger" type="submit" name="booking_un_confirmed_list" value="<bk:printProperty key="manager.home.submit_booking_un_confirmed_list"/>"/>
						<input  class="btn btn-success" type="submit" name="booking_confirmed_list" value="<bk:printProperty key="manager.home.submit_booking_confirmed_list"/>"/>

					<h2>${message}</h2>					
						<table>
							<tr>
							<td></td>
								<td><bk:printProperty key="manager.home.begin_date"/></td>
								<td><bk:printProperty key="manager.home.end_date"/></td>
								<td><bk:printProperty key="manager.home.user_fn"/></td>
								<td><bk:printProperty key="manager.home.user_ln"/></td>
								<td><bk:printProperty key="manager.home.email"/></td>
								<td><bk:printProperty key="manager.home.cost"/></td>
							</tr>
							<c:forEach var="booking" items="${bookings}">
								<tr>
									<td><a href="javascript:void(0)" onclick="showHide(${booking.id})">
									<span class="glyphicon glyphicon-align-justify" title="booking room"></span></a></td>
									<td>${booking.beginDate}</td>
									<td>${booking.endDate}</td>
									<td>${booking.user.firstName}</td>
									<td>${booking.user.lastName}</td>
									<td>${booking.user.email}</td>
									<td>${booking.totalCost}</td>
									
									<c:choose>
									<c:when test="${booking.status == 2}">
									
									<td><a href="<c:url value="manager">
									<c:param name="edit_confirm_confirmed" value="accept"/>
									<c:param name="edit_id" value="${booking.id}"/> 
									</c:url>">
									<span class="glyphicon glyphicon-thumbs-up" title="done"></span>
									</a></td>
									
									<td><a href="<c:url value="manager">
									<c:param name="edit_denied_confirmed" value="accept"/>
									<c:param name="edit_id" value="${booking.id}"/> 
									</c:url>">
									<span class="glyphicon glyphicon-thumbs-down" title="denied"></span>
									</a></td>
									
									</c:when>
									<c:otherwise>
									
									<td><a href="<c:url value="manager">
									<c:param name="edit_confirm" value="accept"/>
									<c:param name="edit_id" value="${booking.id}"/> 
									</c:url>">
									<span class="glyphicon glyphicon-pushpin" title="confirm"></span>
									</a></td>
									
									<td><a href="<c:url value="manager">
									<c:param name="edit_denied" value="accept"/>
									<c:param name="edit_id" value="${booking.id}"/> 
									</c:url>">
									<span class="glyphicon glyphicon-thumbs-down" title="to denied"></span>
									</a></td>
									
									</c:otherwise>
									</c:choose>
									

								</tr>
								<tr>
								<td colspan="5">
								 <div id="${booking.id}" style="display: none;">
									  <c:forEach var="list" items="${booking.bookingRoom}">
										<table>
										<tr>
											 <td>${list.room.roomInfo.name}</td>
											 <td>${list.cost}</td>
										</tr>
										</table>
									
									</c:forEach>
									</div>
									</td>
								</tr>
							</c:forEach>
						</table>

					</form>
			</div>

		</div>

	</div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>