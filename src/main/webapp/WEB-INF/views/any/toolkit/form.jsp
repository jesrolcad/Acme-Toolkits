<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	
	<acme:input-textbox code="any.toolkit.form.label.code" path="code"/>	
	<acme:input-textbox code="any.toolkit.form.label.description" path="description"/>	
	<acme:input-textbox code="any.toolkit.form.label.assembly-notes" path="assemblyNotes"/>
	<acme:input-textbox code="any.toolkit.form.label.optional-link" path="optionalLink"/>	
	<acme:input-textbox code="any.toolkit.form.label.retailPrice" path="retailPrice"/>
	
	<acme:button code="any.toolkit.form.button.items" action="/any/item/listToolkitItems?id=${id}"/>
</acme:form>