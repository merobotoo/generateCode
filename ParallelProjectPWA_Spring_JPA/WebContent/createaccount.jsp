<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="for" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<for:form method="post" action="insertdata" modelAttribute="my">
<table>
<!-- <tr> -->
<%-- <td>Employee Id</td>
<td><for:input path="empId"/></td>
</tr> --%>

<tr>
<td>Customer Name</td>
<td><for:input path="custName"/></td>
<td><for:errors path="custName"></for:errors></td>
</tr>

<tr>
<td>Customer Mobile no</td>
<td><for:input path="custMobile"/></td>
<td><for:errors path="custMobile"></for:errors>
</tr>

<tr>
<td>Customer Age</td>
<td><for:input path="custAge"/></td>
<td><for:errors path="custAge"></for:errors>
</tr>

<tr>
<td>Customer initial balance</td>
<td><for:input path="custInitialBalance"/></td>
<td><for:errors path="custInitialBalance"></for:errors>
</tr>
<tr>
<td><input type="submit" value="Create Account"></input></td>
</tr>
</table>

</for:form>
</body>
</html>