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
		<jstl:forEach items="${averageRetailPriceOfComponents}" var="entry"> 
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
		<jstl:forEach items="${deviationRetailPriceOfComponents}" var="entry"> 
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
		<acme:message code="patron.patron-dashboard.form.label.averageTitle"/>
		<br>		
		<jstl:forEach items="${minRetailPriceOfComponents}" var="entry"> 
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
		<acme:message code="patron.patron-dashboard.form.label.averageTitle"/>
		<br>		
		<jstl:forEach items="${maxRetailPriceOfComponents}" var="entry"> 
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
		<acme:message code="patron.patron-dashboard.form.label.averageRetailPriceOfTools"/>
		<br>		
		<jstl:forEach items="${averageRetailPriceOfTools}" var="entry"> 
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
		<acme:message code="patron.patron-dashboard.form.label.deviationRetailPriceOfTools"/>
		<br>		
		<jstl:forEach items="${deviationRetailPriceOfTools}" var="entry"> 
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
		<br><acme:message code="patron.patron-dashboard.form.label.maxRetailPriceOfTools"/>
		<br>		
		<jstl:forEach items="${maxRetailPriceOfTools}" var="entry"> 
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
		<br><acme:message code="patron.patron-dashboard.form.label.minRetailPriceOfTools"/>
		<br>		
		<jstl:forEach items="${minRetailPriceOfTools}" var="entry"> 
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
		<acme:message code="patron.patron-dashboard.form.label.minRetailPriceOfTools"/>
		<br>		
		<jstl:forEach items="${averageBudgetByStatus}" var="entry"> 
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
		<acme:message code="patron.patron-dashboard.form.label.minRetailPriceOfTools"/>
		<br>		
		<jstl:forEach items="${deviationBudgetByStatus}" var="entry"> 
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
		<br><acme:message code="patron.patron-dashboard.form.label.minRetailPriceOfTools"/>
		<br>		
		<jstl:forEach items="${minBudgetByStatus}" var="entry"> 
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
		<br><acme:message code="patron.patron-dashboard.form.label.minRetailPriceOfTools"/>
		<br>		
		<jstl:forEach items="${maxBudgetByStatus}" var="entry"> 
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
		<acme:message code="patron.patron-dashboard.form.label.totalNumberOfDeniedPatronages"/>		
		<acme:print value="${totalNumberOfComponents}"/>
		<br>
		<acme:message code="patron.patron-dashboard.form.label.totalNumberOfDeniedPatronages"/>		
		<acme:print value="${totalNumberOfTools}"/>
		<br>
		<acme:message code="patron.patron-dashboard.form.label.totalNumberOfDeniedPatronages"/>		
		<acme:print value="${totalNumberOfProposedPatronages}"/>
		<br>
		<acme:message code="patron.patron-dashboard.form.label.totalNumberOfDeniedPatronages"/>		
		<acme:print value="${totalNumberOfDeniedPatronages}"/>
		<br>
		<acme:message code="patron.patron-dashboard.form.label.totalNumberOfDeniedPatronages"/>		
		<acme:print value="${totalNumberOfAcceptedPatronages}"/>
	
</acme:form>
