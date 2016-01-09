<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<spring:message code="button.submeter_respostas" var="submeterRespostas" />

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<script>
			document.getElementById('home').classList.toggle('disabled');
			document.getElementById('restaurantes').classList
					.toggle('disabled');
		</script>
		<div class="form-group">
			<div class="body">
				<div class="container">
					<h3>
						<spring:message code="finalizar_participacao" />
					</h3>
					<fieldset>
						<form:form role="form" action="${contextPath}/usuario/submit"
							method="post" commandName="novoUsuario">
							<div class="row">
								<div class="form-group col-lg-4">
									<label for="code"><spring:message
											code="label.nome_completo" /></label>
									<form:input path="nomeCompleto" type="text" name="nomeCompleto"
										id="nomeCompleto" required="true" class="form-control" />
								</div>
							</div>

							<div class="row">
								<div class="form-group col-lg-4">
									<label for="code"><spring:message code="label.email" /></label>
									<form:input path="email" type="email" name="email" id="email"
										required="true" class="form-control" />
								</div>
							</div>

							<div class="row">
								<div class="form-group col-lg-4">
									<input type="submit" class="btn btn-primary col-lg-4 form-control"
										value="${submeterRespostas}">
								</div>
							</div>
						</form:form>
					</fieldset>
				</div>
			</div>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>