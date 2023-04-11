<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/bank/createUser" method="GET">
	<input type="submit" value="Create User">	
</form:form>
<form:form action="/bank/checkBalance" method="GET">
	<input type="submit" value="Check Balance">	
</form:form>
<form:form action="/bank/doTransfer" method="GET">
	<input type="submit" value="Do Transfer">	
</form:form>