<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="anonymous.tool.form.label.tipo" path="tipo"/>	
	<acme:input-textbox code="anonymous.tool.form.label.name" path="name"/>
	<acme:input-textbox code="anonymous.tool.form.label.code" path="code"/>	
	<acme:input-textbox code="anonymous.tool.form.label.technology" path="technology"/>
	<acme:input-textbox code="anonymous.tool.form.label.description" path="description"/>	
	<acme:input-textbox code="anonymous.tool.form.label.retail-price" path="retailPrice"/>
	<acme:input-textbox code="anonymous.tool.form.label.optional-link" path="optionalLink"/>	
	<acme:input-textbox code="anonymous.tool.form.label.inventor" path="item.inventor.username"/>
</acme:form>