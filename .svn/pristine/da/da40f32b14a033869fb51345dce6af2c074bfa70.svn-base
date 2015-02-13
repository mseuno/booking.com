<%@page import="com.sun.jmx.snmp.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bk:printProperty key="admin.manager_respond.title"/></title>

<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/admin.css"/>
	
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

		<jsp:include page="/pages/header.jsp" />

<div class="apllication">
	 	 <div  class="apllication" id="menu">
			<jsp:include page="/pages/extranet/admin_cabinet/menu_admin.jsp"></jsp:include>
		 </div>
		 <div class="apllication" id="content" >
			<form action="adminreply" method="post">
			
									<input type="submit" name="new" value ="<bk:printProperty key="admin.manager_respond.new"/>" class="btn btn-primary">
									<input type="submit" name="accept" value ="<bk:printProperty key="admin.manager_respond.accept"/>" class="btn btn-success">
									<input type="submit" name="important" value ="<bk:printProperty key="admin.manager_respond.important"/>" class="btn btn-warning">
									<input type="submit" name="dismit" value ="<bk:printProperty key="admin.manager_respond.dissmit"/>" class="btn btn-danger">
									<input type="submit" name="all" value ="<bk:printProperty key="admin.manager_respond.history"/>" class="btn btn-inverse">
			<table class="table table-condensed">
				
				<c:forEach items="${manager_message_list }" var="list">
				<tr>
					<td>
						<c:if test="${list.type == 0 }">
							New Country
						</c:if> <c:if test="${list.type == 1 }">
							New Region
						</c:if> <c:if test="${list.type == 2 }">
							New City
						</c:if> <c:if test="${list.type == 3 }">
							New Street
						</c:if> <c:if test="${list.type == 4 }">
							Error
						</c:if> <c:if test="${list.type == 5 }">
							Else
						</c:if>
					</td>
					
					
					
					<td><a href="javascript:void(0)" onclick="showHide(${list.id})">
						${fn:substring(list.message,0,60)}</a>
						
							<div id="${list.id}" style="display: none;">
								 ${list.message}
							</div>
						
					</td>
					
					<td>
					<a href="<c:url value="adminreply">
									<c:param name="edit_accept" value="accept"/>
									<c:param name="edit_id" value="${list.id}"/> 
									</c:url>">
								<span class="glyphicon glyphicon-thumbs-up"></span>
					</a>
						
					</td>
					<td>
					<a href="<c:url value="adminreply">
									<c:param name="edit_dismit" value="dismit"/>
									<c:param name="edit_id" value="${list.id}"/> 
									</c:url>">
								<span class="glyphicon glyphicon-thumbs-down"></span>
					</a>
						
					</td>
					<td>
					<a href="<c:url value="adminreply">
									<c:param name="edit_important" value="important"/>
									<c:param name="edit_id" value="${list.id}"/> 
									</c:url>">
								<span class="glyphicon glyphicon-pushpin"></span>
					</a>
						
					</td>
					<td>
				     	${list.lastUpdate}
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