<%@ page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Functions</title>
	
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
		
	</style>
	
</head>
<body>
	<section class="header">
		<nav>
			<a href="Functions.html"><img src="" alt="bank logo"></a>
				<div class="nav-links">
					<ul>
						<li><a href="Deposit.jsp">DEPOSIT AMOUNT</a></li>
						<li><a href="Withdraw.jsp">WITHDRAW AMOUNT</a></li>
						<li><a href="Transfer.jsp">TRANSFER AMOUNT</a></li>
						<li><a href="PayBill.jsp">PAY BILLS</a>
						<li><a href="Transaction.html">TRANSACTION DETAILS</a></li>
						<li><a href="Balance.jsp">SHOW BALANCE</a></li>
						<li><a href="AccountDetails">ACCOUNT DETAILS</a></li>
						<li><a href="Logout">LOG OUT</a></li>
						
					</ul>
				</div>
				
		</nav>
	</section>
	
	<script type = "text/javascript" >
	
	    function preventBack() { window.history.forward(); }
	    setTimeout("preventBack()", 0);
	    window.onunload = function () { null };
	    
	</script>
	
</body>
</html>