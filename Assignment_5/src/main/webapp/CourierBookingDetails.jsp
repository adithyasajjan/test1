<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Courier Booking Details</title>
	
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
             height: 550px;
             display: inline-flex;
             border-radius: 15px;
             box-shadow: 0 10px 20px -10px rgba(0,0,0,0.8);
		
		}
		
		.main .left{
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
		}
	
	</style>
	
</head>
<body>
	
	<form action="CusDetails" method="post">

	<section class="header">
	
	    <nav>
				<a href="CourierBookingDetails.jsp"><img src="ALEX COURIER SERVICE-logos_transparent.png" alt="bank logo"></a>
					
		</nav>
	
		
	    <div class="main">
	
	          <div class="left">
	
	                   <h1>Apex<br><span>Courier Service</span></h1>
	
	          </div>
	
	          <div class="right">
	
	                    <div class="form">
	
                            <h1></h1><br>

                            <h3>Enter<br>Booking Details</h3><br>
                            
                            <input type="text" name="fname" placeholder="Enter Name" required><br>

                            <input type="text" name="city" placeholder="Enter City" required><br>
                            
                            <input type="text" name="phNum" placeholder="Enter Mobile Number" required><br>
                           	                            
                            <input type="text" name="destination" placeholder="Enter Destination" required><br>
                            
                        	                            
	                        <input type="number" name="weight" placeholder="Package Weight (gms)" step="0.1" min="1" required><br>
								
							<h4>Select Region</h4>
                          	<select name="region" placeholder="Select region" required>
                            	
                            		<option value="North India">North India INR 200/kg</option>
                            		<option value="South India">South India INR 150/kg</option>
                            		<option value="East India">East India INR 250/kg</option>
                            		<option value="West India">West India INR 115/kg</option>
                            		
                            </select>
                            
	                        <button>Next</button>
	                        
	                        <% boolean flag = Boolean.parseBoolean(request.getParameter("flag")); %>
	                        
	                        <% boolean flag1 = Boolean.parseBoolean(request.getParameter("flag1")); %>
	                        
	                        <% if(flag == true) { %>
	                        
	                        	<h3 style="color:red; margin-left:20px"> Enter Valid Name </h3>
	                        	
	                        <% } %>
	                        
	                        <% if(flag1 == true) { %>
	                        
	                        	<h3 style="color:red; margin-left:20px"> Enter Valid Phone Number </h3>
	                        	
	                        <% } %>

	                    </div>
	
	          </div>
	
	    </div>
	    
	</section>
</form>

</body>
</html>