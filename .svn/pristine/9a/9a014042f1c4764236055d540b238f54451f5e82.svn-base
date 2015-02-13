<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tags/bookingTag.tld" prefix="bk" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<div id="header">
		<div class="logo"><a href="home"><img alt="logo" src="resources/images/logo.png"></a></div>
		<ul>
			<li>
				<a href="<c:url value="/"><c:param name="language" value="ukraine"/></c:url>">
					<img alt="Українська" src="resources/images/ukraine-flag.png">
			    </a>  
			</li>
			<li>
				<a href="<c:url value="/"><c:param name="language" value="english"/></c:url>">
					<img alt="English" src="resources/images/uk-flag.png">
				</a> 
			</li>
			<li>
				<c:choose>
					<c:when test="${user != null}">
						<c:choose>
							<c:when test="${userCabinetState}">
								<div class="btn-group">
									<div class="header-user-name" id="expandeble-user-name-menu">
										<span class="caret"></span> ${user.firstName} 
									</div>									
									 <ul class="dropdown-menu" role="menu">
									    <li><a href="userfavorites">Favorite</a></li>
									    <li><a href="user">Current</a></li>
									    <li><a href="userhistory">History</a></li>
									    <li class="divider"></li>
									    <li><a href="userprofile">Profile</a></li>
									  </ul>
								</div>
							</c:when>
							<c:otherwise>
								<div class="header-user-name">
									<a href="cabinet">${user.firstName}</a>
								</div>
							</c:otherwise>
						</c:choose>	
					</c:when>
					<c:otherwise>
						<a href="userlogin"><bk:printProperty key="header.login"/></a>
					</c:otherwise>
				</c:choose>
			</li>
			<li>
				<c:choose>
					<c:when test="${user != null}">
							<a href="signout"><bk:printProperty key="header.signout"/></a>
					</c:when>
					<c:otherwise>
							<a href="userregistration"><bk:printProperty key="header.registration"/></a>
					</c:otherwise>
				</c:choose>
			</li>
		</ul>
	</div>