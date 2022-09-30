<%@ page import="java.util.*" %>
<%@ page import="Transaction.TransactionUser" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% ArrayList<TransactionUser> TransDetails = (ArrayList<TransactionUser>)request.getAttribute("TransDetails"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Transaction Details</title>
	
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
		
		.container {
			float:center;
			position:relative;
			margin-left:200px;
		}
		
		.selected {
			 background-color: blue; 
			 font-weight:bold;
			 color:#fff;
		}
		
		tr{
			cursor:pointer;
			transition:all .25s erase-in-out;
		}

		
	</style>

</head>
<body>
	<section class="header">
		<nav>
		
			<a href="Functions.jsp"><img src="" alt="bank logo"></a>
				
		</nav>
		
		<div class="container">
			<h1 style="color:white;font-size=30px">BANK STATEMENT</h1><br><br>
				<table id="table" style=width:80% border="1">
					<tr style="background-color: blueviolet; color: white; font-weight: bold; text-align:center">
						<td>DATE</td>
						<td>PAID TO</td>
						<td>AMOUNT</td>
						<td>DESCRIPTION</td>
						<td>Dr/Cr</td>
						<td>BALANCE</td>
					</tr>
			
					<% for(int recCount=0; recCount<TransDetails.size(); recCount++) { %>
						<tr style="color:white">
							<% TransactionUser tran = TransDetails.get(recCount); %>
							<td style="text-align:center;"><%= tran.getDt() %></td>
							<td style="text-align:center;"><%= tran.getToName() %></td>
							<td style="text-align:center;"><%= tran.getAmount() %></td>
							<td style="text-align:center;"><%= tran.getDescrip() %></td>
							<td style="text-align:center;"><%= tran.getDrORCr() %></td>
							<td style="text-align:center;"><%= tran.getBalance() %></td>
						<tr>
						
					<% } %>
					
				</table>
		</div>
	</section>
	
	<script>
		function selectedRow(){
			
			var index, table;
			table = document.getElementById("table");
			for(var i=0; i<table.rows.length; i++)
			{
				table.rows[i].onclick = function()
				{
					if(typeof index !== "undefined"){
						table.rows[index].classList.toggle("selected");
					}
					index = this.rowIndex;
					this.classList.toggle("selected");
					console.log(index);
				};
			}
		}
		
		selectedRow();
	</script>
</body>
</html>