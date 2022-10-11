<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.time.LocalDate" %>
    
<% Integer trackId = (Integer)request.getSession().getAttribute("TrackId"); %>

<% LocalDate DeliveryDt = (LocalDate)request.getSession().getAttribute("DeliveryDt"); %>

<% LocalDate CurDate = (LocalDate)request.getSession().getAttribute("CurDate"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shipment Details</title>
	
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;600;700&display=swap" rel="stylesheet">
	
	<style>
	
		*{
		
               margin: 0;
               padding: 0;
               box-sizing: border-box;
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
			padding: 0% 3%;
			justify-content: space-between;
			align-items: center;
		}
		
		nav img{
			width: 200px;
		}
		
		nav img:hover {
			opacity: 0.5;
			filter: alpha(opacity=30);
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
		
		
		.form a{
		
			color: white;
			text-decoration: none;
			font-size: 16	px;
		}

		.main{
			 position: absolute;
             top: 50%;
             left: 50%;
             transform: translate(-50%,-50%);
             width: 600px;
             height: 350px;
             /* display: inline-flex; */
             border-radius: 15px;
             background-color:white
		
		}
		
		.main h1{
		
			margin-top:30px;	
			margin-left:30px;
		}
		
		.main h2{
			margin-left:60px;
		}
		
	/* 	.main .left{
               width: 250px;
               height: 550px;
               background: url(background.jpg);
               box-sizing: border-box;
               border-radius: 15px 0 0 15px;
		
		}
		
		.main .left h1{
               margin: 45px;
               color: white;
			   text-shadow: 0px 2px 5px black;
		
		}
		
		span{
		
		        color: white;
		
		}
		
		.main .right{
                width: 350px;
                height: 550px;
                background: white;
                border-radius: 0 15px 15px 0;
		}
		
		.main .right .form{
                margin: 30px;
		}
		
		.main .right .form input{
                margin: 10px;
                width: 200px;
                height: 25px;
                padding: 2px;
                outline: none;
		
		}
		
		.main .right .form button{
                width: 200px;
                height: 30px;
                margin: 10px;
                background: black;
                color: white;
                font-size: 18px;
                cursor: pointer;
                border: none;

		}
		
		.main .right .form p{
		        margin: 20px;
		}
		
		.main .right .form a{
                color: grey;
                text-decoration: none;
		
		}
		
		.main .right .form select {
				margin: 10px;
                width: 200px;
                height: 30px;
                padding: 2px;
                 outline: none;
		} */
	
	</style>
</head>
<body>
	<section class="header">
	
	    <nav>
				<a href="CourierBookingDetails.jsp"><img src="ALEX COURIER SERVICE-logos_transparent.png" alt="bank logo"></a>
					
		</nav>
	
		
	    <div class="main">
	
	          <h1> Sit Back And Relax. <br>Your Order Will Be Delivered Securely. </h1><br><br>
	          
	          <h2> Your Tracking Id : ACS<%= trackId %></h2><br>
	          
	          <h2> Date of Shipment : <%= CurDate %></h2><br>
	          
	          <h2> Delivered by : <%= DeliveryDt %></h2><br>
	          
	          
	    </div>
	    
	</section>
</body>
</html>