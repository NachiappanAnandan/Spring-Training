<p>
ID <%= request.getAttribute("id")%>
</p>
<p>
 NAME   <%= request.getAttribute("name")%>
</p>
<p>
 AMOUNT   <%= request.getAttribute("amount")%>
</p>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/bank" method="GET" >
	<input type="submit" value="Menu">	
</form:form>