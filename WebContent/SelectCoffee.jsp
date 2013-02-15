<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.ksquareit.jsp.DBUtil"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Coffee Form</title>
<script type="text/javascript">
	function changeCName(){
		var cName = document.getElementById("cofname").value;
	}
</script>
</head>
<body>
	<h1>Coffee Select form</h1>
	<% Connection conn = DBUtil.getConnection(); %>
	<% if(conn!=null){ %>
	<br /><h4>Select Coffee Here:</h4>
	<% }else{%>
	<br />you are not connected
	<% } %>
	<% ArrayList<String> aList = DBUtil.getCoffeeName(conn);
	Iterator<String> it = aList.iterator();
	%>
	<form name="myForm" action="UserSelection" method="POST">
		
		<select name="cofname" id="cofname" onchange="javascript:changeCName();">
			<option value="None">None</option>
			<option value="All">All</option>
		
			<%
				while (it.hasNext()) {
					String name1 = it.next();
			%>
			<option value="<%=name1%>"><%=name1%></option>
			<%
				}
			%>
		</select>	
		<input type="submit" value="submit" name="submit">
	</form>
</body>
</html>