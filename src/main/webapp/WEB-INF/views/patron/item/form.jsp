<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-select code="patron.item.form.label.tipo" path="tipo">	
		<acme:input-option code="TOOL" value="TOOL" selected="${tipo == 'TOOL'}"/>
		<acme:input-option code="COMPONENT" value="COMPONENT" selected="${tipo == 'COMPONENT'}"/>
	</acme:input-select>
	<acme:input-textbox code="patron.item.form.label.name" path="name"/>
	<acme:input-textbox code="patron.item.form.label.code" path="code"/>	
	<acme:input-textbox code="patron.item.form.label.technology" path="technology"/>
	<acme:input-textbox code="patron.item.form.label.description" path="description"/>	
	<acme:input-textbox code="patron.item.form.label.retail-price" path="retailPrice"/>
	<acme:input-textbox code="patron.item.form.label.optional-link" path="optionalLink"/>	
	<acme:input-textbox code="patron.item.form.label.inventor" path="item.inventor"/>
</acme:form>