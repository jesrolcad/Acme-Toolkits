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

	<acme:message code="patron.patron-dashboard.form.label.avg-title"/>	
	<table class="table table-sm">	
		<jstl:forEach items="${averageBudgetByCurrency}" var="entry"> 	
		<tr>	
			<th>	
			<acme:message code="patron.patron-dashboard.form.label.average-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
			<acme:print value="${string2[0]}"/>
			<acme:message code="patron.patron-dashboard.form.label.and-status"/>
			<acme:print value="${string2[1]}"/>
			<acme:message code="patron.patron-dashboard.form.label.colon"/>
			</th>
			<td align="right">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="patron.patron-dashboard.form.label.deviationTitle"/>		
	<table class="table table-sm">
		<jstl:forEach items="${deviationBudgetByCurrency}" var="entry"> 
		<tr>	
			<th>
				<acme:message code="patron.patron-dashboard.form.label.deviation-sentence"/>		
				<jstl:set var = "string1" value = "${entry.key}"/>
				<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
				<acme:print value="${string2[0]}"/>
				<acme:message code="patron.patron-dashboard.form.label.and-status"/>		
				<acme:print value="${string2[1]}"/>
				<acme:message code="patron.patron-dashboard.form.label.colon"/>		
			</th>
			<td align="right">
				<acme:print value="${entry.value}"/>
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	
	<acme:message code="patron.patron-dashboard.form.label.minTitle"/>
	<table class="table table-sm">	
		<jstl:forEach items="${minBudgetByCurrency}" var="entry"> 
			<tr>	
				<th>
					<acme:message code="patron.patron-dashboard.form.label.min-sentence"/>		
					<jstl:set var = "string1" value = "${entry.key}"/>
					<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
					<acme:print value="${string2[0]}"/>
					<acme:message code="patron.patron-dashboard.form.label.and-status"/>		
					<acme:print value="${string2[1]}"/>
					<acme:message code="patron.patron-dashboard.form.label.colon"/>		
				</th>
				<td align="right">
					<acme:print value="${entry.value}"/>
				</td>		
			</tr>
		</jstl:forEach>
	</table>		
	<acme:message code="patron.patron-dashboard.form.label.maxTitle"/>		
	<table class="table table-sm">	
		<jstl:forEach items="${maxBudgetByCurrency}" var="entry"> 
			<tr>	
				<th>
					<acme:message code="patron.patron-dashboard.form.label.max-sentence"/>		
					<jstl:set var = "string1" value = "${entry.key}"/>
					<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
					<acme:print value="${string2[0]}"/>
					<acme:message code="patron.patron-dashboard.form.label.and-status"/>		
					<acme:print value="${string2[1]}"/>
					<acme:message code="patron.patron-dashboard.form.label.colon"/>		
				</th>
				<td align="right">
					<acme:print value="${entry.value}"/>
				</td>		
			</tr>
		</jstl:forEach>
	</table>
	<acme:message code="patron.patron-dashboard.form.label.absoluteTitle"/>		
	<table class="table table-sm">
			<tr>	
				<th>
					<acme:message code="patron.patron-dashboard.form.label.totalNumberOfProposedPatronages"/>		
		
				</th>
				<td align="right">
					<acme:print value="${totalNumberOfProposedPatronages}"/>
				</td>		
			</tr>
			<tr>	
				<th>
					<acme:message code="patron.patron-dashboard.form.label.totalNumberOfAcceptedPatronages"/>
				</th>
				<td align="right">
					<acme:print value="${totalNumberOfAcceptedPatronages}"/>
				</td>		
			</tr>
			<tr>	
				<th>
					<acme:message code="patron.patron-dashboard.form.label.totalNumberOfDeniedPatronages"/>		
				</th>
				<td align="right">
					<acme:print value="${totalNumberOfDeniedPatronages}"/> 
				</td>		
			</tr>
	</table>
		
		

	
	