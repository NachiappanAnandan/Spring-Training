<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/bank/doTransfer" method="POST" modelAttribute="transaction" >
	USER 1:<form:input path="id1"/><br>
	USER 2:<form:input path="id2"/><br>
	AMOUNT:<form:input path="amount"/><br>
	<input type="submit" value ="Perform">
	
</form:form>