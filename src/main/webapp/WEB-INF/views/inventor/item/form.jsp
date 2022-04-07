<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="inventor.item.form.label.tipo" path="tipo" />
	<acme:input-textbox code="inventor.item.form.label.name" path="name" />
	<acme:input-textbox code="inventor.item.form.label.code" path="code" />
	<acme:input-textbox code="inventor.item.form.label.technology"
		path="technology" />
	<acme:input-textbox code="inventor.item.form.label.description"
		path="description" />
	<acme:input-textbox code="inventor.item.form.label.retailPrice"
		path="retailPrice" />
	<acme:input-textbox code="inventor.item.form.label.published"
		path="published" />
	<acme:input-textbox code="inventor.item.form.label.optionalLink"
		path="optionalLink" />
	<acme:input-textbox code="inventor.item.form.label.inventor"
		path="inventor.userAccount.username" />
</acme:form>