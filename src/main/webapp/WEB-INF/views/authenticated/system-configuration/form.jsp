<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="authenticated.systemconfiguration.form.label.accepted-currencies" path="acceptedCurrencies"/>	
	<acme:input-textbox code="authenticated.systemconfiguration.form.label.system-currency" path="systemCurrency"/>
	<acme:input-textbox code="authenticated.systemconfiguration.form.label.money-exchange-service-name" path="moneyExchangeServiceName"/>
	<acme:input-textarea code="authenticated.systemconfiguration.form.label.money-exchange-service-description" path="moneyExchangeServiceDescription"/>
	<acme:input-url code="authenticated.systemconfiguration.form.label.money-exchange-service-link" path="moneyExchangeServiceLink"/>
	
</acme:form>