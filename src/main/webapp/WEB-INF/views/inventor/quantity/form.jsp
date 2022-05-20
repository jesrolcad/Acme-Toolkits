<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
		
		<jstl:if test="${acme:anyOf(command, 'show, update, delete')}">
		
			<acme:input-integer code="inventor.quantity.form.label.number"
			path="number"/>
			<acme:input-textbox code="inventor.item.form.label.tipo" 
				path="item.tipo" readonly="true"/>
			<acme:input-textbox code="inventor.item.form.label.name"
				path="item.name" readonly="true"/>
			<acme:input-money code="inventor.item.form.label.retail-price"
				path="item.retailPrice" readonly="true" />
			<jstl:if test="${differentCurrency == true}">
				<acme:input-money code="inventor.item.form.label.conversion"
				 path="conversion" readonly="true"/>
			 </jstl:if>
			<acme:input-url code="inventor.item.form.label.optional-link"
				path="item.optionalLink" readonly="true" />
				
			</jstl:if>
				
			<jstl:if test="${toolkitPublished == false}">
				<acme:submit code="inventor.quantity.form.button.update"
					action="/inventor/quantity/update" />
				<acme:submit code="inventor.quantity.form.button.delete"
					action="/inventor/quantity/delete" />
			</jstl:if>
		
		
		<jstl:if test="${command == 'create'}">
			<acme:input-integer code="inventor.quantity.form.label.number"
			path="number"/>
			<acme:input-select code="inventor.quantity.form.label.item"
				path="itemId">
				<jstl:forEach items="${items}" var="item">
					<acme:input-option code="${item.getName()}" value="${item.getId()}"
						selected="${ item.getId() == itemId }" />
				</jstl:forEach>
			</acme:input-select>
			<acme:submit code="inventor.quantity.form.button.create"
				action="/inventor/quantity/create?masterId=${masterId}" />
		</jstl:if>
</acme:form>