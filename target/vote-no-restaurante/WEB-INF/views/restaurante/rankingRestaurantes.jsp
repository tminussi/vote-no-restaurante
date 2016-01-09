<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<h2 align="center">
			<spring:message code="ranking_restaurantes" />
		</h2>

		<c:if test="${not empty obrigado}">
			<div class="alert alert-info fade in">
				<span class="close" data-dismiss="alert" aria-label="close">&times;</span> <strong>${obrigado}</strong>
			</div>
		</c:if>

		<c:if test="${not empty participou}">
			<div class="alert alert-danger fade in">
				<span class="close" data-dismiss="alert" aria-label="close">&times;</span> <strong>${participou}</strong>
			</div>
		</c:if>

		<table class="table">
			<thead>
				<tr>
					<th class="text-center"><spring:message code="label.posicao" /></th>
					<th class="text-center"><spring:message code="label.restaurante_nome" /></th>
					<th class="text-center"><spring:message code="label.restaurante_votos" /></th>
				</tr>
			</thead>
			<tbody class="restaurantes">
				<c:forEach items="${topRestaurantes}" var="restaurante" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${restaurante.nome}</td>
						<td>${restaurante.votos}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${not empty votosUsuario}">
			<h2 align="center">
				<spring:message code="ranking_usuario" />
			</h2>
			<hr>
			<table class="table">
				<thead>
					<tr>
						<th class="text-center"><spring:message code="label.restaurante_nome" /></th>
						<th class="text-center"><spring:message code="label.restaurante_votos" /></th>
					</tr>
				</thead>
				<tbody class="restaurantes">
					<c:forEach items="${votosUsuario}" var="votosUsuario">
						<tr>
							<td>${votosUsuario.nome}</td>
							<td>${votosUsuario.votos}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty votosUsuario and empty participou}">
			<h2 align="center"><spring:message code="nao_participou_ainda" /> <a href="${contextPath}/"><spring:message code="aqui" /></a></h2>
		</c:if>

	</tiles:putAttribute>
</tiles:insertDefinition>