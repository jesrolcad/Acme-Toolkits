<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.item.tool.list.label.tipo" path="tipo" width="20%"/>
	<acme:list-column code="inventor.item.tool.list.label.name" path="name" width="20%"/>
	<acme:list-column code="inventor.item.tool.list.label.code" path="code" width="20%"/>	
	<acme:list-column code="inventor.item.tool.list.label.technology" path="technology" width="20%"/>
	<acme:list-column code="inventor.item.tool.list.label.description" path="description" width="20%"/>
	<acme:list-column code="inventor.item.tool.list.label.retailPrice" path="retailPrice" width="20%"/>
	<acme:list-column code="inventor.item.tool.list.label.optionalLink" path="optionalLink" width="80%"/>	
	<acme:list-column code="inventor.item.tool.list.label.inventor" path="item.inventor" width="20%"/>
</acme:list>