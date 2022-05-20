<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>

	<acme:input-textbox code="patron.patronage.form.label.code" path="code"/>
	<acme:input-moment code="patron.patronage.form.label.startDate" path="startDate"/>
	<acme:input-moment code="patron.patronage.form.label.endDate" path="endDate" />
	<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
	<jstl:if test="${command != 'create'}">
	<acme:input-money code="patron.patronage.form.label.conversion" path="conversion" readonly="true"/>
	<acme:input-textbox code="patron.patronage.form.label.status" path="status" readonly="true"/>
	</jstl:if>
	<acme:input-url code="patron.patronage.form.label.link" path="link"/>
	
	<jstl:if test="${published==true}">	
	<acme:input-textbox code="patron.patronage.form.label.published" path="published"/>
	<acme:input-textbox code="patron.patronage.form.label.username" path="inventor.userAccount.username"/>
	<acme:input-textbox code="patron.patronage.form.label.company" path="inventor.company"/>
	<acme:input-url code="patron.patronage.form.label.inventor-link" path="inventor.link"/>
	<acme:input-textbox code="patron.patronage.form.label.statement" path="inventor.statement"/>
	</jstl:if>	

		<jstl:if test="${command == 'create' or command == 'update' and published==false}">	
	        <acme:input-select code="patron.patronage.form.label.inventor" path="inventorId">
	   			<jstl:forEach items="${inventors}" var="inventor">
					<acme:input-option code="${inventor.getUserAccount().getUsername()}" value="${inventor.getId()}" selected="${ inventor.getId() == inventId }"/>
				</jstl:forEach>
			</acme:input-select>
		</jstl:if>	
		
	<jstl:if test="${command == 'show' and published==false}">
	 <acme:input-select code="patron.patronage.form.label.inventor" path="inventorId">
	   			<jstl:forEach items="${inventors}" var="inventor">
					<acme:input-option code="${inventor.getUserAccount().getUsername()}" value="${inventor.getId()}" selected="${ inventor.getId() == inventId }"/>
				</jstl:forEach>
			</acme:input-select>
			
	
	</jstl:if>
	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command,'show, update, delete, publish') && published == false}">
			
			<acme:submit code="patron.patronage.form.button.update" action="/patron/patronage/update"/> 
			<acme:submit code="patron.patronage.form.button.delete" action="/patron/patronage/delete"/>
			<acme:submit code="patron.publish-patronage" action="/patron/patronage/publish"/>
			                                                                                             
		</jstl:when>
		
		<jstl:when test="${command=='create'}">
			<acme:submit code="patron.patronage.form.button.create" action="/patron/patronage/create"/>
		</jstl:when>
		
	</jstl:choose>	
	
</acme:form>


