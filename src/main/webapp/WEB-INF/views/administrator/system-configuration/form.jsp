<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="administrator.systemconfiguration.form.label.accepted-currencies" path="acceptedCurrencies"/>	
	<acme:input-textbox code="administrator.systemconfiguration.form.label.system-currency" path="systemCurrency"/>
	<acme:input-textbox code="administrator.systemconfiguration.form.label.strong-spam-words" path="strongSpamWords"/>
	<acme:input-textbox code="administrator.systemconfiguration.form.label.strong-spam-threshold" path="strongSpamThreshold"/>
	<acme:input-textbox code="administrator.systemconfiguration.form.label.weak-spam-words" path="weakSpamWords"/>
	<acme:input-textbox code="administrator.systemconfiguration.form.label.weak-spam-threshold" path="weakSpamThreshold"/>
</acme:form>