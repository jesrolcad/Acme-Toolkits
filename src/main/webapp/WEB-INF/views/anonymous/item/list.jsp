<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="anonymous.item.list.label.tipo" path="tipo" width="20%"/>	
	<acme:list-column code="anonymous.item.list.label.name" path="name" width="20%"/>
	<acme:list-column code="anonymous.item.list.label.code" path="code" width="20%"/>	
	<acme:list-column code="anonymous.item.list.label.technology" path="technology" width="20%"/>
</acme:list>