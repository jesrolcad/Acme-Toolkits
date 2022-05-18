<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>	
	<acme:input-textarea code="inventor.toolkit.form.label.description" path="description"/>	
	<acme:input-textarea code="inventor.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-url code="inventor.toolkit.form.label.optional-link" path="optionalLink"/>		
	
	<jstl:choose>
	<jstl:when test="${command == 'show' && published == true}">
	<acme:input-textbox code="inventor.toolkit.form.label.inventor" path="inventor.userAccount.username" readonly="true"/>
	<acme:input-money code="inventor.toolkit.form.label.retailPrice" path="retailPrice"/>
	<acme:input-textbox code="inventor.toolkit.form.label.published" path="published"/>
	
	</jstl:when>
	<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && published == false}">
	<acme:input-textbox code="inventor.toolkit.form.label.inventor" path="inventor.userAccount.username" readonly="true"/>
	<acme:input-money code="inventor.toolkit.form.label.retailPrice" path="retailPrice" readonly="true"/>	
	<acme:submit code="inventor.toolkit.form.button.delete" action="/inventor/toolkit/delete"/>
	<acme:submit code="inventor.toolkit.form.button.update" action="/inventor/toolkit/update"/>
	<acme:submit code="inventor.toolkit.form.button.publish" action="/inventor/toolkit/publish"/>
	</jstl:when>
	<jstl:when test="${command == 'create'}">
	<acme:submit code="inventor.toolkit.form.button.create" action="/inventor/toolkit/create"/>
	</jstl:when>
	</jstl:choose>
	
	<jstl:if test="${command != 'create'}">
	<acme:button code="inventor.toolkit.form.button.items" action="/inventor/quantity/list?masterId=${masterId}"/>
	</jstl:if>
	
</acme:form>