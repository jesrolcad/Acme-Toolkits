<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="administrator.announcement.form.label.title" path="title"/>
	<acme:input-textarea code="administrator.announcement.form.label.body" path="body"/>
	<acme:input-url code="administrator.announcement.form.label.info" path="info" placeholder="https://google.com"/>	
	<acme:input-checkbox code="administrator.announcement.form.label.critical" path="critical"/>
	
	<jstl:if test="${!readonly}">
		<acme:input-checkbox code="administrator.announcement.form.label.confirmation" path="confirmation"/>
		<acme:submit code="administrator.announcement.form.button.create" action="/administrator/announcement/create"/>
	</jstl:if>
		
	
</acme:form>