<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.quantity.item.list.label.tipo" path="item.tipo" width="20%"/>
	<acme:list-column code="inventor.quantity.item.list.label.name" path="item.name" width="20%"/>
	<acme:list-column code="inventor.quantity.item.list.label.code" path="item.code" width="20%"/>	
	<acme:list-column code="inventor.quantity.item.list.label.technology" path="item.technology" width="20%"/>
	<acme:list-column code="inventor.quantity.item.list.label.retail-price" path="item.retailPrice" width="20%"/>
	<acme:list-column code="inventor.quantity.item.list.label.number" path="number" width="20%"/>
	

	
</acme:list>
<acme:button test="${showCreate}" code="inventor.quantity.form.button.add" action="/inventor/quantity/create?masterId=${masterId}"/>
