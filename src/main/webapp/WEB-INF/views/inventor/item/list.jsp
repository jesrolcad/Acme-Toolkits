<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.item.list.label.name" path="name" width="20%"/>
	<acme:list-column code="inventor.item.list.label.code" path="code" width="20%"/>	
	<acme:list-column code="inventor.item.list.label.technology" path="technology" width="20%"/>
	<acme:list-column code="inventor.item.list.label.retail-price" path="retailPrice" width="20%"/>
</acme:list>