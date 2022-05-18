<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="inventor.quantity.form.label.number"
		path="number" />
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show, update, delete')}">
			<acme:input-textbox code="inventor.item.form.label.name"
				path="item.name" readonly="true" />
			<acme:input-textbox code="inventor.item.form.label.code"
				path="item.code" readonly="true" />
			<acme:input-textbox code="inventor.item.form.label.technology"
				path="item.technology" readonly="true" />
			<acme:input-textbox code="inventor.item.form.label.description"
				path="item.description" readonly="true" />
			<acme:input-textbox code="inventor.item.form.label.retail-price"
				path="item.retailPrice" readonly="true" />
			<acme:input-textbox code="inventor.item.form.label.optional-link"
				path="item.optionalLink" readonly="true" />
				
			<jstl:if test="${item.published == true}">
			<acme:input-textbox code="inventor.item.form.label.published"
			path="published" />
			</jstl:if>
			<acme:input-textbox code="inventor.item.form.label.inventor"
				path="item.inventor.userAccount.username" readonly="true" />
				
			<jstl:if test="${toolkitPublished == false}">
			<acme:submit code="inventor.quantity.form.button.update"
				action="/inventor/quantity/update" />
			<acme:submit code="inventor.quantity.form.button.delete"
				action="/inventor/quantity/delete" />
			</jstl:if>
		</jstl:when>
		
		
		<jstl:when test="${command == 'create'}">
			<acme:input-select code="inventor.quantity.form.label.item"
				path="itemId">
				<jstl:forEach items="${items}" var="item">
					<acme:input-option code="${item.getName()}" value="${item.getId()}"
						selected="${ item.getId() == itemId }" />
				</jstl:forEach>
			</acme:input-select>
			<acme:submit code="inventor.quantity.form.button.create"
				action="/inventor/quantity/create?masterId=${masterId}" />
		</jstl:when>
	</jstl:choose>

</acme:form>