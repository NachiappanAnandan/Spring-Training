<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/bank/createUser" method="POST" modelAttribute="user">
	USER ID:<form:input path="id"/><br>
	USER NAME:<form:input path="name"/><br>
	USER AMOUNT:<form:input path="amount"/><br>
	<input type="submit" value="Create User...">
	
</form:form>