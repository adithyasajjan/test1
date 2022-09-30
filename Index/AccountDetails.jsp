<%@ page import="java.util.*" %>
<%@ page import="AccountDetails.AccountUser" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% ArrayList<AccountUser> AccDetails = (ArrayList<AccountUser>)request.getAttribute("AccountDetails"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Account Details</title>
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;600;700&display=swap" rel="stylesheet">
	
	<style> 
		*{
			margin: 0;
			padding: 0;
			font-family: 'Poppins', sans-serif;
			
		}
		
		.header{
			min-height: 100vh;
			width: 100%;
			background-image: linear-gradient(rgba(4, 9, 30, 0.7), rgba(4, 9, 30, 0.7)), url('banner.jpg');
			background-position: center;
			background-size: cover;
			position: relative;
		}
		
		nav{
			display: flex;
			padding: 2% 6%;
			justify-content: space-between;
			align-items: center;
		}
		
		nav img{
			width: 150px;
		}
		
		.nav-links{
			flex: 1;
			text-align: right;
		}
		
		.nav-links ul li{
			list-style: none;
			display: inline-block;
			padding: 8px 12px;
			position: relative;
		}
		
		.nav-links ul li a{
			color: white; 
			text-decoration: none;
			font-size: 16	px;
		}
		
		.nav-links ul li::after{
			content: '';
			width: 0%;
			height: 2px;
			background: #f44336;
			display: block;
			margin: auto;
			transition: 0.5s;
		}
		
		.nav-links ul li:hover::after{
			width: 100%;	
		}
		
		.container {
			float:center;
			position:relative;
			margin-left:200px;
		}
		
		
	</style>
	
</head>
<body>

	<section class="header">
		<nav>
			<a href="Functions.jsp"><img src="" alt="bank logo"></a>
				
		</nav>
		
		<div class="container">
			<h1 style="color:white;font-size=30px">ACCOUNT DETAILS</h1><br><br>
		
			<table style=width:80% border="1">
				<tr style="background-color: blueviolet; color: white; font-weight: bold; text-align:center">
						<td>ACCOUNT NUMBER</td>
						<td>NAME</td>
						<td>CURRENCY</td>
						<td>BALANCE</td>
					</tr>
			
					<% for(int recCount=0; recCount<AccDetails.size(); recCount++) { %>
						<tr style="color:white">
					
						<% AccountUser au = (AccountUser)AccDetails.get(recCount); %>
						<td style="text-align:center;"><%= au.getAccNo() %></td>
						<td style="text-align:center;"><%= au.getUsername() %></td>
						<td style="text-align:center;"><%= "INR" %></td>
						<td style="text-align:center;"><%= au.getBalance() %></td>
						<tr>
					<% } %>
			</table>
		</div>
		
	</section>
</body>
</html>