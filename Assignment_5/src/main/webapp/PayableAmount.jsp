<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Double amount = (Double)request.getSession().getAttribute("amount"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Payable Amount</title>
	
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
             height: 270px;
             display: inline-flex;
             border-radius: 15px;
             box-shadow: 0 10px 20px -10px rgba(0,0,0,0.8);
		
		}
		
		.main .left{
               width: 350px;
               height: 270px;
               background: url(background.jpg);
               box-sizing: border-box;
               border-radius: 20px 0 0 15px;
		
		}
		
		.main .left h1{
               margin: 45px;
               color: white;
			   text-shadow: 0px 2px 5px black;
		
		}
		
		.main .left h2{
			 margin: 10px;
             color: white;
             text-shadow: 0px 2px 5px black;
		}
		
		.main .left h3{
		
			margin-left:50px;
            color: white;
            text-shadow: 0px 2px 5px black;
		}
		
		span{
		
		        color: white;
		
		}
		
		.main .right{
                width: 350px;
                height: 270px;
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
		}
	
	</style>
	
</head>
<body>
	
 <form action="ShipmentDetails" method="post"> 

	<section class="header">
	
	    <nav>
				<a href="CourierBookingDetails.jsp"><img src="ALEX COURIER SERVICE-logos_transparent.png" alt="bank logo"></a>
					
		</nav>
	
		
	    <div class="main">
	
	          <div class="left">
	
	                  <!--  <h1>Apex<br><span>Courier Service</span></h1> -->
	                  
	                  <h2>Delivery Courier Charges per kg in 2022</h2><br>
	                  <h3>North India - INR 200<br>
						  South India -INR 150<br>
						  East India - INR 250<br>
						  West India - INR 115</h3>
					  
		         </div>
	
	          <div class="right">
	
	                    <div class="form">
	
                            <h1></h1><br>

                            <h2>Payable<br>Amount</h2><br>
                            
                           		<h3>Rs. <%= amount %></h3>	<br>
                            
	                        <button>Next</button>
	                        
	                    </div>
	
	          </div>
	
	    </div>
	    
	</section>
 </form> 
</body>
</html>