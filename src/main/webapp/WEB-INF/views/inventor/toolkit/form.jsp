<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>	
	<acme:input-textbox code="inventor.toolkit.form.label.description" path="description"/>	
	<acme:input-textbox code="inventor.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-textbox code="inventor.toolkit.form.label.optional-link" path="optionalLink"/>	
	<acme:input-textbox code="inventor.toolkit.form.label.retailPrice" path="retailPrice"/>
	<acme:input-textbox code="inventor.toolkit.form.label.inventor" path="inventor.userAccount.username"/>
	
	<acme:button code="inventor.toolkit.form.button.items" action="/inventor/item/listToolkitItems?id=${id}"/>
</acme:form>