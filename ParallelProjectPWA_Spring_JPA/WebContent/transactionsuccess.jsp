<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="2">
<tr>
<th>Mobile Number</th>
<th>Credit or Debit</th>
<th>TransAmount</th>
<th>Balance</th>
<th>TransTime</th>
</tr>
<a:forEach var="transdata" items="${trans}">
<tr>
<td>${transdata.custMobile}</td>
<td>${transdata.creditdebit}</td>
<td>${transdata.transactionamount}</td>
<td>${transdata.balance}</td>
<td>${transdata.date}</td>
</a:forEach>
<tr>
<td colspan="5" align="center">
<a href="index.jsp">Home</a>
</td>
</tr>
</table>

</body>
</html>