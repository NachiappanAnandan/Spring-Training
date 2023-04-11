<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/bank/checkBalance" method="POST" modelAttribute="user">
	StudentID:<form:input path="id"/><br>
	<input type="submit" value="Check  User...">
	
</form:form>