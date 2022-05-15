<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
<acme:input-textbox code="inventor.quantity.form.label.number" path="number"/>
	<jstl:if test="${command == 'create'}">	
	        <acme:input-select code="inventor.quantity.form.label.item" path="itemId">
	   			<jstl:forEach items="${items}" var="item">
					<acme:input-option code="${item.getName()}" value="${item.getId()}" selected="${ item.getId() == inventId }"/>
				</jstl:forEach>
			</acme:input-select>
		</jstl:if>	
	<jstl:choose>
		<jstl:when test="${command == 'create'}">
			<acme:submit code="inventor.quantity.form.button.create"
				action="/inventor/quantity/create" />
		</jstl:when>
	</jstl:choose>
</acme:form>