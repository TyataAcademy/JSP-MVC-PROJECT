<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
         	 <tr>
                  <td>${coffee.getCofName()}</td>
                  <td>${coffee.getSupId().toString()}</td>
                  <td>${coffee.getPrice().toString()}</td>
                  <td>${coffee.getSales().toString()}</td>
                  <td>${coffee.getTotal().toString()}</td>
               </tr>
         </tbody>
	</table>
</body>
</html>