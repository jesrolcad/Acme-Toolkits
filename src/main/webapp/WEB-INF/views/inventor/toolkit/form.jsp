<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>	
	<acme:input-textbox code="inventor.toolkit.form.label.description" path="description"/>	
	<acme:input-textbox code="inventor.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-textbox code="inventor.toolkit.form.label.optional-link" path="optionalLink"/>	
	<acme:input-textbox code="inventor.toolkit.form.label.inventor" path="inventor.userAccount.username" readonly="true"/>
	
	<jstl:choose>
	<jstl:when test="${command == 'show' && published == true}">
	<acme:input-textbox code="inventor.toolkit.form.label.retailPrice" path="retailPrice"/>
	<acme:button code="inventor.toolkit.form.button.items" action="/inventor/item/listToolkitItems?id=${id}"/>
	</jstl:when>
	<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && published == false}">
	<acme:input-textbox code="inventor.toolkit.form.label.retailPrice" path="retailPrice" readonly="true"/>	
	<acme:button code="inventor.toolkit.form.button.items" action="/inventor/item/listToolkitItems?id=${id}"/>
	<<acme:submit code="inventor.toolkit.form.button.delete" action="/inventor/toolkit/delete"/>
	<<acme:submit code="inventor.toolkit.form.button.update" action="/inventor/toolkit/update"/>
	<<acme:submit code="inventor.toolkit.form.button.publish" action="/inventor/toolkit/publish"/>
	</jstl:when>
	<jstl:when test="${command == 'create'}">
	<<acme:submit code="inventor.toolkit.form.button.create" action="/inventor/toolkit/create"/>
	</jstl:when>
	</jstl:choose>
	
</acme:form>