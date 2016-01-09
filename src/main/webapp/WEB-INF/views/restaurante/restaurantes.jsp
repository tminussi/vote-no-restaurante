<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<table class="table">
			<thead>
				<tr>
					<th class="text-center"><spring:message code="label.restaurante_nome" /></th>
					<th class="text-center"><spring:message code="label.restaurante_comida_tipica" /></th>
					<th class="text-center"><spring:message code="label.restaurante_imagem" /></th>
				</tr>
			</thead>
			<tbody class="restaurantes">
				<c:forEach items="${restaurantes}" var="restaurante">
					<tr>
						<td>${restaurante.nome}</td>
						<td>${restaurante.comidaTipica}</td>
						<td><img src="<c:url value="/resources/images/${restaurante.imagem}"/>" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</tiles:putAttribute>
</tiles:insertDefinition>