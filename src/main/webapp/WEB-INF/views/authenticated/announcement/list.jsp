<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.announcement.list.label.title" path="title"  width="20%"/>
	<acme:list-column code="authenticated.announcement.list.label.moment" path="moment" width="20%"/>	
<%--<acme:list-column code="authenticated.announcement.list.label.body" path="body"  width="20%"/>
	<acme:list-column code="authenticated.announcement.list.label.info" path="info"  width="20%"/>	--%>
	<acme:list-column code="authenticated.announcement.list.label.critical" path="critical"  width="20%"/>
</acme:list>