<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-default">
	<div class="container-fluid">

		<div class="collapse navbar-collapse" id="navbar">
			<ul class="nav navbar-nav">
				<li id="home"><a class="navbar-brand" href="${contextPath}/">Home</a></li>
				<li id="restaurantes"><a href="${contextPath}/restaurantes"><spring:message code="header.restaurantes" /></a></li>
			</ul>
		</div>
	</div>
</nav>
