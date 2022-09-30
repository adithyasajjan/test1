<%@ page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>
	<title>Sign In</title>
	
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
             height: 450px;
             display: inline-flex;
             border-radius: 15px;
             box-shadow: 0 10px 20px -10px rgba(0,0,0,0.8);
		
		}
		
		.main .left{
               width: 250px;
               height: 450px;
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
                height: 450px;
                background: white;
                border-radius: 0 15px 15px 0;
		}
		
		.main .right .form{
                margin: 30px;
		}
		
		.main .right .form input{
                margin: 10px;
                width: 200px;
                height: 30px;
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
	
	</style>
	

</head>

<body>
<form target="_blank" action="Login" method="Post">
	<section class="header">
	
	    <nav>
				<a href="index.html"><img src="" alt="bank logo"></a>
					<div class="nav-links">
						<ul>
							<li><a href="index.html">HOME</a></li>
						</ul>
					</div>
					
		</nav>
	
		
	    <div class="main">
	
	          <div class="left">
	
	                   <h1>Public<br><span>Bank</span></h1>
	
	          </div>
	
	          <div class="right">
	
	                    <div class="form">
	
	                            <h1>Welcome Back</h1><br>
	
	                            <h3>Sign into your account</h3>   
	                   	                                                       	
                            	<input type="text" name="uname" placeholder="Username" required><br>
                            	
                               	<input type="password" name="passwd" placeholder="Password" required><br>
                            	
                                                       	 
                       			<button >Sign In</button><br><br>
                       			
                       			<% boolean flag = Boolean.parseBoolean(request.getParameter("flag")); %>
                            	
                            	<% System.out.println(flag); %>
                            	<% if(flag == true) { %>
                            		
                            		<%-- <% String str = "Invalid credentials ! "; %> --%>
                            		<h3 style="color:red; margin-left:20px"> Invalid credentials !</h3>
                            		
                            	<% } %>
	                            	
	                   
                            	<p><a href="#">Forgot Password?</a></p>

                            	<p>Don't have an account? <a href="SignUp.html">Register here</a></p>
	
	                    </div>
	
	          </div>
	
	    </div>
	</section>
</form>
</body>

</html>