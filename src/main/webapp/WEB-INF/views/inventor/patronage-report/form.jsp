<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<jstl:if test="${command !='create'}">
		<acme:input-textbox code="inventor.patronageReport.form.label.sequence-number" path="sequenceNumber" />
		<acme:input-moment code="inventor.patronageReport.form.label.creation-moment"  path="creationMoment" />
	</jstl:if>
	<acme:input-textarea code="inventor.patronageReport.form.label.memorandum" path="memorandum"/>
	<acme:input-url code="inventor.patronageReport.form.label.link" path="link"/>
	<jstl:if test="${command == 'create'}">
		<acme:input-checkbox code="inventor.patronageReport.form.label.confirmation" path="confirmation"/>
	</jstl:if>
	<acme:submit test="${command == 'create' && status == 'ACCEPTED'}" code="inventor.patronageReport.list.button.create" action="/inventor/patronage-report/create?patronageId=${patronageId}"/>
</acme:form>