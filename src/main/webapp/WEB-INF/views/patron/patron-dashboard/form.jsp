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
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<acme:form>
	<acme:message code="patron.patron-dashboard.form.label.averageTitle"/>
	<br>		
		<jstl:forEach items="${averageBudgetByCurrency}" var="entry"> 
		<br>		
		<acme:message code="patron.patron-dashboard.form.label.currency"/>		
		<jstl:set var = "string1" value = "${entry.key}"/>
		<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
		<acme:print value="${string2[0]}"/>
		<acme:message code="patron.patron-dashboard.form.label.status"/>		
		<acme:print value="${string2[1]}"/>
		<acme:message code="patron.patron-dashboard.form.label.avgvalue"/>		
		<acme:print value="${entry.value}"/>
		</jstl:forEach>
		<br>
	<br>
	<acme:message code="patron.patron-dashboard.form.label.deviationTitle"/>
	<br>			
		<jstl:forEach items="${deviationBudgetByCurrency}" var="entry"> 
		<br>		
		<acme:message code="patron.patron-dashboard.form.label.currency"/>		
		<jstl:set var = "string1" value = "${entry.key}"/>
		<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
		<acme:print value="${string2[0]}"/>
		<acme:message code="patron.patron-dashboard.form.label.status"/>		
		<acme:print value="${string2[1]}"/>
		<acme:message code="patron.patron-dashboard.form.label.deviationvalue"/>		
		<acme:print value="${entry.value}"/>
		</jstl:forEach>
		<br>
	<br>			
	<acme:message code="patron.patron-dashboard.form.label.minTitle"/>
	<br>				
		<jstl:forEach items="${minBudgetByCurrency}" var="entry"> 
		<br>
		<acme:message code="patron.patron-dashboard.form.label.currency"/>		
		<jstl:set var = "string1" value = "${entry.key}"/>
		<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
		<acme:print value="${string2[0]}"/>
		<acme:message code="patron.patron-dashboard.form.label.status"/>		
		<acme:print value="${string2[1]}"/>
		<acme:message code="patron.patron-dashboard.form.label.minvalue"/>		
		<acme:print value="${entry.value}"/>
		</jstl:forEach>
		<br>			
	<br>			
	<acme:message code="patron.patron-dashboard.form.label.maxTitle"/>
	<br>		
		<jstl:forEach items="${maxBudgetByCurrency}" var="entry"> 
		<br>	
		<acme:message code="patron.patron-dashboard.form.label.currency"/>		
		<jstl:set var = "string1" value = "${entry.key}"/>
		<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
		<acme:print value="${string2[0]}"/>
		<acme:message code="patron.patron-dashboard.form.label.status"/>		
		<acme:print value="${string2[1]}"/>
		<acme:message code="patron.patron-dashboard.form.label.maxvalue"/>		
		<acme:print value="${entry.value}"/>
		</jstl:forEach>
		<br>		
		<acme:message code="patron.patron-dashboard.form.label.totalNumberOfProposedPatronages"/>		
		<acme:print value="${totalNumberOfProposedPatronages}"/>
		<br>
		<acme:message code="patron.patron-dashboard.form.label.totalNumberOfAcceptedPatronages"/>		
		<acme:print value="${totalNumberOfAcceptedPatronages}"/>
		<br>
		<acme:message code="patron.patron-dashboard.form.label.totalNumberOfDeniedPatronages"/>		
		<acme:print value="${totalNumberOfDeniedPatronages}"/>
		
</acme:form>

	
	