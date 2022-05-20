
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.toolkit.list.label.code" path="code" width="20%"/>
	<acme:list-column code="any.toolkit.list.label.title" path="title" width="20%"/>
	<acme:list-column code="any.toolkit.list.label.description" path="description" width="20%"/>
	<acme:list-column code="any.toolkit.list.label.assembly-notes" path="assemblyNotes" width="20%"/>	
	<acme:list-payload path="payload"/>
</acme:list>