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
		<caption></caption>
		
		
	<jstl:if test="${empty averageBudgetByCurrency}">
	<acme:message code="patron.patron-dashboard.form.label.nohayPatrocinios"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${averageBudgetByCurrency}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.average-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
			<acme:print value="${string2[0]}"/>
			<acme:message code="patron.patron-dashboard.form.label.and-status"/>
			<acme:print value="${string2[1]}"/>
			<acme:message code="patron.patron-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="patron.patron-dashboard.form.label.deviationTitle"/>		
	<table class="table table-sm">
		<caption></caption>
		
	<jstl:if test="${empty deviationBudgetByCurrency}">
	<acme:message code="patron.patron-dashboard.form.label.nohayPatrocinios"/>	
	<br>
	<br>
	</jstl:if>
		<jstl:forEach items="${deviationBudgetByCurrency}" var="entry"> 
		<tr>	
			<th id="">
				<acme:message code="patron.patron-dashboard.form.label.deviation-sentence"/>		
				<jstl:set var = "string1" value = "${entry.key}"/>
				<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
				<acme:print value="${string2[0]}"/>
				<acme:message code="patron.patron-dashboard.form.label.and-status"/>		
				<acme:print value="${string2[1]}"/>
				<acme:message code="patron.patron-dashboard.form.label.colon"/>		
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	
	<acme:message code="patron.patron-dashboard.form.label.minTitle"/>
	<table class="table table-sm">	
		<caption></caption>
	<jstl:if test="${empty minBudgetByCurrency}">
	<acme:message code="patron.patron-dashboard.form.label.nohayPatrocinios"/>	
	<br>
	<br>
	</jstl:if>
		<jstl:forEach items="${minBudgetByCurrency}" var="entry"> 
			<tr>	
				<th id="">
					<acme:message code="patron.patron-dashboard.form.label.min-sentence"/>		
					<jstl:set var = "string1" value = "${entry.key}"/>
					<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
					<acme:print value="${string2[0]}"/>
					<acme:message code="patron.patron-dashboard.form.label.and-status"/>		
					<acme:print value="${string2[1]}"/>
					<acme:message code="patron.patron-dashboard.form.label.colon"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${entry.value}"/>
				</td>		
			</tr>
		</jstl:forEach>
	</table>		
	<acme:message code="patron.patron-dashboard.form.label.maxTitle"/>		
	<table class="table table-sm">	
		<caption></caption>
	<jstl:if test="${empty maxBudgetByCurrency}">
	<acme:message code="patron.patron-dashboard.form.label.nohayPatrocinios"/>	
	<br>
	<br>
	</jstl:if>
		<jstl:forEach items="${maxBudgetByCurrency}" var="entry"> 
			<tr>	
				<th id="">
					<acme:message code="patron.patron-dashboard.form.label.max-sentence"/>		
					<jstl:set var = "string1" value = "${entry.key}"/>
					<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
					<acme:print value="${string2[0]}"/>
					<acme:message code="patron.patron-dashboard.form.label.and-status"/>		
					<acme:print value="${string2[1]}"/>
					<acme:message code="patron.patron-dashboard.form.label.colon"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${entry.value}"/>
				</td>		
			</tr>
		</jstl:forEach>
	</table>
	<acme:message code="patron.patron-dashboard.form.label.absoluteTitle"/>		
	<table class="table table-sm">
		<caption></caption>
			<tr>	
				<th id="">
					<acme:message code="patron.patron-dashboard.form.label.totalNumberOfProposedPatronages"/>		
		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfProposedPatronages}"/>
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="patron.patron-dashboard.form.label.totalNumberOfAcceptedPatronages"/>
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfAcceptedPatronages}"/>
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="patron.patron-dashboard.form.label.totalNumberOfDeniedPatronages"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfDeniedPatronages}"/> 
				</td>		
			</tr>
	</table>
		
		

	
	