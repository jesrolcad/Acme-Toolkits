<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="authenticated.announcement.form.label.title" path="title"/>
	<acme:input-textbox code="authenticated.announcement.form.label.moment" path="moment"/>	
	<acme:input-textarea code="authenticated.announcement.form.label.body" path="body"/>
	<acme:input-textarea code="authenticated.announcement.form.label.info" path="info"/>	
	<acme:input-select code="authenticated.announcement.form.label.critical" path="critical">
		<acme:input-option code="True" value="True" selected="${tipo == 'True'}"/>
		<acme:input-option code="False" value="False" selected="${tipo == 'False'}"/>
	</acme:input-select>
	
</acme:form>