<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/bank" method="GET" modelAttribute="user">
	<h1><%= request.getAttribute("msg")%></h1>
	<input type="submit" value="MENU">
	
</form:form>