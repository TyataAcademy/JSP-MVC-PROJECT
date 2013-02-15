<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- page settings --%>
	<%@ page import = "java.util.*" %>
	<%@ page import = "com.ksquareit.jsp.*" %>

	<%-- GuestDataBean to obtain guest list --%>
	<jsp:useBean id = "coffeeList" scope = "request" 
	   class = "com.ksquareit.jsp.DBUtil" />

	<table style='border:1px solid black'>
         <thead style='border:1px solid black'>
            <tr style='background-color:#00FFFF'>
               <th style = "width: 100px;">Coffee Name</th>
               <th style = "width: 100px;">SUP ID</th>
               <th style = "width: 60px;">Price</th>
               <th style = "width: 60px;">Sales</th>
               <th style = "width: 60px;">Total</th>
            </tr>
         </thead>
         <tbody style='border:1px solid black'>
         <% // start scriptlet
			Connection conObj = DBUtil.getConnection();
			
            ArrayList<Coffee> cl = DBUtil.testAll(conObj);
            Iterator<Coffee> itrObj = cl.iterator();
			Coffee c;
            while ( itrObj.hasNext() ) {
               c = ( Coffee ) itrObj.next();
         %> 
               <tr style='border:1px solid black'>
                  <td><%= c.getCofName() %></td>
                  <td><%= c.getSupId() %></td>
                  <td><%= c.getPrice() %></td>
                  <td><%= c.getSales() %></td>
                  <td><%= c.getTotal() %></td>
               </tr>
         <% // continue scriptlet
            } // end while
         %> <%-- end scriptlet --%>
         </tbody>
    </table>
</body>
</html>