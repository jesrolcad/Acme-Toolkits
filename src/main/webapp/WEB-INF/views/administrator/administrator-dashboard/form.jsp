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
	<acme:message code="patron.patron-dashboard.form.label.componentsTitle"/>
	<jstl:if test="${empty averageRetailPriceOfComponents}">
	<br>
	<acme:message code="patron.patron-dashboard.form.label.nohayComponentes"/>
		<br>
		<br>
	
	</jstl:if>	
	<br>	
	
	<acme:message code="patron.patron-dashboard.form.label.avg-title"/>	
	<table class="table table-sm">
		<caption></caption>
		<caption></caption>
		<jstl:forEach items="${averageRetailPriceOfComponents}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.average-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
			<acme:print value="${string2[0]}"/>
			<acme:message code="patron.patron-dashboard.form.label.and-technology"/>
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
	<caption></caption>
		<jstl:forEach items="${deviationRetailPriceOfComponents}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.deviation-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
			<acme:print value="${string2[0]}"/>
			<acme:message code="patron.patron-dashboard.form.label.and-technology"/>
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
		<jstl:forEach items="${minRetailPriceOfComponents}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.min-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
			<acme:print value="${string2[0]}"/>
			<acme:message code="patron.patron-dashboard.form.label.and-technology"/>
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
		<jstl:forEach items="${maxRetailPriceOfComponents}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.max-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />
			<acme:print value="${string2[0]}"/>
			<acme:message code="patron.patron-dashboard.form.label.and-technology"/>
			<acme:print value="${string2[1]}"/>
			<acme:message code="patron.patron-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
		<acme:message code="patron.patron-dashboard.form.label.toolsTitle"/>
	<jstl:if test="${empty averageRetailPriceOfTools}">
	<br>
	
	<acme:message code="patron.patron-dashboard.form.label.nohayHerramientas"/>
	
		<br>
		<br>
	
	</jstl:if>		
		<br>	
	
	<acme:message code="patron.patron-dashboard.form.label.avg-title"/>	
	<table class="table table-sm">	
		<caption></caption>
		<jstl:forEach items="${averageRetailPriceOfTools}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.average-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
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
		<jstl:forEach items="${deviationRetailPriceOfTools}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.deviation-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
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
		<caption></caption>
		<jstl:forEach items="${minRetailPriceOfTools}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.min-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
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
		<jstl:forEach items="${maxRetailPriceOfTools}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.max-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
			<acme:message code="patron.patron-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
		<acme:message code="patron.patron-dashboard.form.label.patronageTitle"/>
	<jstl:if test="${empty averageBudgetByStatus}">
	<br>
	<acme:message code="patron.patron-dashboard.form.label.nohayPatrocinios"/>
		<br>
		<br>
	
	</jstl:if>		
		<br>
	<acme:message code="patron.patron-dashboard.form.label.avg-title"/>	
	<table class="table table-sm">	
		<caption></caption>
		<jstl:forEach items="${averageBudgetByStatus}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.patronage-average-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
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
		<jstl:forEach items="${deviationBudgetByStatus}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.patronage-deviation-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
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
	<caption></caption>
		<jstl:forEach items="${minBudgetByStatus}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.patronage-min-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
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
		<jstl:forEach items="${maxBudgetByStatus}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="patron.patron-dashboard.form.label.patronage-max-sentence"/>		
			<jstl:set var = "string1" value = "${entry.key}"/>
			<jstl:set var = "string2" value = "${fn:split(string1, '->')}" />

			<acme:print value="${string2[0]}"/>
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
			<tr>	
				<th id="">
					<acme:message code="patron.patron-dashboard.form.label.totalNumberOfComponents"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfComponents}"/> 
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="patron.patron-dashboard.form.label.totalNumberOfTools"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfTools}"/> 
				</td>		
			</tr>
	</table>
		
</acme:form>
