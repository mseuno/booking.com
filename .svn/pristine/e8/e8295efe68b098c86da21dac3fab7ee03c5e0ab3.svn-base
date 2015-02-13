<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="manager.booking.title"/></title>
	
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
	
	
	<div id="body" style="margin-left: 10px ">
	
		<div id="menu" style="width: 200px; float: left;">
			<jsp:include page="/pages/extranet/manager_cabinet/menu.jsp"></jsp:include>
		 </div>
	 	 <div id="content" align="center">
				<h2><bk:printProperty key="manager.booking.page_name"/></h2>
	
     			<form method="post" action="cabinetbooking">		
     			<br><input type="submit" value="<bk:printProperty key="manager.booking.denied_done"/>" name="all"/> 
     			<input type="submit" value="<bk:printProperty key="manager.booking.done"/>" name="done"/> 
     			<input type="submit" value="<bk:printProperty key="manager.booking.denied"/>" name="denied"/> 
			 				  
				<br><br><table>
					<tr>
						<td></td>
						<td><bk:printProperty key="manager.booking.begin_date"/></td>
						<td><bk:printProperty key="manager.booking.end_date"/></td>
						<td><bk:printProperty key="manager.booking.status"/></td>
						<td><bk:printProperty key="manager.booking.user_fn"/></td>
						<td><bk:printProperty key="manager.booking.user_ln"/></td>		
						<td><bk:printProperty key="manager.booking.email"/></td>
						<td><bk:printProperty key="manager.booking.total_cost"/></td>
						<td><br><br></td>
					</tr>
					
				<c:forEach var="booking" items="${bookings}">
				<tr>
					<td><a href="javascript:void(0)" onclick="showHide(${booking.id})">
						<span class="glyphicon glyphicon-align-justify"></span></a></td>
					<td>${booking.beginDate}</td>
					<td>${booking.endDate}</td>
					<td>
					<c:if test="${booking.status eq 2}"><bk:printProperty key="manager.booking.subm"/></c:if>
					<c:if test="${booking.status eq 3}"><bk:printProperty key="manager.booking.dend"/></c:if>
					<c:if test="${booking.status eq 0}"><bk:printProperty key="manager.booking.done"/></c:if>
					</td>
					<td>${booking.user.firstName}</td>
					<td>${booking.user.lastName}</td>		
					<td>${booking.user.email}</td>
					<td>${booking.totalCost}</td>
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