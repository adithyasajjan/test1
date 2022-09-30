<%@ page import="java.util.*" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="PayBill.PayBillUser" %> 


<% ArrayList<PayBillUser> billDetails = (ArrayList<PayBillUser>) request.getAttribute("BillDetails"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>PayBill</title>
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
			position:absolute;
		 	top: 35%;
            left: 50%;
            transform: translate(-50%,-50%);
            width: 500px;
            height: 350px;
            display: inline-flex;
            border-radius: 15px;
            font-size: 18px;
		}
		
		table {
			padding:10px;
			border-collapse:seperate;
			border-spacing:0 1em;
			border-style:solid;
		}
		
		.set-button button {
		
			width: 100px;
            height: 30px;
            margin: 10px;
            background: black;
            color: white;
            font-size: 18px;
            cursor: pointer;
            border: none;
            margin-top:570px;
            margin-left:750px;
		}
		
		
	</style>
	
</head>
<body>
<form action="Receipt" method="get">

	<section class="header">
		<nav>
			<a href="PayBill.jsp"><img src="" alt="bank logo"></a>
				
		</nav>
		
		<h1 style="color:white;font-size:30px; margin-left:50px;">Electricity Bill</h1><br><br>
		
		<div class="container">
			
		
			<table style=width:80%>
			
					<% for(int recCount=0; recCount<billDetails.size(); recCount++) { %>
					
						<% PayBillUser pb = (PayBillUser)billDetails.get(recCount); %>
						
						<tr style="color:white;"><td>Name : </td><td style="text-align:center;"><%= pb.getName() %></td></tr>
						<!--  <tr><td></td></tr>	
						<tr><td></td></tr>  -->
						<tr style="color:white;"><td>Consumer Number : </td><td style="text-align:center;"><%= pb.getConsNum() %></td></tr>
						<tr><td></td></tr>	
						<tr><td></td></tr>
						 
						<TH COLSPAN=3><hr>
						
						<tr><td></td></tr>	
						<tr><td></td></tr> 
						
						<tr style="color:white;"><td>Electricity Biller : </td><td style="text-align:center;"><%= pb.getElecProvider() %></td></tr>
						<!-- <tr><td></td></tr>	
						<tr><td></td></tr> -->
						<tr style="color:white;"><td>Consumption : </td><td style="text-align:center;"><%= pb.getConsump()  %> units</td></tr>
						<!-- <tr><td></td></tr>	
						<tr><td></td></tr> -->
						<tr style="color:white;"><td>Bill Date : </td><td style="text-align:center;"><%= pb.getBd() %></td></tr>
						<!-- <tr><td></td></tr>	
						<tr><td></td></tr> -->
						<tr style="color:white;"><td>Bill Due Date : </td><td style="text-align:center;"><%= pb.getBdd() %></td></tr>
						<tr><td></td></tr>	
						<tr><td></td></tr> 
						
						<tr style="color:white;"><td>Payment Status : </td><td style="text-align:center;"><%= pb.getStatus() %></td></tr>
						
						<TH COLSPAN=3><hr>
						
						<tr><td></td></tr>	
						<tr><td></td></tr> 		
						<%-- <tr style="color:white;"><td>Payment Date : </td><td style="text-align:center;"><%= pb.getPd() %></td></tr>
						<tr><td></td></tr>	
						<tr><td></td></tr> --%>
						<tr style="color:white;"><td>Bill Amount : </td><td style="text-align:center;">Rs. <%= pb.getAmount() %></td></tr>
						<!-- <tr><td></td></tr>	
						<tr><td></td></tr>
						 -->
					
					<% } %>
			</table>
			
		</div>
		
		<div class="set-button">
				<button type="submit">Pay</button>
		</div>
		
	</section>
</form>
</body>
</html>