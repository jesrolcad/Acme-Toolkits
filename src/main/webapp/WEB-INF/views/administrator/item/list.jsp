<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.item.list.label.tipo" path="tipo" width="20%"/>	
	<acme:list-column code="administrator.item.list.label.name" path="name" width="20%"/>
	<acme:list-column code="administrator.item.list.label.code" path="code" width="20%"/>	
	<acme:list-column code="administrator.item.list.label.technology" path="technology" width="20%"/>
	<acme:list-column code="administrator.item.list.label.description" path="description" width="20%"/>	
	<acme:list-column code="administrator.item.list.label.retail-price" path="retailPrice" width="20%"/>
	<acme:list-column code="administrator.item.list.label.optional-link" path="optionalLink" width="80%"/>	
	<acme:list-column code="administrator.item.list.label.inventor" path="item.inventor" width="20%"/>
</acme:list>