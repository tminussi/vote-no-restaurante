<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<c:if test="${not empty testeIniciado}">
			<script>
				document.getElementById('home').classList.toggle('disabled');
				document.getElementById('restaurantes').classList
						.toggle('disabled');
			</script>
		</c:if>

		<div class="body">
			<c:if test="${empty restaurantes}">
				<form method="POST" action="${contextPath}/usuario/novo" id="novoUsuario"></form>
				<script>
					$('#novoUsuario').submit();
				</script>
			</c:if>
			<form method="post" action="${contextPath}/">
				<c:if test="${not empty restaurantes}">
					<h2 align="center">
						<spring:message code="vote_restaurante_favorito" />
					</h2>
					<hr>
					<div class="center-panel">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<spring:message code="gosta_mais" />
							</div>
							<div class="panel-body">
								<div class="imagens-restaurantes">
									<c:forEach items="${restaurantes}" var="restaurante" varStatus="status">
										<input type="image" name="restauranteID" value="${restaurante.id}" src="<c:url value="/resources/images/${restaurante.imagem}"/>" />
										<div>
											<c:if test="${status.first}">
												<h1>X</h1>
											</c:if>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</form>
		</div>



	</tiles:putAttribute>
</tiles:insertDefinition>