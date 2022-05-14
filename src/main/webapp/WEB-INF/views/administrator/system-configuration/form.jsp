<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>

	<acme:input-textbox code="administrator.systemconfiguration.form.label.accepted-currencies" path="acceptedCurrencies"/>	
	<acme:input-textbox code="administrator.systemconfiguration.form.label.system-currency" path="systemCurrency"/>
	<acme:input-textbox code="administrator.systemconfiguration.form.label.strong-spam-words" path="strongSpamWords"/>
	<acme:input-double code="administrator.systemconfiguration.form.label.strong-spam-threshold" path="strongSpamThreshold"/>
	<acme:input-textbox code="administrator.systemconfiguration.form.label.weak-spam-words" path="weakSpamWords"/>
	<acme:input-double code="administrator.systemconfiguration.form.label.weak-spam-threshold" path="weakSpamThreshold"/>
	<acme:input-textbox code="administrator.systemconfiguration.form.label.money-exchange-service-name" path="moneyExchangeServiceName"/>
	<acme:input-textarea code="administrator.systemconfiguration.form.label.money-exchange-service-description" path="moneyExchangeServiceDescription"/>
	<acme:input-textbox code="administrator.systemconfiguration.form.label.money-exchange-service-link" path="moneyExchangeServiceLink"/>
	
	
	<acme:submit code="administrator.systemconfiguration.form.button.update" action = "/administrator/system-configuration/update"/>
	
</acme:form>